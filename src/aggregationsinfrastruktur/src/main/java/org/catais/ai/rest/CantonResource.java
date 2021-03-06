package org.catais.ai.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

import org.catais.ai.dao.CantonDAO;
import org.catais.ai.dao.DAOException;
import org.catais.ai.dao.DAOFactory;
import org.catais.ai.model.Canton;

import javax.ws.rs.core.MediaType;


@Path("/cantons")
public class CantonResource {
	
	// Vars ---------------------------------------------------------------------------------------

	DAOFactory xanadu2 = DAOFactory.getInstance("xanadu2.jdbc");
	CantonDAO cantonDAO = xanadu2.getCantonDAO();
	
    // Actions ------------------------------------------------------------------------------------
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public List<Canton> listCantons() {	
		return cantonDAO.listCantons();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response activateCanton(Canton canton) {	
		try {
			cantonDAO.activateCanton(canton);
			return Response.status(201).build();
		} catch (DAOException e) {
			return Response.status(406).build();
		}
	} 
	
	// Returns 204 "No content" if canton == null
	@GET
	@Path("{ct}")
	@Consumes(MediaType.APPLICATION_XML)
	public Canton listCanton(@PathParam("ct") String cantonCode) {		
		return cantonDAO.listCanton(cantonCode.toUpperCase());
	}
	
	@PUT
	@Path("{ct}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCanton(@PathParam("ct") String cantonCode, Canton canton) {
		try {
			cantonDAO.activateCanton(canton);
			return Response.status(200).build();
		} catch (DAOException e) {
			return Response.status(500).build();
		}
	}
	
	@DELETE
	@Path("{ct}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteCanton(@PathParam("ct") String cantonCode, @QueryParam("recursive") boolean recursive) {
		cantonDAO.deleteCanton(cantonCode, recursive);
		return Response.status(200).build();
	}
	
}
