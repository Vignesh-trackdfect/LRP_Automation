package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_046_B extends Keywords {

	public void Detention_Waiver_TS_046_B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_046_B";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String WaiverFor = Excel_data.get("WaiverFor");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String Select_Containers = Excel_data.get("Select_Containers");
		String ContainerNumbers = Excel_data.get("ContainerNumbers");
		String WaiverBy = Excel_data.get("WaiverBy");
		String WaiverByvalue = Excel_data.get("WaiverByvalue");
		String Remark = Excel_data.get("Remark");
		String Approved_Popup = Excel_data.get("Approved_Popup");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");
		String Module_Name = Excel_data.get("Module_Name");
		String IssuedPopup = Excel_data.get("IssuedPopup");
		String DetentionWaiver_Header = Excel_data.get("DetentionWaiver_Header");
		String WaiverNumber_Option = Excel_data.get("WaiverNumber_Option");
		String Error_Popup = Excel_data.get("Error_Popup");
		String Invoice_Mode_Option = Excel_data.get("Invoice_Mode_Option");
		String DetentionChargesTab = Excel_data.get("DetentionChargesTab");
		String reverse_Invoice = Excel_data.get("reverse_Invoice");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String Invoice_Table_Headers = Excel_data.get("ID_Invoice_Table_Headers");
		String WantToCancel = Excel_data.get("WantToCancel");
		String PortStorageChargesTab = Excel_data.get("PortStorageChargesTab");

		String Waiver_number_option = Excel_data.get("Waiver_number_option");
		String DW_Remarks_Input_value = Excel_data.get("DW_Remarks_Input_value");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		moduleNavigate(driver, Detention_Module);

		Step_Start(1, "Click on New Button", test, test1);

		newButton(driver);

		waitForElement(driver, DW_Shipment_Select);
		click(driver, DW_Shipment_Select);

		formatLocatorClick(driver, DW_Shipment_Options, WaiverFor);

		formatLocatorClick(driver, DW_DetentionStorageOption, DetentionStorage_Option);

		Step_End(1, "Click on New Button", test, test1);

		Step_Start(2, "Click on BL No Search Field", test, test1);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		waitForElement(driver, DW_BLNo_Input);
		String Booking_No = getAttribute(driver, DW_BLNo_Input, "value");

		if (Booking_No.equals(BL_Number)) {

			System.out.println(
					"Given Booking number was retrived || Expected : " + BL_Number + " || Actual : " + Booking_No);
			Extent_pass_New(driver,
					"Given Booking number was retrived || Expected : " + BL_Number + " || Actual : " + Booking_No, test,
					test1);

		} else {

			System.out.println(
					"Given Booking number was not retrived || Expected : " + BL_Number + " || Actual : " + Booking_No);
			Extent_fail(driver,
					"Given Booking number was not retrived || Expected : " + BL_Number + " || Actual : " + Booking_No,
					test, test1);
		}

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button", test, test1);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(4, "Click on show Button", test, test1);

		Step_Start(5, "Select the container details, and input the Free time /Lumpsum/Percentage", test, test1);

		scrollElementToView(driver, Detention_container_Filter);
		List<String> ContainersList = new ArrayList<String>();

		if (Select_Containers.equals("Select All")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}
			mouseOverToElement(driver, DW_Select_All_Checkbox);
			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(ContainerNumbers);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);

				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);

				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
			}
			ContainersList.addAll(Containers_Select);
		}

		scrollBottom(driver);


		if (WaiverBy.equalsIgnoreCase("Additional Free Days")) {

			waitForElement(driver, DW_Addition_Days_Input);
			Newclear(driver, DW_Addition_Days_Input);
			Actionsendkeys(driver, DW_Addition_Days_Input, WaiverByvalue);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);
			waitForElement(driver, DW_Waiver_Table_Cell);


		} else if (WaiverBy.equalsIgnoreCase("Waiver Lumpsum")) {

			waitForElement(driver, DW_Lumpsum_radioBtn);
			click(driver, DW_Lumpsum_radioBtn);
			waitForDisplay(driver, DW_Lumpsum_Input);
			if (isElementEnabled(driver, DW_Lumpsum_Input)) {

				waitForElement(driver, DW_Lumpsum_Input);
				Newclear(driver, DW_Lumpsum_Input);
				Actionsendkeys(driver, DW_Lumpsum_Input, WaiverByvalue);
			}
			click(driver, DW_Lumpsum_radioBtn);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

		} else if (WaiverBy.equalsIgnoreCase("Waiver %")) {

			waitForElement(driver, DW_Waiver_percent_RadioBtn);
			click(driver, DW_Waiver_percent_RadioBtn);
			waitForDisplay(driver, DW_Waiver_percent_Input);
			if (isElementEnabled(driver, DW_Waiver_percent_Input)) {
				waitForElement(driver, DW_Waiver_percent_Input);
				Newclear(driver, DW_Waiver_percent_Input);
				Actionsendkeys(driver, DW_Waiver_percent_Input, WaiverByvalue);
			}
			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

		}

		Step_End(5, "SSelect the container details, and input the Free time /Lumpsum/Percentage", test, test1);

		Step_Start(5, "(a) Select Submitt button", test, test1);
		scrollTop(driver);

		waitForElement(driver, DW_Remarks);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		waitForElement(driver, DW_Submitted);
		click(driver, DW_Submitted);

		Step_End(5, "(a) Select Submitt button", test, test1);

		Step_Start(6, "Click on save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click on save Button", test, test1);

		Step_Start(7, "System shown the Validation 'Detention Waiver saved in Submit mode'", test, test1);

		waitForPopup(driver, popup, Submitted_Popup);
		String Submit_popup_Message = getText(driver, popup);

		if (Submit_popup_Message.equals(Submitted_Popup)) {

			System.out.println("Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_pass_New(driver, "Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);

		} else {
			System.out.println("Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_fail(driver, "Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);

		}

		Step_End(7, "System shown the Validation 'Detention Waiver saved in Submit mode'", test, test1);

		Step_Start(8, "Switch to Line", test, test1);

		ResetProfile(driver);

		Step_End(8, "Switch to Line", test, test1);

		Step_Start(9,
				"Open Waiver gate,or detention waiver module and selecte From and Tpo Date as Current Date, and click Show Button",
				test, test1);

		moduleNavigate(driver, Detention_Module);

		waitForElement(driver, last_Common_btn);
		click(driver, last_Common_btn);

		waitForElement(driver, DW_WaiverStatus);
		String Status = getText(driver, DW_WaiverStatus);

		if (Status.contains("Submitted")) {

			System.out.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status);
			Extent_pass_New(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status,
					test, test1);

		} else {

			System.out.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status);
			Extent_fail(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ Status,
					test, test1);

		}

		waitForElement(driver, Edit_Button_toolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		Step_End(9,
				"Open Waiver gate,or detention waiver module and selecte From and Tpo Date as Current Date, and click Show Button",
				test, test1);

		Step_Start(10, "Select the Row and approve the Waiver which is saved lastly", test, test1);

		waitForElement(driver, DW_Approved);
		click(driver, DW_Approved);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup, Approved_Popup);
		String Approved_Popup_Message = getText(driver, popup);

		if (Approved_Popup_Message.equals(Approved_Popup)) {

			System.out.println("Detention Waiver submitted successfully || Expected popup : " + Approved_Popup
					+ " || Actual popup : " + Approved_Popup_Message);
			Extent_pass_New(driver, "Detention Waiver submitted successfully || Expected popup : " + Approved_Popup
					+ " || Actual popup : " + Approved_Popup_Message, test, test1);

		} else {
			System.out.println("Detention Waiver not submitted || Expected popup : " + Approved_Popup
					+ " || Actual popup : " + Approved_Popup_Message);
			Extent_fail(driver, "Detention Waiver not submitted || Expected popup : " + Approved_Popup
					+ " || Actual popup : " + Approved_Popup_Message, test, test1);

		}

		waitForElement(driver, DW_WaiverNo);
		String waiverNumbers=getAttribute(driver, DW_WaiverNo, "value");
		System.out.println("DW_WaiverNo : "+waiverNumbers);
		
		String [] waiverNumber =waiverNumbers.split(" ~~");
		System.out.println("waiverNumber :"+waiverNumber[0]);
		
		Step_End(10, "Select the Row and approve the Waiver which is saved lastly", test, test1);

		Step_Start(11, "Switch To Agency", test, test1);

		SwitchProfile(driver, AgencyName);

		Step_End(11, "Switch To Agency", test, test1);

		Step_Start(12, "Open Export Invoice module", test, test1);

//		Export Invoice

		moduleNavigate(driver, Module_Name);

		Step_End(12, "Open Export Invoice module", test, test1);

		Step_Start(13, "Click on New Button", test, test1);
		waitForDisplay(driver, Invoice_Mode_Input_All);
		if (isdisplayed(driver, Invoice_Mode_Input_All)) {
			waitForElement(driver, Invoice_Mode_Input_All);
			click(driver, Invoice_Mode_Input_All);

			formatLocatorClick(driver, DropDown_Select, Invoice_Mode_Option);
		}
		newButton(driver);

		Step_End(13, "Click on New Button", test, test1);

		Step_Start(14, "load the BL NO", test, test1);

		waitForElement(driver, By_BL_NumberBtn_All);
		click(driver, By_BL_NumberBtn_All);

		waitForElement(driver, In_bl_Search_Button);
		click(driver, In_bl_Search_Button);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		Step_End(14, "load the BL NO", test, test1);

		Step_Start(15, "Go to Container Tab and make sure that Waiver Number is Available", test, test1);

		scrollBottom(driver);

		List<String> WaiverNumbers = new ArrayList<>();

		if(DetentionStorage_Option.equalsIgnoreCase("Detention")) {
			
			String detentionCharges_Tab = String.format(Charges_Tab_ExpInv, DetentionChargesTab);
			waitForElement(driver, detentionCharges_Tab);
			click(driver, detentionCharges_Tab);
			
		waitForElement(driver, detentionCharges_Table_Rows_EXP_INV);

		int scrollLength=60;
		int returnScrollLength=0;
		
		List<Map<String, String>> TabledataFull = getTableDatawithscroll(driver, detentionCharges_Table_Columns_EXP_INV, detentionCharges_Table_Rows_EXP_INV, Detention_Charges_HorizontalScrollBar_EXP, scrollLength, returnScrollLength);

		

		for (Map<String, String> row : TabledataFull) {
			if (row.containsKey(DetentionWaiver_Header)) {
				WaiverNumbers.add(row.get(DetentionWaiver_Header));
			}
		}
	
		}else if(DetentionStorage_Option.equalsIgnoreCase("Storage")) {
			
			String portStorageCharges_Tab = String.format(Charges_Tab_ExpInv, PortStorageChargesTab);
			waitForElement(driver, portStorageCharges_Tab);
			click(driver, portStorageCharges_Tab);
			
			waitForElement(driver, port_Storage_Tab_Rows_EXP);

			int scrollLength=60;
			int returnScrollLength=0;
			List<Map<String, String>> TabledataFull = getTableDatawithscroll(driver, port_Storage_Tab_Columns_EXP, port_Storage_Tab_Rows_EXP, Port_Storage_Charges_HorizontalScrollBar_EXP, scrollLength, returnScrollLength);

			for (Map<String, String> row : TabledataFull) {
				if (row.containsKey(DetentionWaiver_Header)) {
					WaiverNumbers.add(row.get(DetentionWaiver_Header));
				}
			}
			}
		
		if(!WaiverNumbers.isEmpty()) {
			System.out.println("Matched || Expected : Waiver Numbers should be present in the grid || Actual : Waiver Numbers are present in the grid"+" || Waiver numbers present in grid : "+WaiverNumbers);
			Extent_pass_New(driver, "Matched || Expected : Waiver Numbers should be present in the grid || Actual : Waiver Numbers are present in the grid"+" || Waiver numbers present in grid : "+WaiverNumbers, test, test1);
			}else {
				System.out.println("Not Matched || Expected : Waiver Numbers should be present in the grid || Actual : Waiver Numbers are not present in the grid"+" || Waiver numbers present in grid : "+WaiverNumbers);
				Extent_fail(driver, "Not Matched || Expected : Waiver Numbers should be present in the grid || Actual : Waiver Numbers are not present in the grid"+" || Waiver numbers present in grid : "+WaiverNumbers, test, test1);
				}
		
		

		String waiver_Numbers = WaiverNumbers.get(0);
		String Waiver_Numbers_Split[] = waiver_Numbers.split(" ");
		String Waiver_Numbers = Waiver_Numbers_Split[0];
		System.out.println("Waiver_Numbers : "+Waiver_Numbers);

		Step_End(15, "Go to Container Tab and make sure that Waiver Number is Available", test, test1);
		Step_Start(16, "Click on save Button", test, test1);

		scrollTop(driver);

		waitForElement(driver, In_Issued_Button);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, In_Issued_Button);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, IssuedPopup);
		String import_saved_act = getText(driver, popup_Message);

		System.out.println(import_saved_act);

		if (IssuedPopup.equals(import_saved_act)) {
			System.out.println("Matched || Expected Popup : " + IssuedPopup + " || Actual Popup : " + import_saved_act);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + IssuedPopup + " || Actual Popup : " + import_saved_act, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected Popup : " + IssuedPopup + " || Actual Popup : " + import_saved_act);

			Extent_fail(driver,
					"Not Matched || Expected Popup : " + IssuedPopup + " || Actual Popup : " + import_saved_act, test,
					test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		String detentionChargesTab = String.format(Charges_Tab_ExpInv, DetentionChargesTab);
		waitForElement(driver, detentionChargesTab);
		mouseOverToElement(driver, detentionChargesTab);
		waitForElement(driver, detentionChargesTab);
		click(driver, detentionChargesTab);
		
		
//		formatLocatorClick(driver, Charges_Tab_ExpInv, DetentionChargesTab);

		waitForElement(driver, detentionCharges_Table_Rows_EXP_INV);
		List<Map<String, String>> invoice_Tabledata = getTableData(driver, detentionCharges_Table_Columns_EXP_INV,
				detentionCharges_Table_Rows_EXP_INV);

		List<String> columnheaders_Invoice = splitAndExpand(Invoice_Table_Headers);

		List<String> invoiceNumbers = getValuesByHeader(invoice_Tabledata, columnheaders_Invoice.get(0));

		ArrayList<String> inv_Numbers = new ArrayList<String>();
		for (int i = 0; i < invoiceNumbers.size(); i++) {
			inv_Numbers.add(invoiceNumbers.get(i));
		}

		System.out.println("inv_Numbers : " + inv_Numbers);
		String invNumber = invoiceNumbers.get(0);
		System.out.println("invNumber : "+invNumber);
		Step_End(16, "Click on save Button", test, test1);

		Step_Start(17, "Close the Import Invoice and Open Detention Waiver module", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(17, "Close the Import Invoice and Open Detention Waiver module", test, test1);

		Step_Start(18, "Load the Same BL NO", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, BL_Condition, WaiverNumber_Option, waiverNumber[0], "", "", "", "");

		Step_End(18, "Load the Same BL NO", test, test1);

		Step_Start(19, "Click on Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(19, "Click on Edit button", test, test1);

		Step_Start(20, "Capure the Validation And Verify it", test, test1);

		waitForPopup(driver, popup_Message, Error_Popup);
		String actual_popup = getText(driver, popup_Message);

		if (actual_popup.equals(Error_Popup)) {

			System.out.println("User getting expected warning message || Expected popup : " + Error_Popup
					+ " || Actual popup : " + actual_popup);
			Extent_pass_New(driver, "User getting expected warning message || Expected popup : " + Error_Popup
					+ " || Actual popup : " + actual_popup, test, test1);

			click(driver, popup_Message_Ok_Button);
		} else {

			System.out.println("User getting different warning message || Expected popup : " + Error_Popup
					+ " || Actual popup : " + actual_popup);
			Extent_fail(driver, "User getting different warning message || Expected popup : " + Error_Popup
					+ " || Actual popup : " + actual_popup, test, test1);
		}

		Step_End(20, "Capure the Validation And Verify it", test, test1);

		if (reverse_Invoice.equalsIgnoreCase("Yes")) {
			moduleNavigate(driver, InvoiceReversal_Module);

			newButton(driver);

			waitForElement(driver, invoiceNo_SearchButton);
			click(driver, invoiceNo_SearchButton);

			globalValueSearchWindow(driver, BL_Condition, search_Type_Invoice_Reversal, invNumber, "", "", "", "");

			waitForElement(driver, invoiceReversal_Show_Button);
			click(driver, invoiceReversal_Show_Button);

			waitForElement(driver, invoice_Num_Txtfield);
			String invoice_Number = getAttribute(driver, invoice_Num_Txtfield, "value");

			String select_Row = String.format(import_Reversal_Confirmed_Row, invoice_Number);

			waitForElement(driver, select_Row);
			click(driver, select_Row);

			click(driver, invoiceReversal_Remarks_TextArea);
			sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

			click(driver, SaveButton_ToolBar);

			waitForDisplay(driver, popup_Message_Yes_Button);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}

			waitForPopup(driver, popup_Message, invoiceReversedPopup);

			String actualReversedPopup = getText(driver, popup_Message);

			if (actualReversedPopup.equals(invoiceReversedPopup)) {
				Extent_pass_New(driver, "Matched || Expected Reveresed Popup : " + invoiceReversedPopup
						+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
				System.out.println("Matched || Expected Reveresed Popup : " + invoiceReversedPopup
						+ " Actual Reveresed Popup : " + actualReversedPopup);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Reveresed Popup : " + invoiceReversedPopup
						+ " Actual Reveresed Popup : " + actualReversedPopup);
				Extent_fail(driver, "Not Matched || Expected Reveresed Popup : " + invoiceReversedPopup
						+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
			}
		}

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, DW_Waiver_Reference_input);
		String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

		waitForElement(driver, DW_WaiverStatus);
		String waiverstatus = getText(driver, DW_WaiverStatus);

		if (WantToCancel.equalsIgnoreCase("Yes")) {

			Reversewaiver(driver, BL_Condition, Waiver_number_option, waiverValue, DW_Remarks_Input_value, waiverstatus,
					AgencyName, Detention_Module);
			waitForElement(driver, Popup_Message);

		}

		Extent_completed(testcase_Name, test, test1);

	}
}
