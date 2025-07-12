package LRP_Import_Documentation_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC062 extends Keywords{
	public void Import_Documentation_SC062(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data
		String testcase_Name="TC_Import_Documentation_SC062";
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_ImportDocumentation=Excel_data.get("Module_ImportDocumentation");
		String dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String bl_Number=Excel_data.get("BL_Number");
		String chargeCode=Excel_data.get("ChargeCode");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String chargeCodeEdit=Excel_data.get("ChargeCodeEdit");
		String baseRateUnit=Excel_data.get("BaseRateUnit");
		String currencyCode=Excel_data.get("CurrencyCode");
		String baseRate=Excel_data.get("BaseRate");
		String portCode=Excel_data.get("PortCode");
		String payBy=Excel_data.get("PayBy");
		String Baserate_Quantity=Excel_data.get("Baserate_Quantity");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
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
		String pol_Value=Excel_data.get("pol_Value");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ConditionFilter = Excel_data.get("ConditionFilter");
		String Charge_Code_Header = Excel_data.get("Charge_Code_Header");
		String Unit_Code_Header = Excel_data.get("Unit_Code_Header");
		String CurrencyCode_Header = Excel_data.get("CurrencyCode_Header");
		String PortCode_Header = Excel_data.get("PortCode_Header");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);
		//		Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1, module_ImportDocumentation);
		Step_Start(1, "Open Import Documentation module", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		
		Step_End(1, "Open Import Documentation module", test, test1);
		Step_Start(2, "CLick Search Button and Load the BL No", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			globalValueSearchWindow(driver, dropdownCondition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
	
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
				waitForElement(driver, popup_Message_Yes_Button);
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
				twoColumnSearchWindow(driver, Pol_Header, ConditionFilter, pol_Value);

			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			click(driver, Show_BL_Button);

			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, ConditionFilter, bl_Number);

		}
		Step_End(2, "CLick Search Button and Load the BL No", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		Step_Start(3, "go the collect charges tab ", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		scrollBottom(driver);
		click(driver, collectChargersTab_Rows);
		String select_ChargeCode=String.format(Charege_Code_Grid, chargeCode);

		Step_End(3, "go the collect charges tab ", test, test1);
		Step_Start(4, "select the charge code ,base unit,currency,equipment type", test, test1);	
		click(driver, select_ChargeCode);
		waitForElement(driver, select_ChargeCode);
		doubleClick(driver, select_ChargeCode);

		Step_End(3, "Select the agency charge and doublt click in the charge tab below grid", test, test1);
		Step_Start(4, "Charge code details fetched with the respective fields", test, test1);

		waitForElement(driver, chargeCode_SearchButton_IMD);
		String actual_ChargeCode=getAttribute(driver, collectChargeTab_ChargeCode, "value");
		if(actual_ChargeCode.equals(chargeCode)) {
			System.out.println("Charge code details fetched with the respective fields|| Expected Charge Code : "+chargeCode+"   ||  Actual Charge Code : "+actual_ChargeCode);
			Extent_pass_New(driver, "Charge code details fetched with the respective fields|| Expected Charge Code : "+chargeCode+"   ||  Actual Charge Code : "+actual_ChargeCode, test, test1);
		}else {
			System.out.println("Charge code details not fetched with the respective fields|| Expected Charge Code : "+chargeCode+"   ||  Actual Charge Code : "+actual_ChargeCode);
			Extent_fail(driver, "Charge code details not fetched with the respective fields|| Expected Charge Code : "+chargeCode+"   ||  Actual Charge Code : "+actual_ChargeCode, test, test1);
		}

		if(!chargeCodeEdit.trim().equals("")) {
			waitForElement(driver, chargeCode_SearchButton_IMD);
			click(driver, chargeCode_SearchButton_IMD);
			twoColumnSearchWindow(driver, Charge_Code_Header, ConditionFilter, chargeCodeEdit);
		}
		
		if(!baseRateUnit.trim().equals("")) {
			waitForElement(driver, baseRateUnit_SearchButton_IMD);
			click(driver, baseRateUnit_SearchButton_IMD);
			twoColumnSearchWindow(driver, Unit_Code_Header, ConditionFilter, baseRateUnit);
		}

		if(!currencyCode.trim().equals("")) {
			waitForElement(driver, currency_SearchButton_IMD);
			click(driver, currency_SearchButton_IMD);
			twoColumnSearchWindow(driver, CurrencyCode_Header, ConditionFilter, currencyCode);
		}

		
		Step_End(4, "select the charge code ,base unit,currency,equipment type", test, test1);
		Step_Start(5, "enter the 3 base rate quantity (actual bill have 2 container)", test, test1);
		if(!Baserate_Quantity.trim().equals("")) {
			waitForElement(driver, baseRate_Quantity_Field_IMD);
			click(driver, baseRate_Quantity_Field_IMD);
			clearAndType(driver, baseRate_Quantity_Field_IMD, Baserate_Quantity);
		}
		
		Step_End(5, "enter the 3 base rate quantity (actual bill have 2 container)", test, test1);
		Step_Start(6, "enter the base rate", test, test1);
		if(!baseRate.trim().equals("")) {
			waitForElement(driver, baseRate_Textfield_IMD);
			click(driver, baseRate_Textfield_IMD);
			clearAndType(driver, baseRate_Textfield_IMD, baseRate);
		}
		
		Step_End(6, "enter the base rate", test, test1);
		Step_Start(7, "select paylocation and select pay by ", test, test1);
		if(!portCode.trim().equals("")) {
			waitForElement(driver, payLocation_SearchButton_IMD);
			click(driver, payLocation_SearchButton_IMD);
			twoColumnSearchWindow(driver, PortCode_Header, ConditionFilter, portCode);
		}
		if(!payBy.trim().equals("")) {
			waitForElement(driver, payBy_Dropdown_IMD);
			click(driver, payBy_Dropdown_IMD);
			String select_PayBy_=String.format(select_PayBy, payBy);
			click(driver, select_PayBy_);
		}
		Step_End(7, "select paylocation and select pay by ", test, test1);
		Step_Start(8, "click the add button", test, test1);
		click(driver, collectChargeTab_add_Button);
		waitForElement(driver, collectChargeTab_add_Button);
		Step_End(8, "click the add button", test, test1);
		Step_Start(9, "system will populate the valaition'Base rate quantity exceeds for the type", test, test1);

		waitForPopup(driver, popup_Message, updatedPopup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(updatedPopup)) {
			System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
		}
		Step_End(9, "system will populate the valaition'Base rate quantity exceeds for the type", test, test1);
		Extent_completed(testcase_Name, test, test1);

	
	}
}
