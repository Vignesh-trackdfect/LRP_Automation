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

public class TC_Detention_Waiver_TS_038B extends Keywords {

	public void Detention_Waiver_TS_038B(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException {

		String testcase_Name = "TC_Detention_Waiver_TS_038B";

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
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Remarks_value = Excel_data.get("Remarks_value");

		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Waiver_Reason_Value = Excel_data.get("Waiver_Reason_Value");

		String Cancel_Mode_Popup = Excel_data.get("Cancel_Mode_Popup");

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

		Step_Start(5, "Select the container details, and input the Free days/Waiver Lumsump/Waiver %", test, test1);
		
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

		if (WaiverBy.equalsIgnoreCase("Additional Free Days")) {

			waitForElement(driver, DW_Addition_Days_Input);
			Newclear(driver, DW_Addition_Days_Input);
			Actionsendkeys(driver, DW_Addition_Days_Input, WaiverByvalue);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

			List<Map<String, String>> Waiver_Table_data = extractTableDataByColumnWithoutScroll(driver,
					DW_Waiver_Table_);

			List<String> Act_Waiver_ValuesList = getValuesByFirstColumnAndHeader(Waiver_Table_data, "Container No",
					ContainersList, "Waiver Value");

			for (int i = 0; i < Act_Waiver_ValuesList.size(); i++) {

				String waiverValue = Act_Waiver_ValuesList.get(i);

				if (waiverValue.equals(WaiverByvalue)) {
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
			waitForDisplay(driver, DW_Waiver_percent_Input);
			if(isElementEnabled(driver, DW_Waiver_percent_Input)) {
			waitForElement(driver, DW_Waiver_percent_Input);
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

		Step_End(5, "Select the container details, and input the Free days/Waiver Lumsump/Waiver %", test, test1);

		scrollBottom(driver);
		Step_Start(6, " Enter the Remarks in Remarks section", test, test1);
		waitForElement(driver, DW_Remarks_Input);
		sendKeys(driver, DW_Remarks_Input, Remarks_value);
		Step_End(6, " Enter the Remarks in Remarks section", test, test1);

		scrollTop(driver);
		
		waitForElement(driver, DW_Submitted_Option);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Submitted_Option);

		Step_Start(7, " click on save button,", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(7, " click on save button,", test, test1);

		Step_Start(8, " Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

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
		System.out.println(ref_No);
		Step_End(8, " Verify the Msg\"Detention Waiver saved in Submitted mode\"", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForElement(driver, DW_Remarks_Input);
		sendKeys(driver, DW_Remarks_Input, Remarks_value);

		waitForElement(driver, SaveButton_ToolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Cancel_Mode_Popup);

		String act_Popup = getText(driver, Popup_Message);
		System.out.println(act_Popup);

		if (Cancel_Mode_Popup.equals(act_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected value : " + Cancel_Mode_Popup + " || Actual value : " + act_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected value : " + Cancel_Mode_Popup + " || Actual value : " + act_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected value : " + Cancel_Mode_Popup + " || Actual value : " + act_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected value : " + Cancel_Mode_Popup + " || Actual value : " + act_Popup,
					test, test1);
		}
		Extent_completed(testcase_Name, test, test1);

	}

}
