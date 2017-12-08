package jersey.demo.param;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static jersey.demo.Constants.ARCHE_DESC;

@Path("/user/{username: [A-Z][a-zA-Z_0-9]*}")
public class UserRegExpResource {
    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        return "<content><message>Hello " + userName + ", Welcome to RESTful word.</message>" +
                "<desc>This is a response of a REST GET request in xml with URI param parameter " +
                "/users/{username : [A-Z][a-zA-Z_0-9]*}}. " +
                "The {username} should begins with capital letter. Otherwise 404 error. " +
                "Try to change the {username} parameter to see the effect.</desc>" +
                "<foot>" + ARCHE_DESC + "</foot></content>";
    }
}