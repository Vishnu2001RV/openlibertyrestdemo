package com.example.libertyresteg.rest;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@Path("events")
public class RestResource {

    /**
     * This method creates a new event from the submitted data (name, time and
     * location) by the user.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public JsonObject addNewEvent(@FormParam("name") String name,
                                @FormParam("time") String time, @FormParam("location") String location) {

        JsonObjectBuilder builder = Json.createObjectBuilder();


        builder.add("name", name).add("time", time)
                .add("location",location);
        return builder.build();
    }

    /**
     * This method updates a new event from the submitted data (name, time and
     * location) by the user.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Transactional
    public Response updateEvent(@FormParam("name") String name,
                                @FormParam("time") String time, @FormParam("location") String location,
                                @PathParam("id") int id) {

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    /**
     * This method deletes a specific existing/stored event
     */
    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteEvent(@PathParam("id") int id) {

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    /**
     * This method returns a specific existing/stored event in Json format
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public JsonObject getEvent(@PathParam("id") int eventId) {
        JsonObjectBuilder builder = Json.createObjectBuilder();


            builder.add("name", "Vis").add("time", "15/03/2023")
                    .add("id",eventId);

        return builder.build();
    }


}