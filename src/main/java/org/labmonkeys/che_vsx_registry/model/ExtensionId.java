package org.labmonkeys.che_vsx_registry.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record ExtensionId(String publisher, String extensionName) {}
