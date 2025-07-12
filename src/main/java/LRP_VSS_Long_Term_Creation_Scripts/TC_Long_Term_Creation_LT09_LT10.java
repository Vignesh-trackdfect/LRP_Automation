package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT09_LT10 extends Keywords {

	public void ommitandrollbackport(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name = "TC_Long_Term_Creation_LT09_LT10";
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Port_Name = Excel_data.get("Port_Name");
		String Port_Ommit_Pop_Exp = Excel_data.get("Port_Ommit_Pop_Exp");
		String Add_Pord_colour = Excel_data.get("Add_Pord_colour");
		String Rolled_Back_pop_exp = Excel_data.get("Rolled_Back_pop_exp");
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
		String Rolled_Back_Gird_pop_exp = Excel_data.get("Rolled_Back_Gird_pop_exp");
		String To_voyage_perform = Excel_data.get("To_voyage_perform");
		String From_Voyage_Perform = Excel_data.get("From_Voyage_Perform");
		String From_voyage_Input = Excel_data.get("From_voyage_Input");
		String To_voyage_Input = Excel_data.get("From_voyage_Input");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Ommit_Colour_exp = Excel_data.get("Ommit_Colour_exp");
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
					
						waitForDisplay(driver, reference);
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

}
