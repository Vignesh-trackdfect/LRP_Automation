package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_048  extends Keywords{
	public void Delivery_Order_TS_048(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_048";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String configuration_Reset = Excel_data.get("Configuration_Reset");
		String bl_Number=Excel_data.get("BL_Number");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String remarks_Input = Excel_data.get("remarks_Input");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String after_Remarks_GlobalSearchFilterOption_DO = Excel_data.get("after_Remarks_GlobalSearchFilterOption_DO");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1,"Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header,Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open delivery order ", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open delivery order ", test, test1);
		Step_Start(6, "Click search and fetch the BL click edit ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterOption_DO,bl_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);

		Step_End(6, "Click search and fetch the BL click edit ", test, test1);
		Step_Start(7, "Enter the remarks and click save", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, DO_Remarks_Field);
		clear(driver, DO_Remarks_Field);
		sendKeys(driver, DO_Remarks_Field, remarks_Input);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(7, "Enter the remarks and click save", test, test1);
		Step_Start(8, "Copy the Delivery order number ", test, test1);
		waitForElement(driver, do_Number_Txtfield);
		String DO_Number = getAttribute(driver, do_Number_Txtfield, "value");
		Step_End(8, "Copy the Delivery order number ", test, test1);
		Step_Start(9, "Click search and fetch the respective delivery order number", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,after_Remarks_GlobalSearchFilterOption_DO,DO_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);

		Step_End(9, "Click search and fetch the respective delivery order number", test, test1);
		Step_Start(10, "Make sure entered value matched", test, test1);
		waitForElement(driver, DO_Remarks_Field);
		String actual_Remarks = getText(driver, DO_Remarks_Field);
		if(remarks_Input.equals(actual_Remarks)) {
			Extent_pass_New(driver, "Matched || Expected Remarks Given From Excel is : "+remarks_Input+" || Actual Remarks In Delivery Order Module is : "+actual_Remarks, test, test1);
			System.out.println("Matched || Expected Remarks Given From Excel is : "+remarks_Input+" || Actual Remarks In Delivery Order Module is : "+actual_Remarks);
		}else {
			System.out.println("Not Matched || Expected Remarks Given From Excel is : "+remarks_Input+" || Actual Remarks In Delivery Order Module is : "+actual_Remarks);
			Extent_fail(driver,"Not Matched || Expected Remarks Given From Excel is : "+remarks_Input+" || Actual Remarks In Delivery Order Module is : "+actual_Remarks, test, test1);
		}
		Step_End(10,"Make sure entered value matched", test, test1);
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, configuration_Reset, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}
