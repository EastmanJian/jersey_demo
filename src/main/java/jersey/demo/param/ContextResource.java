package jersey.demo.param;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import java.util.Set;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * Demo of REST JAX-RS, using @Context to obtain a general map of parameters.
 * Test it with curl command:
 *   curl 'https://eastmanjian.cn/jersey_demo/webapi/paramap/val1/val2?step=3&min-m=false'
 */
@Path("paramap/{para1}/{para2}")
public class ContextResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getParameterMap(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        StringBuilder result = new StringBuilder("");
        Set<String> queryKeys = queryParams.keySet();
        String value;
        for (String key: queryKeys) {
            value = queryParams.get(key).toString();
            result.append("queryParam " + key + "=" + value + "\n");
        }
        Set<String> pathKeys = pathParams.keySet();
        for (String key: pathKeys) {
            value = pathParams.get(key).toString();
            result.append("pathParam " + key + "=" + value + "\n");
        }

        return  "This is a demo of using @Context to obtain a general map of parameters." + NEW_LINE + NEW_LINE +
                "Params received from URL are:"+ NEW_LINE + result +
                NEW_LINE + ARCHE_DESC;
    }
}