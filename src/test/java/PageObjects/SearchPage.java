package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	private WebElement wait;
	private final WebDriver driver;
	
	private final By element_button_solmar_acores = By.xpath("//pdo-brand-logo[5]//article[1]//a[1]//pdo-square-background[1]//div[1]//div[1]");
	private final By element_filter_first_Item = By.xpath("(//img[@class='pdo-block media ng-star-inserted'])[1]");
	private final By element_title_Item= By.xpath("//h2[normalize-space()='Caldeirada de Peixe Congelada - Embalagem 0.9 Kg']");
	private final By element_button_search_text_box = By.id("search");
	private final By element_button_acores = By.xpath("//div[@class='square-media']");


	
	public SearchPage(WebDriver driver) {
        this.driver = driver;
		
    }
	
	public void clickOnAcoresStore() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_button_solmar_acores));
		wait.click();
	}
	
	public void searchForPeixe(String Peixe) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_button_search_text_box));
		wait.sendKeys(Peixe);
	}
	
	public void pressEnterOnSearch() {
		driver.findElement(element_button_search_text_box).sendKeys(Keys.ENTER);
	}
	public void validationUrl(String url) {

		String curent_url= driver.getCurrentUrl();
		System.out.println("current url is " + curent_url  );

		Assert.assertTrue(curent_url.equals(url));
	}
	public void selectFirstItem() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_filter_first_Item));
		wait.click();
	}
	
	public void verifyTitleDescription() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_title_Item));
		String Item_title = wait.getText();
		System.out.println("O titulo do artigo é " + Item_title  );
		Assert.assertTrue(Item_title.contains("Caldeirada de Peixe Congelada - Embalagem 0.9 Kg"));
	}

	public void selectAcoresStore() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(ExpectedConditions.elementToBeClickable(element_button_acores));
		wait.click();
	}

}
