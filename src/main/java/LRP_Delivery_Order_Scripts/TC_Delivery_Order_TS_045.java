package LRP_Delivery_Order_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_045 extends Keywords {
	public void Delivery_Order_TS_045(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_045";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String attribute = Excel_data.get("Attribute");
		String value_back = Excel_data.get("value_back");
		String set_As_Default = Excel_data.get("set_As_Default");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header,Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(5, "Open delivery order module", test, test1);
		Step_Start(6, "Ensure system will shown the 'Empty Return form' in Delivery order screen", test, test1);
		waitForDisplay(driver, empty_Return_Form_Data);
		if(isDisplayed(driver, empty_Return_Form_Data)) {
			System.out.println("Matched || Expected Result is : Empty Return Form Data Should be Displayed in Delivery Order Screen || Actual Result is : Empty Return Form Data is Displayed in the Delivery Order Screen");
			Extent_pass_New(driver,"Matched || Expected Result is : Empty Return Form Data Should be Displayed in Delivery Order Screen || Actual Result is : Empty Return Form Data is Displayed in the Delivery Order Screen", test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Empty Return Form Data Should be Displayed in Delivery Order Screen || Actual Result is : Empty Return Form Data is Not Displayed in the Delivery Order Screen");
			Extent_fail(driver,"Not Matched || Expected Result is : Empty Return Form Data Should be Displayed in Delivery Order Screen || Actual Result is : Empty Return Form Data is Not Displayed in the Delivery Order Screen", test, test1);
		}
		Step_End(6, "Ensure system will shown the 'Empty Return form' in Delivery order screen", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, value_back, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}