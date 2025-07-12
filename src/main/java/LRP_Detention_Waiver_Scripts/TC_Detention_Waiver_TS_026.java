package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_026 extends Keywords {

	public void Detention_Waiver_TS_026(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Throwable {

		String testcase_Name = "TC_Detention_Waiver_TS_026";

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
		String percentage_Value = Excel_data.get("percentage_Value");
		String Expected_Popup = Excel_data.get("Expected_Popup");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		Extent_cal(test, test1, "Open Global configuraiton module,");

		Step_Start(1, "1.Select the Condition fileter option,\r\n" + "2. Select WPE Attribute Value,\r\n"
				+ "3. Verify WPE Value is Marked as 'N'", test, test1);
		setGlobalConfiguration(driver, Global_Configuration_Module, Global_Configuration_Attribute,
				Global_Configuration_Value);

		Step_Start(1, "1.Select the Condition fileter option,\r\n" + "2. Select WPE Attribute Value,\r\n"
				+ "3. Verify WPE Value is Marked as 'N'", test, test1);

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

		Step_Start(4, " Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		scrollElementToView(driver, Detention_container_Filter);

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();

				if (!eletext.equals("")) {

					ContainersList.add(eletext);

				}
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
			ContainersList.addAll(Containers_Select);
		}

		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, "Click on % Radio Button", test, test1);

		waitForElement(driver, DW_Waiver_Radio_button);
		click(driver, DW_Waiver_Radio_button);

		Step_End(5, "Click on % Radio Button", test, test1);

		Step_Start(6, "Enter the % value in Text Fields", test, test1);

		if (!isElementEnabled(driver, DW_Percenteage_Input_Field)) {

			waitForElement(driver, DW_Percenteage_Input_Field);
		}

		waitForElement(driver, DW_Percenteage_Input_Field);
		doubleClick(driver, DW_Percenteage_Input_Field);

		Newclear(driver, DW_Percenteage_Input_Field);

		sendKeys(driver, DW_Percenteage_Input_Field, percentage_Value);

		Step_End(6, "Enter the % value in Text Fields", test, test1);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_Start(7, "Verify that system shows Validation(Capture Validation.)\r\n"
				+ "No Detention is available for the Container(s)", test, test1);

		waitForPopup(driver, popup_Message, Expected_Popup);
		String formattedList = String.join(" , ", ContainersList);
		String Actual_Popup = getText(driver, popup_Message);
		Expected_Popup = String.format(Expected_Popup, formattedList);
		String Expected_Popup_2 = String.format(Expected_Popup, Container_number_Add);

		if (Expected_Popup.trim().equals(Actual_Popup.trim()) || Expected_Popup_2.trim().equals(Actual_Popup.trim())) {
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
		click(driver, popup_Message_Ok_Button);

		Step_End(7, "Verify that system shows Validation(Capture Validation.)\r\n"
				+ "No Detention is available for the Container(s)", test, test1);
		scrollTop(driver);

		reSetGlobalConfiguration(driver, Global_Configuration_Reset_Option, Global_Configuration_Module,
				Global_Configuration_Attribute, Global_Configuration_Reset_Value);
		Extent_completed(testcase_Name, test, test1);
	}
}
