package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getHomepage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginpage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterpage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfopage(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }

}
