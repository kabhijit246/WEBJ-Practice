package assignment.WebService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/myresource")
public class MyResource 
{
	@GET  
	@Path("/{hello}")  
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("hello") String s) 
	{  
		String output = "Hello " + s;  
		return Response.status(200).entity(output).build();  
	}  
}
