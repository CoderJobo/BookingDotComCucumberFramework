package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    private By hotelList = By.xpath(".//div[@id='hotellist_inner']");

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyIfSearchResultDisplayed(){
        return driver.findElement(hotelList).isDisplayed();
    }

    public boolean verifyIfHotelIsListed(String hotelName){
        boolean isListed = false;
        try{
            if(driver.findElement(By.xpath(".//div[@class='sr-hotel__title-wrap']//span[contains(text(),'" + hotelName + "')]")).isDisplayed()){
                isListed = true;
            }
        }
        catch(Exception e){
        }
        return isListed;
    }

}
