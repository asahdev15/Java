package labyak;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "herd")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLHerdElement {

    @XmlElement(name = "labyak")
    private List<XMLLabYakElement> labYaks;

    public List<XMLLabYakElement> getLabYaks() {
        return labYaks;
    }

    public void setLabYaks(List<XMLLabYakElement> labYaks) {
        this.labYaks = labYaks;
    }

    public void add(XMLLabYakElement labYak) {
        if (this.labYaks == null) {
            this.labYaks = new ArrayList<>();
        }
        this.labYaks.add(labYak);
    }

    @Override
    public String toString() {
        return "Herd{" +
                "labYaks=" + labYaks +
                '}';
    }

}
