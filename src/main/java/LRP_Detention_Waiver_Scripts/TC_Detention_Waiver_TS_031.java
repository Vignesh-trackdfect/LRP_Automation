package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_031 extends Keywords {

	public void Detention_Waiver_TS_031(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Throwable {

		String testcase_Name = "TC_Detention_Waiver_TS_031";

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
		String Expected_Popup = Excel_data.get("Expected_Popup");
		String Waiver_reason_Search_Column_Header = Excel_data.get("Waiver_reason_Search_Column_Header");
		String Waiver_Reasoncode = Excel_data.get("Waiver_Reasoncode");
		String Expected_Saved_Popup = Excel_data.get("Expected_Saved_Popup");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Free_Days_Input = Excel_data.get("Free_Days_Input");
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

		Step_Start(4, " Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, "Select the container details, and input the Free time as 20 days", test, test1);
		scrollUsingElement(driver, DW_Containers_Column);

		scrollBottom(driver);
		waitForElement(driver, DW_Containers_Column);
		scrollElementToCenter(driver, DW_Containers_Column);
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
			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
			for (String container : Containers_Select) {

				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);

				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);

			}
		}

		waitForElement(driver, Addtional_free_days_radio_button);
		click(driver, Addtional_free_days_radio_button);

		if (!isElementEnabled(driver, DW_Additional_Free_Days)) {

			waitForElement(driver, DW_Additional_Free_Days);
		}

		waitForElement(driver, DW_Additional_Free_Days);
		doubleClick(driver, DW_Additional_Free_Days);

		Newclear(driver, DW_Additional_Free_Days);

		sendKeys(driver, DW_Additional_Free_Days, Free_Days_Input);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);
		Step_End(5, "Select the container details, and input the Free time as 20 days", test, test1);
		Step_Start(6, "Click on save Button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(6, "Click on save Button", test, test1);

		Step_Start(7, "Select the Waiver reason Search Button, and select the waiver reason.", test, test1);

		waitForPopup(driver, Popup_Message, Expected_Popup);

		String Actual_Popup = getText(driver, Popup_Message);

		if (Expected_Popup.trim().equals(Actual_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up value is : " + Expected_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + Expected_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + Expected_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + Expected_Popup
					+ "   || Actual Pop-up value is : " + Actual_Popup, test, test1);
		}
		waitForElement(driver, DW_Waiver_Reason_Search_Button);
		jsClick(driver, DW_Waiver_Reason_Search_Button);
		twoColumnSearchWindow(driver, Waiver_reason_Search_Column_Header, BookingSearch_Condition, Waiver_Reasoncode);

		Step_End(7, "Select the Waiver reason Search Button, and select the waiver reason.", test, test1);

		Step_Start(8, "Click on save Button", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(8, "Click on save Button", test, test1);

		Step_Start(9,
				"Verify that system should be saved the Detention Waiver Verify this msg 'Detention Waiver saved in Pending mode'",
				test, test1);

		waitForPopup(driver, Popup_Message, Expected_Saved_Popup);

		String Actual_Saved_Popup = getText(driver, Popup_Message);

		if (Expected_Saved_Popup.trim().equals(Actual_Saved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Saved_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Saved_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Saved_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + Expected_Saved_Popup
					+ "   || Actual Pop-up value is : " + Actual_Saved_Popup, test, test1);
		}
		Step_End(9,
				"Verify that system should be saved the Detention Waiver Verify this msg 'Detention Waiver saved in Pending mode'",
				test, test1);
		Step_Start(10, "Verify that Waiver reason also listed", test, test1);
		waitForElement(driver, DW_Waiver_Reason_Input_Field);
		String waiver_Reason = getAttribute(driver, DW_Waiver_Reason_Input_Field, "value");
		if (!waiver_Reason.equals("")) {
			System.out.println(
					"Matched || Expected result : Waiver reason list should be displayed || Actual result :  Actual Waiver Reason is : "
							+ waiver_Reason);
			Extent_pass_New(driver,
					"Matched || Expected result : Waiver reason list should be displayed || Actual result : Actual Waiver Reason is : "
							+ waiver_Reason,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result : Waiver reason list should be displayed || Actual result : Actual Waiver Reason is Not Available : "
							+ waiver_Reason);
			Extent_pass_New(driver,
					"Not Matched || Expected result : Waiver reason list should be displayed || Actual result : Actual Waiver Reason is Not Available : "
							+ waiver_Reason,
					test, test1);
		}
		Step_End(10, "Verify that Waiver reason also listed", test, test1);
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