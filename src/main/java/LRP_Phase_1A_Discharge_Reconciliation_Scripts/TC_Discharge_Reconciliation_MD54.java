package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD54 extends Keywords {
	public void Discharge_Reconciliation_MD54(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD54";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Type=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);	
		String Bl_Number=Excel_data.get("Bl_Number");
		String Ports_Agency_name=Excel_data.get("Ports_Module");
		String GlobalSearch_type_1=Excel_data.get("Select_Search_Type_Ports");
		String GlobalSearch_Condition_1=Excel_data.get("Global_Search_Condition");
		String Stuff_Module_name=Excel_data.get("StuffPlan_Module");
		String GlobalSearch_type_2=Excel_data.get("Select_Search_Type_StuffPlan");
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency,", test, test1);
		
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);


		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.", test, test1);
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				waitForElement(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC,Terminal_Input);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, "Select the Plan as ALL/Local/Transhipment.", test, test1);
		
		Step_Start(6, " Click on Download BL Button", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button", test, test1);
		
		Step_Start(7, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);
		waitForElement(driver, Show_Summary_Btn);
		click(driver, Show_Summary_Btn);
		Step_End(7, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);
		Step_Start(8, "click Non-Containerized Shipment summary.", test, test1);
		waitForElement(driver, Non_Container_Shipment_Summary_Btn);
		click(driver, Non_Container_Shipment_Summary_Btn);
		Step_End(8, "click Non-Containerized Shipment summary.", test, test1);
		
		
		
		Step_Start(9, "Go to Cargo Section,", test, test1);
		Step_Start(10, ".Make sure that BL number should be listed, and copy the Book NO", test, test1);
		waitForElement(driver, Cargo_Detials_Filter_Btn);
		click(driver, Cargo_Detials_Filter_Btn);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
		waitForElement(driver, Cargo_Pol_Detials);
		
		String Pol_Code = getText(driver, Cargo_Pol_Detials);
		String Cargo_Book_no = getText(driver, Cargo_Book_Detials);
		
		click(driver, Non_Container_Shipment_Summary_Close_Btn);
		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);
		
		Step_End(9, "Go to Cargo Section,.", test, test1);
		Step_End(10, ".Make sure that BL number should be listed, and copy the Book NO", test, test1);
		
		Step_Start(11, "Go to load agency( go to switch profile and switch it)", test, test1);
		moduleNavigate(driver, Ports_Agency_name);
		
		waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, GlobalSearch_Condition_1, GlobalSearch_type_1, Pol_Code, "", "", "", "");
	waitForElement(driver, Agency_input_tab);
		String Agency_Code = getAttribute(driver, Agency_input_tab, "value");
		SwitchProfile(driver, Agency_Code);
		Step_End(11, "Go to load agency( go to switch profile and switch it)", test, test1);
		Step_Start(12, "Open Stuffing Plan BB/RORO module", test, test1);
		moduleNavigate(driver, Stuff_Module_name);
		Step_End(12, "Open Stuffing Plan BB/RORO module", test, test1);
		
		Step_Start(13, "Click on search Field,", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(13, "Click on search Field,", test, test1);
		
	
		Step_Start(14, "Paste the Book No which is Copyied in Discharge reconciliation module", test, test1);
		Step_Start(15, "Click on select Button and load it,", test, test1);
		globalValueSearchWindow(driver, GlobalSearch_Condition_1, GlobalSearch_type_2, Cargo_Book_no, "", "", "", "");
		
		Step_End(14, "Paste the Book No which is Copyied in Discharge reconciliation module", test, test1);
		Step_End(15, "Click on select Button and load it,", test, test1);
		Step_Start(16, "make sure Book NO is listed in the Module.", test, test1);
		if (isDisplayed(driver, Stuff_BB_Book_no)) {
			 System.out.println("pass: The Book No from Discharge module is  Present in Stuff BB/RORO  Module ");
				Extent_pass(driver, "pass: The Book No from Discharge module is  Present in Stuff BB/RORO  Module ", test, test1);
			String Stuff_book_no_value = getText(driver, Stuff_BB_Book_no);
			if (Cargo_Book_no.equals(Stuff_book_no_value)) {
				System.out.println("pass: The Expected  Book NO is from discharge module "+Cargo_Book_no+"  The Actual is Book No is from Stuff BB/RORO Module  " +Stuff_book_no_value);
				Extent_pass(driver, "pass: The Expected  Book NO is from discharge module "+Cargo_Book_no+"  The Actual is Book No is from Stuff BB/RORO Module  " +Stuff_book_no_value, test, test1);
			} else {
				System.out.println("fail: The Expected  Book NO is from discharge module "+Cargo_Book_no+"  The Actual is Book No is from Stuff BB/RORO Module  " +Stuff_book_no_value);
				Extent_fail(driver, "fail: The Expected  Book NO is from discharge module "+Cargo_Book_no+"  The Actual is Book No is from Stuff BB/RORO Module  " +Stuff_book_no_value, test, test1);
			}
			
		 } else {
			 System.out.println("fail: The Book no from Discharge module is not Present in Stuff BB/RORO  Module ");
				Extent_fail(driver, "fail: The Book no from Discharge module is not Present in Stuff BB/RORO  Module ", test, test1);

		}
		Step_End(16, "make sure Book NO is listed in the Module.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
		
		
	
		
		
		
	}

}
