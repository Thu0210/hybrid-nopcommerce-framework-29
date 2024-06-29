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
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.*;

public class User_09_Switch_Site_URL extends BaseTest {
    public WebDriver driver;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private UserOrderPO userOrderPage;
    private UserAddressPO userAddressPage;
    private UserRewardPointPO userRewardPointPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    String firsName = "Lele";
    String lastName = "LeNa";
    String dayOfBirth = "10";
    String monthOfBirth = "January";
    String yearofBirth = "1998";
    String email = "lele" + generateRandomNumber() + "@gmail.com";
    String companyName = "TestAutomation";
    String password = "123456";
    String adminEmailAddress = "admin@yourstore.com";
    String adminPassword = "admin";
    private String userURLValue, adminURLValue;


    @Parameters({"browser", "userURL", "adminURL"})

    @BeforeClass
    public void beforeClass(String browserName, String userURL, String adminURL) {
        userURLValue = userURL;
        adminURLValue = adminURL;
        driver = new FirefoxDriver();
        driver = getBrowserDriver(browserName, userURL);
        userHomePage = PageGenerator.getUserHomepage(driver);
        // Pre-condition
        userRegisterPage =userHomePage.openRegisterPage();
        userRegisterPage.selectMaleRadio();
        userRegisterPage.inputFirstNameTextbox(firsName);
        userRegisterPage.inputLastNameTextbox(lastName);
        userRegisterPage.selectDayofBirth(dayOfBirth);
        userRegisterPage.selectMonthofBirth(monthOfBirth);
        userRegisterPage.selectYearofBirth(yearofBirth);
        userRegisterPage.inputEmailTextbox(email);
        userRegisterPage.inputCompanyNameTextbox(companyName);
        userRegisterPage.inputPasswordTextbox(password);
        userRegisterPage.inputConfirmPasswordTextbox(password);
        userRegisterPage.clickRegisterButton();
        Assert.assertTrue(userRegisterPage.isCompletedRegisterMessageDisplayed());
        userHomePage = userRegisterPage.clickLogoutLink();
}

    @Test
    public void User_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.openLoginPage();
        userHomePage = userLoginPage.loginToSystem(email, password);
        userHomePage.openPageUrl(driver, adminURLValue);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

    }
    @Test
    public void User_02_Admin_Site_To_User_Site() {
        adminDashboardPage.openPageUrl(driver, userURLValue);
        userHomePage = PageGenerator.getUserHomepage(driver);
        userCustomerInfoPage = userHomePage.openMyAccountPage();


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
