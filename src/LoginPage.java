import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		//ChromeDriver driver = new ChromeDriver();		
//		driver.get("https://rahulshettyacademy.com");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		driver.close();
		
		String Username = "Jyoti";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacad");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Username);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jyoti@gmail.com");
		driver.findElement(By.cssSelector("input[Type='Text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@Type='text'][2]")).sendKeys("jyoti45@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456789");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//This is the combination of Parent_Child_tag + Regular Expression of xpath + index 
		driver.findElement(By.xpath("//div[contains(@class,'forgot-pwd-btn-conainer')]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder*=\"User\"]")).sendKeys(Username);
		driver.findElement(By.xpath("//input[contains(@placeholder,'word')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id$='One']")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + Username + ",");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println("Logged Out");
		driver.close();
		}
		
	}
