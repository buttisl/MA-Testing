package Test;

import DriverManager.BaseTest;
import Pages.AgendaPage;
import org.testng.annotations.Test;

public class AgendaTest extends BaseTest {
    @Test
    public void goToAgenda() throws InterruptedException {
        AgendaPage agendaPage = new AgendaPage(GetDriver(),GetWait());
        agendaPage.goToAgenda();
    }
}
