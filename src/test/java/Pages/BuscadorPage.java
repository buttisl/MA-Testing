package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BuscadorPage {

    WebDriver driver;
    WebDriverWait wait;

    public BuscadorPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToBuscador() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        WebElement busqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/div[3]/div/div/nav/div/form/input")));
        wait.until(ExpectedConditions.elementToBeClickable(busqueda));
        busqueda.sendKeys("Muniain");
        busqueda.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("figure.posts__thumb")));
        List<WebElement> noticias = driver.findElements(By.cssSelector("figure.posts__thumb"));
        System.out.println("Cantidad de noticias encontradas: " + noticias.size());
    }
}
