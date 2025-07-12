package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC009 extends Keywords{

	public void Import_Documentation_SC009(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC009";
		
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleID=Excel_data.get("Module_ImportDocumentation");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
		String agencyUser = Excel_data.get("AgencyUser");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
        String voyagecode = Excel_data.get("voyagecode");
        String bound = Excel_data.get("bound");
        String portcode = Excel_data.get("portcode");
        String terminal = Excel_data.get("terminal");
        String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
        String bl_Number = Excel_data.get("bl_Number");
        String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String BL_Condition = Excel_data.get("BL_Condition");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition = Excel_data.get("Condition");

		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");

		String BOL_Select_Type1=Excel_data.get("BOL_Select_Type1");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");

		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");


//      String Get_BL_Number;
      String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testCaseName, test, test1);
//		Login
        navigateUrl(driver,url);		
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "Open the import documentation module", test, test1);
		moduleNavigate(driver, moduleID);
		Step_End(2, "Open the import documentation module", test, test1);

		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity

			if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
				click(driver, SearchButton_Toolbar);
				waitForElement(driver, SearchButton_Toolbar );
				
				globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

			}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

				Step_Start(4, "Click the Home button", test, test1);
				waitForDisplay(driver, NewButton_ToolBar);
				if(IsElementEnabled(driver, NewButton_ToolBar)) {
					click(driver, NewButton_ToolBar);

					Step_End(4, "Click the Home button", test, test1);

					Step_Start(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);
					waitForPopup(driver, popup_Message, New_Import_Documentation);
					String new_import_documentation=getText(driver, popup_Message);
					if(new_import_documentation.equals(New_Import_Documentation)) {
						System.out.println("Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
						Extent_pass_New(driver, "Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					}else {
						System.out.println("Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
						Extent_fail(driver, "Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					}

					Step_End(5, "The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.", test, test1);

					Step_Start(6, "Click the Yes button", test, test1);
					waitForElement(driver, popup_Message_Yes_Button);
					safeclick(driver, popup_Message_Yes_Button);
					Step_End(6, "Click the Yes button", test, test1);

				}

				Step_Start(8, "Enter the valid service", test, test1);
				waitForElement(driver, ServiceInput_IMD);
				sendKeys(driver, ServiceInput_IMD, Service_Name);
				Step_End(8, "Enter the valid service", test, test1);

				Step_Start(9, " Populate the vessel details based on the provided service.", test, test1);
				if(!vesselcode.trim().equals("")) {
					waitForElement(driver, grid_vesselcode_IMP_DOC);
					sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
				}
				if(!voyagecode.trim().equals("")) {
					sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
				}
				if(!bound.trim().equals("")) {
					sendKeys(driver, grid_bound_IMP_DOC, bound);
				}
				if(!portcode.trim().equals("")) {
					sendKeys(driver, grid_portcodeIMP_DOC, portcode);
				}
				if(!terminal.trim().equals("")) {
					waitForElement(driver, grid_scroll);
					scrollUsingElement(driver, grid_scroll);
					horizontalscroll(driver, grid_scroll, 300);
					click1(driver,grid_terminal_IMP_DOC);
					sendKeys(driver, grid_terminal_IMP_DOC, terminal);
				}
				Step_End(9, "Populate the vessel details based on the provided service", test, test1);

				Step_Start(10, "Select the service and vessel details", test, test1);
				waitForElement(driver, Select_Service_Details);
				click(driver,Select_Service_Details);
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);

				Step_End(10, "Select the service and vessel details", test, test1);
				Step_Start(11, "POL Search field-based on datasheet it will set", test, test1);

				scrollTop(driver);
				if(!pol_Value.trim().equals("")) {
					waitForElement(driver, POLSearch);
					click(driver, POLSearch);
					twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition, pol_Value);

				}
				Step_End(11, "POL Search field-based on datasheet it will set", test, test1);

				Step_Start(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);
				waitForElement(driver, slection_Label_1);
				click(driver, slection_Label_1);
				waitForElement(driver, select_Option_1);
				click(driver, select_Option_1);

				Step_End(12, "ALL ,SAVED BL AND UNSAVED BL-based on data set it will set", test, test1);

				Step_Start(13, "ALL,LOCAL,TRANS-Based on the data set it will set", test, test1);
				waitForElement(driver, slection_Label_2);
				click(driver, slection_Label_2);
				waitForElement(driver, select_Option_2);
				click(driver, select_Option_2);

				Step_End(13, "ALL,LOCAL,TRANS-Based on the data set it will sets", test, test1);

				Step_Start(14, "Click the Show BL's button", test, test1);
				waitForElement(driver, Show_BL_Button);
				click(driver, Show_BL_Button);

				Step_End(14, "Click the Show BL's button", test, test1);

				Step_Start(15, "The respective service and vessel-based BL's will be shown in the import documentation module.", test, test1);
				waitForElement(driver, Local_Check_Box);
				checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
				waitForElement(driver, Transhipment_Check_Box);
				checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
				
				waitForElement(driver, BL_Number);
				String Get_BL_Number = getAttribute(driver, BL_Number,"value");
				System.out.println("Get_BL_Number:"+ Get_BL_Number);
		      
				waitForElement(driver, BL_SearchButton_IMP_DOC);
				click(driver, BL_SearchButton_IMP_DOC);
				
				twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition, bl_Number);
				Step_End(15, "The respective service and vessel-based BL's will be shown in the import documentation module.", test, test1);

			}
			
			Step_Start(16, "Home page display the Bl type .in import documentation.", test, test1);
			waitForElement(driver, Bl_type);
			String Get_BL_Type = getText(driver, Bl_type);
			System.out.println("Get_BL_Type:"+ Get_BL_Type);
						
			waitForElement(driver, BL_HBL_Summary_Tab);
			click(driver,BL_HBL_Summary_Tab);
			waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
			String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
			
			Step_End(16, "Home page display the Bl type .in import documentation.", test, test1);
			
			if(MCN_Number.equals("")) {
				
				Step_Start(17, "open the bill of lading module", test, test1);

				moduleNavigate(driver, module_BillOfLading);
				Step_Start(17, "open the bill of lading module", test, test1);

				Step_Start(18, "load the bill in bill of lading module", test, test1);

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, BL_Condition, BOL_Select_Type1, bl_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
				
				Step_End(18, "load the bill in bill of lading module", test, test1);

				Step_Start(19, "bl type field value has to be shown  in bill module.", test, test1);
				waitForElement(driver, billof_lading_Bl_type);
				String bill_BL_Type = getText(driver, billof_lading_Bl_type);
				System.out.println("Get_BL_Type:"+ bill_BL_Type);
				
			
				Step_End(19, "bl type field value has to be shown  in bill module.", test, test1);
				
				Step_Start(20, "Home page display the Bl type .in import documentation.", test, test1);


				if(Get_BL_Type.equals(bill_BL_Type)) {
					System.out.println("Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type Bill of Lading : "+bill_BL_Type);
					Extent_pass_New(driver, "Matched || Expected  BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type Bill of Lading : "+bill_BL_Type, test, test1);
				}else {
					System.out.println("Not Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type Bill of Lading : "+bill_BL_Type);
					Extent_fail(driver, "Not Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type Bill of Lading : "+bill_BL_Type, test, test1);

				}
				Step_End(20, "Home page display the Bl type .in import documentation.", test, test1);
				
				
			}else {
				
				scrollTop(driver);
				moduleNavigate(driver, MCN_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
				
				waitForElement(driver, BL_Type_Input_MCN);
				String BL_TypeValue_MCN=getText(driver, BL_Type_Input_MCN);
				
				if(Get_BL_Type.equals(BL_TypeValue_MCN)) {
					System.out.println("Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type MCN Module : "+BL_TypeValue_MCN);
					Extent_pass_New(driver, "Matched || Expected  BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type MCN Module : "+BL_TypeValue_MCN, test, test1);
				}else {
					System.out.println("Not Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type MCN Module : "+BL_TypeValue_MCN);
					Extent_fail(driver, "Not Matched || Expected BL Type Import Documentation : "+Get_BL_Type +" || Actual BL Type MCN Module : "+BL_TypeValue_MCN, test, test1);
				}
			}
			
			Extent_completed(testCaseName, test, test1);
	}
}
