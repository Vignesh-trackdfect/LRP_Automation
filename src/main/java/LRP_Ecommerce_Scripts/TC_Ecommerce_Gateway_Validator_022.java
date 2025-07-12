package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_022 extends Keywords {

	public void Ecommerce_Gateway_Validator_022(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_022";
		
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

		click(driver, select_Routing);

		System.out.println("clicked in the popup");

		Step_End(6, "Click on the corresponding Routing", test, test1);

		Step_Start(7, "Click on ok button", test, test1);

		waitForElement(driver, ok);

		click(driver, ok);

		Step_End(7, "Click on ok button", test, test1);

		Step_Start(8, "Check whether schedule got added or not", test, test1);

		if (isDisplayed(driver, Route_data2)) {
			System.out.println(
					"Matched || Expected : Schedule should be added after selecting the Routing value Actual Message :Schedule got added after selecting the Routing value");
			Extent_pass_New(driver,
					"Matched || Expected : Schedule should be added after selecting the Routing value Actual Message :Schedule got added after selecting the Routing value",
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected : Schedule should be added after selecting the Routing value Actual Message :Schedule didn't got added after selecting the Routing value");
			Extent_fail(driver,
					"Not Matched || Expected : Schedule should be added after selecting the Routing value Actual Message :Schedule didn't got added after selecting the Routing value",
					test, test1);

		}

		Step_End(8, "Check whether schedule got added or not", test, test1);

		Step_Start(9, "print the scheduled data", test, test1);

		if (!isDisplayed(driver, Processing_Locator)) {

			waitForElement(driver, Route_data2);

			String data = getText(driver, Route_data2);

			System.out.println(data);

		}
		
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
		}

		
		waitForElement(driver, Route_data2);
		String data = getText(driver, Route_data2);

		if (isDisplayed(driver, Route_data2)) {
			System.out.println("Matched || Expected :Newly scheduled booking terminal ETD data should be displayed:"
					+ data + "Actual Message :Newly scheduled booking  terminal ETD data is displayed:" + data);
			Extent_pass_New(driver,
					"Matched || Expected :Newly scheduled booking terminal ETD data should be displayed:" + data
							+ "Actual Message :Newly scheduled booking terminal ETD data is displayed:" + data,
					test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking terminal ETD data should be displayed:"
					+ data + "Actual Message :Newly scheduled booking terminal ETD data is not displayed:" + data);
			Extent_fail(driver,
					"Not Matched|| Expected :Newly scheduled booking terminal ETD data should be displayed:" + data
							+ "Actual Message :Newly scheduled booking terminal ETD data is not displayed:" + data,
					test, test1);

		}
		waitForElement(driver, SGSINPLD);
		String PLD = getText(driver, SGSINPLD);
		if (isDisplayed(driver, SGSINPLD)) {
			System.out.println("Matched || Expected :Newly scheduled booking PLD data should be displayed:" + PLD
					+ "Actual Message :Newly scheduled booking PLD data is displayed:" + PLD);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking PLD data should be displayed:" + PLD
					+ "Actual Message :Newly scheduled booking PLD data is displayed:" + PLD, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking PLD data should be displayed:" + PLD
					+ "Actual Message :Newly scheduled booking PLD data is not displayed:" + PLD);
			Extent_fail(driver, "Not Matched || Expected :Newly scheduled booking PLD data should be displayed:" + PLD
					+ "Actual Message :Newly scheduled booking PLD data is not displayed:" + PLD, test, test1);

		}
		waitForElement(driver, SGSINPOD);

		String POD = getText(driver, SGSINPOD);
		if (isDisplayed(driver, SGSINPOD)) {
			System.out.println("Matched || Expected :Newly scheduled booking POD data should be displayed:" + POD
					+ "Actual Message :Newly scheduled booking POD data is displayed:" + POD);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking POD data should be displayed:" + POD
					+ "Actual Message :Newly scheduled booking POD data is displayed:" + POD, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking POD data should be displayed:" + POD
					+ "Actual Message :Newly scheduled booking POD data is not displayed:" + POD);
			Extent_fail(driver, "Not Matched || Expected :Newly scheduled booking POD data should be displayed:" + POD
					+ "Actual Message :Newly scheduled booking POD data is not displayed:" + POD, test, test1);

		}

		String POL = getText(driver, POLDATA);
		if (isDisplayed(driver, POLDATA)) {
			System.out.println("Matched || Expected :Newly scheduled booking POL data should be displayed:" + POL
					+ "Actual Message :Newly scheduled booking POL data is displayed:" + POL);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking POL data should be displayed:" + POL
					+ "Actual Message :Newly scheduled booking POL data is displayed:" + POL, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking POL data should be displayed:" + POL
					+ "Actual Message :Newly scheduled booking POL data is not displayed:" + POL);
			Extent_fail(driver, "Not Matched || Expected :Newly scheduled booking POL data should be displayed:" + POL
					+ "Actual Message :Newly scheduled booking POL data is not displayed:" + POL, test, test1);

		}

		String PLA = getText(driver, PLADATA);
		if (isDisplayed(driver, PLADATA)) {
			System.out.println("Matched || Expected :Newly scheduled booking PLA data should be displayed:" + PLA
					+ "Actual Message :Newly scheduled booking PLA data is displayed:" + PLA);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking PLA data should be displayed:" + PLA
					+ "Actual Message :Newly scheduled booking PLA data is displayed:" + PLA, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking PLA data should be displayed:" + PLA
					+ "Actual Message :Newly scheduled booking PLA data is not displayed:" + PLA);
			Extent_fail(driver, "Not Matched || Expected :Newly scheduled booking PLA data should be displayed:" + PLA
					+ "Actual Message :Newly scheduled booking PLA data is not displayed:" + PLA, test, test1);

		}

		waitForElement(driver, BOUNDD);
		String BOUNDW = getText(driver, BOUNDD);
		if (isDisplayed(driver, BOUNDD)) {
			System.out.println("Matched || Expected :Newly scheduled booking BOUND data should be displayed:" + BOUNDW
					+ "Actual Message :Newly scheduled booking BOUND data is displayed:" + BOUNDW);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking BOUND data should be displayed:" + BOUNDW
					+ "Actual Message :Newly scheduled booking BOUND data is displayed:" + BOUNDW, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking BOUND data should be displayed:"
					+ BOUNDW + "Actual Message :Newly scheduled booking BOUND data is not displayed:" + BOUNDW);
			Extent_fail(driver,
					"Not Matched || Expected :Newly scheduled booking BOUND data should be displayed:" + BOUNDW
							+ "Actual Message :Newly scheduled booking BOUND data is not displayed:" + BOUNDW,
					test, test1);

		}

		waitForElement(driver, VOYAGE);
		String VOYAG = getText(driver, VOYAGE);

		if (isDisplayed(driver, VOYAGE)) {
			System.out.println("Matched || Expected :Newly scheduled booking VOYAGE data should be displayed:" + VOYAG
					+ "Actual Message :Newly scheduled booking VOYAGE data is displayed:" + VOYAG);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking VOYAGE data should be displayed:" + VOYAG
					+ "Actual Message :Newly scheduled booking VOYAGE data is displayed:" + VOYAG, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking VOYAGE data should be displayed:"
					+ VOYAG + "Actual Message :Newly scheduled booking VOYAGE data is not displayed:" + VOYAG);
			Extent_fail(driver,
					"Not Matched || Expected :Newly scheduled booking VOYAGE data should be displayed:" + VOYAG
							+ "Actual Message :Newly scheduled booking VOYAGE data is not displayed:" + VOYAG,
					test, test1);

		}

		String VESSL = getText(driver, VESSEL);
		if (isdisplayed(driver, VESSEL)) {
			System.out.println("Matched || Expected :Newly scheduled booking VESSEL data should be displayed:" + VESSL
					+ "Actual Message :Newly scheduled booking VESSEL data is displayed:" + VESSL);
			Extent_pass_New(driver, "Matched || Expected :Newly scheduled booking VESSEL data should be displayed:" + VESSL
					+ "Actual Message :Newly scheduled booking VESSEL data is displayed:" + VESSL, test, test1);

		} else {
			System.out.println("Not Matched || Expected :Newly scheduled booking VESSEL data should be displayed:"
					+ VESSL + "Actual Message :Newly scheduled booking VESSEL data is not displayed:" + VESSL);
			Extent_fail(driver,
					"Not Matched || Expected :Newly scheduled booking VESSEL data should be displayed:" + VESSL
							+ "Actual Message :Newly scheduled booking VESSEL data is not displayed:" + VESSL,
					test, test1);

		}

		Step_End(9, "print the scheduled data", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
