package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_ActivityDefinition_TS_064 extends Keywords{

	public void ActivityDefinition_TS_064(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCase_Name="TC_ActivityDefinition_TS_064";
	
		
		String Username = Excel_data.get("Userid");
		String pass_word = Excel_data.get("PassWord");
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
				System.out.println( "Matched || The Selected Activity code : "+Added_Data);
				Extent_pass_New(driver, "Matched || The Selected Activity code : "+Added_Data, test,test1);
				doubleClick(driver, Added_Column_Value);
				Step_End(4, "Double click the columns Name.", test, test1);


				Step_Start(5, "Click on the \"delete\" button from the toolbar.", test, test1);
				waitForElement(driver, Delete_button_toolBar);
				click1(driver, Delete_button_toolBar);
				Step_End(5, "Click on the \"delete\" button from the toolbar.", test, test1);
				Step_Start(6, "Press 'Yes' in the Popup message to delete.", test, test1);
				waitForElement(driver, popup_Message);
				click(driver, popup_Message_Yes_Button);
				Step_End(6, "Press 'Yes' in the Popup message to delete.", test, test1);

				Extent_call(test, test1, "Check whether that system allows to delete the Activity Code Column name setup");
				waitForPopup(driver, Popup_Message, act_Def_Deleted_Popup_txt_Exp);
				String deleted_Popup=getText(driver, Popup_Message);
				if(act_Def_Deleted_Popup_txt_Exp.equals(deleted_Popup)) {
					System.out.println("Matched || " + " Expected Report Activity is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Report Activity is : " + deleted_Popup);
					Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Report Activity is : " + deleted_Popup, test,test1);
					waitForElement(driver, column_Filter_AD);
					sendKeys(driver, column_Filter_AD, Column_Value);
					Extent_call(test, test1, "Check the Deleted Activity code Highlighted In Red Color");
					String deleted_Column_Value1 = String.format(deleted_Column_Value_AD,Column_Value);
					String deleted_Column_Color = getTextBackgroundColor(driver, deleted_Column_Value1);
					System.out.println("deleted_Column_color : "+deleted_Column_Color);
					String deleted_Column_color=getColorName(deleted_Column_Color);
					if(deleted_Column_color.equals(act_Def_Deleted_colour_txt_Exp)) {
						System.out.println( "Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value  +" it should be  highlighted in "+  deleted_Column_color  +"colour || Actual Result is : Once User  Deleted the Activity code : "+  Column_Value  +" it is   highlighted in "+  deleted_Column_color +"colour");
						Extent_pass_New(driver,  "Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value +" it should be  highlighted in "+  deleted_Column_color  +"colour || Actual Result is : Once User  Deleted the Activity code : "+  Column_Value  +" it is   highlighted in "+  deleted_Column_color +"colour", test,test1);
					}else {
						System.out.println( "Not Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value  +" it should be  highlighted in "+  deleted_Column_color  +"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value  +" it is  not highlighted in "+  deleted_Column_color +"colour");
						Extent_fail(driver,  "Not Matched || Expected Result is :Once User  Deleted the Activity code : "+Column_Value  +" it should be  highlighted in "+  deleted_Column_color  +"colour || Actual Result is : Once User  Deleted the Activity code : "+Column_Value  +" it is  not highlighted in "+ deleted_Column_color +"colour", test,test1);
					}
				}else {
					System.out.println("Not Matched || " + " Expected Report Activity is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Report Activity is : " + deleted_Popup);
					Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + act_Def_Deleted_Popup_txt_Exp + " || Actual Report Activity is : " + deleted_Popup, test,test1);
				}
			} else {
				System.out.println("NotMatched || "+Column_Value+  "Activity Code Not Added");
				Extent_fail(driver,  "NotMatched || "+Column_Value+  "Activity Code Not Added", test,test1);

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

				System.out.println("Matched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup);
				Extent_pass_New(driver, "Matched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup,
						test, test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println(
						"NotMatched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup);
				Extent_fail(driver,
						"NotMatched || Expected popup was : " + Reactivation_Popup + " || Actual popup was : " + reactivationpopup, test,
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
				if(formatLocatorIsDisplayed(driver, Added_Column_Value, Column_Value)) {
					System.out.println( "Matched || The ReActivated Activity code : "+Column_Value);
					Extent_pass_New(driver, "Matched || The ReActivated Activity code : "+Column_Value, test,test1);
				} else {
					System.out.println("NotMatched || "+ Column_Value  +"Activity Code Not ReActivated");
					Extent_fail(driver,  "NotMatched || "+ Column_Value  +"Activity Code Not ReActivated", test,test1);
				}
			}
			Step_End(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);

		}
		Extent_completed(testCase_Name, test, test1);
	}
}