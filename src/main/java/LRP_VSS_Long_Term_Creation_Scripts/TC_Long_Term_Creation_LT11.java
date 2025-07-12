package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT11 extends Keywords {

	public void permenentvoyage(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT11";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number").trim();
		String Port_Add_Pop_Exp = Excel_data.get("Port_Add_Pop_Exp");
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
		
		Extent_completed(testcase_Name, test, test1);
	}

}
