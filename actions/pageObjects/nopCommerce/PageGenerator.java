package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.*;


public class PageGenerator {
    public static UserHomePO getUserHomepage(WebDriver driver){
        return new UserHomePO(driver);
    }
    public static UserLoginPO getUserLoginpage(WebDriver driver){
        return new UserLoginPO(driver);
    }
    public static UserRegisterPO getUserRegisterpage(WebDriver driver){
        return new UserRegisterPO(driver);
    }
    public static UserCustomerInfoPO getUserCustomerInfopage(WebDriver driver){
        return new UserCustomerInfoPO(driver);
    }
    public static UserAddressPO getUserAddressPage(WebDriver driver){
        return new UserAddressPO(driver);
    }
    public static UserOrderPO getUserOrderPage(WebDriver driver){
        return new UserOrderPO(driver);
    }
    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver){
        return new UserRewardPointPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
    public  static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }


}
