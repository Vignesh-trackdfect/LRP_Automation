package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC49  extends Keywords{
	public void Haulage_Contract_SC49(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC49";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Contarct_Numer_Header = Excel_data.get("Contarct_Numer_Header");
		String condition = Excel_data.get("condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Delete_Popup = Excel_data.get("Delete_Popup");
		String Delete_Popup_Expected = Excel_data.get("Delete_Popup_Expected");
		String No_Records_Found = Excel_data.get("No_Records_Found");
		
		

	



		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
	
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
		Step_Start(3, "Check whether it opens a Contract details search window.        ", test, test1);
		Step_Start(4, ".Enter the saved Contract number in the Contract number search field.  .", test, test1);
		Step_Start(5, "Then click on the search button.                 .", test, test1);
		Step_Start(6, "System will show the Contract details based on the hlg contract Number. .", test, test1);
		Step_Start(7, "Click on the select button.                   .", test, test1);
		globalValueSearchWindow(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
		Step_End(3, "Check whether it opens a Contract details search window.        ", test, test1);
		Step_End(4, ".Enter the saved Contract number in the Contract number search field.  .", test, test1);
		Step_End(5, "Then click on the search button.                 .", test, test1);
		Step_End(6, "System will show the Contract details based on the hlg contract Number. .", test, test1);
		Step_End(7, "Click on the select button.                   .", test, test1);
		waitForElement(driver, HC_Contarct_Number_Field);	 
		
		Step_Start(8, "System will retrieve the contract.  ", test, test1);
		
		 String validation = getAttribute(driver, HC_Contarct_Number_Field,"value");
		 System.out.println(validation);
		
		 if(validation.equals(Contract_Number)) {
        	 System.out.println("Matched||Expected Value From test data :"+Contract_Number + " || Actual Value Taken after global search the contract number: "+validation);
        	 Extent_pass_New(driver, "Matched||Expected Value From test data:"+Contract_Number + "||  Actual Value Taken after global search the contract number : "+validation, test, test1);
         }else {
        	 System.out.println("NotMatched ||Expected Value From test data:"+Contract_Number + "|| Actual Value Taken after global search the contract number  : "+validation);
             Extent_fail(driver, "NotMatched ||Expected Value From test data :"+Contract_Number + "|| Actual Value Taken after global search the contract number: "+validation, test, test1);
         }
		 
		 Step_End(8, "System will retrieve the contract.  ", test, test1);
		 Step_Start(9, "System will retrieve the contract.  ", test, test1);
		 Step_Start(9, "Click on the tool bar delete option.  .  ", test, test1);
		 waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(9, "Click on the tool bar delete option.    ", test, test1);
			 Step_Start(10, "It shows  validation message as \"\"Do you want to delete the Feeder  contract?\"\".   ", test, test1);
			waitForElement(driver, popup_Message);	 
   		 String delete_pop = getText(driver, popup_Message);
   		 System.out.println(validation);
   		 if(Delete_Popup_Expected.equals(delete_pop)) {
           	 System.out.println("Matched||Expected Value Popup is  :"+Delete_Popup_Expected + " || Actual Value Popup is: "+delete_pop);
           	 Extent_pass_New(driver, "Matched||Expected Value Popup is:"+Delete_Popup_Expected + "|| Actual Value Popup is : "+delete_pop, test, test1);
            }else {
           	 System.out.println("NotMatched ||Expected Value Popup is:"+Delete_Popup_Expected + "||Actual Value Popup is  : "+delete_pop);
                Extent_fail(driver, "NotMatched ||Expected Value Popup is :"+Delete_Popup_Expected + "| Actual Value Popup is: "+delete_pop, test, test1);
            }
   		Step_End(10, "It shows  validation message as \"\"Do you want to delete the Feeder  contract?\"\".   ", test, test1);
   	 Step_Start(11, ".Click on 'No' for the validation pop up closed.          ", test, test1);
   		waitForElement(driver, popup_Message_No_Button);
			click(driver, popup_Message_No_Button);
		
			
		 if(!isdisplayed(driver, popup_Message_No_Button)) {
			 System.out.println("Matched||Validation YES/NO Option box have been closed after clicking NO  Button");
			 Extent_pass_New(driver, "Matched||Validation YES/NO Option box have been closed after clicking NO  Button", test, test1);
		 }else {
			 System.out.println("NotMatched ||Validation YES/NO Option box have not been closed after clicking NO  Button");
			 Extent_fail(driver, "NotMatched || Validation YES/NO Option box have not been closed after clicking NO  Button", test, test1);
		 }
			Step_End(11, "Click on 'No' for the validation pop up closed.  ", test, test1);	
			 Step_Start(12, ".Ensure that contract number will not be deleted", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
	 		click(driver, SearchButton_Toolbar);
	 		globalValueSearchWindow(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
	 		
			 String validation1 = getAttribute(driver, HC_Contarct_Number_Field,"value");
			 System.out.println(validation1);
			
			 if(validation1.equals(Contract_Number)) {
	        	 System.out.println("Matched||Expected Value From test data :"+Contract_Number + "|| Actual Value Taken after global search the contract number: "+validation1);
	        	 Extent_pass_New(driver, "Matched||Expected Value From test data:"+Contract_Number + " || Actual Value Taken after global search the contract number : "+validation1, test, test1);
	         }else {
	        	 System.out.println("NotMatched ||Expected Value From test data:"+Contract_Number + "|| Actual Value Taken after global search the contract number  : "+validation1);
	             Extent_fail(driver, "NotMatched ||Expected Value From test data :"+Contract_Number + "|| Actual Value Taken after global search the contract number: "+validation1, test, test1);
	         }
			
			 Step_End(12, ".Ensure that contract number will not be deleted", test, test1);
			 Step_Start(13, ".Click on \"\"Yes\"\",Contarct details deleted and Shows the Popup message \"\" Feeder Contract Deleted\"\"           ", test, test1);
			 waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
			
			
			
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			
			
			
			
			
			
			
			waitForElement(driver, popup_Message);	 
	   		 String delete_pop1 = getText(driver, popup_Message);
	   		 System.out.println(delete_pop1);
	   		 if(Delete_Popup.equals(delete_pop1)) {
	           	 System.out.println("Matched||Expected Value Popup is  :"+Delete_Popup + " || Actual Value Popup is: "+delete_pop1);
	           	 Extent_pass_New(driver, "Matched||Expected Value Popup is:"+Delete_Popup + " || Actual Value Popup is : "+delete_pop1, test, test1);
	            }else {
	           	 System.out.println("NotMatched ||Expected Value Popup is:"+Delete_Popup + "|| Actual Value Popup is  : "+delete_pop1);
	                Extent_fail(driver, "NotMatched ||Expected Value Popup is :"+Delete_Popup + " ||Actual Value Popup is: "+delete_pop1, test, test1);
	            }
		 		waitForElement(driver, popup_Message_Ok_Button);
		 		click(driver, popup_Message_Ok_Button);
		
		 		
		 		
	 		waitForElement(driver, SearchButton_Toolbar);
	 		click(driver, SearchButton_Toolbar);
	 		globalValueSearchWindow1(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
	 		
	 		waitForElement(driver, Popup_Message);	 
	   		 String no_records = getText(driver, Popup_Message);
	   		 System.out.println(no_records);
	   		 
	   		 if(No_Records_Found.equals(no_records)) {
	           	 System.out.println("Matched||Expected Value Popup is  :"+No_Records_Found + " || Actual Value Popup is: "+no_records);
	           	 Extent_pass_New(driver, "Matched||Expected Value Popup is:"+No_Records_Found + "|| Actual Value Popup is : "+no_records, test, test1);
	            }else {
	           	 System.out.println("NotMatched ||Expected Value Popup is:"+No_Records_Found + "|| Actual Value Popup is  : "+no_records);
	                Extent_fail(driver, "NotMatched ||Expected Value Popup is :"+No_Records_Found + "|| Actual Value Popup is: "+no_records, test, test1);
	            }
		 
	   		 Step_End(13, ".Click on \"\"Yes\"\",Contarct details deleted and Shows the Popup message \"\" Feeder Contract Deleted\"\"           ", test, test1);
		 Extent_completed(testcase_Name, test, test1);
}}
