package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD31B extends Keywords {

public void Discharge_Reconciliation_MD31B(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD31B";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Operation_List_View = Excel_data.get("Operation_List_View");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Condition = Excel_data.get("Condition");
//		String Service_Header_Input = Excel_data.get("Service_Header_Input");
		String Voyage_Code_Header = Excel_data.get("Voyage_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String OLV_select_Option = String.format(OLV_Dropdown_Select, Plan_Input);
		
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
//     	String Service_Head_Input = Excel_data.get("Service_Head_Input");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String OLV_List_Select = Excel_data.get("OLV_List_Select");
		String OLV_Feeder_Select = Excel_data.get("OLV_Feeder_Select");
		String Condition_Terminal = Excel_data.get("Condition_Terminal");
		
		String select_Option_1 = String.format(OLV_Multi_Select_Btn, OLV_Feeder_Select);
		String select_Option_2 = String.format(OLV_Multi_Select_Btn1, OLV_List_Select);
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);


		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);

		Step_End(3, "Click on New Button", test, test1);
		
		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
				
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		
		Step_Start(5, "Select the Plan as ALL/Local/Transhipment", test, test1);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, "Select the Plan as ALL/Local/Transhipment", test, test1);
	
		Step_Start(6, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button.", test, test1);
		
		Step_Start(7, "Click on Show Summary button", test, test1);
		waitForElement(driver, Summary_Button);
		click(driver, Summary_Button);
		Step_End(7, "Click on Show Summary button", test, test1);
		
		Step_Start(8, "Go to No of Units Planned Text Area section And Capture the Values stored that place", test, test1);
		String TotalCount = getAttribute(driver, Value_Get, "value");
		Extent_pass(driver, "No of Units Planned Values is :"+TotalCount, test, test1);
	    System.out.println(TotalCount);
	    int ActualValue_Dis=Integer.parseInt(TotalCount);
	    Step_End(8, "Go to No of Units Planned Text Area section And Capture the Values stored that place", test, test1);	
       
	    Step_Start(10, " Open Operation List view Module", test, test1);
	    
	    moduleNavigate(driver, Operation_List_View);
	    Step_End(10, " Open Operation List view Module", test, test1);
	    
	    Step_Start(11, " Click on Conainerized Button", test, test1);
	    
	    waitForElement(driver, OLV_Container_Btn);
		click(driver, OLV_Container_Btn);
		
		waitForElement(driver, select_Option_1);
		click(driver, select_Option_1);
		
		  Step_End(11, " Click on Conainerized Button", test, test1);
		  
		  Step_Start(12, " Click Discharge List Button", test, test1);
		  
		  waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
		  
		  
			 Step_End(12, " Click Discharge List Button", test, test1);
		  
			 Step_Start(13, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
			 
		 waitForElement(driver, Service_Searchfield_Button);
			click(driver, Service_Searchfield_Button);
			
			twoColumnSearchWindow(driver,Service_Code_Header, Condition, Service_Input);
	        
			waitForElement(driver, Vessel_SearchField_Button);
			click(driver, Vessel_SearchField_Button);
			twoColumnSearchWindow(driver,Vessel_Code_Header, Condition, Vessel_Input);
			
			waitForElement(driver, Voyage_SearchField_Button);
			click(driver, Voyage_SearchField_Button);
			twoColumnSearchWindow(driver,Voyage_Code_Header, Condition, Voyage_Input);
			
			
			waitForElement(driver, Port_SearchField_Button);
			click(driver, Port_SearchField_Button);
			
			twoColumnSearchWindow(driver,Port_Code_Header, Condition, Port_Input);
			
			waitForElement(driver, Terminal_SearchField_Button);
			click(driver, Terminal_SearchField_Button);
			twoColumnSearchWindow(driver,Terminal_Code_Header, Condition_Terminal, Terminal_Input);
			
			waitForElement(driver, OLV_Dropdown);
			click(driver, OLV_Dropdown);
			waitForElement(driver, OLV_select_Option);
			click(driver, OLV_select_Option);
			
			 Step_End(13, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
	    
	    Step_Start(14, " Click on load Button", test, test1);
	    
	    waitForElement(driver, Load_Button);
		click(driver, Load_Button);
	      
	    Step_End(14, " Click on load Button", test, test1);
	    
	    Step_Start(15, " Capture the Total Rows Count", test, test1);
	    waitForElement(driver, OLV_Row_Count);
	    String Total_row_count= getText(driver, OLV_Row_Count);
	    
	    Extent_pass(driver, "Total Row Count Operation list view Grid is :"+ Total_row_count, test, test1);
	    System.out.println(Total_row_count);
	    int ActualValue_OLV=Integer.parseInt(Total_row_count);

	    
	    Step_End(15, " Capture the Total Rows Count", test, test1);
	    
	    
	    Step_Start(16, " Verify and Compare  No of units Planned and Operation List view Module Count", test, test1); 
		
	    
	    if (ActualValue_Dis==(ActualValue_OLV)) {
			Extent_pass(driver, " Excepted No of Units Planned Values  || In Discharge reconciliation module is :"+ActualValue_Dis+ "Actual No of row count ||In Operation List View Module is :"+ActualValue_OLV , test, test1);
			System.out.println(" Excepted No of Units Planned Values || In Discharge reconciliation module is :"+ActualValue_Dis+ "Actual No of row count ||In Operation List View Module is :"+ActualValue_OLV );
			
			
		} else {
			Extent_fail(driver, "UnExcepted No of Units Planned Values || In Discharge reconciliation module is:"+ActualValue_Dis+ "Actual No of row count||In Operation List View Module is :"+ActualValue_OLV , test, test1);
			//ActualValue
		}
	   Step_End(16, "Verify and Compare  No of units Planned and Operation List view Module Count", test, test1);     
	    
	   Extent_completed(testcase_Name, test, test1);
	    
	    
	}
	
	
}
