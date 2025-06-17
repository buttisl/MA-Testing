package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriasPage {

    WebDriver driver;
    WebDriverWait wait;

    public CategoriasPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToCategorias(String categoria){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("jpreOverlay")));
        String xpath = "//a[@href and normalize-space()='" + categoria + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        wait.until(ExpectedConditions.urlContains(categoria.toLowerCase()));
    }
}
