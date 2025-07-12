package LRP_VSS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Service_Creation_Consolidation extends Keywords {

	public void serviceCreationConsolidation(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		
		String tc_name_1="TC_Service_Creation_SC01";
		String File_Path_1 = TestNgXml.getfilePath_FromExecution().get(tc_name_1);
		String sheetNameSC01 = TestNgXml.getsheetName_FromExecution().get(tc_name_1);
		Map<String, String> data_1 = Utils.GetAllData(sheetNameSC01, tc_name_1, "Dataset"+selected_dataset, File_Path_1);		
		String URL = TestNgXml.getdatafromExecution().get(tc_name_1);
		       
		
		String Username = data_1.get("Username");
        String Password = data_1.get("Password");
        String ModuleSearch = data_1.get("Module_Search");
        
		navigateUrl(driver, URL);
	// Login
			
			LRP_Login(driver, Username, Password);
			
			moduleNavigate(driver, ModuleSearch);
			
		int i=1;
		
		if(i == 1) {//	Get data from excel sheet

			
			String Frequ = data_1.get("Frequency");
			String NoShips = data_1.get("No_Ships");
			String service_Code = data_1.get("Service_Code");
			String service_Name = data_1.get("Service_Name");
			String noOfBound = data_1.get("NoOfBound");
			String serviceType = data_1.get("ServiceType");
			String ext_Fdr = data_1.get("Ext_Fdr");		
			String startDate = data_1.get("StartDate");		
			String endDate = data_1.get("EndDate");
			String savedPopup = data_1.get("SavedPopup");
			String pnl_ServiceType = data_1.get("PNL_ServiceType");
			String status = data_1.get("Status");
			String date_Picker = data_1.get("DatePicker");
			String Ext_FDR_Disable_Status = data_1.get("Ext_FDR_Disable_Status");

			
			Extent_Start(tc_name_1, test, test1);
	
//		Create new Service
			
			Step_Start(1, " Click on the new button in the toolbar", test, test1);
			
			newButton(driver);
	
		Step_End(1, " Click on the new button in the toolbar", test, test1);
		
		Step_Start(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
	
		waitForElement(driver, Service_CodeI);		
		System.out.println("Service Code : " + service_Code);
		click(driver, Service_CodeI);
		waitForElement(driver, Service_CodeI);		
		sendKeys(driver, Service_CodeI, service_Code);
		
		Step_End(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
		
		Step_Start(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
		
		waitForElement(driver, Service_NameI);
		System.out.println("Service Name " + service_Name);
		sendKeys(driver, Service_NameI, service_Name);
	
		Step_End(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
		
		Step_Start(4, "Select the bound from the drop down", test, test1);
		
		waitForElement(driver,No_of_Bound);
		click(driver,No_of_Bound);
		
		String selectBound=String.format(DropDown_Select, noOfBound);
		
		waitForElement(driver,selectBound);
		click(driver, selectBound);
	
		Step_End(4, "Select the bound from the drop down", test, test1);
		
		if(!pnl_ServiceType.equals("")) {
		waitForElement(driver,pnlServiceType );
		click(driver,pnlServiceType);
		
		String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
		
		waitForElement(driver, selectPNL_Service_type);
		click(driver, selectPNL_Service_type);

		}
		
		
		Step_Start(5, "Select the Service Type from the Service Type drop Down", test, test1);
		
		waitForElement(driver,Service_Type);
		click(driver,Service_Type);
		
		String select_Service=String.format(DropDown_Select, serviceType);
		waitForElement(driver, select_Service);
		click(driver, select_Service);
	
		Step_End(5, "Select the Service Type from the Service Type drop Down", test, test1);
		Step_Start(6, "Enter the Numerical Values in the Frequency field ", test, test1);

		
		waitForElement(driver, Freqency);
		doubleClick(driver, frequency_Textfield);
		new Actions(driver).sendKeys(Frequ).perform();
		Step_End(6, "Enter the Numerical Values in the Frequency field ", test, test1);
		
		Step_Start(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
		waitForElement(driver, No_of_Ships1);
		doubleClick(driver, No_of_Ships1);
		new Actions(driver).sendKeys(NoShips).perform();

		Step_End(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
		
		Step_Start(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
		
		waitForElement(driver, ext_FDR_Dropdown);
		if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
		waitForElement(driver, Ext_Fdr);
		click(driver,Ext_Fdr);
		
		String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
		
		waitForElement(driver, select_EXT_Fdr);
		click(driver, select_EXT_Fdr);
		}
		
		Step_End(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
		Step_Start(9, "Enter the Start Date from the field for the Service ", test, test1);
		
		waitForElement(driver,Start_Date);
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, Start_Date, startDate);
		}else {
			if(startDate.contains("-")) {
				String startDate1=startDate.replace("-", "/");
				clear(driver,Start_Date);
				waitForElement(driver, Start_Date);
				sendKeys(driver, Start_Date, startDate1);

			}else {
				clear(driver,Start_Date);
				waitForElement(driver, Start_Date);
				sendKeys(driver, Start_Date, startDate);		
				}
		}
		
		Step_End(9, "Enter the Start Date from the field for the Service ", test, test1);
		
		Step_Start(10, "Enter the End Date greater than the Start Date Given", test, test1);
		
		waitForElement(driver,End_Date);	
		
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, End_Date, endDate);
			}else {
			if(endDate.contains("-")) {
				String endDate1=endDate.replace("-", "/");
				clear(driver,End_Date);
				waitForElement(driver, End_Date);
				sendKeys(driver, End_Date, endDate1);

			}else {
			clearAndType(driver, End_Date, endDate);
			}		
		}
		
		
		Step_End(10, "Enter the End Date greater than the Start Date Given", test, test1);
		
		Step_Start(11, "Select the Status as Active from the Status drop down ", test, test1);
		
		waitForElement(driver,status_Dropdown_SER);
		click(driver,status_Dropdown_SER);
		
		String select_Status=String.format(DropDown_Select,status);
		
		waitForElement(driver, select_Status);
		click(driver, select_Status);

		Step_End(11, "Select the Status as Active from the Status drop down ", test, test1);
		
		Step_Start(12, "Click on Save button from the toolbar", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
	
		Step_End(12, "Click on Save button from the toolbar", test, test1);
		
//		Verify the service creation popup

		Step_Start(13, "Should show the pop message says \"Service Creation Saved\"", test, test1);
		
		waitForPopup(driver, popup_Message, savedPopup);
		
			String ActText = getText(driver,popup_Message);
			System.out.println(ActText);
			if (savedPopup.equals(ActText)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText, test, test1);
				System.out.println("Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText);
				click(driver,popup_Message_Ok_Button);

			}else {
				System.out.println("Not Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText);
				Extent_fail(driver, "Not Matched || Expected Popup :"+savedPopup+" || Actual Popup :"+ActText, test, test1);
			}
		
	
//  Get Service code 
		
		waitForElement(driver, service_Code_Textfield_SER);
		String savedValue = getAttribute(driver, service_Code_Textfield_SER, "value");
		System.out.println(savedValue);
		if(savedValue.equalsIgnoreCase(service_Code)) {
			Extent_pass_New(driver, "Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue, test, test1);
			System.out.println("Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue);

		}else {
			System.out.println("Not Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue);
			Extent_fail(driver, "Not Matched || Expected service code :"+service_Code+" || Actual service code :"+savedValue, test, test1);
		}
			Step_End(13, "Should show the pop message says Service Creation Saved", test, test1);
			
			Extent_completed(tc_name_1, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab); 
			
			
		}
		
	 i=2;
		
	 if(i==2) {

		 String tc_name="TC_Service_Creation_SC02";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC02 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC02, tc_name, "Dataset"+selected_dataset, File_Path);		
			       		
	        String Frequ = data.get("Frequency");
			String NoShips = data.get("No_Ships");
			String service_Code = data.get("Service_Code");
			String retrieveServiceName = data.get("RetrieveServiceName");
			String noOfBound = data.get("NoOfBound");
			String serviceType = data.get("ServiceType");
			String ext_Fdr = data.get("Ext_Fdr");
			String updatedPopup = data.get("UpdatedPopup");
			String pnl_ServiceType = data.get("PNL_ServiceType");
			String status = data.get("Status");
			String serviceName = data.get("ServiceName");
			String startDate = data.get("StartDate");		
			String endDate = data.get("EndDate");
			String date_Picker = data.get("DatePicker");
			String Ext_FDR_Disable_Status = data.get("Ext_FDR_Disable_Status");


			Extent_Start(tc_name, test, test1);
			
		moduleNavigate(driver, ModuleSearch);	
		

//		Retrieve Service from AG Grid
			
		Step_Start(1, " Double click on the saved record from the AgGrid table below", test, test1);
		
		waitForElement(driver, agGrid_Filter);
		click(driver, agGrid_Filter);
		waitForElement(driver, condition_Filter_AG_Grid_SER);
		click(driver, condition_Filter_AG_Grid_SER);
		waitForElement(driver, serviceCode_FilterSearch);
		click(driver, serviceCode_FilterSearch);
		waitForElement(driver, serviceCode_FilterSearch);
		sendKeys(driver, serviceCode_FilterSearch, service_Code);
		
		waitForElement(driver, serviceName_FilterSearch);
		click(driver, serviceName_FilterSearch);
		waitForElement(driver, serviceName_FilterSearch);
		sendKeys(driver, serviceName_FilterSearch, retrieveServiceName);
		
		waitForElement(driver, select_ServiceCode);
		click(driver, select_ServiceCode);
		waitForElement(driver, select_ServiceCode);
		doubleClick(driver, select_ServiceCode);			
		
		Step_End(1, " Double click on the saved record from the AgGrid table below", test, test1);
		
//Edit The Service
		Step_Start(2, "Click on the **Edit** button from the toolbar", test, test1);
		
	waitForElement(driver, Edit_Button_toolBar);
	click(driver,Edit_Button_toolBar);
	
	Step_End(2, "Click on the **Edit** button from the toolbar", test, test1);
	Step_Start(3, "Edit the Fields below -> Service Name, No.of Bound, Service Type, Frequency,No.of Ships, Start Date , End Date}", test, test1);
	
	Extent_call(test, test1, "Edit Service Name");
	
	waitForElement(driver, Service_NameI);
	System.out.println("Service Name " + serviceName);
	clearAndType(driver, Service_NameI, serviceName);
	
	Extent_call(test, test1, "Edit  No.of Bound");

	waitForElement(driver,No_of_Bound);
	click(driver,No_of_Bound);
	
	String selectBound=String.format(DropDown_Select, noOfBound);
	
	waitForElement(driver,selectBound);
	click(driver, selectBound);
	
	
	if(!pnl_ServiceType.equals("")) {
		waitForElement(driver,pnlServiceType );
		click(driver,pnlServiceType);
		
		String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
		
		waitForElement(driver, selectPNL_Service_type);
		click(driver, selectPNL_Service_type);

		}
	
	waitForElement(driver,Service_Type);
	click(driver,Service_Type);
	
	String select_Service=String.format(DropDown_Select, serviceType);
	waitForElement(driver, select_Service);
	click(driver, select_Service);

	
	Extent_call(test, test1, "Edit Frequency");

	waitForElement(driver, Freqency);
	doubleClick(driver, frequency_Textfield);
	new Actions(driver).sendKeys(Frequ).perform();

	Extent_call(test, test1, "Edit No.of Ships");

	waitForElement(driver, No_of_Ships1);
	doubleClick(driver, No_of_Ships1);
	new Actions(driver).sendKeys(NoShips).perform();

	
	waitForElement(driver, ext_FDR_Dropdown);
	if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
	waitForElement(driver, Ext_Fdr);
	click(driver,Ext_Fdr);
	
	String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
	
	waitForElement(driver, select_EXT_Fdr);
	click(driver, select_EXT_Fdr);
	}
	

	Extent_call(test, test1, "Edit Start Date");

	waitForElement(driver,Start_Date);
	if(date_Picker.equalsIgnoreCase("Yes")) {
		
		selectDatePickerWithTime(driver, Start_Date, startDate);
	}else {
		if(startDate.contains("-")) {
			String startDate1=startDate.replace("-", "/");
			clear(driver,Start_Date);
			waitForElement(driver, Start_Date);
			sendKeys(driver, Start_Date, startDate1);

		}else {
			clear(driver,Start_Date);
			waitForElement(driver, Start_Date);
			sendKeys(driver, Start_Date, startDate);		
			}
	}
	
	Extent_call(test, test1, "Edit End Date");

	waitForElement(driver,End_Date);	
	
	if(date_Picker.equalsIgnoreCase("Yes")) {
		
		selectDatePickerWithTime(driver, End_Date, endDate);
		}else {
		if(endDate.contains("-")) {
			String endDate1=endDate.replace("-", "/");
			clear(driver,End_Date);
			waitForElement(driver, End_Date);
			sendKeys(driver, End_Date, endDate1);

		}else {
		clearAndType(driver, End_Date, endDate);
		}		
	}
	
	Extent_call(test, test1, "Edit Status");


	waitForElement(driver,status_Dropdown_SER);
	click(driver,status_Dropdown_SER);
	
	String select_Status=String.format(DropDown_Select,status);
	
	waitForElement(driver, select_Status);
	click(driver, select_Status);
	
	Step_End(3, "Edit the Fields below->  Service Name, No.of Bound, Service Type, Frequency,No.of Ships, Start Date , End Date}", test, test1);

//Verify the service creation popup
	
	Step_Start(4, "Click on Save Button from the toolbar", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver,SaveButton_ToolBar);
 
	Step_End(4, "Click on Save Button from the toolbar", test, test1);
	Step_Start(5, "Should show the pop up message says\"Service Creation Updated\"", test, test1);
	
	waitForPopup(driver, popup_Message, updatedPopup);
		String ActText = getText(driver,popup_Message);

		System.out.println(ActText);
		if (updatedPopup.equals(ActText)) {
			Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
			System.out.println("Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
			click(driver,popup_Message_Ok_Button);

		}else {
			System.out.println("Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
			Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
		}
			
			Step_End(5, "Should show the pop up message says Service Creation Updated", test, test1);
			Extent_completed(tc_name, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab); 
		 
		 
	 }
		
	  i=3;
	 
	 if(i==3) {
		 String tc_name="TC_Service_Creation_SC03";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC03 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC03, tc_name, "Dataset"+selected_dataset, File_Path);		
			
	        String Frequ = data.get("Frequency");
			String service_Code = data.get("Service_Code");
			String service_Name = data.get("Service_Name");
			String noOfBound = data.get("NoOfBound");
			String serviceType = data.get("ServiceType");
			String pnl_ServiceType = data.get("PNL_ServiceType");
			String serviceCodePopup = data.get("ServiceCodePopup");
			String serviceNamePopup = data.get("ServiceNamePopup");
			String noOfBoundPopup = data.get("NoOfBoundPopup");
			String serviceTypePopup = data.get("ServiceTypePopup");
			String frequencyPopup = data.get("FrequencyPopup");
			String shipsGreaterThanZeroPopup = data.get("ShipsGreaterThanZeroPopup");
			
			
			Extent_Start(tc_name, test, test1);

			moduleNavigate(driver, ModuleSearch);
			
			
//		Service Creation
			
			Step_Start(1, " Click on the new button in the toolbar",test, test1);

			newButton(driver);
		
			Step_End(1, "Click on the new button in the toolbar",test, test1);
			
			Step_Start(2, " Click on Save button without entering the value in the Service Code field ",test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_End(2, "Click on Save button without entering the value in the Service Code field ",test, test1);
			Step_Start(3, "System should show validation pop up as **Enter the Service Code** ",test, test1);

			waitForPopup(driver, popup_Message, serviceCodePopup);
			String actualServiceCodePopup=getText(driver, popup_Message);
			if(actualServiceCodePopup.equals(serviceCodePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup, test, test1);
				System.out.println("Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+serviceCodePopup+" || Actual Popup :"+actualServiceCodePopup, test, test1);
			}
			
			Step_End(3, "System should show validation pop up as **Enter the Service Code** ",test, test1);
			
//		Invalid input for Service code 
			
			waitForElement(driver, Service_CodeI);		
			System.out.println("Service Code " + service_Code);
			click(driver, Service_CodeI);
			waitForElement(driver, Service_CodeI);		
			sendKeys(driver, Service_CodeI, service_Code);
			
			Step_Start(4, "  Click on Save button without entering the value in the Service Name field ",test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(4, " Click on Save button without entering the value in the Service Name field ",test, test1);
			Step_Start(5, "System should show validation pop up as-> **Enter the Service Name** ",test, test1);

			waitForPopup(driver, popup_Message, serviceNamePopup);
			String actualServiceNamePopup=getText(driver, popup_Message);
			if(actualServiceNamePopup.equals(serviceNamePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup, test, test1);
				System.out.println("Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+serviceNamePopup+" || Actual Popup :"+actualServiceNamePopup, test, test1);
			}
			
			Step_End(5, "System should show validation pop up as ->**Enter the Service Name**", test, test1);
			
			waitForElement(driver, Service_NameI);
			System.out.println("Service Name " + service_Name);
			sendKeys(driver, Service_NameI, service_Name);
			
			Step_Start(6, "Click on Save button without Choosing  the value in No.of Bound field ", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(6, "Click on Save button without Choosing  the value in No.of Bound field ", test, test1);
			
			Step_Start(7, " System should show validation pop up as ->Enter the Bound ", test, test1);
			
			waitForPopup(driver, popup_Message, noOfBoundPopup);
			String actualNoOfBoundPopup=getText(driver, popup_Message);
			if(actualNoOfBoundPopup.equals(noOfBoundPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup, test, test1);
				System.out.println("Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+noOfBoundPopup+" || Actual Popup :"+actualNoOfBoundPopup, test, test1);
			}
			
			Step_End(7, " System should show validation pop up as ->Enter the Bound ", test, test1);
			
			waitForElement(driver,No_of_Bound);
			click(driver,No_of_Bound);
			
			String selectBound=String.format(DropDown_Select, noOfBound);
			
			waitForElement(driver,selectBound);
			click(driver, selectBound);

			if(!pnl_ServiceType.equals("")) {
				waitForElement(driver,pnlServiceType );
				click(driver,pnlServiceType);
				
				String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
				
				waitForElement(driver, selectPNL_Service_type);
				click(driver, selectPNL_Service_type);

				}
			
			Step_Start(8, "Click on Save button without Choosing the value in the Service Type field ", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_End(8, "Click on Save button without Choosing the value in the Service Type field ", test, test1);
			Step_Start(9, "System should show validation pop up as ->Enter the Service Type", test, test1);
		
			waitForPopup(driver, popup_Message, serviceTypePopup);
			String actualSizeTypePopup=getText(driver, popup_Message);
			if(actualSizeTypePopup.equals(serviceTypePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup, test, test1);
				System.out.println("Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+serviceTypePopup+" || Actual Popup :"+actualSizeTypePopup, test, test1);
			}
			Step_End(9, "System should show validation pop up as ->Enter the Service Type", test, test1);
			
			waitForElement(driver,Service_Type);
			click(driver,Service_Type);
			
			String select_Service=String.format(DropDown_Select, serviceType);
			waitForElement(driver, select_Service);
			click(driver, select_Service);

			
			Step_Start(10, "Click on Save button without entering the value in the Frequency field ", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_End(10, "Click on Save button without entering the value in the Frequency field ", test, test1);
			Step_Start(11, " System should show validation pop up as ->Enter the Frequency", test, test1);
			
			waitForPopup(driver, popup_Message, frequencyPopup);
			String actualFrequencyPopup=getText(driver, popup_Message);
			if(actualFrequencyPopup.equals(frequencyPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup, test, test1);
				System.out.println("Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+frequencyPopup+" || Actual Popup :"+actualFrequencyPopup, test, test1);
			}
			
			Step_End(11, " System should show validation pop up as ->Enter the Frequency", test, test1);
		
			waitForElement(driver, Freqency);
			doubleClick(driver, frequency_Textfield);
			new Actions(driver).sendKeys(Frequ).perform();

			Step_Start(12, "Click on Save button without entering the value in the No.of Ships field ", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			Step_End(12, "Click on Save button without entering the value in the No.of Ships field ", test, test1);
			
			Step_Start(13, "System should show validation pop up as ->Enter the No.of Ships ", test, test1);
		
			waitForPopup(driver, popup_Message, shipsGreaterThanZeroPopup);
			String actualshipsGreaterThanZeroPopup=getText(driver, popup_Message);
			if(actualshipsGreaterThanZeroPopup.equals(shipsGreaterThanZeroPopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup, test, test1);
				System.out.println("Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+shipsGreaterThanZeroPopup+" || Actual Popup :"+actualshipsGreaterThanZeroPopup, test, test1);
			}
			
			Step_End(13, "System should show validation pop up as ->Enter the No.of Ships ", test, test1);
				Extent_completed(tc_name, test, test1);
				
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab); 
				

	 }
		
	
		i=5;
		
		if(i==5) {
			
			String tc_name="TC_Service_Creation_SC05";

			
			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC05 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC05, tc_name, "Dataset"+selected_dataset, File_Path);		
				
		        String Frequ = data.get("Frequency");
				String NoShips = data.get("No_Ships");
				String service_Code = data.get("Service_Code");
				String service_Name = data.get("Service_Name");
				String noOfBound = data.get("NoOfBound");
				String serviceType = data.get("ServiceType");
				String ext_Fdr = data.get("Ext_Fdr");
				String date_Picker = data.get("DatePicker");
				String startDate = data.get("StartDate");
				String endDate = data.get("EndDate");
				String alreadyExistsPopup = data.get("AlreadyExistsPopup");
				String pnl_ServiceType = data.get("PNL_ServiceType");
				String status = data.get("Status");
				String Ext_FDR_Disable_Status = data.get("Ext_FDR_Disable_Status");
					
				
				Extent_Start(tc_name, test, test1);

				moduleNavigate(driver, ModuleSearch);
				
			
//			Service Creation

				Step_Start(1, " Click on the new button in the toolbar", test, test1);
				
				newButton(driver);
			
				Step_End(1, " Click on the new button in the toolbar", test, test1);
				
				Step_Start(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
			
				waitForElement(driver, Service_CodeI);		
				System.out.println("Service Code " + service_Code);
				click(driver, Service_CodeI);
				waitForElement(driver, Service_CodeI);		
				sendKeys(driver, Service_CodeI, service_Code);
				
				Step_End(2, "Select the Service Code field and Enter Alphanumeric values upto 4 characters ", test, test1);
				
				Step_Start(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
				
				waitForElement(driver, Service_NameI);
				System.out.println("Service Name " + service_Name);
				sendKeys(driver, Service_NameI, service_Name);
			
				Step_End(3, "Select the Service Name field and Enter Alphanumeric values upto 50 characters", test, test1);
				
				Step_Start(4, "Select the bound from the drop down", test, test1);
				
				waitForElement(driver,No_of_Bound);
				click(driver,No_of_Bound);
				
				String selectBound=String.format(DropDown_Select, noOfBound);
				
				waitForElement(driver,selectBound);
				click(driver, selectBound);
			
				Step_End(4, "Select the bound from the drop down", test, test1);
				
				if(!pnl_ServiceType.equals("")) {
					waitForElement(driver,pnlServiceType );
					click(driver,pnlServiceType);
					
					String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
					
					waitForElement(driver, selectPNL_Service_type);
					click(driver, selectPNL_Service_type);

					}
				
				Step_Start(5, "Select the Service Type from the Service Type drop Down", test, test1);
				
				waitForElement(driver,Service_Type);
				click(driver,Service_Type);
				
				String select_Service=String.format(DropDown_Select, serviceType);
				waitForElement(driver, select_Service);
				click(driver, select_Service);
			
				Step_End(5, "Select the Service Type from the Service Type drop Down", test, test1);
				Step_Start(6, "Enter the Numerical Values in the Frequency field ", test, test1);

				waitForElement(driver, Freqency);
				doubleClick(driver, frequency_Textfield);
				new Actions(driver).sendKeys(Frequ).perform();

				Step_End(6, "Enter the Numerical Values in the Frequency field ", test, test1);
				
				Step_Start(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
				waitForElement(driver, No_of_Ships1);
				doubleClick(driver, No_of_Ships1);
				new Actions(driver).sendKeys(NoShips).perform();

				Step_End(7, "Enter the Numerical Values in the No.of Ships field", test, test1);
				
				Step_Start(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
			
				waitForElement(driver, ext_FDR_Dropdown);
				if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
				waitForElement(driver, Ext_Fdr);
				click(driver,Ext_Fdr);
				
				String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
				
				waitForElement(driver, select_EXT_Fdr);
				click(driver, select_EXT_Fdr);
				}

				Step_End(8, " If the Service Type is chosen as Feeder the choose value from Ext Fdr drop down ", test, test1);
				Step_Start(9, "Enter the Start Date from the field for the Service ", test, test1);
				
				waitForElement(driver,Start_Date);
				if(date_Picker.equalsIgnoreCase("Yes")) {
					
					selectDatePickerWithTime(driver, Start_Date, startDate);
				}else {
					if(startDate.contains("-")) {
						String startDate1=startDate.replace("-", "/");
						clear(driver,Start_Date);
						waitForElement(driver, Start_Date);
						sendKeys(driver, Start_Date, startDate1);

					}else {
						clear(driver,Start_Date);
						waitForElement(driver, Start_Date);
						sendKeys(driver, Start_Date, startDate);		
						}
				}
				
			Step_End(9, "Enter the Start Date from the field for the Service ", test, test1);
			
			Step_Start(10, "Enter the End Date greater than the Start Date Given", test, test1);
			
			waitForElement(driver,End_Date);	
			
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, End_Date, endDate);
				}else {
				if(endDate.contains("-")) {
					String endDate1=endDate.replace("-", "/");
					clear(driver,End_Date);
					waitForElement(driver, End_Date);
					sendKeys(driver, End_Date, endDate1);

				}else {
				clearAndType(driver, End_Date, endDate);
				}		
			}
			
				Step_End(10, "Enter the End Date greater than the Start Date Given", test, test1);
				
				Step_Start(11, "Select the Status as Active from the Status drop down ", test, test1);
				
				waitForElement(driver,status_Dropdown_SER);
				click(driver,status_Dropdown_SER);
				
				String select_Status=String.format(DropDown_Select,status);
				
				waitForElement(driver, select_Status);
				click(driver, select_Status);


				Step_End(11, "Select the Status as Active from the Status drop down ", test, test1);
				
				Step_Start(12, "Click on Save button from the toolbar", test, test1);
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver,SaveButton_ToolBar);
			
				Step_End(12, "Click on Save button from the toolbar", test, test1);
				
//				Verify the service creation popup
			
				Step_Start(13, "System should Pop up validation message says Service Code Already Exits", test, test1);
				
				waitForPopup(driver, popup_Message, alreadyExistsPopup);
					String ActText = getText(driver,popup_Message);
					
					System.out.println(ActText);
					if (alreadyExistsPopup.equals(ActText)) {
						Extent_pass_New(driver, "Matched || Expected Popup :"+alreadyExistsPopup+" || Actual Popup :"+ActText, test, test1);
						System.out.println("Matched || Expected Popup :"+alreadyExistsPopup+" || Actual Popup :"+ActText);
						click(driver,popup_Message_Ok_Button);


					}else {
						System.out.println("Not Matched || Expected Popup :"+alreadyExistsPopup+" || Actual Popup :"+ActText);

						Extent_fail(driver, "Not Matched || Expected Popup :"+alreadyExistsPopup+" || Actual Popup :"+ActText, test, test1);
					}
					
					Step_End(13, "System should Pop up validation message says Service Code Already Exits", test, test1);
					
					Extent_completed(tc_name, test, test1);

					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab); 

			
		}
		
		i=6;
		
		if(i==6) {
			
			String tc_name="TC_Service_Creation_SC06";


			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC06 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC06, tc_name, "Dataset"+selected_dataset, File_Path);	
			       		
			String retriveService_Code = data.get("RetrieveService_Code");
			String retrieveServiceName = data.get("RetrieveServiceName");
			String wantToDeletePopup = data.get("WantToDeletePopup");
			String usedServiceCode = data.get("UsedServiceCode");
			String usedServiceName = data.get("UsedServiceName");
			String deletedPopup = data.get("DeletedPopup");
			String alreadyUsedPopup = data.get("AlreadyUsedPopup");
			
			
			Extent_Start(tc_name, test, test1);

			moduleNavigate(driver, ModuleSearch);
			

			// Service creation
			
			waitForElement(driver, agGrid_Filter);
			click(driver, agGrid_Filter);
			waitForElement(driver, condition_Filter_AG_Grid_SER);
			click(driver, condition_Filter_AG_Grid_SER);
			waitForElement(driver, serviceCode_FilterSearch);
			click(driver, serviceCode_FilterSearch);
			waitForElement(driver, serviceCode_FilterSearch);
			sendKeys(driver, serviceCode_FilterSearch, retriveService_Code);
			
			waitForElement(driver, serviceName_FilterSearch);
			click(driver, serviceName_FilterSearch);
			waitForElement(driver, serviceName_FilterSearch);
			sendKeys(driver, serviceName_FilterSearch, retrieveServiceName); 
			
			waitForElement(driver, select_ServiceCode);
			String actualServiceCode = getText(driver, select_ServiceCode);
			Step_Start(1, "Double Click on the Service Record",test, test1);
			if (actualServiceCode.equalsIgnoreCase(retriveService_Code)) {
				System.out.println("Matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode);
				Extent_pass_New(driver,"Matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode,test,test1);
				doubleClick(driver, select_ServiceCode);
			
			} else {
				System.out.println("Not matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode);
				Extent_fail(driver,"Not matched || " + " Expected Service code : " + retriveService_Code + " || Actual Service code : " + actualServiceCode,test,test1);
			}
			
			
			Step_End(1, "Double Click on the Service Record",test, test1);

	//Delete service
			// For No
			
			Step_Start(2, "Click on the Delete icon from the toolbar ",test, test1);
			scrollTop(driver);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			Step_End(2, "Click on the Delete icon from the toolbar ",test, test1);
			
			Step_Start(3, "System should pop up a message of ,Do you want to permanently delete",test, test1);

			waitForPopup(driver, popup_Message, wantToDeletePopup);

			String deletPopupAct1 = getText(driver, popup_Message);
			System.out.println(deletPopupAct1);

			if (deletPopupAct1.equals(wantToDeletePopup)) {
				System.out.println("Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct1);
				Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual Popup : "+ deletPopupAct1, test, test1);
				click(driver, popup_Message_No_Button);

			} else {
				System.out.println("Not matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct1);
				Extent_fail(driver, "Not matched || " + " Expected  Popup : " + wantToDeletePopup+ " || Actual  Popup : " + deletPopupAct1, test, test1);
			}
			
			Step_End(3, "System should pop up a message of ,Do you want to permanently delete",test, test1);

			Step_Start(4, "Clicking on No should close the pop up message ",test, test1);

			waitForDisplay(driver, popup_Message);
			if(!isdisplayed(driver, popup_Message)) {		
				Extent_pass_New(driver, wantToDeletePopup + " poppup is closed", test, test1);
				System.out.println(wantToDeletePopup + " poppup is closed");
			} else {	
				System.out.println(wantToDeletePopup + " poppup is not closed");

				Extent_fail(driver, wantToDeletePopup + " poppup is not closed", test, test1);
			}
			 
			Step_End(4, "Clicking on No should close the pop up message ",test, test1);

	// For Yes
			scrollTop(driver);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

			waitForPopup(driver, popup_Message, wantToDeletePopup);

			String deletPopupAct2 = getText(driver, popup_Message);
			if (deletPopupAct2.equals(wantToDeletePopup)) {
				System.out.println("Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct2);
				Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual Popup : "+ deletPopupAct2, test, test1);
				click(driver, popup_Message_Yes_Button);

			} else {
				System.out.println("Not matched || " + " Expected  Popup : " + wantToDeletePopup + " || Actual  Popup : "+ deletPopupAct2);
				Extent_fail(driver, "Not matched || " + " Expected  Popup : " + wantToDeletePopup+ " || Actual  Popup : " + deletPopupAct2, test, test1);
			}
			
			Step_Start(5, "Clicking on Yes should remove the record from the grid ",test, test1);

			
			waitForPopup(driver, popup_Message, deletedPopup);
			String actualDeletedPopup = getText(driver, popup_Message);
			if (actualDeletedPopup.equals(deletedPopup)) {
				System.out.println("Matched || " + " Expected  Popup : " + deletedPopup + " || Actual  Popup : "+ actualDeletedPopup);
				Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + deletedPopup + " || Actual Popup : "+ actualDeletedPopup, test, test1);
				click(driver, popup_Message_Ok_Button);
				Extent_pass_New(driver, "Record is removed ", test, test1);

			} else {
				System.out.println("Not matched || " + " Expected  Popup : " + deletedPopup + " || Actual  Popup : "+ actualDeletedPopup);
				Extent_fail(driver, "Not matched || " + " Expected  Popup : " + deletedPopup+ " || Actual  Popup : " + actualDeletedPopup, test, test1);
			}
			
			Step_End(5, "Clicking on No should close the pop up message ",test, test1);

			
	//Already Used Popup
			

			waitForElement(driver, agGrid_Filter);
			click(driver, agGrid_Filter);
			waitForElement(driver, condition_Filter_AG_Grid_SER);
			click(driver, condition_Filter_AG_Grid_SER);
			waitForElement(driver, serviceCode_FilterSearch);
			click(driver, serviceCode_FilterSearch);
			waitForElement(driver, serviceCode_FilterSearch);

			sendKeys(driver, serviceCode_FilterSearch, usedServiceCode);
			
			if(!usedServiceName.equals("")) {
			click(driver, serviceName_FilterSearch);
			waitForElement(driver, serviceName_FilterSearch);
			sendKeys(driver, serviceName_FilterSearch,usedServiceName); 
			}
			
			Step_Start(6, "Select Service code",test, test1);

			waitForElement(driver, select_ServiceCode);
			String actualUsedServiceCode = getText(driver, select_ServiceCode);
			

			if (actualUsedServiceCode.equalsIgnoreCase(usedServiceCode)) {
				System.out.println("Matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code : " + actualUsedServiceCode);
				Extent_pass_New(driver,"Matched || " + " Expected Service code : " + usedServiceCode + " || ActualService code : " + actualUsedServiceCode,test,test1);
				doubleClick(driver, select_ServiceCode);

				
			} else {
				System.out.println("Not matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code  : " + actualUsedServiceCode);
				Extent_fail(driver,"Not matched || " + " Expected Service code : " + usedServiceCode + " || Actual Service code : " + actualUsedServiceCode,test,test1);
			}
			
			Step_End(6, "Select Service code",test, test1);
			
			
			Step_Start(6, "Click on delete button",test, test1);
			scrollTop(driver);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			
			Step_End(6, "Click on delete button",test, test1);

			
			
			Step_Start(7, "\"The service is already used in Mainline/Feeder Schedules\"",test, test1);

			waitForPopup(driver, popup_Message, alreadyUsedPopup);
			String actualUsedPopup = getText(driver, popup_Message);

			if (actualUsedPopup.equals(alreadyUsedPopup)) {
				System.out.println("Matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup);
				Extent_pass_New(driver,"Matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual Popup : " + actualUsedPopup,test,test1);
				click(driver, popup_Message_Ok_Button);

			} else {
				System.out.println("Not matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup);
				Extent_fail(driver,"Not matched || " + " Expected  Popup : " + alreadyUsedPopup + " || Actual  Popup : " + actualUsedPopup,test,test1);
			}
			
			Step_End(7, "\"The service is already used in Mainline/Feeder Schedules\"",test, test1);


			Extent_completed(tc_name, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab); 
			
			
		}
		
		i=7;
		if(i==7) {
			
			String tc_name="TC_Service_Creation_SC07";


			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC07 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC07, tc_name, "Dataset"+selected_dataset, File_Path);	
			       		
			String retriveService_Code = data.get("RetrieveService_Code");
			String retrieveServiceName = data.get("RetrieveServiceName");
			String serviceCodeColor = data.get("ServiceCodeColor");
			String status = data.get("Status");
			String updatedPopup = data.get("UpdatedPopup");
			String status_2 = data.get("status_2");
			String want_To_Activate = data.get("Want_To_Activate");

			
			Extent_Start(tc_name, test, test1);
			
			moduleNavigate(driver, ModuleSearch);
				
	//Retrieve a Service	
			Step_Start(1, "Double Click on the Service Record",test, test1);
			waitForElement(driver, agGrid_Filter);
			click(driver, agGrid_Filter);
			waitForElement(driver, condition_Filter_AG_Grid_SER);
			click(driver, condition_Filter_AG_Grid_SER);
			waitForElement(driver, serviceCode_FilterSearch);
			sendKeys(driver, serviceCode_FilterSearch, retriveService_Code);
			
			waitForElement(driver, serviceName_FilterSearch);
			sendKeys(driver, serviceName_FilterSearch, retrieveServiceName); 
			
			waitForElement(driver, select_ServiceCode);
			String actualServiceCode = getText(driver, select_ServiceCode);

			if (actualServiceCode.equalsIgnoreCase(retriveService_Code)) {
				System.out.println("Matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode);
				Extent_pass_New(driver,"Matched || " + " Expected Service Code : " + retriveService_Code + " || ActualService Code : " + actualServiceCode,test,test1);
			} else {
				System.out.println("Not matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode);
				Extent_fail(driver,"Not matched || " + " Expected Service Code : " + retriveService_Code + " || Actual Service Code : " + actualServiceCode,test,test1);
			}
			
			waitForElement(driver, select_ServiceCode);
			click(driver, select_ServiceCode);
			waitForElement(driver, select_ServiceCode);
			doubleClick(driver, select_ServiceCode);			
			
			Step_End(1, "Double Click on the Service Record",test, test1);
			
//Change to Inactive
			
			Step_Start(2, "Click on the Edit Button from the toolbar",test, test1);
			scrollTop(driver);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
		
			Step_End(2, "Click on the Edit Button from the toolbar",test, test1);

			Step_Start(3, "Select the Inactive Value from the Status Drop Down",test, test1);
			
			waitForElement(driver,status_Dropdown_SER);
			click(driver,status_Dropdown_SER);
			
			String select_Status=String.format(DropDown_Select,status);
			
			waitForElement(driver, select_Status);
			click(driver, select_Status);
			
			waitForElement(driver,status_Dropdown_Value_SER);
			String actualStatus = getText(driver,status_Dropdown_Value_SER);
			
			if (actualStatus.equals(status)) {
				Extent_pass_New(driver, "Matched || Expected :"+status+" || Actual :"+actualStatus, test, test1);
				System.out.println("Matched || Expected :"+status+" || Actual :"+actualStatus);
			
			}else {
				System.out.println("Not Matched || Expected :"+status+" || Actual :"+actualStatus);
				Extent_fail(driver, "Not Matched || Expected :"+status+" || Actual :"+actualStatus, test, test1);
			}
			Step_End(3, "Select the Inactive Value from the Status Drop Down",test, test1);

			Step_Start(4, "Click on Save Button",test, test1);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
//	Verify the service creation popup
			
			waitForPopup(driver, popup_Message, updatedPopup);
				String ActText = getText(driver,popup_Message);
				System.out.println(ActText);
				if (updatedPopup.equals(ActText)) {
					Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
					System.out.println("Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);
					click(driver, popup_Message_Ok_Button);
				}else {
					System.out.println("Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText);

					Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup+" || Actual Popup :"+ActText, test, test1);
				}
				waitForElement(driver, service_Code_Textfield_SER);
				String actualColorCode = getTextBackgroundColor(driver, service_Code_Textfield_SER);
				String actualColor=getColorName(actualColorCode);
				
				if (actualColor.equalsIgnoreCase(serviceCodeColor)) {
					System.out.println("Matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor);
					Extent_pass_New(driver,"Matched || " + " Expected Color : " + serviceCodeColor + " || ActualColor : " + actualColor,test,test1);
				} else {
					System.out.println("Not matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor);
					Extent_fail(driver,"Not matched || " + " Expected Color : " + serviceCodeColor + " || Actual Color : " + actualColor,test,test1);
				}
			
				Step_End(4, "Click on Save Button",test, test1);
				
				if(want_To_Activate.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				waitForElement(driver,status_Dropdown_SER);
				click(driver,status_Dropdown_SER);
				
				String select_Status1=String.format(DropDown_Select,status_2);
				
				waitForElement(driver, select_Status1);
				click(driver, select_Status1);
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver,SaveButton_ToolBar);
				if(isdisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				}
				}
					
					Extent_completed(tc_name, test, test1);
					
					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab); 
			
		}
		
		
	i=4;
		
		if(i==4) {
			
			String tc_name="TC_Service_Creation_SC04";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_name);
			String sheetNameSC04 = TestNgXml.getsheetName_FromExecution().get(tc_name);
			Map<String, String> data = Utils.GetAllData(sheetNameSC04, tc_name, "Dataset"+selected_dataset, File_Path);	
			       
			
	        String Frequ = data.get("Frequency");
			String NoShips = data.get("No_Ships");
			String invalidFrequ = data.get("InvalidFrequency");
			String invalidNoShips = data.get("InvalidNoOfShips");
			String service_Code = data.get("Service_Code");
			String service_Name = data.get("Service_Name");
			String noOfBound = data.get("NoOfBound");
			String serviceType = data.get("ServiceType");
			String ext_Fdr = data.get("Ext_Fdr");
			String startDate = data.get("StartDate");
			String endDate = data.get("EndDate");
			String pnl_ServiceType = data.get("PNL_ServiceType");
			String status = data.get("Status");
			String endDateGreaterPopup = data.get("EndDateGreaterPopup");
			String negativeFrequencyPopup = data.get("NegativeFrequencyPopup");
			String negativeNoOfShipsPopup = data.get("NegativeNoOfShipsPopup");
			String date_Picker = data.get("DatePicker");
			String Ext_FDR_Disable_Status = data.get("Ext_FDR_Disable_Status");

			
			Extent_Start(tc_name, test, test1);

			moduleNavigate(driver, ModuleSearch);
			
			
//		Service creation
			
			Step_Start(1, " Click on the new button in the toolbar",test, test1);
			
			newButton(driver);
			
			Step_End(1, "Click on the new button in the toolbar",test, test1);

			waitForElement(driver, Service_CodeI);		
			System.out.println("Service Code " + service_Code);
			click(driver, Service_CodeI);
			waitForElement(driver, Service_CodeI);		
			sendKeys(driver, Service_CodeI, service_Code);
			
			waitForElement(driver, Service_NameI);
			System.out.println("Service Name " + service_Name);
			sendKeys(driver, Service_NameI, service_Name);
			
			waitForElement(driver,No_of_Bound);
			click(driver,No_of_Bound);
			
			String selectBound=String.format(DropDown_Select, noOfBound);
			
			waitForElement(driver,selectBound);
			click(driver, selectBound);
			
			if(!pnl_ServiceType.equals("")) {
				waitForElement(driver,pnlServiceType );
				click(driver,pnlServiceType);
				
				String selectPNL_Service_type=String.format(DropDown_Select, pnl_ServiceType);
				
				waitForElement(driver, selectPNL_Service_type);
				click(driver, selectPNL_Service_type);

				}
			
			waitForElement(driver,Service_Type);
			click(driver,Service_Type);
			
			String select_Service=String.format(DropDown_Select, serviceType);
			waitForElement(driver, select_Service);
			click(driver, select_Service);

			
			Step_Start(2, "Enter the Frquency field value with negative(-) number",test, test1);

			waitForElement(driver, Freqency);
			doubleClick(driver, frequency_Textfield);
			new Actions(driver).sendKeys(invalidFrequ).perform();
			
			Step_End(2, "Enter the Frquency field value with negative(-) number",test, test1);

			
			Step_Start(3, "pop message states Frequency should not be Negative and should remove the value entered from the field",test, test1);

			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			String ActText = getText(driver,popup_Message);
			
			System.out.println(ActText);
			if (negativeFrequencyPopup.equals(ActText)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText, test, test1);
				System.out.println("Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText);
				if(isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver, popup_Message_Ok_Button);
				}
				waitForElement(driver, Freqency);
				doubleClick(driver, frequency_Textfield);
				new Actions(driver).sendKeys(Frequ).perform();
				
			}		
//			else {
//				System.out.println("Not Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText);
//
//				extent_fail(driver, "Not Matched || Expected Popup :"+negativeFrequencyPopup+" || Actual Popup :"+ActText, test, test1);
//			}
			}
//			else {
//				Extent_cal(test, test1, "Expected Failure Due To Functionality Not Working As Expected");
//				extent_fail(driver, "Frequency should not be Negative popup is not displayed", test, test1);
//				System.out.println("Frequency should not be Negative popup is not displayed");
//			}

			Step_End(3, "pop message states Frequency should not be Negative and should remove the value entered from the field",test, test1);

			Step_Start(4, "Enter the No.of Ships field value with negative(-) number", test, test1);
			
			waitForElement(driver, No_of_Ships1);
			click(driver, No_of_Ships1);

			new Actions(driver).sendKeys(invalidNoShips).perform();
			
			Extent_pass_New(driver, "invalidNoShips: "+invalidNoShips, test, test1);
			System.out.println("invalidNoShips: "+invalidNoShips);
			
			Step_End(4, "Enter the No.of Ships field value with negative(-) number",test, test1);

			Step_Start(5, "pop message states No.of Ships should not be Negative and should remove the value entered from the field",test, test1);
			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
			String ActText = getText(driver,popup_Message);
			System.out.println(ActText);
			if (negativeNoOfShipsPopup.equals(ActText)) {
				Extent_pass_New(driver, "Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText, test, test1);
				System.out.println("Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText);
				if(isdisplayed(driver, popup_Message_Ok_Button)) {

				click(driver, popup_Message_Ok_Button);
				}
				waitForElement(driver, No_of_Ships1);
				click(driver, No_of_Ships1);
				new Actions(driver).sendKeys(NoShips).perform();
				
			}
//			else {
//				System.out.println("Not Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText);
//
//				extent_fail(driver, "Not Matched || Expected Popup :"+negativeNoOfShipsPopup+" || Actual Popup :"+ActText, test, test1);
//			}
			}
//			else {
//				Extent_cal(test, test1, "Expected Failure Due To Functionality Not Working As Expected");
//				extent_fail(driver, "No.of Ships should not be Negative popup is not displayed", test, test1);
//				System.out.println("No.of Ships should not be Negative popup is not displayed");
//			}
			
			Step_End(5, "pop message states No.of Ships should not be Negative and should remove the value entered from the field",test, test1);

			
			waitForElement(driver, ext_FDR_Dropdown);
			if(!serviceType.equals(Ext_FDR_Disable_Status)) {   
			waitForElement(driver, Ext_Fdr);
			click(driver,Ext_Fdr);
			
			String select_EXT_Fdr=String.format(DropDown_Select,ext_Fdr);
			
			waitForElement(driver, select_EXT_Fdr);
			click(driver, select_EXT_Fdr);
			}
			
			Step_Start(6, "Enter the End Date Lesser than Start Date",test, test1);

			waitForElement(driver,Start_Date);
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Start_Date, startDate);
			}else {
				if(startDate.contains("-")) {
					String startDate1=startDate.replace("-", "/");
					clear(driver,Start_Date);
					waitForElement(driver, Start_Date);
					sendKeys(driver, Start_Date, startDate1);

				}else {
					clear(driver,Start_Date);
					waitForElement(driver, Start_Date);
					sendKeys(driver, Start_Date, startDate);		
					}
			}
			
			waitForElement(driver,End_Date);	
			
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, End_Date, endDate);
				}else {
				if(endDate.contains("-")) {
					String endDate1=endDate.replace("-", "/");
					clear(driver,End_Date);
					waitForElement(driver, End_Date);
					sendKeys(driver, End_Date, endDate1);

				}else {
				clearAndType(driver, End_Date, endDate);
				}		
			}
			
			
			Step_End(6, "Enter the End Date Lesser than Start Date",test, test1);

			waitForElement(driver,status_Dropdown_SER);
			click(driver,status_Dropdown_SER);
			
			String select_Status=String.format(DropDown_Select,status);
			
			waitForElement(driver, select_Status);
			click(driver, select_Status);
			
			Step_Start(7, "Click on Save button",test, test1);

			scrollTop(driver);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			Step_End(7, "Click on Save button", test, test1);
			// End date lesser than start date
			Step_Start(8, "pop up message shows End date should be greater than Start Date", test, test1);
				
			waitForPopup(driver, popup_Message, endDateGreaterPopup);
				String actText = getText(driver,popup_Message);
					
					if (endDateGreaterPopup.equals(actText)) {
						Extent_pass_New(driver, "Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText, test, test1);
						System.out.println("Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText);
						click(driver,popup_Message_Ok_Button);

					}else {
						System.out.println("Not Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText);

						Extent_fail(driver, "Not Matched || Expected Popup :"+endDateGreaterPopup+" || Actual Popup :"+actText, test, test1);
					}
			
			Step_End(8, "pop up message shows End date should be greater than Start Date", test, test1);
			
			Extent_completed(tc_name, test, test1);
				
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab); 
			
		}
		
		
	}
	
	
}
