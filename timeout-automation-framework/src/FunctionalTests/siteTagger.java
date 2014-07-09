package FunctionalTests;
import org.testng.annotations.Test;

@Test
public class siteTagger extends setup.testSetting
{
  public void  siteTaggerverificationforGlobalPlatform() throws InterruptedException {
	  String[] domain=atn.domains();
	  for(int i=0;i<domain.length;i++){
		  if(domain[i].equals("fr-paris"))
			  domain[i]=domain[i].replace("fr-paris","paris");
		  else if(domain[i].equals("us-newyork"))
			  domain[i]=domain[i].replace("us-newyork", "newyork");
		  else if(domain[i].equals("mx-df"))
			  domain[i]=domain[i].replace("mx-df", "df");
		  else if(domain[i].equals("us-losangeles"))
			  domain[i]=domain[i].replace("us-losangeles", "los-angeles");
		  else  domain[i]=domain[i].replace("uk-london", "london");
	  webDriver.driver.navigate().to("http://www."+atn.qabox()+domain[i]+"/search");
	  String source=webDriver.driver.getPageSource();
	  if(source.contains("tags.sitetagger.co.uk")){
	  System.out.println("Site Tagger exists on "+ domain[i]);}
	  else System.out.println("Site Tagger Doesn't exists on "+ domain[i]);}
  }
  }