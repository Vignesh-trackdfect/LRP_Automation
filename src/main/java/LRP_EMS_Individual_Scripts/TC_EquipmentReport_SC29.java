package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EquipmentReport_SC29 extends Keywords {

	public void EquipmentReport29(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TC_EquipmentReport_SC29";
		
		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String Field_Names2 = Excel_data.get("Field_Names2");
		String Report_Option = Excel_data.get("Report_Option");
		String Include_Shipper_Owned_Option = Excel_data.get("Include_Shipper_Owned_Option");
		String Stock_Value = Excel_data.get("Stock_Value");
		String ActivityCode_Value = Excel_data.get("ActivityCode_Value");
		String SupplierContract_Value = Excel_data.get("SupplierContract_Value");
		String LeaseKind_Value = Excel_data.get("LeaseKind_Value");
		String Lease_Value = Excel_data.get("Lease_Value");
		String SizeType_Value = Excel_data.get("SizeType_Value");
		String CustomerContract_Value = Excel_data.get("CustomerContract_Value");
		String Lessor_Value = Excel_data.get("Lessor_Value");
		String FlagCode_Value = Excel_data.get("FlagCode_Value");
		String FromLocHierarchy = Excel_data.get("FromLocHierarchy");
		String Loc_Por_Value = Excel_data.get("Loc_Por_Value");
		String Loc_Pol_Value = Excel_data.get("Loc_Pol_Value");
		String ToLocHierarchy = Excel_data.get("ToLocHierarchy");
		String POD_Value = Excel_data.get("POD_Value");
		String Destination_Value = Excel_data.get("Destination_Value");
		String Detail_Perform = Excel_data.get("Detail_Perform");
		String BLDetailsCheckBox = Excel_data.get("BLDetailsCheckBox");
		String From_Region_Value = Excel_data.get("From_Region_Value");
		String To_region_Value = Excel_data.get("To_region_Value");
		String Service_Value = Excel_data.get("Service_Value");
		String Disposal_RegNo_Value = Excel_data.get("Disposal_RegNo_Value");
		String bookNo_Value = Excel_data.get("bookNo_Value");
		String conditionFilter = Excel_data.get("conditionFilter");
		String SupplierContract_Search = Excel_data.get("SupplierContract_Search");
		String Activity_Code_Search = Excel_data.get("Activity_Code_Search");
		String stock_status_code_Search = Excel_data.get("stock_status_code_Search");
		String Lessee_Code_Search = Excel_data.get("Lessee_Code_Search");
		String Lease_Kind_Search = Excel_data.get("Lease_Kind_Search");
		String Equipment_type_Search = Excel_data.get("Equipment_type_Search");
		String Customer_contract_Search = Excel_data.get("Customer_contract_Search");
		String Lessor_Code_Search = Excel_data.get("Lessor_Code_Search");
		String Flag_code_Search = Excel_data.get("Flag_code_Search");
		String Service_Search = Excel_data.get("Service_Search");
		String Disposal_RegNo_Search = Excel_data.get("Disposal_RegNo_Search");
		String bookNo_Search = Excel_data.get("bookNo_Search");
		String Vessel_Voyage_Bound_value = Excel_data.get("Vessel_Voyage_Bound_value");
		String vessel_Voyage_Bound_Header = Excel_data.get("vessel_Voyage_Bound_Header");
		String sizeType_Special_Perform = Excel_data.get("sizeType_Special_Perform");

		
		
		

		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, pass_word);
		Extent_Start(testcase_Name, test, test1);
		Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
		
			moduleNavigate(driver, Field_Names2);

       Step_Start(1, "Select Report by drop menu & select current option", test, test1);
		waitForElement(driver, reportByOpt);
		safeclick(driver, reportByOpt);
		String reportBy_Select =  String.format(DropDown_Select,  Report_Option); 
			click(driver, reportBy_Select);
			
			
         Step_End(1, "Select Report by drop menu & select current option", test, test1);
         
         Step_Start(2, "select required field need to filter with summary option as selected", test, test1);
		waitForElement(driver, includeShipperOwnedOpt);
		safeclick(driver, includeShipperOwnedOpt);
		String shipperOwned_Option =  String.format(DropDown_Select,  Include_Shipper_Owned_Option); 	
		waitForElement(driver, shipperOwned_Option);
			click(driver, shipperOwned_Option);
		
		Step_End(2, "select required field need to filter with summary option as selected", test, test1);
		
		// Non-Mandatory fields
		if (!SupplierContract_Value.equals("")) {
			List<String> datas3 = splitAndExpand(SupplierContract_Value);
			for (String data : datas3) {
				waitForElement(driver, SupplierContract_PlusBtn);
				safeclick(driver, SupplierContract_PlusBtn);
				
				twoColumnSearchWindow(driver, SupplierContract_Search, conditionFilter, data);
			}
		} else {

			System.out.println("SupplierContract_Value " + "Input Not Available in test data");
		}
		if (!ActivityCode_Value.equals("")) {
			List<String> datas2 = splitAndExpand(ActivityCode_Value);
			for (String data : datas2) {
				waitForElement(driver, ActivityCode_PlusBtn);
				safeclick(driver, ActivityCode_PlusBtn);
				
				twoColumnSearchWindow(driver, Activity_Code_Search, conditionFilter, data);

			}
		} else {

			System.out.println("ActivityCode_Value " + "Input Not Available in test data");
		}

		if (!Vessel_Voyage_Bound_value.equals("")) {
			List<String> datas4 = splitAndExpand(Vessel_Voyage_Bound_value);
			for (String data : datas4) {

				waitForElement(driver, Vessel_PlusBtn);
				safeclick(driver, Vessel_PlusBtn);
				twoColumnMultipleSearchWindow(driver, vessel_Voyage_Bound_Header, conditionFilter, data);
				
			}
		} else {

			System.out.println("Vessel_Voyage_Bound_value " + "Input Not Available in test data");
		}
		
		


		if (!Stock_Value.equals("")) {
			List<String> datas1 = splitAndExpand(Stock_Value);
			for (String data : datas1) {
				waitForElement(driver, StockStatus_PlusBtn);
				safeclick(driver, StockStatus_PlusBtn);
				
				twoColumnSearchWindow(driver, stock_status_code_Search, conditionFilter, data);

				
			}
		} else {

			System.out.println("Stock_Value " + "Input Not Available in test data");
		}

		if (!LeaseKind_Value.equals("")) {
			List<String> datas7 = splitAndExpand(LeaseKind_Value);
			for (String data : datas7) {
				waitForElement(driver, LeaseKind_PlusBtn);
				safeclick(driver, LeaseKind_PlusBtn);
				twoColumnSearchWindow(driver, Lease_Kind_Search, conditionFilter, data);

			}
		} else {

			System.out.println("LeaseKind_Value " + "Input Not Available in test data");
		}

		if (!Lease_Value.equals("")) {
			List<String> datas8 = splitAndExpand(Lease_Value);
			for (String data : datas8) {

				waitForElement(driver, Lease_PlusBtn);
				safeclick(driver, Lease_PlusBtn);
				twoColumnSearchWindow(driver, Lessee_Code_Search, conditionFilter, data);

			}
		} else {

			System.out.println("Lease_Value " + "Input Not Available in test data");
		}

		if (!SizeType_Value.equals("")) {
			List<String> datas9 = splitAndExpand(SizeType_Value);
			for (String data : datas9) {

				waitForElement(driver, SizeType_PlusBtn);
				safeclick(driver, SizeType_PlusBtn);
				
				twoColumnSearchWindow(driver, Equipment_type_Search, conditionFilter, data);

			}
		} else {

			System.out.println("Lease_Value " + "Input Not Available in test data");
		}

		if (!CustomerContract_Value.equals("")) {
			List<String> datas10 = splitAndExpand(CustomerContract_Value);
			for (String data : datas10) {

				waitForElement(driver, CustomerContract_PlusBtn);
				safeclick(driver, CustomerContract_PlusBtn);
				twoColumnSearchWindow(driver, Customer_contract_Search, conditionFilter, data);

			}
		} else {

			System.out.println("CustomerContract_Value " + "Input Not Available in test data");
		}

		if (!Lessor_Value.equals("")) {
			List<String> datas11 = splitAndExpand(Lessor_Value);
			for (String data : datas11) {

				waitForElement(driver, Lessor_PlusBtn);
				safeclick(driver, Lessor_PlusBtn);
				twoColumnSearchWindow(driver, Lessor_Code_Search, conditionFilter, data);

			}
		} else {

			System.out.println("Lessor_Value " + "Input Not Available in test data");
		}

		if (!FlagCode_Value.equals("")) {
			List<String> datas12 = splitAndExpand(FlagCode_Value);
			for (String data : datas12) {
				waitForElement(driver, FlagCode_PlusBtn);
				safeclick(driver, FlagCode_PlusBtn);
				twoColumnSearchWindow(driver, Flag_code_Search, conditionFilter, data);

			}
		} else {

			System.out.println("FlagCode_Value " + "Input Not Available in test data");
		}


		if (!Service_Value.equals("")) {
			List<String> datas22 = splitAndExpand(Service_Value);
			for (String data : datas22) {

				waitForElement(driver, Service_SearchBtn);
				safeclick(driver, Service_SearchBtn);
				twoColumnSearchWindow(driver, Service_Search, conditionFilter, data);

			}
		} else {

			System.out.println("Service_Value " + "Input Not Available in test data");
		}


		if (!Disposal_RegNo_Value.equals("")) {
			List<String> datas23 = splitAndExpand(Disposal_RegNo_Value);
			for (String data : datas23) {

				waitForElement(driver, Disposal_RegNo_SearchBtn);
				safeclick(driver, Disposal_RegNo_SearchBtn);
				twoColumnSearchWindow(driver, Disposal_RegNo_Search, conditionFilter, data);

			}
		} else {

			System.out.println("Disposal_RegNo_Value " + "Input Not Available in test data");
		}


		if (!bookNo_Value.equals("")) {
			List<String> datas24 = splitAndExpand(bookNo_Value);
			for (String data : datas24) {

				waitForElement(driver, BookNo_SearchBtn);
				safeclick(driver, BookNo_SearchBtn);
				twoColumnSearchWindow(driver, bookNo_Search, conditionFilter, data);

			}
		} else {

			System.out.println("bookNo_Value " + "Input Not Available in test data");
		}

		if (!FromLocHierarchy.equals("")) {
			waitForElement(driver, From_Loc_Hierarchy_Dropdown);
			safeclick(driver, From_Loc_Hierarchy_Dropdown);
			String From_Loc =  String.format(FromLoc,  FromLocHierarchy); 
				click(driver, From_Loc);
			
		} else {

			System.out.println("FromLocHierarchy " + "Input Not Available in test data");
		}

		if (!From_Region_Value.equals("")) {
			List<String> datas14 = splitAndExpand(From_Region_Value);
			for (String data : datas14) {
				
				waitForElement(driver, From_Loc_region_searchbtn);
				safeclick(driver, From_Loc_region_searchbtn);
				waitForElement(driver, From_Loc_Region_TF);
				sendKeys(driver, From_Loc_Region_TF, data);
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("From_Region_Value " + "Input Not Available in test data");
		}
		if (!Loc_Por_Value.equals("")) {
			List<String> datas13 = splitAndExpand(Loc_Por_Value);
			for (String data1 : datas13) {

			
				waitForElement(driver, Loc_POR_searchBtn);
				safeclick(driver, Loc_POR_searchBtn);
				waitForElement(driver, Loc_POR_TF);
				sendKeys(driver, Loc_POR_TF, data1);
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("Loc_Por_Value " + "Input Not Available in test data");
		}

		if (!Loc_Pol_Value.equals("")) {
			List<String> datas20 = splitAndExpand(Loc_Pol_Value);
			for (String data2 : datas20) {
				waitForElement(driver, Loc_POL_SearchBtn);
				safeclick(driver, Loc_POL_SearchBtn);
				waitForElement(driver, Loc_POL_TF);
				waitForElement(driver, Loc_POL_TF);
				sendKeys(driver, Loc_POL_TF, data2);
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("Loc_Pol_Value " + "Input Not Available in test data");
		}

		if (!ToLocHierarchy.equals("")) {
			waitForElement(driver, To_Loc_Hierarchy_Dropdown);
			safeclick(driver, To_Loc_Hierarchy_Dropdown);
			  String To_Loc =  String.format(ToLoc,  ToLocHierarchy); 
				click(driver, To_Loc);
			
		} else {
			System.out.println("ToLocHierarchy " + "Input Not Available in test data");
		}

		if (!To_region_Value.equals("")) {
			List<String> datas15 = splitAndExpand(To_region_Value);
			for (String data4 : datas15) {
				waitForElement(driver, To_Region_searchBtn);
				safeclick(driver, To_Region_searchBtn);
				waitForElement(driver, To_Region_TF);
				sendKeys(driver, To_Region_TF, data4);
				
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("To_region_Value " + "Input Not Available in test data");
		}

		if (!POD_Value.equals("")) {
			List<String> datas16 = splitAndExpand(POD_Value);
			for (String data1 : datas16) {
				waitForElement(driver, Loc_POD_SearchBtn);
				safeclick(driver, Loc_POD_SearchBtn);
				waitForElement(driver, Loc_POD_TF);
				sendKeys(driver, Loc_POD_TF, data1);
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("POD_Value " + "Input Not Available in test data");
		}

		if (!Destination_Value.equals("")) {
			List<String> datas9 = splitAndExpand(Destination_Value);
			for (String data : datas9) {
				waitForElement(driver, Loc_Destination_SearchBtn);
				safeclick(driver, Loc_Destination_SearchBtn);
				waitForElement(driver, Loc_Destination_TF);
				sendKeys(driver, Loc_Destination_TF, data);
				waitForElement(driver, Loc_CloseBtn);
				safeclick(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("Destination_Value " + "Input Not Available in test data");
		}
		
		if(sizeType_Special_Perform.equalsIgnoreCase("NO")) {
		waitForElement(driver, SizeType_Standard);
		safeclick(driver, SizeType_Standard);
		}else if(sizeType_Special_Perform.equalsIgnoreCase("YES")) {
		
		waitForElement(driver, SizeType_special);
		safeclick(driver, SizeType_special);
		}
		if (Detail_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, detailsOPt);
			safeclick(driver, detailsOPt);
			waitForElement(driver, IncludeBL_checkBox);
			checkBox(driver, IncludeBL_checkBox, BLDetailsCheckBox);
		}
		Extent_call(test, test1, "Click Summary option");
		//click summary button
		waitForElement(driver, summaryOpt);
		doubleClick(driver, summaryOpt);
		scrollBottom(driver);
		if (isDisplayed(driver, summaryOpt)) {
			System.out.println("Expected Result is : Before clicking the show button table data should not displayed || Actual Result is : Before clicking the show button table data is not displayed   ");
			Extent_pass_New(driver, "Expected Result is : Before clicking the show button table data should not displayed || Actual Result is : Before clicking the show button table data is not displayed   ", test, test1);
		} else {
			System.out.println("Expected Result is : Before clicking the show button table data should not displayed || Actual Result is : Before clicking the show button table data is displayed   ");
			Extent_fail(driver, "Expected Result is : Before clicking the show button table data should not displayed || Actual Result is : Before clicking the show button table data is displayed   ", test, test1);
		}
		Step_Start(3, "Click show button & then it shown data in grid", test, test1);
		waitForElement(driver, showOpt);
		doubleClick(driver, showOpt);
		scrollBottom(driver);
        waitForElement(driver, portOpt);
		if (isDisplayed(driver, portOpt)) {
			System.out.println("Expected Result is : Once User Click the show button Port values should be displayed in the grid ||Actual Result is :Once User Click the show button Port values is displayed in the grid");
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is  shown in grid");
			Extent_pass_New(driver, "Expected Result is : Once User Click the show button Port values should be displayed in the grid||Actual Result is :Once User Click the show button Port values is displayed in the grid", test, test1);
		} else {
			System.out.println("Expected Result is : Once User Click the show button Port values should be displayed in the grid ||Actual Result is :Once User Click the show button Port values is not displayed in the grid");
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
			Extent_fail(driver, "Expected Result is : Once User Click the show button Port values should be displayed in the grid ||Actual Result is :Once User Click the show button Port values is not displayed in the grid", test, test1);
		}
        waitForElement(driver, DeportOpt);

		if (isDisplayed(driver, DeportOpt)) {
			System.out.println("Expected Result is : Once User Click the show button Depot values should be displayed in the grid ||Actual Result is :Once User Click the show button Depot values is  displayed in the grid");
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
			Extent_pass_New(driver, "Expected Result is : Once User Click the show button Depot values should be displayed in the grid ||Actual Result is :Once User Click the show button Depot values is  displayed in the grid", test, test1);
		} else {
			System.out.println("Expected Result is : Once User Click the show button Depot values should be displayed in the grid ||Actual Result is :Once User Click the show button Depot values is not displayed in the grid");
			System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
			Extent_fail(driver, "Expected Result is : Once User Click the show button Depot values should be displayed in the grid ||Actual Result is :Once User Click the show button Depot values is not displayed in the grid", test, test1);
		}

		Step_End(3, "Click show button & then it shown data in grid", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
