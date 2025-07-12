package LRP_EMS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.ActivityDefinition_Locators;

public class TC_Activity_Definition_TS062_to_TS064_C extends Keywords{

	public void Activity_Definition_TS062_to_TS064_C(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		int i=1;
		if(i==1) {
			String testCase_Name="TC_ActivityDefinition_TS_062";
			String File_Path_62 = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_062 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			String URL = TestNgXml.getdatafromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_062, testCase_Name, "Dataset"+selected_dataset, File_Path_62);		
			String Username = Excel_data.get("Userid");
			String pass_word = Excel_data.get("PassWord");
			String Field_Names = Excel_data.get("field_name");		
			String Activity_Code_Txt = Excel_data.get("Activity_Code_Txt");		
			String updatedPopup = Excel_data.get("Act_Def_updated_Popup_txt");
			String Column_Input = Excel_data.get("Column_Input");
			String Update_Input = Excel_data.get("Update_Input");
			String copy_From_Previous_Input = Excel_data.get("copy_From_Previous_Input");
			String copy_To_Previous_Input = Excel_data.get("copy_To_Previous_Input");
			String Validation_Type_Input = Excel_data.get("Validation_Type_Input");
			String Button = Excel_data.get("Button");
			Extent_Start(testCase_Name, test, test1);
			String update_Value =String.format(ActivityDefinition_Locators.Updated_Value,Update_Input);
			String Valid_Type = String.format(ActivityDefinition_Locators.Valid_Type_Value,Validation_Type_Input);
			String cmbCpy_Value_1 =String.format(ActivityDefinition_Locators.CMBCpy_Value_1,copy_From_Previous_Input);
			String cmbCpy_Value_2 = String.format(ActivityDefinition_Locators.CMBCpy_Value_2,copy_To_Previous_Input);
			String add_button_select = String.format(ActivityDefinition_Locators.ADD_button_select,Button);
			String Condition =Excel_data.get("Condition");
			String Activity_Search_Column_Header =Excel_data.get("Activity_Search_Column_Header");
			String Activity_Def_Column_Name_Search_Column_Header =Excel_data.get("Activity_Def_Column_Name_Search_Column_Header");

			navigateUrl(driver, URL);
			LRP_Login(driver, Username, pass_word);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
		
			Step_Start(1, "Click on the search toolbar in the Activity code.", test, test1);
			waitForElement(driver, kActivitySearch);
			click(driver,kActivitySearch);
			Step_End(1, "Click on the search toolbar in the Activity code.", test, test1);
			Step_Start(2, "Enter  Activity code in the Activity Search.", test, test1);
			twoColumnSearchWindow(driver,Activity_Search_Column_Header, Condition, Activity_Code_Txt);
			Step_End(2, "Enter  Activity code in the Activity Search.", test, test1);
			Step_Start(3, "Click on the \"Edit\" button from the toolbar.", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			Step_End(3, "Click on the \"Edit\" button from the toolbar.", test, test1);
			Step_Start(4, "Select the newly required column name.", test, test1);
			waitForElement(driver, kActivityDefinitionColumName);
			click(driver,kActivityDefinitionColumName);
			twoColumnSearchWindowMultipleValue(driver,Activity_Def_Column_Name_Search_Column_Header, Condition, Column_Input);
			Step_End (4, "Select the newly required column name.", test, test1);
			Step_Start(5, "Click on the \"Is Update\" dropdown.", test, test1);

			waitForElement(driver, kActivityDefinitionIsUpdate);
			click(driver,kActivityDefinitionIsUpdate);
			Step_End (5, "Click on the \\\"Is Update\\\" dropdown.", test, test1);
			Step_Start(6, "Select 'Yes' or 'No' for Is update.", test, test1);
			waitForElement(driver, update_Value);
			click(driver, update_Value);
			Step_End (6, "Select 'Yes' or 'No' for Is update.", test, test1);

			Step_Start(7, "Click on the \"Validation Type\" dropdown", test, test1);
			waitForElement(driver, kActivityDefinitionValidationType);
			click(driver,kActivityDefinitionValidationType);
			Step_End(7, "Click on the \"Validation Type\" dropdown", test, test1);
			Step_Start(8, "Select 'V' in the Validation type.", test, test1);
			waitForElement(driver, Valid_Type);
			click(driver, Valid_Type);
			Step_End(8, "Select 'V' in the Validation type.", test, test1);
			Step_Start(9, "Click on the \"Copy From Previous\" dropdown.", test, test1);

			waitForElement(driver, kActivityDefinitionCopyFromPrevious);
			click(driver,kActivityDefinitionCopyFromPrevious);
			Step_End(9, "Click on the \"Copy From Previous\" dropdown.", test, test1);
			Step_Start(10, "Select 'Yes' or 'No' for Copy From Previous.", test, test1);
			waitForElement(driver, cmbCpy_Value_1);
			click(driver, cmbCpy_Value_1);
			Step_End(10, "Select 'Yes' or 'No' for Copy From Previous.", test, test1);
			Step_Start(11, "Click on the \"Copy To Previous\" dropdown.", test, test1);
			waitForElement(driver, kActivityDefinitionCopyToPrevious);
			click(driver,kActivityDefinitionCopyToPrevious);
			Step_End(11, "Click on the \"Copy To Previous\" dropdown.", test, test1);
			Step_Start(12, "Select 'Yes' or 'No' for Copy To Previous.", test, test1);
			waitForElement(driver, cmbCpy_Value_2);
			click(driver, cmbCpy_Value_2);
			Step_End(12, "Select 'Yes' or 'No' for Copy To Previous.", test, test1);
			Step_Start(13, "Click on the \"Add\" button.", test, test1);
			waitForElement(driver, add_button_select);
			click(driver, add_button_select);
			Step_End(13, "Click on the \"Add\" button.", test, test1);
			Step_Start(14, "Press the save button in the toolbar.", test, test1);
			waitForElement(driver, kActivityDefinitionSave);
			click(driver,kActivityDefinitionSave);
			Step_End(14, "Press the save button in the toolbar.", test, test1);
			waitForPopup(driver, Popup_Message, updatedPopup);
			String getpopup = getText(driver,Popup_Message) ;
			if (getpopup.equals(updatedPopup)){
				System.out.println( "Matched || Expected Popup was : "+updatedPopup+" || Actual Popup was : "+getpopup);
				Extent_pass_New(driver, "Matched || Expected Popup was : "+updatedPopup+" || Actual Popup was : "+getpopup, test,test1);
			} else {
				System.out.println("NotMatched || Expected Popup was : "+updatedPopup+" || Actual Popup was : "+getpopup);
				Extent_fail(driver,  "NotMatched || Expected Popup was : "+updatedPopup+" || Actual Popup was : "+getpopup, test,test1);
			}
			Extent_call(test, test1, "Verufy the Added Value is Showing the grid or not");
			List<String> Column_Values = splitAndExpand(Column_Input);
			for(String Column_Value : Column_Values) {
				waitForElement(driver, column_Filter_AD);
				sendKeys(driver, column_Filter_AD, Column_Value);
				String Added_Column_Value = String.format(ActivityDefinition_Locators.Added_Column_Value,Column_Value);
				String Added_Data = getText(driver, Added_Column_Value);
				if(isDisplayed(driver, Added_Column_Value)) {
					System.out.println("Matched ||Expected Result is :The newly added Activty Code :"+Added_Data+"Should be added ||Actual Result is :The newly added Activty Code :"+Added_Data+"is added");
					Extent_pass_New(driver, "Matched ||Expected Result is :The newly added Activty Code :"+Added_Data+"Should be added ||Actual Result is :The newly added Activty Code :"+Added_Data+"is added", test,test1);
				} else {
					System.out.println("Not Matched ||Expected Result is :The newly added Activty Code :"+Added_Data+"Should be added ||Actual Result is :The newly added Activty Code :"+Added_Data+"is not added");
					Extent_fail(driver,  "Not Matched ||Expected Result is :The newly added Activty Code :"+Added_Data+"Should be added ||Actual Result is :The newly added Activty Code :"+Added_Data+"is not added", test,test1);
				}
			}
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_ActivityDefinition_TS_063";
			String File_Path_63 = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_063 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_063, testCase_Name, "Dataset"+selected_dataset, File_Path_63);		
			String Field_Names = Excel_data.get("field_name");		
			String Activity_Code_Txt = Excel_data.get("Activity_Code_Txt");		
			String Column_Input = Excel_data.get("Column_Input");
			String Update_Input = Excel_data.get("Update_Input");
			String copy_From_Previous_Input = Excel_data.get("copy_From_Previous_Input");
			String copy_To_Previous_Input = Excel_data.get("copy_To_Previous_Input");
			String Validation_Type_Input = Excel_data.get("Validation_Type_Input");
			String Button = Excel_data.get("Button");
			String act_Def_updated_Popup_txt_Exp = Excel_data.get("Act_Def_updated_Popup_txt");
			String is_update_Value =String.format(ActivityDefinition_Locators.Updated_Value,Update_Input);
			String validation_Type = String.format(ActivityDefinition_Locators.Valid_Type_Value,Validation_Type_Input);
			String Copy_From_Value =String.format(ActivityDefinition_Locators.CMBCpy_Value_1,copy_From_Previous_Input);
			String Copy_Pre_Value = String.format(ActivityDefinition_Locators.CMBCpy_Value_2,copy_To_Previous_Input);
			String edit_button_select = String.format(ActivityDefinition_Locators.ADD_button_select,Button);
			String Condition =Excel_data.get("Condition");
			String Activity_Search_Column_Header =Excel_data.get("Activity_Search_Column_Header");

			Extent_Start(testCase_Name, test, test1);
			
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			
			Step_Start(1, "Click on the search Button.", test, test1);
			waitForElement(driver, kActivitySearch);
			click(driver,kActivitySearch);
			Step_End(1, "Click on the search Button.", test, test1);
			Step_Start(2, "Enter Activity code in the Search field.", test, test1);
			Step_End(2, "Enter Activity code in the Search field.", test, test1);
			Step_Start(3, "Click on the search Button.", test, test1);
			twoColumnSearchWindow(driver,Activity_Search_Column_Header, Condition, Activity_Code_Txt);
			Step_Start(3, "Click on the search Button.", test, test1);
			Step_Start(5, "Click on the \"Edit\" button from the toolbar.", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			Step_End(5, "Click on the \"Edit\" button from the toolbar.", test, test1);
			Step_Start(4, "Double click on the Activity code.", test, test1);
			waitForElement(driver, column_Filter_AD);
			sendKeys(driver, column_Filter_AD, Column_Input);
			
			formatLocatorDoubleClick(driver, Column_Value, Column_Input);
			
			Step_End(4, "Double click on the Activity code.", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);

			Step_Start(6, "Edit the Required Columns name Fields.", test, test1);
			if(!Update_Input.equals("")) {	
				waitForElement(driver, kActivityDefinitionIsUpdate);
				click(driver,kActivityDefinitionIsUpdate);
				waitForElement(driver, is_update_Value);
				click(driver, is_update_Value);
				Step_End(6, "Edit the Required Columns name Fields.", test, test1);
			}else if(!Validation_Type_Input.equals("")) {
				waitForElement(driver, kActivityDefinitionValidationType);
				click(driver,kActivityDefinitionValidationType);
				waitForElement(driver, validation_Type);
				click(driver, validation_Type);
				Step_End(6, "Edit the Required Columns name Fields.", test, test1);
			}else if(!copy_From_Previous_Input.equals("")) {
				waitForElement(driver, kActivityDefinitionCopyFromPrevious);
				click(driver,kActivityDefinitionCopyFromPrevious);
				waitForElement(driver, Copy_From_Value);
				click(driver, Copy_From_Value);
				Step_End(6, "Edit the Required Columns name Fields.", test, test1);
			}else if(!copy_To_Previous_Input.equals("")) {
				waitForElement(driver, kActivityDefinitionCopyToPrevious);
				click(driver,kActivityDefinitionCopyToPrevious);
				waitForElement(driver, Copy_Pre_Value);
				click(driver, Copy_Pre_Value);
				Step_End(6, "Edit the Required Columns name Fields.", test, test1);
			}else {
				System.out.println("There is no values in Excel  sheet for Update the Activity Definition");
			}
			Step_Start(7, "Click the edit button.", test, test1);
			waitForElement(driver, edit_button_select);
			click(driver, edit_button_select);
			Step_End(7, "Click the edit button.", test, test1);
			Step_Start(8, "Press the save button in the tool Bar.", test, test1);
			waitForElement(driver, kActivityDefinitionSave);
			click(driver,kActivityDefinitionSave);
			Step_End(8, "Press the save button in the tool Bar.", test, test1);
			waitForPopup(driver, Popup_Message, act_Def_updated_Popup_txt_Exp);
			String updateMsg=getText(driver, Popup_Message);
			if(act_Def_updated_Popup_txt_Exp.equals(updateMsg)) {
				System.out.println("Matched || " + " Expected Popup is : " + act_Def_updated_Popup_txt_Exp + " || Actual Popup  is : " + updateMsg);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + act_Def_updated_Popup_txt_Exp + " || Actual Popup  is : " + updateMsg,test,test1);
			}else{
				System.out.println("Not Matched || " + " Expected Popup is : " + act_Def_updated_Popup_txt_Exp + " || Actual Popup  is : " + updateMsg);
				Extent_fail(driver,"Not Matched || " + " Expected Popup  is : " + act_Def_updated_Popup_txt_Exp + " || Actual Popup  is : " + updateMsg,test,test1);
			}

			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_ActivityDefinition_TS_064";
			String File_Path_64 = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_064 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_064, testCase_Name, "Dataset"+selected_dataset, File_Path_64);		
			String Field_Names = Excel_data.get("field_name");		
			String Activity_Code_Txt = Excel_data.get("Activity_Code_Txt");		
			String Column_Input = Excel_data.get("Column_Input");
			String act_Def_Deleted_Popup_txt_Exp = Excel_data.get("Act_Def_Deleted_Popup_txt");
			String act_Def_Deleted_colour_txt_Exp = Excel_data.get("Act_Def_Deleted_colour");
			String ReActivate_Optioin =Excel_data.get("ReActivate_Optioin");
			String Matser_Module =Excel_data.get("Matser_Module");
			String Reactivation_Popup =Excel_data.get("Reactivation_Popup");
			String Condition =Excel_data.get("Condition");
			String Activity_Search_Column_Header =Excel_data.get("Activity_Search_Column_Header");
			String Module_Name_Column_Header =Excel_data.get("Module_Name_Column_Header");
			String Module_Name =Excel_data.get("Module_Name");

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			
			Step_Start(1, "Click on the search Button.", test, test1);
			waitForElement(driver, kActivitySearch);
			click(driver,kActivitySearch);
			Step_End(1, "Click on the search Button.", test, test1);
			Step_Start(2, "Enter Activity code in the Search field.", test, test1);
			Step_End(2, "Enter Activity code in the Search field.", test, test1);
			Step_Start(3, "Double click on the Activity code.", test, test1);
			twoColumnSearchWindow(driver,Activity_Search_Column_Header, Condition, Activity_Code_Txt);
			
			Step_End(3, "Double click on the Activity code.", test, test1);

			List<String> Column_Values = splitAndExpand(Column_Input);
			for(String Column_Value : Column_Values) {
				waitForElement(driver, column_Filter_AD);
				sendKeys(driver, column_Filter_AD, Column_Value);
				Step_Start(4, "Double click the columns Name.", test, test1);
				String Added_Column_Value = String.format(AddedColumnValue,Column_Value);
				String Added_Data = getText(driver, Added_Column_Value);

				if(isDisplayed(driver, Added_Column_Value)) {
					System.out.println("Matched ||Expected Result is :The selected Activty Code :"+Added_Data+"Should be added ||Actual Result is :The selected Activty Code :"+Added_Data+"is added");
					Extent_pass_New(driver, "Matched ||Expected Result is :The selected Activty Code :"+Added_Data+"Should be added ||Actual Result is :The selected Activty Code :"+Added_Data+"is added", test,test1);
					doubleClick(driver, Added_Column_Value);
					Step_Start(4, "Double click the columns Name.", test, test1);

					Step_Start(5, "Click on the \"delete\" button from the toolbar.", test, test1);
					waitForElement(driver, Delete_button_toolBar);
					click1(driver, Delete_button_toolBar);
					Step_End(5, "Click on the \"delete\" button from the toolbar.", test, test1);
					Step_Start(6, "Press 'Yes' in the Popup message to delete.", test, test1);
					waitForElement(driver, popup_Message);
					click1(driver, popup_Message_Yes_Button);
					Step_End(6, "Press 'Yes' in the Popup message to delete.", test, test1);

					Extent_call(test, test1, "Check whether that system allows to delete the Activity Code Column name setup");
					waitForPopup(driver, Popup_Message, act_Def_Deleted_Popup_txt_Exp);
					String deleted_Popup=getText(driver, Popup_Message);
					if(act_Def_Deleted_Popup_txt_Exp.equals(deleted_Popup)) {
						System.out.println("Matched || " + " Expected Popup is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Popup is : " + deleted_Popup);
						Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Popup is : " + deleted_Popup, test,test1);
						waitForElement(driver, column_Filter_AD);
						sendKeys(driver, column_Filter_AD, Column_Value);
						Extent_call(test, test1, "Check the Deleted Activity code Highlighted In Red Color");
						String deleted_Column_Value1 = String.format(deleted_Column_Value_AD,Column_Value);
						String deleted_Column_Color = getTextBackgroundColor(driver, deleted_Column_Value1);
						System.out.println("deleted_Column_color : "+deleted_Column_Color);
						String deleted_Column_color=getColorName(deleted_Column_Color);
						if(deleted_Column_color.equals(act_Def_Deleted_colour_txt_Exp)) {
							System.out.println( "Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value+" it should be  highlighted in "+deleted_Column_color+"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value+" it is   highlighted in "+deleted_Column_color+"colour");
							Extent_pass_New(driver,  "Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value+" it should be  highlighted in "+deleted_Column_color+"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value+" it is   highlighted in "+deleted_Column_color+"colour", test,test1);
						}else {
							System.out.println( "Not Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value+" it should be  highlighted in "+deleted_Column_color+"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value+" it is  not highlighted in "+deleted_Column_color+"colour");
							Extent_fail(driver,  "Not Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value+" it should be  highlighted in "+deleted_Column_color+"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value+" it is  not highlighted in "+deleted_Column_color+"colour", test,test1);
						}
					}else {
						System.out.println("Not Matched || " + " Expected Popup is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Popup is : " + deleted_Popup);
						Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Popup is : " + deleted_Popup, test,test1);
					}
				} else {
					System.out.println("Not Matched || Expected : "+Column_Value+" Activity Code should be Added || Actual : "+Column_Value+"Activity Code is Not Added");
					Extent_fail(driver,  "Not Matched || Expected : "+Column_Value+" Activity Code should be Added || Actual : "+Column_Value+"Activity Code is Not Added", test,test1);

				}
			}
			if(ReActivate_Optioin.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				Step_Start(5, "Open Master Reactivation screen", test, test1);
				moduleNavigate(driver, Matser_Module);
				
				
				Step_End(5, "Open Master Reactivation screen", test, test1);
				Step_Start(6, "Click on new button & press 'Yes' option", test, test1);
			newButton(driver);
				
				Step_End(6, "Click on new button & press 'Yes' option", test, test1);
				
				
				Step_Start(7, "Click on module name icon", test, test1);
				waitForElement(driver, module_Name_search_button_MR);
				click(driver, module_Name_search_button_MR);
				Step_End(7, "Click on module name icon", test, test1);
				
				Step_Start(8, "Select Equipment Activity in module name", test, test1);
				twoColumnSearchWindow(driver,Module_Name_Column_Header, Condition, Module_Name);
				Step_End(8, "Select Equipment Activity in module name", test, test1);
				
				Step_Start(9, "Click show button", test, test1);
				waitForElement(driver, show_button_MR);
				click(driver, show_button_MR);
				Step_End(9, "Click show button", test, test1);
				Step_Start(10, "Select the deleted size/type", test, test1);
				waitForElement(driver, activity_code_Select_MR);
				sendKeys(driver, activity_code_Select_MR, Column_Input);
				waitForElement(driver, activity_code_Select_MR);
				click(driver, activity_code_Select_MR);
				Step_End(10, "Select the deleted size/type", test, test1);
				Step_Start(11, "Click on reactivate button", test, test1);
				waitForElement(driver, reactive_button_MR);
				click(driver, reactive_button_MR);
				
				Step_End(11, "Click on reactivate button", test, test1);
				
				Step_Start(12, "System will show message as  Equipment Master Reactivated successfully & then click Ok", test, test1);
				waitForPopup(driver, popup_Message, Reactivation_Popup);
				String  reactivationpopup = getText(driver, popup_Message);
				if (Reactivation_Popup.equals(reactivationpopup)) {

					System.out.println("Matched || Expected Popup : " + Reactivation_Popup + " || Actual Popup : " + reactivationpopup);
					Extent_pass_New(driver, "Matched || Expected Popup : " + Reactivation_Popup + " || Actual Popup : " + reactivationpopup,
							test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println(
							"NotMatched || Expected Popup : " + Reactivation_Popup + " || Actual Popup : " + reactivationpopup);
					Extent_fail(driver,
							"NotMatched || Expected Popup : " + Reactivation_Popup + " || Actual Popup : " + reactivationpopup, test,
							test1);
				}
				
				Step_End(12, "System will show message as  Equipment Master Reactivated successfully & then click Ok", test, test1);
				
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				Step_Start(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);
				moduleNavigate(driver, Field_Names);
				waitForElement(driver, kActivitySearch);
				click(driver,kActivitySearch);
				twoColumnSearchWindow(driver,Activity_Search_Column_Header, Condition, Activity_Code_Txt);
				Column_Values = splitAndExpand(Column_Input);
				for(String Column_Value : Column_Values) {
					waitForElement(driver, column_Filter_AD);
					sendKeys(driver, column_Filter_AD, Column_Value);
					String Added_Column_Value = String.format(ActivityDefinition_Locators.Added_Column_Value,Column_Value);
					String Added_Data = getText(driver, Added_Column_Value);
					if(isDisplayed(driver, Added_Column_Value)) {
						System.out.println("Matched || Expected Activity code : "+Column_Value+" || Actual Activity code : "+Added_Data);
						Extent_pass_New(driver,  "Matched || Expected Activity code : "+Column_Value+" || Actual Activity code : "+Added_Data, test,test1);
					} else {
						System.out.println("Not Matched || Expected Activity code : "+Column_Value+" || Actual Activity code : "+Added_Data);
						Extent_fail(driver,  "Not Matched || Expected Activity code : "+Column_Value+" || Actual Activity code : "+Added_Data, test,test1);
					}
				}
				Step_End(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);

			}
			Extent_completed(testCase_Name, test, test1);
		}
	}

}
