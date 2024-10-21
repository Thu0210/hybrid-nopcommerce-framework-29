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



    public boolean isProfileAvatarUpdatedSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        return !beforeUpload.equals(afterUpload);
    }

    public void clickToEmployeeAvartarDetails() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE_PERSONAL_DETAIL);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE_PERSONAL_DETAIL);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToLicenseDriverTextbox(String driverLicenseNumber) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicenseNumber);
    }

    public void enterToLicenExpiryDateTextbox(String licenseExpirydate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpirydate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);

    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD,maritalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTHDAY_TEXTBOX);
        sendkeyToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTHDAY_TEXTBOX, dateOfBirth);
    }

    public void selectGenderMaleRadioButton(String genderMale) {
        waitForElementClickable(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, genderMale);
        checkTheCheckBoxOrRadio(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, genderMale);
    }

    public void clickToSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_SELECTED);
        return getTextElement(driver, PersonalDetailsPUI.NATIONALITY_SELECTED);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_SELECTED);
        return getTextElement(driver, PersonalDetailsPUI.MARITAL_SELECTED);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTHDAY_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DATE_OF_BIRTHDAY_TEXTBOX, "value");
    }

    public Boolean isGenderMaleRadioSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }
}
