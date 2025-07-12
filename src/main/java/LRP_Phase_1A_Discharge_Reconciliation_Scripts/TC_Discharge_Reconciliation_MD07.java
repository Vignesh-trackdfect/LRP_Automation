package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD07 extends Keywords{
	public void Discharge_Reconciliation_MD07(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD07";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options = Excel_data.get("Plan_Type");
		String Column_Header = Excel_data.get("DC_Column_Header");
		String Condition_Filter = Excel_data.get("DC_Condition_Filter");
		String bl_number = Excel_data.get("Bl_Number");


		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, " Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to Agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(3, "Click on new button if new button not available go below,", test, test1);

		Step_Start(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
		waitForElement(driver, Plan_Option);
		click(driver, Plan_Option);

		formatLocatorClick(driver, Plan_Option_Select, Plan_Options);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
		Step_Start(6, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button.", test, test1);
		
       Step_Start(7, "Capture the Total ROW Count", test, test1);
       Step_Start(8, " Click for More option Button that 9 dots at right side corner,", test, test1);
       Step_Start(9,"Click on Condition Filter,",test, test1);
	   Step_Start(10,"Enter the ANy one Value such BL Number/Delivery Type/HBLNUMBER(Column Header Bring it from Test Data based on that we shall Filter.),",test, test1);
         waitForElement(driver, Total_Records_DR);
		 String beforecountrecords = getText(driver, Total_Records_DR);
       
         System.out.println("TotalRecordsBefore:" +beforecountrecords);
         AGGridValueFilterMultipleValue(driver, Column_Header,Condition_Filter ,bl_number);
		
		 Step_End(7, "Capture the Total ROW Count", test, test1);
		 Step_End(8, " Click for More option Button that 9 dots at right side corner,", test, test1);
		 Step_End(9,"Click on Condition Filter,",test, test1);
		 Step_End(10,"Enter the ANy one Value such BL Number/Delivery Type/HBLNUMBER(Column Header Bring it from Test Data based on that we shall Filter.),",test, test1);
		 
		Step_Start(11, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		
		
		Step_End(11," Click on Download BL Button.", test, test1);
		
		Step_Start(12, " Catpure the Total ROW Count.", test, test1);
		 waitForElement(driver, Total_Records_DR);
			String aftercountrecords = getText(driver, Total_Records_DR);
		System.out.println("TotalRecordsAfter:" +aftercountrecords );
		Step_End(12, " Catpure the Total ROW Count.", test, test1);
		
		Step_Start(13,"Verify that ROW Count has to be matched with before/after download", test, test1);
		 if(beforecountrecords.equals(aftercountrecords)) {
			   System.out.println("Pass || Expected result:  Row count before download" + beforecountrecords + "|| Actual: Row count After download" + aftercountrecords);
			    Extent_pass(driver, "Pass || Expected result: Row count before download"  + beforecountrecords + " || Actual:Row count After download" + aftercountrecords, test, test1);
			} else {
			    System.out.println("Fail || Expected: Row count before download " + beforecountrecords + "  || Actual: Row count After download"+ aftercountrecords );
			    Extent_fail(driver, "Fail || Expected: Row count before download" + beforecountrecords + " || Actual: Row count After download"  + aftercountrecords, test, test1);

		
			}
		 
		Step_End(13,"Verify that ROW Count has to be matched with before/after download", test, test1);
		
		Extent_completed(test_Case_Name, test, test1);


	}

}
