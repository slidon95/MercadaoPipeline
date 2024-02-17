package mercadaoBDD.steps;


import org.openqa.selenium.WebDriver;


import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.General;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	WebDriver driver;

	LoginPage loginPage;
	General generalPage;



	@Given("I am at mercadao login page using {string}")
	public void i_am_at_mercadao_login_page_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		generalPage = new General(driver);
		generalPage.navidatetoMainPAge();
		Helper.takeScreenshot(driver, "tiraprint");
		generalPage.acceptCookies();
		generalPage.clickOnLoginButton();
	}


	@When("I insert valid data")
	public void i_insert_valid_data() {
		loginPage.fillEmailAndPassword("rumosteste@gmail.com", "AcademiaRumos.2024");
	}

	@And("I click to sign in button")
	public void i_click_to_sign_in_button() {
		loginPage.clickToSignInButton();
	}

	@Then("I will be at dashboard {string}")
	public void i_will_be_at_dashboard(String url) {
		loginPage.validationUrl(url);
	}
	
	@Then("Will show on the right corner {string}")
	public void will_show_on_the_right_corner(String owner_name) {
		loginPage.validationNameAccount(owner_name);
	}
	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
