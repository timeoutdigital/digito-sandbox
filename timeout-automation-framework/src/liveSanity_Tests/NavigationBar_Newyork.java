package liveSanity_Tests;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

public class NavigationBar_Newyork {
	
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
		Thread.sleep(2000);
		String[] ParisNav={"boire-manger","cinema"};
		String headertext;
		webDriver.click("xpath","//*[@id='mainContent']/div/form/fieldset[1]/input");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Things to Do", headertext);
		for(int i=1;i<4;i++){
		webDriver.mouseHover("//*[@id='things-to-do']/a");
		String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals(navtext,headertext);}
		webDriver.click("id","food-drink");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Food & Drink", headertext);
		for(int i=1;i<3;i++){
			webDriver.mouseHover("//*[@id='food-drink']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
		webDriver.click("id","arts-culture");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Arts & Culture", headertext);
		for(int i=1;i<2;i++){
			webDriver.mouseHover("//*[@id='arts-culture']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
		webDriver.click("id","film");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Film", headertext);
		webDriver.click("id","music-nightlife");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Music & Nightlife", headertext);
		webDriver.click("id","shopping-style");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Shopping & Style",headertext);
		webDriver.click("id","city-guide");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("City Guide",headertext);
		for(int i=1;i<3;i++){
			webDriver.mouseHover("//*[@id='city-guide']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
	}}