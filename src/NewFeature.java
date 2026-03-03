import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class NewFeature {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//open new tab 
		//driver.switchTo().newWindow(WindowType.TAB);
		
		//open new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> newTab = driver.getWindowHandles();
		Iterator<String> tab = newTab.iterator();
		String parent = tab.next();
		String child = tab.next();
		driver.switchTo().window(child);
		
		driver.get("https://rahulshettyacademy.com/");
		String course = driver.findElement(By.xpath("(//h3[contains(@class,'font-bold text-lg gro')])[1]")).getText();
		
		driver.switchTo().window(parent);
		WebElement name = driver.findElement(By.xpath("(//form/div/input)[1]"));
		name.sendKeys(course);
		
		//to capture the screenshot of particular element
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\SeleniumScreenshots\\element.png"));
		
		//to check the height and width of the element
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		
		driver.quit();
				

	}

}
