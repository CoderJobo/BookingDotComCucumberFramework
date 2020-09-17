package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacilitiesPage extends BasePage {

    private By roomServiceFilter = By.xpath(".//a[@data-id='hotelfacility-5']");
    private By spaAndWellnessCentreFilter = By.xpath(".//a[@data-id='hotelfacility-54']");
    private By freeWiFiFilter = By.xpath(".//a[@data-id='hotelfacility-107']");
    private WebElement showAllButton;
    private String showAllPath = ".//button[contains(text(),'Show all 13')]";

    private WebDriver driver;

    public FacilitiesPage(WebDriver driver) {
        this.driver = driver;
        showAllButton = driver.findElement(By.xpath(showAllPath));
    }

    public void filterFacilities(String facility) throws InterruptedException {
        switch(facility.toLowerCase()){
            case "room service" :
                filterRoomService();
                break;
            case "spa and wellness centre" :
                filterSpaAndWellnessCentre();
                break;
            case "free wifi" :
                filterFreeWiFi();
                break;
            default : System.out.println("Facility " + facility + "does not exist");
        }
    }

    public void filterRoomService() throws InterruptedException {
        try{
            driver.findElement(roomServiceFilter).click();
        }
        catch(Exception e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showAllButton);
            Thread.sleep(500);
            showAllButton.click();
            Thread.sleep(500);
            WebElement roomService = Util.waitToBeLocated(driver, roomServiceFilter, 20);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roomService);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roomService);
        }
    }

    public void filterSpaAndWellnessCentre() throws InterruptedException {
        try{
            driver.findElement(spaAndWellnessCentreFilter).click();
        }
        catch(Exception e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showAllButton);
            Thread.sleep(500);
            showAllButton.click();
            Thread.sleep(500);
            WebElement spaAndWellnessCentre = Util.waitToBeLocated(driver, spaAndWellnessCentreFilter, 20);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", spaAndWellnessCentre);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", spaAndWellnessCentre);
        }
    }

    public void filterFreeWiFi() throws InterruptedException {
        try{
            driver.findElement(freeWiFiFilter).click();
        }
        catch(Exception e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showAllButton);
            Thread.sleep(500);
            showAllButton.click();
            Thread.sleep(500);
            WebElement freeWiFi = Util.waitToBeLocated(driver, freeWiFiFilter, 20);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", freeWiFi);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freeWiFi);
        }
    }

}
