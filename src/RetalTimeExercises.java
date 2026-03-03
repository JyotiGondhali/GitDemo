import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetalTimeExercises {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Get the Count of links present on that page 
		System.out.println("Whole Page: " + driver.findElements(By.tagName("a")).size());
		
		//2. Get the count of links only present in the footer section
		//This is nothing but limiting the webdriver scope.
		WebElement footerScope = driver.findElement(By.id("gf-BIG"));
		System.out.println("Within Footer: " + footerScope.findElements(By.tagName("a")).size());
		
		//3. Get the count of the links only from fotter's 1st column
		WebElement column = footerScope.findElement(By.xpath(".//Table/tbody/tr/td[1]"));  
		//in the above line the xpath starts with (.) which represents start searching from footerscope itself.
		System.out.println("Firts column of the footer: " + column.findElements(By.tagName("a")).size());
		
		//4. Click on each link present in the 1st column of the footer.
		//1st way to do it using back button
		
//		int size = column.findElements(By.tagName("a")).size();
//		for (int i=1; i<size; i++)
//		{
//			footerScope = driver.findElement(By.id("gf-BIG"));
//			column = footerScope.findElement(By.xpath(".//Table/tbody/tr/td[1]"));  
//			column.findElements(By.tagName("a")).get(i).click();
//			System.out.println("Clicked");
//			driver.navigate().back();
//		}
		
		//2nd way to do it using ctrl + click action so that links will open in different tabs
		
		int size = column.findElements(By.tagName("a")).size();
		for(int i=1; i<size; i++)
		{
			String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(click);
			//System.out.println("Clicked");
			Thread.sleep(5000);
		}
		
		//5. Get the title of all opened tabs 
		Set<String> linkTabs = driver.getWindowHandles();
		Iterator<String> tabs = linkTabs.iterator();
		
		while(tabs.hasNext())
		{
			driver.switchTo().window(tabs.next());
			System.out.println(driver.getTitle());
		}
	}

}
