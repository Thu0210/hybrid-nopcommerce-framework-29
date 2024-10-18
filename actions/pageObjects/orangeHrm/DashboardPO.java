package pageObjects.orangeHrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PIM.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;
    public DashboardPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPUI.PIM_LINK);
        clickToElement(driver, DashboardPUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
