package Test;

import DriverManager.BaseTest;
import Pages.ForoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ForoTest extends BaseTest {
    @Test
    public void goToForo(){
        ForoPage foroPage = new ForoPage(GetDriver(),GetWait());
        foroPage.goToForo();
    }
}
