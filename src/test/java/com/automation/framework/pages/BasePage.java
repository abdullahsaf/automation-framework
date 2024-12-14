package com.automation.framework.pages;

import com.automation.framework.utils.LogUtil;
import jakarta.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;

    @Autowired
    protected LogUtil logUtil;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    public void jsClick(By by) {
        javascriptExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    protected void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilAlert() {
        wait.until((ExpectedConditions.alertIsPresent()));
    }

    protected void scrollToTheElement(WebElement element) {
        waitUntilElementVisible(element);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickElement(WebElement element) {
        waitUntilElementClickable(element);
        element.click();
    }

    protected void doubleClickElement(WebElement element) {
        waitUntilElementClickable(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }

    protected void typeInElement(WebElement element, String value) {
        waitUntilElementClickable(element);
        element.sendKeys(value);
    }

    protected void acceptAlert() {
        waitUntilAlert();
        driver.switchTo().alert().accept();
    }

    protected void cancelAlert() {
        waitUntilAlert();
        driver.switchTo().alert().dismiss();
    }

    protected void dragAndDrop(WebElement source, WebElement destination) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, destination).build().perform();
    }

    protected Boolean browserHasHistory(Integer historyLength) {
        return (Boolean) javascriptExecutor.executeScript(String.format("return window.history.length > %d;", historyLength));
    }

}
