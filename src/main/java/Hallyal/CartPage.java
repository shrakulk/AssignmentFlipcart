package Hallyal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean verifyCartProducts(String prName) {
		List<WebElement> selectedProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		boolean d = selectedProducts.stream().anyMatch(c -> c.getText().equalsIgnoreCase(prName));

		System.out.println(d);
		return d;

	}
	
	
	public void clickCheckout() {
		driver.findElement(By.cssSelector(".totalRow button")).click();
	}

}
