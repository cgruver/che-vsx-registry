package org.labmonkeys.che_vsx_registry.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.labmonkeys.che_vsx_registry.api.VsCodeApi;
import org.labmonkeys.che_vsx_registry.dto.query.ExtensionQueryDto;
import org.labmonkeys.che_vsx_registry.dto.query.FilterDto;
import org.labmonkeys.che_vsx_registry.dto.query.FilterTypeDto;
import org.labmonkeys.che_vsx_registry.service.utilities.QueryFlags;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

public class VsCodeService implements VsCodeApi {

    @Override
    public Response extensionQuery(ExtensionQueryDto query, UriInfo uriInfo) {

        URI baseUri = uriInfo.getBaseUri();
        QueryFlags flags = new QueryFlags(query.flags());
        for (FilterDto queryFilter : query.filters()) {
            List<String> extensionNameQueries = new ArrayList<String>();
            List<String> extensionIdQueries = new ArrayList<String>();
            List<String> searchQueries = new ArrayList<String>();
            for (FilterTypeDto filterType : queryFilter.criteria()) {
                switch (filterType.filterType()) {
                    case FilterTypeDto.FilterType.EXTENSION_NAME:
                        extensionNameQueries.add(filterType.value());
                        break;
                    case FilterTypeDto.FilterType.SEARCH_TEXT:
                        searchQueries.add(filterType.value());
                        break;
                    case FilterTypeDto.FilterType.EXTENSION_ID:
                        extensionIdQueries.add(filterType.value());
                        break;
                    default:
                        break;
                }
            }

        }
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
