package page.goal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import page.BaseContainerPage;
import page.client.TestClientPage;

import java.time.Duration;

public class GoalAndCountdownPage extends BaseContainerPage {

    public static boolean isDeclareGoal = true;

    public GoalAndCountdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text()='Goal')]")
    WebElement titleGoal;
    @FindBy(className = "add-goal-btn")
    WebElement btnAddGoal;

    @FindBy(xpath = "//div[contains(text()='General goal')]")
    WebElement titleGeneralGoal;
    @FindBy(css = "div.sc-kBYkOU.cSOHhg.goal-actions")
    WebElement iconPoint;
    @FindBy(xpath = "//span[contains(text()='Edit')]")
    WebElement iconEdit;
    @FindBy(xpath = "//span[contains(text()='Remove')]")
    WebElement iconDelete;
    @FindBy(className = "goal-text")
    WebElement textUpdate;

    @FindBy(css = ".ui.button.close-button")
    WebElement btnClose;
    @FindBy(css = ".tab.active")
    WebElement goal;
    @FindBy(className = "tab")
    WebElement countdown;

    @Override
    public boolean isPageDisplayed() {
        return goal.isDisplayed();
    }

    @Override
    public BaseContainerPage clickBackButton() {
        return null;
    }

    @Override
    public BaseContainerPage open() {
        return null;
    }

    public void clickClose() {
        btnClose.click();
    }

    public void addButtonGoal() throws InterruptedException {
        Thread.sleep(3000);
//        isElementDisplayed(btnAddGoal, Duration.ofSeconds(10));
        btnAddGoal.click();
        isDeclareGoal = false;
    }

    public void addOrSetInformationGoal() throws InterruptedException {
        if (TestClientPage.createNewlyGoal == isDeclareGoal) {
            //When user add first goal
            addButtonGoal();
        } else {
            //When user add goal success, display shown on information goal
            isElementDisplayed(iconPoint, Duration.ofSeconds(3));
            iconPoint.click();
        }
    }

    public void editInformationGoal() {
        iconEdit.click();
    }

    public void deleteInformationGoal() {
        iconDelete.click();
    }

    public void verifyInformAfterUpdate(String text) {
        Assert.assertEquals(titleGeneralGoal.getText(), "General goal");
        Assert.assertEquals(textUpdate.getText(), text);
    }

    public void verifyToInformationPage() {
        Assert.assertEquals(titleGoal.getText(), "Goal");
        Assert.assertEquals(goal.getText(), "Goal");
        Assert.assertEquals(btnAddGoal.getText(), "Add goal");
        Assert.assertEquals(countdown.getText(), "Countdown");
    }

}
