package com.boomi.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.boomi.base.BrowserLaunch;
import com.boomi.pages.CommonFilters;

public class RunAllInForLoop extends BrowserLaunch {

	public static Logger log = LoggerFactory.getLogger(RunAllInForLoop.class);

	CommonFilters commonFilter;
	String processRunning;
	int rowNum=0;
	@Test
	public void test_All() {

		commonFilter = new CommonFilters(logger);
 
		try {
			commonFilter.oneTimeFilter();
			for(int i=0; i<77; i++) {
				
				rowNum= i+1;
				
				String processRunning = reader.getValueOfColumn("PROCESS_NAME", rowNum);
				
				log.info("Currently "+ processRunning + " is Running");
				
				System.out.println("Currently "+ processRunning + " is Running");
				
				if(processRunning.equals("JMS_Q_to_WUB_ProjectsInfo")) {
					
					commonFilter.process_OraFinProjectInfo(reader.getValueOfColumn("PROCESS_NAME", rowNum-1), rowNum-1);

					commonFilter.process_JMSProjectInfo(reader.getValueOfColumn("PROCESS_NAME", rowNum), rowNum);
					
				}else {
					commonFilter.applyCommonFiltersAndFetchData(reader.getValueOfColumn("PROCESS_NAME", rowNum), rowNum);
				}
				
				commonFilter.clearProcess();
				
				log.info("Process - " + processRunning + " is completed");
				
				System.out.println("Process - " + processRunning + " is completed");

			}
			
			sendEmail();
			
			log.info("=====Email Sent=====");

		} catch (Exception e) {
			
			e.printStackTrace();
			addErrorWithScreenshot("Test Failed");
			Assert.fail("Test case failed");
			//sendEmail();
		}
	}
	
	/*@Test
	public void test_Orafin_to_AQueue_ActualCosts() {

		commonFilter = new CommonFilters(logger);

		try {
			processRunning = reader.getValueOfColumn("PROCESS_NAME", 69);
			
			log.info("Currently "+ processRunning + " is Running");
			
			System.out.println("Currently "+ processRunning + " is Running");
			
			commonFilter.oneTimeFilter();
			
			commonFilter.applyCommonFiltersAndFetchData(reader.getValueOfColumn("PROCESS_NAME", 69), 69);
			
			commonFilter.clearProcess();
			
			log.info("Process - " + processRunning + " is completed");
			
			System.out.println("Process - " + processRunning + " is completed");

		} catch (Exception e) {
			e.printStackTrace();
			addErrorWithScreenshot("Test Failed");
			Assert.fail("Test case failed");
		}
	}*/
	
}
