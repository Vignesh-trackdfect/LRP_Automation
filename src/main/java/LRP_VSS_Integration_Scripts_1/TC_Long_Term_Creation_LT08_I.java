package LRP_VSS_Integration_Scripts_1;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT08_I extends Keywords {

	public void renameterminal(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name = "TC_Long_Term_Creation_LT08_I";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Port_Name = Excel_data.get("Port_Name");
		String Rename_Terminal = Excel_data.get("Rename_Terminal");
		String Future_Terminal = Excel_data.get("Future_Terminal");
		String Rename_Terminal_pop_future = Excel_data.get("Rename_Terminal_pop_future");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Rename_Terminal_pop_Current = Excel_data.get("Rename_Terminal_pop_Current");
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
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Terminal_Code_Header  = Excel_data.get("Terminal_Code_Header");
		
		
		String text = null;
		int rownum = 0;
		String caps = null;
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		
		// Verify the terminal
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, Search);

		Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		Step_End(1, "Retirve the Record via Global Search  ", test, test1);
		Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
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

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Edit_Button_toolBar);

		scrollBottom(driver);
		// renaming vessels

		Step_Start(4, "Right Click on the port field in the voyage )", test, test1);

		try {
			int i = 1;
			waitForElement(driver, vessels_code);


			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
			for (WebElement Vessel_Code : vessel_Codes) {

				if (Vessels_Code.equals(Vessel_Code.getText())) {

					String num = String.valueOf(i);
					String voyage_Num = String.format(voyage_Num_l, num);

					if (Voyage_Number.equals(getText(driver, voyage_Num))) {

						String port_Date = String.format(port_Date_17, Port_Name, i);
						click(driver, port_Date);

						RightClick(driver, port_Date);
						Step_End(4, "Right Click on the port field in the voyage )", test, test1);
						// Adjust time_beforeadjustTimeSubMenu
						scrollUsingElement(driver, adjustTime);
						mouseOverToElement(driver, adjustTime);
						safeclick(driver, adjustTimeSubMenu);

						caps = Port_Name.toUpperCase();

						String beforechangeterminal = String.format(reference1, caps);
						//
						String attributeValue = getAttribute(driver, beforechangeterminal, "row-index");
						System.out.println(attributeValue);
						rownum = Integer.parseInt(attributeValue);
						System.out.println(rownum);
						int row = 2;
						rownum = rownum + row;
						String Treminal_code = String.format(terminal_Text, caps);
						text = getText(driver, Treminal_code);
						System.out.println(text);


						waitForElement(driver, closeButtonAdjustTime);
						safeclick(driver, closeButtonAdjustTime);

						String port_Date1 = String.format(port_Date_17, Port_Name, i);
						waitForElement(driver, port_Date1);
						safeclick(driver, port_Date1);

						RightClick(driver, port_Date1);

						Step_Start(5, "Choose Add / Rename Option )", test, test1);
						waitForElement(driver, AddandRemove);
						mouseOverToElement(driver, AddandRemove);
						Step_End(5, "Choose Add / Rename Option )", test, test1);
						Step_Start(6, "Choose Rename Terminal Option", test, test1);
						waitForElement(driver, renameTerminalOption);
						safeclick(driver, renameTerminalOption);
						Step_End(6, "Choose Rename Terminal Option", test, test1);

						waitForElement(driver, renameTerminalSearchButton);
						safeclick(driver, renameTerminalSearchButton);
						twoColumnSearchWindow(driver, Terminal_Code_Header, Condition_Filter, Rename_Terminal);


						// selecting current

						// select terminal for future

						if (Future_Terminal.equals("YES")) {
							Step_Start(8,
									"If the Terminal has to be renamed for the Future cycles of the voyage for the same port ",
									test, test1);
							if (Future_Terminal.equals("YES")) {
								Step_Start(9, "Choose Future Voyages Option", test, test1);
								waitForElement(driver, Futurevoyageselet);
								safeclick(driver, Futurevoyageselet);

								waitForElement(driver, okButtonInRenameTerminal);
								safeclick(driver, okButtonInRenameTerminal);

                                waitForPopup(driver, popup_Message, Rename_Terminal_pop_future);
								String Popforrenameterminal = getText(driver, popup_Message);
								System.out.println(Popforrenameterminal);

								if (Rename_Terminal_pop_future.equals(Popforrenameterminal)) {
									System.out.println(
											"Matched || " + " Expected Activity is : " + Rename_Terminal_pop_future
													+ " || Actual Activity is : " + Popforrenameterminal);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is : " + Rename_Terminal_pop_future
													+ " || Actual Activity is : " + Popforrenameterminal,
											test, test1);
								} else {
									System.out.println(
											"Not matched || " + " Expected Activity is : " + Rename_Terminal_pop_future
													+ " || Actual Activity is : " + Popforrenameterminal);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is : " + Rename_Terminal_pop_future
													+ " || Actual Activity is : " + Popforrenameterminal,
											test, test1);

								}
								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);

								Step_End(8,
										"If the Terminal has to be renamed for the Future cycles of the voyage for the same port ",
										test, test1);

								Step_End(9, "Choose Future Voyages Option", test, test1);
								break;

							}

						}

						if (Future_Terminal.equals("NO")) {

							Step_Start(10,
									"If the Terminal has to be renamed for the Future cycles of the voyage for the same port ",
									test, test1);
							Step_Start(11, "Choose Future Voyages Option", test, test1);
							if (Future_Terminal.equals("NO")) {
								waitForElement(driver, current_voyage);
								safeclick(driver, current_voyage);
								Step_Start(12, ".Click on Ok button", test, test1);

								waitForElement(driver, okButtonInRenameTerminal);
								safeclick(driver, okButtonInRenameTerminal);

								Step_End(12, ".Click on Ok button", test, test1);
								waitForPopup(driver, popup_Message, Rename_Terminal_pop_Current);
								String Popforrenameterminal = getText(driver, popup_Message);
								System.out.println(Popforrenameterminal);
								//
								if (Rename_Terminal_pop_Current.equals(Popforrenameterminal)) {
									System.out.println(
											"Matched || " + " Expected Activity is : " + Rename_Terminal_pop_Current
													+ " || Actual Activity is : " + Popforrenameterminal);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is : " + Rename_Terminal_pop_Current
													+ " || Actual Activity is : " + Popforrenameterminal,
											test, test1);
								} else {
									System.out.println(
											"Not matched || " + " Expected Activity is : " + Rename_Terminal_pop_Current
													+ " || Actual Activity is : " + Popforrenameterminal);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is : " + Rename_Terminal_pop_Current
													+ " || Actual Activity is : " + Popforrenameterminal,
											test, test1);

								}

								waitForElement(driver, popup_Message_Ok_Button);
								safeclick(driver, popup_Message_Ok_Button);
								Step_End(10,
										"If the Terminal has to be renamed for the Future cycles of the voyage for the same port ",
										test, test1);
								Step_End(11, "Choose Future Voyages Option", test, test1);
								break;

							}
						}

					}

				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}

		String Treminalll = String.format(selectdat, Vessels_Code);
		List<WebElement> Selected_Data1 = listOfElements(driver, Treminalll);
		int j = 1;
		for (WebElement dataa : Selected_Data1) {
			int sizenum = Selected_Data1.size();
			System.out.println(sizenum);
			String ele = String.format(Vessel_element, Vessels_Code, j);



			safeclick(driver, ele);

			//
			RightClick(driver, ele);
			if (isDisplayed(driver, conformbutton_display) == true) {
				scrollUsingElement(driver, adjustTime);
				mouseOverToElement(driver, adjustTime);
				waitForElement(driver, adjustTimeSubMenu);
				safeclick(driver, adjustTimeSubMenu);

				String Treminal_code1 = String.format(terminal_Text, caps);

				waitForElement(driver, Treminal_code1);
				String text1 = getText(driver, Treminal_code1);
				System.out.println(text1);


				waitForElement(driver, closeButtonAdjustTime);
				safeclick(driver, closeButtonAdjustTime);

			} else {

				System.out.println("Expected Result is : Selected voyage should be confirm || Actual Result is : Selected voyage is confirm");
				Extent_pass_New(driver, "Expected Result is : Selected voyage should be confirm || Actual Result is : Selected voyage is confirm", test, test1);

			}
			j++;
		}		
		Extent_completed(testcase_Name, test, test1);
	}
}
