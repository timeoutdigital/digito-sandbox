package liveSanity_Tests;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

public class NavigationBar_Mexico {
	
	public functions webDriver = new functions();
	  public Action atn = new Action();

	  @BeforeMethod
	  public void setUp() throws Exception { this.webDriver.SeleniumSetup("chrome", "http://www.timeoutmexico.mx/df"); }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    webDriver.quit();
	  }

	@Test
	public void verifyComments_addComment() throws InterruptedException {	
		Thread.sleep(2000);
		String[] ParisNav={"boire-manger","cinema"};
		String headertext;
		webDriver.click("id","comida-bebida");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Comida y bebida", headertext);
		for(int i=1;i<3;i++){
		webDriver.mouseHover("//*[@id='comida-bebida']/a");
		String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals(navtext,headertext);}
		webDriver.click("id","cine");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Cine", headertext);
		webDriver.click("id","arte-cultura");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Arte y cultura", headertext);
		webDriver.click("id","musica");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Música", headertext);
		webDriver.click("id","compras-estilo");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Compras y estilo",headertext);
		webDriver.click("id","guia-de-la-ciudad");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Guía de la ciudad",headertext);
		for(int i=1;i<3;i++){
			webDriver.mouseHover("//*[@id='guia-de-la-ciudad']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext,headertext);}
	}}