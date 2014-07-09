package testCases_Pagebuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CreateFeaturePage extends setup.testSetting
{  
  public void createEventforGlobalPlatformDomains() throws InterruptedException {
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
        String pageUrl = atn.qabox()+page;
    	System.out.println("Feature Page Created: " + pageUrl );
    	webDriver.driver.navigate().to(pageUrl);
        Assert.assertTrue(pageUrl.endsWith(webDriver.getText("tagName", "h1").trim().toLowerCase()));
        webDriver.driver.navigate().to("http://admin.pagebuilder."+atn.qabox());
    	webDriver.click("linkText","Page Builder");
    	}
     }
  }
