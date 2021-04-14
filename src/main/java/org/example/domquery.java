package org.example;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

class DomQuery {
    public static void main(String argv[]) {

        try {
            File inputFile = new File("film.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Category");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    NodeList bookNameList = eElement.getElementsByTagName("film");

                    for (int count = 0; count < bookNameList.getLength(); count++) {
                        Node node1 = bookNameList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element book = (Element) node1;
                            String m = book.getAttribute("filmid");
                            if (m.equals("0001")) {
                                System.out.println("\nCurrent Element: ");
                                System.out.print("\tfilm id: ");
                                System.out.println(book.getAttribute("filmid"));
                                System.out.print("\tCategoryname: ");
                                System.out.println(eElement.getAttribute("Categoryname"));
                                System.out.println("\tName: "
                                        + book.getElementsByTagName("Name")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("\tRegizor: "
                                        + book.getElementsByTagName("Regizor")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("\tPublication: "
                                        + book.getElementsByTagName("Publication")
                                        .item(0)
                                        .getTextContent());
                                System.out.println("\tDIsp: "
                                        + eElement
                                        .getElementsByTagName("availability")
                                        .item(0)
                                        .getTextContent());

                                System.out.print("\tCasts: ");
                                NodeList cList = doc.getElementsByTagName("Casts");
                                for (int i = 0; i < cList.getLength(); i++) {
                                    System.out.print(eElement
                                            .getElementsByTagName("Cast")
                                            .item(i)
                                            .getTextContent() + ", ");
                                    if (i == cList.getLength() - 1) {
                                        System.out.print("\b\b.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
