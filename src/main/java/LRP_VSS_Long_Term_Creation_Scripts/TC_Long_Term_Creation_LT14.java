package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT14 extends Keywords {

	public void copypastvoyage(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT14";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String copy_Voyage_Number = Excel_data.get("Copy_Voyage");
		String Copy_pop_exp = Excel_data.get("Copy_pop_exp");
		String Past_Pop_Exp = Excel_data.get("Past_Pop_Exp");
		String selected_vessels_Perform = Excel_data.get("selected_vessels_Perform");
		String selected_vessels_input = Excel_data.get("selected_vessels_input");
		String cycle_checkbox_perform = Excel_data.get("cycle_checkbox_perform");
		String Date_checkbox_perform = Excel_data.get("Date_checkbox_perform");
		String voyage_checkbox_perform = Excel_data.get("voyage_checkbox_perform");
		String show_all_cells_checkbox_perform = Excel_data.get("show_all_cells_checkbox_perform");
		String show_draft_cells_checkbox_perform = Excel_data.get("show_draft_cells_checkbox_perform");
		String show_conform_cells_checkbox_perform = Excel_data.get("show_conform_cells_checkbox_perform");
		String show_Actual_conform_cells_checkbox_perform = Excel_data.get("show_Actual_conform_cells_checkbox_perform");
		String show_omitted_cells_checkbox_perform = Excel_data.get("show_omitted_cells_checkbox_perform");
		String To_cycle_input = Excel_data.get("To_cycle_input");
		String From_cycle_input = Excel_data.get("From_cycle_input");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String To_voyage_perform = Excel_data.get("To_voyage_perform");
		String From_Voyage_Perform = Excel_data.get("From_Voyage_Perform");
		String From_voyage_Input = Excel_data.get("From_voyage_Input");
		String To_voyage_Input = Excel_data.get("To_voyage_Input");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Cycle_No = Excel_data.get("Cycle_No");
		String Pivot_Voyage_1 = Excel_data.get("Pivot_Voyage_1");
		String Voyage_No = Excel_data.get("Voyage_No");
		String Pivot_Voyage_2 = Excel_data.get("Pivot_Voyage_2");
		String Pivot_Voyage_3 = Excel_data.get("Pivot_Voyage_3");
		String Arrival_Pilot_Date_Input = Excel_data.get("Arrival_Pilot_Date_Input");



		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
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
}
