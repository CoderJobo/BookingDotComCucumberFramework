package pages;

import core.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class HomePage extends BasePage {

    private By topBanner = By.xpath(".//div[@id='top']");
    private By cookiePreferencesAcceptButton = By.xpath(".//button[@id='onetrust-accept-btn-handler']");
    private By cookieWarningAcceptButton = By.xpath(".//div[@id='cookie_warning']//span[text()='Accept']");
    private By locationInput = By.xpath(".//input[@id='ss']");
    private By firstLocationInDropdown = By.xpath(".//ul[@role='listbox']//span[@class='search_hl_name'][1]");
    private By calendarTitleMonth2 = By.xpath("(.//div[@class='bui-calendar__month'])[2]");
    private By calendarNavNextMonth = By.xpath(".//div[@class='bui-calendar__control bui-calendar__control--next']");
    private By adultsChildrenRoomInput = By.xpath(".//label[@id='xp__guests__toggle']");
    private By numAdults = By.xpath(".//span[@id='group_adults_desc']//preceding-sibling::span");
    private By increaseNumAdultsButton = By.xpath(".//div[@class='sb-group__field sb-group__field-adults']//button[@aria-label='Increase number of Adults']");
    private By decreaseNumAdultsButton = By.xpath(".//div[@class='sb-group__field sb-group__field-adults']//button[@aria-label='Decrease number of Adults']");
    private By numChildren = By.xpath(".//span[@id='group_children_desc']//preceding-sibling::span");
    private By increaseNumChildrenButton = By.xpath(".//div[@class='sb-group__field sb-group-children ']//button[@aria-label='Increase number of Children']");
    private By decreaseNumChildrenButton = By.xpath(".//div[@class='sb-group__field sb-group-children ']//button[@aria-label='Decrease number of Children']");
    private By numRooms = By.xpath(".//span[@id='no_rooms_desc']//preceding-sibling::span");
    private By increaseNumRoomsButton = By.xpath(".//div[@class='sb-group__field sb-group__field-rooms']//button[@aria-label='Increase number of Rooms']");
    private By decreaseNumRoomsButton = By.xpath(".//div[@class='sb-group__field sb-group__field-rooms']//button[@aria-label='Decrease number of Rooms']");
    private By searchButton = By.xpath(".//button[@data-sb-id='main']/span[contains(text(), 'Search')]");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void launchApp(){
        driver.get(TestConfig.getProperty("appBaseURL"));
    }

    public boolean verifyIfNavigatedToBookingDotCom(){
        return driver.findElement(topBanner).isDisplayed();
    }

    public void acceptCookiePreferences() throws InterruptedException {
        try{
            WebElement preferences = Util.waitToBeClickable(driver, cookiePreferencesAcceptButton, 200);
            moveToElement(driver, preferences);
            preferences.click();
            Thread.sleep(5000);
        }
        catch(Exception e){
            WebElement warning = Util.waitToBeClickable(driver, cookieWarningAcceptButton, 200);
            warning.click();
        }
        Thread.sleep(1000);
    }

    public void enterLocationFromDropdown(String location){
        driver.findElement(locationInput).sendKeys(location);
        WebElement firstLocation = Util.waitToBeClickable(driver, firstLocationInDropdown, 30);
        firstLocation.click();
    }

    public void enterDates() {
        LocalDate today = LocalDate.now();
        int monthValue = today.getMonthValue() + 3;
        if(monthValue > 12){
            monthValue = monthValue - 12;
        }
        String monthOfStay = Util.calculateMonthFromNumber(monthValue);
        String year = String.valueOf(today.getYear());
        String arrivalDay = String.valueOf(today.getDayOfMonth());
        String departureDay = String.valueOf(today.getDayOfMonth() + 1);

        WebElement navNext = Util.waitToBeLocated(driver, calendarNavNextMonth, 30);
        while(!monthOfStay.equals(driver.findElement(calendarTitleMonth2).getText().split(" ")[0])) {
            navNext.click();
        }

        WebElement dayOfArrival = Util.waitToBeClickable(driver, By.xpath(".//td[@class='bui-calendar__date']/span[@aria-label='" + arrivalDay + " " + monthOfStay + " " + year + "']"), 30);
        dayOfArrival.click();
        WebElement dayOfDeparture = Util.waitToBeClickable(driver, By.xpath(".//td[@class='bui-calendar__date']/span[@aria-label='" + departureDay + " " + monthOfStay + " " + year + "']"), 30);
        dayOfDeparture.click();
    }

    public void enterGuestRoomDetails(String adultGuests, String childGuests, String guestRooms){
        driver.findElement(adultsChildrenRoomInput).click();
        int adults = Integer.parseInt(adultGuests);
        int children = Integer.parseInt(childGuests);
        int rooms = Integer.parseInt(guestRooms);
        int numAdultsDefault = Integer.parseInt(driver.findElement(numAdults).getText());
        if(numAdultsDefault != adults){
            if(numAdultsDefault > adults){
                decreaseNumGuests(numAdultsDefault, adults, decreaseNumAdultsButton);
            }
            else if(numAdultsDefault < adults){
                increaseNumGuests(numAdultsDefault, adults, increaseNumAdultsButton);
            }
        }
        int numChildrenDefault = Integer.parseInt(driver.findElement(numChildren).getText());
        if(numChildrenDefault != children){
            if(numChildrenDefault > children){
                decreaseNumGuests(numChildrenDefault, children, decreaseNumChildrenButton);
            }
            else if(numChildrenDefault < adults){
                increaseNumGuests(numChildrenDefault, children, increaseNumChildrenButton);
            }
        }
        int numRoomsDefault = Integer.parseInt(driver.findElement(numRooms).getText());
        if(numRoomsDefault != rooms){
            if(numRoomsDefault > rooms){
                decreaseNumGuests(numRoomsDefault, rooms, decreaseNumRoomsButton);
            }
            else if(numRoomsDefault < rooms){
                increaseNumGuests(numRoomsDefault, rooms, increaseNumRoomsButton);
            }
        }
    }

    public void decreaseNumGuests(int numGuests, int guests, By decreaseButton){
        int difference = numGuests - guests;
        for(int i = 0; i < difference; i++){
            driver.findElement(decreaseButton).click();
        }
    }

    public void increaseNumGuests(int numGuests, int guests, By increaseButton){
        int difference = guests - numGuests;
        for(int i = 0; i < difference; i++){
            driver.findElement(increaseButton).click();
        }
    }

    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

}
