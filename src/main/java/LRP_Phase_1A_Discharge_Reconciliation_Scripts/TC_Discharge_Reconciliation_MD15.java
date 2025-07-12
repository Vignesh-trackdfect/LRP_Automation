package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD15 extends Keywords {

	public void Discharge_Reconciliation_MD15(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD15";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Plan_Input = Excel_data.get("Plan_Input");
		String BL_Number_Header = Excel_data.get("BL_Number_Header");
		String condition = Excel_data.get("condition");
		String MCN_Exists_Expected = Excel_data.get("MCN_Exists_Expected");
		String MCN_Available_Expected = Excel_data.get("MCN_Available_Expected");

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
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(7, "Click on Show Summary button", test, test1);

		Step_Start(8, "Click on MCN Yet to be refreshed button in Discharge recon", test, test1);

		waitForElement(driver, MCN_Ref_btn_DR);
		click(driver, MCN_Ref_btn_DR);
		Step_End(8, "Click on MCN Yet to be refreshed button in Discharge recon", test, test1);

		Step_Start(9, "Copy the BL NO and MCN NO from the First ROW", test, test1);

		waitForElement(driver, Dis_Bl_Gird_first);
		String bl_Mcn_tab = getText(driver, Dis_Bl_Gird_first);
		Step_End(9, "Copy the BL NO and MCN NO from the First ROW", test, test1);

		Step_Start(10, "Close MCN Yet to be refreshed window and show Summary Window", test, test1);

		waitForElement(driver, Dis_Bl_Gird_first);
		String No_Mcn_tab = getText(driver, Dis_Bl_Gird_first);
		System.out.println(No_Mcn_tab);
		Extent_pass(driver, "Mcn No was shown in mcn tab was" + No_Mcn_tab, test, test1);

//		waitForElement(driver, Close_btn_DR);
//		click(driver, Close_btn_DR);

		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);
		Step_End(10, "Close MCN Yet to be refreshed window and show Summary Window", test, test1);

		Step_Start(11, " Open Import Documentation", test, test1);

		waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
		Step_End(11, " Open Import Documentation", test, test1);

		

		Step_Start(12, " Load the BL Copied in Discharge recon", test, test1);

		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);

		twoColumnSearchWindow(driver, BL_Number_Header, condition, bl_Mcn_tab);
		Step_End(12, " Load the BL Copied in Discharge recon", test, test1);

		Step_Start(13, "Verify that new label has shown as MCN Available or New MCN Exists", test, test1);

		String MCN_avaliable = getText(driver, mcn_avaliable_text);
		System.out.println(MCN_avaliable);

		if (MCN_avaliable.equalsIgnoreCase(MCN_Available_Expected)) {

			if (MCN_Available_Expected.equalsIgnoreCase(MCN_avaliable)) {
				System.out.println("MATCHED || EXPECTED BL Number should be have Mcn Available: "
						+ MCN_Available_Expected + " ACTUAL BL Number shown Mcn Available :" + MCN_avaliable);
				Extent_pass(driver, "MATCHED || EXPECTED BL Number should be have Mcn Available: "
						+ MCN_Available_Expected + " ACTUAL BL Number shown Mcn Available :" + MCN_avaliable, test,
						test1);
			} else {

				System.out.println("NOT MATCHED || EXPECTED BL Number should be have Mcn Available: "
						+ MCN_Available_Expected + " ACTUAL BL Number not shown Mcn Available :" + MCN_avaliable);
				Extent_fail(driver, "NOT MATCHED || EXPECTED BL Number should be have Mcn Available: "
						+ MCN_Available_Expected + " ACTUAL BL Number not shown Mcn Available :" + MCN_avaliable, test,
						test1);

			}
		}

		if (MCN_avaliable.equalsIgnoreCase(MCN_Exists_Expected)) {

			if (MCN_avaliable.equalsIgnoreCase(MCN_Exists_Expected)) {
				System.out.println("MATCHED || EXPECTED BL Number should be have Mcn Exists: " + MCN_Exists_Expected
						+ " ACTUAL BL Number shown Mcn Exists :" + MCN_avaliable);
				Extent_pass(driver, "MATCHED || EXPECTED BL Number should be have Mcn Exists: " + MCN_Exists_Expected
						+ " ACTUAL BL Number shown Mcn Exists :" + MCN_avaliable, test, test1);
			} else {

				System.out.println("NOT MATCHED || EXPECTED BL Number should be have Mcn Exists: " + MCN_Exists_Expected
						+ " ACTUAL BL Number not shown Mcn Exists :" + MCN_avaliable);
				Extent_fail(driver, "NOT MATCHED || EXPECTED BL Number should be have Mcn Exists: "
						+ MCN_Exists_Expected + " ACTUAL BL Number not shown Mcn Exists :" + MCN_avaliable, test,
						test1);

			}
		}

		Step_End(13, "Verify that new label has shown as MCN Available or New MCN Exists", test, test1);

		Step_Start(14, "14. go to BL/HBL summary tab", test, test1);

		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver, BL_HBL_Summary_Tab);

		Step_End(14, " go to BL/HBL summary tab", test, test1);

		Step_Start(15, "Verify that system should not have the Copied MCN NO in MCN Text Field", test, test1);
		waitForElement(driver, MCN_Text_Field);
		String Mcn_text = getText(driver, MCN_Text_Field);

		if (!No_Mcn_tab.equals(Mcn_text)) {
			System.out.println("Not Matched || Expected Mcn number present in the discharge module : " + No_Mcn_tab
					+ " || Actual Mcn number present in the Import Documentation module : " + Mcn_text);
			Extent_pass(driver,
					"Not Matched || Expected Mcn number present in the discharge module : " + No_Mcn_tab
							+ " || Actual Mcn number present in the Import Documentation module : " + Mcn_text,
					test, test1);
		} else {
			System.out.println("Matched || Expected Mcn number present in the discharge module : " + No_Mcn_tab
					+ " || Actual Mcn number present in the Import Documentation module : " + Mcn_text);
			Extent_fail(driver,
					"Matched || Expected Mcn number present in the discharge module : " + No_Mcn_tab
							+ " || Actual Mcn number present in the Import Documentation module  : " + Mcn_text,
					test, test1);
		}

		Step_End(15, "Verify that system should not have the Copied MCN NO in MCN Text Field", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
