package testCases_CMS;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test(enabled=false,groups = {"Deprecated"})
public class Adunits_PushDown extends setup.testSetting
{
  public void createEventforGlobalPlatformDomains() throws InterruptedException {
	atn.dbConnString("Ad Units");
	webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
     for(int i=0;i<domain.length;i++){
    	webDriver.click("linkText", "Ad Units");
    	webDriver.click("linkText", "+ Add Ad Unit");
    	webDriver.sendKeys("id","ad_unit_name","automated_ad_pushdown"+webDriver.dateTime());
    	webDriver.selectValue("id", "ad_unit_ad_type", "pushdown");
    	webDriver.selectValue("id", "ad_unit_site",domain[i]);
    	//webDriver.sendKeys("id", "ad_unit_primary_language", "fr");
    	if (domain[i].equals("fr-paris")) 
    	webDriver.sendKeys("id", "ad_unit_primary_language","fr");
    	else if (domain[i].equals("us-newyork")||domain[i].equals("us-losangeles")||domain[i].equals("uk-london")||domain[i].equals("gh-accra"))
    	webDriver.sendKeys("id", "ad_unit_primary_language","en");
    	else webDriver.sendKeys("id","ad_unit_primary_language","es");
    	webDriver.driver.findElement(By.id("ad_unit_live_at")).clear();
    	webDriver.driver.findElement(By.id("ad_unit_expire_at")).clear();
    	webDriver.sendKeys("id","ad_unit_live_at",webDriver.fireplacedate());
    	webDriver.sendKeys("id","ad_unit_expire_at",webDriver.addfireplacedate());
    	webDriver.click("id", "ad_unit_active");
    	if(domain[i].equals("us-losangeles"))
    	webDriver.sendKeys("id", "ad_unit_rules_0_value","/los-angeles");
    	else
    	webDriver.sendKeys("id", "ad_unit_rules_0_value","/"+ domain[i].substring(3));
    	webDriver.click("id","form_submit");
    	double randNumber = Math.random();
        if(domain[i].equals("us-losangeles"))
        webDriver.driver.navigate().to("http://"+atn.qabox()+"/"+ "los-angeles" + "/search"+"?df"+ randNumber );
        webDriver.driver.navigate().to("http://"+atn.qabox()+"/"+ domain[i].substring(3) + "/search?"+"?df"+ randNumber );
        String source=webDriver.driver.getPageSource();
        if(source.contains("'http://ad.doubleclick.net/adi/'+dc_pushdown") && source.contains("sz=970x415"))
        System.out.println("PushDown Ad exists on Time Out page at " + domain[i]);
        webDriver.driver.navigate().to("http://admin."+atn.qabox());
        webDriver.CMSLogin_stage();
    	}}
  }
  