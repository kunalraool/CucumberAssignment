package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;

	// Scenario: Login
	@Given("Upskill home page should be open")
	public void upskill_home_page_should_be_open() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KunalRaool\\Desktop\\SDET\\Cucumber project\\chromedriver_win32(2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
	}

	@When("I enter Username as {string}")
	public void i_enter_username_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login")).sendKeys(string);
	}

	@When("I enter Password as {string}")
	public void i_enter_password_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(string);
	}

	@When("I click on Login Button")
	public void i_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("form-login_submitAuth")).click();
	}

	@When("I wait for {int} seconds")
	public void i_wait_for_seconds(Integer int1) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		int1 = int1 * 1000;
		Thread.sleep(int1);
	}

	@When("I click on user drop down Button")
	public void i_click_on_user_drop_down_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("dropdown-toggle")).click();
	}

	@Then("I Validate if login was successful by checking {string}")
	public void i_validate_if_login_was_successful_by_checking(String string) {
		// Write code here that turns the phrase above into concrete actions
		String actualEmail = driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[1]/div/p")).getText();
		org.junit.Assert.assertEquals(string, actualEmail);
	}

// scenario: send mail

	@Given("I logged in to upskill site using {string} and {string}")
	public void i_logged_in_to_upskill_site_using_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
		driver.findElement(By.id("form-login_submitAuth")).click();
	}

	@Given("I validated logged in inormation using {string}")
	public void i_validated_logged_in_inormation_using(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("dropdown-toggle")).click();
		Thread.sleep(1000);
		String actualEmail = driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[1]/div/p")).getText();
		org.junit.Assert.assertEquals(string, actualEmail);
		driver.findElement(By.className("dropdown-toggle")).click();
	}

	@When("I clicked on Compose Button")
	public void i_clicked_on_compose_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//li[@class='list-group-item new-message-social']/a")).click();
	}

	@When("I enter {string} address")
	public void i_enter_address(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		WebElement emailAddress = driver.findElement(By.className("select2-search__field"));
		emailAddress.sendKeys(string);
		Thread.sleep(2000);
		emailAddress.sendKeys(Keys.ENTER);
	}

	@When("I enter {string} in subject field")
	public void i_enter_in_subject_field(String string){
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("compose_message_title")).sendKeys(string);;
		
	}


	@When("I enter {string} in message section")
	public void i_enter_in_message_section(String string) {
		// Write code here that turns the phrase above into concrete actions
		WebElement frame = driver.findElement(By.xpath("//*[@title='Rich Text Editor, content']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector("body")).sendKeys(string);
		driver.switchTo().defaultContent();
	}

	@When("I clicked on send message Button")
	public void i_clicked_on_send_message_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@name='compose']")).click();
	}

	@Then("I validate {string} send successfully")
	public void i_validate_send_successfully(String string) {
		// Write code here that turns the phrase above into concrete actions
		String actualmessage= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		org.junit.Assert.assertEquals(string, actualmessage);
	}

	@Then("I close browser")
	public void i_close_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}


}
