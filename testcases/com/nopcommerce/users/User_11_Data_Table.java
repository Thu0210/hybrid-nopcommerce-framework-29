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
    @Test
    public void Table_04_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/#google_vignette");
        homePage.clickToLoadDataButton();
        homePage.enterToTextboxByIndex("4", "Contact Person", "John");
        homePage.enterToTextboxByIndex("2", "Company", "Google");
        homePage.selectToDropdownByIndex("5", "Country", "HongKong");
        homePage.selectToDropdownByIndex("8", "Country", "India");
        homePage.checkToCheckboxByIndex("3", "NPO", true);
        homePage.checkToCheckboxByIndex("5", "NPO", false);
        homePage.clickToIconByIndex("8", "Move up");
        homePage.clickToIconByIndex("7", "Remove");
        homePage.clickToIconByIndex("6", "Insert");




    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
