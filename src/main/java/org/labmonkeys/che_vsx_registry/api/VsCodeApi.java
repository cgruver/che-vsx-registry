package org.labmonkeys.che_vsx_registry.api;

import org.labmonkeys.che_vsx_registry.dto.query.ExtensionQueryDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@ApplicationScoped
@Path("/vscode")
public interface VsCodeApi {
    
    @Path("/vscode/gallery/extensionquery")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response extensionQuery(ExtensionQueryDto query, @Context UriInfo uriInfo);

    @Path("/vscode/asset/{publisher}/{extensionName}/{version}/{assetType}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getAsset(@PathParam("publisher") String publisher, @PathParam("extensionName") String extensionName, @PathParam("version") String version, @PathParam("assetType") String assetType, @QueryParam("targetPlatform") String targetPlatform, @Context UriInfo uriInfo);


}
