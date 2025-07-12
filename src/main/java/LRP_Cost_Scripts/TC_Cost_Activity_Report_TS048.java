package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS048 extends Keywords {

	public void Cost_Activity_Report_TS048(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS048";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String GivenContract_Type = Excel_data.get("GivenContract_Type");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Condition1 = Excel_data.get("Condition1");
		String GivenMode = Excel_data.get("GivenMode");
		String FilterColumn = Excel_data.get("FilterColumn");
		String Cost_Equipment_Grouping_Module = Excel_data.get("Cost_Equipment_Grouping_Module");
		String Select_ContractCode = Excel_data.get("Select_ContractCode");
		String Select_Terminal = Excel_data.get("Select_Terminal");
		String Select_Port = Excel_data.get("Select_Port");
		String Condition2 = Excel_data.get("Condition2");
		String VendorColumn = Excel_data.get("VendorColumn");
		String Service_Filter_Header = Excel_data.get("Service_Filter_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String ArrivalDate_Filter_Header = Excel_data.get("ArrivalDate_Filter_Header");

		String Contract_option = String.format(Select_ContractType, GivenContract_Type);
		String Mode_option = String.format(Select_ModeOption, GivenMode);
		String Agency = Excel_data.get("Agency");

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		SwitchProfile(driver, Agency);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(3, "Click on the Service search button and select the required service code", test, test1);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);

		waitForElement(driver, Contract_option);
		click(driver, Contract_option);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);

		waitForElement(driver, Mode_option);
		click(driver, Mode_option);

		waitForElement(driver, Service_Search);
		click(driver, Service_Search);

		twoColumnSearchWindow(driver, Service_Filter_Header, Condition1, Service);

		Step_End(3, "Click on the Service search button and select the required service code", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		waitForElement(driver, Vessel_Search);
		click(driver, Vessel_Search);

		twoColumnSearchWindow(driver, Vessel_Filter_Header, Condition1, Vessel);

		Step_End(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code", test, test1);

		waitForElement(driver, port_Search);
		click(driver, port_Search);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition1, Port);

		Step_End(5, "Click on the Port search button and select the required port code", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		waitForElement(driver, CAR_Terminal_Search);
		click(driver, CAR_Terminal_Search);

		twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition1, Terminal);

		Step_End(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date", test, test1);

		waitForElement(driver, ArrivalDate_Search);
		click(driver, ArrivalDate_Search);

		twoColumnSearchWindow(driver, ArrivalDate_Filter_Header, Condition1, Arrival_Date);

		Step_End(7, "Click on the Arrival date search button and select the required date", test, test1);

		Step_Start(8, "Click on the Show button", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}

		Step_End(8, "Click on the Show button", test, test1);

		Step_Start(9, "Click the Predictable reporting tab", test, test1);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver, Predictable_Reporting_CAR);

		Step_End(9, "Click the Predictable reporting tab", test, test1);

		Step_Start(10, "Copy the Equipment type, Version No, Contract No and Head of all the predictable activities",
				test, test1);

		waitForElement(driver, Predictable_reporting_columns);
		click(driver, Predictable_reporting_columns);
		waitForDisplay(driver, PR_Deselect);
		String actualStatus = getAttribute(driver, PR_Deselect, "class");
		if (actualStatus.contains("checked")) {
		waitForDisplay(driver, PR_Deselect);
		click(driver, PR_Deselect);
		}
		List<String> filtercolumns = splitAndExpand(FilterColumn);

		for (String columnname : filtercolumns) {

			waitForElement(driver, PR_FilterInput);
			clear(driver, PR_FilterInput);
			sendKeys(driver, PR_FilterInput, columnname);

			click(driver, PR_Deselect);
		}

		List<WebElement> PR_EqpType_Field = listOfElements(driver, CAR_EqpType_Field);
		List<WebElement> PR_ContractNo_Field = listOfElements(driver, CAR_ContractNo_Field);
		List<WebElement> PR_VersionNo_Field = listOfElements(driver, CAR_VersionNo_Field);
		List<WebElement> PR_Head_Field = listOfElements(driver, CAR_Head_Field);
		List<WebElement> PR_ChargeRate_Field = listOfElements(driver, CAR_ChargeRate_Field);
		List<WebElement> PR_EqpStatus_Field = listOfElements(driver, CAR_EqpStatus_Field);
		List<String> PR_EqpType = new ArrayList<String>();
		List<String> PR_ContractNo = new ArrayList<String>();
		List<String> PR_VersionNo = new ArrayList<String>();
		List<String> PR_Head = new ArrayList<String>();
		List<String> PR_ChargeRate = new ArrayList<String>();
		List<String> PR_EqpStatus = new ArrayList<String>();
		for (int i = 0; i < PR_EqpType_Field.size(); i++) {

			String eqptype = PR_EqpType_Field.get(i).getText();
			PR_EqpType.add(eqptype);

			String contractno = PR_ContractNo_Field.get(i).getText();

			PR_ContractNo.add(contractno);

			String VersionNo = PR_VersionNo_Field.get(i).getText();

			PR_VersionNo.add(VersionNo);

			String Head = PR_Head_Field.get(i).getText();

			PR_Head.add(Head);

			String ChargeRate = PR_ChargeRate_Field.get(i).getText();

			PR_ChargeRate.add(ChargeRate);
			
			String EqpStatus = PR_EqpStatus_Field.get(i).getText();

			PR_EqpStatus.add(EqpStatus);

		}

		Step_End(10, "Copy the Equipment type, Version No, Contract No and Head of all the predictable activities",
				test, test1);

		Step_Start(11, "Click the unpredictable reporting tab", test, test1);

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver, UnPredictable_Tab_CAR);

		Step_End(11, "Click the unpredictable reporting tab", test, test1);

		Step_Start(12, "Copy the Equipment type, Version No, Contract No and Head of all the unpredictable activities",
				test, test1);

		waitForElement(driver, UnPredictable_reporting_columns);
		click(driver, UnPredictable_reporting_columns);
		waitForDisplay(driver, UPR_Deselect);
		actualStatus = getAttribute(driver, UPR_Deselect, "class");
		if (actualStatus.contains("checked")) {
				waitForDisplay(driver, UPR_Deselect);
		click(driver, UPR_Deselect);
}
		for (String columnname : filtercolumns) {

			waitForElement(driver, UPR_FilterInput);
			clear(driver, UPR_FilterInput);
			sendKeys(driver, UPR_FilterInput, columnname);

			click(driver, UPR_Deselect);
		}

		List<WebElement> UPR_EqpType_Field = listOfElements(driver, CAR_UEqpType_Field);
		List<WebElement> UPR_ContractNo_Field = listOfElements(driver, CAR_UContractNo_Field);
		List<WebElement> UPR_VersionNo_Field = listOfElements(driver, CAR_UVersionNo_Field);
		List<WebElement> UPR_Head_Field = listOfElements(driver, CAR_UHead_Field);
		List<WebElement> UPR_ChargeRate_Field = listOfElements(driver, CAR_UChargeRate_Field);
		List<WebElement> UPR_EqpStatus_Field = listOfElements(driver, CAR_UEqpStatus_Field);

		for (int i = 0; i < UPR_EqpType_Field.size(); i++) {

			String eqptype = UPR_EqpType_Field.get(i).getText();
			PR_EqpType.add(eqptype);

			String contractno = UPR_ContractNo_Field.get(i).getText();

			PR_ContractNo.add(contractno);

			String VersionNo = UPR_VersionNo_Field.get(i).getText();

			PR_VersionNo.add(VersionNo);

			String Head = UPR_Head_Field.get(i).getText();

			PR_Head.add(Head);

			String ChargeRate = UPR_ChargeRate_Field.get(i).getText();

			PR_ChargeRate.add(ChargeRate);
			
			String EqpStatus = UPR_EqpStatus_Field.get(i).getText();

			PR_EqpStatus.add(EqpStatus);

		}

		Step_Start(13, "Enter the screen name as Cost Equipment Grouping in the module search field", test, test1);

		moduleNavigate(driver, Cost_Equipment_Grouping_Module);

		Set<String> newset = new HashSet<>(PR_EqpType);

		List<String> neweqptypelist = new ArrayList<String>(newset);

		Step_Start(14, "Click on the global search option in the toolbar. A new window will be opened", test, test1);

		Step_Start(15, "Enter the required Contract code in the Contract Code field", test, test1);

		Step_End(16, "Enter the copied port code in the port field", test, test1);

		Step_Start(17, "Enter the copied terminal code in the terminal field", test, test1);

		Step_Start(18, "Click on the search option", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);

		} else {
			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver,
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully",
					test, test1);
		}

		globalValueSearchWindow1(driver, Condition2, Select_ContractCode, GivenContract_Type, Select_Port, Port,
				Select_Terminal, Terminal);

		Step_End(14, "Click on the global search option in the toolbar. A new window will be opened", test, test1);

		Step_End(15, "Enter the required Contract code in the Contract Code field", test, test1);

		Step_End(17, "Enter the copied terminal code in the terminal field", test, test1);

		Step_End(18, "Click on the search option", test, test1);

		if (isdisplayed(driver, CAR_Norecords)) {

			Step_Start(21,
					"If the records are not shown, clear the port and terminal codes in the port and terminal field and enter only the contract code in the contract code field in that new window.Click on the search option. Select the record where no port and terminal is given.Click on the select option",
					test, test1);

			System.out.println("No records found");
			clear(driver, globalSearch_InputTextfield3);
			clear(driver, globalSearch_InputTextfield2);

			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);

			waitForElement(driver, Port_sort);
			click(driver, Port_sort);

			Step_End(21,
					"If the records are not shown, clear the port and terminal codes in the port and terminal field and enter only the contract code in the contract code field in that new window.Click on the search option. Select the record where no port and terminal is given.Click on the select option",
					test, test1);

		}

		Step_Start(19, "If the record is shown, select the record and click on the select option", test, test1);

		waitForElement(driver, Select1);
		click(driver, Select1);

		waitForElement(driver, SelectButton);
		click(driver, SelectButton);

		Step_End(19, "If the record is shown, select the record and click on the select option", test, test1);

		Step_Start(20,
				"Check whether the copied equipment type from CAR matches with the mapped equipment in the cost equipment grouping. Copy that contract equipments",
				test, test1);

		Step_Start(22,
				"Check whether the copied equipment type from CAR matches with the mapped equipment in the cost equipment grouping. Copy that contract equipments",
				test, test1);

		waitForElement(driver, MappedEquipmentFilter);
		click(driver, MappedEquipmentFilter);

		Map<String, String> ContractEquipment = new HashMap<String, String>();

		for (String eqptypes : neweqptypelist) {

			waitForElement(driver, MappedEquipmentFilter);
			clear(driver, MappedEquipmentFilter);
			sendKeys(driver, MappedEquipmentFilter, eqptypes);

			waitForElement(driver, Contract_Equipment_Value);
			String contract_equipment = getText(driver, Contract_Equipment_Value);

			ContractEquipment.put(eqptypes, contract_equipment);

		}

		System.out.println("ContractEquipment : " + ContractEquipment);

		Step_End(13, "Enter the screen name as Cost Equipment Grouping in the module search field", test, test1);

		for (int i = 0; i < PR_EqpType.size(); i++) {

			String contract_equipment = ContractEquipment.get(PR_EqpType.get(i));
			String contract_equipmentStatus =PR_EqpStatus.get(i);

			Step_End(20,
					"Check whether the copied equipment type from CAR matches with the mapped equipment in the cost equipment grouping. Copy that contract equipments",
					test, test1);

			Step_End(22,
					"Check whether the copied equipment type from CAR matches with the mapped equipment in the cost equipment grouping. Copy that contract equipments",
					test, test1);

			Step_Start(23, "Go to the CAR screen. Click on the contract used option", test, test1);

			waitForElement(driver, CAR_Tab);
			click(driver, CAR_Tab);

			waitForElement(driver, Contract_Used);
			click(driver, Contract_Used);

			Step_End(23, "Go to the CAR screen. Click on the contract used option", test, test1);

			Step_Start(24, "Select the Contract No  which matches with the copied Contract No", test, test1);

			String Contract = String.format(Select_Contract, PR_ContractNo.get(i));

			waitForElement(driver, Contract);
			click(driver, Contract);

			Step_End(24, "Select the Contract No  which matches with the copied Contract No", test, test1);

			Step_Start(25, "Right click on the selected Contract No and click on the Show Contract option", test,
					test1);

			RightClick(driver, Contract);

			waitForElement(driver, Show_Contract);
			click(driver, Show_Contract);

			Step_End(25, "Right click on the selected Contract No and click on the Show Contract option", test, test1);

			Step_Start(26, "Ensure that system opens the vendor contract screen with the selected Contract No", test,
					test1);

			waitForElement(driver, Vendor_Contracts);

			Step_End(26, "Ensure that system opens the vendor contract screen with the selected Contract No", test,
					test1);

			Step_Start(27, "Filter the Head of the activities with the head of the activities copied from CAR screen",
					test, test1);

//			reArrangeAG_GridColumns(driver, VendorColumn);

			waitForElement(driver, Vendor_Columns);
			click(driver, Vendor_Columns);
			waitForDisplay(driver, Vendor_Columns_deselect);
			waitForDisplay(driver, Vendor_Columns_deselect);
			jsClick(driver, Vendor_Columns_deselect);
			List<String> Vendorfiltercolumns = splitAndExpand(VendorColumn);

			for (String columnname : Vendorfiltercolumns) {

				waitForElement(driver, Vendor_Columns_input);
				click(driver, Vendor_Columns_input);
				clear(driver, Vendor_Columns_input);
				sendKeys(driver, Vendor_Columns_input, columnname);

				wait(driver, "1");

				waitForDisplay(driver, Vendor_Columns_deselect);
				jsClick(driver, Vendor_Columns_deselect);
			}

			Step_End(27, "Filter the Head of the activities with the head of the activities copied from CAR screen",
					test, test1);

			Step_Start(28,
					"Ensure that the Copied equipment type from Cost equipment grouping screen matches with Equipment type of  the Vendor contract",
					test, test1);

			waitForElement(driver, Vendor_Filter);
			click(driver, Vendor_Filter);

			waitForElement(driver, Eqp_Filter);
			sendKeys(driver, Eqp_Filter, contract_equipment);
			waitForElement(driver, VC_Eqp_Status_Filter);
			sendKeys(driver, VC_Eqp_Status_Filter, contract_equipmentStatus);
			waitForElement(driver, VC_Head_Filter);
			sendKeys(driver, VC_Head_Filter, PR_Head.get(i));

			Step_End(28,
					"Ensure that the Copied equipment type from Cost equipment grouping screen matches with Equipment type of  the Vendor contract",
					test, test1);

			Step_Start(29, "Copy the amount from the vendor contract and Go to the CAR screen", test, test1);

			String VendorAmounts_field = String.format(Vendor_Amount, PR_Head.get(i));

			String VendorAmounts = getText(driver, VendorAmounts_field);

			Step_End(29, "Copy the amount from the vendor contract and Go to the CAR screen", test, test1);

			Step_Start(30,
					"Check whether the copied amount from the vendor contracts matches with the charge rate in CAR screen",
					test, test1);

			scrollTop(driver);

			if (PR_ChargeRate.get(i).equals(VendorAmounts)) {

				System.out.println("Charge rate is displayed as per the vendor contracts || Expected : " + VendorAmounts
						+ " Actual : " + PR_ChargeRate.get(i));
				Extent_pass_New(driver, "Charge rate is displayed as per the vendor contracts || Expected : "
						+ VendorAmounts + " Actual : " + PR_ChargeRate.get(i), test, test1);
			} else {
				System.out.println("Charge rate is not displayed as per the vendor contracts || Expected : "
						+ VendorAmounts + " Actual : " + PR_ChargeRate.get(i));
				Extent_fail(driver, "Charge rate is not displayed as per the vendor contracts || Expected : "
						+ VendorAmounts + " Actual : " + PR_ChargeRate.get(i), test, test1);
			}

			waitForElement(driver, Close_VendorTab);
			click(driver, Close_VendorTab);

			waitForElement(driver, Tab2);
			click(driver, Tab2);

			Step_End(30,
					"Check whether the copied amount from the vendor contracts matches with the charge rate in CAR screen",
					test, test1);

		}

		Extent_completed(tc_Name, test, test1);

	}

}
