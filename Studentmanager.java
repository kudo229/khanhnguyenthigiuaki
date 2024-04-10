package threadthigiuaki;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Studentmanager {
	 public static void main(String[] args) {
	        try {	   
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            File inputFile = new File("E:\\java chính\\Java project\\threadthigiuaki\\src\\threadthigiuaki\\Student.xml");
	            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dbBuilder.parse(inputFile);
	            doc.getDocumentElement().normalize();

	            NodeList studentList = doc.getElementsByTagName("student");
	            for (int t = 0; t < studentList.getLength(); t++) {
	                Element studentElement = (Element) studentList.item(t);

	                String id = studentElement.getAttribute("id");
	                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
	                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
	                String dateOfBirth = studentElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
	                Student student = new Student(id, name, address, dateOfBirth);
	                System.out.println(id);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	    
	            Scanner scanner = new Scanner(System.in);
	            
	            List<Student> studentList = new ArrayList<>();

	            while (true) {
	                System.out.println("Nhập thông tin học sinh: ");
	                System.out.print("Mã sinh viên: ");
	                String id = scanner.nextLine();

	                System.out.print("Họ tên: ");
	                String name = scanner.nextLine();

	                System.out.print("Địa chỉ: ");
	                String address = scanner.nextLine();
	            	System.out.print("Ngày sinh (dd/MM/yyyy): ");
	                String dateStr = scanner.nextLine();
	                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                Date dateOfBirth = null;
	                try {
	                    dateOfBirth = dateFormat.parse(dateStr);
	                } catch (ParseException e) {
	                    System.err.println("Nhập không đúng form");
	                }
	                System.out.print("Thêm học sinh khác (y/n)? ");
	                String choice = scanner.nextLine();
	                if (!choice.equalsIgnoreCase("y")) {
	                    break;
	                }
	            }
	    }
}
