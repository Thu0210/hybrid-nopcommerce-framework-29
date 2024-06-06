package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextbox(String value) {
        return getAttributeValue(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, value);
    }

    public String getLastNameTextbox(String value) {
        return getAttributeValue(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, value);
    }

    public String getEmailTextbox(String value) {
        return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, value);
    }

    public String getCompanyNameTextbox(String value) {
        return getAttributeValue(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, value);
    }


}
