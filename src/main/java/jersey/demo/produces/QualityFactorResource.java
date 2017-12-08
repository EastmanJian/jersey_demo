package jersey.demo.produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static jersey.demo.Constants.ARCHE_DESC;

/**
 * More than one media type may be declared in the same @Produces declaration.
 * Server can also specify the quality factor for individual media types. These are considered if several are equally
 * acceptable by the client.
 *
 * If client accepts both "application/xml" and "application/json" (equally), then a server always sends
 * "application/json", since "application/xml" has a lower quality factor.
 *
 * e.g. the following curl command will let doGetAsXmlOrJson() choose "application/json" to produce
 *     curl -i -H 'Accept: application/xml, application/json' 'https://eastmanjian.cn/jersey_demo/webapi/jsonOrXml'
 *
 */
@Path("/jsonOrXml")
public class QualityFactorResource {
    @GET
    @Produces({"application/xml; qs=0.9", "application/json"})
    public String doGetAsXmlOrJson() {
        return "{\"Message\":\"The representation sent back to client is in JSON format if the client request below, because annotation @Produces({\"application/xml; qs=0.9\", \"application/json\"}) is used. \"," +
                "\"Command\":\"curl -i -H 'Accept: application/xml, application/json' 'https://eastmanjian.cn/jersey_demo/webapi/jsonOrXml'\"" +
                "\"Desc\":\"" + ARCHE_DESC + "\"}";
    }

}
