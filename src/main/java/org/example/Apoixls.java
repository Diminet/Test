package org.example;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

public class Apoixls {

    public static void main(String[] argv) {

        ArrayList<String> Regizor = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<String> Casts = new ArrayList<>();
        ArrayList<String> Publication = new ArrayList<>();
        ArrayList<String> availability = new ArrayList<>();
        ArrayList<String> filmid = new ArrayList<>();

        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("film.xml"));
            doc.getDocumentElement().normalize();

            NodeList listOfBooks = doc.getElementsByTagName("film");

            for (int s = 0; s < listOfBooks.getLength(); s++) {
                Node nNode = listOfBooks.item(s);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element idElement = (Element) nNode;
                    filmid.add(idElement.getAttribute("filmid"));

                    Element eElement = (Element) nNode;
                    NodeList AuthorsList = eElement.getElementsByTagName("Regizor");
                    Element firstNameElement = (Element) AuthorsList.item(0);
                    NodeList textFNList = firstNameElement.getChildNodes();
                    Regizor.add(textFNList.item(0).getNodeValue());

                    NodeList lastNameList = eElement.getElementsByTagName("Name");
                    Element lastNameElement = (Element) lastNameList.item(0);
                    NodeList textLNList = lastNameElement.getChildNodes();
                    Name.add(textLNList.item(0).getNodeValue());

                    NodeList ageList = eElement.getElementsByTagName("Publication");
                    Element ageElement = (Element) ageList.item(0);
                    NodeList textAgeList = ageElement.getChildNodes();
                    Publication.add(textAgeList.item(0).getNodeValue());

                    NodeList nAvailability = eElement.getElementsByTagName("availability");
                    Element eAvailability = (Element) nAvailability.item(0);
                    NodeList nlAvailability = eAvailability.getChildNodes();
                    availability.add(nlAvailability.item(0).getNodeValue());

                    NodeList listOfCharacters = doc.getElementsByTagName("Casts");

                    for (int tmp = 0; tmp < listOfCharacters.getLength(); tmp++) {
                        Node firstPersonNode = listOfCharacters.item(tmp);
                        if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element firstPersonElement = (Element) firstPersonNode;
                            NodeList cast1 = firstPersonElement.getElementsByTagName("Cast");
                            for (int i = 0; i < listOfCharacters.getLength(); i++) {
                                Element casts2 = (Element) cast1.item(i);
                                NodeList textcastList1 = casts2.getChildNodes();
                                Casts.add(textcastList1.item(0).getNodeValue());
                            }
                        }
                    }


                }
            }
        } catch (SAXParseException err) {
            System.out.println("Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("001 history");
        Sheet sheet1 = wb.createSheet("002 Drama");
        Map<String, Object[]> data = new HashMap<>();

        HSSFCellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("filmid");
        row0.createCell(1).setCellValue("Regizor");
        row0.createCell(2).setCellValue("Name");
        row0.createCell(3).setCellValue("Publication");
        row0.createCell(4).setCellValue("availability");
        row0.createCell(5).setCellValue("Casts");
        for (int temp = 0; temp < row0.getLastCellNum(); temp++) {
            row0.getCell(temp).setCellStyle(style);
        }

        Row row01 = sheet1.createRow(0);
        row01.createCell(0).setCellValue("filmid");
        row01.createCell(1).setCellValue("Regizor");
        row01.createCell(2).setCellValue("Name");
        row01.createCell(3).setCellValue("Publication");
        row01.createCell(4).setCellValue("availability");
        row01.createCell(5).setCellValue("Casts");
        for (int temp = 0; temp < row01.getLastCellNum(); temp++) {
            row01.getCell(temp).setCellStyle(style);
        }

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));
        sheet1.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));

        for (int i = 0; i < Regizor.size(); i++) {
            data.put(i + "", new Object[]{filmid.get(0), Regizor.get(0), Name.get(0), Publication.get(0), availability.get(0),
                    Casts.get(0), Casts.get(1), Casts.get(2)});
        }

        Set<String> keyset = data.keySet();
        int rownum = 1;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    sheet.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
        Map<String, Object[]> data1 = new HashMap<>();
        for (int i = 0; i < Regizor.size(); i++) {
            data1.put(i + "", new Object[]{filmid.get(1), Regizor.get(1), Name.get(1), Publication.get(1),
                    availability.get(1),  Casts.get(3), Casts.get(4), Casts.get(5)});
        }

        Set<String> keyset1 = data1.keySet();
        int rownum1 = 2;
        for (String key : keyset1) {
            Row row1 = sheet.createRow(rownum1);
            Object[] objArr1 = data1.get(key);
            int cellnum = 0;
            for (Object obj : objArr1) {
                Cell cell = row1.createCell(cellnum++);
                for (int i = 0; i < row1.getLastCellNum(); i++) {
                    sheet.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        Map<String, Object[]> data2 = new HashMap<>();
        for (int i = 0; i < Regizor.size(); i++) {
            data2.put(i + "", new Object[]{filmid.get(2), Regizor.get(2), Name.get(2), Publication.get(2),
                    availability.get(2),  Casts.get(6), Casts.get(7), Casts.get(8)});
        }

        Set<String> keyset2 = data2.keySet();
        int rownum2 = 1;
        for (String key : keyset2) {
            Row row2 = sheet1.createRow(rownum2);
            Object[] objArr = data2.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row2.createCell(cellnum++);
                for (int i = 0; i < row2.getLastCellNum(); i++) {
                    sheet1.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream("film.xls");
            wb.write(out);
            out.close();
            System.out.println("Excel written successfully...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}