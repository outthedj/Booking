package steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BookingSteps {
    WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverManager.getInstanceOfDriverManager().getDriver();
        setTimeouts();
    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        driver.get("https://www.booking.com/");
    }

    @When("User inputs the name of the {string} in the [Search] field")
    public void inputtingNameOfTheHotel(String hotelName) {
        driver.findElement(By.id("ss")).sendKeys(hotelName);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @And("User clicks on the [Search] button")
    public void clickingSearchButton() {
        driver.findElement(By.className("xp__button")).click();
    }

    @Then("The result of the {string} and its {string} is displayed")
    public void matchingHotelsNameAndRating(String hotelName, String actualRating) {
        String hotelToSearch = String.format("//div[@data-testid='property-card' and contains(. , '%s')]", hotelName);
        boolean isHotelShown = driver.findElement(By.xpath(hotelToSearch)).isDisplayed();
        Assert.assertTrue(isHotelShown);
        By ratingOfXpath = By.xpath("(" + hotelToSearch + "//div[@aria-label])[1]");
        String rating = driver.findElement(ratingOfXpath).getText();
        Assert.assertEquals(rating, actualRating, "Score is not matched");
    }

    private void setTimeouts() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}