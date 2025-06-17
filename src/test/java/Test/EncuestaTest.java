package Test;

import DriverManager.BaseTest;
import Pages.EncuestaPage;
import org.testng.annotations.Test;

public class EncuestaTest extends BaseTest {
    @Test
    public void goToEncuesta() throws InterruptedException {
        EncuestaPage encuestaPage = new EncuestaPage(GetDriver(),GetWait());
        encuestaPage.goToEncuesta();

    }

}
