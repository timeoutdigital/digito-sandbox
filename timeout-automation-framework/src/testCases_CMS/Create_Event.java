package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Create_Event extends setup.testSetting
{
  public void createEventforGlobalPlatformDomains() throws InterruptedException {
	webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
     for(int i=0;i<domain.length;i++){
    	String EventName=webDriver.createEvent(domain[i]);
    	System.out.println("Event Created:" + EventName );
    	if(domain[i].equals("fr-paris"))
    	webDriver.driver.navigate().to("http://www."+atn.qabox()+"/paris/art/"+EventName);
    	 if(domain[i].equals("us-newyork"))
    	 webDriver.driver.navigate().to("http://www."+atn.qabox()+"/newyork/art/"+EventName);
    	 if(domain[i].equals("mx-df"))
    	 webDriver.driver.navigate().to("http://www."+atn.qabox()+"/df/arte-cultura/"+EventName);
    	 if(domain[i].equals("uk-london"))
    	 webDriver.driver.navigate().to("http://www."+atn.qabox()+"/london/art/"+EventName);
    	 if(domain[i].equals("us-losangeles"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/los-angeles/art/"+EventName);
    	    if(domain[i].equals("us-newyorkkids"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/new-york-kids/art/"+EventName);
    	    if(domain[i].equals("gh-accra"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/accra/art/"+EventName);
    	    if(domain[i].equals("barcelona-ca"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/ca/art/"+EventName);
    	    if(domain[i].equals("barcelona-es"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/es/arte/"+EventName);
    	        if(domain[i].equals("barcelona-en"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/art/"+EventName);
    	    webDriver.driver.navigate().to("http://admin."+atn.qabox()); 
 //   	    webDriver.CMSLogin_stage();
    	    }
     }
  }
