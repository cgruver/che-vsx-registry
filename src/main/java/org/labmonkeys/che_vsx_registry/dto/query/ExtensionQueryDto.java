package org.labmonkeys.che_vsx_registry.dto.query;

import java.util.List;

public record ExtensionQueryDto(List<FilterDto> filters, int flags) {}
