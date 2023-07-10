package org.labmonkeys.che_vsx_registry.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipFile;

import org.jboss.logging.Logger;
import org.labmonkeys.che_vsx_registry.api.VsxAdminApi;
import org.labmonkeys.che_vsx_registry.dto.response.ExtensionAssetDto;
import org.labmonkeys.che_vsx_registry.model.Extension;
import org.labmonkeys.che_vsx_registry.model.ExtensionAsset;
import org.labmonkeys.che_vsx_registry.model.ExtensionId;
import org.labmonkeys.che_vsx_registry.model.ExtensionProperty;
import org.labmonkeys.che_vsx_registry.model.ExtensionVersion;
import org.labmonkeys.che_vsx_registry.model.ExtensionVersionId;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.quarkus.logging.Log;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

public class VsxAdminService implements VsxAdminApi {

    private static final int MAX_FILE_SIZE=536870912;
    private static final String VSIX_MANIFEST="extension.vsixmanifest";
    final Logger LOG = Logger.getLogger(VsxAdminService.class);

    @Override
    @Transactional 
    public Response uploadVsix(InputStream vsixUpload) {

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        try {    
            BufferedInputStream vsixFile = new BufferedInputStream(vsixUpload);
            vsixFile.mark(0);
            if (vsixFile.skip(MAX_FILE_SIZE + 1) > MAX_FILE_SIZE) {
                throw new Exception("Extension file exceeds size limit of: " + MAX_FILE_SIZE + " Bytes.");
            }
            vsixFile.reset();
            Path extensionFile = Files.createTempFile("extension_tmp_", ".vsix");
            vsixFile.transferTo(Files.newOutputStream(extensionFile));
            ZipFile uncompressedExtensionFile = new ZipFile(extensionFile.toFile());
            
            JsonNode vsixManifest = xmlMapper.readTree(getFile(uncompressedExtensionFile, VSIX_MANIFEST));

            

            String manifestPath = this.findValue("Type", ExtensionAssetDto.FILE_MANIFEST, "Path", vsixManifest.path("Assets").path("Asset"));

            JsonNode manifest = jsonMapper.readTree(getFile(uncompressedExtensionFile, manifestPath));

            ExtensionId extensionId = new ExtensionId(manifest.get("publisher").asText(), manifest.get("name").asText());
            Extension extension = Extension.findById(extensionId);
            if (extension == null) {
                extension = new Extension();
                extension.setId(extensionId);
                extension.setUuid(UUID.randomUUID().toString());
                extension.setDisplayName(manifest.get("displayName").asText());
                extension.setShortDescription(manifest.get("description").asText());
                extension.persist();
            }
            ExtensionVersionId versionId = new ExtensionVersionId(manifest.get("publisher").asText(), manifest.get("name").asText(), manifest.get("version").asText());
            ExtensionVersion version = ExtensionVersion.findById(versionId);
            if (version != null) {
                version.delete();
            }
            version = new ExtensionVersion();
            version.setId(versionId);
            List<ExtensionAsset> assets = new ArrayList<ExtensionAsset>();
            ExtensionAsset vsixPackage = new ExtensionAsset();
            vsixPackage.setAssetType(ExtensionAssetDto.FILE_VSIX);
            vsixPackage.setExtensionAsset(vsixUpload.readAllBytes());
            vsixPackage.setExtensionVersion(version);
            assets.add(vsixPackage);
            for (JsonNode assetNode : vsixManifest.path("Assets").path("Asset")) {
                LOG.info(assetNode);
                ExtensionAsset asset = new ExtensionAsset();
                asset.setExtensionVersion(version);
                asset.setAssetType(assetNode.get("Type").asText());
                asset.setExtensionAsset(this.getFile(uncompressedExtensionFile, assetNode.get("Path").asText()));
                assets.add(asset);
            }
            version.setAssets(assets);
            List<ExtensionProperty> properties = new ArrayList<ExtensionProperty>();
            for (JsonNode propertyNode : vsixManifest.path("Metadata").path("Properties").path("Property")) {
                ExtensionProperty property = new ExtensionProperty();
                property.setPropertyId(propertyNode.get("Id").asText());
                property.setPropertyValue(propertyNode.get("Value").asText());
                property.setExtensionVersion(version);
                properties.add(property);
            }
            version.setProperties(properties);
            version.setExtension(extension);
            version.setVersion(manifest.get("version").asText());
            version.persist();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return Response.ok().build();
    }

    private String findValue(String matchKey, String matchValue, String valueKey, Iterable<JsonNode> node) {

        for (JsonNode jsonNode : node) {
            Log.info(jsonNode);
            JsonNode test = jsonNode.get(matchKey);
            Log.info(test);
            if (test != null && test.asText().equals(matchValue)) {
                return jsonNode.get(valueKey).asText();
            }
        }
        return null;
    }

    private byte[] getFile(ZipFile file, String path) throws IOException {
        if (path != null) {
            return file.getInputStream(file.getEntry(path)).readAllBytes();
        }
        return null;
    }

    @Override
    @Transactional
    public Response deleteExtensionVersion(String publisher, String extensionName, String version) {
        
        ExtensionVersionId id = new ExtensionVersionId(publisher, extensionName, version);
        ExtensionVersion.findById(id).delete();
        return Response.ok().build();
    }

    @Override
    @Transactional
    public Response deleteExtension(String publisher, String extensionName) {
        
        ExtensionId id = new ExtensionId(publisher, extensionName);
        Extension.findById(id).delete();
        return Response.ok().build();
    }
    
}
