package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS061 extends Keywords {

	public void Cost_Activity_Report_TS061(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS061";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String GivenContract_Type = Excel_data.get("GivenContract_Type");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Condition1 = Excel_data.get("Condition1");
		String GivenMode = Excel_data.get("GivenMode");
		String DefauleQuantity = Excel_data.get("DefauleQuantity");
		String Agency = Excel_data.get("Agency");
		String Service_Filter_Header = Excel_data.get("Service_Filter_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String ArrivalDate_Filter_Header = Excel_data.get("ArrivalDate_Filter_Header");

		String Contract_option = String.format(Select_ContractType, GivenContract_Type);
		String Mode_option = String.format(Select_ModeOption, GivenMode);

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, Agency);

		verifyMainMenu(driver);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(3, "Click on the Service search button and select the required service code", test, test1);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);

		waitForElement(driver, Contract_option);
		click(driver, Contract_option);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);

		waitForElement(driver, Mode_option);
		click(driver, Mode_option);

		waitForElement(driver, Service_Search);
		click(driver, Service_Search);

		twoColumnSearchWindow(driver, Service_Filter_Header, Condition1, Service);

		Step_End(3, "Click on the Service search button and select the required service code", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		waitForElement(driver, Vessel_Search);
		click(driver, Vessel_Search);

		twoColumnSearchWindow(driver, Vessel_Filter_Header, Condition1, Vessel);

		Step_End(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code", test, test1);

		waitForElement(driver, port_Search);
		click(driver, port_Search);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition1, Port);

		Step_End(5, "Click on the Port search button and select the required port code", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		waitForElement(driver, CAR_Terminal_Search);
		click(driver, CAR_Terminal_Search);

		twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition1, Terminal);

		Step_End(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date", test, test1);

		waitForElement(driver, ArrivalDate_Search);
		click(driver, ArrivalDate_Search);

		twoColumnSearchWindow(driver, ArrivalDate_Filter_Header, Condition1, Arrival_Date);

		Step_End(7, "Click on the Arrival date search button and select the required date", test, test1);

		Step_Start(8, "Click on the Show button", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);

		if (isdisplayed(driver, popup_Message_Yes_Button)) {

			click(driver, popup_Message_Yes_Button);
		}

		Step_End(8, "Click on the Show button", test, test1);

		Step_Start(9, "Click on the expense report", test, test1);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver, Predictable_Reporting_CAR);

		Step_End(9, "Click on the expense report", test, test1);

		Step_Start(10,
				"Click on the predictable Reporting tab and Select the required data in the grid by using the check box selection and ensure that the quantity is set as 1 by default",
				test, test1);

		Scroll_ElementVisible(driver, Predictable_Reporting_CAR, Predictable_Scroll);

//		List<WebElement> Quantity = driver.findElements(By.xpath(
//				"//div[@id='CRR-CRR_jTabbedPane1-CRR_gridPredictable']//div[@col-id='qty' and @role='gridcell']"));
		
		List<WebElement> Quantity = listOfElements(driver, CAR_qtyrow);

		int row = 0;
		for (WebElement element : Quantity) {

			String quantity_value = element.getText();

			if (quantity_value.equals(DefauleQuantity)) {

				System.out
						.println("Predictable reporting Tab Row " + (row + 1) + " value was set as " + DefauleQuantity);
				Extent_pass_New(driver,
						"Predictable reporting Tab Row " + (row + 1) + " value was set as " + DefauleQuantity, test,
						test1);
				Extent_pass_New(driver, "Expected value : " + DefauleQuantity + " Actual value : " + quantity_value, test,
						test1);

			} else {

				System.out.println(
						"Predictable reporting Tab Row " + (row + 1) + " value was not set as " + DefauleQuantity);
				Extent_fail(driver,
						"Predictable reporting Tab Row " + (row + 1) + " value was not set as " + DefauleQuantity, test,
						test1);
				Extent_fail(driver, "Expected value : " + DefauleQuantity + " Actual value : " + quantity_value, test,
						test1);

			}

			row++;

		}

		Step_End(10,
				"Click on the predictable Reporting tab and Select the required data in the grid by using the check box selection and ensure that the quantity is set as 1 by default",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
