package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
public class TC_003_Login extends BaseClass{
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
    public void verify_loginDDT(String email, String password, String exp)
    {
        logger.info("**** Starting TC_003_LoginDDT *****");

        try {

            //Home page
            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin(); //Login link under MyAccount

            //Login page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setTxt_email(p.getProperty("email"));
            loginPage.setTxt_pssword(p.getProperty("password"));
            loginPage.clickLogin();
            MyAccountPage macp = new MyAccountPage(driver);
            boolean targetPage = macp.isMyAccountExists();
            if(exp.equalsIgnoreCase("Valid"))
            {
                if(targetPage==true)
                {
                    macp.clcikLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp.equalsIgnoreCase("Invalid"))
            {
                if(targetPage==true)
                {
                    macp.clcikLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }
        }
        catch(Exception e)
        {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        logger.info("**** Finished TC_003_LoginDDT *****");
    }

}
