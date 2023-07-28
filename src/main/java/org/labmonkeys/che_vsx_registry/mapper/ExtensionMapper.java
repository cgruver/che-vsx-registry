package org.labmonkeys.che_vsx_registry.mapper;

import java.util.ArrayList;
import java.util.List;

import org.labmonkeys.che_vsx_registry.dto.response.ExtensionDto;
import org.labmonkeys.che_vsx_registry.dto.response.ExtensionPublisherDto;
import org.labmonkeys.che_vsx_registry.dto.response.ExtensionStatisticDto;
import org.labmonkeys.che_vsx_registry.model.Extension;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ExtensionMapper {
    
    
    // @Mapping(source = "id.extensionName", target = "extensionName")
    // @Mapping(source = "extensionUuid", target = "extensionId")
    // @Mapping(source = "displayName", target = "displayName")
    // @Mapping(source = "publishedDate", target = "publishedDate")
    // @Mapping(source = "publishedDate", target = "releaseDate")
    // @Mapping(source = "publishedDate", target = "lastUpdated")
    // ExtensionDto ExtensionToDto(Extension entity);

    default ExtensionDto ExtensionToDto(Extension entity) {

        List<String> tags = new ArrayList<String>();
        for (String tag : entity.getTags().split(",")) {
            tags.add(tag);
        }

        List<String> categories = new ArrayList<String>();
        for (String category : entity.getCategories().split(",")) {
            categories.add(category);
        }

        ExtensionPublisherDto publisher = new ExtensionPublisherDto(entity.getId().publisher(), entity.getPublisherUuid(), entity.getId().publisher(), null, Boolean.TRUE);

        return new ExtensionDto(entity.getExtensionUuid(), entity.getId().extensionName(), entity.getDisplayName(), entity.getShortDescription(), publisher, null, null, tags, entity.getPublishedDate().toString(), entity.getPublishedDate().toString(), entity.getPublishedDate().toString(), categories, "null");
        
    }

    default List<ExtensionStatisticDto> ExtensionNullStatistics() {
        return new ArrayList<ExtensionStatisticDto>();
    }

}
