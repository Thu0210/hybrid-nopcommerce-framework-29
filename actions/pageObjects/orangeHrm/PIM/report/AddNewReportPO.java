package pageObjects.orangeHrm.PIM.report;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddNewReportPO extends BasePage {
    private WebDriver driver;
    public AddNewReportPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
