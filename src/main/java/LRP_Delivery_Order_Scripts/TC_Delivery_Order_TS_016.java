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



public class TC_Delivery_Order_TS_016 extends Keywords{
	public void Delivery_Order_TS_016(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_016";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Condition = Excel_data.get("Condition");
		String GlobalSearchFilterOption_ID = Excel_data.get("GlobalSearchFilterOption_ID");
		String BL_Num = Excel_data.get("BL_Num");
		String BL_status_value = Excel_data.get("BL_status_value");
		String DO_Saved = Excel_data.get("DO_Saved");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted expected");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to  transhipment agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to  transhipment agency ", test, test1);
		Step_Start(2, "Open Import Documentation module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(2, "Open Import Documentation module", test, test1);
		Step_Start(3, "Click search,paste the BL and fetch the record", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_ID, BL_Num, "", "", "", "");
		Step_Start(3, "Click search,paste the BL and fetch the record", test, test1);
		Step_Start(4, "Make sure import documentation saved", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String BL_status=getText(driver, BL_status_IMP_DOC);
		if(BL_status.equals(BL_status_value)) {
			System.out.println("Matched || Expected BL Number Status was : " + BL_status + " || Actual BL Number Status was : " + BL_status_value);
			Extent_pass_New(driver,"Matched || Expected BL Number Status was : " + BL_status + " || Actual BL Number Status was : " + BL_status_value, test,test1);
		} else {
			System.out.println("Not Matched || Expected BL Number Status was : " + BL_status + " || Actual BL Number Status was : " + BL_status_value);
			Extent_fail(driver,"Not Matched || Expected BL Number Status was : " + BL_status + " || Actual BL Number Status was  : " + BL_status_value,test, test1);
		}
		Step_End(4, "Make sure import documentation saved", test, test1);
		Step_Start(5, "Copy the containers from container tab", test, test1);
		scrollBottom(driver);
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		List<WebElement> Import_Documentation_Container_List = listOfElements(driver, Import_Documentation_Container_Grid);
		int ID_Container = Import_Documentation_Container_List.size();
		System.out.println(ID_Container);
		Step_End(5, "Copy the containers from container tab", test, test1);
		Step_Start(6, "Navigate to Delivery order screen", test, test1);
		scrollTop(driver);
		waitForElement(driver, DO_Button);
		click(driver, DO_Button);
		Step_End(6, "Navigate to Delivery order screen", test, test1);
		scrollTop(driver);
		waitForElement(driver, first_tab_inside_click);
		click(driver, first_tab_inside_click);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		scrollBottom(driver);
		List<WebElement> Delivery_Order_Container_List = listOfElements(driver, DO_Container_Grid);
		int DO_Container = Delivery_Order_Container_List.size();
		System.out.println(DO_Container);
		Step_Start(7, "Select the containers from below grid", test, test1);
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(7, "Select the containers from below grid", test, test1);
		Step_Start(8, "Click the Save button", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(8, "Click the Save button", test, test1);
		Step_Start(9, "Ensure  Delivery order saved  validation done after Do saved", test, test1);
		waitForPopup(driver,Popup_Message,DO_Saved);
		String DO_Saved_Popup=getText(driver, Popup_Message);
		if (DO_Saved_Popup.equals(DO_Saved)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved);
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is : " + DO_Saved);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + DO_Saved_Popup + " || Actual Pop-up value is  : " + DO_Saved,test, test1);
		}
		Step_End(9, "Ensure  Delivery order saved  validation done after Do saved", test, test1);
		Step_Start(10, "Match the containers with Import documentation screen.", test, test1);
		if(ID_Container == DO_Container){
			System.out.println("Matched || Expected Number of BL Number's size is : " + ID_Container + " || Actual Number of BL Number's size is : " + DO_Container);
			Extent_pass_New(driver,"Matched || Expected Number of BL Number's size is : " + ID_Container + " || Actual Number of BL Number's size is : " + DO_Container, test,test1);
		} else {
			System.out.println("Not Matched || Expected Number of BL Number's size is : " + ID_Container + " || Actual Number of BL Number's size is : " + DO_Container);
			Extent_fail(driver,"Not Matched || Expected Number of BL Number's size is : " + ID_Container + " || Actual Number of BL Number's size is  : " + DO_Container,test, test1);
		}
		Step_End(10, "Match the containers with Import documentation screen.", test, test1);
		if(delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(11, "Click the Delete button", test, test1);
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(11, "Click the Delete button", test, test1);
			Step_Start(12, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message,delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if(delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :"+delete_popup_expected+" || ACTUAL DELETE Pop-up value is :"+delete_Msg_Actual, test, test1);
			}
			Step_End(12, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(13, "Click Yes", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(13, "Click Yes", test, test1);
			Step_Start(14, "Ensure system validated as 'Delivery order deleted'", test, test1);
			waitForPopup(driver,Popup_Message,deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if(do_Deleted_Actual.equals(deleted_expected)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : "+deleted_expected+" || ACTUAL Pop-up value is AFTER DELETE "+do_Deleted_Actual, test, test1);
			}
			Step_End(14, "Ensure system validated as 'Delivery order deleted'", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
}
