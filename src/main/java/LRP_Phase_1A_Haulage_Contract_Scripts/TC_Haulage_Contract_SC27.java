package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC27 extends Keywords{
	public void Haulage_Contract_SC27(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC27";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Pickup_Location_Header = Excel_data.get("Pickup_Location_Header");
		String Pickup_Location_Code = Excel_data.get("Pickup_Location_Code");
		String Drop_Location_Code = Excel_data.get("Drop_Location_Code");
		String Equipment_Type = Excel_data.get("Equipment_Type");
		String HC_LDN_MTY_Value = Excel_data.get("HC_LDN_MTY_Value");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String Pickup_Type_Value = Excel_data.get("Pickup_Type_Value");
		String Drop_Type_Value = Excel_data.get("Drop_Type_Value");
		String Pickup_Term_Value = Excel_data.get("Pickup_Term_Value");
		String Drop_Term_Value = Excel_data.get("Drop_Term_Value");
		String Haulage_mode_Value = Excel_data.get("Haulage_mode_Value");
		String Trip_Type_Value = Excel_data.get("Trip_Type_Value");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Neg_On_Date = Excel_data.get("Neg_On_Date");
		String Amount_Type = Excel_data.get("Amount_Type");
		String Amount_Input = Excel_data.get("Amount_Input");
		String Currency_Select_Input = Excel_data.get("Currency_Select_Input");
		String Currency_Header = Excel_data.get("Currency_Header");
		String Drop_Terminal_Value = Excel_data.get("Drop_Terminal_Value");
		String Drop_Terminal_Header = Excel_data.get("Drop_Terminal_Header");
		String Pickup_Terminal_Value = Excel_data.get("Pickup_Terminal_Value");
		String Pickup_Terminal_Header = Excel_data.get("Pickup_Terminal_Header");








		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		waitForElement(driver, Vendor_Search_Button);
		click(driver, Vendor_Search_Button);


		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		Step_Start(3, "Click on the \"+\" Button to add the all details ", test, test1);
		waitForElement(driver, HC_Plus_Button);
		click(driver, HC_Plus_Button);

		Step_End(3, "Click on the \"+\" Button to add the all details ", test, test1);


		Step_Start(18, "Fill the all mandadory details ", test, test1);
		Step_Start(4, " Click the Pickup Loc search field and select the Pick up location", test, test1);
		waitForElement(driver, HC_Pickup_Location_Search_Button);
		click(driver, HC_Pickup_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Pickup_Location_Code);

		waitForElement(driver, HC_Drop_Location_Search_Button);
		click(driver, HC_Drop_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Drop_Location_Code);
		Step_End(4, " Click the Pickup Loc search field and select the Pick up location", test, test1);



		Step_Start(5, " Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);
		waitForElement(driver, HC_Pickup_Type_Dropdown);
		click(driver, HC_Pickup_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Pickup_Type_Value);

		waitForElement(driver, HC_drop_Type_Dropdown);
		click(driver, HC_drop_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Drop_Type_Value);

		waitForElement(driver, HC_Pickup_Term_List);
		click(driver, HC_Pickup_Term_List);

		formatLocatorClick(driver, DropDown_Select, Pickup_Term_Value);


		if(isElementAccessible(driver, HC_Pickup_Terminal)) {

			waitForElement(driver, HC_Pickup_Terminal);
			click(driver, HC_Pickup_Terminal);

			twoColumnMultipleSearchWindow(driver, Pickup_Terminal_Header, condition, Pickup_Terminal_Value);


		}
		Step_End(5, " Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);



		Step_Start(6, " Click the Drop Loc search field and select the Drop location", test, test1);

		waitForElement(driver, HC_Drop_Term_List);
		click(driver, HC_Drop_Term_List);

		formatLocatorClick(driver, DropDown_Select, Drop_Term_Value);
		Step_End(6, " Click the Drop Loc search field and select the Drop location", test, test1);


		Step_Start(7, " Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal ", test, test1);

		if(isElementAccessible(driver, HC_drop_Terminal_search_Button)) {

			waitForElement(driver, HC_drop_Terminal_search_Button);
			click(driver, HC_drop_Terminal_search_Button);

			twoColumnMultipleSearchWindow(driver, Drop_Terminal_Header, condition,Drop_Terminal_Value);
		}
		Step_End(7, " Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal ", test, test1);





		Step_Start(8, "Click on the Equipment drop down and select the Equipment type", test, test1);

		waitForElement(driver, HC_Equipment_select);
		click(driver, HC_Equipment_select);

		formatLocatorClick(driver, DropDown_Select, Equipment_Type);
		Step_End(8, "Click on the Equipment drop down and select the Equipment type", test, test1);

		Step_Start(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);

		waitForElement(driver, HC_LDN_MTY_Select);
		click(driver, HC_LDN_MTY_Select);
		Step_End(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);
		Step_Start(10, "Click on the No of eqp units and select the Unit", test, test1);
		formatLocatorClick(driver, DropDown_Select, HC_LDN_MTY_Value);


		Step_End(10, "Click on the No of eqp units and select the Unit", test, test1);
		Step_Start(11, ".Click on the Hmode and Trip type drop down and select the value ", test, test1);

		waitForElement(driver, HC_H_Mode);
		click(driver, HC_H_Mode);
		formatLocatorClick(driver, DropDown_Select, Haulage_mode_Value);
		Step_End(11, ".Click on the Hmode and Trip type drop down and select the value ", test, test1);



		Step_Start(13, ".Select the valid from and valid to date ", test, test1);

		waitForElement(driver, HC_From_Date);
		selectDatePicker(driver, HC_From_Date, From_Date_Input);
		waitForElement(driver, HC_To_Date);
		selectDatePicker(driver, HC_To_Date, To_Date_Input);
		Step_End(13, ".Select the valid from and valid to date ", test, test1);



		waitForElement(driver, HC_Trip_Types);
		click(driver, HC_Trip_Types);
		formatLocatorClick(driver, DropDown_Select, Trip_Type_Value);	           



		Step_Start(14, "Click on the Neg by and select the value  ", test, test1);


		waitForElement(driver, HC_Neg_on_date);
		selectDatePicker(driver, HC_Neg_on_date, Neg_On_Date);



		waitForElement(driver, HC_Neg_by_Input);
		click(driver, HC_Neg_by_Input);

		twoColumnMultipleSearchWindow(driver, User_Name_Header, condition, User_Name_Input);

		Step_End(14, "Click on the Neg by and select the value  ", test, test1);
		Step_Start(15, "Click the currency and select the currency code  ", test, test1);
		waitForElement(driver, HC_Currency_Search);
		click(driver, HC_Currency_Search);

		twoColumnMultipleSearchWindow(driver, Currency_Header, condition, Currency_Select_Input);
		Step_End(15, "Click the currency and select the currency code  ", test, test1);



		Step_Start(16, "Select the amt type  drop dowm and select the type ", test, test1);
		waitForElement(driver, HC_Amount_Select);
		click(driver, HC_Amount_Select);
		formatLocatorClick(driver, DropDown_Select, Amount_Type);	           
		Step_End(16, "Select the amt type  drop dowm and select the type ", test, test1);
		Step_Start(17, "Select the amount field  and enter the amount on that field. ", test, test1);
		waitForElement(driver, HC_Amount_Input);
		click(driver, HC_Amount_Input);
		clearAndType(driver, HC_Amount_Input, Amount_Input);


		Step_End(17, "Select the amount field  and enter the amount on that field. ", test, test1);





		waitForElement(driver, HC_Pickup_Location_Field);

		click(driver, HC_Pickup_Location_Field);
		String Pickup_Location_Value_Act = getAttribute(driver, HC_Pickup_Location_Field, "value");	
		String pickup_Loc_Act = getAttribute(driver, HC_Drop_Location_Field, "value");
		String Equipment_Act = getText(driver, HC_Equipment_select);
		String HC_LDN_MTY_Select_Act = getText(driver, HC_LDN_MTY_Select);
		String HC_From_Date_Act = getAttribute(driver, HC_From_Date,"value");	
		String HC_To_Date_Act = getAttribute(driver, HC_To_Date,"value");
		String HC_Pickup_Type_dropdown_Act = getText(driver, HC_Pickup_Type_Dropdown);
		String HC_drop_Type_dropdown_Act = getText(driver, HC_drop_Type_Dropdown);
		String HC_drop_Term_List_Act = getText(driver, HC_Drop_Term_List);
		String HC_Pickup_Term_List_Act = getText(driver, HC_Pickup_Term_List);
		String HC_Trip_Types_Act = getText(driver, HC_Trip_Types);
		String HC_H_Mode_Act = getText(driver, HC_H_Mode);
		String HC_Neg_by_Input_Act = getAttribute(driver, HC_Neg_by_Input_Value,"value");
		String HC_Neg_on_date_Act = getAttribute(driver, HC_Neg_on_date,"value");
		String HC_Amount_Input_Act = getAttribute(driver, HC_Amount_Input,"value");
		String HC_Currency_Text_Act = getAttribute(driver, HC_Currency_Text,"value");


		if(Pickup_Location_Code.equals(Pickup_Location_Value_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Pickup_Location_Code + " || Actual Result is Taken from Application: "+Pickup_Location_Value_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Pickup_Location_Code + " || Actual Result is Taken from Application : "+Pickup_Location_Value_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Pickup_Location_Code + " || Actual Result is Taken from Application: "+Pickup_Location_Value_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Pickup_Location_Code + " || Actual Result is Taken from Application: "+Pickup_Location_Value_Act, test, test1);
		}

		if(Drop_Location_Code.equals(pickup_Loc_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Drop_Location_Code + " || Actual Result is Taken from Application: "+pickup_Loc_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Drop_Location_Code + " || Actual Result is Taken from Application : "+pickup_Loc_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Drop_Location_Code + " || Actual Result is Taken from Application: "+pickup_Loc_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Drop_Location_Code + " || Actual Result is Taken from Application: "+pickup_Loc_Act, test, test1);
		}

		if(Equipment_Type.equals(Equipment_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Equipment_Type + " || Actual Result is Taken from Application: "+Equipment_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Equipment_Type + " || Actual Result is Taken from Application : "+Equipment_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Equipment_Type + " || Actual Result is Taken from Application: "+Equipment_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Equipment_Type + " || Actual Result is Taken from Application: "+Equipment_Act, test, test1);
		}

		if(HC_LDN_MTY_Value.equals(HC_LDN_MTY_Select_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+HC_LDN_MTY_Value + " || Actual Result is Taken from Application: "+HC_LDN_MTY_Select_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+HC_LDN_MTY_Value + " || Actual Result is Taken from Application : "+HC_LDN_MTY_Select_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+HC_LDN_MTY_Value + " || Actual Result is Taken from Application: "+HC_LDN_MTY_Select_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+HC_LDN_MTY_Value + " || Actual Result is Taken from Application: "+HC_LDN_MTY_Select_Act, test, test1);
		}

		if(From_Date_Input.equals(HC_From_Date_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+From_Date_Input + " || Actual Result is Taken from Application: "+HC_From_Date_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+From_Date_Input + " || Actual Result is Taken from Application : "+HC_From_Date_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+From_Date_Input + " || Actual Result is Taken from Application: "+HC_From_Date_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+From_Date_Input + " || Actual Result is Taken from Application: "+HC_From_Date_Act, test, test1);
		}	
		if(To_Date_Input.equals(HC_To_Date_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application : "+HC_To_Date_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act, test, test1);
		}	
		if(To_Date_Input.equals(HC_To_Date_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application : "+HC_To_Date_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+To_Date_Input + " || Actual Result is Taken from Application: "+HC_To_Date_Act, test, test1);
		}	
		if(Pickup_Type_Value.equals(HC_Pickup_Type_dropdown_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Pickup_Type_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Type_dropdown_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Pickup_Type_Value + " || Actual Result is Taken from Application : "+HC_Pickup_Type_dropdown_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Pickup_Type_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Type_dropdown_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Pickup_Type_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Type_dropdown_Act, test, test1);
		}	
		if(Drop_Type_Value.equals(HC_drop_Type_dropdown_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Drop_Type_Value + " || Actual Result is Taken from Application: "+HC_drop_Type_dropdown_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Drop_Type_Value + " || Actual Result is Taken from Application : "+HC_drop_Type_dropdown_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Drop_Type_Value + " || Actual Result is Taken from Application: "+HC_drop_Type_dropdown_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Drop_Type_Value + " || Actual Result is Taken from Application: "+HC_drop_Type_dropdown_Act, test, test1);
		}	
		if(Drop_Term_Value.equals(HC_drop_Term_List_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Drop_Term_Value + " || Actual Result is Taken from Application: "+HC_drop_Term_List_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Drop_Term_Value + " || Actual Result is Taken from Application : "+HC_drop_Term_List_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Drop_Term_Value + " || Actual Result is Taken from Application: "+HC_drop_Term_List_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Drop_Term_Value + " || Actual Result is Taken from Application: "+HC_drop_Term_List_Act, test, test1);
		}	
		if(Pickup_Term_Value.equals(HC_Pickup_Term_List_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Pickup_Term_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Term_List_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Pickup_Term_Value + " || Actual Result is Taken from Application : "+HC_Pickup_Term_List_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Pickup_Term_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Term_List_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Pickup_Term_Value + " || Actual Result is Taken from Application: "+HC_Pickup_Term_List_Act, test, test1);
		}
		if(Trip_Type_Value.equals(HC_Trip_Types_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Trip_Type_Value + " || Actual Result is Taken from Application: "+HC_Trip_Types_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Trip_Type_Value + " || Actual Result is Taken from Application : "+HC_Trip_Types_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Trip_Type_Value + " || Actual Result is Taken from Application: "+HC_Trip_Types_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Trip_Type_Value + " || Actual Result is Taken from Application: "+HC_Trip_Types_Act, test, test1);
		}
		if(Haulage_mode_Value.equals(HC_H_Mode_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Haulage_mode_Value + " || Actual Result is Taken from Application: "+HC_H_Mode_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Haulage_mode_Value + " || Actual Result is Taken from Application : "+HC_H_Mode_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Haulage_mode_Value + " || Actual Result is Taken from Application: "+HC_H_Mode_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Haulage_mode_Value + " || Actual Result is Taken from Application: "+HC_H_Mode_Act, test, test1);
		}
		if(User_Name_Input.equals(HC_Neg_by_Input_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+User_Name_Input + " || Actual Result is Taken from Application: "+HC_Neg_by_Input_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+User_Name_Input + " || Actual Result is Taken from Application : "+HC_Neg_by_Input_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+User_Name_Input + " || Actual Result is Taken from Application: "+HC_Neg_by_Input_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+User_Name_Input + " || Actual Result is Taken from Application: "+HC_Neg_by_Input_Act, test, test1);
		}
		if(Neg_On_Date.equals(HC_Neg_on_date_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Neg_On_Date + " || Actual Result is Taken from Application: "+HC_Neg_on_date_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Neg_On_Date + " || Actual Result is Taken from Application : "+HC_Neg_on_date_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Neg_On_Date + " || Actual Result is Taken from Application: "+HC_Neg_on_date_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Neg_On_Date + " || Actual Result is Taken from Application: "+HC_Neg_on_date_Act, test, test1);
		}
		if(HC_Amount_Input_Act.contains(Amount_Input)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Amount_Input + " || Actual Result is Taken from Application: "+HC_Amount_Input_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Amount_Input + " || Actual Result is Taken from Application : "+HC_Amount_Input_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Amount_Input + " || Actual Result is Taken from Application: "+HC_Amount_Input_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Amount_Input + " || Actual Result is Taken from Application: "+HC_Amount_Input_Act, test, test1);
		}
		if(Currency_Select_Input.equals(HC_Currency_Text_Act)) {
			System.out.println("Matched||Expected Result is taken from Test Data:"+Currency_Select_Input + " || Actual Result is Taken from Application: "+HC_Currency_Text_Act);
			Extent_pass_New(driver, "Matched||Expected Result is taken from Test Data :"+Currency_Select_Input + " || Actual Result is Taken from Application : "+HC_Currency_Text_Act, test, test1);
		}else {
			System.out.println("NotMatched||Expected Result is taken from Test Data :"+Currency_Select_Input + " || Actual Result is Taken from Application: "+HC_Currency_Text_Act);
			Extent_fail(driver, "NotMatched||Expected Result is taken from Test Data :"+Currency_Select_Input + " || Actual Result is Taken from Application: "+HC_Currency_Text_Act, test, test1);
		}
		waitForElement(driver, HC_Tab_Ok_Button);
		click(driver, HC_Tab_Ok_Button);

		waitForDisplay(driver, HC_Add_Gird_Table);
		if (isdisplayed(driver, HC_Add_Gird_Table)) {
			System.out.println("Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and added in the gird");
			Extent_pass_New(driver, "Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and added in the gird", test, test1);
		} else {
			System.out.println("Not Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and not added in the gird");
			Extent_fail(driver, "Not Matched || Expected : All mandatory fields should be filled and added in the gird || Actual : All mandatory fields are filled and not added in the gird", test, test1);
 
		}
		Step_End(18, "Fill the all mandadory details ", test, test1);




		Extent_completed(testcase_Name, test, test1);
	}

}
