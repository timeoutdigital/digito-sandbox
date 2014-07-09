package testCases_CMS;

import junit.framework.Assert;
import org.testng.annotations.Test;

@Test
public class Create_User extends setup.testSetting {
    public void createUsersforGlobalPlatformDomains() throws InterruptedException {
        atn.dbConnString("ACL");
        String[] domain = atn.domains();
        webDriver.driver.navigate().to("http://admin." + atn.qabox());
        for (int i = 0; i < domain.length; i++) {
            webDriver.CMSLogin_stage();
            webDriver.click("linkText", "Users");
            webDriver.click("linkText", "+ Add user");
            String userName = "user_" + domain[i] + webDriver.time();
            webDriver.sendKeys("id", "user_edit_username", userName);
            webDriver.sendKeys("id", "user_edit_email", userName + "@test.com");
            webDriver.sendKeys("id", "user_edit_plainPassword_first", "timeout99");
            webDriver.sendKeys("id", "user_edit_plainPassword_second", "timeout99");
            webDriver.click("id", "user_edit_rolesCollection_1");
            webDriver.selectValue("id", "user_edit_selectedSites", domain[i]);
            webDriver.click("id", "form_submit");
            webDriver.click("linkText", "Logout");
            webDriver.CMSLogin(userName, "timeout99");
            webDriver.click("linkText", "Venues");
            webDriver.click("linkText", "+ Add venue");
            Assert.assertEquals(webDriver.getText("tagName", "h1"), "New venue");
            webDriver.click("linkText", "Logout");
        }
    }
}
