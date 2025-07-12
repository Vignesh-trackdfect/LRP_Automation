package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TS_EMS_Contract_Registration_11 extends Keywords {

	public void EMS_Contract_Registration11(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TS_EMS_Contract_Registration_11";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String contract_no = Excel_data.get("contract_no");
		String ContractType = Excel_data.get("ContractType");
		String leasekind = Excel_data.get("leasekind");
		String lessor_code = Excel_data.get("lessor_code");
		String lessee_code = Excel_data.get("lessee_code");
		String contractage = Excel_data.get("contractage");
		String contract_category = Excel_data.get("contract_category");
		String eff_date = Excel_data.get("eff_date");
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
		String sizevalue = Excel_data.get("sizevalue");
		String leasevalue = Excel_data.get("leasevalue");
		String PerDiem_Value = Excel_data.get("PerDiem_Value");
		String buildup_perdiem_input = Excel_data.get("buildup_perdiem_input");
		String DPPbasis_input = Excel_data.get("DPPbasis_input");
		String DPPlumpsum_input = Excel_data.get("DPPlumpsum_input");
		String freedays_input = Excel_data.get("freedays_input");
		String builddown_perdiem_input = Excel_data.get("builddown_perdiem_input");
		String DPPwaiver_input = Excel_data.get("DPPwaiver_input");
		String amount = Excel_data.get("amount");
		String splperdiem_input = Excel_data.get("splperdiem_input");
		String monthlyamount_input = Excel_data.get("monthlyamount_input");
		String pickup_quantity_input = Excel_data.get("pickup_quantity_input");
		String rep_input = Excel_data.get("rep_input");
		String DPP_input = Excel_data.get("DPP_input");
		String combinevol_input = Excel_data.get("combinevol_input");
		String com_vol = Excel_data.get("com_vol");
		String pretrip_ins_charge_input = Excel_data.get("pretrip_ins_charge_input");
		String posttrip_ins_charge_input = Excel_data.get("posttrip_ins_charge_input");
		String extent_cover_input = Excel_data.get("extent_cover_input");
		String post_builddown_perdiem_input = Excel_data.get("post_builddown_perdiem_input");
		String tc_sizevalue = Excel_data.get("tc_sizevalue");
		String locationhier_value = Excel_data.get("locationhier_value");
		String location_value1 = Excel_data.get("location_value1");
		String date_Picker = Excel_data.get("date_Picker");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String conditionFilter = Excel_data.get("conditionFilter");
		String Ports_Code_Search = Excel_data.get("Ports_Code_Search");
		String lessee_code_Search = Excel_data.get("lessee_code_Search");
		String Lessor_code_search = Excel_data.get("Lessor_code_search");
		String Lease_Code_search = Excel_data.get("Lease_Code_search");



		

		
		String contype_Opt =  String.format(DropDown_Select,  ContractType); 
		String con_Cat =  String.format(con_cat,  contract_category); 
		String unit_Teu =  String.format(DropDown_Select,  unitteu_input); 
		String currency_Value =  String.format(currency_value,  currency_input); 
		String diallow__Value =  String.format(diallow_value,  diallow_input); 
		String sizevalue_Option =  String.format(sizevalue_option,  sizevalue); 
		String lease_Option =  String.format(lease_option,  leasevalue); 
		String DPPbasis_Value =  String.format(DPPbasis_value,  DPPbasis_input);
		String DPPlumpsum_Value =  String.format(DPPlumpsum_value,  DPPlumpsum_input);
		String DPPwaiver_Value =  String.format(DPPwaiver_value,  DPPwaiver_input);
		String combinevol_Value =  String.format(combinevol_value,  combinevol_input);
		String locationhier_Field =  String.format(locationhier_field,  locationhier_value);
		String sizevalue_Field =  String.format(sizevalue_field,  tc_sizevalue);
	

		Extent_Start(testcase_Name, test, test1);
		
	
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
		
		
		moduleNavigate(driver, Search_input);


		waitForElement(driver, SaveButton_ToolBar);

		Step_Start(1, "Ensure system should allow user to enter contract no & contract type", test, test1);

		waitForElement(driver, Econtractno_field);
		safeclick(driver, Econtractno_field);
		sendKeys(driver, Econtractno_field, contract_no);
		waitForElement(driver, Econtracttype_field);

		waitForElement(driver, Econtracttype_field);
		safeclick(driver, Econtracttype_field);

			waitForDisplay(driver, contract_types);
		if (!isdisplayed(driver, contract_types)) {
			safeclick(driver, Econtracttype_field);
		}
		waitForElement(driver, contype_Opt);
		safeclick(driver, contype_Opt);

		//String Dropdownoption = null;

		waitForElement(driver, Dropdown);
		String Dropdown_option = getText(driver, Dropdown);
		System.out.println("Dropdown_option: "+Dropdown_option);
		
		
		if (Dropdown_option.equals(ContractType)) {
			System.out.println(
					"Matched || Expected Result is :Once User select the Contract Type ,it should be changed as  : " + ContractType + " || Actual Result is :Once User select the Contract Type ,it is changed as  : " + Dropdown_option);
			Extent_pass_New(driver,

					"Matched || Expected Result is :Once User select the Contract Type ,it should be changed as  : " + ContractType + " || Actual Result is :Once User select the Contract Type ,it is changed as  : " + Dropdown_option,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Result is :Once User select the Contract Type ,it should be changed as  : " + ContractType + " || Actual Result is :Once User select the Contract Type ,it is not changed as  : " + Dropdown_option);
			Extent_fail(driver,

					"Not Matched || Expected Result is :Once User select the Contract Type ,it should be changed as  : " + ContractType + " || Actual Result is :Once User select the Contract Type ,it is not changed as  : " + Dropdown_option,
					test, test1);
		}
		

		

		Step_End(1, "Ensure system should allow user to enter contract no & contract type", test, test1);

		Step_Start(2, "Ensure that should allow user to select Lessor & Lessor from that field", test, test1);

		waitForElement(driver, Eleasekind_searchicon);
		safeclick(driver, Eleasekind_searchicon);
		
		twoColumnSearchWindow(driver, Lease_Code_search, conditionFilter, leasekind);

		Step_End(2, "Ensure that should allow user to select Lessor & Lessor from that field", test, test1);

		waitForElement(driver, Elessorcode_searchicon);
		safeclick(driver, Elessorcode_searchicon);
		
		twoColumnSearchWindow(driver, Lessor_code_search, conditionFilter, lessor_code);



		waitForElement(driver, Elessee_searchicon);
		safeclick(driver, Elessee_searchicon);
		twoColumnSearchWindow(driver, lessee_code_Search, conditionFilter, lessee_code);


		Step_Start(3, " Ensure that system should allow user to select valid From & To Period", test, test1);

		waitForElement(driver, Evaild_from);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_from, from_date);
		} else {
			waitForElement(driver, Evaild_from);
			clearAndType(driver, Evaild_from, from_date);
		}
		// Selecting the to Date
		waitForElement(driver, Evaild_to);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_to, to_date);
		} else {
			waitForElement(driver, Evaild_to);
			clearAndType(driver, Evaild_to, to_date);
		}
		

		Step_End(3, " Ensure that system should allow user to select valid From & To Period", test, test1);
		// ************Registration non-mandatory fields*************

		if (!contractage.equals("")) {
			waitForElement(driver, contract_age);
			sendKeys(driver, contract_age, contractage);

		} else {
			System.out.println("contractage " + "Input Not Available in test data");
		}

		if (!contract_category.equals("")) {
			waitForElement(driver, contractcate);
			safeclick(driver, contractcate);
			waitForElement(driver, con_Cat);
			safeclick(driver, con_Cat);

		} else {
			System.out.println("contract_category " + "Input Not Available in test data");
		}

		if (!eff_date.equals("")) {
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
			sendKeys(driver, remarks, remarkstext);

		} else {
			System.out.println("remarkstext " + "Input Not Available in test data");
		}

		if (!lessorref_input.equals("")) {
			waitForElement(driver, lessor_ref);
			sendKeys(driver, lessor_ref, lessorref_input);

		} else {
			System.out.println("lessorref_input " + "Input Not Available in test data");
		}

		if (!validprefix_input.equals("")) {
			waitForElement(driver, valid_prefix_addicon);
			safeclick(driver, valid_prefix_addicon);
			waitForElement(driver, valid_prefix_Select);
			sendKeys(driver, valid_prefix_Select, validprefix_input);
			waitForElement(driver, valid_prefix_select);
			safeclick(driver, valid_prefix_select);

		} else {
			System.out.println("validprefix_input " + "Input Not Available in test data");
		}

		checkBox(driver, oneway, oneway_checkbox);
		waitForElement(driver, purchase);
		checkBox(driver, purchase, purchase_checkbox);

		if (!unitteu_input.equals("")) {
			waitForElement(driver, dropoff);
			checkBox(driver, dropoff, dropoff_checkbox);
			waitForElement(driver, unit_teu);
			safeclick(driver, unit_teu);
			waitForElement(driver, unit_Teu);
			safeclick(driver, unit_Teu);
			waitForElement(driver, offhire);
			sendKeys(driver, offhire, offhire_input);

		} else {
			System.out.println("unitteu_input " + "Input Not Available in test data");
		}

		if (!currency_input.equals("")) {
			waitForElement(driver, currency1);
			safeclick(driver, currency1);
			waitForElement(driver, currency_Value);
			safeclick(driver, currency_Value);

		} else {
			System.out.println("currency_input " + "Input Not Available in test data");
		}

		if (diallow_input.equals("Yes")) {
			waitForElement(driver, di_allow);
			safeclick(driver, di_allow);
			waitForElement(driver, diallow_value);
			safeclick(driver, diallow_value);
			waitForElement(driver, difee);
			clear(driver, difee);
			sendKeys(driver, difee, difee_input);

		} else {
			System.out.println("diallow_input " + "Input Not Available in test data");
		}

		if (!billpay_input.equals("")) {
			waitForElement(driver, bill_paytype);
			safeclick(driver, bill_paytype);
			waitForElement(driver, diallow__Value);
			safeclick(driver, diallow__Value);

		} else {
			System.out.println("billpay_input " + "Input Not Available in test data");
		}

		if (!buildup_input.equals("")) {
			waitForElement(driver, buildup_period);
			sendKeys(driver, buildup_period, buildup_input);

		} else {
			System.out.println("buildup_input " + "Input Not Available in test data");
		}

		if (!builddown_input.equals("")) {
			waitForElement(driver, builddown_period);
			sendKeys(driver, builddown_period, builddown_input);

		} else {
			System.out.println("builddown_input " + "Input Not Available in test data");
		}

		if (!minperiod_input.equals("")) {
			waitForElement(driver, min_period);
			sendKeys(driver, min_period, minperiod_input);

		} else {
			System.out.println("minperiod_input " + "Input Not Available in test data");
		}

		Step_Start(4, "Ensure that system should able to select size type tab", test, test1);

		// *********************SIZETYPE TAB*************************

		waitForElement(driver, Esizeandtype_tab);
		safeclick(driver, Esizeandtype_tab);

		Step_End(4, "Ensure that system should able to select size type tab", test, test1);

		waitForElement(driver, Esizeandtype_Field);
		safeclick(driver, Esizeandtype_Field);
		waitForElement(driver, sizevalue_Option);
		safeclick(driver, sizevalue_Option);




		waitForElement(driver, sizetypeDropdownoption);
		String sizetypeDropdown_option = getText(driver, sizetypeDropdownoption);
		System.out.println("sizetypeDropdown_option: "+sizetypeDropdown_option);

		if (sizetypeDropdown_option.equals(sizevalue)) {
			System.out.println(
					"Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue + " || Actual Result is :Once User select the size Type ,it is changed as  : " + sizetypeDropdown_option);
			Extent_pass_New(driver,

					"Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue + " || Actual Result is :Once User select the size Type ,it is changed as  : " + sizetypeDropdown_option,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue + " || Actual Result is :Once User select the size Type ,it is not changed as  : " + sizetypeDropdown_option);
			Extent_fail(driver, 
					"Not Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue + " || Actual Result is :Once User select the size Type ,it is not changed as  : " + sizetypeDropdown_option, test, test1);
		}
		Step_Start(5, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);

		waitForElement(driver, Eleasechargetype_Field);
		safeclick(driver, Eleasechargetype_Field);
		waitForElement(driver, lease_Option);
		safeclick(driver, lease_Option);

		waitForElement(driver, leasetypeDropdownoption);
		String leasetypeDropdown_option = getText(driver, leasetypeDropdownoption);
		System.out.println("leasetypeDropdown_option: "+leasetypeDropdown_option);

		if (leasetypeDropdown_option.equals(leasevalue)) {
			System.out.println(
					"Matched || Expected Result is :Once User select the lease value ,it should be changed as  : " + leasevalue + " || Actual Result is :Once User select the lease value ,it is changed as  : " + leasetypeDropdown_option);
			Extent_pass_New(driver, 
					"Matched || Expected Result is :Once User select the lease value ,it should be changed as  : " + leasevalue + " || Actual Result is :Once User select the lease value ,it is changed as  : " + leasetypeDropdown_option, test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Result is :Once User select the lease value ,it should be changed as  : " + leasevalue + " || Actual Result is :Once User select the lease value ,it is not changed as  : " + leasetypeDropdown_option);
			Extent_fail(driver, 
					"Not Matched || Expected Result is :Once User select the lease value ,it should be changed as  : " + leasevalue + " || Actual Result is :Once User select the lease value ,it is not changed as  : " + leasetypeDropdown_option, test, test1);
		}

		Step_End(5, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);


		Step_Start(6, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed", test, test1);
		waitForElement(driver, Eperdiem_field);
		clear(driver, Eperdiem_field);
		sendKeys(driver, Eperdiem_field, PerDiem_Value);

		// ************sizetype non-mandatory fields*************
		// disabled
		if (!buildup_perdiem_input.equals("")) {
			waitForElement(driver, buildup_perdiem);
			sendKeys(driver, buildup_perdiem, buildup_perdiem_input);

		} else {
			System.out.println("buildup_perdiem_input " + "Input Not Available in test data");
		}

		if (!DPPbasis_input.equals("")) {
			waitForElement(driver, DPP_basis);
			safeclick(driver, DPP_basis);
			waitForElement(driver, DPPbasis_Value);
			safeclick(driver, DPPbasis_Value);
			waitForElement(driver, DPP_lumpsum);
			safeclick(driver, DPP_lumpsum);
			waitForElement(driver, DPPlumpsum_Value);
			safeclick(driver, DPPlumpsum_Value);

		} else {
			System.out.println("DPPbasis_input " + "Input Not Available in test data");
		}

		if (!freedays_input.equals("")) {
			waitForElement(driver, freedays);
			sendKeys(driver, freedays, freedays_input);

		} else {
			System.out.println("freedays_input " + "Input Not Available in test data");
		}
		// disabled
		if (!builddown_perdiem_input.equals("")) {
			waitForElement(driver, builddown_perdiem);
			sendKeys(driver, builddown_perdiem, builddown_perdiem_input);

		} else {
			System.out.println("builddown_perdiem_input " + "Input Not Available in test data");
		}

		if (!DPPwaiver_input.equals("")) {
			waitForElement(driver, DPP_waiver);
			safeclick(driver, DPP_waiver);
			waitForElement(driver, DPPwaiver_Value);
			safeclick(driver, DPPwaiver_Value);
			waitForElement(driver, DPP_amount);
			sendKeys(driver, DPP_amount, amount);

		} else {
			System.out.println("DPPwaiver_input " + "Input Not Available in test data");
		}

		if (!splperdiem_input.equals("")) {
			waitForElement(driver, spl_perdiem);
			clear(driver, spl_perdiem);
			sendKeys(driver, spl_perdiem, splperdiem_input);

		} else {
			System.out.println("splperdiem_input " + "Input Not Available in test data");
		}

		// disabled
		if (!monthlyamount_input.equals("")) {
			waitForElement(driver, monthly_amount);
			clear(driver, monthly_amount);
			sendKeys(driver, monthly_amount, monthlyamount_input);

		} else {
			System.out.println("monthlyamount_input " + "Input Not Available in test data");
		}

		if (!pickup_quantity_input.equals("")) {
			waitForElement(driver, pickup_quantity);
			sendKeys(driver, pickup_quantity, pickup_quantity_input);

		} else {
			System.out.println("pickup_quantity_input " + "Input Not Available in test data");
		}

		if (!rep_input.equals("")) {
			waitForElement(driver, rep_value);
			clear(driver, rep_value);
			sendKeys(driver, rep_value, rep_input);

		} else {
			System.out.println("rep_input " + "Input Not Available in test data");
		}

		if (!DPP_input.equals("")) {
			waitForElement(driver, DPP);
			sendKeys(driver, DPP, DPP_input);

		} else {
			System.out.println("DPP_input " + "Input Not Available in test data");
		}

		// volume based banding
		if (!combinevol_input.equals("")) {
			waitForElement(driver, combine_vol);
			safeclick(driver, combine_vol);
			waitForElement(driver, combinevol_Value);
			safeclick(driver, combinevol_Value);
			waitForElement(driver, combinevolbtn);
			safeclick(driver, combinevolbtn);
			waitForElement(driver, combinevol_addbtn);
			safeclick(driver, combinevol_addbtn);
			waitForElement(driver, search_field_EMS);
			sendKeys(driver, search_field_EMS, com_vol);
			waitForElement(driver, combinevol_selbtn);
			safeclick(driver, combinevol_selbtn);
			waitForElement(driver, combinevol_okbtn);
			safeclick(driver, combinevol_okbtn);

		} else {
			System.out.println("combinevol_input " + "Input Not Available in test data");
		}

		if (isClickable(driver, add_tierbtn)) {
			System.out.println("add tier button is enabled");

			if (!pretrip_ins_charge_input.equals("")) {
				waitForElement(driver, pretrip_ins_charge);
				sendKeys(driver, pretrip_ins_charge, pretrip_ins_charge_input);

			} else {
				System.out.println("pretrip_ins_charge_input " + "Input Not Available in test data");
			}

			if (!posttrip_ins_charge_input.equals("")) {
				waitForElement(driver, posttrip_ins_charge);
				sendKeys(driver, posttrip_ins_charge, posttrip_ins_charge_input);

			} else {
				System.out.println("posttrip_ins_charge_input " + "Input Not Available in test data");
			}

			if (!extent_cover_input.equals("")) {
				waitForElement(driver, extent_cover);
				sendKeys(driver, extent_cover, extent_cover_input);

			} else {
				System.out.println("extent_cover_input " + "Input Not Available in test data");
			}

			if (!post_builddown_perdiem_input.equals("")) {
				waitForElement(driver, post_builddown_perdiem);
				sendKeys(driver, post_builddown_perdiem, post_builddown_perdiem_input);

			} else {
				System.out.println("post_builddown_perdiem_input " + "Input Not Available in test data");
			}

			waitForElement(driver, add_tierbtn);
			safeclick(driver, add_tierbtn);
		}
		waitForElement(driver, Esizeaddbutton);
		safeclick(driver, Esizeaddbutton);

		Step_End(6, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed", test, test1);


		// ***************termcharges mandatory************************

		Step_Start(7, "Ensure that system should able to select Terms & Charges tab", test, test1);


		waitForElement(driver, Etermandcharges);
		safeclick(driver, Etermandcharges);

		Step_End(7, "Ensure that system should able to select Terms & Charges tab", test, test1);

		Step_Start(8, "Ensure that system should allow user to select location hierarchy & enter location", test, test1);

		waitForElement(driver, ELocationhierarchy_field);
		safeclick(driver, ELocationhierarchy_field);
		waitForElement(driver, locationhier_Field);
		safeclick(driver, locationhier_Field);



		waitForElement(driver, Elocationaddbutton);
		safeclick(driver,Elocationaddbutton);
		twoColumnSearchWindow(driver, Ports_Code_Search, conditionFilter, location_value1);
		
		


		Step_End(8, "Ensure that system should allow user to select location hierarchy & enter location", test, test1);

		Step_Start(9, "Ensure that system should list the size/type only which is defined in size/type tab", test, test1);

		waitForElement(driver, Etermchange_size);
		safeclick(driver, Etermchange_size);
		waitForElement(driver, sizevalue_Field);
		safeclick(driver, sizevalue_Field);


		waitForElement(driver, termsizetypeDropdownoption);
		String termsizetypeDropdown_option = getText(driver, termsizetypeDropdownoption);
		System.out.println("termsizetypeDropdown_option: "+termsizetypeDropdown_option);

		if (termsizetypeDropdown_option.equals(tc_sizevalue)) {
			System.out.println("Matched || Expected value was : " + tc_sizevalue + " || Actual value was : "
					+ termsizetypeDropdown_option);
			System.out.println("system list the size/type only which is defined in size/type tab");
			Extent_pass_New(driver, "Matched || Expected value was : " + tc_sizevalue + " || Actual value was : "
					+ termsizetypeDropdown_option, test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + tc_sizevalue + " || Actual value was : "
					+ termsizetypeDropdown_option);
			System.out.println("system not list the size/type only which is defined in size/type tab");
			Extent_fail(driver, "NotMatched || Expected value was : " + tc_sizevalue + " || Actual value was : "
					+ termsizetypeDropdown_option, test, test1);
		}

		Step_End(9, "Ensure that system should list the size/type only which is defined in size/type tab", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}

}
