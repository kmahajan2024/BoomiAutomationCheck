package com.boomi.util;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import com.aventstack.extentreports.Status;
import com.boomi.base.BrowserLaunch;
import com.boomi.base.ExtentsReportConfig;

public class TestUtil extends ExtentsReportConfig{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT = 10;
	
	public static long ELEMENT_TIMEOUT = 30;
	
	public static JavascriptExecutor executor;
	
	String dir = System.getProperty("user.dir");
	
	private org.slf4j.Logger log = LoggerFactory.getLogger(TestUtil.class);
	
	public static void waitFor(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String takeScreenshot() throws Exception {
		TakesScreenshot screen = (TakesScreenshot) BrowserLaunch.driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = currentDir() + "//screenshots//" + testcaseName + "_" + currentDateTime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	public void addErrorWithScreenshot(String info) {
		try {
			logger.log(Status.FAIL, info + logger.addScreenCaptureFromPath(takeScreenshot()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addInfoWithScreenshot(String info) {
		try {
			logger.log(Status.PASS, info + " " + logger.addScreenCaptureFromPath(takeScreenshot()));
			log.info("Screenshot attached: " + info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String isMonday() {
		Format dateFormat = new SimpleDateFormat("EEE");
		String todayIsMonday = dateFormat.format(new Date());
		System.out.println(todayIsMonday);
  		return todayIsMonday;
	}
	
	public static void userSendKeys(WebDriver driver, WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void userClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public static void waitUntilAvailabel(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public static void pageLoadTimeOut(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOf(element));
		//element.click();
	}
	
	public static void userClickAndWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		waitFor(3);
	}
	
	public static void javaScriptClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public boolean isVisible(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean verifyIsEnabled(WebElement element) {
		try {
			element.isEnabled();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public static String currentDate() {

		LocalDateTime dateC = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		String dateCurrent = dateC.format(formatter);
		return dateCurrent;
	}

	public static String yesterdayDate() {

		LocalDateTime dateC = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDateTime dateY = dateC.minusDays(1);
		String dateYesterday = dateY.format(formatter);
		return dateYesterday;
	}

	public static String lastFridayDate() {

		LocalDateTime dateC = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDateTime dateY = dateC.minusDays(3);
		String dateYesterday = dateY.format(formatter);
		return dateYesterday;
	}
	
	public static void pageRefresh() {
		
		BrowserLaunch.driver.navigate().refresh();
		
		waitFor(3);
		
	}
	
	public static void sendEmail() {
		String dir = System.getProperty("user.dir");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.outlook.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
 		props.put("mail.smtp.auth", "true");
 		props.put("mail.smtp.port", "587");
 
 		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("kishor.mahajan@capgemini.com", "Apr#2021");
 
					}
 
				});
 
		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("kishor.mahajan@capgemini.com"));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sw-cg-apps-int-boomi.in@capgemini.com"));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("suchitra.mohanty@capgemini.com, ajeyatha.athyala@capgemini.com, priyanka.singh@capgemini.com"));
			message.setSubject("Finance Integration Run Status");

			BodyPart messageBodyPart1 = new MimeBodyPart();

			messageBodyPart1.setText("Good Morning All,\r\n" + 
					"\r\n" + 
					"Data for all processes are fetch. \r\n" + 
					"\r\n" + 
					"PFA report for reference\r\n" + 
					"\r\n" + 
					"Regards\r\n" + 
					"Automation Team");
			
			BodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = dir + "\\ExcelSheet\\Boomi_Test_Data_And_Result.xlsx";

			DataSource source = new FileDataSource(filename);

			messageBodyPart2.setDataHandler(new DataHandler(source));

			messageBodyPart2.setFileName("Daily_Report_Status.xlsx");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart1);

			multipart.addBodyPart(messageBodyPart2);

			message.setContent(multipart);

			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
			
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
 
	}
}
