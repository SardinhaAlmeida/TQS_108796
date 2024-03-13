//Generated by Selenium IDE
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class TestingdummyblazedemoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testingdummyblazedemo() {
    driver.get("https://blazedemo.com/");
    driver.manage().window().setSize(new Dimension(1920, 976));
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
      assert(elements.size() > 0);
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
