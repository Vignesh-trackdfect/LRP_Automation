package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC24 extends Keywords{
	public void Haulage_Contract_SC24(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC24";

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
		String Payable_At_Grid_Header = Excel_data.get("Payable_At_Grid_Header");









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

		Step_Start(4, "It show the Haulage Contract input details page", test, test1);
		waitForDisplay(driver, HC_Haulage_Contract_Input_Page);
		if(isdisplayed(driver, HC_Haulage_Contract_Input_Page)) {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
		    Extent_fail(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		
		

		waitForElement(driver, HC_Pickup_Location_Search_Button);
		click(driver, HC_Pickup_Location_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Pickup_Location_Code);

		waitForElement(driver, Hc_Drop_Loc_Search_Button);
		click(driver, Hc_Drop_Loc_Search_Button);
		twoColumnMultipleSearchWindow(driver, Pickup_Location_Header, condition, Drop_Location_Code);



		waitForElement(driver, HC_Equipment_select);
		click(driver, HC_Equipment_select);

		formatLocatorClick(driver, DropDown_Select, Equipment_Type);

		waitForElement(driver, HC_LDN_MTY_Select);
		click(driver, HC_LDN_MTY_Select);

		formatLocatorClick(driver, DropDown_Select, HC_LDN_MTY_Value);


		waitForElement(driver, HC_From_Date);
		selectDatePicker(driver, HC_From_Date, From_Date_Input);
		waitForElement(driver, HC_To_Date);
		selectDatePicker(driver, HC_To_Date, To_Date_Input);


		waitForElement(driver, HC_Pickup_Type_Dropdown);
		click(driver, HC_Pickup_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Pickup_Type_Value);

		waitForElement(driver, HC_drop_Type_Dropdown);
		click(driver, HC_drop_Type_Dropdown);

		formatLocatorClick(driver, DropDown_Select, Drop_Type_Value);

		waitForElement(driver, HC_Pickup_Term_List);
		click(driver, HC_Pickup_Term_List);

		formatLocatorClick(driver, DropDown_Select, Pickup_Term_Value);


		if(isElementAccessible(driver, HC_Pickup_Terminal_Search_Button)) {

			waitForElement(driver, HC_Pickup_Terminal_Search_Button);
			click(driver, HC_Pickup_Terminal_Search_Button);

			twoColumnMultipleSearchWindow(driver, Pickup_Terminal_Header, condition, Pickup_Terminal_Value);


		}
		if(isElementAccessible(driver, HC_drop_Terminal_search_Button)) {

			waitForElement(driver, HC_drop_Terminal_search_Button);
			click(driver, HC_drop_Terminal_search_Button);

			twoColumnMultipleSearchWindow(driver, Drop_Terminal_Header, condition,Drop_Terminal_Value);


		}




		waitForElement(driver, HC_Drop_Term);
		click(driver, HC_Drop_Term);

		formatLocatorClick(driver, DropDown_Select, Drop_Term_Value);



		waitForElement(driver, HC_H_Mode);
		click(driver, HC_H_Mode);
		formatLocatorClick(driver, DropDown_Select, Haulage_mode_Value);



		waitForElement(driver, HC_Trip_Types);
		click(driver, HC_Trip_Types);
		formatLocatorClick(driver, DropDown_Select, Trip_Type_Value);	           





		waitForElement(driver, HC_Neg_on_date);
		selectDatePicker(driver, HC_Neg_on_date, Neg_On_Date);



		waitForElement(driver, HC_Neg_by_Input);
		click(driver, HC_Neg_by_Input);

		twoColumnMultipleSearchWindow(driver, User_Name_Header, condition, User_Name_Input);

		waitForElement(driver, HC_Amount_Select);
		click(driver, HC_Amount_Select);
		formatLocatorClick(driver, DropDown_Select, Amount_Type);	           


		waitForElement(driver, HC_Amount_Input);
		click(driver, HC_Amount_Input);
		clearAndType(driver, HC_Amount_Input, Amount_Input);



		waitForElement(driver, HC_Currency_Search);
		click(driver, HC_Currency_Search);

		twoColumnMultipleSearchWindow(driver, Currency_Header, condition, Currency_Select_Input);
		
		Step_Start(5, "Click the POL in the Payat details.", test, test1);
		waitForElement(driver, Payable_At_Pol);
		click(driver, Payable_At_Pol);
		click(driver, Payable_At_Pol);

		
		waitForElement(driver, HC_Tab_Ok_Button);
		click(driver, HC_Tab_Ok_Button);
		
		waitForElement(driver, HC_Table_Grid);
		List<Map<String, String>> tabledata = extractTableDataByColumn(driver, HC_Table_Grid);
		String Act_Pickup_Location = getFirstRowValueByHeaderFromTableData(tabledata, Payable_At_Grid_Header);
		
		System.out.println(Act_Pickup_Location);
		if(Pickup_Location_Code.equals(Act_Pickup_Location)) {
			System.out.println("Matched || Expected Result is : "+Pickup_Location_Code + " || Actual Result is : "+Act_Pickup_Location  );
			Extent_pass_New(driver, "Matched || Expected Result is : "+Pickup_Location_Code + " || Actual Result is : "+Act_Pickup_Location  , test, test1);
		}else {
			System.out.println("Not Matched|| Expected Result is : "+Pickup_Location_Code + " || Actual Result is : "+Act_Pickup_Location  );
			Extent_fail(driver, "Expected Result is : "+Pickup_Location_Code + " || Actual Result is : "+Act_Pickup_Location  , test, test1);
		}
		
		Step_End(5, "Click the POL in the Payat details.", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
