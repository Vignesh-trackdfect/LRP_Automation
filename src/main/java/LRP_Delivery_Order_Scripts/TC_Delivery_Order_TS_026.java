package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_026 extends Keywords {

	public void Delivery_Order_TS_026(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_026";
		
		
		




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description_Data = Excel_data.get("description_Data");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String default_Value = Excel_data.get("default_Value");
		String do_Status_Expected = Excel_data.get("do_Status_Expected");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(3, "Open the Delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(3, "Open the Delivery order module", test, test1);
		Step_Start(4, "Click search button,paste the Bl or DO number ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, Dropdown_Condition, Global_search_value_Bl_Number, bl_Number, "", "", "", "");
		Step_End(4, "Click search button,paste the Bl or DO number ", test, test1);
		Step_Start(5, "Fetch the record (Capture the DO status, which should be issued)", test, test1);
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);

		waitForElement(driver, do_Status);
		String do_Status_actual = getText(driver, do_Status);
		if(do_Status_actual.contains(do_Status_Expected)) {
			System.out.println("MATCHED || EXPECTED DO STATUS -> "+do_Status_Expected+"|| ACTUAL DO STATUS -> "+do_Status_actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED DO STATUS -> "+do_Status_Expected+"|| ACTUAL DO STATUS -> "+do_Status_actual, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED DO STATUS -> "+do_Status_Expected+"|| ACTUAL DO STATUS -> "+do_Status_actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED DO STATUS -> "+do_Status_Expected+"|| ACTUAL DO STATUS -> "+do_Status_actual, test, test1);
		}
		Step_End(5, "Fetch the record (Capture the DO status, which should be issued)", test, test1);
		Step_Start(6, "Copy the Delivery order number and select DO print option", test, test1);
		scrollTop(driver);
		waitForElement(driver, do_Number_Txtfield);
		String do_Number_Screen = getAttribute(driver, do_Number_Txtfield, "value");
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box,"Yes");
		Step_End(6, "Copy the Delivery order number and select DO print option", test, test1);
		Step_Start(7, "Click print button on Tool bar", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(7, "Click print button on Tool bar", test, test1);
		Step_Start(8, "Ensure Print page should be opened and Delivery order number should be matched with printout", test, test1);
		waitForElement(driver, jasper_Document);
		switchToFrame(driver, jasper_Document);
		waitForElement(driver, print_Document_Number_Check);
		String do_Number_In_Document = getText(driver, print_Document_Number_Check);
		if(do_Number_In_Document.equals(do_Number_Screen)) {
			System.out.println("MATCHED || EXPECTED DO NUMBER IS : "+do_Number_Screen+" ACTUAL DO NUMBER IS : "+do_Number_In_Document);
			Extent_pass_New(driver, "MATCHED || EXPECTED DO NUMBER IS : "+do_Number_Screen+" ACTUAL DO NUMBER IS : "+do_Number_In_Document, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED DO NUMBER IS : "+do_Number_Screen+" ACTUAL DO NUMBER IS : "+do_Number_In_Document);
			Extent_fail(driver, "NOT MATCHED || EXPECTED DO NUMBER IS : "+do_Number_Screen+" ACTUAL DO NUMBER IS : "+do_Number_In_Document, test, test1);
		}
		switchToDefaultFrame(driver);
		waitForElement(driver, x_option);
		click(driver, x_option);
		Step_End(8, "Ensure Print page should be opened and Delivery order number should be matched with printout", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}