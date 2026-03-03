import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']")).click();
		Thread.sleep(2000);
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']"));
		
		for(int i=0; i<items.size(); i++)
		{
			String item = items.get(i).getText();
			
			if(item.contains("Kettle"))
			{
				driver.findElements(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']")).get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[title='Add to Shopping Cart']")).click();		
		Thread.sleep(2000);
		driver.findElement(By.id("attach-warranty-close-icon")).click();
	}

}
