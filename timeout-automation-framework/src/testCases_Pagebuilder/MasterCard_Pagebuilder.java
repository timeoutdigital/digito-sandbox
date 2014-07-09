package testCases_Pagebuilder;
import org.testng.annotations.Test;

@Test(enabled=false,groups = {"Deprecated"})
public class MasterCard_Pagebuilder extends setup.testSetting {
 public void VerifyMasterCard() throws InterruptedException {
  webDriver.Login_pagebuilder();
  //String[] domain=atn.domains();
 // for(int i=0;i<domain.length;i++){
  //String page=webDriver.CreatePagebuilderPage(domain[i],"feature");
  String page=webDriver.CreatePagebuilderPage("uk-london","feature");
  webDriver.selectValue("id", "page_builder_add_component_cid", "71");
  webDriver.selectValue("id", "page_builder_add_component_zid", "43");
  webDriver.click("class", "addComponentButton");
  webDriver.click("id", "saveAndEditButton");
  System.out.println("Feature Page Created:" + page );
 // if(domain[i].equals("fr-paris")) webDriver.driver.navigate().to("http://"+atn.qabox()+".d/paris/"+page);
  //if(domain[i].equals("us-newyork")) webDriver.driver.navigate().to("http://"+atn.qabox()+".d/newyork/"+page);
  //if(domain[i].equals("uk-london"))
  //webDriver.driver.navigate().to("http://www."+atn.qabox()+".d/london/"+page+"?"+Math.random());
  //if(domain[i].equals("mx-df")) webDriver.driver.navigate().to("http://"+atn.qabox()+".d/df/"+page);
  //if(domain[i].equals("us-losangeles")) webDriver.driver.navigate().to("http://"+atn.qabox()+".d/los-angeles/"+page);
  //webDriver.driver.navigate().to("http://admin.pagebuilder."+atn.qabox()+".d");
  webDriver.driver.navigate().to("http://www."+atn.qabox()+"/london/"+page+"?"+Math.random());
  webDriver.isElementPresent("xpath", "//*[@id='experience']/div[2]");
  webDriver.getElementProperties("xpath", "//*[@id='experience']/div[2]");
//}
 }
}