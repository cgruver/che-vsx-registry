package org.labmonkeys.che_vsx_registry.dto.response;

import java.util.List;

public record ExtensionVersionDto(String version,
                                    String lastUpdated,
                                    String assetUri,
                                    String fallbackAssetUri,
                                    List<ExtensionAssetDto> files,
                                    List<ExtensionPropertyDto> properties,
                                    String targetPlatform) {}
