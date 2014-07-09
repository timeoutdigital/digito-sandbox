package liveSanity_Tests;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

public class NavigationBar_allSites {
	
	public functions webDriver = new functions();
	  public Action atn = new Action();

	  @BeforeMethod
	  public void setUp() throws Exception { this.webDriver.SeleniumSetup("chrome", "http://www.timeout.fr/paris"); }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    webDriver.quit();
	  }

	@Test
	public void verifyComments_addComment() throws InterruptedException {	
		Thread.sleep(2000);
		String[] ParisNav={"boire-manger","cinema"};
		String headertext;
		webDriver.click("id","boire-manger");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Boire & Manger", headertext);
		for(int i=1;i<4;i++){
		webDriver.mouseHover("//*[@id='boire-manger']/a");
		String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals(navtext, headertext);}
		webDriver.click("id","cinema");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Cinéma", headertext);
		webDriver.click("id","arts-scenes");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Arts & Scènes", headertext);
		for(int i=1;i<3;i++){
			webDriver.mouseHover("//*[@id='arts-scenes']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			if (headertext.equals("Théâtre et spectacles")){navtext="Théâtre et spectacles";}
			assertEquals(navtext, headertext);}
		webDriver.click("id","musique-soirees");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Musique & Soirées", headertext);
		for(int i=1;i<4;i++){
			webDriver.mouseHover("//*[@id='musique-soirees']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
		webDriver.click("id","loisirs-activities");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Loisirs & Activités",headertext);
		for(int i=1;i<4;i++){
			webDriver.mouseHover("//*[@id='loisirs-activities']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
		webDriver.click("id","shopping");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Shopping",headertext);
		webDriver.click("id","guide-de-paris");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Guide de Paris",headertext);
		for(int i=1;i<7;i++){
			webDriver.mouseHover("//*[@id='guide-de-paris']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			if (headertext.equals("Notre guide par quartiers")){navtext="Notre guide par quartiers";}
			assertEquals(navtext, headertext);}
		webDriver.click("id","le-blog");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Le blog",headertext);
		webDriver.click("linkText","English");
		webDriver.click("id","eating-drinking");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Eating & Drinking",headertext);
		for(int i=1;i<3;i++){
			webDriver.mouseHover("//*[@id='eating-drinking']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			assertEquals(navtext, headertext);}
		webDriver.click("id","film");
		headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Film",headertext);
		webDriver.click("id","arts-culture");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Art & Culture",headertext);
		webDriver.click("id","music-nightlife");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Music & Nightlife",headertext);
		webDriver.click("id","things-to-do");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Things to do",headertext);
		webDriver.click("id","shopping");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("Shopping",headertext);
		webDriver.click("id","city-guide");
		headertext=webDriver.getText("xpath","//*[@id='mainContent']/div/div[1]/h1");
		assertEquals("City guide",headertext);
		for(int i=1;i<8;i++){
			webDriver.mouseHover("//*[@id='city-guide']/a");
			String navtext=webDriver.getText("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			webDriver.click("xpath","//*[@id='navigationElements']/div/ul/li["+i+"]/a");
			headertext=webDriver.getText("xpath", "//*[@id='mainContent']/div/div[1]/h1");
			if (headertext.equals("Gay and lesbian")){navtext="Gay and lesbian";}
			assertEquals(navtext, headertext);}
	}}