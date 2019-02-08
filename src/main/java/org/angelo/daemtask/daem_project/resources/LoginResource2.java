package org.angelo.daemtask.daem_project.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value="secured")
public class LoginResource2 {

	@GET
	@Path("main")
	public String securedMethod() {
			return "ACCESS GRANTED - AUTHORIZED USER";
	}
}