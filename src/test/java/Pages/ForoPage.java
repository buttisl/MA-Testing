package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ForoPage {

    WebDriver driver;
    WebDriverWait wait;

    public ForoPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToForo(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, 'foro')])[2]"))).click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://foro.mundoazulgrana.com.ar/"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://foro.mundoazulgrana.com.ar/", "No se abrió la URL del Foro correctamente");
    }

}
