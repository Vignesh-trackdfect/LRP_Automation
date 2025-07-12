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

public class TC_Detention_Waiver_TS_041 extends Keywords {

	public void Detention_Waiver_TS_041(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_041";

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
		String LumpsomAmount = Excel_data.get("LumpsomAmount");
		String Remark = Excel_data.get("Remark");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String LumpsomAmountCounter = Excel_data.get("LumpsomAmountCounter");
		String Counter_Popup = Excel_data.get("Counter_Popup");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
		String Waiver_number_option = Excel_data.get("Waiver_number_option");

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

		Step_Start(5, "Select the container details, and input the LP 200 days", test, test1);

		scrollElementToView(driver, Detention_container_Filter);
		if (Select_Containers.equals("Select All")) {

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else if (Select_Containers.equals("Selected Containers")) {

			List<String> givencontainers = splitAndExpand(ContainerNumbers);

			for (String containerNum : givencontainers) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, containerNum);

				String container_element = String.format(DW_Container_Select, containerNum);

				mouseOverToElement(driver, container_element);

				jsClick(driver, container_element);

			}

		}

		waitForElement(driver, DW_WaiverLumpsum);
		click(driver, DW_WaiverLumpsum);
		waitForDisplay(driver, DW_WaiverLumpsum_input);
		if(isElementEnabled(driver, DW_WaiverLumpsum_input)) {
		waitForElement(driver, DW_WaiverLumpsum_input);
		click(driver, DW_WaiverLumpsum_input);

		Newclear(driver, DW_WaiverLumpsum_input);
		Actionsendkeys(driver, DW_WaiverLumpsum_input, LumpsomAmount);
		}
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		List<WebElement> WaiverAmounts = listOfElements(driver, DW_WaiverAmount_GridList);
		double waiverValue_Exp=Double.parseDouble(LumpsomAmount);

		for (WebElement ele : WaiverAmounts) {

			String WaiverAmount = ele.getText();
			
			String amount = String.valueOf((int) Double.parseDouble(WaiverAmount.replace(",", "")));
			double waiverValue=Double.parseDouble(amount);

			// Now 'amount' = "1000"
			System.out.println("Converted amount: " + amount);


			if (waiverValue==waiverValue_Exp) {

				System.out.println("Selected Containers are added with given waiver value || Expected value : "
						+ waiverValue_Exp + " || Acutal value : " + waiverValue);
				Extent_pass_New(driver, "Selected Containers are added with given waiver value || Expected value : "
						+ waiverValue_Exp + " || Acutal value : " + waiverValue, test, test1);

			} else {

				System.out.println("Selected Containers are added with diffetent waiver value || Expected value : "
						+ waiverValue_Exp + " || Acutal value : " + waiverValue);
				Extent_fail(driver, "Selected Containers are added with diffetent waiver value || Expected value : "
						+ waiverValue_Exp + " || Acutal value : " + waiverValue, test, test1);
			}

		}

		Step_End(5, "Select the container details, and input the LP 200 days", test, test1);

		scrollTop(driver);

		Step_Start(6, "Enter the remarks", test, test1);

		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		Step_End(6, "Enter the remarks", test, test1);

		Step_Start(7, "Click the Submit button", test, test1);

		waitForElement(driver, DW_Submitted);
		mouseOverToElement(driver, SaveButton_ToolBar);
		click(driver, DW_Submitted);

		Step_End(7, "Click the Submit button", test, test1);

		Step_Start(8, "click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "click on save button", test, test1);

		Step_Start(9, "Verify the Msg 'Detention Waiver saved in Submitted mode'", test, test1);

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

		Step_End(9, "Verify the Msg 'Detention Waiver saved in Submitted mode'", test, test1);

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

		scrollElementToView(driver, Detention_container_Filter);
		List<String> Selectall_ContainerNo = new ArrayList<String>();

		List<String> givencontainers = splitAndExpand(ContainerNumbers);

		if (Select_Containers.equals("Select All")) {

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

			List<WebElement> Containerdetails = listOfElements(driver, DW_Container_List);

			for (WebElement element : Containerdetails) {

				moveToElement(driver, element);

				String containernum = element.getText();

				if (!containernum.isEmpty()) {

					Selectall_ContainerNo.add(containernum);
				}

			}

		} else if (Select_Containers.equals("Selected Containers")) {

			for (String containerNum : givencontainers) {
				waitForElement(driver, Detention_container_Filter);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
				
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, containerNum);

				String container_element = String.format(DW_Container_Select, containerNum);

				mouseOverToElement(driver, container_element);

				jsClick(driver, container_element);

			}

		}

		Step_End(16, "Select the Containers", test, test1);

		Step_Start(17, "Enter the LP amount and Click on Add Button", test, test1);

		waitForElement(driver, DW_WaiverLumpsum);
		click(driver, DW_WaiverLumpsum);
		waitForDisplay(driver, DW_WaiverLumpsum_input);
		if(isElementEnabled(driver, DW_WaiverLumpsum_input)) {
		Newclear(driver, DW_WaiverLumpsum_input);
		Actionsendkeys(driver, DW_WaiverLumpsum_input, LumpsomAmountCounter);
		}
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_End(17, "Enter the LP amount and Click on Add Button", test, test1);

		Step_Start(18, "Verify that system allow to added the LP amount", test, test1);

		waitForElement(driver, DW_Add_button);

		waiverValue_Exp=Double.parseDouble(LumpsomAmountCounter);
		if (Select_Containers.equals("Select All")) {

			for (String Containume : Selectall_ContainerNo) {

				String xpath = String.format(DW_WaiverAmount, Containume);

				String WaiverAmount = getText(driver, xpath);
				double waiverValue=Double.parseDouble(WaiverAmount);

				if (waiverValue==waiverValue_Exp) {

					System.out.println("Selected Containers are added with given waiver Amount || Expected value : "
							+ waiverValue_Exp + " || Acutal value : " + waiverValue);
					Extent_pass_New(driver,
							"Selected Containers are added with given waiver Amount || Expected value : "
									+ waiverValue_Exp + " || Acutal value : " + waiverValue,
							test, test1);

				} else {

					System.out.println("Selected Containers are added with diffetent waiver Amount || Expected value : "
							+ waiverValue_Exp + " || Acutal value : " + waiverValue);
					Extent_fail(driver,
							"Selected Containers are added with diffetent waiver Amount || Expected value : "
									+ waiverValue_Exp + " || Acutal value : " + waiverValue,
							test, test1);
				}

			}

		} else {

			for (String Containume : givencontainers) {

				String xpath = String.format(DW_WaiverAmount, Containume);

				String WaiverAmount = getText(driver, xpath);
				
				String amount = String.valueOf((int) Double.parseDouble(WaiverAmount.replace(",", "")));

				// Now 'amount' = "1000"
				System.out.println("Converted amount: " + amount);
				double waiverValue=Double.parseDouble(amount);


				if (waiverValue==waiverValue_Exp) {

					System.out.println("Selected Containers are added with given waiver Amount || Expected value : "
							+ waiverValue_Exp + " || Acutal value : " + waiverValue);
					Extent_pass_New(driver,
							"Selected Containers are added with given waiver Amount || Expected value : "
									+ waiverValue_Exp + " || Acutal value : " + waiverValue,
							test, test1);

				} else {

					System.out.println("Selected Containers are added with diffetent waiver Amount || Expected value : "
							+ waiverValue_Exp + " || Acutal value : " + waiverValue);
					Extent_fail(driver,
							"Selected Containers are added with diffetent waiver Amount || Expected value : "
									+ waiverValue_Exp + " || Acutal value : " + waiverValue,
							test, test1);
				}

			}

			Step_End(18, "Verify that system allow to added the LP amount", test, test1);
		}

		Step_Start(19, "Click on save Button", test, test1);

		scrollTop(driver);

		waitForElement(driver, DW_Remarks);
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

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(19, "Click on save Button", test, test1);

		Step_Start(20, "Verify that system saved same inform after saving Detention Waiver", test, test1);

		waitForPopup(driver, Popup_Message, Counter_Popup);
		String Counter_popup_Message = getText(driver, Popup_Message);

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

		Step_End(20, "Verify that system saved same inform after saving Detention Waiver", test, test1);

		String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

		waitForElement(driver, DW_WaiverStatus);
		String waiverstatus = getText(driver, DW_WaiverStatus);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			Reversewaiver(driver, BL_Condition, Waiver_number_option, waiverValue, Remark, waiverstatus, AgencyName,
					Detention_Module);

		}
		waitForElement(driver, SaveButton_ToolBar);

		Extent_completed(testcase_Name, test, test1);
	}
}
