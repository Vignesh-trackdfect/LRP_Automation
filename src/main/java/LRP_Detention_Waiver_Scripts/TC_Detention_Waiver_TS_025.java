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

public class TC_Detention_Waiver_TS_025 extends Keywords {

	public void Detention_Waiver_TS_025(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_025";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String Value = Excel_data.get("Value");
		String Global_Attribute = Excel_data.get("Global_Attribute");
		String BL_Number = Excel_data.get("BL_Number");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Global_Configration = Excel_data.get("Global_Configration");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Value_Reset = Excel_data.get("Value_Reset");
		String Value_Reset_Perform = Excel_data.get("Value_Reset_Perform");
		String Waiver_Input = Excel_data.get("Waiver_Input");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");

		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String DW_Container_Headers = Excel_data.get("DW_Container_Headers");

		List<String> detentionwaiver_ContainerHeaders = splitAndExpand(DW_Container_Headers, ",");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);
		Extent_call(test, test1, "Open Global configuraiton module");
		setGlobalConfiguration(driver, Global_Configration, Global_Attribute, Value);

		Extent_call(test, test1, "Open Detention Waiver");

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
			ContainersList.addAll(Containers_Select);
		}

		scrollBottom(driver);
		waitForDisplay(driver, Due_days_table);
		List<WebElement> due_Days = listOfElements(driver, Due_days_table);
		Step_Start(6, "A.Verify that Due Date Column has Empty", test, test1);

		for (int i = 1; i <= due_Days.size(); i++) {

			String date = String.format(Due_date_table, i);
			String actualContainer = String.format(grid_Container_Number, i);
			String actualContainerNo = getText(driver, actualContainer);
			String date_text = getText(driver, date);
			System.out.println(date_text);

			if (verifyElementHasNoText(driver, date)) {
				System.out.println("Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty");
				Extent_pass_New(driver, "Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty", test, test1);
			} else {

				System.out.println("Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is not Empty");
				extent_fail(driver, "Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is not Empty", test, test1);

			}

		}
		Step_End(6, "A.Verify that Due Date Column has Empty", test, test1);

		waitForElement(driver, DW_Container_Table);
		List<Map<String, String>> Table_ContainerValue_Det = extractTableDataCountMissMatch(driver, DW_Container_Table);

		String Actual_DW_ContainerTable = TableDataForReport(driver, Table_ContainerValue_Det,
				"Detention Waiver Container Table", detentionwaiver_ContainerHeaders);

		Extent_call(test, test1, "<pre>" + Actual_DW_ContainerTable + "</pre> ");

		waitForElement(driver, DW_Waiver_Radio_button);
		click(driver, DW_Waiver_Radio_button);

		Step_End(5, "Click on % Radio Button", test, test1);

		if (!isElementEnabled(driver, DW_Percenteage_Input_Field)) {

			waitForElement(driver, DW_Percenteage_Input_Field);
		}

		waitForElement(driver, DW_Percenteage_Input_Field);
		doubleClick(driver, DW_Percenteage_Input_Field);

		Newclear(driver, DW_Percenteage_Input_Field);

		Step_Start(6, "Enter the % value in Text Fields,", test, test1);

		sendKeys(driver, DW_Percenteage_Input_Field, Waiver_Input);

		Step_End(6, "Enter the % value in Text Fields,", test, test1);
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		Step_Start(7, "Verify that system added % value in Below Grid.", test, test1);

		waitForDisplay(driver, DW_Select_Container_down_gird);
		if (isdisplayed(driver, DW_Select_Container_down_gird)) {
			System.out.println(
					"Matched || Expected result : system wants to Allow percentage waiver added to gird || Actual result : system  Allowed percentage waiver added to gird");
			Extent_pass_New(driver,
					"Matched || Expected result : system wants to Allow percentage waiver added to gird || Actual result :system  Allowed percentage waiver added to gird",
					test, test1);
		} else {

			System.out.println(
					"Not Matched || Expected result :system wants to Allow percentage waiver added to gird|| Actual result : system not Allowed percentage waiver added to gird");
			Extent_fail(driver,
					"Not Matched || Expected result :system wants to Allow percentage waiver added to gird || Actual result :system  not Allowed percentage waiver added to gird",
					test, test1);

		}

		scrollTop(driver);

		reSetGlobalConfiguration(driver, Value_Reset_Perform, Global_Configration, Global_Attribute, Value_Reset);
		Extent_completed(testcase_Name, test, test1);

	}
}