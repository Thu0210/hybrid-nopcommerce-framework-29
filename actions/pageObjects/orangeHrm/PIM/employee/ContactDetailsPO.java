package pageObjects.orangeHrm.PIM.employee;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends  EmployeeTabs{
    private WebDriver driver;
    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
