import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

class XMLCreate {
    public static void main(String argv[]) {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // books (root) element
            Element booksElement = doc.createElement("films");
            doc.appendChild(booksElement);

            // genre1 element
            Element genre1 = doc.createElement("Category");
            booksElement.appendChild(genre1);

            // setting genreID attribute to element genre1
            Attr genreId = doc.createAttribute("idCategory");
            genreId.setValue("001");
            genre1.setAttributeNode(genreId);

            // setting genreName attribute to element genre1
            Attr genreName = doc.createAttribute("Categoryname");
            genreName.setValue("history");
            genre1.setAttributeNode(genreName);

            // book1 element
            Element book1 = doc.createElement("film");
            genre1.appendChild(book1);

            // setting bookId attribute to element book
            Attr bookId = doc.createAttribute("filmid");
            bookId.setValue("0001");
            book1.setAttributeNode(bookId);

            // author element
            Element bookAuthor = doc.createElement("Regizor");
            bookAuthor.appendChild(doc.createTextNode("Simon Stone"));
            book1.appendChild(bookAuthor);

            // book name element
            Element bookName = doc.createElement("Name");
            bookName.appendChild(doc.createTextNode("The Dig"));
            book1.appendChild(bookName);

            // publication date element
            Element publicationDate = doc.createElement("Publication");
            publicationDate.appendChild(doc.createTextNode("2222"));
            book1.appendChild(publicationDate);

            // availability element
            Element availability = doc.createElement("availability");
            availability.appendChild(doc.createTextNode("true"));
            book1.appendChild(availability);

            // characters list element
            Element characters = doc.createElement("Casts");
            book1.appendChild(characters);

            // character elements
            Element character1 = doc.createElement("Cast");
            character1.appendChild(doc.createTextNode("Lily James"));
            characters.appendChild(character1);

            Element character2 = doc.createElement("Cast");
            character2.appendChild(doc.createTextNode("Ralph Fiennes"));
            characters.appendChild(character2);

            Element character3 = doc.createElement("Cast");
            character3.appendChild(doc.createTextNode("Carey Mulligan"));
            characters.appendChild(character3);



            // book2 element
            Element book2 = doc.createElement("film");
            genre1.appendChild(book2);

            // setting bookId attribute to element book
            Attr book2Id = doc.createAttribute("filmid");
            book2Id.setValue("0002");
            book2.setAttributeNode(book2Id);

            // author element
            Element book2Author = doc.createElement("Regizor");
            book2Author.appendChild(doc.createTextNode("Thomas Kail"));
            book2.appendChild(book2Author);

            // book name element
            Element book2Name = doc.createElement("Name");
            book2Name.appendChild(doc.createTextNode("Hamilton"));
            book2.appendChild(book2Name);

            // publication date element
            Element publicationDate2 = doc.createElement("Publication");
            publicationDate2.appendChild(doc.createTextNode("2020"));
            book2.appendChild(publicationDate2);

            // availability element
            Element availability2 = doc.createElement("availability");
            availability2.appendChild(doc.createTextNode("true"));
            book2.appendChild(availability2);

            // characters list element
            Element characters2 = doc.createElement("Casts");
            book2.appendChild(characters2);

            // character elements
            Element character12 = doc.createElement("Cast");
            character12.appendChild(doc.createTextNode("Brego"));
            characters2.appendChild(character12);

            Element character22 = doc.createElement("Cast");
            character22.appendChild(doc.createTextNode("Daveed Diggs"));
            characters2.appendChild(character22);

            Element character32 = doc.createElement("Cast");
            character32.appendChild(doc.createTextNode("Lin‑Manuel Miranda"));
            characters2.appendChild(character32);



            // genre2 element
            Element genre2 = doc.createElement("Category");
            booksElement.appendChild(genre2);

            // setting genreID attribute to element genre1
            Attr genre2Id = doc.createAttribute("idCategory");
            genre2Id.setValue("002");
            genre2.setAttributeNode(genre2Id);

            // setting genreName attribute to element genre1
            Attr genre2Name = doc.createAttribute("Categoryname");
            genre2Name.setValue("Drama");
            genre2.setAttributeNode(genre2Name);

            // book1 element
            Element book3 = doc.createElement("film");
            genre2.appendChild(book3);

            // setting bookId attribute to element book
            Attr book3Id = doc.createAttribute("filmid");
            book3Id.setValue("0003");
            book3.setAttributeNode(book3Id);

            // author element
            Element book3Author = doc.createElement("Regizor");
            book3Author.appendChild(doc.createTextNode("Aaron Sorkin"));
            book3.appendChild(book3Author);

            // book name element
            Element book3Name = doc.createElement("Name");
            book3Name.appendChild(doc.createTextNode("The Trial of the Chicago 7"));
            book3.appendChild(book3Name);

            // publication date element
            Element publicationDate3 = doc.createElement("Publication");
            publicationDate3.appendChild(doc.createTextNode("2020"));
            book3.appendChild(publicationDate3);

            // availability element
            Element availability3 = doc.createElement("availability");
            availability3.appendChild(doc.createTextNode("true"));
            book3.appendChild(availability3);

            // characters list element
            Element characters3 = doc.createElement("Casts");
            book3.appendChild(characters3);

            // character elements
            Element character13 = doc.createElement("Cast");
            character13.appendChild(doc.createTextNode("Eddie Redmayne"));
            characters3.appendChild(character13);

            Element character23 = doc.createElement("Cast");
            character23.appendChild(doc.createTextNode("Sacha Baron Cohen"));
            characters3.appendChild(character23);

            Element character33 = doc.createElement("Cast");
            character33.appendChild(doc.createTextNode("Jeremy Strong"));
            characters3.appendChild(character33);



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("film.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}