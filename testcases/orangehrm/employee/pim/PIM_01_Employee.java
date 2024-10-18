package orangehrm.employee.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHrm.DashboardPO;
import pageObjects.orangeHrm.LoginPO;
import pageObjects.orangeHrm.PIM.employee.AddNewEmployeePO;
import pageObjects.orangeHrm.PIM.employee.EmployeeListPO;
import pageObjects.orangeHrm.PIM.employee.PersonalDetailsPO;
import pageObjects.orangeHrm.PageGenerator;

public class PIM_01_Employee extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(PIM_01_Employee.class);
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeID, firstName, lastName;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        firstName = "John";
        lastName = "Wick";
        loginPage.enterToUsernameTextbox("Thu Le");
        loginPage.enterToPasswordTextbox("Test123@!456");
        dashboardPage = loginPage.clickLoginButton();

    }
    @Test
    public void Employee_01_Add_New(){
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmpoyeeButton();
        addNewEmployeePage.entertoFirstNameTextbox(firstName);
        addNewEmployeePage.entertoLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clickToSaveButtonEmployeeContainer();

    }
    @Test
    public void Employee_02_Upload_Avatar(){
        personalDetailsPage.clickToEmployeeAvartarImage();
        personalDetailsPage.loadAvartarImage();
        personalDetailsPage.clickToSaveButtonAtProfileContainer();

    }
    @Test
    public void Employee_03_Personal_Detals(){

    }
    @Test
    public void Employee_04_Contact_Detals(){

    }
    @Test
    public void Employee_05_Emergency_Details(){

    }
    @Test
    public void Employee_06_Assigned_Dependents(){

    }
    @Test
    public void Employee_07_Job(){

    }
    @Test
    public void Employee_08_Salary(){

    }
    @Test
    public void Employee_09_ReportTo(){

    }
    @Test
    public void Employee_10_Qualifications(){

    }
    @Test
    public void Employee_11_Search_Employee(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }

}
