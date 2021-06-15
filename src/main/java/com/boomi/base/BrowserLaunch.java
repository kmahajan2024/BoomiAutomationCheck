package com.boomi.base;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import com.boomi.pages.BoomiLoginPage;
import com.boomi.testdata.ExcelTestData;
import com.boomi.util.TestUtil;

/**
 * 
 * @author KMAHAJAN
 *
 */

public class BrowserLaunch extends TestUtil{

	public static WebDriver driver;
	public static Properties prop;
	public static ExcelTestData reader = new ExcelTestData();
	public static Actions action;
	public static JavascriptExecutor executor;
	private org.slf4j.Logger log = LoggerFactory.getLogger(BrowserLaunch.class);
	public String dir = System.getProperty("user.dir");
	
	
	public BrowserLaunch() {
		
		try {
			prop = new Properties();
			
			FileInputStream in = new FileInputStream(dir
					+ "\\src\\main\\java\\com\\boomi\\config\\config.properties");
			prop.load(in);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void initialization() {
		
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty(prop.getProperty("chromeBrowser"), dir + prop.getProperty("driverLocation"));
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			
			if(driver != null) {
				driver.quit();
			}
			
			driver = new ChromeDriver(options);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
		driver.get(prop.getProperty("url"));
		
		waitFor(5);
		
		action = new Actions(driver);

		BoomiLoginPage login = new BoomiLoginPage();
		login.loginToBoomi();
	}
	
	@BeforeMethod
	public void testName(Method method){
		try {
			String nameOfTest = method.getName();
			startTestCase(nameOfTest);
		} catch (Exception e) {
			
		}
	}
	
	@BeforeSuite
	public void sheetRename() {
		reader.renameSheet();
	}
	
	@AfterMethod
	public void tearDown(){
		//sendEmail();
		extentB.flush();
		driver.quit();	
	}
}
