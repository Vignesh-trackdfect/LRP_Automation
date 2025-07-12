package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_033 extends Keywords {

	public void Ecommerce_Gateway_Validator_033(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_033";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Customer_Master_Module = Excel_data.get("Customer_Master_Module");

		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_Port = Excel_data.get("SearchBy_Port");
		String searchBy_Customer = Excel_data.get("SearchBy_Customer");

		String NA_Type = Excel_data.get("NA_Type");
		String Button_Status = Excel_data.get("Button_Status");
		String All_Type = Excel_data.get("All_Type");

		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Customer_Master_Updated_Popup = Excel_data.get("Customer_Master_Updated_Popup");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			waitForElement(driver, EG_FromDate_Input);

			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		Step_Start(1,
				"If ENS is not required for POD in Booking, and 'EUR 1875' flag is not selected, ENS filing defaults to 'NA' and cannot be modified.",
				test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForDisplay(driver, EBK_Discharge_Port_Value);
		String actual_DischarePort = getAttribute1(driver, EBK_Discharge_Port_Value, "value");

		moduleNavigate(driver, Ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Port, actual_DischarePort, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EUR_1875_Port_Checkbox);
		checkBox(driver, EUR_1875_Port_Checkbox, "No");

		waitForElement(driver, EUR_1875_Port_Checkbox);
		String actual_EUR_1875_Port_Checkbox_Status = getAttribute(driver, EUR_1875_Port_Checkbox, "class");

		if (!actual_EUR_1875_Port_Checkbox_Status.contains(Button_Status)) {
			System.out.println("Passed || Expected : EUR 1875 Port checkbox Should be unselected || Actual : EUR 1875 Port checkbox is unselected");
			Extent_pass_New(driver, "Passed || Expected : EUR 1875 Port checkbox Should be unselected || Actual : EUR 1875 Port checkbox is unselected", test, test1);
		} else {
			System.out.println("Failed|| Expected : EUR 1875 Port checkbox Should be unselected || Actual : EUR 1875 Port checkbox is selected");
			Extent_fail(driver, "Failed|| Expected : EUR 1875 Port checkbox Should be unselected || Actual : EUR 1875 Port checkbox is selected", test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		//Eccomm validator

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EBK_Master_Tab_NA_Button);
		String status_Of_NA = getAttribute(driver, EBK_Master_Tab_NA_Button, "class");

		if (status_Of_NA.contains(Button_Status)) {
			System.out.println("Passed || Expected : ENS Filling NA button should be selected || Actual : ENS Filling NA button is selected");
			Extent_pass_New(driver, "Passed || Expected : ENS Filling NA button should be selected || Actual : ENS Filling NA button is selected", test, test1);
		} else {
			System.out.println("Failed || Expected : ENS Filling NA button should be selected || Actual : ENS Filling NA button is unselected");
			Extent_fail(driver, "Failed || Expected : ENS Filling NA button should be selected || Actual : ENS Filling NA button is unselected", test, test1);
		}

		if (!isElementEnabled(driver, Master_Tab_NA_Button_EBK)) {
			System.out.println("Passed || Expected : ENS Filling NA button Should be disabled || Actual : ENS Filling NA button is disabled");
			Extent_pass_New(driver, "Passed || Expected : ENS Filling NA button Should be disabled || Actual : ENS Filling NA button is disabled", test, test1);
		} else {
			System.out.println("Failed || Expected : ENS Filling NA button Should be disabled || Actual : ENS Filling NA button is enabled");
			Extent_fail(driver, "Failed || Expected : ENS Filling NA button Should be disabled || Actual : ENS Filling NA button is enabled", test, test1);
		}

		Step_End(1,
				"If ENS is not required for POD in Booking, and 'EUR 1875' flag is not selected, ENS filing defaults to 'NA' and cannot be modified.",
				test, test1);
		Step_Start(2,
				"If ENS is required for POD in Booking, and 'EUR 1875' flag is selected, ENS type defaults based on customer master for AP.",
				test, test1);

//		Ports 

		moduleNavigate(driver, Ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Port, actual_DischarePort, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EUR_1875_Port_Checkbox);
		checkBox(driver, EUR_1875_Port_Checkbox, "Yes");

		waitForElement(driver, EUR_1875_Port_Checkbox);
		actual_EUR_1875_Port_Checkbox_Status = getAttribute(driver, EUR_1875_Port_Checkbox, "class");

		if (actual_EUR_1875_Port_Checkbox_Status.contains(Button_Status)) {
			System.out.println("Passed || Expected : EUR 1875 Port checkbox Should be selected || Actual :  EUR 1875 Port checkbox is selected");
			Extent_pass_New(driver, "Passed || Expected : EUR 1875 Port checkbox Should be selected || Actual :  EUR 1875 Port checkbox is selected", test, test1);
		} else {
			System.out.println("Failed || Expected : EUR 1875 Port checkbox Should be selected || Actual :  EUR 1875 Port checkbox is unselected");
			Extent_fail(driver, "Failed || Expected : EUR 1875 Port checkbox Should be selected || Actual :  EUR 1875 Port checkbox is unselected", test, test1);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

//	E comm validator

		waitForElement(driver, EBK_Customer_Tab);
		click(driver, EBK_Customer_Tab);

		waitForElement(driver, EBK_Customer_Table_Rows);
		List<Map<String, String>> customerTableData = getTableData(driver, EBK_Customer_Table_Headers,
				EBK_Customer_Table_Rows);
		String actualCustomer = getValueByFirstColumnAndHeader(customerTableData, "Customer Type", "AP", "Name");

//	Customer master
		moduleNavigate(driver, Customer_Master_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Customer, actualCustomer, "", "", "", "");


		waitForElement(driver, ENS_Filling_Type_Dropdown);
		String actual_ENS_Type = getText(driver, ENS_Filling_Type_Dropdown);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

//	E comm validator

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EBK_Master_Tab_NA_Button);
		String status_Of_NA_1 = getAttribute(driver, EBK_Master_Tab_NA_Button, "class");
		String actual_NA = getAttribute(driver, EBK_Master_Tab_NA_Value, "value");

		waitForElement(driver, EBK_Master_Tab_Single_Filling_Button);
		String status_Of_SingleFilling = getAttribute(driver, EBK_Master_Tab_Single_Filling_Button, "class");
		String actual_SingleFilling = getAttribute(driver, EBK_Master_Tab_Single_Filling_Value, "value");

		waitForElement(driver, EBK_Master_Tab_Partial_Filling_Button);
		String status_Of_PartialFilling = getAttribute(driver, EBK_Master_Tab_Partial_Filling_Button, "class");
		String actual_PartialFilling = getAttribute(driver, EBK_Master_Tab_Partial_Filling_Value, "value");

		if (actual_ENS_Type.equals(actual_SingleFilling) && status_Of_SingleFilling.contains(Button_Status)) {
			System.out.println("Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ");
			Extent_pass_New(driver, "Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ", test, test1);
		} else if (actual_ENS_Type.equals(actual_PartialFilling) && status_Of_PartialFilling.contains(Button_Status)) {
			System.out.println("Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ");
			Extent_pass_New(driver, "Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ", test, test1);
		} else if (actual_ENS_Type.equals(actual_NA) && status_Of_NA_1.contains(Button_Status)) {
			System.out.println("Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ");
			Extent_pass_New(driver, "Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ", test, test1);
		} else if (actual_ENS_Type.equals("All") && (status_Of_SingleFilling.contains(Button_Status)
				|| status_Of_PartialFilling.contains(Button_Status))) {
			System.out.println("Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ");
			Extent_pass_New(driver, "Passed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is Selected ", test, test1);
		} else {
			System.out.println("Failed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is deSelected ");
			Extent_fail(driver, "Failed || Expected : " + actual_ENS_Type + " should be selected || Actual : "+actual_ENS_Type+" is deSelected ", test, test1);
		}

		Step_End(2,
				"If ENS is required for POD in Booking, and 'EUR 1875' flag is selected, ENS type defaults based on customer master for AP.",
				test, test1);
		Step_Start(3,
				"If ENS filing type is 'NA' in the customer master, it defaults to 'NA' in Booking, and cannot be changed. If set to 'Single' or 'Partial', users cannot modify.",
				test, test1);

//		Customer master
		moduleNavigate(driver, Customer_Master_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Customer, actualCustomer, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, ENS_Filling_Type_Dropdown);
		click(driver, ENS_Filling_Type_Dropdown);

		String select_ENS_Filling_Type = String.format(DropDown_Select, NA_Type);
		waitForElement(driver, select_ENS_Filling_Type);
		click(driver, select_ENS_Filling_Type);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Customer_Master_Updated_Popup);
		String actPopup=getText(driver, popup_Message);
		if(actPopup.equals(Customer_Master_Updated_Popup)) {
			System.out.println("Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

//			E comm validator

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EBK_Master_Tab_NA_Button);
		String status_Of_NA_11 = getAttribute(driver, EBK_Master_Tab_NA_Button, "class");
		
		if (status_Of_NA_11.contains(Button_Status)&& !isElementEnabled(driver, Master_Tab_Single_Filling_Button_EBK)
				&& !isElementEnabled(driver, Master_Tab_Partial_Filling_Button_EBK)) {
			System.out.println("Passed || Expected : " + NA_Type + " Should be selected  || Actual : "+NA_Type+" is selected ");
			Extent_pass_New(driver, "Passed || Expected : " + NA_Type + " Should be selected  || Actual : "+NA_Type+" is selected ", test, test1);
		} else {
			System.out.println("Failed || Expected : " + NA_Type + " Should be selected  || Actual : "+NA_Type+" is not selected ");
			Extent_fail(driver, "Failed || Expected : " + NA_Type + " Should be selected  || Actual : "+NA_Type+" is not selected ", test, test1);
		}

		Step_End(3,
				"If ENS filing type is 'NA' in the customer master, it defaults to 'NA' in Booking, and cannot be changed. If set to 'Single' or 'Partial', users cannot modify.",
				test, test1);
		Step_Start(4,
				"If ENS filing type is 'All' in the customer master, default is 'Single' in Booking, but can be changed to 'Partial'. 'NA' cannot be selected",
				test, test1);

//				Customer master
		moduleNavigate(driver, Customer_Master_Module);

		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Customer, actualCustomer, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, ENS_Filling_Type_Dropdown);
		click(driver, ENS_Filling_Type_Dropdown);

		select_ENS_Filling_Type = String.format(DropDown_Select, All_Type);
		waitForElement(driver, select_ENS_Filling_Type);
		click(driver, select_ENS_Filling_Type);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,Customer_Master_Updated_Popup);
		actPopup=getText(driver, popup_Message);
		if(actPopup.equals(Customer_Master_Updated_Popup)) {
			System.out.println("Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup);
			Extent_pass_New(driver, "Not Matched || Expected Popup : "+Customer_Master_Updated_Popup+" || Actual Popup : "+actPopup, test, test1);
		}
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EBK_Master_Tab_NA_Button);

		if (!isElementEnabled(driver, Master_Tab_NA_Button_EBK)
				&& isElementEnabled(driver, Master_Tab_Single_Filling_Button_EBK)
				&& isElementEnabled(driver, Master_Tab_Partial_Filling_Button_EBK)) {
			System.out.println("Passed || Expected : " + All_Type + " Should be enabled  || Actual : "+NA_Type+" is enabled ");
			Extent_pass_New(driver, "Passed || Expected : " + All_Type + " Should be enabled  || Actual : "+NA_Type+" is enabled ", test, test1);
		} else {
			System.out.println("Failed || Expected : " + All_Type + " Should be enabled  || Actual : "+NA_Type+" is not enabled ");
			Extent_fail(driver, "Failed || Expected : " + All_Type + " Should be enabled  || Actual : "+NA_Type+" is not enabled ", test, test1);
		}

		Step_Start(4,
				"If ENS filing type is 'All' in the customer master, default is 'Single' in Booking, but can be changed to 'Partial'. 'NA' cannot be selected",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
