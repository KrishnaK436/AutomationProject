package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"OS", "Browser"})
    public void setUp(String OS, String browser) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        //Loading config.properties file
        logger = LogManager.getLogger(this.getClass());  //Log4j2 code mandatory

        switch(browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser name"); return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL")); // reading url from properties file
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randonString(){
        String genratedString = RandomStringUtils.randomAlphabetic(5);
        return genratedString;
    }

    public String randonNumber(){
        String genratedNumber = RandomStringUtils.randomNumeric(10);
        return genratedNumber;
    }

    public String randomAlphaNumeric(){
        String genratedString = RandomStringUtils.randomAlphabetic(5);
        String genratedNumber = RandomStringUtils.randomNumeric(10);
        return (genratedString + "$" +genratedNumber);
    }
}
