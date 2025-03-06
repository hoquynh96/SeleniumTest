package container;

import controller.BaseController;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.client.AllClientsPage;
import page.client.ClientsPage;
import page.client.TestClientPage;
import page.goal.CreateGoalPage;
import page.goal.GoalAndCountdownPage;

import java.io.File;

public class Hooks {

    static WebDriver driver;
    static AllClientsPage allClientsPage;
    static ClientsPage clientsPage;
    static TestClientPage testClientPage;
    static GoalAndCountdownPage goalAndCountdownPage;
    static CreateGoalPage createGoalPage;

    public Hooks() {
        driver = BaseController.instance.getDriver();
    }

    @AfterMethod
    public void checkAfterMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
//    @Test(priority = 1)
//        public void openToAllClientsPage () throws InterruptedException {
//            Thread.sleep(2000);
//            clientsPage = new ClientsPage(driver);
//            clientsPage.inputToEmailAddress("hanhle+test@everfit.io");
//            clientsPage.inputPassword("Test2024");
//            Thread.sleep(2000);
//            clientsPage.clickLogin();
//        }
//
//    @Test(priority = 2)
//        public void openToClientPage () throws InterruptedException {
//            allClientsPage = new AllClientsPage(driver);
//            allClientsPage.clickClientTest();
//        }
//
//    @Test(priority = 3)
//        public void openGoalAndCountdownPage () throws InterruptedException {
//            testClientPage = new TestClientPage(driver);
//            testClientPage.createGoalAndCountdown("Goal", 0);
//        }
//
//    @Test(priority = 4)
//        public void openCreateGoalPage () throws InterruptedException {
//            goalAndCountdownPage = new GoalAndCountdownPage(driver);
////            goalAndCountdownPage.addButtonGoal();
//        }
//
//    @Test(priority = 5)
//        public void createGoalPageSuccess () throws InterruptedException {
//            createGoalPage = new CreateGoalPage(driver);
//            createGoalPage.inputTextGoal("abcde");
//            createGoalPage.clickCreateButton();
//        }
}
