package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.LoginPage;

public class BaseTest {

    public static WebDriver driver;

    public WebDriver initializeDriver() throws IOException{

        //properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\Resources\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public LoginPage startApplication() throws IOException {
        driver = initializeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        return loginPage;
    }
}
