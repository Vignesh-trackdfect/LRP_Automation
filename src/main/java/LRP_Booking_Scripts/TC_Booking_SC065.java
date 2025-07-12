package LRP_Booking_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC065 extends Keywords {

	public void Booking_SC065 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name01 = "TC_Booking_SC065";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String search_moduleS = Excel_data.get("search_moduleS");
		String agencyUser = Excel_data.get("agencyUser");
		String booknum = Excel_data.get("booknum");
		String charge_type = Excel_data.get("charge_type");
		String charge_code = Excel_data.get("charge_code");
		String IMDG_No = Excel_data.get("IMDG_No");
		String equip_id = Excel_data.get("equip_id");
		String surcharge_input_Value = Excel_data.get("surcharge_input_Value");
		String dropdownCondition =  Excel_data.get("dropdownCondition");
		String globalSearchFilterOption =  Excel_data.get("globalSearchFilterOption");
		//locators
		String charge_type_opt =  String.format(Booking_Locators.charge_type_optt,charge_type);
		String charge_code_opt =  String.format(Booking_Locators.charge_code_optt,charge_code);
		Extent_Start(test_Case_Name01, test, test1);

		navigateUrl(driver, url);


		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"** Enter Booking Module **");

		Step_Start(1, "Get the surcharge amount for DG charges", test, test1);


		moduleNavigate(driver, search_moduleS);
		waitForElement(driver, S_chargetype);
		click(driver, S_chargetype);
		waitForElement(driver, charge_type_opt);
		click(driver, charge_type_opt);

		waitForElement(driver, S_showbtn);
		click(driver, S_showbtn);

		waitForElement(driver, S_chargecode_filter);
		sendKeys(driver, S_chargecode_filter, charge_code);

		waitForElement(driver, charge_code_opt);
		doubleClick(driver, charge_code_opt);


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
		mouseOverToElement(driver, S_tool_panel);
		click(driver, S_tool_panel);

		waitForElement(driver, S_condt_filter);
		click(driver, S_condt_filter);

		waitForElement(driver, S_IMDG_filter);
		sendKeys(driver, S_IMDG_filter, IMDG_No);

		waitForElement(driver, S_equip_filter);
		sendKeys(driver, S_equip_filter, equip_id);

		waitForElement(driver, S_surcharge_amount);
		String amount_value = getText(driver, S_surcharge_amount);
		System.out.println(amount_value);
		Step_End(1, "Get the surcharge amount for DG charges", test, test1);

		Step_Start(2, "Retrive the booking with DG", test, test1);

		moduleNavigate(driver, search_module);
		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		jsClick(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption, booknum, "", "", "", "");

		Step_End(2, "Retrive the booking with DG", test, test1);

		Step_Start(3, "Get the booking charges amount", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);


		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		String booking_charges_amount =  String.format(Booking_Locators.booking_charges_amountt,charge_code);
		waitForElement(driver, booking_charges_amount);
		String booking_amount = getText(driver, booking_charges_amount);
		System.out.println(booking_amount);
		Step_End(3, "Get the booking charges amount", test, test1);

		Step_Start(4, "Verify the surcharge amount and booking charges amount are same", test, test1);

		if(booking_amount.equals(amount_value)) {
			Extent_pass_New(driver,"Matched || Excepted value is : "+ amount_value+" || Actual value is : "+booking_amount, test,test1);
			System.out.println("Matched || Excepted value is : "+ amount_value+" || Actual value is : "+booking_amount);
		}
		else {
			Extent_fail(driver,"Not matched || Excepted value is : "+ amount_value+" || Actual value is : "+booking_amount, test,test1);
			System.out.println("Not matched || Excepted value is : "+ amount_value+" || Actual value is : "+booking_amount);
		}
		Step_End(4, "Verify the surcharge amount and booking charges amount are same", test, test1);

		Extent_completed(test_Case_Name01, test, test1);
	}
}
