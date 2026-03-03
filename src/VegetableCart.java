import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegetableCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] veg = { "Beetroot", "Beans", "Brocolli", "Mango" };
		itemsAdd(driver, veg);
		cartAdd(driver);
	}

	public static void itemsAdd(WebDriver driver, String[] veg) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4[class=product-name]"));

		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			List vegitable = Arrays.asList(veg);// convert Array to Array List

			String product = products.get(i).getText();// get the vegitables from the web browser
			String[] name = product.split("-");// eg. Cucumber - 1 Kg > - split means 0th index Cucumber will store and
												// 1st index 1Kg will store
			String actualName = name[0].trim(); // for 0rth index after cucumber one space is present so using trim()
												// method it will trim that space

			if (vegitable.contains(actualName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println(actualName);
				j++;
			}

			if (j == veg.length) {
				System.out.println("End");
				break;
			}

		}
		
	}
	
	public static void cartAdd(WebDriver driver)
	{
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		WebDriverWait web= new WebDriverWait(driver,Duration.ofSeconds(5));
		web.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		web.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		System.out.println(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText());
	}
	

}
