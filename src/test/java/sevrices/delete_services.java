package sevrices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class delete_services extends update_services {

	
	
	

	@Test(priority=10)
	public void delete() throws InterruptedException {

		WebElement delete= driver.findElement(By.xpath("//img[@src='images/delete.png']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", delete);

		Thread.sleep(5000);	
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(5000);	
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

		Thread.sleep(5000);	

	}

}
