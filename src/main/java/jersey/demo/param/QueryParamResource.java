package jersey.demo.param;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.*;

/**
 * Demo of REST JAX-RS, @QueryParam and @DefaultValue.
 * Test it with curl command:
 *   curl 'https://eastmanjian.cn/jersey_demo/webapi/querypara?step=3&min-m=false'
 */
@Path("querypara")
public class QueryParamResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUrlParams(
            @QueryParam("step")  @DefaultValue("2")    int step,
            @QueryParam("min-m") @DefaultValue("true") boolean hasMin,
            @QueryParam("max-m") @DefaultValue("true") boolean hasMax) {
        return  "This is a demo of @QueryParam and @DefaultValue." + NEW_LINE + NEW_LINE +
                "Params received from URL are:"+ NEW_LINE +
                "step (default 2) = " + step + NEW_LINE +
                "min-m (default true) = " + hasMin + NEW_LINE +
                "max-m (default true) = " + hasMax + NEW_LINE +
                "Try to change the URL parameters to see the result" + NEW_LINE +
                NEW_LINE + ARCHE_DESC;
    }
}