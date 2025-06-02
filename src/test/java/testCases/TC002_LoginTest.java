package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verify_login(){
        logger.info("*** Started login****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setTxt_email(p.getProperty("email"));
            loginPage.setTxt_pssword(p.getProperty("password"));
            loginPage.clickLogin();
            MyAccountPage macp = new MyAccountPage(driver);
            boolean targetPage = macp.isMyAccountExists();
            //Assert.assertEquals(targetPage, true, "Login failed");
            Assert.assertTrue(targetPage);
            macp.clcikLogout();
            logger.info("Completed this second test case");
        } catch (Exception e) {
            Assert.fail();
        }

    }
}
