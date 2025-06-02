package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage{
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFristName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinoue;

    @FindBy (xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setFristName(String fname){
        txtFristName.sendKeys(fname);
    }

    public void setLastName(String lname){
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String telephone){
        txtTelephone.sendKeys(telephone);
    }

    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd){
        txtConfirmPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy(){
        chkdPolicy.click();
    }

    public void clickContinoue(){
        //sol 1
        btnContinoue.click();

        //sol 2
        //btnContinoue.submit();

        //sol 3
        //Actions act = new Actions(driver);
        //act.moveToElement(btnContinoue).click().perform();

        //sol 4
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", btnContinoue);

        // sol 5
        //btnContinoue.sendKeys(Keys.RETURN);

        // sol 6
        //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //mywait.until(ExpectedConditions.elementToBeClickable(btnContinoue)).click();
    }

    public String getConfirmationMsg(){
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

}
