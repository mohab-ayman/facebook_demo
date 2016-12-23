package testData;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class xmlDataLoader {

	public Document doc;
	
	public xmlDataLoader(){
		
		try
		{
			File xmlFile = new File("src/testData/test_data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
		}
		catch (Exception ex)
		{
			System.out.println("Cannot Load test data file");
		}
	}
	
	public Object[][] getValidLoginData()
	{
		NodeList nList = doc.getElementsByTagName("user_data");
		Object [][] credentials = new Object [nList.getLength()][3];
		
		for (int i=0; i <nList.getLength(); i++)
		{
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				credentials[i][0] = eElement.getElementsByTagName("email").item(0).getTextContent();
				credentials[i][1] = eElement.getElementsByTagName("password").item(0).getTextContent();
				credentials[i][2] = eElement.getElementsByTagName("profile_name").item(0).getTextContent();
			}
		}
		
		return credentials;
	}
	
	
	public Object[][] getInvalidLoginData()
	{
		NodeList nList = doc.getElementsByTagName("invalid_user_data");
		Object [][] credentials = new Object [nList.getLength()][3];
		
		for (int i=0; i <nList.getLength(); i++)
		{
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				credentials[i][0] = eElement.getElementsByTagName("email").item(0).getTextContent();
				credentials[i][1] = eElement.getElementsByTagName("password").item(0).getTextContent();
				credentials[i][2] = eElement.getElementsByTagName("profile_name").item(0).getTextContent();
			}
		}
		
		return credentials;
	}
}
