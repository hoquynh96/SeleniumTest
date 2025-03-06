package stepDefinition;

import controller.BaseController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.goal.CreateGoalPage;
import page.goal.GoalAndCountdownPage;
import page.goal.RemoveDialog;

public class GoalStepDefinition {

    static WebDriver driver;
    static GoalAndCountdownPage goalAndCountdownPage;
    static CreateGoalPage createGoalPage;
    static RemoveDialog removeDialog;

    public GoalStepDefinition() {
        driver = BaseController.instance.getDriver();
        goalAndCountdownPage = new GoalAndCountdownPage(driver);
        createGoalPage = new CreateGoalPage(driver);
        removeDialog = new RemoveDialog(driver);
    }

    @Given("User input to information new Goal successfully")
    public void userInputToInformationNewGoalSuccessfully() throws InterruptedException {
        createGoalPage.inputTextGoal("abcde");
        Thread.sleep(2000);
        createGoalPage.clickCreateButton();
    }

    @Then("User verify to newly entered information")
    public void userVerifyToNewlyEnteredInformation() {
        goalAndCountdownPage.verifyToInformationPage();
    }

    @Given("User select to edit button")
    public void userSelectToEditButton() throws InterruptedException {
        goalAndCountdownPage.addOrSetInformationGoal();
        createGoalPage.inputTextGoal("gghh3k4j");
        createGoalPage.clickCreateButton();
    }

    @Then("User input newly information of Goal successfully")
    public void userInputNewlyInformationOfGoalSuccessfully() {
        goalAndCountdownPage.verifyInformAfterUpdate("gghh3k4j");
    }

    @Given("User select to delete button")
    public void userSelectToDeleteButton() {
        goalAndCountdownPage.deleteInformationGoal();
    }

    @Then("User delete information of Goal successfully")
    public void userDeleteInformationOfGoalSuccessfully() {
        removeDialog.clickDeleteButton();
    }

    @Then("User delete information of Goal is fail")
    public void userDeleteInformationOfGoalIsFail() {
        removeDialog.clickCancelButton();
    }

    @Then("User input newly information of Goal is fail")
    public void userInputNewlyInformationOfGoalIsFail() {

    }
}
