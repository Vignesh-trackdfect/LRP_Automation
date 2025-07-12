package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC072 extends Keywords {

	public void Import_Documentation_SC072(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name = "TC_Import_Documentation_SC072";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String Delivery_saved_Popup_Value = Excel_data.get("Delivery_saved_Popup_Value");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String pol_Value = Excel_data.get("pol_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Delivery_delete_popup_expected = Excel_data.get("Delivery_delete_popup_expected");
		String Delivery_deleted_expected = Excel_data.get("Delivery_deleted_expected");
		String Import_Document_Saved_popup = Excel_data.get("Import_Document_Saved_popup");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		String Want_To_Delete_ImportDoc = Excel_data.get("Want_To_Delete_ImportDoc");

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		SwitchProfile(driver, AgencyUser);

		Extent_cal(test, test1, "Import Documentation");
		Step_Start(1, "open the import documentation and retrieve the new bill using tool bar search", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if (BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search,
					Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);

		} else if (BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if (IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
				waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
				String NewImportDocumentation = getText(driver, popup_Message).trim();
				if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
					System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
					safeclick(driver, popup_Message_Yes_Button);
				} else {
					System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation);
					Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup
							+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
				}
			}
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

			if (!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if (!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if (!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if (!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if (!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);

			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);

			scrollTop(driver);
			if (!pol_Value.trim().equals("")) {
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
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);

		}
		Step_End(1, "open the import documentation and retrieve the new bill using tool bar search", test, test1);


		Step_Start(2,
				"click the save button - bl has saved in import documentation system has validate import documentation is saved",
				test, test1);
		waitForDisplay(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		if(BL_Value.equalsIgnoreCase("NEW")) {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Import_Document_Saved_popup);
			String savedPopupAct=getText(driver, popup_Message);
			if(Import_Document_Saved_popup.equalsIgnoreCase(savedPopupAct)) {
				System.out.println("Popup Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct);
				Extent_pass_New(driver, "Popup Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct, test, test1);
			}else {
				System.out.println("Popup Not Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct);
				Extent_fail(driver, "Popup Not Matched || Expected : "+Import_Document_Saved_popup+" || Actual : "+savedPopupAct, test, test1);
			
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
	
		Step_End(2,
				"click the save button - bl has saved in import documentation system has validate import documentation is saved",
				test, test1);

		 waitForElement(driver, importDoc_RemarksTab);
		 click(driver, importDoc_RemarksTab);
	        
		 waitForElement(driver, Delivery_Order_checkbox);
		 String DeliveryOrder_perform = getAttribute(driver, Delivery_Order_checkbox, "class");
		
		if(!DeliveryOrder_perform.contains("active")&&!DeliveryOrder_perform.contains("Active")) {
			Step_Start(3, "once saved the import documentation navigate to the delivery order", test, test1);
			
			waitForElement(driver, Delivery_Order_Button);
			click(driver, Delivery_Order_Button);
			Step_End(3, "once saved the import documentation navigate to the delivery order", test, test1);

			Step_Start(4, "open the delivery order module and saved the delivery order.", test, test1);
			// scrollBottom(driver);
			
			waitForElement(driver, Delivery_Order_SelectALL_checkBox);
			click(driver, Delivery_Order_SelectALL_checkBox);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);

			waitForPopup(driver, Popup_Message, Delivery_saved_Popup_Value);
			String Delivery_Saved_Popup = getText(driver, Popup_Message);
			if (Delivery_saved_Popup_Value.equals(Delivery_Saved_Popup)) {
				System.out.println("Matched || Expected Popup was : " + Delivery_saved_Popup_Value	+ " || Actual Popup was : " + Delivery_Saved_Popup);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + Delivery_saved_Popup_Value+ " || Actual Popup was : " + Delivery_Saved_Popup, test, test1);

			} else {
				System.out.println("NotMatched || Expected Popup was : " + Delivery_saved_Popup_Value+ " || Actual Popup was : " + Delivery_Saved_Popup);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + Delivery_saved_Popup_Value+ " || Actual Popup was : " + Delivery_Saved_Popup, test, test1);
			}
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(4, "open the delivery order module and saved the delivery order.", test, test1);

	        Step_Start(5, "retrive the same bill in import documentation", test, test1);    
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
	        Step_End(5, "retrive the same bill in import documentation", test, test1);    

		} 
        Step_Start(6, "click the edit button in import documentation", test, test1);    
		waitForElement(driver, Edit_Button_toolBar);
        click(driver, Edit_Button_toolBar);
        if(isdisplayed(driver, popup_Message_Ok_Button)) {
        	waitForElement(driver, popup_Message_Ok_Button);
        	safeclick(driver, popup_Message_Ok_Button);
        }
        Step_End(6, "click the edit button in import documentation", test, test1);    
        
        Step_Start(7, "DO issue location field has disabled.", test, test1);
		Step_Start(8, "once verified then close the import documentation module", test, test1);

    	waitForElement(driver, Issue_location_search_IMP);
		if(isClickable(driver, Issue_location_search_IMP)) {
			System.out.println("Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is Enabled when Import Invoice is available.");
			Extent_fail(driver, "Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is Enabled when Import Invoice is available.", test, test1);
		}else {
			System.out.println("Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is not Enabled when Import Invoice is available.");
			Extent_pass_New(driver, "Expected : DO Issue Location Search button Should not be Enable if Import Invoice is available. || Actual : DO Issue Location Search button is not Enabled when Import Invoice is available.", test, test1);
		}
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(7, "DO issue location field has disabled.", test, test1);
		Step_End(8, "once verified then close the import documentation module", test, test1);


		if(Want_To_Delete_ImportDoc.equalsIgnoreCase("YES")) {
			Step_Start(9, "open the delivery order module and retive the bill", test, test1);
			Step_Start(10, "delete the delivery order .", test, test1);

			waitForElement(driver, Delivery_Order_Button);
			click(driver, Delivery_Order_Button);
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			
			waitForPopup(driver, popup_Message,Delivery_delete_popup_expected);
			String deliverDeletePopupAct=getText(driver, popup_Message);
			if(Delivery_delete_popup_expected.equalsIgnoreCase(deliverDeletePopupAct)) {
				System.out.println("Popup Matched || Expected : "+Delivery_delete_popup_expected+" || Actual : "+deliverDeletePopupAct);
				Extent_pass_New(driver, "Popup Matched || Expected : "+Delivery_delete_popup_expected+" || Actual : "+deliverDeletePopupAct, test, test1);
			}else {
				System.out.println("Popup Not Matched || Expected : "+Delivery_delete_popup_expected+" || Actual : "+deliverDeletePopupAct);
				Extent_fail(driver, "Popup Not Matched || Expected : "+Delivery_delete_popup_expected+" || Actual : "+deliverDeletePopupAct, test, test1);
			}
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForPopup(driver, Popup_Message,Delivery_deleted_expected);
			String deliverDeletePopupAct2=getText(driver, Popup_Message);
			if(Delivery_deleted_expected.equalsIgnoreCase(deliverDeletePopupAct2)) {
				System.out.println("Popup Matched || Expected : "+Delivery_deleted_expected+" || Actual : "+deliverDeletePopupAct2);
				Extent_pass_New(driver, "Popup Matched || Expected : "+Delivery_deleted_expected+" || Actual : "+deliverDeletePopupAct2, test, test1);
			}else {
				System.out.println("Popup Not Matched || Expected : "+Delivery_deleted_expected+" || Actual : "+deliverDeletePopupAct2);
				Extent_fail(driver, "Popup Not Matched || Expected : "+Delivery_deleted_expected+" || Actual : "+deliverDeletePopupAct2, test, test1);
			}
			Step_End(9, "open the delivery order module and retive the bill", test, test1);
			Step_End(10, "delete the delivery order .", test, test1);

			Step_Start(11, "open the import documentation module and retrive the bill ", test, test1);
			Step_Start(12, "new ,search,edit and delete icon has shown in tool bar", test, test1);
			Step_Start(13, "click the delete icon and system has validate( Do you want to delete import documentation )? Yes or No", test, test1);
			Step_Start(14, "click the yes and system has validate import documentation is deleted .", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
			
			Step_End(11, "open the import documentation module and retrive the bill ", test, test1);
			Step_End(12, "new ,search,edit and delete icon has shown in tool bar", test, test1);
			Step_End(13, "click the delete icon and system has validate( Do you want to delete import documentation )? Yes or No", test, test1);
			Step_End(14, "click the yes and system has validate import documentation is deleted .", test, test1);

		}

		Extent_completed(testcase_Name, test, test1);

	}

}
