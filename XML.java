package threadthigiuaki;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {
	

	    public static void main(String[] args) throws Exception {

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	        DocumentBuilder builder = factory.newDocumentBuilder();

	        Document document = builder.newDocument();
	        Element rootElement = document.createElement("students");
	        document.appendChild(rootElement);
	        for (int a = 0; a < 10; a++) {
	            Element studentElement = document.createElement("student");
	            rootElement.appendChild(studentElement);

	            Element ageElement = document.createElement("age");
	            ageElement.appendChild(document.createTextNode(String.valueOf(a + 18)));
	            studentElement.appendChild(ageElement);
	            
	            Element nameElement = document.createElement("name");
	            nameElement.appendChild(document.createTextNode("Student " + (a + 1)));
	            studentElement.appendChild(nameElement);

	        }
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult("kq.xml");
	        transformer.transform(source, result);
	        System.out.println("Finish");
	    }
	}

