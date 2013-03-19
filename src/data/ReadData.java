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
import java.io.File;

/**
 * @author shivhare
 *
 */
public class ReadData {
	
	private final String devFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	private final String testFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	private final String goldFile = "./RTE3-DEV-FINAL/RTE3_pairs_dev-set-final.xml";
	
	public enum fileType {dev, test, gold};

	/**
	 * @param args
	 */
	public void LoadDev(fileType type){
		// TODO Auto-generated method stub
		
		String path = "";
		
		switch (type) {
			case dev:
				path = devFile;
				break;
				
			case test:
				path = testFile;
				
			case gold:
				path = goldFile;
		}
		
		try {
			 
				File fXmlFile = new File(path);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				NodeList pairs = doc.getElementsByTagName("pair");
				
				for (int i = 0; i < pairs.getLength(); i++) {
					Node p = pairs.item(i);
					Element pair = (Element) p;
					
					System.out.println("\nID  :" + pair.getAttribute("id"));
					System.out.println("\nResult  :" + pair.getAttribute("entailment"));
					
					System.out.println("T : " + pair.getElementsByTagName("t").item(0).getTextContent());
					System.out.println("H : " + pair.getElementsByTagName("h").item(0).getTextContent());
				}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }

	}

}
