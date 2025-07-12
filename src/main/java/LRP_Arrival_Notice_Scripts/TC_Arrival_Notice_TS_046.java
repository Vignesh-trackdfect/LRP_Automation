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

public class TC_Arrival_Notice_TS_046 extends Keywords {

	public void Arrival_Notice_TS_046(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		String testcase_Name="TC_Arrival_Notice_TS_046";
		
		
		




		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
		String GlobalID = Excel_data.get("GlobalID");
		String GlobalValue = Excel_data.get("GlobalValue");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		  String Search_Number = Excel_data.get("Search_Number");
		  String BL_Num = Excel_data.get("BL_Num");
		  String BL_Number_box = Excel_data.get("BL_Number_box");
		
		
	
       
      


		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);


		Step_Start(1, "Open Global configuration screen", test, test1);
		setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);

		
		
		Step_Start(5, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);
		

		moduleNavigate(driver, ImportDocumentationModule);

	waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "","", "","");
		
		
		Step_End(5, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);
		
		
	List<String> datas = splitAndExpand(BL_Number_box);
		
		for(String data :datas) {
			String select_checkbox1 =  String.format(Arrival_Notice_Locators.bl_select_box,data); 
			waitForElement(driver, select_checkbox1);
			click(driver, select_checkbox1);
			Step_Start(6, "Verify auction notice button has to be enabled", test, test1);
		if(isdisplayed(driver, auction_Notice_Button_AN)) {
			
			Extent_fail(driver, "Matched || Expected Result is : Auction_Notice button Should be Enable  and displayed|| Actual Result is : Auction_Notice button  Enable  and displayed", test, test1);
			System.out.println("Matched || Expected Result is : Auction_Notice button Should be Enable  and displayed|| Actual Result is : Auction_Notice button  Enable  and displayed");
		}else {
			System.out.println("Not Matched || Expected Result is : Auction_Notice button Should be Enable  and displayed || Actual Result is : Auction_Notice button  not Enable  and displayed");
			Extent_pass(driver,"Not Matched || Expected Result is : Auction_Notice button Should be Enable  and displayed || Actual Result is : Auction_Notice button not Enable  and displayed", test, test1);
		}}
	
		Step_End(6, "Verify auction notice button has to be enabled", test, test1);
		Extent_completed(testcase_Name, test, test1);
	

}
	}


