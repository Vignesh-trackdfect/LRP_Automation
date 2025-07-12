package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TS_EMS_Contract_Registration_18 extends Keywords {

	public void EMS_Contract_Registration_18(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TS_EMS_Contract_Registration_18";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String contract_no = Excel_data.get("contract_no");
		String ContractType = Excel_data.get("ContractType");
		String leasekind = Excel_data.get("leasekind");
		String lessor_code = Excel_data.get("lessor_code");
		String lessee_code = Excel_data.get("lessee_code");
		String From_Date_Edit = Excel_data.get("From_Date_Edit");
		String Date_Popup = Excel_data.get("Date_Popup");
		String To_Date_Edit = Excel_data.get("To_Date_Edit");
		String contractage = Excel_data.get("contractage");
		String contract_category = Excel_data.get("contract_category");
		String service_input = Excel_data.get("service_input");
		String eff_date = Excel_data.get("eff_date");
		String trade_input = Excel_data.get("trade_input");
		String remarkstext = Excel_data.get("remarkstext");
		String lessorref_input = Excel_data.get("lessorref_input");
		String validprefix_input = Excel_data.get("validprefix_input");
		String oneway_checkbox = Excel_data.get("oneway_checkbox");
		String purchase_checkbox = Excel_data.get("purchase_checkbox");
		String unitteu_input = Excel_data.get("unitteu_input");
		String dropoff_checkbox = Excel_data.get("dropoff_checkbox");
		String offhire_input = Excel_data.get("offhire_input");
		String currency_input = Excel_data.get("currency_input");
		String diallow_input = Excel_data.get("diallow_input");
		String difee_input = Excel_data.get("difee_input");
		String billpay_input = Excel_data.get("billpay_input");
		String buildup_input = Excel_data.get("buildup_input");
		String builddown_input = Excel_data.get("builddown_input");
		String minperiod_input = Excel_data.get("minperiod_input");
		String From_date_Entered = Excel_data.get("From_date_Entered");
		String To_Date_entered = Excel_data.get("To_Date_entered");
		String date_Picker = Excel_data.get("date_Picker");
		String conditionFilter = Excel_data.get("conditionFilter");
		String Lease_Code_search = Excel_data.get("Lease_Code_search");
		String Lessor_code_search = Excel_data.get("Lessor_code_search");
		String lessee_code_Search = Excel_data.get("lessee_code_Search");
		String To_Date = Excel_data.get("To_Date");
		String from_date = Excel_data.get("from_date");



		
		String contype_opt1 =  String.format(DropDown_Select,  ContractType); 
		String unit_Teu =  String.format(DropDown_Select,  unitteu_input); 
		String con_Cat =  String.format(con_cat,  contract_category); 
		String currency_Value =  String.format(currency_value,  contract_category); 
		String diallow_Value =  String.format(diallow_value,  diallow_input); 
		String billpay_Value =  String.format(billpay_value,  billpay_input); 



		// login

		Extent_Start(testcase_Name, test, test1);


		// login
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1, "Enter module name in searchbox & click the module");



		
		moduleNavigate(driver, Search_input);



		waitForElement(driver, SaveButton_ToolBar);
		waitForElement(driver, Econtractno_field);
		click(driver, Econtractno_field);
		sendKeys(driver, Econtractno_field, contract_no);


		waitForElement(driver, Econtracttype_field);
		click(driver, Econtracttype_field);
		waitForDisplay(driver, contract_types);
		if (!isDisplayed(driver, contract_types)) {
			click(driver, Econtracttype_field);
		}

		waitForElement(driver, contype_opt1);
		click(driver, contype_opt1);

		waitForElement(driver, Eleasekind_searchicon);
		click(driver, Eleasekind_searchicon);
		

		twoColumnSearchWindow(driver, Lease_Code_search, conditionFilter, leasekind);

		waitForElement(driver, Elessorcode_searchicon);
		click(driver, Elessorcode_searchicon);
		twoColumnSearchWindow(driver, Lessor_code_search, conditionFilter, lessor_code);


		
		
		waitForElement(driver, Elessee_searchicon);
		click(driver, Elessee_searchicon);
		twoColumnSearchWindow(driver, lessee_code_Search, conditionFilter, lessee_code);


		Step_Start(1, "Ensure system should validate if user try to save with From date greater than To date.", test, test1);

		waitForElement(driver, Evaild_from);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_from, from_date);
		} else {
			waitForElement(driver, Evaild_from);
			clearAndType(driver, Evaild_from, from_date);
		}
		
		waitForElement(driver, Evaild_to);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_to, To_Date);
		} else {
			waitForElement(driver, Evaild_to);
			clearAndType(driver, Evaild_to, To_Date);
		}


		waitForElement(driver, Evaild_from);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_from, From_Date_Edit);
		} else {
			waitForElement(driver, Evaild_from);
			clearAndType(driver, Evaild_from, From_Date_Edit);
		}


		

		waitForElement(driver, Evaild_from);
		String Fromdate_edit = getAttribute(driver, Evaild_from, "value");
		waitForElement(driver, Evaild_to);
		String Todate = getAttribute(driver, Evaild_to, "value");
		if (!Fromdate_edit.equals(Todate)) {
			// comparing from date after to date
			System.out.println(
					"NotMatched || Expected date was : " + Fromdate_edit + " || Actual date was : " + Todate);
			Extent_pass_New(driver,
					"NotMatched || Expected date was : " + Fromdate_edit + " || Actual date was : " + Todate, test,
					test1);
		} else {
			System.out.println("Matched || Expected date was : " + Fromdate_edit + " || Actual date was : " + Todate);
			Extent_fail(driver, "Matched || Expected date was : " + Fromdate_edit + " || Actual date was : " + Todate,
					test, test1);
		}

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		

		Step_End(1, "Ensure system should validate if user try to save with From date greater than To date.", test, test1);


		Step_Start(2, "Ensure that system should validate as 'Valid From should be before the Valid To'.", test, test1);


		waitForPopup(driver, Popup_Message, Date_Popup);
		String DatepopUp = getText(driver, Popup_Message);
		System.out.println(DatepopUp);
		if (DatepopUp.equals(Date_Popup)) {
			System.out.println("Matched || Expected popup was : " + DatepopUp + " || Actual popup was : " + Date_Popup);
			Extent_pass_New(driver, "Matched || Expected popup was : " + DatepopUp + " || Actual popup was : " + Date_Popup,
					test, test1);
		} else {
			System.out.println(
					"NotMatched || Expected popup was : " + DatepopUp + " || Actual popup was : " + Date_Popup);
			Extent_fail(driver,
					"NotMatched || Expected popup was : " + DatepopUp + " || Actual popup was : " + Date_Popup, test,
					test1);

		}


		Step_End(2, "Ensure that system should validate as 'Valid From should be before the Valid To'.", test, test1);

		waitForElement(driver, Evaild_to);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_to, To_Date_Edit);
		} else {
			waitForElement(driver, Evaild_to);
			clearAndType(driver, Evaild_to, To_Date_Edit);
		}


		waitForElement(driver, Evaild_to);
		String Todate_edit = getAttribute(driver, Evaild_to, "value");
		String fromdate = getAttribute(driver, Evaild_from, "value");
		if (!Todate_edit.equals(fromdate)) {

			System.out.println(
					"NotMatched || Expected value was : " + fromdate + " || Actual value was : " + Todate_edit);
			Extent_pass_New(driver,
					"NotMatched || Expected value was : " + fromdate + " || Actual value was : " + Todate_edit, test,
					test1);
		} else {
			System.out.println("Matched || Expected value was : " + fromdate + " || Actual value was : " + Todate_edit);
			Extent_fail(driver, "Matched || Expected value was : " + fromdate + " || Actual value was : " + Todate_edit,
					test, test1);
		}

		String todate = To_Date_entered;
		String fromdate1 = From_date_Entered;
		String newvalue1 = fromdate1.replace("/", "").trim();
		int num1 = Integer.parseInt(newvalue1);

		String newvalue2 = todate.replace("/", "").trim();
		int num2 = Integer.parseInt(newvalue2);

		if (num1 < num2) {
			System.out.println("Expected Result is :Valid From should be before the Valid To || Actual Result is :Expected Result is :Valid From is  before the Valid To");
			Extent_pass_New(driver, "Expected Result is :Valid From should be before the Valid To || Actual Result is :Expected Result is :Valid From is  before the Valid To", test, test1);
		} else {
			System.out.println("Expected Result is :Valid From should be before the Valid To || Actual Result is :Expected Result is :Valid From is not  before the Valid To");
			Extent_fail(driver, "Expected Result is :Valid From should be before the Valid To || Actual Result is :Expected Result is :Valid From is not  before the Valid To", test, test1);
		}

		// *************Registration non-mandatory fields**************

		if (!contractage.equals("")) {
			waitForElement(driver, contract_age);

			try {
				sendKeys(driver, contract_age, contractage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("contractage " + "Input Not Available in test data");
		}

		if (!contract_category.equals("")) {
			waitForElement(driver, contractcate);
			click(driver, contractcate);
			try {
				waitForElement(driver, con_Cat);
				click(driver, con_Cat);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("contract_category " + "Input Not Available in test data");
		}

		if (!service_input.equals("")) {
			try {
				waitForElement(driver, service_searchicon);
				click(driver, service_searchicon);
				waitForElement(driver, service_Search_field);
				sendKeys(driver, service_Search_field, service_input);
				waitForElement(driver, service_selectbtn);
				click(driver, service_selectbtn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("service_input36 " + "Input Not Available in test data");
		}

		if (!trade_input.equals("")) {
			try {
				waitForElement(driver, trade_searchicon);
				click(driver, trade_searchicon);
				waitForElement(driver, service_Search_field);
				sendKeys(driver, service_Search_field, trade_input);
				waitForElement(driver, service_selectbtn);
				click(driver, service_selectbtn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("trade_input " + "Input Not Available in test data");
		}

		if (!eff_date.equals("")) {


			waitForElement(driver, effective_date);
			
			waitForElement(driver, effective_date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, effective_date, eff_date);
			} else {
				waitForElement(driver, effective_date);
				clearAndType(driver, effective_date, eff_date);
			}
			
			
		} else {
			System.out.println("eff_date " + "Input Not Available in test data");
		}

		if (!remarkstext.equals("")) {
			waitForElement(driver, remarks);
			try {
				sendKeys(driver, remarks, remarkstext);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("remarkstext " + "Input Not Available in test data");
		}

		if (!lessorref_input.equals("")) {
			waitForElement(driver, lessor_ref);
			try {
				sendKeys(driver, lessor_ref, lessorref_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("lessorref_input " + "Input Not Available in test data");
		}

		if (!validprefix_input.equals("")) {
			try {
				waitForElement(driver, valid_prefix_addicon);
				click(driver, valid_prefix_addicon);
				waitForElement(driver, service_Search_field);
				sendKeys(driver, service_Search_field, validprefix_input);
				waitForElement(driver, valid_prefix_select);
				click(driver, valid_prefix_select);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("validprefix_input " + "Input Not Available in test data");
		}

		checkBox(driver, oneway, oneway_checkbox);
		checkBox(driver, purchase, purchase_checkbox);

		if (!unitteu_input.equals("")) {
			waitForElement(driver, dropoff);
			checkBox(driver, dropoff, dropoff_checkbox);
			try {
				waitForElement(driver, unit_teu);
				click(driver, unit_teu);

				waitForElement(driver, unit_Teu);
				click(driver, unit_Teu);
				waitForElement(driver, offhire);
				sendKeys(driver, offhire, offhire_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("unitteu_input " + "Input Not Available in test data");
		}

		if (!currency_input.equals("")) {
			waitForElement(driver, currency1);
			click(driver, currency1);
			try {
				waitForElement(driver, currency_Value);
				click(driver, currency_Value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("currency_input " + "Input Not Available in test data");
		}

		if (diallow_input.equals("Yes")) {
			waitForElement(driver, di_allow);
			click(driver, di_allow);
			try {
				waitForElement(driver, diallow_Value);
				click(driver, diallow_Value);
				waitForElement(driver, difee);
				clear(driver, difee);
				sendKeys(driver, difee, difee_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("diallow_input " + "Input Not Available in test data");
		}

		if (!billpay_input.equals("")) {
			waitForElement(driver, bill_paytype);
			click(driver, bill_paytype);
			try {
				waitForElement(driver, billpay_Value);
				click(driver, billpay_Value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("billpay_input " + "Input Not Available in test data");
		}

		if (!buildup_input.equals("")) {
			waitForElement(driver, buildup_period);
			try {
				sendKeys(driver, buildup_period, buildup_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("buildup_input " + "Input Not Available in test data");
		}

		if (!builddown_input.equals("")) {
			waitForElement(driver, builddown_period);
			try {
				sendKeys(driver, builddown_period, builddown_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("builddown_input " + "Input Not Available in test data");
		}

		if (!minperiod_input.equals("")) {
			waitForElement(driver, min_period);
			try {
				sendKeys(driver, min_period, minperiod_input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("minperiod_input " + "Input Not Available in test data");
		}

		Extent_completed(testcase_Name, test, test1);
	}
}
