package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Delete_Venue extends setup.testSetting{
  public void DeleteVenuesforGlobalPlatformDomains() throws InterruptedException {  
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String deletedVenue=webDriver.deleteEVOF(domain[i],"venue");
    	System.out.println("Venue Deleted:" + deletedVenue );}
	}}
