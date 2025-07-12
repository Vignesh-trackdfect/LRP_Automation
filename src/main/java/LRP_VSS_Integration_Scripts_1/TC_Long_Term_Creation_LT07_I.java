package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT07_I extends Keywords {

	public void addingport(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT07_I";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Port_Name = Excel_data.get("Port_Name");
		String Distance_from_previous_port = Excel_data.get("Distance_from_previous_port");
		String Distance_to_next_port = Excel_data.get("Distance_to_next_port");
		String Speed_from_previous_port = Excel_data.get("Speed_from_previous_port");
		String Speed_to_next_port = Excel_data.get("Speed_to_next_port");
		String Buffer_Time_input = Excel_data.get("Buffer_Time_input");
		String Call_Type = Excel_data.get("Call_Type");
		String Port_code_search = Excel_data.get("Port_code_search");
		String Port_Terminal_Code = Excel_data.get("Port_Terminal_Code");
		String Bound_name = Excel_data.get("Bound_name");
		String Port_Add_Pop_Exp = Excel_data.get("Port_Add_Pop_Exp");
		String Add_Pord_colour = Excel_data.get("Add_Pord_colour");
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
		String Search_type = Excel_data.get("Search_type");
		String time_zone = Excel_data.get("time_zone");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String To_voyage_perform = Excel_data.get("To_voyage_perform");
		String From_Voyage_Perform = Excel_data.get("From_Voyage_Perform");
		String From_voyage_Input = Excel_data.get("From_voyage_Input");
		String To_voyage_Input = Excel_data.get("From_voyage_Input");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String New_AddPort_Perform = Excel_data.get("New_AddPort_Perform");
		String Port_Add_rollback_perform = Excel_data.get("Port_Add_rollback_perform");
		String Port_Name_rollback = Excel_data.get("Port_Name_rollback");
		String Search3 = Excel_data.get("Search_input_3");
		String Search2 = Excel_data.get("Service_input_2");
		String Ports_Status = Excel_data.get("Ports_Status");
		String REMARKS_EXP = Excel_data.get("REMARKS_EXP");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String date_Picker = Excel_data.get("date_Picker");
		String To_Voyage_Number_Header = Excel_data.get("To_Voyage_Number_Header");
		String From_Voyage_Number_Header = Excel_data.get("From_Voyage_Number_Header");
		String From_Port_Search = Excel_data.get("From_Port_Search");
		String To_Port_Search = Excel_data.get("To_Port_Search");
		String Location_Code_Header = Excel_data.get("Location_Code_Header");

		
		
		
		
		String get_remarks = String.format(getre);
		String get_remarks_back = String.format(getreback);
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);


		LRP_Login(driver, Username, Password);

		// searching for module
		moduleNavigate(driver, Search);

		Step_Start(1, "Retirve the Record via Global Search ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
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

						if (New_AddPort_Perform.equals("YES")) {
							Step_Start(5, "Choose Add / Rename Option )", test, test1);
							waitForElement(driver, AddandRemove);
							mouseOverToElement(driver, AddandRemove);
							Step_End(5, "Choose Add / Rename Option )", test, test1);
							Step_Start(6, "Choose Add port Option", test, test1);
							safeclick(driver, ADDPORTBTN);
							Step_End(6, "Choose Add port Option", test, test1);
							waitForElement(driver, sEARCHPORTINSIDE);
							safeclick(driver, sEARCHPORTINSIDE);
							Step_Start(7, "Enter the Terminal by using Search icon", test, test1);
							waitForElement(driver, Postcodefilterinput);
							sendKeys(driver, Postcodefilterinput, Port_code_search);
							waitForElement(driver, Terminal_Code_Input_Field);
							sendKeys(driver, Terminal_Code_Input_Field, Port_Terminal_Code);

							Step_End(7, "Enter the Terminal by using Search icon", test, test1);
							waitForElement(driver, Portnametext);
							String portnameAct = getText(driver, Portnametext);
							System.out.println(portnameAct);
							waitForElement(driver, Selectservicebtn);
							safeclick(driver, Selectservicebtn);

							Step_End(7, "Enter the Required port to need in the Port Code field", test, test1);
							Step_Start(8, ".Enter the Distance and Speed values ", test, test1);
							Step_Start(9,
									"Enter the Mandatory fields value highlighted in Light Green Background color ",
									test, test1);
							// distance from previous port input
							waitForElement(driver, DistanceInput);
							if (isElementAccessible(driver, DistanceInput)) {
								if (!Distance_from_previous_port.equals("")) {
									waitForElement(driver, DistanceInput);
									clear(driver, DistanceInput);
									sendKeys(driver, DistanceInput, Distance_from_previous_port);
								}
							}

							// distance to next port
							if (isElementAccessible(driver, DistanceInputtonext)) {
								if (!Distance_to_next_port.equals("")) {
									waitForElement(driver, DistanceInputtonext);
									clear(driver, DistanceInputtonext);
									sendKeys(driver, DistanceInputtonext, Distance_to_next_port);
								}
							}

							// speed from previous port
							if (isElementAccessible(driver, Sprrdfrom)) {
								if (!Speed_from_previous_port.equals("")) {
									waitForElement(driver, Sprrdfrom);
									clear(driver, Sprrdfrom);
									sendKeys(driver, Sprrdfrom, Speed_from_previous_port);

								}
							}

							// speed to next port
							if (isElementAccessible(driver, Speedtonextport)) {
								if (!Speed_to_next_port.equals("")) {
									waitForElement(driver, Speedtonextport);
									clear(driver, Speedtonextport);
									sendKeys(driver, Speedtonextport, Speed_to_next_port);
								}
							}
							if (isElementAccessible(driver, timezone_input)) {
								if (!Speed_to_next_port.equals("")) {
									waitForElement(driver, timezone_input);
									clear(driver, timezone_input);
									sendKeys(driver, timezone_input, time_zone);
								}
							}

							// buffer Time
							if (!Buffer_Time_input.equals("")) {
								waitForElement(driver, Buffer_time);
								clear(driver, Buffer_time);
								sendKeys(driver, Buffer_time, Buffer_Time_input);
							}

							if (!Call_Type.equals("")) {
								waitForElement(driver, Call_type_click);
								safeclick(driver, Call_type_click);

								String calltype = String.format(calltype1, Call_Type);

								click(driver, calltype);

							}

							Step_End(8, ".Enter the Distance and Speed values ", test, test1);
							waitForElement(driver, SUPBOUNDCLICK);
							safeclick(driver, SUPBOUNDCLICK);

							String Subound = String.format(bound_select, Bound_name);

							click(driver, Subound);
							waitForElement(driver, afterclick1);
							safeclick(driver, afterclick1);
							Step_End(9, "Enter the Mandatory fields value highlighted in Light Green Background color ",
									test, test1);

							Step_Start(13, ".Click on Move to Long Term Button  ", test, test1);
							waitForElement(driver, Clicklonftermforaddport);
							safeclick(driver, Clicklonftermforaddport);

							Step_End(13, ".Click on Move to Long Term Button  ", test, test1);

							waitForElement(driver, popup_Message_Yes_Button);
							safeclick(driver, popup_Message_Yes_Button);

							waitForPopup(driver, popup_Message, Port_Add_Pop_Exp);
							String portaddact = getText(driver, popup_Message);
							System.out.println(portaddact);

							if (Port_Add_Pop_Exp.equals(portaddact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + portaddact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + portaddact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + portaddact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + portaddact, test, test1);

							}

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							scrollBottom(driver);
							mouseOverToElement(driver, get_remarks);

							String portadd = String.format(portaddd, portnameAct);

							waitForDisplay(driver, portadd);
							if (isDisplayed(driver, portadd)) {
								System.out.println("Expected Result is : Port should be added ||  Actual Result is : Port is added ");
								Extent_pass_New(driver, "Expected Result is : Port should be added ||  Actual Result is : Port is added ", test, test1);
							} else {
								System.out.println("Expected Result is : Port should be added ||  Actual Result is : Port is not added ");
								Extent_fail(driver, "Expected Result is : Port should be added ||  Actual Result is : Port is not added ", test, test1);
							}

							String portcolourtext = getTextBackgroundColor(driver, get_remarks);
							System.out.println(portcolourtext);
							String portcolourtext1 = getText(driver, get_remarks);
							System.out.println(portcolourtext1);
							Step_Start(14,
									"System should add the added port in the last row of the grid highlighted in green color",
									test, test1);
							if (REMARKS_EXP.equals(portcolourtext1)) {

								String portcolouract = getTextBackgroundColor(driver, get_remarks_back);
								System.out.println(portcolouract);
								String portcolourtext2 = getColorName(portcolouract);
								System.out.println(portcolourtext2);

								if (Add_Pord_colour.equals(portcolourtext2)) {
									System.out.println("Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour  +" || Actual Result is :The port Colour is changed"+ portcolourtext2);
									Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +"  || Actual Result is :The port Colour is changed"+ portcolourtext2, test, test1);
								} else {
									System.out.println("Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2);
									Extent_fail(driver, "Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2, test, test1);

								}

							} else {

								String portcolouract = getTextBackgroundColor(driver, get_remarks);
								System.out.println(portcolouract);
								String portcolourtext2 = getColorName(portcolouract);
								System.out.println(portcolourtext2);

								if (Add_Pord_colour.equals(portcolourtext2)) {
									System.out.println("Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is changed"+ portcolourtext2);
									Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is changed"+ portcolourtext2, test, test1);
								} else {
									System.out.println("Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2);
									Extent_fail(driver, "Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2, test, test1);
								}

							}

							Step_End(14,
									"System should add the added port in the last row of the grid highlighted in green color",
									test, test1);
						}

						if (Port_Add_rollback_perform.equals("YES")) {
							Step_Start(10,
									"If the user want to Rollback any previously permanently deleted call from the same voyage  ",
									test, test1);
							waitForElement(driver, Permanentdelete);
							safeclick(driver, Permanentdelete);
							waitForElement(driver, popup_Message);
							safeclick(driver, popup_Message_Ok_Button);
							waitForElement(driver, popup_Message);
							safeclick(driver, popup_Message_Ok_Button);

							int j = 1;
							waitForElement(driver, vessels_code);

							List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
							for (WebElement Vessel_Code1 : vessel_Codes1) {

								Click(driver, Vessel_Code1);
								if (Vessels_Code.equals(Vessel_Code1.getText())) {

									String num1 = String.valueOf(j);
									String voyage_Num1 = String.format(voyage_Num_l, num1);

									if (Voyage_Number.equals(getText(driver, voyage_Num1))) {

										String port_Date1 = String.format(port_Date_17, Port_Name_rollback,
												j);
										click(driver, port_Date1);

										RightClick(driver, port_Date1);
										waitForElement(driver, AddandRemove);
										mouseOverToElement(driver, AddandRemove);
										safeclick(driver, ADDPORTBTN);
										Step_End(10,
												"If the user want to Rollback any previously permanently deleted call from the same voyage  ",
												test, test1);
										Step_Start(11,
												"Click on the port row in the “Coastal / Long term Permanently deleted calls” grid  ",
												test, test1);

										String Roll_back = String.format(rollbackk, Port_Name);

										click(driver, Roll_back);
										Step_End(11,
												"Click on the port row in the “Coastal / Long term Permanently deleted calls” grid  ",
												test, test1);
										Step_Start(12, "Click on Rollback Button above the Grid ", test, test1);

										waitForElement(driver, ROLLBACKBOTTON);

										safeclick(driver, ROLLBACKBOTTON);
										Step_End(12, "Click on Rollback Button above the Grid ", test, test1);
										// distance from previous port input
										if (isElementAccessible(driver, DistanceInput)) {
											if (!Distance_from_previous_port.equals("")) {
												waitForElement(driver, DistanceInput);
												clear(driver, DistanceInput);
												sendKeys(driver, DistanceInput, Distance_from_previous_port);
											}
										}

										// distance to next port
										if (isElementAccessible(driver, DistanceInputtonext)) {
											if (!Distance_to_next_port.equals("")) {
												waitForElement(driver, DistanceInputtonext);
												clear(driver, DistanceInputtonext);
												sendKeys(driver, DistanceInputtonext, Distance_to_next_port);

											}
										}

										// speed from previous port
										if (isElementAccessible(driver, Sprrdfrom)) {
											if (!Speed_from_previous_port.equals("")) {
												waitForElement(driver, Sprrdfrom);
												clear(driver, Sprrdfrom);
												sendKeys(driver, Sprrdfrom, Speed_from_previous_port);
											}
										}

										// speed to next port
										if (isElementAccessible(driver, Speedtonextport)) {
											if (!Speed_to_next_port.equals("")) {
												waitForElement(driver, Speedtonextport);
												clear(driver, Speedtonextport);
												sendKeys(driver, Speedtonextport, Speed_to_next_port);

											}
										}

										// buffer Time
										if (!Buffer_Time_input.equals("")) {
											waitForElement(driver, Buffer_time);
											clear(driver, Buffer_time);
											sendKeys(driver, Buffer_time, Buffer_Time_input);
										}
										if (isElementAccessible(driver, timezone_input)) {
											if (!Speed_to_next_port.equals("")) {
												waitForElement(driver, timezone_input);
												clear(driver, timezone_input);
												sendKeys(driver, timezone_input, time_zone);
											}
										}
										if (!Call_Type.equals("")) {
											waitForElement(driver, Call_type_click);
											safeclick(driver, Call_type_click);

											String calltype = String.format(calltype1, Call_Type);
											click(driver, calltype);

										}

										waitForElement(driver, SUPBOUNDCLICK);
										safeclick(driver, SUPBOUNDCLICK);

										String Subound1 = String.format(bound, Bound_name);

										click(driver, Subound1);
										Step_Start(13, ".Click on Move to Long Term Button  ", test, test1);
										waitForElement(driver, Clicklonftermforaddport);
										safeclick(driver, Clicklonftermforaddport);
										Step_End(13, ".Click on Move to Long Term Button  ", test, test1);
										waitForElement(driver, popup_Message_Yes_Button);
										safeclick(driver, popup_Message_Yes_Button);

										waitForPopup(driver, popup_Message, Port_Add_Pop_Exp);
										String portaddact1 = getText(driver, popup_Message);
										System.out.println(portaddact1);

										if (Port_Add_Pop_Exp.equals(portaddact1)) {
											System.out.println("Matched || " + " Expected Activity is : "
													+ Port_Add_Pop_Exp + " || Actual Activity is : " + portaddact1);
											Extent_pass_New(driver, "Matched || " + " Expected Activity is : "
													+ Port_Add_Pop_Exp + " || Actual Activity is : " + portaddact1,
													test, test1);
										} else {
											System.out.println("Not matched || " + " Expected Activity is : "
													+ Port_Add_Pop_Exp + " || Actual Activity is : " + portaddact1);
											Extent_fail(driver, "Not matched || " + " Expected Activity is : "
													+ Port_Add_Pop_Exp + " || Actual Activity is : " + portaddact1,
													test, test1);

										}
										safeclick(driver, popup_Message_Ok_Button);
										scrollBottom(driver);
										mouseOverToElement(driver, get_remarks);
										String portcolourtext = getTextBackgroundColor(driver, get_remarks);
										System.out.println(portcolourtext);
										String portcolourtext1 = getText(driver, get_remarks);
										System.out.println(portcolourtext1);
										Step_Start(14,
												"System should add the added port in the last row of the grid highlighted in green color",
												test, test1);
										if (REMARKS_EXP.equals(portcolourtext1)) {

											String portcolouract = getTextBackgroundColor(driver, get_remarks_back);
											System.out.println(portcolouract);
											String portcolourtext2 = getColorName(portcolouract);
											System.out.println(portcolourtext2);

											if (Add_Pord_colour.equals(portcolourtext2)) {
												System.out.println("Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour +"  || Actual Result is :The port Colour is changed"+ portcolourtext2);
												Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour +" || Actual Result is :The port Colour is changed"+ portcolourtext2, test, test1);
											} else {
												System.out.println("Not Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour +"  || Actual Result is :The port Colour is not changed"+ portcolourtext2);
												Extent_fail(driver, "Not Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour +"|| Actual Result is :The port Colour is not changed"+ portcolourtext2, test, test1);

											}

										} else {

											String portcolouract_ = getTextBackgroundColor(driver, get_remarks);
											System.out.println(portcolouract_);
											String portcolouract=getColorName(portcolouract_);
											System.out.println(portcolouract);
											if (Add_Pord_colour.equals(portcolourtext)) {
												System.out.println("Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour+"  || Actual Result is :The port Colour is changed"+ portcolourtext);
												Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour+" || Actual Result is :The port Colour is changed"+ portcolourtext, test, test1);
											} else {
												System.out.println("Not Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour+" || Actual Result is :The port Colour is not changed"+ portcolourtext);
												Extent_fail(driver, "Not Matched || Expected Result is : The port colour should be changed as"+  Add_Pord_colour+" || Actual Result is :The port Colour is not changed"+ portcolourtext, test, test1);

											}

										}

										Step_End(14,
												"System should add the added port in the last row of the grid highlighted in green color",
												test, test1);
										break;
									}

								}
								j++;
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
		ArrayList<String> portName = new ArrayList<String>();
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
						String port_Date = String.format(port_Date_17, Port_Name, i);
						click(driver, port_Date);

						RightClick(driver, port_Date);

						mouseOverToElement(driver, AdjustTime);
						waitForElement(driver, AdjustTime1);
						click(driver, AdjustTime1);

						waitForElement(driver, Getmarinedistance1);
						click(driver, Getmarinedistance1);
						waitForElement(driver, Ports_codes);

						List<WebElement> Ports_code = listOfElements(driver, Ports_codes);
						for (WebElement Ports : Ports_code) {

							String name = Ports.getText();

							System.out.println(name);
							portName.add(name);
						}
						horizontalscroll(driver, Scroll_1, 3500);

						ArrayList<String> Distance = new ArrayList<String>();

						waitForElement(driver, Distance_codes);

						List<WebElement> Distance_code = listOfElements(driver, Distance_codes);
						for (WebElement distance : Distance_code) {

							String name = distance.getText();

							System.out.println(name);

							Distance.add(name);
						}

						waitForElement(driver, Closeadjesttime);
						click(driver, Closeadjesttime);

						moduleNavigate(driver, Search2);


						for (int k = 0; k < portName.size(); k++) {
							if (k + 1 >= portName.size()) {
								break;
							}

							scrollTop(driver);
							
							waitForElement(driver, SearchButton_Toolbar);
							safeclick(driver, SearchButton_Toolbar);
							
							globalValueSearchWindow1(driver, Search_type, From_Port_Search, portName.get(k), To_Port_Search, portName.get(k + 1), "", "");
							
							waitForDisplay(driver, Popup_Message);
							if (isDisplayed(driver, Popup_Message)) {

								System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
								Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
										+ portName.get(k + 1), test, test1);
								waitForElement(driver, Popup_Message);
								safeclick(driver, Popup_Message);

							} else {

								System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
								Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);
							}
							waitForDisplay(driver, retrivedGlobalValue);
							if(isdisplayed(driver, retrivedGlobalValue)) {
							click(driver, retrivedGlobalValue);
							waitForElement(driver, SelectButton);
							click(driver, SelectButton);
							elementnotvisible1(driver, SelectButton);
							
								waitForElement(driver, Distance_GRidcell_MD);
								String distance_value = getText(driver, Distance_GRidcell_MD);
								System.out.println(distance_value);
								System.out.println(Distance.get(k));

								if (Distance.get(k).contains(distance_value)) {
									System.out.println("Expected result is : distance should not be Equal || Actual Result is : Distance is not Equal");

									Extent_pass_New(driver,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value,
											test, test1);
									Extent_call(test, test1,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value);

								} else {
									System.out.println("Expected result is : distance should not be Equal || Actual Result is : Distance is not Equal");

									Extent_pass_New(driver,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value,
											test, test1);

								}

							} else {

								System.out.println("Expected result is : distance should not be found || Actual Result is : Distance is not found");
								Extent_pass_New(driver, "Expected result is : distance should not be found || Actual Result is : Distance is not found", test, test1);

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

		moduleNavigate(driver, Search3);

		for (int D = 0; D < portName.size(); D++) {
			if (D + 1 >= portName.size()) {
				break;
			}

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Search_type, Location_Code_Header, portName.get(D), "", "", "", "");
			
			waitForElement(driver, Statusforport);
			String Port_status = getText(driver, Statusforport);
			System.out.println(Port_status);
			if (Port_status.equals(Ports_Status)) {
				Extent_pass_New(driver, "**Port code of**" + portName.get(D) + "**Status shown as**" + Port_status, test,
						test1);
				Extent_call(test, test1, "**Port code of**" + portName.get(D) + "**Status shown as**" + Port_status);
			} else {

				System.out.println("Expected result is : ports should  be Active || Actual Result is : Ports is active");
				Extent_pass_New(driver, "Expected result is : ports should  be Active || Actual Result is : Ports is active", test, test1);

			}
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
