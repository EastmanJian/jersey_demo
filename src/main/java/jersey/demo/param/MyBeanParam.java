package jersey.demo.param;

import javax.ws.rs.*;

public class MyBeanParam {
    @PathParam("p")
    private String pathParam;

    @MatrixParam("m")
    @Encoded
    @DefaultValue("default")
    private String matrixParamM;

    @MatrixParam("n")
    @Encoded
    @DefaultValue("default")
    private String matrixParamN;

    @HeaderParam("header")
    private String headerParamUsrDef;

    @HeaderParam("host")
    private String headerParamHost;

    private String queryParam;

    public MyBeanParam(@QueryParam("q") String queryParam) {
        this.queryParam = queryParam;
    }

    public String getPathParam() { return pathParam; }
    public String getMatrixParamM() { return matrixParamM; }
    public String getMatrixParamN() { return matrixParamN; }
    public String getHeaderParamUsrDef() {return headerParamUsrDef; }
    public String getHeaderParamHost() {return headerParamHost; }
    public String getQueryParamN() {
        return queryParam;
    }

}