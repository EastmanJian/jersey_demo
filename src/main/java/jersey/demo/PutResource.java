package jersey.demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static jersey.demo.Constants.*;


@Path("/cache")
public class PutResource {
    private String msg;

    /**
     * Receive a plain text message from client who uses a PUT method in the request. Store in a cache.
     * @param msg
     */
    @Path("message")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public synchronized void setMsg(String msg) {
        System.out.println("Receive REST PUT:" + msg);
        Cache.getSingleton().setMsg(msg);
    }

    /**
     * Receive a plain text message from client who uses a PUT method in the request. Store in a cache.
     * And provide a
     * @param msg
     * @return
     */
    @Path("msgrsp")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response putMsg(String msg) {
        System.out.println("Receive REST PUT:" + msg);
        Cache.getSingleton().setMsg(msg);
            return Response.ok().build();
    }

    @Path("message")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg() {
        String message = Cache.getSingleton().getMsg();
        return "Message in cache is '" + message + "'" + NEW_LINE + NEW_LINE +
                "Use command 'curl -vi -X PUT -H \"Accept: text/plain\" -H \"Content-Type: text/plain\"" +
                " -d 'some messages' \"https://eastmanjian.cn/jersey_demo/webapi/cache/message\"' " +
                "to put message to the cache. Option -vi displays the headers and verbose outputs." + NEW_LINE +
                "Or use command 'curl -vi -X PUT -H \"Accept: text/plain\" -H \"Content-Type: text/plain\"" +
                " -d 'some messages' \"https://eastmanjian.cn/jersey_demo/webapi/cache/msgrsp\"' " +
                "to put message to the cache and receive 200 as HTTP response." + NEW_LINE +
                ARCHE_DESC;
    }
}