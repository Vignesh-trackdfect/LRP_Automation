package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Invoice_SC005C  extends Keywords{
	public void Import_Invoice_SC005C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC005C";
		
		

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Filter_Header = Excel_data.get("BL_Filter_Header");
		String BL_Num = Excel_data.get("BL_Num");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Field_Names1 = Excel_data.get("Field_Names1"); 
		String BL_type_input = Excel_data.get("BL_Type");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");
		String Date_Input = Excel_data.get("Date_Input");
		String Service_uninvoiced = Excel_data.get("Service_uninvoiced");
		String Vessel_uninvoiced = Excel_data.get("Vessel_uninvoiced");
		String Voyage_uninvoiced = Excel_data.get("Voyage_uninvoiced");
		String Radio_Button = Excel_data.get("Radio_Button");
		String PLA_Input_uninvoiced = Excel_data.get("PLA_Input_uninvoiced");
		String POL_Input_uninvoiced = Excel_data.get("POL_Input_uninvoiced");
		String PLD_Input_uninvoiced = Excel_data.get("PLD_Input_uninvoiced");
		String POD_Input_uninvoiced = Excel_data.get("POD _Input_uninvoiced");
		String VOYAGE_Header = Excel_data.get("VOYAGE_Header");
		String VESSEL_Header = Excel_data.get("VESSEL_Header");
		String SERVICE_Header = Excel_data.get("SERVICE_Header");
		String PLD_Code_Search_Header = Excel_data.get("PLD_Code_Search_Header");
		String POD_Code_Search_Header = Excel_data.get("POD_Code_Search_Header");
		String POL_Code_Search_Header = Excel_data.get("POL_Code_Search_Header");
		String PLA_Code_Search_Header = Excel_data.get("PLA_Code_Search_Header");
		String bl_type = String.format(bl_typr_dp_select, BL_type_input);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch to agency", test, test1);

	

	

		Step_End(2, "Verify that same BL Number has to show in import invoice module Save the Import Invoice", test,
				test1);

			Extent_call(test, test1, "Import invoice Navigate_it_Via_Uninvoiced_BL_Report ");

		
			Step_Start(10, "Open Uninvoiced BL Report Module", test, test1);

			moduleNavigate(driver, Field_Names1);

			Step_End(10, "Open Uninvoiced BL Report Module", test, test1);

			Step_Start(11, "Verify that New button is enabled, then Click on New Button", test, test1);

			newButton(driver);

			Step_End(11, "Verify that New button is enabled, then Click on New Button", test, test1);

			Step_Start(12,
					"If BL Type is selected as Import Follow Below Steps,Select the BL/MCN (Which has to be there in Test Data) Radio button",
					test, test1);

			waitForElement(driver, bl_typr_dp);
			click(driver, bl_typr_dp);

			waitForElement(driver, bl_type);
			click(driver, bl_type);
			waitForElement(driver, uninvoiced_date);

			selectDatePicker(driver, uninvoiced_date, Date_Input);
			
			if(!Radio_Button.equals("")) {
			
			if(isdisplayed(driver, uninvoiced_mcn_radio_button)) {
			if(Radio_Button.equalsIgnoreCase("MCN")) {
				waitForElement(driver, uninvoiced_mcn_radio_button);
				click(driver, uninvoiced_mcn_radio_button);
			}
			}
			
			
			
			if(isdisplayed(driver, uninvoiced_BL_radio_button)) {
				if(Radio_Button.equalsIgnoreCase("BL")) {
					waitForElement(driver, uninvoiced_BL_radio_button);
					click(driver, uninvoiced_BL_radio_button);
				}
				}
			}
			
			Step_End(12,
					"If BL Type is selected as Import Follow Below Steps,Select the BL/MCN (Which has to be there in Test Data) Radio button",
					test, test1);

			if(!Service_uninvoiced.equals("")) {
			waitForElement(driver, service_search_uninvoiced);
			click(driver, service_search_uninvoiced);

			twoColumnSearchWindow(driver, SERVICE_Header, Condition_Filter, Service_uninvoiced);
			}

			if(!Vessel_uninvoiced.equals("")) {
				waitForElement(driver, vessels_search_uninvoiced);
				click(driver, vessels_search_uninvoiced);
	
				twoColumnSearchWindow(driver, VESSEL_Header, Condition_Filter, Vessel_uninvoiced);
			}

			if(!Voyage_uninvoiced.equals("")) {
				waitForElement(driver, voyage_search_uninvoiced);
				click(driver, voyage_search_uninvoiced);
	
				twoColumnSearchWindow(driver, VOYAGE_Header, Condition_Filter, Voyage_uninvoiced);
			}
			
			if(!PLA_Input_uninvoiced.equals("")) {
			if(isElementAccessible(driver, PLA_SearchButton_UIB)) {
			waitForElement(driver, PLA_SearchButton_UIB);
			click(driver, PLA_SearchButton_UIB);

			twoColumnSearchWindow(driver, PLA_Code_Search_Header, Condition_Filter, PLA_Input_uninvoiced);
			
			}
			}
			
			
			if(!POL_Input_uninvoiced.equals("")) {
			if(isElementAccessible(driver, POL_SearchButton_UIB)) {
			waitForElement(driver, POL_SearchButton_UIB);
			click(driver, POL_SearchButton_UIB);

			twoColumnSearchWindow(driver, POL_Code_Search_Header, Condition_Filter, POL_Input_uninvoiced);
			}
			}
			
			if(!POD_Input_uninvoiced.equals("")) {
			
			if(isElementAccessible(driver, POD_SearchButton_UIB)) {
				waitForElement(driver, POD_SearchButton_UIB);
				click(driver, POD_SearchButton_UIB);

				twoColumnSearchWindow(driver, POD_Code_Search_Header, Condition_Filter, POD_Input_uninvoiced);
				}
			}
			

			if(!PLD_Input_uninvoiced.equals("")) {
			if(isElementAccessible(driver, PLD_SearchButton_UIB)) {
				waitForElement(driver, PLD_SearchButton_UIB);
				click(driver, PLD_SearchButton_UIB);

				twoColumnSearchWindow(driver, PLD_Code_Search_Header, Condition_Filter, PLD_Input_uninvoiced);
				}
			}
				

			Step_Start(13, "Click on SHow Button", test, test1);
			waitForElement(driver, show_button_uninvoiced);
			click(driver, show_button_uninvoiced);
			Step_End(13, "Click on SHow Button", test, test1);

			Step_Start(14, "Filter, Pass your BL NO and Find the Row and Double Click it", test, test1);

			AGGridValueSearchFilter(driver, BL_Filter_Header, Condition_Filter, BL_Num);

			waitForElement(driver, filter_uninvoiced_bl_input_select);
			click(driver, filter_uninvoiced_bl_input_select);
			doubleClick(driver, filter_uninvoiced_bl_input_select);

			Step_End(14, "Filter, Pass your BL NO and Find the Row and Double Click it", test, test1);

			Step_Start(15,
					"System will open the Import Invoice module Verify that same BL Number has to show in import invoice module Save the Import Invoice.",
					test, test1);

			waitForElement(driver, import_invoice_draft_button);
			click(driver, import_invoice_draft_button);

			waitForElement(driver, by_Bl_Number_Txtfield);
			String Bl_number_import_invoice = getAttribute(driver, by_Bl_Number_Txtfield, "value");
			System.out.println(Bl_number_import_invoice);

			if (BL_Num.equals(Bl_number_import_invoice)) {
				System.out.println("Matched || Expected value shown in import documentation : " + BL_Num
						+ " || Actual value shown in import invoice : " + Bl_number_import_invoice);
				Extent_pass_New(driver,
						"Matched || Expected value shown in import documentation : " + BL_Num
								+ " || Actual value shown in import invoice : " + Bl_number_import_invoice,
						test, test1);

			} else {
				System.out.println("NotMatched || Expected value shown in import documentation : " + BL_Num
						+ " || Actual value shown in import invoice : " + Bl_number_import_invoice);
				Extent_fail(driver,
						"NotMatched || Expected value shown in import documentation : " + BL_Num
								+ " || Actual value shown in import invoice : " + Bl_number_import_invoice,
						test, test1);
			}

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Draft_saved_pop);

			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			if (Draft_saved_pop.equals(import_saved_act)) {
				System.out.println(
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);

			} else {
				System.out.println("Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : "
						+ import_saved_act);

				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
						test, test1);

			}
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		

		Step_End(15, "System will open the Import Invoice module"
				+ "Verify that same BL Number has to show in import invoice module." + "Save the Import Invoice.", test,
				test1);

		Step_Start(16, "Delete the invoice Steps, has to follow.", test, test1);
	
		Import_Invoice_Draft_Delete(driver, Import_invoice_delete);
		
		Step_End(16, "Delete the invoice Steps, has to follow.", test, test1);

		Extent_completed(testcase_Name, test, test1);
		
	}

}
