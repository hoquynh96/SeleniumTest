package page.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BaseContainerPage;

import java.time.Duration;
import java.util.List;

public class AllClientsPage extends BaseContainerPage {

    public AllClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "add-button__single")
    WebElement btnAddClient;
    @FindBy(className = "add-button__multiple")
    WebElement chooseAddClients;

    @FindBy(className = "menu__item")
    List<WebElement> addItemClient;
    @FindBy(css = ".detail.name-client")
    WebElement clientTest;

    @Override
    public boolean isPageDisplayed() {
        isElementDisplayed(btnAddClient);
        return btnAddClient.isDisplayed();
    }

    @Override
    public BaseContainerPage clickBackButton() {
        return null;
    }

    @Override
    public BaseContainerPage open() {
        return null;
    }

    public void clickButtonAddClient() {
        btnAddClient.click();
    }

    public void clickClientTest() throws InterruptedException {
        Thread.sleep(3000);
        isElementDisplayed(clientTest, Duration.ofSeconds(3));
        clientTest.click();
    }
}
