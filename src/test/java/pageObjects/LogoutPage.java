package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logoutConfirmMsg;

    @FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Login']")
    WebElement login;

    public String getLogoutMsg(){
        try{
           return (logoutConfirmMsg.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public void clickLogin(){
        login.click();
    }
}
