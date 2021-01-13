package labyak;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "labyak")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLLabYakElement {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "age")
    private double age;
    @XmlAttribute(name = "sex")
    private String sex;

    public XMLLabYakElement() {
    }

    public XMLLabYakElement(String name, double age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
