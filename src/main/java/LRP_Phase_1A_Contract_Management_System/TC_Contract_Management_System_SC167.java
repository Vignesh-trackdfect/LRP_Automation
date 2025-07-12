package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC167 extends Keywords {

	public void Contract_Management_System_SC167(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC167";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Rate_Request_RR_Module = Excel_data.get("Rate_Request_RR_Module");
		String Rate_request_type_sel = Excel_data.get("Rate_request_type_sel");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Select_field = Excel_data.get("Select_field");
		String Select_field1 = Excel_data.get("Select_field1");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String CMS_Equipment_Type_Header = Excel_data.get("CMS_Equipment_Type_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery = Excel_data.get("Delivery");
		String Contract_No = Excel_data.get("Contract_No");
		String Origin_Header = Excel_data.get("Origin_Header");
		String Origin = Excel_data.get("Origin");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Rate_Request_number = Excel_data.get("Rate_Request_number");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Contract_Verified = Excel_data.get("Contract_Verified");
		String EffectiveDate = Excel_data.get("EffectiveDate");
		String Activated = Excel_data.get("Activated");
		String Signature_Date = Excel_data.get("Signature_Date");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, " Create a AC contract in FMC/LRR in agency ,", test, test1);
		Step_Start(2, " And file the NC contract.", test, test1);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, Rate_Request_RR_Module);

		waitForElement(driver, RR_New_btn);
		click(driver, RR_New_btn);

		waitForElement(driver, RR_Fmc);
		click(driver, RR_Fmc);

		waitForElement(driver, RR_Containerised);
		click(driver, RR_Containerised);

		waitForElement(driver, RR_Req_Type_Dropdown);
		click(driver, RR_Req_Type_Dropdown);

		formatLocatorjsClick(driver, R_Req_Type_Dropdown_select, Rate_request_type_sel);

		waitForElement(driver, RR_contractno_searchbar);
		click(driver, RR_contractno_searchbar);

		globalValueSearchWindow(driver, Search_Condition, Select_field, Contract_No, "", "", "", "");

		waitForElement(driver, RR_Edit);
		click(driver, RR_Edit);

		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, RR_Internal_Commodity);
		sendKeys(driver, RR_Internal_Commodity, Internal_Commodity);

		String select_Internal_Commmodity = String.format(RR_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);

		waitForElement(driver, RR_Internal_Commodity_add);
		click(driver, RR_Internal_Commodity_add);

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

		waitForElement(driver, RR_Add_btn);
		click(driver, RR_Add_btn);

		waitForElement(driver, RR_Submit_btn);
		click(driver, RR_Submit_btn);

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		scrollTop(driver);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, Switch_Profile);
		click(driver, Switch_Profile);

		waitForElement(driver, reset_Profile_Button);
		click(driver, reset_Profile_Button);

		moduleNavigate(driver, Rate_Request_RR_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition1, Select_field1, Rate_Request_number, "", "", "", "");

		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
		scrollTop(driver);

		waitForElement(driver, Contract_Management_System_General);
		click(driver, Contract_Management_System_General);

		waitForElement(driver, RR_Request_No);

		String Raterequest_number = getAttribute(driver, RR_Request_No, "value");

		System.out.println("Raterequest Number in RR module :" + Raterequest_number);

		Step_End(1, " Create a AC contract in FMC/LRR in agency ,", test, test1);
		Step_End(2, "And file the NC contract. ", test, test1);

		Step_Start(3, "  Click on the move to CMS option. ", test, test1);
		
		waitForElement(driver, RR_Move_To_CMS_Btn);
		click(driver, RR_Move_To_CMS_Btn);
		
		Step_End(3, "  Click on the move to CMS option. ", test, test1);
		
		Step_Start(4, "  The system will import the port pair lanes from NC contract to CMS.", test, test1);

		waitForElement(driver, RR_ratereference_tab);
		click(driver, RR_ratereference_tab);

		waitForElement(driver, CMS_amd_number);

		String amendmentno_cms = getAttribute(driver, CMS_amd_number, "value");

		System.out.println("Ammendment Number in CMS module :" + amendmentno_cms);

		waitForElement(driver, RR_amdno_reftab);
		List<WebElement> AmtNot = listOfElements(driver, RR_amdno_reftab);
		int AmtLast = AmtNot.size() - 1;

		String amntnumber = AmtNot.get(AmtLast).getText();

		waitForElement(driver, RR_raterequestno_reftab);
		List<WebElement> ratereqno = listOfElements(driver, RR_raterequestno_reftab);
		int ratereq = ratereqno.size() - 1;

		String ratereqnumberin_RR = ratereqno.get(ratereq).getText();

		if (Raterequest_number.equals(ratereqnumberin_RR)) {
			System.out.println(
					"Matched || Expected value is :  The raterequest number in RR module should match with CMS module in RATE reference tab, The Raterequest Number is  : "
							+ Raterequest_number
							+ " || Actual value is : The raterequest number in RR module is matched with CMS module in RATE reference tab :"
							+ ratereqnumberin_RR);
			Extent_pass(driver,
					"Matched || Expected value is : The raterequest number in RR module should match with CMS module in RATE reference tab, The Raterequest Number is  : "
							+ Raterequest_number
							+ " || Actual value is : The raterequest number in RR module is matched with CMS module in RATE reference tab, The Raterequest Number is :"
							+ ratereqnumberin_RR,
					test, test1);

		} else {

			System.out.println(
					"UnMatched || Expected value is : The raterequest number in RR module should match with CMS module in RATE reference tab, The Raterequest Number should be  : "
							+ Raterequest_number
							+ " || Actual value is : The raterequest number in RR module is not matching with CMS module in RATE reference tab, The status is :"
							+ ratereqnumberin_RR);

			Extent_fail(driver,
					"UnMatched || Expected value is : The raterequest number in RR module should match with CMS module in RATE reference tab , Raterequest Number"
							+ Raterequest_number
							+ " || Actual value is : The raterequest number in RR module is not matching with CMS module in RATE reference tab, The status is :"
							+ ratereqnumberin_RR,
					test, test1);

		}

		if (amendmentno_cms.equals(amntnumber)) {
			System.out.println(
					"Matched || Expected value is : ammendment number should be matched , The status should be  : "
							+ amendmentno_cms
							+ " || Actual value is : ammendment number should be matched, The status is :"
							+ amntnumber);
			Extent_pass(driver,
					"Matched || Expected value is : ammendment number should be matched, The status should be  : "
							+ amendmentno_cms
							+ " || Actual value is : ammendment number should be matched, The status is :" + amntnumber,
					test, test1);

		} else {

			System.out.println(
					"UnMatched || Expected value is : ammendment number should be matched, The status should be  : "
							+ amendmentno_cms
							+ " || Actual value is : ammendment number is not matched, The status is :" + amntnumber);

			Extent_fail(driver,
					"UnMatched || Expected value is : ammendment number should be matched, The status should be  : "
							+ amendmentno_cms
							+ " || Actual value is : ammendment number is not matched, The status is :" + amntnumber,
					test, test1);

		}

		
		Step_End(4, "  The system will import the port pair lanes from NC contract to CMS.", test, test1);
		
		Step_Start(5, "  save the contract and activate.", test, test1);
		
		
		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		
		
		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);
		
		
		
		waitForPopup(driver, Popup_Message, Contract_Verified);
		String verified_popup1 =getText(driver, Popup_Message);
		System.out.println("verified_popup :"+verified_popup1);
		
		if(Contract_Verified.equals(verified_popup1)) {
			Extent_pass(driver,"Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup1, test,test1);
			System.out.println("Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is : "+ verified_popup1);
		}else {
			System.out.println("Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display :"+ verified_popup1);
			Extent_fail(driver,"Not Matched || Expected value is : After click on approved button the popup  message should be : "+Contract_Verified+" || Actual value is : After click on approved button the popup  message is not display : "+ verified_popup1, test,test1);
			
		}	
		
		

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);
		
		if(!EffectiveDate.trim().equals("")) {
			waitForElement(driver, AMD_Effective_Date);
			click(driver, AMD_Effective_Date);
			selectDatePicker(driver, AMD_Effective_Date,EffectiveDate);
		}
		
		if(!Signature_Date.trim().equals("")) {
			waitForElement(driver, signature_Date);
			selectDatePicker(driver, signature_Date,Signature_Date);
		}
		
		waitForElement(driver, Contract_Management_System_Active);
		click(driver, Contract_Management_System_Active);
		

		waitForElement(driver, Contract_Management_System_status);
		String Activated_avl = getAttribute(driver, Contract_Management_System_status, "value");
		System.out.println("Activated_avl :" + Activated_avl);

		if (Activated_avl.equals(Activated)) {
			System.out.println("Matched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl);
			Extent_pass(driver,"Matched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl, test,test1);
			
		} else {

			System.out.println("UnMatched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl);

			Extent_fail(driver,"UnMatched || Expected value is : After click on Activate button, The status should be  : " + Activated + " || Actual value is : After click on Activate button, The status is :" + Activated_avl, test,test1);
		
		}
		
		
		Step_End(5, "  save the contract and activate.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
