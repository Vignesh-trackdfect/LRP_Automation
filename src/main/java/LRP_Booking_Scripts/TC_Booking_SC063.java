package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC063 extends Keywords {
	public void Booking_SC063(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String test_Case_Name01 = "TC_Booking_SC063";


		String Username = Excel_data.get("Username");
		String Password =  Excel_data.get("Password");
		String Search =  Excel_data.get("Search_input");
		String agencyUser =  Excel_data.get("AgencyUser");
		String allAgencySearch =  Excel_data.get("allAgencySearch");
		String Surchargesearch =  Excel_data.get("Surchargesearch");
		String Charge_Type =  Excel_data.get("Charge_Type");
		String Charge_code =  Excel_data.get("Charge_code");
		String equip_id =  Excel_data.get("equip_id");
		String IMDG_No =  Excel_data.get("IMDG_No");
		String surcharge_input_Value =  Excel_data.get("surcharge_input_Value");
		String dropdownCondition1 =  Excel_data.get("dropdownCondition");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");

		String selesct_charge_type =  String.format(Booking_Locators.selesct_charge_typee,Charge_Type);
		String Charge_code_select =  String.format(Booking_Locators.Charge_code_selectt,Charge_code);
		String Surcharge_number_select =  String.format(Booking_Locators.Surcharge_number_selectt,surcharge_input_Value);

		Extent_Start(test_Case_Name01, test, test1);

		//Open Url
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//Switch profile
		SwitchProfile(driver, agencyUser);

		Step_Start(1, "open the booking module", test, test1);

		// searching the module of booking

		moduleNavigate(driver, Search);
		Step_End(1, "open the booking module", test, test1);

		// searching contract number in global search 
		Step_Start(2, "reterive the booking number", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, allAgencySearch, "", "", "", "");
		Step_End(2, "reterive the booking number", test, test1);
		Step_Start(3, "open the surcharge module", test, test1);
		// searching the module of booking
		moduleNavigate(driver, Surchargesearch);
		Step_End(3, "open the surcharge module", test, test1);
		Step_Start(4, "select the change type ", test, test1);
		waitForElement(driver, changetype);
		click(driver, changetype);

		waitForElement(driver, selesct_charge_type);
		click(driver, selesct_charge_type);

		waitForElement(driver, clickshow);
		click(driver, clickshow);

		Step_End(4, "select the change type ", test, test1);

		waitForElement(driver, Charge_code_select);
		doubleClick(driver, Charge_code_select);
		Step_Start(5, "click on surcharge number ", test, test1);
		waitForElement(driver, Surcharge_number_select);
		doubleClick(driver, Surcharge_number_select);
		
		Step_End(5, "click on surcharge number ", test, test1);
		Step_Start(6, "take the value of dg ", test, test1);
		
	
		waitForElement(driver, surcharge_filter);
		click(driver, surcharge_filter);



		waitForElement(driver, S_condt_filter1);
		click(driver, S_condt_filter1);


		waitForElement(driver, surcharge_input);
		sendKeys(driver, surcharge_input, surcharge_input_Value);

		waitForElement(driver, S_surcharge_grid);
		doubleClick(driver, S_surcharge_grid);
		scrollBottom(driver);
		waitForElement(driver, S_tool_panel);
		click(driver, S_tool_panel);

		waitForElement(driver, S_condt_filter);
		click(driver, S_condt_filter);

		waitForElement(driver, S_IMDG_filter);
		sendKeys(driver, S_IMDG_filter, IMDG_No);

		waitForElement(driver, S_equip_filter);
		sendKeys(driver, S_equip_filter, equip_id);

		waitForElement(driver, S_surcharge_amount);
		String Valueofdg = getText(driver, S_surcharge_amount);
		System.out.println(Valueofdg);

		scrollTop(driver);
		Step_End(6, "take the value of dg ", test, test1);
		Step_Start(7, "switch to booking ", test, test1);
		 waitForElement(driver, close_second_tab);
			click(driver, close_second_tab); 
	

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(7, "switch to booking ", test, test1);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		scrollBottom(driver);
		Step_Start(8, "take the value of dg ", test, test1);
		
		String selesct_charge_type_amount =  String.format(Booking_Locators.DGvalueinBltab,Charge_code);
		waitForElement(driver, selesct_charge_type_amount);
		String Valueofdgbl=getText(driver, selesct_charge_type_amount);
		System.out.println(Valueofdgbl);
		Step_End(8, "take the value of dg ", test, test1);
		if(Valueofdg.equals(Valueofdgbl)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is [Amount shhown in surcharge]: " + Valueofdg + " || Actual Report Activity is [Amount shown in charges tab]: " + Valueofdgbl);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Amount shhown in surcharge] : " + Valueofdg + " || Actual Report Activity is [Amount shown in charges tab] : " + Valueofdgbl, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is[Amount shhown in surcharge] : " + Valueofdg + " || Actual Report Activity is [Amount shown in charges tab]: " + Valueofdgbl);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Amount shhown in surcharge] : " + Valueofdg + " || Actual Report Activity is[Amount shown in charges tab] : " + Valueofdgbl, test,test1); 
		} 

		Extent_completed(test_Case_Name01, test, test1);
	}
}