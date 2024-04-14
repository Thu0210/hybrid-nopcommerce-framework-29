package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected WebDriver getBrowserDriver(String browserName){
        switch (browserName){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
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
