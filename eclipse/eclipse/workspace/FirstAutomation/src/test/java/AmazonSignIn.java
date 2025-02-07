import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSignIn extends GoogleSearch{

	public static WebDriver amazonsignin(String email,String password) {
		
		WebDriver driver = GoogleSearch.googlesearch();
		// select signin option
		driver.findElement(By.className("nav-line-1-container")).click();
		// wait for 10s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// send login credentials
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		// click on signin
		driver.findElement(By.id("signInSubmit")).click();
		// enter otp
		System.out.println("OTP: ");
		Scanner scan3 = new Scanner(System.in);
		String otp = scan3.nextLine();
		driver.findElement(By.id("auth-mfa-otpcode")).clear();
		driver.findElement(By.id("auth-mfa-otpcode")).sendKeys(otp);
		driver.findElement(By.id("auth-signin-button")).click();
		System.out.println("Amazon signin successful");
		return driver;
		
	}
}
