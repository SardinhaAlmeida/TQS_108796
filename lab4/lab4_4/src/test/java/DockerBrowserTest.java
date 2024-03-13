import static io.github.bonigarcia.seljup.BrowserType.CHROME;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.EnabledIfDockerAvailable;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@EnabledIfDockerAvailable
@ExtendWith(SeleniumJupiter.class)
class DockerChromeBetaTest {

    @Test
    public void testDockerBrowser(
            @DockerBrowser(type = CHROME, args = "--disable-gpu,--no-sandbox") WebDriver driver) {
        driver.get("https://blazedemo.com/");
        // driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        // assertThat(driver.getTitle()).contains("Selenium WebDriver");
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Paris']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(4) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("ola");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("blabla 123");
        driver.findElement(By.id("city")).click();
        {
            WebElement element = driver.findElement(By.id("city"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.findElement(By.id("city")).sendKeys("não sei");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("também não");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("132131");
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.id("creditCardNumber")).click();
        assertThat(driver.findElement(By.id("cardType")).getText(), is(not("-0.5,0")));
        driver.findElement(By.id("creditCardNumber")).sendKeys("21312332534653");
        {
            List<WebElement> elements = driver.findElements(By.id("creditCardNumber"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("09");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2007");
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("ola adeus");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).click();
        assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }

}

// @ExtendWith(SeleniumJupiter.class)
// public class DockerBrowserTest {

//     @Test
//     public void testDockerBrowser (@DockerBrowser(type = FIREFOX) WebDriver driver) {
//         driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
//         assertThat(driver.getTitle()).contains("Selenium WebDriver");
        
//         // driver.get("https://blazedemo.com/");
//         // driver.manage().window().setSize(new Dimension(1920, 976));
//         // {
//         //     WebElement dropdown = driver.findElement(By.name("fromPort"));
//         //     dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).clickAndHold().perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).release().perform();
//         // }
//         // {
//         //     WebElement dropdown = driver.findElement(By.name("toPort"));
//         //     dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("toPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).clickAndHold().perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("toPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("toPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).release().perform();
//         // }
//         // {
//         //     WebElement dropdown = driver.findElement(By.name("fromPort"));
//         //     dropdown.findElement(By.xpath("//option[. = 'Paris']")).click();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).clickAndHold().perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.name("fromPort"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).release().perform();
//         // }
//         // driver.findElement(By.cssSelector(".btn-primary")).click();
//         // driver.findElement(By.cssSelector("tr:nth-child(4) .btn")).click();
//         // driver.findElement(By.id("inputName")).click();
//         // driver.findElement(By.id("inputName")).sendKeys("ola");
//         // driver.findElement(By.id("address")).click();
//         // driver.findElement(By.id("address")).sendKeys("blabla 123");
//         // driver.findElement(By.id("city")).click();
//         // {
//         //     WebElement element = driver.findElement(By.id("city"));
//         //     Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
//         //     assertTrue(isEditable);
//         // }
//         // driver.findElement(By.id("city")).sendKeys("não sei");
//         // driver.findElement(By.id("state")).click();
//         // driver.findElement(By.id("state")).sendKeys("também não");
//         // driver.findElement(By.id("zipCode")).click();
//         // driver.findElement(By.id("zipCode")).click();
//         // driver.findElement(By.id("zipCode")).sendKeys("132131");
//         // {
//         //     WebElement element = driver.findElement(By.id("cardType"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).clickAndHold().perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.id("cardType"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).perform();
//         // }
//         // {
//         //     WebElement element = driver.findElement(By.id("cardType"));
//         //     Actions builder = new Actions(driver);
//         //     builder.moveToElement(element).release().perform();
//         // }
//         // driver.findElement(By.id("creditCardNumber")).click();
//         // assertThat(driver.findElement(By.id("cardType")).getText(), is(not("-0.5,0")));
//         // driver.findElement(By.id("creditCardNumber")).sendKeys("21312332534653");
//         // {
//         //     List<WebElement> elements = driver.findElements(By.id("creditCardNumber"));
//         //     assert (elements.size() > 0);
//         // }
//         // driver.findElement(By.id("creditCardMonth")).click();
//         // driver.findElement(By.id("creditCardMonth")).sendKeys("09");
//         // driver.findElement(By.id("creditCardYear")).click();
//         // driver.findElement(By.id("creditCardYear")).sendKeys("2007");
//         // driver.findElement(By.cssSelector("form")).click();
//         // driver.findElement(By.id("nameOnCard")).click();
//         // driver.findElement(By.id("nameOnCard")).sendKeys("ola adeus");
//         // driver.findElement(By.cssSelector(".checkbox")).click();
//         // driver.findElement(By.id("rememberMe")).click();
//         // driver.findElement(By.cssSelector(".btn-primary")).click();
//         // driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).click();
//         // assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
//     }
// }
