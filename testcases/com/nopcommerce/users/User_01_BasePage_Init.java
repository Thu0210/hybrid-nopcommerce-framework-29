package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_BasePage_Init {
    WebDriver driver;
    BasePage basePage;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage(driver);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void User_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//input[@id='gender-female']");
        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Le");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Le");
        basePage.selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthDay']", "10");
        basePage.selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthMonth']", "January");
        basePage.selectItemInDropdownByVisibletext(driver, "//select[@name='DateOfBirthYear']", "1918");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", "lele123@gmail.com");
        basePage.sendkeyToElement(driver, "//input[@id='Company']", "Test");
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
