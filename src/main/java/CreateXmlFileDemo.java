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
            Element films = doc.createElement("films");
            doc.appendChild(films);

            // genre1 element
            Element Category = doc.createElement("Category");
            films.appendChild(Category);

            // setting genreID attribute to element genre1
            Attr idCategory = doc.createAttribute("idCategory");
            idCategory.setValue("001");
            Category.setAttributeNode(idCategory);

            // setting genreName attribute to element genre1
            Attr Categoryname = doc.createAttribute("Categoryname");
            Categoryname.setValue("history");
            Category.setAttributeNode(Categoryname);

            // book1 element
            Element film1 = doc.createElement("film");
            Category.appendChild(film1);

            // setting bookId attribute to element book
            Attr filmid = doc.createAttribute("filmid");
            filmid.setValue("0001");
            film1.setAttributeNode(filmid);

            // author element
            Element Regizor = doc.createElement("Regizor");
            Regizor.appendChild(doc.createTextNode("Simon Stone"));
            film1.appendChild(Regizor);

            // book name element
            Element Name = doc.createElement("Name");
            Name.appendChild(doc.createTextNode("The Dig"));
            film1.appendChild(Name);

            // publication date element
            Element Publication = doc.createElement("Publication");
            Publication.appendChild(doc.createTextNode("2222"));
            film1.appendChild(Publication);

            // availability element
            Element availability = doc.createElement("availability");
            availability.appendChild(doc.createTextNode("true"));
            film1.appendChild(availability);

            // characters list element
            Element Casts = doc.createElement("Casts");
            film1.appendChild(Casts);

            // character elements
            Element Cast1 = doc.createElement("Cast");
            Cast1.appendChild(doc.createTextNode("Lily James"));
            Casts.appendChild(Cast1);

            Element Cast2 = doc.createElement("Cast");
            Cast2.appendChild(doc.createTextNode("Ralph Fiennes"));
            Casts.appendChild(Cast2);

            Element Cast3 = doc.createElement("Cast");
            Cast3.appendChild(doc.createTextNode("Carey Mulligan"));
            Casts.appendChild(Cast3);




            Element film2 = doc.createElement("film");
            Category.appendChild(film2);


            Attr filmid2 = doc.createAttribute("filmid");
            filmid2.setValue("0002");
            film2.setAttributeNode(filmid2);


            Element Regizor2 = doc.createElement("Regizor");
            Regizor2.appendChild(doc.createTextNode("Thomas Kail"));
            film2.appendChild(Regizor2);

            // book name element
            Element Name2 = doc.createElement("Name");
            Name2.appendChild(doc.createTextNode("Hamilton"));
            film2.appendChild(Name2);

            // publication date element
            Element Publication2 = doc.createElement("Publication");
            Publication2.appendChild(doc.createTextNode("2020"));
            film2.appendChild(Publication2);

            // availability element
            Element availability2 = doc.createElement("availability");
            availability2.appendChild(doc.createTextNode("true"));
            film2.appendChild(availability2);

            // characters list element
            Element Casts2 = doc.createElement("Casts");
            film2.appendChild(Casts2);

            // character elements
            Element Cast12 = doc.createElement("Cast");
            Cast12.appendChild(doc.createTextNode("Brego"));
            Casts2.appendChild(Cast12);

            Element Cast22 = doc.createElement("Cast");
            Cast22.appendChild(doc.createTextNode("Daveed Diggs"));
            Casts2.appendChild(Cast22);

            Element Cast32 = doc.createElement("Cast");
            Cast32.appendChild(doc.createTextNode("Lin‑Manuel Miranda"));
            Casts2.appendChild(Cast32);




            Element Category2 = doc.createElement("Category");
            films.appendChild(Category2);

            Attr idCategory2 = doc.createAttribute("idCategory");
            idCategory2.setValue("002");
            Category2.setAttributeNode(idCategory2);

            Attr Categoryname2 = doc.createAttribute("Categoryname");
            Categoryname2.setValue("Drama");
            Category2.setAttributeNode(Categoryname2);

            Element film3 = doc.createElement("film");
            Category2.appendChild(film3);

            Attr filmid3 = doc.createAttribute("filmid");
            filmid3.setValue("0003");
            film3.setAttributeNode(filmid3);

            Element Regizor3 = doc.createElement("Regizor");
            Regizor3.appendChild(doc.createTextNode("Aaron Sorkin"));
            film3.appendChild(Regizor3);


            Element Name3 = doc.createElement("Name");
            Name3.appendChild(doc.createTextNode("The Trial of the Chicago 7"));
            film3.appendChild(Name3);


            Element Publication3 = doc.createElement("Publication");
            Publication3.appendChild(doc.createTextNode("2020"));
            film3.appendChild(Publication3);


            Element availability3 = doc.createElement("availability");
            availability3.appendChild(doc.createTextNode("true"));
            film3.appendChild(availability3);

            Element Casts3 = doc.createElement("Casts");
            film3.appendChild(Casts3);

            Element Cast31 = doc.createElement("Cast");
            Cast31.appendChild(doc.createTextNode("Eddie Redmayne"));
            Casts3.appendChild(Cast31);

            Element Cast322 = doc.createElement("Cast");
            Cast322.appendChild(doc.createTextNode("Sacha Baron Cohen"));
            Casts3.appendChild(Cast322);

            Element Cast323 = doc.createElement("Cast");
            Cast323.appendChild(doc.createTextNode("Jeremy Strong"));
            Casts3.appendChild(Cast323);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("film.xml"));
            transformer.transform(source, result);


            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
