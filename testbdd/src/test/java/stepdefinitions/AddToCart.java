package stepdefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	public static WebDriver driver;

	@Given("^I open \"(.*?)\"$")
	public void i_open(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		;
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@When("^I select a product$")
	public void i_select_a_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^I clicked the \\*product$")
	public void i_clicked_the_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("product clicked");
	}

	@When("^I add the product to cart$")
	public void i_add_the_product_to_cart() throws Throwable {
		driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[2]/div[2]/a[1]/span"))
				.click();
	}

	@When("^I open cart$")
	public void i_open_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I should see the product in cart$")
	public void i_should_see_the_product_in_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String cart_title = driver.getTitle();
		/*
		 * String Cart = driver.findElement(By.
		 * xpath("//h2[contains(text(),'Product successfully added to your shopping cart\r\n"
		 * + "')]")).getText();
		 */
		driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[2]/div[2]/a[1]/span"))
				.click();
		Assert.assertEquals(cart_title, driver.getTitle());
	}

}
