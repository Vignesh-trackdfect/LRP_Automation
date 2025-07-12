package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT13_I extends Keywords {

	public void Addingvessels (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TC_Long_Term_Creation_LT13_I";
		
		

		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Vessels_search_Status = Excel_data.get("Vessels_search_Status");
		String Add_Vessels_Perform = Excel_data.get("Add_Vessels_Perform");
		String Add_TBN_Vessels_Perform = Excel_data.get("Add_TBN_Vessels_Perform");
		String Add_Empty_Vessels_Perform = Excel_data.get("Add_Empty_Vessels_Perform");
		String Add_Vessels  = Excel_data.get("Add_Vessels");
		String selected_vessels_Perform  = Excel_data.get("selected_vessels_Perform");
		String selected_vessels_input  = Excel_data.get("selected_vessels_input");
		String cycle_checkbox_perform  = Excel_data.get("cycle_checkbox_perform");
		String Date_checkbox_perform  = Excel_data.get("Date_checkbox_perform");
		String voyage_checkbox_perform  = Excel_data.get("voyage_checkbox_perform");
		String show_all_cells_checkbox_perform  = Excel_data.get("show_all_cells_checkbox_perform");
		String show_draft_cells_checkbox_perform  = Excel_data.get("show_draft_cells_checkbox_perform");
		String show_conform_cells_checkbox_perform  = Excel_data.get("show_conform_cells_checkbox_perform");
		String show_Actual_conform_cells_checkbox_perform  = Excel_data.get("show_Actual_conform_cells_checkbox_perform");
		String show_omitted_cells_checkbox_perform  = Excel_data.get("show_omitted_cells_checkbox_perform");
		String To_cycle_input  = Excel_data.get("To_cycle_input");
		String From_cycle_input  = Excel_data.get("From_cycle_input");
		String From_Date_Input  = Excel_data.get("From_Date_Input");
		String To_Date_Input  = Excel_data.get("To_Date_Input");
		String Vessels_search  = Excel_data.get("Vessels_search");
		String To_voyage_perform  = Excel_data.get("To_voyage_perform");
		String From_Voyage_Perform  = Excel_data.get("From_Voyage_Perform");
		String From_voyage_Input  = Excel_data.get("From_voyage_Input");
		String To_voyage_Input  = Excel_data.get("To_voyage_Input");
		String Vessels_Code= Excel_data.get("Vessels_Code");
		String Vessels_verify_perform = Excel_data.get("Vessels_verify_perform");
		String dropdown_Condition = Excel_data.get("dropdown_Condition");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Add_Vessel_Code_Header  = Excel_data.get("Add_Vessel_Code_Header");




		Extent_Start(testcase_Name, test, test1);




		navigateUrl(driver, url); 
		LRP_Login(driver, Username, Password);

		//// verifying vessels are active

moduleNavigate(driver, Vessels_search);
		
		
		waitForElement(driver, switchButton);
		safeclick(driver, switchButton);
		if (Vessels_verify_perform.equals("YES")) {

			List<String> datas = splitAndExpand(Add_Vessels);
			for (String data1 : datas) {
				
				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, dropdown_Condition, Vessel_Code_Search, data1, "", "", "", "");
				

		waitForElement(driver, vesselCode_In_Vessel);
		String vesselscodeact=getAttribute(driver, vesselCode_In_Vessel,"value");
		System.out.println(vesselscodeact);


		
		waitForElement(driver, statusDropDown);
		String vesselsstatusact=getText(driver, statusDropDown);
		System.out.println(vesselsstatusact);


			

		if(Vessels_search_Status.equals(vesselsstatusact)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Vessels_search_Status + " || Actual Report Activity is : " + vesselsstatusact);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Vessels_search_Status + " || Actual Report Activity is  : " + vesselsstatusact, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Vessels_search_Status + " || Actual Report Activity is : " + vesselsstatusact);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Vessels_search_Status + " || Actual Report Activity is : " + vesselsstatusact, test,test1); 
		} 
			}
		}



		// searching for module

		moduleNavigate(driver, Search);
		Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

		Step_End(1, "Retirve the Record via Global Search  ", test, test1);

		// selecting the selected vessels
				if (selected_vessels_Perform.equals("YES")) {
					waitForElement(driver, selected_Vessel_Button);
					safeclick(driver, selected_Vessel_Button);
					waitForElement(driver, Addselectedvessels);
					safeclick(driver, Addselectedvessels);
					
					twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);

				}

		waitForElement(driver, cycle_check_box);
		checkBox(driver, cycle_check_box, cycle_checkbox_perform);
		waitForElement(driver, voyage_check_box);
		checkBox(driver, voyage_check_box, voyage_checkbox_perform);
		waitForElement(driver, showallcells_check_box);
		checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
		waitForElement(driver, showdraftcells_check_box);
		checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
		waitForElement(driver, showconformtcells_check_box);
		checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
		waitForElement(driver, showactualconformtcells_check_box);
		checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
		waitForElement(driver, showomittedcells_check_box);
		checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);

		// From cycle input
		if (!From_cycle_input.equals("")) {
			waitForElement(driver, From_cycle);
			clearAndType(driver, From_cycle, From_cycle_input);
		}

		// To cycle input
		if (!To_cycle_input.equals("")) {
			waitForElement(driver, To_cycle);
			clearAndType(driver, To_cycle, To_cycle_input);
		}

		checkBox(driver, Date_check_box, Date_checkbox_perform);
		
		
		waitForElement(driver, From_date_LT);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, From_date_LT, From_Date_Input);
		} else {
			waitForElement(driver, From_date_LT);
			clearAndType(driver, From_date_LT, From_Date_Input);
		}
		// Selecting the to Date
		waitForElement(driver, To_Date_LT);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, To_Date_LT, To_Date_Input);
		} else {
			waitForElement(driver, To_Date_LT);
			clearAndType(driver, To_Date_LT, To_Date_Input);
		}
		
		if (From_Voyage_Perform.equals("YES")) {
			waitForElement(driver, From_voyage_search);
			safeclick(driver, From_voyage_search);
			
			twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);

		}
		
		
		if (To_voyage_perform.equals("YES")) {
			waitForElement(driver, To_voyage_search);
			safeclick(driver, To_voyage_search);
			twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
			

		}

		waitForElement(driver, LongTermsearchOk);
		safeclick(driver, LongTermsearchOk);

		Step_Start(2, "Click on Edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Edit_Button_toolBar);
		Step_End(2, "Click on Edit button", test, test1);
		scrollBottom(driver);
		// renaming vessels
		List<String> beforename = new ArrayList<>();
		waitForElement(driver, vessels_code);

		List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
		for (WebElement Vessel_Code1 : vessel_Codes1) {

			String before = getText1(driver, Vessel_Code1);

			beforename.add(before);
			System.out.println(beforename);
		}

		try {
			int i = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

			for (WebElement Vessel_Code : vessel_Codes) {

				Click(driver, Vessel_Code);

				if (Vessels_Code.equals(Vessel_Code.getText())) {
					String num = String.valueOf(i);
					String voyage_Num = String.format(voyage_Num_l, num);
					if (Voyage_Number.equals(getText(driver, voyage_Num))) {
						Step_Start(3, "Right Click on the voyage where the add vessel needed to be the next vessel",
								test, test1);
						click(driver, voyage_Num);

						RightClick(driver, voyage_Num);
						Step_End(3, "Right Click on the voyage where the add vessel needed to be the next vessel", test,
								test1);
						Step_Start(4, "Choose “Add /Rename” option from the menu", test, test1);
						waitForElement(driver, AddandRemove);
						mouseOverToElement(driver, AddandRemove);
						Step_End(4, "Choose “Add /Rename” option from the menu", test, test1);

						Step_Start(5, "Choose “Add Vessel” option from the sub menu", test, test1);
						waitForElement(driver, AddVesselsss);
						safeclick(driver, AddVesselsss);
						Step_End(5, "Choose “Add Vessel” option from the sub menu", test, test1);

						if (Add_Vessels_Perform.equals("YES")) {
							Step_Start(6, "Enter the Vessel that needed to be added ", test, test1);
							if (Add_Vessels_Perform.equals("YES")) {
								waitForElement(driver, Addvesseslssearch);
								safeclick(driver, Addvesseslssearch);
								twoColumnSearchWindow(driver, Add_Vessel_Code_Header, Condition_Filter, Add_Vessels);

								

								Extent_pass_New(driver, "*****Vessels was selected as***** " + Add_Vessels, test, test1);
								Step_Start(9, "Click on Ok button", test, test1);
								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);
								Step_End(9, "Click on Ok button", test, test1);

								scrollBottom(driver);

								String ReferenceType_select1 = String.format(ReferenceType_Select1,
										Voyage_Number);
								//
								click(driver, ReferenceType_select1);
								Step_Start(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);
								Step_End(6, "Enter the Vessel that needed to be added ", test, test1);
								Step_End(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);
							} else {
								System.out.println("Expected Result is : Vessel should be selected || Actual Result is : Vessel is not selected ");
								Extent_fail(driver, "Expected Result is : Vessel should be selected || Actual Result is : Vessel is not selected ", test, test1);

							}
						}
						if (Add_TBN_Vessels_Perform.equals("YES")) {
							Step_Start(7, "If TBN vessel needed Click on TbN Vessel Radio button", test, test1);
							if (Add_TBN_Vessels_Perform.equals("YES")) {
								waitForElement(driver, TBMradiobtnclick);
								safeclick(driver, TBMradiobtnclick);
								Step_Start(9, "Click on Ok button", test, test1);

								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);
								Step_End(9, "Click on Ok button", test, test1);

								Step_End(7, "If TBN vessel needed Click on TbN Vessel Radio button", test, test1);
								scrollBottom(driver);

								String ReferenceTypeSelect1 = String.format(ReferenceType_Select1,
										Voyage_Number);

								click(driver, ReferenceTypeSelect1);
								Step_Start(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);
								Step_End(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);
							} else {
								System.out.println("Expected Result is : [TBN] VESSEL should be selected || Actual Result is : [TBN] VESSEL is not selected ");
								Extent_fail(driver, "Expected Result is : [TBN] VESSEL should be selected || Actual Result is : [TBN] VESSEL is not selected ", test, test1);
							}
						}

						if (Add_Empty_Vessels_Perform.equals("YES")) {
							Step_Start(8, "If blank vessel needed Click on TbN Vessel Radio button", test, test1);
							if (Add_Empty_Vessels_Perform.equals("YES")) {
								waitForElement(driver, blankRadioButton);
								safeclick(driver, blankRadioButton);
								Step_Start(9, "Click on Ok button", test, test1);
								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);

								Step_End(8, "If blank vessel needed Click on TbN Vessel Radio button", test, test1);
								Step_End(9, "Click on Ok button", test, test1);

								scrollBottom(driver);

								String Referencetype_Select1 = String.format(ReferenceType_Select1,
										Voyage_Number);

								click(driver, Referencetype_Select1);
								Step_Start(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);
								Step_End(10,
										"System should an empty vessel next to the voyage where we added the vessel",
										test, test1);

							} else {
								System.out.println("Expected Result is : Blank VESSEL should be selected || Actual Result is : Blank VESSEL is not selected ");
								Extent_fail(driver, "Expected Result is : Blank VESSEL should be selected || Actual Result is : Blank VESSEL is not selected ", test, test1);
							}

						}

						break;
					}
				}

				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}
		Extent_completed(testcase_Name, test, test1);

	}

} 

