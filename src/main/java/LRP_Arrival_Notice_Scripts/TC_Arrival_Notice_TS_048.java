package LRP_Arrival_Notice_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_048 extends Keywords{
	
	
	

	public void Arrival_Notice_TS_048(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
	
	
	String testcase_Name="TC_Arrival_Notice_TS_048";
	
			

	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String AgencyUser = Excel_data.get("AgencyUser");
	String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
	String Agency_Code_search = Excel_data.get("Agency_Code_search");
	String Attribute_Search = Excel_data.get("Attribute_Search");
	String condition_Filter = Excel_data.get("Condition_Filter");
	String attribute = Excel_data.get("Attribute");
	String description = Excel_data.get("description");
	String value = Excel_data.get("value");
	String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
	String BL_Condition = Excel_data.get("BL_Condition");
	String Search_Number = Excel_data.get("Search_Number");
	String BL_Num = Excel_data.get("BL_Num");
	String BL_Number_box = Excel_data.get("BL_Number_box");

	
	





	navigateUrl(driver, url);
	LRP_Login(driver, Username, Password);

	SwitchProfile(driver, AgencyUser);

	Step_Start(1, " Open Agency configuration screen", test, test1);
	// Agency Configuration
	
	
	
	
	
	
	setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Code_search, Attribute_Search, condition_Filter, AgencyUser, attribute, description, value);
	
	
	
	moduleNavigate(driver, ImportDocumentationModule);

	Step_End(4, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);
	Step_Start(5, "Select the Arrival Notice  Freight Memo from search icon", test, test1);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	
	
	globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "","", "","");
	
	
	Step_End(5, "Select the \"Arrival Notice / Freight Memo\" from search icon", test, test1);
	List<String> datas = splitAndExpand(BL_Number_box);
	
	for(String data :datas) {
		String select_checkbox1 =  String.format(Arrival_Notice_Locators.bl_select_box,data); 
		waitForElement(driver, select_checkbox1);
		click(driver, select_checkbox1);
	}
	Step_Start(6, ".Ensure \"Send to customer\"  button has to be disabled", test, test1);
	waitForDisplay(driver, sendtocustomerclick);
	if(isdisplayed(driver, sendtocustomerclick)) {
		
		Extent_fail(driver, "NotMatched || Expected Result is : Send_To_Customer_Button button Should be not  Enable  and displayed|| Actual Result is : Send_To_Customer_Button button  Enable  and displayed", test, test1);
		System.out.println("NotMatched || Expected Result is : Send_To_Customer_Button button Should be not Enable  and displayed|| Actual Result is : Send_To_Customer_Button button  Enable  and displayed");
	}else {
		System.out.println(" Matched || Expected Result is : Send_To_Customer_Button button Should be not Enable  and displayed || Actual Result is : Send_To_Customer_Button button  not Enable  and displayed");
		Extent_pass(driver," Matched || Expected Result is : Send_To_Customer_Button button Should be not Enable  and displayed || Actual Result is : Send_To_Customer_Button button not Enable  and displayed", test, test1);
	}
		
	Step_End(6, ".Ensure \"Send to customer\"  button has to be disabled", test, test1);
			Extent_completed(testcase_Name, test, test1);
	
	
}
}