package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_012 extends Keywords{
	public void Delivery_Order_TS_012(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_012";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String attribute = Excel_data.get("attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");
		String Value_To_Reset = Excel_data.get("Value_To_Reset");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description, value);
		scrollTop(driver);
		Step_Start(4, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(4, "Open Delivery order module", test, test1);
		Step_Start(5, "Click new button ", test, test1);
		newButton(driver);
		Step_End(5, "Click new button ", test, test1);
		Step_Start(6, "Ensure customer search option disabled ", test, test1);
		waitForElement(driver, DO_Customer_Code_Search_Button);
		if(!isElementEnabled(driver, DO_Customer_Code_Search_Button)) {
			System.out.println("Matched || The Expected Result is : Customer Search Selection Option Should be Disabled in delivery order screen based on agency configuration 'DEC' as 'N' || The Actual : Customer Search Selection Option is Disabled in delivery order screen based on agency configuration 'DEC' as 'N'");
			Extent_pass_New(driver,"Matched || The Expected Result is : Customer Search Selection Option Should be Disabled in delivery order screen based on agency configuration 'DEC' as 'N' || The Actual : Customer Search Selection Option is Disabled in delivery order screen based on agency configuration 'DEC' as 'N'", test, test1);
		} else {
			System.out.println("Not Matched || The Expected Result is : Customer Search Selection Option Should be Disabled in delivery order screen based on agency configuration 'DEC' as 'N' || But The Actual : Customer Search Selection Option is Enabled in delivery order screen based on agency configuration 'DEC' as 'N'");
			Extent_fail(driver,"Not Matched || The Expected Result is : Customer Search Selection Option Should be Disabled in delivery order screen based on agency configuration 'DEC' as 'N' || But The Actual : Customer Search Selection Option is Enabled in delivery order screen based on agency configuration 'DEC' as 'N'", test, test1);
		}	
		Step_End(6, "Ensure customer search option disabled ", test, test1);
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description, Value_To_Reset, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}