package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		
		//switch to the frame
		driver.switchTo().frame(0);
		//find the element
		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		System.out.println(drag.getLocation());
		//drag and drop
	//go action class to mouseover the drag and drop
		//create object
		Actions builder = new Actions(driver);
		
		//call the class 
	//all the action will end with perform();	
		builder.dragAndDropBy(drag, 100, 50).perform();
		
		//to know the position
		System.out.println(drag.getLocation());

	}

}
