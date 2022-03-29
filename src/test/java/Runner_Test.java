import org.testng.annotations.Test;
import pages.MainPage;

import java.util.function.Predicate;

public class Runner_Test extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage(driver);


    }
}
