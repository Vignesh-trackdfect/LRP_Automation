package LRP_Cost_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS041 extends Keywords {

	public void Cost_Activity_Report_TS041(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS041";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String MainActivity = Excel_data.get("MainActivity");
		String MainActivityName = Excel_data.get("MainActivityName");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Eqp_Status = Excel_data.get("Eqp_Status");
		String Car_Open_Popup = Excel_data.get("Car_Open_Popup");
		String Open_popup = Excel_data.get("Open_popup");
		String Agency = Excel_data.get("Agency");

		String Mainactivity_option = String.format(DropDown_Select, MainActivity);
		String Mainactivity_Name = String.format(DropDown_Select, MainActivityName);
		String Eqp_Type_option = String.format(DropDown_Select, Eqp_Type);
		String Eqp_Status_option = String.format(DropDown_Select, Eqp_Status);

		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, Agency);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
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

		Step_Start(9,
				"Ensure that only opened CAR is allowed to edit. If CAR is closed and clicking edit option System validates as Closed CAR cannot be edited Click on the ok option.Then click CAR open and open the car",
				test, test1);

		if(isdisplayed(driver, CAR_Close_Button)) {
			waitForElement(driver, CAR_Close_Button);
			click(driver, CAR_Close_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
		}
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForPopup(driver, popup_Message, Car_Open_Popup);
		String ActualPopupmessage = getText(driver, popup_Message);

		if (ActualPopupmessage.equals(Car_Open_Popup)) {

			System.out.println(
					"Popup Matched || Expected : " + Car_Open_Popup + " || Actual : " + ActualPopupmessage);
			Extent_pass_New(driver,
					"Popup Matched  || Expected : " + Car_Open_Popup + " || Actual : " + ActualPopupmessage,
					test, test1);
		} else {

			System.out.println("Popup Not Matched || Expected : " + Car_Open_Popup + " || Actual : "
					+ ActualPopupmessage);
			Extent_fail(driver, "Popup Not Matched || Expected : " + Car_Open_Popup + " || Actual : "
					+ ActualPopupmessage, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, CAR_Open_Button);
		click(driver, CAR_Open_Button);

		waitForPopup(driver, popup_Message, Open_popup);
		String ActualPopupmessage2 = getText(driver, popup_Message);

		if (ActualPopupmessage2.equals(Open_popup)) {

			System.out.println(
					"CAR Activity is Opened || Expected : " + Open_popup + " || Actual : " + ActualPopupmessage2);
			Extent_pass_New(driver,
					"CAR Activity is Opened || Expected : " + Open_popup + " || Actual : " + ActualPopupmessage2, test,
					test1);
		} else {

			System.out.println(
					"CAR Activity is not Opened || Expected : " + Open_popup + " || Actual : " + ActualPopupmessage2);
			Extent_fail(driver,
					"CAR Activity is not Opened || Expected : " + Open_popup + " || Actual : " + ActualPopupmessage2,
					test, test1);
		}

		Step_End(9,
				"Ensure that only opened CAR is allowed to edit. If CAR is closed and clicking edit option System validates as Closed CAR cannot be edited Click on the ok option.Then click CAR open and open the car",
				test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(10, "Click on the edit option in the toolbar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Grid_count);
		String totalcount = getText(driver, Grid_count);

		int prv_count = Integer.parseInt(totalcount);

		Step_End(10, "Click on the edit option in the toolbar", test, test1);

		Step_Start(11, "Click on the ADD option in the CAR summary tab", test, test1);

		waitForElement(driver, AddAcitivity);
		click(driver, AddAcitivity);

		Step_End(11, "Click on the ADD option in the CAR summary tab", test, test1);

		Step_Start(12, "A new window will be opened as add equipment details.", test, test1);

		if (isdisplayed(driver, AddSummary_Tab)) {

			System.out.println("Expected : Add equipments tab Should displayed || Actual : Add equipments tab is displayed");
			Extent_pass_New(driver, "Expected : Add equipments tab Should displayed || Actual : Add equipments tab is displayed", test, test1);

		} else {

			System.out.println("Expected : Add equipments tab Should displayed || Actual : Add equipments tab is not displayed");
			Extent_fail(driver, "Expected : Add equipments tab Should displayed || Actual : Add equipments tab is not displayed", test, test1);
		}

		Step_End(12, "A new window will be opened as add equipment details.", test, test1);

		Step_Start(13, "Select the required Main Activity,Main Activity name,Equipments type and Equipments status",
				test, test1);

		jsClick(driver, MainActivityDropdown);

		waitForElement(driver, Mainactivity_option);
		click(driver, Mainactivity_option);
		jsClick(driver, MainActivityNameDropdown);

		waitForElement(driver, Mainactivity_Name);
		click(driver, Mainactivity_Name);

		jsClick(driver, Eqp_TypeDropdown_CAR);

		waitForElement(driver, Eqp_Type_option);
		click(driver, Eqp_Type_option);

		jsClick(driver, Eqp_StausDropdown);

		waitForElement(driver, Eqp_Status_option);
		click(driver, Eqp_Status_option);

		Step_End(13, "Select the required Main Activity,Main Activity name,Equipments type and Equipments status", test,
				test1);

		Step_Start(14, "Click on the ok option", test, test1);

		waitForElement(driver, Click_Ok_CAR);
		click(driver, Click_Ok_CAR);

		Step_End(14, "Click on the ok option", test, test1);

		Step_Start(15, "Ensure that main activity gets added to the AG grid in CAR summary tab", test, test1);

		waitForElement(driver, Grid_count);
		String totalcount1 = getText(driver, Grid_count);

		int after_count = Integer.parseInt(totalcount1);

		if (after_count > prv_count) {

			String newlyadded = String.format(CAR_Activity_description, MainActivityName, Eqp_Type);

			if (isDisplayed(driver, newlyadded)) {

				System.out.println("Expected : Given data '" + Eqp_Type
						+ "' Should added in the grid || Actual : Given data was added in the grid");
				Extent_pass_New(driver,
						"Expected : Given data '" + Eqp_Type
								+ "' Should added in the grid || Actual : Given data was added in the grid",
						test, test1);

			} else {
				System.out.println("Expected : Given data '" + Eqp_Type
						+ "' Should added in the grid || Actual : Given data was not added in the grid");
				Extent_fail(driver,
						"Expected : Given data '" + Eqp_Type
								+ "' Should added in the grid || Actual : Given data was not added in the grid",
						test, test1);

			}
		} else {

			System.out.println("Expected : Given data '"+Eqp_Type+"' Should added in the grid || Actual : Given data was not added in the grid");
			Extent_fail(driver, "Expected : Given data '"+Eqp_Type+"' Should added in the grid || Actual : Given data was not added in the grid", test, test1);
		}

		Step_End(15, "Ensure that main activity gets added to the AG grid in CAR summary tab", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
