package testCases_CMS;
import org.testng.annotations.Test;
public class Translate_Event extends setup.testSetting
{
@Test
  public void TranslateEventforGlobalPlatformDomains() throws InterruptedException { 
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String eventName=webDriver.createEvent(domain[i]);
    	System.out.println("Event Created:" + eventName );
    	webDriver.translateVenue(eventName);
        }
	  }
  }
