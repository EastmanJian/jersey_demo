package jersey.demo.methods;

import jersey.demo.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static jersey.demo.Constants.*;


/**
 * Example for RESTful PUT, POST, DELETE, @Consumes, sub-resource
 * Put a message to a cache, get back from a cache, also remove it from the cache.
 *
 * Test this example with the following curl commands
 *   curl -vi -X PUT -H "Accept: text/plain" -H "Content-Type: text/plain" -d 'some messages' "https://eastmanjian.cn/jersey_demo/webapi/cache/message
 *   curl -vi -X PUT -H "Accept: text/plain" -H "Content-Type: text/plain" -d 'some messages' "https://eastmanjian.cn/jersey_demo/webapi/cache/msgrsp"
 *   curl -vi -X POST -H "Accept: text/plain" -H "Content-Type: text/plain" -d 'some messages' "https://eastmanjian.cn/jersey_demo/webapi/cache/postmsg"
 *   curl -vi -X DELETE -H "Accept: text/plain" "https://eastmanjian.cn/jersey_demo/webapi/cache/delmsg"
 */
@Path("/cache") //root resource
public class PutPostDeleteResource {
    /**
     * Receive a plain text message from client who uses a PUT method in the request. Store in a cache.
     * The resource method returns void. This means no representation is returned and response with a HTTP status code
     * of 204 (No Content) will be returned to the client.
     * @param msg the message to put
     */
    @Path("message") //sub-resource, the param will be /cache/message
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public synchronized void setMsg(String msg) {
        System.out.println("Receive REST PUT:" + msg);
        Cache.getSingleton().setMsg(msg);
    }

    /**
     * Receive a plain text message from client who uses a PUT method in the request. Store in a cache.
     * @param msg the message to put.
     * @return status 200(ok) as HTTP response.
     */
    @Path("/msgrsp")  //sub-resource, the param will be /cache/msgrsp
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response putMsg(String msg) {
        System.out.println("Receive REST PUT:" + msg);
        Cache.getSingleton().setMsg(msg);
            return Response.ok().build();
    }

    /**
     * Receive a plain text message from client who uses a POST method in the request. Store in a cache.
     * @param msg the message to post
     * @return status 204(no content) as HTTP response.
     */
    @Path("postmsg")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postMsg(String msg) {
        System.out.println("Receive REST POST:" + msg);
        Cache.getSingleton().setMsg(msg);
        return Response.noContent().build();
    }

    /**
     * Receive REST DELETE request from client. Clear the msg value in the cache.
     * @return status 200(ok) as HTTP response.
     */
    @Path("delmsg")
    @DELETE
    public Response removeMsg() {
        System.out.println("Receive REST DELETE request");
        Cache.getSingleton().clearMsg();
        return Response.ok().build();
    }


    @Path("message")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg() {
        String message = Cache.getSingleton().getMsg();
        return  "This is a demo of RESTful PUT, POST, DELETE, @Consumes, sub-resource." + NEW_LINE + NEW_LINE +

                "Message in cache is '" + message + "'" + NEW_LINE + NEW_LINE +

                "Use command 'curl -vi -X PUT -H \"Accept: text/plain\" -H \"Content-Type: text/plain\"" +
                " -d 'some messages' \"https://eastmanjian.cn/jersey_demo/webapi/cache/message\"' " +
                "to put message to the cache. Option -vi displays the headers and verbose outputs." + NEW_LINE + NEW_LINE +

                "Or use command 'curl -vi -X PUT -H \"Accept: text/plain\" -H \"Content-Type: text/plain\"" +
                " -d 'some messages' \"https://eastmanjian.cn/jersey_demo/webapi/cache/msgrsp\"' " +
                "to put message to the cache. The handling method provide 200 (ok) as HTTP response." + NEW_LINE + NEW_LINE +

                "Or use command 'curl -vi -X POST -H \"Accept: text/plain\" -H \"Content-Type: text/plain\"" +
                " -d 'some messages' \"https://eastmanjian.cn/jersey_demo/webapi/cache/postmsg\"' " +
                "to post message to the cache.  The handling method provide 204(no content) as HTTP response." + NEW_LINE + NEW_LINE +

                "Use command 'curl -vi -X DELETE -H \"Accept: text/plain\" " +
                " \"https://eastmanjian.cn/jersey_demo/webapi/cache/delmsg\"' " +
                "to remove the message from the cache. The handling method provide 200(ok) as HTTP response." + NEW_LINE + NEW_LINE +

                ARCHE_DESC;
    }
}