package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
		
		//close the x button
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		//mouceover electronic menu
		WebElement ele = driver.findElement(By.xpath("//div[text()='Electronics']"));
		//move to action class
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();

	}

}
