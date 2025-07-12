package LRP_Detention_Waiver_Scripts;

import java.awt.AWTException;
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

public class TC_Detention_Waiver_TS_039 extends Keywords {

	public void Detention_Waiver_TS_039(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException {

		String testcase_Name = "TC_Detention_Waiver_TS_039";

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

		String Additonal_Date_Value = Excel_data.get("Additonal_Date_Value");
		String Detention_Waiver_Saved_Popup = Excel_data.get("Detention_Waiver_Saved_Popup");

		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Remarks_value = Excel_data.get("Remarks_value");

		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Waiver_Reason_Value = Excel_data.get("Waiver_Reason_Value");

		String Select_Approve_Module = Excel_data.get("Select_Approve_Module");
		String Approved_Popup = Excel_data.get("Approved_Popup");
		String Approved_Status = Excel_data.get("Approved_Status");
		String Approved_Success_popup_Detention = Excel_data.get("Approved_Success_popup_Detention");

		String Approved_BL_Filter_type = Excel_data.get("Approved_BL_Filter_type");
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

		Step_Start(5, "Select the container details, and input the Free time", test, test1);
		mouseOverToElement(driver, DW_Select_All_Checkbox);

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
		waitForElement(driver, DW_Addition_Days_Input);
		Newclear(driver, DW_Addition_Days_Input);
		Actionsendkeys(driver, DW_Addition_Days_Input, Additonal_Date_Value);
		click(driver, DW_Add_Days_RadioBtn);

		waitForElement(driver, DW_Waiver_Add_button);
		click(driver, DW_Waiver_Add_button);

		waitForElement(driver, DW_Waiver_Table_Cell);

		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

			String waiverValue = Act_Waiver_ValuesList.get(i);
			double exp_Amount = getNumberValue(Additonal_Date_Value);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected value  : " + Additonal_Date_Value + " || Actual value : " + waiverValue);
				Extent_pass_New(driver, "Waiver Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected value  : " + Additonal_Date_Value + " || Actual value : " + waiverValue, test,
						test1);
			} else {
				System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected value  : " + Additonal_Date_Value + " || Actual value : " + waiverValue);
				Extent_fail(driver, "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected value  : " + Additonal_Date_Value + " || Actual value : " + waiverValue, test,
						test1);
			}

		}
		Step_End(5, "Select the container details, and input the Free time", test, test1);

		Step_Start(6, "Click on save Button", test, test1);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);

		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click on save Button", test, test1);

		Step_Start(7, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		waitForPopup(driver, Popup_Message, Detention_Waiver_Saved_Popup);

		String Act_Popup = getText(driver, Popup_Message);

		if (Detention_Waiver_Saved_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected value : " + Detention_Waiver_Saved_Popup
					+ " || Actual value : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected value : " + Detention_Waiver_Saved_Popup
					+ " || Actual value : " + Act_Popup, test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected value : " + Detention_Waiver_Saved_Popup
					+ " || Actual value : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected value : " + Detention_Waiver_Saved_Popup
					+ " || Actual value : " + Act_Popup, test, test1);
		}

		Step_End(7, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		Step_Start(8, "Click on Edit Button and Click the Submit button,", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		Step_Start(10, " Enter the Remarks in Remarks section", test, test1);
		waitForElement(driver, DW_Remarks_Input);
		sendKeys(driver, DW_Remarks_Input, Remarks_value);
		Step_End(10, " Enter the Remarks in Remarks section", test, test1);
		scrollTop(driver);

		waitForElement(driver, DW_Submitted_Option);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Submitted_Option);
		Step_End(8, "Click on Edit Button and Click the Submit button,", test, test1);

		Step_Start(9, " click on save button,", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(9, " click on save button,", test, test1);

		Step_Start(11, " Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForPopup(driver, Popup_Message, Submitted_Popup);

		String Act_Popup_Submit = getText(driver, Popup_Message);

		if (Submitted_Popup.equals(Act_Popup_Submit)) {
			System.out.println(
					"Popup Matched ||  Expected value : " + Submitted_Popup + " || Actual value : " + Act_Popup_Submit);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected value : " + Submitted_Popup + " || Actual value : " + Act_Popup_Submit,
					test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected value : " + Submitted_Popup + " || Actual value : "
					+ Act_Popup_Submit);
			Extent_fail(driver, "Popup Not Matched ||  Expected value : " + Submitted_Popup + " || Actual value : "
					+ Act_Popup_Submit, test, test1);
		}

		waitForElement(driver, DW_Waiver_Reference_input);
		String ref_No = getAttribute(driver, DW_Waiver_Reference_input, "value");
		Step_End(11, " Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		Step_Start(12, " Switch to Line Login,", test, test1);
		ResetProfile(driver);
		Step_End(12, " Switch to Line Login,", test, test1);

		Step_Start(13,
				" Open Waiver Gate module or detention waiver module -if detention waiver module -retrive the bl in agency",
				test, test1);
		if (Select_Approve_Module.equalsIgnoreCase("Waiver Gate")) {
			moduleNavigate(driver, Select_Approve_Module);
			Step_End(13,
					" Open Waiver Gate module or detention waiver module -if detention waiver module -retrive the bl in agency",
					test, test1);

			Step_Start(14, " Select the Row Waiver in waiver gate", test, test1);
			waitForElement(driver, WG_Submitted_Option);
			click(driver, WG_Submitted_Option);

			waitForElement(driver, WG_BL_Filter_Input);
			click(driver, WG_BL_Filter_Input);
			sendKeys(driver, WG_BL_Filter_Input, BL_Number);

			String Select_CheckBox_BL = String.format(WG_Select_BL_CheckBox, BL_Number);
			waitForDisplay(driver, Select_CheckBox_BL);
			jsClick(driver, Select_CheckBox_BL);
			Step_End(14, " Select the Row Waiver in waiver gate", test, test1);

			Step_Start(14, "  A. Click on approve Button.e", test, test1);
			waitForElement(driver, WG_Approved_Button);
			click(driver, WG_Approved_Button);

			waitForPopup(driver, Popup_Message, Approved_Popup);

			String Act_Popup_Approved = getText(driver, Popup_Message);

			if (Approved_Popup.equals(Act_Popup_Approved)) {
				System.out.println("Popup Matched ||  Expected value : " + Approved_Popup + " || Actual value : "
						+ Act_Popup_Approved);
				Extent_pass_New(driver, "Popup Matched ||  Expected value : " + Approved_Popup + " || Actual value : "
						+ Act_Popup_Approved, test, test1);
			} else {
				System.out.println("Popup Not Matched ||  Expected value : " + Approved_Popup + " || Actual value : "
						+ Act_Popup_Approved);
				Extent_fail(driver, "Popup Not Matched ||  Expected value : " + Approved_Popup + " || Actual value : "
						+ Act_Popup_Approved, test, test1);
			}
			Step_End(14, "  A. Click on approve Button.e", test, test1);

		} else {

			moduleNavigate(driver, Select_Approve_Module);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow1(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

			waitForElement(driver, DW_Waiver_Ref_No_FilterInput);
			sendKeys(driver, DW_Waiver_Ref_No_FilterInput, ref_No);

			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			waitInvisible(driver, SelectButton);

			Step_End(13,
					" Open Waiver Gate module or detention waiver module -if detention waiver module -retrive the bl in agency",
					test, test1);

			Step_Start(14, " A. Click on approve Button", test, test1);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
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
				System.out.println("Popup Matched ||  Expected value : " + Approved_Success_popup_Detention
						+ " || Actual value : " + Act_Popup_approved);
				Extent_pass_New(driver, "Popup Matched ||  Expected value : " + Approved_Success_popup_Detention
						+ " || Actual value : " + Act_Popup_approved, test, test1);
			} else {
				System.out.println("Popup Not Matched ||  Expected value : " + Approved_Success_popup_Detention
						+ " || Actual value : " + Act_Popup_approved);
				Extent_fail(driver, "Popup Not Matched ||  Expected value : " + Approved_Success_popup_Detention
						+ " || Actual value : " + Act_Popup_approved, test, test1);
			}
			Step_End(14, "  A. Click on approve Button.", test, test1);

		}

		Step_Start(15, "  Open Detention waiver module", test, test1);

		SwitchProfile(driver, Agency_User);
		moduleNavigate(driver, Detention_Module);
		Step_End(15, "  Open Detention waiver module", test, test1);

		Step_Start(16, "  Click on Search Button ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(16, "  Click on Search Button ", test, test1);

		Step_Start(17, "  Enter Waiver No/ BL NO ", test, test1);
		Step_Start(18, "  load  the data.", test, test1);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, Approved_BL_Filter_type, ref_No, "",
				"");

		Step_End(18, "  load  the data.", test, test1);
		Step_End(17, "  Enter Waiver No/ BL NO ", test, test1);

		Step_Start(19, " Verify that Waiver is in Approved Status", test, test1);

		waitForElement(driver, DW_Waiver_Status);
		String Act_Status = getText(driver, DW_Waiver_Status);
		if (Act_Status.contains(Approved_Status)) {
			System.out.println(
					"Status Matched ||  Expected value : " + Approved_Status + " || Actual value : " + Act_Status);
			Extent_pass_New(driver,
					"Status Matched ||  Expected value : " + Approved_Status + " || Actual value : " + Act_Status, test,
					test1);
		} else {
			System.out.println(
					"Status Not Matched ||  Expected value : " + Approved_Status + " || Actual value : " + Act_Status);
			Extent_fail(driver,
					"Status Not Matched ||  Expected value : " + Approved_Status + " || Actual value : " + Act_Status,
					test, test1);
		}
		Step_End(19, " Verify that Waiver is in Approved Status", test, test1);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

			String waiverstatus = getText(driver, DW_WaiverStatus);

			Reversewaiver(driver, BL_Condition, Waiver_number_option, waiverValue, DW_Remarks_Input_value, waiverstatus,
					Agency_User, Detention_Module);

		}

		Extent_completed(testcase_Name, test, test1);

	}

}
