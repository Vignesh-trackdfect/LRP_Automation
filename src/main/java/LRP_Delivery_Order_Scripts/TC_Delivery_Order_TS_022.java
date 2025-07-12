package LRP_Delivery_Order_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_022 extends Keywords{
	public void Delivery_Order_TS_022(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable{

		String testcase_Name="TC_Delivery_Order_TS_022";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String description_Data = Excel_data.get("description_Data");
		String value = Excel_data.get("value");
		String Do_Module = Excel_data.get("Do_Module");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String agencyConfigurationModule = Excel_data.get("agencyConfigurationModule");
		String bl_Number = Excel_data.get("bl_Number");
		String save_Popup_Expected = Excel_data.get("save_Popup_Expected");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String Global_search_value_Bl_Number = Excel_data.get("Global_search_value_Bl_Number");
		String Container_Click_Count = Excel_data.get("Container_Click_Count");
		String module_ImportDocumentation = Excel_data.get("module_ImportDocumentation");
		String Global_search_value1_Imp_Doc = Excel_data.get("Global_search_value1_Imp_Doc");
		String Global_Search_Option1_Do_Module = Excel_data.get("Global_Search_Option1_Do_Module");
		String default_Value = Excel_data.get("default_Value");
		String attribute = Excel_data.get("attribute");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to transhipment agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to transhipment agency", test, test1);
		Extent_cal(test, test1, "Open agency configuration module and select the agency");
		List<Boolean> newlyadded = setAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description_Data, value);
		Step_Start(2, "Open Delivery order module", test, test1);
		moduleNavigate(driver, Do_Module);
		Step_End(2, "Open Delivery order module", test, test1);
		int count=Integer.parseInt(Container_Click_Count);
		List<String> Do_Numbers_generated = new ArrayList<>();
		for(int i=0;i<=count;i++) {
			Step_Start(3, "Click new button", test, test1);
			newButton(driver);
			Step_End(3, "Click new button", test, test1);
			Step_Start(4, "Click the ADD Button and paste the Bl", test, test1);
			waitForElement(driver, DO_Add_Button);
			click(driver, DO_Add_Button);
			Step_Start(5, "Select the BL", test, test1);
			globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value_Bl_Number, bl_Number, "", "", "", "");
			Step_End(5, "Select the BL", test, test1);
			Step_End(4, "Click the ADD Button and paste the Bl", test, test1);
			Step_Start(6, "Click the SHOW button", test, test1);
			waitForElement(driver, DO_Show_Button);
			click(driver, DO_Show_Button);
			Step_End(6, "Click the SHOW button", test, test1);
			Step_Start(7, "Count the total container before selection and select the required container (Example first)", test, test1);
			waitForElement(driver, do_Table_Rows);
			List<WebElement> total_Containers_Present = listOfElements(driver, do_Table_Rows);
			System.out.println("total containers available are : "+total_Containers_Present);
			waitForElement(driver, do_Row_First_Chekbox);
			click(driver, do_Row_First_Chekbox);
			Step_End(7, "Count the total container before selection and select the required container (Example first)", test, test1);
			Step_Start(8, "Click the Save button in Tool bar", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(8, "Click the Save button", test, test1);
			Step_Start(9, "Capture the Validation  ''Delivery Order Saved'' and copy the DO number", test, test1);
			waitForPopup(driver,Popup_Message,save_Popup_Expected);
			String save_Popup_Actual = getText(driver, Popup_Message);
			if(save_Popup_Actual.equals(save_Popup_Expected)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER SAVE IS : "+save_Popup_Expected+" ACTUAL Pop-up value is AFTER SAVE IS : "+ save_Popup_Actual, test, test1);
			}
			Step_End(9, "Capture the Validation  ''Delivery Order Saved'' and copy the DO number", test, test1);
			Step_Start(10, "Follow the step from 3 to 9 using the same BL number and save the DO for remaining Containers", test, test1);
			Step_End(10, "Follow the step from 3 to 9 using the same BL number and save the DO for remaining Containers", test, test1);
			Step_Start(11, "capture both  the  DO number", test, test1);
			waitForElement(driver, do_Number_Txtfield);
			String generated_Do_Number = getAttribute(driver, do_Number_Txtfield, "value");
			System.out.println("Generated DO number "+i +"iteration is :"+generated_Do_Number);
			Do_Numbers_generated.add(generated_Do_Number);
			System.out.println("DO NUMBERS STORED IN LIST ARE : "+Do_Numbers_generated);
			Step_End(11, "capture both  the  DO number", test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(12, "Open import documentation screen", test, test1);
		moduleNavigate(driver, module_ImportDocumentation);
		Step_End(12, "Open import documentation screen", test, test1);
		Step_Start(13, "Click search and fetch the BL", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value1_Imp_Doc, bl_Number, "", "", "", "");
		Step_End(13, "Click search and fetch the BL", test, test1);
		Step_Start(14, "Go to remarks tab and match the DO numbers with Delivery order screen (Same Bl)", test, test1);
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		scrollBottom(driver);
		for(String do_check:Do_Numbers_generated) {
			String bl_Num_Check_Imp_Documents=String.format(bl_Num_Check_Imp_Doc, do_check);
			waitForElement(driver, bl_Num_Check_Imp_Documents);
			String bl_Number_Check_Actual = getText(driver, bl_Num_Check_Imp_Documents);
			if(bl_Number_Check_Actual.equals(do_check)) {
				System.out.println("MATCHED || BL NUMBER IS : "+bl_Number+" || EXPECTED DELIVERY ORDER NUMBER IS : "+do_check+" || ACTUAL DELIVERY ORDER NUMBER IS : "+bl_Number_Check_Actual);
				Extent_pass_New(driver, "MATCHED || BL NUMBER IS : "+bl_Number+" || EXPECTED DELIVERY ORDER NUMBER IS : "+do_check+" || ACTUAL DELIVERY ORDER NUMBER IS : "+bl_Number_Check_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || BL NUMBER IS : "+bl_Number+" || EXPECTED DELIVERY ORDER NUMBER IS : "+do_check+" || ACTUAL DELIVERY ORDER NUMBER IS : "+bl_Number_Check_Actual);
				Extent_fail(driver, "NOT MATCHED || BL NUMBER IS : "+bl_Number+" || EXPECTED DELIVERY ORDER NUMBER IS : "+do_check+" || ACTUAL DELIVERY ORDER NUMBER IS : "+bl_Number_Check_Actual, test, test1);
			}
		}
		Step_End(14, "Go to remarks tab and match the DO numbers with Delivery order screen (Same Bl)", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		if(delete_Option.equalsIgnoreCase("Yes")) {

			Extent_cal(test, test1, "navigating to delivery order module");
			moduleNavigate(driver, Do_Module);
			for(String Do_Numbers:Do_Numbers_generated) {
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Do_Module, Do_Numbers, "", "", "", "");
				Step_Start(15, "Click the Delete button", test, test1);
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				Step_End(15, "Click the Delete button", test, test1);
				Step_Start(16, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
				waitForPopup(driver,popup_Message,delete_popup_expected);
				String delete_Msg_Actual = getText(driver, popup_Message).trim();
				if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
					System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
					Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
				}else {
					System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
					Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
				}
				Step_End(16, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
				Step_Start(17, "Click Yes", test, test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				Step_End(17, "Click Yes", test, test1);
				Step_Start(18, "Ensure system validated as 'Delivery order deleted'", test, test1);
				waitForPopup(driver,Popup_Message,deleted_expected);
				String do_Deleted_Actual = getText(driver, Popup_Message);
				if(do_Deleted_Actual.equals(deleted_expected)) {
					System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
					Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
				}else {
					System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
					Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
				}

				Step_End(18, "Ensure system validated as 'Delivery order deleted'", test, test1);
			}
		}
		reSetAgencyConfiguration(driver, agencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, description_Data, default_Value, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}
