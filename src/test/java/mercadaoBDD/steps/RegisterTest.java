package mercadaoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.General;
import PageObjects.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	WebDriver driver;
	RegisterPage registerPage;
	General generalPage;
	

	@Given("I am at mercadao register page using {string}")
	public void i_am_at_mercadao_register_page_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		registerPage = new RegisterPage(driver);
		generalPage = new General(driver);
		generalPage.navidatetoMainPAge();
		Helper.takeScreenshot(driver, "tiraprint");
		generalPage.acceptCookies();
		generalPage.clickOnLoginButton();
		registerPage.clickOnRegisteAqui();
	}

	@When("I insert valid data for register")
	public void i_insert_valid_data_for_register() {
		registerPage.fillMandatoryFildsOnRegister( "AcademiaRumos.2024");
	}

	@And("I click to register button")
	public void i_click_to_register_button() {
		registerPage.clickOnRegisterButton();
	}

	@Then("I will be at confirmation by email page {string}")
	public void i_will_be_at_confirmation_by_email_page(String url) {
	  registerPage.validationUrl(url);
	}
	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
