package br.com.pedrosa.resource;

import br.com.pedrosa.domain.Client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.Response.created;

@Path("/clients")
public class ClientResource {

    @Context
    UriInfo uriInfo;

    @GET
    public List<Client> list() {
        return Client.listAll();
    }

    @POST
    public Response add(Client client){
        var location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", client.id)
                .build();
        return created(location).entity(client).build();
    }
}