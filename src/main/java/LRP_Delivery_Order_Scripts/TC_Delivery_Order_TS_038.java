package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_038 extends Keywords{
	public void Delivery_Order_TS_038(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_038";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String Print_DO_Check_Box_Select = Excel_data.get("Print_DO_Check_Box_Select");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Popup_Msg = Excel_data.get("Popup_Msg");
		String Date_Picker = Excel_data.get("Date_Picker");
		String DO_Print_Approval_From_Date = Excel_data.get("DO_Print_Approval_From_Date");
		String DO_Print_Approval_To_Date = Excel_data.get("DO_Print_Approval_To_Date");
		String DO_Print_Approval_Module = Excel_data.get("DO_Print_Approval_Module");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name,  test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1,"Switch the agency" , test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency" , test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open delivery order screen" , test, test1);
		scrollTop(driver);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open delivery order screen" , test, test1);
		Step_Start(6, "Click search button , paste the BL number / Delivery order number and search " , test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, bl_Number, "", "", "", "");
		Step_End(6, "Click search button , paste the BL number / Delivery order number and search " , test, test1);
		Step_Start(7, "Fetch the active record in grid" , test, test1);
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);

		Step_End(7, "Fetch the active record in grid" , test, test1);
		Step_Start(8, "Select the print DO check box" , test, test1);
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, Print_DO_Check_Box_Select);
		Step_End(8, "Select the print DO check box" , test, test1);
		Step_Start(9,"Click Print button" , test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(9, "Click Print button" , test, test1);
		Step_Start(10,"Ensure System validates  'The superuser is not approved. Hence, Delivery Order cannot be printed'" , test, test1);
		waitForPopup(driver, popup_Message,Popup_Msg);
		String actual_Popup = getText(driver, popup_Message);
		if (Popup_Msg.equals(actual_Popup)) {
			System.out.println("Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Popup value was : " + Popup_Msg + " || Actual Delivery Order Popup value was : " + actual_Popup, test, test1);
		}
		Step_End(10, "Ensure System validates 'The superuser is not approved. Hence, Delivery Order cannot be printed'" , test, test1);
		Step_Start(11,"Open DO Print approval screen" , test, test1);
		moduleNavigate(driver, DO_Print_Approval_Module);
		Step_End(11,"Open DO Print approval screen" , test, test1);
		Step_Start(12,"Pass the date and click show button" , test, test1);
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
		waitForElement(driver, DO_Approval_Show_Button);
		click(driver, DO_Approval_Show_Button);
		Step_End(12,"Pass the date and click show button" , test, test1);
		Step_Start(13,"Select the \"Delivery order pending for approval node \"" , test, test1);
		waitForElement(driver, Delivery_Order_Pending_For_Approval);
		click(driver, Delivery_Order_Pending_For_Approval);
		Step_End(13,"Select the \"Delivery order pending for approval node \"" , test, test1);
		Step_Start(14,"Make sure respective DO number presented this node and Display " , test, test1);
		waitForElement(driver, DO_Print_Approval_Tool_Panel);
		click(driver, DO_Print_Approval_Tool_Panel);
		waitForElement(driver, DO_Print_Approval_Filter);
		click(driver, DO_Print_Approval_Filter);
		waitForElement(driver, DO_Print_Approval_BL_Filter);
		sendKeys(driver, DO_Print_Approval_BL_Filter,bl_Number);
		String select_BL = String.format(Select_BL_For_Approve, bl_Number);
		waitForDisplay(driver, select_BL);
		if(isDisplayed(driver, select_BL)) {
			System.out.println("Matched || "+bl_Number+" BL Number is Not Approved In the DO Print Approval Module . It is in the Pending status ");
			Extent_pass_New(driver,"Matched || "+bl_Number+" BL Number is Not Approved In the DO Print Approval Module . It is in the Pending status ", test,test1);
		} else {
			System.out.println("Not Matched || "+bl_Number+" BL Number is Approved In the DO Print Approval Module . It is Not in the Pending status ");
			Extent_fail(driver,"Not Matched || "+bl_Number+" BL Number is Approved In the DO Print Approval Module . It is Not in the Pending status ", test, test1);
		}
		Step_End(14,"Make sure respective DO number presented this node and Display " , test, test1);
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, Configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name , test, test1);
	}
}
