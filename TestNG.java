package automation;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestNG {
	static Logger logger = Logger.getLogger(test.class);
	WebDriver driver;
	@Test(priority=0)
	public void AccesstoSite()
	{
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject");
		 logger.info("Site surfing passed");
	}
	@Test (priority=1)
	public void Managerlogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement Mlogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Manager Log')]")));
		Mlogin.click();
		
		 logger.info("Manager has logged in to server");
		 
	}
	@Test(priority=2)
	public void Addcustomer()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Addcust = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-class=\"btnClass1\"]")));
		Addcust.click();
		logger.info("Customer add tab open");
	}
	
	@Test(priority=3)
	public void customerdetails()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement FirstN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@ng-model=\"fName\"]")));
		
		FirstN.sendKeys(("Shoaib"));
		
		WebElement LastN= driver.findElement(By.xpath("//input[@ng-model=\"lName\"]"));
		LastN.sendKeys(("Ahmad"));
		
		WebElement Pcode= driver.findElement(By.xpath("//input[@ng-model=\"postCd\"]"));
		Pcode.sendKeys(("48240"));
		
		 WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
		  submit.click();
		  Alert alert = driver.switchTo().alert();
		  alert.accept(); 
	      driver.switchTo().defaultContent();
		
		logger.info("Customer detail added");
	}
	
	@Test(priority=4)
	public void OpenAccount()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Openacc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-class='btnClass2']")));
		Openacc.click();
		
		
		
		WebElement baropen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='userSelect']")));
		 Select baropen1=new Select(baropen);
		 baropen1.selectByVisibleText("Shoaib Ahmad");
		
		 
		 WebElement curopen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='currency']")));
		 Select curopen1=new Select(curopen);
		 curopen1.selectByVisibleText("Rupee");
		 
		 WebElement process= driver.findElement(By.xpath("//button[@type='submit']"));
		  process.click();
		  Alert alert = driver.switchTo().alert();
		  alert.accept(); 
	      driver.switchTo().defaultContent();
		 
		logger.info("Customer Account opened");
	}
	
	@Test(priority=5)
	public void Customerlogin()
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement Home = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Home')]")));
		Home.click();
		
		
		WebElement Clogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Customer Log')]")));
		Clogin.click();
		
		 logger.info("Customer has logged in to server");
		
		
	}
	
}
