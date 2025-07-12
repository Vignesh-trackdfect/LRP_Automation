package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_029 extends Keywords{
	public void Delivery_Order_TS_029(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_029";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description_Data = Excel_data.get("description_Data");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String Condition = Excel_data.get("Condition");
		String default_Value = Excel_data.get("default_Value");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(5, "Open delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(5, "Open delivery order module", test, test1);
		Step_Start(6, "Ensure system will shown the Empty Return Depot Field  in Delivery order screen.", test, test1);
		waitForDisplay(driver, empty_Return_Depot_Field);
		if(isDisplayed(driver, empty_Return_Depot_Field)) {
			System.out.println("MATCHED || Expected Result is : Empty return depot field Should be display in the Delivery Order Screen || Actual Result is : Empty return depot field is displaying in the Delivery Order Screen");
			Extent_pass_New(driver,"MATCHED || Expected Result is : Empty return depot field Should be display in the Delivery Order Screen || Actual Result is : Empty return depot field is displaying in the Delivery Order Screen", test, test1);
		}else {
			System.out.println("NOT MATCHED || Expected Result is : Empty return depot field Should be display in the Delivery Order Screen || But Actual Result is : Empty return depot field is Not displaying in the Delivery Order Screen");
			Extent_fail(driver,"NOT MATCHED || Expected Result is : Empty return depot field Should be display in the Delivery Order Screen || But Actual Result is : Empty return depot field is Not displaying in the Delivery Order Screen", test, test1);
		}
		Step_End(6, "Ensure system will shown the Empty Return Depot Field in Delivery order screen.", test, test1);
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}
