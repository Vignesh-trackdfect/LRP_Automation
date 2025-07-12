package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Cost_Activity_Report_Locators;

public class TC_Cost_Activity_Report_TS065 extends Keywords {
	public void Cost_Activity_Report_TS065(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS065";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String Select_Columns = Excel_data.get("Select_Columns");
		String activity_Input = Excel_data.get("activity_Input");
		
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");

		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window.", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No", test, test1);
		Step_Start(8, "Click on the select button", test, test1);

		globalValueSearchWindow(driver, CAR_Retrieve_Condition, CAR_Retrieve_Type, CAR_Number_Retrieve, CAR_Retrieve_Type2, CAR_Number_Retrieve_Value2, CAR_Retrieve_Type3, CAR_Number_Retrieve_Value3);

		Step_End(4, "Check whether it opens a new search window.", test, test1);

		Step_End(5, "Enter the required CAR No. in the CAR No search field", test, test1);

		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No", test, test1);
		Step_End(8, "Click on the select button", test, test1);

		Step_Start(9, "System will retrieve the CAR", test, test1);
		waitForElement(driver, car_Table_Column_Button);
		Step_End(9, "System will retrieve the CAR", test, test1);

		Step_Start(10, "Go to the AG grid", test, test1);
		safeclick(driver, car_Table_Column_Button);
		Step_End(10, "Go to the AG grid", test, test1);
		Step_Start(11,
				"Go to the Amount with STX cloumn.Ensure that the Amount is showing based on the sum of Amount and its tax amount for the activity.",
				test, test1);
		waitForElement(driver, car_Table_Column_CheckBox);
		safeclick(driver, car_Table_Column_CheckBox);
		List<String> columns = splitAndExpand(Select_Columns);
		for (String column : columns) {
			waitForElement(driver, car_Table_Column_SearchBar);
			clear(driver, car_Table_Column_SearchBar);
			waitForElement(driver, car_Table_Column_SearchBar);
			sendKeys(driver, car_Table_Column_SearchBar, column);
			String checkbox = String.format(Cost_Activity_Report_Locators.car_Table_Checkbox_Select, column);
			safeclick(driver, checkbox);
		}
		waitForElement(driver, car_Table_Column_Button);
		safeclick(driver, car_Table_Column_Button);

		waitForElement(driver, Tool_Pannel_TF);
		click(driver, Tool_Pannel_TF);
		waitForElement(driver, car_Condition_Filter);
		click(driver, car_Condition_Filter);
		waitForElement(driver, activity_TF_Car);
		sendKeys(driver, activity_TF_Car, activity_Input);

		waitForElement(driver, car_Table);

		List<Map<String, String>> car_Table_Data = extractTableDataDirect1(driver, car_Table);
		String amount_Data = getFirstValueByHeader(car_Table_Data, "Amount");
		String Amount_Data = amount_Data.replaceAll(",", "");
		double amountValue = Double.parseDouble(Amount_Data);
		System.out.println("amountValue :" + amountValue);

		String amount_With_STX_Data = getFirstValueByHeader(car_Table_Data, "Amount with STX");
		String amount_With_STXData = amount_With_STX_Data.replaceAll(",", "");
		double Amount_With_STXData = Double.parseDouble(amount_With_STXData);
		System.out.println("Amount_With_STXData :" + Amount_With_STXData);

		String SGST_Data = getFirstValueByHeader(car_Table_Data, "SGST");
		String SGST_data = SGST_Data.replaceAll(",", "");
		double SGSTdata = Double.parseDouble(SGST_data);
		System.out.println("SGSTdata :" + SGSTdata);

		String VAT_Data = getFirstValueByHeader(car_Table_Data, "VAT");
		String VAT_data = VAT_Data.replaceAll(",", "");
		double VATdata = Double.parseDouble(VAT_data);
		System.out.println("VATdata :" + VATdata);

		double Total_Tax_Amount = SGSTdata + VATdata;
		System.out.println("Total_Tax_Amount :" + Total_Tax_Amount);

		double The_sum_of_Amount_and_its_tax_amount = Total_Tax_Amount + amountValue;
		System.out.println("The_sum_of_Amount_and_its_tax_amount :" + The_sum_of_Amount_and_its_tax_amount);

		if (Amount_With_STXData == The_sum_of_Amount_and_its_tax_amount) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Amount_With_STXData
					+ " || Actual Report Activity is : " + The_sum_of_Amount_and_its_tax_amount);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Amount_With_STXData
					+ " || Actual Report Activity is : " + The_sum_of_Amount_and_its_tax_amount, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Amount_With_STXData
					+ " || Actual Report Activity is : " + The_sum_of_Amount_and_its_tax_amount);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Amount_With_STXData
					+ " || Actual Report Activity is : " + The_sum_of_Amount_and_its_tax_amount, test, test1);
		}

		Step_End(11,
				"Go to the Amount with STX cloumn.Ensure that the Amount is showing based on the sum of Amount and its tax amount for the activity.",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
