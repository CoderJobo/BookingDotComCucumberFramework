package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    public BasePage() {}

    public void moveToElement(WebDriver driver, WebElement ele){
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
    }
}
