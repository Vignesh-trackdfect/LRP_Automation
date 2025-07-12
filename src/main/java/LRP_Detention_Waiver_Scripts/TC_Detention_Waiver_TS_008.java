package LRP_Detention_Waiver_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_008 extends Keywords {

	public void Detention_Waiver_TS_008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Detention_Waiver_TS_008";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Booking_number = Excel_data.get("BL_Number");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Container_number = Excel_data.get("Container_number");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Enable_Check_Field = Excel_data.get("Waiver_By");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention weiver Module", test, test1);

		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);

		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);

		Step_Start(2, "Click on BL No Search Field", test, test1);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Booking_number, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		scrollBottom(driver);
		Step_End(4, "Click on show Button", test, test1);

		// select the container row

		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}
			mouseOverToElement(driver, DW_Select_All_Checkbox);
			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			List<String> Containers_Select = splitAndExpand(Container_number);
			for (String container : Containers_Select) {

				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
			}
			ContainersList.addAll(Containers_Select);
		}

		Step_Start(5, "Select the  Radio Button", test, test1);

		String enable_check = String.format(DW_Radio_Button, Enable_Check_Field);
		mouseOverToElement(driver, enable_check);

		waitForElement(driver, enable_check);
		click(driver, enable_check);

		Step_End(5, "Select the  Radio Button", test, test1);

		Step_Start(6, " Select the Free time Radio Button.", test, test1);

		Step_End(6, " Select the Free time Radio Button.", test, test1);

		Step_Start(7, "Verify that  %Radio button is Unchecked and Free time button is checked", test, test1);
		scrollBottom(driver);
		String FreeDays_RadioButton = getAttribute(driver, DWAddtionfreedays_Radio_ButtonCheck, "class");
		String Percentage_RadioButton = getAttribute(driver, DW_Percenteage_Radio_Button_Verify, "class");
		String Lumpsum_RadioButton = getAttribute(driver, DW_Lumpsum_Radio_Button_Verify, "class");
		if (Enable_Check_Field.equalsIgnoreCase("Additional Free Days")) {
			if (FreeDays_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is : Free time check box should be checked || Actual result is : Free time checkbox is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is : Free time check box should be checked || Actual result is : Free time checkbox is checked",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is : Free time check box should be checked || Actual result is : Free time checkbox is not checked");
				Extent_fail(driver,
						"Fail || Expected result is : Free time check box should be checked || Actual result is : Free time checkbox is not checked",
						test, test1);
			}
		}

		if (Enable_Check_Field.equalsIgnoreCase("Waiver Lumpsum")) {
			if (Lumpsum_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is :Lumpsum check box should be checked || Actual result is : Lumpsum checkbox is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is : Lumpsum check box should be checked || Actual result is : Lumpsum checkbox is checked",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is :Lumpsum check box should be checked || Actual result is : Lumpsum checkbox is not checked");
				Extent_fail(driver,
						"Fail || Expected result is : Lumpsum check box should be checked || Actual result is : Lumpsum checkbox is not checked",
						test, test1);
			}
		}
		if (Enable_Check_Field.equalsIgnoreCase("Waiver %")) {
			if (Percentage_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is :Lumpsum % check box should be checked || Actual result is : Lumpsum % checkbox is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is : Lumpsum % check box should be checked || Actual result is : Lumpsum % checkbox is checked",
						test, test1);
			} else {
				System.out.println(
						"Fail || Expected result is :Lumpsum % check box should be checked || Actual result is : Lumpsum % checkbox is not checked");
				Extent_fail(driver,
						"Fail || Expected result is : Lumpsum % check box should be checked || Actual result is : Lumpsum %checkbox is not checked",
						test, test1);
			}
		}

		if (Enable_Check_Field.equalsIgnoreCase("Additional Free Days")) {
			if (!Percentage_RadioButton.contains("active") && !Lumpsum_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is : % Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is Unchecked");
				Extent_pass_New(driver,
						"Pass || Expected result is :% Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is Unchecked",
						test, test1);
			} else {
				System.out.println(
						"Pass || Expected result is : % Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is :% Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is checked",
						test, test1);
			}
		}

		if (Enable_Check_Field.equalsIgnoreCase("Waiver Lumpsum")) {
			if (!Percentage_RadioButton.contains("active") && !FreeDays_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is : % Radio button & Free days Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is Unchecked");
				Extent_pass_New(driver,
						"Pass || Expected result is :% Radio button & Free days Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is Unchecked",
						test, test1);
			} else {
				System.out.println(
						"Pass || Expected result is : % Radio button & Free days Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is :% Radio button & Free days Radio button check box should be Unchecked || Actual result is : % Radio button & Lumpsum Radio button check box is checked",
						test, test1);
			}
		}
		if (Enable_Check_Field.equalsIgnoreCase("Waiver %")) {
			if (!Lumpsum_RadioButton.contains("active") && !FreeDays_RadioButton.contains("active")) {
				System.out.println(
						"Pass || Expected result is : Free days Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is :Free days Radio button & Lumpsum Radio button check box is Unchecked");
				Extent_pass_New(driver,
						"Pass || Expected result is :Free days Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is :Free days Radio button & Lumpsum Radio button check box is Unchecked",
						test, test1);
			} else {
				System.out.println(
						"Pass || Expected result is : Free days Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is : Free days Radio button & Lumpsum Radio button check box is checked");
				Extent_pass_New(driver,
						"Pass || Expected result is :Free days Radio button & Lumpsum Radio button check box should be Unchecked || Actual result is :Free days Radio button & Lumpsum Radio button check box is checked",
						test, test1);
			}
		}

		Step_End(7, "Verify that  %Radio button is Unchecked and Free time button is checked", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
