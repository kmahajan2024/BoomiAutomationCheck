package com.boomi.base;

import java.util.Date;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReportConfig {
	
	 protected ExtentHtmlReporter reporter= null;
	 protected ExtentReports extentB = null;
	 public ExtentTest logger= null;
	 protected String testcaseName;
	 
	 
	 public void configExtendReport(){
	   String dir = System.getProperty("user.dir");
	   System.out.println("Current Directory :"+ dir );	 
	   String fileName = currentDateTime();
	   reporter = new ExtentHtmlReporter(dir+"/test-result/Automation_"+fileName+".html");
	   extentB = new ExtentReports();
	   extentB.setSystemInfo("OS", "Windows");
       extentB.setSystemInfo("Browser", "Chrome");
       extentB.attachReporter(reporter);
	  
	  reporter.config().setDocumentTitle("Boomi Automation Report");
	  reporter.config().setReportName("Test Report");
	  reporter.config().setTheme(Theme.STANDARD);
	  reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 	}
	 
	 public void startTestCase(String testcasename) throws Exception{
		 this.testcaseName = testcasename;
		 logger = extentB.createTest(testcasename);
		
	 }
	 
	 @BeforeSuite
		public void initExtentReport() {
			
			configExtendReport();
		}
	 
	 
	 public String currentDir(){
		 return  System.getProperty("user.dir"); 
	 }
	 
	 @SuppressWarnings("deprecation")
	public String currentDateTime(){
		return (new Date().getYear()+1900)+"_"
	   				+(new Date().getMonth()+1)+"_"
	   				+(new Date().getDate())+"_"
	   				+(new Date().getHours())+"_"
	   				+(new Date().getMinutes())+"_"
	   				+(new Date().getSeconds());

	 }
}

