package controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseController {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static BaseController instance = new BaseController();
    public static WebDriver driver;

    public void start() {
        initializeDriver("chrome", "https://dev.everfit.io/");
    }

    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
        driver.quit();
    }

    public synchronized WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            try {
                BaseController.instance.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driverThreadLocal.get();
    }

    @Parameters({"browser", "appUrl"})
    public void initializeDriver(String browser, String appUrl) {
        if (driverThreadLocal.get() == null) {
            if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.get(appUrl);
            driverThreadLocal.set(driver);
        }
        openBrowser(driver, appUrl);
    }

    private static void openBrowser(WebDriver driver, String appUrl) {
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
