package org.example;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;

public class DomXMLtoXml {
    public static void main(String[] argv) {
        String catn = "002";

        try {
            File inputFile = new File("film.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            DocumentBuilderFactory dbrFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder drBuilder = dbrFactory.newDocumentBuilder();
            Document rdoc = drBuilder.newDocument();

            NodeList genreList = doc.getElementsByTagName("Category");

            for (int temp = 0; temp < genreList.getLength(); temp++) {
                Node genre = genreList.item(temp);
                if (genre.getNodeType() == Node.ELEMENT_NODE) {
                    Element genreAtt = (Element) genre;
                    if (genreAtt.getAttribute("idCategory").equals(catn)) {
                        Element booksElement = rdoc.createElement("films");
                        rdoc.appendChild(booksElement);

                        Element genreElement = rdoc.createElement("Category");
                        booksElement.appendChild(genreElement);

                        Attr genreId = rdoc.createAttribute("idCategory");
                        genreId.setValue(genreAtt.getAttribute("idCategory"));
                        genreElement.setAttributeNode(genreId);

                        Attr genreName = rdoc.createAttribute("Categoryname");
                        genreName.setValue(genreAtt.getAttribute("Categoryname"));
                        genreElement.setAttributeNode(genreName);

                        NodeList bookNameList = genreAtt.getElementsByTagName("film");

                        for (int count = 0; count < bookNameList.getLength(); count++) {
                            Node books = bookNameList.item(count);
                            if (books.getNodeType() == books.ELEMENT_NODE) {
                                Element bookInfo = (Element) books;

                                Element book = rdoc.createElement("film");
                                genreElement.appendChild(book);

                                Attr rBookId = rdoc.createAttribute("filmid");
                                rBookId.setValue(bookInfo.getAttribute("filmid"));
                                book.setAttributeNode(rBookId);

                                Element bookAuthor = rdoc.createElement("Regizor");
                                bookAuthor.appendChild(rdoc.createTextNode(bookInfo.getElementsByTagName("Regizor").item(0).getTextContent()));
                                book.appendChild(bookAuthor);

                                Element bookName = rdoc.createElement("Name");
                                bookName.appendChild(rdoc.createTextNode(bookInfo.getElementsByTagName("Name").item(0).getTextContent()));
                                book.appendChild(bookName);

                                Element publicationDate = rdoc.createElement("Publication");
                                publicationDate.appendChild(rdoc.createTextNode(bookInfo.getElementsByTagName("Publication").item(0).getTextContent()));
                                book.appendChild(publicationDate);

                                Element availability = rdoc.createElement("availability");
                                availability.appendChild(rdoc.createTextNode(bookInfo.getElementsByTagName("availability").item(0).getTextContent()));
                                book.appendChild(availability);

                                Element characters = rdoc.createElement("Casts");
                                book.appendChild(characters);

                                NodeList charactersList = doc.getElementsByTagName("Casts");
                                for (int i = 0; i < charactersList.getLength(); i++){
                                    Element character = rdoc.createElement("Cast");
                                    character.appendChild(rdoc.createTextNode(bookInfo.getElementsByTagName("Cast").item(i).getTextContent()));
                                    characters.appendChild(character);
                                }

                            }
                        }
                    }
                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(rdoc);
            StreamResult result = new StreamResult(new File("filmod.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
