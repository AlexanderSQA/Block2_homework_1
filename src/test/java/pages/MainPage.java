package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(MainPage.class);
    protected final String BASE_URL = "https://otus.ru";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(WebDriver driver){
        driver.get(BASE_URL);
        logger.info("Сайт открыт");
    }

}
