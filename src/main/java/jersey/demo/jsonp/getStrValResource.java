package jersey.demo.jsonp;

import jersey.demo.Cache;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * JSONP example:  JsonObject usage
 *
 * e.g. the following curl command will invoke doPostFromJsonOrXml()
 *     curl -i -X POST -H 'Content-Type: application/json' -d '{"msg":"say something"}' 'https://eastmanjian.cn/jersey_demo/webapi/jsonmsg'
 *
 * Use the curl command below to retrieve the value stored in the cache
 *     curl 'https://eastmanjian.cn/jersey_demo/webapi/jsonmsg'
 */
@Path("/jsonmsg")
@Consumes(MediaType.TEXT_PLAIN)
public class getStrValResource {
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})  //this overrides the class level @Consumes(MediaType.TEXT_PLAIN)
    public void doPostFromJsonOrXml(JsonObject msg) {
        Cache.getSingleton().setMsg(msg.getString("msg"));
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg() {
        String message = Cache.getSingleton().getMsg();
        return  "This is a demo of JSONP" + NEW_LINE + NEW_LINE +

                "The message in cache is '" + message + "'" + NEW_LINE + NEW_LINE +

                "Use command: curl -i -X POST -H 'Content-Type: application/json' -d '{\"msg\":\"say something\"}' 'https://eastmanjian.cn/jersey_demo/webapi/jsonmsg'" + NEW_LINE +
                "to put message to the cache with json format. " + NEW_LINE + NEW_LINE +

                ARCHE_DESC;
    }

}
