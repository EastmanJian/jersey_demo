package jersey.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.*;

/**
 * Root resource (exposed at "myresource" param)
 */
@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent to the client as "text/plain" media type.
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!" +
                NEW_LINE + NEW_LINE + "(This is a response answering a REST GET request in plain text.)" +
                NEW_LINE + ARCHE_DESC;
    }
}
