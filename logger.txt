package automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	static Logger logger = Logger.getLogger(test.class);



	public static void main(String[] args) {
		PropertyConfigurator.configure("Log4j.properties");
		// TODO Auto-generated method stub
		System.out.println(logger + "here");
		
		
		logger.info("hi");
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		
		 driver.get("https://omayo.blogspot.in/");
			String pageTitle= driver.getTitle();
			System.out.println("Title of the web page: " + pageTitle);
		
			logger.info("Surfing the site");
			

			WebElement DoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
	        Actions actions = new Actions(driver);
	        actions.doubleClick(DoubleClick).perform();
	        System.out.println("Double-clicked!");
	       logger.info("Double Click has been pressed");
			

	        Alert alert = driver.switchTo().alert();
			alert.accept(); 
		    driver.switchTo().defaultContent();
		    
		    

			//File Screenshot
				
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		      
			String destinationPath = "C:\\Users\\4871\\Downloads\\screenshot\\screenshots2.jpg";
		     try {
		      FileUtils.copyFile(screenshot, new File(destinationPath));
		      System.out.println("Screenshot saved: " + destinationPath);
		     	}catch (IOException e) {
		     	    System.out.println("Failed to save screenshot: " + e.getMessage());
		     	}
			
			driver.quit();
		

	}

}
