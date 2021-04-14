
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXQuery {
    public static void main(String[] args) {

        try {
            File inputFile = new File("film.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userHandler = new UserHandler2();
            saxParser.parse(inputFile, userHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler2 extends DefaultHandler {

    boolean Regizor = false;
    boolean name = false;
    boolean Publication = false;
    boolean availability = false;
    boolean Casts = false;
    boolean Cast = false;

    String filmid = null;
    String idf = "0001";

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("film")) {
            filmid = attributes.getValue("filmid");
        }
        if (idf.equals(filmid)) {
            if (qName.equalsIgnoreCase("Regizor")) {
                Regizor = true;
            } else if (qName.equalsIgnoreCase("Name")) {
                name = true;
            } else if (qName.equalsIgnoreCase("Publication")) {
                Publication = true;
            } else if (qName.equalsIgnoreCase("availability")) {
                availability = true;
            } else if (qName.equalsIgnoreCase("Cast")) {
                Cast = true;
            } else if (qName.equalsIgnoreCase("Casts")) {
                Casts = true;
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (idf.equals(filmid)) {
            if (Regizor) {
                System.out.println("Regizor: " + new String(ch, start, length));
                Regizor = false;
            } else if (name) {
                System.out.println("Name: " + new String(ch, start, length));
                name = false;
            } else if (Publication) {
                System.out.println("Publication: " + new String(ch, start, length));
                Publication = false;
            } else if (availability) {
                System.out.println("availability: " + new String(ch, start, length));
                availability = false;
            } else if (Casts) {
                System.out.print("Casts: ");
                Casts = false;
            } else if (Cast) {
                System.out.print(new String(ch, start, length) + ", ");
                Cast = false;
            }
        }
    }
}