/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_addelte;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 *
 * @author xabier.barreiroalber
 */
public class Dom_add {

    public static void main(String[] args) {
        File file = new File("dom.xml");
        try (FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8") ) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dB = factory.newDocumentBuilder();
        Document doc = dB.parse(new InputSource(isr));
        Node raiz = doc.getFirstChild();
        
        Element cliente = doc.createElement("cliente");
        cliente.setAttribute("DNI", "646374627W");
        
        Element apellido1 = doc.createElement("apellido1");
        apellido1.setTextContent("VILLANUEVA");
        cliente.appendChild(apellido1);
        
        Element apellido2 = doc.createElement("apellido2");
        apellido1.setTextContent("VILLANUE");
        cliente.appendChild(apellido2);
        
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("JUÁN");
        cliente.appendChild(nombre);
        
        Element validez = doc.createElement("calidez");
        validez.setAttribute("estado", "borrado");
        validez.setAttribute("timestamp", "153532523345");
        
        raiz.appendChild(cliente);
        
        
        Element element = (Element)doc.getElementsByTagName("cliente").item(0);
        
        element.getParentNode().removeChild(element);
        doc.normalize();
        
        
        
        
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult(file));

        
        
        

        
//ahora podemos acceder a los nodos del document ‘doc’
}
        
        
        
catch (Exception e) { e.printStackTrace(); }
    }
    
}
