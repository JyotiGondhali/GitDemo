import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//1. write the code to compare the sort is working or not

public class Stream {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//clicked on column and sort got applied
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		
		//written the xpath for 1st column items
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		
		//extracted the actual data from 1st column 
		List<String> originalValue = list.stream().map(data -> data.getText()).collect(Collectors.toList());
		System.out.println(originalValue);
		//sorted the original value extracted from page
		List<String> sortedValue = originalValue.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedValue);
		//now comparing both values are equal or not
		
		Assert.assertTrue(originalValue.equals(sortedValue));
		
}
}