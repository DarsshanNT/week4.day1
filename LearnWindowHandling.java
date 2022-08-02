package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//print the window handling uniquevalue
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		
		//we learn how to control one window to another window
		driver.findElement(By.id("home")).click();
		
		//now check the windowhandle value - ctrl not move automaticallly.
		System.out.println(driver.getWindowHandle());
	//the unique value will same because the ctrl will not change 
		
		//how to move ctrl to second window
	//to convert getwindowhandles to set for unique	
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		//how can i get second from set
	//to change set to list
		List<String> lstwindowhandles =new ArrayList<String>(windowHandles);	
		String secondwindowhandle = lstwindowhandles.get(1);
		System.out.println(secondwindowhandle);
		
		//how can move ctrl to second window
		driver.switchTo().window(secondwindowhandle);
		
		//to print title
		System.out.println(driver.getTitle());
		
		//close
		driver.close();
	//it close only the second window 
	//because we change the ctrl to first window..
		
		//switch to primary
		driver.switchTo().window(windowHandle);
		
		//to print the first window title
		System.out.println(driver.getTitle());
		
		driver.close();
		
		//close all windows use quit
		driver.quit();
		


	}

}
