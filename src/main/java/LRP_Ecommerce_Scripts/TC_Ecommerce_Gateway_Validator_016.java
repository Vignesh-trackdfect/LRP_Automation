package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ecommerce_Gateway_Validator_016 extends Keywords{
	public void Ecommerce_Gateway_Validator_016(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_016";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		Step_Start(1, "select the agency ", test, test1);
		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}
		Step_End(1, "select the agency ", test, test1);
		moduleNavigate(driver, Module_Name);

		Step_Start(2, "Click the refresh button on the e-commerce gateway.", test, test1);

		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		Step_End(2, "Click the refresh button on the e-commerce gateway.", test, test1);
		Step_Start(3, "Booking and SI records show a grid.", test, test1);

		Step_Start(4, "Select booking row and double-click the e-commerce validator", test, test1);

		waitForElement(driver, First_Row_Grid_Ecomm_Gate_Way);
		doubleClick(driver, First_Row_Grid_Ecomm_Gate_Way);
		Step_End(3, "Booking and SI records show a grid.", test, test1);
		Step_End(4, "Select booking row and double-click the e-commerce validator", test, test1);
		Step_Start(5, "origin agency and booking agency should be same ", test, test1);

		waitForElement(driver, Book_Agency_Input_Ecomm_Validator);
		String Booking_Agency_Name = getAttribute(driver, Book_Agency_Input_Ecomm_Validator, "value");
		
		
		
		System.out.println(Booking_Agency_Name);
		waitForElement(driver, Orgin_Agency_Name);
		String Orgin_Agency_Names = getText(driver, Orgin_Agency_Name);
		
		String[] Actual_Orgin_Agency_Names = Orgin_Agency_Names.split("]");
		String Actual_Orgin_Agency_Name = Actual_Orgin_Agency_Names[1].trim();
		System.out.println(Actual_Orgin_Agency_Name);
		
		if (Actual_Orgin_Agency_Name.equals(Booking_Agency_Name)) {
			System.out.println(" Matched || The Excepted : The Agency Name from The Booking is : "+ Booking_Agency_Name +"||The Actual : The Agency From The Orgin Agency is :"+Actual_Orgin_Agency_Name);
			Extent_pass_New(driver, " Matched || The Excepted : The Agency Name from The Booking is : "+ Booking_Agency_Name +"||The Actual : The Agency From The Orgin Agency is :"+Actual_Orgin_Agency_Name, test, test1);
		} else {
			System.out.println("Not Matched || The Excepted : The Agency Name from The Booking is : "+ Booking_Agency_Name +"||The Actual : The Agency From The Orgin Agency is :"+Actual_Orgin_Agency_Name);
			Extent_fail(driver, "Not Matched || The Excepted : The Agency Name from The Booking is : "+ Booking_Agency_Name +"||The Actual : The Agency From The Orgin Agency is :"+Actual_Orgin_Agency_Name, test, test1);
	
		}
		Step_End(5, "origin agency and booking agency should be same ", test, test1);

		Extent_completed(testcase_Name, test, test1);
		
		
	}
}
