package LRP_Vendor_Contract_Scripts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC018 extends Keywords {

	public void Vendor_Contracts_SC018(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC018";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Contract_Type_Filter_Header = Excel_data.get("Contract_Type_Filter_Header");
		String Contract_Type_Filter_Condition = Excel_data.get("Contract_Type_Filter_Condition");
		String Contract_Type = Excel_data.get("Contract_Type");
		String Ventor_Code_Filter_Header = Excel_data.get("Ventor_Code_Filter_Header");
		String Ventor_Code_Filter_Condition = Excel_data.get("Ventor_Code_Filter_Condition");
		String Ventor_Code = Excel_data.get("Ventor_Code");
		String From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");
		String Period_type = Excel_data.get("Period_type");
		String Port_Name = Excel_data.get("Port_Name");
		String Terminal_Type = Excel_data.get("Terminal_Type");
		String Terminal_name = Excel_data.get("Terminal_name");
		String ImportFilePath = Excel_data.get("ImportFilePath");
		String ImportExcel_MasterTab = Excel_data.get("ImportExcel_MasterTab");
		String Excel_Sheet1Name = Excel_data.get("Excel_Sheet1Name");
		String MapColumn_popup = Excel_data.get("MapColumn_popup");
		String ImportExcel_FormulaTab = Excel_data.get("ImportExcel_FormulaTab");
		String Excel_Sheet2Name = Excel_data.get("Excel_Sheet2Name");
		String ImportExcel_SlabTab = Excel_data.get("ImportExcel_SlabTab");
		String Excel_Sheet3Name = Excel_data.get("Excel_Sheet3Name");
		String Imported_popup = Excel_data.get("Imported_popup");
		String Saved_popup = Excel_data.get("Saved_popup");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter the screen name as 'Vendor Contracts' in module search field", test, test1);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as 'Vendor Contracts' in module search field", test, test1);

		Step_Start(2, "Click on the contract type search button and select the required contract", test, test1);

		waitForElement(driver, search_icon_contract_type_Vc);
		click(driver, search_icon_contract_type_Vc);

		twoColumnSearchWindow(driver, Contract_Type_Filter_Header, Contract_Type_Filter_Condition, Contract_Type);

		Step_End(2, "Click on the contract type search button and select the required contract", test, test1);

		Step_Start(3, "Click on the vendor code search button and select the reuired vendor", test, test1);

		newButton(driver);

		waitForElement(driver, vendor_code_search_icon_Vc);
		click(driver, vendor_code_search_icon_Vc);

		twoColumnSearchWindow(driver, Ventor_Code_Filter_Header, Ventor_Code_Filter_Condition, Ventor_Code);

		Step_End(3, "Click on the vendor code search button and select the reuired vendor", test, test1);

		Step_Start(4, "Select the required valid from and valid to", test, test1);

		waitForElement(driver, valid_from_date_Vc);
		selectDatePicker(driver, valid_from_date_Vc, From_Date);

		waitForElement(driver, valid_To_date_Vc);
		selectDatePicker(driver, valid_To_date_Vc, To_Date);

		Step_End(4, "Select the required valid from and valid to", test, test1);

		Step_Start(5, "Select the period type as per the requirement", test, test1);

		waitForElement(driver, VC_Period);
		click(driver, VC_Period);

		formatLocatorClick(driver, DropDown_Select, Period_type);

		Step_End(5, "Select the period type as per the requirement", test, test1);

		Step_Start(6, "Enter the port code and terminal type and enter the terminal/depot code as per the requirement",
				test, test1);

		waitForDisplay(driver, VC_Port_Input);
		sendKeys(driver, VC_Port_Input, Port_Name);

		waitForElement(driver, VC_Port_Select1);
		safeclick(driver, VC_Port_Select1);

		waitForElement(driver, VC_Terminal_dropdown);
		click(driver, VC_Terminal_dropdown);

		formatLocatorClick(driver, DropDown_Select, Terminal_Type);

		waitForDisplay(driver, VC_Terminal_Input);
		sendKeys(driver, VC_Terminal_Input, Terminal_name);

		waitForElement(driver, VC_Terminal_Select1);
		safeclick(driver, VC_Terminal_Select1);

		Step_End(6, "Enter the port code and terminal type and enter the terminal/depot code as per the requirement",
				test, test1);

		Step_Start(7, "Click on the import excel option", test, test1);

		waitForElement(driver, VC_ImportExcel);
		click(driver, VC_ImportExcel);

		Step_End(7, "Click on the import excel option", test, test1);

		Step_Start(8, "Click on the select excel file option", test, test1);

		Step_Start(9, "Select the excel file from the system and click open", test, test1);

		waitForDisplay(driver, VC_IE_SelectExcel);
		uploadfile_new(driver, VC_IE_SelectExcel, ImportFilePath);

		Step_End(8, "Click on the select excel file option", test, test1);

		Step_End(9, "Select the excel file from the system and click open", test, test1);

		Step_Start(10, "Select the Master tab", test, test1);

		formatLocatorClick(driver, VC_ImportTabs, ImportExcel_MasterTab);

		Step_End(10, "Select the Master tab", test, test1);

		Step_Start(11, "Click the select sheet and select the sheet 1 name", test, test1);

		waitForElement(driver, VC_Import_Sheet);
		click(driver, VC_Import_Sheet);

		formatLocatorClick(driver, VC_Import_SheetName, Excel_Sheet1Name);

		Step_End(11, "Click the select sheet and select the sheet 1 name", test, test1);

		Step_Start(12, "Click on Load sheet option", test, test1);

		waitForElement(driver, VC_Load_Sheet);
		click(driver, VC_Load_Sheet);

		Step_End(12, "Click on Load sheet option", test, test1);

		Step_Start(13, "The system validates a message as 'Do you want to map the column automatically?'", test, test1);

		if (isdisplayed(driver, VC_MapColumn_popup)) {

			waitForPopup(driver, VC_MapColumn_popup, MapColumn_popup);

			String Actual_mapcolumn_popup = getText(driver, VC_MapColumn_popup);

			if (MapColumn_popup.equals(Actual_mapcolumn_popup)) {

				System.out.println("Matched || Expected Map column popup was : " + MapColumn_popup
						+ " || Actual map column popup was : " + Actual_mapcolumn_popup);
				Extent_pass_New(driver, "Matched || Expected Map column popup was : " + MapColumn_popup
						+ " || Actual map column popup was : " + Actual_mapcolumn_popup, test, test1);

			} else {

				System.out.println("Not Matched || Expected Map column popup was : " + MapColumn_popup
						+ " || Actual map column popup was : " + Actual_mapcolumn_popup);
				Extent_fail(driver, "Not Matched || Expected Map column popup was : " + MapColumn_popup
						+ " || Actual map column popup was : " + Actual_mapcolumn_popup, test, test1);

			}

			Step_End(13, "The system validates a message as 'Do you want to map the column automatically?'", test,
					test1);

			Step_Start(14, "Click on Yes option", test, test1);

			waitForElement(driver, VC_MapColumn_popup_Yes);
			click(driver, VC_MapColumn_popup_Yes);

		}

		waitForElement(driver, VC_Gridfield_value);

		Step_End(14, "Click on Yes option", test, test1);

		List<Map<String, String>> sheet1_Datas = getTableData(driver, VC_Gridfield_header, VC_Gridfield_value);

		List<String> D_Columnvalue = new ArrayList<>();

		for (Map<String, String> row : sheet1_Datas) {
			if (row.containsKey("D")) {
				D_Columnvalue.add(row.get("D"));
			}
		}

		if (!D_Columnvalue.contains("Sub To Formula")) {

			System.out.println("The Uploaded excel Don't have the formula, So It skipped the Formula and Slab sheets");
			Extent_cal(test, test1,
					"The Uploaded excel Don't have the formula, So It skipped the Formula and Slab sheets");

		} else {

			Step_Start(15, "Select the Formula tab", test, test1);

			formatLocatorClick(driver, VC_ImportTabs, ImportExcel_FormulaTab);

			Step_End(15, "Select the Formula tab", test, test1);

			Step_Start(16, "Click the select sheet and select the sheet 2 name", test, test1);

			waitForElement(driver, VC_Import_Sheet);
			click(driver, VC_Import_Sheet);

			formatLocatorClick(driver, VC_Import_SheetName, Excel_Sheet2Name);

			Step_End(16, "Click the select sheet and select the sheet 2 name", test, test1);

			Step_Start(17, "Click on Load sheet option", test, test1);

			waitForElement(driver, VC_Load_Sheet);
			click(driver, VC_Load_Sheet);

			Step_End(17, "Click on Load sheet option", test, test1);

			Step_Start(18, "The system validates a message as 'Do you want to map the column automatically?'", test,
					test1);

			if (isdisplayed(driver, VC_MapColumn_popup)) {

				waitForPopup(driver, VC_MapColumn_popup, MapColumn_popup);

				String Actual_mapcolumn_popup2 = getText(driver, VC_MapColumn_popup);

				if (MapColumn_popup.equals(Actual_mapcolumn_popup2)) {

					System.out.println("Matched || Expected Map column popup was : " + MapColumn_popup
							+ " || Actual map column popup was : " + Actual_mapcolumn_popup2);
					Extent_pass_New(driver, "Matched || Expected Map column popup was : " + MapColumn_popup
							+ " || Actual map column popup was : " + Actual_mapcolumn_popup2, test, test1);

				} else {

					System.out.println("Not Matched || Expected Map column popup was : " + MapColumn_popup
							+ " || Actual map column popup was : " + Actual_mapcolumn_popup2);
					Extent_fail(driver, "Not Matched || Expected Map column popup was : " + MapColumn_popup
							+ " || Actual map column popup was : " + Actual_mapcolumn_popup2, test, test1);

				}

				Step_End(18, "The system validates a message as 'Do you want to map the column automatically?'", test,
						test1);

				Step_Start(19, "Click on Yes option", test, test1);

				waitForElement(driver, VC_MapColumn_popup_Yes);
				click(driver, VC_MapColumn_popup_Yes);

			}

			waitForElement(driver, VC_Gridfield_value);

			Step_End(19, "Click on Yes option", test, test1);

			List<Map<String, String>> sheet1_Datas2 = getTableData(driver, VC_Gridfield_header, VC_Gridfield_value);

			List<String> D_Columnvalue2 = new ArrayList<>();

			for (Map<String, String> row : sheet1_Datas2) {
				if (row.containsKey("D")) {
					D_Columnvalue2.add(row.get("D"));
				}
			}

			if (!D_Columnvalue2.contains("Y")) {

				System.out.println("The Uploaded excel Don't have the formula, So It skipped Slab sheets");
				Extent_cal(test, test1, "The Uploaded excel Don't have the formula, So It skipped Slab sheets");

			} else {

				Step_Start(20, "Select the slab tab", test, test1);

				formatLocatorClick(driver, VC_ImportTabs, ImportExcel_SlabTab);

				Step_End(20, "Select the slab tab", test, test1);

				Step_Start(21, "Click the select sheet and select the sheet 3 name", test, test1);

				waitForElement(driver, VC_Import_Sheet);
				click(driver, VC_Import_Sheet);

				formatLocatorClick(driver, VC_Import_SheetName, Excel_Sheet3Name);

				Step_End(21, "Click the select sheet and select the sheet 3 name", test, test1);

				Step_Start(22, "Click on Load sheet option", test, test1);

				waitForElement(driver, VC_Load_Sheet);
				click(driver, VC_Load_Sheet);

				Step_End(22, "Click on Load sheet option", test, test1);

				Step_Start(23, "The system validates a message as 'Do you want to map the column automatically?'", test,
						test1);

				if (isdisplayed(driver, VC_MapColumn_popup)) {

					waitForPopup(driver, VC_MapColumn_popup, MapColumn_popup);

					String Actual_mapcolumn_popup3 = getText(driver, VC_MapColumn_popup);

					if (MapColumn_popup.equals(Actual_mapcolumn_popup3)) {

						System.out.println("Matched || Expected Map column popup was : " + MapColumn_popup
								+ " || Actual map column popup was : " + Actual_mapcolumn_popup3);
						Extent_pass_New(driver, "Matched || Expected Map column popup was : " + MapColumn_popup
								+ " || Actual map column popup was : " + Actual_mapcolumn_popup3, test, test1);

					} else {

						System.out.println("Not Matched || Expected Map column popup was : " + MapColumn_popup
								+ " || Actual map column popup was : " + Actual_mapcolumn_popup3);
						Extent_fail(driver, "Not Matched || Expected Map column popup was : " + MapColumn_popup
								+ " || Actual map column popup was : " + Actual_mapcolumn_popup3, test, test1);

					}

					Step_End(23, "The system validates a message as 'Do you want to map the column automatically?'",
							test, test1);

					Step_Start(24, "Click on Yes option", test, test1);

					waitForElement(driver, VC_MapColumn_popup_Yes);
					click(driver, VC_MapColumn_popup_Yes);

				}

				waitForElement(driver, VC_Gridfield_value);

				Step_End(24, "Click on Yes option", test, test1);

			}

		}

		Step_Start(25, "Click upload option", test, test1);

		waitForElement(driver, VC_UploadButton);
		click(driver, VC_UploadButton);

		Step_End(25, "Click upload option", test, test1);

		Step_Start(26, "System validates as Successfully imported and Click ok Option", test, test1);

		waitForPopup(driver, popup_Message, Imported_popup);

		String Imported_popup_msg = getText(driver, popup_Message);

		if (Imported_popup_msg.equals(Imported_popup)) {

			System.out.println("Matched || Expected Imported popup was : " + Imported_popup
					+ " || Actual Imported popup was : " + Imported_popup_msg);
			Extent_pass_New(driver, "Matched || Expected Imported popup was : " + Imported_popup
					+ " || Actual Imported popup was : " + Imported_popup_msg, test, test1);
		} else {

			System.out.println("Not Matched || Expected Imported popup was : " + Imported_popup
					+ " || Actual Imported popup was : " + Imported_popup_msg);
			Extent_fail(driver, "Not Matched || Expected Imported popup was : " + Imported_popup
					+ " || Actual Imported popup was : " + Imported_popup_msg, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		String excelPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator
				+ ImportFilePath;

		System.out.println("excelPath : " + excelPath);

		List<String> Excelvalues = new ArrayList<String>();

		try {
			Excelvalues = readColumnDataFromExcel_firstrow(excelPath, "Activity", Excel_Sheet1Name);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		if (isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}

		List<WebElement> activityvalues = listOfElements(driver, VC_ActivityGrid);

		List<String> Activitycolumn = new ArrayList<String>();

		for (WebElement ele : activityvalues) {

			String activity = ele.getText();

			Activitycolumn.add(activity);
		}

		boolean flag = true;

		for (String activitie : Excelvalues) {

			if (Activitycolumn.contains(activitie.toUpperCase())) {

				System.out.println("Expected result : The Activity " + activitie
						+ " should be present in the grid || Actual result : The Activity " + activitie
						+ " is present in the grid");

				Extent_pass_New(driver,
						"Expected result : The Activity " + activitie
								+ " should be present in the grid || Actual result : The Activity " + activitie
								+ " is present in the grid",
						test, test1);
				flag = true;
			} else {

				System.out.println("Expected result : The Activity " + activitie
						+ " should be present in the grid || Actual result : The Activity " + activitie
						+ " is not present in the grid");

				Extent_fail(driver,
						"Expected result : The Activity " + activitie
								+ " should be present in the grid || Actual result : The Activity " + activitie
								+ " is not present in the grid",
						test, test1);

				flag = false;
			}

		}

		if (flag == true) {

			System.out.println(
					"Expected result is : All the excel data's should be Imported in the grid || Actual result is : All the excel data's are imported in the grid");
			Extent_pass_New(driver,
					"Expected result is : All the excel data's should be Imported in the grid || Actual result is : All the excel data's are imported in the grid",
					test, test1);

			flag = true;
		} else {
			System.out.println(
					"Expected result is : All the excel data's should be Imported in the grid || Actual result is : All the excel data's are not imported in the grid");
			Extent_fail(driver,
					"Expected result is : All the excel data's should be Imported in the grid || Actual result is : All the excel data's are not imported in the grid",
					test, test1);
		}

		Step_End(26, "System validates as Successfully imported and Click ok Option", test, test1);

		Step_Start(27,
				"Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Saved_popup);

		String Saved_popup_msg = getText(driver, popup_Message);

		if (Saved_popup_msg.equals(Saved_popup)) {

			System.out.println("Matched || Expected saved popup was : " + Saved_popup + " || Actual saved popup was : "
					+ Saved_popup_msg);
			Extent_pass_New(driver, "Matched || Expected saved popup was : " + Saved_popup
					+ " || Actual saved popup was : " + Saved_popup_msg, test, test1);
		} else {

			System.out.println("Not Matched || Expected saved popup was : " + Saved_popup
					+ " || Actual saved popup was : " + Saved_popup_msg);
			Extent_fail(driver, "Not Matched || Expected saved popup was : " + Saved_popup
					+ " || Actual saved popup was : " + Saved_popup_msg, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(27,
				"Click on save option in toolbar and check whether the system shows a confirmation message as 'Vendor contracts saved' and click ok",
				test, test1);

		Step_Start(28, "Click Accept option", test, test1);

		waitForElement(driver, accept_Button_VC);
		click(driver, accept_Button_VC);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(28, "Click Accept option", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
