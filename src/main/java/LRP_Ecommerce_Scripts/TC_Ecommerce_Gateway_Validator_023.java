package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_023 extends Keywords {

	public void Ecommerce_Gateway_Validator_023(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_023";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String service_Code = Excel_data.get("service_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		
		Extent_Start(testcase_Name, test, test1);

		Step_Start(1, "Login to  the url", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_End(1, "Login to  the url", test, test1);

		Step_Start(2, "Switch  to corresponding agency", test, test1);

		if (!AgencyName.equals("")) {

			SwitchProfile(driver, AgencyName);
		}

		Step_End(2, "Switch  to corresponding agency", test, test1);

		Step_Start(3, "Navigate to Ecommerce Module", test, test1);

		moduleNavigate(driver, Module_Name);

		Step_End(3, "Navigate to Ecommerce Module", test, test1);

		Step_Start(4, "Click on the corresponding Reference number", test, test1);

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

		waitForDownload(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		Step_End(4, "Click on the corresponding Reference number", test, test1);

		Step_Start(5, "Click on Edit Button once user got redirect to Ecommerce Validator/Collector page", test, test1);

		waitForElement(driver, Ed);

		click(driver, Ed);

		waitForElement(driver, Edit1);

		click(driver, Edit1);

		Step_End(5, "Click on Edit Button once user got redirect to Ecommerce Validator/Collector page", test, test1);

		Step_Start(6, "Click on the corresponding Routing", test, test1);

		String select_Routing = String.format(Routing_Select_ECom_Validator, Terminal_Code, service_Code);

		waitForElement(driver, select_Routing);

		scrollUsingElement(driver, select_Routing);

		if (isClickable(driver, select_Routing)) {
			click(driver, select_Routing);
			System.out.println(
					"Matched || Expected:  Routing Selection should be enabled : || Actual Report Activity is : Routing Selection is enabled ");
			Extent_pass_New(driver,
					"Matched || Expected:  Routing Selection should be enabled : || Actual Report Activity is : Routing Selection is enabled ",
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected:  Routing Selection should be enabled :  || Actual Report Activity is :Routing Selection is disabled  ");
			Extent_fail(driver,
					"Not Matched ||  Expected:  Routing Selection should be enabled : || Actual Report Activity is :Routing Selection is disabled  ",
					test, test1);
		}

		System.out.println("clicked in the popup");

		Step_End(6, "Click on the corresponding Routing", test, test1);

		Step_Start(7, "Click on ok button", test, test1);

		waitForElement(driver, ok);

		click(driver, ok);

		Step_End(7, "Click on ok button", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
