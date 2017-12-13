package jersey.demo.moxy.jaxb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Jersey will automatically discover the module and seamlessly enable JSON binding support via MOXy in your applications.
 * This is enabled by Jersey “Auto-Discoverable Features”
 *
 * With GlassFish server, MOXy module is already contained. But might need to update *moxy*.jar if any version issue.
 */
@Path("jaxbjson")
@Produces(MediaType.APPLICATION_JSON)
public class JaxbResource {
    @GET
    @Produces("application/json")
    public MyJaxbBean getMyBean() {
        return new MyJaxbBean("Agamemnon", 32);
    }

}
