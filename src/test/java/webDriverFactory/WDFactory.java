package webDriverFactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Locale;

public class WDFactory {

    public static WebDriver getDriver(Browsers driverName) {
        switch (driverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case FIREFOX:
                WebDriverManager.operadriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + driverName);
        }
    }

    public static WebDriver getDriver(String driverName){
        driverName = driverName.toUpperCase(Locale.ROOT);
        switch (driverName){
            case "CHROME":
                return getDriver(Browsers.CHROME);
            case "OPERA":
                return getDriver(Browsers.OPERA);
            case "FIREFOX":
                return getDriver(Browsers.FIREFOX);
            default: WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
