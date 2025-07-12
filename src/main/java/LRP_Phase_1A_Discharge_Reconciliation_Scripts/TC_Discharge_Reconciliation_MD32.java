package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD32  extends Keywords{
public void Discharge_Reconciliation_MD32(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD32";
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
		String Operation_List_View_Module = Excel_data.get("Operation_List_View_Module");
		String Service_Code_Header = Excel_data.get("OLV_Service_Code_Header");
		String Condition = Excel_data.get("Condition");
		String Voyage_Code_Header = Excel_data.get("OLV_Voyage_Code_Header");
		String Vessel_Code_Header = Excel_data.get("OLV_Vessel_Code_Header");
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		String Port_Code_Header = Excel_data.get("OLV_Port_Code_Header");
		String Operation_Grid_bL_header = Excel_data.get("Operation_Grid_bL_header");
		String Terminal_Code_Header = Excel_data.get("OLV_Terminal_Code_Header");
		
		
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
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			
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
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(7, "Click on Show Summary button", test, test1);
		
		Step_Start(8, "Go to Non-Container without BL place", test, test1);
		Step_Start(9, "Capture the Non-Container without BL count", test, test1);
		
		String Actual_value_Dis_Non_Cointainer_Field = getAttribute(driver, Dis_Non_Container_Count, "value");
		Extent_pass(driver, "Non-Container without BL count is :"+Actual_value_Dis_Non_Cointainer_Field, test, test1);
		 int ActualValue_Dis=Integer.parseInt(Actual_value_Dis_Non_Cointainer_Field);
	    System.out.println(ActualValue_Dis);
	    
	    Step_End(8, "Go to Non-Container without BL place", test, test1);
	    Step_End(9, "Capture the Non-Container without BL count", test, test1);
	    
	    Step_Start(10, " Open Operation List view Module", test, test1);
	    
	    moduleNavigate(driver, Operation_List_View_Module);
	    Step_End(10, " Open Operation List view Module", test, test1);
	    
	    Step_Start(11, " Click on Non-Conainerized Button", test, test1);
	    
	    waitForElement(driver, Non_Container_Button);
		click(driver, Non_Container_Button);
		  Step_End(11, " Click on Non-Conainerized Button", test, test1);
		  
		  Step_Start(12, " Click Discharge List Button", test, test1);
		  
		  waitForElement(driver, Discharge_Button);
			click(driver, Discharge_Button);
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
			twoColumnSearchWindow(driver,Terminal_Code_Header, Condition, Terminal_Input);
//			
			 Step_End(13, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
	    
	    
	    Step_Start(14, " Click on load Button", test, test1);
	    
	    waitForElement(driver, Load_Button);
		click(driver, Load_Button);
	      
	    Step_End(14, " Click on load Button", test, test1);
	    
	    Step_Start(15, " Filter Only Row does not have BL Number", test, test1);
	    
	    reArrangeAG_GridColumnsNew(driver, OLV_cocloum_click, Operation_Grid_bL_header);
	    
	    waitForElement(driver, OLV_Filter_Btn);
		click(driver, OLV_Filter_Btn);
		
		AGGridBlankSearchFilter(driver, Operation_Grid_bL_header);
	
	    Step_End(15, "Filter Only Row does not have BL Number", test, test1);
	    
	    
	    Step_Start(16, "Capture the count of rows", test, test1);
	    
	    waitForElement(driver, OLV_Row_Count);
	    String Row_Count= getText(driver, OLV_Row_Count);
	    System.out.println(Row_Count);
	    
	    
		    List<String> splitAndExpand = splitAndExpand(Row_Count,"of");
		    
		    String No_Of_Non_containers = splitAndExpand.get(0).trim();
		    System.out.println(No_Of_Non_containers);
		    Extent_pass(driver, "Total Blank Row Count Of Non Container Without BLNo in Operation List View Module  is :"+ No_Of_Non_containers, test, test1);
//		    
		    int ActualValue_OLV=Integer.parseInt(No_Of_Non_containers);
		    System.out.println(ActualValue_OLV);
		    
	    Step_End(16, "Capture the count of rows", test, test1);
	    
	    Step_Start(17, " Verify that Make sure (Container Total Count)  are Matched in Operation List view and Non-Container without BL Count in summary section.", test, test1); 
		if (ActualValue_Dis==(ActualValue_OLV)) {
			Extent_pass(driver, " Excepted Non Container Without BLNo  || In Discharge reconciliation module is :"+ActualValue_Dis+ "Actual Non Container Without BLNo ||In Operation List View Module is :"+ActualValue_OLV , test, test1);
			System.out.println(" Excepted NonContainer Without BLNo || In Discharge reconciliation module is :"+ActualValue_Dis+ "Actual Non Container Without BLNo ||In Operation List View Module is :"+ActualValue_OLV );
			
			
		} else {
			System.out.println(" UnExcepted NonContainer Without BLNo || In Discharge reconciliation module is :"+ActualValue_Dis+ "Actual Non Container Without BLNo ||In Operation List View Module is :"+ActualValue_OLV );
			
			
			Extent_fail(driver, "UnExcepted NonContainer Without BLNo || In Discharge reconciliation module is:"+ActualValue_Dis+ "Actual Non Container Without BLNo||In Operation List View Module is :"+ActualValue_OLV , test, test1);
			//ActualValue
		}
	   Step_End(17, " Verify that Make sure (Container Total Count)  are Matched in Operation List view and Non-Container without BL Count in summary section.", test, test1);     
	    
	   Extent_completed(testcase_Name, test, test1);
}
}
