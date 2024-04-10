package threadthigiuaki;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.lang.*;

public class docXml {

	public static void main(String[] args) throws Exception {

        Document kqDocument = readXML("kq.xml");

        NodeList studentList = kqDocument.getElementsByTagName("student");


        for (int i = 0; i < studentList.getLength(); i++) {
            Element studentElement = (Element) studentList.item(i);

            String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
            int age = Integer.parseInt(studentElement.getElementsByTagName("age").item(0).getTextContent());
            int sumOfDigits = Integer.parseInt(studentElement.getElementsByTagName("sum").item(0).getTextContent());
            boolean isDigit = Boolean.parseBoolean(studentElement.getElementsByTagName("isDigit").item(0).getTextContent());
   
            System.out.println("Thông tin học sinh :"+ name +" - "+ age +" - "+ sumOfDigits +" - "+ isDigit +" - ");
        }
    }
    private static Document readXML(String fileName) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder bui = factory.newDocumentBuilder();
        Document document = bui.parse(fileName);
        return document;
    }
}

