package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC091 extends Keywords {
	public void Import_Documentation_SC091(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		// Get data from test data
		String testcase_Name="TC_Import_Documentation_SC091";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String module_Agency_Roe = Excel_data.get("Module_Agency_Roe");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number = Excel_data.get("BL_Number");
		String description = Excel_data.get("Description");
		String value = Excel_data.get("Value");
		String Table_Name = Excel_data.get("Table_Name");
		String Table_Headers = Excel_data.get("Table_Headers");
		String Confguration_Reset = Excel_data.get("Confguration_Reset");
		String attribute = Excel_data.get("Attribute");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String Select_Search_Type_Agency_Roe=Excel_data.get("Select_Search_Type_Agency_Roe");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String pol_Value=Excel_data.get("pol_Value");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		// Switch User
		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		
		List<Boolean> newlyAdded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, agencyUser, attribute, description, value);

		Step_End(4,
				"Filter the description (Import Documentation - Block Add/Edit Customer, Container, Commodity and Charges tab ) value Set as 'N'",
				test, test1);

		Extent_cal(test, test1, module_ImportDocumentation);

		Step_Start(5, "Open the Import Documentation Retrieve the  bill using tool bar search.", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String NewImportDocumentation = getText(driver, popup_Message);
			if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
				System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup
						+ " || Actual value was : " + NewImportDocumentation);
				Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup
						+ " || Actual value was : " + NewImportDocumentation, test, test1);

			} else {
				System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup
						+ " || Actual value was : " + NewImportDocumentation);
				Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup
						+ " || Actual value was : " + NewImportDocumentation, test, test1);
			}
			safeclick(driver, popup_Message_Yes_Button);
		}
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			scrollTop(driver);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);

			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, bl_Number);

		}
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}

		Step_End(5, "Open the Import Documentation Retrieve the  bill using tool bar search.", test, test1);
		Step_Start(6,
				"below column has not shown  in collect charges tab  \r\n" + "-----------Verify-----------\r\n"
						+ "Verify that these Fields are available,\r\n" + "   1.Currency\r\n"
						+ "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n" + "   4.Total  ",
						test, test1);

		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		waitForElement(driver, collectChrges_Total_Table_Headers);
		List<Map<String, String>> Local_Charges = getTableData(driver, collectChrges_Total_Table_Headers, collectChrges_Total_Table_Row);
		if (isDisplayed(driver, collectChrges_Total_Table_Headers)) {
			List<String> column_Headers = splitAndExpand(Table_Headers);
			String table_Value = TableDataForReport(driver, Local_Charges, Table_Name, column_Headers);
			Extent_pass_New(driver, "Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n"
					+ "   4.Total  fields are available", test, test1);

			Extent_pass_New(driver,"Matched || Actual : \n"+ "<pre>" +table_Value + "</pre>" , test, test1);
		} else {
			System.out.println("Not Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n"
					+ "   4.Total  fields are Not available");
			Extent_fail(driver, "Not Matched || 1.Currency\r\n" + "   2.Manifest Charges\r\n"
					+ "   3.Agency Charges\r\n" + "   4.Total  fields are Not available", test, test1);
		}
		String local_Currency = getFirstValueByHeader(Local_Charges, "Currency");
		String Local_Manifest = getFirstValueByHeader(Local_Charges, "Manifest Charges").replace(",", "");
		String local_Agency_Charges = getFirstValueByHeader(Local_Charges, "Agency Charges").replace(",", "");
		String Local_Total = getFirstValueByHeader(Local_Charges, "Total").replace(",", "");
		Step_End(6,"below column has not shown  in collect charges tab \r\n" + "-----------Verify-----------\r\n"+ "Verify that these Fields are available,\r\n" + "   1.Currency\r\n"+ "   2.Manifest Charges\r\n" + "   3.Agency Charges\r\n" + "   4.Total  ",test, test1);
		String Actual_ETA = getText(driver, Actual_Eta_Date);
		System.out.println("Actual_ETA : "+Actual_ETA);
		List<Map<String, String>> Collect_Charges_Table = getTableData(driver, Collect_Charges_Table_Header,  Collect_Charges_Table_Row);

		moduleNavigate(driver, module_Agency_Roe);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, type_Select1);
		selectByText(driver, type_Select1, Select_Search_Type_Agency_Roe);
		click(driver, Roe_Date_Condition);
		selectByText(driver, Roe_Date_Condition, dropdownCondition);
		click(driver, Roe_Date_Field);
		sendKeys(driver, Roe_Date_Field, Actual_ETA);
		waitForElement(driver, globalSearch_Frame_SearchButton);
		click(driver, globalSearch_Frame_SearchButton);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		elementnotvisible1(driver, SelectButton);
		
		waitForElement(driver, Roe_Table_Headers);
		List<Map<String, String>> Roe_Table = getTableData(driver, Roe_Table_Headers,  Roe_Table_Row);
		waitForElement(driver, Agency_Roe_Close);
		click(driver, Agency_Roe_Close);

		List<String> Roe_Curency_Code = getValuesByHeader(Roe_Table, "Currency Code");
		List<String> ROE_value = getValuesByHeader(Roe_Table, "ROE");

		List<String> type_Columns = getValuesByHeader(Collect_Charges_Table, "Type");
		String Manifest_toatl_Value ;
		if(type_Columns.contains("Manifest")) {
			List<String> Manifest_curency_Code = getValuesByFirstColumnAndHeader(Collect_Charges_Table, "Type", "Manifest", "Currency");
			List<String> Manifest_Amount = getValuesByFirstColumnAndHeader(Collect_Charges_Table, "Type", "Manifest", "Amount");
			Manifest_toatl_Value = convertToCurrency(Manifest_curency_Code, Manifest_Amount, Roe_Curency_Code, ROE_value,local_Currency);
			System.out.println(Manifest_toatl_Value);
		}else {
			Manifest_toatl_Value="0.000";
		}
		double Local_ManifestVal=getNumberValue(Local_Manifest);
		double Manifest_toatl=getNumberValue(Manifest_toatl_Value);
		
		if(Local_ManifestVal==Manifest_toatl) {
			if(type_Columns.contains("Manifest")) {
				Extent_pass_New(driver, "Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || The Sum Of Colect Charges Table Manifest Amount value is  : " + Manifest_toatl_Value, test,test1);
				System.out.println("Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || The Sum Of Colect Charges Table Manifest Amount value is  : " + Manifest_toatl_Value);
			}else {
				Extent_pass_New(driver, "Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || There is No Manifest Charges in the Colect Charges Table", test,test1);
				System.out.println("Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || There is No Manifest Charges in the Colect Charges Table");
			}
		} else {
			System.out.println("Not Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || The Sum Of Colect Charges Table Manifest Amount value is  : " + Manifest_toatl_Value);
			Extent_fail(driver, "Not Matched || The Local Charges Table Manifest Charges value is : " + Local_Manifest + " || The Sum Of Colect Charges Table Manifest Amount value is  : " + Manifest_toatl_Value, test,test1);
		}
		List<String> curency_Code = getValuesByFirstColumnAndHeader(Collect_Charges_Table, "Type", "Agency", "Currency");
		List<String> Amount = getValuesByFirstColumnAndHeader(Collect_Charges_Table, "Type", "Agency", "Amount");
		String Agency_toatl_Value = convertToCurrency(curency_Code, Amount, Roe_Curency_Code, ROE_value,local_Currency);
		System.out.println("toatl_Value : "+Agency_toatl_Value);
		
		double local_Agency_ChargesValu=getNumberValue(local_Agency_Charges);
		double Agency_toatl_ValueValue=getNumberValue(Agency_toatl_Value);
		
		if(local_Agency_ChargesValu==Agency_toatl_ValueValue) {
			Extent_pass_New(driver, "Matched || The Local Charges Table Agency Charges value is : " + local_Agency_Charges + " || The Sum Of Colect Charges Table Agency Amount value is  : " + Agency_toatl_Value, test,test1);
			System.out.println("Matched || The Local Charges Table Agency Charges value is : " + local_Agency_Charges + " || The Sum Of Colect Charges Table Agency Amount value is  : " + Agency_toatl_Value);
		} else {
			System.out.println("Not Matched || The Local Charges Table Agency Charges value is : " + local_Agency_Charges + " || The Sum Of Colect Charges Table Agency Amount value is  : " + Agency_toatl_Value);
			Extent_fail(driver, "Not Matched || The Local Charges Table Agency Charges value is : " + local_Agency_Charges + " || The Sum Of Colect Charges Table Agency Amount value is  : " + Agency_toatl_Value, test,test1);
		}
		System.out.println();
		String total_Amount_Value = Double.toString( Double.parseDouble(Manifest_toatl_Value)+Double.parseDouble(Agency_toatl_Value));
	
		double Local_TotalAmount=getNumberValue(Local_Total);
		double total_Amount_ValueAct=getNumberValue(total_Amount_Value);
		
		if(Local_TotalAmount==total_Amount_ValueAct) {
			Extent_pass_New(driver, "Matched || The Local Charges Table Total value is : " + Local_Total + " || The Sum Of Colect Charges Table Amount value is  : " + total_Amount_Value, test,test1);
			System.out.println("Matched || The Local Charges Table Total value is : " + Local_Total + " || The Sum Of Colect Charges Table Amount value is  : " + total_Amount_Value);
		} else {
			System.out.println("Not Matched || The Local Charges Table Total value is : " + Local_Total + " || The Sum Of Colect Charges Table Amount value is  : " + total_Amount_Value);
			Extent_fail(driver, "Not Matched || The Local Charges Table Total value is : " + Local_Total + " || The Sum Of Colect Charges Table Amount value is  : " + total_Amount_Value, test,test1);
		}

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, agencyUser, description, Confguration_Reset, newlyAdded, reset);
		
		Extent_completed(testcase_Name, test, test1);
	}
}
