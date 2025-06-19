package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NoticiaPage {

    WebDriver driver;
    WebDriverWait wait;

    public NoticiaPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToNoticia() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        WebElement busqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/div[3]/div/div/nav/div/form/input")));
        wait.until(ExpectedConditions.elementToBeClickable(busqueda));
        busqueda.sendKeys("Miguel dijo adiós");
        busqueda.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        WebElement noticia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Miguel dijo adiós']")));
        wait.until(ExpectedConditions.elementToBeClickable(noticia)).click();

        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='post__title']")));
        Assert.assertEquals(titulo.getText().trim(), "MIGUEL DIJO ADIÓS", "El título de la noticia no coincide con el esperado.");

    }
}
