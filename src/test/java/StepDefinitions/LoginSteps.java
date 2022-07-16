package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver=null;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/");
	}
	@When("user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		Thread.sleep(2000);
	    driver.findElement(By.id("Email")).sendKeys(username);
	    Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys(password);
	}
	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException{
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		Thread.sleep(3000);
	}
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {	
		//driver.close();
	}
}
