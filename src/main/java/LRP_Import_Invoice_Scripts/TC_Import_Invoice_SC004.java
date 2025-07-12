package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Invoice_SC004 extends Keywords {

	public void Import_Invoice_SC004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Import_Invoice_SC004";
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String import_Invoice_Module = Excel_data.get("import_Invoice_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Call_ID = Excel_data.get("Call_ID");
		String Terminal_Code_Input = Excel_data.get("Terminal_Code_Input");


		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "switch to import agency", test, test1);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser); 

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, ".open the import invoice module .", test, test1);

		moduleNavigate(driver, import_Invoice_Module);

		Step_End(2, "Open the import invoice module .", test, test1);

		Step_Start(3, "click the new button ", test, test1);

		newButton(driver);

		Step_End(3, "click the new button ", test, test1);

		Step_Start(4,
				"system has automatically select the BY BLNumber option -Verify that the Follwing field has enable-BLnumber Search field-Draft/Issued-Customer Search field-show bl button has enable.",
				test, test1);

		waitForElement(driver, by_Bl_Number_IN);
		if (isElementSelected(driver, by_Bl_Number_IN)) {

			System.out.println(
					"Pass || Expected result is : By BL Number option should selected as default || Actual result is : By BL Number option is defaultly selected");
			Extent_pass_New(driver,
					"Pass || Expected result is : By BL Number option should selected as default || Actual result is : By BL Number option is defaultly selected",
					test, test1);
		} else {

			System.out.println(
					"Pass || Expected result is : By BL Number option should selected as default || Actual result is : By BL Number option is not defaultly selected");
			Extent_pass_New(driver,
					"Pass || Expected result is : By BL Number option should selected as default || Actual result is : By BL Number option is not defaultly selected",
					test, test1);

		}

		Step_End(4,
				"system has automatically select the BY BLNumber option -Verify that the Follwing field has enable-BLnumber Search field-Draft/Issued-Customer Search field-show bl button has enable.",
				test, test1);

		Step_Start(5, "click the by vessel otpion", test, test1);

		waitForElement(driver, by_Vessel_Option);
		click(driver, by_Vessel_Option);

		Step_End(5, "click the by vessel otpion", test, test1);

		Step_Start(6, "system has enabled  the service,vessel,voyage and customer search field.", test, test1);

		waitForDisplay(driver, service_Txtfield_IN);

		if (isElementEnabled(driver, service_Txtfield_IN)) {

			System.out.println(
					"Pass || Expected result is : After click on by vessel button, service field should be enabled || Actual result is : After click on by vessel button, service field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is :After click on by vessel button, service field should be enabled || Actual result is : After click on by vessel button, service field is enabled",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : After click on by vessel button, service field should be enabled || Actual result is : After click on by vessel button, service field is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : After click on by vessel button, service field should be enabled || Actual result is : After click on by vessel button, service field is disabled",
					test, test1);

		}

		if (isElementEnabled(driver, vessel_Txtfield)) {

			System.out.println(
					"Pass || Expected result is : After click on by vessel button, Vessel field should be enabled || Actual result is : After click on by vessel button, Vessel field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is :After click on by vessel button, Vessel field should be enabled || Actual result is : After click on by vessel button, Vessel field is enabled",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : After click on by vessel button, Vessel field should be enabled || Actual result is : After click on by vessel button, Vessel field is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : After click on by vessel button, Vessel field should be enabled || Actual result is : After click on by vessel button, Vessel field is disabled",
					test, test1);

		}

		if (isElementEnabled(driver, voyage_Txtfield)) {

			System.out.println(
					"Pass || Expected result is : After click on by vessel button, Voyage field should be enabled || Actual result is : After click on by vessel button, Voyage field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is :After click on by vessel button, Voyage field should be enabled || Actual result is : After click on by vessel button, Voyage field is enabled",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : After click on by vessel button, Voyage field should be enabled || Actual result is : After click on by vessel button, Voyage field is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : After click on by vessel button, Voyage field should be enabled || Actual result is : After click on by vessel button, Voyage field is disabled",
					test, test1);

		}

		waitForElement(driver, customer_Search_Icon);
		if (isElementEnabled(driver, customer_Search_Icon)) {

			System.out.println(
					"Pass || Expected result is : After click on by vessel button, Customer search field should be enabled || Actual result is : After click on by vessel button, Customer search field is enabled");
			Extent_pass_New(driver,
					"Pass || Expected result is :After click on by vessel button, Customer search field should be enabled || Actual result is : After click on by vessel button, Customer search field is enabled",
					test, test1);

		} else {
			System.out.println(
					"Fail || Expected result is : After click on by vessel button, Customer search field should be enabled || Actual result is : After click on by vessel button, Customer search field is disabled");
			Extent_fail(driver,
					"Fail || Expected result is : After click on by vessel button, Customer search field should be enabled || Actual result is : After click on by vessel button, Customer search field is disabled",
					test, test1);

		}

		Step_End(6, "system has enabled  the service,vessel,voyage and customer search field.", test, test1);
		
		waitForElement(driver, service_text);
		click(driver, service_text);
		sendKeys(driver, service_text, Service);

		waitForElement(driver, Service_code);
		sendKeys(driver, Service_code, Service);

		waitForElement(driver, Vessel_code);
		sendKeys(driver, Vessel_code, Vessel);

		waitForElement(driver, Voyage_input);
		sendKeys(driver, Voyage_input, Voyage);
		
		waitForElement(driver, II_Bound_input);
		sendKeys(driver, II_Bound_input, Bound);

		
		if(!Terminal_Code_Input.equals("")) {
			horizontalscroll(driver, By_Vessel_Scroll, 500);
			sendKeys(driver, By_Vessel_Terminal, Terminal_Code_Input);
			}
			
			if(!Call_ID.equals("")) {
			waitForElement(driver, By_Vessel_Call_Id);
			sendKeys(driver, By_Vessel_Call_Id, Call_ID);
			}

		
		waitForElement(driver, Select_button);
		click(driver, Select_button);
		Extent_pass_New(driver, "By clicking Vessel Option , System able to Enter Service , Vessel, Voyage detailss", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
