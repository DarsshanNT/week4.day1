package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingLeafTaps {
	
	//1) Open the chrome
	//2) Login to leaftaps
	//3) Click CRM/SFA link
	//4) Click Leads Link
	//5) Click Merge Leads Link
	//6) Click the icon following the from lead
	//7) Switch to new window
	//8) Enter the first name as Babu
	//9) Click Find Leads Button
	//10) Click on the first resulting lead
	//11) Move the control back to first window

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>lstwindowhandles=new ArrayList<String>(windowHandles);
		String string = lstwindowhandles.get(1);
		System.out.println(string);
		driver.switchTo().window(string);
		driver.findElement(By.id("ext-gen27")).sendKeys("Darsshan");
		driver.findElement(By.id("ext-gen114")).click();
		driver.findElement(By.linkText("13585")).click();
		driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
