package LRP_VSS_Consolidation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Proforma_Service_Creation_Consolidation extends Keywords {

	public void proformaServiceCreationConsolidation(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset) {
		
		int a=1;
		
		if(a == 1) {
			//	Get data from excel sheet
			String tc_name="TC_Proforma_Service_Creation_PC01";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC01 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC01, tc_name, "Dataset"+selected_dataset, File_Path);	
			String URL = TestNgXml.getdatafromExecution().get(tc_name);


			String Username = data.get("Username");
			String Password = data.get("Password");
			String ModuleSearch = data.get("Module_Search");
			String service_Code = data.get("Service_Code");
			String remarks = data.get("Remarks");
			String status = data.get("ProformaStatus");
			String type = data.get("ProformaType");
			String startDate = data.get("StartDate");
			String noOfTimeAdd = data.get("NoOfPortsAdd");
			String yellowColor = data.get("YellowColor");
			String capacity = data.get("Capacity");
			String proformaSavedPopup = data.get("ProformaSavedPopup");
			String date_Picker = data.get("DatePicker");

			String condition = data.get("Condition");
			String service_Search_Header = data.get("Service_Search_Header");
			String port_Search_Header = data.get("Port_Search_Header");
			String terminal_Search_Header = data.get("Terminal_Search_Header");
			String Export_All_Columns_Checkbox = data.get("Export_All_Columns_Checkbox");
			String Auto_Save_Split_Bound_Checkbox = data.get("Auto_Save_Split_Bound_Checkbox");


			Extent_Start(tc_name, test, test1);
			navigateUrl(driver, URL);

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

				String portCode = data.get("PortCode"+i);
				String terminalCode = data.get("TerminalCode"+i);	

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
			scrollTop(driver);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			

		}
		
		int b=2;
		if(b==2) {
			String tc_name="TC_Proforma_Service_Creation_PC02";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC02 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC02, tc_name, "Dataset"+selected_dataset, File_Path);	
			
	        String ModuleSearch = data.get("Module_Search");
	        String proformaCode = data.get("ProformaCode");
	        String bound = data.get("Bound");
	        String boundPopup = data.get("BoundPopup");       
	        String proformaUpdatedPopup = data.get("ProformaUpdatedPopup");
	        String greenColor = data.get("GreenColor");
	        String proforma_Status = data.get("ProformaStatus");
	        String dropdownCondition = data.get("DropdownCondition");
	        String globalSearchValueType = data.get("GlobalSearchValueType");

	        
	        Extent_Start(tc_name, test, test1);
			
	    	moduleNavigate(driver, ModuleSearch);
			
			
//	    	Retrieve the existing  record by Global Search		
	    			Step_Start(1, "Click on the search icon", test, test1);
	    			waitForElement(driver, SearchButton_Toolbar);
	    	        click(driver,SearchButton_Toolbar);
	    			Step_End(1, "Click on the search icon", test, test1);
	    			
	    			Step_Start(2, "Retrieve the existing record", test, test1);

	    			globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");
	    		
	    		
	    			 waitForDisplay(driver, Proforma_Temp_Remove);
	    				if(isdisplayed(driver, Proforma_Temp_Remove)){
	    					waitForElement(driver, Proforma_Temp_Remove);
	    					click(driver, Proforma_Temp_Remove);
	    				}	
	    			Step_End(2, "Retrieve the existing record", test, test1);
	    			
	    			Step_Start(3, "Select the status as “Confirmed” from the status drop down", test, test1);
	    			scrollTop(driver);
	    			waitForElement(driver, Edit_Button_toolBar);
	    			click(driver, Edit_Button_toolBar);
	    			
	    //  Change status			
	    			
	    			if(!proforma_Status.equals("")) {
	    				waitForElement(driver, status_Dropdown_SPF);
	    				click(driver,status_Dropdown_SPF);
	    				
	    				String select_Status=String.format(DropDown_Select,proforma_Status);
	    				
	    				waitForElement(driver, select_Status);
	    				click(driver, select_Status);
	    			}
	    			
	    			
	    			waitForElement(driver, proformaStatus);
	    			String StatusDropdownoption=getText(driver, proformaStatus);
	    			System.out.println(StatusDropdownoption);
	    			
	    			if(StatusDropdownoption.equals(proforma_Status)) {
	    				Extent_pass_New(driver, "Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
	    				System.out.println("Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);
	    			}else {
	    				System.out.println("Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);

	    				Extent_fail(driver, "Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
	    			}
	    	
	    			Step_End(3, "Select the status as “Confirmed” from the status drop down", test, test1);
	    			
	    			Step_Start(4, "Click On Save Button", test, test1);
	    			
	    			scrollTop(driver);

	    			waitForElement(driver, SaveButton_ToolBar);
	    			click(driver,SaveButton_ToolBar);
	    			
	    			Step_End(4, "Click On Save Button", test, test1);
	    // Bound popup			
	    			Step_Start(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
	    			waitForDisplay(driver, popup_Message);
	    			if(isdisplayed(driver, popup_Message)) {
	    			String boundmessage =getText(driver, popup_Message);
	    			Step_Start(6, "CLick on Save button", test, test1);

	    			if(boundmessage.equals(boundPopup)) {
	    				Extent_pass_New(driver, "Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage, test,test1);
	    				System.out.println("Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage);
	    				click(driver, popup_Message_Ok_Button);
	    				
	    				
	    				waitForElement(driver, bound_Gridcell);
	    				doubleClick(driver, bound_Gridcell);
	    				
	    				String selectBound=String.format(select_Bound, bound);
	    				waitForElement(driver, selectBound);
	    				click(driver, selectBound);
	    				
	    				scrollTop(driver);

	    				waitForElement(driver, SaveButton_ToolBar);
	    				click(driver,SaveButton_ToolBar);
	    				
	    			}
	    	
	    			}
	    			Step_End(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
	    			Step_End(6, "CLick on Save button", test, test1);

	    // Proforma updated popup
	    			
	    			Step_Start(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
	    			waitForPopup(driver, popup_Message, proformaUpdatedPopup);
	    			String actualUpdatedPopup = getText(driver, popup_Message);

	    			if (actualUpdatedPopup.equals(proformaUpdatedPopup)) {
	    				Extent_pass_New(driver, "Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
	    				System.out.println("Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);
	    				click(driver, popup_Message_Ok_Button);
	    			}else {
	    				System.out.println("Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);

	    				Extent_fail(driver, "Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
	    			}
	    			Step_End(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
	    			
	    			Step_Start(8, "Highlighted with Green background in the proforma code", test, test1);
	    	         
	    			waitForElement(driver, proforma_code);
	    			String actualColorCode = getTextBackgroundColor(driver, proforma_code);
	    			String actualColor = getColorName(actualColorCode);
	    			
	    			if (actualColor.equals(greenColor)) {
	    				Extent_pass_New(driver, "Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
	    				System.out.println("Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);	
	    				Extent_pass_New(driver, "The background color of Proforma code textfield is Green", test, test1);
	    				System.out.println("The background color of Proforma code textfield is Green");
	    			}else {
	    				System.out.println("Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);

	    				Extent_fail(driver, "Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
	    			}
	    			Step_End(8, "Highlighted with Green background in the proforma code", test, test1);
	    			
	    			Extent_completed(tc_name, test, test1);
	    			scrollTop(driver);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
			
		}
		
		
		int c=3;
		if(c==3) {
			
//			
//			Get data from excel sheet
			String tc_name="TC_Proforma_Service_Creation_PC03";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC03 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC03, tc_name, "Dataset"+selected_dataset, File_Path);	
			
	       
			
	        String ModuleSearch = data.get("Module_Search");
	        String date_Picker = data.get("DatePicker");
	        String arr_DockDate = data.get("ArrDockDate");
	        String arr_PilotDate = data.get("ArrPilotDate");
	        String dep_DockDate = data.get("DepDockDate");
	        String dep_PilotDate = data.get("DepPilotDate");
	        String firstAndLastPortSame = data.get("FirstAndLastPortSame");
	        String proformaCode = data.get("ProformaCode");
	        String arrDockLessorPopup = data.get("ArrDockLessorPopup");
	        String depDockLessArrDock = data.get("DepDockLessArrDock");
	        String depPilotLessDepDock = data.get("DepPilotLessDepDock");
	        String arrPilotGreaterPrevDep = data.get("ArrPilotGreaterPrevDep");
	        String samePortAndTerminal = data.get("SamePortAndTerminal");
	        String confirmStatus = data.get("ConfirmStatus");
	        String port = data.get("Port");
	        String terminal = data.get("Terminal");
	        
	        String dropdownCondition = data.get("DropdownCondition");
	        String globalSearchValueType = data.get("GlobalSearchValueType");
	        String condition = data.get("Condition");
			String port_Search_Header = data.get("Port_Search_Header");
			String terminal_Search_Header = data.get("Terminal_Search_Header");
			String columnHeaders = data.get("ColumnHeaders");

			
	        Extent_Start(tc_name, test, test1);
			
	        moduleNavigate(driver, ModuleSearch);
	        
//	    	Proforma service creation	

//	    		Retrieve Record
	    		Step_Start(1, "Retireve the existing record from the global search", test, test1);
	    		
	    		waitForElement(driver, SearchButton_Toolbar);
	            click(driver,SearchButton_Toolbar);
	    		
	    		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");

	    		
	    		Step_End(1, "Retireve the existing record from the global search", test, test1);
	    		Step_Start(2, "Click on the edit button ", test, test1);
	    		
	    			waitForElement(driver, Edit_Button_toolBar); 	    
	    		    click(driver, Edit_Button_toolBar);
	    		    
	    		    waitForDisplay(driver, Proforma_Temp_Remove);
	    			if(isdisplayed(driver, Proforma_Temp_Remove)){
	    				waitForElement(driver, Proforma_Temp_Remove);
	    				click(driver, Proforma_Temp_Remove);
	    			}
	    		    Step_End(2, "Click on the edit button ", test, test1);  
	    		    
	    		    reArrangeAG_GridColumnsWithoutCheckbox(driver, columnHeaders);

	    			 	    
	    			
	    			
	    			
//	    		ArrDock	lesser than ArrPilot
	    			
	    			Step_Start(3, "Check whether the system shows validation when the Arr Dock values is lesser than Arr pilot", test, test1);

	    		    waitForElement(driver, arrDockTime);		
	    			doubleClick(driver, arrDockTime);
	    					
	    			if(date_Picker.equalsIgnoreCase("Yes")) {
	    				
	    				selectDatePickerWithTime(driver, arrDockTime, arr_DockDate);

	    			}else {
	    				if(arr_DockDate.contains("-")) {
	    					String arr_DockDate1=arr_DockDate.replace("-", "/");
	    					waitForElement(driver, arrDockTime);
	    					click(driver,arrDockTime);
	    					waitForElement(driver, arrDockTime);
	    					clearAndType(driver, arrDockTime, arr_DockDate1);
	    					
	    				}else {
	    					click(driver,arrDockTime);
	    					waitForElement(driver, arrDockTime);
	    					clearAndType(driver, arrDockTime, arr_DockDate);	

	    					}
	    				
	    				waitForElement(driver, calenderclosebutton_SPF);
	    				click(driver, calenderclosebutton_SPF);
	    			}
	    			
	    			waitForElement(driver, arrDockTime1);
	    			click(driver, arrDockTime1);
	    			
	    			waitForPopup(driver, popup_Message, arrDockLessorPopup);

	    			String actualPopup = getText(driver, popup_Message);

	    			if (actualPopup.equals(arrDockLessorPopup)) {
	    				Extent_pass_New(driver, "Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup, test,test1);
	    				System.out.println("Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup);
	    				click(driver, popup_Message_Ok_Button);
	    			}else {
	    				System.out.println("Not Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup);

	    				Extent_fail(driver, "Not Matched || Expected popup :"+arrDockLessorPopup+" || Actual popup :"+actualPopup, test,test1);
	    			}
	    			
	    			
	    			
	    			Step_End(3, "Check whether the system shows validation when the Arr Dock values is lesser than Arr pilot", test, test1);

//	    	DepDock lesser than ArrDock
	    		
	    			Step_Start(4, ".Check whether the system shows validation when the Dep Dock values is lesser than Arr Dock", test, test1);

	    			waitForElement(driver, depDockTime);		
	    			doubleClick(driver, depDockTime);

	    			if(date_Picker.equalsIgnoreCase("Yes")) {
	    				
	    				selectDatePickerWithTime(driver, depDockTime, dep_DockDate);
	    				
	    			}else {
	    				if(dep_DockDate.contains("-")) {
	    					String dep_DockDate1=dep_DockDate.replace("-", "/");
	    					waitForElement(driver, depDockTime);
	    					click(driver,depDockTime);
	    					waitForElement(driver, depDockTime);
	    					clearAndType(driver, depDockTime, dep_DockDate1);
	    				}else {
	    					click(driver,depDockTime);
	    					waitForElement(driver, depDockTime);
	    					clearAndType(driver, depDockTime, dep_DockDate);	

	    					}
	    				
	    				waitForElement(driver, calenderclosebutton_SPF);
	    				click(driver, calenderclosebutton_SPF);
	    			}
	    			waitForElement(driver, depDockTime1);
	    				click(driver, depDockTime1);
	    				
	    				waitForPopup(driver, popup_Message, depDockLessArrDock);
	    				String actualPopup2 = getText(driver, popup_Message);

	    				if (actualPopup2.equals(depDockLessArrDock)) {
	    					Extent_pass_New(driver, "Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2, test,test1);
	    					System.out.println("Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2);
	    					click(driver, popup_Message_Ok_Button);
	    				}else {
	    					System.out.println("Not Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2);
	    					Extent_fail(driver, "Not Matched || Expected popup :"+depDockLessArrDock+" || Actual popup :"+actualPopup2, test,test1);
	    				}
	    				
	    				
	    				
	    				Step_End(4, ".Check whether the system shows validation when the Dep Dock values is lesser than Arr Dock", test, test1);
	    				
//	    	DepPilot lesser than DepDock
	    				
	    			Step_Start(5, "Check whether the system shows validation when the Dep Dock values is Greater than Dep pilot", test, test1);
	    			    waitForElement(driver, depPilotTime);		
	    				doubleClick(driver, depPilotTime);
	    				
	    				if(date_Picker.equalsIgnoreCase("Yes")) {
	    					
	    					selectDatePickerWithTime(driver, depPilotTime, dep_PilotDate);
	    				
	    				}else {
	    					if(dep_PilotDate.contains("-")) {
	    						String dep_PilotDate1=dep_PilotDate.replace("-", "/");
	    						waitForElement(driver, depPilotTime);
	    						click(driver,depPilotTime);
	    						waitForElement(driver, depPilotTime);
	    						clearAndType(driver, depPilotTime, dep_PilotDate1);
	    						
	    					}else {
	    						click(driver,depPilotTime);
	    						waitForElement(driver, depPilotTime);
	    						clearAndType(driver, depPilotTime, dep_PilotDate);	

	    						}
	    					
	    					waitForElement(driver, calenderclosebutton_SPF);
	    					click(driver, calenderclosebutton_SPF);
	    				}
	    				
	    				waitForElement(driver, depPilotTime1);
	    				click(driver, depPilotTime1);
	    				
	    				waitForPopup(driver, popup_Message, depPilotLessDepDock);
	    				String actualPopup3 = getText(driver, popup_Message);

	    				if (actualPopup3.equals(depPilotLessDepDock)) {
	    					Extent_pass_New(driver, "Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3, test,test1);
	    					System.out.println("Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3);
	    					click(driver, popup_Message_Ok_Button);
	    				}else {
	    					System.out.println("Not Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3);

	    					Extent_fail(driver, "Not Matched || Expected popup :"+depPilotLessDepDock+" || Actual popup :"+actualPopup3, test,test1);
	    				}
	    				
	    				
	    				
	    				Step_End(5, "Check whether the system shows validation when the Dep Dock values is Greater than Dep pilot", test, test1);
	    				
//	    	Arr pilot values is Lesser than previous row  Dep pilot
	    				
	    				Step_Start(6, ".Check whether the system shows validation when the Arr pilot values is Lesser than previous row  Dep pilot", test, test1);
	    			    waitForElement(driver, arrPilotTime1);		
	    				doubleClick(driver, arrPilotTime1);
	    				
	    				if(date_Picker.equalsIgnoreCase("Yes")) {
	    					
	    					selectDatePickerWithTime(driver, arrPilotTime1, arr_PilotDate);

	    				}else {
	    					if(arr_PilotDate.contains("-")) {
	    						String arr_PilotDate1=arr_PilotDate.replace("-", "/");
	    						waitForElement(driver, arrPilotTime1);
	    						click(driver,arrPilotTime1);
	    						waitForElement(driver, arrPilotTime1);
	    						clearAndType(driver, arrPilotTime1, arr_PilotDate1);
	    					}else {
	    						click(driver,arrPilotTime1);
	    						waitForElement(driver, arrPilotTime1);
	    						clearAndType(driver, arrPilotTime1, arr_PilotDate);	

	    						}
	    					
	    					waitForElement(driver, calenderclosebutton_SPF);
	    					click(driver, calenderclosebutton_SPF);
	    				}
	    				
	    				waitForElement(driver, arrPilotTime);
	    				click(driver, arrPilotTime);
	    				
	    				waitForPopup(driver, popup_Message, arrPilotGreaterPrevDep);
	    				String actualPopup4 = getText(driver, popup_Message);

	    				if (actualPopup4.equals(arrPilotGreaterPrevDep)) {
	    					Extent_pass_New(driver, "Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4, test,test1);
	    					System.out.println("Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4);
	    					click(driver, popup_Message_Ok_Button);
	    				}else {
	    					System.out.println("Not Matched || Expected popup:"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4);

	    					Extent_fail(driver, "Not Matched || Expected popup :"+arrPilotGreaterPrevDep+" || Actual popup :"+actualPopup4, test,test1);
	    				}
	    				
	    				
	    				
	    				Step_End(6, ".Check whether the system shows validation when the Arr pilot values is Lesser than previous row  Dep pilot", test, test1);
	    		   
//	    				Change status to confirm
	    				Step_Start(7, "Change status to confirm", test, test1);
	    					
	    					waitForElement(driver, status_Dropdown_SPF);
	    					click(driver,status_Dropdown_SPF);
	    					
	    					String select_Status=String.format(DropDown_Select,confirmStatus);
	    					
	    					waitForElement(driver, select_Status);
	    					click(driver, select_Status);
	    				
	    				
	    		    	String firstPort=getText(driver, firstPort_3);
	    				String firstTerminal=getText(driver, firstTerminal_3);
	    				Step_End(7, "Change status to confirm", test, test1);

	    		//	Port search
	    				
	    				Step_Start(8, "System should not allow if the two rows have same port and same terminal ", test, test1);
	    				waitForElement(driver, remove_Button_SPF);
	    		    	click(driver,remove_Button_SPF);
	    		    	
	    				waitForDisplay(driver, marineDistance_Frame);
	    				if(isdisplayed(driver, marineDistance_Frame)) {
	    					waitForElement(driver, marineDistance_Ok_Button);
	    					click(driver, marineDistance_Ok_Button);
	    					}
	    		    	waitForElement(driver, AGgrid_plusicon);
	    				click(driver, AGgrid_plusicon);
	    				waitForElement(driver, portSearch_button_Grid_SPF);
	    				click(driver, portSearch_button_Grid_SPF);
	    				
	    				twoColumnSearchWindow(driver, port_Search_Header, condition, firstPort);

	    				
	    				waitForDisplay(driver, marineDistance_Frame);
	    				if(isdisplayed(driver, marineDistance_Frame)) {
	    					waitForElement(driver, marineDistance_Ok_Button);
	    					click(driver, marineDistance_Ok_Button);
	    					}
	    				
	    				
	    //Terminal search
	    								
	    				waitForElement(driver, search_Terminal);
	    				click(driver, search_Terminal);
	    			
	    				twoColumnSearchWindow(driver, terminal_Search_Header, condition, firstTerminal);

	    				
	    					waitForElement(driver, SaveButton_ToolBar);
	    					click(driver,SaveButton_ToolBar);
	    					
	    					waitForPopup(driver, popup_Message, samePortAndTerminal);

	    					String actualPopup7 = getText(driver, popup_Message);

	    					if (actualPopup7.equals(samePortAndTerminal)) {
	    						Extent_pass_New(driver, "Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7, test,test1);
	    						System.out.println("Matched || Expected popup:"+samePortAndTerminal+" || Actual popup :"+actualPopup7);
	    						Extent_pass_New(driver, samePortAndTerminal+" popup is displayed", test, test1);
	    						System.out.println( samePortAndTerminal+" popup is displayed");
	    						click(driver, popup_Message_Ok_Button);
	    					}else {
	    						System.out.println("Not Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7);

	    						Extent_fail(driver, "Not Matched || Expected popup :"+samePortAndTerminal+" || Actual popup :"+actualPopup7, test,test1);
	    					}
	    					Step_End(8, "System should not allow if the two rows have same port and same terminal ", test, test1);
	    		    
	    		    
//	    	Add port
	    					Step_Start(9, "System should not allow to save the record, if the first row and last row have the same port and terminal", test, test1);
	    					waitForElement(driver, SaveButton_ToolBar);
	    			
	    					List<WebElement> ports = listOfElements(driver, ports3);
	    					int noOfPorts=ports.size();
	    					
	    					for(int i=2;i<=3;i++) {
	    						if(i==2) {
	    							String searchPorts=String.format(search_Port, i);
	    							waitForElement(driver, searchPorts);
	    							click(driver, searchPorts);
	    						}else {
	    							
	    							String searchPorts=String.format(search_Port, noOfPorts);
	    							waitForElement(driver, searchPorts);
	    							click(driver, searchPorts);
	    						}
	    						
	    			//		Port search
	    						
	    						twoColumnSearchWindow(driver, port_Search_Header, condition, port);

	    						waitForDisplay(driver, marineDistance_Frame);
	    						if(isdisplayed(driver, marineDistance_Frame)) {
	    							waitForElement(driver, marineDistance_Ok_Button);
	    							click(driver, marineDistance_Ok_Button);
	    							}
//	    		Terminal search
	    						
	    						waitForElement(driver, SaveButton_ToolBar);
	    					
	    							if(i==2) {
	    								String terminalSearch=String.format(terminal_Search,i);
	    								waitForElement(driver, terminalSearch);
	    								click(driver, terminalSearch);
	    							}else {
	    								String terminalSearch=String.format(terminal_Search,noOfPorts);
	    								waitForElement(driver, terminalSearch);
	    								click(driver, terminalSearch);
	    							}
	    							
	    					
	    							twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminal);
	    							
	    					}
	    					
	    				Step_End(9, "System should not allow to save the record, if the first row and last row have the same port and terminal", test, test1);
//	    		Change status to confirm
	    				Step_Start(10, "Change status to confirm", test, test1);
	    				
	    				waitForElement(driver, status_Dropdown_SPF);
	    				click(driver,status_Dropdown_SPF);
	    				
	    				select_Status=String.format(DropDown_Select,confirmStatus);
	    				
	    				waitForElement(driver, select_Status);
	    				click(driver, select_Status);
	    				
	    				
	    				Step_End(10, "Change status to confirm", test, test1);

	    				waitForElement(driver, SaveButton_ToolBar);
	    				click(driver,SaveButton_ToolBar);
	    				
	    				waitForPopup(driver, popup_Message, firstAndLastPortSame);

	    				String actualPopup6 = getText(driver, popup_Message);

	    				if (actualPopup6.equals(firstAndLastPortSame)) {
	    					Extent_pass_New(driver, "Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6, test,test1);
	    					System.out.println("Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6);
	    					click(driver, popup_Message_Ok_Button);
	    				}else {
	    					System.out.println("Not Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup :"+actualPopup6);

	    					Extent_fail(driver, "Not Matched || Expected popup :"+firstAndLastPortSame+" || Actual popup:"+actualPopup6, test,test1);
	    				}
	    				Extent_completed(tc_name, test, test1);	
					scrollTop(driver);

					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
			
			
		}
		
		int d=4;
		if(d==4) {
			String tc_name="TC_Proforma_Service_Creation_PC04";


			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC04 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC04, tc_name, "Dataset"+selected_dataset, File_Path);	
			       
			
	        String ModuleSearch = data.get("Module_Search");
	        String noOfTimeAdd = data.get("NoOfPortsAdd");
	        String portCodeEdit = data.get("PortCodeEdit");
	        String bufferTimeEdit = data.get("BufferTimeEdit");
	        String boundEdit = data.get("BoundEdit");
	        String timeZoneEdit = data.get("TimeZoneEdit");
	        String addRowPortCode = data.get("AddRowPortCode");
	        String terminalCodeEdit = data.get("TerminalCodeEdit");
	        String remarks = data.get("Remarks");
	        String proformaSavedPopup = data.get("ProformaSavedPopup");
	        String status = data.get("ProformaStatus");
	        String type = data.get("ProformaType");
	        String capacity = data.get("Capacity");     
	        String startDate = data.get("StartDate");
	        String quickProformaStartDate = data.get("QuickProformaStartDate");
	        String defaultSpeed = data.get("DefaultSpeed");
	        String defaultTerminalTime = data.get("DefaultTerminalTime");
	        String defaultTimeZone = data.get("DefaultTimeZone");
	        String defaultDistance = data.get("DefaultDistance");
	        String defaultBufferTime = data.get("DefaultBufferTime");
	        String date_Picker = data.get("DatePicker");
	        String QuickProforma_Panel = data.get("QuickProforma_Panel");
	        String Service_Filter_Data = data.get("Service_Filter_Data");
	        
	        String condition = data.get("Condition");
			String service_Search_Header = data.get("Service_Search_Header");
			String terminalCode_Search_Header = data.get("TerminalCode_Search_Header");


			Extent_Start(tc_name, test, test1);

	        
			
		     moduleNavigate(driver, ModuleSearch);
		        
//		 	Proforma service creation	
		 		
		 		
		 		Step_Start(1, "Click on the new button ", test, test1);

		 		newButton(driver);
		 		Step_End(1, "Click on the new button", test, test1);
		 	
		 		waitForElement(driver, service_Search_Icon_Psc);
		 		click(driver, service_Search_Icon_Psc);
		 		
		 		twoColumnSearchWindow(driver, service_Search_Header, condition, Service_Filter_Data);

		 		waitForElement(driver, remark_field);
		 		click(driver, remark_field);
		 		waitForElement(driver, remark_field);
		 		sendKeys(driver, remark_field, remarks);

		 		 waitForDisplay(driver, Proforma_Temp_Remove);
		 			if(isdisplayed(driver, Proforma_Temp_Remove)){
		 				waitForElement(driver, Proforma_Temp_Remove);
		 				click(driver, Proforma_Temp_Remove);
		 			}
		 		waitForElement(driver, proforma_Date);

		 		if(date_Picker.equalsIgnoreCase("Yes")) {
		 			
		 			selectDatePickerWithTime_Proforma(driver, proforma_Date, startDate);

		 		}else {
		 			if(startDate.contains("-")) {
		 				String startDate1=startDate.replace("-", "/");

		 				waitForElement(driver, proforma_Date);

		 				clearAndType(driver, proforma_Date, startDate1);
		 				waitForElement(driver, calenderclosebutton_SPF);
		 				click(driver, calenderclosebutton_SPF);
		 			}else {
		 				waitForElement(driver, proforma_Date);
		 				clearAndType(driver, proforma_Date, startDate);	
		 				waitForElement(driver, calenderclosebutton_SPF);
		 				click(driver, calenderclosebutton_SPF);

		 				}
		 		}

//		 		Non mandatory fields
		 		
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
		 		
		 	
//		 	Quick proforma
		 		Step_Start(2, "Click on Quick proforma button", test, test1);
		 		waitForElement(driver, quickproforma);
		 	    click(driver,quickproforma);
		 	    Step_End(2, "Click on Quick proforma button", test, test1);
		 	    if(!quickProformaStartDate.equals("")) {
		 	    	waitForElement(driver, quickProforma_StartDate);

		 			if(date_Picker.equalsIgnoreCase("Yes")) {
		 				
		 				selectDatePickerWithTime(driver, quickProforma_StartDate, quickProformaStartDate);

		 				}else {
		 				if(quickProformaStartDate.contains("-")) {
		 					String quickProformaStartDate1=quickProformaStartDate.replace("-", "/");
		 					waitForElement(driver, quickProforma_StartDate);
		 					clearAndType(driver, quickProforma_StartDate, quickProformaStartDate1);
		 					waitForElement(driver, calenderclosebutton_SPF);
		 					click(driver, calenderclosebutton_SPF);
		 			
		 					}else {
		 					waitForElement(driver, quickProforma_StartDate);
		 					clearAndType(driver, quickProforma_StartDate, quickProformaStartDate);	
		 					waitForElement(driver, calenderclosebutton_SPF);
		 					click(driver, calenderclosebutton_SPF);

		 					}
		 			}
		 	    }

//		 	   Non mandatory fields
		 	    
		 	    if(!defaultSpeed.equals("")) {
		 	    	waitForElement(driver, defaultSpeed_Textfield);
		 	    	click(driver, defaultSpeed_Textfield);
		 	    	waitForElement(driver, defaultSpeed_Textfield);
		 	    	clearAndType(driver, defaultSpeed_Textfield, defaultSpeed);
		 	    	
		 	    }
		 	    if(!defaultTerminalTime.equals("")) {
		 	    	waitForElement(driver, defaultTerminalTime_Textfield);
		 	    	click(driver, defaultTerminalTime_Textfield);
		 	    	waitForElement(driver, defaultTerminalTime_Textfield);
		 	    	clearAndType(driver, defaultTerminalTime_Textfield, defaultTerminalTime);
		 	    	
		 	    }
		 	    
		 	    if(!defaultTimeZone.equals("")) {
		 	    	waitForElement(driver, defaultTimeZone_Textfield);
		 	    	click(driver, defaultTimeZone_Textfield);
		 	    	waitForElement(driver, defaultTimeZone_Textfield);
		 	    	clearAndType(driver, defaultTimeZone_Textfield, defaultTimeZone);
		 	    	
		 	    }
		 	    
		 	    if(!defaultDistance.equals("")) {
		 	    	waitForElement(driver, defaultDistance_Textfield);
		 	    	click(driver, defaultDistance_Textfield);
		 	    	waitForElement(driver, defaultDistance_Textfield);
		 	    	clearAndType(driver, defaultDistance_Textfield, defaultDistance);
		 	    	
		 	    } 
		 	    
		 	    if(!defaultBufferTime.equals("")) {
		 	    	waitForElement(driver, defaultBufferTime_Textfield);
		 	    	click(driver, defaultBufferTime_Textfield);
		 	    	waitForElement(driver, defaultBufferTime_Textfield);
		 	    	clearAndType(driver, defaultBufferTime_Textfield, defaultBufferTime);
		 	    	
		 	    } 
		 	    
		     	waitForElement(driver, add_Button);
		 	    click(driver, add_Button);
		 	
//		 	   Add Multiple ports in grid & Edit
		 	    Step_Start(3, "Enter the Port Code in the Port COde field", test, test1);
		 	    int j=Integer.parseInt(noOfTimeAdd);
		 	    for(int i=1;i<=j;i++) {
	 		    	waitForElement(driver, quickproforma_portcode);

		 			 String portCode = data.get("PortCode"+i);
		 			 
		 		    	waitForElement(driver, quickproforma_portcode);
		 		    	sendKeys(driver, quickproforma_portcode, portCode);
		 		    	
		 		    	waitForElement(driver, port_Code_Panel);
		 				click(driver, port_Code_Panel);		
		 				
		 		    	waitForElement(driver, quickproforma_portcode);
		 		    	clear(driver, quickproforma_portcode);
		 		    	
		 			 Extent_call(test, test1, "Repeat sending the portcodes & click enter until the required ports for the voyage is added");
		 	    	
		 	    }
		 	   Step_End(3, "Enter the Port Code in the Port COde field", test, test1);
		 	    
		 	    Step_Start(4, "To Edit an exisitng added row, Double click the row and edit the port code ", test, test1);

		     	waitForElement(driver, editRow);
		     	waitForElement(driver, editRow);
		 	    click(driver, editRow);
		     	waitForElement(driver, editRow);
		 	    doubleClick(driver, editRow);	
		 	    
		     	waitForElement(driver, quickproforma_portcode);
		 	    clear(driver,quickproforma_portcode);
		     	waitForElement(driver, quickproforma_portcode);
		 	    sendKeys(driver, quickproforma_portcode, portCodeEdit);
		     	waitForElement(driver, quickproforma_portcode);
		     	waitForElement(driver, port_Code_Panel);
		 		click(driver, port_Code_Panel);
		 		
		 	    
		     	waitForElement(driver, bufferTime_Row);
		 	    String updatedPortcode =String.format(updated_Portcode, portCodeEdit);
		 	    String updated_Portcode1 = getText(driver, updatedPortcode);
		 	    System.out.println("updated_Portcode:"+updated_Portcode1);
		    
		 	   Step_End(4, "To Edit an exisitng added row, Double click the row and edit the port code ", test, test1);
		 	   
		 	   Step_Start(5, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit & clicking the terminal search icon", test, test1);
		 	   
		 	   click(driver,bufferTime_Row);
		    		waitForElement(driver, bufferTimeEdit_Row);
		 	   click(driver,bufferTimeEdit_Row);
		   		waitForElement(driver, bufferTimeEdit_Row);
		 	   clearAndType(driver, bufferTimeEdit_Row, bufferTimeEdit);
		 	  
		 	   waitForElement(driver, timeZone_Row);
		 	   click(driver,timeZone_Row);
		 	   waitForElement(driver, timeZoneEdit_Row);
		 	   click(driver,timeZoneEdit_Row);
		 	   waitForElement(driver, timeZoneEdit_Row);
		 	   clearAndType(driver, timeZoneEdit_Row, timeZoneEdit);

		 	   waitForElement(driver, bufferTime_Row);
		 		click(driver,bufferTime_Row);
		 	    waitForElement(driver, terminalCode_Row);
		 		click(driver, terminalCode_Row);
		 		
		 		twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);

		 		waitForElement(driver, bound_Row);
		 	   click(driver, bound_Row);
		 	   
		 	   String bound_EditOption = String.format(boundEditOption, boundEdit);
		 		waitForElement(driver, bound_EditOption);
		 		click(driver, bound_EditOption);
		 		
		 	   Step_End(5, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit &  clicking the terminal search icon", test, test1);
		 	   
		 	   Step_Start(6, "Click on Move up  Move down button to change the position of port code", test, test1);
		 		waitForElement(driver, moveUp_Row);
		 	   click(driver, moveUp_Row);
		 		waitForElement(driver, moveDown_Row);
		 	   Extent_pass_New(driver, "The row has moved up", test, test1);
		 	   
		 	   click(driver, moveDown_Row);
		 	   Extent_pass_New(driver, "The row has moved down", test, test1);

		 	   Step_End(6, "Click on Move up Move down button to change the position of port code", test, test1);
		 	   
		 	   Step_Start(7, "To add a port between port, click on the port row single time ,and enter the port code should add new row with the given port code ", test, test1);
		 		waitForElement(driver, editRow);
		 	   click(driver, editRow);	
		 	    
		 		waitForElement(driver, quickproforma_portcode);
		 	    clear(driver,quickproforma_portcode);
		 	    Extent_call(test, test1, "Sending the portcode and then click enter");
		 		waitForElement(driver, quickproforma_portcode);
		 	    sendKeys(driver, quickproforma_portcode, addRowPortCode);
		 	    
		 	    String portcodePanel=String.format(portcode_Panel,QuickProforma_Panel);
		 	    
		 	    waitForElement(driver, portcodePanel);
		 	    click(driver, portcodePanel);
		 	    

		 		waitForElement(driver, addedRowPortCode);
		 		
		 		System.out.println("addedRowPortCode: "+ getText(driver, addedRowPortCode));
		 	 Step_End(7, "To add a port between port, click on the port row single time ,and enter the port code should add new row with the given port code ", test, test1);
		 	   Extent_pass_New(driver, "Rows in Quick proforma", test, test1);
		 	 
//		 	  No of ports in Quick proforma 
		 	   
		 	   ArrayList<String> qproPorts=new ArrayList<String>();
		 	   
		 		   List <WebElement>  quickProforma_Rows= listOfElements(driver, quickProformaRows);
		 		   int size=quickProforma_Rows.size();
		    System.out.println("size of rows is:"+size);
		 		   for(int i=1;i<size;i+=2) {
		 			   String qp_Port=String.format(qpPort, i);
		 			   String qpPort_List = getText(driver, qp_Port);//need to verify this
		 			   qproPorts.add(qpPort_List);
		 		 
		 		   }
		 	   	   
		 	   waitForElement(driver, quickProforma_Ok_Button);
		 	   click(driver, quickProforma_Ok_Button);

		 //  No of ports in  proforma 

		 	   waitForElement(driver, SaveButton_ToolBar);
		 	   ArrayList<String> proPorts=new ArrayList<String>();
		 		    List<WebElement> proforma_Rows = listOfElements(driver, proformaRows);
		 		   
		 		   for(WebElement quickProformaList:proforma_Rows) {
				 	   waitForElement(driver, proformaRows);
		 			   String proPortsList=quickProformaList.getText();
		 			   proPorts.add(proPortsList);  
		 			   
		 		   }
		 	   if(proPorts.equals(qproPorts)) {
		 		   Extent_pass_New(driver, "Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
		 		   System.out.println("Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
		 	   }else {
		 		   System.out.println("Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

		 		   Extent_fail(driver, "Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
		 	   }
		 	   
//		 	Verify the proforma service creation popup
		 	   
		 	   click(driver,SaveButton_ToolBar);
		 		
		 		waitForPopup(driver, popup_Message, proformaSavedPopup);

		 		String actualUpdatedPopup = getText(driver, popup_Message);

		 		if (actualUpdatedPopup.equals(proformaSavedPopup)) {
		 			Extent_pass_New(driver, "Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
		 			System.out.println("Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup);
		 			click(driver, popup_Message_Ok_Button);
		 		}else {
		 			System.out.println("Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup);

		 			Extent_fail(driver, "Not Matched || Expected popup :"+proformaSavedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
		 		}
					Extent_completed(tc_name, test, test1);
					scrollTop(driver);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
			
		}
		int n=5;
		
		if(n==5) {
			String tc_name="TC_Proforma_Service_Creation_PC05";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC05 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC05, tc_name, "Dataset"+selected_dataset, File_Path);	
			
	        String ModuleSearch = data.get("Module_Search");
	        String noOfTimeAdd = data.get("NoOfPortsAdd");
	        String proformaCode = data.get("ProformaCode");
	        String portCodeEdit = data.get("PortCodeEdit");
	        String bufferTimeEdit = data.get("BufferTimeEdit");
	        String boundEdit = data.get("BoundEdit");
	        String timeZoneEdit = data.get("TimeZoneEdit");
	        String addRowPortCode = data.get("AddRowPortCode");
	        String terminalCodeEdit = data.get("TerminalCodeEdit");
	        String dropdownCondition = data.get("DropdownCondition");
	        String globalSearchValueType = data.get("GlobalSearchValueType");
			String condition = data.get("Condition");
			String terminalCode_Search_Header = data.get("TerminalCode_Search_Header");

			Extent_Start(tc_name, test, test1);

			
			  moduleNavigate(driver, ModuleSearch);
		  		
//				Proforma service creation	

			// Global search

					Step_Start(1, "Click on Global search icon", test, test1);


					waitForElement(driver, SearchButton_Toolbar);
			        click(driver,SearchButton_Toolbar);
			        
					Step_End(1, "Click on Global search icon", test, test1);
					
					globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");


//				Edit Quick proforma

					scrollTop(driver);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					
					Step_Start(3, "Click on Quick proforma button", test, test1);
					 waitForDisplay(driver, Proforma_Temp_Remove);
						if(isdisplayed(driver, Proforma_Temp_Remove)){
							waitForElement(driver, Proforma_Temp_Remove);
							click(driver, Proforma_Temp_Remove);
						}
					waitForElement(driver, quickproforma);
					click(driver, quickproforma);
					Step_End(3, "Click on Quick proforma button", test, test1);
//				Add Multiple ports in grid

					Step_Start(4, "Enter the Port Code in the Port Code field", test, test1);
					int j = Integer.parseInt(noOfTimeAdd);
					for (int i = 1; i <= j; i++) {
						String portCode = data.get("PortCode" + i);

						waitForElement(driver, quickproforma_portcode);
						sendKeys(driver, quickproforma_portcode, portCode);
						Step_End(4, "Enter the Port Code in the Port Code field", test, test1);

						Step_Start(5, "Click on enter should add the value to below grid", test, test1);

						waitForElement(driver, port_Code_Panel);
						click(driver, port_Code_Panel);
						
						waitForElement(driver, quickproforma_portcode);
		 		    	clear(driver, quickproforma_portcode);
		 		    	
						Extent_pass_New(driver, portCode + " Port has added", test, test1);
						Step_End(5, "Click on enter should add the value to below grid", test, test1);
					}

					Step_Start(6, "To Edit an existing added row, Double click the row and edit the port code", test, test1);
					waitForElement(driver, editRow1);
					click(driver, editRow1);
					waitForElement(driver, editRow1);
					doubleClick(driver, editRow1);

					waitForElement(driver, quickproforma_portcode);
					clear(driver, quickproforma_portcode);
					waitForElement(driver, quickproforma_portcode);
					sendKeys(driver, quickproforma_portcode, portCodeEdit);
					waitForElement(driver, quickproforma_portcode);

					waitForElement(driver, port_Code_Panel);
					click(driver, port_Code_Panel);
					
					Step_End(6, "To Edit an existing added row, Double click the row and edit the port code", test, test1);
					waitForElement(driver, bufferTime_Row);
					String updatedPortcode5 = String.format(updated_Portcode, portCodeEdit);

					String updated_Portcode =getText(driver, updatedPortcode5);
					System.out.println("updated_Portcode:" + updated_Portcode);

					Step_Start(7, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit", test, test1);
					waitForElement(driver, bufferTime_Row);
					click(driver, bufferTime_Row);
					waitForElement(driver, bufferTimeEdit_Row);
					click(driver, bufferTimeEdit_Row);
					waitForElement(driver, bufferTimeEdit_Row);
					clearAndType(driver, bufferTimeEdit_Row, bufferTimeEdit);

					waitForElement(driver, timeZone_Row);
					click(driver, timeZone_Row);
					waitForElement(driver, timeZoneEdit_Row);
					click(driver, timeZoneEdit_Row);
					waitForElement(driver, timeZoneEdit_Row);
					clearAndType(driver, timeZoneEdit_Row, timeZoneEdit);

					waitForElement(driver, bound_Row);
					click(driver, bound_Row);
					String bound_EditOption = String.format(boundEditOption, boundEdit);
					waitForElement(driver, bound_EditOption);
					click(driver, bound_EditOption);
					
					Step_End(7, "Click on the fields such as , Time zone, Buffer Time , Bound to Edit", test, test1);
					Step_Start(8, "Click on Move up / Move down button to change the position of port code ", test, test1);
					waitForElement(driver, moveUp_Row);
					click(driver, moveUp_Row);
					waitForElement(driver, moveUp_Row);
					Extent_pass_New(driver, "The row has moved up", test, test1);

					waitForElement(driver, moveDown_Row);
					click(driver, moveDown_Row);
					waitForElement(driver, moveDown_Row);
					Extent_pass_New(driver, "The row has moved down", test, test1);

					Step_End(8, "Click on Move up / Move down button to change the position of port code ", test, test1);
					waitForElement(driver, editRow1);
					click(driver, editRow1);

					waitForElement(driver, quickproforma_portcode);
					clear(driver, quickproforma_portcode);
					waitForElement(driver, quickproforma_portcode);
					sendKeys(driver, quickproforma_portcode, addRowPortCode);
					waitForElement(driver, quickproforma_portcode);
					waitForElement(driver, port_Code_Panel);
					click(driver, port_Code_Panel);
					
					waitForElement(driver, terminalCode_Row);
					click(driver, terminalCode_Row);
					Step_Start(9, "Click on Terminal Search icon to change the Terminal of the port", test, test1);
					
					twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);
					
					Step_End(9, "Click on Terminal Search icon to change the Terminal of the port", test, test1);

					waitForElement(driver, terminalCode_Row);
					 String addedRowPortCode_New = getText(driver, addedRowPortCode5);
					
					System.out.println("addedRowPortCode: " +  addedRowPortCode_New);

					waitForElement(driver, terminalCode_Row);
					Extent_pass_New(driver, "Rows in Quick proforma", test, test1);

//				No of ports in Quick proforma 

					ArrayList<String> qproPorts = new ArrayList<String>();
						
						List<WebElement> quickProformaRows_New = listOfElements(driver, quickProformaRows);
						
						int size = quickProformaRows_New.size();

						for (int i = 1; i < size; i += 2) {
							
							String qport_New = getText(driver, String.format(qpPort, i));
							qproPorts.add(qport_New);
						}

					Step_Start(12, "Click on ok ", test, test1);
					waitForElement(driver, quickProforma_Ok_Button);
					click(driver, quickProforma_Ok_Button);
					Step_End(12, "Click on ok ", test, test1);
			//  No of ports in Quick proforma 
					Step_Start(13, "Now the data added to the grid in the outer menu ", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					ArrayList<String> proPorts = new ArrayList<String>();
					

						List<WebElement> proformaRows = listOfElements(driver, proformaRows5);
						
						for (WebElement quickProformaList : proformaRows) {
							waitForElement(driver, proformaRows5);
							String proPortsList = quickProformaList.getText();
							proPorts.add(proPortsList);

						}
					


				   if(proPorts.equals(qproPorts)) {
					   Extent_pass_New(driver, "Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
					   System.out.println("Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
				   }else {
					   System.out.println("Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

					   Extent_fail(driver, "Not Matched || Ports in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
				   }
				   
				   Step_End(13, "Now the data added to the grid in the outer menu ", test, test1);
					Extent_completed(tc_name, test, test1);
					scrollTop(driver);

			   waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				Extent_completed(tc_name, test, test1);
			
			
		}
		
		int f=6;
		
		if(f==6) {
			String tc_name="TC_Proforma_Service_Creation_PC06";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC06 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC06, tc_name, "Dataset"+selected_dataset, File_Path);
			

	        String ModuleSearch = data.get("Module_Search");
	        String excelFilePath = data.get("ExcelFilePath");
	        String remarks = data.get("Remarks");
	        String rowNumberToRemove = data.get("RowNumberToRemove");
	        String Service_Filter_Data = data.get("Service_Filter_Data");
	        String condition = data.get("Condition");
			String service_Search_Header = data.get("Service_Search_Header");
			
	        Extent_Start(tc_name, test, test1);

			
	    	moduleNavigate(driver, ModuleSearch);
			
//	    	Proforma service creation	
	    		
	    		Step_Start(1, "Click on new button ", test, test1);

	    		newButton(driver);
	    		
	    		Step_End(1, "Click on new button ", test, test1);

	    		waitForElement(driver, service_Search_Icon_Psc);
	    		click(driver, service_Search_Icon_Psc);
	    		
	    		twoColumnSearchWindow(driver, service_Search_Header, condition, Service_Filter_Data);

	    		waitForElement(driver, remark_field);
	    		click(driver, remark_field);
	    		waitForElement(driver, remark_field);
	    		sendKeys(driver, remark_field, remarks);
	    		
//	    	Import From Excel
	    		
	    		Step_Start(2, "CLick on Import Excel Icon", test, test1);
	    		 waitForDisplay(driver, Proforma_Temp_Remove);
	    			if(isdisplayed(driver, Proforma_Temp_Remove)){
	    				waitForElement(driver, Proforma_Temp_Remove);
	    				click(driver, Proforma_Temp_Remove);
	    			}
	    		
	    		waitForElement(driver, Importexcelbtn);
	    		click(driver, Importexcelbtn);
	    		Step_End(2, "CLick on Import Excel Icon", test, test1);
	    		waitForElement(driver, Importexcelbtn);

	    		Step_Start(3, "Upload the Required file ", test, test1);
	    		
	    		waitForElement(driver, Loadexcelfile);
	    		
	    		uploadfile1(driver,PC_Upload_Excel,excelFilePath);
	    		
	    		waitForDisplay(driver, excelDetails_Table);
	    		if(isdisplayed(driver,excelDetails_Table)) {
	    			Extent_pass_New(driver, "Passed || Expected : Excel file should be uploaded || Actual : Excel file is uploaded", test, test1);
	    			System.out.println("Passed || Expected : Excel file should be uploaded || Actual : Excel file is uploaded");
	    		}else {
	    			System.out.println("Failed || Expected : Excel file should be uploaded || Actual : Excel file is not uploaded");

	    			Extent_fail(driver, "Failed || Expected : Excel file should be uploaded || Actual : Excel file is not uploaded", test, test1);
	    		}
	    		Step_End(3, "Upload the Required file ", test, test1);
	    		
//	    	Remove unwanted rows
	    		
	    Step_Start(4, "Remove the unwanted rows if needed ", test, test1);

	    //  Before remove
	    		int beforeCount=0;
	    		
	    		 List<WebElement> beforeRemove = listOfElements(driver, beforeAndAfterRemove);
	    			
	    			beforeCount=beforeRemove.size();
	    		
	    			String select_Row=String.format(select_Row_ImportExcel_SPF,rowNumberToRemove);
	    			
	    		scrollUsingElement(driver, select_Row);
	    		
	    		waitForElement(driver, select_Row);		
	    		click(driver, select_Row);

	    		waitForElement(driver, Loadexcelfileremovecoloum);
	    		mouseOverToElement(driver, Loadexcelfileremovecoloum);
	    		waitForElement(driver, Loadexcelfileremovecoloum);
	    		click(driver, Loadexcelfileremovecoloum);
	    	//  After remove
	    	
	    		waitForElement(driver, beforeAndAfterRemove);		
	    		int afterCount=0;
	    		
	    			List<WebElement> afterRemove = listOfElements(driver, beforeAndAfterRemove);
	    		
	    		afterCount=afterRemove.size();
	    		
	    		
	    		if (afterCount!=beforeCount) {
	    			System.out.println("Not Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount);
	    			Extent_pass_New(driver, "Not Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount, test, test1);
	    			Extent_pass_New(driver, "The selected row was removed", test,test1);
	    			System.out.println("The selected row was removed");
	    		} else {
	    			System.out.println("Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount);
	    			Extent_fail(driver, "Matched || Number Of Rows Before Remove : "+beforeCount+" || Number Of Rows After Remove : "+afterCount, test, test1);
	    			
	    		}
	    		
	    		
	    Step_End(4, "Remove the unwanted rows if needed ", test, test1);

//	    	No of ports in Import from excel tab 

	    		
	    		ArrayList<String> impPorts=new ArrayList<String>();
	    		
	    			List<WebElement> xlRow_List = listOfElements(driver, xlRow);
	    			for(WebElement xlPorts:xlRow_List ) {
	    				 
	    				String xlImpPorts=xlPorts.getText();
	    				impPorts.add(xlImpPorts);
	    			}
	    			
	    		Step_Start(5, "Click on ok button", test, test1);
	    		
	    		scrollTop(driver);
	    		waitForElement(driver, Loadexcelfileselect1ok);
	    		click(driver, Loadexcelfileselect1ok);
	    		Step_End(5, "Click on ok button", test, test1);

//	    	No of ports in proforma 		
	    		Step_Start(6, "Now the Excel Data will be added in the main grid", test, test1);
	    		waitForElement(driver, NewButton_ToolBar);
	    		   ArrayList<String> proPorts=new ArrayList<String>();
	    		   
	    			   List<WebElement> proformaRows_List = listOfElements(driver, proformaRows);
	    			   for(WebElement quickProformaList:proformaRows_List) {
	    				   
	    				   String proPortsList=quickProformaList.getText();
	    				   proPorts.add(proPortsList);  
	    				   
	    			   }		   

	    		   if(proPorts.equals(impPorts)) {
	    			   Extent_pass_New(driver, "Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
	    			   System.out.println("Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts);
	    		   }else {
	    			   System.out.println("Not Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts);

	    			   Extent_fail(driver, "Not Matched || Ports in Import From Excel grid : "+impPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
	    		   }
	    		   
	    		   Step_End(6, "Now the Excel Data will be added in the main grid", test, test1);
				scrollTop(driver);

				   waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
					Extent_completed(tc_name, test, test1);
			
		}
		
		int g=7;
		
		if(g==7){

			String tc_name="TC_Proforma_Service_Creation_PC07";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC07 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC07, tc_name, "Dataset"+selected_dataset, File_Path);		
			
			
	       
	        String ModuleSearch = data.get("Module_Search");
	        String service_Code = data.get("Service_Code");
	        String noOfTimeAdd = data.get("NoOfPortsAdd");
	        String proformaCode = data.get("ProformaCode");
	        String portCodeEdit = data.get("PortCodeEdit");
	        String bufferTimeEdit = data.get("BufferTimeEdit");
	        String boundEdit = data.get("BoundEdit");
	        String timeZoneEdit = data.get("TimeZoneEdit");
	        String addRowPortCode = data.get("AddRowPortCode");
			String terminalCodeEdit = data.get("TerminalCodeEdit");
			String remarks = data.get("Remarks");
			String proformaSavedPopup = data.get("ProformaSavedPopup");
			String condition = data.get("Condition");
			String service_Search_Header = data.get("Service_Search_Header");
			String proformaCode_Search_Header = data.get("ProformaCode_Search_Header");
			String terminalCode_Search_Header = data.get("TerminalCode_Search_Header");

			Extent_Start(tc_name, test, test1);

			
			moduleNavigate(driver, ModuleSearch);
			
//			Proforma service creation	
				
				Step_Start(1, "Click on new button ", test, test1);
				newButton(driver);
				
				Step_End(1, "Click on new button ", test, test1);
				

				waitForElement(driver, service_Search_Icon_Psc);
				click(driver, service_Search_Icon_Psc);
				
				twoColumnSearchWindow(driver, service_Search_Header, condition, service_Code);
				
				waitForElement(driver, remark_field);
				click(driver, remark_field);
				waitForElement(driver, remark_field);
				sendKeys(driver, remark_field, remarks);

		//  Quick Proforma
				
				Step_Start(2, ".Click on Quick Proforma", test, test1);
				
				waitForElement(driver, quickproforma);
			    click(driver,quickproforma);
			    Step_End(2, ".Click on Quick Proforma", test, test1);
				
				Step_Start(3, "Click on Import proforma ", test, test1);
				
				waitForDisplay(driver, Importproforma_Button);
				if(isdisplayed(driver,Importproforma_Button)) {
					Extent_pass_New(driver, "Passed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is opened", test, test1);
					System.out.println("Passed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is opened");
				}else {
					System.out.println("Failed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is not opened");

					Extent_fail(driver, "Failed || Expected : Quick profoma page should be opened || Actual : Quick profoma page is not opened", test, test1);
				}
				
				 waitForDisplay(driver, Proforma_Temp_Remove);
					if(isdisplayed(driver, Proforma_Temp_Remove)){
						waitForElement(driver, Proforma_Temp_Remove);
						click(driver, Proforma_Temp_Remove);
					}
				
				waitForElement(driver, Importproforma_Button);
				click(driver, Importproforma_Button);
				Step_End(3, "Click on Import proforma ", test, test1);
		//  Import Proforma tab		

//			Search by Proforma code
				Step_Start(4, "Choose any existing proforma rotation which has to be replicated again", test, test1);
				
				twoColumnSearchWindow(driver, proformaCode_Search_Header, condition, proformaCode);

			    Step_End(4, "Choose any existing proforma rotation which has to be replicated again", test, test1);
				
//			Add Multiple Port codes
				   Step_Start(5, "Edit the data if needed ", test, test1);

				 int j=Integer.parseInt(noOfTimeAdd);
				    for(int i=1;i<=j;i++) {
		 		    	waitForElement(driver, quickproforma_portcode);

						String portCode = data.get("PortCode" + i);

						waitForElement(driver, quickproforma_portcode);
						sendKeys(driver, quickproforma_portcode, portCode);
						waitForElement(driver, quickproforma_portcode);

						waitForElement(driver, port_Code_Panel);
						click(driver, port_Code_Panel);

						waitForElement(driver, quickproforma_portcode);
		 		    	clear(driver, quickproforma_portcode);
				    }
				   
//			Edit Rows	    
					waitForElement(driver, editRow1);
					waitForElement(driver, editRow1);

					click(driver, editRow1);
					waitForElement(driver, editRow1);
					doubleClick(driver, editRow1);

					waitForElement(driver, quickproforma_portcode);
					clear(driver, quickproforma_portcode);
					waitForElement(driver, quickproforma_portcode);
					sendKeys(driver, quickproforma_portcode, portCodeEdit);
					waitForElement(driver, quickproforma_portcode);

			    	waitForElement(driver, port_Code_Panel);
					click(driver, port_Code_Panel);

					waitForElement(driver, bufferTime_Row);
					String updatedPortcode5 = String.format(updated_Portcode, portCodeEdit);
					
					String updated_Portcode_New = getText(driver, updatedPortcode5);
					System.out.println("updated_Portcode:" + updated_Portcode_New);

					waitForElement(driver, bufferTime_Row);
					click(driver, bufferTime_Row);
					waitForElement(driver, bufferTimeEdit_Row);
					click(driver, bufferTimeEdit_Row);
					waitForElement(driver, bufferTimeEdit_Row);
					clearAndType(driver, bufferTimeEdit_Row, bufferTimeEdit);

					waitForElement(driver, timeZone_Row);
					click(driver, timeZone_Row);
					waitForElement(driver, timeZoneEdit_Row);
					click(driver, timeZoneEdit_Row);
					waitForElement(driver, timeZoneEdit_Row);
					clearAndType(driver, timeZoneEdit_Row, timeZoneEdit);

					waitForElement(driver, bound_Row);
					click(driver, bound_Row);
					
					String bound_EditOption = String.format(boundEditOption, boundEdit);
					waitForElement(driver, bound_EditOption);
					click(driver, bound_EditOption);

					waitForElement(driver, terminalCode_Row1);
					click(driver, terminalCode_Row1);
					
					twoColumnSearchWindow(driver, terminalCode_Search_Header, condition, terminalCodeEdit);

					waitForElement(driver, moveUp_Row);
					click(driver, moveUp_Row);
					waitForElement(driver, moveUp_Row);
					Extent_pass_New(driver, "The row has moved up", test, test1);

					waitForElement(driver, moveDown_Row);
					click(driver, moveDown_Row);
					waitForElement(driver, moveDown_Row);
					Extent_pass_New(driver, "The row has moved down", test, test1);

				   waitForElement(driver, editRow1);
				   click(driver, editRow1);	
				    
					waitForElement(driver,  quickproforma_portcode);
				    clear(driver,quickproforma_portcode);
					waitForElement(driver,  quickproforma_portcode);
				    sendKeys(driver, quickproforma_portcode, addRowPortCode);
				    waitForElement(driver,  quickproforma_portcode);
				    waitForElement(driver, port_Code_Panel);
				    click(driver, port_Code_Panel);
				    
				   waitForElement(driver, addedRowPortCode);
				   doubleClick(driver, addedRowPortCode);
				   Extent_pass_New(driver, "Rows in Quick proforma", test, test1);

//			Port codes in Quick proforma 
				   waitForElement(driver, quickProforma_Ok_Button);

				   ArrayList<String> qproPorts=new ArrayList<String>();
				   
				   
					   List <WebElement>  quickProforma_Rows= listOfElements(driver, quickProformaRows);
					   int size=quickProforma_Rows.size();
			   
					   for(int i=1;i<size;i+=2) {
						  String qport_List=String.format(qpPort, i);
						  waitForElement(driver, qport_List);
						   String qport_New_list = getText(driver, qport_List);
						   qproPorts.add(qport_New_list);
					   }
					   
				  
				   Step_End(5, "Edit the data if needed ", test, test1);
				   
				  // System.out.println("qproPorts:"+qproPorts);
				   	   Step_Start(6, "Click on ok", test, test1);
				   	   
				   waitForElement(driver, quickProforma_Ok_Button);
				   click(driver, quickProforma_Ok_Button);
				   
			Step_End(6, "Click on ok", test, test1);
//			Port codes in Proforma
				   Step_Start(7, "Now the data should be added to the maingrid", test, test1);
				   
				   waitForElement(driver, SaveButton_ToolBar);
				   ArrayList<String> proPorts=new ArrayList<String>();
				   
					   List<WebElement> proformarows_List = listOfElements(driver, proformaRows);
					   
					   for(WebElement quickProformaList:proformarows_List) {
						   waitForElement(driver, proformaRows);

						   String proPortsList=quickProformaList.getText();
						   proPorts.add(proPortsList);  
						   
					   }		   

				   if(proPorts.equals(qproPorts)) {
					   Extent_pass_New(driver, "Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
					   System.out.println("Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);
				   }else {
					   System.out.println("Not Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts);

					   Extent_fail(driver, "Not Matched || Port Codes in QuickProforma grid : "+qproPorts +" || Ports in Proforma grid : "+proPorts, test, test1);
				   }
				   Step_End(7, "Now the data should be added to the maingrid", test, test1);

				   scrollTop(driver);
				   waitForElement(driver, SaveButton_ToolBar);
				   click(driver,SaveButton_ToolBar);

//			Verify the proforma service creation popup

				   waitForPopup(driver, popup_Message, proformaSavedPopup);
					String actualUpdatedPopup = getText(driver, popup_Message);

					if (actualUpdatedPopup.equals(proformaSavedPopup)) {
						Extent_pass_New(driver, "Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup, test,test1);
						System.out.println("Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup);
						click(driver, popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup);
						Extent_fail(driver, "Not Matched || Expected :"+proformaSavedPopup+" || Actual :"+actualUpdatedPopup, test,test1);
					}
					scrollTop(driver);

					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
					Extent_completed(tc_name, test, test1);
			
		}
		
		int h=8;
		if(h==8) {
			
			String tc_name="TC_Proforma_Service_Creation_PC08";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC08 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC08, tc_name, "Dataset"+selected_dataset, File_Path);		
			       
			
	        String ModuleSearch = data.get("Module_Search");
	        String draftProformaCode = data.get("DraftProformaCode");
	        String deployedProformaCode = data.get("DeployedProformaCode");
	        String confirmProformaCode = data.get("ConfirmProformaCode");
	        String proformaDeletedPopup = data.get("ProformaDeletedPopup");
	        String alreadyUsedPopup = data.get("AlreadyUsedPopup");
	        String wantToDeletePopup = data.get("WantToDeletePopup");
	        String confirmStatus = data.get("ConfirmStatus");
	        String deployedStatus = data.get("DeployedStatus");
	        String draftStatus = data.get("DraftStatus");
	        String dropdownCondition = data.get("DropdownCondition");
	        String globalSearchValueType = data.get("GlobalSearchValueType");
	  
	        
	        Extent_Start(tc_name, test, test1);
			
	     	moduleNavigate(driver, ModuleSearch);
      		
//	    	Proforma service creation	

//	    	Retrieve & Delete Draft Record
	    		
	    		Step_Start(1, "Click on the Search Icon ", test, test1);
	    		
	    		waitForElement(driver, SearchButton_Toolbar);
	            click(driver,SearchButton_Toolbar);
	            
	            Step_End(1, "Click on the Search Icon ", test, test1);
	            
	    		Step_Start(2, "Retrieve the Draft record ", test, test1);
	    		
	    		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, draftProformaCode, "", "", "", "");

	    		
//	    		Verify Actual status of retrieved proforma code
	    		waitForElement(driver, proformaStatus);
	    		String actualDraftStatus = getText(driver, proformaStatus);
	    		
	    		if(actualDraftStatus.equals(draftStatus)) {
	    			Extent_pass_New(driver, "Matched || Expected proforma status:"+draftStatus+" || Actual proforma status :"+actualDraftStatus, test,test1);
	    			System.out.println("Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus);
	    			click(driver, Delete_button_toolBar);
	    		}else {
	    			System.out.println("Not Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus);

	    			Extent_fail(driver, "Not Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualDraftStatus, test,test1);
	    		}
	    		Step_End(2, "Retrieve the Draft record ", test, test1);
//	    	Delete 
	    		Step_Start(3, "Delete the Draft record ", test, test1);

	    		
	    		
	    		   waitForPopup(driver, popup_Message, wantToDeletePopup);
	    		String actualDeletePopup = getText(driver, popup_Message);

//	    	Verify The Proforma Service Creation popup
	    		
	    		if (actualDeletePopup.equals(wantToDeletePopup)) {
	    			Extent_pass_New(driver, "Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup, test,test1);
	    			System.out.println("Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup);
	    			click(driver, popup_Message_Yes_Button);
	    		}else {
	    			System.out.println("Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup);

	    			Extent_fail(driver, "Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup, test,test1);
	    		}
	    		
	    		
	    		   waitForPopup(driver, popup_Message, proformaDeletedPopup);
	    		String actualDeletedPopup = getText(driver, popup_Message);

	    		if (actualDeletedPopup.equals(proformaDeletedPopup)) {
	    			Extent_pass_New(driver, "Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup, test,test1);
	    			System.out.println("Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup);
	    			click(driver, popup_Message_Ok_Button);
	    		}else {
	    			System.out.println("Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup);

	    			Extent_fail(driver, "Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopup, test,test1);
	    		}
	    		Step_End(3, "Delete the Draft record ", test, test1);
	    				
//	    	Retrieve & Delete Confirmed Record
	    		
	    		Step_Start(4, "Retrieve the Confirmed record ", test, test1);

	    		waitForElement(driver, SearchButton_Toolbar);
	            click(driver,SearchButton_Toolbar);

	    		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, confirmProformaCode, "", "", "", "");

	    		
//	    	Verify Actual status of retrieved proforma code
	    		
	    		waitForElement(driver, proformaStatus);
	    		String actualConfirmStatus8 = getText(driver, proformaStatus);
	    		
	    		if(actualConfirmStatus8.equals(confirmStatus)) {
	    			Extent_pass_New(driver, "Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8, test,test1);
	    			System.out.println("Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8);
	    		}else {
	    			System.out.println("Not Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8);

	    			Extent_fail(driver, "Not Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualConfirmStatus8, test,test1);
	    		}
	    		Step_End(4, "Retrieve the Confirmed record ", test, test1);
//	    	Delete
	    		Step_Start(5, "Delete the Confirmed record ", test, test1);
	    		
	    		scrollTop(driver);
	    		waitForDisplay(driver, Delete_button_toolBar);
	    		click(driver, Delete_button_toolBar);

//	    	Verify The Proforma Service Creation popup

	    		   waitForPopup(driver, popup_Message, wantToDeletePopup);
	    		String actualDeletePopup2 = getText(driver, popup_Message);

	    		if (actualDeletePopup2.equals(wantToDeletePopup)) {
	    			Extent_pass_New(driver, "Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2, test,test1);
	    			System.out.println("Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2);
	    			click(driver, popup_Message_Yes_Button);
	    		}else {
	    			System.out.println("Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2);

	    			Extent_fail(driver, "Not Matched || Expected popup :"+wantToDeletePopup+" || Actual popup :"+actualDeletePopup2, test,test1);
	    		}
	    		
	    		
	    		   waitForPopup(driver, popup_Message, proformaDeletedPopup);
	    		String actualDeletedPopupConfirm = getText(driver, popup_Message);

	    		if (actualDeletedPopupConfirm.equals(proformaDeletedPopup)) {
	    			Extent_pass_New(driver, "Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm, test,test1);
	    			System.out.println("Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm);
	    			click(driver, popup_Message_Ok_Button);
	    		}else {
	    			System.out.println("Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm);

	    			Extent_fail(driver, "Not Matched || Expected popup :"+proformaDeletedPopup+" || Actual popup :"+actualDeletedPopupConfirm, test,test1);
	    		}
	    		Step_End(5, "Delete the Confirmed record ", test, test1);

//	    		Retrieve Deployed Record
	    		Step_Start(6, "Retrieve the Deployed record ", test, test1);
	    		waitForElement(driver, SearchButton_Toolbar);
	            click(driver,SearchButton_Toolbar);
	    		
	    		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, deployedProformaCode, "", "", "", "");

	    		
//	    	Verify Actual status of retrieved proforma code
	    	
	    		waitForElement(driver, proformaStatus);
	    		String actualDeployedStatus8 = getText(driver, proformaStatus);
	    		if(actualDeployedStatus8.equals(deployedStatus)) {
	    			Extent_pass_New(driver, "Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8, test,test1);
	    			System.out.println("Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8);
	    		}else {
	    			System.out.println("Not Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8);

	    			Extent_fail(driver, "Not Matched || Expected proforma status :"+deployedStatus+" || Actual proforma status :"+actualDeployedStatus8, test,test1);
	    		}
	    		Step_End(6, "Retrieve the Deployed record ", test, test1);
	    		
//	    	Delete the Deployed record 
	    		
	    		Step_Start(7, "Delete the Deployed record ", test, test1);
	    		scrollTop(driver);

	    		waitForElement(driver, Delete_button_toolBar);
	    		click(driver, Delete_button_toolBar);
	    		
//	    	Verify The Proforma Service Creation popup
	    		
	    		   waitForPopup(driver, popup_Message, alreadyUsedPopup);
	    		String actualPopup = getText(driver, popup_Message);

	    		if (actualPopup.contains(alreadyUsedPopup)) {
	    			Extent_pass_New(driver, "Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup, test,test1);
	    			System.out.println("Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup);
	    			click(driver, popup_Message_Ok_Button);
	    		}else {
	    			System.out.println("Not Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup);

	    			Extent_fail(driver, "Not Matched || Expected popup :"+alreadyUsedPopup+" || Actual popup :"+actualPopup, test,test1);
	    		}
	    		Step_End(7, "Delete the Deployed record ", test, test1);
	    		
				scrollTop(driver);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			Extent_completed(tc_name, test, test1);
			
		}
		
		int l=9;
		if(l==9) {
			
			String tc_name="TC_Proforma_Service_Creation_PC09";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNamePC09 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNamePC09, tc_name, "Dataset"+selected_dataset, File_Path);
			
	        String ModuleSearch = data.get("Module_Search");
	        String proformaCode = data.get("ProformaCode");
	        String inactiveStatus = data.get("InactiveStatus");
	        String confirmStatus = data.get("ConfirmStatus");
	        String draftStatus = data.get("DraftStatus");
	        String proformaUpdatedPopup = data.get("ProformaUpdatedPopup");
	        String proformaCodeColor = data.get("ProformaCodeColor");
	        String dropdownCondition = data.get("DropdownCondition");
	        String globalSearchValueType = data.get("GlobalSearchValueType");

			Extent_Start(tc_name, test, test1);

	        
//		Login
			moduleNavigate(driver, ModuleSearch);
			
			
			
//			Proforma service creation	

//				Retrieve a Record
				Step_Start(1, "Click on the Search Icon ", test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
		        click(driver,SearchButton_Toolbar);
		        
				Step_End(1, "Click on the Search Icon ", test, test1);
				Step_Start(2, "Retirve the record ", test, test1);
				
				globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");

				
			     Step_End(2, "Retirve the record ", test, test1);
//			Verify Actual status of retrieved proforma code
				
				waitForElement(driver, proformaStatus);
				String actualStatus=getText(driver, proformaStatus);
				if(actualStatus.equals(draftStatus)) {
					Extent_pass_New(driver, "Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualStatus, test,test1);
					System.out.println("Matched || Expected proforma status :"+draftStatus+" || Actual proforma status :"+actualStatus);
					
				}else if(actualStatus.equals(confirmStatus)){
					Extent_pass_New(driver, "Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualStatus, test,test1);
					System.out.println("Matched || Expected proforma status :"+confirmStatus+" || Actual proforma status :"+actualStatus);
				}else {
					System.out.println("Not Matched || Expected proforma status :"+confirmStatus+"/"+draftStatus+" || Actual proforma status :"+actualStatus);
					Extent_fail(driver, "Not Matched || Expected proforma status :"+confirmStatus+"/"+draftStatus+" || Actual proforma status :"+actualStatus, test,test1);
				}
				 waitForDisplay(driver, Proforma_Temp_Remove);
					if(isdisplayed(driver, Proforma_Temp_Remove)){
						waitForElement(driver, Proforma_Temp_Remove);
						click(driver, Proforma_Temp_Remove);
					}
		//  Change the status to inactive
				Step_Start(3, "Choose Status as Inactive", test, test1);
				
				scrollTop(driver);
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				waitForElement(driver, proformaStatus);

					waitForElement(driver, proformaStatus);
					click(driver, proformaStatus);
					
					String inactiveStatusOption = String.format(DropDown_Select, inactiveStatus);
					
					waitForElement(driver, inactiveStatusOption);
					click(driver, inactiveStatusOption);
					
					Step_End(3, "Choose Status as Inactive", test, test1);
					
					Step_Start(4, "Click on Save button", test, test1);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
					Step_End(4, "Click on Save button", test, test1);
//			Verify the proforma service creation popup
						
					   waitForPopup(driver, popup_Message, proformaUpdatedPopup);
						String actualPopup = getText(driver, popup_Message);

						if (actualPopup.contains(proformaUpdatedPopup)) {
							Extent_pass_New(driver, "Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup, test,test1);
							System.out.println("Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup);
							click(driver, popup_Message_Ok_Button);
						}else {
							System.out.println("Not Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup);

							Extent_fail(driver, "Not Matched || Expected :"+proformaUpdatedPopup+" || Actual :"+actualPopup, test,test1);
						}
						
//			Verify the status after change
						Step_Start(5, "Only the Draft/Confirm Status Record will be allowed to change the status", test, test1);
						waitForElement(driver, proformaStatus);
						String statusAfter=getText(driver, proformaStatus);
						if (statusAfter.equals(inactiveStatus)) {
							System.out.println("Matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter);
							Extent_pass_New(driver,"Matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual proforma status : " + statusAfter,test,test1);
						} else {
							System.out.println("Not matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter);
							Extent_fail(driver,"Not matched || " + " Expected  proforma status : " + inactiveStatus + " || Actual  proforma status : " + statusAfter,test,test1);
						}
				
				
					Step_End(5, "Only the Draft/Confirm Status Record will be allowed to change the status", test, test1);
					
		//Background Color Verification of Proforma code textfield
					
				Step_Start(6, "Now the Proforma Code will be highlighed in Red Background", test, test1);
				
				waitForElement(driver, proforma_code);
				String actColorCode=getTextBackgroundColor(driver, proforma_code);
				String actColor=getColorName(actColorCode);
				
				if (actColor.equalsIgnoreCase(proformaCodeColor)) {
					System.out.println("Matched || " + " Expected  Color : " + proformaCodeColor + " || Actual  Color : " + actColor);
					Extent_pass_New(driver,"Matched || " + " Expected  Color : " + proformaCodeColor + " || Actual Color : " + actColor,test,test1);
					System.out.println("The background color of Proforma Code textfield is red");
					Extent_pass_New(driver, "The background color of Proforma Code textfield is red", test,test1);
				} else {
					System.out.println("Not matched || " + " Expected  Color : " + proformaCodeColor + " || Actual Color : " + actColor);
					Extent_fail(driver,"Not matched || " + " Expected  Color : " + proformaCodeColor + " || Actual  Color : " + actColor,test,test1);
				}
				Step_End(6, "Now the Proforma Code will be highlighed in Red Background", test, test1);
				scrollTop(driver);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				Extent_completed(tc_name, test, test1);

		}
		
		
		
	}
	
	
}
