package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageUIs.*;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static BasePage getBasePage(){
        return new BasePage(getBasePage().driver);
    }
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
        return driver.findElement(getByLocator(locator));
    }
    public List<WebElement> findlistElements(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    public By elementBy (String locator){
       return getByLocator(locator);
    }
    public void clickToElement(WebDriver driver, String locator){
        findElement(driver, locator).click();
    }
    public void clickToElement(WebDriver driver, String locator, String... values){
        findElement(driver, castRestParameter(locator, values)).click();
    }
    public void sendkeyToElement(WebDriver driver, String locator, String keyToSend){
        findElement(driver, locator).sendKeys(keyToSend);
    }
    public void sendkeyToElement(WebDriver driver, String locator, String keyToSend, String... values){
        findElement(driver, castRestParameter(locator, values)).sendKeys(keyToSend);
    }
//    public void selectionDropdown(WebDriver driver, String locator){
//        new Select(findElement(driver, locator));
//    }
    public void selectItemInDropdownByVisibletext(WebDriver driver, String locator, String text){
        new Select(findElement(driver, locator)).selectByVisibleText(text);
    }

    public void selectItemInDropdownByValue(WebDriver driver, String locator, String value){
        new Select(findElement(driver, locator)).selectByValue(value);
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
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
    }
    public String getAttributeValue(WebDriver driver, String locator, String attributeName){
        return findElement(driver, locator).getAttribute(attributeName);
    }
    public String getTextElement(WebDriver driver, String locator){
        return findElement(driver, locator).getText();

    }
    public String getCSSValue(WebDriver driver, String locator, String cssValue){
        return findElement(driver, locator).getCssValue(cssValue);
    }
    public String getCssValue(WebDriver driver, String locator,String cssValue, String... values){
        return findElement(driver, castRestParameter(locator, values)).getCssValue(cssValue);
    }
    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getElementSize(WebDriver driver, String locator){
        return findlistElements(driver, locator).size();
    }
    public void checkTheCheckBoxOrRadio( WebDriver driver, String locator){
        if(!findElement(driver, locator).isSelected()){
            findElement(driver, locator).click();
        }
    }
    public void unCheckTheCheckBox( WebDriver driver, String locator){
        if(findElement(driver, locator).isSelected()){
            findElement(driver, locator).click();
        }
    }
    public Boolean isElementDisplayed (WebDriver driver, String locator){
        return findElement(driver, locator).isDisplayed();
    }
    public Boolean isElementDisplayed (WebDriver driver, String locator, String...values){
        return findElement(driver, castRestParameter(locator, values)).isDisplayed();
    }
    public Boolean isElementSelected (WebDriver driver, String locator){
        return findElement(driver, locator).isSelected();
    }
    public Boolean isElementSelected (WebDriver driver, String locator, String...values){
        return findElement(driver, castRestParameter(locator, values)).isSelected();
    }
    public Boolean isElementEnabled (WebDriver driver, String locator){
        return findElement(driver, locator).isEnabled();
    }
    public Boolean isElementEnabled (WebDriver driver, String locator, String...values){
        return findElement(driver, castRestParameter(locator, values)).isEnabled();
    }
    public void switchToIframe(WebDriver driver, String locator){
        driver.switchTo().frame(findElement(driver, locator));
    }
    public void switchToDefaultPage(WebDriver driver, String locator){
        driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(findElement(driver,locator)).perform();
    }
    public void clickAndHoverToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(findElement(driver,locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(findElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(findElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator, String...values){
        new Actions(driver).contextClick(findElement(driver, castRestParameter(locator, values))).perform();
    }
    public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator){
        new Actions(driver).dragAndDrop(findElement(driver,sourceLocator), findElement(driver, targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(findElement(driver, locator), keys).perform();
    }
    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(findElement(driver, locator));
    }
    public void scrollToElement(WebDriver driver, String locator, String...values){
        new Actions(driver).scrollToElement(findElement(driver, castRestParameter(locator, values)));
    }
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = findElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        SleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(driver, locator));
        SleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", findElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", findElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", findElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", findElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", findElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", findElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                findElement(driver, locator));
    }
    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator, String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator, values))));
    }
    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(elementBy(locator)));
    }
    public void waitForElementPresence(WebDriver driver, String locator, String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(elementBy(castRestParameter(locator, values))));
    }
    public void waitForElementInVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(elementBy(locator)));
    }
    public void waitForElementInVisible(WebDriver driver, String locator, String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(elementBy(castRestParameter(locator, values))));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(elementBy(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator, String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(elementBy(castRestParameter(locator, values))));
    }

    private String castRestParameter(String locator, String... values){
        return String.format(locator, (Object[]) values);
    }

    private By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.startsWith("CSS") || prefixLocator.startsWith("css") || prefixLocator.startsWith("Css")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.startsWith("id=") || prefixLocator.startsWith("ID=") || prefixLocator.startsWith("Id=")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("name=") || prefixLocator.startsWith("Name=") || prefixLocator.startsWith("Name=")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.startsWith("tagname=")|| prefixLocator.startsWith("Tagname=") || prefixLocator.startsWith("Tagname=")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.startsWith("class=") || prefixLocator.startsWith("Class=") || prefixLocator.startsWith("Class=")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("xpath=")|| prefixLocator.startsWith("Xpath=") || prefixLocator.startsWith("Xpath=")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator is not correct");
        }
        return by;
    }

    public void SleepInSecond(int milisecond){
        try {
            Thread.sleep(milisecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
