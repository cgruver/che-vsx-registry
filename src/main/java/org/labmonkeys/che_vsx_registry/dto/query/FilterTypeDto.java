package org.labmonkeys.che_vsx_registry.dto.query;

public record FilterTypeDto(int key, String value) {
    public static final int FILTER_TAG = 1;
    public static final int FILTER_EXTENSION_ID = 4;
    public static final int FILTER_CATEGORY = 5;
    public static final int FILTER_EXTENSION_NAME = 7;
    public static final int FILTER_TARGET = 8;
    public static final int FILTER_FEATURED = 9;
    public static final int FILTER_SEARCH_TEXT = 10;
    public static final int FILTER_EXCLUDE_WITH_FLAGS = 12;
}
