package LRP_EMS_Individual_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Equipment_Master_Locators;

public class TC_Equipment_Master_TS052 extends Keywords{
	
	public void Equipment_Master_TS052(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCase_Name="TC_Equipment_Master_TS052";
		
		String user_Name =Excel_data.get("Userid");
		String pass_word =Excel_data.get("PassWord");
		String Field_Names =Excel_data.get("field_name");
		String equip_Type =Excel_data.get("equip_Type");
		String Equipment_deleted_Popup_Txt_Exp =Excel_data.get("Equipment_deleted_Popup_Txt");
		String No_Records_Found_Popup_Txt_Exp =Excel_data.get("No_Records_Found_Popup_Txt");
		String ReActivate_Optioin =Excel_data.get("ReActivate_Optioin");
		String Matser_Module =Excel_data.get("Matser_Module");
		String Reactivation_Popup =Excel_data.get("Reactivation_Popup");
		String newlyAddedEquipment=String.format(Equipment_Master_Locators.newlyAddedEquipment,equip_Type);
		String Condition =Excel_data.get("Condition");
		String Module_Name_Column_Header =Excel_data.get("Module_Name_Column_Header");
		String Global_Search_Type =Excel_data.get("Global_Search_Type");
		String Global_Search_Condition =Excel_data.get("Global_Search_Condition");
		
		//navigate the Url
		Extent_Start(testCase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, user_Name, pass_word);
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
		//Enter Equipment Master Module
		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Double click the size/type", test, test1);	
	
		waitForElement(driver, P_Equip_Size_Menu);
		click(driver, P_Equip_Size_Menu);
		waitForElement(driver, Equip_Size_Filter_EQP);
		click(driver, Equip_Size_Filter_EQP);
		waitForElement(driver, P_Equip_Filter_CheckBox_EQP);
		click(driver, P_Equip_Filter_CheckBox_EQP);
	
		waitForElement(driver, P_Equip_Filter_Search_EQP);
		sendKeys(driver, P_Equip_Filter_Search_EQP, equip_Type);
		waitForElement(driver, P_Filter_First_Value);
		click(driver, P_Filter_First_Value);
	
		waitForElement(driver, P_equipmentType_TxtField);
		click(driver, P_equipmentType_TxtField);
	
		waitForElement(driver, P_First_Equip_Type);
		doubleClick(driver, P_First_Equip_Type);
		Step_End(1, "Double click the size/type", test, test1);

		Step_Start(2, "Click delete icon from toolbar", test, test1);	
	
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(2, "Click delete icon from toolbar", test, test1);

		Step_Start(3, "Click 'Yes' while confirming for Do you want to delete", test, test1);	
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(3, "Click 'Yes' while confirming for Do you want to delete", test, test1);

		Step_Start(3, "Message will be shown as deleted", test, test1);	
		waitForPopup(driver, Popup_Message, Equipment_deleted_Popup_Txt_Exp);
		String deletedMsg =getText(driver, Popup_Message);
		Step_End(3, "Message will be shown as deleted", test, test1);
		
		if(Equipment_deleted_Popup_Txt_Exp.equals(deletedMsg)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Equipment_deleted_Popup_Txt_Exp + " || Actual Report Activity is : " + deletedMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Equipment_deleted_Popup_Txt_Exp + " || Actual Report Activity is : " + deletedMsg, test,test1);
		}else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Equipment_deleted_Popup_Txt_Exp + " || Actual Report Activity is : " + deletedMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Equipment_deleted_Popup_Txt_Exp + " || Actual Report Activity is : " + deletedMsg, test,test1);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow1(driver, Global_Search_Condition, Global_Search_Type, equip_Type, "", "", "", "");
		
		waitForPopup(driver, Popup_Message, No_Records_Found_Popup_Txt_Exp);
		String noRecordPopup = getText(driver, Popup_Message);
		if(No_Records_Found_Popup_Txt_Exp.equals(noRecordPopup)){
			System.out.println("Matched || " + " Expected Popup is : " + No_Records_Found_Popup_Txt_Exp + " || Actual Popup is : " + noRecordPopup);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + No_Records_Found_Popup_Txt_Exp + " || Actual Popup is : " + noRecordPopup, test,test1);
		}else {
			System.out.println("Not Matched || " + " Expected Popup is : " + No_Records_Found_Popup_Txt_Exp + " || Actual Popup is : " + noRecordPopup);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + No_Records_Found_Popup_Txt_Exp + " || Actual Popup is : " + noRecordPopup, test,test1);
		}
		waitForElement(driver, globalSearchCloseIcon_L);
		click(driver, globalSearchCloseIcon_L);
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
			waitForElement(driver, module_Nume_search_button_MRD);
			click(driver, module_Nume_search_button_MRD);
			Step_End(7, "Click on module name icon", test, test1);
			
			Step_Start(8, "Select Equipment Activity in module name", test, test1);
			twoColumnSearchWindow(driver,Module_Name_Column_Header, Condition, Field_Names);
			
			Step_End(8, "Select Equipment Activity in module name", test, test1);
			
			Step_Start(9, "Click show button", test, test1);
			waitForElement(driver, show_Button_MRD);
			click(driver, show_Button_MRD);
			Step_End(9, "Click show button", test, test1);
			Step_Start(10, "Select the deleted size/type", test, test1);
			waitForElement(driver, activity_Code_TF_MRD);
			sendKeys(driver, activity_Code_TF_MRD, equip_Type);
			waitForElement(driver, activity_Code_Select_MRD);
			click(driver, activity_Code_Select_MRD);
			Step_End(10, "Select the deleted size/type", test, test1);
			Step_Start(11, "Click on reactivate button", test, test1);
			waitForElement(driver, reactive_Button_MRD);
			click(driver, reactive_Button_MRD);
			
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
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			
			globalValueSearchWindow1(driver, Global_Search_Condition, Global_Search_Type, equip_Type, "", "", "", "");
			
			String newlyAddedEquipmentText = getText(driver, newlyAddedEquipment);
			if(equip_Type.equals(newlyAddedEquipmentText)) {
				System.out.println("Matched || The Equipment Master Equipment Type is ReActivated || Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText);
				Extent_pass_New(driver, "Matched || The Equipment Master Equipment Type is ReActivated || Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText, test,test1);
			}
			else {
				System.out.println("Not Matched || The Equipment Master Equipment Type is Not ReActivated || ReActivated Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText);
				Extent_fail(driver, "Not Matched || The Equipment Master Equipment Type is Not ReActivated || ReActivated Expected Equipment Type is : " + equip_Type + " || Actual Equipment Type is : " + newlyAddedEquipmentText, test,test1);
			}
			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			
			Step_End(13, "Open Equipment activity screen & then verify that reactivated size/type showing in screen in Activity code filter option", test, test1);
		}
		Extent_completed(testCase_Name, test, test1);
	}
}
