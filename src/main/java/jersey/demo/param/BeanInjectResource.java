package jersey.demo.param;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Map;
import java.util.Set;

import static jersey.demo.Constants.ARCHE_DESC;
import static jersey.demo.Constants.NEW_LINE;

/**
 * Demo of REST JAX-RS, inject the parameters into a single bean. Also the usage of @MatrixParam, @HeaderParam.
 *
 * Test it with curl command:
 *   curl -H 'Accept: text/plain' -H 'header: anything' 'https://eastmanjian.cn/jersey_demo/webapi/beanparam/Eastman;m=ValM;n=ValN?q=135'
 */
@Path("beanparam/{p}")
public class BeanInjectResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String injectToBean(@BeanParam MyBeanParam beanParam, String entity) {
        final String pathParam = beanParam.getPathParam();
        final String matrixParamM = beanParam.getMatrixParamM();
        final String matrixParamN = beanParam.getMatrixParamN();
        final String headerParam = beanParam.getHeaderParamN();
        final String queryParam = beanParam.getQueryParamN();

        return  "This is a demo of injecting the parameters into a single bean." +
                "Also the usage of @MatrixParam, @HeaderParam." + NEW_LINE + NEW_LINE +
                "Use the following curl command to test the headerParam:" + NEW_LINE +
                "curl -H 'Accept: text/plain' -H 'header: anything' 'https://eastmanjian.cn/jersey_demo/webapi/beanparam/Eastman;m=ValM;n=ValN?q=135'" + NEW_LINE + NEW_LINE +
                "pathParam = " + pathParam + NEW_LINE +
                "matrixParamM = " + matrixParamM + NEW_LINE +
                "matrixParamN = " + matrixParamN + NEW_LINE +
                "headerParam = " + headerParam + NEW_LINE +
                "queryParam = " + queryParam + NEW_LINE +
                NEW_LINE + ARCHE_DESC;
    }
}