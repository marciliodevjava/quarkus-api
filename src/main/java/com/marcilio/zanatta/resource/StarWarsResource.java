package com.marcilio.zanatta.resource;

import com.marcilio.zanatta.client.StarWarsClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

    @RestClient
    StarWarsClient starWarsClient;

    @GET
    @Path("/starships")
    public String getStarShips() {
        return starWarsClient.getStarShips();
    }
}
