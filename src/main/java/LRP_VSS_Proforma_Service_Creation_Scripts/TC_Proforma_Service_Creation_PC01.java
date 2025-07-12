package LRP_VSS_Proforma_Service_Creation_Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC01 extends Keywords {

	
	//	Saving Record in Draft Mode 
	public void Proforma_Service_Creation_PC01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws FileNotFoundException, IOException {

		//	Get data from excel sheet
		String tc_name="TC_Proforma_Service_Creation_PC01";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String service_Code = Excel_data.get("Service_Code");
		String remarks = Excel_data.get("Remarks");
		String status = Excel_data.get("ProformaStatus");
		String type = Excel_data.get("ProformaType");
		String startDate = Excel_data.get("StartDate");
		String noOfTimeAdd = Excel_data.get("NoOfPortsAdd");
		String yellowColor = Excel_data.get("YellowColor");
		String capacity = Excel_data.get("Capacity");
		String proformaSavedPopup = Excel_data.get("ProformaSavedPopup");
		String date_Picker = Excel_data.get("DatePicker");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String port_Search_Header = Excel_data.get("Port_Search_Header");
		String terminal_Search_Header = Excel_data.get("Terminal_Search_Header");
		String Export_All_Columns_Checkbox = Excel_data.get("Export_All_Columns_Checkbox");
		String Auto_Save_Split_Bound_Checkbox = Excel_data.get("Auto_Save_Split_Bound_Checkbox");


		Extent_Start(tc_name, test, test1);
		navigateUrl(driver, url);

		//	Login

		LRP_Login(driver, Username, Password);
		
		moduleNavigate(driver, ModuleSearch);
		
	

		//	Create proforma service

		Step_Start(1, "Click on the new button in the toolbar", test, test1);
		
		newButton(driver);
		
		Step_End(1, "Click on the new button in the toolbar", test, test1);
		Step_Start(2, "Enter the service code in the service field via autocomplete", test, test1);
		
		waitForElement(driver, service_Search_Icon_Psc);
		click(driver, service_Search_Icon_Psc);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, service_Code);
		
		Step_End(2, "Enter the service code in the service field via autocomplete", test, test1);

		Step_Start(3, "Enter the remarks", test, test1);
		
		waitForElement(driver, remark_field);
		click(driver, remark_field);
		waitForElement(driver, remark_field);
		sendKeys(driver, remark_field, remarks);
		
		Step_End(3, "Enter the remarks", test, test1);
		
		waitForDisplay(driver, Proforma_Temp_Remove);
		if(isdisplayed(driver, Proforma_Temp_Remove)){
			waitForElement(driver, Proforma_Temp_Remove);
			click(driver, Proforma_Temp_Remove);
		}
		//	Proforma Date

		Step_Start(4, "Select the respective date from the proforma start date field ", test, test1);
		waitForElement(driver, proforma_Date);

		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime_Proforma(driver, proforma_Date, startDate);
			}else {
				if(startDate.contains("-")) {
					String startDate1=startDate.replace("-", "/");
					clearAndType(driver, proforma_Date, startDate1);
					waitForElement(driver, calenderclosebutton_SPF);
					click(driver, calenderclosebutton_SPF);
				}else {
					clearAndType(driver, proforma_Date, startDate);	
					waitForElement(driver, calenderclosebutton_SPF);
					click(driver, calenderclosebutton_SPF);

				}
			}

		Step_End(4, "Select the respective date from the proforma start date field ", test, test1);

		if(!status.equals("")) {
			waitForElement(driver, status_Dropdown_SPF);
			click(driver,status_Dropdown_SPF);
			
			String select_Status=String.format(DropDown_Select,status);
			
			waitForElement(driver, select_Status);
			click(driver, select_Status);
		}

		if(!type.equals("")) {
			waitForElement(driver, type_Dropdown);
			click(driver,type_Dropdown);
			
			String select_Type=String.format(DropDown_Select,type);
			
			waitForElement(driver, select_Type);
			click(driver, select_Type);
		}

		if(!capacity.equals("")) {
			waitForElement(driver, capacity_Textfield);
			click(driver,capacity_Textfield);
			waitForElement(driver, capacity_Textfield);
			clearAndType(driver, capacity_Textfield, capacity);

		}
		
		 waitForDisplay(driver, Proforma_Temp_Remove);
			if(isdisplayed(driver, Proforma_Temp_Remove)){
				waitForElement(driver, Proforma_Temp_Remove);
				click(driver, Proforma_Temp_Remove);
			}
		Step_Start(5, "Click on the Plus icon from the AGgrid below ", test, test1);
		// Add multiple ports & Terminal in grid

		int j=Integer.parseInt(noOfTimeAdd);
		for(int i=1;i<=j;i++) {

			String portCode = Excel_data.get("PortCode"+i);
			String terminalCode = Excel_data.get("TerminalCode"+i);	

			String portSearchButtonIteration=String.format(portSearchButton_Iteration,i);
			waitForDisplay(driver, portSearchButtonIteration);
			click(driver, portSearchButtonIteration);

			twoColumnSearchWindow(driver, port_Search_Header, condition, portCode);

			
			Extent_call(test, test1, "Select the port using port search icon");
			
			waitForDisplay(driver, marineDistance_Frame);
			if(isdisplayed(driver, marineDistance_Frame)) {
				waitForElement(driver, marineDistance_Ok_Button);
				click(driver, marineDistance_Ok_Button);
			}

			String terminalSearchButtonIteration=String.format(terminalSearchButton_Iteration, i);
			waitForDisplay(driver, terminalSearchButtonIteration);
			click(driver, terminalSearchButtonIteration);

			Extent_call(test, test1, "Select the terminal Using the terminal Search Icon");

			twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminalCode);

			if(i!=j) {

				String	agGrid_PlusIconIteration=String.format(agGrid_PlusIcon_Iteration, i);
				waitForElement(driver, agGrid_PlusIconIteration);
				click(driver, agGrid_PlusIconIteration);
			}
		}
		Step_End(5, "Click on the Plus icon from the AGgrid below ", test, test1);

			waitForDisplay(driver, export_All_Columns_Checkbox);
			checkBox(driver, export_All_Columns_Checkbox, Export_All_Columns_Checkbox);
			waitForDisplay(driver, autoSave_Split_Bound_Checkbox);
			checkBox(driver, autoSave_Split_Bound_Checkbox, Auto_Save_Split_Bound_Checkbox);

		//	Verify the proforma service creation popup

		Step_Start(6, "Click on save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(6, "Click on save button ", test, test1);

		waitForPopup(driver, popup_Message, proformaSavedPopup);

		String saveproforma = getText(driver, popup_Message);

		if (saveproforma.equals(proformaSavedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+saveproforma, test,test1);
			System.out.println("Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+saveproforma);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+saveproforma);

			Extent_fail(driver, "Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+saveproforma, test,test1);
		}

		//	Background Color Verification of Proforma code textfield
		Step_Start(7, "System should save the record in Draft highlighting the Service Code is Yellow Background color ", test, test1);

		waitForElement(driver, proforma_code);
		String textcolorCode = getTextBackgroundColor(driver, proforma_code);
		String textcolor = getColorName(textcolorCode);
				
		if (textcolor.equals(yellowColor)) {
			Extent_pass_New(driver, "Matched || Expected :"+yellowColor+" || Actual :"+textcolor, test,test1);
			System.out.println("Matched || Expected :"+yellowColor+" || Actual :"+textcolor);	
			Extent_pass_New(driver, "The background color of Proforma code textfield is Yellow", test, test1);
			System.out.println("The background color of Proforma code textfield is Yellow");
		}else {
			System.out.println("Not Matched || Expected :"+yellowColor+" || Actual :"+textcolor);

			Extent_fail(driver, "Not Matched || Expected :"+yellowColor+" || Actual :"+textcolor, test,test1);
		}

		Step_End(7, "System should save the record in Draft highlighting the Service Code is Yellow Background color ", test, test1);

		String newproforma_code = getAttribute(driver,proforma_code,"value" );

		Extent_pass_New(driver, " Generated :Proforma Code :: "+newproforma_code, test, test1);
		System.out.println(" Generated :Proforma Code :: "+newproforma_code);

		Extent_completed(tc_name, test, test1);
	}
}
