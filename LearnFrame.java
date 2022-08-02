package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();

		
		//by ctrl+f = //iframe and find the frame by index and switch to frame
	//	driver.switchTo().frame(0);
		
		//click on the click me
	//	driver.findElement(By.id("Click")).click();
		
		
		
		// switch to parent frame by webelement
		WebElement parentframe = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(parentframe);
		
		//switch to child frame
		driver.switchTo().frame("frame2");
		
		//click on the click me
		driver.findElement(By.id("Click1")).click();
		
		// come out of the frame use switchto defaultcontent
		driver.switchTo().defaultContent();
		
		}

}
