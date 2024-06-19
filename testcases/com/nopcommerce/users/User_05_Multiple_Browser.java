package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.UserCustomerInfoPO;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserLoginPO;
import pageObjects.user.UserRegisterPO;

import java.time.Duration;

public class User_05_Multiple_Browser extends BaseTest {
    public WebDriver driver;
    private UserHomePO homePageObject;
    private UserLoginPO loginPageObject;
    private UserRegisterPO registerPageObject;
    private UserCustomerInfoPO customerInfoPageObject;
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

        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        homePageObject = new UserHomePO(driver);

    }

    @Test
    public void User_01_Register() {
        homePageObject.openRegisterPage();
        registerPageObject = new UserRegisterPO(driver);
        registerPageObject.selectMaleRadio();
        registerPageObject.inputFirstNameTextbox(firsName);
        registerPageObject.inputLastNameTextbox(lastName);
        registerPageObject.selectDayofBirth(dayOfBirth);
        registerPageObject.selectMonthofBirth(monthOfBirth);
        registerPageObject.selectYearofBirth(yearofBirth);
        registerPageObject.inputEmailTextbox(email);
        registerPageObject.inputCompanyNameTextbox(companyName);
        registerPageObject.inputPasswordTextbox(password);
        registerPageObject.inputConfirmPasswordTextbox(password);
        registerPageObject.clickRegisterButton();
        Assert.assertTrue(registerPageObject.isCompletedRegisterMessageDisplayed());
        //registerPageObject.clickContinueButton();


    }
    @Test
    public void User_02_Login() {
        homePageObject.openLoginPage();
        loginPageObject = new UserLoginPO(driver);
        loginPageObject.inputEmailTextbox(email);
        loginPageObject.inputPasswordTextbox(password);
        loginPageObject.clickOnLoginButton();


    }
    @Test
    public void User_03_Customer_Info(){
        homePageObject = new UserHomePO(driver);
        homePageObject.openMyAccountPage();
        customerInfoPageObject = new UserCustomerInfoPO(driver);
        Assert.assertEquals(customerInfoPageObject.getFirstNameTextbox("value"),firsName );
        Assert.assertEquals(customerInfoPageObject.getLastNameTextbox("value"), lastName);
        Assert.assertEquals(customerInfoPageObject.getEmailTextbox("value"), email);
        Assert.assertEquals(customerInfoPageObject.getCompanyNameTextbox("value"), companyName);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
