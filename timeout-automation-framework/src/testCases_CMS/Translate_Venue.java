package testCases_CMS;
import org.testng.annotations.Test;

public class Translate_Venue extends setup.testSetting
{
@Test
  public void TranslateVenueforGlobalPlatformDomains() throws InterruptedException {
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){	
    	String venueName=webDriver.createVenue(domain[i]);
    	System.out.println("Venue Created:" + venueName );
    	webDriver.translateVenue(venueName);
        }}
  }
