/**
 * 
 */
package data;

import javax.swing.text.html.parser.AttributeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import sun.rmi.runtime.NewThreadAction;

import java.io.File;
import java.util.Vector;

/**
 * @author shivhare
 *
 */
public class ReadData {
	
	private static final String devFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	private static final String testFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	private static final String goldFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	
	public static enum fileType {dev, test, gold};

	/**
	 * @param args
	 */
	public static Corpus LoadFile(fileType type){
		// TODO Auto-generated method stub
		
		String path = "";
		Corpus corpus = null;
		switch (type) {
			case dev:
				path = devFile;
				corpus = new Corpus(fileType.dev, path);
				break;
				
			case test:
				path = testFile;
				corpus = new Corpus(fileType.test, path);
				break;
				
			case gold:
				path = goldFile;
				corpus = new Corpus(fileType.gold, path);
				break;
		}
		
		try {
			 
				File fXmlFile = new File(path);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				NodeList pairs = doc.getElementsByTagName("pair");
				
				Vector<THPair> thPairs = corpus.getPairs();
				
				for (int i = 0; i < pairs.getLength(); i++) {
					Node p = pairs.item(i);
					Element pair = (Element) p;
					
					//System.out.println("\nID  :" + pair.getAttribute("id"));
					//System.out.println("\nResult  :" + pair.getAttribute("entailment"));
					
					THPair thpair = new THPair(Integer.parseInt(pair.getAttribute("id")), pair.getAttribute("entailment"));
					
					//System.out.println("T : " + pair.getElementsByTagName("t").item(0).getTextContent());
					thpair.T().setRawString(pair.getElementsByTagName("t").item(0).getTextContent());
					//System.out.println("H : " + pair.getElementsByTagName("h").item(0).getTextContent());
					thpair.H().setRawString(pair.getElementsByTagName("h").item(0).getTextContent());
					
					thPairs.addElement(thpair);
				}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
			return corpus;
	}

}
