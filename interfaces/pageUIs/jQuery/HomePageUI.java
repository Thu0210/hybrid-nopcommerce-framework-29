package pageUIs.jQuery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_OR_LINK = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME = "Xpath=//div[@class='qgrd-header-text' and text() ='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "Xpath=//td[@data-key='females'and text()= '%s']/following-sibling" +
            "::td[@data-key='country'and text()='%s']/following-sibling" +
            "::td[@data-key='males'and text()='%s']/following-sibling" +
            "::td[@data-key='total'and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME = "Xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME= "Xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'edit')]";

}
