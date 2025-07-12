package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT06_I extends Keywords {

	public void adjusttime(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT06_I";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Search2 = Excel_data.get("Service_input_2");
		String Port_Name = Excel_data.get("Port_Name");
		String Time_Input = Excel_data.get("Time_Input");
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
		String From_Date_edit = Excel_data.get("From_Date_edit");
		String Search_type = Excel_data.get("Search_type");
		String Pop_up_for_Validation = Excel_data.get("Pop_up_for_Validation");
		String Ports_Status = Excel_data.get("Ports_Status");
		String Search3 = Excel_data.get("Search_input_3");
		String Time_input_perform = Excel_data.get("Time_input_perform");
		String Pop_up_perform = Excel_data.get("Pop_up_perform");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String date_Picker = Excel_data.get("date_Picker");
		String To_Voyage_Number_Header = Excel_data.get("To_Voyage_Number_Header");
		String From_Voyage_Number_Header = Excel_data.get("From_Voyage_Number_Header");
		String From_Port_Search = Excel_data.get("From_Port_Search");
		String To_Port_Search = Excel_data.get("To_Port_Search");
		String Location_Code_Header = Excel_data.get("Location_Code_Header");

		
		
		
		
		String beforeadjusttime = null;
		//

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
		scrollBottom(driver);
		Step_End(4, "Click on edit button ", test, test1);
		Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color))", test, test1);
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
						Step_End(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);

						RightClick(driver, voyage_Num);
						Step_Start(7, "Choose Adjust Time Option from the menu ", test, test1);
						mouseOverToElement(driver, AdjustTime);
						waitForElement(driver, AdjustTime1);
						safeclick(driver, AdjustTime1);

						Step_End(7, "Choose Adjust Time Option from the menu ", test, test1);

						Step_Start(8, "System should show a voyage details window box ", test, test1);
						waitForElement(driver, current_voyage);
						safeclick(driver, current_voyage);

						waitForElement(driver, current_voyage);

						horizontalscroll(driver, Scroll_1, 1500);

						List<WebElement> changedate = listOfElements(driver, changee);

						// Check if the list is not empty
						if (changedate.size() > 0) {
							// Get the last element in the list
							WebElement lastElement = changedate.get(changedate.size() - 1);

							// safeclick on the lagst element
							lastElement.click();

							beforeadjusttime = getText1(driver, lastElement);
							System.out.println(beforeadjusttime);
							doubleClick1(driver, lastElement);

						}

						Step_Start(10, "System should adjust the time based on the user value  ", test, test1);
						if (Time_input_perform.equals("YES")) {

							waitForElement(driver, Time_input);
							sendKeys(driver, Time_input, Time_Input);
						}
						Step_End(10, "System should adjust the time based on the user value  ", test, test1);

						// Selecting the From Date

						Step_Start(9, "Adjust the required fields to adjust the date  ", test, test1);
						selectDatePicker(driver, From_Date_edit);
						if (date_Picker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, From_Date_edit);
						} 
						click(driver, Close_Date);
						mouseOverToElement(driver, closedate);
						waitForElement(driver, closedate);
						click(driver, closedate);
						Step_End(9, "Adjust the required fields to adjust the date  ", test, test1);

						Step_Start(11, "Once the date is adjusted Click on move to Long Term button ", test, test1);
						waitForElement(driver, P_MoveTo_Long_Term_Btn);
						safeclick(driver, P_MoveTo_Long_Term_Btn);
						Step_End(11, "Once the date is adjusted Click on move to Long Term button ", test, test1);
						Step_End(8, "System should show a voyage details window box ", test, test1);
						Step_Start(12,
								"System should show validation if the given time of the current voyage last port dep pilot time is greater than the next voyage first port arrival pilot date ",
								test, test1);
						waitForPopup(driver, popup_Message, Pop_up_for_Validation);
						String portaddact = getText(driver, popup_Message);
						System.out.println(portaddact);

						if (Pop_up_for_Validation.equals(portaddact)) {
							System.out.println("Matched || " + " Expected Activity is[Before Adjust time] : "
									+ Pop_up_for_Validation + " || Actual Activity is [After adjust time]: "
									+ portaddact);
							Extent_pass_New(driver,
									"Matched || " + " Expected Activity is[Before Adjust time] : "
											+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
											+ portaddact,
									test, test1);
						} else {
							System.out.println("Not matched || " + " Expected Activity is[Before Adjust time] : "
									+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
									+ portaddact);
							Extent_fail(driver,
									"Not matched || " + " Expected Activity is [Before Adjust time]: "
											+ Pop_up_for_Validation + " || Actual Activity is[After adjust time] : "
											+ portaddact,
									test, test1);

						}

						Step_End(12,
								"System should show validation if the given time of the current voyage last port dep pilot time is greater than the next voyage first port arrival pilot date ",
								test, test1);

						// Popup want to click yes

						if (Pop_up_perform.equals("YES")) {

							waitForElement(driver, popup_Message_Yes_Button);
							safeclick(driver, popup_Message_Yes_Button);

							waitForElement(driver, popup_Message);
							String Updatedact = getText(driver, popup_Message);
							System.out.println(Updatedact);

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);

							String port_Date1 = String.format(port_Date_17, Port_Name, i);
							click(driver, port_Date1);

							RightClick(driver, port_Date1);

							mouseOverToElement(driver, AdjustTime);
							waitForElement(driver, AdjustTime1);
							safeclick(driver, AdjustTime1);

							waitForElement(driver, current_voyage);
							safeclick(driver, current_voyage);

							waitForElement(driver, current_voyage);
							horizontalscroll(driver, Scroll_1, 1500);

							waitForElement(driver, changee);

							List<WebElement> changedate1 = listOfElements(driver, changee);

							// Check if the list is not empty
							if (changedate1.size() > 0) {
								// Get the last element in the list
								WebElement lastElement = changedate1.get(changedate1.size() - 1);

								// safeclick on the last element
								lastElement.click();
							
//								waitForPopup(driver, lastElement, beforeadjusttime);
								String afteradjusttime = getText1(driver, lastElement);
								System.out.println(afteradjusttime);

								if (beforeadjusttime.equals(afteradjusttime)) {
									System.out.println("Matched || " + " Expected Activity is[Before Adjust time]: "
											+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
											+ afteradjusttime);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is[Before Adjust time] : "
													+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
													+ afteradjusttime,
											test, test1);
								} else {
									System.out.println("Not matched || "
											+ " Expected Activity is[Before Adjust time] : " + beforeadjusttime
											+ " || Actual Activity is [After adjust time]: " + afteradjusttime);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is[Before Adjust time] : "
													+ beforeadjusttime + " || Actual Activity is [After adjust time]: "
													+ afteradjusttime,
											test, test1);

								}

							}
						}

						// popup want to click No
						if (Pop_up_perform.equals("NO")) {

							waitForElement(driver, popup_Message_Ok_Button);
							safeclick(driver, popup_Message_Ok_Button);
							waitForElement(driver, closeButtonAdjustTime);
							safeclick(driver, closeButtonAdjustTime);

							String port_Date1 = String.format(port_Date_17, Port_Name, i);
							click(driver, port_Date1);

							RightClick(driver, port_Date1);

							mouseOverToElement(driver, AdjustTime);
							waitForElement(driver, AdjustTime1);
							safeclick(driver, AdjustTime1);

							waitForElement(driver, current_voyage);
							safeclick(driver, current_voyage);

							horizontalscroll(driver, Scroll_1, 1500);
							waitForElement(driver, changee);

							List<WebElement> changedate1 = listOfElements(driver, changee);
							// Check if the list is not empty
							if (changedate1.size() > 0) {
								// Get the last element in the list
								WebElement lastElement = changedate1.get(changedate1.size() - 1);

								// safeclick on the last element
								lastElement.click();
//                                waitForPopup(driver, lastElement, beforeadjusttime);
								String afteradjusttime = getText1(driver, lastElement);
								System.out.println(afteradjusttime);

								if (beforeadjusttime.equals(afteradjusttime)) {
									System.out.println("Matched || " + " Expected Activity is[Before Adjust time] : "
											+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
											+ afteradjusttime);
									Extent_pass_New(driver,
											"Matched || " + " Expected Activity is [Before Adjust time]: "
													+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
													+ afteradjusttime,
											test, test1);
								} else {
									System.out.println("Not matched || "
											+ " Expected Activity is[Before Adjust time] : " + beforeadjusttime
											+ " || Actual Activity is[After adjust time] : " + afteradjusttime);
									Extent_fail(driver,
											"Not matched || " + " Expected Activity is[Before Adjust time] : "
													+ beforeadjusttime + " || Actual Activity is[After adjust time] : "
													+ afteradjusttime,
											test, test1);

								}

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
		waitForElement(driver, Closeadjesttime);
		safeclick(driver, Closeadjesttime);

		ArrayList<String> portName = new ArrayList<String>();
		try {
			int i = 1;
			waitForElement(driver, vessels_code);

			List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);

			for (WebElement Vessel_Code : vessel_Codes) {

				if (Vessels_Code.equals(Vessel_Code.getText())) {
					String num = String.valueOf(i);
					String voyage_Num = String.format(voyage_Num_l, num);

					waitForElement(driver, voyage_Num);
					if (Voyage_Number.equals(getText(driver, voyage_Num))) {
						String port_Date = String.format(port_Date_17, Port_Name, i);
						click(driver, port_Date);

						RightClick(driver, port_Date);
						Step_End(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);

						RightClick(driver, voyage_Num);

						mouseOverToElement(driver, AdjustTime);
						waitForElement(driver, AdjustTime1);
						safeclick(driver, AdjustTime1);

						waitForElement(driver, Getmarinedistance1);
						safeclick(driver, Getmarinedistance1);
						
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
						safeclick(driver, Closeadjesttime);

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
									Extent_pass_New(driver,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value,
											test, test1);
									Extent_call(test, test1,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value);
									System.out.println("Expected result is : distance should not be Equal || Actual Result is : Distance is not Equal");

								} else {
									System.out.println("Expected result is : distance should not be Equal || Actual Result is : Distance is not Equal");
									Extent_pass_New(driver,
											"***Value taken from long term***" + portName.get(k) + "***"
													+ portName.get(k + 1) + "******" + Distance.get(k)
													+ "***Values taken from Distsnce***" + distance_value,
											test, test1);

								}

							} else {

								System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
								Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);

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

				System.out.println("Expected result is : ports should not be Active || Actual Result is : Ports is active");
				Extent_pass_New(driver, "Expected result is : ports should not be Active || Actual Result is : Ports is active", test, test1);

			}
		}
		Extent_completed(testcase_Name, test, test1);

	}

}
