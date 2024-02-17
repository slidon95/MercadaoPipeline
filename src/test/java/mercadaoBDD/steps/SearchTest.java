package mercadaoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.General;
import PageObjects.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest {
	
	WebDriver driver;
	
	General generalPage;
	SearchPage searchPage;
	
	@Given("I at Store solmar-acores Mercadao using {string}")
	public void i_at_store_solmar_acores_mercadao_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		generalPage = new General(driver);
		searchPage = new SearchPage(driver);
		generalPage.navidatetoMainPAge();
		Helper.takeScreenshot(driver, "tiraprint");
		generalPage.acceptCookies();
		searchPage.clickOnAcoresStore();
	}


	@When("search for {string} on search box")
	public void search_for_on_search_box(String peixe) {
		searchPage.searchForPeixe(peixe);
	}

	@And("I press enter")
	public void i_press_enter() {
		searchPage.pressEnterOnSearch();
	}

	@Then("I will be at search dashboard {string}")
	public void i_will_be_at_search_dashboard(String url) {
		searchPage.validationUrl(url);
	}
	
	@And("Select First Item and see the information")
	public void select_first_item_and_see_the_information() {
		searchPage.selectFirstItem();
		searchPage.verifyTitleDescription();
	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
