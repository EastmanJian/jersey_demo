package jersey.demo.consumes;

import jersey.demo.Cache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * The @Consumes annotation is used to specify the MIME media types of representations that can be consumed by a resource.
 * @Consumes can be applied at both the class and the method levels and more than one media type may be declared.
 *
 * e.g. the following curl command will invoke doSetFromPlainText()
 *     curl -i -X PUT -H 'Content-Type: text/plain' -d 'try @Consumes' 'https://eastmanjian.cn/jersey_demo/webapi/cachemsg'
 *
 * e.g. the following curl command will invoke doPostFromJsonOrXml()
 *     curl -i -X POST -H 'Content-Type: application/json' -d '{"msg":"try again"}' 'https://eastmanjian.cn/jersey_demo/webapi/cachemsg'
 *
 * Use the curl command below to retrieve the value stored in the cache
 *     curl 'https://eastmanjian.cn/jersey_demo/webapi/cachemsg'
 */
@Path("/cachemsg")
@Consumes(MediaType.TEXT_PLAIN)
public class MultiConsumesResource {
    @PUT
    public void doSetFromPlainText(String msg) {
        Cache.getSingleton().setMsg(msg);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})  //this overrides the class level @Consumes(MediaType.TEXT_PLAIN)
    public void doPostFromJsonOrXml(String msg) {
        Cache.getSingleton().setMsg(msg); //For demo, the json format content is accepted as a String here. It's not parsed by any JSON API yet.
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg() {
        String message = Cache.getSingleton().getMsg();
        return  "This is a demo of @Consumes annotation." + NEW_LINE + NEW_LINE +

                "The message in cache is '" + message + "'" + NEW_LINE + NEW_LINE +

                "Use command: curl -i -X PUT -H 'Content-Type: text/plain' -d 'try @Consumes' 'https://eastmanjian.cn/jersey_demo/webapi/cachemsg'" + NEW_LINE +
                "to put message to the cache with plain text. " + NEW_LINE + NEW_LINE +

                "Use command: curl -i -X POST -H 'Content-Type: application/json' -d '{\"msg\":\"try again\"}' 'https://eastmanjian.cn/jersey_demo/webapi/cachemsg'" + NEW_LINE +
                "to put message to the cache with json format. " + NEW_LINE + NEW_LINE +

                ARCHE_DESC;
    }

}
