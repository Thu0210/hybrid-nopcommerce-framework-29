package pageObjects.orangeHrm.PIM.report;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ReportSearchPO extends BasePage {
    private WebDriver driver;
    public ReportSearchPO(WebDriver driver){
        super(driver);
        this.driver = driver;

    }
}
