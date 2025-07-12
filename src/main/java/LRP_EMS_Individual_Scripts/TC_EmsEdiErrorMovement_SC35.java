package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EmsEdiErrorMovement_SC35 extends Keywords {
	public void emsEdiErrorMovement35(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TC_EmsEdiErrorMovement_SC35";
		
		
		


		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String Field_Names4 = Excel_data.get("Field_Names4");
		String Edi_file_Value = Excel_data.get("Edi_file_Value");
		String Error_date = Excel_data.get("Error_date");
		String Clear_Button_Perform = Excel_data.get("Clear_Button_Perform");
		String Search_module = Excel_data.get("Search_module");
		String Error_Equipment_No = Excel_data.get("Error_Equipment_No");
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_date_Value = Excel_data.get("To_date_Value");
		String To_EMS_date = Excel_data.get("To_EMS_date");
		String From_Ems_date = Excel_data.get("From_Ems_date");
		String Error_Status_Coloums = Excel_data.get("Error_Status_Coloums");
		String Error_Background_Colour_Code = Excel_data.get("Error_Background_Colour_Code");
		String conditionFilter = Excel_data.get("conditionFilter");
		String Edi_File_Search = Excel_data.get("Edi_File_Search");


		
		
		

		// login
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, pass_word);
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
		// search module
	    
	    
 		moduleNavigate(driver, Field_Names4);

		Step_Start(1, "Select From & To date range according in required fields", test, test1);
		// select from date
	
		// select from date

				waitForElement(driver, kFromDate);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, kFromDate, From_Date_Value);
				} else {
					waitForElement(driver, kFromDate);
					clearAndType(driver, kFromDate, From_Date_Value);
				}
				// Selecting the to Date
				waitForElement(driver, kToDate);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, kToDate, To_date_Value);
				} else {
					waitForElement(driver, kToDate);
					clearAndType(driver, kToDate, To_date_Value);
				}
		
		
		
		
		
		
	
		Step_End(1, "Select From & To date range according in required fields", test, test1);
		Step_Start(2, "Click add button & it will show list of all id based on date range selection", test, test1);
		// click add option
		waitForElement(driver, kAddOption);
		click(driver, kAddOption);
		
		twoColumnSearchWindow(driver, Edi_File_Search, conditionFilter, Edi_file_Value);


		
		
		Step_End(2, "Click add button & it will show list of all id based on date range selection", test, test1);

		Step_Start(3, "Click show button to get error detail in data grid", test, test1);
		// click show option
		waitForElement(driver, show_Btn);
		click(driver, show_Btn);

		waitForElement(driver, EDI_ErrorMoments_ToolPannel);
		click(driver, EDI_ErrorMoments_ToolPannel);
		waitForElement(driver, EDI_ErrorMoments_ConditionFilter);
		click(driver, EDI_ErrorMoments_ConditionFilter);
		waitForElement(driver, EDI_ErrorMoments_Equipment_No);
		sendKeys(driver, EDI_ErrorMoments_Equipment_No, Error_Equipment_No);
		// Change the date in Error grid
		
		
		waitForElement(driver, Error_Grid_Gate);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Error_Grid_Gate, Error_date);
		} else {
			waitForElement(driver, Error_Grid_Gate);
			clearAndType(driver, Error_Grid_Gate, Error_date);
		}

		

		
		

		waitForElement(driver, Error_SelectBtn);
		click(driver, Error_SelectBtn);
		waitForElement(driver, Re_Process_Btn);
		click(driver, Re_Process_Btn);
		// Non-Mandatory button
		if (Clear_Button_Perform.equals("YES")) {
			waitForElement(driver, clear_btn);
			click(driver, clear_btn);
		}

		// search EMS gate module
	
 		moduleNavigate(driver, Search_module);

	    waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message_Ok_Button)) {
			System.out.println("Expected Result is : No Records Found text should be present  || Actual Result is : No Records Found text is present");
			doubleClick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Expected Result is : No Records Found text should be present  || Actual Result is : No Records Found text is not present");
		}
		// select From date
		
		

		// Selecting the From Date

		waitForElement(driver, EMS_Gate_From_Date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, EMS_Gate_From_Date, From_Ems_date);
		} else {
			waitForElement(driver, EMS_Gate_From_Date);
			clearAndType(driver, EMS_Gate_From_Date, From_Ems_date);
		}
		// Selecting the to Date
		waitForElement(driver, EMS_Gate_To_Date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, EMS_Gate_To_Date, To_EMS_date);
		} else {
			waitForElement(driver, EMS_Gate_To_Date);
			clearAndType(driver, EMS_Gate_To_Date, To_EMS_date);
		}
		// click Refresh button
		waitForElement(driver, refresh_Button_Ems_Gate);
		click(driver, refresh_Button_Ems_Gate);
		waitForElement(driver, Status_Menu);
		click(driver, Status_Menu);
		waitForElement(driver, Filter_Option_Gate);
		click(driver, Filter_Option_Gate);
		waitForElement(driver, Select_all_CheckBox);
		click(driver, Select_all_CheckBox);

		List<String> error_Values = splitAndExpand(Error_Status_Coloums);
		for(String error_Value : error_Values) {
			String select_Value =  String.format(select_value,  error_Value); 
			waitForElement(driver, select_Value);
			click(driver, select_Value);
		}
		waitForElement(driver, Error_Record_List);
		List<WebElement> error_Records = listOfElements(driver, Error_Record_List);
		for(int i=1;i<error_Records.size();i++) {
			String error_Row =  String.format(error_row,i); 
			String error_File =  String.format(error_file,  i); 
			String error_Filename=getText(driver, error_File);
			
			String Records_Color = getTextBackgroundColor(driver, error_Row);
			System.out.println("records_Color : "+Records_Color);
			String records_Color =getColorName(Records_Color);
			if (Error_Background_Colour_Code.equals(records_Color)) {
				System.out.println("Matched || Expected Result is : Error Record should be display in " + Error_Background_Colour_Code
						+ "colour || Actual Result is :  Error Record is displayed in" + records_Color+"colour || The Error system file name is "+error_Filename);
				Extent_pass_New(driver, "Matched || Expected Result is : Error Record should be display in " + Error_Background_Colour_Code
						+ "colour || Actual Result is :  Error Record is displayed in" + records_Color+"colour || The Error system file name is "+error_Filename, test, test1);
			} else {
				System.out.println("Not Matched || Expected Result is : Error Record should be display in " + Error_Background_Colour_Code
						+ "colour || Actual Result is :  Error Record is not displayed in" + records_Color+"colour || The Error system file name is "+error_Filename);
				Extent_fail(driver, "Not Matched || Expected Result is : Error Record should be display in " + Error_Background_Colour_Code
						+ "colour || Actual Result is :  Error Record is not displayed in" + records_Color+"colour || The Error system file name is "+error_Filename, test, test1);
			}
		
		}

		Step_End(3, "Click show button to get error detail in data grid", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}