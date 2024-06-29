package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;


public class User_11_Data_Table extends BaseTest {
    WebDriver driver;
    HomePO homePage;
    @Parameters({"browser", "URL"})

    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);

    }

//    @Test
    public void Table_01_Piagination() {
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));
        homePage.openPageByNumber("20");
        Assert.assertTrue(homePage.isPageNumberActived("20"));
        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageNumberActived("10"));

    }
//    @Test
    public void Table_02_Search() {
        homePage.enterToTextboxByHeaderName("Country", "Algeria");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("283821", "Algeria", "295140", "578961"));
        homePage.refreshPage(driver);
        homePage.enterToTextboxByHeaderName("Males", "276472");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("276880", "Angola", "276472", "553353"));
        homePage.refreshPage(driver);
        homePage.enterToTextboxByHeaderName("Females", "384187");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187", "Afghanistan", "407124", "791312"));
        homePage.refreshPage(driver);

    }
    @Test
    public void Table_03_Delete_Edit() {
        homePage.enterToTextboxByHeaderName("Country", "Algeria");
        homePage.deleteRowByCountryName("Algeria");
        homePage.refreshPage(driver);
        homePage.enterToTextboxByHeaderName("Country", "Angola");
        homePage.deleteRowByCountryName("Angola");
        homePage.refreshPage(driver);
        homePage.enterToTextboxByHeaderName("Country", "Aruba");
        homePage.editRowByCountryName("Aruba");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
