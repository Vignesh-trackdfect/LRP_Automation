package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Delivery_Order_Locators;

public class TC_Delivery_Order_TS_044 extends Keywords{
	public void Delivery_Order_TS_044(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_044";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String first_row_Expected = Excel_data.get("first_row_Expected");
		String second_row_Expected = Excel_data.get("second_row_Expected");
		String import_select = Excel_data.get("import_select");
		String Testing_select = Excel_data.get("Testing_select");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String attribute = Excel_data.get("Attribute");
		String value_back = Excel_data.get("value_back");
		String set_As_Default = Excel_data.get("set_As_Default");
		String globalSearchFilterOption_DO = Excel_data.get("globalSearchFilterOption_DO");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted_expected");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, Condition, AgencyUser, attribute, description, value);
		Step_Start(5, "Open Delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click ADD and paste the BL, then click Show", test, test1);
		newButton(driver);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		globalValueSearchWindow(driver,Dropdown_Condition,globalSearchFilterOption_DO,bl_Number, "", "", "", "");
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(6, "Click ADD and paste the BL, then click Show", test, test1);
		scrollBottom(driver);
		Step_Start(8, "Scroll to the right side and click the DROP DOWN button in the CFS column", test, test1);
		waitForElement(driver, do_Table_Scroll);
		horizontalscroll(driver, do_Table_Scroll, 3000);
		Step_End(8, "Scroll to the right side and click the DROP DOWN button in the CFS column", test, test1);
		waitForPresenceOfElement(driver, do_Table_Headers);
		List<WebElement> table_Headers = listOfElements(driver, do_Table_Headers);
		int cfsColumn=1;
		Step_Start(9, "Ensure CFS drop down has to be enabled and allowed to pick any one CFS value", test, test1);
		String CFS="";
		for(int i=0;i<table_Headers.size();i++) {
			try {
				String cfs_Column=getAttributeForElement(driver, table_Headers.get(i), "aria-label");
				if(cfs_Column.equalsIgnoreCase("CFS")) {
					cfsColumn=i+1;
					CFS=String.format(Delivery_Order_Locators.cfs_Column, cfsColumn);
					mouseOverToElement(driver, CFS);
					doubleClick(driver, CFS);
					String first_Row_Select=String.format(Delivery_Order_Locators.CFS_SELECT, import_select);
					waitForElement(driver, first_Row_Select);
					click(driver, first_Row_Select);
					String CFS1=String.format(Delivery_Order_Locators.cfs_Column1, cfsColumn);
					waitForElement(driver, CFS1);
					doubleClick(driver, CFS1);
					String second_Row_Select=String.format(Delivery_Order_Locators.CFS_SELECT, Testing_select);
					waitForElement(driver, second_Row_Select);
					click(driver, second_Row_Select);
					Step_End(9, "Ensure CFS drop down has to be enabled and allowed to pick any one CFS value", test, test1);
					Step_Start(7, "Select the Container", test, test1);
					waitForElement(driver, select_All_Checkbox_DO);
					click(driver, select_All_Checkbox_DO);
					Step_End(7, "Select the Container", test, test1);
					scrollTop(driver);
					Step_Start(10, "Click on save in Delivery Order", test, test1);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
					Step_End(10, "Click on save in Delivery Order", test, test1);
					Step_Start(11, "Make sure CFS value is added", test, test1);
					//1st row check
					String First_Row_Text_Check=String.format(Delivery_Order_Locators.First_Row_Text_Check, cfsColumn);
					waitForElement(driver, First_Row_Text_Check);
					String first_row_Actual = getText(driver, First_Row_Text_Check);
					if(first_row_Actual.equals(first_row_Expected)) {
						System.out.println("MATCHED || EXPECTED TEXT VALUE : "+first_row_Expected+" ACTUAL TEXT VALUE : "+first_row_Actual);
						Extent_pass_New(driver, "MATCHED || EXPECTED TEXT VALUE : "+first_row_Expected+" ACTUAL TEXT VALUE : "+first_row_Actual, test, test1);
					}else {
						System.out.println("NOT MATCHED || EXPECTED TEXT VALUE : "+first_row_Expected+" ACTUAL TEXT VALUE : "+first_row_Actual);
						Extent_fail(driver, "NOT MATCHED || EXPECTED TEXT VALUE : "+first_row_Expected+" ACTUAL TEXT VALUE : "+first_row_Actual, test, test1);
					}
					//2nd row check
					String second_Row_Text_Check=String.format(Delivery_Order_Locators.second_Row_Text_Check, cfsColumn);
					String second_row_Actual = getText(driver, second_Row_Text_Check);
					if(second_row_Actual.equals(second_row_Expected)) {
						System.out.println("MATCHED || EXPECTED TEXT VALUE : "+second_row_Expected+" ACTUAL TEXT VALUE : "+second_row_Actual);
						Extent_pass_New(driver, "MATCHED || EXPECTED TEXT VALUE : "+second_row_Expected+" ACTUAL TEXT VALUE : "+second_row_Actual, test, test1);
					}else {
						System.out.println("NOT MATCHED || EXPECTED TEXT VALUE : "+second_row_Expected+" ACTUAL TEXT VALUE : "+second_row_Actual);
						Extent_fail(driver, "NOT MATCHED || EXPECTED TEXT VALUE : "+second_row_Expected+" ACTUAL TEXT VALUE : "+second_row_Actual, test, test1);
					}
					Step_End(11, "Make sure CFS value is added", test, test1);				
				}
			}catch (Exception e) {
			}
		}
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(12, "Click the Delete button ", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(12, "Click the Delete button ", test, test1);
			Step_Start(13, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE MESSAGE :"+delete_popup_expected+" ACTUAL DELETE MESSAGE :"+delete_Msg_Actual, test, test1);
			}
			Step_End(13, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(14, "Click Yes ", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(14, "Click Yes ", test, test1);
			Step_Start(15, "Ensure system validated as Delivery order deleted \" ", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(deleted_expected.equals(do_Deleted_Actual)) {
				System.out.println("MATCHED || EXPECTED POPUP AFTER DELETE : "+deleted_expected+" ACTUAL POPUP AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED POPUP AFTER DELETE : "+deleted_expected+" ACTUAL POPUP AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED POPUP AFTER DELETE : "+deleted_expected+" ACTUAL POPUP AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED POPUP AFTER DELETE : "+deleted_expected+" ACTUAL POPUP AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(15, "Ensure system validated as Delivery order deleted \" ", test, test1);
		}
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, description, value_back, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}
