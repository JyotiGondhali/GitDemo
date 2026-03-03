import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String Year= "2027";
		String Month = "10";
		String Date = "22";
		
		String[] array = {Month, Date, Year};
		
		driver.findElement(By.cssSelector("svg[class*='react-date-picker__calendar-button__icon react-date-picker__button__icon']")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
		driver.findElement(By.xpath("//div[@class='react-calendar__year-view__months']/button[" +Month+ "]")).click();
		driver.findElement(By.xpath("//abbr[text()='"+Date+"']")).click();
		
		List<WebElement> calender = driver.findElements(By.cssSelector("input[class*='react-date-picker__inputGroup__input react-date-picker']"));
		
		for (int i=0;i<calender.size();i++)
		{
			System.out.println(calender.get(i).getAttribute("Value"));
			Assert.assertEquals(calender.get(i).getAttribute("Value"), array[i]);
		}
	}

}



































