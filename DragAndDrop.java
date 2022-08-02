package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		https://jqueryui.com/droppable/
			
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/droppable/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
			WebElement drop = driver.findElement(By.xpath("//p[text()='Drop here']"));
			Actions builder = new Actions(driver);
			builder.dragAndDrop(drag, drop).perform();
			System.out.println(drop.getText());
	}

}
