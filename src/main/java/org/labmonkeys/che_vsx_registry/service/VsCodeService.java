package org.labmonkeys.che_vsx_registry.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.labmonkeys.che_vsx_registry.api.VsCodeApi;
import org.labmonkeys.che_vsx_registry.dto.query.ExtensionQueryDto;
import org.labmonkeys.che_vsx_registry.dto.query.FilterDto;
import org.labmonkeys.che_vsx_registry.dto.query.FilterTypeDto;
import org.labmonkeys.che_vsx_registry.dto.response.QueryResponseDto;
import org.labmonkeys.che_vsx_registry.model.Extension;
import org.labmonkeys.che_vsx_registry.model.ExtensionId;
import org.labmonkeys.che_vsx_registry.service.utilities.QueryFlags;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

public class VsCodeService implements VsCodeApi {

    @Override
    public Response extensionQuery(ExtensionQueryDto query, UriInfo uriInfo) {

        // The Base URI will be needed in the response data for the Asset URIs
        URI baseUri = uriInfo.getBaseUri();
        List<QueryResponseDto> results = new ArrayList<>();
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
            if (!extensionNameQueries.isEmpty()) {
                findByName(extensionNameQueries, flags);
            }
            if (!searchQueries.isEmpty()) {
                findByText(searchQueries, flags);
            }
            if (!extensionIdQueries.isEmpty()) {
                findById(extensionIdQueries, flags);
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

    private QueryResponseDto findByName(List<String> extensionNames, QueryFlags flags) {

        for (String extensionName : extensionNames.stream().distinct().collect(Collectors.toList())) {
            String[] tokens = extensionName.split(".");
            // Throw exception if tokens.length != 2
            String publisher = tokens[0];
            String name = tokens[1];
            ExtensionId id = new ExtensionId(publisher , name);
            Extension extension = Extension.findById(id);
        }
        return null;
    }

    private QueryResponseDto findByText(List<String> searchText, QueryFlags flags) {
        for(String text : searchText.stream().distinct().collect(Collectors.toList())) {

        }
        return null;
    }

    private QueryResponseDto findById(List<String> extensionIds, QueryFlags flags) {
        for (String extensionId : extensionIds.stream().distinct().collect(Collectors.toList())) {
                    
        }
        return null;
    }

    


    
}
