package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC163 extends Keywords{

	public void Contract_Management_System_SC163(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC163";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Rate_Request_RR_Module=Excel_data.get("Rate_Request_RR_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery = Excel_data.get("Delivery");
		String Pricing_offer = Excel_data.get("Pricing_offer");
		String Origin_Header = Excel_data.get("Origin_Header");
		String Origin = Excel_data.get("Origin");
		String RR_Remark = Excel_data.get("RR_Remark");
		
		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		
		moduleNavigate(driver, Rate_Request_RR_Module);
		

		Step_Start(1, "select FMC check box", test, test1);
		
		waitForElement(driver, RR_New_btn);
		click(driver, RR_New_btn);
		
		waitForElement(driver, RR_Fmc);
		click(driver, RR_Fmc);
		
		Step_End(1, "select FMC check box", test, test1);
		
        Step_Start(2, "select containerized check box", test, test1);
		
		waitForElement(driver, RR_Containerised);
		click(driver, RR_Containerised);
		
		waitForElement(driver, RR_Req_Type_Dropdown);
		click(driver, RR_Req_Type_Dropdown);
		
		waitForElement(driver, RR_Req_Type);
		click(driver, RR_Req_Type);
		
		Step_End(2, "select containerized check box", test, test1);

		Step_Start(3, "Enter the customer name", test, test1);
		
		waitForElement(driver, RR_CustomerName);
		sendKeys(driver, RR_CustomerName, Customer_code_Value);

		waitForElement(driver, RR_Auto_Panel_First);
		safeclick(driver, RR_Auto_Panel_First);

		waitForDisplay(driver, Contract_Management_System_Commodity);
		if (isdisplayed(driver, RR_Exit)) {
			click(driver, RR_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}

		Step_End(3, "Enter the customer name", test, test1);

		Step_Start(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, RR_Internal_Commodity);
		sendKeys(driver, RR_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity = String.format(RR_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);

		waitForElement(driver, RR_Internal_Commodity_add);
		click(driver, RR_Internal_Commodity_add);

		Step_End(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);
		
		Step_Start(5, "and save the contract and activate", test, test1);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);

		waitForElement(driver, RR_Eqp_Search);
		click(driver, RR_Eqp_Search);
		twoColumnSearchWindow(driver, CMS_Equipment_Type_Header, Search_Condition, Eqp_Type);
		
		waitForElement(driver, RR_Origin_search);
		click(driver, RR_Origin_search);

		twoColumnSearchWindow(driver, Origin_Header, Search_Condition, Origin);
		
		waitForElement(driver, RR_Delivery_search);
		click(driver, RR_Delivery_search);

		twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);
		
		
		waitForElement(driver, RR_Pricing_offer);
		sendKeys(driver, RR_Pricing_offer, Pricing_offer);
		

		waitForElement(driver, RR_Add_btn);
		click(driver, RR_Add_btn);
		
		waitForElement(driver, RR_Submit_btn);
		click(driver, RR_Submit_btn);
		
		waitForElement(driver, RR_Edit);
		click(driver, RR_Edit);

		waitForElement(driver, RR_Approve_Btn);
		click(driver, RR_Approve_Btn);
		
		waitForElement(driver, RR_Remarks);
		sendKeys(driver, RR_Remarks, RR_Remark);
		
		waitForElement(driver, RR_Remark_Okbtn);
		click(driver, RR_Remark_Okbtn);
		
		waitForElement(driver, RR_Save_Btn);
		click(driver, RR_Save_Btn);
		

		waitForElement(driver, RR_Promote_btn);
		click(driver, RR_Promote_btn);
		
		waitForElement(driver, RR_Remarks);
		sendKeys(driver, RR_Remarks, RR_Remark);
		
		waitForElement(driver, RR_Remark_Okbtn);
		click(driver, RR_Remark_Okbtn);
		
		waitForElement(driver, RR_Save_Btn);
		click(driver, RR_Save_Btn);
		
		waitForElement(driver, RR_Request_No);
		String RR_request_No_Text = getAttribute(driver, RR_Request_No, "value");
		System.out.println("RR Request No: " + RR_request_No_Text);
		
		
		Step_End(5, "and save the contract and activate", test, test1);
		
		
		Step_Start(6, "Click on the move to CMS option", test, test1);
		
		waitForElement(driver, RR_Move_To_CMS_Btn);
		click(driver, RR_Move_To_CMS_Btn);
		
		waitForElement(driver, RR_Move_To_CMS_New_Cont);
		click(driver, RR_Move_To_CMS_New_Cont);
		
		waitForElement(driver, RR_move_okbtn);
		click(driver, RR_move_okbtn);
		
		Step_End(6, "Click on the move to CMS option", test, test1);
		
		Step_Start(7, "Verify the Rate Request Module Request Number and Customer Contract Management System Rate Referance Tab Request Number are same or not", test, test1);
		
		waitForElement(driver, CMS_Rate_Reference_tab);
		click(driver, CMS_Rate_Reference_tab);
		
		
		String Cms_req_no = String.format(CMS_Rate_Request_No,RR_request_No_Text);
		waitForElement(driver, Cms_req_no);
		String Cms_request_No_Text =getText(driver,Cms_req_no);
		System.out.println("RR Request No: " + Cms_request_No_Text);
		
		
		if(RR_request_No_Text.equals(Cms_request_No_Text)) {
			System.out.println("Matched  ||   Expected : Rate Request Module Request Number "+ RR_request_No_Text+"   ||   Actual : Customer Contract Management System Rate Referance Tab Request Number "+ Cms_request_No_Text);
			Extent_pass(driver, "Matched  ||   Expected : Rate Request Module Request Number "+ RR_request_No_Text+"   ||   Actual : Customer Contract Management System Rate Referance Tab Request Number "+ Cms_request_No_Text, test, test1);
		}else {
			System.out.println("Not Matched  ||   Expected :Rate Request Module Request Number  "+ RR_request_No_Text+"   ||   Actual : Customer Contract Management System Rate Referance Tab Request Number "+ Cms_request_No_Text);
			Extent_fail(driver, "Not Matched  ||   Expected :Rate Request Module Request Number "+ RR_request_No_Text+"   ||   Actual : Customer Contract Management System Rate Referance Tab Request Number "+ Cms_request_No_Text, test, test1);
		}
		
		
		Step_End(7, "Verify the Rate Request Module Request Number and Customer Contract Management System Rate Referance Tab Request Number are same or not", test, test1);
		
	}
}
