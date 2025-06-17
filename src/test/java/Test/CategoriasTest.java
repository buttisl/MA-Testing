package Test;

import DriverManager.BaseTest;
import Pages.CategoriasPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriasTest extends BaseTest {
    @Test
    public void goToCategoria(){
        CategoriasPage categoriasPage = new CategoriasPage(GetDriver(),GetWait());
        categoriasPage.goToCategorias("Institucionales");

        String currentUrl = GetDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains("institucionales"),
                "La URL no contiene 'institucionales': " + currentUrl);
    }
}
