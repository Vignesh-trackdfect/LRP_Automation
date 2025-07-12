package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_039 extends Keywords{
	public void Delivery_Order_TS_039(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_039";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String Print_DO_Check_Box_Select = Excel_data.get("Print_DO_Check_Box_Select");
		String DO_Print_Approval_Module = Excel_data.get("DO_Print_Approval_Module");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_Delivery_Order_Reset = Excel_data.get("module_Delivery_Order_Reset");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Approved_Msg = Excel_data.get("Approved_Msg");
		String DO_Print_Approval_From_Date = Excel_data.get("DO_Print_Approval_From_Date");
		String DO_Print_Approval_To_Date = Excel_data.get("DO_Print_Approval_To_Date");
		String Revert_Action = Excel_data.get("Revert_Action");
		String globalSearchFilterOption_DO_Reset = Excel_data.get("globalSearchFilterOption_DO_Reset");
		String remarks = Excel_data.get("DO_Reset_Remarks");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open DO Print approval screen", test, test1);
		moduleNavigate(driver, DO_Print_Approval_Module);
		Step_End(5, "Open DO Print approval screen", test, test1);
		Step_Start(6, "Select the from date and To date (Sailing date should be in this interval)", test, test1);
		if(!DO_Print_Approval_From_Date.equals("")) {
			waitForElement(driver, DO_Approval_From_Date);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, DO_Approval_From_Date, DO_Print_Approval_From_Date);
			}else {
				clearAndType(driver, DO_Approval_From_Date, DO_Print_Approval_From_Date);
			}
		}
		if(!DO_Print_Approval_To_Date.equals("")) {
			waitForElement(driver, DO_Approval_To_Date);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, DO_Approval_To_Date, DO_Print_Approval_To_Date);
			}else {
				waitForElement(driver, DO_Approval_To_Date);
				clearAndType(driver, DO_Approval_To_Date, DO_Print_Approval_To_Date);
			}
		}
		Step_End(6, "Select the from date and To date (Sailing date should be in this interval)", test, test1);
		Step_Start(8, "Click show button", test, test1);
		waitForElement(driver, DO_Approval_Show_Button);
		click(driver, DO_Approval_Show_Button);
		Step_End(8, "Click show button", test, test1);
		Step_Start(7, "Select the Node \"Delivery order pending for approval \"", test, test1);
		waitForElement(driver, Delivery_Order_Pending_For_Approval);
		click(driver, Delivery_Order_Pending_For_Approval);
		Step_End(7, "Select the Node \"Delivery order pending for approval \"", test, test1);
		Step_Start(9, "Select the respective Bl", test, test1);
		waitForElement(driver, DO_Print_Approval_Tool_Panel);
		click(driver, DO_Print_Approval_Tool_Panel);
		waitForElement(driver, DO_Print_Approval_Filter);
		click(driver, DO_Print_Approval_Filter);
		waitForElement(driver, DO_Print_Approval_BL_Filter);
		sendKeys(driver, DO_Print_Approval_BL_Filter,bl_Number);
		formatLocatorClick(driver, Select_BL_For_Approve, bl_Number);
		Step_End(9, "Select the respective Bl", test, test1);
		Step_Start(10, "Click approve button", test, test1);
		waitForElement(driver, DO_Approval_Approve_Button);
		click(driver, DO_Approval_Approve_Button);
		Step_End(10, "Click approve button", test, test1);
		Step_Start(11, "Make sure selected Bl approved", test, test1);
		waitForPopup(driver, popup_Message,Approved_Msg);
		String actual_Msg = getText(driver, popup_Message);
		if(Approved_Msg.equals(actual_Msg)) {
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Approved_Msg+" || Actual Pop-up value is : "+actual_Msg, test, test1);
			System.out.println("Matched || Expected Pop-up value is : "+Approved_Msg+" || Actual Pop-up value is : "+actual_Msg);
			waitForElement(driver,popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+Approved_Msg+" || Actual Pop-up value is : "+actual_Msg);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+Approved_Msg+" || Actual Pop-up value is : "+actual_Msg, test, test1);
		}
		Step_End(11, "Make sure selected Bl approved", test, test1);
		Step_Start(12, "Open delivery order ", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(12, "Open delivery order ", test, test1);
		Step_Start(13, "Click search button , paste the BL number and search", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO, bl_Number, "", "", "", "");
		Step_End(13, "Click search button , paste the BL number and search", test, test1);
		Step_Start(14, "Fetch the active record in grid", test, test1);
		waitForElement(driver, do_Number_Txtfield);
		String DO_Number = getAttribute(driver, do_Number_Txtfield,"value");
		Step_End(14, "Fetch the active record in grid", test, test1);
		Step_Start(15, "Select the print DO check box and Click print button", test, test1);
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, Print_DO_Check_Box_Select);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(15, "Select the print DO check box and Click print button", test, test1);
		Step_Start(16, "Ensure print page opened and Delivery order number matched with screen.", test, test1);
		waitForElement(driver, jsp_Iframe);
		switchToFrame(driver, jsp_Iframe);
		waitForElement(driver, print_Document_Number_Check);
		String Print_DO_Number = getText(driver, print_Document_Number_Check);
		if(DO_Number.equals(Print_DO_Number)) {
			Extent_pass_New(driver, "Matched || Expected Delivery Order Number : "+DO_Number+" || Actual Delivery Order Number In DO Print : "+Print_DO_Number, test, test1);
			System.out.println("Matched || Expected Delivery Order Number : "+DO_Number+" || Actual Delivery Order Number In DO Print : "+Print_DO_Number);
		}else {
			System.out.println("Not Matched || Expected Delivery Order Number : "+DO_Number+" || Actual Delivery Order Number In DO Print : "+Print_DO_Number);
			Extent_fail(driver, "Not Matched || Expected Delivery Order Number : "+DO_Number+" || Actual Delivery Order Number In DO Print : "+Print_DO_Number, test, test1);
		}
		switchToDefaultFrame(driver);
		waitForElement(driver, close_Button_PDF_Viewer);
		click(driver, close_Button_PDF_Viewer);
		Step_End(16, "Ensure print page opened and Delivery order number matched with screen.", test, test1);
		if(Revert_Action.equalsIgnoreCase("Yes")) {
			Extent_cal(test, test1, module_Delivery_Order_Reset);
			moduleNavigate(driver, module_Delivery_Order_Reset);
			waitForElement(driver, DO_Number_SearchButton);
			click(driver, DO_Number_SearchButton);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO_Reset, bl_Number, "", "", "", "");
			waitForElement(driver, DO_Reset_Remarks_Area);
			sendKeys(driver, DO_Reset_Remarks_Area, remarks);
			waitForElement(driver, DO_Reset_Button);
			click(driver, DO_Reset_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, Configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}
