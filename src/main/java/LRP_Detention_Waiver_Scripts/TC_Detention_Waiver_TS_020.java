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

public class TC_Detention_Waiver_TS_020 extends Keywords {

	public void Detention_Waiver_TS_020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_020";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String BL_Number = Excel_data.get("BL_Number");
		String DW_Container_Headers = Excel_data.get("DW_Headers");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Expected_Due_Days = Excel_data.get("Expected_Due_Days");

		Extent_Start(testcase_Name, test, test1);
		List<String> detentionwaiver_ContainerHeaders = splitAndExpand(DW_Container_Headers, ",");

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

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
		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);

		Step_Start(5, "Verify that Due Date is Zero", test, test1);

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
				clear(driver, Detention_container_Filter_input);
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
		for (int i = 1; i <= due_Days.size(); i++) {

			String actual_dueDays = due_Days.get(i - 1).getText();
			String date = String.format(Due_date_table, i);
			String actualContainer = String.format(grid_Container_Number, i);
			String actualContainerNo = getText(driver, actualContainer);
			String date_text = getText(driver, date);
			System.out.println(date_text);

			if (Expected_Due_Days.equals(actual_dueDays)) {

				System.out.println("Expected Due Days for : " + actualContainerNo + " : " + Expected_Due_Days
						+ " || Actual Due Days : " + actual_dueDays);
				Extent_pass_New(driver, "Expected Due Days for : " + actualContainerNo + " : " + Expected_Due_Days
						+ " || Actual Due Days : " + actual_dueDays, test, test1);
			} else {

				System.out.println("Expected Due Days for : " + actualContainerNo + " : " + Expected_Due_Days
						+ " || Actual Due Days : " + actual_dueDays);
				extent_fail(driver, "Expected Due Days for : " + actualContainerNo + " : " + Expected_Due_Days
						+ " || Actual Due Days : " + actual_dueDays, test, test1);
			}

			if (verifyElementHasNoText(driver, date)) {
				System.out.println("Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty");
				Extent_pass_New(driver, "Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty", test, test1);
			} else {

				System.out.println("Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty");
				extent_fail(driver, "Expected result : Due date should be Empty " + actualContainerNo
						+ " || Actual result :  Due date is Empty", test, test1);

			}

		}

		waitForElement(driver, DW_Container_Table);
		List<Map<String, String>> Table_ContainerValue_Det = extractTableDataCountMissMatch(driver, DW_Container_Table);

		String Actual_DW_ContainerTable = TableDataForReport(driver, Table_ContainerValue_Det,
				"Detention Waiver Container Table", detentionwaiver_ContainerHeaders);

		Extent_call(test, test1, "<pre>" + Actual_DW_ContainerTable + "</pre> ");

		Step_End(5, "Verify that Due Date is Zero", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
