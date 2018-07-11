package com.simple.restapi.simple_crud_application;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.simple.restapi.simple_crud_application.model.ProfileInformation;
import com.simple.restapi.simple_crud_application.service.SimpleCRUDService;

/**
 * SimpleCRUDResource class used to handle all the request from client.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
@Path("/crudapp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SimpleCRUDResource {

	/**
	 * simpleCRUDService objec to access service methods
	 */
	SimpleCRUDService simpleCRUDService = new SimpleCRUDService();

	/**
	 * getAllProfiles method used to retrieve all the personal profile information.
	 * 
	 * @return response, which is contains status and result entity
	 */
	@GET
	public List<ProfileInformation> getAllProfiles() {
		return simpleCRUDService.getAllProfiles();
	}

	/**
	 * getProfile method used to retrieve a profile information based upon the
	 * userId
	 * 
	 * @param userId,
	 *            unique id of the user
	 * @return response, which is contains status and result entity
	 */
	@GET
	@Path("/{profileId}")
	public Response getProfile(@PathParam("profileId") String userId) {
		return Response.status(Status.OK).entity(simpleCRUDService.getProfile(userId)).build();
	}

	/**
	 * createProfile method used to request to create a new resource.
	 * 
	 * @param profileInformation,
	 *            which is contains details to create a profile.
	 * @return {@link Response} which is contains status
	 */
	@POST
	public Response createProfile(ProfileInformation profileInformation) {
		simpleCRUDService.createProfile(profileInformation);
		return Response.status(Status.CREATED).build();
	}

	/**
	 * deleteProfile method used to delete a profile.
	 * 
	 * @param userId,
	 *            unique id of the user to delete a profile.
	 * @return {@link Response} which is contains status
	 */
	@DELETE
	@Path("/{profileId}")
	public Response deleteProfile(@PathParam("profileId") String userId) {
		simpleCRUDService.deleteProfile(userId);
		return Response.status(Status.OK).build();
	}

	/**
	 * updateProfile method used to update a user profile.
	 * 
	 * @param userId,
	 *            unique id of the user.
	 * @param information
	 *            , which is contains updated information to update a profile.
	 * @return {@link Response} which is contains status.
	 */
	@PUT
	@Path("/{profileId}")
	public Response updateProfile(@PathParam("profileId") String userId, ProfileInformation information) {
		information.setUserId(userId);
		return Response.status(Status.OK).entity(simpleCRUDService.updateProfile(information)).build();
	}

}
