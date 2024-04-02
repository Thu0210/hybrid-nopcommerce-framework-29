package com.nopcommerce.users;

import commons.BasePage;
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

public class User_04_Page_Object_Partern extends BasePage {
    WebDriver driver;
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    RegisterPageObject registerPageObject;
    CustomerInfoPageObject customerInfoPageObject;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePageObject = new HomePageObject();

    }

    @Test
    public void User_01_Register() {
        homePageObject.clickToRegisterLink();
        registerPageObject = new RegisterPageObject();
        registerPageObject.selectMaleRadio();
        registerPageObject.inputFirstNameTextbox("");
        registerPageObject.inputLastNameTextbox("");
        registerPageObject.selectDayofBirth("");
        registerPageObject.selectMonthofBirth("");
        registerPageObject.selectYearofBirth("");
        registerPageObject.inputEmailTextbox("");
        registerPageObject.inputCompanyNameTextbox("");
        registerPageObject.inputPasswordTextbox("");
        registerPageObject.inputConfirmPasswordTextbox("");
        registerPageObject.clickRegisterButton();
        Assert.assertEquals(registerPageObject.isCompletedRegisterMessageDisplayed(), "Your registration completed");
        registerPageObject.clickContinueButton();


    }
    @Test
    public void User_02_Login(){
        registerPageObject.clickOnLoginLink();
        loginPageObject = new LoginPageObject();
        loginPageObject.inputEmailTextbox("");
        loginPageObject.inputPasswordTextbox("");
        loginPageObject.clickOnLoginButton();

    }
    @Test
    public void User_03_Customer_Info(){
        homePageObject = new HomePageObject();
        homePageObject.clickOnMyAccountLink();
        customerInfoPageObject = new CustomerInfoPageObject();
        Assert.assertEquals(customerInfoPageObject.getFirstNameTextbox(), "");
        Assert.assertEquals(customerInfoPageObject.getLastNameTextbox(), "");
        Assert.assertEquals(customerInfoPageObject.getEmailTextbox(), "");
        Assert.assertEquals(customerInfoPageObject.getCompanyNameTextbox(), "");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
