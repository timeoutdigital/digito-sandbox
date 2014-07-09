package testCases_CMS;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Edit_Occurence extends setup.testSetting
{
  public void EditOccuranceforGlobalPlatformDomains() throws InterruptedException {  
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String VenueName= webDriver.createVenue(domain[i]);
    	String EventName= webDriver.createEvent(domain[i]);
    	System.out.println("Event Created:" + EventName );
    	webDriver.createOccurence(EventName,VenueName);
    	//System.out.println("Event Created:" + eventName );
    	webDriver.click("xpath", ".//*[@id='topNavigation']/ul/li[2]/a");
    	webDriver.sendKeys("id", "filter_name", EventName);
    	webDriver.click("xpath", ".//*[@id='form']/div[4]/button");
    	webDriver.click("xpath",".//*[@id='column1']/table/tbody/tr[2]/td/a");
    	webDriver.click("linkText", "Occurrences");
    	webDriver.click("linkText", EventName);
    	webDriver.sendKeys("id", "occurrenceEdit_start_time_hour", "20");
    	webDriver.sendKeys("id", "occurrenceEdit_start_time_minute", "30");
    	webDriver.sendKeys("id", "occurrenceEdit_end_time_hour", "22");
    	webDriver.sendKeys("id", "occurrenceEdit_end_time_minute", "30");
    	webDriver.click("id","form_submit");
    	Assert.assertEquals("The occurrence was saved successfully.",webDriver.getText("xpath", ".//*[@id='globalNotices']/div"));    	
        } 
	  }
  }
