package org.labmonkeys.che_vsx_registry.dto.response;

import java.util.List;

public record ExtensionDto(String extensionId,
                            String extensionName,
                            String displayName,
                            String shortDescription,
                            ExtensionPublisherDto publisher,
                            List<ExtensionVersionDto> versions,
                            List<ExtensionStatisticDto> statistics,
                            String[] tags,
                            String releaseDate,
                            String publishedDate,
                            String lastUpdated,
                            List<String> categories,
                            String flags) {}
