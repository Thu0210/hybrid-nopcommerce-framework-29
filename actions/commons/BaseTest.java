package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;
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
        return driver;
    }
    protected int generateRandomNumber(){
        return new Random().nextInt(9999);
    }
    protected void SleepInSecond() throws InterruptedException {
        Thread.sleep(5000);
    }
}
