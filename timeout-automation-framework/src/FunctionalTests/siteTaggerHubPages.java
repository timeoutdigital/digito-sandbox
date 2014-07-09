package FunctionalTests;
import org.testng.annotations.Test;

@Test
public class siteTaggerHubPages extends setup.testSetting
{
  public void  siteTaggerverificationforGlobalPlatform() throws InterruptedException {
	webDriver.Login_pagebuilder();
	String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    if(domain[i].equals("fr-paris")){
    webDriver.click("linkText","Reset");
    webDriver.sendKeys("id", "pb_page_filters_title", "paris");
    webDriver.selectValue("id","pb_page_filters_segment", "paris");}
    if(domain[i].equals("us-newyork")){	
    	webDriver.click("linkText","Reset");
        webDriver.sendKeys("id", "pb_page_filters_title", "live");
        webDriver.selectValue("id","pb_page_filters_segment","newyork");}
    if(domain[i].equals("uk-london")){	
    	webDriver.click("linkText","Reset");
        webDriver.sendKeys("id", "pb_page_filters_title", "test");
        webDriver.selectValue("id","pb_page_filters_segment", "london");}
    if(domain[i].equals("mx-df")){
    	webDriver.click("linkText","Reset");
        webDriver.sendKeys("id", "pb_page_filters_title", "mexico");
        webDriver.selectValue("id","pb_page_filters_segment", "df");}
    if(domain[i].equals("us-losangeles")){
    	webDriver.click("linkText","Reset");
        webDriver.sendKeys("id", "pb_page_filters_title", "home");
        webDriver.selectValue("id","pb_page_filters_segment", "los-angeles");}
    webDriver.selectValue("id","pb_page_filters_type_id","2");
    webDriver.click("xpath", ".//*[@id='sf_admin_container']/div[1]/div/form/div[4]/input");
    webDriver.click("linkText", "Live");
    webDriver.click("xpath",".//*[@id='sf_admin_content']/div/table/tbody/tr[1]/td[3]/a");
    //webDriver.click("xpath",".//*[@id='main-content']/p/a");
    String url=webDriver.getText("xpath", "//*[@id='main-content']/p/a");
    webDriver.driver.navigate().to(url);
    String source=webDriver.driver.getPageSource();
	if(source.contains("tags.sitetagger.co.uk"))System.out.println("Site Tagger  exists on "+ domain[i]);
	else System.out.println("Site Tagger Doesn't exists on "+ domain[i]);
	webDriver.driver.navigate().to("http://admin.pagebuilder."+atn.qabox());
  	webDriver.click("linkText","Page Builder");  	
    }  	
    	
  }  	
    }