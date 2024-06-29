package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.time.Duration;

public class User_10_Dynamic_Locator extends BaseTest {
    public WebDriver driver;
    private UserHomePO homePage;
    private UserLoginPO loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserOrderPO orderPage;
    private UserAddressPO addressPage;
    private UserRewardPointPO rewardPointPage;
    String firsName = "Lele";
    String lastName ="LeNa";
    String dayOfBirth = "10";
    String monthOfBirth = "January";
    String yearofBirth = "1998";
    String email = "lele" + generateRandomNumber() + "@gmail.com";
    String companyName ="TestAutomation";
    String password = "123456";

    @Parameters("browser")

    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        homePage = PageGenerator.getUserHomepage(driver);

    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterPage();
        registerPage.selectMaleRadio();
        registerPage.inputFirstNameTextbox(firsName);
        registerPage.inputLastNameTextbox(lastName);
        registerPage.selectDayofBirth(dayOfBirth);
        registerPage.selectMonthofBirth(monthOfBirth);
        registerPage.selectYearofBirth(yearofBirth);
        registerPage.inputEmailTextbox(email);
        registerPage.inputCompanyNameTextbox(companyName);
        registerPage.inputPasswordTextbox(password);
        registerPage.inputConfirmPasswordTextbox(password);
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isCompletedRegisterMessageDisplayed());
        registerPage.clickLogoutLink();


    }
    @Test
    public void User_02_Login() {
        loginPage = homePage.openLoginPage();
        loginPage.inputEmailTextbox(email);
        loginPage.inputPasswordTextbox(password);
        homePage = loginPage.clickOnLoginButton();


    }
    @Test
    public void User_03_Customer_Info(){
        customerInfoPage = homePage.openMyAccountPage();
        Assert.assertEquals(customerInfoPage.getFirstNameTextbox("value"),firsName );
        Assert.assertEquals(customerInfoPage.getLastNameTextbox("value"), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextbox("value"), email);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextbox("value"), companyName);

    }
    @Test
    public void User_04_Dynamic_Page_Locator(){
        //customer info => Address
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByPageName("Addresses");

        //address => Reward Points
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");
        //reward points => Orders
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");
        //orders => address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");
        //address => customer info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");
    }
    @Test
    public void User_05_Dynamic_Page_Locator(){
        //customer info => Address
        customerInfoPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        //address => Reward Points
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);
        //reward points => Orders
        rewardPointPage.openSidebarLinkByPageNames("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);
        //orders => address
        orderPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);
        //address => customer info
        addressPage.openSidebarLinkByPageNames("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerInfopage(driver);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
