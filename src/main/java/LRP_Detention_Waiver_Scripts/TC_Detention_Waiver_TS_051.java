package LRP_Detention_Waiver_Scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_051 extends Keywords {

	public void Detention_Waiver_TS_051(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException {

		String testcase_Name = "TC_Detention_Waiver_TS_051";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String Detention_Module = Excel_data.get("Detention_Module");
		String WaiverFor = Excel_data.get("WaiverFor");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Select_Containers_List = Excel_data.get("Select_Containers_List");
		String WaiverBy = Excel_data.get("WaiverBy");
		String WaiverByvalue = Excel_data.get("WaiverByvalue");
		String Waiver_Table_Headers = Excel_data.get("Waiver_Table_Headers");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Waiver_Reason_Value = Excel_data.get("Waiver_Reason_Value");
		String Detention_Waiver_Saved_Popup = Excel_data.get("Detention_Waiver_Saved_Popup");
		String Remarks_value = Excel_data.get("Remarks_value");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Select_Approve_Module = Excel_data.get("Select_Approve_Module");
		String Approved_Popup = Excel_data.get("Approved_Popup");
		String Approved_Status = Excel_data.get("Approved_Status");
		String Approved_Success_popup_Detention = Excel_data.get("Approved_Success_popup_Detention");
		String Free_Days = Excel_data.get("Free_Days");
		String Kindly_Select_Lumpsum_Popup = Excel_data.get("Kindly_Select_Lumpsum_Popup");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
		String Waiver_number_option = Excel_data.get("Waiver_number_option");
		String DW_Remarks_Input_value = Excel_data.get("DW_Remarks_Input_value");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_User);

		Extent_call(test, test1, "Open Detention Waiver  - Start");
		moduleNavigate(driver, Detention_Module);
		Extent_call(test, test1, "Open Detention Waiver  - End");

		Step_Start(1, "Click on New Button", test, test1);

		newButton(driver);

		waitForElement(driver, DW_Shipment_Select);
		click(driver, DW_Shipment_Select);

		formatLocatorClick(driver, DW_Shipment_Options, WaiverFor);

		formatLocatorClick(driver, DW_DetentionStorageOption, DetentionStorage_Option);

		Step_End(1, "Click on New Button", test, test1);

		Step_Start(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		waitForElement(driver, DW_BookingNo_Search_btn);
		click(driver, DW_BookingNo_Search_btn);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		if (IsElementEnabled(driver, DW_Waiver_ReasonSearch_btn)) {
			click(driver, DW_Waiver_ReasonSearch_btn);
			twoColumnMultipleSearchWindow(driver, Waiver_Reason_Header, Condition_Filter, Waiver_Reason_Value);
		}

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(4, "Click on show Button", test, test1);
		waitForElement(driver, DW_Show_Button);
		click(driver, DW_Show_Button);

		Step_End(4, "Click on show Button", test, test1);

		Step_Start(5,
				"Select the container details, and input the Free time /Lumpsum/Percentage Split into 2 % and LP..",
				test, test1);
		

		scrollElementToView(driver, Detention_container_Filter);
		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}

			checkBox(driver, DW_ContainersGrid_SelectAll, "Yes");

		} else {
			List<String> Containers_Select = splitAndExpand(Select_Containers_List);
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

		if (WaiverBy.equalsIgnoreCase("Waiver Lumpsum")) {

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

			List<WebElement> waiverValueColumns = listOfElements(driver, DW_Waiver_Values_ColumnTable);
			List<String> Act_Waiver_ValuesList1 = new ArrayList<String>();
			for (WebElement columns : waiverValueColumns) {

				String ColText = columns.getText();
				Act_Waiver_ValuesList1.add(ColText);

			}

			List<WebElement> waiverAmountValueColumns = listOfElements(driver, DW_Waiver_Amount_ColumnTable);
			List<String> Act_Waiver_AmountList1 = new ArrayList<String>();
			for (WebElement columns : waiverAmountValueColumns) {

				String ColText = columns.getText();
				Act_Waiver_AmountList1.add(ColText);

			}

			for (int i = 0; i < Act_Waiver_AmountList1.size(); i++) {

				String waiverValue = Act_Waiver_AmountList1.get(i);
				double exp_Amount = getNumberValue(WaiverByvalue);
				double Act_Amount = getNumberValue(waiverValue);
				if (exp_Amount == Act_Amount) {
					System.out.println("Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_pass_New(driver, "Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				} else {
					System.out.println("Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_fail(driver, "Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				}

			}

			for (int i = 0; i < Act_Waiver_ValuesList1.size(); i++) {

				String waiverValue = Act_Waiver_ValuesList1.get(i);
				double exp_Amount = getNumberValue(WaiverByvalue);
				double Act_Amount = getNumberValue(waiverValue);
				if (exp_Amount == Act_Amount) {
					System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_pass_New(driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				} else {
					System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_fail(driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				}

			}

		} else if (WaiverBy.equalsIgnoreCase("Waiver %")) {

			waitForElement(driver, DW_Waiver_percent_RadioBtn);
			click(driver, DW_Waiver_percent_RadioBtn);

			waitForElement(driver, DW_Waiver_percent_Input);
			if(isElementEnabled(driver, DW_Waiver_percent_Input)) {
			Newclear(driver, DW_Waiver_percent_Input);
			Actionsendkeys(driver, DW_Waiver_percent_Input, WaiverByvalue);
			}
			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

			reArrangeAG_GridColumnsWithoutCheckbox(driver, Waiver_Table_Headers);

			Map<String, String> Container_Amount_Lists = new HashMap<String, String>();

			List<WebElement> waiver_NetAmount = listOfElements(driver, DW_Net_Tarrif_Amount);
			List<WebElement> container_Columns = listOfElements(driver, DW_Container_NumbersColumn);

			for (int k = 0; k < container_Columns.size(); k++) {
				String Container = container_Columns.get(k).getText();
				String NetAmount_ = waiver_NetAmount.get(k).getText();
				if (!Container.equals("")) {
					Container_Amount_Lists.put(Container, NetAmount_);
				}
			}

			List<WebElement> waiverValueColumns = listOfElements(driver, DW_Waiver_Values_ColumnTable);
			List<String> Act_Waiver_ValuesList1 = new ArrayList<String>();
			for (WebElement columns : waiverValueColumns) {

				String ColText = columns.getText();
				Act_Waiver_ValuesList1.add(ColText);

			}

			List<WebElement> waiverAmountValueColumns = listOfElements(driver, DW_Waiver_Amount_ColumnTable);
			List<String> Act_Waiver_AmountList1 = new ArrayList<String>();
			for (WebElement columns : waiverAmountValueColumns) {

				String ColText = columns.getText();
				Act_Waiver_AmountList1.add(ColText);

			}

			for (int i = 0; i < Act_Waiver_AmountList1.size(); i++) {

				double Expected_Amount = getWaiverPercentAmount(Container_Amount_Lists.get(ContainersList.get(i)),
						WaiverByvalue);
				double Act_Amount = getNumberValue(Act_Waiver_AmountList1.get(i));

				if (Expected_Amount == Act_Amount) {
					System.out.println("Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount);
					Extent_pass_New(driver,
							"Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
									+ "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount,
							test, test1);
				} else {
					System.out.println("Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount);
					Extent_fail(driver,
							"Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
									+ "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount,
							test, test1);
				}
			}

			for (int i = 0; i < Act_Waiver_ValuesList1.size(); i++) {

				String waiverValue = Act_Waiver_ValuesList1.get(i);
				double exp_Amount = getNumberValue(WaiverByvalue);
				double Act_Amount = getNumberValue(waiverValue);
				if (exp_Amount == Act_Amount) {
					System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_pass_New(driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				} else {
					System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue);
					Extent_fail(driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
							+ "  || Expected  : " + WaiverByvalue + " || Actual : " + waiverValue, test, test1);
				}
			}

		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Detention_Waiver_Saved_Popup);
		String Act_Popup = getText(driver, Popup_Message);
		if (Detention_Waiver_Saved_Popup.equals(Act_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + Detention_Waiver_Saved_Popup + " || Actual : " + Act_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Detention_Waiver_Saved_Popup + " || Actual : " + Act_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Detention_Waiver_Saved_Popup + " || Actual : " + Act_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Detention_Waiver_Saved_Popup + " || Actual : " + Act_Popup,
					test, test1);
		}

		Step_End(5, "Select the container details, and input the Free time /Lumpsum/Percentage Split into 2 % and LP..",
				test, test1);

		Step_Start(6, " Enter the Remarks", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		waitForElement(driver, DW_Remarks_Input);
		sendKeys(driver, DW_Remarks_Input, Remarks_value);
		Step_End(6, " Enter the Remarks", test, test1);

		Step_Start(7, "Click the Submit button,", test, test1);
		scrollTop(driver);
		waitForElement(driver, DW_Submitted_Option);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Submitted_Option);
		Step_End(7, "Click the Submit button,", test, test1);

		Step_Start(8, "click on save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(8, "click on save button", test, test1);

		Step_Start(9, "Verify the Msg  Detention Waiver saved in Submitted mode", test, test1);

		waitForPopup(driver, Popup_Message, Submitted_Popup);

		String Act_Popup_Submit = getText(driver, Popup_Message);

		if (Submitted_Popup.equals(Act_Popup_Submit)) {
			System.out.println("Popup Matched ||  Expected : " + Submitted_Popup + " || Actual : " + Act_Popup_Submit);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Submitted_Popup + " || Actual : " + Act_Popup_Submit, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Submitted_Popup + " || Actual : " + Act_Popup_Submit);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Submitted_Popup + " || Actual : " + Act_Popup_Submit, test,
					test1);
		}
		waitForElement(driver, DW_Waiver_Reference_input);
		String ref_No = getAttribute(driver, DW_Waiver_Reference_input, "value");

		Step_End(9, "Verify the Msg  Detention Waiver saved in Submitted mode", test, test1);

		Step_Start(10, " Switch to Line Login", test, test1);

		ResetProfile(driver);
		Step_End(10, " Switch to Line Login", test, test1);

		Step_Start(11, " Open WaiverGate or detention waiver", test, test1);
		if (Select_Approve_Module.equalsIgnoreCase("Waiver Gate")) {
			moduleNavigate(driver, Select_Approve_Module);
			Step_End(11, " Open WaiverGate or detention waiver", test, test1);

			Step_Start(12, " Enter From and To Date and click on show button", test, test1);
			waitForElement(driver, WG_Submitted_Option);
			click(driver, WG_Submitted_Option);
			Step_End(12, " Enter From and To Date and click on show button", test, test1);

			Step_Start(13, " Filter the by Waiver number and click on Approve button,", test, test1);
			waitForElement(driver, WG_BL_Filter_Input);
			click(driver, WG_BL_Filter_Input);
			sendKeys(driver, WG_BL_Filter_Input, BL_Number);

			String Select_CheckBox_BL = String.format(WG_Select_BL_CheckBox, BL_Number);
			waitForDisplay(driver, Select_CheckBox_BL);
			jsClick(driver, Select_CheckBox_BL);

			waitForElement(driver, WG_Approved_Button);
			click(driver, WG_Approved_Button);
			Step_End(13, " Filter the by Waiver number and click on Approve button,", test, test1);

			waitForPopup(driver, Popup_Message, Approved_Popup);

			String Act_Popup_Approved = getText(driver, Popup_Message);

			if (Approved_Popup.equals(Act_Popup_Approved)) {
				System.out.println(
						"Popup Matched ||  Expected : " + Approved_Popup + " || Actual : " + Act_Popup_Approved);
				Extent_pass_New(driver,
						"Popup Matched ||  Expected : " + Approved_Popup + " || Actual : " + Act_Popup_Approved, test,
						test1);
			} else {
				System.out.println(
						"Popup Not Matched ||  Expected : " + Approved_Popup + " || Actual : " + Act_Popup_Approved);
				Extent_fail(driver,
						"Popup Not Matched ||  Expected : " + Approved_Popup + " || Actual : " + Act_Popup_Approved,
						test, test1);
			}

		} else {

			moduleNavigate(driver, Select_Approve_Module);
			Step_End(11, " Open WaiverGate or detention waiver", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow1(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

			waitForElement(driver, DW_Waiver_Ref_No_FilterInput);
			sendKeys(driver, DW_Waiver_Ref_No_FilterInput, ref_No);

			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			elementnotvisible1(driver, SelectButton);

			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			mouseOverToElement(driver, SaveButton_ToolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, DW_Approved_option);
			click(driver, DW_Approved_option);

			scrollBottom(driver);
			waitForElement(driver, DW_Remarks_Input);
			sendKeys(driver, DW_Remarks_Input, Remarks_value);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			mouseOverToElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, Approved_Success_popup_Detention);

			String Act_Popup_approved = getText(driver, Popup_Message);

			if (Approved_Success_popup_Detention.equals(Act_Popup_approved)) {
				System.out.println("Popup Matched ||  Expected : " + Approved_Success_popup_Detention + " || Actual : "
						+ Act_Popup_approved);
				Extent_pass_New(driver, "Popup Matched ||  Expected : " + Approved_Success_popup_Detention
						+ " || Actual : " + Act_Popup_approved, test, test1);
			} else {
				System.out.println("Popup Not Matched ||  Expected : " + Approved_Success_popup_Detention
						+ " || Actual : " + Act_Popup_approved);
				Extent_fail(driver, "Popup Not Matched ||  Expected : " + Approved_Success_popup_Detention
						+ " || Actual : " + Act_Popup_approved, test, test1);
			}

			waitForElement(driver, DW_Waiver_Status);
			String Act_Status = getText(driver, DW_Waiver_Status);
			if (Act_Status.contains(Approved_Status)) {
				System.out.println("Status Matched ||  Expected : " + Approved_Status + " || Actual : " + Act_Status);
				Extent_pass_New(driver,
						"Status Matched ||  Expected : " + Approved_Status + " || Actual : " + Act_Status, test, test1);
			} else {
				System.out
						.println("Status Not Matched ||  Expected : " + Approved_Status + " || Actual : " + Act_Status);
				Extent_fail(driver,
						"Status Not Matched ||  Expected : " + Approved_Status + " || Actual : " + Act_Status, test,
						test1);
			}

		}

		Step_Start(14, " Switch to agency and open waiver module", test, test1);

		SwitchProfile(driver, Agency_User);
		moduleNavigate(driver, Detention_Module);

		Step_End(14, " Switch to agency and open waiver module", test, test1);

		Step_Start(15, " Click on New Button", test, test1);

		newButton(driver);

		waitForElement(driver, DW_Shipment_Select);
		click(driver, DW_Shipment_Select);

		formatLocatorClick(driver, DW_Shipment_Options, WaiverFor);

		formatLocatorClick(driver, DW_DetentionStorageOption, DetentionStorage_Option);

		Step_End(15, " Click on New Button", test, test1);

		Step_Start(16, " Click on BL No Search Field ", test, test1);
		Step_Start(17, " Input your Confirm BL No  ", test, test1);

		waitForElement(driver, DW_BookingNo_Search_btn);
		click(driver, DW_BookingNo_Search_btn);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		if (IsElementEnabled(driver, DW_Waiver_ReasonSearch_btn)) {
			click(driver, DW_Waiver_ReasonSearch_btn);
			twoColumnMultipleSearchWindow(driver, Waiver_Reason_Header, Condition_Filter, Waiver_Reason_Value);
		}
		Step_End(17, " Input your Confirm BL No  ", test, test1);
		Step_End(16, " Click on BL No Search Field ", test, test1);

		Step_Start(18, " Click on show Button", test, test1);
		waitForElement(driver, DW_Show_Button);
		click(driver, DW_Show_Button);
		Step_End(18, " Click on show Button", test, test1);

		Step_Start(19, "Select the container details, and and select free days radio button", test, test1);
		mouseOverToElement(driver, DW_Select_All_Checkbox);

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			scrollBottom(driver);
			checkBox(driver, DW_ContainersGrid_SelectAll, "Yes");

		} else {
			List<String> Containers_Select = splitAndExpand(Select_Containers_List);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				waitForElement(driver, Detention_container_Filter_input);
				String containerInput = String.format(DW_Select_Container_Checkbox,container);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
			}
		}

		scrollBottom(driver);
		click(driver, DW_Add_Days_RadioBtn);

		Step_End(19, "Select the container details, and and select free days radio button", test, test1);

		Step_Start(20, "enter the free days and click + button,", test, test1);

		waitForElement(driver, DW_Addition_Days_Input);
		Newclear(driver, DW_Addition_Days_Input);
		Actionsendkeys(driver, DW_Addition_Days_Input, Free_Days);
		click(driver, DW_Add_Days_RadioBtn);

		waitForElement(driver, DW_Waiver_Add_button);
		click(driver, DW_Waiver_Add_button);

		Step_End(20, "enter the free days and click + button,", test, test1);

		Step_Start(21, "Verify the Validation", test, test1);

		waitForPopup(driver, Popup_Message, Kindly_Select_Lumpsum_Popup);

		String Act_Popup_Lumpsum = getText(driver, Popup_Message);

		if (Kindly_Select_Lumpsum_Popup.equals(Act_Popup_Lumpsum)) {
			System.out.println("Popup Matched ||  Expected : " + Kindly_Select_Lumpsum_Popup + " || Actual : "
					+ Act_Popup_Lumpsum);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Kindly_Select_Lumpsum_Popup + " || Actual : " + Act_Popup_Lumpsum,
					test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected : " + Kindly_Select_Lumpsum_Popup + " || Actual : "
					+ Act_Popup_Lumpsum);
			Extent_fail(driver, "Popup Not Matched ||  Expected : " + Kindly_Select_Lumpsum_Popup + " || Actual : "
					+ Act_Popup_Lumpsum, test, test1);
		}

		Step_End(21, "Verify the Validation", test, test1);

		scrollTop(driver);

		waitForElement(driver, cancel_Common_btn);
		jsClick(driver, cancel_Common_btn);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			waitForElement(driver, SearchButton_Toolbar);
			jsClick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Waiver_number_option, ref_No, "", "", "", "");

			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
			waitForElement(driver, popup_Message_Yes_Button);
			jsClick(driver, popup_Message_Yes_Button);
			waitForElement(driver, DW_Remarks_Input);
			clearAndType(driver, DW_Remarks_Input, DW_Remarks_Input_value);

			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

		}

		Extent_completed(testcase_Name, test, test1);

	}

}
