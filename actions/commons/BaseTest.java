package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is invalid!");
        }
        driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is invalid!");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    protected int generateRandomNumber(){
        return new Random().nextInt(9999);
    }
    protected void SleepInSecond() throws InterruptedException {
        Thread.sleep(5000);
    }
}
