package mercadaoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.AddCartPage;
import PageObjects.General;
import PageObjects.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartTest {
	
	WebDriver driver;
	
	General generalPage;
	SearchPage searchPage;
	AddCartPage addPage;
	
	@Given("I at Store solmar-acores Mercadao using {string} and search for {string}")
	public void i_at_store_solmar_acores_mercadao_using_and_search_for(String browser, String item) {
		driver = WebDriverConfig.startBrowser(browser);
		generalPage = new General(driver);
		searchPage = new SearchPage(driver);
		addPage = new AddCartPage(driver);
		generalPage.navidatetoMainPAge();
		Helper.takeScreenshot(driver, "tiraprint");
		generalPage.acceptCookies();
		searchPage.clickOnAcoresStore();
		searchPage.searchForPeixe(item);
		searchPage.pressEnterOnSearch();
	}

	@When("I select the first item")
	public void i_select_the_first_item() {
		searchPage.selectFirstItem();
	}

	@When("Buy the item")
	public void buy_the_item() {
		addPage.clickBuyButton();

	}

	@When("write the postal code {string}")
	public void write_the_postal_code(String postalCode) {
		addPage.writePostalCode(postalCode);

	}

	@And("I click on my cart")
	public void i_click_on_my_cart() {
		addPage.clickButtonAddCart();
	}

	@Then("Verify if the item is on the cart")
	public void verify_if_the_item_is_on_the_cart() {
		String item = "Caldeirada de Peixe Congelada - Embalagem 0.9 Kg";
		addPage.verifyIfInCart(item);
	}
	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
