import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> calculate = driver.findElements(By.xpath("//fieldset/div/table/tbody/tr/td[4]"));
		
		int sum = 0;
		for(int i=0; i<calculate.size(); i++)
		{
			sum = sum + Integer.parseInt((calculate.get(i).getText()));
		}
		
		String total = (driver.findElement(By.className("totalAmount")).getText()).split(":")[1].trim();
		int i = Integer.parseInt(total);
		
		Assert.assertEquals(sum, i);
		System.out.println("Sum is "+sum+" actual sum is "+i);
	}

}
