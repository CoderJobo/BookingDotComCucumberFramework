package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunThingsToDoPage extends BasePage {

    private By saunaFilter = By.xpath(".//a[@data-id='popular_activities-10']//span[contains(text(),'Sauna')]");

    private WebDriver driver;

    public FunThingsToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applySaunaFilter() throws InterruptedException {
        try{
            driver.findElement(saunaFilter).click();
        }
        catch(Exception e){
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement sauna = wait.until(ExpectedConditions.presenceOfElementLocated(saunaFilter));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sauna);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sauna);

        }
    }

}
