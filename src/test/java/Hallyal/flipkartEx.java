package Hallyal;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		// Enter url in the browser
		driver.get("https://www.flipkart.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// Click on login button
		WebElement loginButton = driver.findElement(By.cssSelector("div.H6-NpN._3N4_BX"));

		loginButton.click();

		driver.findElement(By.cssSelector("input.r4vIwl")).sendKeys("9373689834");

		driver.findElement(By.cssSelector("button.QqFHMw")).click();

		//Scanner scanner = new Scanner(System.in);

		//System.out.println("enter the OTP");
		Thread.sleep(5000);
		String OTP = OTPFetch.getOTP();

		String[] otpArray = new String[OTP.length()];

		for (int i = 0; i < OTP.length(); i++) {
			otpArray[i] = String.valueOf(OTP.charAt(i));
			// System.out.println(otpArray[i]);
			int j = i + 1;
			driver.findElement(By.xpath("//div[@class='XDRRi5']/div[" + j + "]/input[1]")).sendKeys(otpArray[i]);
		}

	}

}
