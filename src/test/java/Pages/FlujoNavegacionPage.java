package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlujoNavegacionPage {
    WebDriver driver;
    WebDriverWait wait;

    public FlujoNavegacionPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void FlujoCompleto() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));

        //Buscar noticia
        WebElement buscador = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/div[3]/div/div/nav/div/form/input")));
        wait.until(ExpectedConditions.elementToBeClickable(buscador));
        buscador.sendKeys("Miguel dijo adiós");
        buscador.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));

        //Validar resultado y entrar
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Miguel dijo adiós']")));
        Assert.assertTrue(resultado.isDisplayed(), "Resultado visible");
        resultado.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));

        //Validar que se abre la noticia
        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='post__title']")));
        Assert.assertEquals(titulo.getText().trim(), "MIGUEL DIJO ADIÓS");

        //Volver al inicio
        driver.navigate().to("https://mundoazulgrana.com.ar");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));

        //Ir a Categoría desde el menú principal
        WebElement categoria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Institucionales']")));
        categoria.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));

        //Validar que estamos en la categoría seleccionada
        String expectedUrl = "https://mundoazulgrana.com.ar/sanlorenzo/noticias/categoria/institucionales/153";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "La URL luego del click en Institucionales no es la esperada.");
    }
}
