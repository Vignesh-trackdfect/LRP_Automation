package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_046_C extends Keywords {

	public void Detention_Waiver_TS_046_C(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		String testcase_Name = "TC_Detention_Waiver_TS_046_C";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String WaiverFor = Excel_data.get("WaiverFor");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String ContainerNumbers = Excel_data.get("ContainerNumbers");
		String WaiverBy = Excel_data.get("WaiverBy");
		String WaiverByvalue = Excel_data.get("WaiverByvalue");
		String Remark = Excel_data.get("Remark");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Waiver_Gate_Module = Excel_data.get("Waiver_Gate_Module");
		String Approved_Popup_WaiverGate = Excel_data.get("Approved_Popup_WaiverGate");
		String Detention_Demurrage_Invoice_Module = Excel_data.get("Detention_Demurrage_Invoice_Module");
		String Corporate_Code = Excel_data.get("Corporate_Code");
		String Corporate_Search_Header = Excel_data.get("Corporate_Search_Header");
		String EMS_From_Date = Excel_data.get("EMS_From_Date");
		String EMS_To_Date = Excel_data.get("EMS_To_Date");
		String Shipment_Det_Dem_Invoice = Excel_data.get("Shipment_Det_Dem_Invoice");
		String ReportType_Det_Dem_Invoice = Excel_data.get("ReportType_Det_Dem_Invoice");
		String Invoice_Details_Columns_Det_Dem_Invoice = Excel_data.get("Invoice_Details_Columns_Det_Dem_Invoice");
		String Detention_Demurrage_Saved_Popup = Excel_data.get("Detention_Demurrage_Saved_Popup");
		String SearchType_WaiverNumer = Excel_data.get("SearchType_WaiverNumer");
		String SearchType_Transaction_No = Excel_data.get("SearchType_Transaction_No");
		String Want_To_Delete_Detention_Demurrage_Popup = Excel_data.get("Want_To_Delete_Detention_Demurrage_Popup");
		String Deleted_Detention_Demurrage_Popup = Excel_data.get("Deleted_Detention_Demurrage_Popup");
		String cannotEdit_Detention_Demurrage_Popup = Excel_data.get("cannotEdit_Detention_Demurrage_Popup");
		String Delete_DAR = Excel_data.get("Delete_DAR");
		String WantToCancel_Waiver = Excel_data.get("WantToCancel_Waiver");

		String DW_Remarks_Input_value = Excel_data.get("DW_Remarks_Input_value");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		moduleNavigate(driver, Detention_Module);

		Step_Start(1, "Click on New Button", test, test1);

		newButton(driver);
		
		Step_End(1, "Click on New Button", test, test1);
		Step_Start(2, "Select the Shipment Type as Export/Import Shipment,", test, test1);

		String Waiveroption = String.format(DW_WaiverOption, WaiverFor);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		
		Step_End(2, "Select the Shipment Type as Export/Import Shipment,", test, test1);

		
		Step_Start(3, "Select the Shipment Type as Export/Import Shipment,", test, test1);
		Step_Start(4, " Click on BL No Search Field ", test, test1);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);


		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		Step_Start(5, "Input your BL No ", test, test1);

		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
		Step_End(3, "Select the Shipment Type as Export/Import Shipment,", test, test1);

	
		Step_End(4, " Click on BL No Search Field ", test, test1);
		Step_End(5, "Input your BL No ", test, test1);
		Step_Start(6, "Click on show Button ", test, test1);
		
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		Step_End(6, "Click on show Button ", test, test1);
		Step_Start(7, "Go to Container section ", test, test1);

		scrollBottom(driver);


		scrollElementToView(driver, Detention_container_Filter);
		Step_End(7, "Go to Container section ", test, test1);
		Step_Start(8, "Click select all check box inContainer Section,", test, test1);

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}
			mouseOverToElement(driver, DW_Select_All_Checkbox);
			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(ContainerNumbers);
			for (String container : Containers_Select) {

				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			}
			ContainersList.addAll(Containers_Select);
		}
		
		Step_End(8, "Click select all check box inContainer Section,", test, test1);
		Step_Start(9, "Select the Fre time Radio Button/LP/% option.", test, test1);
		Step_Start(10, "Go to free time /LP/% text field and enter Values as 99.", test, test1);
		Step_Start(11, "Click the Plus(+) button.", test, test1);

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
			if(isElementEnabled(driver, DW_Lumpsum_Input)) {
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
			if(isElementEnabled(driver, DW_Waiver_percent_Input)) {
			waitForElement(driver, DW_Waiver_percent_Input);
			Newclear(driver, DW_Waiver_percent_Input);
			Actionsendkeys(driver, DW_Waiver_percent_Input, WaiverByvalue);
			}
			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

		}
		Step_End(9, "Select the Fre time Radio Button/LP/% option.", test, test1);

		Step_End(10, "Go to free time /LP/% text field and enter Values as 99.", test, test1);
		Step_End(11, "Click the Plus(+) button.", test, test1);
		Step_Start(12, "system added the free time /LP/%", test, test1);

		
		waitForElement(driver, DW_Waiver_Values_ColumnTable);

		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

			String waiverValue = Act_Waiver_ValuesList.get(i);

			if(!WaiverBy.equalsIgnoreCase("Additional Free Days")) {
			double exp_Amount = getNumberValue(WaiverByvalue);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Verify that free time /LP/% Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + exp_Amount + " || Actual free time /LP/% Amount is Entered as : " + Act_Amount);
				Extent_pass_New(driver, "Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + exp_Amount + " || Actual free time /LP/% Amount is Entered as : " + Act_Amount,test, test1);
			} else {
				System.out.println("Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + exp_Amount + " || Actual free time /LP/% Amount is Entered as : " + Act_Amount);
				Extent_fail(driver, "Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + exp_Amount + " || Actual free time /LP/% Amount is Entered as : " + Act_Amount,test, test1);
			}
			}else {
				if (waiverValue.equals(WaiverByvalue)) {
					System.out.println("Verify that free time /LP/% Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + WaiverByvalue + " || Actual free time /LP/% Amount is Entered as : " + waiverValue);
					Extent_pass_New(driver, "Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + WaiverByvalue + " || Actual free time /LP/% Amount is Entered as : " + waiverValue,test, test1);
				} else {
					System.out.println("Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + WaiverByvalue + " || Actual free time /LP/% Amount is Entered as : " + waiverValue);
					Extent_fail(driver, "Verify that LP Amount is Entered for Container : " + ContainersList.get(i)+ "  || Expected free time /LP/% Amount should be Entered as : " + WaiverByvalue + " || Actual free time /LP/% Amount is Entered as : " + waiverValue,test, test1);
				}
			}
		}
		
		Step_End(12, "system added the free time /LP/%", test, test1);
		Step_Start(13, "Go to remarks section and enter the Remarks", test, test1);

		scrollTop(driver);

		waitForElement(driver, DW_Remarks);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		Step_End(13, "Go to remarks section and enter the Remarks", test, test1);
		Step_Start(14, " Click on submit button,", test, test1);

		waitForDisplay(driver, DW_ReasonSearch);
		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		waitForElement(driver, DW_Submitted);
		click(driver, DW_Submitted);

		Step_End(14, " Click on submit button,", test, test1);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		Step_Start(15, "Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForPopup(driver, Popup_Message, Submitted_Popup);
		String Submit_popup_Message = getText(driver, Popup_Message);

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

		waitForElement(driver, DW_WaiverNo);
		String waiverNumbers=getAttribute(driver, DW_WaiverNo, "value");
		System.out.println("DW_WaiverNo : "+waiverNumbers);
		
		String [] waiverNumber =waiverNumbers.split(" ~~");
		System.out.println("waiverNumber :"+waiverNumber[0]);
		
		Step_End(15, "Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		Step_Start(16, "Switch to Line", test, test1);

		ResetProfile(driver);

		Step_End(16, "Switch to Line", test, test1);

//	// Detention Gate
		
		Step_Start(17, "Open Waiver Gate module,", test, test1);

		moduleNavigate(driver, Waiver_Gate_Module);

		Step_End(17, "Open Waiver Gate module,", test, test1);
		Step_Start(18, "Click on Submitt option", test, test1);

		waitForElement(driver, WG_Submitted_Option);
		click(driver, WG_Submitted_Option);

		Step_End(18, "Click on Submitt option", test, test1);
		Step_Start(19, "Select the Row Waiver in waiver gate", test, test1);

		waitForElement(driver, WG_BL_Filter_Input);
		click(driver, WG_BL_Filter_Input);
		sendKeys(driver, WG_BL_Filter_Input, BL_Number);

		String Select_CheckBox_BL = String.format(WG_Select_BL_CheckBox, BL_Number);
		waitForDisplay(driver, Select_CheckBox_BL);
		jsClick(driver, Select_CheckBox_BL);
		Step_End(19, "Select the Row Waiver in waiver gate", test, test1);

		Step_Start(20, "Click on approve Button.", test, test1);
		waitForElement(driver, WG_Approved_Button);
		click(driver, WG_Approved_Button);

		waitForPopup(driver, Popup_Message, Approved_Popup_WaiverGate);

		String Act_Popup_Approved = getText(driver, Popup_Message);

		if (Approved_Popup_WaiverGate.equals(Act_Popup_Approved)) {
			System.out.println("Popup Matched ||  Expected Popup : " + Approved_Popup_WaiverGate + " || Actual Popup : "
					+ Act_Popup_Approved);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected Popup : " + Approved_Popup_WaiverGate + " || Actual Popup : " + Act_Popup_Approved,
					test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected Popup : " + Approved_Popup_WaiverGate + " || Actual Popup : "
					+ Act_Popup_Approved);
			Extent_fail(driver, "Popup Not Matched ||  Expected Popup : " + Approved_Popup_WaiverGate + " || Actual Popup : "
					+ Act_Popup_Approved, test, test1);
		}
		Step_End(20, "Click on approve Button.", test, test1);
		Step_Start(21, "Open the Detention / Demurrage Invoice module", test, test1);
		
// Detention / Demurrage Invoice
		
		moduleNavigate(driver, Detention_Demurrage_Invoice_Module);
		
		newButton(driver);
		
		Step_End(21, "Open the Detention / Demurrage Invoice module", test, test1);
		Step_Start(22, "Enter the Corporate Agency ", test, test1);

		waitForElement(driver, Corporate_Agency_SearchButton);
		click(driver, Corporate_Agency_SearchButton);
		
		twoColumnSearchWindow(driver, Corporate_Search_Header, Search_Condition, Corporate_Code);
		Step_End(22, "Enter the Corporate Agency ", test, test1);
		Step_Start(23, " Select EMS From Date && EMS To Date as Current Data", test, test1);

		if(!EMS_From_Date.equals("")) {
			waitForElement(driver, EMS_From_Date_Textfield);
			click(driver, EMS_From_Date_Textfield);
			selectDateInCalender(driver, EMS_From_Date, Date_Text_Value, Month_Text_Value, Year_Text_Value, previous_Button_DatePicker, next_Button_DatePicker);
		}
		if(!EMS_To_Date.equals("")) {
			waitForElement(driver, EMS_To_Date_Textfield);
			click(driver, EMS_To_Date_Textfield);
		    selectDateInCalender(driver, EMS_To_Date, Date_Text_Value, Month_Text_Value, Year_Text_Value, previous_Button_DatePicker, next_Button_DatePicker);
		}
		
		Step_End(23, " Select EMS From Date && EMS To Date as Current Data", test, test1);
		Step_Start(24, "Select the Shipment in Drop down", test, test1);

		if(!Shipment_Det_Dem_Invoice.equals("")) {

		waitForElement(driver, Shipment_Dropdown);
		click(driver, Shipment_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Shipment_Det_Dem_Invoice);
		}
		
		Step_End(24, "Select the Shipment in Drop down", test, test1);
		Step_Start(25, "Select the Report Type in Drop down", test, test1);

		if(!ReportType_Det_Dem_Invoice.equals("")) {

		waitForElement(driver, Report_Type_Dropdown);
		click(driver, Report_Type_Dropdown);
		formatLocatorClick(driver, DropDown_Select, ReportType_Det_Dem_Invoice);
		}
		
		Step_End(25, "Select the Report Type in Drop down", test, test1);
		Step_Start(26, "Click on Show Button", test, test1);

		waitForElement(driver, Show_Button_Det_Dem_Invoice);
		click(driver, Show_Button_Det_Dem_Invoice);
		
		Step_End(26, "Click on Show Button", test, test1);
		Step_Start(27, "Verify that Waiver Created BL only available in Detention / Demurrage Invoice if any other BL available remove(Select the Checkbox of other BLs and click on remove button) it.", test, test1);

		scrollElementToView(driver, Select_All_Checkbox_InvoiceDetails);
		waitForElement(driver, Select_All_Checkbox_InvoiceDetails);
		click(driver, Select_All_Checkbox_InvoiceDetails);
		
		reArrangeAG_GridColumns(driver, Invoice_Details_Columns_Det_Dem_Invoice);
		waitForElement(driver, invoiceDetails_Grid_Filter_Button);
		click(driver, invoiceDetails_Grid_Filter_Button);
		
		waitForElement(driver, BL_Number_Filter_Searchfield);
		sendKeys(driver, BL_Number_Filter_Searchfield,BL_Number);
		
		Actions actions=new Actions(driver);
		List<WebElement> blNumber_Gridcells = listOfElements(driver, BL_Number_Gridcells);
		for(WebElement blNumber_Gridcell : blNumber_Gridcells) {
			actions.keyDown(Keys.CONTROL).click(blNumber_Gridcell).build().perform();
		}
		
		actions.keyUp(Keys.CONTROL).build().perform();
		
		waitForElement(driver, BL_Number_Filter_Searchfield);
		clear(driver, BL_Number_Filter_Searchfield);
		
		waitForElement(driver, Remove_Button);
		click(driver, Remove_Button);
		
		waitForElement(driver, Detention_Demurrage_Invoice_Popup_Yes_Button);
		click(driver, Detention_Demurrage_Invoice_Popup_Yes_Button);
		

		Step_End(27, "Verify that Waiver Created BL only available in Detention / Demurrage Invoice if any other BL available remove(Select the Checkbox of other BLs and click on remove button) it.", test, test1);
		Step_Start(28, "Move to Waiver References,", test, test1);
		reArrangeAG_GridColumns(driver, Invoice_Details_Columns_Det_Dem_Invoice);

		waitForElement(driver, Waiver_Ref_Number_Gridcell);
		String actualWaiverRefNo=getText(driver, Waiver_Ref_Number_Gridcell);
		
		System.out.println("actualWaiverRefNo : "+actualWaiverRefNo);
		
		Step_End(28, "Move to Waiver References,", test, test1);
		Step_Start(29, " Ensure that Waiver References column has Waiver References number", test, test1);

		if(verifyElementHasText(driver, Waiver_Ref_Number_Gridcell)) {
			
			System.out.println("Matched || Expected : Waiver Reference number should be present in gridcell || Actual :  Waiver Reference number is present in gridcell || Presented Waiver Reference number : "+actualWaiverRefNo);
			Extent_pass_New(driver, "Matched || Expected : Waiver Reference number should be present in gridcell || Actual :  Waiver Reference number is present in gridcell || Presented Waiver Reference number : "+actualWaiverRefNo, test, test1);
			
		}else {
			System.out.println("Not Matched || Expected : Waiver Reference number should be present in gridcell || Actual :  Waiver Reference number is not present in gridcell");
			Extent_pass_New(driver, "Matched || Expected : Waiver Reference number should be present in gridcell || Actual :  Waiver Reference number is not present in gridcell", test, test1);
			
		}
		Step_End(29, " Ensure that Waiver References column has Waiver References number", test, test1);
		Step_Start(30, "Click on save button,", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(30, "Click on save button,", test, test1);
		Step_Start(31, "Ensure that system shows message as 'Detention / Demurrage Invoice saved Successfully' and CLick on ok button.", test, test1);

		waitForPopup(driver, Detention_Demurrage_Invoice_Popup, Detention_Demurrage_Saved_Popup);

		String Act_Popup_Det_Dem_saved = getText(driver, Detention_Demurrage_Invoice_Popup);

		if (Detention_Demurrage_Saved_Popup.equals(Act_Popup_Det_Dem_saved)) {
			System.out.println("Popup Matched ||  Expected Popup : " + Detention_Demurrage_Saved_Popup + " || Actual Popup : "
					+ Act_Popup_Det_Dem_saved);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected Popup : " + Detention_Demurrage_Saved_Popup + " || Actual Popup : " + Act_Popup_Det_Dem_saved,
					test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected Popup : " + Detention_Demurrage_Saved_Popup + " || Actual Popup : "
					+ Act_Popup_Det_Dem_saved);
			Extent_fail(driver, "Popup Not Matched ||  Expected Popup : " + Detention_Demurrage_Saved_Popup + " || Actual Popup : "
					+ Act_Popup_Det_Dem_saved, test, test1);
		}
		
		waitForElement(driver, Detention_Demurrage_Invoice_Popup_Ok_Button);
		click(driver, Detention_Demurrage_Invoice_Popup_Ok_Button);
		
		
		Step_End(31, "Ensure that system shows message as 'Detention / Demurrage Invoice saved Successfully' and CLick on ok button.", test, test1);
		Step_Start(32, "25A.Capture the Transaction number internally.", test, test1);

		waitForElement(driver, Transaction_Textfield);
		String generated_Transaction_No=getAttribute(driver, Transaction_Textfield, "value");
		System.out.println("generated_Transaction_No : "+generated_Transaction_No);
		Extent_call(test, test1, "generated_Transaction_No : "+generated_Transaction_No);
		
		Step_End(32, "25A.Capture the Transaction number internally.", test, test1);
		Step_Start(33, "Switch to Agency", test, test1);

		SwitchProfile(driver, AgencyName);
		
		Step_End(33, "Switch to Agency", test, test1);
		Step_Start(34, "Open Detention Waiver Module", test, test1);
		
// Detention Waiver
		moduleNavigate(driver, Detention_Module);
		
		Step_End(34, "Open Detention Waiver Module", test, test1);
		Step_Start(35, "Click on Search Button", test, test1);


		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(35, "Click on Search Button", test, test1);
		Step_Start(36, "Enter the Waiver Number && load it,", test, test1);

		globalValueSearchWindow(driver, BL_Condition, SearchType_WaiverNumer, waiverNumber[0], "", "", "", "");

		Step_End(36, "Enter the Waiver Number && load it,", test, test1);
		Step_Start(37, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);		
		
		Step_End(37, "Click on Edit Button", test, test1);
		Step_Start(38, "Verify that Message as ' Approved Waiver cannot be Edited' Since the same Reference is involved in DAR, Hence not allow to Cancel it.", test, test1);

		waitForPopup(driver, popup_Message, cannotEdit_Detention_Demurrage_Popup);
		String cannotEditPopup = getText(driver, popup_Message);

		if (cannotEditPopup.equals(cannotEdit_Detention_Demurrage_Popup)) {

			System.out.println("Matched || Expected popup : " + cannotEdit_Detention_Demurrage_Popup
					+ " || Actual popup : " + cannotEditPopup);
			Extent_pass_New(driver, "Matched || Expected popup : " + cannotEdit_Detention_Demurrage_Popup
					+ " || Actual popup : " + cannotEditPopup, test, test1);

		} else {
			System.out.println("Not Matched || Expected popup : " + cannotEdit_Detention_Demurrage_Popup
					+ " || Actual popup : " + cannotEditPopup);
			Extent_fail(driver, "Not Matched || Expected popup : " + cannotEdit_Detention_Demurrage_Popup
					+ " || Actual popup : " + cannotEditPopup, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, DW_WaiverStatus);
		String waiverstatus = getText(driver, DW_WaiverStatus);
		System.out.println("waiverstatus : "+waiverstatus);
		
		Step_End(38, "Verify that Message as ' Approved Waiver cannot be Edited' Since the same Reference is involved in DAR, Hence not allow to Cancel it.", test, test1);

		if(Delete_DAR.equalsIgnoreCase("Yes")) {
// Detention / Demurrage Invoice
		
			Step_Start(39, " Switch To Line profile,", test, test1);

			ResetProfile(driver);

		
		Step_End(39, " Switch To Line profile,", test, test1);
		Step_Start(40, "Open the Detention / Demurrage Invoice module,", test, test1);

		moduleNavigate(driver, Detention_Demurrage_Invoice_Module);

		Step_End(40, "Open the Detention / Demurrage Invoice module,", test, test1);
		Step_Start(41, "Click on search button,", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(41, "Click on search button,", test, test1);
		Step_Start(42, "Enter the transaction Number in Search field and load data", test, test1);

		globalValueSearchWindow(driver, BL_Condition, SearchType_Transaction_No, generated_Transaction_No, "", "", "", "");

		Step_End(42, "Enter the transaction Number in Search field and load data", test, test1);
		Step_Start(43, "Click on Delete button", test, test1);

		scrollTop(driver);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		
		Step_End(43, "Click on Delete button", test, test1);
		Step_Start(44, "system shows message as 'Are you sure to delete the Detention/Demurrage Invoice?' Click on Yes button", test, test1);

		waitForPopup(driver, popup_Message, Want_To_Delete_Detention_Demurrage_Popup);
		String wantToDelete_popup_Message = getText(driver, popup_Message);

		if (wantToDelete_popup_Message.equals(Want_To_Delete_Detention_Demurrage_Popup)) {

			System.out.println("Matched || Expected popup : " + Want_To_Delete_Detention_Demurrage_Popup
					+ " || Actual popup : " + wantToDelete_popup_Message);
			Extent_pass_New(driver, "Matched || Expected popup : " + Want_To_Delete_Detention_Demurrage_Popup
					+ " || Actual popup : " + wantToDelete_popup_Message, test, test1);

		} else {
			System.out.println("Not Matched || Expected popup : " + Want_To_Delete_Detention_Demurrage_Popup
					+ " || Actual popup : " + wantToDelete_popup_Message);
			Extent_fail(driver, "Not Matched || Expected popup : " + Want_To_Delete_Detention_Demurrage_Popup
					+ " || Actual popup : " + wantToDelete_popup_Message, test, test1);

		}
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		Step_End(44, "system shows message as 'Are you sure to delete the Detention/Demurrage Invoice?' Click on Yes button", test, test1);
		Step_Start(45, "system shows message as' Detention/Demurrage Invoice is deleted' and click on ok button", test, test1);

		waitForPopup(driver, popup_Message, Deleted_Detention_Demurrage_Popup);
		String DeletedPopup = getText(driver, popup_Message);

		if (DeletedPopup.equals(Deleted_Detention_Demurrage_Popup)) {

			System.out.println("Matched || Expected popup : " + Deleted_Detention_Demurrage_Popup
					+ " || Actual popup : " + DeletedPopup);
			Extent_pass_New(driver, "Matched || Expected popup : " + Deleted_Detention_Demurrage_Popup
					+ " || Actual popup : " + DeletedPopup, test, test1);

		} else {
			System.out.println("Not Matched || Expected popup : " + Deleted_Detention_Demurrage_Popup
					+ " || Actual popup : " + DeletedPopup);
			Extent_fail(driver, "Not Matched || Expected popup : " + Deleted_Detention_Demurrage_Popup
					+ " || Actual popup : " + DeletedPopup, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(45, "system shows message as' Detention/Demurrage Invoice is deleted' and click on ok button", test, test1);

		}
		
		if (WantToCancel_Waiver.equalsIgnoreCase("Yes")) {

			Extent_call(test, test1, "Switch to agency cancel the waiver.");
			SwitchProfile(driver, AgencyName);

			moduleNavigate(driver, Detention_Module);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, SearchType_WaiverNumer, waiverNumber[0], "", "", "", "");

			Reversewaiver(driver, BL_Condition, SearchType_WaiverNumer, waiverNumber[0], DW_Remarks_Input_value, waiverstatus,
					AgencyName, Detention_Module);

		}
		
		
		Extent_completed(testcase_Name, test, test1);

	}
}
