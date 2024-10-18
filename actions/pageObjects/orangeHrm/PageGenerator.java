package pageObjects.orangeHrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.PIM.employee.*;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }
    public static DashboardPO getDashBoardPage(WebDriver driver){
        return new DashboardPO(driver);
    }
    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver){
        return new AddNewEmployeePO(driver);
    }
    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return new EmployeeListPO(driver);
    }
    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver){
        return new PersonalDetailsPO(driver);
    }
    public static EmergencyContactPO getEmergencyContactPage(WebDriver driver){
        return new EmergencyContactPO(driver);
    }
    public static ContactDetailsPO getContactDetailsPage(WebDriver driver){
        return new ContactDetailsPO(driver);
    }



}
