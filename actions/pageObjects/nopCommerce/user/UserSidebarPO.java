package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserSidebarBaseUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarBaseUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarBaseUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarBaseUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarBaseUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfopage(driver);
    }

    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarBaseUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarBaseUI.ADDRESS_LINK);

        return PageGenerator.getUserAddressPage(driver);
    }

    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarBaseUI.ORDER_LINK);
        clickToElement(driver, UserSidebarBaseUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    //    Phù hợp với trường hợp số lượng page it
    public UserSidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, UserSidebarBaseUI.DYNAMIC_PAGE_LINK, pageName);
        clickToElement(driver, UserSidebarBaseUI.DYNAMIC_PAGE_LINK, pageName);
        switch (pageName) {
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInfopage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            default:
                throw new RuntimeException("Page name is not supported");
        }
    }

    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSidebarBaseUI.DYNAMIC_PAGE_LINK, pageName);
        clickToElement(driver, UserSidebarBaseUI.DYNAMIC_PAGE_LINK, pageName);

    }
}
