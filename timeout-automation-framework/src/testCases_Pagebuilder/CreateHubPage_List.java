package testCases_Pagebuilder;
import org.testng.annotations.Test;

@Test(enabled=false,groups = {"Deprecated"})
public class CreateHubPage_List extends setup.testSetting
{  
  public void CreateSuperListHubPagesforGlobalPlatformDomains() throws InterruptedException {
	 webDriver.CMSLogin_stage();
	 String[] domain=atn.domains();
     for(int i=0;i<domain.length;i++){
     String superlist=webDriver.createSuperlist(domain[i]);
     webDriver.Login_pagebuilder();
     String page=webDriver.CreatePagebuilderPage(domain[i],"feature");
     webDriver.selectValue("id", "page_builder_add_component_cid", "37");
     webDriver.selectValue("id", "page_builder_add_component_zid", "42");
     webDriver.click("class", "addComponentButton");
     webDriver.sendKeyswhy("xpath","//div[@class='pb-link']/span[1]/../input[1]","Feature"+domain[i]+webDriver.time());
     webDriver.sendKeyswhy("xpath","//input[@class='sl-search ac_input']",superlist);
     Thread.sleep(2000);
     webDriver.click("xpath","/html/body/div[9]/ul/li/strong");
     webDriver.click("id", "saveAndEditButton");
     System.out.println("Feature Page Created:" + page );
     if(domain[i].equals("fr-paris")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("us-newyork")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("uk-london")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("mx-df")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("us-losangeles")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("us-newyorkkids")) webDriver.driver.navigate().to(page);
     if(domain[i].equals("gh-accra")) webDriver.driver.navigate().to(page);
     webDriver.driver.navigate().to("http://admin."+atn.qabox());
     webDriver.CMSLogin_stage();
     //webDriver.click("linkText","Page Builder");
     }
   }
 }
