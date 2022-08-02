package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		
		
		//click on alertbox
	//	driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		//Get the text first froom alert
	//	Alert alert = driver.switchTo().alert();
	//	String text = alert.getText();
	//	System.out.println(text);
		
		//clickok
	//	alert.accept();
		
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.dismiss();
		String text2 = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		System.out.println(text2);
		
		 
		
		
		
		

	}

}
