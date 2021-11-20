package sevrices;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class search_compare extends delete_services{
	
	@Test(priority=11)
	public void search_compare() throws InterruptedException {

		driver.findElement(By.id("search-bar")).clear();
		
		driver.findElement(By.id("search-bar")).sendKeys("Rutu");
		Thread.sleep(5000);
		
		String service_user= driver.findElement(By.xpath("//span[@class='ServicePersons-name']")).getText();
		
		System.out.println(service_user);
		
		assertEquals(service_user, "Digvijay");
		
	}

	

}
