package com.marcilio.zanatta.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;

@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UniPDSResource {
    private int i = 0;

    @GET
    public int getI(){
        return this.i;
    }

    @GET
    @Path("diferentao")
    public int getDiferentao(){
        return LocalDateTime.now().getNano();
    }

    @POST
    public void addI(){
        this.i++;
    }

    @DELETE
    public void removeI(){
        this.i--;
    }

    @PUT
    @Path("/{i}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void setI(@PathParam("i")int i) {
        this.i = i;
    }
}
