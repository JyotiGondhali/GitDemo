import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentChildWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.className("blinkingText")).click();
		
		//child tab navigation
		Set<String> tab= driver.getWindowHandles(); //get all open window tab id's. set will uniquely set the ids
		Iterator<String> travel = tab.iterator(); //iterator will iterate through these id's to read them 
		String parent = travel.next(); //next() returns the window id which we will store in variable.
		String child = travel.next(); //next() returns the another window id which we will store in variable.
		driver.switchTo().window(child);//switch control the child window.
		WebDriverWait time = new WebDriverWait(driver, Duration.ofSeconds(2));
		time.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='im-para red']")));
		
		// Please email us at mentor@rahulshettyacademy.com with below template to receive response
		
		String text = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		//2 ways to get the email id from text 
		//1st 
		String test = text.split("at")[1].trim().split(" ")[0];
		
		//2nd
//		String[] array1 = text.split("at");
//		String[] array2 = array1[1].split(" ");
//		String email = array2[1].trim();
		
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(test);
		
		System.out.println(test);
		
	}
	

}
