package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC001 extends Keywords {

	public void Import_Invoice_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC001";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition"); 
		String No_records_pop = Excel_data.get("No_records_pop");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Customer_Code = Excel_data.get("Customer_Code");
		String customer_code_select = Excel_data.get("customer_code_select");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String POD_Port = Excel_data.get("POD Port");
		String Select_option = Excel_data.get("Select_option");
		String Charges_Popup = Excel_data.get("Charges_Popup");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Call_ID = Excel_data.get("Call_ID");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");

		Extent_Start(testcase_Name, test, test1);

		Step_Start(1, "opent the application", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_End(1, "open the application", test, test1);

		Step_Start(2, "open the import invoice module", test, test1);

		moduleNavigate(driver, Field_Names);

		Step_End(2, "open the import invoice module", test, test1);

		Step_Start(3, "click on new button", test, test1);

		newButton(driver);

		Step_End(3, "click on new button", test, test1);

		Step_Start(4, "click on bl number search field", test, test1);

		waitForElement(driver, import_invoice_bl_search);
		click(driver, import_invoice_bl_search);
		
		Step_End(4, "click on bl number search field", test, test1);

		globalValueSearchWindow1(driver, BL_Condition, Select_search_value, BL_Number_input, "", "", "", "");

		Step_Start(7, "system has validate---no records found. ", test, test1);

		waitForPopup(driver, Popup_Message, No_records_pop);

		String norecordsPopupact = getText(driver, Popup_Message);

		if (No_records_pop.equals(norecordsPopupact)) {

			Extent_pass_New(driver,
					"Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact, test,
					test1);
			System.out.println(
					"Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact);
			Extent_fail(driver,
					"Not Matched || Expected Popup : " + No_records_pop + " || Actual Popup : " + norecordsPopupact,
					test, test1);

		}

		Step_End(7, "system has validate---no records found. ", test, test1);

		waitForElement(driver, globalSearchCloseIcon_L);
		click(driver, globalSearchCloseIcon_L);

		Step_Start(8, "switch to import agency ", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(8, "switch to import agency ", test, test1);

		Step_Start(9, "Open import invoice Module", test, test1);

		moduleNavigate(driver, Field_Names);

		Step_End(9, "Open import invoice Module", test, test1);

		Step_Start(10, "Click on New Button", test, test1);

		newButton(driver);

		Step_End(10, "Click on New Button", test, test1);

		if (Select_option.equals("By BL Number")) {

			Step_Start(11, "Click on BL number search field", test, test1);

			waitForElement(driver, import_invoice_bl_search);
			click(driver, import_invoice_bl_search);

			globalValueSearchWindow(driver, BL_Condition, Select_search_value, BL_Number_input, "", "", "", "");
			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
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
			waitForElement(driver, import_invoice_bl);
			String BL_Numberact = getAttribute(driver, import_invoice_bl, "value");
			System.out.println(BL_Numberact);
			if (BL_Number_input.equals(BL_Numberact)) {

				Extent_pass_New(driver, "Matched || Expected BL_Number : " + BL_Number_input + " || Actual   BL_Number: "
						+ BL_Numberact, test, test1);
				System.out.println("Matched || Expected BL_Number: " + BL_Number_input + " || Actual   BL_Number: "
						+ BL_Numberact);

			} else {
				System.out.println("Not Matched || Expected  BL_Number : " + BL_Number_input + " || Actual  BL_Number: "
						+ BL_Numberact);
				Extent_fail(driver, "Not Matched || Expected  BL_Number : " + BL_Number_input
						+ " || Actual  BL_Number : " + BL_Numberact, test, test1);

			}

			if (isdisplayed(driver, Import_Invoice_BL_Details_Table_Row)) {

				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab");
				Extent_pass_New(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab",
						test, test1);

			} else {
				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab");
				Extent_fail(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab",
						test, test1);
			}

			Step_End(18, "System has be shown the details for that bl no", test, test1);

		} else if (Select_option.equals("By Vessel")) {

			Step_Start(11, "Select Vessel option", test, test1);

			String SelectOption = String.format(SelectTab, Select_option);

			waitForElement(driver, SelectOption);
			click(driver, SelectOption);

			Step_End(11, "Select Vessel option", test, test1);

			Step_Start(15, "Enter the Service, vessel, voyage, bound, Port (From Test Data)", test, test1);


			waitForElement(driver, Service_Code_Input_All);
			click(driver, Service_Code_Input_All);
			sendKeys(driver, Service_Code_Input_All, Service);

			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel);
			
			
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

			waitForElement(driver, Select_button);
			click(driver, Select_button);

			Step_End(15, "Enter the Service, vessel, voyage, bound, Port (From Test Data)", test, test1);

			Step_Start(16, " Enter the customer code (From Test Data)", test, test1);

			waitForElement(driver, customer_Search_Icon);
			click(driver, customer_Search_Icon);

			globalValueSearchWindow(driver, BL_Condition, Customer_Code, customer_code_select, "", "", "", "");

			Step_End(16, "Enter the customer code (From Test Data)", test, test1);

			Step_Start(17, "Click on show BL button", test, test1);

			waitForElement(driver, BL_Show_click);
			click(driver, BL_Show_click);

			Step_End(17, "Click on show BL button", test, test1);
			
			
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

			Step_Start(18, "System has be shown the details for that bl no", test, test1);

			waitForElement(driver, Import_Invoice_BL_Details_Table_Row);

			if (verifyElementHasText(driver, Import_Invoice_BL_Details_Table_Row)) {

				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab");
				Extent_pass_New(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are showing the BL details tab",
						test, test1);

			} else {
				System.out.println(
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab");
				Extent_fail(driver,
						"Expected result is : After click on show BL button, BL details should show the BL details tab || Actual result is : After click on show BL button, BL details are not showing the BL details tab",
						test, test1);
			}

			Step_End(18, "System has be shown the details for that bl no", test, test1);
			
			
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
			
		}
		Extent_completed(testcase_Name, test, test1);

	}
}
