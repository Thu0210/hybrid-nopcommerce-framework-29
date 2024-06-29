package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.user.*;

import java.time.Duration;

public class User_07_Switch_Page_Object extends BaseTest {
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
    private UserHomePO homePageObject;

    @Parameters("browser")

    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
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
        loginPage = homePageObject.openLoginPage();
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
    public void User_04_Switch_Page(){
        //customer info => Address
        addressPage = customerInfoPage.openAddressPage(driver);

        //address => Reward Points
        rewardPointPage = addressPage.openRewardPointPage(driver);
        //reward points => Orders
        orderPage = rewardPointPage.openOrderPage(driver);
        //orders => address
        addressPage = orderPage.openAddressPage(driver);
        //address => customer info
        customerInfoPage = addressPage.openCustomerInfoPage(driver);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
