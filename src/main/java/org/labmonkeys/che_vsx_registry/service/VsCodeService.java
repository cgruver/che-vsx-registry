package org.labmonkeys.che_vsx_registry.service;

import org.labmonkeys.che_vsx_registry.api.VsCodeApi;
import org.labmonkeys.che_vsx_registry.dto.query.ExtensionQueryDto;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

public class VsCodeService implements VsCodeApi {

    @Override
    public Response extensionQuery(ExtensionQueryDto query, UriInfo uriInfo) {

        uriInfo.getBaseUri();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extensionQuery'");
    }

    @Override
    public Response getAsset(String publisher, String extensionName, String version, String assetType,
            String targetPlatform, UriInfo uriInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlob'");
    }
    
}
