package Hallyal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import HallyalAbstractComponents.AbstractClass;

public class HomePage extends AbstractClass {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public List<WebElement> addToCart() {
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		return products;
	}

	public WebElement requiredButton(List<WebElement> button1, String prodName) {
		WebElement addbutton = button1.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodName))
				.findFirst().orElse(null);
		return addbutton;
	}

	public void clickRequiredButton(WebElement addbutton) {

		addbutton.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	}

}
