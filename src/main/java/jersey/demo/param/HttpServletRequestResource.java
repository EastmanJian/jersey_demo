package jersey.demo.param;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * Demo of REST JAX-RS, using @Context to obtain info in HttpServletRequest and SecurityContext.
 * Test it with curl command:
 *   curl -i -H 'Accept: text/plain' -H 'header: anything' 'https://eastmanjian.cn/jersey_demo/webapi/httpServletReq'
 */
@Path("httpServletReq")
public class HttpServletRequestResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getParameterMap(@Context HttpServletRequest requestContext, @Context SecurityContext context) {
        StringBuilder result = new StringBuilder("");

        Enumeration<String> headerNames = requestContext.getHeaderNames();
        String name, value;
        while (headerNames.hasMoreElements()) {
            name = headerNames.nextElement();
            value = requestContext.getHeader(name);
            result.append("HttpServletRequest header: " + name + "=" + value + "\n");
        }

        result.append("HttpServletRequest.getRemoteAddr() =" + requestContext.getRemoteAddr() + "\n");
        result.append("HttpServletRequest.getRemoteHost() =" + requestContext.getRemoteHost() + "\n");
        result.append("HttpServletRequest.getRemotePort() =" + requestContext.getRemotePort() + "\n");
        result.append("HttpServletRequest.getMethod() =" + requestContext.getMethod() + "\n");
        result.append("HttpServletRequest.getAuthType() =" + requestContext.getAuthType() + "\n");
        result.append("HttpServletRequest.getContextPath() =" + requestContext.getContextPath() + "\n");
        result.append("HttpServletRequest.getPathTranslated() =" + requestContext.getPathTranslated() + "\n");
        result.append("HttpServletRequest.getRequestedSessionId() =" + requestContext.getRequestedSessionId() + "\n");
        result.append("HttpServletRequest.getRequestURI() =" + requestContext.getRequestURI() + "\n");
        result.append("HttpServletRequest.getServletPath() =" + requestContext.getServletPath() + "\n");
        result.append("HttpServletRequest.getCharacterEncoding() =" + requestContext.getCharacterEncoding() + "\n");
        result.append("HttpServletRequest.getContentType() =" + requestContext.getContentType() + "\n");
        result.append("HttpServletRequest.getLocalAddr() =" + requestContext.getLocalAddr() + "\n");
        result.append("HttpServletRequest.getLocalName() =" + requestContext.getLocalName() + "\n");
        result.append("HttpServletRequest.getProtocol() =" + requestContext.getProtocol() + "\n");
        result.append("HttpServletRequest.getScheme() =" + requestContext.getScheme() + "\n");
        result.append("HttpServletRequest.getServerName() =" + requestContext.getServerName() + "\n");
        result.append("HttpServletRequest.getPathInfo() =" + requestContext.getPathInfo() + "\n");

        result.append("SecurityContext.isSecure() =" + context.isSecure() + "\n");
        result.append("SecurityContext.getAuthenticationScheme() =" + context.getAuthenticationScheme() + "\n");
        result.append("SecurityContext.getUserPrincipal() =" + context.getUserPrincipal() + "\n");

        return  "This is a demo of using @Context to obtain info in HttpServletRequest and SecurityContext." + NEW_LINE + NEW_LINE +
                "HttpServletRequest and SecurityContext received from URL are:"+ NEW_LINE + result +
                NEW_LINE + ARCHE_DESC;
    }
}