package page.goal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BaseContainerPage;

import java.time.Duration;

public class CreateGoalPage extends BaseContainerPage {

    public CreateGoalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "edit-goal-input")
    WebElement inputGoal;
    @FindBy(css = ".ui.button.close-button")
    WebElement btnClose;
    @FindBy(xpath = "button.sc-bxivhb.sc-sJJJd.gmZMGH")
    WebElement btnCreate;

    @Override
    public boolean isPageDisplayed() {
        return inputGoal.isDisplayed();
    }

    @Override
    public BaseContainerPage clickBackButton() {
        return null;
    }

    @Override
    public BaseContainerPage open() {
        return null;
    }


    public void inputTextGoal(String text) throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(inputGoal, Duration.ofSeconds(10));
//        inputGoal.click();
        inputGoal.clear();
        inputGoal.sendKeys(text);
    }

    public void closeCreateGoal() {
        btnClose.click();
    }

    public void clickCreateButton() {
        isElementDisplayed(btnCreate, Duration.ofSeconds(3));
        if (btnCreate.isEnabled()) {
            btnCreate.click();
        }
    }
}
