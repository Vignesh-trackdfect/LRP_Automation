package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_033 extends Keywords {

	public void Detention_Waiver_TS_033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Throwable {

		String testcase_Name = "TC_Detention_Waiver_TS_033";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String BL_Number = Excel_data.get("BL_Number");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Global_Configuration_Attribute = Excel_data.get("Global_Configuration_Attribute");
		String Global_Configuration_Value = Excel_data.get("Global_Configuration_Value");
		String Global_Configuration_Reset_Value = Excel_data.get("Global_Configuration_Reset_Value");
		String Global_Configuration_Reset_Option = Excel_data.get("Global_Configuration_Reset_Option");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Additional_Free_Days = Excel_data.get("Additional_Free_Days");
		String Expected_Saved_Popup = Excel_data.get("Expected_Saved_Popup");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Dropdown_condition = Excel_data.get("Dropdown_condition");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Delete_option_perform = Excel_data.get("Delete_option_perform");
		String Wiver_number_option = Excel_data.get("Wiver_number_option");
		String DW_Remarks_Input_value = Excel_data.get("DW_Remarks_Input_value");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		setGlobalConfiguration(driver, Global_Configuration_Module, Global_Configuration_Attribute,
				Global_Configuration_Value);
		SwitchProfile(driver, AgencyName);
		Extent_cal(test, test1, "Open Detention Waiver");

		Step_Start(1, "A.Open Detention weiver Module", test, test1);

		moduleNavigate(driver, Detention_Module);
		Step_End(1, "A.Open Detention weiver Module", test, test1);

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

//		Step_Start(5, "Verify that waiver Reason option not listing", test, test1);

		waitForDisplay(driver, DW_Total_records);
		scrollUsingElement(driver, DW_Total_records);
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
				mouseOverToElement(driver, DW_Remarks_Input);
				click(driver, Detention_container_Filter);
				waitForElement(driver, Detention_container_Filter_input);
				scrollBottom(driver);
				clear(driver, Detention_container_Filter_input);

				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);

				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
			}
			ContainersList.addAll(Containers_Select);
		}

//		Step_End(5, "Verify that waiver Reason option not listing", test, test1);

		Step_Start(5, "Select the container details, and input the Free time", test, test1);
		waitForElement(driver, DW_Additional_Free_Days);
		doubleClick(driver, DW_Additional_Free_Days);

		Newclear(driver, DW_Additional_Free_Days);

		sendKeys(driver, DW_Additional_Free_Days, Additional_Free_Days);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		scrollTop(driver);
		waitForElement(driver, DW_PLA_Value);
		String act_PLA_Value = getText(driver, DW_PLA_Value);
		System.out.println("act_PLA_Value :" + act_PLA_Value);

		waitForElement(driver, DW_POL_Value);
		String act_POL_Value = getText(driver, DW_POL_Value);
		System.out.println("act_POL_Value :" + act_POL_Value);

		waitForElement(driver, DW_POD_Value);
		String act_POD_Value = getText(driver, DW_POD_Value);
		System.out.println("act_POD_Value :" + act_POD_Value);

		waitForElement(driver, DW_PLD_Value);
		String act_PLD_Value = getText(driver, DW_PLD_Value);
		System.out.println("act_PLD_Value :" + act_PLD_Value);

		moduleNavigate(driver, Agency_Master_Module);

		scrollTop(driver);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Dropdown_condition, Global_Search_Type, AgencyName, "", "", "", "");

		waitForElement(driver, Controlling_Ports_AM);
		click(driver, Controlling_Ports_AM);

		waitForElement(driver, AM_Controlling_Ports_Filter);
		click(driver, AM_Controlling_Ports_Filter);

		waitForElement(driver, AM_Port_Code_Input_Field);
		click(driver, AM_Port_Code_Input_Field);

		List<String> locationValues = new ArrayList<>();
		locationValues.add(act_POL_Value);
		locationValues.add(act_POD_Value);
		locationValues.add(act_PLA_Value);
		locationValues.add(act_PLD_Value);

		for (int i = 0; i < locationValues.size(); i++) {

			String value = locationValues.get(i);
			waitForElement(driver, AM_Port_Code_Input_Field);
			clear(driver, AM_Port_Code_Input_Field);
			sendKeys(driver, AM_Port_Code_Input_Field, value);

			if (!isdisplayed(driver, AM_Port_Code_Row_Values)) {
				System.out.println("Matched || Expected value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value
						+ ", PLA-" + act_PLA_Value + ", and PLD-" + act_PLD_Value
						+ "  values should not be displayed in the Agency Master screen for the agency :" + AgencyName
						+ " || Actual value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value + ", PLA-"
						+ act_PLA_Value + ", and PLD-" + act_PLD_Value
						+ "  values is not displayed in the Agency Master screen for the agency :" + AgencyName);
				Extent_pass_New(driver,
						"Matched || Expected value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value + ", PLA-"
								+ act_PLA_Value + ", and PLD-" + act_PLD_Value
								+ "  values should not be displayed in the Agency Master screen for the agency :"
								+ AgencyName + " || Actual value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value
								+ ", PLA-" + act_PLA_Value + ", and PLD-" + act_PLD_Value
								+ "  values is not displayed in the Agency Master screen for the agency :" + AgencyName,
						test, test1);
			} else {

				System.out.println("Not Matched || Expected value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value
						+ ", PLA-" + act_PLA_Value + ", and PLD-" + act_PLD_Value
						+ "  values should not be displayed in the Agency Master screen for the agency :" + AgencyName
						+ " || Actual value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value + ", PLA-"
						+ act_PLA_Value + ", and PLD-" + act_PLD_Value
						+ "  values is displayed in the Agency Master screen for the agency :" + AgencyName);
				Extent_fail(driver,
						"Not Matched || Expected value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value + ", PLA-"
								+ act_PLA_Value + ", and PLD-" + act_PLD_Value
								+ "  values should not be displayed in the Agency Master screen for the agency :"
								+ AgencyName + " || Actual value is : POL-" + act_POL_Value + ", POD-" + act_POD_Value
								+ ", PLA-" + act_PLA_Value + ", and PLD-" + act_PLD_Value
								+ "  values is displayed in the Agency Master screen for the agency :" + AgencyName,
						test, test1);

			}

		}
		waitForElement(driver, Module_Close);
		jsClick(driver, Module_Close);

		Step_End(5, "Select the container details, and input the Free time", test, test1);

		Step_Start(6, "Click on save Button", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Expected_Saved_Popup);

		Step_End(6, "Click on save Button", test, test1);

		Step_Start(7, "Verify that Detention Waiver saved", test, test1);

		String Actual_Popup = getText(driver, Popup_Message);

		if (Expected_Saved_Popup.trim().equals(Actual_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup, test, test1);
		}

		Step_End(7, "Verify that Detention Waiver saved", test, test1);

		scrollTop(driver);

		String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

		String waiverstatus = getText(driver, DW_WaiverStatus);

		if (Delete_option_perform.equalsIgnoreCase("YES")) {

			Reversewaiver(driver, BookingSearch_Condition, Wiver_number_option, waiverValue, DW_Remarks_Input_value,
					waiverstatus, AgencyName, Detention_Module);

		}
		scrollTop(driver);

		reSetGlobalConfiguration(driver, Global_Configuration_Reset_Option, Global_Configuration_Module,
				Global_Configuration_Attribute, Global_Configuration_Reset_Value);

		Extent_completed(testcase_Name, test, test1);
	}
}
