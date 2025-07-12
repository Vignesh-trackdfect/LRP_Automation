package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS031 extends Keywords{
	
	public void  Cost_Activity_Report_TS031(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS031";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String Remarks_Value = Excel_data.get("Remarks_Value");
		String Remarks_Updated_Popup = Excel_data.get("Remarks_Updated_Popup");

		
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency ", test, test1);

		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field. ", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field. ", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar.  ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar. ", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, ".Enter the required CAR No. in the CAR No search field.  ", test, test1);
		Step_Start(6, "Then click on the search button.       ", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button. ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(7, "System will show the CAR No. and Click on the select button.", test, test1);
		Step_End(6, "Then click on the search button.       ", test, test1);
		Step_End(5, ".Enter the required CAR No. in the CAR No search field.", test, test1);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		
		Step_Start(8, ".System will retrieve the CAR. ", test, test1);
		waitForElement(driver, Remarks_Tab_CAR);
		Step_End(8, ".System will retrieve the CAR. ", test, test1);
		
		Step_Start(9, "Click on the edit option in the toolbar. ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(9, "Click on the edit option in the toolbar. ", test, test1);
		
		Step_Start(10, "Click on the remarks tab.", test, test1);
		waitForElement(driver, Remarks_Tab_CAR);
		click(driver,Remarks_Tab_CAR);
		Step_End(10, "Click on the remarks tab.", test, test1);
		
		Step_Start(11, "Enter the required remarks", test, test1);
		waitForElement(driver, Remarks_Text_Area_CAR);
		sendKeys(driver, Remarks_Text_Area_CAR, Remarks_Value);
		Step_End(11, "Enter the required remarks", test, test1);
		
		Step_Start(12, "Click on the save option.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(12, "Click on the save option.", test, test1);
		
		Step_Start(13, "System validates as 'Container Activity Report Updated' ", test, test1);
		waitForPopup(driver, popup_Message, Remarks_Updated_Popup);
		String PopupText_Act=getText(driver, popup_Message);
		
		if(PopupText_Act.equals(Remarks_Updated_Popup)) {
			System.out.println("Popup Matched  ||   Expected : "+Remarks_Updated_Popup+"   ||   Actual   : "+PopupText_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Remarks_Updated_Popup+"   ||   Actual   : "+PopupText_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Remarks_Updated_Popup+"   ||   Actual   : "+PopupText_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Remarks_Updated_Popup+"   ||   Actual   : "+PopupText_Act, test, test1);
		}
		Step_End(13, "System validates as 'Container Activity Report Updated' ", test, test1);
		
		Step_Start(14, "Click on the ok option. ", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(14, "Click on the ok option. ", test, test1);
		
		Step_Start(15, "Then click on the remarks tab. ", test, test1);
		waitForElement(driver, Remarks_Tab_CAR);
		click(driver,Remarks_Tab_CAR);
		Step_End(15, "Then click on the remarks tab. ", test, test1);
		
		String ExpDate=getCurrentDateNew();
		
		Step_Start(16, "Ensure that given remarks is entered in the grid with  Remarks by and Remarks on data.", test, test1);
		waitForElement(driver, Remarks_Row_CAR);
		List<WebElement> remarks_values_Row=listOfElements(driver, Remarks_Row_CAR);
		int lastSize_=remarks_values_Row.size();
		
		String Remarks_Name=String.format(Remarks_Values_Last_CAR, lastSize_);
		String Remarks_Added_Last=getText(driver, Remarks_Name);
		
		String Remarks_User=String.format(Remarks_User_Last_CAR, lastSize_);
		String Remarks_User_Last=getText(driver, Remarks_User);
		
		String Remarks_Date=String.format(Remarks_Date_Last_CAR, lastSize_);
		String Remarks_Date_Last=getText(driver, Remarks_Date);
		
		if(Remarks_Value.equals(Remarks_Added_Last)) {
			System.out.println("Remarks Matched || Expected  : "+Remarks_Value+"   Actual : "+Remarks_Added_Last);
			Extent_pass_New(driver, "Remarks Matched || Expected  : "+Remarks_Value+"   Actual : "+Remarks_Added_Last, test, test1);
		}else {
			System.out.println("Remarks Not Matched || Expected  : "+Remarks_Value+"   Actual : "+Remarks_Added_Last);
			Extent_fail(driver, "Remarks Not Matched || Expected  : "+Remarks_Value+"   Actual : "+Remarks_Added_Last, test, test1);
		}
		
		if(Remarks_User_Last.equalsIgnoreCase(username)) {
			System.out.println("Remarks By Matched || Expected  : "+username+"   Actual : "+Remarks_User_Last);
			Extent_pass_New(driver, "Remarks By Matched || Expected  : "+username+"   Actual : "+Remarks_User_Last, test, test1);
		}else {
			System.out.println("Remarks By Not Matched || Expected  : "+username+"   Actual : "+Remarks_User_Last);
			Extent_fail(driver, "Remarks By Not Matched || Expected  : "+username+"   Actual : "+Remarks_User_Last, test, test1);
		}
		
		if(Remarks_Date_Last.contains(ExpDate)) {
			System.out.println("Remarks On Matched || Expected  : "+ExpDate+"   Actual : "+Remarks_Date_Last);
			Extent_pass_New(driver, "Remarks On Matched || Expected  : "+ExpDate+"   Actual : "+Remarks_Date_Last, test, test1);
		}else {
			System.out.println("Remarks On Not Matched || Expected  : "+ExpDate+"   Actual : "+Remarks_Date_Last);
			Extent_fail(driver, "Remarks On Not Matched || Expected  : "+ExpDate+"   Actual : "+Remarks_Date_Last, test, test1);
		}
		Step_End(16, "Ensure that given remarks is entered in the grid with  Remarks by and Remarks on data.", test, test1);
		
		Extent_completed(tc_Name, test, test1);
		
	}

}
