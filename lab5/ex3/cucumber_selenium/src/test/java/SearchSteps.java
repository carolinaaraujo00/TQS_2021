import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SearchSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @And("I choose departure {string}")
    public void iChooseDeparture(String searchQuery) {
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = '" + searchQuery + "']")).click();
        }
    }

    @And("I choose destination {string}")
    public void iChooseDestination(String searchQuery) {
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = '" + searchQuery + "']")).click();
        }
    }

    @And("I press Find Flights")
    // checked
    public void iPressFindFlights() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("I should be shown results including {string}")
    public void iShouldBeShownResultsIncluding(String result) {
        try {
            assertThat(driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(4)")).getText(), is(result));
        } catch (NoSuchElementException e) {
            throw new AssertionError(
                    "\"" + result + "\" not available in results");
        }
    }

    @And("I press Choose Flight 4346")
    // checked
    public void iPressChooseThisFlight() {
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
    }

    @Then("I finish the purchase")
    // checked
    public void iFinishPurchase(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
        try {
            assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Thank you for your purchase today!"));
        } catch (NoSuchElementException e) {
            throw new AssertionError();
        } finally {
            driver.quit();
        }
    }
}