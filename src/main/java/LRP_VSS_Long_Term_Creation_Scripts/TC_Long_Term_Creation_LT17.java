package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT17 extends Keywords {

	int i = 1;

	public void changecelltype(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT17";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
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
		String Future_Vessels_Perform = Excel_data.get("Future_Vessels_Perform");
		String Change_call_type_Perform = Excel_data.get("Change_call_type_Perform");
		String Cell_Type_Changed_Pop_Exp = Excel_data.get("Cell_Type_Changed_Pop_Exp");
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");

		String port_name_list = null;
		String claa_type_list = null;

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
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
