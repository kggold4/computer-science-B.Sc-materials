package xml;

import common.Address;
import common.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParse {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // Students list
        List<Student> studentList = new ArrayList<>();

        // get xml file
        File inputFile = new File("src/xml/students.xml");

        // create factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // get builder from factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        // create document from xml file (parse with builder)
        Document doc = builder.parse(inputFile);

        // print root name
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // getting all the students node into a list
        NodeList nodeList = doc.getDocumentElement().getElementsByTagName("Student");
        for(int studentIdx = 0; studentIdx < nodeList.getLength(); studentIdx++) {
            Node studentNode = nodeList.item(studentIdx);
            if(studentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) studentNode;
                Student student = new Student();
                studentList.add(student);

                // print attribute degree
                System.out.println("Degree: " + element.getAttribute("degree"));
                NodeList studentAllNode = studentNode.getChildNodes();
                for(int stIdx = 0; stIdx < studentAllNode.getLength(); stIdx++) {
                    Node stInnerNode = studentAllNode.item(stIdx);
                    switch(stInnerNode.getNodeName()) {
                        case "FirstName":
                            student.firstName = stInnerNode.getTextContent();
                            break;
                        case "LastName":
                            student.lastName = stInnerNode.getTextContent();
                            break;
                        case "id":
                            student.id = Integer.parseInt(stInnerNode.getTextContent());
                            break;
                        case "age":
                            student.age = Integer.parseInt(stInnerNode.getTextContent());
                            break;
                        case "Address":
                            Address address = new Address();
                            student.address = address;
                            NodeList addressAllNodes = stInnerNode.getChildNodes();
                            for(int adIdx = 0; adIdx < addressAllNodes.getLength(); adIdx++) {
                                Node adInnerNode = addressAllNodes.item(adIdx);
                                switch(adInnerNode.getNodeName()) {
                                    case "Street":
                                        address.street = adInnerNode.getTextContent();
                                        break;
                                    case "City":
                                        address.city = adInnerNode.getTextContent();
                                        break;
                                    case "Zip":
                                        address.zip = adInnerNode.getTextContent();
                                        break;
                                }
                                student.address = address;
                            }
                    }
                }
            }
        }

        System.out.println();
        for(Student st : studentList) {
            System.out.println(st);
        }

        System.out.println(studentList.get(0).lastName);
        System.out.println(studentList.get(1).address.zip);
        System.out.println(studentList.get(2).id);
    }
}
