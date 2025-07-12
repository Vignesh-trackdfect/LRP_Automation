package LRP_Detention_Waiver_Scripts;

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

public class TC_Detention_Waiver_TS_043 extends Keywords {

	public void Detention_Waiver_TS_043(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_043";

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
		String Waiver_Table_Headers = Excel_data.get("Waiver_Table_Headers");
		String Remark = Excel_data.get("Remark");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String WaivervalueCounter = Excel_data.get("WaivervalueCounter");
		String Counter_Popup = Excel_data.get("Counter_Popup");
		String LineContainerNumbers = Excel_data.get("LineContainerNumbers");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");
		String ExpectedStatus = Excel_data.get("ExpectedStatus");
		String GridColumns = Excel_data.get("GridColumns");

		String Waiver_number_option = Excel_data.get("Waiver_number_option");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
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

		Step_Start(5, "Select the container details, and input the Free days/Waiver Lumsump/Waiver %", test, test1);

		waitForElement(driver, DW_BLNo_Input);

		scrollUsingElement(driver, DW_ContainersGrid);

		reArrangeAG_GridColumnsWithoutCheckbox(driver, GridColumns);

		List<String> ContainersList = new ArrayList<String>();
		List<String> TariffAmount = new ArrayList<String>();

		if (Select_Containers.equals("Select All")) {

			checkBox(driver, DW_ContainersGrid_SelectAll, "Yes");

			List<WebElement> element = listOfElements(driver, DW_Container_List);

			for (int i = 0; i < element.size(); i++) {

				WebElement element1 = element.get(i);

				moveToElement(driver, element1);

				String containernum = element1.getText();

				if (!containernum.isEmpty()) {

					ContainersList.add(containernum);
				}

			}

			for (String containerNum : ContainersList) {

				String Tariff_element = String.format(DW_Tariffamount, containerNum);

				String Amount = getText(driver, Tariff_element);

				TariffAmount.add(Amount);

			}

		} else if (Select_Containers.equals("Selected Containers")) {

			List<String> givencontainers = splitAndExpand(ContainerNumbers);
		

			
		
			for (String containerNum : givencontainers) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, containerNum);
				
				String Tariff_element = String.format(DW_Tariffamount, containerNum);
				
			

				String Amount = getText(driver, Tariff_element);

				TariffAmount.add(Amount);

				ContainersList.add(containerNum);
				
				String container_element = String.format(DW_Container_Select, containerNum);

				mouseOverToElement(driver, container_element);

				jsClick(driver, container_element);

			}

		}

		scrollBottom(driver);

		if (WaiverBy.equalsIgnoreCase("Additional Free Days")) {

			waitForElement(driver, DW_Addition_Days_Input);
			Newclear(driver, DW_Addition_Days_Input);
			Actionsendkeys(driver, DW_Addition_Days_Input, WaiverByvalue);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Add_button);

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

			waitForElement(driver, DW_Waiver_Values_ColumnTable);

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

		Step_End(5, "Select the container details, and input the Free days/Waiver Lumsump/Waiver %", test, test1);

		Step_Start(6, "Enter the Remarks", test, test1);

		waitForElement(driver, DW_Remarks);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		Step_End(6, "Enter the Remarks", test, test1);

		Step_Start(7, "Click the Submit button", test, test1);

		waitForElement(driver, DW_Submitted);
		click(driver, DW_Submitted);

		Step_End(7, "Click the Submit button", test, test1);

		Step_Start(8, "Click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Click on save button", test, test1);

		Step_Start(9, "Verify the Msg Detention Waiver saved in Submitted mode", test, test1);

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

		Step_End(9, "Verify the Msg Detention Waiver saved in Submitted mode", test, test1);

		Step_Start(10, "Switch to Line Login", test, test1);

		ResetProfile(driver);

		Step_End(10, "Switch to Line Login", test, test1);

		Step_Start(11, "Open Detention Waiver module", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(11, "Open Detention Waiver module", test, test1);

		Step_Start(12, "Click on Search Button", test, test1);

		Step_Start(13, "Enter Waiver No/ BL NO for", test, test1);

		Step_Start(14, "load  the data", test, test1);

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

		Step_End(12, "Click on Search Button", test, test1);

		Step_End(13, "Enter Waiver No/ BL NO for", test, test1);

		Step_End(14, "load  the data", test, test1);

		Step_Start(15, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(15, "Click on Edit Button", test, test1);

		Step_Start(16, "Select the Containers", test, test1);

		waitForElement(driver, DW_BLNo_Input);
		scrollUsingElement(driver, DW_ContainersGrid);

		reArrangeAG_GridColumnsWithoutCheckbox(driver, GridColumns);

		List<String> givencontainers = splitAndExpand(LineContainerNumbers);

		List<String> Line_Allcontainers = new ArrayList<String>();
		List<String> Line_TariffAmount = new ArrayList<String>();

		if (Select_Containers.equals("Select All")) {

			checkBox(driver, DW_ContainersGrid_SelectAll, "Yes");

			List<WebElement> element = listOfElements(driver, DW_Container_List);

			for (int j = 0; j < element.size(); j++) {

				WebElement element1 = element.get(j);

				moveToElement(driver, element1);

				String containernum = element1.getText();

				if (!containernum.isEmpty()) {

					Line_Allcontainers.add(containernum);
				}

			}

			for (String containerNum : Line_Allcontainers) {

				String Tariff_element = String.format(DW_Tariffamount, containerNum);

				String Amount = getText(driver, Tariff_element);

				Line_TariffAmount.add(Amount);

			}

		} else if (Select_Containers.equals("Selected Containers")) {

			for (String containerNum : givencontainers) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, containerNum);

				String Tariff_element = String.format(DW_Tariffamount, containerNum);

				String Amount = getText(driver, Tariff_element);

				Line_TariffAmount.add(Amount);

				Line_Allcontainers.add(containerNum);
				

				String container_element = String.format(DW_Container_Select, containerNum);

				mouseOverToElement(driver, container_element);

				jsClick(driver, container_element);

			}

		}

		Step_End(16, "Select the Containers", test, test1);

		Step_Start(17, "Enter the Free days/Waiver Lumsump/Waiver % and Click on Add Button", test, test1);

//		waitForElement(driver, DW_percentage);
//		click(driver, DW_percentage);
//
//		waitForElement(driver, DW_percentage_Input);
//		click(driver, DW_percentage_Input);
//
//		Newclear(driver, DW_percentage_Input);
//		Actionsendkeys(driver, DW_percentage_Input, WaiverPercentageCounter);
//
//		waitForElement(driver, DW_Add_button);
//		click(driver, DW_Add_button);

		Step_Start(18, "Verify that system allow to added the Free days/Waiver Lumsump/Waiver %", test, test1);

		scrollBottom(driver);

		if (WaiverBy.equalsIgnoreCase("Additional Free Days")) {

			waitForElement(driver, DW_Addition_Days_Input);
			Newclear(driver, DW_Addition_Days_Input);
			Actionsendkeys(driver, DW_Addition_Days_Input, WaivervalueCounter);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

			if (Select_Containers.equals("Select All")) {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_Line_Freedays, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			} else {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_Line_Freedays, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			}

		} else if (WaiverBy.equalsIgnoreCase("Waiver Lumpsum")) {

			waitForElement(driver, DW_Lumpsum_radioBtn);
			click(driver, DW_Lumpsum_radioBtn);
			waitForDisplay(driver, DW_Lumpsum_Input);
			if(isElementEnabled(driver, DW_Lumpsum_Input)) {
			waitForElement(driver, DW_Lumpsum_Input);
			Newclear(driver, DW_Lumpsum_Input);
			Actionsendkeys(driver, DW_Lumpsum_Input, WaivervalueCounter);
			}
			click(driver, DW_Lumpsum_radioBtn);

			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

			if (Select_Containers.equals("Select All")) {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_Line_Freedays, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			} else {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_Line_Freedays, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			}

		} else if (WaiverBy.equalsIgnoreCase("Waiver %")) {

			waitForElement(driver, DW_Waiver_percent_RadioBtn);
			click(driver, DW_Waiver_percent_RadioBtn);
			waitForDisplay(driver, DW_Waiver_percent_Input);
			if(isElementEnabled(driver, DW_Waiver_percent_Input)) {
			waitForElement(driver, DW_Waiver_percent_Input);
			Newclear(driver, DW_Waiver_percent_Input);
			Actionsendkeys(driver, DW_Waiver_percent_Input, WaivervalueCounter);
			}
			waitForElement(driver, DW_Waiver_Add_button);
			click(driver, DW_Waiver_Add_button);

			waitForElement(driver, DW_Waiver_Table_Cell);

			if (Select_Containers.equals("Select All")) {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_WaiverValue, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			} else {

				for (String Containume : Line_Allcontainers) {

					double exp_Amount = getNumberValue(WaivervalueCounter);

					String xpath = String.format(DW_WaiverValue, Containume);

					String Waivervalue = getText(driver, xpath);

					double Act_Amount = getNumberValue(Waivervalue);

					if (exp_Amount == Act_Amount) {

						System.out.println("Selected Containers are added with given waiver Value || Expected value : "
								+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_pass_New(driver,
								"Selected Containers are added with given waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);

					} else {

						System.out.println(
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue);
						Extent_fail(driver,
								"Selected Containers are added with diffetent waiver Value || Expected value : "
										+ WaivervalueCounter + " || Acutal value : " + Waivervalue,
								test, test1);
					}

				}

			}

			int k = 0;

			for (String Containerno : Line_Allcontainers) {

				String WaiverAmountField = String.format(DW_Tariffamount_Grid, Containerno);

				String Waiver_Amount = getText(driver, WaiverAmountField);

				double ActualAmount = Double.valueOf(Waiver_Amount.replace(",", ""));

				String percent = Line_TariffAmount.get(k);

				double convertedamount = getWaiverPercentAmount(percent, WaiverByvalue);

				if (ActualAmount == convertedamount) {

					System.out.println("Selected Containers are added with Correct waiver Amount || Expected Amount : "
							+ convertedamount + " || Acutal Amount : " + ActualAmount);
					Extent_pass_New(driver,
							"Selected Containers are added with Correct waiver Amount || Expected Amount : "
									+ convertedamount + " || Acutal Amount : " + ActualAmount,
							test, test1);

				} else {

					System.out
							.println("Selected Containers are added with diffetent waiver Amount || Expected Amount : "
									+ convertedamount + " || Acutal Amount : " + ActualAmount);
					Extent_fail(driver,
							"Selected Containers are added with diffetent waiver Amount || Expected Amount : "
									+ convertedamount + " || Acutal Amount : " + ActualAmount,
							test, test1);
				}

				k++;

			}

		}

		Step_End(18, "Verify that system allow to added the Free days/Waiver Lumsump/Waiver %", test, test1);

		Step_End(17, "Enter the Free days/Waiver Lumsump/Waiver %  and Click on Add Button", test, test1);

		Step_Start(19, "Click remaks tab add remarks and Counter Button", test, test1);

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

		waitForElement(driver, DW_Counter);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Counter);

		Step_End(19, "Click remaks tab add remarks and Counter Button", test, test1);

		Step_Start(20, "Click on save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup, Counter_Popup);
		String Counter_popup_Message = getText(driver, popup);

		if (Counter_popup_Message.equals(Counter_Popup)) {

			System.out.println("Detention Waiver submitted successfully || Expected popup : " + Counter_Popup
					+ " || Actual popup : " + Counter_popup_Message);
			Extent_pass_New(driver, "Detention Waiver submitted successfully || Expected popup : " + Counter_Popup
					+ " || Actual popup : " + Counter_popup_Message, test, test1);

		} else {
			System.out.println("Detention Waiver not submitted || Expected popup : " + Counter_Popup
					+ " || Actual popup : " + Counter_popup_Message);
			Extent_fail(driver, "Detention Waiver not submitted || Expected popup : " + Counter_Popup
					+ " || Actual popup : " + Counter_popup_Message, test, test1);

		}

		Step_End(20, "Click on save Button", test, test1);

		Step_Start(21, "Verify that Status is now changed into Open", test, test1);

		waitForElement(driver, DW_WaiverStatus);
		String NewStatus = getText(driver, DW_WaiverStatus);

		if (NewStatus.contains(ExpectedStatus)) {

			System.out.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ NewStatus);
			Extent_pass_New(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ NewStatus,
					test, test1);

		} else {

			System.out.println(
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ NewStatus);
			Extent_fail(driver,
					"Expected result : After retrive the data, detention waiver status should show || Actual result : After retrive the data, detention waiver status shows "
							+ NewStatus,
					test, test1);

		}

		String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

		waitForElement(driver, DW_WaiverStatus);
		String waiverstatus = getText(driver, DW_WaiverStatus);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			Reversewaiver(driver, BL_Condition, Waiver_number_option, waiverValue, DW_Remarks_Input_value, waiverstatus,
					AgencyName, Detention_Module);

		}

		Step_End(21, "Verify that Status is now changed into Open", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
