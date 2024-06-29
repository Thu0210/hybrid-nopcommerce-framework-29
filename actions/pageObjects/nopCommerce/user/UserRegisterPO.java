package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void selectMaleRadio() {
        clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void inputFirstNameTextbox(String firstName) {
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputLastNameTextbox(String lastName) {
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayofBirth(String dayOfBirth) {
        selectItemInDropdownByVisibletext(driver, UserRegisterPageUI.DAY_OF_BIRTH_DROPDOWN, dayOfBirth);
    }

    public void selectMonthofBirth(String monthOfBirth) {
        selectItemInDropdownByVisibletext(driver, UserRegisterPageUI.MONTH_OF_BIRTH_DROPDOWN, monthOfBirth);
    }

    public void selectYearofBirth(String yearOfBirth) {
        selectItemInDropdownByVisibletext(driver, UserRegisterPageUI.YEAR_OF_BIRTH_DROPDOWN, yearOfBirth);
    }

    public void inputEmailTextbox(String emailAddress) {
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputCompanyNameTextbox(String companyName) {
        sendkeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void inputPasswordTextbox(String password) {
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputConfirmPasswordTextbox(String confirmPassword) {
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickRegisterButton() {
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isCompletedRegisterMessageDisplayed() {
        waitForElementPresence(driver, UserRegisterPageUI.RESULT_MESSAGE);
        return isElementDisplayed(driver, UserRegisterPageUI.RESULT_MESSAGE);
    }

//    public void clickContinueButton() {
//    }


    public UserHomePO clickLogoutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomepage(driver);
    }

}
