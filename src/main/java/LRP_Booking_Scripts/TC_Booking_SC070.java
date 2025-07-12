package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC070 extends Keywords {


	public void Booking_SC070(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String test_Case_Name01 = "TC_Booking_SC070";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String Actualeqpid = Excel_data.get("Actualeqpid");
		String agencyUser = Excel_data.get("AgencyUser");
		String HSCODE = Excel_data.get("HSCODE");
		String allAgencySearch = Excel_data.get("allAgencySearch");
		String Sealpopexp = Excel_data.get("Sealpop");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition1");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		String commoditygroupinput = Excel_data.get("commoditygroup");



		Extent_Start(test_Case_Name01, test, test1);


		//Open Url
		navigateUrl(driver, url);

		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//Switch profile
		SwitchProfile(driver, agencyUser);

		// searching the module of booking

		moduleNavigate(driver, Search);

		// searching contract number in global search 
		Step_Start(1, "Retrive the booking",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
		
		


		
		Step_End(1, "Retrive the booking ",test, test1);
		Step_Start(2, "Navigate to container tab and edit",test, test1);
		waitForElement(driver, container_tab);
		safeclick(driver, container_tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(2, "Navigate to container tab and edit",test, test1);
		Step_Start(3, "Click on smart import",test, test1);
		waitForElement(driver, Smartimport);
		safeclick(driver, Smartimport);
		Step_End(3, "Click on smart import",test, test1);
		Step_Start(4, "Enter the hs code and equipment id",test, test1);
		waitForElement(driver, Actualequpid);
		doubleClick(driver, Actualequpid);

		Actionsendkeys(driver, Actualequpid, Actualeqpid);


		String actualexp=getText(driver, Actualequpid);
		System.out.println(actualexp);
		horizontalscroll(driver, Scrollbutton1, 1000);
		waitForElement(driver, HScode);
		doubleClick(driver, HScode);
		Actionsendkeys(driver, HScode, HSCODE);

		String hscodeexp=getText(driver, HScode);
		System.out.println(hscodeexp);
		waitForElement(driver, clickhsc);
		safeclick(driver, clickhsc);
		waitForElement(driver, commoditygroup);
		doubleClick(driver, commoditygroup);

		Actionsendkeys(driver, commoditygroup, commoditygroupinput);
		waitForElement(driver, clickhsc);
		safeclick(driver, clickhsc);
		waitForElement(driver, Pasebutton);
		safeclick(driver, Pasebutton);

		Step_End(4, "Enter the hs code and equipment id",test, test1);
		waitForPopup(driver, popup_Message,Sealpopexp);
		String samrtimportpopup=getText(driver, popup_Message);
		if(Sealpopexp.equals(samrtimportpopup)) {                                                                                                                  
			System.out.println("Matched ||Expected Pop-up value is : " + Sealpopexp + " || Actual Pop-up value is : " + samrtimportpopup);            
			Extent_pass_New(driver, "Matched ||Expected Pop-up value is : " + Sealpopexp + " || Actual Pop-up value is : " + samrtimportpopup, test,test1);     
		}                                                                                                                                                                        
		else {
			Extent_fail(driver, "Not Matched || Expected Pop-up value is :: " + Sealpopexp + " || Actual Pop-up value is : " + samrtimportpopup, test,test1); 
			System.out.println("Not Matched || Expected Pop-up value is : " + Sealpopexp + " ||Actual Pop-up value is : " + samrtimportpopup);        

		} 

		Step_Start(5, "Navigate to commodity tab and check whethere is updated in grid",test, test1);

		System.out.println(samrtimportpopup);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		waitForElement(driver, commoditytab);
		safeclick(driver, commoditytab);
		scrollBottom(driver);
		waitForElement(driver, Equipmentidtext);
		String equipmentid=getText(driver, Equipmentidtext);
		System.out.println(equipmentid);


		String commidycode=getText(driver, commoditycode);
		System.out.println(commidycode);
		String commodity_group_act=getText(driver, commoditygroup1);
		System.out.println(commodity_group_act);
		String Equipment_id_act=getText(driver, Equipment_id);
		System.out.println(Equipment_id_act);


		if(commidycode.equals(HSCODE)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + commidycode + " || Actual Report Activity is : " + HSCODE);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + commidycode + " || Actual Report Activity is  : " + HSCODE, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + commidycode + " || Actual Report Activity is : " + HSCODE);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + commidycode + " || Actual Report Activity is : " + HSCODE, test,test1); 
		} 


		if(commoditygroupinput.equals(commodity_group_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + commoditygroupinput + " || Actual Report Activity is : " + commodity_group_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + commoditygroupinput + " || Actual Report Activity is  : " + commodity_group_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + commoditygroupinput + " || Actual Report Activity is : " + commodity_group_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + commoditygroupinput + " || Actual Report Activity is : " + commodity_group_act, test,test1); 
		}
		if(Actualeqpid.trim().equals(Equipment_id_act.trim())) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Actualeqpid + " || Actual Report Activity is : " + Equipment_id_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Actualeqpid + " || Actual Report Activity is  : " + Equipment_id_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Actualeqpid + " || Actual Report Activity is : " + Equipment_id_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Actualeqpid + " || Actual Report Activity is : " + Equipment_id_act, test,test1); 
		}
		Step_End(5, "Navigate to commodity tab and check whethere is updated in grid",test, test1);

		Extent_completed(test_Case_Name01, test, test1);



	} 


}
