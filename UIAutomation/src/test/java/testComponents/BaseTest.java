package testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objects.Locators;

public class BaseTest {
	public WebDriver driver;
	public Locators locators;
	
	
	
	public WebDriver initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeClass
	public Locators launchapplication() {
		driver = initialization();
		locators = new Locators(driver);
		driver.get("https://www.worldometers.info/world-population/");
		return locators;
		
		
	}

}
