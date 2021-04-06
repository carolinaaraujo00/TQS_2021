import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static io.github.bonigarcia.seljup.BrowserType.OPERA;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.seljup.DockerBrowser;

import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;


@ExtendWith(SeleniumJupiter.class)
class ClassTest {
    @Test
    void testDockerOpera(@DockerBrowser(type = OPERA) RemoteWebDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(), containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    void testDockerChromeWithVersion(
            @DockerBrowser(type = CHROME, version = "88.0") RemoteWebDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(), containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    public void automation(FirefoxDriver driver) {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(856, 692));
        driver.findElement(By.linkText("destination of the week! The Beach!")).click();
        driver.findElement(By.linkText("Travel The World")).click();
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'San Diego']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(5)")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(4) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Carolina Araujo");
        driver.findElement(By.id("address")).sendKeys("Universidade de Aveiro");
        driver.findElement(By.id("city")).sendKeys("Aveiro");
        driver.findElement(By.id("state")).sendKeys("Aveiro");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        driver.findElement(By.id("creditCardNumber")).sendKeys("12345");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Carolina");
        driver.findElement(By.id("nameOnCard")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("nameOnCard")).sendKeys(Keys.TAB);
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals(driver.getTitle(), "BlazeDemo Confirmation");
    }

    @Test
    void testWithFirefoxGoogle(FirefoxDriver driver) {
        driver.get("https://www.google.com/");
        assertEquals(driver.getTitle(), "Google");
    }

    @Test
    void testHeadlessBrowser_PhantomJS(PhantomJSDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertNotNull(driver.getPageSource());
    }

    @Test
    void testHeadlessBrowser_HTMLUnit(HtmlUnitDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(), containsString("JUnit 5 extension for Selenium"));
    }

    @Disabled
    void testWithOneChrome(ChromeDriver chromeDriver) {
        // Use Chrome in this test
    }

    @Disabled
    void testWithChromeAndFirefox(ChromeDriver chromeDriver, FirefoxDriver firefoxDriver) {
        // Use Chrome and Firefox in this test
    }

}