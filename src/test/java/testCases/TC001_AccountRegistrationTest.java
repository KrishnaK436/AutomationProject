package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {

        logger.info("**** Starting Test Case***");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();
            logger.info("**** Entered to the registration page ***");

            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            arp.setFristName(randonString().toUpperCase());
            arp.setLastName(randonString().toLowerCase());
            String email = randonString() + "@mail.com";
            arp.setEmail(email); // randomly generated the email
            arp.setTelephone(randonNumber());
            String password = randomAlphaNumeric();
            arp.setPassword(password);
            arp.setConfirmPassword(password);
            arp.setPrivacyPolicy();
            arp.clickContinoue();

            logger.info("**** Validating account creation message***");
            String confMsg = arp.getConfirmationMsg();

            Assert.assertEquals(confMsg, "Your Account Has Been Created!");

            if(confMsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }else {
                Assert.assertTrue(false);
                logger.error("test failed......");
                logger.debug("Debug logs....");
            }

        } catch (Exception e) {

            Assert.fail();
        }
        logger.info("**** Completed the test case***");
    }

}
