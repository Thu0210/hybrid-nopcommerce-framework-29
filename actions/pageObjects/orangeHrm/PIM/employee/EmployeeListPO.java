package pageObjects.orangeHrm.PIM.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmpoyeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
    public PersonalDetailsPO clickToEmployeeAvartarImage() {
        waitForElementClickable(driver, EmployeeListPUI.EMPLOYEE_IMAGE);
        clickToElement(driver, EmployeeListPUI.EMPLOYEE_IMAGE);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public PersonalDetailsPO openPersonalDetailsPage() {
        waitForElementClickable(driver, EmployeeListPUI.PERSONAL_DETAIL_TAB);
        clickToElement(driver, EmployeeListPUI.PERSONAL_DETAIL_TAB);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
