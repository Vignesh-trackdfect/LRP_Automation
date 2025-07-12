package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_006 extends Keywords{
	public void Arrival_Notice_TS_006(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data

		String testcase_Name="TC_Arrival_Notice_TS_006";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Customer_Code = Excel_data.get("Customer_Code");
		String Customer_Name = Excel_data.get("Customer_Name");
		String Fax_Button_Check = Excel_data.get("Fax_Button_Check");
		String pol_TF_check = Excel_data.get("pol_TF_check");
		String ETD_TF_Check = Excel_data.get("ETD_TF_Check");
		String ETA_TF_Check = Excel_data.get("ETA_TF_Check");
		String pod_TF_Check = Excel_data.get("pod_TF_Check");
		String discharge_Bound_TF_Check = Excel_data.get("discharge_Bound_TF_Check");
		String Show_Button_Check = Excel_data.get("Show_Button_Check");
		String blNn_copy_Button_Check = Excel_data.get("blNn_copy_Button_Check");
		String Auction_Notice_Button_Check = Excel_data.get("Auction_Notice_Button_Check");
		String discharge_Vessel_TF_Check = Excel_data.get("discharge_Vessel_TF_Check");
		String discharge_Voyage_TF_check = Excel_data.get("discharge_Voyage_TF_check");
		String discharge_Terminal_TF_Check = Excel_data.get("discharge_Terminal_TF_Check");
		String Mail_Button_Check = Excel_data.get("Mail_Button_Check");
		String Customer_Search_Check = Excel_data.get("Customer_Search_Check");
		String Customer_name_search = Excel_data.get("Customer_name_search");
		String Customer_code_search = Excel_data.get("Customer_code_search");
		String Gird_Record_Check = Excel_data.get("Gird_Record_Check");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);
		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, ArrivalNotice_Module);


		Step_End(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);
		Step_Start(3, "Click By customer option", test, test1);
		waitForElement(driver, by_customer_AN);
		click(driver, by_customer_AN);

		Step_End(3, "Click By customer option", test, test1);
		Step_Start(4, ".Enter the customer detail", test, test1);
		waitForElement(driver, customer_Search_Button_AN);
		click(driver, customer_Search_Button_AN);
		globalValueSearchWindow(driver, BL_Condition, Customer_code_search, Customer_Code, Customer_name_search, Customer_Name, "", "");


		Step_End(4, "Enter the customer detail", test, test1);


		if(Customer_Search_Check.equalsIgnoreCase("Y")) {
			if(isClickable(driver, customer_Search_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is : Customer Search button Should be Enable || Actual Result is : Customer Search button  is Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Customer Search button Should be Enable || Actual Result is :Customer Search button  is Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is : Customer Search button Should be Enable || Actual Result is : Customer Search button is Not Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Customer Search button Should be Enable || Actual Result is : Customer Search button  is Not Enabled", test, test1);
			}
		}



		if(Show_Button_Check.equalsIgnoreCase("Y")) {
			if(isClickable(driver, show_Btn_An)) {


				Extent_pass(driver, "Matched || Expected Result is : Show button Should be Enable || Actual Result is : Show button is Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Show button Should be Enable || Actual Result is :Show button is Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is : Show button Should be Enable || Actual Result is : Show button is Not Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Show button Should be Enable || Actual Result is : Show button is Not Enabled", test, test1);
			}
		}


		if(Fax_Button_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, fax_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Fax button Should not be Enable || Actual Result is :Fax button is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Fax button Should not be Enable || Actual Result is : Fax button is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Fax button Should  NOT be Enable  || Actual Result is : Fax button is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Fax button Should  NOT be Enable  || Actual Result is : Fax button is  Enabled", test, test1);
			}
		}

		if(Auction_Notice_Button_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, auction_Notice_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Auction Notice button Should not be Enable || Actual Result is :Auction Notice button is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Auction Notice button Should not be Enable || Actual Result is : Auction Notice button is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Auction Notice button Should NOT be Enable  || Actual Result is : Auction Notice button is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Auction Notice button Should  NOT be Enable  || Actual Result is : Auction Notice button is  Enabled", test, test1);
			}
		}

		if(Mail_Button_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, mail_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Mail button Should not be Enable || Actual Result is :Mail button is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Mail button Should not be Enable || Actual Result is : Mail button is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Mail button Should  NOT be Enable  || Actual Result is : Mail button is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Mail button Should NOT be Enable  || Actual Result is : Mail button is  Enabled", test, test1);
			}
		}


		if(blNn_copy_Button_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, blNn_copy_Button_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :BLNNCopy button Should not be Enable || Actual Result is :BLNNCopy button is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : BLNNCopy button Should not be Enable || Actual Result is : BLNNCopy button is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :BLNNCopy button Should NOT be Enable  || Actual Result is : BLNNCopy button is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : BLNNCopy button Should NOT be Enable  || Actual Result is : BLNNCopy button is  Enabled", test, test1);
			}
		}
		Step_Start(5, "click show ", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(5, "click show ", test, test1);

		Step_Start(6, "Ensure vessel details should not be editable", test, test1);
		waitForElement(driver, show_Btn_An);
		if(discharge_Vessel_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, discharge_Vessel_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Discharge Vessel  TF Should not be Enable || Actual Result is :Discharge Vessel  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Discharge Vessel  TF Should not be Enable || Actual Result is : Discharge Vessel  TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Discharge Vessel  TF Should NOT be Enable  || Actual Result is : Discharge Vessel  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Discharge Vessel  TF Should NOT  be Enable  || Actual Result is : Discharge Vessel  TF is  Enabled", test, test1);
			}
		}




		if(discharge_Voyage_TF_check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, discharge_Voyage_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Discharge Voyage  TF Should not be Enable || Actual Result is :Discharge Voyage  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Discharge Voyage  TF Should not be Enable || Actual Result is : Discharge Voyage  TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Discharge Voyage  TF Should  not be Enable  || Actual Result is : Discharge Voyage  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Discharge Voyage  TF Should not  be Enable  || Actual Result is : Discharge Voyage  TF is  Enabled", test, test1);
			}
		}

		if(discharge_Bound_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, discharge_Bound_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Discharge Bound  TF Should not be Enable || Actual Result is :Discharge Bound  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Discharge Bound  TF Should not be Enable || Actual Result is : Discharge Bound  TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Discharge Bound  TF Should  not be Enable  || Actual Result is : Discharge Bound  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Discharge Bound  TF Should  not be Enable  || Actual Result is : Discharge Bound  TF is  Enabled", test, test1);
			}
		}

		if(pod_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, pod_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :POD  TF Should not be Enable || Actual Result is :POD  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : POD  TF Should not be Enable || Actual Result is : POD  TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :POD  TF Should  be Enable  || Actual Result is : POD  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : POD  TF  Should  be Enable  || Actual Result is : POD  TF is  Enabled", test, test1);
			}
		}


		if(discharge_Terminal_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, discharge_Terminal_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :Discharge Terminal  TF Should not be Enable || Actual Result is :Discharge Terminal  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : Discharge Terminal  TF Should not be Enable || Actual Result is : Discharge Terminal  TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :Discharge Terminal  TF Should  be Enable  || Actual Result is : Discharge Terminal  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : Discharge Terminal  TF  Should  be Enable  || Actual Result is : Discharge Terminal  TF is  Enabled", test, test1);
			}
		}


		if(ETA_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, ETA_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :ETA  TF Should not be Enable || Actual Result is :ETA  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : ETA  TF Should not be Enable || Actual Result is : ETA TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :ETA  TF Should  be Enable  || Actual Result is : ETA  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : ETA  TF  Should  be Enable  || Actual Result is : ETA  TF is  Enabled", test, test1);
			}
		}

		if(ETD_TF_Check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, ETD_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :ETD  TF Should not be Enable || Actual Result is :ETD  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : ETD  TF Should not be Enable || Actual Result is : ETD TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :ETD  TF Should  be Enable  || Actual Result is : ETD  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : ETD  TF  Should  be Enable  || Actual Result is : ETD  TF is  Enabled", test, test1);
			}
		}

		if(pol_TF_check.equalsIgnoreCase("Y")) {
			if(elementNotclickable(driver, pol_TF_AN)) {
				Extent_pass(driver, "Matched || Expected Result is :POL  TF Should not be Enable || Actual Result is :POL  TF is not Enabled", test, test1);
				System.out.println("Matched || Expected Result is : POL  TF Should not be Enable || Actual Result is : POL TF is not Enabled");
			}else {
				System.out.println("Not Matched || Expected Result is :POL  TF Should  be Enable  || Actual Result is : POL  TF is  Enabled");
				Extent_fail(driver,"Not Matched || Expected Result is : POL  TF  Should  be Enable  || Actual Result is : POL  TF is  Enabled", test, test1);
			}
		}

		Step_End(6, "Ensure vessel details should not be editable", test, test1);

		if(Gird_Record_Check.equalsIgnoreCase("Y")) {
		waitForDisplay(driver, bl_Number_Grid_AN);
		if(isDisplayed(driver, bl_Number_Grid_AN)) {
			Extent_pass(driver, "Matched || Expected Result is :Grid records Should  be Display || Actual Result is :Grid records is Displayed", test, test1);
			System.out.println("Matched || Expected Result is : Grid records Should  be Display || Actual Result is : Grid records is Displayed");
		}else {
			System.out.println("Not Matched || Expected Result is :Grid records Should  not be Display  || Actual Result is : Grid records is Displayed");
			Extent_fail(driver,"Not Matched || Expected Result is : Grid records Should  not be Display  || Actual Result is : Grid records is Displayed", test, test1);
		}}




		Extent_completed(testcase_Name, test, test1);



	}
}
