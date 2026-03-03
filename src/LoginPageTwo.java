import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPageTwo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		String Username = "Jyoti";
		String Password = passwordMethod(driver);
		driver.findElement(By.xpath("//div[contains(@class,'forgot-pwd-btn-conainer')]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder*=\"User\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[contains(@placeholder,'word')]")).sendKeys(Password);
		driver.findElement(By.cssSelector("input[id$='One']")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(1000);
		System.out.println("Logged Out");
		driver.close();
		}
//here we are passing driver as a parameter because in main method already browser is opened and 
//same browser we have to use in this method hence we passed the driver method 
	public static String passwordMethod(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//Please use temporary password-'rahulshettyacademy'-to Login.
		String Data1 = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray1 = Data1.split("'");
		return passwordArray1[1];
	}
	
}
