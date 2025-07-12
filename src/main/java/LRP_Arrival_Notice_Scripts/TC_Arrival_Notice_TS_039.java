package LRP_Arrival_Notice_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_039 extends Keywords {

	public void Arrival_Notice_TS_039(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		

		String tc_Name="TC_Arrival_Notice_TS_039";
		
		
		

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String AU5_Module =Excel_data.get("AU5_Module");
		String ImportDocumentationModule =Excel_data.get("Imp_Doc_Search");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Search_Number =Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("bl_Number");
		String MCN_Available_Expected = Excel_data.get("MCN_Available_Expected");
		String valid_Mcn_Avail_Exp =Excel_data.get("valid_Mcn_Avail_Exp");
		String MCN_Exists_Expected =Excel_data.get("MCN_Exists_Expected");
		
	
		


		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);


		LRP_Login(driver, username, password);


		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, AU5_Module);


		Step_End(1, " Switch the agency ", test, test1);

		Step_Start(2, "Open Import documentation screen", test, test1);

		
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(2, "Open Import documentation screen", test, test1);
		Step_Start(3, "Click search button and pass the BL", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		Step_End(3, "Click search button and pass the BL", test, test1);
		
		
		Step_Start(4, "Fetch the record make sure \"  MCN available \" shown for this Bl", test, test1);
		
		waitForDisplay(driver, mcn_avaliable_text); 
		String MCN_avaliable=getText(driver, mcn_avaliable_text);	
		System.out.println(MCN_avaliable);
		
		if(MCN_avaliable.equalsIgnoreCase(MCN_Available_Expected)) {
		
		
		if(MCN_Available_Expected.equalsIgnoreCase(MCN_avaliable)) {
		System.out.println("MATCHED || EXPECTED BL Number should be have Mcn Available: "+MCN_Available_Expected+" ACTUAL BL Number shown Mcn Available :"+MCN_avaliable);
		Extent_pass(driver, "MATCHED || EXPECTED BL Number should be have Mcn Available: "+MCN_Available_Expected+" ACTUAL BL Number shown Mcn Available :"+MCN_avaliable, test, test1);
	}else {
		
		System.out.println("NOT MATCHED || EXPECTED BL Number should be have Mcn Available: "+MCN_Available_Expected+" ACTUAL BL Number not shown Mcn Available :"+MCN_avaliable);
		Extent_fail(driver, "NOT MATCHED || EXPECTED BL Number should be have Mcn Available: "+MCN_Available_Expected+" ACTUAL BL Number not shown Mcn Available :"+MCN_avaliable, test, test1);
		
	}}
		
		
		if(MCN_avaliable.equalsIgnoreCase(MCN_Exists_Expected)) {
			
			
			if(MCN_avaliable.equalsIgnoreCase(MCN_Exists_Expected)) {
			System.out.println("MATCHED || EXPECTED BL Number should be have Mcn Exists: "+MCN_Exists_Expected+" ACTUAL BL Number shown Mcn Exists :"+MCN_avaliable);
			Extent_pass(driver, "MATCHED || EXPECTED BL Number should be have Mcn Exists: "+MCN_Exists_Expected+" ACTUAL BL Number shown Mcn Exists :"+MCN_avaliable, test, test1);
		}else {
			
			System.out.println("NOT MATCHED || EXPECTED BL Number should be have Mcn Exists: "+MCN_Exists_Expected+" ACTUAL BL Number not shown Mcn Exists :"+MCN_avaliable);
			Extent_fail(driver, "NOT MATCHED || EXPECTED BL Number should be have Mcn Exists: "+MCN_Exists_Expected+" ACTUAL BL Number not shown Mcn Exists :"+MCN_avaliable, test, test1);
			
		}}
		
		
		
		
		
		
	
		Step_End(4, "Fetch the record make sure \"  MCN available \" shown for this Bl", test, test1);
		
		Step_Start(5, "navigate to arrival notice screen ", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(5, "navigate to arrival notice screen ", test, test1);



	
		
		Step_Start(6, "Select the Bl in Grid ", test, test1);
		
		String click_checkbox_By_Bl_Num=String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num, bl_Number);
		waitForElement(driver, click_checkbox_By_Bl_Num);
		click(driver, click_checkbox_By_Bl_Num);
		
		Step_End(6, "Select the Bl in Grid ", test, test1);

		Step_Start(7, "Click the Print button", test, test1);
		
		waitForElement(driver, print_Btn_Toolbar_AN);
		click(driver, print_Btn_Toolbar_AN);
		
		Step_End(7, "Click the Print button", test, test1);

		
		Step_Start(8, "System validated as \" BL number(s ) with Valid MCN  Available",test, test1);
		
		waitForPopup(driver, valid_Mcn_Avail_Popup, valid_Mcn_Avail_Exp); 
		String actual_Valid_Mcn_Popup = getText(driver, valid_Mcn_Avail_Popup);
		
		if(actual_Valid_Mcn_Popup.equals(valid_Mcn_Avail_Exp)) {
			
			System.out.println("MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup);
			Extent_pass(driver, "MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup, test, test1);
		}else {
			
			System.out.println("NOT MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup);
			Extent_fail(driver, "NOT MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup, test, test1);
			
		}
		
		
		
		Step_End(8, "System validated as \" BL number(s ) with Valid MCN  Available",test, test1);

		Extent_completed(tc_Name, test, test1);
		

	}
}
