package com.boomi.pages;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.boomi.base.BrowserLaunch;

public class CommonFilters extends BrowserLaunch {

	@FindBy(xpath = "//*[@data-locator='link-manage-menu']")
	WebElement manageMenu;

	@FindBy(xpath = "//*[@data-locator='link-process-reporting']")
	WebElement processReporting;

	@FindBy(xpath = "//*[contains(@data-locator,'button-past')]")
	WebElement durationFilter;

	@FindBy(xpath = "//*[@data-locator='formrow-past-24-hours-input']")
	WebElement durationFilterForPast24Hours;

	@FindBy(xpath = "//*[@data-locator='formrow-past-week-input']")
	WebElement durationFilterForPastWeek;

	@FindBy(xpath = "//*[@data-locator='button-apply']")
	WebElement clickApply;

	@FindBy(xpath = "//*[@data-locator='button-add-filter']")
	WebElement clickAddFilter;

	@FindBy(xpath = "//div[contains(text(),'Atoms')]")
	WebElement filterByAtoms;

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'prd_')]//parent::span/input[@type='checkbox']") })
	List<WebElement> selectAllProd;

	@FindBy(xpath = "//div[@class='filter_type']//div[contains(text(),'Process')]")
	WebElement filterByProcess;

	@FindBy(xpath = "//input[@class='filter_input uneditable_text']")
	WebElement clickOnUneditableText;

	@FindBy(xpath = "//input[@class='filter_input']")
	WebElement filterInputByText;

	@FindBy(xpath = "//div[contains(text(),'JMS')]//following-sibling::label[contains(text(),'ErrorLogger')]//following-sibling::div[strong='Successes:']")
	WebElement clickOnJMSSuccess;
	
	@FindBy(xpath = "//div[contains(text(),'JMS')]//following-sibling::label[contains(text(),'ErrorDetails')]//following-sibling::div[strong='Successes:']")
	WebElement clickOnErrorDetailsJMSSuccess;
  
	@FindBy(xpath = "//div[contains(text(),'JMS')]//following-sibling::div")
	WebElement getJMSSuccessNo;

	@FindBy(xpath = "//div[@id='execution_detail_panel']//div[contains(text(),'JMS')]")
	WebElement linkJMS;

	@FindBy(xpath = "//div[contains(text(),'JMS')]//following-sibling::label[contains(text(),'ErrorLogger')]")
	WebElement isJMSErrorLoggerPresent;
	
	@FindBy(xpath = "//div[contains(text(),'JMS')]//following-sibling::label[contains(text(),'ErrorDetails')]")
	WebElement isJMSErrorDetailsPresent;

	@FindAll({
			@FindBy(xpath = "(//div[contains(@class,'modal_contents')]//div[@class='GPGODNGDPL'])[2]/table/tbody/tr/td[3]") })
	List<WebElement> openDoc;

	@FindBy(xpath = "//a[contains(text(),'View Document')]")
	WebElement viewDocument;

	@FindBy(xpath = "//div[@class='stylizedDocumentViewer']/div//following-sibling::div[contains(text(),'ErrorMessage')]//following-sibling::div[contains(@class,'value')]")
	WebElement getErrorMsg;
	
	@FindBy(xpath = "//div[@class='stylizedDocumentViewer']//div[contains(text(),'Error Message')]//following-sibling::div[contains(@class,'value')]")
	WebElement getErrorMsgDiffType;

	@FindBy(xpath = "//button[@data-locator='button-close-document-viewer']")
	WebElement closeDocViewer;

	@FindBy(xpath = "//button[@data-locator='button-close']")
	WebElement closeButton;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[2]/div/div")
	WebElement selectDateLink;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[10]/div")
	WebElement execDuration;

	@FindBy(xpath = "//button[@data-locator='button-actions']")
	WebElement actionButton;

	@FindBy(xpath = "//a[@data-locator='link-actions-view-extended-information']")
	WebElement viewExtendedInfo;

	@FindBy(xpath = "//div[@data-locator='formrow-deployment-id']")
	WebElement getDeploymentID;

	@FindBy(xpath = "//div[@class='modal']/div[@class='button_set']/button[@data-locator='button-close']")
	WebElement closeExtendedInfo;

	@FindBy(xpath = "(//div[contains(@class,'modal_contents')]//button[@data-locator='button-next'])[1]")
	WebElement nextButtonError;

	@FindBy(xpath = "(//div[@class='modal_contents']//div[@class='table']//div[@class='gwt-HTML'])[1]")
	WebElement totalElements;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[8]")
	WebElement dataInCount;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[9]")
	WebElement dataOutCount;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[4]")
	WebElement processName;

	@FindAll({ @FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr/td[8]") })
	List<WebElement> totalInCount;

	@FindAll({ @FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr/td[9]") })
	List<WebElement> totalOutCount;

	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr/td/div[contains(text(),'There is no data to display.')]")
	WebElement noDataText;

	@FindBy(xpath = "(//button[@data-locator='button-next'])[1]")
	WebElement verifyNextButton;
	
	@FindBy(xpath = "(//button[@data-locator='button-previous'])[1]")
	WebElement verifyPreviousButton;
	
	@FindBy(xpath = "(//a[@data-locator='link-first'])[1]")
	WebElement firstPage;
	
	@FindBy(xpath = "(//button[@data-locator='button-clear'])[2]")
	WebElement clearProcessFilter;
	
	@FindBy(xpath = "//div[contains(text(),'Hide Successes with 0 Inbound Docs')]")
	WebElement filterBy0InBounds;
	
	@FindBy(xpath = "(//button[@data-locator='button-clear'])[3]")
	WebElement clear0InBoundsFilter;
	
	@FindBy(xpath = "//button[contains(text(), 'Close Dialog')]")
	WebElement viewDocDialogue;
	
	@FindBy(xpath = "(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[1]//img[@title='In Process']")
	WebElement verifyProcessStatus;
	
	@FindBy(xpath = "//button[@data-locator='button-hide-successes-with-0-inbound-docs']")
	WebElement hideInBoundsFilter;

	public CommonFilters(ExtentTest logger) {
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	String inData = null;
	String outData = null;
	String execDateTime = null;
	String executioDuration = null;
	String componentID = null;
	String errorMsg;
	int counter = 0;
	int coll = 0;
	int dataFetchedCounter = 0;
	boolean isVisited = false;
	int outDataCount = 0; 
	WebElement processStatus;

	private org.slf4j.Logger log = LoggerFactory.getLogger(CommonFilters.class);

	public void addInfoWithScreenshot(String info) {

		try {
			waitFor(2);
			logger.log(Status.PASS, info + " " + logger.addScreenCaptureFromPath(takeScreenshot()));
			log.info("Screenshot : " + info);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public String takeScreenshot() throws Exception {
		BrowserLaunch.driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = currentDir() + "//screenshots//" + testcaseName + "_" + currentDateTime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public void updateErrorInExcel(int rowNum) {

		try {
			for (int i = 0; i < openDoc.size(); i++) {
				waitFor(2);

				action.moveToElement(openDoc.get(i)).build().perform();

				openDoc.get(i).click();

				userClickAndWait(driver, viewDocument);
				waitFor(5);
				
				while(isVisible(viewDocDialogue)==true) {
					waitFor(5);
				}
				
				if(isVisible(getErrorMsg)==true || isVisible(getErrorMsgDiffType)==true) {
				
					if(isVisible(getErrorMsg)==true) {
						errorMsg = getErrorMsg.getText();
						
					}
					else {
						errorMsg = getErrorMsgDiffType.getText();
					}

					String errorCollNum = String.valueOf(++coll);

					reader.setCellData("ERROR_" + errorCollNum, rowNum, errorMsg);
				}

				javaScriptClick(driver, closeDocViewer);

			}

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();

		}
	}

	public void errorMessageCapture(int rowNum) {

		try {
			if (isVisible(isJMSErrorLoggerPresent) == true || isVisible(isJMSErrorDetailsPresent) == true) {

				coll = 0;
				if(isVisible(isJMSErrorLoggerPresent) == true) {
					userClickAndWait(driver, clickOnJMSSuccess);
				}
				else {
					userClickAndWait(driver, clickOnErrorDetailsJMSSuccess);
				}
				

				updateErrorInExcel(rowNum);

				while (nextButtonError.isEnabled()) {

					userClick(driver, nextButtonError);
					updateErrorInExcel(rowNum);

				}

				userClick(driver, closeButton);

				reader.setCellData("STATUS", rowNum, "PARTIALLY COMPLETE");
				reader.colorRow(rowNum, "Orange");

			} else {

				userClick(driver, closeButton);
				reader.setCellData("STATUS", rowNum, "COMPLETE");
			}

		} catch (Exception e) {
			logger.fail(e.getMessage());
			e.printStackTrace();
			//Assert.fail();


		}
	}

	public void selectProcessReporting() {
		try {
			userClick(driver, manageMenu);

			userClick(driver, processReporting);
		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();

		}
	}

	public void duration() {
		try {
			waitFor(2);
			userClick(driver, durationFilter);

			if (isMonday().equals("Mon")) {
				waitFor(1);
				userClick(driver, durationFilterForPastWeek);
				addInfoWithScreenshot("Screen captured");
				waitFor(1);
			} else {
				waitFor(1);
				userClick(driver, durationFilterForPast24Hours);
				addInfoWithScreenshot("Screen captured");
				waitFor(1);
			}

			userClickAndWait(driver, clickApply);
		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();

		}
	}

	public void environment() {
		try {
			userClickAndWait(driver, clickAddFilter);

			userClickAndWait(driver, filterByAtoms);

			for (int i = 0; i < selectAllProd.size(); i++) {
				selectAllProd.get(i).click();
			}

			userClickAndWait(driver, clickApply);

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();

		}
	}

	public void selectProcess(String processName, int index) {
		try {
			if (isMonday().equals("Mon")) {
				
				if(processName.equals("JMS_Q_Activity_OPEX_XML_to_Orafin") || processName.equals("JMS_Q_Activity_CAPEX_XML_to_Orafin") 
						|| processName.equals("Ellipse_to_Orafin_POReceipts_test") || processName.equals("Ellipse_To_Orafin_POCreate_test") 
						|| processName.equals("JMS_Q_WOCost_XML_to_OraFin") || processName.equals("JMS_Q_InvoiceCDM_to_WUB_BillDtls")
						|| processName.equals("MSD365_to_JMS_Q_Non_Domestic_Billing") || processName.equals("JMS_Q_to_WUB_ProjectsInfo")
						|| processName.equals("JMS_Q_BillIN_XML_to_WUB_Billing") || processName.equals("OraFin_to_ePay_BACSProcessing")
						|| processName.equals("MSDCRM_to_Disk_NonPrimary") || processName.equals("Disk_to_JMS_NonPrimary")
						|| processName.equals("OraFin_to_ePay_BACSProcessing_subProcess")) {
					
					userClick(driver, durationFilter);

					userClick(driver, durationFilterForPast24Hours);
					
					userClickAndWait(driver, clickApply);
				}
			}
			
			userClick(driver, clickAddFilter);

			userClick(driver, filterByProcess);

			userClick(driver, clickOnUneditableText);

			userSendKeys(driver, filterInputByText, processName);

			if (processName.equals("WUB_to_JMS_Q_NewDomesticBillDtls") || processName.equals("JMS_Q_eInvoice_to_OraFin") || processName.equals("LIMS_to_CDR_PRODUCT_SPEC")) {
				WebElement pName = driver.findElement(By.xpath("(//div[@data-locator='item-"
						+ processName.toLowerCase().replaceAll("[_/& ]", "-") + "']//input[@type='checkbox'])[2]"));

				userClick(driver, pName);

				userClickAndWait(driver, clickApply);

			} else {
				WebElement pName = driver.findElement(By.xpath("(//div[@data-locator='item-"
						+ processName.toLowerCase().replaceAll("[_/& ]", "-") + "']//input[@type='checkbox'])[1]"));

				userClick(driver, pName);

				userClickAndWait(driver, clickApply);
			}
			
			if(processName.equals("JMS_Q_InvoiceCDM_to_WUB_BillDtls")) {
				userClick(driver, clickAddFilter);
				userClick(driver, filterBy0InBounds);
			}

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();
			
		}
	}

	public void fetchDataBasedOnDate(String processName, int index, String date) {
		try {
			
			List<WebElement> runDate = driver.findElements(By.xpath("//*[contains(text(),'" + date + "')]"));
			for (int i = 0; i < runDate.size(); i++) {

				int rowNum = i + 1;

				action.moveToElement(totalInCount.get(i)).build().perform();

 				int verifyInData = Integer.parseInt(driver.findElement(
						By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
								+ rowNum + "]/td[8]"))
						.getText());

				int verifyOutData = Integer.parseInt(driver.findElement(
						By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
								+ rowNum + "]/td[9]"))
						.getText());
				
				String processStatus = driver.findElement(By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody"
						+ "/tr[" +rowNum+ "]/td[1]//img")).getAttribute("title");

				if (runDate.size() == 1) {

					isVisited = true;

					if (verifyInData >= 0 && verifyOutData == 0) {

						if(processStatus == "In Progress") {
							updateDataInExcel(index, i);
							reader.setCellData("STATUS", index, "PENDING");
							reader.colorRow(index, "BlueGrey");
							errorMessageCapture(index);
						}else {
							updateDataInExcel(index, i);
							reader.setCellData("COMMENT", index, "No Data");
							reader.colorRow(index, "Yellow");
							errorMessageCapture(index);
						}
						
					} else {
						if(processStatus == "In Progress") {
							updateDataInExcel(index, i);
							reader.setCellData("STATUS", index, "PENDING");
							reader.colorRow(index, "BlueGrey");
							errorMessageCapture(index);
						}else {
						updateDataInExcel(index, i);

						errorMessageCapture(index);
						}
					}

					break;
				} else if (verifyInData > 0 && verifyOutData > 0) {
					
					if(processName.equals("Ls-JMS_Q_MSD365_NewDomesticBillDtls") || processName.equals("Ls-WSS_SOAP_EPayment_WUB")) {
						if(verifyInData == 1 && verifyOutData >= 2) {
							isVisited = true;
							counter++;
							updateDataInExcel(index, i);

							errorMessageCapture(index);
						}
						
					}else {
						isVisited = true;
						counter++;
						updateDataInExcel(index, i);

						errorMessageCapture(index);
					}
					
				}
				
				if(counter>=9) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();
		}
	}

	public void selectRecordAndFetchData(String processName, int index) {

		try {
			if (isVisible(noDataText) == true) {

				reader.setCellData("STATUS", index, "N/A");

				if(processName.equals("OraFin_to_CISP_CapitalCosts") || processName.equals("CISP_to_JMS_T_CapProject") 
						|| processName.equals("HCM_to_OraFin_User") || processName.equals("HCM_to_OraFin_EmpMaster_Payroll")) {
					reader.colorRow(index, "LightGrey");
				}
				

			} else {

				try {
					if (isVisible(
							driver.findElement(By.xpath("//*[contains(text(),'" + currentDate() + "')]"))) == true) {

						fetchDataBasedOnDate(processName, index, currentDate());

					}
				} catch (Exception e) {
					//System.out.println("Current Date could not found");
				}

				try {
					if (isVisible(
							driver.findElement(By.xpath("//*[contains(text(),'" + yesterdayDate() + "')]"))) == true) {

						fetchDataBasedOnDate(processName, index, yesterdayDate());

					}
				} catch (Exception e) {
					//System.out.println("Yesterday Date could not found");
				}

				try {
					if (isVisible(
							driver.findElement(By.xpath("//*[contains(text(),'" + lastFridayDate() + "')]"))) == true) {

						fetchDataBasedOnDate(processName, index, lastFridayDate());

					}
				} catch (Exception e) {
					//System.out.println("Friday Date could not found");
				}

				while (verifyNextButton.isEnabled()) {

					userClick(driver, verifyNextButton);

					try {
						if (isVisible(driver
								.findElement(By.xpath("//*[contains(text(),'" + currentDate() + "')]"))) == true) {

							fetchDataBasedOnDate(processName, index, currentDate());

						}
					} catch (Exception e) {
						//System.out.println("Current Date could not found");
					}

					try {
						if (isVisible(driver
								.findElement(By.xpath("//*[contains(text(),'" + yesterdayDate() + "')]"))) == true) {

							fetchDataBasedOnDate(processName, index, yesterdayDate());

						}
					} catch (Exception e) {
						//System.out.println("Yesterday Date could not found");
					}

					try {
						if (isVisible(driver
								.findElement(By.xpath("//*[contains(text(),'" + lastFridayDate() + "')]"))) == true) {

							fetchDataBasedOnDate(processName, index, lastFridayDate());

						}
					} catch (Exception e) {
						//System.out.println("Friday Date could not found");
					}
				}
				
				if (!isVisited) {
					
					if(processName.equals("Ls-JMS_Q_MSD365_NewDomesticBillDtls") || processName.equals("Ls-WSS_SOAP_EPayment_WUB")) {
						System.out.println(processName);
						log.info(processName);
						if(verifyPreviousButton.isEnabled()){
							userClickAndWait(driver, firstPage);
						}
						updateDataInExcel(index, 0);
						userClick(driver, closeButton);
						reader.setCellData("STATUS", index, "COMPLETE");
					}else {
						if(verifyPreviousButton.isEnabled()) {
							userClickAndWait(driver, firstPage);
						}
						updateDataInExcel(index, 0);
						userClick(driver, closeButton);
						reader.setCellData("COMMENT", index, "No Data");

						reader.colorRow(index, "Yellow");
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();

		}
	}

	public void updateDataInExcel(int index, int i) {

		try {

			int rowNumber = i + 1;

			WebElement dateLink = driver.findElement(
					By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
							+ rowNumber + "]/td[2]/div/div"));

			WebElement durationExec = driver.findElement(
					By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
							+ rowNumber + "]/td[10]/div"));

			if (counter == 0 || counter == 1) {

				reader.setCellData("EXECUTION_TIME(UTC)", index, dateLink.getText());

				reader.setCellData("EXECUTION_DURATION", index, durationExec.getText());

				reader.setCellData("IN_DATA", index, totalInCount.get(i).getText());

				reader.setCellData("OUT_DATA", index, totalOutCount.get(i).getText());

				userClickAndWait(driver, dateLink);

				/*userClick(driver, actionButton);

				userClickAndWait(driver, viewExtendedInfo);

				reader.setCellData("COMPONENT_ID", index, getDeploymentID.getText());

				userClick(driver, closeExtendedInfo);*/
				
			} else if (counter > 1) {

				String collNum = String.valueOf(counter);

				reader.setCellData("EXECUTION_TIME(UTC)_" + collNum, index, dateLink.getText());

				reader.setCellData("EXECUTION_DURATION_" + collNum, index, durationExec.getText());

				reader.setCellData("IN_DATA_" + collNum, index, totalInCount.get(i).getText());

				reader.setCellData("OUT_DATA_" + collNum, index, totalOutCount.get(i).getText());

				userClickAndWait(driver, dateLink);

				/*userClick(driver, actionButton);

				userClickAndWait(driver, viewExtendedInfo);

				reader.setCellData("COMPONENT_ID_" + collNum, index, getDeploymentID.getText());

				userClick(driver, closeExtendedInfo);*/
			}

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();
		}

	}

	public void applyCommonFiltersAndFetchData(String processName, int index) {
		try {
			
			isVisited = false;
			selectProcess(processName, index);

			selectRecordAndFetchData(processName, index);

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();
		}
	}
	
	public void oneTimeFilter() {
		try {
			selectProcessReporting();

			duration();

			environment();

		} catch (Exception e) {
			e.printStackTrace();
			//Assert.fail();
		}
	}
	
	public void clearProcess() {
		
		if(isVisible(hideInBoundsFilter) == true) {
			userClick(driver, clear0InBoundsFilter);
		}
		
		userClick(driver, clearProcessFilter);
		
		counter = 0;

	}
	
	public int process_OraFinProjectInfo(String processName, int index) {

		selectProcess(processName, index);

		outDataCount = Integer.parseInt(driver.findElement(
				By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr[1]/td[9]"))
				.getText());
		
		userClick(driver, clearProcessFilter);
		
		System.out.println(outDataCount);
		
		return outDataCount;	
		
	}
	
	public void process_JMSProjectInfo(String processName, int index) {
		
		int pCount = 0;
		
		selectProcess(processName, index);
		
		List<WebElement> lastRunDate = driver.findElements(By.xpath("//*[contains(text(),'" + currentDate() + "')]"));
		
		for(int i=0; i<lastRunDate.size(); i++) {
			
			int rowNo = i+1;
			
			action.moveToElement(lastRunDate.get(i)).build().perform();
			
			int verifyOutData = Integer.parseInt(driver.findElement(
					By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
							+ rowNo + "]/td[9]"))
					.getText());
			
			if(verifyOutData > 1) {
				updateDataInExcel(index, i);
				userClickAndWait(driver, closeButton);
				break;
			}
		}
		
		lastRunDate = driver.findElements(By.xpath("//*[contains(text(),'" + currentDate() + "')]"));
		
		for(int i=0; i<lastRunDate.size(); i++) {
			
			int rowNum = i+1;
			
			action.moveToElement(lastRunDate.get(i)).build().perform();
			
			int verifyInData = Integer.parseInt(driver.findElement(
					By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
							+ rowNum + "]/td[8]"))
					.getText());
			
			int verifyOutData = Integer.parseInt(driver.findElement(
					By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
							+ rowNum + "]/td[9]"))
					.getText());
			
			if(verifyInData > 1 && verifyOutData > 1) {
				pCount = verifyOutData + pCount;
			}	
		}
		
		while (verifyNextButton.isEnabled()) {
			
			userClickAndWait(driver, verifyNextButton);
			
			lastRunDate = driver.findElements(By.xpath("//*[contains(text(),'" + currentDate() + "')]"));
			
			for(int i=0; i<lastRunDate.size(); i++) {
				
				int rowNum = i+1;
				
				action.moveToElement(lastRunDate.get(i)).build().perform();
				
				int verifyInData = Integer.parseInt(driver.findElement(
						By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
								+ rowNum + "]/td[8]"))
						.getText());
				
				int verifyOutData = Integer.parseInt(driver.findElement(
						By.xpath("(//div[@class='table_container']//div[@class='GPGODNGDPL'])[1]/table/tbody/tr["
								+ rowNum + "]/td[9]"))
						.getText());
				
				if(verifyInData > 1 && verifyOutData > 1) {
					pCount = verifyOutData + pCount;
				}	
			}
		}
		
		if(outDataCount == pCount) {
			
			System.out.println(pCount);
			
			log.info(outDataCount + " == " + pCount);
		
			reader.setCellData("STATUS", index, "COMPLETE");

		}else {
			
			System.out.println(pCount);
			
			log.info("Process count does not matched" + outDataCount + " != " + pCount);
			
			reader.setCellData("STATUS", index, "PENDING");

			reader.colorRow(index, "BlueGrey");
			
		}
	}
}
