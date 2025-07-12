package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC007C extends Keywords {

	public void Import_Invoice_SC007C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC007C";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Draft_colour = Excel_data.get("Draft_colour");
		String Issued_colour = Excel_data.get("Issued_colour");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Issue_updated = Excel_data.get("Issue_updated");
		String Select_option = Excel_data.get("Select_option");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String POD_Port = Excel_data.get("POD Port");
		String Customer_Code = Excel_data.get("Customer_Code");
		String customer_code_select = Excel_data.get("customer_code_select");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String Sys_Code = Excel_data.get("Sys_Code");
		String reverse_Option = Excel_data.get("reverse_Option"); 
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");
		String Call_ID = Excel_data.get("Call_ID");

		
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "switch to import agency ", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency ", test, test1);

		Step_Start(2, "open the import invoice module.", test, test1);

		moduleNavigate(driver, Field_Names);

		Step_End(2, "open the import invoice module.", test, test1);
	
			Step_Start(3, "click the new button", test, test1);

			newButton(driver);

			Step_End(3, "click the new button", test, test1);

			if (Select_option.equals("By BL Number")) {

				Step_Start(4, "retrive the bl in bl number search field ", test, test1);

				waitForElement(driver, import_invoice_bl_search);
				click(driver, import_invoice_bl_search);
				Step_End(4, "retrive the bl in bl number search field ", test, test1);

				Step_Start(5, "search  and select the bl no ", test, test1);

				globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Number_input, "", "", "", "");
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
				
				
					
				waitForElement(driver, Amount_header);

				Step_End(5, "search  and select the bl no ", test, test1);

				Step_Start(6, "bl details and charges  has to be shown in below tab for that bl no ", test, test1);

				waitForElement(driver, import_invoice_bl);

				String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");

				if (BL_Number_input.equals(BL_Numberact)) {
					System.out.println("BL Details are shown for selected BL No || Expected  BL_Number : "
							+ BL_Number_input + " || Actual BL_Number : " + BL_Numberact);

					Extent_pass_New(driver, "BL Details are shown for selected BL No || Expected BL_Number : "
							+ BL_Number_input + " || Actual BL_Number : " + BL_Numberact, test, test1);

				} else {
					System.out.println("BL Details are not shown for selected BL No || Expected BL_Number : "
							+ BL_Number_input + " || Actual BL_Number : " + BL_Numberact);
					Extent_fail(driver, "BL Details are not shown for selected BL No || Expected BL_Number : "
							+ BL_Number_input + " || Actual BL_Number : " + BL_Numberact, test, test1);

				}

			} else if (Select_option.equals("By Vessel")) {

				Step_Start(4, "retrive the bl by Vessel search field", test, test1);

				String SelectOption = String.format(SelectTab, Select_option);

				waitForElement(driver, SelectOption);
				click(driver, SelectOption);

				waitForElement(driver, service_text);
				click(driver, service_text);
				sendKeys(driver, service_text, Service);

				waitForElement(driver, Service_code);
				sendKeys(driver, Service_code, Service);

				waitForElement(driver, Vessel_code);
				sendKeys(driver, Vessel_code, Vessel);

				waitForElement(driver, Voyage_input);
				sendKeys(driver, Voyage_input, Voyage);

				scrollUsingElement(driver, POD_input);

				waitForElement(driver, II_Bound_input);
				sendKeys(driver, II_Bound_input, Bound);

				waitForElement(driver, POD_input);
				sendKeys(driver, POD_input, POD_Port);
				
				horizontalscroll(driver, By_Vessel_Scroll, 500);  if(!Terminal_Code_Input.equals("")) {
				horizontalscroll(driver, By_Vessel_Scroll, 500);
				sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
				}
				
				if(!Call_ID.equals("")) {
				waitForElement(driver, By_Vessel_Call_Id);
				sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}

				Step_End(4, "retrive the bl by Vessel search field", test, test1);

				Step_Start(5, "search  and select the bl no ", test, test1);

				waitForElement(driver, Select_button);
				click(driver, Select_button);

				waitForElement(driver, customer_Search_Icon);
				click(driver, customer_Search_Icon);

				globalValueSearchWindow1(driver, BL_Condition, Customer_Code, customer_code_select, "", "", "", "");

				waitForElement(driver, SystemCode_FilterInput);
				sendKeys(driver, SystemCode_FilterInput, Sys_Code);
				waitForElement(driver, retrivedGlobalValue);
				click(driver, retrivedGlobalValue);
				waitForElement(driver, SelectButton);
				click(driver, SelectButton);

				waitForElement(driver, BL_Show_click);
				click(driver, BL_Show_click);

				Step_End(5, "search  and select the bl no ", test, test1);

				Step_Start(6, "bl details and charges has to be shown in below tab for that bl no", test, test1);
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
					
				
				RemoveBLfromInvoice(driver, BL_Number_input, BL_Details_Tab_IN, BL_details_Tab_Row, BL_Details_Table_Row, BL_Details_BL_Select);
				
				waitForElement(driver, BLDetails_BLNumber);
				BL_Number_input = getText(driver, BLDetails_BLNumber);

				scrollTop(driver);

			}

			if (verifyElementHasText(driver, Import_Invoice_BL_Details_Table_Row)) {

				System.out.println(
						"Pass || Expected : After click on show BL button, BL details should show in the BL details tab || Actual : After click on show BL button, BL details are showing the BL details tab");
				Extent_pass_New(driver,
						"Pass || Expected : After click on show BL button, BL details should show in the BL details tab || Actual : After click on show BL button, BL details are showing the BL details tab",
						test, test1);

			} else {
				System.out.println(
						"Fail || Expected : After click on show BL button, BL details should show in the BL details tab || Actual : After click on show BL button, BL details are not showing the BL details tab");
				Extent_fail(driver,
						"Fail || Expected : After click on show BL button, BL details should show in the BL details tab || Actual : After click on show BL button, BL details are not showing the BL details tab",
						test, test1);
			}

			Step_End(6, "bl details and charges has to be shown in below tab for that bl no", test, test1);

			Step_Start(7, "in tool bar save button has enable  ", test, test1);

			waitForElement(driver, import_invoice_draft_button);
			click(driver, import_invoice_draft_button);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(7, "in tool bar save button has enable  ", test, test1);

			waitForPopup(driver, popup_Message, Draft_saved_pop);
			String import_saved_act = getText(driver, popup_Message);
			System.out.println(import_saved_act);

			Step_Start(8, "click the save button -system has validate --import invoice is saved ", test, test1);

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
			Step_End(8, "click the save button -system has validate --import invoice is saved ", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_Start(9, "above rows showing yellow color", test, test1);

			waitForElement(driver, import_invoice_first_row);
			String get_color = getTextBackgroundColor(driver, import_invoice_first_row);

			String draftcolouract = getColorName(get_color);
			System.out.println(draftcolouract);

			if (Draft_colour.equalsIgnoreCase(draftcolouract)) {

				Extent_pass_New(driver, "Row colors are changed as expected || Expected colour : " + Draft_colour
						+ " || Actual colour : " + draftcolouract, test, test1);
				System.out.println("Row colors are changed as expected || Expected colour : " + Draft_colour
						+ " || Actual colour : " + draftcolouract);

			} else {
				System.out.println("Row colors are not changed as expected || Expected colour : " + Draft_colour
						+ " || Actual colour : " + draftcolouract);
				Extent_fail(driver, "Row colors are not changed as expected || Expected colour : " + Draft_colour
						+ " || Actual colour : " + draftcolouract, test, test1);

			}

			Step_End(9, "above rows showing yellow color", test, test1);

			Step_Start(10, "Click on Edit Button", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(10, "Click on Edit Button", test, test1);

			Step_Start(11, "Click on Issue Button", test, test1);

			waitForElement(driver, import_Invoice_Issued_Button);
			click(driver, import_Invoice_Issued_Button);

			Step_End(11, "Click on Issue Button", test, test1);

			Step_Start(12, "Click on Save Button", test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Issue_updated);
			String import_saved_act2 = getText(driver, popup_Message);
			System.out.println(import_saved_act2);

			if (Issue_updated.equals(import_saved_act2)) {
				System.out.println(
						"Matched || Expected Popup : " + Issue_updated + " || Actual Popup : " + import_saved_act2);
				Extent_pass_New(driver,
						"Matched || Expected Popup : " + Issue_updated + " || Actual Popup : " + import_saved_act2,
						test, test1);

			} else {
				System.out.println(
						"Not Matched || Expected Popup : " + Issue_updated + " || Actual Popup : " + import_saved_act2);

				Extent_fail(driver,
						"Not Matched || Expected Popup : " + Issue_updated + " || Actual Popup : " + import_saved_act2,
						test, test1);

			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(12, "Click on Save Button", test, test1);

			Step_Start(13, "above rows showing Green Color", test, test1);

			waitForElement(driver, import_invoice_first_row);
			String get_color1 = getTextBackgroundColor(driver, import_invoice_first_row);

			String Issue_color = getColorName(get_color1);
			System.out.println(Issue_color);

			if (Issued_colour.equalsIgnoreCase(Issue_color)) {

				Extent_pass_New(driver, "Row colors are changed as expected || Expected colour : " + Issued_colour
						+ " || Actual colour : " + Issue_color, test, test1);
				System.out.println("Row colors are changed as expected || Expected colour : " + Issued_colour
						+ " || Actual colour : " + Issue_color);

			} else {
				System.out.println("Row colors are not changed as expected || Expected colour : " + Issued_colour
						+ " || Actual colour : " + Issue_color);
				Extent_fail(driver, "Row colors are not changed as expected || Expected colour : " + Issued_colour
						+ " || Actual colour : " + Issue_color, test, test1);

			}

			Step_End(13, "above rows showing Green Color", test, test1);

			 if(reverse_Option.equalsIgnoreCase("Yes")) {
	            	Invoice_Reversal(driver, InvoiceReversal_Module, BL_Condition, search_Type_Invoice_Reversal, BL_Number_input, invoiceReversalRemarks, invoiceReversedPopup);

			 }
		
				Extent_pass_New(driver, "Expected -Import invoice is in reversal status  ||   Actual : Import invoice is in reversal status", test, test1);

		
		Extent_completed(testcase_Name, test, test1);
		
		
		
		
		
		
		
		
	}

}
