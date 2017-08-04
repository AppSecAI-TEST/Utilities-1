import java.awt.image.ConvolveOp;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NPair fe = new NPair();
		fe.setNs(new NonStandard());
		fe.setNumber1(12);
		fe.setNumber2(13);
		FileOutputStream fos1=null;
		try {
			fos1 = new FileOutputStream("C:\\Utils\\ser.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
		xe1.writeObject(fe);
		xe1.flush();
		xe1.close();	
		
		String retString = encode(fe);
		System.out.println(retString);
		Node node = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			node = dbf.newDocumentBuilder().parse(new 
					ByteArrayInputStream(retString.getBytes()));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fe);
		
		NodeList nl = node.getChildNodes();
		
	//	Node item = node.getFirstChild().getChildNodes().item(1).
	//	getChildNodes().item(1).getChildNodes().item(1);//.getFirstChild();
	//	Node itemClone = item.cloneNode(true);
		
		//itemClone.setTextContent("truedwd");\
		
		Main m = new Main();
	
		m.dumpNode(node, 0);
		m.processNode(node);
		//item.getParentNode().replaceChild(item, item);
		
		String out = convertDocumentToString(node);
		
		System.out.println( out);
		
		m.dumpNode(node, 0);
		
		System.out.println(fe);
		
	}
	
	public void dumpNode(Node node, int spaces){
		System.out.println("");
		for(int j=0;j < spaces;j++) {
			System.out.print(" ");
		}
		System.out.print("{start dump node:"+ node);
//		System.out.print(";localName:"+ node.getLocalName());
//		System.out.print(";BaseURI:"+ node.getBaseURI());
		System.out.print(";NodeName:"+ node.getNodeName());
		System.out.print(";NodeType:"+ node.getNodeType());
		System.out.print(";NodeValue:"+ node.getNodeValue());
		
		NamedNodeMap nnm = node.getAttributes();
		
		if(nnm!=null && null != nnm.getNamedItem("class"))
			System.out.println(";class="+nnm.getNamedItem("class").getNodeValue()) ;
		
		NodeList childs = node.getChildNodes();
		
		for(int j=0;j < spaces;j++) {
			System.out.print(" ");
		}
		System.out.print("dump childs:"+ node + "[");
		for(int i=0;i<childs.getLength();i++){
			dumpNode(childs.item(i),spaces+1);
		}
		System.out.print("]}");
	}
	
	public void processNode(Node node){
	Node item = node.getFirstChild().getChildNodes().item(1).
	getChildNodes().item(1).getChildNodes().item(1);//.getFirstChild();
	//Node itemClone = item.cloneNode(true);
	item.setTextContent("truTedwd");
	}
	
    public static String convertDocumentToString(Node doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
         
        return null;
    }
	
	private static String encode(Object book) {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(book);
		encoder.close();

		return out.toString();

		}
	
	
	
}
