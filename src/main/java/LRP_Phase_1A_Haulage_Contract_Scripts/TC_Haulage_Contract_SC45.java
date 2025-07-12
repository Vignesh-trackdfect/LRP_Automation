package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC45 extends Keywords{
	public void Haulage_Contract_SC45(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC45";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
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
		String Column_condition = Excel_data.get("Column_condition");
		String DG_Class_Header = Excel_data.get("DG_Class_Header");
		String DG_Class = Excel_data.get("DG_Class");
		String DG_Charge_Type = Excel_data.get("DG_Charge_Type");
		String DG_Currrency = Excel_data.get("DG_Currrency");
		String DG_Amount = Excel_data.get("DG_Amount");
		String DG_Removed_Popup = Excel_data.get("DG_Removed_Popup");

		
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


		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, Column_condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		Step_Start(3, "Click on the \"+\" Button to add the all details ", test, test1);
		waitForElement(driver, HC_Plus_Button);
		click(driver, HC_Plus_Button);

		Step_End(3, "Click on the \"+\" Button to add the all details ", test, test1);
		Step_Start(4, "Click the Pickup Loc search field and select the Pick up location", test, test1);

		waitForElement(driver, HC_Pickup_Location_Search_Button);
		click(driver, HC_Pickup_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, Column_condition, Pickup_Location_Code);

		Step_End(4, "Click the Pickup Loc search field and select the Pick up location", test, test1);
		Step_Start(5, "Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);

		waitForElement(driver, HC_Pickup_Type_Dropdown);
		click(driver, HC_Pickup_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Pickup_Type_Value);

		
		Step_End(5, "Click on the Pick up type drop down and Select the Pick up type based on that we can able to select the select the Pickup terminal.", test, test1);
		Step_Start(6, "Click the Drop Loc search field and select the Drop location", test, test1);

		waitForElement(driver, Hc_Drop_Loc_Search_Button);
		click(driver, Hc_Drop_Loc_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, Column_condition, Drop_Location_Code);

		Step_End(6, "Click the Drop Loc search field and select the Drop location", test, test1);
		Step_Start(7, "Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal", test, test1);

		waitForElement(driver, HC_drop_Type_Dropdown);
		click(driver, HC_drop_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Drop_Type_Value);
		
		Step_End(7, "Click on the Drop type Drop down and Select the Drop type based on that we can able to select the Drop terminal", test, test1);
		Step_Start(8, "Click on the Equipment drop down and select the Equipment type ", test, test1);

		waitForElement(driver, HC_Equipment_select);
		click(driver, HC_Equipment_select);

		formatLocatorClick(driver, DropDown_Select, Equipment_Type);

		Step_End(8, "Click on the Equipment drop down and select the Equipment type ", test, test1);
		Step_Start(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);

		waitForElement(driver, HC_LDN_MTY_Select);
		click(driver, HC_LDN_MTY_Select);

		formatLocatorClick(driver, DropDown_Select, HC_LDN_MTY_Value);

		Step_End(9, "Click on the LDN/MTY drop down and select the Larden or empty", test, test1);
		Step_Start(10, "Click on the No of eqp units and select the Unit", test, test1);
		Step_Start(11, "Click on the Hmode and Trip type drop down and select the value ", test, test1);

		waitForElement(driver, HC_H_Mode);
		click(driver, HC_H_Mode);
		formatLocatorClick(driver, DropDown_Select, Haulage_mode_Value);

		waitForElement(driver, HC_Trip_Types);
		click(driver, HC_Trip_Types);
		formatLocatorClick(driver, DropDown_Select, Trip_Type_Value);	           

		Step_End(11, "Click on the Hmode and Trip type drop down and select the value ", test, test1);
		Step_Start(12, "Click on the PIck up term drop down and select the value and also click on Drop term Drop down and select the Value ", test, test1);

		waitForElement(driver, HC_Pickup_Term_List);
		click(driver, HC_Pickup_Term_List);

		formatLocatorClick(driver, DropDown_Select, Pickup_Term_Value);


		if(isElementAccessible(driver, HC_Pickup_Terminal_Search_Button)) {

			waitForElement(driver, HC_Pickup_Terminal_Search_Button);
			click(driver, HC_Pickup_Terminal_Search_Button);

			twoColumnMultipleSearchWindow(driver, Pickup_Terminal_Header, Column_condition, Pickup_Terminal_Value);


		}
		if(isElementAccessible(driver, HC_drop_Terminal_search_Button)) {

			waitForElement(driver, HC_drop_Terminal_search_Button);
			click(driver, HC_drop_Terminal_search_Button);

			twoColumnMultipleSearchWindow(driver, Drop_Terminal_Header, Column_condition,Drop_Terminal_Value);


		}

		waitForElement(driver, HC_Drop_Term);
		click(driver, HC_Drop_Term);

		formatLocatorClick(driver, DropDown_Select, Drop_Term_Value);

		Step_End(12, "Click on the PIck up term drop down and select the value and also click on Drop term Drop down and select the Value ", test, test1);
		Step_Start(13, "Select the valid from and valid to date ", test, test1);

		waitForElement(driver, HC_From_Date);
		selectDatePicker(driver, HC_From_Date, From_Date_Input);
		waitForElement(driver, HC_To_Date);
		selectDatePicker(driver, HC_To_Date, To_Date_Input);

		Step_End(13, "Select the valid from and valid to date ", test, test1);
		Step_Start(14, "Click on the Neg by and select the value", test, test1);

		waitForElement(driver, HC_Neg_on_date);
		selectDatePicker(driver, HC_Neg_on_date, Neg_On_Date);



		waitForElement(driver, HC_Neg_by_Input);
		click(driver, HC_Neg_by_Input);

		twoColumnMultipleSearchWindow(driver, User_Name_Header, Column_condition, User_Name_Input);

		Step_End(14, "Click on the Neg by and select the value", test, test1);
		Step_Start(15, "Click the currency and select the currency code", test, test1);

		waitForElement(driver, HC_Currency_Search);
		click(driver, HC_Currency_Search);

		twoColumnMultipleSearchWindow(driver, Currency_Header, Column_condition, Currency_Select_Input);

		Step_End(15, "Click the currency and select the currency code", test, test1);
		Step_Start(16, "Select the amt type  drop dowm and select the type .", test, test1);

		waitForElement(driver, HC_Amount_Select);
		click(driver, HC_Amount_Select);
		formatLocatorClick(driver, DropDown_Select, Amount_Type);	           

		Step_End(16, "Select the amt type  drop dowm and select the type .", test, test1);
		Step_Start(17, "Select the amount field  and enter the amount on that field.", test, test1);

		waitForElement(driver, HC_Amount_Input);
		click(driver, HC_Amount_Input);
		clearAndType(driver, HC_Amount_Input, Amount_Input);

		Step_End(17, "Select the amount field  and enter the amount on that field.", test, test1);
		Step_Start(18, "Fill the all mandadory details", test, test1);
		Step_Start(19, "Click \"OK\" to save the details in haulage contract.", test, test1);

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
		
		waitForElement(driver, HC_Add_Gird_Table);
		click(driver, HC_Add_Gird_Table);
		
		Step_End(19, "Click \"OK\" to save the details in haulage contract.", test, test1);
		Step_Start(20, "Click the \"+\" in DG and select the Dg code .", test, test1);

		waitForElement(driver, HC_DG_Plus_Button);
		click(driver, HC_DG_Plus_Button);
		
		Step_End(20, "Click the \"+\" in DG and select the Dg code .", test, test1);
		Step_Start(21, "Double click the charge and edit the amount.", test, test1);

		twoColumnSearchWindow(driver, DG_Class_Header, Column_condition, DG_Class);
		
		waitForElement(driver, HC_DG_ChargeType_Gridcell);
		click(driver, HC_DG_ChargeType_Gridcell);
		
		waitForElement(driver, HC_DG_ChargeType_Gridcell_Dropdown);
		click(driver, HC_DG_ChargeType_Gridcell_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, DG_Charge_Type);
		
		if(DG_Charge_Type.equals("LumpSum")) {
		waitForElement(driver, HC_DG_Currency_Gridcell);
		click(driver, HC_DG_Currency_Gridcell);
		
		waitForElement(driver, HC_DG_Currency_Gridcell_Dropdown);
		click(driver, HC_DG_Currency_Gridcell_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, DG_Currrency);
		}

		waitForElement(driver, HC_DG_Amount_Gridcell);
		doubleClick(driver, HC_DG_Amount_Gridcell);
		
		clearAndType(driver, HC_DG_Amount_Gridcell_Textfield, DG_Amount);
		enter(driver);
		
		Step_End(21, "Double click the charge and edit the amount.", test, test1);
		Step_Start(22, "Select the row and Click remove \"-\".", test, test1);

		waitForElement(driver, HC_DG_Row_Class_Gridcell);
		click(driver, HC_DG_Row_Class_Gridcell);
		
		waitForElement(driver, HC_DG_Minus_Button);
		click(driver, HC_DG_Minus_Button);
		
		waitForPopup(driver, popup_Message,DG_Removed_Popup);
		String removed_Popup = getText(driver, popup_Message);
		if(removed_Popup.equals(DG_Removed_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + DG_Removed_Popup + " || Actual Popup is : " + removed_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + DG_Removed_Popup + " || Actual Popup is : " + removed_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + DG_Removed_Popup + " || Actual Popup is : " + removed_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + DG_Removed_Popup + " || Actual Popup is : " + removed_Popup, test,test1); 
		}
		
		waitForDisplay(driver, HC_DG_Empty_Row);
		if(isdisplayed(driver, HC_DG_Empty_Row)) {                                                                                                                  
			System.out.println("Matched || " + " Expected : DG details row should be removed || Actual : DG details row is removed");            
			Extent_pass_New(driver, "Matched || " + " Expected : DG details row should be removed || Actual : DG details row is removed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected : DG details row should be removed || Actual : DG details row is not removed");        
			Extent_fail(driver, "Not Matched || " + " Expected : DG details row should be removed || Actual : DG details row is not removed", test,test1); 
		}
		Step_End(22, "Select the row and Click remove \"-\".", test, test1);

		
		Extent_completed(testcase_Name, test, test1);
		
	}

}
