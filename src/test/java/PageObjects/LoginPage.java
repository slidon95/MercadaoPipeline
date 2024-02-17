package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
	private WebElement wait;
	private final WebDriver driver;
	
	private final By element_email = By.xpath("//input[@id='email']");
	private final By element_pass = By.xpath("//input[@id='password']");
	private final By element_button_sign_in = By.xpath("//button[normalize-space()='Entrar']");
	private final By element_name_account = By.xpath("//pdo-navbar-top[@class='_3db0T2TkzhslzgcJWQemKW _14nSOKHXzSgVTmxBtbljEP']//a[@class='_2FHvr5ab9Vdg3y5BBHt5GC ng-star-inserted'][contains(text(),'Olá,')]");
	  public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	public void fillEmailAndPassword(String email, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_email));
		wait.sendKeys(email);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_pass));
		wait.sendKeys(password);
	}
	public void clickToSignInButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_button_sign_in));
		wait.click();
	}
	public void validationUrl(String url) {
		String curent_url= driver.getCurrentUrl();
		Assert.assertTrue(curent_url.equals(url));
	}
	
	public void validationNameAccount(String name_account) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(element_name_account));
	String name = wait.getText();
	System.out.println("The name account is" + name  );
	Assert.assertTrue(name.contains(name_account));
	}
}
