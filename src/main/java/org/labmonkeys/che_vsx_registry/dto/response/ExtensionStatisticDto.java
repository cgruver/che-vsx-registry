package org.labmonkeys.che_vsx_registry.dto.response;

public record ExtensionStatisticDto(String statisticName, double value) {
    public static final String STAT_INSTALL = "install";
    public static final String STAT_AVERAGE_RATING = "averagerating";
    public static final String STAT_RATING_COUNT = "ratingcount";
}
