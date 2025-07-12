package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC113 extends Keywords {
	public void Import_Documentation_SC113(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name="TC_Import_Documentation_SC113";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Portcode = Excel_data.get("Portcode");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String ModuleDischargeReconciliation = Excel_data.get("ModuleDischargeReconciliation");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String DR_Plan_Option = Excel_data.get("DR_Plan_Option");
		String BL_Num = Excel_data.get("BL_Num");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Terminal = Excel_data.get("Terminal");
		String pol_Value = Excel_data.get("pol_Value");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Condition_Filter = Excel_data.get("Condition_Filter");

		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login to the Application
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);


		//	Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);

		Extent_cal(test, test1, "Import Documentation");
		Step_Start(2, "Open the import documentation module.", test, test1);
		moduleNavigate(driver, moduleImportDoc);

		Step_End(2, "Open the import documentation module.", test, test1);

		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
	
			// Verifying New button is enabled	
			waitForDisplay(driver, NewButton_ToolBar);
			if(isdisplayed(driver, NewButton_ToolBar) && IsElementEnabled(driver, NewButton_ToolBar)) {
				Step_Start(3, "In the toolbar, only the Home button and Search button are enabled.", test, test1);
				Step_Start(4, "Click the Home button", test, test1);
				click(driver, NewButton_ToolBar);
				Step_End(4, "Click the Home button", test, test1);
				Step_End(3, "In the toolbar, only the Home button and Search button are enabled.", test, test1);

				Step_Start(5, "The system will validate and prompt: \"\"Do you want to create a new Import Documentation?\"\" Select NO or YES", test, test1);

				waitForPopup(driver, popup_Message, New_Import_Documentation);
				String NewImportDocumentation = getText(driver, popup_Message);
				if (New_Import_Documentation.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected popup was : " + New_Import_Documentation+ " || Actual popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected popup was : " + New_Import_Documentation+ " || Actual popup was : " + NewImportDocumentation, test, test1);
		
				} else {
					System.out.println("NotMatched || Expected popup was : " + New_Import_Documentation+ " || Actual popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected popup was : " + New_Import_Documentation	+ " || Actual popup was : " + NewImportDocumentation, test, test1);
				}
				Step_End(5, "The system will validate and prompt: \"\"Do you want to create a new Import Documentation?\"\" Select NO or YES", test, test1);
				Step_Start(6, "Click the Yes button", test, test1);

				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
				Step_End(6, "Click the Yes button", test, test1);
		
			}
			
			Step_Start(7, "The Service, POL search field, all dropdown fields, and Show BL's button are enabled.", test, test1);
			Step_Start(8, "Enter the valid service.", test, test1);
	
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);
			Step_End(7, "The Service, POL search field, all dropdown fields, and Show BL's button are enabled.", test, test1);
			Step_End(8, "Enter the valid service.", test, test1);

			Step_Start(9, "Populate the vessel details based on the provided service", test, test1);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Portcode.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Portcode);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			Step_End(9, "Populate the vessel details based on the provided service", test, test1);

			Step_Start(10, "Select the service and vessel details.", test, test1);
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			Step_End(10, "Select the service and vessel details.", test, test1);

			Step_Start(11, "Click the Show BL's button.", test, test1);
			scrollTop(driver);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);
	
			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			Step_End(11, "Click the Show BL's button.", test, test1);

			Step_Start(12, "The respective service and vessel-based BL's will be shown in the import documentation module", test, test1);
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
	
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);

			Step_End(12, "The respective service and vessel-based BL's will be shown in the import documentation module", test, test1);
		}
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
			
		Step_Start(13, "total no of bl's count has shown", test, test1);

		waitForElement(driver, BL_Count);
		String count = getText(driver, BL_Count);
		String[] total_BL = count.split("/");
		String Total_Count = total_BL[1];
		Step_End(13, "total no of bl's count has shown", test, test1);
		Step_Start(14, "open the discharge reconcillation module", test, test1);

		moduleNavigate(driver, ModuleDischargeReconciliation);

		Step_End(14, "open the discharge reconcillation module", test, test1);
		
		Step_Start(15, "click the new button", test, test1);
		newButton(driver);
		Step_End(15, "click the new button", test, test1);
		
		Step_Start(16, "service and vessel field has enabled.", test, test1);
		Step_Start(17, "enter the serive", test, test1);
		waitForElement(driver, DisRecServiceInput);
		sendKeys(driver, DisRecServiceInput, Service);

		Step_End(16, "service and vessel field has enabled.", test, test1);
		Step_End(17, "enter the serive", test, test1);
		Step_Start(18, "system will auto populate the vessel details", test, test1);

		if(!Vessel.trim().equals("")) {
			waitForElement(driver, vesselcode);
			sendKeys(driver, vesselcode, Vessel);
		}
		if(!Voyage.trim().equals("")) {
			waitForElement(driver, voyagecode);
			sendKeys(driver, voyagecode, Voyage);
		}
		
		if(!Bound.trim().equals("")) {
			waitForElement(driver, bound);
			sendKeys(driver, bound, Bound);
		}
		if(!Portcode.trim().equals("")) {
			waitForElement(driver, portcode);
			sendKeys(driver, portcode, Portcode);
		}
		
		Step_End(18, "system will auto populate the vessel details", test, test1);
		Step_Start(19, "select the correct vessel details", test, test1);

		waitForElement(driver, selectbtn);
		click(driver, selectbtn);
		Step_End(19, "select the correct vessel details", test, test1);
		Step_Start(20, "click the download BL(s)", test, test1);
		waitForElement(driver, Plan_Option);
		click(driver, Plan_Option);
		String option_Select = String.format(Plan_Option_Select, DR_Plan_Option);
		waitForElement(driver, option_Select);
		click(driver, option_Select);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(20, "click the download BL(s)", test, test1);
		Step_Start(21, "system has shown the bl's for that service", test, test1);
		Step_End(21, "system has shown the bl's for that service", test, test1);
		Step_Start(22, "right side corner total bl count has shown", test, test1);

		waitForElement(driver, Total_Records_DR);
		String total_Records = getText(driver, Total_Records_DR);
		Step_End(22, "right side corner total bl count has shown", test, test1);
		Step_Start(23, "bl count should be match with discharge reconcillation and import documentation", test, test1);

		if (Total_Count.equals(total_Records)) {
			Extent_pass_New(driver, "Matched || Expected Total BL Number Count in the Import Documentatio Module : " + Total_Count + " || Actual Total Records count in Discharge Reconciliation Module : " + total_Records, test, test1);
			System.out.println("Matched || Expected Total BL Number Count in the Import Documentatio Module : " + Total_Count + " || Actual Total Records count in Discharge Reconciliation Module : " + total_Records);
		} else {
			System.out.println("Not Matched || Expected Total BL Number Count in the Import Documentatio Module : " + Total_Count + " || Actual Total Records count in Discharge Reconciliation Module : " + total_Records);
			Extent_fail(driver, "Not Matched || Expected Total BL Number Count in the Import Documentatio Module : " + Total_Count + " || Actual Total Records count in Discharge Reconciliation Module : " + total_Records, test,
					test1);
			}
		Step_End(23, "bl count should be match with discharge reconcillation and import documentation", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
