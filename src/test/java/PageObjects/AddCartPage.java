package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddCartPage {
	private WebElement wait;
	private final WebDriver driver;
	
	private final By element_text_box_codigo_postal= By.xpath("//input[@id='postalCode']");
	private final By element_buy_button = By.xpath("//button[normalize-space()='Comprar']");
	private final By element_codigo_postal_confirm_button= By.xpath("//button[normalize-space()='Confirmar']");
	private final By element_cart_button= By.xpath("//span[@class='cart-btn']//button[@type='button']");
	private final By element_title_cart= By.xpath("//h1[normalize-space()='Caldeirada de Peixe Congelada - Embalagem 0.9 Kg']");
	private final By element_seu_carrinho = By.xpath("//div[@class='cart-wrapper']");

	
	public AddCartPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void clickBuyButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_buy_button));
		wait.click();
	}
	
	public void writePostalCode(String postalCode) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_text_box_codigo_postal));
		wait.sendKeys(postalCode);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_codigo_postal_confirm_button));
		wait.click();
	}
	
	public void clickButtonAddCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_cart_button));
		wait.click();
		
	}
	
	public void verifyIfInCart(String title_artigo) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_title_cart));
		String title_cart = wait.getText();
		System.out.println("O titulo do artigo que está no cart é" + title_cart + "titulo do buy page " + title_artigo );
		Assert.assertTrue(title_cart.contains(title_artigo));
	}


	
}
