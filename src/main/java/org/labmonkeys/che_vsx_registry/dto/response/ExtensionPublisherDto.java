package org.labmonkeys.che_vsx_registry.dto.response;

public record ExtensionPublisherDto(String displayName, String publisherId, String publisherName, String domain, Boolean isDomainVerified) {}

// domain is always null, may be able to drop it