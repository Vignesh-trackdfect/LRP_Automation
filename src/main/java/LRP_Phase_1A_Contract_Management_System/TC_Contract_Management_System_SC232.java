package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC232 extends Keywords {

	public void Contract_Management_System_SC232(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC232";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String MainSheetName = Excel_data.get("MainSheetName");
		String ImportFilename = Excel_data.get("ImportFilename");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String Activated = Excel_data.get("Activated");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Contract_Amendment = Excel_data.get("Contract_Amendment");
		String CMS_PreviousDate_Popup = Excel_data.get("CMS_PreviousDate_Popup");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		
		
		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);


	       Step_Start(1, "select N-N-FMC check box", test, test1);
			
			waitForElement(driver, Contract_Management_System_NFMC);
			click(driver, Contract_Management_System_NFMC);
			
			Step_End(1, "select N-N-FMC check box", test, test1);
			
	       Step_Start(2, "select containerized check box", test, test1);
			
			waitForElement(driver, Contract_Management_System_Containerized);
			click(driver, Contract_Management_System_Containerized);
			
			Step_End(2, "select containerized check box", test, test1);
			

		Step_Start(3, "Enter the customer name", test, test1);

		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);

		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);

		waitForDisplay(driver, Contract_Management_System_Commodity);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);

		Step_End(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);

		Step_Start(5, "switch to port pair tab", test, test1);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		Step_End(5, "switch to port pair tab", test, test1);

		Step_Start(6, ".Import the port pair lanes", test, test1);

		waitForElement(driver, ImportExcel);
		click(driver, ImportExcel);

		uploadfile_new(driver, ImportInput, ImportFilename);

		String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);

		waitForElement(driver, SelectSheet_dropdown1);
		click(driver, SelectSheet_dropdown1);

		waitForElement(driver, MainSheet_option);
		click(driver, MainSheet_option);

		waitForElement(driver, LoadSheet_Main);
		click(driver, LoadSheet_Main);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);

		scrollBottom(driver);

		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();

		if (gridcount.equals(ExcelrowCount)) {

			System.out.println("All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {

			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}

		scrollTop(driver);
		Step_End(6, ".Import the port pair lanes", test, test1);

		Step_Start(7, "calculate the routing and surcharge.", test, test1);
		
		waitForElement(driver, RouteSch);
		click(driver, RouteSch);

		waitForDisplay(driver, RouteSch_Ok);
		click(driver, RouteSch_Ok);
		

		Step_End(7, "calculate the routing and surcharge.", test, test1);

		Step_Start(8, "save the contract", test, test1);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

		waitForElement(driver, Contract_Management_System_Signatory_Name);
		sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

		waitForElement(driver, Contract_Management_System_Signatory_Title);
		sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);
		
		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForPopup(driver, Popup_Message, Contract_saved);
		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);

		if (Contract_saved.equals(saved_popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}
		Step_End(8, "save the contract", test, test1);
		
		Step_Start(9, " activate the 0th amendment", test, test1);
			
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);


		waitForPopup(driver, Popup_Message, Contract_Verified);
		String verified_popup = getText(driver, Popup_Message);
		System.out.println("verified_popup :" + verified_popup);

		if (Contract_Verified.equals(verified_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on Verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on Verify button the popup  message is : "
							+ verified_popup,
					test, test1);
			System.out.println(
					"Matched || Expected value is : After click on Verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on Verify button the popup  message is : "
							+ verified_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on Verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on Verify button the popup  message is not display :"
							+ verified_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on Verify button the popup  message should be : "
							+ Contract_Verified
							+ " || Actual value is : After click on Verify button the popup  message is not display : "
							+ verified_popup,
					test, test1);

		}

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		
      

		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);

//				

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			waitForDisplay(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		} else {
			System.out.println("Popup message is not display");
		}
       
		waitForDisplay(driver, Contract_Management_System_status);
		waitForElement(driver, Contract_Management_System_status);
		String Activated_avl = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Activated_avl :" + Activated_avl);

		if (Activated_avl.equals(Activated)) {
			System.out.println("Matched || Expected value is : After click on Activate button, The status should be  : "
					+ Activated + " || Actual value is : After click on Activate button, The status is :"
					+ Activated_avl);
			Extent_pass(driver,
					"Matched || Expected value is : After click on Activate button, The status should be  : "
							+ Activated + " || Actual value is : After click on Activate button, The status is :"
							+ Activated_avl,
					test, test1);

		} else {

			System.out
					.println("UnMatched || Expected value is : After click on Activate button, The status should be  : "
							+ Activated + " || Actual value is : After click on Activate button, The status is :"
							+ Activated_avl);

			Extent_fail(driver,
					"UnMatched || Expected value is : After click on Activate button, The status should be  : "
							+ Activated + " || Actual value is : After click on Activate button, The status is :"
							+ Activated_avl,
					test, test1);

		}

		
		
		waitForElement(driver, AMendment);
		click(driver, AMendment);
 
		waitForPopup(driver, Popup_Message, Contract_Amendment);
		String AmendmentPopup = getText(driver, Popup_Message);
 
 
         if (Contract_Amendment.equals(AmendmentPopup)) {
			
			System.out.println("Matched || Expected value is : After click on amendment button the value should be  : " + Contract_Amendment + " || Actual value is : After click on amendment button the value  is : " + AmendmentPopup);
			Extent_pass(driver,"Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "||  Actual value is : After click on amendment button the value  is : " + AmendmentPopup,test, test1);
		} else {
 
			System.out.println("Not Matched || Expected value is : After click on amendment button the value should be :" + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :"+ AmendmentPopup);
			Extent_fail(driver,"Not Matched || Expected value is : After click on amendment button the value should be : " + Contract_Amendment + "|| Actual value is : After click on amendment button the value  is not display :" + AmendmentPopup,test, test1);
		
		}
 
         Step_End(9, " activate the 0th amendment", test, test1);
         
         Step_Start(10, "create 1st amendment and active with same effective date of 0th amendment.", test, test1);
         
         waitForElement(driver, Contract_Management_System_Edit);
 		click(driver, Contract_Management_System_Edit);

 		waitForElement(driver, Contract_Management_System_Approved);
 		click(driver, Contract_Management_System_Approved);

 	
 		waitForPopup(driver, Popup_Message, Contract_Verified);
 		String verified_popup1 = getText(driver, Popup_Message);
 		System.out.println("verified_popup :" + verified_popup1);

 		if (Contract_Verified.equals(verified_popup1)) {
 			Extent_pass(driver,
 					"Matched || Expected value is : After click on Verify button the popup  message should be : "
 							+ Contract_Verified
 							+ " || Actual value is : After click on Verify button the popup  message is : "
 							+ verified_popup1,
 					test, test1);
 			System.out.println(
 					"Matched || Expected value is : After click on Verify button the popup  message should be : "
 							+ Contract_Verified
 							+ " || Actual value is : After click on Verify button the popup  message is : "
 							+ verified_popup1);
 		} else {
 			System.out.println(
 					"Not Matched || Expected value is : After click on Verify button the popup  message should be : "
 							+ Contract_Verified
 							+ " || Actual value is : After click on Verify button the popup  message is not display :"
 							+ verified_popup1);
 			Extent_fail(driver,
 					"Not Matched || Expected value is : After click on Verify button the popup  message should be : "
 							+ Contract_Verified
 							+ " || Actual value is : After click on Verify button the popup  message is not display : "
 							+ verified_popup1,
 					test, test1);

 		}

 		waitForElement(driver, Contract_Management_System_Edit);
 		click(driver, Contract_Management_System_Edit);
        
 		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);
        		
      	   waitForDisplay(driver, Popup_Message);
     		waitForPopup(driver, Popup_Message, CMS_PreviousDate_Popup);
     		String Act_PreviousDate_popup = getText(driver, Popup_Message);
     		
     		if (CMS_PreviousDate_Popup.equals(Act_PreviousDate_popup)) {
     			Extent_pass(driver,"Expected popup|| Without Adding Effective date We Should Get This  Popup Message : "+CMS_PreviousDate_Popup+" || Actual popup || We are getting this popup without adding  Effective date : "+ Act_PreviousDate_popup, test,test1);
     			System.out.println("Expected popup|| Without Adding Effective date We Should Get This  Popup Message : "+CMS_PreviousDate_Popup+" || Actual popup || We are getting this popup without adding  Effective date : "+ Act_PreviousDate_popup);
     		}else {
     			System.out.println("Expected popup|| Without Adding Effective date We Should Get This  Popup Message : "+CMS_PreviousDate_Popup+" || Actual popup || We are getting this popup without adding  Effective date: "+ Act_PreviousDate_popup);
     			Extent_fail(driver,"Expected popup|| Without Adding Effective date We Should Get This  Popup Message : "+CMS_PreviousDate_Popup+" || Actual popup  || We are getting this popup without adding  Effective date: "+ Act_PreviousDate_popup, test,test1);
     						
     		}
  		
         Step_End(10, "create 1st amendment and active with same effective date of 0th amendment.", test, test1);
	
         Extent_completed(testCaseName, test, test1);
         
	}
	
}
