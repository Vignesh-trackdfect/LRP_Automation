package LRP_VSS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Long_Term_Creation_LT07_LT12 extends Keywords {

	public void createlongterm_07_12(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)
			throws Exception {

		

		int LT7 = 7;

		if (LT7 == 7) {
			
			String testcase_Name = "TC_Long_Term_Creation_LT07";
			String URL = TestNgXml.getdatafromExecution().get(testcase_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Username = data.get("Username");
			String Password = data.get("Password");
			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String Distance_from_previous_port = data.get("Distance_from_previous_port");
			String Distance_to_next_port = data.get("Distance_to_next_port");
			String Speed_from_previous_port = data.get("Speed_from_previous_port");
			String Speed_to_next_port = data.get("Speed_to_next_port");
			String Buffer_Time_input = data.get("Buffer_Time_input");
			String Call_Type = data.get("Call_Type");
			String Port_code_search = data.get("Port_code_search");
			String Port_Terminal_Code = data.get("Port_Terminal_Code");
			String Bound_name = data.get("Bound_name");
			String Port_Add_Pop_Exp = data.get("Port_Add_Pop_Exp");
			String Add_Pord_colour = data.get("Add_Pord_colour");
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
			String New_AddPort_Perform = data.get("New_AddPort_Perform");
			String Port_Add_rollback_perform = data.get("Port_Add_rollback_perform");
			String Port_Name_rollback = data.get("Port_Name_rollback");
			String REMARKS_EXP = data.get("REMARKS_EXP");
			String time_zone = data.get("time_zone");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");

			//

			String get_remarks = String.format(getre);

			String get_remarks_back = String.format(getreback);
			Extent_Start(testcase_Name, test, test1);

			navigateUrl(driver, URL);

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
									System.out.println("Expected Result is : Port should be added  || Actual Result is : Port is added ");
									Extent_pass_New(driver, "Expected Result is : Port should be added  || Actual Result is : Port is added ", test, test1);
								} else {
									System.out.println("Expected Result is : Port should be added  || Actual Result is : Port is not added ");
									Extent_fail(driver, "Expected Result is : Port should be added  || Actual Result is : Port is not added ", test, test1);
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
										System.out.println("Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :The port Colour is changed"+ portcolourtext2);
										Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :The port Colour is changed"+ portcolourtext2, test, test1);
									} else {
										System.out.println("Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :The port Colour is not changed"+ portcolourtext2);
										Extent_fail(driver, "Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :The port Colour is not changed"+ portcolourtext2, test, test1);

									}

								} else {

									String portcolouract = getTextBackgroundColor(driver, get_remarks);
									System.out.println(portcolouract);
									String portcolourtext2 = getColorName(portcolouract);
									System.out.println(portcolourtext2);

									if (Add_Pord_colour.equals(portcolourtext2)) {
										System.out.println("Matched || Expected Result is : The port colour should be changed as" + Add_Pord_colour +" || Actual Result is :The port Colour is changed"+ portcolourtext2);
										Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is changed"+ portcolourtext2, test, test1);
									} else {
										System.out.println("Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2);
										Extent_fail(driver, "Not Matched || Expected Result is : The port colour should be changed as"+ Add_Pord_colour +" || Actual Result is :The port Colour is not changed"+ portcolourtext2, test, test1);
									}

								}

								Extent_pass_New(driver, "Expected Result is : Port should be added at last "+portnameAct +" || Actual Result is : Port should be added at last "+portnameAct , test, test1);
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
													System.out.println("Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is changed"+portcolourtext2);
													Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is changed"+portcolourtext2, test, test1);
												} else {
													System.out.println("Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is not changed"+portcolourtext2);
													Extent_fail(driver, "Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is not changed"+portcolourtext2, test, test1);

												}

											} else {

												String portcolouract_ = getTextBackgroundColor(driver, get_remarks);
												System.out.println(portcolouract_);
												String portcolouract=getColorName(portcolouract_);
												System.out.println(portcolouract);
												if (Add_Pord_colour.equals(portcolourtext)) {
													System.out.println("Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is changed"+portcolourtext);
													Extent_pass_New(driver, "Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is changed"+portcolourtext, test, test1);
												} else {
													System.out.println("Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is not changed"+portcolourtext);
													Extent_fail(driver, "Matched || Expected Result is : The port colour should be changed as"+Add_Pord_colour+"|| Actual Result is :The port Colour is not changed"+portcolourtext, test, test1);

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
			Extent_completed(testcase_Name, test, test1);

		}
		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT8 = 8;

		if (LT8 == 8) {
			String testcase_Name = "TC_Long_Term_Creation_LT08";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String Rename_Terminal = data.get("Rename_Terminal");
			String Future_Terminal = data.get("Future_Terminal");
			String Rename_Terminal_pop_future = data.get("Rename_Terminal_pop_future");
			String Vessels_Code = data.get("Vessels_Code");
			String Rename_Terminal_pop_Current = data.get("Rename_Terminal_pop_Current");
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
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");
			String Terminal_Code_Header  = data.get("Terminal_Code_Header");

			
			
			String text = null;
			int rownum = 0;
			String caps = null;
			Extent_Start(testcase_Name, test, test1);



			// searching for module

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

					Extent_pass_New(driver, "Expected Result is : Before Adjust time it should be shown as "+ text + " Actual Result is : After adjusted time its shows"+ text1 , test, test1);

					waitForElement(driver, closeButtonAdjustTime);
					safeclick(driver, closeButtonAdjustTime);

				} else {

					System.out.println("Expected Result is : Selected Voyage should be confirm || Actual Result is : Selected voyage is confirm ");
	               Extent_fail(driver, "Expected Result is : Selected Voyage should be confirm || Actual Result is : Selected voyage is confirm ", test, test1);
				}
				j++;
			}
			Extent_completed(testcase_Name, test, test1);
		}

		scrollTop(driver);

		click(driver, Close_Current_tab);

		int LT9 = 9;

		if (LT9 == 9) {
			String testcase_Name = "TC_Long_Term_Creation_LT09_LT10";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String Port_Ommit_Pop_Exp = data.get("Port_Ommit_Pop_Exp");
			String Add_Pord_colour = data.get("Add_Pord_colour");
			String Rolled_Back_pop_exp = data.get("Rolled_Back_pop_exp");
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
			String Rolled_Back_Gird_pop_exp = data.get("Rolled_Back_Gird_pop_exp");
			String To_voyage_perform = data.get("To_voyage_perform");
			String From_Voyage_Perform = data.get("From_Voyage_Perform");
			String From_voyage_Input = data.get("From_voyage_Input");
			String To_voyage_Input = data.get("From_voyage_Input");
			String Vessels_Code = data.get("Vessels_Code");
			String Ommit_Colour_exp = data.get("Ommit_Colour_exp");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");

			Extent_Start(testcase_Name, test, test1);

			// searching for module
			moduleNavigate(driver, Search);

			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
			Step_Start(2, "Enter the Service Code in the Service Code field ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
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
							Step_Start(4, "Right Click on the port field in the voyage ", test, test1);

							RightClick(driver, port_Date);
							Step_End(4, "Right Click on the port field in the voyage ", test, test1);

							Step_Start(5, "Choose Cut/Copy/Paste Option", test, test1);
							mouseOverToElement(driver, Removeportclickaddandremove);
							Step_End(5, "Choose Cut/Copy/Paste Option", test, test1);
							Step_Start(6, "Choose Remove(Omit)Option from sub menu ", test, test1);
							safeclick(driver, Removeportclickaddandremoveside);
							Step_End(6, "Choose Remove(Omit)Option from sub menu ", test, test1);
							Step_Start(7, "Click on Ok button in the Confirmation pop up message ", test, test1);

						


							Step_Start(8, "System should show “Port is Omitted” message ", test, test1);
							waitForPopup(driver, popup_Message, Port_Ommit_Pop_Exp);
							String OmitpopAct = getText(driver, popup_Message);
							System.out.println(OmitpopAct);

							if (Port_Ommit_Pop_Exp.equals(OmitpopAct)) {
								System.out.println("Matched || " + " Expected Activity is : " + Port_Ommit_Pop_Exp
										+ " || Actual Activity is : " + OmitpopAct);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Port_Ommit_Pop_Exp
										+ " || Actual Activity is : " + OmitpopAct, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Port_Ommit_Pop_Exp
										+ " || Actual Activity is : " + OmitpopAct);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Port_Ommit_Pop_Exp
										+ " || Actual Activity is : " + OmitpopAct, test, test1);
							}
							scrollBottom(driver);

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							Step_End(7, "Click on Ok button in the Confirmation pop up message ", test, test1);
							Step_End(8, "System should show “Port is Omitted” message ", test, test1);
							
							String ommitcolour = String.format(port_Date_17, Port_Name, i);
							System.out.println(ommitcolour);
							

							String colouract = getTextColor(driver, ommitcolour);
							System.out.println(colouract);
							  String Omit_Colour=getColorName(colouract);
							  System.out.println("Omit_Colour :"+Omit_Colour);
							Step_Start(9, "Now the Removed port should be highlighted in Red color", test, test1);
							if (Ommit_Colour_exp.equals(Omit_Colour)) {
								System.out.println("Matched || Expected Result is : The removed port colour should be changed as"+  Ommit_Colour_exp  +"|| Actual Result is :The removed port Colour is changed"+  Omit_Colour);
								Extent_pass_New(driver,"Matched || Expected Result is : The removed port colour should be changed as"+  Ommit_Colour_exp  +"|| Actual Result is :The removed port Colour is changed"+  Omit_Colour,
										test, test1);
							} else {
								System.out.println("Not Matched || Expected Result is : The removed port colour should be changed as"+  Ommit_Colour_exp  +"|| Actual Result is :The removed port Colour is not changed"+  Omit_Colour);
								Extent_fail(driver, "Not Matched || Expected Result is : The removed port colour should be changed as"+  Ommit_Colour_exp  +"|| Actual Result is :The removed port Colour is not changed"+  Omit_Colour, test, test1);
							}

							Step_End(9, "Now the Removed port should be highlighted in Red color", test, test1);

							click(driver, ommitcolour);

							RightClick(driver, ommitcolour);

							Step_Start(10, "Choose “Rollback” option from the menu ", test, test1);
							
							waitForElement(driver, RollBack_Option_LT);
							mouseOverToElement(driver, RollBack_Option_LT);
							
							waitForElement(driver, omitted_Calls_Option_LT);
							safeclick(driver, omitted_Calls_Option_LT);
							
							Step_End(10, "Choose “Rollback” option from the menu ", test, test1);

							Step_Start(11, "Choose the Red color highlighted row from the Rollback Window ", test, test1);
						
							String ReferenceType_Select11 = String.format(reference, Port_Name);
							waitForElement(driver, ReferenceType_Select11);
							safeclick(driver, ReferenceType_Select11);
							Step_End(11, "Choose the Red color highlighted row from the Rollback Window ", test, test1);
							Step_Start(12, ".Click on Rollback Button ", test, test1);
							waitForElement(driver, RollBackclickbtn);
							safeclick(driver, RollBackclickbtn);
							Step_End(12, ".Click on Rollback Button ", test, test1);
							Step_Start(13, "System should show validation “Selected Port has rollbacked” window", test,
									test1);
							
							waitForPopup(driver, popup_Message, Rolled_Back_Gird_pop_exp);
							String rollbackact = getText(driver, popup_Message);
							System.out.println(rollbackact);

							if (Rolled_Back_Gird_pop_exp.equals(rollbackact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Rolled_Back_Gird_pop_exp
										+ " || Actual Activity is : " + rollbackact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Rolled_Back_Gird_pop_exp
										+ " || Actual Activity is : " + rollbackact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Rolled_Back_Gird_pop_exp
										+ " || Actual Activity is : " + rollbackact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : "
										+ Rolled_Back_Gird_pop_exp + " || Actual Activity is : " + rollbackact, test,
										test1);
							}
							waitForElement(driver, popup_Message_Ok_Button);
							Step_End(13, "System should show validation “Selected Port has rollbacked” window", test,
									test1);
							safeclick(driver, popup_Message_Ok_Button);
							Step_Start(14, "Click on Move to Long Term Creation button", test, test1);
							waitForElement(driver, Longtermbutton);
							safeclick(driver, Longtermbutton);
							Step_End(14, "Click on Move to Long Term Creation button", test, test1);
							waitForElement(driver, popup_Message);
							waitForElement(driver, popup_Message_Ok_Button);
							Step_Start(15, "System should show “Port(S) rollbacked window", test, test1);
							waitForPopup(driver, popup_Message, Rolled_Back_pop_exp);
							String Rollbackpopact = getText(driver, popup_Message);
							System.out.println(Rollbackpopact);
							if (Rolled_Back_pop_exp.equals(Rollbackpopact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Rolled_Back_pop_exp
										+ " || Actual Activity is : " + Rollbackpopact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Rolled_Back_pop_exp
										+ " || Actual Activity is : " + Rollbackpopact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Rolled_Back_pop_exp
										+ " || Actual Activity is : " + Rollbackpopact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Rolled_Back_pop_exp
										+ " || Actual Activity is : " + Rollbackpopact, test, test1);
							}
							Step_End(15, "System should show “Port(S) rollbacked window", test, test1);

							String rolebackcolour = String.format(port_Date_17, Port_Name, i);

							String rolebackcolouract = getTextColor(driver, rolebackcolour);
							System.out.println(rolebackcolouract);
							  String roleBack_Colour=getColorName(rolebackcolouract);
							  System.out.println(roleBack_Colour);

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);

							Step_Start(16, "Now the system should remove the red highlight from the removed port", test,
									test1);

							if (Add_Pord_colour.equals(roleBack_Colour)) {
								System.out.println("Matched || Expected Result is : rollback colour should be changed as"+  Add_Pord_colour +"|| Actual Result is :rollback Colour is changed"+ roleBack_Colour);
								Extent_pass_New(driver, "Matched || Expected Result is : rollback colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :rollback Colour is changed"+ roleBack_Colour, test, test1);
							} else {
								System.out.println("Not Matched || Expected Result is : rollback colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :rollback Colour is not changed"+ roleBack_Colour);
								Extent_fail(driver, "Not Matched || Expected Result is : rollback colour should be changed as"+ Add_Pord_colour +"|| Actual Result is :rollback Colour is notchanged"+ roleBack_Colour, test, test1);
							}

							Step_End(16, "Now the system should remove the red highlight from the removed port", test,
									test1);
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

		int LT11 = 11;

		if (LT11 == 11) {

			String testcase_Name = "TC_Long_Term_Creation_LT11";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number").trim();
			String Port_Add_Pop_Exp = data.get("Port_Add_Pop_Exp");
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

			//

			Extent_Start(testcase_Name, test, test1);


			// searching for module

			moduleNavigate(driver, Search);

			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);

			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);

			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);



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

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {
							click(driver, voyage_Num);
							Step_Start(3, "Right Click on the voyage which needed to permanently deleted ", test, test1);
							RightClick(driver, voyage_Num);
							Step_End(3, "Right Click on the voyage which needed to permanently deleted ", test, test1);
							Step_Start(4, "Choose Permanent Delete Option", test, test1);
							waitForElement(driver, Permanentdelete);
							safeclick(driver, Permanentdelete);
							waitForElement(driver, popup_Message);
							safeclick(driver, popup_Message_Yes_Button);
							Step_End(4, "Choose Permanent Delete Option", test, test1);

							Step_Start(5, "Click on Ok from the Confirmation Validation", test, test1);

							Step_Start(7, "System should show pop up validation “Selected Voyage/Ports(s) Deleted”", test,
									test1);
							waitForPopup(driver, popup_Message, Port_Add_Pop_Exp);
							String deletepopact = getText(driver, popup_Message);
							System.out.println(deletepopact);

							if (Port_Add_Pop_Exp.equals(deletepopact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + deletepopact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + deletepopact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + deletepopact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Port_Add_Pop_Exp
										+ " || Actual Activity is : " + deletepopact, test, test1);

							}
							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							Step_End(5, "Click on Ok from the Confirmation Validation", test, test1);

							Step_Start(6, "System should remove the voayge from the grid ", test, test1);
							String Voyage_Numberr_dis = String.format(Voyage_Numberr, Voyage_Number);
							waitForDisplay(driver, Voyage_Numberr_dis);
							if (isDisplayed(driver, Voyage_Numberr_dis)) {
								System.out.println("Expected Result is : Voyage should not be deleted || Actual Result is : Voyage is not deleted ");
								Extent_fail(driver, "Expected Result is : Voyage should not be deleted || Actual Result is : Voyage is not deleted " + Voyage_Number, test, test1);

							} else {
								System.out.println("Expected Result is : Voyage should  be deleted || Actual Result is : Voyage is  deleted ");
								Extent_pass_New(driver, "Expected Result is : Voyage should  be deleted || Actual Result is : Voyage is  deleted " + Voyage_Number, test, test1);
								Step_End(6, "System should remove the voayge from the grid ", test, test1);
								Step_End(7, "System should show pop up validation “Selected Voyage/Ports(s) Deleted”", test,
										test1);
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

			Extent_completed(testcase_Name, test, test1);// searching for module
			
			scrollTop(driver);

			click(driver, Close_Current_tab);
			
			

		}

		int LT12 = 12;

		if (LT12 == 12) {

			String testcase_Name = "TC_Long_Term_Creation_LT12";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			System.out.println(Sheet_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset, File_Path);

			String Search = data.get("Search_input");
			String service_select = data.get("service_select");
			String Voyage_Number = data.get("Voyage_Number");
			String Port_Name = data.get("Port_Name");
			String Port_delete_pop_exp = data.get("Port_delete_pop_exp");
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
			String Port_delete_colour_exp = data.get("Port_delete_colour_exp");
			String Service_Code_Header  = data.get("Service_Code_Header");
			String Vessel_Code_Header  = data.get("Vessel_Code_Header");
			String From_Voyage_Number_Header  = data.get("From_Voyage_Number_Header");
			String Condition_Filter  = data.get("Condition_Filter");
			String To_Voyage_Number_Header  = data.get("To_Voyage_Number_Header");
			String date_Picker  = data.get("date_Picker");


	//

			Extent_Start(testcase_Name, test, test1);


			// searching for module

			moduleNavigate(driver, Search);

			Step_Start(1, "Retirve the Record via Global Search  ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			waitForElement(driver, searchIconLT);
			safeclick(driver, searchIconLT);
			Step_End(1, "Retirve the Record via Global Search  ", test, test1);
			twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);


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

					if (Vessels_Code.equals(Vessel_Code.getText())) {

						String num = String.valueOf(i);
						String voyage_Num = String.format(voyage_Num_l, num);

						if (Voyage_Number.equals(getText(driver, voyage_Num))) {

							String port_Date = String.format(port_Date_17, Port_Name, i);
							Step_Start(3, "Right Click on the Port which needed to permanently deleted from the voyage ",
									test, test1);
							click(driver, port_Date);

							RightClick(driver, port_Date);
							Step_End(3, "Right Click on the Port which needed to permanently deleted from the voyage ",
									test, test1);

							Step_Start(4, "Choose Permanent Delete Option ", test, test1);
							waitForElement(driver, Permanentdelete);
							safeclick(driver, Permanentdelete);
							Step_End(4, "Choose Permanent Delete Option ", test, test1);
							waitForElement(driver, popup_Message);
							Step_Start(5, "Click on Ok from the Confirmation Validation ", test, test1);
							safeclick(driver, popup_Message_Yes_Button);
							Step_End(5, "Click on Ok from the Confirmation Validation ", test, test1);
							Step_Start(7, "System should show pop up validation “Selected Voyage/Ports(s) Deleted” ", test,
									test1);
							waitForPopup(driver, popup_Message, Port_delete_pop_exp);
							String deletemsgact = getText(driver, popup_Message);
							System.out.println(deletemsgact);
							if (Port_delete_pop_exp.equals(deletemsgact)) {
								System.out.println("Matched || " + " Expected Activity is : " + Port_delete_pop_exp
										+ " || Actual Activity is : " + deletemsgact);
								Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Port_delete_pop_exp
										+ " || Actual Activity is : " + deletemsgact, test, test1);
							} else {
								System.out.println("Not matched || " + " Expected Activity is : " + Port_delete_pop_exp
										+ " || Actual Activity is : " + deletemsgact);
								Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Port_delete_pop_exp
										+ " || Actual Activity is : " + deletemsgact, test, test1);
							}
							safeclick(driver, popup_Message_Ok_Button);

							Step_Start(6,
									"System should remove the port from the voyage grid, and should voyage grid should have white space in the place of the port  ",
									test, test1);

							String port_Date1 = String.format(port_Date_17, Port_Name, i);
							String Portdelete_COde = getTextBackgroundColor(driver, port_Date1);
							System.out.println(Portdelete_COde);
							String Portdelete= getColorName(Portdelete_COde);

							if (Port_delete_colour_exp.equals(Portdelete)) {
								System.out.println("Matched ||  Expected Result is :Once User remove the port, voyage grid should be changed as " + Port_delete_colour_exp + " || Actual result is  :Once User remove the port, voyage grid is changed as " + Portdelete);
								Extent_pass_New(driver, "Matched ||  Expected Result is :Once User remove the port, voyage grid should be changed as " + Port_delete_colour_exp + " || Actual result is  :Once User remove the port, voyage grid is changed as " + Portdelete, test, test1);
							} else {
								System.out.println("Not Matched ||  Expected Result is :Once User remove the port, voyage grid should be changed as " + Port_delete_colour_exp + " || Actual result is  :Once User remove the port, voyage grid is not changed as " + Portdelete);
								Extent_fail(driver, "Not Matched ||  Expected Result is :Once User remove the port, voyage grid should be changed as " + Port_delete_colour_exp + " || Actual result is  :Once User remove the port, voyage grid is not changed as " + Portdelete, test, test1);
							}
							Step_End(6,
									"System should remove the port from the voyage grid, and should voyage grid should have white space in the place of the port  ",
									test, test1);
							Step_End(7, "System should show pop up validation “Selected Voyage/Ports(s) Deleted” ", test,
									test1);

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