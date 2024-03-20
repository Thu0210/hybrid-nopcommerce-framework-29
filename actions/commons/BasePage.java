package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }
    public String getTitlePage(WebDriver driver){
        return driver.getTitle();
    }
    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public void backPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());

    }
    public void acceptAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }
    public void cancelAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }
    public String getTextAlert(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String sendKey){
        driver.switchTo().alert().sendKeys(sendKey);
    }
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public WebElement findElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    public void clickToElement(WebDriver driver, String locator){
        findElement(driver, locator).click();
    }
    public void sendkeyToElement(WebDriver driver, String locator, String keyToSend){
        findElement(driver, locator).sendKeys(keyToSend);
    }
//    public void selectionDropdown(WebDriver driver, String locator){
//        new Select(findElement(driver, locator));
//    }
    public void selectItemInDropdownByVisibletext(WebDriver driver, String locator, String text){
        new Select(findElement(driver, locator)).selectByVisibleText(text);
    }
    public void selectItemInDropDownById(WebDriver driver, String locator, int index){
        new Select(findElement(driver, locator)).selectByIndex(index);
    }
    public List<WebElement> getAllSelectedOption(WebDriver driver, String locator){
         return new Select(findElement(driver, locator)).getAllSelectedOptions();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
       return new Select(findElement(driver, locator)).isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        findElement(driver, parentLocator).click();
        SleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
    }
    public void SleepInSecond(int milisecond){
        try {
            Thread.sleep(milisecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
