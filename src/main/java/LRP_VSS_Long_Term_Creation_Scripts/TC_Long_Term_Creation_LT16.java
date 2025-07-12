package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT16 extends Keywords {

	int i;

	public void PhaseOutin(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT16";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Add_Vessels_Perform = Excel_data.get("Add_Vessels_Perform");
		String Add_TBN_Vessels_Perform = Excel_data.get("Add_TBN_Vessels_Perform");
		String Add_Empty_Vessels_Perform = Excel_data.get("Add_Empty_Vessels_Perform");
		String Add_Vessels = Excel_data.get("Add_Vessels");
		String Port_Name = Excel_data.get("Port_Name");
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
		String To_voyage_Input = Excel_data.get("From_voyage_Input");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Future_Perform = Excel_data.get("Future_Perform");
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Add_Vessel_Code_Header  = Excel_data.get("Add_Vessel_Code_Header");
		
		
		
		int rownum = 0;

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
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
}
