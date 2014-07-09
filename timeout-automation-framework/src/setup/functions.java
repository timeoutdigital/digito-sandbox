package setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;*/

public class functions extends seleniumSession
{
  Logger log = new Logger(functions.class);
  Action atn = new Action();
  
  //CustomReporter report = new CustomReporter(this.atn.browser());

  protected By getLocator(String locatorType, String selector) {
    if (locatorType.equals("xpath"))
      return By.xpath(selector);
    if (locatorType.equals("class"))
      return By.className(selector);
    if (locatorType.equals("css"))
      return By.cssSelector(selector);
    if (locatorType.equals("id"))
      return By.id(selector);
    if (locatorType.equals("linkText"))
      return By.linkText(selector);
    if (locatorType.equals("name"))
      return By.name(selector);
    if (locatorType.equals("partialLinkText"))
      return By.partialLinkText(selector);
    if (locatorType.equals("tagName"))
      return By.tagName(selector);
    return null;
  }

  public void sendKeys(String locatorType, String locator, String value) 
  {
    try{By newLocator = getLocator(locatorType, locator);
        this.driver.findElement(newLocator).clear();
    this.driver.findElement(newLocator).sendKeys(new CharSequence[] { value });
    this.log.info("Value Entered is :" + value);}
    catch (NoSuchElementException e){
    log.info("Element not found:"+locator);
    captureScreenshot();}
  }
  
  public void sendKeyswhy(String locatorType, String locator, String value) throws InterruptedException 
  {
	Thread.sleep(3000);
    By newLocator = getLocator(locatorType, locator);
    Thread.sleep(3000);
    this.driver.findElement(newLocator).sendKeys(new CharSequence[] { value });
    Thread.sleep(3000);
    this.log.info("Value Entered is :" + value);
  }

  public void clickwhy(String locatorType, String locator) throws InterruptedException
  {
	Thread.sleep(3000);
    By newLocator = getLocator(locatorType, locator);
    Thread.sleep(3000);
    this.driver.findElement(newLocator).click(); 
  }
   
  public void click(String locatorType, String locator)
  {
    try{By newLocator = getLocator(locatorType, locator);
    this.driver.findElement(newLocator).click();}
    catch (NoSuchElementException e){
    log.info("Element not found:"+locator);
    captureScreenshot();}
  }

  public void quit()
  {
    this.driver.quit();
    this.log.info("WebDriver Ended the Test....");
    //this.log.info("Screenshots for this test can be found in C:\\screenshots_" + date() + " folder");
  }

  public void waitForElementPresent(String locatorType, String locator) {
   boolean checkForElement = false;
   while (!checkForElement)
   try {
      this.driver.findElement(getLocator(locatorType, locator));
      checkForElement = true;
      this.log.info("Element present : " + locator);
      }
   catch (NotFoundException e) {
   this.log.info("Element not present...try again");
        //this.report.addResult("Fail");
      }
  }

  public void isElementPresent(String locatorType, String locator)
  {
    try{By newLocator = getLocator(locatorType, locator);
    boolean value=this.driver.findElement(newLocator).isDisplayed();
    String elementName=driver.findElement(newLocator).getText();
    if (value==true)
    System.out.println("Element exists:" + locator + ":" + elementName);
    else
    System.out.println("Element Doesn't exists:" + locator + ":" + elementName);}
    catch (NoSuchElementException e){
    log.info("Element not found:"+locator);
    captureScreenshot();}
    //return value;
  }

  public String getText(String locatorType, String locator) 
  {
    try{
    By newLocator = getLocator(locatorType, locator);
    String text = this.driver.findElement(newLocator).getText();
    //this.log.info("Value got is :" +text);
    return text;}
    catch (NoSuchElementException e){
    log.info("Element not found:"+locator);
    captureScreenshot();}
    return null;
    }
  
  public void captureScreenshot()
  {
    try {
      String date = date();
      String time = time();
      File scrFile = (File)((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("c:\\screenshots_" + date + "\\" + "screenshot_" + time + ".png"));
      this.log.info("Screenshot captured");
      this.log.info("Error Screenshots for this test can be found in C:\\screenshots_" + date() + " folder");
    }
    catch (Exception e){
      this.log.info("Screenshot not captured");}
  }

  public void getElementProperties(String locatorType, String locator)
  {
    By newLocator = getLocator(locatorType, locator);
    String fontsize=this.driver.findElement(newLocator).getCssValue("font-size");
    System.out.println("Font Size is :"+ fontsize);
    String fontfamily=this.driver.findElement(newLocator).getCssValue("font-family");
    System.out.println("Font name is :"+ fontfamily);
    String fontcolor=this.driver.findElement(newLocator).getCssValue("color");
    System.out.println("Font color is :"+ fontcolor);
   }

   public String getElementAttribute(String locatorType, String locator, String attribute)
   {
       return this.driver.findElement(getLocator(locatorType, locator)).getAttribute(attribute);
   }


  public void selectValue(String locatorType, String locator, String value)
  {
	try{Select select = new Select(this.driver.findElement(getLocator(locatorType, locator)));
    select.selectByValue(value);
    this.log.info("Value selected is :" + value);}
	catch (NoSuchElementException e){
	log.info("Element not found:"+locator);
    captureScreenshot();}
  }
  
  public void selectValueWhy(String locatorType, String locator, String value) throws InterruptedException
  {
    Select select = new Select(this.driver.findElement(getLocator(locatorType, locator)));
    Thread.sleep(3000);
    select.selectByValue(value);
    Thread.sleep(2000);
    this.log.info("Value selected is :" + value);
  }

  public String time()
  {
    DateFormat dateFormat = new SimpleDateFormat("HHmmss");
    Date date = new Date();
    return dateFormat.format(date);
  }

  public String date()
  {
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
    Date date = new Date();
    return dateFormat.format(date);
  }
   
  public String fireplacedate()
  {
    DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
    Date date = new Date();
    return dateFormat.format(date);
  }
  
  public String addfireplacedate()
  {
    DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 1);	//Adding 1 day to current date
    String newdate = dateFormat.format(cal.getTime());
    return newdate;
  }

  public String dateTime()
  {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
    Date date = new Date();
    this.log.info("Event Created : " + dateFormat.format(date));
    return dateFormat.format(date);
  }

  public void Email() throws InterruptedException
  {  
	//File oldFile = new File("C:\\workspace\\TimeOut_Automation_Framework\\test-output\\emailable-report.html");
	//oldFile.renameTo(new File("C:\\workspace\\TimeOut_Automation_Framework\\test-output\\emailable-report.html"+dateTime()));
	File sourceFile = new File("test-output\\emailable-report.html");
    Properties properties = System.getProperties();
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getDefaultInstance(properties, 
    new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("timeout.automation@gmail.com","automation485");}});
    MimeMessage message = new MimeMessage(session);
    try
    {
      message.setFrom(new InternetAddress("vamshimuniganti@timeout.com"));
      message.addRecipient(Message.RecipientType.TO, 
        new InternetAddress("vamshimuniganti@timeout.com"));
    //  message.addRecipient(Message.RecipientType.TO, 
    	//    new InternetAddress("ashleykitson@timeout.com"));
      message.addRecipient(Message.RecipientType.TO, 
  	        new InternetAddress("paulharman@timeout.com"));
      message.addRecipient(Message.RecipientType.TO, 
    	        new InternetAddress("poojababurajan@timeout.com"));
     // message.addRecipient(Message.RecipientType.TO, 
  	   //     new InternetAddress("llewellynthomas@timeout.com"));
     // message.addRecipient(Message.RecipientType.TO, 
    	   //    new InternetAddress("abriamisekar@timeout.com"));
     // message.addRecipient(Message.RecipientType.TO, 
  	   //     new InternetAddress("martinhearn@timeout.com"));
      //message.addRecipient(Message.RecipientType.TO, 
        //   new InternetAddress("grahamralls@timeout.com"));
      //message.addRecipient(Message.RecipientType.TO, 
        //    new InternetAddress("peterholley@timeout.com"));
      message.addRecipient(Message.RecipientType.TO, 
    	      new InternetAddress("raghavendrakonyala@timeout.com"));
      message.addRecipient(Message.RecipientType.TO, 
   	       new InternetAddress("gurpinderdhaliwal@timeout.com"));

      //message.setSubject("TimeOut_Automation_Framework_Release_"+atn.release()+"_Results_"+dateTime());
      message.setSubject("TimeOut_Automation_Framework_ACCRA_Results_"+dateTime());
      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText("Open the attachment to view the Report " + "\n\nCOMMENTS:ACCRA Results for CMS and PB,all tests Passed in regression tests ");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      messageBodyPart = new MimeBodyPart();
      //String filename = "C:\\email.html";
      DataSource source = new FileDataSource(sourceFile);
      messageBodyPart.setDataHandler(new DataHandler(source));
      //messageBodyPart.setFileName(filename);
      messageBodyPart.setFileName("TimeOut_Automation_Report_"+dateTime()+".html");
      multipart.addBodyPart(messageBodyPart);
      message.setContent(multipart);
      Transport.send(message);
      System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
       mex.printStackTrace();
    }
  }


  public String createVenue(String country) throws InterruptedException
  {
	String venTime = time();
    waitForElementPresent("linkText", "Venues");
    click("linkText", "Venues");
    waitForElementPresent("xpath", "/html/body/div/div[3]/h1/a");
    click("xpath", "/html/body/div/div[3]/h1/a");
    waitForElementPresent("id", "venueCreate_name");
    String venueName= "Venue" + country + venTime;
    sendKeys("id", "venueCreate_name", venueName);
    waitForElementPresent("id", "venueCreate_language");
    if(country.equals("fr-paris")){
    selectValue("id", "venueCreate_language", "fr");
    sendKeys("id", "venueCreate_city", "Paris");}
    else if (country.equals("us-newyork")||country.equals("us-newyorkkids")){
    selectValue("id", "venueCreate_language", "en_US");
    sendKeys("id", "venueCreate_city", "NewYork");}
    else if (country.equals("us-losangeles")){
    selectValue("id", "venueCreate_language", "en_US");
    sendKeys("id", "venueCreate_city", "Los Angeles");}
    else if (country.equals("uk-london"))
    {selectValue("id", "venueCreate_language", "en_GB");
    sendKeys("id", "venueCreate_city", "London");}
    else if (country.equals("barcelona-es"))
    {selectValue("id", "venueCreate_language", "es_ES");
    sendKeys("id", "venueCreate_city", "Barcelona");}
    else if (country.equals("barcelona-ca"))
    {selectValue("id", "venueCreate_language", "ca");
    sendKeys("id", "venueCreate_city", "Barcelona");}
    else if (country.equals("barcelona-en"))
    {selectValue("id", "venueCreate_language", "en_GB");
    sendKeys("id", "venueCreate_city", "Barcelona");}
    else if (country.equals("gh-accra"))
    {selectValue("id", "venueCreate_language", "en_GH");
    sendKeys("id", "venueCreate_city", "gh-accra");}
    else {selectValue("id", "venueCreate_language", "es_419");
    sendKeys("id", "venueCreate_city", "Mexico");}
    waitForElementPresent("id", "venueCreate_site");
    if(country.equals("fr-paris"))selectValue("id", "venueCreate_site", "fr-paris");
    else if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
    selectValue("id", "venueCreate_site", "es-barcelona");
    else selectValue("id", "venueCreate_site", country);
    click("id", "form_submit");
    waitForElementPresent("id", "globalNotices");
    sendKeys("id", "venueEdit_building_no", "test_building_1");
    sendKeys("id", "venueEdit_building_name", "test_building"); 
    geocodes(country);
    sendKeys("id","venueEdit_ticket_url","http://www.barclays.co.uk");
   // selectValue("id", "venueEdit_status", "complete");
    click("id", "form_submit");
    click("xpath", ".//*[@id='column2']/ul/li[6]/a");
    selectValue("xpath","//*[@id='bonsai-img-tab-search']/div[1]/form/select[2]",country);
    click("id","bonsai-img-tab-search-button");
    Thread.sleep(3000);
    click("xpath",".//*[@id='bonsai-img-tab-search-list']/li[1]/div[3]/button[2]");
    click("id","bonsai-img-attachments-save");
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    click("id","bonsai-img-dialog-cancel");
    click("id", "form_submit");
        //click("id", "form_submit");
    click("xpath","//*[@id='column2']/ul/li[2]/a");
    Thread.sleep(2000);
    
    if(country.equals("fr-paris"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[6]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[6]/ul/li[3]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[6]/ul/li[3]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("mx-df"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[6]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[6]/ul/li[1]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[6]/ul/li[1]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("barcelona-ca"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[2]/div");
    doubleclick("//*[@id='tagger_1']/div[1]/ul/li[2]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[2]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("barcelona-es"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//*[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[3]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//*[@id='tagger_1']/div[2]/ul/li[3]/ul/li[2]/span","//*[@id='primaryTag']/span");}
    click("xpath","//*[@id='tagger_instance1']/button");
    click("linkText","Edit Venue");
    selectValue("id", "venueEdit_status", "complete");
    click("id", "form_submit");
    return venueName;
  }

  public String createEvent(String country) throws InterruptedException
  {
	String eveTime = time();
	String date = fireplacedate();
	String adddate= addfireplacedate();
    waitForElementPresent("linkText", "Events");
    click("linkText", "Events");
    waitForElementPresent("xpath", "/html/body/div/div[3]/h1/a");
    click("xpath", "/html/body/div/div[3]/h1/a");
    waitForElementPresent("id", "eventCreate_name");
    String eventName= "Event" + country + eveTime;
    sendKeys("id", "eventCreate_name", eventName);
    waitForElementPresent("id", "eventCreate_language");
    if(country.equals("fr-paris"))
    selectValue("id", "eventCreate_language", "fr");
    else if (country.equals("us-newyork")||country.equals("us-losangeles")|| country.equals("us-newyorkkids"))
    selectValue("id", "eventCreate_language", "en_US");
    else if (country.equals("barcelona-es"))
    selectValue("id", "eventCreate_language","es_ES");
    else if (country.equals("barcelona-ca"))
    selectValue("id", "eventCreate_language","ca");
    else if (country.equals("barcelona-en"))
    selectValue("id", "eventCreate_language","en_GB");
    else if (country.equals("uk-london"))
    selectValue("id", "eventCreate_language","en_GB");
    else if (country.equals("gh-accra"))
    selectValue("id", "eventCreate_language","en_GH");
    else selectValue("id", "eventCreate_language","es_419");
    waitForElementPresent("id", "eventCreate_site");
    if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
    selectValue("id", "eventCreate_site", "es-barcelona");
    else selectValue("id", "eventCreate_site", country);
    click("id", "form_submit");
    waitForElementPresent("id", "eventEdit_start_date");
    sendKeys("id", "eventEdit_start_date", date);
    sendKeys("id", "eventEdit_end_date", adddate);
    selectValue("id", "eventEdit_site", country);
    sendKeys("id","eventEdit_ticket_url","http://www.barclays.co.uk");
       // selectValue("id", "eventEdit_status", "complete");
    click("id", "form_submit");
    waitForElementPresent("xpath", "//*[contains(text(),'The event was saved successfully.')]");
//    Thread.sleep(3000);
    
    click("xpath", ".//*[@id='column2']/ul/li[7]/a");
    selectValue("xpath","//*[@id='bonsai-img-tab-search']/div[1]/form/select[2]",country);
    click("id","bonsai-img-tab-search-button");
    Thread.sleep(3000);
    click("xpath",".//*[@id='bonsai-img-tab-search-list']/li[1]/div[3]/button[2]");
    click("id","bonsai-img-attachments-save");
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    click("id","bonsai-img-dialog-cancel");
    click("id", "form_submit");
     
    click("xpath","//*[@id='column2']/ul/li[3]/a");
    Thread.sleep(3000);
    if(country.equals("fr-paris"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[6]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[6]/ul/li[3]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[6]/ul/li[3]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("mx-df"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[6]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[6]/ul/li[1]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[6]/ul/li[1]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("barcelona-ca"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[2]/div");
    doubleclick("//*[@id='tagger_1']/div[1]/ul/li[2]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[2]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else if(country.equals("barcelona-es"))
    {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//*[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[3]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else {Thread.sleep(2000);
    click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//*[@id='tagger_1']/div[2]/ul/li[3]/ul/li[2]/span","//*[@id='primaryTag']/span");}
    click("xpath","//div[@id='tagger_instance1']/button");
    click("linkText","Edit Event");
    selectValue("id", "eventEdit_status", "complete");
    click("id", "form_submit");
    return eventName;
  }

  
  public void createOccurence(String EventName,String VenueName) throws InterruptedException
  {
	String date = fireplacedate();
	click("linkText", "Events");
	sendKeys("id", "filter_name", EventName);
	click("xpath", ".//*[@id='form']/div[4]/button");
	click("xpath",".//*[@id='column1']/table/tbody/tr[2]/td/a");
    waitForElementPresent("linkText", "Occurrences");
    click("linkText", "Occurrences");
    waitForElementPresent("xpath", "/html/body/div/div[3]/h1/a");
    click("xpath", "/html/body/div/div[3]/h1/a");
    waitForElementPresent("id", "occurrenceEdit_venue_id");
    sendKeys("id", "occurrenceEdit_venue_id", VenueName);
    Thread.sleep(3000);
    click("xpath","html/body/div[3]/ul/li[1]");
    sendKeys("id", "occurrenceEdit_start_date", date);
    sendKeys("id", "occurrenceEdit_start_time_hour", "19");
    sendKeys("id", "occurrenceEdit_start_time_minute", "05");
    sendKeys("id", "occurrenceEdit_end_time_hour", "23");
    sendKeys("id", "occurrenceEdit_end_time_minute", "05");
    selectValue("id", "occurrenceEdit_status", "complete");
    //sendKeys("id", "occurrenceEdit_venue_id", "venue_test_" + venueTime);
    waitForElementPresent("id", "form_submit");
    click("id", "form_submit");
    captureScreenshot();
  }

  public void CMSLogin_stage()
  {
	sendKeys("id", "username", "VamshiM");
    sendKeys("id", "password", "VamshiM");
    click("class", "primary");
  }
  
  public void CMSLogin(String userName,String password)
  {
    sendKeys("id", "username", userName);
    sendKeys("id", "password", password);
    click("class", "primary");
  }
  
  public void createFireplace(String country) throws InterruptedException
  {
	String fireplacepath="/workspace/TimeOut_Automation_Framework/configur/mirko.jpg";
	String fireplaceTime = time();
	waitForElementPresent("linkText","Fireplaces");
    click("linkText", "Fireplaces");
    waitForElementPresent("xpath", "//div[@id='content']/h1/a");
    click("xpath", "//div[@id='content']/h1/a");
    waitForElementPresent("id", "campaign_imageFilename");
    sendKeys("id", "campaign_imageFilename", fireplacepath);
    sendKeys("id", "campaign_name","Automated_Fireplace_" + country + fireplaceTime);
    sendKeys("id", "campaign_backgroundColor","000000");
    sendKeys("id", "campaign_url","http://cineworld.co.uk");   
    if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
    selectValue("id", "campaign_site", "es-barcelona");else
    selectValue("id", "campaign_site", country);
    //sendKeys("id", "campaign_topMargin","100");
    click("id", "campaign_active");
    click("xpath", "//button[@id='form_submit']"); 
    click("id", "form_submit"); 
  }
  public boolean verifyTextPresent(String locatorType,String locator,String text)
  {
	By newLocator = getLocator(locatorType, locator);
	driver.findElement(newLocator).getText().equalsIgnoreCase(text);
	return true; 
  }
  
  public void targetRuleOrZone(String country,String Zone)
  {
	String date = fireplacedate();
    String adddate= addfireplacedate();
	waitForElementPresent("linkText", "Targeting rules");
    click("linkText", "Targeting rules");
    waitForElementPresent("xpath", "//div[@id='content']/h1/a");
    click("xpath", "//div[@id='content']/h1/a");
    sendKeys("id", "rule_liveDate", date);
    sendKeys("id", "rule_expiryDate",adddate);
    if (country.equals("fr-paris")) 
    sendKeys("id", "rule_locale","fr");
    else if (country.equals("us-newyork")||country.equals("us-losangeles")||country.equals("us-newyorkkids")||country.equals("gh-accra"))
    sendKeys("id", "rule_locale","en");
    else if (country.equals("uk-london"))
    sendKeys("id", "rule_locale","en_GB");
 else if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
    sendKeys("id", "rule_locale", "en");
    else sendKeys("id", "rule_locale","es");
    sendKeys("id","rule_zone",Zone);
    click("id", "form_submit");    
  }
  
  public String CreateSlideshows(String country,int slide_number) throws InterruptedException
  {
	String slideShowTime = time();
	waitForElementPresent("linkText", "Slideshows");
	click("linkText", "Slideshows");
	waitForElementPresent("xpath", "//div[@id='content']/h1/a");
	click("xpath", "//div[@id='content']/h1/a");
	String slideShowName= "Auto_slideShow_" + country + slideShowTime ;
	sendKeys("id","slideshow_title",slideShowName);
	waitForElementPresent("id", "slideshow_site");
if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
	    selectValue("id", "slideshow_site", "es-barcelona");else
	selectValue("id","slideshow_site",country);
	click("id","form_submit");
	verifyTextPresent("xpath","//div[@id='globalNotices']/div","The slideshow was saved successfully.");
	for(int i=1;i<=slide_number;i++){
	waitForElementPresent("id", "slideshowSlideList");
	click("xpath","//*[@id='slideshowSlideList']/a[1]");
	waitForElementPresent("id", "image_search_submit");
	click("id", "image_search_submit");
	Thread.sleep(3000);
	waitForElementPresent("xpath","//*[@id='slideshowForm']/fieldset[2]/div[5]/img[" + i + "]");
	click("xpath","//*[@id='slideshowForm']/fieldset[2]/div[5]/img[" + i + "]");
	driver.findElement(By.id("slide_title")).clear();
    this.sendKeys("id","slide_title", "slide"+i);
	waitForElementPresent("id", "form_submit");
	click("id", "form_submit");
	}
	return slideShowName;
  }
  
  public String createFilms(String country) throws InterruptedException
  {
	String eveTime = time();
	String date = fireplacedate();
	//String adddate= addfireplacedate();
    waitForElementPresent("linkText", "Films");
    click("linkText", "Films");
    waitForElementPresent("xpath", "/html/body/div/div[3]/h1/a");
    click("xpath", "/html/body/div/div[3]/h1/a");
    waitForElementPresent("id", "filmCreate_language");
    if(country.equals("fr-paris"))
    selectValue("id", "filmCreate_language", "fr");
    else if (country.equals("us-newyork")||country.equals("us-losangeles")||country.equals("us-newyorkkids"))
    selectValue("id", "filmCreate_language", "en_US");
else if (country.equals("barcelona-es"))
    {selectValue("id", "filmCreate_language", "es_ES");}
    else if (country.equals("barcelona-ca"))
    {selectValue("id", "venueCreate_language", "ca");}
    else if (country.equals("barcelona-en"))
    {selectValue("id", "venueCreate_language", "en_GB");}
    else if (country.equals("uk-london"))
    selectValue("id", "filmCreate_language", "en_GB");
    else if (country.equals("gh-accra"))
    selectValue("id", "eventCreate_language", "en_GH");
    else selectValue("id", "filmCreate_language", "es_419");
    waitForElementPresent("id", "filmCreate_original_title");
    String filmOriginalTitle= "Film_" + country + eveTime;
    sendKeys("id", "filmCreate_original_title", filmOriginalTitle);
    waitForElementPresent("id", "filmCreate_title");
    String filmTitle= filmOriginalTitle + "actual";
    sendKeys("id", "filmCreate_title",filmTitle);
    sendKeys("id", "filmCreate_author", "testAuthor");
    sendKeys("id", "filmCreate_posted_at", date);
    click("id", "form_submit");
    waitForElementPresent("id", "filmEdit_status");
    selectValue("id", "filmEdit_status","complete");
    click("id", "form_submit");
    //only works for firefox,chrome handling alerts is not yet implemented.
    click("xpath", ".//*[@id='column2']/ul/li[7]/a");
 if (country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en"))
	    selectValue("xpath", "//*[@id='bonsai-img-tab-search']/div[1]/form/select[2]", "es-barcelona");else
    selectValue("xpath","//*[@id='bonsai-img-tab-search']/div[1]/form/select[2]",country);
    click("id","bonsai-img-tab-search-button");
    Thread.sleep(3000);
    click("xpath",".//*[@id='bonsai-img-tab-search-list']/li[1]/div[3]/button[2]");
    click("id","bonsai-img-attachments-save");
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    click("id","bonsai-img-dialog-cancel");
    return filmOriginalTitle;
  }

public void draganddrop(String dragElement)
{
	WebElement element = driver.findElement(By.xpath(dragElement));
	WebElement target = driver.findElement(By.xpath("//*[@class='sortable item-droppable ui-sortable']"));
	(new Actions(driver)).dragAndDrop(element, target).build().perform();
}

public void doubleclick(String dragElement)
{
	WebElement element = driver.findElement(By.xpath(dragElement));
	Actions action = new Actions(driver);
	action.doubleClick(element);
	action.perform();
}

public void draganddrop_new(String dragElement,String dropElement)
{
	WebElement element = driver.findElement(By.xpath(dragElement));
	WebElement target = driver.findElement(By.xpath(dropElement));
	(new Actions(driver)).dragAndDrop(element, target).build().perform();
}

public void draganddrop_preview(String dragElement) throws InterruptedException
{
	WebElement element = driver.findElement(By.xpath(dragElement));
	WebElement target = driver.findElement(By.xpath("//div[@id=('mainContentContainer')]/div[2]/div[1]"));
	Thread.sleep(5000);
	(new Actions(driver)).dragAndDrop(element,target).build();
}

public void mouseHover(String dragElement)
{
	WebElement element = driver.findElement(By.xpath(dragElement));
	//Actions action = new Actions(driver);
	//action.doubleClick(element);
	//action.perform();
	Actions builder = new Actions(driver);
	
	builder.moveToElement(element).build().perform();
}

public String createSuperlist(String country) throws InterruptedException
{
	String slTime = time();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String str=dateFormat.format(date);
    waitForElementPresent("linkText", "Superlists");
    click("linkText", "Superlists");
    if(country.equals("fr-paris")){
    click("xpath","//*[@id='category_117']/span");
    click("xpath","//*[@id='category_119']/span");
    click("xpath","//*[@id='category_127']/span/a");}
    if(country.equals("us-newyork")){
    click("xpath","//*[@id='category_153']/span");
    click("xpath","//*[@id='category_155']/span");
    click("xpath","//*[@id='category_157']/span/a");}
    if(country.equals("uk-london")){
    click("xpath","//*[@id='category_203']/span");
    click("xpath","//*[@id='category_207']/span");
    click("xpath","//*[@id='category_215']/span/a");}
    if(country.equals("mx-df")){
    click("xpath","//*[@id='category_183']/span");
    click("xpath","//*[@id='category_187']/span");
    click("xpath","//*[@id='category_193']/span/a");}
if(country.equals("barcelona-es")){
        click("xpath","//*[@id='category_279']/span");
        click("xpath","//*[@id='category_281']/span");
        click("xpath","//*[@id='category_287']/span/a");}
    if(country.equals("barcelona-ca")){
        click("xpath","//*[@id='category_279']/span");
        click("xpath","//*[@id='category_295']/span");
        click("xpath","//*[@id='category_301']/span/a");}
    if(country.equals("barcelona-en")){
        click("xpath","//*[@id='category_279']/span");
        click("xpath","//*[@id='category_313']/span");
        click("xpath","//*[@id='category_319']/span/a");}
    if(country.equals("us-losangeles")){
    Thread.sleep(2000);
    //click("xpath","//*[@id='category_153']/span");
    click("xpath","//*[@id='category_227']/span");
    click("xpath","//*[@id='category_231']/span/a");}
    if(country.equals("us-newyorkkids")){
        Thread.sleep(2000);
        click("xpath","//*[@id='category_153']/span");
        click("xpath","//*[@id='category_263']/span");
        click("xpath","//*[@id='category_265']/span/a");}
    if(country.equals("gh-accra")){
        Thread.sleep(2000);
        click("xpath","//*[@id='category_340']/span");
        click("xpath","//*[@id='category_341']/span");
        click("xpath","//*[@id='category_344']/span/a");}
    click("id","create_new");
    String slName= "list_" + slTime;
    sendKeys("id","list_name",slName);
    click("id","create_submit");
    Thread.sleep(3000);
    click("linkText",slName);
    click("id","create_new_instance");
    sendKeys("id","new_instance_live_date",str + " 00:00");
    click("xpath","//form[@id='create_instance_form']/button");
    Thread.sleep(3000);
    selectValue("id","search_content_items_type","film");
    if(country.equals("fr-paris")){
    selectValue("id", "search_content_items_language", "fr");
    selectValue("id","search_content_items_site",country);}
else if (country.equals("barcelona-es"))
    {selectValue("id", "search_content_items_language", "es");
    sendKeys("id", "search_content_items_site", "es-barcelona");}
    else if (country.equals("barcelona-ca"))
    {selectValue("id", "search_content_items_language", "ca");
    sendKeys("id", "search_content_items_site", "es-barcelona");}
    else if (country.equals("barcelona-en"))
    {selectValue("id", "search_content_items_language", "en");
    sendKeys("id", "search_content_items_site", "es-barcelona");}
    if(country.equals(("uk-london"))||country.equals("us-newyork")||country.equals("us-losangeles")||country.equals("us-newyorkkids")||country.equals("gh-accra")){
    selectValue("id", "search_content_items_language", "en");
    selectValue("id","search_content_items_site",country);}
    if(country.equals("mx-df")){
    selectValue("id", "search_content_items_language", "es");
    selectValue("id","search_content_items_site",country);}
    click("xpath","//input[@id='btn_search_content_items_search']");
    Thread.sleep(3000);
    for(int i=1;i<5;i++){
    draganddrop("//div[@id='column2']/div[1]/div[1]/ul/li["+i+"]/h3");}
    Thread.sleep(2000);
    click("xpath","//*[@value='Save & Close']");
    Thread.sleep(5000);
    click("linkText","Logout");
    return slName;
}

public void translateVenue(String translatedName) throws InterruptedException
{
	if(translatedName.contains("Venue")){
	click("linkText","Venues");}
	else if(translatedName.contains("Event")){
	click("linkText","Events");}
	sendKeys("id","filter_name",translatedName);
	click("xpath",".//*[@id='form']/div[4]/button");
	click("linkText",translatedName);
	click("linkText","New translation");
	Thread.sleep(2000);
	click("xpath",".//*[@id='moreLanguages']/ul/li[1]/a");
	click("id","form_submit");
}

public String deleteEVOF(String country,String EVOF) 
{
	if(EVOF.contains("venue")){
	click("linkText","Venues");}
	else if(EVOF.contains("event")){
	click("linkText","Events");}
	sendKeys("id","filter_name",EVOF+ "_" +country);
	sendKeys("id","filter_status","complete");
	click("xpath",".//*[@id='form']/div[4]/button");
	String errormsg=getText("xpath",".//*[@id='column1']/table/tbody/tr[2]/td");
	String msg= "Sorry, no " + EVOF+"s matched your criteria";
	if (errormsg.equalsIgnoreCase(msg)) {
	click("xpath",".//*[@id='form']/div[4]/a");
	sendKeys("id","filter_name",EVOF);
	sendKeys("id","filter_status","complete");
	click("xpath",".//*[@id='form']/div[4]/button");}
	if(EVOF.equals("venue")){
	String deletedStr= getText("xpath",".//*[@id='column1']/table/tbody/tr[2]/td[2]/a");
	click("xpath",".//*[@id='column1']/table/tbody/tr[2]/td/a");
	selectValue("id", EVOF+"Edit_status","deleted");
    click("id", "form_submit");
	return deletedStr;}
	else{String deletedStr= getText("xpath",".//*[@id='column1']/table/tbody/tr[2]/td/a");	
	click("xpath",".//*[@id='column1']/table/tbody/tr[2]/td/a");
	selectValue("id", EVOF+"Edit_status","deleted");
    click("id", "form_submit");
	return deletedStr;}
}

public void Login_pagebuilder()
{
	driver.navigate().to("http://admin.pagebuilder."+atn.qabox());
	String source=driver.getPageSource();
	if(source.contains("login")){
	sendKeys("id", "signin_username", "timeout");
	sendKeys("id","signin_password","outtime00");
	click("xpath",".//*[@id='main-content']/form/input");}
	click("linkText","Page Builder");
}

public void geocodes(String country)
{
	if(country.equals("uk-london")){
    sendKeys("id","venueEdit_latitude","51.51184081479892");
	sendKeys("id","venueEdit_longitude","-0.10648046279902701");}
	if(country.equals("fr-paris")||country.equals("barcelona-es")||country.equals("barcelona-ca")||country.equals("barcelona-en")){
	    sendKeys("id","venueEdit_latitude","48.87334559757214");
		sendKeys("id","venueEdit_longitude","2.340948211669911");}
	if(country.equals("us-newyork")||country.equals("us-losangeles")||country.equals("mx-df")){
	    sendKeys("id","venueEdit_latitude","40.715940416644635");
		sendKeys("id","venueEdit_longitude","-74.00234736505126");}
	
}

public String CreatePagebuilderPage(String country,String pageType) throws InterruptedException
{
	//Login_pagebuilder();
    click("class", "addButton");
//    selectValue("id", "page_builder_status", "New");
    if(country.equals("fr-paris"))selectValue("id", "page_builder_segment", "paris");
    if(country.equals("us-newyork"))selectValue("id", "page_builder_segment", "newyork");
    if(country.equals("uk-london"))selectValue("id", "page_builder_segment", "london");
    if(country.equals("mx-df"))selectValue("id", "page_builder_segment", "df");
    if(country.equals("us-losangeles"))selectValue("id", "page_builder_segment", "los-angeles");
    if(country.equals("us-newyorkkids"))selectValue("id", "page_builder_segment", "new-york-kids");
    if(country.equals("gh-accra"))selectValue("id", "page_builder_segment", "accra");
    if(pageType.equals("hub"))selectValue("id", "page_builder_type_id", "2");
    if(pageType.equals("feature"))selectValue("id", "page_builder_type_id", "6");
    if(country.equals("fr-paris"))selectValue("id", "page_builder_language", "fr");
    if(country.equals("us-newyork")||country.equals("us-newyorkkids"))selectValue("id", "page_builder_language", "en_US");
    if(country.equals("uk-london"))selectValue("id", "page_builder_language", "en_GB");
    if(country.equals("mx-df"))selectValue("id", "page_builder_language", "es_419");
    if(country.equals("us-losangeles"))selectValue("id", "page_builder_language", "en_US");
    if(country.equals("gh-accra"))selectValue("id", "page_builder_language", "en_GH");
if (country.equals("barcelona-es"))selectValue("id", "page_builder_language", "es_ES");
    if (country.equals("barcelona-ca"))selectValue("id", "page_builder_language", "ca");
    if (country.equals("barcelona-en"))selectValue("id", "page_builder_language", "es_GB");
    String page= "TestPage_"+ time();
    sendKeys("id", "page_builder_title",page);
    sendKeys("id","page_builder_author","TestUser");
    /*click("xpath", ".//*[@id='formList']/li[1]/ul/li[2]");
    if(country.equals("fr-paris")){sendKeys("id","page_builder_url","/paris/"+page);}
    if(country.equals("us-newyork")){sendKeys("id","page_builder_url","/newyork/"+page);}
    if(country.equals("uk-london")){sendKeys("id","page_builder_url","/london/"+page);}
    if(country.equals("mx-df")){sendKeys("id","page_builder_url","/df/"+page);}
    if(country.equals("us-losangeles")){sendKeys("id","page_builder_url","/los-angeles/"+page);}
    if(country.equals("us-newyorkkids")){sendKeys("id","page_builder_url","/new-york-kids/"+page);} 
    //sendKeys("id","page_builder_url","/london/"+page);
*/
    click("id","saveAndCloseButton");
    //click("linkText","Reset");
    sendKeys("id","pb_page_filters_title", page);
//    click("xpath",".//*[@id='sf_admin_container']/div[1]/div/form/div[4]/input");
    click("linkText",page);
    click("xpath","//*[@id='formList']/li[1]/ul/li[7]/a");
    
    Thread.sleep(3000);
    if(country.equals("fr-paris"))
	{Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[6]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[6]/ul/li[3]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[6]/ul/li[3]/span","//div[@id='primaryTag']/span");}
if(country.equals("barcelona-ca"))
	{Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[2]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[2]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[1]/ul/li[2]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    if(country.equals("barcelona-es"))
	{Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    if(country.equals("barcelona-en"))
	{Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else if(country.endsWith("mx-df"))
	{Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[5]/div");
    doubleclick("//div[@id='tagger_1']/div[1]/ul/li[5]/ul/li[2]/span");
    draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[5]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    else {Thread.sleep(2000);
	click("xpath","//*[@id='tagger_1']/div[1]/ul/li[3]/div");
	doubleclick("//div[@id='tagger_1']/div[1]/ul/li[3]/ul/li[2]/span");
	draganddrop_new("//div[@id='tagger_1']/div[2]/ul/li[3]/ul/li[2]/span","//div[@id='primaryTag']/span");}
    click("xpath","//div[@id='tagger_instance1']/button");
    click("id","saveAndEditButton");
    /*click("linkText","Reset");
    sendKeys("id","pb_page_filters_title", page);
    click("xpath",".//*[@id='sf_admin_container']/div[1]/div/form/div[4]/input");
    click("linkText",page);*/
    selectValue("id","page_builder_status","live");
    click("id","saveAndEditButton");
    click("linkText","Advanced");
//    page = this.getText("xpath", "//*[@id='main-content']/p/a");
//    page = this.getText("id", "page_builder_url");
    page = this.getElementAttribute("id", "page_builder_url", "value");
    System.out.println("Page URL is " + page);
    return page;
}

}