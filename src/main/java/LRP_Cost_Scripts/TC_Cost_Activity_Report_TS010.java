package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS010 extends Keywords {

	public void Cost_Activity_Report_TS010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS010";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Filter_Columns = Excel_data.get("Filter_Columns");
		String Updated_Popup = Excel_data.get("Updated_Popup");
		String Agency = Excel_data.get("Agency");
		String DeSelectALL_Checkbox = Excel_data.get("DeSelectALL_Checkbox");
		String Remove_Status_Type = Excel_data.get("Remove_Status_Type");

		
		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, Agency);

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

		Step_Start(10, "Click on the tool bar edit option", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(10, "Click on the tool bar edit option", test, test1);

		Step_Start(11,
				"Then select the Draft,Submitted and rejected activities in the AG grid by refering based on the status column which is available in the AG grid and click on remove button",
				test, test1);

		reArrangeAG_GridColumns(driver, Filter_Columns);
		
		waitForElement(driver, menuOption_StatusColum_CAR);
		click(driver,menuOption_StatusColum_CAR);
		
		waitForElement(driver, FilterOption_ColumnMenu_CAR);
		String FilterSelected=getAttribute(driver, FilterOption_ColumnMenu_CAR, "class");
		if(!FilterSelected.contains("selected")) {
			click(driver,FilterOption_ColumnMenu_CAR);
		}
		
		formatLocatorClick(driver, Checkbox_Filter_Column_CAR, DeSelectALL_Checkbox);
		
		waitForElement(driver, Menu_FilterSearchInput_CAR);
		List<String> removeColumns=splitAndExpand(Remove_Status_Type);
		for(String column: removeColumns) {
			Newclear(driver, Menu_FilterSearchInput_CAR);
			sendKeys(driver, Menu_FilterSearchInput_CAR, column);
			if(formatLocatorIsDisplayed(driver,Checkbox_Filter_Column_CAR,column)) {
				formatLocatorClick(driver, Checkbox_Filter_Column_CAR, column);
			}
		}
		
		waitForElement(driver, FilterOption_ColumnMenu_CAR);
		click(driver,FilterOption_ColumnMenu_CAR);
		
		waitForElement(driver, Filterd_Rows_Misc_Grid_CAR);
		List<WebElement> remove_Rows=listOfElements(driver, Filterd_Rows_Misc_Grid_CAR);
		
		if(remove_Rows.size()==0) {
			System.out.println("Expected : Draft/Submitted Activities should be present to remove it || Actual : Draft / Submitted Activities are not present");
			Extent_FailNew(driver, "Expected : Draft/Submitted Activities should be present to remove it || Actual : Draft / Submitted Activities are not present", test, test1);
		}
		
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL).build().perform();
		for(WebElement ele:remove_Rows ) {
			act.moveToElement(ele).build().perform();
			act.click(ele).build().perform();
		}
		act.keyUp(Keys.CONTROL).build().perform();
		
		waitForElement(driver, Remove_Misc);
		click(driver, Remove_Misc);

		Step_End(11,
				"Then select the Draft,Submitted and rejected activities in the AG grid by refering based on the status column which is available in the AG grid and click on remove button",
				test, test1);

		Step_Start(12,
				"Check whether the activity removed in AG grid and click on the save button which is available in tool bar",
				test, test1);

		reArrangeAG_GridColumns(driver, Filter_Columns);
		
		waitForElement(driver, menuOption_StatusColum_CAR);
		click(driver,menuOption_StatusColum_CAR);
		
		waitForElement(driver, FilterOption_ColumnMenu_CAR);
		FilterSelected=getAttribute(driver, FilterOption_ColumnMenu_CAR, "class");
		if(!FilterSelected.contains("selected")) {
			click(driver,FilterOption_ColumnMenu_CAR);
		}
		
		formatLocatorClick(driver, Checkbox_Filter_Column_CAR, DeSelectALL_Checkbox);
		
		waitForElement(driver, Menu_FilterSearchInput_CAR);
		removeColumns=splitAndExpand(Remove_Status_Type);
		for(String column: removeColumns) {
			Newclear(driver, Menu_FilterSearchInput_CAR);
			sendKeys(driver, Menu_FilterSearchInput_CAR, column);
			if(formatLocatorIsDisplayed(driver,Checkbox_Filter_Column_CAR,column)) {
				formatLocatorClick(driver, Checkbox_Filter_Column_CAR, column);
			}
		}
		
		if(!isdisplayed(driver, Filterd_Rows_Misc_Grid_CAR)) {
			System.out.println("Expected : Draft,Submitted and rejected activities should be removed in AG grid || Actual : Draft,Submitted and rejected activities removed in AG grid");
			Extent_pass_New(driver, "Expected : Draft,Submitted and rejected activities should be removed in AG grid || Actual : Draft,Submitted and rejected activities removed in AG grid", test, test1);
		}else {
			System.out.println("Expected : Draft,Submitted and rejected activities should be removed in AG grid || Actual : Draft,Submitted and rejected activities not removed in AG grid");
			Extent_fail(driver, "Expected : Draft,Submitted and rejected activities should be removed in AG grid || Actual : Draft,Submitted and rejected activities not removed in AG grid", test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(12,
				"Check whether the activity removed in AG grid and click on the save button which is available in tool bar",
				test, test1);

		Step_Start(13,
				"Check whether the stystem populates the information message as Container Activity Report updated",
				test, test1);

		waitForPopup(driver, popup_Message, Updated_Popup);
		String SavePopupmessage = getText(driver, popup_Message);

		if (SavePopupmessage.equals(Updated_Popup)) {

			System.out.println(
					"Activity report is saved || Expected : " + Updated_Popup + " || Actual : " + SavePopupmessage);
			Extent_pass_New(driver,
					"Activity report is saved || Expected : " + Updated_Popup + " || Actual : " + SavePopupmessage,
					test, test1);
		} else {

			System.out.println(
					"Activity report is not saved || Expected : " + Updated_Popup + " || Actual : " + SavePopupmessage);
			Extent_fail(driver,
					"Activity report is not saved || Expected : " + Updated_Popup + " || Actual : " + SavePopupmessage,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(13, "Check whether the stystem populates the information message as Container Activity Report updated",
				test, test1);

		Extent_completed(tc_Name, test, test1);

		
	}

}
