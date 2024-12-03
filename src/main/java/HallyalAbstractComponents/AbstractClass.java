package HallyalAbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	static WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;

	}

	public static void waitUntil() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

	}

	public static void cartClick() {
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	}
}
