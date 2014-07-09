package testCases_CMS;
import org.testng.annotations.Test;

@Test
public class Create_Superlist extends setup.testSetting
{  
  public void CreateSuperListforGlobalDomains() throws InterruptedException {
    //webDriver.CMSLogin_stage(); 
    String domain[]= atn.domains();
    for(int i=0;i<domain.length;i++){
    webDriver.CMSLogin_stage();
    webDriver.createSuperlist(domain[i]);}
   }
 }
