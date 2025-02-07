import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseGiftCard extends GoogleSearch{

	public static void main(String[] args) {
		
		System.out.println("Username: ");
		Scanner scan1 = new Scanner(System.in);
		String username = scan1.nextLine();
		System.out.println("Password: ");
		Scanner scan2 = new Scanner(System.in);
		String password = scan2.nextLine();
		purchasegiftcard(username,password);
		
	}
		
	public static void purchasegiftcard(String email,String password) {
		
		WebDriver driver = AmazonSignIn.amazonsignin(email,password);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("amazon gift card birthday");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Birthday')]")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
	}
}
