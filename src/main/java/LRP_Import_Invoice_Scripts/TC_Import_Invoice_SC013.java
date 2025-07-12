package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC013 extends Keywords {

	public void Import_Invoice_SC013(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC013";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");
		String BL_Num = Excel_data.get("BL_Num"); 
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String Draft_colour = Excel_data.get("Draft_colour");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String service_input = Excel_data.get("service_input");
		String vesselss_code_input = Excel_data.get("vesselss_code_input");
		String voyagee_code_input = Excel_data.get("voyagee_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input");
		String Customer_Code = Excel_data.get("Customer_Code");
		String Field_Names1 = Excel_data.get("Field_Names1");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input"); 
		String Call_ID = Excel_data.get("Call_ID");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "open the import Invoice module", test, test1);

		moduleNavigate(driver, Field_Names);
		Step_End(2, "open the import Invoice module", test, test1);

		if (BL_Retrive_from_Import_invoice.equals("By_bl_Number")) {

			Extent_call(test, test1, "If like to Go By BL follow below step,");

			Step_Start(3, "click the new button", test, test1);

			newButton(driver);

			Step_End(3, "click the new button", test, test1);

			Step_Start(4, " Click on BL NO Search and Paste the BL in the search and then load the BL", test, test1);

			waitForElement(driver, import_invoice_bl_search);
			click(driver, import_invoice_bl_search);

			globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Num, "", "", "", "");
			
			if(isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);
					
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
					if(Charges_Popup.equals(act_Popup)) {
						System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						jsClick(driver, popup_Message_Ok_Button);
						waitForDisplay(driver, popup_Up_Ok);
						if(isdisplayed(driver, popup_Up_Ok)) {
							waitForElement(driver, popup_Up_Ok);
							jsClick(driver, popup_Up_Ok);
					}
					}
				}
				}
				else if(Charges_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					
					if(isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
				}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button); 
				}
					}
				}
				
			}

			waitForElement(driver, import_invoice_bl);

			String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");
			System.out.println(BL_Numberact);

			if (BL_Num.equals(BL_Numberact)) {
				System.out.println("Given BL Number is retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact);

				Extent_pass_New(driver, "Given BL Number is retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact, test, test1);

			} else {
				System.out.println("Given BL Number is not retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact);
				Extent_fail(driver, "Given BL Number is not retrived || Expected BL_Number : " + BL_Num
						+ " || Actual BL_Number : " + BL_Numberact, test, test1);

			}
			Step_End(4, " Click on BL NO Search and Paste the BL in the search and then load the BL", test, test1);
		}

		if (BL_Retrive_from_Import_invoice.equals("By_Vessels")) {

			Extent_call(test, test1, "If like to Go By Vessel follow below steps");

			newButton(driver);

			Step_Start(4, "click the by vessel option", test, test1);

			waitForElement(driver, by_vessels_select);
			click(driver, by_vessels_select);

			Step_End(4, " click the by vessel option", test, test1);

			Step_Start(5, " enter the service in service field", test, test1);

			waitForElement(driver, service_text);
			sendKeys(driver, service_text, service_input);

			Step_End(5, " enter the service in service field", test, test1);

			Step_Start(6, " automatically service details has to be populated based on the given service ", test,
					test1);

			Step_Start(7, "select the serive ,vessel and voyage details for that bl ", test, test1);

			waitForElement(driver, vessels_code_input);
            click(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, vesselss_code_input);

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, voyagee_code_input);

			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_code_input);
			horizontalscroll(driver, By_Vessel_Scroll, 600);

			horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
				}
				
				if(!Call_ID.equals("")) {

				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}
			Step_Start(7, "select the serive ,vessel and voyage details for that bl ", test, test1);

			Step_End(6, " automatically service details has to be populated based on the given service ", test, test1);

			Step_Start(8, "before click the customer field ", test, test1);

			waitForElement(driver, Select_grid);
			click(driver, Select_grid);

			Step_End(8, "before click the customer field ", test, test1);

			Step_Start(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name",
					test, test1);

			moduleNavigate(driver, Field_Names1);

			scrollTop(driver);

			newButton(driver);

			waitForDisplay(driver, cancel_Common_btn);
			if (isClickable(driver, cancel_Common_btn)) {
				click(driver, cancel_Common_btn);
			}

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, "", "", "", "");

			waitForElement(driver, Customer_Tab);
			click(driver, Customer_Tab);

			waitForElement(driver, customer_code_copy);
			String customer_code_paste = getText(driver, customer_code_copy);
			System.out.println(customer_code_paste);
			Step_End(9,
					"go the import documentation module retrieve the same bl and go to the customer tab --copy the consignee customer code or name",
					test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(10, "click the customer field and put the CN code or name", test, test1);

			waitForElement(driver, customer_search);
			click(driver, customer_search);

			globalValueSearchWindow(driver, BL_Condition, Customer_Code, customer_code_paste, "", "", "", "");

			Step_End(10, "click the customer field and put the CN code or name", test, test1);

			Step_Start(11, "load the same Customer and click on SHow BL button,", test, test1);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

			Step_End(11, "load the same Customer and click on SHow BL button,", test, test1);
		
			if(isdisplayed(driver, popup_Message)) {
				waitForDisplay(driver, popup_Message);
				String act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					jsClick(driver, popup_Message_Ok_Button);
					
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
					if(Charges_Popup.equals(act_Popup)) {
						System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
						Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						jsClick(driver, popup_Message_Ok_Button);
						waitForDisplay(driver, popup_Up_Ok);
						if(isdisplayed(driver, popup_Up_Ok)) {
							waitForElement(driver, popup_Up_Ok);
							jsClick(driver, popup_Up_Ok);
					}
					}
				}
				}
				else if(Charges_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Charges_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					
					if(isdisplayed(driver, Popup_Message)) {
						waitForElement(driver, popup_Up_Ok);
						click(driver, popup_Up_Ok);
				}
					waitForDisplay(driver, popup_Message);
					if(isdisplayed(driver, popup_Message)) {
					 act_Popup=getText(driver, popup_Message);
				if(Part_Lot_BL_Popup.equals(act_Popup)) {
					System.out.println("Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup);
					Extent_pass_New(driver, "Matched ||   Expected Popup " + Part_Lot_BL_Popup + "||  Actual Popup :" + act_Popup, test, test1);
					
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
				}
					}
				}
				
			}
			
		
		
		RemoveBLfromInvoice(driver, BL_Num, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
		
		}
		
		waitForElement(driver, Billing_number_filter);

		waitForElement(driver, Billing_number_filter);
		sendKeys(driver, Billing_number_filter, BL_Num);

		waitForElement(driver, Billing_number_filter_select);
		click(driver, Billing_number_filter_select);

		scrollTop(driver);
		waitForElement(driver, import_invoice_draft_button);
		click(driver, import_invoice_draft_button);
		Step_Start(12, "Click on save Button in Import Invoice,", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click on save Button in Import Invoice,", test, test1);

		waitForPopup(driver, popup_Message, Draft_saved_pop);
		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);
		if (Draft_saved_pop.equals(import_saved_act)) {
			System.out.println(
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + Draft_saved_pop + " || Actual Popup : " + import_saved_act,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, import_invoice_first_row);
		String draftcolouract = getTextBackgroundColor(driver, import_invoice_first_row);
		System.out.println(draftcolouract);

		String draftcolouract1 = getColorName(draftcolouract);
		System.out.println(draftcolouract1);

		System.out.println(draftcolouract1);

		if (Draft_colour.equals(draftcolouract1)) {

			System.out.println("Row colors are changed as expected || Expected colour : " + Draft_colour
					+ " || Actual colour : " + draftcolouract1);
			Extent_pass_New(driver, "Row colors are changed as expected || Expected colour : " + Draft_colour
					+ " || Actual colour : " + draftcolouract1, test, test1);

		} else {
			System.out.println("Row colors are not changed as expected || Expected colour : " + Draft_colour
					+ " || Actual colour : " + draftcolouract1);
			Extent_fail(driver, "Row colors are not changed as expected || Expected colour : " + Draft_colour
					+ " || Actual colour : " + draftcolouract1, test, test1);

		}

		Import_Invoice_Draft_Delete(driver, Import_invoice_delete);
		Extent_completed(testcase_Name, test, test1);

	}

}
