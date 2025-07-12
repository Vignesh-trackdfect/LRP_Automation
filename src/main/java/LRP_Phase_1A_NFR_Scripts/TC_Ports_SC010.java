package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC010 extends Keywords {

	public void Ports_SC010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC010";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DLC_ModuleName = Excel_data.get("DLC_ModuleName");
		String Excel_Upload = Excel_data.get("Excel_Upload");
		String ExcelPath = Excel_data.get("ExcelPath");
		String sheetname = Excel_data.get("sheetname");
		String Approve_popup = Excel_data.get("Approve_popup");
		String Ports_Module = Excel_data.get("Ports_Module");
		String GlobalSearch_option = Excel_data.get("GlobalSearch_option");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application..", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application..", test, test1);

		Step_Start(2, " Navigate to Ports Screen.", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, DLC_ModuleName);

		Step_End(2, "Navigate to Day Light Configuration screen", test, test1);

		Step_Start(3, "Select excel upload check box and click on import Excel button", test, test1);

		waitForDisplay(driver, DLC_ExcelUpload_Checkbox);

		checkBox(driver, DLC_ExcelUpload_Checkbox, Excel_Upload);

		Step_End(3, "Select excel upload check box and click on import Excel button", test, test1);

		Step_Start(4, "Upload Excel file. and click on load sheet button, The data will be loaded on grid", test,
				test1);

		waitForElement(driver, DLC_ImportExcel);
		click(driver, DLC_ImportExcel);

		waitForPresenceOfElement(driver, Select_excel_FC);
		uploadfile_new(driver, Select_excel_FC, ExcelPath);

		waitForDisplay(driver, FC_SelectSheet);
		jsClick(driver, FC_SelectSheet);

		formatLocatorClick(driver, DropDown_Select, sheetname);

		waitForElement(driver, FC_LoadSheet);
		click(driver, FC_LoadSheet);

		Step_End(4, "Upload Excel file. and click on load sheet button, The data will be loaded on grid", test, test1);

		Step_Start(5, "Select Upload button, data will be loaded on the Screen", test, test1);

		waitForElement(driver, FC_Upload);
		click(driver, FC_Upload);

		waitForDisplay(driver, DLC_TimeDaylight_Grid);

		if (isdisplayed(driver, DLC_TimeDaylight_Grid)) {

			System.out.println(
					"Expected result : The imported data's should be loaded on the screen || Actual result : The imported data's are loaded on the screen");
			Extent_pass_New(driver,
					"Expected result : The imported data's should be loaded on the screen || Actual result : The imported data's are loaded on the screen",
					test, test1);
		} else {

			System.out.println(
					"Expected result : The imported data's should be loaded on the screen || Actual result : The imported data's are not loaded on the screen");
			Extent_fail(driver,
					"Expected result : The imported data's should be loaded on the screen || Actual result : The imported data's are not loaded on the screen",
					test, test1);

		}

		List<WebElement> portcode_Fields = listOfElements(driver, DLC_TimeDaylight_Grid);

		List<String> Approved_portcode = new ArrayList<String>();

		for (WebElement ele : portcode_Fields) {

			String portcodes = ele.getText();

			Approved_portcode.add(portcodes);

		}

		List<WebElement> ChangedFrom_Fields = listOfElements(driver, DLC_ChangeFromDate);

		List<String> ChangedFrom_value = new ArrayList<String>();

		for (WebElement ele : ChangedFrom_Fields) {

			String fromdate = ele.getText();

			ChangedFrom_value.add(fromdate);

		}

		List<WebElement> ChangedTo_Fields = listOfElements(driver, DLC_ChangeToDate);

		List<String> ChangedTo_value = new ArrayList<String>();

		for (WebElement ele : ChangedTo_Fields) {

			String Todate = ele.getText();

			ChangedTo_value.add(Todate);

		}

		Step_End(5, "Select Upload button, data will be loaded on the Screen", test, test1);

		Step_Start(6, "Choose select all check-box and click approve button", test, test1);

		waitForDisplay(driver, DLC_Selectall_Checkbox);
		jsClick(driver, DLC_Selectall_Checkbox);

		waitForElement(driver, DLC_Approve);
		click(driver, DLC_Approve);

		Step_End(6, "Choose select all check-box and click approve button", test, test1);

		Step_Start(7, "System prompt 'DayLight Updated Successfully'", test, test1);

		waitForPopup(driver, Popup_Message, Approve_popup);

		String Act_pop1 = getText(driver, Popup_Message);

		if (Approve_popup.equals(Act_pop1)) {
			System.out.println("Expected popup is :" + Approve_popup + " Actual popup is : " + Act_pop1);
			Extent_pass_New(driver, "Expected  popup is :" + Approve_popup + " Actual popup is : " + Act_pop1, test,
					test1);
		} else {
			System.out.println("Expected  popup is :" + Approve_popup + " Actual popup is : " + Act_pop1);
			Extent_fail(driver, "Expected  popup is :" + Approve_popup + " Actual popup is : " + Act_pop1, test, test1);
		}

		Step_End(7, "System prompt 'DayLight Updated Successfully'", test, test1);

		Step_Start(8, "Open ports screen and retrive one or two ports which are approved", test, test1);

		Step_Start(9, "To verify the result whether change from & change to date updated correctly", test, test1);

		moduleNavigate(driver, Ports_Module);

		int i = 0;

		for (String portcode : Approved_portcode) {

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_option, portcode, "", "", "", "");

			waitForElement(driver, ports_ChangeDateFrom);

			String changed_Fromdate = getAttribute(driver, ports_ChangeDateFrom, "value");

			System.out.println("changed_Fromdate : " + changed_Fromdate);

			waitForElement(driver, ports_ChangeDateFrom);

			String changed_Todate = getAttribute(driver, ports_ChangeDateTo, "value");

			System.out.println("changed_Todate : " + changed_Todate);

			String[] changed_FromDate = ChangedFrom_value.get(i).split(" ");

			String Fromgrid_Value = dateconverter(changed_FromDate[0]);

			if (Fromgrid_Value.contains(changed_Fromdate)) {

				System.out.println("Expected result : The given From date " + Fromgrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given From date "
						+ changed_Fromdate + " was updated in the ports screen");
				Extent_pass_New(driver, "Expected result : The given From date " + Fromgrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given From date "
						+ changed_Fromdate + " was updated in the ports screen", test, test1);

			} else {

				System.out.println("Expected result : The given From date " + Fromgrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given From date "
						+ changed_Fromdate + " was not updated in the ports screen");
				Extent_fail(driver, "Expected result : The given From date " + Fromgrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given From date "
						+ changed_Fromdate + " was not updated in the ports screen", test, test1);

			}

			String[] changed_ToDate = ChangedTo_value.get(i).split(" ");

			String Togrid_Value = dateconverter(changed_ToDate[0]);

			if (Togrid_Value.contains(changed_Todate)) {

				System.out.println("Expected result : The given To date " + Togrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given To date "
						+ changed_Todate + " was updated in the ports screen");
				Extent_pass_New(driver, "Expected result : The given To date " + Togrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given To date "
						+ changed_Todate + " was updated in the ports screen", test, test1);

			} else {

				System.out.println("Expected result : The given To date " + Togrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given To date "
						+ changed_Todate + " was not updated in the ports screen");
				Extent_fail(driver, "Expected result : The given To date " + Togrid_Value
						+ " should be updated in the ports screen || Actual result : Expected result : The given To date "
						+ changed_Todate + " was not updated in the ports screen", test, test1);

			}

			i++;
		}

		Step_End(8, "Open ports screen and retrive one or two ports which are approved", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
