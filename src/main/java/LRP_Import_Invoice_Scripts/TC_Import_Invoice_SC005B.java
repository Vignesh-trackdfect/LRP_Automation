package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC005B  extends Keywords{
	
	
	public void Import_Invoice_SC005B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC005B";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names"); 
		String BL_Condition = Excel_data.get("BL_Condition");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Import_Doc_BL_Retrive_Option = Excel_data.get("Import_Doc_BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String BL_Num = Excel_data.get("BL_Num");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal_Code_Input");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Draft_saved_pop = Excel_data.get("Draft_saved_pop");
		String service_input = Excel_data.get("service_input");
		String vesselss_code_input = Excel_data.get("vesselss_code_input");
		String voyagee_code_input = Excel_data.get("voyagee_code_input");
		String Bound_code_input = Excel_data.get("Bound_code_input");
		String Customer_Code = Excel_data.get("Customer_Code");
		String customer_code_select = Excel_data.get("customer_code_select");
		String Import_invoice_delete = Excel_data.get("Import_invoice_delete");
		String pol_Value1 = Excel_data.get("POL_HEADER");
		String BL_Number = Excel_data.get("BL_Number");
		String BL_SearchOption = Excel_data.get("BL_SearchOption");
		String BL_Retrive_from_Import_invoice = Excel_data.get("BL_Retrive_from_Import_invoice");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Call_ID = Excel_data.get("Call_ID");

		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);

		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "open the import documentation module", test, test1);
		Step_Start(3, "retrieve the bl in tool bar -bl has saved in import documentation", test, test1);

		if (Import_Doc_BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			Extent_call(test, test1, "Import Documentation retrived by BL");
			waitForDisplay(driver, NewButton_ToolBar);
			if (isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);

				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);

				String NewImportDocumentation = getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation, test, test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup
							+ " || Actual value was : " + NewImportDocumentation, test, test1);
				}
			}
			waitForDisplay(driver, cancel_Common_btn);
			if (isClickable(driver, cancel_Common_btn)) {
				click(driver, cancel_Common_btn);
			}
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);


			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, "", "", "", "");


		} else if (Import_Doc_BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			Extent_call(test, test1, "Import Documentation retrived by Service");
			waitForDisplay(driver, NewButton_ToolBar);
			if (isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {

					waitForPopup(driver, popup_Message, NewImportDocumentationPopup);

					String NewImportDocumentation = getText(driver, popup_Message).trim();
					if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
						System.out.println("Matched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation);
						Extent_pass_New(driver, "Matched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation, test, test1);
						safeclick(driver, popup_Message_Yes_Button);
					} else {
						System.out.println("NotMatched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation);
						Extent_fail(driver, "NotMatched || Expected value was : " + NewImportDocumentationPopup
								+ " || Actual value was : " + NewImportDocumentation, test, test1);
					}
				}
			}
			waitForElement(driver, ID_servicename);
			sendKeys(driver, ID_servicename, Service);

			if (!Vessel.equals("")) {
				waitForElement(driver, ID_grid_vesselcode);
				sendKeys(driver, ID_grid_vesselcode, Vessel);
			}
			if (!Voyage.equals("")) {
				sendKeys(driver, ID_grid_voyagecode, Voyage);
			}
			if (!Bound.equals("")) {
				sendKeys(driver, ID_grid_bound, Bound);
			}
			if (!Port.equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				sendKeys(driver, ID_grid_portcode, Port);
			}
			if (!Terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver, ID_grid_terminal);
				sendKeys(driver, ID_grid_terminal, Terminal);
			}

			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			click(driver, ID_grid_selectbtn);

			if (!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, pol_Value1, Condition_Filter, pol_Value);
			}

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);
			click(driver, Show_BL_Button);

		
			waitForElement(driver, BlNoSearchButton);
			click(driver, BlNoSearchButton);

			twoColumnSearchWindow(driver, BL_Number, Condition_Filter, BL_Num);

		}
		
		waitForElement(driver, importInvoice_Button);
		if(isElementEnabled(driver, importInvoice_Button)) {
			System.out.println("Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is Enabled");
			Extent_pass_New(driver, "Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is not Enabled");
             Extent_fail(driver, "Expected Result is : Import Invoice Button Should be Enabled || Actual Result is : Import Invoice Button is not Enabled", test, test1);
		}
		Step_End(3, "retrieve the bl in tool bar -bl has saved in import documentation", test, test1);

		Step_Start(4,
				"Navigate from Import Documentation Verify that same BL Number has to show in import invoice module Save the Import Invoice",
				test, test1);


		Step_End(4,
				"Navigate from Import Documentation Verify that same BL Number has to show in import invoice module Save the Import Invoice",
				test, test1);

		Step_Start(5, "Open Import Invoice module Directly and load the BL and Check open the import invoice module",
				test, test1);


			moduleNavigate(driver, Field_Names);
			Step_End(5, "Open Import Invoice module Directly and load the BL and Check open the import invoice module",
					test, test1);

			if (BL_Retrive_from_Import_invoice.equals("By_bl_Number")) {
				Extent_call(test, test1, "Import invoice retrived by BL Number");

				Step_Start(6, "click the new button", test, test1);

				newButton(driver);

				Step_End(6, "click the new button", test, test1);

				Step_Start(7, "retrieve the bl in bl number search field", test, test1);

				Step_Start(8, "search  and select the bl no", test, test1);

				waitForElement(driver, import_invoice_bl_search);
				click(driver, import_invoice_bl_search);
				globalValueSearchWindow(driver, BL_Condition, BL_SearchOption, BL_Num, "", "", "", "");
				
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

				Step_End(7, "retrieve the bl in bl number search field", test, test1);

				Step_Start(9, "Verify that same BL Number has to show in import invoice module ", test, test1);

				waitForElement(driver, import_invoice_bl);

				String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");
				System.out.println(BL_Numberact);

				if (BL_Num.equals(BL_Numberact)) {
					System.out.println("Expected BL Number has shown || Expected BL_Number : " + BL_Num
							+ " || Actual BL_Number : " + BL_Numberact);

					Extent_pass_New(driver, "Expected BL Number has shown || Expected BL_Number : " + BL_Num
							+ " || Actual BL_Number : " + BL_Numberact, test, test1);

				} else {
					System.out.println("Expected BL Number not shown || Expected BL_Number : " + BL_Num
							+ " || Actual BL_Number : " + BL_Numberact);
					Extent_fail(driver, "Expected BL Number not shown || Expected BL_Number : " + BL_Num
							+ " || Actual BL_Number : " + BL_Numberact, test, test1);

				}
			}

			if (BL_Retrive_from_Import_invoice.equals("By_Vessels")) {
				Extent_call(test, test1, "Import invoice retrived by BL Vessels");
				newButton(driver);

				waitForElement(driver, by_vessels_select);
				click(driver, by_vessels_select);
				
				waitForElement(driver, Service_Code_Input_All);
				click(driver, Service_Code_Input_All);
				sendKeys(driver, Service_Code_Input_All, service_input);

				waitForElement(driver, vessels_code_input);
				sendKeys(driver, vessels_code_input, vesselss_code_input);
				
				
				waitForElement(driver, Voyage_input);
				sendKeys(driver, Voyage_input, voyagee_code_input);

				scrollUsingElement(driver, POD_input);

				waitForElement(driver, II_Bound_input);
				sendKeys(driver, II_Bound_input, Bound_code_input);
				
				
				if(!Terminal.equals("")) {
					horizontalscroll(driver, By_Vessel_Scroll, 500);
					sendKeys(driver, By_Vessel_Terminal, Terminal);
				}
					
				if(!Call_ID.equals("")) {
					waitForElement(driver, By_Vessel_Call_Id);
					sendKeys(driver, By_Vessel_Call_Id, Call_ID);
				}
				

				waitForElement(driver, Select_button);
				click(driver, Select_button);

				waitForElement(driver, customer_search);
				click(driver, customer_search);


				globalValueSearchWindow(driver, BL_Condition, Customer_Code, customer_code_select, "", "", "", "");

				waitForElement(driver, BL_Show_click);
				click(driver, BL_Show_click);
			
				
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

		Step_End(9, "Verify that same BL Number has to show in import invoice module Save the Import Invoice", test,
				test1);



		Step_End(15, "System will open the Import Invoice module"
				+ "Verify that same BL Number has to show in import invoice module." + "Save the Import Invoice.", test,
				test1);

		Step_Start(16, "Delete the invoice Steps, has to follow.", test, test1);
		Import_Invoice_Draft_Delete(driver, Import_invoice_delete);
		
		
		Step_End(16, "Delete the invoice Steps, has to follow.", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
