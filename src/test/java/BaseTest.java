import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

import static webDriverFactory.WDFactory.getDriver;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);
    String driverName = "Chrome"; //System.getProperty("browser").toUpperCase(Locale.ROOT); // TODO Как перенести в WDF, а потом прокинуть driverName в BaseTest?


    @BeforeClass
    public void setupWebDriverManager() {
        driver = getDriver(driverName);

    }

    @BeforeMethod
    public void setupWebDriver() {
        setUpDriverSession();
    }

    @AfterMethod
    public void end() {
        if (driver != null)
            driver.quit();
    }

    private void setUpDriverSession() { //TODO как сделать универсальную реализацию под любой вебдрайвера, а не только под хром?
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");

//        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // TODO Поподробнее что это такое????

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        logger.info("Драйвер поднят");
    }
}
