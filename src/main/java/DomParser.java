
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("film.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
               NodeList nList = doc.getElementsByTagName("film");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("film id : "
                            + eElement.getAttribute("filmid"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("Name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Regizor : "
                            + eElement
                            .getElementsByTagName("Regizor")
                            .item(0)
                            .getTextContent());
                    System.out.println("Publication : "
                            + eElement
                            .getElementsByTagName("Publication")
                            .item(0)
                            .getTextContent());
                    System.out.println("Availability : "
                            + eElement
                            .getElementsByTagName("availability")
                            .item(0)
                            .getTextContent());
                    if(eElement.getElementsByTagName("Casts").getLength()>0){
                        System.out.println("Casts : "
                                +eElement.getElementsByTagName("Casts")
                                .item(0)
                                .getTextContent());
                    }System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
