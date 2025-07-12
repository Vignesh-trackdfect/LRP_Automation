package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT03_I extends Keywords {

	public void conformingthedraft(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT03_I";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Pop_up_for_confirm = Excel_data.get("Pop_up_for_confirm");
		String Voyage_Confirmed_popEXP = Excel_data.get("Voyage_Confirmed_pop");
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
		String Search2 = Excel_data.get("Service_input_2");
		String Search3 = Excel_data.get("Search_input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		String Search_type = Excel_data.get("Search_type");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String date_Picker = Excel_data.get("date_Picker");
		String To_Voyage_Number_Header = Excel_data.get("To_Voyage_Number_Header");
		String From_Voyage_Number_Header = Excel_data.get("From_Voyage_Number_Header");
		String From_Port_Search = Excel_data.get("From_Port_Search");
		String To_Port_Search = Excel_data.get("To_Port_Search");
		String Location_Code_Header = Excel_data.get("Location_Code_Header");





		
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		// searching for module

		// searching for module

		moduleNavigate(driver, Search);
		Step_Start(1, "Retirve the Record via Global Search ",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		Step_End(1, "Retirve the Record via Global Search  ",test, test1);
		Step_Start(2, "Enter the Service Code in the Service Code field ",test, test1);
		
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, service_select);

		Step_End(2, "Enter the Service Code in the Service Code field",test, test1);
		Step_Start(3, "Click on Ok button ",test, test1);
		Step_End(3, "Click on Ok button  ",test, test1);


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
		if(!From_cycle_input.equals("")) {
			waitForElement(driver, From_cycle);
			clearAndType(driver, From_cycle, From_cycle_input);
		}

		// To cycle input 
		if(!To_cycle_input.equals("")) {
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
		Step_Start(4, "Click on edit button",test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Edit_Button_toolBar);
		Step_End(4, "Click on edit button ",test, test1);
		scrollBottom(driver);





		List<String> firstHeaders = splitAndExpand1(Vessels_Code);
		List<String> secondHeaders = splitAndExpand1(Voyage_Number);

		Actions actions = new Actions(driver);
		int i = 0;
		for(String firstHeader : firstHeaders) {
			// Locate the table headers
			List<WebElement> tableHeaders = listOfElements(driver, vessel_Code_Header_LT);
			List<WebElement> vessel_Codes = listOfElements(driver, Vessel_Codes_LT);

			// Loop through both header lists

			for (int j=0;j<tableHeaders.size();j++) {
				// Get the current headers for comparison
				String firstTableHeader = tableHeaders.get(j).getText(); // First column header
				String secondTableHeader = vessel_Codes.get(j).getText(); // Second column header

				// Check for matches
				if (firstTableHeader.equals(firstHeaders.get(i)) && secondTableHeader.equals(secondHeaders.get(i))) {
		 // Perform control-click on first headers
					WebElement headerElement = tableHeaders.get(j);
					actions.keyDown(Keys.CONTROL).click(headerElement).keyUp(Keys.CONTROL).perform();

					// Right-click on one of the selected headers (you can choose one of the selected elements)
					i++;
					if(i==firstHeaders.size()) {
						break;
					}
					// Add any additional actions you want to perform after the right-click
				} 
			}
			if(i==firstHeaders.size()) {
				break;
			}
		}
		String rightClickElement = String.format(Voy_Num_LT, secondHeaders.get(0));

		waitForElement(driver, rightClickElement);
		RightClick(driver, rightClickElement);
		RightClick(driver, rightClickElement);

		Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ",test, test1);
		Step_Start(6, "Choose Confirm Option ",test, test1);
						waitForElement(driver, Conformbtnlongterm);
						safeclick(driver, Conformbtnlongterm);
						
						Step_End(6, "Choose Confirm Option",test, test1);
						Step_Start(7, "System should show a pop message of confirming to user to change the status ",test, test1);
						waitForPopup(driver, popup_Message, Pop_up_for_confirm);
						String wantconformAct=getText(driver, popup_Message);
						System.out.println(wantconformAct);
								if (wantconformAct.equals(Pop_up_for_confirm)) {
									System.out
											.println("Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
									Extent_pass_New(driver,
											"Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);
								} else {
									System.out.println(
											"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
									Extent_fail(driver,
											"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);
									
								}
								waitForElement(driver, popup_Message_Yes_Button);
								safeclick(driver, popup_Message_Yes_Button);
						
						
							
								if(isDisplayed(driver, continuebutton)) {
									waitForElement(driver, continuebutton);
									safeclick(driver, continuebutton);
									}else {
										System.out.println("Expected Result is : Continue button not displayed ||  Actual Result is : Continue button not displayed");
									}
								Step_End(7, "System should show a pop message of confirming to user to change the status  ",test, test1);
								
						waitForElement(driver, popup_Message_Ok_Button);
						Step_Start(9, "System should show a pop up message of “Voyage Confirmed”",test, test1);
						Step_Start(10, "verify that that should be white colour ang have popup for that validation.",test, test1);
						waitForPopup(driver, popup_Message, Voyage_Confirmed_popEXP);
						String Voyage_Confirmed_popAct =getText(driver, popup_Message);
						System.out.println(Voyage_Confirmed_popAct);

						if (Voyage_Confirmed_popEXP.equals(Voyage_Confirmed_popAct)) {
							System.out
									.println("Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
							Extent_pass_New(driver,
									"Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);
							Extent_pass_New(driver, "**********Voyage was conformed and background was changed to white colour********", test, test1);
						} else {
							System.out.println(
									"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
							Extent_fail(driver,
									"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);
							
						}
						Step_End(9, "System should show a pop up message of “Voyage Confirmed” ",test, test1);
						waitForElement(driver, popup_Message_Ok_Button);
						safeclick(driver, popup_Message_Ok_Button);
						
					    	Step_Start(8, "Clicking on ok should turn voyage color to White",test, test1);
						
						Extent_pass_New(driver, "***Voayage was selected to confotm id*****"+Voyage_Number, test, test1);
						Extent_pass_New(driver, "**********Voyage was conformed and background was changed to white colour********", test, test1);
						Step_End(8, "Clicking on ok should turn voyage color to White",test, test1);
						Step_End(10, "verify that that should be white colour ang have popup for that validation.",test, test1);

		ArrayList<String> portName = new ArrayList<String>();
		i = 0;
		for (String firstHeader : firstHeaders) {
			// Locate the table headers
			List<WebElement> tableHeaders = listOfElements(driver, vessels_code);
			List<WebElement> vessel_Codes = listOfElements(driver, voyage_Num_1);
			// Loop through both header lists

			for (int j = 0; j < tableHeaders.size(); j++) {
				// Get the current headers for comparison
				String firstTableHeader = tableHeaders.get(j).getText(); // First column header
				String secondTableHeader = vessel_Codes.get(j).getText(); // Second column header

				// Check for matches
				if (firstTableHeader.equals(firstHeaders.get(i)) && secondTableHeader.equals(secondHeaders.get(i))) {
					// Perform control-click on first headers
					WebElement headerElement = tableHeaders.get(j);
					actions.keyDown(Keys.CONTROL).click(headerElement).keyUp(Keys.CONTROL).perform();

					// Right-click on one of the selected headers (you can choose one of the
					// selected elements)
					i++;
					if (i == firstHeaders.size()) {
						break;
					}
					// Add any additional actions you want to perform after the right-click
				}
			}
			if (i == firstHeaders.size()) {
				break;
			}
		}
		waitForElement(driver, rightClickElement);
		RightClick(driver, rightClickElement);
		RightClick(driver, rightClickElement);

		mouseOverToElement(driver, AdjustTime);
		waitForElement(driver, AdjustTime2);
		click(driver, AdjustTime2);

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
			
			if (isDisplayed(driver, Popup_Message)) {

				System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
				Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
						+ portName.get(k + 1), test, test1);
				waitForElement(driver, Popup_Message);
				safeclick(driver, Popup_Message);

			} else {

				System.out.println("Expected result is : distance should not be found || Actual Result is : Distance is not found");
				Extent_pass_New(driver, "Expected result is : distance should not be found || Actual Result is : Distance is not found", test, test1);
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
					System.out.println("Expected result is : distance should  be Equal || Actual Result is : Distance is  Equal");

					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);
					Extent_call(test, test1,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value);
					System.out.println("Expected result is : distance should  be Equal || Actual Result is : Distance is  Equal");

				} else {
					System.out.println("Expected result is : distance should not be Equal || Actual Result is : Distance is not Equal");

					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);

				}

			} else {

				System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
				Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);

			}
		}
			
		
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		
		moduleNavigate(driver, Search3);

		for (int D = 0; D < portName.size(); D++) {
			if (D + 1 >= portName.size()) {
				break;
			}

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Search_type, Location_Code_Header, portName.get(D), "", "", "", "");
			
			Extent_call(test, test1, "Verify the status of port code");
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
