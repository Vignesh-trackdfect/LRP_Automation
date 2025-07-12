package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS007 extends Keywords {

	public void Cost_Activity_Report_TS007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS007";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Select_ContractCode = Excel_data.get("Select_ContractCode");
		String Select_Port = Excel_data.get("Select_Port");
		String Select_Terminal = Excel_data.get("Select_Terminal");
		String Cost_Equipment_Grouping_Module = Excel_data.get("Cost_Equipment_Grouping_Module");
		String Agency = Excel_data.get("Agency");

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
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully", test, test1);
		} else {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully", test, test1);
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

		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9, "System will retrieve the CAR", test, test1);

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

		Step_End(9, "System will retrieve the CAR", test, test1);

		Step_Start(10,
				"Click on the Grp. Eqp. Summary option button.A new tab is opened along with equipments grouping", test,
				test1);

		waitForElement(driver, Grid_count);
		String summary_Count = getText(driver, Grid_count);

		String GivenContract_Type = getText(driver, Contract_type);
		String Port = getAttribute(driver, Port_Value, "value");
		String Terminal = getAttribute(driver, CAR_Terminal_Input, "value");

		List<String> MainActivities = new ArrayList<String>();
		List<String> Summary_Eqp_type = new ArrayList<String>();

		for (int i = 0; i < Integer.parseInt(summary_Count); i++) {

			String gridData = String.format(CarSummary_Activities, i);
			String gridEqpType = String.format(CarSummary_EqpType, i);

			waitForElement(driver, gridData);
			scrollUsingElement(driver, gridData);

			String Activity = getText(driver, gridData);
			String EqpType = getText(driver, gridEqpType);

			MainActivities.add(Activity);

			Summary_Eqp_type.add(EqpType);

		}

		System.out.println("MainActivities : " + MainActivities);

		waitForElement(driver, Grp_Eqp);
		click(driver, Grp_Eqp);

		Step_End(10, "Click on the Grp. Eqp. Summary option button.A new tab is opened along with equipments grouping",
				test, test1);

		Step_Start(11,
				"Check whether the Grp. Eqp. Summary option shows data in both the tabs such as \"Actual Eqp with Grp Eqp. Summary\" and \"Group Equipment Summary\"",
				test, test1);

		waitForElement(driver, GES_Count);
		String ges_totalcount = getText(driver, GES_Count);

		List<String> GES_activities = new ArrayList<String>();
		List<String> GES_Eqp = new ArrayList<String>();

		for (int i = 0; i < Integer.parseInt(ges_totalcount); i++) {

			String Grp_Mainactivity = String.format(Grp_Eqpsummary_Mainactivity, i);
			String Grp_Eqp = String.format(Grp_Eqpsummary_Eqp, i);

			mouseOverToElement(driver, Grp_Mainactivity);

			String activity = getText(driver, Grp_Mainactivity);
			String Eqptype = getText(driver, Grp_Eqp);

			GES_activities.add(activity);
			GES_Eqp.add(Eqptype);

		}

		Set<String> gesPairs = new HashSet<>();
		for (int i = 0; i < GES_activities.size(); i++) {
			gesPairs.add(GES_activities.get(i) + "-" + GES_Eqp.get(i));
		}

		for (int i = 0; i < MainActivities.size(); i++) {
			String pair = MainActivities.get(i) + "-" + Summary_Eqp_type.get(i);
			if (gesPairs.contains(pair)) {
				System.out.println("The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ Summary_Eqp_type.get(i) + " is present in the Acutal Eqp with Grp");
				Extent_pass_New(driver, "The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ Summary_Eqp_type.get(i) + " is present in the Acutal Eqp with Grp", test, test1);
			} else {
				System.out.println("The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ Summary_Eqp_type.get(i) + " is not present in the Acutal Eqp with Grp");
				Extent_fail(driver, "The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ Summary_Eqp_type.get(i) + " is not present in the Acutal Eqp with Grp", test, test1);
			}
		}

		Step_End(11,
				"Check whether the Grp. Eqp. Summary option shows data in both the tabs such as \"Actual Eqp with Grp Eqp. Summary\" and \"Group Equipment Summary\"",
				test, test1);

		Step_Start(12,
				"Check whether the Grouped Eqp. shows the group based on Cost equipment grouping for Contract type CTL along with the Port and Terminal which is defined in the CAR",
				test, test1);

		waitForElement(driver, GE_SummaryTab);
		click(driver, GE_SummaryTab);

		waitForElement(driver, GES_Records);
		String Total_Count = getText(driver, GES_Records);

		List<String> GES_Activity = new ArrayList<String>();
		List<String> GES_EqpType = new ArrayList<String>();

		for (int i = 0; i < Integer.parseInt(Total_Count); i++) {

			String GES_Activiti = String.format(GES_Summary_Activity, i);
			String GES_Eqptype = String.format(GES_Summary_eqptype, i);

			mouseOverToElement(driver, GES_Activiti);
			waitForDownload(driver, GES_Activiti);
			String Activity = getText(driver, GES_Activiti);

			GES_Activity.add(Activity);

			String EqpType = getText(driver, GES_Eqptype);

			GES_EqpType.add(EqpType);

		}

		waitForElement(driver, Group_Ok);
		click(driver, Group_Ok);

		System.out.println("GES_Activity: " + GES_Activity);

		Step_Start(13,
				"Incase the respective Port and Terminal not available in Cost equipment grouping means,system should consider the CTL cost grouping without Port and Terminal mapping",
				test, test1);

		moduleNavigate(driver, Cost_Equipment_Grouping_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully", test, test1);
		} else {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully", test, test1);
		}

		globalValueSearchWindow1(driver, Condition, Select_ContractCode, GivenContract_Type, Select_Port, Port,
				Select_Terminal, Terminal);
		
		if (isdisplayed(driver, CAR_Norecords)) {

			System.out.println("No records found");
			clear(driver, globalSearch_InputTextfield3);
			clear(driver, globalSearch_InputTextfield2);

			waitForElement(driver, globalSearch_Frame_SearchButton);
			click(driver, globalSearch_Frame_SearchButton);

			waitForElement(driver, Port_sort);
			click(driver, Port_sort);

		}

		waitForElement(driver, Select1);
		click(driver, Select1);

		waitForElement(driver, SelectButton);
		click(driver, SelectButton);

		waitForElement(driver, MappedEquipmentFilter);
		click(driver, MappedEquipmentFilter);

		List<String> GroupEqp = new ArrayList<String>();

		for (int i = 0; i < Summary_Eqp_type.size(); i++) {

			waitForElement(driver, MappedEquipmentFilter);
			clear(driver, MappedEquipmentFilter);
			sendKeys(driver, MappedEquipmentFilter, Summary_Eqp_type.get(0));

			waitForElement(driver, Contract_Equipment_Value);
			String contract_equipment = getText(driver, Contract_Equipment_Value);

			GroupEqp.add(contract_equipment);

			System.out.println("contract_equipment : " + contract_equipment);

		}

		Set<String> gesPairs2 = new HashSet<>();
		for (int i = 0; i < GES_Activity.size(); i++) {
			gesPairs2.add(GES_Activity.get(i) + "-" + GES_EqpType.get(i));
		}

		for (int i = 0; i < 3; i++) {
			String pair = MainActivities.get(i) + "-" + GroupEqp.get(i);
			if (gesPairs2.contains(pair)) {
				System.out.println("The main activity : " + MainActivities.get(i) + " and Eqp Type : " + GroupEqp.get(i)
						+ " is present in the Grouped equipments summary Tab");
				Extent_pass_New(driver, "The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ GroupEqp.get(i) + " is present in the Grouped equipments summary Tab", test, test1);
			} else {
				System.out.println("The main activity : " + MainActivities.get(i) + " and Eqp Type : " + GroupEqp.get(i)
						+ " is not present in the Grouped equipments summary Tab");
				Extent_fail(driver, "The main activity : " + MainActivities.get(i) + " and Eqp Type : "
						+ GroupEqp.get(i) + " is not present in the Grouped equipments summary Tab", test, test1);
			}
		}

		Step_End(12,
				"Check whether the Grouped Eqp. shows the group based on Cost equipment grouping for Contract type CTL along with the Port and Terminal which is defined in the CAR",
				test, test1);

		Step_End(13,
				"Incase the respective Port and Terminal not available in Cost equipment grouping means,system should consider the CTL cost grouping without Port and Terminal mapping",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
