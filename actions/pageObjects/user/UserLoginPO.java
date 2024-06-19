package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;
    public UserLoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void inputEmailTextbox(String emailAddress) {
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputPasswordTextbox(String password) {
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePO clickOnLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomepage(driver);
    }

    public UserHomePO loginToSystem(String email, String password) {
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return new UserHomePO(driver);
    }
}
