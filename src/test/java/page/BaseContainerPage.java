package page;

import controller.BaseController;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.client.AllClientsPage;
import page.client.ClientsPage;
import page.client.TestClientPage;
import page.goal.CreateGoalPage;
import page.goal.GoalAndCountdownPage;
import page.goal.RemoveDialog;

import java.time.Duration;

public abstract class BaseContainerPage {

    private static WebDriver driver;

    public BaseContainerPage(WebDriver driver) {
        this.driver = driver;
        driver = BaseController.instance.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Get Web driver
     *
     * @return Web driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Check page is displayed
     */
    public abstract boolean isPageDisplayed();

    /**
     * Click back button
     */
    public abstract BaseContainerPage clickBackButton();

    /**
     * Navigate to page
     */
    public abstract BaseContainerPage open();

    /**
     * Check element displayed for pages
     */
    public boolean isElementDisplayed(WebElement element, Duration timeOutInSecond) {
        boolean isVisible = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            if (wait.until(ExpectedConditions.visibilityOf(element)) != null) {
                isVisible = true;
            }
        } catch (Exception e) {
            // No-opt
        }
        return isVisible;
    }
}
