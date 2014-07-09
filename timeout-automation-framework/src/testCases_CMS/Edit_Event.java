package testCases_CMS;

import org.testng.annotations.Test;

public class Edit_Event extends setup.testSetting
{
 
@Test
  public void EditEventforGlobalPlatformDomains() throws InterruptedException { 
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String eventName=webDriver.createEvent(domain[i]);
    	System.out.println("Event Created:" + eventName );
    	webDriver.click("xpath", ".//*[@id='topNavigation']/ul/li[2]/a");
    	webDriver.sendKeys("id", "filter_name", eventName);
    	webDriver.click("xpath", ".//*[@id='form']/div[4]/button");
    	webDriver.click("linkText",eventName);
    	webDriver.sendKeys("id", "eventEdit_url", "http://www.barclays.co.uk");
    	webDriver.sendKeys("id", "eventEdit_ticket_url", "http://www.ticketmaster.co.uk");
    	webDriver.sendKeys("id", "eventEdit_telephone", "02033445566");
    	webDriver.selectValue("id","eventEdit_editorial_rating", "4");
    	webDriver.click("xpath",".//*[@id='eventEdit_provider']");
    	webDriver.sendKeys("id", "eventEdit_price", "50�");
    	webDriver.sendKeys("id", "eventEdit_author", "Shakespear");
    	webDriver.click("id","form_submit");
        webDriver.waitForElementPresent("xpath", "//*[contains(text(),'The event was saved successfully.')]");
    	//Assert.assertEquals("The event was saved successfully.",webDriver.getText("xpath", ".//*[@id='globalNotices']/div"));
    	if(domain[i].equals("fr-paris"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/paris/art/"+eventName);
    	    if(domain[i].equals("us-newyork"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/newyork/art/"+eventName);
    	    if(domain[i].equals("mx-df"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/df/arte-cultura/"+eventName);
    	    if(domain[i].equals("uk-london"))
    	    webDriver.driver.navigate().to("http://www."+atn.qabox()+"/london/art/"+eventName);
    	    if(domain[i].equals("us-losangeles"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/los-angeles/art/"+eventName);
    	    if(domain[i].equals("gh-accra"))
    	        webDriver.driver.navigate().to("http://www."+atn.qabox()+"/los-angeles/art/"+eventName);
    	    webDriver.driver.navigate().to("http://admin."+atn.qabox()); 
    	    webDriver.CMSLogin_stage();}
        }
  }
