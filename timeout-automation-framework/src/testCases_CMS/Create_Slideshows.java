package testCases_CMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;

@Test
public class Create_Slideshows extends setup.testSetting
{
  public void createslideshowsforGlobalPlatformDomains() throws InterruptedException {
try {
	String[] domain=atn.domains();
	for(int i=0;i<domain.length;i++){
	String a=null;
	Connection con = null;
	Statement statement = null;//some sql work is remained will be tidy up then
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://"+atn.qabox()+":3306/slideshow","timeout","65dali32");
	if(!con.isClosed())
	System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");      
	statement = con.createStatement();
	String source=webDriver.driver.getPageSource();
	if(source.contains("submit")){
    webDriver.CMSLogin_stage();}
    String slideName=webDriver.CreateSlideshows(domain[i],5);
    String query="select * from slideshow where title='"+ slideName +"'";
    ResultSet rs =statement.executeQuery(query);
    while (rs.next())
    a= rs.getString("id");
    System.out.println(a);
    webDriver.Login_pagebuilder();
    String page=webDriver.CreatePagebuilderPage(domain[i],"feature");
	webDriver.selectValue("id", "page_builder_add_component_cid", "47");
    webDriver.selectValue("id", "page_builder_add_component_zid", "42");
    webDriver.click("class", "addComponentButton");
    webDriver.sendKeyswhy("xpath","//ul[@id='zone_42']/li[contains(@class,'c-id-47')]/ul/li/label[text()='Slideshow ID']/../input",a);
    webDriver.click("id", "saveAndEditButton");
	System.out.println("Feature Page Created:" + page );
	if(domain[i].equals("fr-paris")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("us-newyork")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("uk-london")) webDriver.driver.navigate().to(page+"?"+Math.random());
    if(domain[i].equals("mx-df")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("us-losangeles")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("us-newyorkkids")) webDriver.driver.navigate().to(page);
    if(domain[i].equals("gh-accra")) webDriver.driver.navigate().to(page);
    for(int k=1;k<6;k++){
    //WebElement myElement =webDriver.driver.findElement(By.xpath(".//*[@id='mainContent']/div/div[2]/div[1]/ul/li[2]/a"));
   	//Actions builder = new Actions(webDriver.driver);
   	//builder.moveToElement(myElement).build().perform();
    //webDriver.click("xpath",".//*[@id='mainContent']/div/div[2]/div[1]/ul/li[2]/a");
    //webDriver.isElementPresent("xpath", ".//*[@id='mainContent']/div/div[3]/h4");
    webDriver.isElementPresent("xpath", "//div[@id='mainContent']/div/div[2]/div[2]/div/ul/li["+k+"]");}
    //webDriver.isElementPresent("xpath", "//*[@id='mainContent']/div/div[2]/div[2]");
    //div[@id='mainContent']/div/div[2]/div[2]/div/ul/li[2]
    webDriver.driver.navigate().to("http://admin."+atn.qabox());
    }}
    catch(Exception e) {
	System.err.println("Exception: " + e.getMessage());}
	  }
  }
