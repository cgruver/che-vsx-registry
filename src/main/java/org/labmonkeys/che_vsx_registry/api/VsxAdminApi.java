package org.labmonkeys.che_vsx_registry.api;

import java.io.InputStream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/admin")
public interface VsxAdminApi {

    @Path("/upload")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadVsix(InputStream vsixFile);

    @Path("/delete/{publisher}/{extensionName}/{version}")
    public Response deleteExtensionVersion(@PathParam("publisher") String publisher, @PathParam("extensionName") String extensionName, @PathParam("version") String version);
    
    @Path("/delete/{publisher}/{extensionName}")
    public Response deleteExtension(@PathParam("publisher") String publisher, @PathParam("extensionName") String extensionName);
}
