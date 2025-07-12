package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT05 extends Keywords {

	public void renamingvoyage(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT05";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Future_Renamed_Pop_Exp = Excel_data.get("Future_Renamed_Pop_Exp");
		String Current_Renamed_Pop_Exp = Excel_data.get("Current_Renamed_Pop_Exp");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Voyage_number_input = Excel_data.get("Voyage_number_input");
		String Increment_pivot_1 = Excel_data.get("Increment_pivot_1");
		String Pivot_Voyage_1 = Excel_data.get("Pivot_Voyage_1");
		String Pivot_Voyage_2 = Excel_data.get("Pivot_Voyage_2");
		String Pivot_Voyage_3 = Excel_data.get("Pivot_Voyage_3");
		String Increment_number_voyage_input_1 = Excel_data.get("Increment_number_voyage_input_1");
		String Increment_number_voyage_input_2 = Excel_data.get("Increment_number_voyage_input_2");
		String Future_Rename_Perform = Excel_data.get("Future_Rename_Perform");
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
		String Pivot_Voyage_perform = Excel_data.get("Pivot_Voyage_perform");
		String Head_Voyage_perform = Excel_data.get("Head_Voyage_perform");
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		// searching for module

		moduleNavigate(driver, Search);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		Step_Start(1, "Retirve the Record via Global Search ", test, test1);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		Step_End(1, "Retirve the Record via Global Search  ", test, test1);
		Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

		Step_End(2, "Enter the Service Code in the Service Code field", test, test1);
		Step_Start(3, "Click on Ok button ", test, test1);

		Step_End(3, "Click on Ok button  ", test, test1);

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

		Step_Start(4, "Click on edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Edit_Button_toolBar);
		Step_End(4, "Click on edit button ", test, test1);
		scrollBottom(driver);
		// renaming vessels

		Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);
		List<String> beforename = new ArrayList<>();
		int i = 1;
		waitForElement(driver, vessels_code);

		List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
		for (WebElement vessel_Code : vessel_Codes) {

			if (vessel_Code.getText().equals(Vessels_Code)) {

				String num = String.valueOf(i);
				String voyagenumbers = String.format(voyage_Num_l, num);

				String Before = getText(driver, voyagenumbers);
				System.out.println(Before);
				beforename.add(Before);
			}
			i++;

		}

		try {
			int i1 = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
			for (WebElement Vessel_Code : vessel_Codes1) {

				if (Vessels_Code.equals(Vessel_Code.getText())) {

					String num = String.valueOf(i1);
					String voyage_Num = String.format(voyage_Num_l, num);

					if (Voyage_Number.equals(getText(driver, voyage_Num))) {
						click(driver, voyage_Num);

						RightClick(driver, voyage_Num);
						Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ", test, test1);
						Step_Start(6, "Choose Add/Rename Option", test, test1);
						scrollUsingElement(driver, renameLT);
						waitForElement(driver, renameLT);
						mouseOverToElement(driver, renameLT);
						Step_Start(7, "Choose Rename Voyage Option from the sub menu )", test, test1);
						safeclick(driver, renameVoyage);

						waitForElement(driver, renameVoyageFrame);
						Step_End(6, "Choose Add/Rename Option ", test, test1);
						Step_End(7, "Choose Rename Voyage Option from the sub menu  ", test, test1);

						Step_Start(8, "System should show a dialog box )", test, test1);
						if (isDisplayed(driver, renameVoyageFrame)) {
							System.out.println("The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is displayed");
							Extent_pass_New(driver, "The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is displayed", test, test1);

						} else {
							System.out.println("The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is not displayed");
							Extent_fail(driver, "The expected Result is : Once user select rename option. rename voyage frame should be displayed || Acutal result is : Once user select rename option. rename voyage frame is not displayed", test, test1);

						}

						Step_Start(16,
								"Choose if only the Head Voyage should be updated. Uncheck the Pivot voyage check box"
										+ ")",
								test, test1);
						Step_Start(17,
								"Choose if only the Pivot Voyage should be updated. Uncheck the Head voyage check box"
										+ ")",
								test, test1);
						waitForElement(driver, voyageNumberTextField);
						safeclick(driver, voyageNumberTextField);
						checkBox(driver, headVoyageCheckBox_l, Head_Voyage_perform);
						checkBox(driver, pivotVoyageCheckBox_l, Pivot_Voyage_perform);

						Step_End(16,
								"Choose if only the Head Voyage should be updated. Uncheck the Pivot voyage check box"
										+ ")",
								test, test1);
						Step_End(17,
								"Choose if only the Pivot Voyage should be updated. Uncheck the Head voyage check box"
										+ ")",
								test, test1);

						Step_End(8, "System should show a dialog box )", test, test1);
						Step_Start(9, "Enter the Voyage Number and the Increment Value ", test, test1);
						// Voyage number input
						if (!Voyage_number_input.equals("")) {
							waitForElement(driver, voyageNumberTextField);
							sendKeys(driver, voyageNumberTextField, Voyage_number_input);
						}

						// Incremet Voyage number input
						if (!Increment_pivot_1.equals("")) {
							waitForElement(driver, incrementVoyageTextField);
							sendKeys(driver, incrementVoyageTextField, Increment_pivot_1);
						}

						// Pivot Voyage_1 number input
						if (!Pivot_Voyage_1.equals("")) {
							waitForElement(driver, pivotVoyage_1_l);
							sendKeys(driver, pivotVoyage_1_l, Pivot_Voyage_1);
						}
						// Pivot Voyage_2 number input
						if (!Pivot_Voyage_2.equals("")) {
							waitForElement(driver, PIVOT_VOYAGE_2);
							sendKeys(driver, PIVOT_VOYAGE_2, Pivot_Voyage_2);
						}
						// Pivot Voyage_3 number input
						if (!Pivot_Voyage_3.equals("")) {
							waitForElement(driver, PIVOT_VOYAGE_3);
							sendKeys(driver, PIVOT_VOYAGE_3, Pivot_Voyage_3);
						}

						// Increment Pivot_1 number input
						if (!Increment_number_voyage_input_1.equals("")) {
							waitForElement(driver, incrementPivot1_l);
							sendKeys(driver, incrementPivot1_l, Increment_number_voyage_input_1);
						}

						// Increment Pivot_2 number input
						if (!Increment_number_voyage_input_2.equals("")) {
							waitForElement(driver, Increment_pivot_2);
							sendKeys(driver, Increment_pivot_2, Increment_number_voyage_input_2);
						}

						// Increment Pivot_3 number input
						if (!Increment_number_voyage_input_1.equals("")) {
							waitForElement(driver, Increment_pivot_3);
							sendKeys(driver, Increment_pivot_3, Increment_number_voyage_input_1);
						}

						Step_End(9, "Enter the Voyage Number and the Increment Value ", test, test1);
						Step_Start(10,
								"Choose Whether the Renaming of the voyage should affect the future cycles of the vessel",
								test, test1);
						if (Future_Rename_Perform.equals("YES")) {
							if (Future_Rename_Perform.equals("YES")) {
								Step_Start(11, "Choose Future Voyages ", test, test1);
								Step_Start(12, "Click on ok ", test, test1);
								waitForElement(driver, renameVoyageFrameOk);
								safeclick(driver, renameVoyageFrameOk);
								Step_End(11, "Choose Future Voyages ", test, test1);
								Step_End(12, "Click on ok ", test, test1);
								waitForPopup(driver, popup_Message, Future_Renamed_Pop_Exp);
								String Future_Rename_Pop_Act_TBN = getText(driver, popup_Message);
								System.out.println(Future_Rename_Pop_Act_TBN);
								Step_Start(18, "Now system should show a validation “Voyage Updated", test, test1);

								if (Future_Renamed_Pop_Exp.equals(Future_Rename_Pop_Act_TBN)) {
									System.out
											.println("Matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN,
											test, test1);
								} else {
									System.out.println(
											"Not matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is : " + Future_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Future_Rename_Pop_Act_TBN,
											test, test1);

								}
								Step_End(18, "Now system should show a validation “Voyage Updated", test, test1);
								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);
							}
						}
						Step_End(10,
								"Choose Whether the Renaming of the voyage should affect the future cycles of the vessel",
								test, test1);
						Step_Start(13,
								"Choose Whether the Renaming of the voyage should affect on the current cycle of the vessel",
								test, test1);
						if (Future_Rename_Perform.equals("NO")) {
							if (Future_Rename_Perform.equals("NO")) {
								Step_Start(14, "Choose current Voyages ", test, test1);
								Step_Start(15, "Click on ok ", test, test1);
								waitForElement(driver, current_voyage);
								safeclick(driver, current_voyage);
								waitForElement(driver, renameVoyageFrameOk);
								safeclick(driver, renameVoyageFrameOk);
								Step_End(14, "Choose current Voyages ", test, test1);
								Step_End(15, "Click on ok ", test, test1);
								Step_Start(18, "Now system should show a validation “Voyage Updated", test, test1);

								waitForPopup(driver, popup_Message, Current_Renamed_Pop_Exp);
								String Current_Rename_Pop_Act = getText(driver, popup_Message);
								System.out.println(Current_Rename_Pop_Act);

								if (Current_Renamed_Pop_Exp.equals(Current_Rename_Pop_Act)) {
									System.out.println(
											"Matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Current_Rename_Pop_Act);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Current_Rename_Pop_Act,
											test, test1);
								} else {
									System.out.println(
											"Not matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Current_Rename_Pop_Act);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is : " + Current_Renamed_Pop_Exp
													+ " || Actual Activity is : " + Current_Rename_Pop_Act,
											test, test1);

								}
								Step_End(18, "Now system should show a validation “Voyage Updated", test, test1);
								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);
								Step_End(13,
										"Choose Whether the Renaming of the voyage should affect on the current cycle of the vessel",
										test, test1);
							}

						}

						break;

					}
				}

				i1++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}
		List<String> Afterrename = new ArrayList<>();

		try {

			int i1 = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
			for (WebElement vessel_Code : vessel_Codes1) {

				if (vessel_Code.getText().equals(Vessels_Code)) {

					String num = String.valueOf(i1);
					String voyagenumbers = String.format(voyage_Num_l, num);
					String After = getText(driver, voyagenumbers);
					System.out.println(After);
					Afterrename.add(After);
				}
				i1++;

			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}

		if (beforename.equals(Afterrename)) {
			System.out.println("Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ Afterrename);
			Extent_fail(driver,
					"Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ Afterrename,
					test, test1);

		} else {

			System.out.println("Not Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name not  changed as "+ Afterrename);
			Extent_pass_New(driver, "Not Matched || The expected Result is : Once user before Renaming  the voyage , vessel name is "+ beforename+ "|| Acutal result is : Once user after Renaming  the vessel , vessel name not  changed as "+ Afterrename, test, test1);

		}
		Extent_completed(testcase_Name, test, test1);
	}
}
