package jersey.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.*;

@Path("/users/{username}")
public class UserResource {
    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        return "<content><message>Hello " + userName + ", Welcome to RESTful word.</message>" +
                "<desc>This is a response of a REST GET request in xml with URI path parameter /users/{username}. " +
                "Try to change the {username} parameter to see the effect.</desc>" +
                "<foot>" + ARCHE_DESC + "</foot></content>";
    }
}