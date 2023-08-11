package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PlaceOrderStepdefs {

    public static WebDriver driver;
    @Given("User go to the NopCommerce Home page")
    public void userGoToTheNopCommerceHomePage() throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @When("User click {string} option from {string} category")
    public void userClickOptionFromCategory(String arg0, String arg1) throws InterruptedException {
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")).click();
    }
    @And("User click on the {string} for product details")
    public void userClickOnTheForProductDetails(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]")).click();
    }
    @And("User set the quantity number {int} in the quantity field")
    public void userSetTheQuantityNumberInTheQuantityField(int arg0) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
    }
    @And("User click on the {string} button")
    public void userClickOnTheButton(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();
    }
    @And("User go to the shipping cart page")
    public void userGoToTheShippingCartPage() {
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
    }
    @And("User accept terms conditions and click checkout button")
    public void userAcceptTermsConditionsAndClickCheckoutButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }
    @And("User click checkout as guest button")
    public void userClickCheckoutAsGuestButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Checkout as Guest']")).click();
    }
    @And("User input all the billing details and click continue")
    public void userInputAllTheBillingDetailsAndClickContinue() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Sumon");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("sumon12@gmail.com");
        WebElement element =driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select se=new Select(element);
        se.selectByVisibleText("Bangladesh");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Dhaka");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Khilkhet");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("1229");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("01699604898");
        driver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
    }

    @And("User select shipping method {string} and click continue")
    public void userSelectShippingMethodAndClickContinue(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
    }

    @And("User select payment method {string} and click continue")
    public void userSelectPaymentMethodAndClickContinue(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
    }

    @And("User select {string} card and input card information")
    public void userSelectCardAndInputCardInformation(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("sumon");
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("4716946601381503");
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("650");
        WebElement element=driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select drop=new Select(element);
        drop.selectByVisibleText("2026");
        driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
    }

    @And("User click confirm button to place the order")
    public void userClickConfirmButtonToPlaceTheOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
    }

    @Then("Verify that the order place message {string} is d")
    public void verifyThatTheOrderPlaceMessageIsD(String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        String actualMessage=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(2000);
        driver.close();
    }
}
