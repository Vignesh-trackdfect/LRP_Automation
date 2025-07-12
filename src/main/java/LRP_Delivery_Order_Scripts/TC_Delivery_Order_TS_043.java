package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_043 extends Keywords {
	public void Delivery_Order_TS_043(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_043";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number=Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String DO_POP_EXP = Excel_data.get("DO_POP_EXP");
		String IGM_EDI_Generation_Module = Excel_data.get("IGM_EDI_Generation_Module");
		String No_Records_EXP = Excel_data.get("No_Records_EXP");
		String value_back = Excel_data.get("value_back");
		String globalSearchFilterIGM = Excel_data.get("globalSearchFilterIGM");
		String globalSearchFilterdelivery = Excel_data.get("globalSearchFilterdelivery");
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
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		// EDI 
		Step_Start(5, "Open IGM EDI generation module", test, test1);
		moduleNavigate(driver, IGM_EDI_Generation_Module);
		Step_End(5, "Open IGM EDI generation module", test, test1);
		Step_Start(6, "Click search and paste the Bl number ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterIGM,bl_Number, "", "", "", "");
		Step_End(6, "Click search and paste the Bl number ", test, test1);
		Step_Start(7, "Make sure IGM FILE NO generated (No records found)", test, test1);
		waitForElement(driver, IGM_no_record);
		String No_Records_ACT = getText(driver, IGM_no_record);
		if (No_Records_EXP.equals(No_Records_ACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + No_Records_EXP + " || Actual Pop-up value is : " + No_Records_ACT);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + No_Records_EXP + " || Actual Pop-up value is : " + No_Records_ACT, test,test1);
		} else {
			System.out.println("NotMatched || Expected Pop-up value is : " + No_Records_EXP + " || Actual Pop-up value is : " + No_Records_ACT);
			Extent_fail(driver,"NotMatched || Expected Pop-up value is : " + No_Records_EXP + " || Actual Pop-up value is : " + No_Records_ACT,test, test1);
		}
		Step_End(7, "Make sure IGM FILE NO generated (No records found)", test, test1);
		waitForElement(driver, IGM_no_record_close);
		click(driver, IGM_no_record_close);
		// DELIVERY MODULE
		Step_Start(8, "Open Delivery order module ", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(8, "Open Delivery order module ", test, test1);
		Step_Start(9, "Click new button  ", test, test1);
		newButton(driver);
		Step_End(9, "Click new button  ", test, test1);
		Step_Start(10, "Click the \" ADD \" Button ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(10, "Click the \" ADD \" Button ", test, test1);
		Step_Start(11, "Paste the BL and click search ", test, test1);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterdelivery,bl_Number, "", "", "", "");
		Step_End(11, "Paste the BL and click search ", test, test1);
		Step_Start(12, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(12, "Click the SHOW button", test, test1);
		Step_Start(13, "Select the container details in below grid", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(13, "Select the container details in below grid", test, test1);
		Step_Start(14, "Click the Save button ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(14, "Click the Save button ", test, test1);
		Step_Start(15, "Ensure system validated as \"IGM yet to be filed, hence Delivery Order can’t be saved\" ", test, test1);
		waitForPopup(driver,Popup_Message,DO_POP_EXP);
		String DO_POP_ACT = getText(driver, Popup_Message);
		if (DO_POP_EXP.equals(DO_POP_ACT)) {
			System.out.println(
					"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_pass_New(driver,
					"Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT, test,
					test1);
		} else {
			System.out.println(
					"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver,
					"NotMatched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : " + DO_POP_ACT,
					test, test1);
		}
		Step_End(15, "Ensure system validated as \"IGM yet to be filed, hence Delivery Order can’t be saved\" ", test, test1);
		// Agency Configuration
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, value_back, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}
