package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	
	private WebElement wait;
	private final WebDriver driver;
	private final By element_check_out_button= By.xpath("(//button[@class='pdo-button -block -cta'])[1]");
	private final By element_click_and_collect_button= By.xpath("//button[normalize-space()='Click & Collect']");
	private final By element_first_address= By.xpath("//pdo-cc-location[1]//div[1]//pdo-radio[1]//div[1]//label[1]");
	private final By element_seguinte_button= By.xpath("//button[@type='submit']");

	private final By element_day_deliver= By.xpath("//span[normalize-space()='23']");
	private final By element_time_deliver= By.xpath("//div[2]//div[5]//div[1]//a[1]//div[1]");
	private final By element_mbway_text = By.xpath("//p[@class='modal-text ng-star-inserted']");
	private final By element_mbway_option = By.xpath("(//label[@for='defaultPaymentMethod'])[1]");

	
	public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
	public void clickCheckOutButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_check_out_button));
		wait.click();
	}
	public void clickClickAndColect() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_click_and_collect_button));
		wait.click();
	}
	public void selectFirstAddress() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_first_address));
		wait.click();
	}
	public void clickSeguinte() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000))
				.until(ExpectedConditions.elementToBeClickable(element_seguinte_button));
		wait.click();
	}
	public void selectDeliver() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_day_deliver));
		wait.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_time_deliver));
		wait.click();
	}
	
	public void selectMBWayOption() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_mbway_option));
		wait.click();
	}


	public void verifyMBwayMessage(String MBWayMessage) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element_mbway_text));
		String message = wait.getText();
		System.out.println("message  é" + message + "o esperado é" + MBWayMessage );
		Assert.assertTrue(message.contains(MBWayMessage));

	}
}
