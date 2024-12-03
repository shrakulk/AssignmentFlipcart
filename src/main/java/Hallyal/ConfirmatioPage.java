package Hallyal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import HallyalAbstractComponents.AbstractClass;
import dev.failsafe.internal.util.Assert;

public class ConfirmatioPage extends AbstractClass {

	WebDriver driver;

	public ConfirmatioPage(WebDriver driver) {

		super(driver);
		this.driver = driver;

	}

	public String validateMessage(String expectedMessage) {

		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		return confirmationMessage;

	}

}
