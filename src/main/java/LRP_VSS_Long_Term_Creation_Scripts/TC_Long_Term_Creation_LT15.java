package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT15 extends Keywords {
	public void proformarefresh(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT15";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Vessels_Code = Excel_data.get("Vessels_Code");
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
		String All_proforma_check_box = Excel_data.get("All_proforma_check_box");
		String Add_new_proforma_code = Excel_data.get("Add_new_proforma_code");
		String proforma_code_input = Excel_data.get("proforma_code_input");
		String start_Date = Excel_data.get("start_Date");
		String All_cycles_perform = Excel_data.get("All_cycles_perform");
		String selected_cycle_perform = Excel_data.get("selected_cycle_perform");
		String Future_cycle_perform = Excel_data.get("Future_cycle_perform");
		String cycles_input_selected = Excel_data.get("cycles_input_selected");
		String Long_Term_Updated_Pop = Excel_data.get("Long_Term_Updated_Pop");
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Proforma_code_Header  = Excel_data.get("Proforma_code_Header");
		String Cycle_No_Header  = Excel_data.get("Cycle_No_Header");



		String Updated_pop_act = null;

		Extent_Start(testcase_Name, test, test1);


		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
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
}
