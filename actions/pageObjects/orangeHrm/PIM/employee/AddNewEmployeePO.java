package pageObjects.orangeHrm.PIM.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewPUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;
    public AddNewEmployeePO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void entertoFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, AddNewPUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPUI.FIRST_NAME_TEXTBOX, firstname);

    }

    public void entertoLastNameTextbox(String lastname) {
        waitForElementVisible(driver, AddNewPUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddNewPUI.LAST_NAME_TEXTBOX, lastname);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public PersonalDetailsPO clickToSaveButtonEmployeeContainer() {
        waitForElementClickable(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
