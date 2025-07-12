package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_045 extends Keywords {

	public void Detention_Waiver_TS_045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_045";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String Search_Type_WaiverStatus = Excel_data.get("Search_Type_WaiverStatus");
		String SearchStatus = Excel_data.get("SearchStatus");
		String Expected_popup = Excel_data.get("Expected_popup");
		String Remark = Excel_data.get("Remark");
		String Save_Popup = Excel_data.get("Save_Popup");
		String ExpectedStatus = Excel_data.get("ExpectedStatus");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention Waiver", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(1, "Open Detention Waiver", test, test1);

		Step_Start(1, "a) Click on Search Button", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(1, "a) Click on Search Button", test, test1);

		Step_Start(2, "Enter Waiver No/ BL NO for Cancelled Ref details", test, test1);
		Step_Start(3, "load  the data", test, test1);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, Search_Type_WaiverStatus, SearchStatus, "", "");

		Step_End(2, "Enter Waiver No/ BL NO for Cancelled Ref details", test, test1);

		Step_End(3, "load  the data", test, test1);

		Step_Start(4, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Click on Edit Button", test, test1);

		Step_Start(5,
				"SYSTEM HAS VALIDATE -Approved Waiver cannot be Edited. Selected waiver is yet to be Invoiced, Do you want to cancel the Waiver No/Yes",
				test, test1);

		waitForPopup(driver, popup_Message, Expected_popup);
		String Cancelled_popup_Message = getText(driver, popup_Message);

		if (Cancelled_popup_Message.contains(Expected_popup)) {

			System.out.println("Approved Waiver Cannot be edited || Expected popup : " + Expected_popup
					+ " || Actual popup : " + Cancelled_popup_Message);
			Extent_pass_New(driver, "Approved Waiver Cannot be edited || Expected popup : " + Expected_popup
					+ " || Actual popup : " + Cancelled_popup_Message, test, test1);

		} else {
			System.out.println("Approved Waiver Can be edited || Expected popup : " + Expected_popup
					+ " || Actual popup : " + Cancelled_popup_Message);
			Extent_fail(driver, "Approved Waiver Can be edited || Expected popup : " + Expected_popup
					+ " || Actual popup : " + Cancelled_popup_Message, test, test1);

		}

		Step_End(5,
				"SYSTEM HAS VALIDATE -Approved Waiver cannot be Edited. Selected waiver is yet to be Invoiced, Do you want to cancel the Waiver No/Yes",
				test, test1);

		Step_Start(6, "CLICK THE YES", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(6, "CLICK THE YES", test, test1);

		Step_Start(7, "Enter the Remarks", test, test1);

		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		Step_End(7, "Enter the Remarks", test, test1);

		Step_Start(8, "Click on save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Click on save Button", test, test1);

		Step_Start(9, "Verify that Status Should be in Cancelled status for the BL", test, test1);

		waitForPopup(driver, Popup_Message, Save_Popup);
		String Actual_popup_Message = getText(driver, Popup_Message);

		if (Actual_popup_Message.equals(Save_Popup)) {

			System.out.println(
					"Matched || Expected popup : " + Save_Popup + " || Actual popup : " + Actual_popup_Message);
			Extent_pass_New(driver,
					"Matched || Expected popup : " + Save_Popup + " || Actual popup : " + Actual_popup_Message, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected popup : " + Save_Popup + " || Actual popup : " + Actual_popup_Message);
			Extent_fail(driver,
					"Not Matched || Expected popup : " + Save_Popup + " || Actual popup : " + Actual_popup_Message,
					test, test1);

		}

		
		waitForElement(driver, DW_WaiverStatus);
		String NewStatus = getText(driver, DW_WaiverStatus);

		if (NewStatus.contains(ExpectedStatus)) {

			System.out.println("Expected Waiver Status : "+ExpectedStatus+" || Actual Waiver Status : "+NewStatus);
			Extent_pass_New(driver,"Expected Waiver Status : "+ExpectedStatus+" || Actual Waiver Status : "+NewStatus,
					test, test1);

		} else {

			System.out.println("Expected Waiver Status : "+ExpectedStatus+" || Actual Waiver Status : "+NewStatus);
			Extent_fail(driver,
					"Expected Waiver Status : "+ExpectedStatus+" || Actual Waiver Status : "+NewStatus,
					test, test1);

		}

		Step_End(9, "Verify that Status Should be in Cancelled status for the BL", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
