package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgendaPage {

    WebDriver driver;
    WebDriverWait wait;

    public AgendaPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToAgenda() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        WebElement agenda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='AGENDA']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", agenda);

        Assert.assertTrue(agenda.getText().contains("AGENDA"), "No se encontró la agenda del próximo partido");
    }
}
