package FunctionalTests;

import static junit.framework.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

@Test
public class Newsletter_FE
{
  public functions webDriver = new functions();
  public Action atn = new Action();

  
  @BeforeMethod
  public void setUp() throws Exception
  {
    this.webDriver.SeleniumSetup("chrome", "http://www.qa08.d/london/feature/1/affordable-drinking-in-london");
   
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
	this.webDriver.quit();
  }

  public void createNewsletterforLondon() throws InterruptedException {
	  String[] res = new String[40];
	  webDriver.waitForElementPresent("id", "sign-up-container");
	  String user="londonuser_"+webDriver.dateTime()+"@test.com" ;
	  webDriver.sendKeys("id", "signup_london", user);
	  //Thread.sleep(3000);
	  webDriver.waitForElementPresent("xpath", "//*[@id='sign-up-container']/div/div/form/fieldset/ol/li/input[3]");
	  webDriver.click("xpath", "//*[@id='sign-up-container']/div/div/form/fieldset/ol/li/input[3]");
	  Thread.sleep(5000);
	  webDriver.waitForElementPresent("xpath", "//*[@id='sign-up-container']/div/div/h4");
	  String txtuser=webDriver.getText("xpath", "//*[@id='sign-up-container']/div/div/h4");
	  assertEquals(txtuser, "Thank you");
	  webDriver.driver.navigate().to("https://login.emarsys.net");
	  webDriver.sendKeys("name", "company", "timeout");
	  webDriver.sendKeys("name", "username", "timeoutqa");
	  webDriver.sendKeys("name", "password", "outtime99");
	  webDriver.click("class", "submit");
	  String msg=webDriver.driver.getPageSource();
	  if(msg.contains("Already logged in."))
		  webDriver.click("linkText","Click here");
	  webDriver.waitForElementPresent("name", "niddle");
	  webDriver.sendKeys("name", "niddle", user);
	  webDriver.click("id", "a_search");
	  webDriver.click("xpath","//*[@id='mainLayer']/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[4]/a[1]/img");
	  webDriver.click("xpath","//*[@id='mainLayer']/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/table/tbody/tr/td[8]");
	  for(int i=0;i<40;i++){
	  String locator= "//*[@id='mainLayer']/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[3]/table/tbody/tr[2]/td/table/tbody/tr["+(i+1)+"]/td[2]/b";
	  String val=webDriver.getText("xpath",locator);
	  res[i]=val;
	  if (res[i]!=" ")
		  System.out.println(res[i]);}
	  /*System.out.println("lang_en:"+ res[0]);
	  System.out.println("lang_fr:"+ res[0]);
	  System.out.println("lang_es:"+ res[0]);
	  System.out.println("competitions_entered:"+ res[0]);
	  System.out.println("lang_en:"+ res[0]);
	  System.out.println("lang_en:"+ res[0]);*/
	  webDriver.captureScreenshot();
	  webDriver.sendKeys("name", "niddle", user);
	  webDriver.click("id", "a_search");
	  webDriver.click("xpath","//*[@id='mainLayer']/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[4]/a[2]/img");
	  webDriver.driver.switchTo().alert().accept();
	  webDriver.sendKeys("name", "niddle", user);
	  webDriver.click("id", "a_search");
	  String contact=webDriver.getText("xpath","//*[@id='mainLayer']/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td");
	  assertEquals(contact,"-- no contacts found --");
  }
  }