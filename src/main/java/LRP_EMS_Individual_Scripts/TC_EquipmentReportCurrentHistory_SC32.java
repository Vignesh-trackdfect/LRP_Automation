package LRP_EMS_Individual_Scripts;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EquipmentReportCurrentHistory_SC32 extends Keywords {

	public void EquipmentRepportCurrentHistory32(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TC_EquipmentReportCurrentHistory_SC32";
		
		
		


		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String Field_Names2 = Excel_data.get("Field_Names2");
		String Report_Option = Excel_data.get("Report_Option");
		String Include_Shipper_Owned_Option = Excel_data.get("Include_Shipper_Owned_Option");
		String report_request_sentPopup = Excel_data.get("report_request_sentPopup");
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
		String ToLocHierarchy = Excel_data.get("ToLocHierarchy");
		String POD_Value = Excel_data.get("POD_Value");
		String BLDetailsCheckBox = Excel_data.get("BLDetailsCheckBox");
		String Service_Value = Excel_data.get("Service_Value");
		String Disposal_RegNo_Value = Excel_data.get("Disposal_RegNo_Value");
		String From_Region_Value = Excel_data.get("From_Region_Value");
		String bookNo_Value = Excel_data.get("bookNo_Value");
		String Loc_Pol_Value = Excel_data.get("Loc_Pol_Value");
		String To_region_Value = Excel_data.get("To_region_Value");
		String Destination_Value = Excel_data.get("Destination_Value");
		String SizeType_standard_Perform = Excel_data.get("SizeType_standard_Perform");
		String sizeType_Special_Perform = Excel_data.get("sizeType_Special_Perform");
		String Detail_Perform = Excel_data.get("Detail_Perform");
		String date_Picker = Excel_data.get("date_Picker");
		String Activity_date_From = Excel_data.get("Activity_date_From");
		String Activity_Date_To = Excel_data.get("Activity_Date_To");
		String creation_Date_From = Excel_data.get("creation_Date_From");
		String creation_Date_To = Excel_data.get("creation_Date_To");
		String Modified_date_from = Excel_data.get("Modified_date_from");
		String Modified_Date_To = Excel_data.get("Modified_Date_To");
		String conditionFilter = Excel_data.get("conditionFilter");
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
		String SupplierContract_Search = Excel_data.get("SupplierContract_Search");
		String Vessel_Voyage_Bound_value = Excel_data.get("Vessel_Voyage_Bound_value");
		String vessel_Voyage_Bound_Header = Excel_data.get("vessel_Voyage_Bound_Header");
		
		




		Extent_Start(testcase_Name, test, test1);
		// login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, pass_word);
		Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");

			moduleNavigate(driver, Field_Names2);

		Step_Start(1, "Select Report by drop menu & select history option", test, test1);
		// select report by option
		waitForElement(driver, reportByOpt);
		click(driver, reportByOpt);
		String reportBy_Select =  String.format(reportBySelect,  Report_Option); 
		click(driver, reportBy_Select);
		Step_End(1, "Select Report by drop menu & select history option", test, test1);
		Step_Start(2, "select required field need to filter", test, test1);
		waitForElement(driver, includeShipperOwnedOpt);
		click(driver, includeShipperOwnedOpt);
		String shipperOwned_Option =  String.format(shipperOwnedOption,  Include_Shipper_Owned_Option);
		click(driver, shipperOwned_Option);
		Step_End(2, "select required field need to filter", test, test1);
		Step_Start(3, "Click on search icon in date search & select date range accordingly", test, test1);
		// select date
		waitForElement(driver, kDateSearch);
		safeclick(driver, kDateSearch);
		
		if(!Activity_date_From.equals("")) {

		Extent_call(test, test1, "select activity from date and month");
		
		waitForElement(driver, kActivityDate);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kActivityDate, Activity_date_From);
		} else {
			waitForElement(driver, kActivityDate);
			clearAndType(driver, kActivityDate, Activity_date_From);
		}
		
		}

		if(!Activity_Date_To.equals("")) {

		Extent_call(test, test1, "select activity To date and month");

		
		waitForElement(driver, kActivityDateLast);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kActivityDateLast, Activity_Date_To);
		} else {
			waitForElement(driver, kActivityDateLast);
			clearAndType(driver, kActivityDateLast, Activity_Date_To);
		}
		
		}
		
		if(!creation_Date_From.equals("")) {

		Extent_call(test, test1, "select Creation from date and month");
		
		waitForElement(driver, kCreationDate);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kCreationDate, creation_Date_From);
		} else {
			waitForElement(driver, kCreationDate);
			clearAndType(driver, kCreationDate, creation_Date_From);
		}
		}
		if(!creation_Date_To.equals("")) {

		Extent_call(test, test1, "select Creation To date and month");


		waitForElement(driver, kCreationDateLast);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kCreationDateLast, creation_Date_To);
		} else {
			waitForElement(driver, kCreationDateLast);
			clearAndType(driver, kCreationDateLast, creation_Date_To);
		}
		}

		if(!Modified_date_from.equals("")) {

		Extent_call(test, test1, "select modify from date and month");
		
		waitForElement(driver, kModifyDate);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kModifyDate, Modified_date_from);
		} else {
			waitForElement(driver, kModifyDate);
			clearAndType(driver, kModifyDate, Modified_date_from);
		}
		}
		if(!Modified_Date_To.equals("")) {

		Extent_call(test, test1, "select modify To date and month");
		
		waitForElement(driver, kModifyDateLast);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, kModifyDateLast, Modified_Date_To);
		} else {
			waitForElement(driver, kModifyDateLast);
			clearAndType(driver, kModifyDateLast, Modified_Date_To);
		}
		}
		Step_End(3, "Click on search icon in date search & select date range accordingly", test, test1);

		Step_Start(4, "Click ok button once date range given", test, test1);
		// safeclick ok button
		waitForElement(driver, kOkOption);
		safeclick(driver, kOkOption);
		Step_End(4, "Click ok button once date range given", test, test1);

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
			click(driver, From_Loc_Hierarchy_Dropdown);
			String From_Loc =  String.format(FromLoc,  FromLocHierarchy); 
				click(driver, From_Loc);
			
		} else {

			System.out.println("FromLocHierarchy " + "Input Not Available in test data");
		}

		if (!From_Region_Value.equals("")) {
			List<String> datas14 = splitAndExpand(From_Region_Value);
			for (String data : datas14) {
				waitForElement(driver, From_Loc_region_searchbtn);
				click(driver, From_Loc_region_searchbtn);
				waitForElement(driver, From_Loc_Region_TF);
				sendKeys(driver, From_Loc_Region_TF, data);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("From_Region_Value " + "Input Not Available in test data");
		}

		if (!Loc_Por_Value.equals("")) {
			List<String> datas13 = splitAndExpand(Loc_Por_Value);
			for (String data1 : datas13) {

				waitForElement(driver, Loc_POR_searchBtn);
				click(driver, Loc_POR_searchBtn);
				waitForElement(driver, Loc_POR_TF);
				sendKeys(driver, Loc_POR_TF, data1);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("Loc_Por_Value " + "Input Not Available in test data");
		}

		if (!Loc_Pol_Value.equals("")) {
			List<String> datas20 = splitAndExpand(Loc_Pol_Value);
			for (String data2 : datas20) {
				waitForElement(driver, Loc_POL_SearchBtn);
				click(driver, Loc_POL_SearchBtn);
				waitForElement(driver, Loc_POL_TF);
				sendKeys(driver, Loc_POL_TF, data2);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {

			System.out.println("Loc_Pol_Value " + "Input Not Available in test data");
		}

		if (!ToLocHierarchy.equals("")) {
			waitForElement(driver, To_Loc_Hierarchy_Dropdown);
			click(driver, To_Loc_Hierarchy_Dropdown);
			 String To_Loc =  String.format(ToLoc,  ToLocHierarchy); 
				click(driver, To_Loc);
			
		} else {
			System.out.println("ToLocHierarchy " + "Input Not Available in test data");
		}

		if (!To_region_Value.equals("")) {
			List<String> datas15 = splitAndExpand(To_region_Value);
			for (String data4 : datas15) {
				waitForElement(driver, To_Region_searchBtn);
				click(driver, To_Region_searchBtn);
				waitForElement(driver, To_Region_TF);
				sendKeys(driver, To_Region_TF, data4);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("To_region_Value " + "Input Not Available in test data");
		}

		if (!POD_Value.equals("")) {
			List<String> datas16 = splitAndExpand(POD_Value);
			for (String data1 : datas16) {
				waitForElement(driver, Loc_POD_SearchBtn);
				click(driver, Loc_POD_SearchBtn);
				waitForElement(driver, Loc_POD_TF);
				sendKeys(driver, Loc_POD_TF, data1);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("POD_Value " + "Input Not Available in test data");
		}

		if (!Destination_Value.equals("")) {
			List<String> datas9 = splitAndExpand(Destination_Value);
			for (String data : datas9) {
				waitForElement(driver, Loc_Destination_SearchBtn);
				click(driver, Loc_Destination_SearchBtn);
				waitForElement(driver, Loc_Destination_TF);
				sendKeys(driver, Loc_Destination_TF, data);
				waitForElement(driver, Loc_CloseBtn);
				click(driver, Loc_CloseBtn);
			}
		} else {
			System.out.println("Destination_Value " + "Input Not Available in test data");
		}

		if (SizeType_standard_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, SizeType_Standard);
			click(driver, SizeType_Standard);
		}

		if (sizeType_Special_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, SizeType_special);
			click(driver, SizeType_special);
		}

		if (Detail_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, detailsOPt);
			click(driver, detailsOPt);
			if (BLDetailsCheckBox.equalsIgnoreCase("YES")) {
				waitForElement(driver, IncludeBL_checkBox);
				checkBox(driver, IncludeBL_checkBox, BLDetailsCheckBox);
			}
		}
		Step_Start(5, "Click Detail tab button & click show button", test, test1);
		// click details option
		waitForElement(driver, detailsOPt);
		click(driver, detailsOPt);
		// click show option
		waitForElement(driver, showOpt);
		doubleClick(driver, showOpt);
		Step_End(5, "Click Detail tab button & click show button", test, test1);
		Step_Start(6, "message shown as report request sent", test, test1);
		waitForDisplay(driver, Popup_Message);
		if(isDisplayed(driver, Popup_Message)) {
		String reportPop = getText(driver, Popup_Message);
		if (reportPop.equals(report_request_sentPopup)) {
			System.out.println("Matched || Expected value was : " + report_request_sentPopup + " || Actual value was : "
					+ reportPop);
			Extent_pass_New(driver, "Matched || Expected value was : " + report_request_sentPopup
					+ " || Actual value was : " + reportPop, test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + report_request_sentPopup
					+ " || Actual value was : " + reportPop);
			Extent_fail(driver, "NotMatched || Expected value was : " + report_request_sentPopup
					+ " || Actual value was : " + reportPop, test, test1);

		}
		}else {
			System.out.println("Either Expected Popup is not displayed or Quickly disappear");
			Extent_Warning(driver, "Either Expected Popup is not displayed or Quickly disappear", test, test1);
		}
		
		Step_End(6, "message shown as report request sent", test, test1);
		Step_Start(7, " click download icon button & click the id once processed", test, test1);
		// click download button
		waitForElement(driver, downloadOpt);
		click(driver, downloadOpt);
		waitForDownload(driver, processed);
		Step_End(7, " click download icon button & click the id once processed", test, test1);
		Step_Start(8, "Export sheet will be downloaded once clicked the processed id", test, test1);
		String current_Report = getText(driver, Report_download);
		System.out.println("Current report : " + current_Report);
		Extent_pass_New(driver, "Current report : " + current_Report, test, test1);

		waitForElement(driver, reportDownload);
		click(driver, reportDownload);
		Downloadedfile(driver,current_Report);
		Step_End(8, "Export sheet will be downloaded once clicked the processed id", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
