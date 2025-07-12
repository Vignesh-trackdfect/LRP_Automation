package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC04 extends Keywords{
	public void Haulage_Contract_SC04(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC04";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String ServiceCode_Value = Excel_data.get("ServiceCode_Value");
		String ServiceCode_Spl_Value = Excel_data.get("ServiceCode_Spl_Value");
		String ServiceCode_char_Value = Excel_data.get("ServiceCode_char_Value");

	

	



		
		
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
		
		Step_Start(4, "It show the Haulage Contract input details page.", test, test1);
		waitForDisplay(driver, HC_Haulage_Contract_Input_Page);
		if(isdisplayed(driver, HC_Haulage_Contract_Input_Page)) {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ");
			Extent_pass_New(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is opened ", test, test1);
		}else {
			System.out.println("Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ");
		    Extent_fail(driver, "Expected Result is : Haulage Contract-Input Details Page should be opened || Actual Result is : Haulage Contract-Input Details page is not opened ", test, test1);
		}
		Step_End(4, "It show the Haulage Contract input details page.", test, test1);
		
		Step_Start(5, "Enter the value in the Pickup loc with 5 characters.", test, test1);
		waitForElement(driver, HC_Pickup_Location_Field);
		sendKeys(driver, HC_Pickup_Location_Field, ServiceCode_Spl_Value);
		tab(driver);
		
		
		waitForElement(driver, HC_Pickup_Location_Field);
		String pickup_Loc = getAttribute(driver, HC_Pickup_Location_Field, "value");
		
		if (isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			System.out.println(
					"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters");

			Extent_pass_New(driver,
					"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters",
					test, test1);

			
			
		} else {

			if (checkspecial(driver, pickup_Loc) == false) {
			
				System.out.println(
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters");

				Extent_pass_New(driver,
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point field not allows special charaters",
						test, test1);
				
				
				
			} else {
				System.out.println(
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point allows special charaters");

				Extent_fail(driver,
						"Expected result : The Pickup point field should not allow special charaters || Actual result : The Pickup point allows special charaters",
						test, test1);

			}
		}
		
		waitForElement(driver, HC_Pickup_Location_Field);
		Newclear(driver, HC_Pickup_Location_Field);
		sendKeys(driver, HC_Pickup_Location_Field, ServiceCode_char_Value);
		
		tab(driver);

		waitForElement(driver, HC_Pickup_Location_Field);
		String morecharacters = getAttribute(driver, HC_Pickup_Location_Field, "value");
		
		if (isdisplayed(driver, popup_Message)) {

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			System.out.println(
					"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows upto 5 characters");
			Extent_pass_New(driver,
					"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows upto 5 characters",
					test, test1);
			
		} else {

			if (morecharacters.length() <= 5) {

				System.out.println(
						"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows upto 5 characters");
				Extent_pass_New(driver,
						"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows upto 5 characters",
						test, test1);
			} else {

				System.out.println(
						"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows more than 5 characters");
				Extent_fail(driver,
						"Expected result || The Pickup point field only should allows upto 5 characters || Actual result : The Pickup point field only allows more than 5 characters",
						test, test1);

			}

		}


		waitForElement(driver, HC_Pickup_Location_Field);
		Newclear(driver, HC_Pickup_Location_Field);
		sendKeys(driver, HC_Pickup_Location_Field, ServiceCode_Value);

		tab(driver);
		
		waitForElement(driver, HC_Pickup_Location_Field);
		String actual_ServiceCode = getAttribute(driver, HC_Pickup_Location_Field, "value");

		if (ServiceCode_Value.equals(actual_ServiceCode)) {

			System.out.println(
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User can able to select the Drop terminal value using entering the value");
			Extent_pass_New(driver,
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User can able to select the Drop terminal value using entering the value",
					test, test1);
		} else {

			System.out.println(
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User cannot able to select the Drop terminal value using entering the value");
			Extent_fail(driver,
					"Expected result : User should be able to select the Drop terminal value using entering the value || Actual result : User cannot able to select the Drop terminal value using entering the value",
					test, test1);

		}
		
		Step_End(5, "Enter the value in the Pickup loc with 5 characters.", test, test1);
	
		Extent_completed(testcase_Name, test, test1);
	}

}
