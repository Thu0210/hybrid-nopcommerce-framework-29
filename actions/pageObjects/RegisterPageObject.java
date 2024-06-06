package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void selectMaleRadio() {
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void inputFirstNameTextbox(String firstName) {
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputLastNameTextbox(String lastName) {
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayofBirth(String dayOfBirth) {
        selectItemInDropdownByVisibletext(driver, RegisterPageUI.DAY_OF_BIRTH_DROPDOWN, dayOfBirth);
    }

    public void selectMonthofBirth(String monthOfBirth) {
        selectItemInDropdownByVisibletext(driver, RegisterPageUI.MONTH_OF_BIRTH_DROPDOWN, monthOfBirth);
    }

    public void selectYearofBirth(String yearOfBirth) {
        selectItemInDropdownByVisibletext(driver, RegisterPageUI.YEAR_OF_BIRTH_DROPDOWN, yearOfBirth);
    }

    public void inputEmailTextbox(String emailAddress) {
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputCompanyNameTextbox(String companyName) {
        sendkeyToElement(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void inputPasswordTextbox(String password) {
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputConfirmPasswordTextbox(String confirmPassword) {
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isCompletedRegisterMessageDisplayed() {
        waitForElementPresence(driver, RegisterPageUI.RESULT_MESSAGE);
        return isElementDisplayed(driver, RegisterPageUI.RESULT_MESSAGE);
    }

//    public void clickContinueButton() {
//    }

    public LoginPageObject openLoginPage() {
        waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
        clickToElement(driver, RegisterPageUI.LOGIN_LINK);
        return PageGenerator.getLoginpage(driver);
    }

    public LoginPageObject clickLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getLoginpage(driver);
    }
}
