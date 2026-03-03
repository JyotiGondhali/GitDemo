import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HTTPSCertificate {

	public static void main(String[] args) throws IOException {
//		ChromeOptions option = new ChromeOptions();
//		option.setAcceptInsecureCerts(true);
//		WebDriver driver = new ChromeDriver(option);
//		driver.get("https://expired.badssl.com/");
//		System.out.println(driver.getTitle());
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\SeleniumScreenshots\\screenshot.png"));
		
	}

}
