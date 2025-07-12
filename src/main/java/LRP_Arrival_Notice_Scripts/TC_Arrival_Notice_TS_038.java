package LRP_Arrival_Notice_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_038 extends Keywords{
	


	
	public void Arrival_Notice_TS_038(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException {
		
		

		String tc_Name="TC_Arrival_Notice_TS_038";
		
		
		

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String ImportDocumentationModule=Excel_data.get("ImportDocumentationModule");
		String bl_Number =Excel_data.get("bl_Number");
		String equal_To=Excel_data.get("equal_To");
		String valid_Mcn_Avail_Exp =Excel_data.get("valid_Mcn_Avail_Exp").trim();
		String Search_Number=Excel_data.get("Search_Number");
		String Search_Number1=Excel_data.get("Search_Number1");
		String MCN_Available_Expected = Excel_data.get("MCN_Available_Expected");
		String MCN_Exists_Expected =Excel_data.get("MCN_Exists_Expected");
		String DropdownCondition =Excel_data.get("DropdownCondition");
		

		
		

		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);

//		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);


		Step_Start(2, " Open import documentation screen", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(2, " Open import documentation screen", test, test1);
		
		Step_Start(3, ".Click search and paste the BL ", test, test1);
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar );
		globalValueSearchWindow(driver, DropdownCondition, Search_Number1, bl_Number, "","", "","");
		Step_End(3, ".Click search and paste the BL ", test, test1);
		Step_Start(4, "Make  \" MCN exists \" shown for this Bl", test, test1);
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
		
		Step_End(4, "Make  \" MCN exists \" shown for this Bl", test, test1);
		Step_Start(5, "Open arrival notice screen", test, test1);
		moduleNavigate(driver, arrival_Module_Search);
		Step_End(5, "Open arrival notice screen", test, test1);
		Step_Start(6, "Click new button and fetch the BL", test, test1);	
		newButton(driver);

		waitForElement(driver, by_Bl_Number_Button_AN);
		click(driver, by_Bl_Number_Button_AN);
		

		waitForElement(driver, BL_Search_button_AN);
		click(driver, BL_Search_button_AN);
		
		
		
		globalValueSearchWindow(driver, equal_To, Search_Number, bl_Number, "","", "","");
		
		Step_End(6, "Click new button and fetch the BL", test, test1);	

		Step_Start(7, "After fetching record click show button", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		Step_End(7, "After fetching record click show button", test, test1);		

	
		scrollTop(driver);
		Step_Start(8, "Click EDIT button and select the record", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		
		String click_Chckbox_By_Bl_Number=String.format(Arrival_Notice_Locators.click_checkbox_By_Bl_Num,bl_Number);
	

		waitForElement(driver, click_Chckbox_By_Bl_Number);
		click(driver, click_Chckbox_By_Bl_Number);
		
		Step_End(8, "Click EDIT button and select the record", test, test1);
		Step_Start(9, "Click Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(9, "Click Save button", test, test1);
		Step_Start(10, "Ensure system validated as 'BL Number(s) with Valid MCN Available'", test, test1);

		waitForPopup(driver, valid_Mcn_Avail_Popup, valid_Mcn_Avail_Exp);    
		String actual_Valid_Mcn_Popup = getText(driver, valid_Mcn_Avail_Popup).trim();
		
		if(actual_Valid_Mcn_Popup.equals(valid_Mcn_Avail_Exp)) {
			
			System.out.println("MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup);
			Extent_pass(driver, "MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup);
			Extent_fail(driver, "NOT MATCHED || EXPECTED VALID MCN AVAILABLE POPUP IS: "+valid_Mcn_Avail_Exp+" ACTUAL VALID MCN AVAILABLE POPUP IS :"+actual_Valid_Mcn_Popup, test, test1);
		}
		
		Step_End(10, "Ensure system validated as 'BL Number(s) with Valid MCN Available'", test, test1);

		Extent_completed(tc_Name, test, test1);
	}
	

	

		
	}
	

