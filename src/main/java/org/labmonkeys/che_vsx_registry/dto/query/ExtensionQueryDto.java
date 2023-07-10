package org.labmonkeys.che_vsx_registry.dto.query;

import java.util.List;

public record ExtensionQueryDto(List<FilterDto> filters, int flags) {

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
}
