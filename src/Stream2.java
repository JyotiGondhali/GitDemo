import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//get the price of the Apple which is present under page 4
public class Stream2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
						
		List<String> value;
		do {
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		value = list.stream().filter(f->f.getText().contains("Brinjal")).map(m->getprice(m)).collect(Collectors.toList());
		value.forEach(f->System.out.println(f));
		if(value.size()==0)
		{
			driver.findElement(By.xpath("(//a[@role='button'])[7]")).click();
		}
		
	}while(value.size()==0);
		
}
		
	private static String getprice(WebElement m) {
		String price = m.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
