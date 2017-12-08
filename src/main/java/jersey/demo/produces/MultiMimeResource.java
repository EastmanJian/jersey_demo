package jersey.demo.produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * More than one media type may be declared in the same @Produces declaration
 *
 * The doGetAsXmlOrJson method will get invoked if either of the media types "application/xml" and "application/json"
 * are acceptable. If both are equally acceptable then the former will be chosen because it occurs first.
 *
 * e.g. the following curl command will let doGetAsXmlOrJson() choose "application/xml" to produce
 *     curl -H "Accept: application/json, application/xml" "https://eastmanjian.cn/jersey_demo/webapi/xmlOrJson"
 *
 */
@Path("/xmlOrJson")
public class MultiMimeResource {
    @GET
    @Produces({"application/xml", "application/json"}) //Or use the constants in MediaType class to avoid typographical errors
    public String doGetAsXmlOrJson() {
        return "<return><msg>The representation sent back to client is in xml if client accepts following MIME types because annotation @Produces({\"application/xml\", \"application/json\"}) is used</msg>" +
                "<command>curl -H 'Accept: application/json, application/xml' 'https://eastmanjian.cn/jersey_demo/webapi/xmlOrJson'</command>" +
                "<desc>" + ARCHE_DESC + "</desc></return>";
    }

}
