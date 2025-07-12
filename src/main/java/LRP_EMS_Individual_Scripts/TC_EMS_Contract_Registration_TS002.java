package LRP_EMS_Individual_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



import locators.Ems_Contract_Registration_Locators;

public class TC_EMS_Contract_Registration_TS002 extends Keywords {
	
	public void Emscontractregistration02(WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
		
		String tc_Name="TC_EMS_Contract_Registration_TS002";

		
			
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
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

		Step_Start(1, "open chrome browser ", test, test1);
		Step_Start(2, "Enter the url", test, test1);

		navigateUrl(driver, url); 
		
		Step_End(2, "Enter the url", test, test1);
		Step_End(1, "open chrome browser ", test, test1);
		
		LRP_Login(driver, Username, Password);
		
		Step_End(5, "click on login button", test, test1);

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
			System.out.println("Matched || Expected popup was : "+ contractupdated +" || Actual popup was : "+ getpopup1);
			Extent_pass_New(driver, "Matched || Expected popup was : "+ contractupdated +" || Actual popup was : "+ getpopup1, test, test1);
		}else {
			System.out.println("Not Matched || Expected popup was : "+ contractupdated +" || Actual popup was : "+ getpopup1);
			Extent_fail(driver,  "Not Matched || Expected popup was : "+ contractupdated +" || Actual popup was : "+ getpopup1, test, test1);
		}
		Step_End(15, "Check that user should shown message as 'EMS Contract Registration Updated'", test, test1);
		Step_End(16, "verify 'EMS Contract Registration Updated' popup message.", test, test1);
	   
		Extent_completed(tc_Name, test, test1);
	}
}


