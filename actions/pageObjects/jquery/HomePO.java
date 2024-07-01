package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.HomePageUI;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_OR_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_OR_LINK, pageNumber);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_OR_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_OR_LINK, "class", pageNumber).contains("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendKey) {
        refreshPage(driver);
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendKey, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
        SleepInSecond(2);
    }

    public boolean isRowDataValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW,female,country,male,total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, female, country, male, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        SleepInSecond(2);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        SleepInSecond(2);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
        SleepInSecond(2);

    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        int columnNumber = findListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String columnIndex = String.valueOf(columnNumber);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnNumber = findListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String columnIndex = String.valueOf(columnNumber);
        selectionDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUnchecked) {
        int columnNumber = findListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        String columnIndex = String.valueOf(columnNumber);
        if(checkOrUnchecked){
            checkTheCheckBoxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AMD_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            unCheckTheCheckBox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AMD_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
    }
}
