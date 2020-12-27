package labyak;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class YakApp {

    public static void main(String[] args){
        try {
            String filePath = "/Users/asahdev/Work/Test/DesignPatterns/src/main/java/application/XMLInputHerdData.xml";
            int days = 14;
            String yaksStatus = getYaksStatus(filePath, days);
            System.out.println(yaksStatus);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    private static String getYaksStatus(String filepath, int days) throws  Exception {
        XMLHerdElement xmlHerdElement = xmlToObject(filepath);
        List<Yak> inputYaks = getYakList(xmlHerdElement);
        int wool = 0;
        double milk = 0.0;
        StringBuilder herdsStatus = new StringBuilder("Herd:\n");
        for(Yak yak : inputYaks){
            yak.performMorningTask(days);
            wool = wool + yak.getWoolQuantity();
            milk = milk + yak.getMilkFetched();
            herdsStatus.append(yak.getName() + " " + yak.getCurrentAge() + " years old\n");
        }
        StringBuilder result = new StringBuilder("In Stock:\n");
        result.append(milk + " liters of milk\n");
        result.append(wool + " skins of wool\n");
        result.append(herdsStatus);
        return result.toString();
    }

    private static List<Yak> getYakList(XMLHerdElement xmlHerdElement) throws Exception{
        List<Yak> inputYaks = new ArrayList<Yak>();
        for (XMLLabYakElement yak : xmlHerdElement.getLabYaks()) {
            inputYaks.add(YakFactory.buildYak(YakType.LAB_YAK, yak.getName(), yak.getAge(), yak.getSex()));
        }
        return inputYaks;
    }

    private static XMLHerdElement xmlToObject(String filepath) throws Exception{
        File file = new File(filepath);
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLHerdElement.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLHerdElement XMLHerdElement = (XMLHerdElement) unmarshaller.unmarshal(file);
        return XMLHerdElement;
    }

}
