package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_03_BasePage_Inheritance extends BasePage {
    WebDriver driver;

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
        sendkeyToElement(driver, "//input[@id='FirstName']", "Le12");
        sendkeyToElement(driver, "//input[@id='LastName']", "Le12");
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthDay']", "10");
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthMonth']", "January");
        selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthYear']", "1918");
        sendkeyToElement(driver, "//input[@id='Email']", "lele1232@gmail.com");
        sendkeyToElement(driver, "//input[@id='Company']", "Test");
        sendkeyToElement(driver, "//input[@id='Password']", "123456");
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
        clickToElement(driver, "//button[@id='register-button']");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
