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
}
