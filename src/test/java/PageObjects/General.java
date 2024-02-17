package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General {
	
	private WebElement wait;
	private final WebDriver driver;
	
	private final By element_accept_cookies = By.id("onetrust-accept-btn-handler");
	private final By element_button_login = By.xpath("//pdo-navbar-top[@class='_3db0T2TkzhslzgcJWQemKW _14nSOKHXzSgVTmxBtbljEP']//a[@class='_2FHvr5ab9Vdg3y5BBHt5GC ng-star-inserted'][normalize-space()='Login']");

	 public General(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 public void acceptCookies() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(element_accept_cookies));
			wait.click();
		}
		public void clickOnLoginButton() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(element_button_login));
			wait.click();
			
		}
		public void navidatetoMainPAge() {
			driver.get("https://mercadao.pt");

		}
		
		

}
