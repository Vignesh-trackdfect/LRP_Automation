package LRP_Phase_1A_Discharge_Reconciliation_Scripts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD24 extends Keywords{

public void Discharge_Reconciliation_MD24(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Discharge_Reconciliation_MD24";
		
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
		String Filter_btn = Excel_data.get("Filter_btn");
		String Filters = Excel_data.get("Filters");
		String BL_No = Excel_data.get("Bl_Number");
		String Search_By = Excel_data.get("Search_By");
		String global_Search_Condition = Excel_data.get("global_Search_Condition");
		String Operation_List_view_module = Excel_data.get("Operation_List_view_module");
		String MCN_No_Status = Excel_data.get("MCN_No_Status");
		String Service_Header = Excel_data.get("Service_Header");
		String Plan_Input = Excel_data.get("Plan_Type");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
//	    String Bl_wi_MF_Filters = Excel_data.get("Bl_wi_MF_Filters");
		String Status = Excel_data.get("Status");
		String Manifest_Closed = Excel_data.get("Manifest_Closed");
		
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String OLV_select_Option = String.format(DropDown_Select, Plan_Input);
		
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1,"Once login to the application and click on switch profile option and select the required agency.",test, test1);
 
		SwitchProfile(driver, AgencyUser);
 
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",test, test1);
 
		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
 
		moduleNavigate(driver, Dis_Recon_Module);
 
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);
 
		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);
 
		Step_End(3, "Click on New Button", test, test1);
 
		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		waitForElement(driver, Service_Option);
		click(driver, Service_Option);
		twoColumnSearchWindow(driver, Service_Header, Filter_Condition, Service_Input);
		
		waitForElement(driver, Vessele_Option);
		click(driver, Vessele_Option);
		twoColumnSearchWindow(driver, Vessel_Header, Filter_Condition, Vessel_Input);
		
		waitForElement(driver, DR_Voyage_Option);
		sendKeys(driver, DR_Voyage_Option, Voyage_Input);
 
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
 
		if (!Port_Input.equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		
		click1(driver,grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
 
		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);
 
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
 
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
 
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
 
		Step_End(5, "Select the Plan as ALL/Local/Transhipment", test, test1);
 
		Step_Start(6, "Click on Download BL Button", test, test1);
 
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
 
		Step_End(6, "Click on Download BL Button", test, test1);
		
		Step_Start(7, "Click on Summary Button", test, test1);
		
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver , Show_Summary_Btn_DR);
		
		Step_End(7, "Click on Summary Button", test, test1);
		
		Step_Start(8, "Click on non container shipment summary button", test, test1);
		
		waitForElement(driver, DR_Non_Container_ss_btn);
		click(driver , DR_Non_Container_ss_btn);
 
		Step_End(8, "Click on non container shipment summary button", test, test1);
		
		Step_Start(9, "Capture the BL NO in Cargo section", test, test1);
 
		 waitForElement(driver, Bl_No_Cargo_det);
		  
		
		  List<String> newValue = new ArrayList<>();
	        //String Cargo_bl_num=String.format(DR_Cargo_Bl_no, j);    
	        
	        int j=0;
	        Set<String>  newValue1=new HashSet<String>();
	        String blno=String.format(DR_Cargo_Bl_no, j);    
	        
	        while(isdisplayed(driver, blno)) {
	        	mouseOverToElement(driver, blno);
	        	String BLNum1=getText(driver, blno);
	        	if(BLNum1!=null&& !BLNum1.isEmpty()) {
		        	newValue.add(BLNum1);
	        	}
	        	j++;
	        	blno=String.format(DR_Cargo_Bl_no, j);    
	        }
	        
	        int Cargo_bl_num=newValue.size();
		
		  waitForElement(driver, DR_Show_Non_container_clbtn);
			click(driver, DR_Show_Non_container_clbtn);;
 
		
		
		// show container btn
//		  waitForElement(driver, DR_Bl_No_show_Container);
//		  String Bl_no_cargo_details =getText(driver, DR_Bl_No_show_Container);
//		  click(driver, DR_Bl_No_show_Container);
		  
//		    waitForElement(driver, DR_Show_container_clbtn);
//			click(driver, DR_Show_container_clbtn);
			
		Step_End(9, "Capture the BL NO in Cargo section", test, test1);
		
		Step_Start(10, " Open Operation List view Module", test, test1);
		
		moduleNavigate(driver, Operation_List_view_module);
		
		Step_End(10, " Open Operation List view Module", test, test1);
		
		Step_Start(11, " Click on Non-Conainerized Button", test, test1);
		
		waitForElement(driver, Olv_Non_Containerized_btn);
		click(driver , Olv_Non_Containerized_btn);
		
		Step_End(11, " Click on Non-Conainerized Button", test, test1);
		
		Step_Start(12, "Click Discharge List Button", test, test1);
		
		waitForElement(driver, Olv_Discharge_List_btn);
		click(driver , Olv_Discharge_List_btn);
		
		Step_End(12, "Click Discharge List Button", test, test1);
		
		Step_Start(13, "Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
		
 
		waitForElement(driver, OLV_Service_Option);
		click(driver, OLV_Service_Option);
		twoColumnSearchWindow(driver, Service_Header, Filter_Condition, Service_Input);
		
	
		waitForElement(driver, OLV_Vessele_Option);
		click(driver, OLV_Vessele_Option);
		twoColumnSearchWindow(driver, Vessel_Header, Filter_Condition, Vessel_Input);
		
		waitForElement(driver, OLV_Voyage_Option);
		click(driver, OLV_Voyage_Option);
		twoColumnSearchWindow(driver, Voyage_Header, Filter_Condition, Voyage_Input);
		
	
		//Plan as ALL/Local/Transhipment
		waitForElement(driver, OLV_grid_selectbtn);
		click(driver, OLV_grid_selectbtn);
 
		waitForElement(driver, OLV_select_Option);
		click(driver, OLV_select_Option);
 
		
		waitForElement(driver, OLV_Port_Option);
		click(driver, OLV_Port_Option);
		twoColumnSearchWindow(driver, Port_Header, Filter_Condition, Port_Input);
		
		waitForElement(driver, OLV_Terminal_Option);
		click(driver, OLV_Terminal_Option);
		twoColumnSearchWindow(driver,Terminal_Header, Filter_Condition, Terminal_Input);
		
		Step_End(13, "Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
		
		
		Step_Start(14, "Click on load Button", test, test1);
		
		waitForElement(driver, OLV_Load_btn);
		click(driver, OLV_Load_btn);
		
		Step_End(14, "Click on load Button", test, test1);
		
		Step_Start(15, "Filter Only Row has BL Number", test, test1);
		
		reArrangeAG_GridColumnsNew(driver, OLV_cocloum_click, Filters);
//		waitForElement(driver, OLV_Filter_btn);
//		click(driver, OLV_Filter_btn);	
 
		Step_End(15, "Filter Only Row has BL Number", test, test1);
		
		Step_Start(16, "Distinct the BL number List", test, test1);
		
		 int i=0;
	        Set<String>  newValue12=new HashSet<String>();
	        String blnums=String.format(OLV_ManifiesBL_Numbers, i);    
	        
	        while(isdisplayed(driver, blnums)) {
	        	mouseOverToElement(driver, blnums);
	        	String BLNum=getText(driver, blnums);
	        	if(BLNum!=null&& !BLNum.isEmpty()) {
		        	newValue12.add(BLNum);
	        	}
	        	i++;
	        	blnums=String.format(OLV_ManifiesBL_Numbers, i);    
	        }
	        
	        int BL_Num_Cout=newValue12.size();
		
		
		Step_End(16, "Distinct the BL number List", test, test1);
		
		Step_Start(17, "Verify that Make sure BLs are listed in Operation List view and Non-Container summary", test, test1);
		
		if(Cargo_bl_num == BL_Num_Cout){
			 System.out.println("Matched || Expected :  BLs are listed in Operation List view count has to matched as "+BL_Num_Cout+ " || Actual  : BLs are listed in Operation List view count : Non-Container summary count : "+ Cargo_bl_num);
			 Extent_pass(driver,"Matched || Expected :  BLs are listed in Operation List view count has to matched as "+BL_Num_Cout+ " || Actual  : BLs are listed in Operation List view count : Non-Container summary count : "+ Cargo_bl_num,test, test1);
		 }else {
			 System.out.println("Not Matched || Expected :  BLs are listed in Operation List view count has to matched as "+BL_Num_Cout+ " || Actual  : BLs are listed in Operation List view count : "+ Cargo_bl_num);
			 Extent_fail(driver,"Not Matched || Expected :  BLs are listed in Operation List view count has to matched as "+BL_Num_Cout+ " || Actual  : BLs are listed in Operation List view count : Non-Container summary count : "+ Cargo_bl_num,test, test1);
		 }
		
		
		
		Step_End(17, "Verify that Make sure BLs are listed in Operation List view and Non-Container summary", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
    }
 
}