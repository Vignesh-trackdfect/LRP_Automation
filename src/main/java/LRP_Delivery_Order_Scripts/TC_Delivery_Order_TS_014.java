package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Delivery_Order_Locators;

public class TC_Delivery_Order_TS_014 extends Keywords{
	public void Delivery_Order_TS_014(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_014";





		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String Condition = Excel_data.get("Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String DO_Saved = Excel_data.get("DO_Saved");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String GlobalSearchFilterOption_ID = Excel_data.get("GlobalSearchFilterOption_ID");
		String GlobalSearchFilterOption_DO1 = Excel_data.get("GlobalSearchFilterOption_DO1");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");
		String Container_Select = Excel_data.get("Container_Select");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency", test, test1);
		List<String> DO_Numbers=new ArrayList<String>();
		Step_Start(2, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(2, "Open Delivery order module", test, test1);
		Step_Start(3, "Click new button", test, test1);
		newButton(driver);
		Step_End(3, "Click new button", test, test1);
		Step_Start(4, "Click the  ADD  Button and paste the Bl", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_Start(5, "Select the BL ", test, test1);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, BL_Num, "", "", "", "");
		Step_End(5, "Select the BL ", test, test1);
		Step_End(4, "Click the  ADD  Button and paste the Bl", test, test1);
		Step_Start(6, "Click the SHOW button", test, test1);
		waitForElement(driver, DO_Show_Button);
		click(driver, DO_Show_Button);
		Step_End(6, "Click the SHOW button", test, test1);
		Step_Start(7, "Count the total container before selection and select the required container", test, test1);
		scrollBottom(driver);
		waitForElement(driver, DO_Column_Header);
		List<Map<String, String>> BL_Container_Data = getTableData(driver, DO_Column_Header, DO_Column_Row);
		List<String> Container_Data = getValuesByHeader(BL_Container_Data, "Container No");
		System.out.println("Container_Data:"+Container_Data);
		int DO_Container_Number = Container_Data.size();
		System.out.println("DO_Container_Number:"+DO_Container_Number);
		scrollBottom(driver);
		int batchSize = Integer.parseInt(Container_Select);
		if(batchSize<2) {
			   System.out.println("Not Matched || Expected Container Count value is Greater dhan 1 but here the container Count is : "+batchSize);
		       Extent_fail(driver,"Not Matched || Expected Container Count value is Greater dhan 1 but here the container Count is : "+batchSize, test, test1);
		}
		for (int i = 0; i < DO_Container_Number; i += batchSize) {
		    
		    for (int j = i; j < i + batchSize && j < DO_Container_Number; j++) {
		        String checkbox = String.format(Delivery_Order_Locators.DO_Container_Checkbox_Click, Container_Data.get(j));
		        if (isdisplayed(driver, checkbox)) {
		            waitForElement(driver, checkbox);
		            click(driver, checkbox);
		        } else {
		            break;
		        }
		    }

		    Step_End(7, "Count the total container before selection and select the required container", test, test1);            	 
		    Step_Start(8, "Click the Save button in Tool bar ", test, test1);           
		    scrollTop(driver);
		    waitForElement(driver, SaveButton_ToolBar);
		    click(driver, SaveButton_ToolBar);
		    Step_End(8, "Click the Save button in Tool bar ", test, test1);	

		    Step_Start(9, "Capture the Validation \" Delivery Order Saved\" and copy the DO number", test, test1);
		    waitForPopup(driver, Popup_Message, DO_Saved);
		    String DO_Saved_Popup = getText(driver, Popup_Message);
		    if (DO_Saved_Popup.equals(DO_Saved)) {
		        System.out.println("Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
		        Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup, test, test1);
		    } else {
		        System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
		        Extent_fail(driver, "Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is  : " + DO_Saved_Popup, test, test1);
		    }

		    String DO_number = getAttribute(driver, DO_Num_Tf, "value");
		    System.out.println(DO_number);
		    DO_Numbers.add(DO_number);
		    Step_End(9, "Capture the Validation \" Delivery Order Saved\" and copy the DO number", test, test1);					

		    if (i + batchSize < DO_Container_Number) {
		        Step_Start(10, "Follow the step from 3 to 9 using the same BL number and save the DO for remaining BL", test, test1);
		        scrollTop(driver);
		        newButton(driver);
		        waitForElement(driver, DO_Add_Button);
		        click(driver, DO_Add_Button);
		        globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO, BL_Num, "", "", "", "");
		        waitForElement(driver, DO_Show_Button);
		        click(driver, DO_Show_Button);
		        scrollBottom(driver);
		        Step_End(10, "Follow the step from 3 to 9 using the same BL number and save the DO for remaining BL", test, test1);
		    }
		}
		Step_Start(11, "capture both  the  DO number ", test, test1);
		Step_End(11, "capture both  the  DO number ", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(12, "Open import documentation screen", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(12, " Open import documentation screen", test, test1);
		Step_Start(13, "Click search and fetch the BL", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_ID, BL_Num, "", "", "", "");
		Step_End(13, "Click search and fetch the BL", test, test1);
		Step_Start(14, "Go to remarks tab and match the DO numbers with Delivery order screen (Same Bl)", test, test1);
		scrollBottom(driver);
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		List<Map<String, String>> importDoc_RemarksTab_details = getTableData(driver, Remarks_Tab_Column_Header, Remarks_Tab_Column_Row);
		List<String> Remarks_Details = getValuesByFirstColumnAndHeader(importDoc_RemarksTab_details, "Reference Type", "Delivery Order", "Reference Value");
		System.out.println("Remark_details:"+Remarks_Details);
		for(int i=0;i<DO_Numbers.size();i++)
			if(Remarks_Details.contains(DO_Numbers.get(i))) {
				System.out.println("Delivery Order number  matched with Import Documentation remarks tab");
			}
		Step_End(14, "Go to remarks tab and match the DO numbers with Delivery order screen (Same Bl)", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			moduleNavigate(driver, DeliveryOrderModule);
			for(String DO_Number : DO_Numbers) {
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_DO1, DO_Number, "", "", "", "");
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
		Extent_completed(testcase_Name, test, test1);
	}
}
