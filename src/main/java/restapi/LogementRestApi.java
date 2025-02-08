package restapi;

import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/logement")
public class LogementRestApi {
    static LogementBusiness logementBusiness = new LogementBusiness();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAll(){
       return Response
               .ok()
               .entity(logementBusiness.getLogements())
               .build();
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public Response addLogement(Logement logement){
        logementBusiness.addLogement(logement);
        return  Response
                .status(201)
                .entity("Logement a été ajouté avec success")
                .build();
    }
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/{reference}")
    public Response updateLogement(@PathParam("reference") int reference, Logement logement) {
        return Response.ok().entity("Logement mis à jour avec succès").build();

    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete/{reference}")
    public Response deleteLogement(@PathParam("reference") int reference) {
       return Response.ok().entity("Logement supprimé avec succès").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{reference}")
    public Response getLogementsByReference(@PathParam("reference") int reference) {
        Logement logement = logementBusiness.getLogementsByReference(reference);
            return Response.ok().entity(logement).build();

    }
}
