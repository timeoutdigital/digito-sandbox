package testCases_CMS;
import org.testng.annotations.Test;

@Test(enabled=false,groups = {"Deprecated"})
public class Create_Fireplace extends setup.testSetting
{  
  public void createFireplaceforGlobalPlatformDomains() throws InterruptedException {
	atn.dbConnString("Fireplace");
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    webDriver.createFireplace(domain[i]);
    boolean value=webDriver.verifyTextPresent("xpath","//div[@id='globalNotices']/div","The fireplace was created successfully.");
    System.out.println("Fireplace created Successfully : " + value);
    webDriver.targetRuleOrZone(domain[i],"");
    double randNumber = Math.random();
    if(domain[i].equals("us-losangeles")){
    webDriver.driver.navigate().to("http://"+atn.qabox()+ "/los-angeles" + "/search"+"?df"+ randNumber );}
    else if(domain[i].equals("us-newyorkkids")){
    	webDriver.driver.navigate().to("http://"+atn.qabox()+ "/new-york-kids" + "/search"+"?df"+ randNumber );}
    else{
    webDriver.driver.navigate().to("http://"+atn.qabox()+"/"+domain[i].substring(3) + "/search"+"?df"+ randNumber );}
    String source=webDriver.driver.getPageSource();
    boolean res=source.contains("mirko.jpg");
    System.out.println("Fireplace on Time Out page is " + res);
    res=source.contains("http://cineworld.co.uk");
    System.out.println("URL for fireplace is " + res);
    String url=webDriver.driver.getCurrentUrl();
    System.out.println("Fireplace URL is: " + url);
    webDriver.driver.navigate().to("http://admin."+atn.qabox());}
  }
}