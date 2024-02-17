package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {
	
	private WebElement wait;
	private final WebDriver driver;
	
	private final By element_text_registeseaqui = By.xpath("//a[normalize-space()='Registe-se aqui']");
	private final By element_email = By.xpath("//input[@id='email']");
	private final By element_pass = By.xpath("//input[@id='password']");
	private final By element_select_box_register = By.xpath("//pdo-input-checkbox[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']");
	private final By element_button_register = By.xpath("//button[normalize-space()='Criar']");
	
	GenerateRandomEmail randomEmail = new GenerateRandomEmail ();

	public RegisterPage(WebDriver driver) {
	        this.driver = driver;
			
	    }
	
	public void clickOnRegisteAqui() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_text_registeseaqui));
		wait.click();
	}
	public void fillMandatoryFildsOnRegister(String pass) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_email));
		wait.sendKeys(randomEmail.generateRandomEmail());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_pass));
		wait.sendKeys(pass);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_select_box_register));
		wait.click();
	}
	
	public void clickOnRegisterButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_button_register));
		wait.click();
	}

	public void validationUrl(String url) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String curent_url= driver.getCurrentUrl();
		System.out.println("current url is " + curent_url  );

		Assert.assertTrue(curent_url.equals(url));
	}
	
}
