package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

	protected WebDriver driver;
	Properties prop;
	
	public void readProp() throws IOException  //for reading user.properties file
	{
		FileReader fle=new FileReader("C:\\Users\\LAB-USER-01\\Desktop\\MACHINE_TEST_SAMITHA\\LocalFinds\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fle);
	}
	@BeforeTest
	public void setUp() throws IOException	//driver initialization
	{   
		readProp();
		driver=new ChromeDriver();
		driver.manage().window().maximize();	//maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait
		//driver.get("https://localfinds-two.vercel.app/");  
		driver.get(prop.getProperty("url"));
		//loading the url to be tested
	}
	
	@AfterTest
	public void tearDown() //for quitting browser after test
	{
		driver.quit();
	}
}
