package sevrices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class update_services extends add_service{
	
	
	
	
	
	
	@Test(priority=8,dependsOnMethods="search")
	public void edit() {

		WebElement edit= driver.findElement(By.xpath("//img[@src='images/edit.png']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", edit);
	}



	@Test(priority=9)
	public static void update() throws InterruptedException
	{
		Thread.sleep(5000);	

		driver.findElement(By.xpath("//input[@value='Update']")).click(); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

		Thread.sleep(5000);	

	}



	
	

}
