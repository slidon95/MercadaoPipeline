package mercadaoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.AddCartPage;
import PageObjects.CheckOutPage;
import PageObjects.General;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutTest {
	
	WebDriver driver;
	
	LoginPage loginPage;
	General generalPage;
	SearchPage searchPage;
	AddCartPage addPage;
	CheckOutPage checkPage;

	@Given("I logged into Mercadao using {string} and initiated a search, selected the {string} on Solmar-acores, and entered the postal code.")
	public void i_logged_into_mercadao_using_and_initiated_a_search_selected_the_on_solmar_acores_and_entered_the_postal_code(String browser, String item) {
		driver = WebDriverConfig.startBrowser(browser);
		generalPage = new General(driver);
		searchPage = new SearchPage(driver);
		addPage = new AddCartPage(driver);
		loginPage = new LoginPage(driver);
		checkPage = new CheckOutPage(driver);
		generalPage.navidatetoMainPAge();
		Helper.takeScreenshot(driver, "tiraprint");
		generalPage.acceptCookies();
		generalPage.clickOnLoginButton();
		loginPage.fillEmailAndPassword("rumosteste@gmail.com", "AcademiaRumos.2024");
		loginPage.clickToSignInButton();
		searchPage.clickOnAcoresStore();
		searchPage.searchForPeixe(item);
		searchPage.pressEnterOnSearch();
		searchPage.selectFirstItem();
		addPage.clickBuyButton();
		addPage.writePostalCode("9500-764");
		addPage.clickButtonAddCart();

	}
	

	@When("I click the checkOut button")
	public void i_click_the_check_out_button() {
		checkPage.clickCheckOutButton();
	}
	
	@When("choose Click & Collect and select the first address, and click Seguinte")
	public void choose_click_collect_and_select_the_first_address_and_click_seguinte() {
		checkPage.clickClickAndColect();
		checkPage.selectFirstAddress();
		checkPage.clickSeguinte();
	}

	@When("pick a delivery time, then click Continue")
	public void pick_a_delivery_time_then_click_continue() {
		checkPage.selectDeliver();
		checkPage.clickSeguinte();
	}
	

	@When("opt for MB WAY and click Finalizar Compra")
	public void opt_for_mb_way_and_click_finalizar_compra() {
		checkPage.selectMBWayOption();
		checkPage.clickSeguinte();
	}


	@Then("I should receive a message stating {string}")
	public void i_should_receive_a_message_stating(String mbwayDescription) {
		checkPage.verifyMBwayMessage(mbwayDescription);
	}
	
	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
	

}
