package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class EncuestaPage {

    WebDriver driver;
    WebDriverWait wait;

    public EncuestaPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToEncuesta() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Encuesta']")));

        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sidebar']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sidebar);

        Thread.sleep(2000);

        Assert.assertTrue(sidebar.getText().contains("ENCUESTA"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Sí, era su momento']//span[@class='radio-indicator']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();

        List<WebElement> resultados = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//*[@id='encuestaDatos']//div[contains(text(), '-') and contains(text(), '%')]")
        ));

        System.out.println("Resultados de la encuesta:");
        for (WebElement resultado : resultados) {
            System.out.println("• " + resultado.getText());
        }
    }
}