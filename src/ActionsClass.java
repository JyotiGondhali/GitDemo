import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions action = new Actions(driver);
		
		//hover over the Accounts & Lists option
		//action.moveToElement(driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']"))).build().perform();
		//right click on Accounts & Lists option(we can write this in 18th line only but for practice i am writing in next line)
		action.moveToElement(driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']"))).contextClick().build().perform();
		
		//Enter Capital letter in search box and select that entered text.
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		System.out.println(driver.getTitle());
		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");
		System.out.println("Test");

	}

}
