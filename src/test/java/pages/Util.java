package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    public static WebElement waitToBeLocated(WebDriver driver, By element, long seconds){
        return new WebDriverWait(driver, seconds)
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public static WebElement waitToBeClickable(WebDriver driver, By element, long seconds){
        return new WebDriverWait(driver, seconds)
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String calculateMonthFromNumber(int num){
        String month = "";
        switch(num){
            case 1 : month = "January"; break;
            case 2 : month = "February"; break;
            case 3 : month = "March"; break;
            case 4 : month = "April"; break;
            case 5 : month = "May"; break;
            case 6 : month = "June"; break;
            case 7 : month = "July"; break;
            case 8 : month = "August"; break;
            case 9 : month = "September"; break;
            case 10 : month = "October"; break;
            case 11 : month = "November"; break;
            case 12 : month = "December"; break;
            default : month = ""; break;
        }
        return month;
    }
}
