package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC064E extends Keywords {

	public void Import_Documentation_SC064E(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC064E";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String NewImportDocumentationPopup=Excel_data.get("NewImportDocumentationPopup");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Import_Document_SavedPopup = Excel_data.get("Import_Document_SavedPopup");
		String Remarks_Tab_Refer_Head = Excel_data.get("Remarks_Tab_Refer_Head");
		
		
		String Import_Invoice_Saved_Popup = Excel_data.get("Import_Invoice_Saved_Popup");
		String Receipt_Module = Excel_data.get("Receipt_Module");
		String Receipt_SelectType = Excel_data.get("Receipt_SelectType");
		String payment_Mode = Excel_data.get("Payment_Mode");
		String number_data = Excel_data.get("number_data");
		String bankname = Excel_data.get("bankname");
		String Search_Bank_Name_Column_Header = Excel_data.get("Search_Bank_Name_Column_Header");
		String Receipt_Saved_Popup = Excel_data.get("Receipt_Saved_Popup");
		String deposit_bank = Excel_data.get("deposit_bank");
		String Deposite_Bank_Name_Column_Header = Excel_data.get("Deposite_Bank_Name_Column_Header");
	
		String Delivery_Order_Module = Excel_data.get("Delivery_Order_Module");
		String Delivery_SelectType = Excel_data.get("Delivery_SelectType");
		String Delivery_Order_Saved_Popup = Excel_data.get("Delivery_Order_Saved_Popup");		
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		
		Step_Start(1, "Open Import Documentation module", test, test1);	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "open the import documentation module", test, test1);
		
		Step_Start(2, "Open Import Documentation module,", test, test1);	

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
				}
			}
			
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

			if(!Vessel.equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.equals("")) {
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
			if(!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
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
			
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, BL_Num);	
		}
		Step_End(2, "Open Import Documentation module,", test, test1);	

		Step_Start(3, "Save the Import Doc,", test, test1);	
		
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_Status_Act=getText(driver, BL_status_IMP_DOC);
		if(BL_Status_Act.equalsIgnoreCase("NEW")) {

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			Step_Start(4, "Capture Save validation", test, test1);
			waitForPopup(driver, popup_Message, Import_Document_SavedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (Import_Document_SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass(driver, "Matched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + Import_Document_SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
			}
			Step_End(4, "Capture Save validation", test, test1);
		}
		Step_End(3, "Save the Import Doc,", test, test1);	

		
		waitForElement(driver, importDoc_RemarksTab);
		click(driver,importDoc_RemarksTab);

		String Module_Check="Delivery Order";
		String CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
		waitForElement(driver, CheckBox_Element);
		String checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
		
		String ImportInvoice_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, "Import Invoice");
		waitForElement(driver, ImportInvoice_Element);
		String ImportInvoiceSelected=getAttribute(driver, ImportInvoice_Element, "class");
		
		if(!ImportInvoiceSelected.contains("active")) {
			Step_Start(5, "Click on Import Invoice Navigation Button, orr open the import invoice module", test, test1);	

			waitForElement(driver, import_Invoice_Btn);
			click(driver,import_Invoice_Btn);
			Step_End(5, "Click on Import Invoice Navigation Button, orr open the import invoice module", test, test1);	

			Step_Start(6, "issued the Import Invoice.", test, test1);	
			waitForElement(driver, import_Invoice_Issued_Button);
			click(driver,import_Invoice_Issued_Button);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Import_Invoice_Saved_Popup);
			String import_saved_act=getText(driver, popup_Message);
			System.out.println(import_saved_act);
			if(Import_Invoice_Saved_Popup.equals(import_saved_act)) {
				System.out.println("Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_pass(driver, "Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : "+Import_Invoice_Saved_Popup+" || Actual Popup : "+import_saved_act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(6, "issued the Import Invoice.", test, test1);	

		}
		
		String Receipt_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, "Receipt");
		waitForElement(driver, Receipt_Element);
		String ReceiptSelected=getAttribute(driver, Receipt_Element, "class");
		
		if(!ReceiptSelected.contains("active")) {
			Step_Start(7, "naviagte to receipt module or open the receipt module.", test, test1);	

			moduleNavigate(driver, Receipt_Module);
			newButton(driver);
			Step_End(7, "naviagte to receipt module or open the receipt module.", test, test1);	

			Step_Start(8, " saved the receipt .", test, test1);	

			waitForElement(driver, Customer_Search_button_Receipt);
			click(driver,Customer_Search_button_Receipt);
			
			globalValueSearchWindow(driver, BL_Condition, Receipt_SelectType, BL_Num, "", "", "", "");

			waitForElement(driver, paymentMode_Dropdown_IMP_DOC);
			click(driver, paymentMode_Dropdown_IMP_DOC);
			String select_Mode=String.format(paymentMode_IMP_DOC, payment_Mode);
			waitForDisplay(driver, select_Mode);
			click(driver, select_Mode);
			waitForElement(driver, number_Txtfield);
			sendKeys(driver, number_Txtfield, number_data);
			waitForElement(driver, bank_Search_Icon);
			click(driver, bank_Search_Icon);
			twoColumnSearchWindow(driver, Search_Bank_Name_Column_Header, Condition_Filter, bankname);
		
			waitForElement(driver, deposit_Bank_Search_Icon);
			click(driver, deposit_Bank_Search_Icon);
			twoColumnSearchWindow(driver, Deposite_Bank_Name_Column_Header, Condition_Filter, deposit_bank);
			
			waitForElement(driver, add_Payment_Details);
			click(driver, add_Payment_Details);
			
			waitForElement(driver, InvoiceAndReceipt_Tab_IMP_Doc);
			click(driver, InvoiceAndReceipt_Tab_IMP_Doc);
			
			waitForElement(driver, SelectAll_CheckBox_Receipt);
			String selectAll=getAttribute(driver, SelectAll_CheckBox_Receipt, "class");
			if(!selectAll.contains("active")) {
				jsClick(driver, SelectAll_CheckBox_Receipt);						
			}
			
			waitForElement(driver, allocate_Button_IMP_DOC);
			click(driver, allocate_Button_IMP_DOC);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Receipt_Saved_Popup);
			String Receipt_saved_act=getText(driver, popup_Message);
			System.out.println(Receipt_saved_act);
			if(Receipt_saved_act.contains(Receipt_Saved_Popup)) {
				System.out.println("Matched || Expected Popup : "+Receipt_Saved_Popup+" || Actual Popup : "+Receipt_saved_act);
				Extent_pass(driver, "Matched || Expected Popup : "+Receipt_Saved_Popup+" || Actual Popup : "+Receipt_saved_act, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+Receipt_Saved_Popup+" || Actual Popup : "+Receipt_saved_act);
				Extent_fail(driver, "Not Matched || Expected Popup : "+Receipt_Saved_Popup+" || Actual Popup : "+Receipt_saved_act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(8, " saved the receipt .", test, test1);	

		}
		
		
		if(!checkboxSelected.contains("active")) {
			Step_Start(9, "open the delivery order module or navigate to the delivery order module in import doc", test, test1);	

			moduleNavigate(driver, Delivery_Order_Module);
			newButton(driver);
			Step_End(9, "open the delivery order module or navigate to the delivery order module in import doc", test, test1);	
			Step_Start(10, "save the delivery order module.", test, test1);	

			waitForElement(driver, Add_button_DeliveryOrder);
			click(driver,Add_button_DeliveryOrder);
			
			globalValueSearchWindow(driver, BL_Condition, Delivery_SelectType, BL_Num, "", "", "", "");

			waitForElement(driver, Show_Button_DeliverOrder);
			click(driver,Show_Button_DeliverOrder);
			
			waitForElement(driver, Select_All_CheckBox_DeliveryOrder);
			String deliveryAllCheck=getAttribute(driver, Select_All_CheckBox_DeliveryOrder, "class");
			if(!deliveryAllCheck.contains("active")) {
				jsClick(driver, Select_All_CheckBox_DeliveryOrder);
			}
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, Popup_Message, Delivery_Order_Saved_Popup);
			String DO_POP_ACT = getText(driver, Popup_Message);
			if (Delivery_Order_Saved_Popup.equals(DO_POP_ACT)) {
				System.out.println("Matched || Expected Popup was : " + Delivery_Order_Saved_Popup + " || Actual Popup was : " + DO_POP_ACT);
				Extent_pass(driver,"Matched || Expected Popup was : " + Delivery_Order_Saved_Popup + " || Actual Popup was : " + DO_POP_ACT, test,test1);
				Extent_call(test, test1, DO_POP_ACT);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + Delivery_Order_Saved_Popup + " || Actual Popup was : " + DO_POP_ACT);
				Extent_fail(driver,"NotMatched || Expected Popup was : " + Delivery_Order_Saved_Popup + " || Actual Popup was : " + DO_POP_ACT,test, test1);
			}
			Step_End(10, "save the delivery order module.", test, test1);	

			Step_Start(11, "print tha delivery order flag (yes or NO )", test, test1);	

			waitForElement(driver, Deliver_Order_No);
			String DeliveryOrder_value=getAttribute(driver, Deliver_Order_No, "value");
			Step_End(11, "print tha delivery order flag (yes or NO )", test, test1);	

			waitForElement(driver, Deliver_Order_Date);
			String DeliveryOrderDate_value=getAttribute(driver, Deliver_Order_Date, "value");
			
			Step_Start(12, "open the import documentation .", test, test1);	

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(12, "open the import documentation .", test, test1);	
			Step_Start(13, "Load the BL no , ", test, test1);	
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			Step_End(13, "Load the BL no , ", test, test1);	
			Step_Start(14, " Go to Remarks tab,import invoice, receipt no and delivery order check box is checked and invoiceno, receipt no and delivery order also showing", test, test1);	

			waitForElement(driver, importDoc_RemarksTab);
			click(driver,importDoc_RemarksTab);
			
			CheckBox_Element=String.format(Remarks_Tab_Checkbox_ImpDoc, Module_Check);
			waitForElement(driver, CheckBox_Element);
			checkboxSelected=getAttribute(driver, CheckBox_Element, "class");
			
			if(checkboxSelected.contains("active")) {
				System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ");
				Extent_pass(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is selected ", test,test1);
			}else {
				System.out.println("Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ");
				Extent_fail(driver, "Expected : "+Module_Check+"  Checkbox Should be selected || Actual : "+Module_Check+" Checkbox is not selected ", test,test1);
			}
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "Delivery Order", "Reference Value");
			String RefDate_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "Delivery Order", "Reference Date");

			if (DeliveryOrder_value.equals(Ref_value_Import)) {
				System.out.println("Matched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import);
				Extent_pass(driver, "Matched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import,
						test, test1);
			}
			
			if (CompareDateValues(DeliveryOrderDate_value,RefDate_Import)) {
				System.out.println("Matched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import);
				Extent_pass(driver, "Matched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import,
						test, test1);
			}
			Step_End(14, " Go to Remarks tab,import invoice, receipt no and delivery order check box is checked and invoiceno, receipt no and delivery order also showing", test, test1);	

		}else {
			Extent_call(test, test1, "Verify that Import Invoice, receipt no  and delivery order Check Box Button is Checked and invoice no, receipt no and delivery orderalso showing");
			
			waitForElement(driver, remarksTab_Table_Row_IMP_DOC);
			List<Map<String, String>>  RemarksTable_Data=getTableData(driver,remarksTab_Table_Header_IMP_DOC,remarksTab_Table_Row_IMP_DOC);

			String Ref_value_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "Delivery Order", "Reference Value");
			String RefDate_Import=getValueByFirstColumnAndHeader(RemarksTable_Data, Remarks_Tab_Refer_Head, "Delivery Order", "Reference Date");

			moduleNavigate(driver, Delivery_Order_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			
			waitForElement(driver, type_Select1);
			selectByText(driver, type_Select1, Delivery_SelectType);
			
			waitForElement(driver, globalSearch_Condition_Dropdown1);
			selectByText(driver, globalSearch_Condition_Dropdown1, BL_Condition);
			waitForElement(driver, globalSearch_InputTextfield1);
			sendKeys(driver, globalSearch_InputTextfield1, BL_Num);
			
			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);

			waitForElement(driver, DeliveryFilter_Input);
			sendKeys(driver, DeliveryFilter_Input, Ref_value_Import);
			
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);		

			waitForElement(driver, Deliver_Order_No);
			String DeliveryOrder_value=getAttribute(driver, Deliver_Order_No, "value");
			
			waitForElement(driver, Deliver_Order_Date);
			String DeliveryOrderDate_value=getAttribute(driver, Deliver_Order_Date, "value");
			
			if (DeliveryOrder_value.equals(Ref_value_Import)) {
				System.out.println("Matched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import);
				Extent_pass(driver, "Matched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + DeliveryOrder_value + " || Actual value was : " + Ref_value_Import,
						test, test1);
			}
			
			if (CompareDateValues(DeliveryOrderDate_value,RefDate_Import)) {
				System.out.println("Matched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import);
				Extent_pass(driver, "Matched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import);
				Extent_fail(driver, "NotMatched || Expected value was : " + DeliveryOrderDate_value + " || Actual value was : " + RefDate_Import,
						test, test1);
			}
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Extent_call(test, test1, "Verify that Import Invoice, receipt no  and delivery order Check Box Button is Checked and invoice no, receipt no and delivery orderalso showing");
		}
		Extent_completed(testcase_Name, test, test1);

	}
}
