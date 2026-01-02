package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends TestBase{
	
	LoginPage lp;
	HomePage hpg;
	
	WebDriverWait wait;
	
	@BeforeClass
	public void objInit()  //object initialization 
	{  
	
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		lp=new LoginPage(driver);
		hpg = new HomePage(driver);	
		
	}
	
	@Test(priority=1)
	public void invalidLogin() throws InterruptedException, IOException
	{
		lp.setSignIn();
//		lp.setEmail("abc@gmail.com");
//		lp.setPassword("12345");
		
		lp.setEmail(ExcelUtility.readExcel(0, 0));  //Reading the credentials from Excel using ExcelUtility
		lp.setPassword(ExcelUtility.readExcel(0, 1));
		lp.setLogin();
		Thread.sleep(2000);
		WebElement invalid=lp.checkInvalid();
		Assert.assertTrue(invalid.isDisplayed()); //assert that invalid credentials message is displayed
		
	}
	
	@Test(priority=2)
	public void validLogin() throws InterruptedException
	{
		lp.setSignIn();
		lp.setEmail("mahi@gmail.com");
		lp.setPassword("mahi123");
		lp.setLogin();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("marketplace"));  //check whether user logged in and markketplace is loaded
		WebElement valid=lp.checkValid();
		Assert.assertTrue(valid.isDisplayed()); //Assert that login successful message is displayed
		Thread.sleep(1000);
		
	
	}
	
	
	@Test(priority=3)
	public void prodCheck() throws InterruptedException   //select product and validate its name and details
	{
		hpg.selectProduct();
        
		WebElement prod=hpg.checkProductName();
		Assert.assertTrue(prod.isDisplayed()); //assert product name is displayed
		WebElement price=hpg.checkProductPrice();
		Assert.assertTrue(price.isDisplayed());
		hpg.addProd(); //Adding product to cart
		hpg.loggingOut(); //Logout from account
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
		
	}
	

}
