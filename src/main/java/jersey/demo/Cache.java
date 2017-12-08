package jersey.demo;

/**
 * A singleton Cache
 */
public class Cache {
    private static Cache singleton;
    private String msg;

    private Cache() {
        this.msg = null;
    }


    public static synchronized Cache getSingleton() {
        if (singleton == null) {
            singleton = new Cache();
        }
        return singleton;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void clearMsg() {
        this.msg = null;
    }

    public String getMsg() {
        return msg;
    }
}
