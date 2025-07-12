package LRP_EMS_Individual_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ActivityDefinition_Locators;

public class TC_ActivityDefinition_TS_063 extends Keywords{

	public void ActivityDefinition_TS_063(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCase_Name="TC_ActivityDefinition_TS_063";
		
		String Username = Excel_data.get("Userid");
		String pass_word = Excel_data.get("PassWord");
		String Field_Names = Excel_data.get("field_name");		
		String Activity_Code_Txt = Excel_data.get("Activity_Code_Txt");		
		String Column_Input = Excel_data.get("Column_Input");
		String Update_Input = Excel_data.get("Update_Input");
		String copy_From_Previous_Input = Excel_data.get("copy_From_Previous_Input");
		String copy_To_Previous_Input = Excel_data.get("copy_To_Previous_Input");
		String Validation_Type_Input = Excel_data.get("Validation_Type_Input");
		String Button = Excel_data.get("Button");
		String act_Def_updated_Popup_txt_Exp = Excel_data.get("Act_Def_updated_Popup_txt");
		String Condition =Excel_data.get("Condition");
		String Activity_Search_Column_Header =Excel_data.get("Activity_Search_Column_Header");

		
		
		String is_update_Value =String.format(ActivityDefinition_Locators.Updated_Value,Update_Input);
		String validation_Type = String.format(ActivityDefinition_Locators.Valid_Type_Value,Validation_Type_Input);
		String Copy_From_Value =String.format(ActivityDefinition_Locators.CMBCpy_Value_1,copy_From_Previous_Input);
		String Copy_Pre_Value = String.format(ActivityDefinition_Locators.CMBCpy_Value_2,copy_To_Previous_Input);
		String edit_button_select = String.format(ActivityDefinition_Locators.ADD_button_select,Button);

		Extent_Start(testCase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, pass_word);
		
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
	}
}