package pageObjects.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;
    public LoginPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPUI.USERNAME_TEXTBOX, username);

    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPO clickLoginButton() {
        waitForElementClickable(driver,LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashBoardPage(driver);
    }
}
