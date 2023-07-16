package org.labmonkeys.che_vsx_registry.service.utilities;

public record QueryFlags(boolean includeVersion,
                        boolean includeFiles,
                        boolean includeCatergoryAndTags,
                        boolean includeSharedAccounts,
                        boolean includeVersionProperties,
                        boolean exludeNonValidated,
                        boolean includeTargets,
                        boolean includeAssetUri,
                        boolean includeStats,
                        boolean latestOnly,
                        boolean unpublished) {
    
    public static final class Flag {
		public static final int INCLUDE_VERSIONS = 0x1;
		public static final int INCLUDE_FILES = 0x2;
		public static final int INCLUDE_CATEGORY_AND_TAGS = 0x4;
		public static final int INCLUDE_SHARED_ACCOUNTS = 0x8;
		public static final int INCLUDE_VERSION_PROPERTIES = 0x10;
		public static final int EXCLUDE_NON_VALIDATED = 0x20;
		public static final int INCLUDE_INSTALLATION_TARGETS = 0x40;
		public static final int INCLUDE_ASSET_URI = 0x80;
		public static final int INCLUDE_STATISTICS = 0x100;
		public static final int INCLUDE_LATEST_VERSION_ONLY = 0x200;
		public static final int UNPUBLISHED = 0x1000;
	}

    public QueryFlags(int flags) {
        this((flags & Flag.INCLUDE_VERSIONS) != 0,
            (flags & Flag.INCLUDE_FILES) != 0,
            (flags & Flag.INCLUDE_CATEGORY_AND_TAGS) != 0,
            (flags & Flag.INCLUDE_SHARED_ACCOUNTS) != 0,
            (flags & Flag.INCLUDE_VERSION_PROPERTIES) != 0,
            (flags & Flag.EXCLUDE_NON_VALIDATED) != 0,
            (flags & Flag.INCLUDE_INSTALLATION_TARGETS) != 0,
            (flags & Flag.INCLUDE_ASSET_URI) != 0,
            (flags & Flag.INCLUDE_STATISTICS) != 0, 
            (flags & Flag.INCLUDE_LATEST_VERSION_ONLY) != 0,
            (flags & Flag.UNPUBLISHED) != 0);
    }
}
