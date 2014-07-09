package liveSanity_Tests;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

public class Search_AllSites {
	
	public functions webDriver = new functions();
	  public Action atn = new Action();

	  @BeforeMethod
	  public void setUp() throws Exception { this.webDriver.SeleniumSetup("chrome", "http://www.timeout.com/newyork"); }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    webDriver.quit();
	  }

	@Test
	public void verifyComments_addComment() throws InterruptedException {	
		
		webDriver.click("xpath","//*[@id='mainContent']/div/form/fieldset[1]/input");
		Thread.sleep(2000);
		webDriver.click("xpath","//*[@id='panel']/div[3]/div[1]/div/ul/li[2]/a");
		Thread.sleep(3000);
		webDriver.click("xpath","//html/body/div/div[3]/div/div[2]/div/div/div/h2/a");
		webDriver.click("xpath","//*[@id='bookingHeader']/a");
		
	}}