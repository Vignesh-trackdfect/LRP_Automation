package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC51  extends Keywords{
	public void Haulage_Contract_SC51(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC51";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Contarct_Numer_Header = Excel_data.get("Contarct_Numer_Header");
		String condition = Excel_data.get("condition");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Copied_Popup = Excel_data.get("Copied_Popup");
		String ADD_Haulage_Contract = Excel_data.get("ADD_Haulage_Contract");
		
		

	



		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		moduleNavigate(driver, Haulage_Contract_Module_Name);
		
		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		
		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_Start(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_Start(5, "Click on the search button.     .", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_Start(7, "Double click the Contract detials.          .", test, test1);
		globalValueSearchWindow(driver, condition, Contarct_Numer_Header, Contract_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_End(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_End(5, "Click on the search button.     .", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_End(7, "Double click the Contract detials.          .", test, test1);
		
		Step_Start(8, "Check whether the system retrieves the saved contract number", test, test1);
		waitForElement(driver, HC_Contarct_Number_Field);	 
		 String validation = getAttribute(driver, HC_Contarct_Number_Field,"value");
		 System.out.println(validation);
		
		 if(validation.equals(Contract_Number)) {
        	 System.out.println("Matched||Expected Value From test data :"+Contract_Number + " || Actual Value Taken after global search the contract number: "+validation);
        	 Extent_pass_New(driver, "Matched||Expected Value From test data:"+Contract_Number + "||  Actual Value Taken after global search the contract number : "+validation, test, test1);
         }else {
        	 System.out.println("NotMatched ||Expected Value From test data:"+Contract_Number + "|| Actual Value Taken after global search the contract number  : "+validation);
             Extent_fail(driver, "NotMatched ||Expected Value From test data :"+Contract_Number + "|| Actual Value Taken after global search the contract number: "+validation, test, test1);
         }
			Step_End(8, "Check whether the system retrieves the saved contract number", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		 
			waitForElement(driver, HC_show_All_Radio_Button);
			click(driver, HC_show_All_Radio_Button);
			Step_Start(9, "Choose the new Location pair", test, test1);
			waitForElement(driver, HC_Add_Gird_Table);
			click(driver, HC_Add_Gird_Table);
			Step_End(9, "Choose the new Location pair", test, test1);
			
			Step_Start(10, "Click copy the exsiting record and Paste the Haulage contract screen", test, test1);
			waitForElement(driver, HC_New_Location_radio_Button);
			click(driver, HC_New_Location_radio_Button);
			waitForElement(driver, HC_Copy_Button);
			click(driver, HC_Copy_Button);
			String copied_Pop_Act = getText(driver, Popup_Message);
    		
  		  if(Copied_Popup.equals(copied_Pop_Act)) {
		        	 System.out.println("Matched||Expected Popup is :"+Copied_Popup + " || Actual Popup is: "+copied_Pop_Act);
		        	 Extent_pass_New(driver, "Matched||Expected Popup is :"+Copied_Popup + " || Actual Popup is : "+copied_Pop_Act, test, test1);
		         }else {
		        	 System.out.println("NotMatched ||Expected Popup is  :"+Copied_Popup + "||  Actual Popup is: "+copied_Pop_Act);
		             Extent_fail(driver, "NotMatched ||Expected Popup is :"+Copied_Popup + " || Actual Popup is: "+copied_Pop_Act, test, test1);
		         }
			
			
  		waitForElement(driver, HC_Paste_Button);
		click(driver, HC_Paste_Button);
			
		  formatLocatorClick(driver, HC_Paste_Number, ADD_Haulage_Contract);
			
		  waitForElement(driver, HC_ADD_Haulage_Contract);
			click(driver, HC_ADD_Haulage_Contract);
			
			
			waitForElement(driver, HC_ADD_Haulage_Contract_text);	 
   		 String contract_type = getText(driver, HC_ADD_Haulage_Contract_text);
   		 System.out.println(contract_type);
   		 if(ADD_Haulage_Contract.equals(contract_type)) {
           	 System.out.println("Matched||Expected Value taken in test data  :"+ADD_Haulage_Contract + " || Actual Value Taken in grid after paste: "+contract_type);
           	 Extent_pass_New(driver, "Matched||Expected Value taken in test data:"+ADD_Haulage_Contract + " || Actual Value Taken in grid after paste : "+contract_type, test, test1);
            Extent_call(test, test1, "Equipment was added in grid after pasting the equipment as " + ADD_Haulage_Contract);
   		 }else {
           	 System.out.println("NotMatched ||Expected Value taken in test data:"+ADD_Haulage_Contract + "|| Actual Value Taken in grid after paste  : "+contract_type);
                Extent_fail(driver, "NotMatched ||Expected Value taken in test data :"+ADD_Haulage_Contract + " || Actual Value Taken in grid after paste: "+contract_type, test, test1);
            }

   		Step_End(10, "Click copy the exsiting record and Paste the Haulage contract screen", test, test1);

		 Extent_completed(testcase_Name, test, test1);
}}
