package page.client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import page.BaseContainerPage;

import java.time.Duration;

public class ClientsPage extends BaseContainerPage {

    public ClientsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text()='Log in to Everfit')]")
    WebElement title;
    @FindBy(css = "input[placeholder='Your Email Address']")
    WebElement email;
    @FindBy(css = "input[placeholder='Password']")
    WebElement password;
    @FindBy(className = "checkbox-icon")
    WebElement checkbox;
    @FindBy(css = ".sc-gfiWVN.cJhtDK")
    WebElement btnSubmit;

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

    public void verifyInformationPage() {
//        Assert.assertEquals(title.getText(), "Log in to Everfit");
//        Assert.assertEquals(email.getText(), "Your Email Address");
//        Assert.assertEquals(password.getText(), "Password");
        System.out.println("Your Email Address");
        System.out.println("Password");
    }

    public void inputToEmailAddress(String name) throws InterruptedException {
        isElementDisplayed(email, Duration.ofSeconds(3));
        email.click();
        email.sendKeys(name);
    }

    public void inputPassword(String name) throws InterruptedException {
        isElementDisplayed(password, Duration.ofSeconds(3));
        password.click();
        password.sendKeys(name);
    }

    public void clickCheckboxRemember() {
        checkbox.click();
    }

    public void clickLogin() {
        isElementDisplayed(btnSubmit, Duration.ofSeconds(3));
        if (btnSubmit.isEnabled()) {
            btnSubmit.click();
        }
    }
}
