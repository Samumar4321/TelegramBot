/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

/**
 *
 * @author marelli_samuele
 */
public class XML_Parser {

    public XML_Parser() {
    }

    public String DocumentParse(String path, String elementName) throws ParserConfigurationException, SAXException, IOException {

        //List<Autore> objects = new ArrayList<Autore>();
        String csv = "";
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Node root, element;
        NodeList nodeList;
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(path);
        root = document.getDocumentElement();
        nodeList = document.getElementsByTagName("Success");
        if (nodeList.getLength() > 0) {
            Node n = nodeList.item(0);
//            System.out.println("---------------------------------");
//            System.out.println(n.getTextContent());
//            Node sibiling = n.getNextSibling();
//            System.out.println(sibiling.getTextContent());
//            System.out.println("---------------------------------");
            csv += n.getTextContent();
            csv += ";";
            Node sibiling = n.getNextSibling();
            if (sibiling != null) {
                csv += sibiling.getTextContent();
            }
        } else {
            nodeList = document.getElementsByTagName(elementName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                if (e.hasChildNodes()) {
//                    System.out.println("---------------------------------");
                    if (e.hasAttribute("id")) {
                        csv += e.getAttribute("id");
                        csv += ";";
                    }
                    Node child = e.getFirstChild();
                    for (int j = 0; child != null; j++) {
//                      System.out.println(child.getTextContent());
                        csv += child.getTextContent();
                        csv += ";";
                        child = child.getNextSibling();
                    }
//                    System.out.println("---------------------------------");
                    csv += "<>";
                }
            }
        }
        return csv;
    }

}
