package LRP_EMS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Ems_Contract_Registration_Locators;

public class TC_EMS_Contract_Registration_TS001_to_TS005_C extends Keywords {
	public void ems_Contract_Registration_TS001_to_TS005_C (WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)throws Exception {
		
		
		
		int T1=1;
				if(T1==1) {
					String tc_Name="TC_EMS_Contract_Registration_TS001";
					String URL = TestNgXml.getdatafromExecution().get(tc_Name);
					String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
					String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
					Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
					
					String Username = Excel_data.get("Username");
					String Password = Excel_data.get("Password");
					String Search_input = Excel_data.get("Search_input");
					String contract_no1 = Excel_data.get("contract_no1");
					String ContractType = Excel_data.get("ContractType");
					String leasekind = Excel_data.get("leasekind");
					String lessor_code = Excel_data.get("lessor_code");
					String lessee_code = Excel_data.get("lessee_code");
					String sizevalue = Excel_data.get("sizevalue");
					String leasevalue = Excel_data.get("leasevalue");
					String PerDiem_Value = Excel_data.get("PerDiem_Value");
					String locationhier_value = Excel_data.get("locationhier_value");
					String location_value = Excel_data.get("location_value");
					String depreciation_type = Excel_data.get("depreciation_type");
					String popupmsg = Excel_data.get("popupmsg");
					String contract_category = Excel_data.get("contract_category");
					String service_input = Excel_data.get("service_input");
					String contractage = Excel_data.get("contractage");
					String trade_input = Excel_data.get("trade_input");
					String eff_date = Excel_data.get("eff_date");
					String remarkstext = Excel_data.get("remarkstext");
					String lessorref_input = Excel_data.get("lessorref_input");
					String validprefix_input = Excel_data.get("validprefix_input");
					String oneway_checkbox = Excel_data.get("oneway_checkbox");
					String purchase_checkbox = Excel_data.get("purchase_checkbox");
					String dropoff_checkbox = Excel_data.get("dropoff_checkbox");
					String unitteu_input = Excel_data.get("unitteu_input");
					String offhire_input = Excel_data.get("offhire_input");
					String currency_input = Excel_data.get("currency_input");
					String diallow_input = Excel_data.get("diallow_input");
					String billpay_input = Excel_data.get("billpay_input");
					String buildup_input = Excel_data.get("buildup_input");
					String builddown_input = Excel_data.get("builddown_input");
					String minperiod_input = Excel_data.get("minperiod_input");
					String difee_input = Excel_data.get("difee_input");
					String buildup_perdiem_input = Excel_data.get("buildup_perdiem_input");
					String DPPbasis_input = Excel_data.get("DPPbasis_input");
					String DPPlumpsum_input = Excel_data.get("DPPlumpsum_input");
					String freedays_input = Excel_data.get("freedays_input");
					String builddown_perdiem_input = Excel_data.get("builddown_perdiem_input");
					String amount = Excel_data.get("amount");
					String DPPwaiver_input = Excel_data.get("DPPwaiver_input");
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
					String tcpickup_input = Excel_data.get("tcpickup_input");
					String tc_pickuphandling_input = Excel_data.get("tc_pickuphandling_input");
					String tc_dropoffcredit_input = Excel_data.get("tc_dropoffcredit_input");
					String tc_dropoffmonth_input = Excel_data.get("tc_dropoffmonth_input");
					String tc_pickupcharges_input = Excel_data.get("tc_pickupcharges_input");
					String tc_dropoff_input = Excel_data.get("tc_dropoff_input");
					String tc_dropoffhandling_input = Excel_data.get("tc_dropoffhandling_input");
					String tc_pickupcredit_input = Excel_data.get("tc_pickupcredit_input");
					String tc_dropoffcharges_input = Excel_data.get("tc_dropoffcharges_input");
					String penalty_label = Excel_data.get("penalty_label");
					String tc_penalty_input = Excel_data.get("tc_penalty_input");
					String dropoffcharges_radio = Excel_data.get("dropoffcharges_radio");
					String condtdropoff_radio = Excel_data.get("condtdropoff_radio");
					String depkind_input = Excel_data.get("depkind_input");
					String deprate_input = Excel_data.get("deprate_input");
					String dep_percent_input = Excel_data.get("dep_percent_input");
					String tc_depmin_input = Excel_data.get("tc_depmin_input");
					String tc_depax_input = Excel_data.get("tc_depax_input");
					String depmin_checkbox = Excel_data.get("depmin_checkbox");
					String dep_mincheckbox_fieldvalue = Excel_data.get("dep_mincheckbox_fieldvalue");
					String date_Picker = Excel_data.get("date_Picker");
					String from_date = Excel_data.get("from_date");
					String to_date = Excel_data.get("to_date");
					String Condition = Excel_data.get("Condition");
					String lease_code_header = Excel_data.get("lease_code_header");
					String lessor_code_header = Excel_data.get("lessor_code_header");
					String lesee_code_header = Excel_data.get("lesee_code_header");
					String service_code_header = Excel_data.get("service_code_header");
					String trade_code_header = Excel_data.get("trade_code_header");
					String valid_prefix_header = Excel_data.get("valid_prefix_header");
					String ports_code_header = Excel_data.get("ports_code_header");
					String Want_To_Delete = Excel_data.get("Want_To_Delete");
					String Search_type = Excel_data.get("Search_type");	
					String search_by_con_num = Excel_data.get("search_by_con_num");
					
					String contype_opt =String.format(DropDown_Select, ContractType);
					String con_cat =String.format(Ems_Contract_Registration_Locators.con_cat, contract_category);
					String unitteu =String.format(DropDown_Select, unitteu_input);
					String currency_value =String.format(Ems_Contract_Registration_Locators.currency_value, currency_input);
					String diallow_value =String.format(Ems_Contract_Registration_Locators.diallow_value, diallow_input);
					String billpay_value =String.format(Ems_Contract_Registration_Locators.billpay_value, billpay_input);
					String sizevalue_option=String.format(Ems_Contract_Registration_Locators.sizevalue_option, sizevalue);
					String lease_option=String.format(Ems_Contract_Registration_Locators.lease_option, leasevalue);
					String DPPbasis_value =String.format(Ems_Contract_Registration_Locators.DPPbasis_value, DPPbasis_input);
					String DPPlumpsum_value = String.format(Ems_Contract_Registration_Locators.DPPlumpsum_value, DPPlumpsum_input);
					String DPPwaiver_value =String.format(Ems_Contract_Registration_Locators.DPPwaiver_value, DPPwaiver_input);
					String combinevol_value =String.format(Ems_Contract_Registration_Locators.combinevol_value, combinevol_input);
					String locationhier_field =String.format(Ems_Contract_Registration_Locators.locationhier_field, locationhier_value);
					String sizevalue_field =String.format(Ems_Contract_Registration_Locators.sizevalue_field, tc_sizevalue);
					String penalty =String.format(Ems_Contract_Registration_Locators.penalty, penalty_label);
					String depkind =String.format(Ems_Contract_Registration_Locators.depkind, depkind_input);
					String depreciation_option=String.format(Ems_Contract_Registration_Locators.depreciation_option, depreciation_type);
					String depercent = String.format(Ems_Contract_Registration_Locators.depercent, dep_percent_input);


				Extent_Start(tc_Name, test, test1);
				
				Step_Start(1, "open chrome browser ", test, test1);
				Step_Start(2, "Enter the url", test, test1);
					navigateUrl(driver, URL);
					Step_End(2, "Enter the url", test, test1);
					Step_End(1, "open chrome browser ", test, test1);

					LRP_Login(driver, Username, Password);

					Step_Start(6, "click on search field", test, test1);
					Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
					moduleNavigate(driver, Search_input);

					Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
					Step_End(6, "click on search field", test, test1);

					Step_Start(8, "Enter Alphanumeric character in Contract No field for Registration tab", test, test1);
					waitForElement(driver, SaveButton_ToolBar);
					waitForElement(driver, Econtractno_field);
					click(driver, Econtractno_field);
					sendKeys(driver, Econtractno_field, contract_no1);
					
					Step_End(8, "Enter Alphanumeric character in Contract No field for Registration tab", test, test1);

					Step_Start(9, "Click on 'Contract Type' Drop menu & select anyone accordingly for Registration tab", test, test1);
					waitForElement(driver, Econtracttype_field);
					click(driver, Econtracttype_field);
					waitForDisplay(driver, contract_types);
					if (!isDisplayed(driver, contract_types)) {
						click(driver, Econtracttype_field);
					}
					
						waitForElement(driver, contype_opt);
						safeclick(driver, contype_opt);
						Step_End(9, "Click on 'Contract Type' Drop menu & select anyone accordingly for Registration tab", test, test1);

						
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
					
					Step_Start(10, "Click on search icon for Lease Kind list & select anyone accordingly for Registration tab", test, test1);
					
					waitForElement(driver, Eleasekind_searchicon);
					safeclick(driver, Eleasekind_searchicon);
					twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);
					

					Step_End(10, "Click on search icon for Lease Kind list & select anyone accordingly for Registration tab", test, test1);

					Step_Start(11, "Click on search icon for 'Lessor' list & select anyone accordingly for Registration tab", test, test1);
					
					waitForElement(driver, Elessorcode_searchicon);
					safeclick(driver, Elessorcode_searchicon);
					twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);

					
					Step_End(11, "Click on search icon for 'Lessor' list & select anyone accordingly for Registration tab", test, test1);

					Step_Start(12, "Click on search icon for 'Lessee' list & select anyone accordingly for Registration tab", test, test1);
					
					waitForElement(driver, Elessee_searchicon);
					safeclick(driver, Elessee_searchicon);
					twoColumnSearchWindow(driver, lesee_code_header, Condition, lessee_code);

					
					Step_End(12, "Click on search icon for 'Lessee' list & select anyone accordingly for Registration tab", test, test1);

					Step_Start(13, "Select From Date range accordingly in date picker for Registration tab", test, test1);
					
					waitForElement(driver, Evaild_from);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						
						selectDatePicker(driver, Evaild_from, from_date);
						
					} else {
						waitForElement(driver, Evaild_from);
						clearAndType(driver, Evaild_from, from_date);
					}
					Step_End(13, "Select From Date range accordingly in date picker for Registration tab", test, test1);

					Step_Start(14, "Select To Date range accordingly in date picker for Registration tab", test, test1);
					
					waitForElement(driver, Evaild_to);
					if (date_Picker.equalsIgnoreCase("Yes")) {
						
						selectDatePicker(driver, Evaild_to, to_date);
						
					} else {
						waitForElement(driver, Evaild_to);
						clearAndType(driver, Evaild_to, to_date);
					}
					Step_End(14, "Select To Date range accordingly in date picker for Registration tab", test, test1);


					// **************Registration non-mandatory fields***************

					if (!contractage.equals("")) {
						waitForElement(driver, contract_age);
						sendKeys(driver, contract_age, contractage);

					} else {
						System.out.println("contractage " + "Input Not Available in test data");
					}

					if (!contract_category.equals("")) {
						waitForElement(driver, contractcate);
						click(driver, contractcate);
							waitForElement(driver, con_cat);
							click(driver, con_cat);
						
					} else {
						System.out.println("contract_category " + "Input Not Available in test data");
					}

					if (!service_input.equals("")) {
						waitForElement(driver, service_searchicon);
						click(driver, service_searchicon);
						twoColumnSearchWindow(driver, service_code_header, Condition, service_input);

						
					} else {
						System.out.println("service_input36 " + "Input Not Available in test data");
					}

					if (!trade_input.equals("")) {
						waitForElement(driver, trade_searchicon);
						click(driver, trade_searchicon);
						twoColumnSearchWindow(driver, trade_code_header, Condition, trade_input);


					} else {
						System.out.println("trade_input " + "Input Not Available in test data");
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
						click(driver, valid_prefix_addicon);
						twoColumnSearchWindow(driver, valid_prefix_header, Condition, validprefix_input);

					} else {
						System.out.println("validprefix_input " + "Input Not Available in test data");
					}
					waitForElement(driver, oneway);
					checkBox(driver, oneway, oneway_checkbox);
					waitForElement(driver, purchase);
					checkBox(driver, purchase, purchase_checkbox);

					if (!unitteu_input.equals("")) {
						waitForElement(driver, dropoff);
						checkBox(driver, dropoff, dropoff_checkbox);
							waitForElement(driver, unit_teu);
							click(driver, unit_teu);
							waitForElement(driver, unitteu);
							click(driver, unitteu);
							waitForElement(driver, offhire);
							sendKeys(driver, offhire, offhire_input);
						
					} else {
						System.out.println("unitteu_input " + "Input Not Available in test data");
					}

					if (!currency_input.equals("")) {
						waitForElement(driver, currency1);
						click(driver, currency1);
							waitForElement(driver, currency_value);
							click(driver, currency_value);
						
					} else {
						System.out.println("currency_input " + "Input Not Available in test data");
					}

					if (diallow_input.equals("Yes")) {
						waitForElement(driver, di_allow);
						click(driver, di_allow);
							waitForElement(driver, diallow_value);
							click(driver, diallow_value);
							waitForElement(driver, difee);
							clear(driver, difee);
							sendKeys(driver, difee, difee_input);
						
					} else {
						System.out.println("diallow_input " + "Input Not Available in test data");
					}

					if (!billpay_input.equals("")) {
						waitForElement(driver, bill_paytype);
						click(driver, bill_paytype);
							waitForElement(driver, billpay_value);
							click(driver, billpay_value);
						
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

					// ***********************SIZETYPE TAB***************************
					Step_Start(15, "Click on Size/Type tab once all mandatory field entered in Registration tab", test, test1);
					waitForElement(driver, Esizeandtype_tab);
					safeclick(driver, Esizeandtype_tab);
					Step_End(15, "Click on Size/Type tab once all mandatory field entered in Registration tab", test, test1);

					Step_Start(16, ".Click on Size/Type Drop menu & select any size type accordingly for size/type tab", test, test1);
					waitForElement(driver, Esizeandtype_Field);
					safeclick(driver, Esizeandtype_Field);
						waitForElement(driver, sizevalue_option);
						click(driver, sizevalue_option);
						Step_End(16, ".Click on Size/Type Drop menu & select any size type accordingly for size/type tab", test, test1);


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
					Step_Start(17, "Click on Lease Charge Type Drop menu and select 'No Banding' option accordingly for size/type tab", test, test1);
					waitForElement(driver, Eleasechargetype_Field);
					safeclick(driver, Eleasechargetype_Field);
						waitForElement(driver, lease_option);
						safeclick(driver, lease_option);
						Step_End(17, "Click on Lease Charge Type Drop menu and select 'No Banding' option accordingly for size/type tab", test, test1);

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

					waitForElement(driver, Eperdiem_field);
					clear(driver, Eperdiem_field);
					sendKeys(driver, Eperdiem_field, PerDiem_Value);

					// **************sizetype non-mandatory fields***************
					// disabled
					if (!buildup_perdiem_input.equals("")) {
						waitForElement(driver, buildup_perdiem);
						sendKeys(driver, buildup_perdiem, buildup_perdiem_input);

					} else {
						System.out.println("buildup_perdiem_input " + "Input Not Available in test data");
					}

					if (!DPPbasis_input.equals("")) {
						waitForElement(driver, DPP_basis);
						click(driver, DPP_basis);
							waitForElement(driver, DPPbasis_value);
							click(driver, DPPbasis_value);
							waitForElement(driver, DPP_lumpsum);
							click(driver, DPP_lumpsum);
							waitForElement(driver, DPPlumpsum_value);
							click(driver, DPPlumpsum_value);
						
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
						click(driver, DPP_waiver);
							waitForElement(driver, DPPwaiver_value);
							safeclick(driver, DPPwaiver_value);
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
						click(driver, combine_vol);
							waitForElement(driver, combinevol_value);
							click(driver, combinevol_value);
							waitForElement(driver, combinevolbtn);
							click(driver, combinevolbtn);
							waitForElement(driver, combinevol_addbtn);
							click(driver, combinevol_addbtn);
							waitForElement(driver, search_field_EMS);
							sendKeys(driver, search_field_EMS, com_vol);
							waitForElement(driver, combinevol_selbtn);
							click(driver, combinevol_selbtn);
							waitForElement(driver, combinevol_okbtn);
							click(driver, combinevol_okbtn);
					
					} else {
						System.out.println("combinevol_input " + "Input Not Available in test data");
					}

					waitForElement(driver, add_tierbtn);
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
						click(driver, add_tierbtn);
					}
					Step_Start(18, "Click on Add button once all mandatory field is entered for size/type tab", test, test1);
					waitForElement(driver, Esizeaddbutton);
					click(driver, Esizeaddbutton);
					Step_End(18, "Click on Add button once all mandatory field is entered for size/type tab", test, test1);

					// ****************termcharges mandatory*************************
					Step_Start(19, "Click on Terms and Charge tab once all mandatory field entered in Size/Type", test, test1);
					waitForElement(driver, Etermandcharges);
					safeclick(driver, Etermandcharges);
					Step_End(19, "Click on Terms and Charge tab once all mandatory field entered in Size/Type", test, test1);

					Step_Start(20, "Click on Location Hierarchy Drop menu & select 'All Region' option accordingly for Terms and Charges", test, test1);
					waitForElement(driver, ELocationhierarchy_field);
					click(driver, ELocationhierarchy_field);
						waitForElement(driver, locationhier_field);
						click(driver, locationhier_field);
						Step_End(20, "Click on Location Hierarchy Drop menu & select 'All Region' option accordingly for Terms and Charges", test, test1);

					waitForElement(driver, locationDropdownoption);
					String locationDropdown_option = getText(driver, locationDropdownoption);
					System.out.println("locationDropdown_option: "+locationDropdown_option);

					if (locationDropdown_option.equals(locationhier_value)) {
						System.out.println(
								"Matched || Expected Result is :Once User select the location value ,it should be changed as  : " + locationhier_value + " || Actual Result is :Once User select the location value ,it is changed as  : " + locationDropdown_option);
						Extent_pass_New(driver, 
								"Matched || Expected Result is :Once User select the location value ,it should be changed as  : " + locationhier_value + " || Actual Result is :Once User select the location value ,it is changed as  : " + locationDropdown_option, test, test1);
					} else {
						System.out.println(
								"Not Matched || Expected Result is :Once User select the location value ,it should be changed as  : " + locationhier_value + " || Actual Result is :Once User select the location value ,it is not changed as  : " + locationDropdown_option);
						Extent_fail(driver, 
								"Not Matched || Expected Result is :Once User select the location value ,it should be changed as  : " + locationhier_value + " || Actual Result is :Once User select the location value ,it is not changed as  : " + locationDropdown_option, test, test1);
					}
					
					Step_Start(21, "Click on Add button for location list & select any location accordingly for Terms and Charges", test, test1);
					waitForElement(driver, Elocationaddbutton);
					safeclick(driver,Elocationaddbutton);	
					twoColumnSearchWindow(driver, ports_code_header, Condition, location_value);
					
					Step_End(21, "Click on Add button for location list & select any location accordingly for Terms and Charges", test, test1);

					Step_Start(22, "Click on Size/Type Drop menu & select any size type accordingly for Terms and Charges", test, test1);
					waitForElement(driver, Etermchange_size);
					click(driver, Etermchange_size);
						waitForElement(driver, sizevalue_field);
						click(driver, sizevalue_field);
						Step_End(22, "Click on Size/Type Drop menu & select any size type accordingly for Terms and Charges", test, test1);

					waitForElement(driver, termsizetypeDropdownoption);
					String termsizetypeDropdown_option = getText(driver, termsizetypeDropdownoption);
					System.out.println("termsizetypeDropdown_option: "+termsizetypeDropdown_option);

					if (termsizetypeDropdown_option.equals(tc_sizevalue)) {
						System.out.println(
								"Matched || Expected Result is :Once User select the size type value ,it should be changed as  : " + tc_sizevalue + " || Actual Result is :Once User select the size type value ,it is changed as  : " + termsizetypeDropdown_option);
						Extent_pass_New(driver, 
								"Matched || Expected Result is :Once User select the size type value ,it should be changed as  : " + tc_sizevalue + " || Actual Result is :Once User select the size type value ,it is changed as  : " + termsizetypeDropdown_option, test, test1);
					} else {
						System.out.println(
								"Not Matched || Expected Result is :Once User select the size type value ,it should be changed as  : " + tc_sizevalue + " || Actual Result is :Once User select the size type value ,it is not changed as  : " + termsizetypeDropdown_option);
						Extent_fail(driver, 
								"Not Matched || Expected Result is :Once User select the size type value ,it should be changed as  : " + tc_sizevalue + " || Actual Result is :Once User select the size type value ,it is changed as  : " + termsizetypeDropdown_option, test, test1);
					}

					// *********tc non-mandatory field

					if (!tcpickup_input.equals("")) {
						waitForElement(driver, tc_pickup);
						sendKeys(driver, tc_pickup, tcpickup_input);

					} else {
						System.out.println("tcpickup_input " + "Input Not Available in test data");
					}

					if (!tc_pickuphandling_input.equals("")) {
						waitForElement(driver, tc_pickup_handling);
						clear(driver, tc_pickup_handling);
						sendKeys(driver, tc_pickup_handling, tc_pickuphandling_input);

					} else {
						System.out.println("tc_pickuphandling_input " + "Input Not Available in test data");
					}

					if (!tc_dropoffcredit_input.equals("")) {
						waitForElement(driver, tc_dropoff_credit);
						clear(driver, tc_dropoff_credit);
						sendKeys(driver, tc_dropoff_credit, tc_dropoffcredit_input);

					} else {
						System.out.println("tc_dropoffcredit_input " + "Input Not Available in test data");
					}

					if (!tc_dropoffmonth_input.equals("")) {
						waitForElement(driver, tc_dropoff_month);
						sendKeys(driver, tc_dropoff_month, tc_dropoffmonth_input);

					} else {
						System.out.println("tc_dropoffmonth_input " + "Input Not Available in test data");
					}

					if (!tc_pickupcharges_input.equals("")) {
						waitForElement(driver, tc_pickupcharges);
						clear(driver, tc_pickupcharges);
						sendKeys(driver, tc_pickupcharges, tc_pickupcharges_input);

					} else {
						System.out.println("tc_pickupcharges_input " + "Input Not Available in test data");
					}

					if (!tc_dropoff_input.equals("")) {
						waitForElement(driver, tc_dropoff);
						sendKeys(driver, tc_dropoff, tc_dropoff_input);

					} else {
						System.out.println("tc_dropoff_input " + "Input Not Available in test data");
					}

					if (!tc_dropoffhandling_input.equals("")) {
						waitForElement(driver, tc_dropoff_handling);
						clear(driver, tc_dropoff_handling);
						sendKeys(driver, tc_dropoff_handling, tc_dropoffhandling_input);

					} else {
						System.out.println("tc_dropoffhandling_input " + "Input Not Available in test data");
					}

					if (!tc_pickupcredit_input.equals("")) {
						waitForElement(driver, tc_pickup_credit);
						clear(driver, tc_pickup_credit);
						sendKeys(driver, tc_pickup_credit, tc_pickupcredit_input);

					} else {
						System.out.println("tc_pickupcredit_input " + "Input Not Available in test data");
					}

					if (!tc_dropoffcharges_input.equals("")) {
						waitForElement(driver, tc_dropoffcharges);
						clear(driver, tc_dropoffcharges);
						sendKeys(driver, tc_dropoffcharges, tc_dropoffcharges_input);

					} else {
						System.out.println("tc_dropoffcharges_input " + "Input Not Available in test data");
					}

					if (!tc_penalty_input.equals("")) {
						waitForElement(driver, tc_penalty);
						click(driver, tc_penalty);
							waitForElement(driver, penalty);
							click(driver, penalty);
							waitForElement(driver, tc_penalty_value);
							sendKeys(driver, tc_penalty_value, tc_penalty_input);
						
					} else {
						System.out.println("tc_penalty_input " + "Input Not Available in test data");
					}
					waitForElement(driver, tc_dropoffcharges_radio);
					checkBox(driver, tc_dropoffcharges_radio, dropoffcharges_radio);
					waitForElement(driver, tc_condtdropoff_radio);
					checkBox(driver, tc_condtdropoff_radio, condtdropoff_radio);

					Step_Start(23, "Click on Add button once all mandatory field is entered for Terms and Charges", test, test1);
					waitForElement(driver, Etermchange_addbutton);
					click(driver, Etermchange_addbutton);
					Step_End(23, "Click on Add button once all mandatory field is entered for Terms and Charges", test, test1);

					// **************depreciation tab*****************
					Step_Start(24, "Click on Depreciation tab once all mandatory field entered in Terms and Charges tab", test, test1);
					waitForElement(driver, Edepreciationtab);
					click(driver, Edepreciationtab);
					Step_End(24, "Click on Depreciation tab once all mandatory field entered in Terms and Charges tab", test, test1);

					if (!depkind_input.equals("")) {
						waitForElement(driver, dep_kind);
						click(driver, dep_kind);
							waitForElement(driver, depkind);
							click(driver, depkind);
						
					} else {
						System.out.println("depkind_input " + "Input Not Available in test data");
					}

					Step_Start(25, "Click on Depreciation Type Drop menu select any type accordingly for Depreciation tab", test, test1);
					waitForElement(driver, Edepreciation_Type);
					click(driver, Edepreciation_Type);
						waitForElement(driver, depreciation_option);
						click(driver, depreciation_option);
						Step_End(25, "Click on Depreciation Type Drop menu select any type accordingly for Depreciation tab", test, test1);

					waitForElement(driver, depreciationtypeDropdownoption);
					String depreciationtypeDropdown_option= getText(driver, depreciationtypeDropdownoption);
					System.out.println("depreciationtypeDropdown_option: "+depreciationtypeDropdown_option);

					if (depreciationtypeDropdown_option.equals(depreciation_type)) {
						System.out.println(
								"Matched || Expected Result is :Once User select the depreciation type value ,it should be changed as  : " + depreciation_type + " || Actual Result is :Once User select the depreciation type value ,it is changed as  : " + depreciationtypeDropdown_option);
						Extent_pass_New(driver, 
								"Matched || Expected Result is :Once User select the depreciation type value ,it should be changed as  : " + depreciation_type + " || Actual Result is :Once User select the depreciation type value ,it is changed as  : " + depreciationtypeDropdown_option, test, test1);
					} else {
						System.out.println(
								"Not Matched || Expected Result is :Once User select the depreciation type value ,it should be changed as  : " + depreciation_type + " || Actual Result is :Once User select the depreciation type value ,it is not changed as  : " + depreciationtypeDropdown_option);
						Extent_fail(driver, 
								"Not Matched || Expected Result is :Once User select the depreciation type value ,it should be changed as  : " + depreciation_type + " || Actual Result is :Once User select the depreciation type value ,it is not changed as  : " + depreciationtypeDropdown_option, test, test1);
					}

					if (!deprate_input.equals("")) {
						waitForElement(driver, dep_percent);
						click(driver, dep_percent);
						
							waitForElement(driver, depercent);
							click(driver, depercent);
							waitForElement(driver, dep_rate);
							sendKeys(driver, dep_rate, deprate_input);
						
					} else {
						System.out.println("deprate_input " + "Input Not Available in test data");
					}

					if (!tc_depmin_input.equals("")) {
						waitForElement(driver, dep_min);
						sendKeys(driver, dep_min, tc_depmin_input);

					} else {
						System.out.println("tc_depmin_input " + "Input Not Available in test data");
					}

					if (!tc_depax_input.equals("")) {
						waitForElement(driver, dep_max);
						clear(driver, dep_max);
						sendKeys(driver, dep_max, tc_depax_input);

					} else {
						System.out.println("tc_depax_input " + "Input Not Available in test data");
					}

					if (!dep_mincheckbox_fieldvalue.equals("")) {
						waitForElement(driver, dep_min_checkbox);
						checkBox(driver, dep_min_checkbox, depmin_checkbox);

						waitForElement(driver, dep_mincheckbox_field);
						sendKeys(driver, dep_mincheckbox_field, dep_mincheckbox_fieldvalue);

					} else {
						System.out.println("dep_mincheckbox_fieldvalue " + "Input Not Available in test data");
					}
					
					Step_Start(26, "Click Save button once all mandatory field is entered in all tabs", test, test1);
						waitForElement(driver, SaveButton_ToolBar);
						safeclick(driver, SaveButton_ToolBar);
						Step_End(26, "Click Save button once all mandatory field is entered in all tabs", test, test1);

						Step_Start(27, "Check that message should show in screen as 'EMS Contract Registration Saved' once user click save button", test, test1);
						Step_Start(28, "verify 'EMS Contract Registration Saved' popup message.", test, test1);
				waitForPopup(driver, Popup_Message, popupmsg);
						String getpopup = getText(driver, Popup_Message);

					if (getpopup.equals(popupmsg)) {
						System.out.println("Matched || Expected popup was : " + popupmsg + " || Actual popup was : " + getpopup);
						Extent_pass_New(driver, "Matched || Expected popup was : " + popupmsg + " || Actual popup was : " + getpopup,
								test, test1);
					} else {
						System.out.println("NotMatched || Expected popup was : " + popupmsg + " || Actual popup was : " + getpopup);
						Extent_fail(driver, "NotMatched || Expected popup was : " + popupmsg + " || Actual popup was : " + getpopup,
								test, test1);
					}
					Step_End(28, "verify 'EMS Contract Registration Saved' popup message.", test, test1);
					Step_End(27, "Check that message should show in screen as 'EMS Contract Registration Saved' once user click save button", test, test1);

					if(Want_To_Delete.equalsIgnoreCase("Yes")) {

					scrollTop(driver);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					
					globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no1, "", "", "", "");

					waitForElement(driver, Delete_button_toolBar);
				    safeclick(driver,Delete_button_toolBar);

				    waitForElement(driver, popup_Message);
				    safeclick(driver,popup_Message_Yes_Button);
				    
				    waitForElement(driver, Popup_Message);

					}
					
					Extent_completed(tc_Name, test, test1);

					waitForElement(driver, Close_Current_tab);
                    click(driver, Close_Current_tab);
					

				}
				int T2=1;
				if(T2==1) {
					
					String tc_Name="TC_EMS_Contract_Registration_TS002";

					String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
					String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
					Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
						
					String Search_input = Excel_data.get("Search_input");	
					String contract_no2 = Excel_data.get("contract_no2");	
					String leasevalue = Excel_data.get("leasevalue");	
					String PerDiem_Value = Excel_data.get("PerDiem_Value");	
					String sizevalue1 = Excel_data.get("sizevalue1");	
					String contractupdated = Excel_data.get("contractupdated");	
					String buildup_perdiem_input = Excel_data.get("buildup_perdiem_input");	
					String DPPbasis_input = Excel_data.get("DPPbasis_input");	
					String DPPlumpsum_input = Excel_data.get("DPPlumpsum_input");	
					String freedays_input = Excel_data.get("freedays_input");	
					String builddown_perdiem_input = Excel_data.get("builddown_perdiem_input");	
					String amount = Excel_data.get("amount");	
					String DPPwaiver_input = Excel_data.get("DPPwaiver_input");	
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
					String Search_type = Excel_data.get("Search_type");	
					String Search_Type2 = Excel_data.get("Search_Type2");	
					String Search_Input2 = Excel_data.get("Search_Input2");	
					String Search_Type3 = Excel_data.get("Search_Type3");	
					String Search_Input3 = Excel_data.get("Search_Input3");	
					String search_by_con_num = Excel_data.get("search_by_con_num");	

					String lease_option=String.format(Ems_Contract_Registration_Locators.lease_option, leasevalue);
					String DPPbasis_value =String.format(Ems_Contract_Registration_Locators.DPPbasis_value, DPPbasis_input);
					String DPPlumpsum_value = String.format(Ems_Contract_Registration_Locators.DPPlumpsum_value, DPPlumpsum_input);
					String DPPwaiver_value =String.format(Ems_Contract_Registration_Locators.DPPwaiver_value, DPPwaiver_input);
					String combinevol_value =String.format(Ems_Contract_Registration_Locators.combinevol_value, combinevol_input);
					String sizevalue_option=String.format(Ems_Contract_Registration_Locators.sizevalue_option, sizevalue1);

					
					Extent_Start(tc_Name, test, test1);

					

					Step_Start(6, "click on search field", test, test1);
					Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
					moduleNavigate(driver, Search_input);

				    Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
					Step_End(6, "click on search field", test, test1);
					
					Step_Start(8, "Click on Global Search from toolbar", test, test1);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					Step_End(8, "Click on Global Search from toolbar", test, test1);

					Step_Start(9, "Enter Contract no & click on search button", test, test1);
					Step_Start(10, "Click on retrieved data for required contract no", test, test1);
					
					globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no2, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
					
					Step_End(9, "Enter Contract no & click on search button", test, test1);
					Step_End(10, "Click on retrieved data for required contract no", test, test1);

					Step_Start(11, "Click on Edit button from toolbar", test, test1);
				    
				    waitForElement(driver, Edit_Button_toolBar);
						click(driver, Edit_Button_toolBar);
						Step_Start(11, "Click on Edit button from toolbar", test, test1);

							Step_Start(12, "Select Size/type tab", test, test1);
							
							waitForElement(driver, Esizeandtype_tab);
							safeclick(driver, Esizeandtype_tab);
							Step_End(12, "Select Size/type tab", test, test1);

							Step_Start(13, "Add required size/type by selecting from dropmenu, select lease charge type and click add button", test, test1);
							
							waitForElement(driver, Esizeandtype_Field);
							safeclick(driver, Esizeandtype_Field);
								waitForElement(driver, sizevalue_option);
								click(driver, sizevalue_option);

							
							waitForElement(driver, sizetypeDropdownoption);
							String sizetypeDropdown_option = getText(driver, sizetypeDropdownoption);
							System.out.println("sizetypeDropdown_option: "+sizetypeDropdown_option);

							if (sizetypeDropdown_option.equals(sizevalue1)) {
								System.out.println(
										"Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue1 + " || Actual Result is :Once User select the size Type ,it is changed as  : " + sizetypeDropdown_option);
								Extent_pass_New(driver,

										"Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue1 + " || Actual Result is :Once User select the size Type ,it is changed as  : " + sizetypeDropdown_option,
										test, test1);
							} else {
								System.out.println(
										"Not Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue1 + " || Actual Result is :Once User select the size Type ,it is not changed as  : " + sizetypeDropdown_option);
								Extent_fail(driver, 
										"Not Matched || Expected Result is :Once User select the size Type ,it should be changed as  : " + sizevalue1 + " || Actual Result is :Once User select the size Type ,it is not changed as  : " + sizetypeDropdown_option, test, test1);
							}
							waitForElement(driver, Eleasechargetype_Field);
							safeclick(driver, Eleasechargetype_Field);
								waitForElement(driver, lease_option);
								safeclick(driver, lease_option);

							
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

							waitForElement(driver, Eperdiem_field);
							clear(driver, Eperdiem_field);
							sendKeys(driver, Eperdiem_field, PerDiem_Value);

							// **************sizetype non-mandatory fields***************
							// disabled
							if (!buildup_perdiem_input.equals("")) {
								waitForElement(driver, buildup_perdiem);
								sendKeys(driver, buildup_perdiem, buildup_perdiem_input);

							} else {
								System.out.println("buildup_perdiem_input " + "Input Not Available in : " + File_Path);
							}

							if (!DPPbasis_input.equals("")) {
								waitForElement(driver, DPP_basis);
								click(driver, DPP_basis);
									waitForElement(driver, DPPbasis_value);
									click(driver, DPPbasis_value);
									waitForElement(driver, DPP_lumpsum);
									click(driver, DPP_lumpsum);
									waitForElement(driver, DPPlumpsum_value);
									click(driver, DPPlumpsum_value);
								
							} else {
								System.out.println("DPPbasis_input " + "Input Not Available in : " + File_Path);
							}

							if (!freedays_input.equals("")) {
								waitForElement(driver, freedays);
								sendKeys(driver, freedays, freedays_input);

							} else {
								System.out.println("freedays_input " + "Input Not Available in : " + File_Path);
							}
							// disabled
							if (!builddown_perdiem_input.equals("")) {
								waitForElement(driver, builddown_perdiem);
								sendKeys(driver, builddown_perdiem, builddown_perdiem_input);

							} else {
								System.out.println("builddown_perdiem_input " + "Input Not Available in : " + File_Path);
							}

							if (!DPPwaiver_input.equals("")) {
								waitForElement(driver, DPP_waiver);
								click(driver, DPP_waiver);
									waitForElement(driver, DPPwaiver_value);
									safeclick(driver, DPPwaiver_value);
									waitForElement(driver, DPP_amount);
									sendKeys(driver, DPP_amount, amount);
							
							} else {
								System.out.println("DPPwaiver_input " + "Input Not Available in : " + File_Path);
							}

							if (!splperdiem_input.equals("")) {
								waitForElement(driver, spl_perdiem);
								clear(driver, spl_perdiem);
								sendKeys(driver, spl_perdiem, splperdiem_input);

							} else {
								System.out.println("splperdiem_input " + "Input Not Available in : " + File_Path);
							}

							// disabled
							if (!monthlyamount_input.equals("")) {
								waitForElement(driver, monthly_amount);
								clear(driver, monthly_amount);
								sendKeys(driver, monthly_amount, monthlyamount_input);

							} else {
								System.out.println("monthlyamount_input " + "Input Not Available in : " + File_Path);
							}

							if (!pickup_quantity_input.equals("")) {
								waitForElement(driver, pickup_quantity);
								sendKeys(driver, pickup_quantity, pickup_quantity_input);

							} else {
								System.out.println("pickup_quantity_input " + "Input Not Available in : " + File_Path);
							}

							if (!rep_input.equals("")) {
								waitForElement(driver, rep_value);
								clear(driver, rep_value);
								sendKeys(driver, rep_value, rep_input);

							} else {
								System.out.println("rep_input " + "Input Not Available in : " + File_Path);
							}

							if (!DPP_input.equals("")) {
								waitForElement(driver, DPP);
								sendKeys(driver, DPP, DPP_input);

							} else {
								System.out.println("DPP_input " + "Input Not Available in : " + File_Path);
							}

							// volume based banding
							if (!combinevol_input.equals("")) {
								waitForElement(driver, combine_vol);
								click(driver, combine_vol);
									waitForElement(driver, combinevol_value);
									click(driver, combinevol_value);
									waitForElement(driver, combinevolbtn);
									click(driver, combinevolbtn);
									waitForElement(driver, combinevol_addbtn);
									click(driver, combinevol_addbtn);
									waitForElement(driver, search_field_EMS);
									sendKeys(driver, search_field_EMS, com_vol);
									waitForElement(driver, combinevol_selbtn);
									click(driver, combinevol_selbtn);
									waitForElement(driver, combinevol_okbtn);
									click(driver, combinevol_okbtn);
							
							} else {
								System.out.println("combinevol_input " + "Input Not Available in : " + File_Path);
							}

							if (isClickable(driver, add_tierbtn)) {
								System.out.println("add tier button is enabled");

								if (!pretrip_ins_charge_input.equals("")) {
									waitForElement(driver, pretrip_ins_charge);
									sendKeys(driver, pretrip_ins_charge, pretrip_ins_charge_input);

								} else {
									System.out.println("pretrip_ins_charge_input " + "Input Not Available in : " + File_Path);
								}

								if (!posttrip_ins_charge_input.equals("")) {
									waitForElement(driver, posttrip_ins_charge);
									sendKeys(driver, posttrip_ins_charge, posttrip_ins_charge_input);

								} else {
									System.out.println("posttrip_ins_charge_input " + "Input Not Available in : " + File_Path);
								}

								if (!extent_cover_input.equals("")) {
									waitForElement(driver, extent_cover);
									sendKeys(driver, extent_cover, extent_cover_input);

								} else {
									System.out.println("extent_cover_input " + "Input Not Available in : " + File_Path);
								}

								if (!post_builddown_perdiem_input.equals("")) {
									waitForElement(driver, post_builddown_perdiem);
									sendKeys(driver, post_builddown_perdiem, post_builddown_perdiem_input);

								} else {
									System.out.println("post_builddown_perdiem_input " + "Input Not Available in : " + File_Path);
								}

								waitForElement(driver, add_tierbtn);
								click(driver, add_tierbtn);
							}
							
							waitForElement(driver, Esizeaddbutton);
							click(driver, Esizeaddbutton);
							
							Step_End(13, "Add required size/type by selecting from dropmenu, select lease charge type and click add button", test, test1);

							Step_Start(14, "Click save once update required details", test, test1);
					     waitForElement(driver, SaveButton_ToolBar);
						click(driver,SaveButton_ToolBar);
						Step_End(14, "Click save once update required details", test, test1);
					
						Step_Start(15, "Check that user should shown message as 'EMS Contract Registration Updated'", test, test1);
						Step_Start(16, "verify 'EMS Contract Registration Updated' popup message.", test, test1);
			             waitForPopup(driver, Popup_Message, contractupdated);
						String getpopup1 = getText(driver, Popup_Message);
					
					if (getpopup1.equals(contractupdated)) {
						System.out.println("Matched || Expected popup was : "+contractupdated+" || Actual popup was : "+getpopup1);
						Extent_pass_New(driver, "Matched || Expected popup was : "+contractupdated+" || Actual popup was : "+getpopup1, test, test1);
					}else {
						System.out.println("Not Matched || Expected popup was : "+contractupdated+" || Actual popup was : "+getpopup1);
						Extent_fail(driver,  "Not Matched || Expected popup was : "+contractupdated+" || Actual popup was : "+getpopup1, test, test1);
					}
					Step_End(15, "Check that user should shown message as 'EMS Contract Registration Updated'", test, test1);
					Step_End(16, "verify 'EMS Contract Registration Updated' popup message.", test, test1);
				   
					Extent_completed(tc_Name, test, test1);
				
					waitForElement(driver, Close_Current_tab);
	                click(driver, Close_Current_tab);
				}
		int T3=1;
		if(T3==1) {
			
			String tc_Name="TC_EMS_Contract_Registration_TS003";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
				
			String Search_input =Excel_data.get("Search_input");	
			String contract_no3 =Excel_data.get("contract_no3");	
			String delete_confirm =Excel_data.get("delete_confirm");	
			String Deleted_Message =Excel_data.get("Deleted_Message");	
			String Search_type =Excel_data.get("Search_type");	
			String search_by_con_num = Excel_data.get("search_by_con_num");	
			String Search_Type2 = Excel_data.get("Search_Type2");	
			String Search_Input2 = Excel_data.get("Search_Input2");	
			String Search_Type3 = Excel_data.get("Search_Type3");	
			String Search_Input3 = Excel_data.get("Search_Input3");	
			Extent_Start(tc_Name, test, test1);

			Step_Start(6, "click on search field", test, test1);
			Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
			moduleNavigate(driver, Search_input);

		    Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
			Step_End(6, "click on search field", test, test1);
			
			Step_Start(8, "Click on Global Search from toolbar", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			Step_End(8, "Click on Global Search from toolbar", test, test1);

			Step_Start(9, "Enter Contract no & click on search button", test, test1);
			Step_Start(10, "Click on retrieved data for required contract no", test, test1);

			globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no3, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
			
			Step_End(9, "Enter Contract no & click on search button", test, test1);
			Step_End(10, "Click on retrieved data for required contract no", test, test1);
			
			Step_Start(11, "Click on Delete icon from toolbar", test, test1);
			    waitForElement(driver, Delete_button_toolBar);
			    click(driver,Delete_button_toolBar);
				Step_End(11, "Click on Delete icon from toolbar", test, test1);

				waitForPopup(driver, popup_Message, delete_confirm);
			    String confirm_delete= getText(driver, popup_Message);
			    
			    if(confirm_delete.equals(delete_confirm)) {
			    	System.out.println("Matched || Expected popup was : "+delete_confirm+" || Actual popup was : "+confirm_delete);
			    	Extent_pass_New(driver, "Matched || Expected popup was : "+delete_confirm+" || Actual popup was : "+confirm_delete, test, test1);
			    }else {
			    	System.out.println("Not Matched || Expected popup was : "+delete_confirm+" || Actual popup was : "+confirm_delete);
			    	Extent_fail(driver,  "Not Matched || Expected popup was : "+delete_confirm+" || Actual popup was : "+confirm_delete, test, test1);
			    }
			    
				Step_Start(12, "Click on 'Yes' when pop-up message occurs for confirmation message", test, test1);
			    waitForElement(driver, popup_Message_Yes_Button);
			    click(driver,popup_Message_Yes_Button);
				Step_End(12, "Click on 'Yes' when pop-up message occurs for confirmation message", test, test1);

				Step_Start(13, "verify pop-up message occurs for confirmation message", test, test1);
			    waitForPopup(driver, Popup_Message, Deleted_Message);
				String delete_msg= getText(driver, Popup_Message);

			    if(delete_msg.equals(Deleted_Message)) {
			    	System.out.println("Matched || Expected popup was : "+Deleted_Message+" || Actual popup was : "+delete_msg);
			    	Extent_pass_New(driver, "Matched || Expected popup was : "+Deleted_Message+" || Actual popup was : "+delete_msg, test, test1);
			    }else {
			    	System.out.println("Not Matched || Expected popup was : "+Deleted_Message+" || Actual popup was : "+delete_msg);
			    	Extent_fail(driver,  "Not Matched || Expected popup was : "+Deleted_Message+" || Actual popup was : "+delete_msg, test, test1);
			    	}
				Step_End(13, "verify pop-up message occurs for confirmation mess2age", test, test1);
				
				Extent_completed(tc_Name, test, test1);


		    
			waitForElement(driver, Close_Current_tab);
            click(driver, Close_Current_tab);
		    
		}
		int T4=1;
		if(T4==1) {
			String tc_Name="TC_EMS_Contract_Registration_TS004";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
				
			String Search_input = Excel_data.get("Search_input");	
			String contract_no4 = Excel_data.get("contract_no4");	
			String cannot_delete = Excel_data.get("cannot_delete");	
			String Search_type = Excel_data.get("Search_type");	
			String search_by_con_num = Excel_data.get("search_by_con_num");	
			String Search_Type2 = Excel_data.get("Search_Type2");	
			String Search_Input2 = Excel_data.get("Search_Input2");	
			String Search_Type3 = Excel_data.get("Search_Type3");	
			String Search_Input3 = Excel_data.get("Search_Input3");	
	 		Extent_Start(tc_Name, test, test1);

			
	 		Step_Start(6, "click on search field", test, test1);
			Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
			
			moduleNavigate(driver, Search_input);

		    Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
			Step_End(6, "click on search field", test, test1);
			
			Step_Start(8, "Click on Global Search from toolbar", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			Step_End(8, "Click on Global Search from toolbar", test, test1);

			Step_Start(9, "Enter Contract no & click on search button", test, test1);
			Step_Start(10, "Click on retrieved data for required contract no", test, test1);
			
			globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no4, Search_Type2, Search_Input2, Search_Type3, Search_Input3);

			
			Step_End(9, "Enter Contract no & click on search button", test, test1);
			Step_End(10, "Click on retrieved data for required contract no", test, test1);
			    
			Step_Start(11, "Click on Delete icon from toolbar", test, test1);
		    waitForElement(driver, Delete_button_toolBar);
		    safeclick(driver,Delete_button_toolBar);
			Step_End(11, "Click on Delete icon from toolbar", test, test1);
			    
		    
			Step_Start(12, "Message will be shown as 'Cannot be deleted. This Contract No is used in Movement Entry'", test, test1);
			Step_Start(13, "verify 'Cannot be deleted. This Contract No is used in Movement Entry' popup message.", test, test1);
		  waitForPopup(driver, Popup_Message, cannot_delete);
			String delete_cannotmsg=getText(driver, Popup_Message);
		   if(delete_cannotmsg.equals(cannot_delete)) {
		    	System.out.println("Matched || Expected popup was : "+  cannot_delete+" || Actual popup was : "+ delete_cannotmsg);
		    	Extent_pass_New(driver, "Matched || Expected popup was : "+cannot_delete+" || Actual popup was : "+ delete_cannotmsg, test, test1);
		    }else {
		    	System.out.println("NotMatched || Expected popup was : "+ cannot_delete+" || Actual popup was : "+ delete_cannotmsg);
		    	Extent_fail(driver,  "NotMatched || Expected popup was : "+ cannot_delete+" || Actual popup was : "+ delete_cannotmsg, test, test1);	
		    }
		   Step_End(12, "Message will be shown as 'Cannot be deleted. This Contract No is used in Movement Entry'", test, test1);
			Step_End(13, "verify 'Cannot be deleted. This Contract No is used in Movement Entry' popup message.", test, test1);
		    
			Extent_completed(tc_Name, test, test1);

			waitForElement(driver, Close_Current_tab);
            click(driver, Close_Current_tab);
		 
		}
		
		int T5=1;
		if(T5==1) {
			
			String tc_Name="TC_EMS_Contract_Registration_TS005";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
				
			String Search_input = Excel_data.get("Search_input");	
			String contract_no5 = Excel_data.get("contract_no5");	
			String Search_type = Excel_data.get("Search_type");	
			String search_by_con_num = Excel_data.get("search_by_con_num");	
			String Search_Type2 = Excel_data.get("Search_Type2");	
			String Search_Input2 = Excel_data.get("Search_Input2");	
			String Search_Type3 = Excel_data.get("Search_Type3");	
			String Search_Input3 = Excel_data.get("Search_Input3");	
			
			Extent_Start(tc_Name, test, test1);

			Step_Start(6, "click on search field", test, test1);
			Step_Start(7, "Enter the EMS Contract Registration field in search box", test, test1);
			moduleNavigate(driver, Search_input);

		    Step_End(7, "Enter the EMS Contract Registration field in search box", test, test1);
			Step_End(6, "click on search field", test, test1);
			
			Step_Start(8, "Click on Global Search from toolbar", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			Step_End(8, "Click on Global Search from toolbar", test, test1);

			Step_Start(9, "Enter Contract no & click on search button", test, test1);
			Step_Start(10, "Click on retrieved data for required contract no", test, test1);
			
			globalValueSearchWindow(driver, Search_type, search_by_con_num, contract_no5, Search_Type2, Search_Input2, Search_Type3, Search_Input3);

			
			Step_End(9, "Enter Contract no & click on search button", test, test1);
			Step_End(10, "Click on retrieved data for required contract no", test, test1);
			   
			Step_Start(11, "verify the same retrived data show to contract no or not", test, test1);
			waitForElement(driver, Contract_no);
			    String actual_contractnum = getAttribute(driver, Contract_no, "value");
			    if(contract_no5.equals(actual_contractnum)) {
			    	System.out.println("Matched || Expected value was : "+ contract_no5+" || Actual value was : "+ actual_contractnum);
			    	Extent_pass_New(driver, "Matched || Expected value was : "+ contract_no5+" || Actual value was : "+ actual_contractnum, test, test1);
			    }else {
			    	System.out.println("Not Matched || Expected value was : "+  contract_no5+" || Actual value was : "+ actual_contractnum);
			    	Extent_fail(driver,  "Not Matched || Expected value was : "+contract_no5+" || Actual value was : "+ actual_contractnum, test, test1);	
			    }
				Step_End(11, "verify the same retrived data show to contract no or not", test, test1);
				Extent_completed(tc_Name, test, test1);

}
	}

}
