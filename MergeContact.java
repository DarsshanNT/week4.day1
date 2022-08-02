package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String> lstwindowhandles=new ArrayList<String>(windowHandles);
		String string = lstwindowhandles.get(1);
		System.out.println(string);
		driver.switchTo().window(string);
		driver.findElement(By.linkText("DemoCustomer")).click();
	driver.switchTo().window(windowHandle);
	
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		Set<String> windowHandle2 = driver.getWindowHandles();
		System.out.println(windowHandle2);
		List<String>lstwindowhandles2=new ArrayList<String>(windowHandle2);
		String string2 = lstwindowhandles2.get(1);
		driver.switchTo().window(string2);
		
		driver.findElement(By.linkText("DemoLBCust")).click();
	driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().window(windowHandle);	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
	driver.switchTo().window(windowHandle);	
		
		System.out.println(driver.getTitle());

	}

}
