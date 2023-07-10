package org.labmonkeys.che_vsx_registry.dto.response;

import java.util.List;

// Reference: https://github.com/microsoft/vscode/blob/main/src/vs/platform/extensionManagement/common/extensionGalleryService.ts

public record QueryResponseDto(List<ExtensionDto> extensions, List<QueryResponseDataDto> responseData) {}
