package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Delete_Event extends setup.testSetting
{
  public void DeleteEventforGlobalPlatformDomains() throws InterruptedException {
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String deletedEvent=webDriver.deleteEVOF(domain[i],"event");
    	System.out.println("Event Deleted:" + deletedEvent );}}
  }
