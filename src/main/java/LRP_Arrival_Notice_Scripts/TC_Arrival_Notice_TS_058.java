package LRP_Arrival_Notice_Scripts;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_058 extends Keywords {

	public void Arrival_Notice_TS_058(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Arrival_Notice_TS_058";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfiguration_Module = Excel_data.get("AgencyConfiguration_Module");
		String Agency_Code_search = Excel_data.get("Agency_Code_search");
		String Attribute_Search = Excel_data.get("Attribute_Search");
		String condition_Filter = Excel_data.get("condition_Filter");
		String attribute = Excel_data.get("attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String CustomerMaster_Module = Excel_data.get("CustomerMaster_Module");
		String Condition = Excel_data.get("Condition");
		String Customer_Name_search = Excel_data.get("Customer_Name_search");
		String Customer_Name = Excel_data.get("Customer_Name");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String Headers = Excel_data.get("Headers");
		String value1 = Excel_data.get("Default_Value_Set");
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Agency configuration screen", test, test1);

		setAgencyConfiguration(driver, AgencyConfiguration_Module, Agency_Code_search, Attribute_Search, condition_Filter, AgencyUser, attribute, description, value);
		
	
		
		moduleNavigate(driver, CustomerMaster_Module);

		Step_End(4, "Open customer master screen", test, test1);
		Step_Start(5, "Search the customer code and fetch it", test, test1);
		waitForElement(driver, customer_Master_Search_Button_AN);
		click(driver, customer_Master_Search_Button_AN);

		
		globalValueSearchWindow(driver, Condition, Customer_Name_search, Customer_Name, "", "", "", "");
		
		Step_End(5, "Search the customer code and fetch it", test, test1);

		scrollBottom(driver);
		Step_Start(6, "Go to notification tab", test, test1);
		waitForElement(driver, customer_Master_Notification_Tab_AN);
		click(driver, customer_Master_Notification_Tab_AN);
		Step_End(6, "Go to notification tab", test, test1);



		Step_Start(7, "Copy the arrival notice mail id (Notification type as \"arrival notice\")", test, test1);
		List<Map<String, String>> table_Data = getTableData(driver, customer_Master_NotificationTab_Header, customer_Master_NotificationTab_Rows);

		List<String> mail_Ids = getValuesByFirstColumnAndHeader(table_Data, "Notification Type", "Arrival Notice", "Email");
		Collections.sort(mail_Ids);
		System.out.println(mail_Ids);
		Extent_call(test, test1, "Mail id shown in customer tab"+mail_Ids);
		Step_End(7, "Copy the arrival notice mail id (Notification type as \"arrival notice\")", test, test1);
		mouseOverToElement(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);


		Step_Start(8, "Open Import documentation screen", test, test1);
	
		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(8, "Open Import documentation screen", test, test1);

		Step_Start(9, "Click search and paste the BL", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, Search_Number, BL_Num, "", "", "", "");
		
	

		Step_End(9, "Click search and paste the BL", test, test1);

		Step_Start(10, "After fetching the BL Navigate to arrival notice screen.", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(10, "After fetching the BL Navigate to arrival notice screen.", test, test1);
	mouseOverToElement(driver, tool_Pannel_AN);

		Step_Start(11, "Select the BL by condition filter option", test, test1);
		waitForElement(driver, tool_Pannel_AN);
		click(driver, tool_Pannel_AN);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);

		waitForElement(driver, blNumber_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN, BL_Num);
		Step_End(11, "Select the BL by condition filter option", test, test1);
		Step_Start(12, "Scroll right side and check in consignee mail box", test, test1);
		reArrangeAG_GridColumnsNew(driver,AN_coloum_click, Headers);
		
		
		Step_End(12, "Scroll right side and check in consignee mail box", test, test1);

		Step_Start(13, "Make sure  the Email id were matched with customer master (notification tab)", test, test1);
		waitForElement(driver, consignee_Email_AN);
		
		waitForElement(driver, Expand_coloum_Arrival);
		doubleClick(driver, Expand_coloum_Arrival);
		
		
		String Consignee_Email=getText(driver, consignee_Email_AN);
		System.out.println(Consignee_Email);

		List<String> act_mail = splitAndExpand(Consignee_Email);

		if(mail_Ids.equals(act_mail)) {

			System.out.println(
					"Matched || Mail ID taken from Customer Master notifications Tab : " + mail_Ids + " || Mail ID taken from Arrival Notice Module  : " + act_mail);
			Extent_pass(driver,
					"Matched || Mail ID taken from Customer Master notifications Tab : " + mail_Ids + " || Mail ID taken from Arrival Notice Module  : " + act_mail, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || Mail ID taken from Customer Master notifications Tab : " + mail_Ids + " || Mail ID taken from Arrival Notice Module  : " + act_mail);
			Extent_fail(driver,
					"NotMatched || Mail ID taken from Customer Master notifications Tab : " + mail_Ids + " || Mail ID taken from Arrival Notice Module  : " + act_mail,
					test, test1);

		}
		Step_End(13, "Make sure  the Email id were matched with customer master (notification tab)", test, test1);

		// Agency Configuration
		setAgencyConfiguration(driver, AgencyConfiguration_Module, Agency_Code_search, Attribute_Search, Condition, AgencyUser, attribute, description, value1);
		
		
		Extent_completed(testcase_Name, test, test1);
	}
	}

