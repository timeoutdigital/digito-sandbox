package testCases_CMS;
import org.testng.annotations.Test;

public class Create_Films extends setup.testSetting
{ 
	@Test
	public void createFilmsforGlobalPlatformDomains() throws InterruptedException {
    webDriver.CMSLogin_stage(); 
    String[] domain=atn.domains();
    for(int i=0;i<domain.length;i++){
    	String FilmName= webDriver.createFilms(domain[i]);
    	System.out.println("Event Created:" + FilmName );
        }
   	  }
  }
