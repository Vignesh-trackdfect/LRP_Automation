package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_008 extends Keywords {

	public void Ecommerce_Gateway_Validator_008(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_008";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Reference_Number = Excel_data.get("Reference_Number");
		String Booking_Number = Excel_data.get("Booking_Number");
		String BL_Number = Excel_data.get("BL_Number");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Validator_Module_Name = Excel_data.get("Validator_Module_Name");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "Click the refresh button on the e-commerce gateway", test, test1);

		waitForElement(driver, EG_BLNo_input);
		sendKeys(driver, EG_BLNo_input, BL_Number);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			waitForElement(driver, EG_FromDate_Input);
			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		if (!Reference_Number.isEmpty()) {

			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);

		}

		if (!Booking_Number.isEmpty()) {

			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);

		}

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		Step_End(1, "Click the refresh button on the e-commerce gateway", test, test1);

		Step_Start(2, "Booking and SI records show a grid", test, test1);

		if (isdisplayed(driver, AG_Grid_First_Row)) {

			System.out.println(
					"Pass || Expected result is : Booking or SI values should show in the grid || Actual result is : Booking or SI values is showing in the grid");
			Extent_pass_New(driver,
					"Pass || Expected result is : Booking or SI values should show in the grid || Actual result is : Booking or SI values is showing in the grid",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Booking or SI values should show in the grid || Actual result is : Booking or SI values is not showing in the grid");
			Extent_fail(driver,
					"Fail || Expected result is : Booking or SI values should show in the grid || Actual result is : Booking or SI values is not showing in the grid",
					test, test1);

		}

		Step_End(2, "", test, test1);

		Step_Start(3, "Select any one Booking or SI row", test, test1);

		waitForElement(driver, AG_Grid_First_Row);
		doubleClick(driver, AG_Grid_First_Row);

		waitForElement(driver, Current_Module_Name);
		String currentModuleName = getText(driver, Current_Module_Name);

		if (Validator_Module_Name.equals(currentModuleName)) {
			System.out.println("Matched || After Double Clicking The Reference No Expected Module Name is : "
					+ Validator_Module_Name + " || The Actual Module Name is : " + currentModuleName);
			Extent_pass_New(driver,
					"Matched || After Double Clicking The Reference No Expected Module Name is : "
							+ Validator_Module_Name + " || The Actual Module Name is : " + currentModuleName,
					test, test1);
		} else {
			System.out.println("Not Matched || After Double Clicking The Reference No Expected Module Name is : "
					+ Validator_Module_Name + " || The Actual Module Name is : " + currentModuleName);
			Extent_fail(driver,
					"Not Matched || After Double Clicking The Reference No Expected Module Name is : "
							+ Validator_Module_Name + " || The Actual Module Name is : " + currentModuleName,
					test, test1);
		}

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		waitForElement(driver, AG_Grid_First_Row);
		click(driver, AG_Grid_First_Row);

		Step_End(3, "Select any one Booking or SI row", test, test1);

		Step_Start(4, "Right-click on the selected row and choose 'Show Original Field'", test, test1);

		waitForElement(driver, AG_Grid_First_Row);
		RightClick(driver, AG_Grid_First_Row);

		waitForElement(driver, EG_ShowOriginal);
		click(driver, EG_ShowOriginal);

		Step_End(4, "Right-click on the selected row and choose 'Show Original Field'", test, test1);

		Step_Start(5, "The Ecom or EDI Submitted Booking and SI Validator Corrector Module should open'", test, test1);

		if (isdisplayed(driver, EV_Refno)) {

			System.out.println(
					"Pass || Expected result is : Ecommerce Validator/Corrector module should get opened || Actual result is : Ecommerce Validator/Corrector module is opened");
			Extent_pass_New(driver,
					"Pass || Expected result is : Ecommerce Validator/Corrector module should get opened || Actual result is : Ecommerce Validator/Corrector module is opened",
					test, test1);
		} else {

			System.out.println(
					"Fail || Expected result is : Ecommerce Validator/Corrector module should get opened || Actual result is : Ecommerce Validator/Corrector module is not opened");
			Extent_fail(driver,
					"Fail || Expected result is : Ecommerce Validator/Corrector module should get opened || Actual result is : Ecommerce Validator/Corrector module is not opened",
					test, test1);

		}

		Step_End(5, "The Ecom or EDI Submitted Booking and SI Validator Corrector Module should open'", test, test1);

		Step_Start(6, "The system should display the original values submitted by the customer", test, test1);

		waitForElement(driver, EV_Refno);

		waitForElement(driver, Current_Module_Name);
		String currentModuleName2 = getText(driver, Current_Module_Name);

		if (Validator_Module_Name.equals(currentModuleName2)) {
			System.out.println("Matched || Expected Module Name is : " + Validator_Module_Name
					+ " || The Actual Module Name is : " + currentModuleName2);
			Extent_pass_New(driver, "Matched || Expected Module Name is : " + Validator_Module_Name
					+ " || The Actual Module Name is : " + currentModuleName2, test, test1);
		} else {
			System.out.println("Not Matched || Expected Module Name is : " + Validator_Module_Name
					+ " || The Actual Module Name is : " + currentModuleName2);
			Extent_fail(driver, "Not Matched || Expected Module Name is : " + Validator_Module_Name
					+ " || The Actual Module Name is : " + currentModuleName2, test, test1);
		}

		Step_End(6, "The system should display the original values submitted by the customer", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
