package jersey.demo.moxy.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyJaxbBean {
    public String name;
    public int age;

    public MyJaxbBean() {
    } // JAXB needs this

    public MyJaxbBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}