package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS051 extends Keywords {

	public void Cost_Activity_Report_TS051(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS051";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String ColorCode = Excel_data.get("ColorCode");
		String disbursement_ColorCode = Excel_data.get("disbursement_ColorCode");
		String Reject_popup = Excel_data.get("Reject_popup");
		String Agency = Excel_data.get("Agency");

		Extent_Start(tc_Name, test, test1);
		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);
		SwitchProfile(driver, Agency);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);

		} else {
			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver,
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully",
					test, test1);
		}

		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_Start(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(6, "Then click on the search button", test, test1);

		Step_Start(7, "System will show the CAR No", test, test1);

		Step_Start(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(6, "Then click on the search button", test, test1);

		Step_End(7, "System will show the CAR No", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}

		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9, "Click on the expense report option", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		Step_End(9, "Click on the expense report option", test, test1);

		Step_Start(10, "Click on the approve expense tab", test, test1);

		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);

		Step_End(10, "Click on the approve expense tab", test, test1);

		Step_Start(11,
				"Select the activities which is in yellow colour which indicates that the invoice is generated for that activity",
				test, test1);

		List<WebElement> approved_rows = listOfElements(driver, CAR_Approvedrows);

		Step_End(11,
				"Select the activities which is in yellow colour which indicates that the invoice is generated for that activity",
				test, test1);

		Step_Start(12, "Click on the reject option", test, test1);

		for (WebElement approveddata : approved_rows) {

			Step_Start(14,
					"Select the activities which is in green colour which indicates that the disbursement is generated for that activity",
					test, test1);

			String getcolor = getTextBackgroundColor1(driver, approveddata);

			String Fieldcolor = getColorName(getcolor);

			if (Fieldcolor.equals(ColorCode) || Fieldcolor.equals(disbursement_ColorCode)) {

				Click(driver, approveddata);

				Step_End(14,
						"Select the activities which is in green colour which indicates that the disbursement is generated for that activity",
						test, test1);

				Step_Start(15, "Click on the reject option", test, test1);

				waitForElement(driver, RejectExpense);
				click(driver, RejectExpense);

				Step_End(15, "Click on the reject option", test, test1);

				break;

			}

		}

		Step_End(12, "Click on the reject option", test, test1);

		Step_Start(16, "Ensure that system validates as  Invoiced activity cannot be rejected Click on the ok option",
				test, test1);

		waitForPopup(driver, popup_Message, Reject_popup);
		String PopupMEssage = getText(driver, popup_Message);

		if (PopupMEssage.equals(Reject_popup)) {

			System.out.println(
					"Expected Updated popup is showing || Expected : " + Reject_popup + " || Actual : " + PopupMEssage);
			Extent_pass_New(driver,
					"Expected Updated popup is showing || Expected : " + Reject_popup + " || Actual : " + PopupMEssage,
					test, test1);
		} else {

			System.out.println(
					"Expected Updated popup is showing || Expected : " + Reject_popup + " || Actual : " + PopupMEssage);
			Extent_fail(driver,
					"Expected Updated popup is showing || Expected : " + Reject_popup + " || Actual : " + PopupMEssage,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(16, "Ensure that system validates as  Invoiced activity cannot be rejected Click on the ok option",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
