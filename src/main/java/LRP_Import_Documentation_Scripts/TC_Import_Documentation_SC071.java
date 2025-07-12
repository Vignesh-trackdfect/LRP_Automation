package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC071  extends Keywords{

	public void Import_Documentation_SC071(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC071";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Num = Excel_data.get("BL_Num");
		String Do_Issue_Location = Excel_data.get("Do_Issue_Location").trim();
		String Updated_pop = Excel_data.get("Updated_pop");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String pol_Value = Excel_data.get("pol_Value");
		String Delete_perform = Excel_data.get("Delete_perform");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Port = Excel_data.get("Port");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
	
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		
		Extent_cal(test, test1, "Import Documentation");	
		Step_Start(1, "open the import documentation module and retrieve the new bill using tool bar search.", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition1, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);


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

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);
			
		}
		
		waitForElement(driver, BL_Number);
		String Act_BL_Num=getAttribute(driver, BL_Number, "value");
		if(Act_BL_Num.equals(BL_Num)) {
			System.out.println("Matched : Expected BL Number : "+BL_Num+" || Actual BL Number "+Act_BL_Num);
			Extent_pass_New(driver, "Matched : Expected BL Number : "+BL_Num+" || Actual BL Number "+Act_BL_Num, test, test1);
		}else {
			System.out.println("Not Matched : Expected BL Number : "+BL_Num+" || Actual BL Number "+Act_BL_Num);
			Extent_fail(driver, "Not Matched : Expected BL Number : "+BL_Num+" || Actual BL Number "+Act_BL_Num, test, test1);
		}
		
		Step_End(1, "open the import documentation module and retrieve the new bill using tool bar search.", test, test1);

		Step_Start(2, "bl has saved in import documentation.", test, test1);
		
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_Value=getText(driver, BL_status_IMP_DOC);
		
		if(!BL_Value.equalsIgnoreCase("NEW")) {
			System.out.println("bl was already saved");
			Extent_pass_New(driver, "Expected : BL should Saved in the Import Document || Actual : BL Number is Saved ", test, test1);
		}else {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, "Import Document Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		Step_End(2, "bl has saved in import documentation.", test, test1);

		Step_Start(3, "once saved the import documentation edit button has enable in tool bar ", test, test1);
		if(IsElementEnabled(driver, Edit_Button_toolBar)) {
			System.out.println("Expected : Once saved the import documentation edit button should be enable in tool bar || Actual : once saved the import documentation edit button has enabled in tool bar ");
			Extent_pass_New(driver, "Expected : Once saved the import documentation edit button should be enable in tool bar || Actual : once saved the import documentation edit button has enabled in tool bar ", test, test1);
		}else {
			System.out.println("Expected : Once saved the import documentation edit button should be enable in tool bar || Actual : once saved the import documentation edit button not enabled in tool bar ");
			Extent_fail(driver, "Expected : Once saved the import documentation edit button should be enable in tool bar || Actual : once saved the import documentation edit button not enabled in tool bar ", test, test1);
		}
		Step_End(3, "once saved the import documentation edit button has enable in tool bar ", test, test1);
		
		Step_Start(4, " click the edit button ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(4, " click the edit button ", test, test1);

		Step_Start(5, "do issue location search field has enable ", test, test1);

		waitForDisplay(driver, Issue_location_search_IMP);
		if(isElementEnabled(driver, Issue_location_search_IMP)) {
			System.out.println("Expected : DO Issue Location Search button Should Enable || Actual : DO Issue Location Search button is Enabled");
			Extent_pass_New(driver, "Expected : DO Issue Location Search button Should Enable || Actual : DO Issue Location Search button is Enabled", test,test1);

		} else {
			System.out.println("Expected : DO Issue Location Search button Should Enable || Actual : DO Issue Location Search button is Disabled ");
			Extent_fail(driver, "Expected : DO Issue Location Search button Should  Enable || Actual : DO Issue Location Search button is Disabled", test,test1);
		
		}
		Step_End(5, "do issue location search field has enable", test, test1);

		Step_Start(6, "select and change the do issue location", test, test1);
		waitForElement(driver, Issue_location_search_IMP);
		String do_text_before= getAttribute(driver, Issue_location_text_IMP,"value");
		System.out.println(do_text_before);

		click(driver, Issue_location_search_IMP);
		twoColumnSearchWindow(driver, Port_Code_Header, Condition_Filter, Do_Issue_Location);

		Step_End(5, "select and change the do issue location", test, test1);

		Step_Start(6, "save the import documentation", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Updated_pop);
		String BL_updated_msg= getText(driver, popup_Message);

		if(BL_updated_msg.equals(Updated_pop)) {
			System.out.println("Matched || Expected Popup was : " + BL_updated_msg + " || Actual Popup was : " + Updated_pop);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_updated_msg + " || Actual Popup was : " + Updated_pop, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected Popup was : " + BL_updated_msg + " || Actual Popup was : " + Updated_pop);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + BL_updated_msg + " || Actual Popup was : " + Updated_pop,
					test, test1);
		}		

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(6, "save the import documentation", test, test1);
		
		Step_Start(7, "Verify that Changed DO issue location agency updated Correctly", test, test1);
		waitForElement(driver, Issue_location_text_IMP);
		String do_text_after= getAttribute(driver, Issue_location_text_IMP,"value");
		System.out.println(do_text_after);

		if(Do_Issue_Location.equals(do_text_after)) {
			System.out.println("Matched || Expected : Do Issue Location should be Change after Saving the BL, Old Location : " + do_text_before + " || Actual : Do Issue Location Changed after Saving the BL, New Location Exp : " + Do_Issue_Location+" || Act : "+do_text_after);
			Extent_pass_New(driver, "Matched || Expected : Do Issue Location should be Change after Saving the BL, Old Location : " + do_text_before + " || Actual : Do Issue Location Changed after Saving the BL, New Location Exp : " + Do_Issue_Location+" || Act : "+do_text_after, test,
					test1);

		} else {
			System.out.println("Not Matched || Expected : Do Issue Location should be Change after Saving the BL, Old Location : " + do_text_before + " || Actual : Do Issue Location not Changed after Saving the BL, New Location Exp : " + Do_Issue_Location+" || Act : "+do_text_after);
			Extent_fail(driver, "Not Matched || Expected : Do Issue Location should be Change after Saving the BL, Old Location : " + do_text_before + " || Actual : Do Issue Location not Changed after Saving the BL, New Location Exp : " + Do_Issue_Location+" || Act : "+do_text_after,
					test, test1);
		}		

		Step_End(7, "Verify that Changed DO issue location agency updated Correctly", test, test1);
		
		Step_Start(8, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0", test, test1);
		Step_Start(9, "click the yes and system has validate import documentation is deleted", test, test1);

		if(Delete_perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Step_End(8, "click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0 ", test, test1);
		Step_End(9, "click the yes and system has validate import documentation is deleted", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
