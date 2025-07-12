package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD14 extends Keywords {

	public void Discharge_Reconciliation_MD14(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD14";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String bl_Number = Excel_data.get("bl_Number");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Plan_Input = Excel_data.get("Plan_Input");
		String Bill_Of_Lading_Module = Excel_data.get("Bill_Of_Lading_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Discharge_Header = Excel_data.get("Discharge_Header");
		String Bill_global_Search = Excel_data.get("Bill_global_Search");
		String Shipemnt_Type_Expected = Excel_data.get("Shipemnt_Type_Expected");

		String select_Option_3 = String.format(DropDown_Select, Plan_Input);

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);

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
		waitForElement(driver, DownloadBLs);
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(7, "Click on Show Summary button", test, test1);

		Step_Start(8, "Click on Non-Container Shipment Summary Button in Discharge recon", test, test1);
		waitForElement(driver, DR_Non_Container_ss_btn);
		click(driver, DR_Non_Container_ss_btn);
		Step_End(8, "Click on Non-Container Shipment Summary Button in Discharge recon", test, test1);

		Step_Start(9, "Go to Cargo detail section and apply your BL NO which is available from Test data", test, test1);
		waitForElement(driver, Cargo_gird_Filter);
		click(driver, Cargo_gird_Filter);
		Step_End(9, "Go to Cargo detail section and apply your BL NO which is available from Test data", test, test1);

		Step_Start(10, "Verify that BL No is listed in Dropdown Button", test, test1);

		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);

		waitForElement(driver, Cargo_gird_Filter_bl);
		String bl_cargo_tab = getText(driver, Cargo_gird_Filter_bl);

		if (bl_Number.equals(bl_cargo_tab)) {
			System.out.println("Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in cargo tab : " + bl_cargo_tab);
			Extent_pass(driver, "Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in cargo tab : " + bl_cargo_tab, test, test1);
		} else {
			System.out.println("Not Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in cargo tab : " + bl_cargo_tab);
			Extent_fail(driver, "Not Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in cargo tab  : " + bl_cargo_tab, test, test1);
		}
		Step_End(10, "Verify that BL No is listed in Dropdown Button", test, test1);

		Step_Start(11, "Close the Non-container shipment summary window", test, test1);
		waitForElement(driver, Non_Con_tab_close);
		click(driver, Non_Con_tab_close);

		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);
		Step_End(11, "Close the Non-container shipment summary window", test, test1);

		Step_Start(12,
				"apply the Condition Filter in discharge recon module && apply your BL NO which is available from Test data",
				test, test1);

		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		Step_End(12,
				"apply the Condition Filter in discharge recon module && apply your BL NO which is available from Test data",
				test, test1);

		Step_Start(13, " Verify that BL NO is available", test, test1);

		waitForElement(driver, Dis_Bl_Gird_first);
		String bl_Dis_tab = getText(driver, Dis_Bl_Gird_first);

		if (bl_Number.equals(bl_Dis_tab)) {
			System.out.println("Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in Gird : " + bl_Dis_tab);
			Extent_pass(driver, "Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in Gird : " + bl_Dis_tab, test, test1);
		} else {
			System.out.println("Not Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in Gird : " + bl_Dis_tab);
			Extent_fail(driver, "Not Matched || Expected BL Number given in test data : " + bl_Number
					+ " || Actual BL Number present in Gird  : " + bl_Dis_tab, test, test1);
		}

		Step_End(13, " Verify that BL NO is available", test, test1);

		Step_Start(14, " Open Bill of Lading module", test, test1);
		moduleNavigate(driver, Bill_Of_Lading_Module);
		Step_End(14, " Open Bill of Lading module", test, test1);

		Step_Start(15, " Load the same BL in Bill of lading module", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, BL_Condition, Bill_global_Search, bl_Number, "", "", "", "");
		Step_End(15, " Load the same BL in Bill of lading module", test, test1);

		Step_Start(16, " Verify that Shipment Type is selected as Un-Containerized", test, test1);
		waitForElement(driver, BL_Shipment_Type);
		String bl_cargo_type = getAttribute(driver, BL_Shipment_Type, "value");

		if (Shipemnt_Type_Expected.equals(bl_cargo_type)) {
			System.out.println("Matched || Expected BL Number shipment type should be shown : " + Shipemnt_Type_Expected
					+ " || Actual BL Number shipment type present in bill of lading  : " + bl_cargo_type);
			Extent_pass(driver,
					"Matched || Expected BL Number shipment type should be shown  : " + Shipemnt_Type_Expected
							+ " || Actual BL Number shipment type present in bill of lading: " + bl_cargo_type,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected BL Number shipment type should be shown : " + Shipemnt_Type_Expected
							+ " || Actual BL Number shipment type present in bill of lading : " + bl_cargo_type);
			Extent_fail(driver,
					"Not Matched || Expected BL Number shipment type should be shown : " + Shipemnt_Type_Expected
							+ " || Actual BL Number shipment type present in bill of lading  : " + bl_cargo_type,
					test, test1);
		}
		Step_End(16, "Verify that Shipment Type is selected as Un-Containerized", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
