import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//For Currency Dropdown (Single select dropdown)
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select value = new Select(dropdown);
		value.selectByIndex(2);
		System.out.println(value.getFirstSelectedOption().getText());
		value.selectByValue("USD");
		System.out.println(value.getFirstSelectedOption().getText());
		value.selectByVisibleText("INR");
		System.out.println(value.getFirstSelectedOption().getText());
//		driver.close();
		
		
		//For Passengers Dropdown 
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int i=1;
		while (i<=4)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		driver.close();

		//For Dynamic DropDown 
		//(a[@value=\"JAI\"])[2]: it will search on whole page for this Xpath for 2nd matching index
		//a[@value=\"JAI\"][2]: it will check for 2nd index but under that a parent only 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"IXJ\"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value=\"JAI\"])[2]")).click(); 
		//Xpath without using index
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JAI']")).click();
		Thread.sleep(2000);
		
		//Calender
		driver.findElement(By.xpath("(//a[text()=\"18\"])[1]")).click();

		//enabled or disabled check
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"))
		{
			System.out.println("Enabled");
		}
		else
		{
			System.out.println("Disabled");
		}
		
		
		//Autosuggestive Dropdown
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			break;
			}
		}
		
		//Checkbox Selection
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		//Count of the total no of checkboxes present on the page
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}

}
