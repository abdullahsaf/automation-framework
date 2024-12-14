package com.automation.framework.cucumber.steps;

import com.automation.framework.annotations.LazyAutowired;
import com.automation.framework.pages.TestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TestSteps {

    @LazyAutowired
    TestPage testPage;

    @Given("User clicks on link text")
    public void userClicksOnLinkText() {
        testPage.clickLinkText();
    }

    @When("User type {string} in textbox")
    public void userTypeInTextbox(String name) {
        testPage.typeInTextbox(name);
    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() {
        testPage.clickSubmitButton();
    }

    @Then("submit button turns blue")
    public void submitButtonTurnsBlue() {
        Assertions.assertEquals("background: blue;", testPage.getBackgroundColorSubmitButton());
    }

    @When("User clicks double click button")
    public void userClicksDoubleClickButton() {
        testPage.doubleClickDblClkBtn();
    }

    @And("accept the alert box")
    @And("accept the confirm box")
    public void acceptTheAlertBox() {
        testPage.acceptAlertBox();
    }

    @And("cancel the confirm box")
    public void cancelTheConfirmBox() {
        testPage.cancelConfirmBox();
    }

    @When("click {string} radio button")
    public void clickRadioButton(String gender) {
        testPage.selectRadioButton(gender);
    }

    @And("check {string} testing checkbox")
    public void checkTestingCheckbox(String testing) {
        testPage.selectCheckbox(testing);
    }

    @And("select {string} from dropdown")
    public void selectFromDropdown(String option) {
        testPage.selectFromDropdown(option);
    }

    @When("user clicks on generate alert box")
    public void userClicksOnGenerateAlertBox() {
        testPage.clickGenerateAlertButton();
    }

    @When("user clicks on generate confirm box")
    public void userClicksOnGenerateConfirmBox() {
        testPage.clickGenerateConfirmButton();
    }

    @And("the confirmation text is {string}")
    public void theConfirmationTextIs(String expectedValue) {
        Assertions.assertEquals(expectedValue, testPage.getConfirmationTextAfterConfirm());
    }

    @When("drag image to target box")
    public void dragImageToTargetBox() {
        testPage.dragImageToTarget();
    }

    @Then("the image is placed in target box")
    public void theImageIsPlacedInTargetBox() {
        Assertions.assertTrue(testPage.hasTargetPopulated());
    }

    @Then("the page loads")
    public void thePageLoads() {
        Assertions.assertTrue(testPage.hasHistory());
    }

    @Given("user is on the testing page")
    public void userIsOnTheTestingPage() {
        testPage.goToPage();
    }
}
