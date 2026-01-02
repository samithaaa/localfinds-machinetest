package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
//		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}

	public void setSignIn() 	//clicking sign in 
	{
		WebElement sign=driver.findElement(By.linkText("Sign In"));
		//		WebElement sign=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));  
		sign.click();
	}
	
	public void setEmail(String mail)	//send email to email field
	{
		WebElement eml=driver.findElement(By.cssSelector("input[placeholder='Email address'][name='email']"));
//		WebElement eml=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email address'][name='email']")));
		eml.clear();
		eml.sendKeys(mail);
	}
	
	public void setPassword(String passw)
	{
		
		WebElement pass=driver.findElement(By.cssSelector("input[placeholder='Password'][name='password']"));
//		WebElement pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password'][name='password']")));
		pass.clear();
		pass.sendKeys(passw);
	}
	
	public void setLogin()		//click signin after entering credentials
	{
		
		WebElement lgin=driver.findElement(By.xpath("//button[text()='Sign In']"));
//		WebElement lgin=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
     	lgin.click();
		}
	
	public WebElement checkInvalid()
   {
//	WebElement invalid =driver.findElement(By.xpath("//div[text()='Invalid credentials']"));
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	WebElement  invalid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Invalid credentials']")));  //Using Explicit Wait
		return invalid;
	}
	
	public WebElement checkValid()
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement  valid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Signed in successfully!']")));  //Using Explicit Wait
			return valid;
	}
	
}


