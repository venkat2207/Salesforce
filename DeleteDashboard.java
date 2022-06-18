package SalesforceOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteDashboard {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
        
        
    	
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(options);
        
        
		
	
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		
		driver.findElement(By.id("Login")).click();
		

		driver.findElement(By.className("slds-icon-waffle")).click();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboard");
		
		
		WebElement element = driver.findElement(By.xpath("//mark[text()='Dashboard']/.."));
	     
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    
		executor.executeScript("arguments[0].click();", element);
		
		
		driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]/..")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("venkat",Keys.RETURN);
		

		
		driver.findElement(By.xpath("//table/tbody//th//span[text()='Venkat']/ancestor::th/following-sibling::td[6]//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Delete']//parent::a")).click();
		
		
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		
		String text = driver.findElement(By.xpath("//span[text()='Dashboard']")).getText();
		
		
		System.out.println(text);
		
		if (text.contains("deleted"))
			
		{
			
			System.out.println("successfully deleted");
		}
		
		
		
	}

}
