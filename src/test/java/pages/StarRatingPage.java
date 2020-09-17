package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StarRatingPage {

    private WebDriver driver;

    public StarRatingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterByStars(int numStars) throws Exception {
        WebElement starFilter = driver.findElement(By.xpath(".//a[@data-id='class-" + numStars + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", starFilter);
        Thread.sleep(500);
        starFilter.click();
    }
}
