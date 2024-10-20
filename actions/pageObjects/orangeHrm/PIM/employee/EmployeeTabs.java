package pageObjects.orangeHrm.PIM.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;
    public EmployeeTabs(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public PersonalDetailsPO openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        waitForElementClickable(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
    public ContactDetailsPO openContactDetailPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        waitForElementClickable(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getContactDetailsPage(driver);
    }
    public EmergencyContactPO openEmergencyContactPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.EMERGENCY_CONTACT_LINK);
        waitForElementClickable(driver, EmployeeTabsPUI.EMERGENCY_CONTACT_LINK);
        return PageGenerator.getEmergencyContactPage(driver);
    }

}
