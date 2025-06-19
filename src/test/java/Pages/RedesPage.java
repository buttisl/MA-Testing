package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RedesPage {

    WebDriver driver;
    WebDriverWait wait;

    public RedesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToRedes(String redes){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        String xpath = "//a[@href and normalize-space()='" + redes + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();


        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://www.youtube.com/@mundoazulgrana"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.youtube.com/@mundoazulgrana", "No se abrió la URL de YouTube correctamente");


        /* -- X -- */

        /* wait.until(ExpectedConditions.urlToBe("https://x.com/MundoAzulgrana/"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://x.com/MundoAzulgrana/", "No se abrió la URL de X correctamente");
         */

        /* -- TikTok -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.tiktok.com/@mundoazulgranaoficial"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.tiktok.com/@mundoazulgranaoficial", "No se abrió la URL de TikTok correctamente");
         */

        /* -- Instagram -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.instagram.com/mundoazulgrana"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.instagram.com/mundoazulgrana", "No se abrió la URL de Instagram correctamente");
         */

        /* -- Facebook-- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/mundoazulgrana"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.facebook.com/mundoazulgrana", "No se abrió la URL de Facebook correctamente");
         */
    }
}