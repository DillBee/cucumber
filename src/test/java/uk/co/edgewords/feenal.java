package uk.co.edgewords;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class feenal {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
/*    @After
    public void end(){
        driver.quit();
    }*/


    @Given("I am on the given products page")
    public void I_am_on_the_given_products_page() {
        driver.get("https://www.edgewordstraining.co.uk/demo-site/product/belt/");
    }

    @When("I add the item to my basket")
    public void iAddTheItemToMyBasket() {
        //driver.findElement(By.cssSelector(".demo_store.woocommerce-store-notice > .woocommerce-store-notice__dismiss-link")).click();
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();

    }

    @And("I check out my basket")
    public void iCheckOutMyBasket() {
        driver.navigate().to("https://www.edgewordstraining.co.uk/demo-site/cart/");


        driver.findElement(By.cssSelector("#post-5 > div > div > div.cart-collaterals > div > div > a")).click();
        driver.findElement(By.cssSelector("input#billing_first_name")).clear();
        driver.findElement(By.cssSelector("input#billing_first_name")).sendKeys("Dylan");
        driver.findElement(By.cssSelector("input#billing_last_name")).clear();
        driver.findElement(By.cssSelector("input#billing_last_name")).sendKeys("Berwick");
        driver.findElement(By.cssSelector("input#billing_company")).clear();
        driver.findElement(By.cssSelector("input#billing_company")).sendKeys("2i Testing");
        driver.findElement(By.cssSelector("input[name='billing_address_1']")).clear();
        driver.findElement(By.cssSelector("input[name='billing_address_1']")).sendKeys("34 No Existo");
        driver.findElement(By.cssSelector("input#billing_city")).clear();
        driver.findElement(By.cssSelector("input#billing_city")).sendKeys("Edinburgh");
        driver.findElement(By.cssSelector("input#billing_postcode")).clear();
        driver.findElement(By.cssSelector("input#billing_postcode")).sendKeys("KY4 9RJ");
        driver.findElement(By.cssSelector("input#billing_phone")).clear();
        driver.findElement(By.cssSelector("input#billing_phone")).sendKeys("07771834358");
        driver.findElement(By.cssSelector("input#billing_email")).clear();
        driver.findElement(By.cssSelector("input#billing_email")).sendKeys("dylan.berwick@2itesting.com");
        //driver.findElement(By.cssSelector("input#account_password")).sendKeys("password1990nine");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("#place_order")).click();



    }

    @Given("I am on the Edgewords Login Page")
    public void iAmOnTheEdgewordsLoginPage() {
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
    }

    @When("I enter my login details")
    public void iEnterMyLoginDetails() {
        driver.findElement(By.cssSelector("input#username")).sendKeys("dylan.berwick@2itesting.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("password1990nine");

    }

    @And("I submit my login details")
    public void iSubmitMyLoginDetails() {
        driver.findElement(By.cssSelector(".demo_store.woocommerce-store-notice > .woocommerce-store-notice__dismiss-link")).click();
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }



    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        String thing = driver.findElement(By.cssSelector(".woocommerce-MyAccount-content > p:nth-of-type(1)")).getText();
        MatcherAssert.assertThat(thing, containsString("Hello"));


    }

    @Then("I have bought the item")
    public void iHaveBoughtTheItem() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-6 > div > div > div > section.woocommerce-order-details > h2")));

        String thing = driver.findElement(By.cssSelector("#post-6 > div > div > div > section.woocommerce-order-details > h2")).getText();
        System.out.println(thing);
        MatcherAssert.assertThat(thing, containsString("Order received"));
    }

    @Given("I log in")
    public void iLogIn() {
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
        driver.findElement(By.cssSelector("input#username")).sendKeys("dylan.berwick@2itesting.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("password1990nine");
        driver.findElement(By.cssSelector(".demo_store.woocommerce-store-notice > .woocommerce-store-notice__dismiss-link")).click();
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }
}
