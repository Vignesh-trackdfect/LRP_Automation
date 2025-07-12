package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_026 extends Keywords {

	public void Ecommerce_Gateway_Validator_026(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_026";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Gateway_Module = Excel_data.get("Ecomm_Gateway_Module");
		String CustomerTab_Header_Name = Excel_data.get("CustomerTab_Header_Name");

		String Select_User_To_Copy = Excel_data.get("Select_User_To_Copy");
		String Select_Paste_Customers = Excel_data.get("Select_Paste_Customers");

		String Compare_Copied_ColumnValues = Excel_data.get("Compare_Copied_ColumnValues");

		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Ecomm_Gateway_Module);

		Step_Start(1, " Enter the Agreement Party ", test, test1);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		String Transaction_type_Select = String.format(EG_Select_Transaction_type, Transaction_Type_Value);
		waitForElement(driver, Transaction_type_Select);
		click(driver, Transaction_type_Select);

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		waitForElement(driver, EG_FromDate_Input);
		selectDatePicker(driver, EG_FromDate_Input, From_Date_Value);

		waitForElement(driver, EG_ToDate_Input);
		selectDatePicker(driver, EG_ToDate_Input, To_Date_Value);

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

		waitForDownload(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);
		
		Step_End(1, " Enter the Agreement Party ", test, test1);


		Step_Start(2, " Right click copy option system will add the selected customer details", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		if (isDisplayed(driver, popup_Message)) {
			waitForDownload(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

		waitForElement(driver, Header_Panel_EComm_Validator);
		String Customer_header = String.format(Header_Panel_List_Ecomm_Validator, CustomerTab_Header_Name);
		waitForElement(driver, Customer_header);
		click(driver, Customer_header);

		waitForElement(driver, Customer_Table_EComm_Validator);

		String RowSelect = String.format(Customer_Table_RowSelect_EComm_Validator, Select_User_To_Copy);
		waitForElement(driver, RowSelect);

		String Row_Count_Get = getAttribute(driver, RowSelect, "data-ri");

		List<WebElement> before_TableRows = listOfElements(driver, Customer_Table_Rows_EComm_Validator);
		int before_TableRowSize = before_TableRows.size();
		String Select_Customer = String.format(SelectCustomer_EComm_Validator, Select_User_To_Copy);
		waitForElement(driver, Select_Customer);
		click(driver, Select_Customer);
		String Row_Select_Edit = String.format(CustomerEdit_Row_EComm_Validator, Row_Count_Get);
		waitForElement(driver, Row_Select_Edit);
		click(driver, Row_Select_Edit);
		String Select_Customer1 = String.format(SelectCustomer_EComm_Validator, Select_User_To_Copy);
		waitForElement(driver, Select_Customer1);
		RightClick(driver, Select_Customer1);

		waitForDisplay(driver, Customer_Copy_EComm_Validator);
		jsClick(driver, Customer_Copy_EComm_Validator);

		waitForElement(driver, Paste_Options_EComm_Validator);
		List<String> pasteColumnsList = splitAndExpand(Select_Paste_Customers);
		int pasteColumnSize = pasteColumnsList.size();
		int Pasted_TableRowSizeExp = before_TableRowSize + pasteColumnSize;
		for (String Column : pasteColumnsList) {
			String Select_Columns_Paste = String.format(Paste_Select_Columns_EComm_Validator, Column);
			waitForElement(driver, Select_Columns_Paste);
			click(driver, Select_Columns_Paste);
			waitForElement(driver, Paste_Btn_EComm_Validator);
			click(driver, Paste_Btn_EComm_Validator);
		}

		waitForElement(driver, Close_PasteOptions_EComm_Validator);
		click(driver, Close_PasteOptions_EComm_Validator);

		List<String> CompareValues_Headers = splitAndExpand(Compare_Copied_ColumnValues);
		waitForElement(driver, Customer_Table_Rows_EComm_Validator);
		List<WebElement> After_TableRows = listOfElements(driver, Customer_Table_Rows_EComm_Validator);
		int After_TableRowSize = After_TableRows.size();
		List<Map<String, String>> CustomerTableData = getTableData(driver, Customer_Table_Headers_EComm_Validator,
				Customer_Table_Rows_EComm_Validator);
		List<List<String>> CopiedColumnValues = getValuesByColumnAndHeaders(CustomerTableData, "Customer Type",
				Select_User_To_Copy, CompareValues_Headers);

		waitForElement(driver, Customer_Type_Column_EComm_Validator);
		List<WebElement> CustomerType_TableRows = listOfElements(driver, Customer_Type_Column_EComm_Validator);
		if (Pasted_TableRowSizeExp == After_TableRowSize) {
			for (int k = before_TableRowSize; k < After_TableRowSize; k++) {
				String CustomerCode = CustomerType_TableRows.get(k).getText();
				List<List<String>> PastedColumnValues = getValuesByColumnAndHeaders(CustomerTableData, "Customer Type",
						CustomerCode, CompareValues_Headers);
				if (compareTableData(CopiedColumnValues, PastedColumnValues)) {
					System.out.println("Copy Pasted Column Details for the Code '" + CustomerCode
							+ "' is Matched with Copied Column Details, Expected : " + CopiedColumnValues
							+ " ||  Actual : " + PastedColumnValues);
					Extent_pass_New(driver,
							"Copy Pasted Column Details for the Code '" + CustomerCode
									+ "' is Matched with Copied Column Details, Expected : " + CopiedColumnValues
									+ " ||  Actual : " + PastedColumnValues,
							test, test1);
				} else {
					System.out.println("CopyPasted Column Details for the Code '" + CustomerCode
							+ "' is Not Matched with Copied Column Details, Expected : " + CopiedColumnValues
							+ " ||  Actual : " + PastedColumnValues);
					Extent_fail(driver,
							"Copy Pasted Column Details for the Code '" + CustomerCode
									+ "' is Not Matched with Copied Column Details, Expected : " + CopiedColumnValues
									+ " ||  Actual : " + PastedColumnValues,
							test, test1);
				}
			}

		} else {

			System.out.println("Copy Pasted Row Count not Matched || Expected Rows After Paste : "
					+ Pasted_TableRowSizeExp + " ||  Actual Rows : " + After_TableRowSize);
			Extent_fail(driver, "Copy Pasted Row Count not Matched || Expected Rows After Paste : "
					+ Pasted_TableRowSizeExp + " ||  Actual Rows : " + After_TableRowSize, test, test1);
		}

		Step_End(2, " Right click copy option system will add the selected customer details", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
