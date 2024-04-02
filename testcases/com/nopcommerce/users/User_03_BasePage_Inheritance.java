package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_03_BasePage_Inheritance extends BasePage {
    WebDriver driver;
    String firsName = "Lele", lastName ="LeNa", dayOfBirth = "10", monthOfBirth = "January",
            yearofBirth = "1998", email = "lele1202@gmail.com", companyName ="TestAutomation", password = "123456";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void User_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//input[@id='gender-female']");
        sendkeyToElement(driver, "//input[@id='FirstName']", firsName);
        sendkeyToElement(driver, "//input[@id='LastName']", lastName);
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthDay']", dayOfBirth);
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthMonth']", monthOfBirth);
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthYear']", yearofBirth);
        sendkeyToElement(driver, "//input[@id='Email']", email);
        sendkeyToElement(driver, "//input[@id='Company']", companyName);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        clickToElement(driver, "//button[@id='register-button']");

    }
    @Test
    public void User_02_Login(){
        waitForElementClickable(driver, "//a[contains(@class,\"ico-login\")]");
        clickToElement(driver, "//a[@class='ico-login']");
        sendkeyToElement(driver,"//input[@id='Email']", email );
        sendkeyToElement(driver, "//input[@id='Password']", password);
        clickToElement(driver, "//button[contains(@class,\"login-button\")]");
        Assert.assertTrue(isElementDisplayed(driver, "//a[contains(@class,\"ico-account\")]"));
    }
    @Test
    public void User_03_Customer_Info(){
        waitForElementPresence(driver, "//a[contains(@class,\"ico-account\")]");
        waitForElementClickable(driver, "//a[contains(@class,\"ico-account\")]");
        clickToElement(driver, "//a[contains(@class,\"ico-account\")]");
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), firsName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"),email);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
