package LRP_End_To_End_Script;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_MCF_SC001 extends Keywords{
	public void MCF_SC001(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_MCF_SC001";
		//		String File_Path01 = TestNgXml.getfilePath_FromExecution().get(test_Case_Name);
		//		String Sheet_Name_SC01 = TestNgXml.getsheetName_FromExecution().get(test_Case_Name);
		////		
		//		Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_SC01, test_Case_Name, "Dataset" + selected_dataset, File_Path01);

//		String Username = Excel_data.get("Username");
//		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search_MCF");
		String agencyUser = Excel_data.get("Agency_user");
		String dropdown_Condition = Excel_data.get("dropdown_Condition");
		String MCF_GlobalSearch_Type = Excel_data.get("MCF_GlobalSearch_Type");
		String New_BL_Number = Excel_data.get("New_BL_Number");
		String MCF_Remarks_Input = Excel_data.get("MCF_Remarks_Input");
//		String first_service_data = Excel_data.get("Service_Code_new");
//		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
//		String Boundinput = Excel_data.get("Boundinput");
//		String booking_draft_Color = Excel_data.get("booking_draft_Color");
//		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
//		String savedpopEXP = Excel_data.get("savedpopEXP");
//		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
//		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		Extent_Start(test_Case_Name, test, test1);

//		navigateUrl(driver, url);
//			LRP_Login(driver, Username, Password);
		//	verifyMainMenu(driver);
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, search_module);

		newButton(driver);
		waitForElement(driver, MCF_By_Bl_No_radio_Button);
		click(driver, MCF_By_Bl_No_radio_Button);
		waitForElement(driver, MCF_By_Bl_No_Search_Button);
		click(driver, MCF_By_Bl_No_Search_Button);
		globalValueSearchWindow(driver, dropdown_Condition, MCF_GlobalSearch_Type, New_BL_Number, "", "", "", "");

		waitForElement(driver, MCF_Show_Button);
		click(driver, MCF_Show_Button);
		String bl_Checkbox = String.format(MCF_Select_Checkbox,New_BL_Number);
		waitForElement(driver, bl_Checkbox);
		checkBox(driver, bl_Checkbox, "Yes");
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			safeclick(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, MCF_Remarks_Area);
		sendKeys(driver, MCF_Remarks_Area, MCF_Remarks_Input);
		waitForElement(driver, MCF_Force_Close_Button);
		click(driver, MCF_Force_Close_Button);
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Extent_completed(test_Case_Name, test, test1);
	}
}