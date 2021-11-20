package sevrices;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class add_service {




	public static WebDriver driver;

	@BeforeTest
	public static void intitalisation_drivers()
	{
		WebDriverManager.chromedriver().setup();

		ChromeOptions cop = new ChromeOptions();
		cop.addArguments("--disable-notifications");

		driver = new ChromeDriver(cop);



	}


	@Test(priority=0)
	public static void Link()

	{
		driver.navigate().to("https://staging.aapkedoorstep.com/");
		driver.manage().window().maximize();;
	}


	@Test(priority=1)
	public static void Login() throws InterruptedException

	{

		driver.findElement(By.id("email")).sendKeys("admin@doorstep.com");
		driver.findElement(By.id("password")).sendKeys("doorstep@123");
		driver.findElement(By.id("loginClick")).click();
		Thread.sleep(5000);	



		Thread.sleep(5000);	
	}

	@Test(priority=2)
	public static void Service_User()

	{
		driver.findElement(By.xpath("//div[@id='menu6']//img")).click();
	}


	@Test(priority=3)
	public static void Add_Service_User() throws InterruptedException, IOException

	{
		driver.findElement(By.xpath("//button[normalize-space()='Add New Service User']")).click();

		Thread.sleep(2000);
	}


	@Test(priority=4)
	public static void Upload_Profile_Photo() throws InterruptedException, IOException
	{

		Thread.sleep(2000);

		WebElement upload= driver.findElement(By.xpath("//img[@src='images/main-profile.png']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", upload);

		Thread.sleep(5000);

		Runtime.getRuntime().exec("E:\\Autoit\\autoit.exe"); // Uploaded Profile Picture Using Autoit External Plugin
		Thread.sleep(2000);

	}


	@Test(priority=5)
	public static void Login_Credentials() throws InterruptedException
	{

		driver.findElement(By.id("input-s-name")).sendKeys("Digvijay");
		driver.findElement(By.id("input-mo-no")).sendKeys("9764697407");
		driver.findElement(By.id("input-email-id")).sendKeys("dtikka6@gmail.com");

		Thread.sleep(5000);

		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("input-mo-no"))).sendKeys("Maha",Keys.TAB);
		Thread.sleep(5000);
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("input-email-id"))).sendKeys("Kolh",Keys.TAB);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Add']")).click(); 
		Thread.sleep(5000);
	}


	@Test(priority=6)

	public static void add() throws InterruptedException
	{

		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(5000);	
	}



	@Test(priority=7,dependsOnMethods="add")
	public void search() {

		driver.findElement(By.id("search-bar")).sendKeys("Digvijay", Keys.ENTER);

	}




}



