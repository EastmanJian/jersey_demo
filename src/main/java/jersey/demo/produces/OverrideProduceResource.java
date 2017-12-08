package jersey.demo.produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * The @Produces annotation is used to specify the MIME media types of representations a resource can produces and send
 * back to the client. It can be applied at both the class and method levels. Method level overrides class level.
 *
 * If a resource class is capable of producing more that one MIME media type then the resource method chosen will
 * correspond to the most acceptable media type as declared by the client.
 *
 * e.g. the following curl command will invoke doGetAsHtml()
 *     curl -H "Accept: text/html" "https://eastmanjian.cn/jersey_demo/webapi/textOrHtml"
 *
 * e.g. the following curl command will invoke doGetAsPlainText()
 *     curl -H "Accept: text/html;q=0.9, text/plain" "https://eastmanjian.cn/jersey_demo/webapi/textOrHtml"
 *
 */
@Path("/textOrHtml")
@Produces("text/plain")
public class OverrideProduceResource {
    @GET
    public String doGetAsPlainText() {
        return "The representation sent back to client is in plain text" + NEW_LINE +
                ARCHE_DESC;
    }

    @GET
    @Produces("text/html")  //this overrides the class level @Produces("text/plain")
    public String doGetAsHtml() {
        return "<h3>The representation sent back to client is in html</h3><br>" +
                "<p>" + ARCHE_DESC + "</p>";
    }
}
