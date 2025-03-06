package page.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import page.BaseContainerPage;
import page.goal.GoalAndCountdownPage;

import java.time.Duration;
import java.util.List;

public class TestClientPage extends BaseContainerPage {

    public static boolean createNewlyGoal = true;

    public TestClientPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageDisplayed() {
        return false;
    }

    @Override
    public BaseContainerPage clickBackButton() {
        return null;
    }

    @Override
    public BaseContainerPage open() {
        return null;
    }

    @FindBy(className = "add-btn")
    List<WebElement> btnCreate;

    @FindBy(className = "edit-icon")
    WebElement editNote;

    public void createGoalAndCountdown(String name, int pos) throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(btnCreate.get(pos), Duration.ofSeconds(3));
        if (name.equals("Goal")) {
            Assert.assertEquals(btnCreate.get(pos).getText(), "Goal");
        } else {
            Assert.assertEquals(btnCreate.get(pos).getText(), "Countdown");
        }
        btnCreate.get(pos).click();
        createNewlyGoal = true;
    }

    public void setEditNote() {
        editNote.click();
    }
}
