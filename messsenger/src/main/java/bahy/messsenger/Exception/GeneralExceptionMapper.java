package bahy.messsenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import bahy.messsenger.model.ErrorMessage;
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage em =new ErrorMessage(arg0.getMessage(), 505, "internal error with the fucking server");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(em).build();
	}

}
