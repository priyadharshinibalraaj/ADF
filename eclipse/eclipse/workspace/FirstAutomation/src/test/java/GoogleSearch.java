import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {
	
	public static WebDriver googlesearch() {
		
		// set project path
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path is " +projectPath);
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		// add chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		// assign chrome driver
		WebDriver driver = new ChromeDriver(options);
		//wait for 20s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// go to google.com
		driver.get("https://google.com/");
		//wait for 20s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// enter the text in search box
		driver.findElement(By.name("q")).sendKeys("Amazon signin");
		// click on search button
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		// bypass bot verification
		WebElement recaptchaCheckbox = driver.findElement(By.id("recaptcha"));
		// wait for 20s
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(recaptchaCheckbox));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// click the recaptcha
		recaptchaCheckbox.click();
		// click amazon signin page
		driver.findElement(By.tagName("h3")).click();
		// wait 20s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Google search for amazon completed successfully");
		return driver;
		// close the browser
		//driver.close();	
		
	}
}
