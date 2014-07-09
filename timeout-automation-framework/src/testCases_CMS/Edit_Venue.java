package testCases_CMS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Edit_Venue extends setup.testSetting
{
  
@Test
  public void EditVenueforGlobalPlatformDomains() throws InterruptedException  {
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String venueName=webDriver.createVenue(domain[i]);
    	System.out.println("Event Created:" + venueName );
    	webDriver.click("xpath", ".//*[@id='topNavigation']/ul/li[1]/a");
    	webDriver.sendKeys("id", "filter_name", venueName);
    	webDriver.click("xpath", ".//*[@id='form']/div[4]/button");
    	webDriver.click("xpath",".//*[@id='column1']/table/tbody/tr[2]/td[2]/a");
    	webDriver.sendKeys("id", "venueEdit_building_no", "450");
    	webDriver.sendKeys("id", "venueEdit_building_name", "updated_buildingName");
    	webDriver.sendKeys("id", "venueEdit_address1", "updated_address1");
    	webDriver.sendKeys("id", "venueEdit_cross_street", "updated_crossStreet");
    	webDriver.sendKeys("id", "venueEdit_address2", "updated_address2");
    	webDriver.sendKeys("id", "venueEdit_county", domain[i]);
    	webDriver.click("xpath",".//*[@id='venueEdit_provider']");
    	webDriver.sendKeys("id", "venueEdit_author", "Shakespear");
    	webDriver.selectValue("id","venueEdit_editorial_rating", "4");
    	webDriver.click("id","form_submit");
    	Assert.assertEquals("The venue was saved successfully.",webDriver.getText("xpath", ".//*[@id='globalNotices']/div"));   	
        }
	  }
  }
