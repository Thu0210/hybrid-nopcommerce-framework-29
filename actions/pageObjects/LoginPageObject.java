package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void inputEmailTextbox(String emailAddress) {
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputPasswordTextbox(String password) {
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickOnLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
