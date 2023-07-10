package org.labmonkeys.che_vsx_registry.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record ExtensionVersionId(String publisher, String extensionName, String targetPlatform) {}
