package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_Long_Term_Creation_LT02 extends Keywords {

	int i;

	public void copypastvoyage(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT02";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Add_Vessels_Perform = Excel_data.get("Add_Vessels_Perform");
		String Add_TBN_Vessels_Perform = Excel_data.get("Add_TBN_Vessels_Perform");
		String Add_Empty_Vessels_Perform = Excel_data.get("Add_Empty_Vessels_Perform");
		String Add_Vessels = Excel_data.get("Add_Vessels");
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
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header = Excel_data.get("From_Voyage_Number_Header");
		String To_Voyage_Number_Header = Excel_data.get("To_Voyage_Number_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Add_Vessel_Code_Header = Excel_data.get("Add_Vessel_Code_Header");
		String date_Picker = Excel_data.get("date_Picker");
		
		
		
		String ReferenceType_Select1_d = String.format(ReferenceType_Select1, Voyage_Number);
		String ReferenceType_Select2_d = String.format(ReferenceType_Select2, Voyage_Number);
		String ReferenceType_Select3_d = String.format(ReferenceType_Select3, copy_Voyage_Number);

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
		
		
		// Selecting the From Date

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
			i = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

			for (WebElement Vessel_Code : vessel_Codes) {
				System.out.println("i : " + i);
				waitForElement(driver, Vessel_Code);

				Click(driver, Vessel_Code);

				if (Vessels_Code.equals(Vessel_Code.getText())) {
					String num = String.valueOf(i);
					String voyage_Num = String.format(voyage_Num_l, num);

					System.out.println(getText(driver, voyage_Num));
					System.out.println(Voyage_Number);
					System.out.println(voyage_Num);
					if (Voyage_Number.equals(getText(driver, voyage_Num))) {

						click(driver, voyage_Num);

						waitForElement(driver, voyage_Num);

						RightClick(driver, voyage_Num);

						// Adding vessels
						waitForDisplay(driver, optionsBox);
						if (isDisplayed(driver, optionsBox)) {
							System.out.println("The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is displayed");
							Extent_pass_New(driver, "The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is displayed", test, test1);
							scrollUsingElement(driver, renameLT);
							mouseOverToElement(driver, renameLT);
						} else {
							System.out.println("The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is not displayed");
							Extent_fail(driver, "The expected Result is : Once user right click on the voyage, options Menu bar should be displayed || Acutal result is : Once user right click on the voyage, options Menu bar is not displayed", test, test1);

						}

						waitForDisplay(driver, addVessel);
						if (isDisplayed(driver, addVessel)) {
							System.out.println("The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar should be displayed");
							Extent_pass_New(driver, "The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar should be displayed", test, test1);
							safeclick(driver, addVessel);
						} else {
							System.out.println("The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar is not displayed");
							Extent_fail(driver, "The expected Result is : Once user mousehover on the rename option, options sub Menu bar should be displayed || Acutal result is : Once user mousehover on the rename option, options sub Menu bar is not displayed", test, test1);

						}

						if (Add_Vessels_Perform.equals("YES")) {
							if (Add_Vessels_Perform.equals("YES")) {
								waitForElement(driver, Addvesseslssearch);
								safeclick(driver, Addvesseslssearch);
								twoColumnSearchWindow(driver, Add_Vessel_Code_Header, Condition_Filter, Add_Vessels);
                                System.out.println("Expected Result: Vessel should be selected as  " + Add_Vessels + "|| Actual Result: Vessel selected as "+ Add_Vessels);
								Extent_pass_New(driver, "Expected Result: Vessel should be selected as  " + Add_Vessels + "|| Actual Result: Vessel selected as "+ Add_Vessels, test, test1);
								waitForElement(driver, select);
								safeclick(driver, select);
								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);

								scrollBottom(driver);
								waitForElement(driver, ReferenceType_Select1_d);
								click(driver, ReferenceType_Select1_d);
								System.out.println("Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is added as "+ Add_Vessels);
								Extent_pass_New(driver, "Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is added as "+ Add_Vessels, test, test1);

							} else {
								System.out.println("Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is not added as "+ Add_Vessels);
								Extent_fail(driver, "Expected Result :Vessels should be added as "+ Add_Vessels +" || Actual Result : Vessel is not added as "+ Add_Vessels, test, test1);

							}
						}
						if (Add_TBN_Vessels_Perform.equals("YES")) {
							if (Add_TBN_Vessels_Perform.equals("YES")) {
								waitForElement(driver, TBMradiobtnclick);
								safeclick(driver, TBMradiobtnclick);
								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);
								waitForElement(driver, ReferenceType_Select1_d);
								click(driver, ReferenceType_Select1_d);
								System.out.println("Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is added as [TBN] ");
								Extent_pass_New(driver, "Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is added as [TBN] ", test, test1);
							} else {
								System.out.println("Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is not added as [TBN] ");
								Extent_fail(driver, "Expected Result: Vessel should be added as [TBN]  || Actual Result: Vessel is not added as [TBN] ", test, test1);
							}
						}

						if (Add_Empty_Vessels_Perform.equals("YES")) {
							if (Add_Empty_Vessels_Perform.equals("YES")) {
								waitForElement(driver, blankRadioButton);
								safeclick(driver, blankRadioButton);
								Extent_pass_New(driver, "*******Vessels was selected as [Empty vessels]***", test, test1);
								waitForElement(driver, vesselRenameOkButton);
								safeclick(driver, vesselRenameOkButton);

								scrollBottom(driver);
								waitForElement(driver, ReferenceType_Select2_d);
								click(driver, ReferenceType_Select2_d);


							} else {
								System.out.println("Expected Result is : Blank Vessel should not selected || Actual Result is : Blank Vessel is not selected");
								Extent_fail(driver, "Expected Result is : Blank Vessel should not added as [Empty Vessel] || Actual Result is : Blank Vessel is not added as [Empty Vessel]", test, test1);
							}
						}

						// copy the vessels
						Step_Start(3, "Click on the Voyage which needed to be copied(Draft/Confirmed)", test, test1);

						Step_Start(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
						waitForElement(driver, ReferenceType_Select3_d);
						click(driver, ReferenceType_Select3_d);

						RightClick(driver, ReferenceType_Select3_d);

						Step_End(4, "Right click on the Added or Blank Vessel without the voyage ", test, test1);
						if (isDisplayed(driver, optionsBox)) {
							System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed");
							Extent_pass_New(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is displayed", test, test1);
							scrollUsingElement(driver, cutCopyPasteRemove);
							Step_Start(5, "Choose Cut/Copy/Paste From the menu", test, test1);
							mouseOverToElement(driver, cutCopyPasteRemove);
						} else {
							System.out.println("The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed");
							Extent_fail(driver, "The expected Result is : Once user right click on the added or blank vessel, options Menu bar should be displayed || Acutal result is : Once user right click on the added or blank vessel, options Menu bar is not displayed", test, test1);
						}
						Step_End(5, "Choose Cut/Copy/Paste From the menu", test, test1);

						if (isDisplayed(driver, subMenuCopyPaste)) {
							System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed");
							Extent_pass_New(driver, "The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is displayed", test, test1);
							Step_Start(6, "Choose Paste option ", test, test1);
							waitForElement(driver, copyInSubMenu);
							safeclick(driver, copyInSubMenu);
						} else {
							System.out.println("The expected Result is : Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar should be displayed || Acutal result is : Once user Once user Choose Cut/Copy/Paste From the menu, Options Sub Menu bar is not displayed");
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

						click(driver, ReferenceType_Select1_d);

						RightClick(driver, ReferenceType_Select1_d);
						waitForDisplay(driver, optionsBox);

						if (isDisplayed(driver, optionsBox)) {
							System.out.println("The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is displayed");
							Extent_pass_New(driver, "The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is displayed", test, test1);
							scrollUsingElement(driver, cutCopyPasteRemove);
							mouseOverToElement(driver, cutCopyPasteRemove);
						} else {
							System.out.println("The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is not displayed");
							Extent_fail(driver, "The expected Result is : Once user right click on the Voyage options Menu bar should be displayed || Acutal result is : Once user right click on the Voyage Options Menu bar is  not displayed", test, test1);
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

						Step_Start(7, ".Now the copied voyage will be pasted on the vessel", test, test1);

						Step_Start(8, "System should show validation “Voyage Pasted”", test, test1);
						waitForPopup(driver, popup_Message, Past_Pop_Exp);
						String pastedpopact = getText(driver, popup_Message);
						System.out.println(pastedpopact);
						if (Past_Pop_Exp.equals(pastedpopact)) {
							System.out.println("Matched || " + " Expected Popup is : " + Past_Pop_Exp
									+ " || Actual Popup is : " + pastedpopact);
							Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Past_Pop_Exp
									+ " || Actual Popup is : " + pastedpopact, test, test1);
						} else {
							System.out.println("Not matched || " + " Expected Popup is : " + Past_Pop_Exp
									+ " || Actual Popup is : " + pastedpopact);
							Extent_fail(driver, "Not matched || " + " Expected Popup is : " + Past_Pop_Exp
									+ " || Actual Popup is : " + pastedpopact, test, test1);

						}
						safeclick(driver, popup_Message_Ok_Button);
						waitForElement(driver, ReferenceType_Select1_d);
						click(driver, ReferenceType_Select1_d);

						System.out.println("Expected Result is: Voyage should be pasted as "+ copy_Voyage_Number + " || Actual Result is : Voyage is pasted as "+ copy_Voyage_Number);
						Extent_pass_New(driver, "Expected Result is: Voyage should be pasted as "+ copy_Voyage_Number + " || Actual Result is : Voyage is pasted as "+ copy_Voyage_Number, test, test1);

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