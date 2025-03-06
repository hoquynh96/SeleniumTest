package stepDefinition;

import controller.BaseController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.BaseContainerPage;
import page.client.AllClientsPage;
import page.client.ClientsPage;
import page.client.TestClientPage;
import page.goal.GoalAndCountdownPage;

public class ClientsStepDef {
    static WebDriver driver;
    static ClientsPage clientsPage;
    static AllClientsPage allClientsPage;
    static TestClientPage testClientPage;
    static GoalAndCountdownPage goalAndCountdownPage;

    public ClientsStepDef() {
        driver = BaseController.instance.getDriver();
        clientsPage = new ClientsPage(driver);
        allClientsPage = new AllClientsPage(driver);
        testClientPage = new TestClientPage(driver);
        goalAndCountdownPage = new GoalAndCountdownPage(driver);
    }

    @Given("User verify to information in the Clients page")
    public void user_verify_to_information_in_the_clients_page() {
        clientsPage.verifyInformationPage();
    }

    @Then("User input your email address and your password in the Clients page")
    public void user_input_your_email_address_and_your_password_in_the_clients_page() throws InterruptedException {
        Thread.sleep(2000);
        clientsPage = new ClientsPage(driver);
        clientsPage.inputToEmailAddress("hanhle+test@everfit.io");
        clientsPage.inputPassword("Test2024");
        Thread.sleep(2000);
        clientsPage.clickLogin();
    }

    @Then("User verify to information in the Client Test page")
    public void userVerifyToInformationInTheClientTestPage() {
        clientsPage.verifyInformationPage();
    }

    @Then("User verify to information in the All Client page")
    public void userVerifyToInformationInTheAllClientPage() throws InterruptedException {
        clientsPage.verifyInformationPage();
    }

    @Given("User select client name {string} page")
    public void userSelectClientNamePage(String arg0) throws InterruptedException {
        allClientsPage.clickClientTest();
    }

    @When("User add choose Goal in the information of the Goal and Countdown")
    public void userAddChooseGoalInTheInformationOfTheGoalAndCountdown() throws InterruptedException {
        goalAndCountdownPage.addButtonGoal();
    }

    @Then("User verify to information in the Goal page")
    public void userVerifyToInformationInTheGoalPage() {
        goalAndCountdownPage.verifyToInformationPage();
    }

    @Then("User choose the Goal and Countdown")
    public void userChooseTheGoalAndCountdown() throws InterruptedException {
        testClientPage.createGoalAndCountdown("Goal", 0);
    }
}
