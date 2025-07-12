package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.LoadConfirmation_Locators;

public class TC_Slot_Cost_CalcuatorSC032  extends Keywords {
	
	public void Slot_Cost_CalcuatorSC032(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Slot_Cost_CalcuatorSC032";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Slot_Cost_Module = Excel_data.get("Slot_Cost_Module");
		String Action_option = Excel_data.get("Action_option");
		String Arr_Pilot_Option = Excel_data.get("Arr_Pilot_Option");
		String Arr_Dock_Option = Excel_data.get("Arr_Dock_Option");
		String Arr_Pilot_Date = Excel_data.get("Arr_Pilot_Date");
		String Arr_DockDate = Excel_data.get("Arr_DockDate");
		
		Extent_Start(testcase_Name, test, test1);
		 
		Step_Start(1, "Open the application.", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the application.", test, test1);
		
		Step_Start(2, "Go to the Slot Cost Calculator Module where the ag-Grid component is present.", test, test1);

		
		Step_Start(2, "Go to the Slot Cost Calculator Module where the ag-Grid component is present.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Slot_Cost_Module);
		
		
		Step_End(2, "Go to the Slot Cost Calculator Module where the ag-Grid component is present.", test, test1);

		Step_Start(3, "Assert that the grid is visible. By click on action to retrieve data.(MainLine)", test, test1);

		formatLocatorClick(driver, SCC_Action_Button, Action_option);

		waitForDisplay(driver, SCC_Slot_Cost_Calculator_Option);
		if(isDisplayed(driver, SCC_Slot_Cost_Calculator_Option)) {
			
			System.out.println("After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.");		
			Extent_pass_New(driver, "After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.",test, test1);

		}else {
			System.out.println("After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.");		
			Extent_fail(driver, "After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.",test, test1);

		}
		Step_End(3, "Assert that the grid is visible. By click on action to retrieve data.(MainLine)", test, test1);

		
		Step_Start(4, "Click on Edit Option on the tool bar.", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(4, "Click on Edit Option on the tool bar.", test, test1);
		
		Step_Start(5, "Edit the cell column  where date is present(Arr.Pilot).", test, test1);
		
		Step_Start(6, "Enter or edit the date or Select from the calender.", test, test1);
		
		

		formatLocatorDoubleClick(driver, SCC_Arr_pilot_Option, Arr_Pilot_Option);
		
		waitForElement(driver, SCC_Arr_pilot_Option_Input);
		clear(driver,SCC_Arr_pilot_Option_Input);
		sendKeys(driver, SCC_Arr_pilot_Option_Input, Arr_Pilot_Date);
		
		
		
		Step_End(6, "Enter or edit the date or Select from the calender.", test, test1);
		Step_End(5, "Edit the cell column  where date is present(Arr.Pilot).", test, test1);

		
		Step_Start(7, "Click on enter button.", test, test1);
		enter(driver);
		
		Step_End(7, "Click on enter button.", test, test1);
		
		waitForElement(driver, SCC_Port_First_row);
		click(driver,SCC_Port_First_row);
		
		
		 String Arr_pilot = String.format(SCC_Arr_pilot_Option, Arr_Pilot_Option);
		 String act_val=getText(driver, Arr_pilot);
		 
		 if(act_val.equals(Arr_Pilot_Date)) {
		
	 		   System.out.println("Matched || Expected || Arr pilot date  was : "+Arr_Pilot_Date+ "|| Actual : Arr pilot date was :" + act_val);
			   Extent_pass_New(driver,"Matched || Expected || Arr pilot date  was : "+Arr_Pilot_Date+ "|| Actual : Arr pilot date was :" + act_val,test, test1);


		 }else {
			 System.out.println("Not Matched || Expected || Arr pilot date  was : "+Arr_Pilot_Date+ "|| Actual : Arr pilot date was :" + act_val);
			   Extent_fail(driver,"Not Matched || Expected || Arr pilot date  was : "+Arr_Pilot_Date+ "|| Actual : Arr pilot date was :" + act_val,test, test1);

		 }
		
		
		 formatLocatorDoubleClick(driver, SCC_Arr_Dock_Option, Arr_Dock_Option);
		 
			StringBuilder day = new StringBuilder();
			StringBuilder month = new StringBuilder();
			StringBuilder year = new StringBuilder();
			StringBuilder time = new StringBuilder();
			datePickerWithTime(Arr_DockDate, day, month, year, time);
			
			waitForElement(driver, Year_DD);
			selectByText(driver, Year_DD, year.toString());
			waitForElement(driver, Month_DD);
			selectByText(driver, Month_DD, month.toString());
			String date_Select = String.format(LoadConfirmation_Locators.date_select, day);
			waitForElement(driver, date_Select);
			jsClick(driver, date_Select);
			
		
			waitForElement(driver, timeInput);
			click(driver, timeInput);
			waitForElement(driver, timeInput);
			clearAndType(driver, timeInput, time.toString());
			waitForElement(driver, timeInput);
			click(driver, timeInput);
			waitForDisplay(driver, calender_close);
			if (isdisplayed(driver, calender_close)) {
				waitForElement(driver, calender_close);
				click(driver, calender_close);
			}
			
			waitForElement(driver, SCC_Port_First_row);
			click(driver,SCC_Port_First_row);
			
			String Arr_Dock = String.format(SCC_Arr_Dock_Option, Arr_Dock_Option);
			waitForElement(driver, Arr_Dock);
			String act_Dock=getText(driver, Arr_Dock);
			System.out.println("act_Dock :"+act_Dock);
			
			Step_Start(8, ".To verify that whether date is set on (Arr.pilot) based on the input given.", test, test1);

			 
			 if(act_Dock.equals(Arr_DockDate)) {
					
		 		   System.out.println("Matched || Expected || Arr pilot date  was : "+Arr_DockDate+ "|| Actual : Arr pilot date was :" + act_Dock);
				   Extent_pass_New(driver,"Matched || Expected || Arr pilot date  was : "+Arr_DockDate+ "|| Actual : Arr pilot date was :" + act_Dock,test, test1);


			 }else {
				 System.out.println("Not Matched || Expected || Arr pilot date  was : "+Arr_DockDate+ "|| Actual : Arr pilot date was :" + act_Dock);
				   Extent_fail(driver,"Not Matched || Expected || Arr pilot date  was : "+Arr_DockDate+ "|| Actual : Arr pilot date was :" + act_Dock,test, test1);

			 }
			 
			 Step_End(8, ".To verify that whether date is set on (Arr.pilot) based on the input given.", test, test1);	 
			 
			 Extent_completed(testcase_Name, test, test1);	 
			
		
}
}