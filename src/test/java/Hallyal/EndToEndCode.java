package Hallyal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import HallyalAbstractComponents.AbstractClass;

public class EndToEndCode extends AbstractClass {

	public EndToEndCode(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		String productName = "Adidas Original";
		String url = "https://rahulshettyacademy.com/client/";
		String userName = "StudentOne@gmail.com";
		String password = "Abcd@1234";
		String countryName = "india";
		String expectedMessage = "Thankyou for the order.";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.openPage(url);
		LoginPage.enterUserName(userName);
		LoginPage.enterPassword(password);
		LoginPage.clickSubmit();

		HomePage HomePage = new HomePage(driver);
		List<WebElement> buttonList = HomePage.addToCart();
		WebElement addbutton = HomePage.requiredButton(buttonList, productName);
		HomePage.clickRequiredButton(addbutton);

		waitUntil();

		Thread.sleep(1000);

		cartClick();

		CartPage CartPage = new CartPage(driver);
		boolean productValue = CartPage.verifyCartProducts(productName);
		Assert.assertTrue(productValue);

		CartPage.clickCheckout();

		CheckoutPage CheckoutPage = new CheckoutPage(driver);
		CheckoutPage.enterCountryName(countryName);
		CheckoutPage.clickCheckoutFinal();

		ConfirmatioPage ConfirmatioPage = new ConfirmatioPage(driver);
		String confirmationMessage = ConfirmatioPage.validateMessage(expectedMessage);
		
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(expectedMessage));
	}

}
