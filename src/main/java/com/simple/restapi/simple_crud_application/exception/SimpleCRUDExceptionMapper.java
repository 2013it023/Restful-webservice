package com.simple.restapi.simple_crud_application.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.simple.restapi.simple_crud_application.model.ExceptionMessage;

/**
 * SimpleCRUDExceptionMapper class used to send a exception as a response to
 * client side.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
@Provider
public class SimpleCRUDExceptionMapper implements ExceptionMapper<SimpleCRDUDException> {

	@Override
	public Response toResponse(SimpleCRDUDException exception) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(exception.getMessage(), Status.BAD_GATEWAY);
		return Response.status(Status.BAD_GATEWAY).entity(exceptionMessage).build();
	}

}
