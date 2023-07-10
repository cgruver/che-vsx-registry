package org.labmonkeys.che_vsx_registry.dto.query;

public record FilterTypeDto(int filterType, String value) {

    public static final class FilterType {
        public static final int TAG = 1;
        public static final int EXTENSION_ID = 4;
        public static final int CATEGORY = 5;
        public static final int EXTENSION_NAME = 7;
        public static final int TARGET = 8;
        public static final int FEATURED = 9;
        public static final int SEARCH_TEXT = 10;
        public static final int EXCLUDE_WITH_FLAGS = 12;
    }

}
