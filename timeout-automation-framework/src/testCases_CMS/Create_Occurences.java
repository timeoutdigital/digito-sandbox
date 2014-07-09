package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Create_Occurences extends setup.testSetting
{
  public void createOccurrancesforGlobalPlatformDomains() throws InterruptedException {
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String VenueName= webDriver.createVenue(domain[i]);
    	String EventName= webDriver.createEvent(domain[i]);
    	System.out.println("Event Created:" + EventName );
    	webDriver.createOccurence(EventName,VenueName);
    	if(domain[i].equals("fr-paris"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/paris/art/"+VenueName);
    	    if(domain[i].equals("us-newyork"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/newyork/art/"+VenueName);
    	    if(domain[i].equals("mx-df"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/df/arte-cultura/"+VenueName);
    	    if(domain[i].equals("uk-london"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/london/art/"+VenueName);
    	    if(domain[i].equals("us-losangeles"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/los-angeles/art/"+VenueName);
    	    if(domain[i].equals("us-newyorkkids"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/new-york-kids/art/"+VenueName);
    	    if(domain[i].equals("gh-accra"))
        	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/accra/art/"+VenueName);
    	    webDriver.driver.navigate().to("http://admin."+atn.qabox()); 
    	    webDriver.CMSLogin_stage();}
	}
  }
