package jersey.demo.param;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * Demo of REST JAX-RS, @QueryParam and @DefaultValue with user defined parameter type.
 * Test it with curl command:
 *   curl 'https://eastmanjian.cn/jersey_demo/webapi/usrdefpara?step=3&min-m=false&min-color=red'
 */
@Path("usrdefpara")
public class UserDefParamResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUrlParams(
            @QueryParam("step")      @DefaultValue("2")    int step,
            @QueryParam("min-m")     @DefaultValue("true") boolean hasMin,
            @QueryParam("min-color") @DefaultValue("blue") ColorParam minColor) {
        return  "This is a demo of @QueryParam and @DefaultValue with user-defined parameter type." + NEW_LINE + NEW_LINE +
                "Params received from URL are:"+ NEW_LINE +
                "step (int type, default 2) = " + step + NEW_LINE +
                "min-m (boolean type default true) = " + hasMin + NEW_LINE +
                "minColor (ColorParam user-defined type, default blue) = " + minColor + NEW_LINE +
                "Try to change the URL parameters to see the result" + NEW_LINE +
                NEW_LINE + ARCHE_DESC;
    }
}