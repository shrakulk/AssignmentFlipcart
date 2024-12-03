package Hallyal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import HallyalAbstractComponents.AbstractClass;

public class CheckoutPage extends AbstractClass {

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;

	}

	public void enterCountryName(String countryName) throws InterruptedException {

		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), countryName).build().perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

		Thread.sleep(1000);

	}
	
	public void clickCheckoutFinal() {
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
	}

}
