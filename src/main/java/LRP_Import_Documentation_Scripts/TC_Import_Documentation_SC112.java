package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC112  extends Keywords{

	public void Import_Documentation_SC112(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC112";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Customer_Code = Excel_data.get("Customer_Code");
		String BL_Num = Excel_data.get("BL_Num");
		String Agency_Local_Charges_Module = Excel_data.get("Agency_Local_Charges_Module");
		String Charge_Code = Excel_data.get("Charge_Code");
		String Currency = Excel_data.get("Currency");
		String Charge_Unit = Excel_data.get("Charge_Unit");
		String Valid_From = Excel_data.get("Valid_From");
		String Valid_To = Excel_data.get("Valid_To");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Amount_Input = Excel_data.get("Amount_Input");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Select_Search_Type_ALC=Excel_data.get("Select_Search_Type_ALC");
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
		String Do_You_Want_Delete_Import_Doc=Excel_data.get("Do_You_Want_Delete_Import_Doc");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String date_Picker = Excel_data.get("date_Picker");
		String Charge_Unit_Header = Excel_data.get("Charge_Unit_Header");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Charge_Code_Header = Excel_data.get("Charge_Code_Header");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		String Charge_row = String.format(Charge_row_, Charge_Code);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "open the agency local charges module", test, test1);
		moduleNavigate(driver, Agency_Local_Charges_Module);

		Step_End(1, "open the agency local charges module", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_ALC, Customer_Code, "", "", "", "");
		waitForDisplay(driver, Temprory_Popup);
		if(isdisplayed(driver, Temprory_Popup)) {
			waitForElement(driver, Agency_Search_Close);
			click(driver, Agency_Search_Close);
			Step_Start(2, "Click New Button", test, test1);
			waitForElement(driver, NewButton_ToolBar);
			click(driver, NewButton_ToolBar);
			Step_End(2, "Click New Button", test, test1);
			Step_Start(3, "click on customer option and  selecte the customer", test, test1);
			waitForElement(driver, customer_Search_Btn);
			click(driver, customer_Search_Btn);
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_ALC, Customer_Code, "", "", "", "");

			Step_End(3, "click on customer option and  selecte the customer", test, test1);
			Step_Start(4, "Selecte Import radio Button and click the COMMON Tab", test, test1);
			waitForElement(driver, import_Radio_Button);
			click(driver, import_Radio_Button);
			Step_End(4, "Selecte Import radio Button and click the COMMON Tab", test, test1);
			Step_Start(5, "Verify that Charge Code already there in Agency local charges if Yes Skip(Steps 7,8, and 9) charge code-CBF Already mapped for that customer and agency (INSVM113)", test, test1);
			Step_Start(6, "Select charge code,Currency,ChargeUnit, Valid from and valid To and AMT, and select Status as ALL.(All Details Must take from Test Data.)\r\n"
					+ "", test, test1);
			waitForElement(driver, ALC_Charge_Search);
			click(driver, ALC_Charge_Search);
			twoColumnSearchWindow(driver, Charge_Code_Header, Condition_Filter, Charge_Code);

			waitForElement(driver, ALC_Currency_Search);
			click(driver, ALC_Currency_Search);
			twoColumnSearchWindow(driver, Currency_Code_Header, Condition_Filter, Currency);

			waitForElement(driver, ALC_Charge_Unit_Search);
			click(driver, ALC_Charge_Unit_Search);
			twoColumnSearchWindow(driver, Charge_Unit_Header, Condition_Filter, Charge_Unit);
			
			waitForElement(driver, ALC_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, ALC_From_Date, Valid_From);
			} else {
				waitForElement(driver, ALC_From_Date);
				clearAndType(driver, ALC_From_Date, Valid_From);
			}
			
			
			waitForElement(driver, ALC_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, ALC_To_Date, Valid_To);
			} else {
				waitForElement(driver, ALC_To_Date);
				clearAndType(driver, ALC_To_Date, Valid_To);
			}
			
			
			waitForElement(driver, ALC_Amount);
			sendKeys(driver, ALC_Amount, Amount_Input);
			Step_End(6, "Select charge code,Currency,ChargeUnit, Valid from and valid To and AMT, and select Status as ALL.(All Details Must take from Test Data.)\r\n"
					+ "", test, test1);
			Step_Start(7, "Click on Add Button", test, test1);
			waitForElement(driver, ALC_Add_Button);
			click(driver, ALC_Add_Button);
			Step_End(7, "Click on Add Button", test, test1);
			Step_End(5, "Verify that Charge Code already there in Agency local charges if Yes Skip(Steps 7,8, and 9) charge code-CBF Already mapped for that customer and agency (INSVM113)", test, test1);

			Step_Start(8, "Click on save Button,Close the Module.", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Step_End(8, "Click on save Button,Close the Module.", test, test1);
		}
		
		waitForElement(driver, ALC_Table_Headers);
		List<Map<String, String>> customer_ALC_Table_Data = getTableData(driver, ALC_Table_Headers, ALC_Table_Rows);
		String customer_Amount_Value = getValueByFirstColumnAndHeader(customer_ALC_Table_Data, "Charge Code",Charge_Code, "Amount");
		click(driver, Close_Current_tab);
		
		Step_Start(9, "Open Agency local charges Module Click on Edit Button", test, test1);
		
		moduleNavigate(driver, Agency_Local_Charges_Module);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(9, "Open Agency local charges Module Click on Edit Button", test, test1);
		Step_Start(10, "Selecte Import radio Button and click the COMMON Tab", test, test1);
		waitForElement(driver, import_Radio_Button);
		click(driver, import_Radio_Button);
		Step_End(10, "Selecte Import radio Button and click the COMMON Tab", test, test1);
		Step_Start(11, " Verify that Charge Code already there in Agency local charges if Yes SkiP(Steps 13,14,and 15) ", test, test1);
		waitForDisplay(driver, Charge_row);
		if(!isDisplayed(driver, Charge_row)) {
			Step_Start(12, "Select charge code,Currency,ChargeUnit, Valid from and valid To and AMT, and select Status as ALL.(All Details Must take from Test Data.)\r\n"
					+ "", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			waitForElement(driver, ALC_Charge_Search);
			click(driver, ALC_Charge_Search);
			twoColumnSearchWindow(driver, Charge_Code_Header, Condition_Filter, Charge_Code);


			waitForElement(driver, ALC_Currency_Search);
			click(driver, ALC_Currency_Search);
			twoColumnSearchWindow(driver, Currency_Code_Header, Condition_Filter, Currency);

			waitForElement(driver, ALC_Charge_Unit_Search);
			click(driver, ALC_Charge_Unit_Search);
			twoColumnSearchWindow(driver, Charge_Unit_Header, Condition_Filter, Charge_Unit);

			
			waitForElement(driver, ALC_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, ALC_From_Date, Valid_From);
			} else {
				waitForElement(driver, ALC_From_Date);
				clearAndType(driver, ALC_From_Date, Valid_From);
			}
			
			
			waitForElement(driver, ALC_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, ALC_To_Date, Valid_To);
			} else {
				waitForElement(driver, ALC_To_Date);
				clearAndType(driver, ALC_To_Date, Valid_To);
			}
			
			
			waitForElement(driver, ALC_Amount);
			sendKeys(driver, ALC_Amount, Amount_Input);
			Step_End(12, "Select charge code,Currency,ChargeUnit, Valid from and valid To and AMT, and select Status as ALL.(All Details Must take from Test Data.)\r\n"
					+ "", test, test1);
			Step_Start(13, "Click on Add Button", test, test1);
			waitForElement(driver, ALC_Add_Button);
			click(driver, ALC_Add_Button);
			Step_End(13, "Click on Add Button", test, test1);
			Step_Start(14, "Click on save Button", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, "Agency Local Charges Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Step_End(14, "Click on save Button", test, test1);
		}
		mouseOverToElement(driver, Charge_row);
		waitForElement(driver, ALC_Table_Headers);
		List<Map<String, String>> Agency_ALC_Table_Data = getTableData(driver, ALC_Table_Headers, ALC_Table_Rows);
		String Agency_Amount_Value = getValueByFirstColumnAndHeader(Agency_ALC_Table_Data, "Charge Code",Charge_Code, "Amount");
		Step_End(11, " Verify that Charge Code already there in Agency local charges if Yes SkiP(Steps 13,14,and 15) ", test, test1);

		Step_Start(15, "open the import documentation", test, test1);
		
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(15, "open the import documentation", test, test1);

		Step_Start(16, "retrieve the bl using toolbar search ", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar );
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String NewImportDocumentation = getText(driver, popup_Message);
			if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
				System.out.println("Matched || Expected popup was : " + NewImportDocumentationPopup
						+ " || Actual popup was : " + NewImportDocumentation);
				Extent_pass_New(driver, "Matched || Expected popup was : " + NewImportDocumentationPopup
						+ " || Actual popup was : " + NewImportDocumentation, test, test1);

			} else {
				System.out.println("NotMatched || Expected popup was : " + NewImportDocumentationPopup
						+ " || Actual popup was : " + NewImportDocumentation);
				Extent_fail(driver, "NotMatched || Expected popup was : " + NewImportDocumentationPopup
						+ " || Actual popup was : " + NewImportDocumentation, test, test1);
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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);
		}
		Step_End(16, "retrieve the bl using toolbar search ", test, test1);
		Step_Start(17, "go to the collect charge tab", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			waitForPopup(driver, popup_Message, "Import Document Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		Step_End(17, "go to the collect charge tab", test, test1);
		scrollBottom(driver);
		Step_Start(18, "agency local charge has shown based on customer based on Customer Based Amount and charge Unit has to Verify", test, test1);
		List<Map<String, String>> Collect_Charges_Table_Data = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
		String Collect_Charges_Amount_Value = getValueByFirstColumnAndHeader(Collect_Charges_Table_Data, "Charge Code",Charge_Code, "Base Rate");
		waitForElement(driver, Collect_Charges_Tab);
		if (customer_Amount_Value.equals(Collect_Charges_Amount_Value)) {
			System.out.println("Matched || Expected Customer Amount Value From Agency Local Charges Module : " + customer_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value);
			Extent_pass_New(driver, "Matched || Expected Customer Amount Value From Agency Local Charges Module : " + customer_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value, test,
					test1);
		} else if (Agency_Amount_Value.equals(Collect_Charges_Amount_Value)) {
			System.out.println("Matched || Expected Agency Amount Value From Agency Local Charges Module : " + Agency_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value);
			Extent_pass_New(driver, "Matched || Expected Agency Amount Value From Agency Local Charges Module : " + Agency_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value, test,
					test1);
		} else {
			System.out.println("Matched || Expected Customer Amount Value From Agency Local Charges Module : " + customer_Amount_Value + "Matched || Expected Agency Amount Value From Agency Local Charges Module : " + Agency_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value);
			Extent_fail(driver, "Matched || Expected Customer Amount Value From Agency Local Charges Module : " + customer_Amount_Value + "Matched || Expected Agency Amount Value From Agency Local Charges Module : " + Agency_Amount_Value + " || Actual Collect Charges Tab Customer Amount Value From Import Documentaion Module : " + Collect_Charges_Amount_Value,
					test, test1);
		}
		Step_End(18, "agency local charge has shown based on customer based on Customer Based Amount and charge Unit has to Verify", test, test1);
		scrollTop(driver);
		if(Do_You_Want_Delete_Import_Doc.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);					
		}
		
		Extent_completed(testcase_Name, test, test1);
	}
}
