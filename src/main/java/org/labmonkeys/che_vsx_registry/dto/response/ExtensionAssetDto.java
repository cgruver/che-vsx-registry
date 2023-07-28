package org.labmonkeys.che_vsx_registry.dto.response;

public record ExtensionAssetDto(String assetType, String source) {
    public static final String FILE_ICON = "Microsoft.VisualStudio.Services.Icons.Default";
    public static final String FILE_DETAILS = "Microsoft.VisualStudio.Services.Content.Details";
    public static final String FILE_CHANGELOG = "Microsoft.VisualStudio.Services.Content.Changelog";
    public static final String FILE_MANIFEST = "Microsoft.VisualStudio.Code.Manifest";
    public static final String FILE_VSIX = "Microsoft.VisualStudio.Services.VSIXPackage";
    public static final String FILE_LICENSE = "Microsoft.VisualStudio.Services.Content.License";
    public static final String FILE_WEB_RESOURCES = "Microsoft.VisualStudio.Code.WebResources";
    public static final String FILE_VSIXMANIFEST = "Microsoft.VisualStudio.Services.VsixManifest";
    public static final String FILE_SIGNATURE = "Microsoft.VisualStudio.Services.VsixSignature";
    public static final String FILE_PUBLIC_KEY = "Microsoft.VisualStudio.Services.PublicKey";
}
