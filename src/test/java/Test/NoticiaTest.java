package Test;

import DriverManager.BaseTest;
import Pages.NoticiaPage;
import org.testng.annotations.Test;

public class NoticiaTest extends BaseTest {
    @Test
    public void goToNotica(){
        NoticiaPage noticiaPage = new NoticiaPage(GetDriver(),GetWait());
        noticiaPage.goToNoticia();

    }
}
