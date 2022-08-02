package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrame {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		
		
		
		

	}

}
