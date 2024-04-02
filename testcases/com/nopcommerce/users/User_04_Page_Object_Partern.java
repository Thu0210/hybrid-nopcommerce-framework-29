package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class User_04_Page_Object_Partern extends BaseTest {
    public WebDriver driver;
    private HomePageObject homePageObject;
    private LoginPageObject loginPageObject;
    private RegisterPageObject registerPageObject;
    private CustomerInfoPageObject customerInfoPageObject;
    String firsName = "Lele";
    String lastName ="LeNa";
    String dayOfBirth = "10";
    String monthOfBirth = "January";
    String yearofBirth = "1998";
    String email = "lele" + generateRandomNumber() + "@gmail.com";
    String companyName ="TestAutomation";
    String password = "123456";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePageObject = new HomePageObject(driver);

    }

    @Test
    public void User_01_Register() {
        homePageObject.clickToRegisterLink();
        registerPageObject = new RegisterPageObject(driver);
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
    public void User_02_Login(){
        registerPageObject.clickOnLoginLink();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inputEmailTextbox(email);
        loginPageObject.inputPasswordTextbox(password);
        loginPageObject.clickOnLoginButton();
        homePageObject = new HomePageObject(driver);

    }
    @Test
    public void User_03_Customer_Info(){
        homePageObject.clickOnMyAccountLink();
        customerInfoPageObject = new CustomerInfoPageObject(driver);
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
