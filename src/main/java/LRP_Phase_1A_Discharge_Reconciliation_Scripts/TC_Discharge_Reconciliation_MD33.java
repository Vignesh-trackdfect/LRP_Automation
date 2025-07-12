package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD33 extends Keywords {
public void Discharge_Reconciliation_MD33(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD33";
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
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Switch to agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);


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
		
		
		 Step_Start(7, "Capture the count of row donwloaded under voyage,", test, test1);
		 waitForElement(driver, Voyage_Count);
		 String val1 = getText(driver, Voyage_Count).trim();
		Extent_pass(driver, "Downloaded count  is :"+val1, test, test1);
		System.out.println(val1);
		Step_End(7, "Capture the count of row donwloaded under voyage,", test, test1);
		
		
		Step_Start(8, "Click on Show Summary button", test, test1);
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(8, "Click on Show Summary button", test, test1);
		
		Step_Start(9, "Go to mapped BL Text area", test, test1);
		Step_Start(10, "Capture the Mapped BL Value,", test, test1);
		
		
		waitForElement(driver, Mapped_bl);
		String val2 = getAttribute(driver, Mapped_bl, "value");
		Extent_pass(driver, "The Value Present in the  Mapped_bl Text Area is :"+val2, test, test1);
		System.out.println(val2);
		
		Step_End(9, "Go to mapped BL Text area", test, test1);
		Step_End(10, "Capture the Mapped BL Value,", test, test1);
		
		Step_Start(11, "Verify that Downloaded count and mapped BL Count has to be matched", test, test1);
		
		if (val1.equals(val2)) {
			Extent_pass(driver, "Excepted The count of row donwloaded under voyage in || Discharge Reconciliation  is :"+ val1+ "Actual The Value Present in the  Mapped_bl Text Area || The Mapped_bl count is :"+val2 , test, test1);
			System.out.println("Excepted The count of row donwloaded under voyage in || Discharge Reconciliation  is :"+ val1+ "Actual The Value Present in the  Mapped_bl Text Area || The Mapped_bl count is :"+val2 );
			
			
		} else {
			Extent_fail(driver, "UnExcepted The count of row donwloaded under voyage in || Discharge Reconciliation  is :"+ val1+ "Actual The Value Present in the  Mapped_bl Text Area || The Mapped_bl count is :"+val2  , test, test1);
			System.out.println("UnExcepted The count of row donwloaded under voyage in || Discharge Reconciliation  is :"+ val1+ "Actual The Value Present in the  Mapped_bl Text Area || The Mapped_bl count is :"+val2 );

		}
		
		Step_End(11, "Verify that Downloaded count and mapped BL Count has to be matched", test, test1);


        Extent_completed(testcase_Name, test, test1);	

}
}