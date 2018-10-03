package kbratest;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import usefulmethods.GenericMethods;

public class PhpEvalCautionTest {

	private WebDriver driver;
	private GenericMethods gm;
	private String baseURL;
	
	@BeforeEach
	void setUp() throws Exception {
		//Initiate ChromeDriver with ChromeOptions to set User Agent to Chrome 60 on Windows 10
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan.mufti\\Documents\\workspace_personal\\selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36");
		driver = new ChromeDriver(options);
		
		//Create object of GenericMethods class for use
		gm = new GenericMethods(driver);
		
		//Set base URL and maximize browser window when test is initiated
		baseURL = "http://www.php.net/";
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		driver.get(baseURL);
		
		//Explicitly wait for the search field for 3 seconds
		WebElement searchField = gm.waitForElement(By.xpath("//input[@class='search-query tt-query']"), 3);
		
		//Once field is located, send string value and press enter
		searchField.sendKeys("eval");
		searchField.sendKeys(Keys.RETURN);
		
		//Create list of WebElements with text containing "Caution"
		Boolean cautionExists = gm.isElementPresent("//*[text()[contains(.,'Caution')]]", "xpath");
		
		//Assert here. Fail if list is !> 0 (cautionExists returns false)
		Assert.assertTrue("Unable to find elements with text 'Caution'", cautionExists);
		
	}

}
