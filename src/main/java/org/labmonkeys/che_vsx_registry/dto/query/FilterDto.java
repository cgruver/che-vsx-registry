package org.labmonkeys.che_vsx_registry.dto.query;

import java.util.List;

public record FilterDto(List<FilterTypeDto> criteria, int pageNumber, int pageSize, int sortBy, int sortOrder) {}

