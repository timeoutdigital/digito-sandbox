package setup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testSetting {
	
	public functions webDriver = new functions();
	public Action atn = new Action();  
	 
	  @BeforeMethod
	  public void setUp() throws Exception
	  {
		  String cname=this.getClass().getName();
		  if(cname.contains("ACL")||cname.contains("NewsLetter")||cname.contains("siteTagger")||cname.contains("FeaturePages")||cname.contains("MasterCard")||cname.contains("Offers"))
		  this.webDriver.SeleniumSetup(atn.browser(),"");
		  else if(cname.contains("cityConfiguration"))
		  this.webDriver.SeleniumSetup(atn.browser(),"http://"+atn.qabox()+"/london/search");
		  else webDriver.SeleniumSetup(atn.browser(),"http://admin."+atn.qabox());
		  System.out.println("Running Script:" + cname);
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    this.webDriver.quit();}
	
}

