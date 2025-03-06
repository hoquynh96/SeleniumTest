package page.goal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BaseContainerPage;

public class RemoveDialog extends BaseContainerPage {

    public RemoveDialog(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "confirm-content-label")
    WebElement textContent;
    @FindBy(xpath = "//button[contains(text()='Remove')]")
    WebElement btnRemove;
    @FindBy(xpath = "//button[contains(text()='Cancel')]")
    WebElement btnCancel;

    @Override
    public boolean isPageDisplayed() {
        return textContent.isDisplayed();
    }

    @Override
    public BaseContainerPage clickBackButton() {
        return null;
    }

    @Override
    public BaseContainerPage open() {
        return null;
    }

    public void clickDeleteButton() {
        btnRemove.click();
    }

    public void clickCancelButton() {
        btnCancel.click();
    }
}
