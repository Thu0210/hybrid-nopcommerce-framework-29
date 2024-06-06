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
    public static AddressPageObject getAddressPage(WebDriver driver){
        return new AddressPageObject(driver);
    }
    public static OrderPageObject getOrderPage(WebDriver driver){
        return new OrderPageObject(driver);
    }
    public static RewardPointPageObject getRewardPointPage(WebDriver driver){
        return new RewardPointPageObject(driver);
    }


}
