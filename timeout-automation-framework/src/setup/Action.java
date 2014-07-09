package setup;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Action
{
	String filepath="configur/configme.xml";
  public String browser()
  {
	 
    String browser = null;
    try {
      File file = new File(filepath);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("Config");
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node fstNode = nodeLst.item(s);
        if (fstNode.getNodeType() != 1)
          continue;
        Element fstElmnt = (Element)fstNode;
        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("browser");
        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        NodeList fstNm = fstNmElmnt.getChildNodes();

        browser = fstNm.item(0).getNodeValue();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return browser;
  }
  
  
  public String[] browsers()
  {
    String browser = null;
    String country[] =null;
    try {
      File file = new File(filepath);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("Config");
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node fstNode = nodeLst.item(s);
        if (fstNode.getNodeType() != 1)
          continue;
        Element fstElmnt = (Element)fstNode;
        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("browser");
        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        NodeList fstNm = fstNmElmnt.getChildNodes();

        browser = fstNm.item(0).getNodeValue();
      }
      for(int i=0;i<browser.length();i++)
          country= browser.split(",");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return country;
  }
  
  
  
  
  
  public String[] domains()
  {
    String domain = null;
    String[] country=null;
    try {
      File file = new File(filepath);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("Config");
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node fstNode = nodeLst.item(s);
        if (fstNode.getNodeType() != 1)
          continue;
        Element fstElmnt = (Element)fstNode;
        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("domain");
        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        NodeList fstNm = fstNmElmnt.getChildNodes();

        domain = fstNm.item(0).getNodeValue();
      }
      for(int i=0;i<domain.length();i++)
      country= domain.split(",");
    }    
    catch (Exception e) {
      e.printStackTrace();
    }
    return country;
  }


  public String URL() {
    String URL = null;
    try {
      File file = new File(filepath);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("Config");
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node fstNode = nodeLst.item(s);
        if (fstNode.getNodeType() == 1) {
          Element fstElmnt = (Element)fstNode;
          NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("url");
          Element lstNmElmnt = (Element)lstNmElmntLst.item(0);
          NodeList lstNm = lstNmElmnt.getChildNodes();
          URL = lstNm.item(0).getNodeValue();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return URL;
  }
  
  public String release() {
	    String release = null;
	    try {
	      File file = new File(filepath);
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      Document doc = db.parse(file);
	      doc.getDocumentElement().normalize();
	      NodeList nodeLst = doc.getElementsByTagName("Config");
	      for (int s = 0; s < nodeLst.getLength(); s++) {
	        Node fstNode = nodeLst.item(s);
	        if (fstNode.getNodeType() == 1) {
	          Element fstElmnt = (Element)fstNode;
	          NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("release");
	          Element lstNmElmnt = (Element)lstNmElmntLst.item(0);
	          NodeList lstNm = lstNmElmnt.getChildNodes();
	          release = lstNm.item(0).getNodeValue();
	        }
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    return release;
	  }
  
  
  public String qabox() {
	    String URL = null;
	    try {
	      File file = new File(filepath);
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      Document doc = db.parse(file);
	      doc.getDocumentElement().normalize();
	      NodeList nodeLst = doc.getElementsByTagName("Config");
	      for (int s = 0; s < nodeLst.getLength(); s++) {
	        Node fstNode = nodeLst.item(s);
	        if (fstNode.getNodeType() == 1) {
	          Element fstElmnt = (Element)fstNode;
	          NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("qabox");
	          Element lstNmElmnt = (Element)lstNmElmntLst.item(0);
	          NodeList lstNm = lstNmElmnt.getChildNodes();
	          URL = lstNm.item(0).getNodeValue();
	        }
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    return URL;
	  }
  
  public String[] pages(String city)
  {
    String domain = null;
    String[] country=null;
    try {
      File file = new File(filepath);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      NodeList nodeLst = doc.getElementsByTagName("Config");
      for (int s = 0; s < nodeLst.getLength(); s++) {
        Node fstNode = nodeLst.item(s);
        if (fstNode.getNodeType() != 1)
          continue;
        Element fstElmnt = (Element)fstNode;
        if(city.equals("fr-paris")){
        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("pages_fr");
        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        NodeList fstNm = fstNmElmnt.getChildNodes();
        domain = fstNm.item(0).getNodeValue();}
        else if(city.equals("us-newyork")){
        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("pages_ny");
        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        NodeList fstNm = fstNmElmnt.getChildNodes();
        domain = fstNm.item(0).getNodeValue();}
        else if(city.equals("uk-london")){
            NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("pages_london");
            Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
            NodeList fstNm = fstNmElmnt.getChildNodes();
            domain = fstNm.item(0).getNodeValue();}
        else if(city.equals("us-losangeles")){
            NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("pages_la");
            Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
            NodeList fstNm = fstNmElmnt.getChildNodes();
            domain = fstNm.item(0).getNodeValue();}
        else if(city.equals("mx-df")){
            NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("pages_df");
            Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
            NodeList fstNm = fstNmElmnt.getChildNodes();
            domain = fstNm.item(0).getNodeValue();}
        //Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
        //NodeList fstNm = fstNmElmnt.getChildNodes();

        //domain = fstNm.item(0).getNodeValue();
      }
      for(int i=0;i<domain.length();i++)
      country= domain.split(",");
    }    
    catch (Exception e) {
      e.printStackTrace();
    }
    return country;
  }
  
  public void dbConnString(String testName) {
		Connection con = null;
	    Statement statement = null;  
		    try {	
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        con = DriverManager.getConnection("jdbc:mysql://"+qabox()+":3306/user","timeout","65dali32");
		        if(!con.isClosed())
		          System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
		        statement = con.createStatement();
		        if(testName.equalsIgnoreCase("ACL"))
		        statement.execute(" DELETE from user.security_users where username LIKE '%user_%'");
		        if(testName.equalsIgnoreCase("Fireplace")){
		        	statement.execute("DELETE from advertising.rules WHERE campaign_id in (select id from advertising.campaigns WHERE name LIKE '%Automated_%')");
   	                statement.execute("DELETE from advertising.campaigns WHERE name LIKE '%Automated_%'");}
		        if(testName.equalsIgnoreCase("Ad Units")){
		        	statement.execute("DELETE from advertising.rules WHERE campaign_id in (select id from advertising.campaigns WHERE name LIKE '%Automated_%')");
   	                statement.execute("DELETE from advertising.ad_unit_campaigns WHERE name LIKE '%Automated_%'");}
		      } catch(Exception e) {
		        System.err.println("Exception: " + e.getMessage());}
	}
  
}