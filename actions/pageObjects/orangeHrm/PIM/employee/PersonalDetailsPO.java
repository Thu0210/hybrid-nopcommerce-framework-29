package pageObjects.orangeHrm.PIM.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeTabs {
    private WebDriver driver;
    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE_PERSONAL_DETAIL);
    }


    public EmployeeListPO clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        return PageGenerator.getEmployeeListPage(driver);
    }

    public Boolean isSuccessMessageIsDisplayed() {
        waitForElementVisible(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
    }

    public boolean isProfileAvatarUpdatedSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        return !beforeUpload.equals(afterUpload);
    }

    public void clickToEmployeeAvartarDetails() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE_PERSONAL_DETAIL);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE_PERSONAL_DETAIL);
    }

    public void enterToFirstNameTextbox(String s) {
    }

    public void enterToLastNameTextbox(String s) {
    }

    public int getEmployeeID() {
        return 3;
    }

    public void enterToLicenseDriverTextbox(String s) {
    }

    public void enterToLicenExpiryDateTextbox(String s) {
    }

    public void selectNationalityDropdown(String s) {
    }

    public void selectMaritalStatusDropdown(String s) {
    }

    public void enterToDateOfBirthTextbox(String s) {
    }

    public void selectGenderMaleRadioButton(String s) {
    }

    public void clickToSaveButtonAtPersonalDetailContainer() {
    }
}
