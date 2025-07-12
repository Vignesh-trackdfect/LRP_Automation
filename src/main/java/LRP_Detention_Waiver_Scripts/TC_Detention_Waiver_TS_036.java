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



public class TC_Detention_Waiver_TS_036 extends Keywords {

	public void Detention_Waiver_TS_036(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException {

		String testcase_Name = "TC_Detention_Waiver_TS_036";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");

		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String BL_Number = Excel_data.get("BL_Number");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
		String Wiver_number_option = Excel_data.get("Wiver_number_option");
		String DW_Remarks_Input_value = Excel_data.get("DW_Remarks_Input_value");
		
		String Lumbsum_Value_Edit = Excel_data.get("Lumbsum_Value_Edit");

		String Detention_Waiver_Saved_Popup = Excel_data.get("Detention_Waiver_Saved_Popup");
		String Waiver_remove_popup = Excel_data.get("Waiver_remove_popup");

		String Lumbsum_Value = Excel_data.get("Lumbsum_Value");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, Weiver_For);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		Step_Start(2, "Click on BL No Search Field", test, test1);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, BL_Number, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, "Click on show Button", test, test1);

		Step_Start(5, "Select the container details", test, test1);
		mouseOverToElement(driver, DW_Select_All_Checkbox);

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
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
		scrollUsingElement(driver, DW_Lumpsum_radioBtn);
		waitForElement(driver, DW_Lumpsum_radioBtn);
		click(driver, DW_Lumpsum_radioBtn);
		waitForDisplay(driver, DW_Lumpsum_Input);
		if(isElementEnabled(driver, DW_Lumpsum_Input)) {
		waitForElement(driver, DW_Lumpsum_Input);
		Newclear(driver, DW_Lumpsum_Input);
		Actionsendkeys(driver, DW_Lumpsum_Input, Lumbsum_Value);
		}
		click(driver, DW_Lumpsum_radioBtn);

		waitForElement(driver, DW_Waiver_Add_button);
		click(driver, DW_Waiver_Add_button);
		

		waitForElement(driver, DW_Waiver_Table_Cell);

		List<WebElement> waiverValueColumn = listOfElements(driver, DW_Waiver_Values_ColumnTable);
		List<String> Act_Waiver_ValuesList = new ArrayList<String>();
		for (WebElement columns : waiverValueColumn) {

			String ColText = columns.getText();
			Act_Waiver_ValuesList.add(ColText);

		}

		Step_End(5, "Select the container details", test, test1);
		Step_Start(6, "Click on save Button", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
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
					"Fail || Expected result is : Waiver table value should be removed || Actual result is : Waiver Table Values not removed after removing it");
			Extent_fail(driver,
					"Fail || Expected result is : Waiver table value should be removed || Actual result is : Waiver Table Values not removed after removing it",
					test, test1);
		} else {
			System.out.println(
					"Pass || Expected result is : Waiver table value should be removed || Actual result is : Waiver Table Values are removed after removing it");
			Extent_pass_New(driver,
					"Pass || Expected result is : Waiver table value should be removed || Actual result is : Waiver Table Values are removed after removing it",
					test, test1);
		}
		Step_End(8, "c.click the yes -containers are removed in the grid.", test, test1);

		Step_Start(9, "Select the Rows in Container Grid  ", test, test1);
		mouseOverToElement(driver, DW_Select_All_Checkbox);
		waitForDisplay(driver, DW_Select_All_Checkbox);

		ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
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

		Step_Start(10, "Select LP radio button, and etner the New LP Value, ", test, test1);
		scrollUsingElement(driver, DW_Lumpsum_radioBtn);
		waitForElement(driver, DW_Lumpsum_radioBtn);
		click(driver, DW_Lumpsum_radioBtn);
		waitForDisplay(driver, DW_Lumpsum_Input);
		if(isElementEnabled(driver, DW_Lumpsum_Input)) {
		waitForElement(driver, DW_Lumpsum_Input);
		Newclear(driver, DW_Lumpsum_Input);
		Actionsendkeys(driver, DW_Lumpsum_Input, Lumbsum_Value_Edit);
		}
		click(driver, DW_Lumpsum_radioBtn);

		waitForElement(driver, DW_Waiver_Add_button);
		click(driver, DW_Waiver_Add_button);	
		Step_End(10, "Select LP radio button, and etner the New LP Value, ", test, test1);

		Step_Start(11, "Verify that Newly added LP amount Days is added in below grid", test, test1);

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
			double exp_Amount = getNumberValue(Lumbsum_Value_Edit);
			double Act_Amount = getNumberValue(waiverValue);
			if (exp_Amount == Act_Amount) {
				System.out.println("Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + Lumbsum_Value_Edit + " || Actual : " + waiverValue);
				Extent_pass_New(driver, "Waiver Amount Value Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + Lumbsum_Value_Edit + " || Actual : " + waiverValue, test, test1);
			} else {
				System.out.println("Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + Lumbsum_Value_Edit + " || Actual : " + waiverValue);
				Extent_fail(driver, "Waiver Amount Value Not Matched For the Container : " + ContainersList.get(i)
						+ "  || Expected  : " + Lumbsum_Value_Edit + " || Actual : " + waiverValue, test, test1);
			}

		}


		Step_End(11, "Verify that Newly added LP amount Days is added in below grid", test, test1);

		Step_Start(12, "Click on save Button.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
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

		scrollTop(driver);

		String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

		String waiverstatus = getText(driver, DW_WaiverStatus);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			Reversewaiver(driver, BookingSearch_Condition, Wiver_number_option, waiverValue, DW_Remarks_Input_value,
					waiverstatus,AgencyName,Detention_Module);

		}
		
		Extent_completed(testcase_Name, test, test1);

	}

}
