package Test;

import DriverManager.BaseTest;
import Pages.FlujoNavegacionPage;
import org.testng.annotations.Test;

public class FlujoNavegacionTest extends BaseTest {
    @Test
    public void flujoCompleto() throws InterruptedException{
        FlujoNavegacionPage flujoNavegacionPage = new FlujoNavegacionPage(GetDriver(),GetWait());
        flujoNavegacionPage.FlujoCompleto();

    }
}
