package jersey.demo.param;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.Map;
import java.util.Set;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * Demo of REST JAX-RS, using @Context to obtain a general map of HTTP headers and cookies.
 * Test it with curl command:
 *   curl -i -H 'Accept: text/plain' -H 'header: anything' 'https://eastmanjian.cn/jersey_demo/webapi/headermap'
 */
@Path("headermap")
public class HeaderResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getParameterMap(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> cookieMap = hh.getCookies();

        StringBuilder result = new StringBuilder("");
        Set<String> headerKeys = headerParams.keySet();
        String value;
        Cookie cookie;
        for (String key: headerKeys) {
            value = headerParams.get(key).toString();
            result.append("headerParam " + key + "=" + value + "\n");
        }
        Set<String> cookieKeys = cookieMap.keySet();
        for (String key: cookieKeys) {
            cookie = cookieMap.get(key);
            result.append("Cookie " + key + "=" + cookie + "\n");
        }

        return  "This is a demo of using @Context to obtain a general map of parameters." + NEW_LINE + NEW_LINE +
                "Header and cookie received from URL are:"+ NEW_LINE + result +
                NEW_LINE + ARCHE_DESC;
    }
}