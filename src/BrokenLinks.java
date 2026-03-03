import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement web = driver.findElement(By.id("gf-BIG"));
		List<WebElement> list = web.findElements(By.tagName("a"));
		SoftAssert sa = new SoftAssert();
		
		for(int i=0;i<list.size();i++)
		{
			String url = list.get(i).getAttribute("href");
			//System.out.println(url);
			HttpURLConnection link = (HttpURLConnection) new URI(url).toURL().openConnection();
			link.setRequestMethod("HEAD");
			link.connect();
			int code=link.getResponseCode();
			
			sa.assertTrue(code<=400, "URL is Broken: "+list.get(i).getText());
			
		}

		sa.assertAll();
	}

}
