package LRP_VSS_Consolidation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Long_Term_Creation_LT13_LT17 extends Keywords {
	int i = 1;

	public void Addingvessels_13_17(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)
			throws Exception {

		int LT13 = 13;

		if (LT13 == 13) {


			String testcase_Name = "TC_Long_Term_Creation_LT13";
			String URL = TestNgXml.getdatafromExecution().get(testcase_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Username = data.get("Username");
			String Password = data.get("Password");
			String Search = data.get("Search_input");
//			String service_select = data.get("service_select");
//			String Voyage_Number = data.get("Voyage_Number");
//			String Add_Vessels_Perform = data.get("Add_Vessels_Perform");
//			String Add_TBN_Vessels_Perform = data.get("Add_TBN_Vessels_Perform");
//			String Add_Empty_Vessels_Perform = data.get("Add_Empty_Vessels_Perform");
//			String Add_Vessels = data.get("Add_Vessels");
//			String selected_vessels_Perform = data.get("selected_vessels_Perform");
//			String selected_vessels_input = data.get("selected_vessels_input");
//			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
//			String Date_checkbox_perform = data.get("Date_checkbox_perform");
//			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
//			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
//			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
//			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
//			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
//			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
//			String To_cycle_input = data.get("To_cycle_input");
//			String From_cycle_input = data.get("From_cycle_input");
//			String From_Date_Input = data.get("From_Date_Input");
//			String To_Date_Input = data.get("To_Date_Input");
//			String To_voyage_perform = data.get("To_voyage_perform");
//			String From_Voyage_Perform = data.get("From_Voyage_Perform");
//			String From_voyage_Input = data.get("From_voyage_Input");
//			String To_voyage_Input = data.get("To_voyage_Input");
//			String Vessels_Code = data.get("Vessels_Code");
//			String Service_Code_Header  = data.get("Service_Code_Header");
//			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
//			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
//			String Condition_Filter  = data.get("Condition_Filter");
//			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
//			String date_Picker  = data.get("date_Picker");
//			String Add_Vessel_Code_Header  = data.get("Add_Vessel_Code_Header");
//
//			Extent_Start(testcase_Name, test, test1);
//
//			navigateUrl(driver, URL);
//
//			LRP_Login(driver, Username, Password);
//			// searching for module
//
//			moduleNavigate(driver, Search);
//			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
//			waitForElement(driver, SearchButton_Toolbar);
//			safeclick(driver, SearchButton_Toolbar);
//			waitForElement(driver, searchIconLT);
//			safeclick(driver, searchIconLT);
//			
//			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);
//
//			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
//
//			// selecting the selected vessels
//					if (selected_vessels_Perform.equals("YES")) {
//						waitForElement(driver, selected_Vessel_Button);
//						safeclick(driver, selected_Vessel_Button);
//						waitForElement(driver, Addselectedvessels);
//						safeclick(driver, Addselectedvessels);
//						
//						twoColumnSearchWindow(driver, Vessel_Code_Header, Condition_Filter, selected_vessels_input);
//
//					}
//
//			waitForElement(driver, cycle_check_box);
//			checkBox(driver, cycle_check_box, cycle_checkbox_perform);
//			waitForElement(driver, voyage_check_box);
//			checkBox(driver, voyage_check_box, voyage_checkbox_perform);
//			waitForElement(driver, showallcells_check_box);
//			checkBox(driver, showallcells_check_box, show_all_cells_checkbox_perform);
//			waitForElement(driver, showdraftcells_check_box);
//			checkBox(driver, showdraftcells_check_box, show_draft_cells_checkbox_perform);
//			waitForElement(driver, showconformtcells_check_box);
//			checkBox(driver, showconformtcells_check_box, show_conform_cells_checkbox_perform);
//			waitForElement(driver, showactualconformtcells_check_box);
//			checkBox(driver, showactualconformtcells_check_box, show_Actual_conform_cells_checkbox_perform);
//			waitForElement(driver, showomittedcells_check_box);
//			checkBox(driver, showomittedcells_check_box, show_omitted_cells_checkbox_perform);
//
//			// From cycle input
//			if (!From_cycle_input.equals("")) {
//				waitForElement(driver, From_cycle);
//				clearAndType(driver, From_cycle, From_cycle_input);
//			}
//
//			// To cycle input
//			if (!To_cycle_input.equals("")) {
//				waitForElement(driver, To_cycle);
//				clearAndType(driver, To_cycle, To_cycle_input);
//			}
//
//			checkBox(driver, Date_check_box, Date_checkbox_perform);
//			
//			
//			waitForElement(driver, From_date_LT);
//			if (date_Picker.equalsIgnoreCase("Yes")) {
//				selectDatePicker(driver, From_date_LT, From_Date_Input);
//			} else {
//				waitForElement(driver, From_date_LT);
//				clearAndType(driver, From_date_LT, From_Date_Input);
//			}
//			// Selecting the to Date
//			waitForElement(driver, To_Date_LT);
//			if (date_Picker.equalsIgnoreCase("Yes")) {
//				selectDatePicker(driver, To_Date_LT, To_Date_Input);
//			} else {
//				waitForElement(driver, To_Date_LT);
//				clearAndType(driver, To_Date_LT, To_Date_Input);
//			}
//			
//			if (From_Voyage_Perform.equals("YES")) {
//				waitForElement(driver, From_voyage_search);
//				safeclick(driver, From_voyage_search);
//				
//				twoColumnSearchWindow(driver, From_Voyage_Number_Header, Condition_Filter, From_voyage_Input);
//
//			}
//			
//			
//			if (To_voyage_perform.equals("YES")) {
//				waitForElement(driver, To_voyage_search);
//				safeclick(driver, To_voyage_search);
//				twoColumnSearchWindow(driver, To_Voyage_Number_Header, Condition_Filter, To_voyage_Input);
//				
//
//			}
//
//			waitForElement(driver, LongTermsearchOk);
//			safeclick(driver, LongTermsearchOk);
//
//			Step_Start(2, "Click on Edit button", test, test1);
//			waitForElement(driver, Edit_Button_toolBar);
//			safeclick(driver, Edit_Button_toolBar);
//			waitForElement(driver, Edit_Button_toolBar);
//			Step_End(2, "Click on Edit button", test, test1);
//			scrollBottom(driver);
//			// renaming vessels
//			List<String> beforename = new ArrayList<>();
//			waitForElement(driver, vessels_code);
//
//			List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
//			for (WebElement Vessel_Code1 : vessel_Codes1) {
//
//				String before = getText1(driver, Vessel_Code1);
//
//				beforename.add(before);
//				System.out.println(beforename);
//			}
//
//			try {
//				int i = 1;
//				waitForElement(driver, vessels_code);
//
//				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
//
//				for (WebElement Vessel_Code : vessel_Codes) {
//
//					Click(driver, Vessel_Code);
//
//					if (Vessels_Code.equals(Vessel_Code.getText())) {
//						String num = String.valueOf(i);
//						String voyage_Num = String.format(voyage_Num_l, num);
//						if (Voyage_Number.equals(getText(driver, voyage_Num))) {
//							Step_Start(3, "Right Click on the voyage where the add vessel needed to be the next vessel",
//									test, test1);
//							click(driver, voyage_Num);
//
//							RightClick(driver, voyage_Num);
//							Step_End(3, "Right Click on the voyage where the add vessel needed to be the next vessel", test,
//									test1);
//							Step_Start(4, "Choose “Add /Rename” option from the menu", test, test1);
//							waitForElement(driver, AddandRemove);
//							mouseOverToElement(driver, AddandRemove);
//							Step_End(4, "Choose “Add /Rename” option from the menu", test, test1);
//
//							Step_Start(5, "Choose “Add Vessel” option from the sub menu", test, test1);
//							waitForElement(driver, AddVesselsss);
//							safeclick(driver, AddVesselsss);
//							Step_End(5, "Choose “Add Vessel” option from the sub menu", test, test1);
//
//							if (Add_Vessels_Perform.equals("YES")) {
//								Step_Start(6, "Enter the Vessel that needed to be added ", test, test1);
//								if (Add_Vessels_Perform.equals("YES")) {
//									waitForElement(driver, Addvesseslssearch);
//									safeclick(driver, Addvesseslssearch);
//									twoColumnSearchWindow(driver, Add_Vessel_Code_Header, Condition_Filter, Add_Vessels);
//
//									
//
//									Extent_pass_New(driver, "Expected Result is : Vessel should be added as " + Add_Vessels+ "Actual result is : Vessel should be added as "+ Add_Vessels, test, test1);
//									Step_Start(9, "Click on Ok button", test, test1);
//									waitForElement(driver, vesselRenameOkButton);
//									safeclick(driver, vesselRenameOkButton);
//									Step_End(9, "Click on Ok button", test, test1);
//
//									scrollBottom(driver);
//
//									String ReferenceType_select1 = String.format(ReferenceType_Select1,
//											Voyage_Number);
//									//
//									click(driver, ReferenceType_select1);
//									Step_Start(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//									Extent_pass_New(driver, "Expected Result is : Vessel should be added as " + Add_Vessels+ "Actual result is : Vessel should be added as "+ Add_Vessels, test, test1);
//									Step_End(6, "Enter the Vessel that needed to be added ", test, test1);
//									Step_End(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//								} else {
//									System.out.println("Expected Result is : Vessel should not be selected || Actual Result is : Vessel is not selected");
//									Extent_fail(driver, "Expected Result is : Vessel should not be selected || Actual Result is : Vessel is not selected" + Add_Vessels, test, test1);
//
//								}
//							}
//							if (Add_TBN_Vessels_Perform.equals("YES")) {
//								Step_Start(7, "If TBN vessel needed Click on TbN Vessel Radio button", test, test1);
//								if (Add_TBN_Vessels_Perform.equals("YES")) {
//									waitForElement(driver, TBMradiobtnclick);
//									safeclick(driver, TBMradiobtnclick);
//									Extent_pass_New(driver, "Expected Result is : Vessel should  be selected as [TBN] || Actual Result is : Vessel is selected as [TBN] ", test, test1);
//									Step_Start(9, "Click on Ok button", test, test1);
//
//									waitForElement(driver, vesselRenameOkButton);
//									safeclick(driver, vesselRenameOkButton);
//									Step_End(9, "Click on Ok button", test, test1);
//
//									Step_End(7, "If TBN vessel needed Click on TbN Vessel Radio button", test, test1);
//									scrollBottom(driver);
//
//									String ReferenceTypeSelect1 = String.format(ReferenceType_Select1,
//											Voyage_Number);
//
//									click(driver, ReferenceTypeSelect1);
//									Step_Start(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//									Extent_pass_New(driver, "Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is added as [TBN]", test, test1);
//									Step_End(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//								} else {
//									System.out.println("Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is not added as [TBN]");
//									Extent_fail(driver, "Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is not added as [TBN]", test, test1);
//								}
//							}
//
//							if (Add_Empty_Vessels_Perform.equals("YES")) {
//								Step_Start(8, "If blank vessel needed Click on TbN Vessel Radio button", test, test1);
//								if (Add_Empty_Vessels_Perform.equals("YES")) {
//									waitForElement(driver, blankRadioButton);
//									safeclick(driver, blankRadioButton);
//									Extent_pass_New(driver, "Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is added as Empty Vessel", test, test1);
//									Step_Start(9, "Click on Ok button", test, test1);
//									waitForElement(driver, vesselRenameOkButton);
//									safeclick(driver, vesselRenameOkButton);
//
//									Step_End(8, "If blank vessel needed Click on TbN Vessel Radio button", test, test1);
//									Step_End(9, "Click on Ok button", test, test1);
//
//									scrollBottom(driver);
//
//									String Referencetype_Select1 = String.format(ReferenceType_Select1,
//											Voyage_Number);
//
//									click(driver, Referencetype_Select1);
//									Step_Start(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//									Extent_call(test, test1, "Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is added as Empty Vessel");
//									Extent_pass_New(driver, "Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is added as Empty Vessel", test, test1);
//									Step_End(10,
//											"System should an empty vessel next to the voyage where we added the vessel",
//											test, test1);
//
//								} else {
//									System.out.println("Expected Result is : Blank Vessel should not be added || Actual Result is :Blank Vessel is not added");
//									Extent_fail(driver, "Expected Result is : Blank Vessel should not be added || Actual Result is :Blank Vessel is not added", test, test1);
//								}
//
//							}
//
//							break;
//						}
//					}
//
//					i++;
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);
//
//			}
//			
//			Extent_completed(testcase_Name, test, test1);
//
//		
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT14 = 14;

		if (LT14 == 14) {

			String testcase_Name = "TC_Long_Term_Creation_LT14";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String copy_Voyage_Number = data.get("Copy_Voyage");
			String Copy_pop_exp = data.get("Copy_pop_exp");
			String Past_Pop_Exp = data.get("Past_Pop_Exp");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			String Add_Vessel_Code_Header = data.get("Add_Vessel_Code_Header");
			String Cycle_No = data.get("Cycle_No");
			String Pivot_Voyage_1 = data.get("Pivot_Voyage_1");
			String Voyage_No = data.get("Voyage_No");
			String Pivot_Voyage_2 = data.get("Pivot_Voyage_2");
			String Pivot_Voyage_3 = data.get("Pivot_Voyage_3");
			String Arrival_Pilot_Date_Input = data.get("Arrival_Pilot_Date_Input");

			Extent_Start(testcase_Name, test, test1);

			// searching for module

			moduleNavigate(driver, Search);
			
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
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
			try {
				int i = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

				for (WebElement Vessel_Code : vessel_Codes) {

					Click(driver, Vessel_Code);

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String voyage_Num = String.format(voyage_Num_l, i);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							// copy the vessels
							Step_Start(3, "Click on the Voyage which needed to be copied(Draft/Confirmed)", test, test1);
							String ReferenceType_Select1_ = String.format(ReferenceType_Select3,
									copy_Voyage_Number);

							Step_Start(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
							click(driver, ReferenceType_Select1_);

							RightClick(driver, ReferenceType_Select1_);
							

							Step_End(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
							waitForDisplay(driver, optionsBox);
							if (isDisplayed(driver, optionsBox)) {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed  || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed", test, test1);
								scrollUsingElement(driver, cutCopyPasteRemove);
								Step_Start(5, "Choose Cut/Copy/Paste From the menu", test, test1);
								mouseOverToElement(driver, cutCopyPasteRemove);
							} else {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed  || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed", test, test1);
							}
							Step_End(5, "Choose Cut/Copy/Paste From the menu", test, test1);

							waitForDisplay(driver, subMenuCopyPaste);
							if (isDisplayed(driver, subMenuCopyPaste)) {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed  || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed", test, test1);
								Step_Start(6, "Choose Paste option ", test, test1);
								waitForElement(driver, copyInSubMenu);
								safeclick(driver, copyInSubMenu);
							} else {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed  || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed", test, test1);
							}

							Step_End(6, "Choose Paste option ", test, test1);

							waitForPopup(driver, popup_Message, Copy_pop_exp);
							String Copypopact = getText(driver, popup_Message);
							System.out.println(Copypopact);
							if (Copy_pop_exp.equals(Copypopact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp, test, test1);
								Extent_pass_New(driver, "***Voyage was selected to copy as***" + copy_Voyage_Number, test,
										test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Copypopact
										+ " || Actual Activity is : " + Copy_pop_exp, test, test1);
							}
							safeclick(driver, popup_Message_Ok_Button);

							Step_End(3, "Click on the Voyage which needed to be copied(Draft/Confirmed)", test, test1);
							// Past A voyage
							String ReferenceType_Select11 = String.format(ReferenceType_Select3,
									Voyage_Number);

							click(driver, ReferenceType_Select11);

							RightClick(driver, ReferenceType_Select11);

							waitForDisplay(driver, optionsBox);
							if (isDisplayed(driver, optionsBox)) {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed", test, test1);
								scrollUsingElement(driver, cutCopyPasteRemove);
								mouseOverToElement(driver, cutCopyPasteRemove);
							} else {
								System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed", test, test1);
							}

							waitForDisplay(driver, subMenuCopyPaste);
							if (isDisplayed(driver, subMenuCopyPaste)) {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed");
								Extent_pass_New(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed", test, test1);
								safeclick(driver, pasteInSubMenu);
							} else {
								System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed");
								Extent_fail(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed", test, test1);
							}
							
								
								
								waitForElement(driver, cycle_No_TF);
								clearAndType(driver, cycle_No_TF, Cycle_No);
								
								waitForElement(driver, Voyage_No_TF);
								clearAndType(driver, Voyage_No_TF, Voyage_No);

								
								if(!Pivot_Voyage_1.equals("")) {
								waitForElement(driver, Pivot_Voyage_1_TF);
								clearAndType(driver, Pivot_Voyage_1_TF, Pivot_Voyage_1);
								}

								if(!Pivot_Voyage_2.equals("")) {
								waitForElement(driver, Pivot_Voyage_2_TF);
								clearAndType(driver, Pivot_Voyage_2_TF, Pivot_Voyage_2);
								}
								
								if(!Pivot_Voyage_3.equals("")) {
									waitForElement(driver, Pivot_Voyage_3_TF);
									clearAndType(driver, Pivot_Voyage_3_TF, Pivot_Voyage_3);
									}
								
								
								selectDatePickerWith_Time(driver, Arrival_Pilot_Date_Cs, Arrival_Pilot_Date_Input);
								
								
							waitForElement(driver, Paste_Voyage_Ok_Button);
							click(driver, Paste_Voyage_Ok_Button);
								
								if(isdisplayed(driver, popup_Message_Yes_Button)) {
									waitForElement(driver, popup_Message_Yes_Button);
									click(driver, popup_Message_Yes_Button);
									
								}

							Step_Start(7, ".Now the copied voyage will be pasted on the vessel", test, test1);
	                        waitForPopup(driver, popup_Message, Past_Pop_Exp);
							Step_Start(8, "System should show validation “Voyage Pasted”", test, test1);
							String pastedpopact = getText(driver, popup_Message);
							System.out.println(pastedpopact);
							if (Past_Pop_Exp.equals(pastedpopact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Past_Pop_Exp
										+ " || Actual Activity is : " + pastedpopact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Past_Pop_Exp
										+ " || Actual Activity is : " + pastedpopact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Past_Pop_Exp
										+ " || Actual Activity is : " + pastedpopact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Past_Pop_Exp
										+ " || Actual Activity is : " + pastedpopact, test, test1);

							}
							safeclick(driver, popup_Message_Ok_Button);

//							String ReferenceType_Select111 = String.format(ReferenceType_Select1,
//									Voyage_Number);
	//
//							click(driver, ReferenceType_Select111);

							Extent_pass_New(driver, "Expected Result is : Voyage should be pasted as " + copy_Voyage_Number+ "Expected Result is : Voyage should be pasted as " + copy_Voyage_Number, test, test1);

							Step_End(7, ".Now the copied voyage will be pasted on the vessel", test, test1);
							Step_End(8, "System should show validation “Voyage Pasted”", test, test1);

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

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT15 = 15;

		if (LT15 == 15) {

			String testcase_Name = "TC_Long_Term_Creation_LT15";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Pop_up_for_confirm = data.get("Pop_up_for_confirm");
			String Voyage_Confirmed_popEXP = data.get("Voyage_Confirmed_pop");
			String Vessels_Code = data.get("Vessels_Code");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("To_voyage_Input");
			String All_proforma_check_box = data.get("All_proforma_check_box");
			String Add_new_proforma_code = data.get("Add_new_proforma_code");
			String proforma_code_input = data.get("proforma_code_input");
			String start_Date = data.get("start_Date");
			String All_cycles_perform = data.get("All_cycles_perform");
			String selected_cycle_perform = data.get("selected_cycle_perform");
			String Future_cycle_perform = data.get("Future_cycle_perform");
			String cycles_input_selected = data.get("cycles_input_selected");
			String Long_Term_Updated_Pop = data.get("Long_Term_Updated_Pop");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			String Proforma_code_Header  = data.get("Proforma_code_Header");
			String Cycle_No_Header  = data.get("Cycle_No_Header");



			String Updated_pop_act = null;

			Extent_Start(testcase_Name, test, test1);


			// searching for module
			
			moduleNavigate(driver, Search);

			Step_Start(1, "Retrieve the Record via Global Search", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);


			Step_End(1, "Retrieve the Record via Global Search", test, test1);

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

			Step_Start(2, ".Click on Edit button", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			safeclick(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);
			scrollBottom(driver);
			Step_End(2, ".Click on Edit button", test, test1);

			int i = 1;

			waitForElement(driver, vessels_code);

			List<String> beforename = new ArrayList<>();
			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
			for (WebElement Vessel_Code : vessel_Codes) {

				if (Vessels_Code.equals(Vessel_Code.getText())) {

					String voyage_Num1 = String.format(vesselsss1, i);

					String Codesbefore = getText(driver, voyage_Num1);
					beforename.add(Codesbefore);
					System.out.println(beforename);
				}
				i++;
			}

			try {
				i = 1;

				for (WebElement Vessel_Code : vessel_Codes) {

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String voyage_Num = String.format(voyage_Num_l, i);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {
							String voyage_Num1 = String.format(vesselsss1, i);

							String Codesbefore = getText(driver, voyage_Num1);
							beforename.add(Codesbefore);
							System.out.println(beforename);
							Step_Start(3,
									"Click on the voyage which need to have different proforma from the exisitng one voyage has ",
									test, test1);
							click(driver, voyage_Num1);
							Step_End(3,
									"Click on the voyage which need to have different proforma from the exisitng one voyage has ",
									test, test1);

							Step_Start(4, "Right click on th voyage ", test, test1);
							RightClick(driver, voyage_Num1);
							Step_End(4, "Right click on th voyage ", test, test1);
							Step_Start(5, "Choose Proforma Refersh Option ", test, test1);
							waitForElement(driver, ProformaRefresh);
							safeclick(driver, ProformaRefresh);
							Step_End(5, "Choose Proforma Refersh Option ", test, test1);
							Step_Start(6, "Choose the Desired proforma from the two col search ", test, test1);
							checkBox(driver, All_proforma_checkbox, All_proforma_check_box);

							if (Add_new_proforma_code.equals("YES")) {
								waitForElement(driver, new_proforma_code_search);
								safeclick(driver, new_proforma_code_search);
								twoColumnSearchWindow(driver, Proforma_code_Header, Condition_Filter, proforma_code_input);
								
							}
							Step_End(6, "Choose the Desired proforma from the two col search ", test, test1);

							waitForDisplay(driver, popup_Message_Ok_Button);
							if (isDisplayed(driver, popup_Message_Ok_Button)) {
								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);
							}
							Step_Start(7, "Set the Start Date for the Voyage to Start ", test, test1);
							
							waitForElement(driver, start_Date_Click);
							if (date_Picker.equalsIgnoreCase("Yes")) {
								selectDatePicker(driver, start_Date_Click, start_Date);
							} else {
								waitForElement(driver, start_Date_Click);
								clearAndType(driver, start_Date_Click, start_Date);
							}
							
							Step_End(7, "Set the Start Date for the Voyage to Start ", test, test1);
							Step_Start(11, "Chosse if the new proforma should apply for the Current voyage ", test, test1);
							Step_Start(12, "Click on Current Voyage", test, test1);
							Step_Start(16, "If the new proforma wanted to be applied to all cycles  ", test, test1);
							Step_Start(17, "Select All Cycles   ", test, test1);
							if (Future_cycle_perform.equals("NO")) {

								waitForElement(driver, Selec_current_butn);
								safeclick(driver, Selec_current_butn);
								waitForElement(driver, Clicklongtermbutton);
								safeclick(driver, Clicklongtermbutton);
								waitForDisplay(driver, popup_Message_Yes_Button);
								if (isDisplayed(driver, popup_Message_Yes_Button)) {
									safeclick(driver, popup_Message_Yes_Button);
								} else {
									System.out.println("Expected Result is : Popup should be display || Actual Result is : Popup is displayed ");
								}

								Step_End(11, "Chosse if the new proforma should apply for the Current voyage ", test,
										test1);
								Step_End(12, "Click on Current Voyage", test, test1);
								Step_End(16, "If the new proforma wanted to be applied to all cycles  ", test, test1);
								Step_End(17, "Select All Cycles   ", test, test1);
								waitForPopup(driver, popup_Message, Long_Term_Updated_Pop);
								String Updated_pop_act1 = getText(driver, popup_Message);
								System.out.println(Updated_pop_act1);

								if (Long_Term_Updated_Pop.equals(Updated_pop_act1)) {
									System.out.println("Matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
											+ " || Actual Activity is : " + Updated_pop_act1);
									Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
											+ " || Actual Activity is : " + Updated_pop_act1, test, test1);
									Extent_pass_New(driver, "***Voyage was selected  as***" + Updated_pop_act1, test, test1);
								} else {
									System.out.println("Not matched || " + " Expected Activity is : "
											+ Long_Term_Updated_Pop + " || Actual Activity is : " + Updated_pop_act1);
									Extent_fail(driver, "Not matched || " + " Expected Activity is : "
											+ Long_Term_Updated_Pop + " || Actual Activity is : " + Updated_pop_act1, test,
											test1);
								}
								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);

							}

							Step_Start(9,
									"Chosse if the new proforma should apply for the future voyages of the same vessel  ",
									test, test1);
							Step_Start(15, "..Choose the Cycles from the Multi option search ", test, test1);
							Step_Start(10, "Click on Future Voyages", test, test1);
							if (Future_cycle_perform.equals("YES")) {

								if (All_cycles_perform.equals("YES")) {
									System.out.println("all cycles selected");
								}

								Step_Start(13, ".If the new proforma wanted to be only to selected cycle ", test, test1);
								Step_Start(14, ".Select Selected cycles button ", test, test1);
								if (selected_cycle_perform.equals("YES")) {
									waitForElement(driver, selected_cycles_click);
									safeclick(driver, selected_cycles_click);
									List<String> datas = splitAndExpand(cycles_input_selected);
									for (String data1 : datas) {
										waitForElement(driver, selected_cycles_search);
										safeclick(driver, selected_cycles_search);
										
										twoColumnSearchWindow(driver, Cycle_No_Header, Condition_Filter, data1);
									}
								}
							}
							Step_End(13, ".If the new proforma wanted to be only to selected cycle ", test, test1);
							Step_End(14, ".Select Selected cycles button ", test, test1);
							Step_Start(18, ".Click on “make Long Term” option   ", test, test1);
							waitForElement(driver, Clicklongtermbutton);
							safeclick(driver, Clicklongtermbutton);
							Step_End(18, ".Click on “make Long Term” option   ", test, test1);
							if (isDisplayed(driver, popup_Message_Yes_Button)) {
								safeclick(driver, popup_Message_Yes_Button);
							} else {
								System.out.println("pop was not came");
							}
							Step_End(15, "..Choose the Cycles from the Multi option search ", test, test1);
							Step_End(9,
									"Chosse if the new proforma should apply for the future voyages of the same vessel  ",
									test, test1);
							Step_End(10, "Click on Future Voyages", test, test1);
							waitForPopup(driver, popup_Message, Long_Term_Updated_Pop);
							Updated_pop_act = getText(driver, popup_Message);
							System.out.println(Updated_pop_act);

							if (Long_Term_Updated_Pop.equals(Updated_pop_act)) {
								System.out.println("Matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
										+ " || Actual Activity is : " + Updated_pop_act);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
										+ " || Actual Activity is : " + Updated_pop_act, test, test1);

							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
										+ " || Actual Activity is : " + Updated_pop_act);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Long_Term_Updated_Pop
										+ " || Actual Activity is : " + Updated_pop_act, test, test1);
							}

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);

							break;
						}
					}

					i++;

				}
			} catch (Exception e) {
				e.printStackTrace();
				Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

			}
			waitForElement(driver, vessels_code);

			vessel_Codes = listOfElements(driver, vessels_code);
			i = 1;
			List<String> aftername = new ArrayList<>();
			for (WebElement Vessel_Code : vessel_Codes) {

				if (Vessels_Code.equals(Vessel_Code.getText())) {
					String voyage_Num1 = String.format(vesselsss1, i);
					String aftercode = getText(driver, voyage_Num1);
					aftername.add(aftercode);
					System.out.println(aftername);
				}
				i++;
			}

			if (beforename.equals(aftername)) {
				System.out.println("Matched || The expected Result is : Once user add new proforma should be  "+ beforename+ "|| Acutal result is :Once user add new proforma is "+aftername);
				Extent_fail(driver,
						"Matched || The expected Result is : Once user add new proforma should be  "+ beforename+ "|| Acutal result is :Once user add new proforma is "+aftername,
						test, test1);

			} else {
				System.out.println("Not Matched || The expected Result is : Once user add new proforma should be  "+ beforename+ "|| Acutal result is :Once user not add new proforma is "+aftername);
				Extent_pass_New(driver, "Not Matched || The expected Result is : Once user add new proforma should be  "+ beforename+ "|| Acutal result is :Once user not add new proforma is "+aftername, test, test1);
			}

			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT16 = 16;

		if (LT16 == 16) {
			String testcase_Name = "TC_Long_Term_Creation_LT16";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Add_Vessels_Perform = data.get("Add_Vessels_Perform");
			String Add_TBN_Vessels_Perform = data.get("Add_TBN_Vessels_Perform");
			String Add_Empty_Vessels_Perform = data.get("Add_Empty_Vessels_Perform");
			String Add_Vessels = data.get("Add_Vessels");
			String Port_Name = data.get("Port_Name");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("From_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String Future_Perform = data.get("Future_Perform");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			String Add_Vessel_Code_Header  = data.get("Add_Vessel_Code_Header");
			
			
			
			int rownum = 0;

			Extent_Start(testcase_Name, test, test1);

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
	            try {
				int i = 1;
				waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

				for (WebElement Vessel_Code : vessel_Codes) {

					Click(driver, Vessel_Code);
					if (Vessels_Code.equals(Vessel_Code.getText())) {
						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);

						System.out.println(getText(driver, voyage_Num));
						System.out.println(Voyage_Number);
						System.out.println(voyage_Num);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							String port_Date = String.format(port_Date_17, Port_Name, i);
							Step_Start(3,
									"Right click on the port of the voyage from which the voyage will be phased out and phased in by different vessel",
									test, test1);
							safeclick(driver, port_Date);

							RightClick(driver, port_Date);

							Step_End(3,
									"Right click on the port of the voyage from which the voyage will be phased out and phased in by different vessel",
									test, test1);

							mouseOverToElement(driver, AdjustTime);
							waitForElement(driver, AdjustTime1);
							safeclick(driver, AdjustTime1);

							String beforechangeterminal = String.format(terminal_, Port_Name);
							String attributeValue = getAttribute(driver, beforechangeterminal, "row-index");
							System.out.println(attributeValue);
							rownum = Integer.parseInt(attributeValue);
							System.out.println(rownum);

							int row = 2;
							rownum = rownum + row;

							
							String Treminal_code = String.format(terminal_c, rownum);
							String text = getText(driver, Treminal_code);
							System.out.println(text);

							waitForElement(driver, Closeadjesttime);
							safeclick(driver, Closeadjesttime);

							String port_Date1 = String.format(port_Date_17, Port_Name, i);
							safeclick(driver, port_Date1);

							RightClick(driver, port_Date1);
							Step_Start(4, "Choose Phase out/in Swap from the menu", test, test1);
							mouseOverToElement(driver, swapOption);
							waitForElement(driver, phaseOutOkButton);
							safeclick(driver, phaseOutOkButton);
							Step_End(4, "Choose Phase out/in Swap from the menu", test, test1);
							// selecting future
							Step_Start(6,
									"If the Future voyages of the phased out vessel should be replaced by the phase in vessel",
									test, test1);
							Step_Start(7, "Choose Future Cycle ", test, test1);
							if (Future_Perform.equals("YES")) {
								System.out.println("Expected Result is : Future should be selected || Actual Result is : Future is selected ");
								Extent_pass_New(driver, "Expected Result is : Future should be  selected || Actual Result is : Future is selected ", test, test1);
							}

							Step_End(6,
									"If the Future voyages of the phased out vessel should be replaced by the phase in vessel",
									test, test1);
							Step_End(7, "Choose Future Cycle ", test, test1);

							Step_Start(8, "If Only the current voyage should be phased out and phased in ", test, test1);
							Step_Start(9, "Choose Current Cycle ", test, test1);
							// selecting current
							if (Future_Perform.equals("NO")) {
								waitForElement(driver, Selec_current_butn);
								safeclick(driver, Selec_current_butn);
								System.out.println("Expected Result is : current should be selected || Actual Result is : current is selected ");
								Extent_pass_New(driver, "Expected Result is : current should be selected || Actual Result is : current is selected ", test, test1);
							}
							Step_End(8, "If Only the current voyage should be phased out and phased in ", test, test1);
							Step_Start(9, "Choose Current Cycle ", test, test1);
							Step_Start(5, ".Choose the Vessel that to be phased in(Actual, TBN,Blank)", test, test1);
							if (Add_Vessels_Perform.equals("YES")) {
								if (Add_Vessels_Perform.equals("YES")) {
									waitForElement(driver, searchswap);
									safeclick(driver, searchswap);
									twoColumnSearchWindow(driver, Add_Vessel_Code_Header, Condition_Filter, Add_Vessels);

									Extent_pass_New(driver, "Vessels was selected as" + Add_Vessels, test, test1);
									Step_Start(10, "Click on Ok button ", test, test1);
									waitForElement(driver, searchswapok);
									safeclick(driver, searchswapok);
									Step_End(10, "Click on Ok button ", test, test1);

									scrollBottom(driver);

									Extent_pass_New(driver, "Expected Result is : Vessel should be added as " + Add_Vessels+" || Actual result is : Vessel should be added as "+ Add_Vessels, test, test1);

								} else {
									System.out.println("Expected Result is : Vessel should not be selected || Actual Result is : Vessel is not selected");
									Extent_fail(driver, "Expected Result is : Vessel should not be selected || Actual Result is : Vessel is not selected" + Add_Vessels, test, test1);

								}
							}
							if (Add_TBN_Vessels_Perform.equals("YES")) {
								if (Add_TBN_Vessels_Perform.equals("YES")) {
									waitForElement(driver, TBMradiobtnclickphase);
									safeclick(driver, TBMradiobtnclickphase);
									Extent_pass_New(driver, "***Port was selected as TBN***", test, test1);
									Step_Start(10, "Click on Ok button ", test, test1);
									waitForElement(driver, searchswapok);
									safeclick(driver, searchswapok);
									Step_End(10, "Click on Ok button ", test, test1);

									scrollBottom(driver);

									horizontalscroll(driver, scroll_LT, 1000);
									Extent_pass_New(driver, "Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is added as [TBN]", test, test1);
								} else {
									System.out.println("Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is not added as [TBN]");
									Extent_fail(driver, "Expected Result is : Vessel should be added as [TBN] || Actual Result is :Vessel is not added as [TBN]", test, test1);
								}
							}

							if (Add_Empty_Vessels_Perform.equals("YES")) {
								if (Add_Empty_Vessels_Perform.equals("YES")) {
									waitForElement(driver, blankRadioButtonphase);
									safeclick(driver, blankRadioButtonphase);
									Step_Start(10, "Click on Ok button ", test, test1);
									waitForElement(driver, searchswapok);
									safeclick(driver, searchswapok);
									Step_End(10, "Click on Ok button ", test, test1);

									scrollBottom(driver);

									horizontalscroll(driver, scroll_LT, 1000);
									Extent_pass_New(driver, "Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is added as Empty Vessel", test, test1);

								} else {
									System.out.println("Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is not added as Empty Vessel");
									Extent_fail(driver, "Expected Result is : Vessel should be added as Empty Vessel || Actual Result is :Vessel is not added as Empty Vessel", test, test1);
								}
							}
							Step_End(5, ".Choose the Vessel that to be phased in(Actual, TBN,Blank)", test, test1);

							waitForElement(driver, popup_Message);
							String Swappop = getText(driver, popup_Message);
							System.out.println(Swappop);
							Step_Start(11,
									"Now the System should add the phased in vessel next to the phased out vessel , and removing the ports after the ports which we phased out and those port should be added in the phased in vessel ",
									test, test1);
							Extent_pass_New(driver, "*****Valiadtion afrer swap was show added as****" + Swappop, test, test1);

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							scrollBottom(driver);
							horizontalscroll(driver, scroll_LT, 500);

							Extent_pass_New(driver, "****The vessels add the phased in vessel next to the phased out vessel***",
									test, test1);

							Step_End(11,
									"Now the System should add the phased in vessel next to the phased out vessel , and removing the ports after the ports which we phased out and those port should be added in the phased in vessel ",
									test, test1);

						
							String next_port_Date1 = String.format(next_p, Port_Name, i);
							click(driver, next_port_Date1);

							RightClick(driver, next_port_Date1);

							mouseOverToElement(driver, AdjustTime);
							waitForElement(driver, AdjustTime1);
							safeclick(driver, AdjustTime1);
							waitForPopup(driver, P_Long_Term_ArrPilot_Adjust, text);
							String timeafer = getText(driver, P_Long_Term_ArrPilot_Adjust);
							System.out.println(timeafer);

							if (text.equals(timeafer)) {
								System.out.println("Matched || " + " Expected Activity is : " + text
										+ " || Actual Activity is : " + timeafer);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + text
										+ " || Actual Activity is : " + timeafer, test, test1);

							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + text
										+ " || Actual Activity is : " + timeafer);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + text
										+ " || Actual Activity is : " + timeafer, test, test1);
							}
							Extent_pass_New(driver, "*****Date should be same before swap and after swap** **", test, test1);

							waitForElement(driver, Closeadjesttime);
							safeclick(driver, Closeadjesttime);

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

		scrollTop(driver);

		click(driver, Close_Current_tab);
		
		int LT17 = 17;

		if (LT17 == 17) {
			String testcase_Name = "TC_Long_Term_Creation_LT17";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String selected_vessels_Perform = data.get("selected_vessels_Perform");
			String selected_vessels_input = data.get("selected_vessels_input");
			String cycle_checkbox_perform = data.get("cycle_checkbox_perform");
			String Date_checkbox_perform = data.get("Date_checkbox_perform");
			String voyage_checkbox_perform = data.get("voyage_checkbox_perform");
			String show_all_cells_checkbox_perform = data.get("show_all_cells_checkbox_perform");
			String show_draft_cells_checkbox_perform = data.get("show_draft_cells_checkbox_perform");
			String show_conform_cells_checkbox_perform = data.get("show_conform_cells_checkbox_perform");
			String show_Actual_conform_cells_checkbox_perform = data.get("show_Actual_conform_cells_checkbox_perform");
			String show_omitted_cells_checkbox_perform = data.get("show_omitted_cells_checkbox_perform");
			String To_cycle_input = data.get("To_cycle_input");
			String From_cycle_input = data.get("From_cycle_input");
			String From_Date_Input = data.get("From_Date_Input");
			String To_Date_Input = data.get("To_Date_Input");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("From_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String Future_Vessels_Perform = data.get("Future_Vessels_Perform");
			String Change_call_type_Perform = data.get("Change_call_type_Perform");
			String Cell_Type_Changed_Pop_Exp = data.get("Cell_Type_Changed_Pop_Exp");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");

			String port_name_list = null;
			String claa_type_list = null;

			Extent_Start(testcase_Name, test, test1);

			// searching for module

			moduleNavigate(driver, Search);

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
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
			click(driver, LongTermsearchOk);

			Step_Start(2, "Retirve the Record via Global Search  ", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			waitForElement(driver, Edit_Button_toolBar);
			Step_End(2, "Retirve the Record via Global Search  ", test, test1);

			scrollBottom(driver);

	               try {
	       			waitForElement(driver, vessels_code);

				List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
				for (WebElement Vessel_Code : vessel_Codes) {

					if (Vessels_Code.equals(Vessel_Code.getText())) {
						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);
						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							String port_Date = String.format(port_Date_17, Port_Name, i);
							Step_Start(3,
									"Right click on the port of the voyage which needed to be changing the call type  ",
									test, test1);

							RightClick(driver, port_Date);
							Step_End(3, "Right click on the port of the voyage which needed to be changing the call type  ",
									test, test1);

							waitForElement(driver, MoreOptions);
							click(driver, MoreOptions);
							Step_Start(4, "Choose Change Call Type option  ", test, test1);
							waitForElement(driver, MoreOptionsedit);
							click(driver, MoreOptionsedit);
							waitForElement(driver, MoreOptionseditselectall);
							click(driver, MoreOptionseditselectall);

							waitForElement(driver, MoreOptionseditselectallsave);
							click(driver, MoreOptionseditselectallsave);
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);

							String port_Date1 = String.format(port_Date_17, Port_Name, i);
							click(driver, port_Date1);

							RightClick(driver, port_Date1);

							waitForElement(driver, Changecelltype);
							click(driver, Changecelltype);
							Step_End(4, "Choose Change Call Type option  ", test, test1);
							Step_Start(6,
									"Choose Current voyage if the call Type should only affect the current port in the current voyage  ",
									test, test1);
							if (Future_Vessels_Perform.equals("NO")) {
								waitForElement(driver, current_voyage);
								click(driver, current_voyage);
								System.out.println("Expected Result is : current should be selected || Actual Result is : current is  selected");
							} else {
								System.out.println("Expected Result is : current should be selected || Actual Result is : current is  not selected");
							}
							Step_End(6,
									"Choose Current voyage if the call Type should only affect the current port in the current voyage  ",
									test, test1);

							Step_Start(5,
									"Choose Future voyages if the Call type of the port should be applied to future voyages of the same port in the same vessel  ",
									test, test1);
							if (Future_Vessels_Perform.equals("YES")) {
								System.out.println("Expected Result is : Future should be selected || Actual Result is : Future is selected");
							} else {
								System.out.println("Expected Result is : Future should be selected || Actual Result is : Future is not selected");
							}

							Step_End(5,
									"Choose Future voyages if the Call type of the port should be applied to future voyages of the same port in the same vessel  ",
									test, test1);

							Step_Start(7, "Choose the Call to be Changed from Commercial/Physical/Canal ", test, test1);
							String calltype_Select = String.format(call_type, Change_call_type_Perform);


							
							click(driver, calltype_Select);
							
							
							waitForPopup(driver, popup_Message, Cell_Type_Changed_Pop_Exp);
							Step_Start(8, "System should show pop up as”Call type changed”", test, test1);
							String call_type_changed_pop_act1 = getText(driver, popup_Message);
							System.out.println(call_type_changed_pop_act1);
							if (Cell_Type_Changed_Pop_Exp.equals(call_type_changed_pop_act1)) {
								System.out.println("Matched || " + " Expected Activity is : " + Cell_Type_Changed_Pop_Exp
										+ " || Actual Activity is : " + call_type_changed_pop_act1);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Cell_Type_Changed_Pop_Exp
										+ " || Actual Activity is : " + call_type_changed_pop_act1, test, test1);
								Extent_pass_New(driver, "***Cell type was changed***" + Change_call_type_Perform, test, test1);
							} else {
								System.out
										.println("Not matched || " + " Expected Activity is : " + Cell_Type_Changed_Pop_Exp
												+ " || Actual Activity is : " + call_type_changed_pop_act1);
								Extent_fail(driver,
										"Not matched || " + " Expected Activity is : " + Cell_Type_Changed_Pop_Exp
												+ " || Actual Activity is : " + call_type_changed_pop_act1,
										test, test1);
							}
							Step_End(8, "System should show pop up as”Call type changed”", test, test1);
							waitForElement(driver, popup_Message_Ok_Button);
							click(driver, popup_Message_Ok_Button);
							Step_End(7, "Choose the Call to be Changed from Commercial/Physical/Canal ", test, test1);

							String port_Date11 = String.format(port_Date_17, Port_Name, i);
							click(driver, port_Date11);

							RightClick(driver, port_Date11);

							waitForElement(driver, AdjustTime);
							mouseOverToElement(driver, AdjustTime);
							click(driver, AdjustTime1);
							List<String> port_name_li = new ArrayList<>();

							List<WebElement> port_name = listOfElements(driver, portname);
							for (WebElement port_names : port_name) {

								port_name_list = getText1(driver, port_names);
								port_name_li.add(port_name_list);
								System.out.println(port_name_li);
								Extent_Pass(driver, port_name_li, test, test1);

							}

							horizontalscroll(driver, Scroll_1, 4500);
							List<String> port_name_li1 = new ArrayList<>();

							List<WebElement> call_type = listOfElements(driver, calltype);
							for (WebElement call_types : call_type) {

								claa_type_list = getText1(driver, call_types);
								port_name_li1.add(claa_type_list);
								System.out.println(port_name_li1);
							}

							Step_Start(9, "If the port call is canal , the the port date should be in “Italic” style”",
									test, test1);
							if (Change_call_type_Perform.equals("Change Commercial to Canal")) {

								horizontalscroll(driver, Scroll_1, 6000);
								List<String> port_name_li11 = new ArrayList<>();

								List<WebElement> call_type1 = listOfElements(driver, caneltype);
								for (WebElement call_types : call_type1) {

									String claa_type_list1 = getText1(driver, call_types);
									port_name_li11.add(claa_type_list1);
									System.out.println(port_name_li11);
								}
							}
							Step_End(9, "If the port call is canal , the the port date should be in “Italic” style”", test,
									test1);
							if (Change_call_type_Perform.equals("Change Physical to Canal")) {

								horizontalscroll(driver, Scroll_1, 6000);
								List<String> port_name_li11 = new ArrayList<>();

								List<WebElement> call_type11 = listOfElements(driver, caneltype);
								for (WebElement call_types : call_type11) {

									String claa_type_list1 = getText1(driver, call_types);
									port_name_li11.add(claa_type_list1);
									System.out.println(port_name_li11);

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
}
