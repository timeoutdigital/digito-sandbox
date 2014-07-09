package FunctionalTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Action;
import setup.functions;

@Test
public class siteTagger_Pagebuilder_FeaturePages extends setup.testSetting
{
  public void  siteTaggerverificationforGlobalPlatform() throws InterruptedException {
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
   	if(domain[i].equals("fr-paris")) webDriver.driver.navigate().to("http://"+atn.qabox()+"/paris/"+page);
    if(domain[i].equals("us-newyork")) webDriver.driver.navigate().to("http://"+atn.qabox()+"/newyork/"+page);
    if(domain[i].equals("uk-london")) webDriver.driver.navigate().to("http://"+atn.qabox()+"/london/"+page);
    if(domain[i].equals("mx-df")) webDriver.driver.navigate().to("http://"+atn.qabox()+"/df/"+page);
    if(domain[i].equals("us-losangeles")) webDriver.driver.navigate().to("http://"+atn.qabox()+"/los-angeles/"+page);
	String source=webDriver.driver.getPageSource();
	if(source.contains("tags.sitetagger.co.uk"))System.out.println("Site Tagger exists on "+ domain[i]);
	else System.out.println("Site Tagger Doesn't exists on "+ domain[i]);
	webDriver.driver.navigate().to("http://admin.pagebuilder."+atn.qabox());
  	webDriver.click("linkText","Page Builder");
	  }
  }
  }