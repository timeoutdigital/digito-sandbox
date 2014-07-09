package FunctionalTests;
import org.testng.annotations.Test;

public class verifyCommentsOnFeaturePages extends setup.testSetting 
{
  @Test
    public void verifyCommentsOnFeaturePages() throws InterruptedException {
	webDriver.Login_pagebuilder();
	String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
   	String page=webDriver.CreatePagebuilderPage(domain[i],"feature");
   	webDriver.selectValue("id", "page_builder_add_component_cid", "3");
    webDriver.selectValue("id", "page_builder_add_component_zid", "42");
    webDriver.click("class", "addComponentButton");
    webDriver.sendKeyswhy("xpath","//div[@class='pb-link']/span[1]/../input[1]","Feature"+domain[i]+webDriver.time());
    webDriver.sendKeyswhy("xpath","//ul[@id='zone_42']/li[contains(@class,'c-id-3')]/ul/li/label[text()='Text']/../textarea","Feature started today");
    // webDriver.clickwhy("xpath","//ul[@id='zone_43']/li[contains(@class,'c-id-45')]/ul/li/label[text()='Show agreement for partner affers']/../input");
    webDriver.click("id", "saveAndEditButton");
   	System.out.println("Feature Page Created:" + page );
   	if(domain[i].equals("fr-paris")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("us-newyork")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("uk-london")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("mx-df")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("us-losangeles")) webDriver.driver.navigate().to(page);
       
    webDriver.isElementPresent("xpath", ".//*[@id='mainContent']/div/h2");
    webDriver.isElementPresent("xpath", ".//*[@id='commentForm']/fieldset/ol/li[1]/label");
    webDriver.isElementPresent("id", "jsStarRating");
    webDriver.isElementPresent("xpath", ".//*[@id='commentForm']/fieldset/ol/li[2]/label");
    webDriver.isElementPresent("id", "userName");
    webDriver.isElementPresent("xpath", ".//*[@id='commentForm']/fieldset/ol/li[3]/label");
    webDriver.isElementPresent("id", "userEmail");
    webDriver.isElementPresent("xpath", ".//*[@id='commentForm']/fieldset/ol/li[4]/label");
    webDriver.isElementPresent("id", "text");
    webDriver.isElementPresent("xpath", ".//*[@id='commentForm']/fieldset/ol/li[5]/span[1]");
    webDriver.isElementPresent("id", "submit");
    
    webDriver.driver.navigate().to("http://admin.pagebuilder."+atn.qabox());
   	webDriver.click("linkText","Page Builder");}
  }
}