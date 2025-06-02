package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id='input-email']")
    WebElement txt_email;

    @FindBy (xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy (xpath = "//input[@value='Login']")
    WebElement btn_login;

    public void setTxt_email(String mail) {
        txt_email.sendKeys(mail);
    }

    public void setTxt_pssword(String pwd) {
        txt_password.sendKeys(pwd);
    }

    public void clickLogin(){
        btn_login.click();
    }

    public String getTitle(){
        try{
            return (driver.getTitle());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
