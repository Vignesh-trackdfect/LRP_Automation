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

public class TC_Detention_Waiver_TS_037 extends Keywords {

	public void Detention_Waiver_TS_037(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException {

		String testcase_Name = "TC_Detention_Waiver_TS_037";

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
		String Waiver_Table_Headers = Excel_data.get("Waiver_Table_Headers");
		String WaiverBy = Excel_data.get("WaiverBy");
		String WaiverByvalue = Excel_data.get("WaiverByvalue");
		String Detention_Waiver_Saved_Popup = Excel_data.get("Detention_Waiver_Saved_Popup");
		String Waiver_remove_popup = Excel_data.get("Waiver_remove_popup");
		String Waiver_Percentage_Value = Excel_data.get("Waiver_Percentage_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Waiver_Reason_Value = Excel_data.get("Waiver_Reason_Value");
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

			// Remove last element if it's empty
			if (!Act_Waiver_AmountList1.isEmpty() && Act_Waiver_AmountList1.get(Act_Waiver_AmountList1.size() - 1).trim().isEmpty()) {
			    Act_Waiver_AmountList1.remove(Act_Waiver_AmountList1.size() - 1);
			}
			List<String> Act_Waiver_AmountList11 = new ArrayList<String>();
			for (WebElement columns : waiverAmountValueColumns) {

				String ColText = columns.getText();
				Act_Waiver_AmountList11.add(ColText);

			}

			for (int i = 0; i < Act_Waiver_AmountList11.size(); i++) {

				String waiverValue = Act_Waiver_AmountList11.get(i);
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

			int minSize = Math.min(Act_Waiver_AmountList1.size(), ContainersList.size());

			for (int i = 0; i < minSize - 1; i++) {
			    // Scroll to the row to ensure it’s in view
			    WebElement row = listOfElements(driver, DW_Waiver_Amount_ColumnTable).get(i);
			 //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", row);

			    double Expected_Amount = getWaiverPercentAmount(Container_Amount_Lists.get(ContainersList.get(i)), WaiverByvalue);
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
			for (int i = 0; i < minSize; i++) {
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

		Step_End(7, "System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		Step_Start(8, "Click on Edit Button", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(8, "Click on Edit Button", test, test1);

		Step_Start(8, "a.go to the last grid select the container", test, test1);
		scrollBottom(driver);

		waitForDisplay(driver, DW_Waiver_Table_SelectAll_Checkbox);
		jsClick(driver, DW_Waiver_Table_SelectAll_Checkbox);
		Step_End(8, "a.go to the last grid select the container", test, test1);

		Step_Start(8, "b.click the remove -system has validate", test, test1);
		waitForElement(driver, DW_Waiver_Remove_button);
		click(driver, DW_Waiver_Remove_button);
		Step_End(8, "b.click the remove -system has validate", test, test1);

		Step_Start(8, "c.click the yes -containers are removed in the grid.", test, test1);

		waitForPopup(driver, popup_Message, Waiver_remove_popup);

		String Act_Popup_remove = getText(driver, popup_Message);

		if (Act_Popup_remove.contains(Waiver_remove_popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + Waiver_remove_popup + " || Actual : " + Act_Popup_remove);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Waiver_remove_popup + " || Actual : " + Act_Popup_remove, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Waiver_remove_popup + " || Actual : " + Act_Popup_remove);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Waiver_remove_popup + " || Actual : " + Act_Popup_remove,
					test, test1);
		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForDisplay(driver, DW_Waiver_Table_Cell);
		
		if (isdisplayed(driver, DW_Waiver_Table_Cell)) {
			System.out.println(
					"Expected result : Waiver table value should be removed || Actual result is : Waiver Table Values not removed after removing it");
			Extent_fail(driver,
					"Expected result : Waiver table value should be removed || Actual result is : Waiver Table Values not removed after removing it",
					test, test1);
		} else {
			System.out.println(
					"Expected result : Waiver table value should be removed || Actual result is : Waiver Table Values removed after removing it");
			Extent_pass_New(driver,
					"Expected result : Waiver table value should be removed || Actual result is : Waiver Table Values removed after removing it",
					test, test1);
		}

		Step_End(8, "c.click the yes -containers are removed in the grid.", test, test1);

		Step_Start(9, "Select the Rows in Container Grid  ", test, test1);

		mouseOverToElement(driver, DW_Select_All_Checkbox);
		waitForDisplay(driver, DW_Select_All_Checkbox);

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

		ContainersList = new ArrayList<String>();

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
		Step_End(9, "Select the Rows in Container Grid  ", test, test1);

		Step_Start(10, "Select LP radio button, and etner the New % Value ", test, test1);
		waitForElement(driver, DW_Waiver_percent_RadioBtn);
		click(driver, DW_Waiver_percent_RadioBtn);
		waitForDisplay(driver, DW_Waiver_percent_Input);
		if(isElementEnabled(driver, DW_Waiver_percent_Input)) {
		waitForElement(driver, DW_Waiver_percent_Input);
		Newclear(driver, DW_Waiver_percent_Input);
		Actionsendkeys(driver, DW_Waiver_percent_Input, Waiver_Percentage_Value);
		}
		waitForElement(driver, DW_Waiver_Add_button);
		click(driver, DW_Waiver_Add_button);
		Step_End(10, "Select LP radio button, and etner the New % Value ", test, test1);

		Step_Start(11, "Verify that Newly added % amount Days is added in below grid.", test, test1);

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

		// Loop excluding the last value
		for (int i = 0; i < Act_Waiver_AmountList1.size() - 1; i++) {

		    double Expected_Amount = getWaiverPercentAmount(Container_Amount_Lists.get(ContainersList.get(i)),
		            Waiver_Percentage_Value);
		    double Act_Amount = getNumberValue(Act_Waiver_AmountList1.get(i));

		    if (Expected_Amount == Act_Amount) {
		        System.out.println("Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount);
		        Extent_pass_New(driver, "Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount, test, test1);
		    } else {
		        System.out.println("Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount);
		        Extent_fail(driver, "Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Expected_Amount + " || Actual : " + Act_Amount, test, test1);
		    }
		}

		int minSize = Math.min(Act_Waiver_ValuesList1.size(), ContainersList.size());

		for (int i = 0; i < minSize; i++) {
		    String waiverValue = Act_Waiver_ValuesList1.get(i);
		    double exp_Amount = getNumberValue(Waiver_Percentage_Value);
		    double Act_Amount = getNumberValue(waiverValue);

		    if (exp_Amount == Act_Amount) {
		        System.out.println("Waiver Value Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Waiver_Percentage_Value + " || Actual : " + waiverValue);
		        Extent_pass_New(driver,
		                "Waiver Value Matched For the Container : " + ContainersList.get(i)
		                        + "  || Expected  : " + Waiver_Percentage_Value + " || Actual : " + waiverValue,
		                test, test1);
		    } else {
		        System.out.println("Waiver Value Not Matched For the Container : " + ContainersList.get(i)
		                + "  || Expected  : " + Waiver_Percentage_Value + " || Actual : " + waiverValue);
		        Extent_fail(driver,
		                "Waiver Value Not Matched For the Container : " + ContainersList.get(i)
		                        + "  || Expected  : " + Waiver_Percentage_Value + " || Actual : " + waiverValue,
		                test, test1);
		    }
		}
		Step_End(11, "Verify that Newly added % amount Days is added in below grid.", test, test1);

		Step_Start(12, "Click on save Button.", test, test1);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, "Click on save Button.", test, test1);

		Step_Start(13, "Verify System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		waitForPopup(driver, Popup_Message, Detention_Waiver_Saved_Popup);

		Act_Popup = getText(driver, Popup_Message);

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
		Step_End(13, "Verify System shown the Validation \"Detention Waiver saved in Pending mode\"", test, test1);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

			String waiverstatus = getText(driver, DW_WaiverStatus);

			Reversewaiver(driver, BL_Condition, Waiver_number_option, waiverValue, DW_Remarks_Input_value, waiverstatus,
					Agency_User, Detention_Module);

		}

		Extent_completed(testcase_Name, test, test1);

	}
}
