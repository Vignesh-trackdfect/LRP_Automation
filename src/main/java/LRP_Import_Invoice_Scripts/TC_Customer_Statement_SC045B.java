package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Customer_Statement_Report_Locators;

public class TC_Customer_Statement_SC045B extends Keywords {
	public void Customer_Statement_SC045B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Customer_Statement_SC045B";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		
		String customer_Code_Input = Excel_data.get("customer_Code_Input");
		String customer_Code = Excel_data.get("customer_Code");
		String charges_to_add = Excel_data.get("charges_to_add");
		String currencies = Excel_data.get("currencies");
		String base_rate_unit = Excel_data.get("base_rate_unit_data");
		String containers = Excel_data.get("containers_to_add");
		String rates = Excel_data.get("rate_data");
		String quantity = Excel_data.get("quantity_data");
		String remarks_data = Excel_data.get("remarks_data");
		String saved_pop = Excel_data.get("saved_pop");
		String Invoice_Module = Excel_data.get("Invoice_Module");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String customer_Statement_Report_Module = Excel_data.get("customer_Statement_Report_Module");
		String Invoice_type_Input_Select = Excel_data.get("Invoice_type_Input_Select");
		String charge_type_Input_Select = Excel_data.get("charge_type_Input_Select");
		String scope_type_Input_Select = Excel_data.get("scope_type_Input_Select");
		String radio_Button_By_Input = Excel_data.get("radio_Button_By_Input");
		String customer_group_Input = Excel_data.get("customer_group_Input");
		String customer_Search_Filter = Excel_data.get("customer_Search_Filter");
		String Service_Code_Input = Excel_data.get("Service_Code_Input");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Voyage_Code_Input = Excel_data.get("Voyage_Code_Input");
		String port_Code_Input = Excel_data.get("port_Code_Input");
		String customer_name_Search_Filter = Excel_data.get("customer_name_Search_Filter");
		String customer_name_Input = Excel_data.get("customer_name_Input");
		String BL_Search_Filter = Excel_data.get("BL_Search_Filter");
		String date_Picker = Excel_data.get("date_Picker");
		String Input_Select_Radio_Button = Excel_data.get("Input_Select_Radio_Button");
		String checkBox_Aging_Bucket = Excel_data.get("checkBox_Aging_Bucket");
		String checkBox_Summary = Excel_data.get("checkBox_Summary");
		String Table_Headers = Excel_data.get("Table_Headers");
		String no_Record_Popup = Excel_data.get("no_Record_Popup");
		String Charge_Code_Header = Excel_data.get("Charge_Code_Header");
		String Currency_Code_Header = Excel_data.get("Currency_Code_Header");
		String Base_Rate_Unit_Header = Excel_data.get("Base_Rate_Unit_Header");
		String Container_Num_Header = Excel_data.get("Container_Num_Header");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");
		String Part_Lot_BL_Popup = Excel_data.get("Part_Lot_BL_Popup");
		String Charges_Popup = Excel_data.get("Charges_Popup");

		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String GlobalSearch_Type1_Invoice = Excel_data.get("GlobalSearch_Type1_Invoice");
		String GlobalSearch_Value1_Invoice = Excel_data.get("GlobalSearch_Value1_Invoice");
		String GlobalSearch_Type2_Invoice = Excel_data.get("GlobalSearch_Type2_Invoice");
		String GlobalSearch_Value2_Invoice = Excel_data.get("GlobalSearch_Value2_Invoice");
		String GlobalSearch_Type3_Invoice = Excel_data.get("GlobalSearch_Type3_Invoice");
		String GlobalSearch_Value3_Invoice = Excel_data.get("GlobalSearch_Value3_Invoice");
		String Invoice_Already_Exist = Excel_data.get("Invoice_Already_Exist");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");
		String Cust_Statement_Report_StartDate = Excel_data.get("Cust_Statement_Report_StartDate");
		String Cust_Statement_Report_EndDate = Excel_data.get("Cust_Statement_Report_EndDate");
		
		String Invoice_Reverse = Excel_data.get("Invoice_Reverse");
		String Invoice_Reversal_Module = Excel_data.get("Invoice_Reversal_Module");
		String Reversal_Filter_Type = Excel_data.get("Reversal_Filter_Type");
		String Invoice_Reversal_Remark = Excel_data.get("Invoice_Reversal_Remark");
		String Invoice_Reversal_Success = Excel_data.get("Invoice_Reversal_Success");
		
		String Filter_Input_Customer_Report = Excel_data.get("Filter_Input_Customer_Report");

		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "Create Invoice");
		moduleNavigate(driver, Invoice_Module);

		Step_Start(1,
				"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);
		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);
		String invoice_Option = String.format(DropDown_Select, Invoice_Mode_Option);
		waitForElement(driver, invoice_Option);
		click(driver, invoice_Option);

		Step_End(1,
				"Select Agency Corrector Invoice/Cross/Manifest Corrector Invoice/Miscellaneous Invoice/Slot Invoice",
				test, test1);
		Extent_call(test, test1, "If New button Not Available Skip 2nd Step");
		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL") || BL_Retrive_Option.equalsIgnoreCase("By_Book")) {
			// button click
			if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) { 
				waitForElement(driver, By_BL_NumberBtn_All);
				click(driver, By_BL_NumberBtn_All);
			} else {
				waitForElement(driver, By_Book_Button_All);
				click(driver, By_Book_Button_All);
			}
			waitForElement(driver, In_bl_Search_Button);
			click(driver, In_bl_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);
			
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
				
			if (isdisplayed(driver, popup_Message)) {
				String poputext_Act = getText(driver, popup_Message);
				if (poputext_Act.equals(Invoice_Already_Exist)) {
					System.out.println(	"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_FailNew(driver,	"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				} else {
					System.out.println("Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act);
					Extent_fail(driver,"Expected result : No popup message should display || Actual result is : Popup Displayed When load the BL Number : "
									+ poputext_Act,
							test, test1);
				}
			}

			waitForElement(driver, invoice_Customer_Text_Field);
			String customer_Value = getAttribute(driver, Actual_Cust_All, "value");
			if (customer_Value.trim().equals("")) {
				waitForElement(driver, In_customer_Search_Button);
				click(driver, In_customer_Search_Button);

				globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");

				waitForElement(driver, In_Show_BL_Button);
				click(driver, In_Show_BL_Button);
			}
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Vessel")) {
			waitForElement(driver, By_Vessel_Button_All);
			click(driver, By_Vessel_Button_All);
			waitForElement(driver, invoice_Service_Text_Field);
			sendKeys(driver, invoice_Service_Text_Field, Service_Code);

			waitForElement(driver, vessels_code_input);
			sendKeys(driver, vessels_code_input, Vessel_Code);

			waitForElement(driver, voyage_code_input);
			sendKeys(driver, voyage_code_input, Voyage_Number);

			waitForElement(driver, bounnd_code_input);
			sendKeys(driver, bounnd_code_input, Bound_Input);

			waitForElement(driver, POL_PortCode_Input);
			sendKeys(driver, POL_PortCode_Input, Port_Code);

			horizontalscroll(driver, InvoiceGridScroll, 300);
			click(driver, POL_PortTerminal_Input);

			sendKeys(driver, POL_PortTerminal_Input, Terminal_Code);
			waitForElement(driver, service_grid_first_row);
			click(driver, service_grid_first_row);
			waitForElement(driver, service_select_btn);
			click(driver, service_select_btn);

			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Code, customer_Code_Input, "", "", "", "");

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
			
			
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
		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Customer")) {
			waitForElement(driver, In_customer_Search_Button);
			click(driver, In_customer_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_Type1_Invoice, GlobalSearch_Value1_Invoice, GlobalSearch_Type2_Invoice, GlobalSearch_Value2_Invoice, GlobalSearch_Type3_Invoice, GlobalSearch_Value3_Invoice);

			waitForElement(driver, In_Show_BL_Button);
			click(driver, In_Show_BL_Button);
		}


		Extent_call(test, test1, "Common Steps : ");

		Step_Start(1, "Go to charges tab", test, test1);

		//charges_to_add
		if(!charges_to_add.trim().equals("")) {
			waitForElement(driver, invoice_Addtional_Charges_Tab);
			click(driver, invoice_Addtional_Charges_Tab);

			
			waitForDisplay(driver, Additional_Charges_Plus_Button);
			if(isdisplayed(driver, Additional_Charges_Plus_Button)) {
				click(driver,Additional_Charges_Plus_Button);
			}
			
			Step_End(1, "Go to charges tab", test, test1);

			List<String> charges_to_select = splitAndExpand(charges_to_add, "/");
			scrollBottom(driver);
			for (int i = 0; i < charges_to_select.size(); i++) {
				List<String> currency = splitAndExpand(currencies, ",");
				List<String> base_rate_data = splitAndExpand(base_rate_unit, ",");
				List<String> remarks_datas = splitAndExpand(remarks_data, ",");
				List<String> quantity_data = splitAndExpand(quantity, ",");
				List<String> rate = splitAndExpand(rates, ",");
				List<String> container = splitAndExpand(containers, ",");
				String container_add = container.get(i);

				String charges_value = charges_to_select.get(i);
				String currency_data = currency.get(i);
				String base_rate = base_rate_data.get(i);
				String remarks = remarks_datas.get(i);
				String quantity_add = quantity_data.get(i);
				String rate_select = rate.get(i);
				// 2
				Step_Start(2,"Enter the Charge Code Currency, Base Rate, Rate(Rate Can be a Positive /Negative), QTY and Container NO (Optional)",
						test, test1);
				
				if (!charges_value.trim().equals("")) {
					waitForElement(driver, invoice_Charge_Search_Button);
					click(driver, invoice_Charge_Search_Button);
					twoColumnSearchWindow(driver, Charge_Code_Header, Two_Column_Search_Condition, charges_value);
				}
				
				// 3
				if (!currency_data.trim().equals("")) {
					waitForElement(driver, invoice_Currency_Roe_Search_Button);
					click(driver, invoice_Currency_Roe_Search_Button);
					twoColumnSearchWindow(driver, Currency_Code_Header, Two_Column_Search_Condition, currency_data);

				}
				
				// 4
				if (!base_rate.trim().equals("")) {
					waitForElement(driver, invoice_Base_Rate_Search_Button);
					mouseOverToElement(driver, invoice_Base_Rate_Search_Button);
					click(driver, invoice_Base_Rate_Search_Button);
					twoColumnSearchWindow(driver, Base_Rate_Unit_Header, Two_Column_Search_Condition, base_rate);
				}
				
				// 5
				if (!quantity_add.trim().equals("")) {
					waitForElement(driver, invoice_Quantity_Text_Field);
					mouseOverToElement(driver, invoice_Quantity_Text_Field);
					Newclear(driver, invoice_Quantity_Text_Field);
					sendKeys(driver, invoice_Quantity_Text_Field, quantity_add);
				}
				
				// 6
				waitForElement(driver, invoice_Rate_Text_Field);
				click(driver,invoice_Rate_Text_Field);
				waitForElement(driver, invoice_Rate_Text_Field);
				Newclear(driver, invoice_Rate_Text_Field);
				sendKeys(driver, invoice_Rate_Text_Field, rate_select);
				click(driver, invoice_Quantity_Text_Field);
				if (!container_add.trim().equals("")) {
					waitForElement(driver, invoice_Container_Search_Button);
					click(driver, invoice_Container_Search_Button);
					twoColumnSearchWindow(driver, Container_Num_Header, Two_Column_Search_Condition, container_add);
				}

				waitForElement(driver, invoice_Remarks_Text_Field);
				click(driver, invoice_Remarks_Text_Field);
				sendKeys(driver, invoice_Remarks_Text_Field, remarks);
				Step_End(2,
						"Enter the Charge Code Currency, Base Rate, Rate(Rate Can be a Positive /Negative), QTY and Container NO (Optional)",
						test, test1);

				Step_Start(3, "Click on Add Button", test, test1);
				waitForElement(driver, invoice_Addtinal_Charges_Add_Button);
				click(driver, invoice_Addtinal_Charges_Add_Button);
				Step_End(3, "Click on Add Button", test, test1);
			}
		}
		

		Step_Start(4, "Click on Issue Button", test, test1);

		scrollTop(driver);
		waitForElement(driver, import_Invoice_Issued_Button);
		click1(driver, import_Invoice_Issued_Button);

		Step_End(4, "Click on Issue Button", test, test1);

		Step_Start(5, "Click on save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		Step_End(5, "Click on save Button", test, test1);

		Step_Start(6, "Msg 'Invoice saved' then Click on ok", test, test1);

		waitForPopup(driver, popup_Message, saved_pop);

		String import_saved_act = getText(driver, popup_Message);
		System.out.println(import_saved_act);

		if (saved_pop.equals(import_saved_act)) {
			Extent_pass_New(driver,	"Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : " + import_saved_act,
					test, test1);
			System.out.println(	"Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : " + import_saved_act);
		} else {
			System.out.println("Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
					+ import_saved_act);
			Extent_fail(driver, "Not Matched || Expected Draft Popup : " + saved_pop + " || Actual Draft Popup : "
					+ import_saved_act, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(6, "Msg 'Invoice saved' then Click on ok", test, test1);
		waitForElement(driver, Invoice_Table_Header_All);
		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> invoice_Table_Data = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String inv_number = getFirstValueByHeader(invoice_Table_Data, "Inv Number");
		System.out.println("inv_number :" + inv_number);
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");

		String inv_date = getFirstValueByHeader(invoice_Table_Data, "Inv Date");
		System.out.println("inv_date :" + inv_date);

		String inv_amount = getFirstValueByHeader(invoice_Table_Data, "Amount");
		System.out.println("inv_amount :" + inv_amount);

		String inv_cust_Code = getFirstValueByHeader(invoice_Table_Data, "Customer Code");
		System.out.println("inv_cust_Code: " + inv_cust_Code);

		Step_Start(7, "Open the Module", test, test1);
		moduleNavigate(driver, customer_Statement_Report_Module);
		scrollTop(driver);
		Step_End(7, "Open the Module", test, test1);

		newButton(driver);

		Step_Start(8, " Customer can be input using blow option,", test, test1);
		if (!Invoice_type_Input_Select.equals("")) {
			waitForElement(driver, customer_Statement_Invoice_Type_Dropdown);
			click(driver, customer_Statement_Invoice_Type_Dropdown);
			String Invoice_Type_Select = String.format(DropDown_Select, Invoice_type_Input_Select);
			waitForElement(driver, Invoice_Type_Select);
			click(driver, Invoice_Type_Select);
		}

		if (!charge_type_Input_Select.equals("")) {
			waitForElement(driver, customer_statement_Charge_Type_Dropdown);
			click(driver, customer_statement_Charge_Type_Dropdown);
			String charge_Type_Select = String.format(DropDown_Select, charge_type_Input_Select);
			waitForElement(driver, charge_Type_Select);
			click(driver, charge_Type_Select);
		}

		
		if (AgencyUser.trim().equalsIgnoreCase("")) {
			if (!scope_type_Input_Select.equals("")) {
				waitForElement(driver, customer_statement_Scope_Select);
				click(driver, customer_statement_Scope_Select);
				String scope_Type_Select = String.format(DropDown_Select, scope_type_Input_Select);
				waitForElement(driver, scope_Type_Select);
				click(driver, scope_Type_Select);
			}
			
			if(scope_type_Input_Select.equals("Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, AgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);			
			}
			
			if(scope_type_Input_Select.equals("Corporate Agency")) {
				waitForElement(driver, customer_Statement_Report_Scope_Plus_Button);
				click(driver,customer_Statement_Report_Scope_Plus_Button);
				twoColumnSearchWindow(driver, CorporateAgencyCode_Header, Two_Column_Search_Condition, Select_Scope_Value);		
			}
		}
		
		if (radio_Button_By_Input.equalsIgnoreCase("By Group")) {
			String by_Group_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Group_click);
			click(driver, by_Group_click);

			waitForElement(driver, customer_Group_Name_Search_Button);
			click(driver, customer_Group_Name_Search_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_Search_Filter, customer_group_Input, "", "", "", "");

			waitForElement(driver, customer_Group_Plus_button);
			click(driver, customer_Group_Plus_button);
		}

		if (radio_Button_By_Input.equalsIgnoreCase("By Customer")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);

			globalValueSearchWindow(driver, GlobalSearch_Condition, customer_name_Search_Filter, customer_name_Input, "", "", "",
					"");

			waitForElement(driver, customer_Group_Plus_button);
			click(driver, customer_Group_Plus_button);

		}

		if (radio_Button_By_Input.equalsIgnoreCase("By Service")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);

			if (!Service_Code_Input.trim().equals("")) {
				waitForElement(driver, Service_Search_Button);
				click(driver, Service_Search_Button);

				twoColumnSearchWindow(driver, ServiceHeader, Two_Column_Search_Condition, Service_Code_Input);
			}

			if (!Vessel_Code_Input.trim().equals("")) {
				waitForElement(driver, Vessel_Search_Button);
				click(driver, Vessel_Search_Button);

				twoColumnSearchWindow(driver, VesselHeader, Two_Column_Search_Condition, Vessel_Code_Input);
			}

			if (!Voyage_Code_Input.trim().equals("")) {
				waitForElement(driver, Voyage_Search_Button);
				click(driver, Voyage_Search_Button);
				twoColumnSearchWindow(driver, Voyage_Header, Two_Column_Search_Condition, Voyage_Code_Input);
			}

			if (!port_Code_Input.trim().equals("")) {
				waitForElement(driver, port_Search_Button);
				click(driver, port_Search_Button);
				twoColumnSearchWindow(driver, PortHeader, Two_Column_Search_Condition, port_Code_Input);
			}
		}

		if (radio_Button_By_Input.equalsIgnoreCase("By BL")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);
			waitForElement(driver, BL_Plus_Button);
			click(driver, BL_Plus_Button);

			globalValueSearchWindow(driver, GlobalSearch_Condition, BL_Search_Filter, BL_Number_input, "", "", "", "");

		}

		if (radio_Button_By_Input.equalsIgnoreCase("By Date")) {
			String by_Customer_click = String.format(customer_Statement_Radio_Button, radio_Button_By_Input);
			waitForElement(driver, by_Customer_click);
			click(driver, by_Customer_click);
		}


		String From_date=beforeDaysToDate(inv_date, Cust_Statement_Report_StartDate);
		String To_date=addDaysToDate(inv_date, Cust_Statement_Report_EndDate);
		
		if (!From_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_From_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_From_Date, From_date);
			} else {
				waitForElement(driver, customer_Statement_From_Date);
				clearAndType(driver, customer_Statement_From_Date, From_date);
			}
		}

		if (!To_date.trim().equals("")) {
			waitForElement(driver, customer_Statement_To_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, customer_Statement_To_Date, To_date);
			} else {
				waitForElement(driver, customer_Statement_To_Date);
				clearAndType(driver, customer_Statement_To_Date, To_date);
			}
		}
		
		
		String input_Radio_Btn = String.format(input_Selection_Radio_Button, Input_Select_Radio_Button);
		waitForElement(driver, input_Radio_Btn);
		click(driver, input_Radio_Btn);

		checkBox(driver, Aging_Bucket_CheckBox, checkBox_Aging_Bucket);
		checkBox(driver, summary_CheckBox, checkBox_Summary);

		Step_End(8, " Customer can be input using blow option,", test, test1);

		Step_Start(9, "Click on show button,", test, test1);
		waitForElement(driver, customer_Statement_show_Button);
		click(driver, customer_Statement_show_Button);

		if (isdisplayed(driver, popup)) {
			String act_Popup = getText(driver, popup);
			if (no_Record_Popup.equals(act_Popup)) {
				System.out.println("Expected result : No popup message should display || Actual result is : "
						+ act_Popup + " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.");
				Extent_FailNew(driver,
						"Expected result : No popup message should display || Actual result is : " + act_Popup
								+ " Pop-up is Displayed. The Inputs Are Not Valid. Kindly provide valid inputs.",
						test, test1);
			}
		} else {
			Step_End(9, "Click on show button,", test, test1);

			waitForElement(driver, customer_statement_Table);

			waitForElement(driver, Tool_Pannel_CSR);
			click(driver,Tool_Pannel_CSR);
			
			waitForElement(driver, Customer_Statement_Report_Locators.FilterOption_Menu);
			click(driver,Customer_Statement_Report_Locators.FilterOption_Menu);
			
			waitForElement(driver, AG_Grid_Columns_CSR);
			safeclick(driver, AG_Grid_Columns_CSR);
			waitForElement(driver, AG_Headers_Filter_Input_CSR);
			safeclick(driver, SelectAll_CheckBox_CSR);
			List<String> columns = splitAndExpand(Table_Headers);
			for (String column : columns) {
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				Newclear(driver, AG_Headers_Filter_Input_CSR);
				waitForElement(driver, AG_Headers_Filter_Input_CSR);
				sendKeys(driver, AG_Headers_Filter_Input_CSR, column);
				waitForDisplay(driver, SelectAll_CheckBox_CSR);
				safeclick(driver, SelectAll_CheckBox_CSR);
			}
			waitForElement(driver, AG_Grid_Columns_CSR);
			click(driver, AG_Grid_Columns_CSR);
			
			AG_Grid_FilterInputs(driver,Filter_Input_Customer_Report,inv_number);

			Step_Start(10, "If Invoice is Created Verify Customer Code, Name, Invoice Amount, INvoice NO.", test,
					test1);
			waitForElement(driver, customer_statement_Table);
			List<Map<String, String>> customer_statement_TableData = extractTableDataByColumn(driver,
					customer_statement_Table);

			String customer_code = getFirstValueByHeader(customer_statement_TableData, "Customer Code");
			System.out.println("customer_code" + customer_code);

			String customer_name = getFirstValueByHeader(customer_statement_TableData, "Customer Name");
			System.out.println("customer_name" + customer_name);


			String invoice_Amount = getFirstValueByHeader(customer_statement_TableData, "Invoice Amount");
			System.out.println("invoice_Amount" + invoice_Amount);


			if (inv_cust_Code.equals(customer_code)) {
				System.out.println("Matched || The Excpected Customer Code is : " + inv_cust_Code
						+ " || The Actual Customer Code Value From the Customer Statement Report is Table is : "
						+ customer_code);
				Extent_pass_New(driver,
						"Matched || The Excpected Customer Code is : " + inv_cust_Code
								+ " || The Actual Customer Code Value From the Customer Statement Report is Table is : "
								+ customer_code,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Customer Code is : " + inv_cust_Code
						+ " || The Actual Customer Code Value From the Customer Statement Report is Table is : "
						+ customer_code);
				Extent_fail(driver,
						"Not Matched || The Excpected Customer Code is : " + inv_cust_Code
								+ " || The Actual Customer Code Value From the Customer Statement Report is Table is : "
								+ customer_code,
						test, test1);
			}

			double expAmount=getNumberValue(inv_amount);
			double ActAmount=getNumberValue(invoice_Amount);
			
			if (expAmount==ActAmount) {
				System.out.println("Matched || The Excpected Invoice amount is : " + inv_amount
						+ " || The Actual Invoice amount Value From the Customer Statement Report is Table is : "
						+ invoice_Amount);
				Extent_pass_New(driver, "Matched || The Excpected Invoice amount is : " + inv_amount
						+ " || The Actual Invoice amount Value From the Customer Statement Report is Table is : "
						+ invoice_Amount, test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice amount is : " + inv_amount
						+ " || The Actual Invoice amount Value From the Customer Statement Report is Table is : "
						+ invoice_Amount);
				Extent_fail(driver, "Not Matched || The Excpected Invoice amount is : " + inv_amount
						+ " || The Actual Invoice amount Value From the Customer Statement Report is Table is : "
						+ invoice_Amount, test, test1);
			}
			
			String invoice_Num="";
			String invoice_date="";
			if(Filter_Input_Customer_Report.equals("Invoice No")) {
				invoice_Num = getFirstValueByHeader(customer_statement_TableData, "Invoice No");
				invoice_date = getFirstValueByHeader(customer_statement_TableData, "Invoice Date");
			}else {
				invoice_Num = getFirstValueByHeader(customer_statement_TableData, "Transaction No");
				invoice_date = getFirstValueByHeader(customer_statement_TableData, "Transaction Date");
			}
			
			System.out.println("invoice_Num" + invoice_Num);
			System.out.println("invoice_date" + invoice_date);
			
			if (inv_number.equals(invoice_Num)) {
				System.out.println("Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Customer Statement Report is Table is : "
						+ invoice_Num);
				Extent_pass_New(driver, "Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Customer Statement Report is Table is : "
						+ invoice_Num, test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Customer Statement Report is Table is : "
						+ invoice_Num);
				Extent_fail(driver, "Not Matched || The Excpected Invoice Number is : " + inv_number
						+ " || The Actual Invoice Number Value From the Customer Statement Report is Table is : "
						+ invoice_Num, test, test1);
			}
			
			if (inv_date.equals(invoice_date)) {
				System.out.println("Matched || The Excpected Invoice Date is : " + inv_date
						+ " || The Actual Invoice Date Value From the Customer Statement Report is Table is : "
						+ invoice_date);
				Extent_pass_New(driver,
						"Matched || The Excpected Invoice Date is : " + inv_date
								+ " || The Actual Invoice Date Value From the Customer Statement Report is Table is : "
								+ invoice_date,
						test, test1);
			} else {
				System.out.println("Not Matched || The Excpected Invoice Date is : " + inv_date
						+ " || The Actual Invoice Date Value From the Customer Statement Report is Table is : "
						+ invoice_date);
				Extent_fail(driver,
						"Not Matched || The Excpected Invoice Date is : " + inv_date
								+ " || The Actual Invoice Date Value From the Customer Statement Report is Table is : "
								+ invoice_date,
						test, test1);
			}
			Step_End(10, "If Invoice is Created Verify Customer Code, Name, Invoice Amount, INvoice NO.", test, test1);
		}
		
		if(Invoice_Reverse.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, "Delete / Reverse Invoice - Start");
			Invoice_Reversal(driver,Invoice_Reversal_Module,GlobalSearch_Condition,Reversal_Filter_Type,inv_number,Invoice_Reversal_Remark,Invoice_Reversal_Success);
			Extent_cal(test, test1, "Delete / Reverse Invoice - End");
		}
		
		Extent_completed(testcase_Name, test, test1);

	}
}
