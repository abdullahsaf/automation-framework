package com.automation.framework.pages;

import com.automation.framework.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;

@LazyComponent
public class TestPage extends BasePage {
    @FindBy(linkText = "This is a link")
    @CacheLookup
    private WebElement linkTextField;

    @FindBy(xpath = "//p[text()='TextBox : ']/input")
    @CacheLookup
    private WebElement textBoxField;

    @FindBy(xpath = "//p[text()='Button : ']/button[text()='Submit']")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(id = "dblClkBtn")
    @CacheLookup
    private WebElement dblClkBtn;

    @FindBy(id = "male")
    @CacheLookup
    private WebElement maleRadio;

    @FindBy(id = "female")
    @CacheLookup
    private WebElement femaleRadio;

    @FindBy(xpath = "//input[@type='checkbox'][@value='Automation']")
    @CacheLookup
    private WebElement automationCheckbox;

    @FindBy(xpath = "//input[@type='checkbox'][@value='Performance']")
    @CacheLookup
    private WebElement performanceCheckbox;

    @FindBy(id = "testingDropdown")
    @CacheLookup
    private WebElement dropdown;

    @FindBy(xpath = "//div[@id='AlertBox']/button")
    @CacheLookup
    private WebElement alertBoxButton;

    @FindBy(xpath = "//div[@id='ConfirmBox']/button")
    @CacheLookup
    private WebElement confirmBoxButton;

    @FindBy(xpath = "//div[@id='ConfirmBox']/button/following-sibling::p")
    @CacheLookup
    private WebElement confirmationText;

    @FindBy(id = "targetDiv")
    @CacheLookup
    private WebElement dragTarget;

    @FindBy(xpath = "//img[@draggable='true'][@alt='art of testing']")
    @CacheLookup
    private WebElement draggableImage;

    @Value("${application.url}")
    private String baseURL;

    public TestPage goToPage() {
        driver.get(baseURL);
        return this;
    }

    public void clickLinkText() {
        clickElement(linkTextField);
    }

    public void typeInTextbox(String value) {
        typeInElement(textBoxField, value);
    }

    public void clickSubmitButton() {
        clickElement(submitButton);
    }

    public String getBackgroundColorSubmitButton() {
        return submitButton.getDomAttribute("style");
    }

    public void doubleClickDblClkBtn() {
        doubleClickElement(dblClkBtn);
    }

    public void acceptAlertBox() {
        acceptAlert();
    }

    public void cancelConfirmBox() {
        cancelAlert();
    }

    public void selectRadioButton(String gender) {
        WebElement element = gender.equalsIgnoreCase("male") ? maleRadio : femaleRadio;
        clickElement(element);
    }

    public void selectFromDropdown(String option) {
        Select selectBox = new Select(dropdown);
        selectBox.selectByVisibleText(option);
    }

    public void selectCheckbox(String option) {
        WebElement element = option.equalsIgnoreCase("automation") ? automationCheckbox : performanceCheckbox;
        clickElement(element);
    }

    public void clickGenerateAlertButton() {
        clickElement(alertBoxButton);
    }

    public void clickGenerateConfirmButton() {
        clickElement(confirmBoxButton);
    }

    public String getConfirmationTextAfterConfirm() {
        return confirmationText.getText();
    }

    public void dragImageToTarget() {
        dragAndDrop(draggableImage, dragTarget);
    }

    public Boolean hasTargetPopulated() {
        List<WebElement> children = dragTarget.findElements(By.xpath(".//*"));
        return children.contains(draggableImage);
    }

    public Boolean hasHistory() {
        return browserHasHistory(2);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> Objects.equals(this.driver.getCurrentUrl(), baseURL));
    }
}
