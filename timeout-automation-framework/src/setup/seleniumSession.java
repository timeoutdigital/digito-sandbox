package setup;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.thoughtworks.selenium.Selenium;

public class seleniumSession
{
  private static final DesiredCapabilities DesiredCapabilities = null;
  public WebDriver driver;
  @SuppressWarnings("unused")
private DesiredCapabilities capability;

  public void SeleniumSetup(String browser, String URL)
    throws Exception
  {
    Logger log = new Logger(seleniumSession.class);
    log.info("WebDriver started the Script....");
    DesiredCapabilities capability = null;

    if (browser.equalsIgnoreCase("firefox"))
    {
      log.info("Browser :" + browser);
      capability = DesiredCapabilities.firefox();
      capability.setCapability("firefox.switches", Arrays.asList("--start-maximized"));
      capability.setPlatform(Platform.ANY);
      capability.setJavascriptEnabled(true);
      capability.setCapability("takesScreenshot", true);
      capability.setCapability("javascriptEnabled", true);
      this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
      this.driver.navigate().to(URL);
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
      Selenium sel = new WebDriverBackedSelenium(this.driver, "http://www.google.com");
      sel.windowMaximize();
      this.driver = new Augmenter().augment(this.driver);
    }
    else if (browser.equalsIgnoreCase("ie"))
    {
      log.info("Browser :" + browser);
      capability = DesiredCapabilities.internetExplorer();

      this.driver = new RemoteWebDriver(new URL("http://ci01.ldn3.timesout.net:4444/wd/hub"), capability);
      this.driver.navigate().to(URL);
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
      Selenium sel = new WebDriverBackedSelenium(this.driver, "http://www.google.com");
      sel.windowMaximize();
      this.driver = new Augmenter().augment(this.driver);
    }
    else if (browser.equalsIgnoreCase("chrome"))
    {
      log.info("Browser :" + browser);
      capability = DesiredCapabilities.chrome();
      capability.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
      this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
      this.driver.navigate().to(URL);
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
      Selenium sel = new WebDriverBackedSelenium(this.driver, "http://www.google.com");
      sel.windowMaximize();
      this.driver = new Augmenter().augment(this.driver);
    }
    
    /*else if (browser.equalsIgnoreCase("safari"))
    {
      log.info("Browser :" + browser);
      capability = DesiredCapabilities.safari();

      this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
      this.driver.navigate().to(URL);
      Selenium sel = new WebDriverBackedSelenium(this.driver, "http://www.google.com");
      sel.windowMaximize();
      this.driver = new Augmenter().augment(this.driver);
    }*/
    else if (browser.equalsIgnoreCase("android"))
    {
      log.info("Browser :" + browser);
      capability = DesiredCapabilities.android();
      capability.setPlatform(Platform.ANDROID);
      capability.setBrowserName("android");
      this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
      this.driver.navigate().to(URL);
     // Selenium sel = new WebDriverBackedSelenium(this.driver, "http://www.google.com");
     // sel.windowMaximize();
     // this.driver = new Augmenter().augment(this.driver);
    } 
  }
}