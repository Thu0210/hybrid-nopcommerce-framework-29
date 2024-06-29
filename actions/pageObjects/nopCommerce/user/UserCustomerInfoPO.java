package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getFirstNameTextbox(String value) {
        return getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, value);
    }

    public String getLastNameTextbox(String value) {
        return getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, value);
    }

    public String getEmailTextbox(String value) {
        return getAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, value);
    }

    public String getCompanyNameTextbox(String value) {
        return getAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, value);
    }


}
