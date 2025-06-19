package Test;

import DriverManager.BaseTest;
import Pages.RedesPage;
import org.testng.annotations.Test;

public class RedesTest extends BaseTest {
    @Test
    public void goToRedes(){
        RedesPage redesPage = new RedesPage(GetDriver(),GetWait());
        redesPage.goToRedes("Youtube");
    }
}
