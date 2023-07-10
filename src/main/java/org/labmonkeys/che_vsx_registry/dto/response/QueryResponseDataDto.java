package org.labmonkeys.che_vsx_registry.dto.response;

import java.util.List;

public record QueryResponseDataDto(String type, List<QueryResponseDataItemDto> item) {}
