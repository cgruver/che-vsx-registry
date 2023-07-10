package org.labmonkeys.che_vsx_registry.dto.response;

public record ExtensionPropertyDto(String key, String value) {
    public static final String REPOSITORY = "Microsoft.VisualStudio.Services.Links.Source";
    public static final String SPONSOR_LINK = "Microsoft.VisualStudio.Code.SponsorLink";
    public static final String DEPENDENCIES = "Microsoft.VisualStudio.Code.ExtensionDependencies";
    public static final String EXTENSION_PACK = "Microsoft.VisualStudio.Code.ExtensionPack";
    public static final String ENGINE = "Microsoft.VisualStudio.Code.Engine";
    public static final String LOCALIZED_LANGUAGES = "Microsoft.VisualStudio.Code.LocalizedLanguages";
    public static final String BRANDING_COLOR = "Microsoft.VisualStudio.Services.Branding.Color";
    public static final String BRANDING_THEME = "Microsoft.VisualStudio.Services.Branding.Theme";
    public static final String WEB_EXTENSION = "Microsoft.VisualStudio.Code.WebExtension";
    public static final String PRE_RELEASE = "Microsoft.VisualStudio.Code.PreRelease";
}
