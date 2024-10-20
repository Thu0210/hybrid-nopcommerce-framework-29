package pageObjects.orangeHrm.PIM.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmergencyContactPO extends EmployeeTabs {
    private WebDriver driver;
    public EmergencyContactPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
