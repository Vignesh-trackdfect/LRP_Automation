package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC070  extends Keywords{
	
	public void Import_Documentation_SC070(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC070";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String AgencyUser1 = Excel_data.get("AgencyUser1");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String bl_Number = Excel_data.get("BL_Number");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String pol_Value = Excel_data.get("pol_Value");
		String Delete_perform = Excel_data.get("Delete_perform");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
	    
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);
		
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);
		
		
		Extent_cal(test, test1, "Import Documentation");	
		Step_Start(2, "Open the import documentation module.", test, test1);
		Extent_cal(test, test1," module_ImportDocumentation");
		moduleNavigate(driver, ImportDocumentationModule);


		Step_End(2, "Open the import documentation module.", test, test1);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);

			Step_End(2, "Open the import documentation module click on search field and enter the BL no", test, test1);
			
		
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation=getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
					waitForElement(driver, popup_Message_Yes_Button);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
				}
			}
			
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

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
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
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
			
			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, bl_Number);
	
		}
		
		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			System.out.println("bl was already saved");
		}else {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		
		if(isClickable(driver, Edit_Button_toolBar)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		
		
		waitForDisplay(driver, Delivary_order_button_IMP_DOC);
		if(isClickable(driver, Delivary_order_button_IMP_DOC)) {
			System.out.println("Expected : Delivery Order button Should be Disable || Actual : Delivery Order button is not Disabled ");
			Extent_fail(driver, "Expected : Delivery Order button Should be Disable || Actual : Delivery Order button is not Disabled", test, test1);
		}else {
			System.out.println("Expected : Delivery Order button Should be Disable || Actual : Delivery Order button is Disabled");
			Extent_pass_New(driver, "Expected : Delivery Order button Should be Disable || Actual : Delivery Order button is Disabled", test, test1);
		}

		
			Step_Start(1, "Switch to agency.", test, test1);
			SwitchProfile(driver, AgencyUser1);
			Step_End(1, "Switch to agency.", test, test1);
			
			verifyMainMenu(driver);
			Extent_cal(test, test1, "Import Documentation");	
			Step_Start(2, "Open the import documentation module.", test, test1);
			Extent_cal(test, test1," module_ImportDocumentation");
			moduleNavigate(driver, ImportDocumentationModule);

			Step_End(2, "Open the import documentation module.", test, test1);
			
			if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);


				Step_End(2, "Open the import documentation module click on search field and enter the BL no", test, test1);
				Step_Start(3, "Load the BL in search field ", test, test1);


			}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
				waitForDisplay(driver, NewButton_ToolBar);
				if(isClickable(driver, NewButton_ToolBar)) {
					click(driver, NewButton_ToolBar);
					waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
					String NewImportDocumentation=getText(driver, popup_Message).trim();
					if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
						System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
						Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation, test,test1);
						waitForElement(driver, popup_Message_Yes_Button);
						safeclick(driver, popup_Message_Yes_Button);
					} else {
						System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation);
						Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup + " || Actual Popup was : " + NewImportDocumentation,test, test1);
					}
				}
				
				waitForElement(driver, ServiceInput_IMD);
				sendKeys(driver, ServiceInput_IMD, Service);

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
				if(!Port.trim().equals("")) {
					scrollUsingElement(driver, grid_scroll);
					horizontalscroll(driver, grid_scroll, 100);
					waitForElement(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC, Port);
				}
				if(!Terminal.trim().equals("")) {
					waitForElement(driver, grid_scroll);
					scrollUsingElement(driver, grid_scroll);
					horizontalscroll(driver, grid_scroll, 500);
					click1(driver,grid_terminal_IMP_DOC);
					sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
				}
				waitForElement(driver, Select_Service_Details);
				click(driver, Select_Service_Details);
				
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				
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
				waitForElement(driver, Local_Check_Box);
				checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
				waitForElement(driver, Transhipment_Check_Box);
				checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);


				waitForElement(driver, BL_SearchButton_IMP_DOC);
				click(driver, BL_SearchButton_IMP_DOC);
				twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, bl_Number);

			}
			
			if(isClickable(driver, Edit_Button_toolBar)) {
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
			}

			waitForDisplay(driver, Delivary_order_button_IMP_DOC);
			if(isClickable(driver, Delivary_order_button_IMP_DOC)) {
				System.out.println("Expected : Delivery Order button Should be Enable || Actual : Delivery Order button is Enabled");
				Extent_pass_New(driver, "Expected : Delivery Order button Should be Enable || Actual : Delivery Order button is Enabled", test, test1);
			}else {
				System.out.println("Expected : Delivery Order button Should be Enable || Actual : Delivery Order button is Disabled");
				Extent_fail(driver, "Expected : Delivery Order button Should be Enable || Actual : Delivery Order button is Disabled", test, test1);
			}
			
			Step_Start(6, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
     			   + "YES or N0 ", test, test1);
     	   Step_Start(7, "click the yes and system has validate import documentation is deleted", test, test1);
     	   
			if(Delete_perform.equalsIgnoreCase("YES")){
				SwitchProfile(driver, AgencyUser);
				moduleNavigate(driver, ImportDocumentationModule);
	
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, bl_Number, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
	
				deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
        	 
			}
			Step_End(6, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
	     			   + "YES or N0 ", test, test1);
			Step_End(7, "click the yes and system has validate import documentation is deleted", test, test1);
					
			Extent_completed(testcase_Name, test, test1);
					
	}
					
}
				
