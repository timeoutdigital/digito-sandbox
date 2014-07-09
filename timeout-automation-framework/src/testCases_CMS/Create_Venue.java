package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Create_Venue extends setup.testSetting
{
   public void createVenuesforGlobalPlatformDomains() throws InterruptedException {  
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    String venueName=webDriver.createVenue(domain[i]);
    System.out.println("Venue Created:" + venueName );
    if(domain[i].equals("fr-paris"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/paris/art/"+venueName);
    webDriver.captureScreenshot();
    if(domain[i].equals("us-newyork"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/newyork/art/"+venueName);
    if(domain[i].equals("mx-df"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/df/arte-cultura/"+venueName);
    if(domain[i].equals("uk-london"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/london/art/"+venueName);
    webDriver.captureScreenshot();
    if(domain[i].equals("us-losangeles"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/los-angeles/art/"+venueName);
    if(domain[i].equals("us-newyorkkids"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/new-york-kids/art/"+venueName);
    if(domain[i].equals("gh-accra"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/accra/art/"+venueName);
    if(domain[i].equals("barcelona-ca"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/ca/art/"+venueName);
    if(domain[i].equals("barcelona-es"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/es/arte/"+venueName);
    if(domain[i].equals("barcelona-en"))
    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/barcelona/art/"+venueName);
    webDriver.driver.navigate().to("http://admin."+atn.qabox()); 
    webDriver.CMSLogin_stage();} 
	}
  }
