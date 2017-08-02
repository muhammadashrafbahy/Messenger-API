package bahy.messsenger.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path (value="/annotationparam")
@Consumes (MediaType.TEXT_PLAIN)
@Produces (MediaType.TEXT_PLAIN)
public class Extra_annotation_param {

	@GET
	@Path ("/test")
	public String annotation_param(@MatrixParam ("matrixparam") String matrixparam ,
			@HeaderParam ("headerparam") String headerparam, @CookieParam ("cookieparam") String cookieparam )
	{
		
		return "matrixparam = " + matrixparam +"*****" +"headerparam = " + headerparam +"************";
		
	}
	
	@GET
	@Path ("/context")
	public String annotation_param(@Context UriInfo uriinfo , @Context HttpHeaders httpheaders ) {
		
		String path = uriinfo.getAbsolutePath().toString();
		String headers= httpheaders.getHeaderString("headerparam");
		  
		return path + "*****"+headers;
	}
		
	
	
}
