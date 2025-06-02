package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement LnkMyaccount;

    @FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
    WebElement LnkRegister;

    @FindBy (xpath = "//a[normalize-space()='Login']")
    WebElement LnkLogin;

    public void clickMyAccount(){
        LnkMyaccount.click();
    }

    public void clickRegister(){
        LnkRegister.click();
    }

    public void clickLogin(){
        LnkLogin.click();
    }

}
