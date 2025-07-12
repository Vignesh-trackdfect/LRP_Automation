package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_027 extends Keywords {

	public void Ecommerce_Gateway_Validator_027(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_027";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Gateway_Module = Excel_data.get("Ecomm_Gateway_Module");

		String Container_Header_Name = Excel_data.get("Container_Header_Name");
		String Commodity_Header_Name = Excel_data.get("Commodity_Header_Name");

		String Commodity_Row_To_Change_Wt = Excel_data.get("Commodity_Row_To_Change_Wt");
		String New_Cargo_Weight = Excel_data.get("New_Cargo_Weight");

		String Transaction_Type_Value = Excel_data.get("Transaction_Type_Value");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Archive_Condition = Excel_data.get("Archive_Condition");

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


		Step_Start(2, " enter the cargo weight in container tab  ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			waitForDownload(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

		waitForElement(driver, Header_Panel_EComm_Validator);
		String Commmodity_header = String.format(Header_Panel_List_Ecomm_Validator, Commodity_Header_Name);
		waitForElement(driver, Commmodity_header);
		click(driver, Commmodity_header);

		String RowSelect = String.format(Commodity_Row_Value_EComm_Validator, Commodity_Row_To_Change_Wt);
		String Row_Count_Get = getAttribute(driver, RowSelect, "data-ri");

		String Row_Select_Edit = String.format(Commodity_Row_Edit_Ecomm_Validator, Row_Count_Get);
		waitForElement(driver, Row_Select_Edit);
		click(driver, Row_Select_Edit);

		waitForElement(driver, Cargo_Weight_Input_Commodity_Ecomm_Validator);
		Newclear(driver, Cargo_Weight_Input_Commodity_Ecomm_Validator);
		sendKeys(driver, Cargo_Weight_Input_Commodity_Ecomm_Validator, New_Cargo_Weight);

		waitForElement(driver, Edit_btn_Commodity_EComm_Validator);
		click(driver, Edit_btn_Commodity_EComm_Validator);

		waitForElement(driver, Commodity_Table_EComm_Validator);
		List<Map<String, String>> CommodityTableData = getTableData(driver, Commodity_Table_Headers_EComm_Validator,
				Commodity_Table_Row_EComm_Validator);
		String CargoWeight_Commodity_Table = getValueByFirstColumnAndHeader(CommodityTableData, "Equipment ID",
				Commodity_Row_To_Change_Wt, "Weight");

		double Exp_Weight = getNumberValue(New_Cargo_Weight);
		double Act_Weight_Commodity = getNumberValue(CargoWeight_Commodity_Table);

		if (Act_Weight_Commodity == Exp_Weight) {
			System.out.println("New Cargo Weight updated in the Commodity Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Commodity_Table);
			Extent_pass_New(driver, "New Cargo Weight updated in the Commodity Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Commodity_Table, test, test1);

		} else {
			System.out.println("New Cargo Weight not updated in the Commodity Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Commodity_Table);
			Extent_fail(driver, "New Cargo Weight not updated in the Commodity Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Commodity_Table, test, test1);

		}

		waitForElement(driver, Header_Panel_EComm_Validator);
		String Container_header = String.format(Header_Panel_List_Ecomm_Validator, Container_Header_Name);
		waitForElement(driver, Container_header);
		click(driver, Container_header);

		waitForElement(driver, Container_Table_Headers_EComm_Validator);
		List<Map<String, String>> ContainerTableData = getTableData(driver, Container_Table_Headers_EComm_Validator,
				Container_Table_Rows_EComm_Validator);

		String CargoWeight_Container_Table = getValueByFirstColumnAndHeader(ContainerTableData, "Equipment ID",
				Commodity_Row_To_Change_Wt, "Cargo Wt.");
		double Act_Weight_Container = getNumberValue(CargoWeight_Container_Table);

		if (Act_Weight_Container == Exp_Weight) {
			System.out.println("New Cargo Weight updated in the Contaier Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Container_Table);
			Extent_pass_New(driver, "New Cargo Weight updated in the Contaier Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Container_Table, test, test1);
		} else {
			System.out.println("New Cargo Weight not updated in the Contaier Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Container_Table);
			Extent_fail(driver, "New Cargo Weight not updated in the Contaier Table || Expected : " + New_Cargo_Weight
					+ "  ||  Actual : " + CargoWeight_Container_Table, test, test1);
		}

		Step_End(2, " enter the cargo weight in container tab  ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
