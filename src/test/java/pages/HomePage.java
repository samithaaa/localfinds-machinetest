package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;	
	}

	
	public void selectProduct() //clicking a product and viewing its details
	{
		
		WebElement prod=driver.findElement(By.xpath("//p[text()='toys']"));
		prod.click();
	}
	
	public WebElement checkProductName() //validating product name
	{
		WebElement prodname= driver.findElement(By.xpath("//h2[text()='toys']"));
		return prodname;
	}
	
	public WebElement checkProductPrice() //validating product price
	{
		WebElement price=driver.findElement(By.xpath("//div[text()='2000.00']"));
		return price;
	}
	public void addProd()
	{
		WebElement add=driver.findElement(By.xpath("//button[text()='Add to Cart']"));  //checking add to cart functionality
		add.click();
	}
	
	public void loggingOut()
	{
		WebElement logout=driver.findElement(By.xpath("//button[text()='Logout']"));
		logout.click();
		
	}
}
