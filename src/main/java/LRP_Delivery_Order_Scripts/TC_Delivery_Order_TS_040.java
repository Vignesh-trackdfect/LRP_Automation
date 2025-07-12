package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_040 extends Keywords{
	public void Delivery_Order_TS_040(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_040";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Print_DO_Check_Box_Select = Excel_data.get("Print_DO_Check_Box_Select");
		String bl_Number=Excel_data.get("Search_Input");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Popup_Msg = Excel_data.get("Popup_Msg");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Configuration_Reset = Excel_data.get("Configuration_Reset");                                                    
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, AgencyUser);
		// Agency Configuration
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);
		Step_Start(5, "Open Delivery order module and use \"MYPKGEDO505\" Delivery Order number", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(5, "Open Delivery order module and use \"MYPKGEDO505\" Delivery Order number", test, test1);
		Step_Start(6, "Click search and pass the Delivery Order number", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, bl_Number, "", "", "", "");
		Step_Start(7, "Click on the select Option", test, test1);
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);
		Step_End(7, "Click on the select Option", test, test1);
		Step_End(6, "Click search and pass the Delivery Order number", test, test1);
		Step_Start(8, "Select print DO option and click Print button", test, test1);
		waitForElement(driver, DO_Table_Headers);
		List<Map<String, String>> container_Table_Values = getTableData(driver, DO_Table_Headers, DO_Table_Rows);
		List<String> containers = getValuesByHeader(container_Table_Values, "Container No");
		String container="";
		for(int i=0;i<containers.size();i++) {
			if(i==containers.size()-1) {
				container=container+containers.get(i);
			}else {
				container=container+containers.get(i)+",";
			}
		}
		String finalPopupValue=String.format(Popup_Msg, container);
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, Print_DO_Check_Box_Select);
		Step_End(8, "Select print DO option and click Print button", test, test1);
		Step_Start(9, "Ensure that system validated as \"Below container(s) are gated out, hence DO cannot be printed. ", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		waitForPopup(driver, popup_Message,finalPopupValue);
		String actual_Popup = getText(driver, popup_Message);
		System.out.println("actual_Popup : "+actual_Popup);
		if (finalPopupValue.trim().equals(actual_Popup.trim())) {
			System.out.println("Matched || Expected Delivery Order Popup value was : " + finalPopupValue + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Popup value was : " + finalPopupValue + " || Actual Delivery Order Popup value was : " + actual_Popup, test,test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Popup value was : " + finalPopupValue + " || Actual Delivery Order Popup value was : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Popup value was : " + finalPopupValue + " || Actual Delivery Order Popup value was : " + actual_Popup,test, test1);
		}
		Step_End(9, "Ensure that system validated as \"Below container(s) are gated out, hence DO cannot be printed. ", test, test1);
		reSetGlobalConfiguration(driver,Reset_Option,GlobalConfigurationModule, GlobalID, Configuration_Reset);
		Extent_completed(testcase_Name, test, test1);
	}
}