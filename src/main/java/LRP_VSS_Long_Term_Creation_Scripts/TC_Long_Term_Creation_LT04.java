package LRP_VSS_Long_Term_Creation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT04 extends Keywords {

	public void renamevessels(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Long_Term_Creation_LT04";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String service_select = Excel_data.get("service_select");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Add_Vessels_Perform = Excel_data.get("Add_Vessels_Perform");
		String Add_TBN_Vessels_Perform = Excel_data.get("Add_TBN_Vessels_Perform");
		String Add_Empty_Vessels_Perform = Excel_data.get("Add_Empty_Vessels_Perform");
		String Add_Vessels = Excel_data.get("Add_Vessels");
		String Future_Cycle_Perform = Excel_data.get("Future_Cycle_Perform");
		String Future_Renamed_Pop_Exp = Excel_data.get("Future_Renamed_Pop_Exp");
		String Current_Renamed_Pop_Exp = Excel_data.get("Current_Renamed_Pop_Exp");
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
		String Service_Code_Header  = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Header  = Excel_data.get("Vessel_Code_Header");
		String From_Voyage_Number_Header  = Excel_data.get("From_Voyage_Number_Header");
		String Condition_Filter  = Excel_data.get("Condition_Filter");
		String To_Voyage_Number_Header  = Excel_data.get("To_Voyage_Number_Header");
		String date_Picker  = Excel_data.get("date_Picker");
		String Vessel_Code_Header_Rename  = Excel_data.get("Vessel_Code_Header_Rename");

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

		Step_End(4, "Click on edit button ", test, test1);
		scrollBottom(driver);
		// renaming vessels
		Step_Start(5, "Right Click on the Draft voyage (Indicating in blue color)", test, test1);
		List<String> beforename = new ArrayList<>();

		String Voyage_Num = String.format(voyage_Num, Voyage_Number);
		waitForElement(driver, Voyage_Num);
		String actualVoyage = getText(driver, Voyage_Num);

		waitForElement(driver, vessels_code);

		List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);


		for (WebElement Vessel_Code : vessel_Codes) {
			waitForElement(driver, Vessel_Code);

			if (Vessels_Code.equals(Vessel_Code.getText()) && Future_Cycle_Perform.equalsIgnoreCase("YES")) {

				String before = getText1(driver, Vessel_Code);
				beforename.add(before);
				System.out.println(beforename);

			}
			if (Vessels_Code.equals(Vessel_Code.getText()) && actualVoyage.equals(Voyage_Number)
					&& Future_Cycle_Perform.equalsIgnoreCase("NO")) {

				String before = getText1(driver, Vessel_Code);
				beforename.add(before);
				System.out.println(beforename);
				break;
			}

		}

		System.out.println("actualVoyage:" + actualVoyage);
		System.out.println("Voyage_Number:" + Voyage_Number);

		waitForElement(driver, Voyage_Num);
		click(driver, Voyage_Num);
		waitForElement(driver, Voyage_Num);
		RightClick(driver, Voyage_Num);

		Step_End(5, "Right Click on the Draft voyage (Indicating in blue color) ", test, test1);
		Step_Start(6, "Choose Add/Rename Option", test, test1);
		scrollUsingElement(driver, renameLT);
		waitForElement(driver, renameLT);
		mouseOverToElement(driver, renameLT);
		Step_End(6, "Choose Add/Rename Option ", test, test1);
		Step_Start(7, "Choose Rename Vessel Option from the sub menu ", test, test1);
		waitForElement(driver, Renamevessels);
		safeclick(driver, Renamevessels);
		Step_End(7, "Choose Rename Vessel Option from the sub menu ", test, test1);
		Step_Start(8, "System should show a dialog box", test, test1);
		Step_Start(9, "Enter the Vessel to be Renamed ", test, test1);

		if (Add_Vessels_Perform.equals("YES")) {
			if (Add_Vessels_Perform.equals("YES")) {
				waitForElement(driver, renameFrameSearchIcon);
				safeclick(driver, renameFrameSearchIcon);
				twoColumnSearchWindow(driver, Vessel_Code_Header_Rename, Condition_Filter, Add_Vessels);
				Extent_pass_New(driver, "Expected Result is : Vessels should be selected as "+ Add_Vessels + "Actual Result is : Vessels should be selected as "+ Add_Vessels , test, test1);
			}
		}

		if (Add_TBN_Vessels_Perform.equals("YES")) {
			if (Add_TBN_Vessels_Perform.equals("YES")) {
				waitForElement(driver, Tbn_radio_btn);
				safeclick(driver, Tbn_radio_btn);
				Extent_pass_New(driver, "Expected Result is : Vessels should be selected as [TBN] || Actual  Result is : Vessels should be selected as [TBN]", test, test1);

			}
		}

		if (Add_Empty_Vessels_Perform.equals("YES")) {
			if (Add_Empty_Vessels_Perform.equals("YES")) {
				waitForElement(driver, blank_radio_btn);
				safeclick(driver, blank_radio_btn);
				Extent_pass_New(driver, "Expected Result is : Vessels should be selected as [Empty vessels] || Actual  Result is : Vessels should be selected as [Empty vessels]", test, test1);

			}
		}

		Step_End(9, "Enter the Vessel to be Renamed ", test, test1);

		Step_Start(10,
				"Choose Whether the Renaming of the vessel should affect the future cycles of the renaming vessel",
				test, test1);
		// selecting future
		Step_Start(11, "Choose Future Voyages ", test, test1);
		if (Future_Cycle_Perform.equals("YES")) {
			if (Future_Cycle_Perform.equals("YES")) {
				Step_End(11, "Choose Future Voyages ", test, test1);
				Step_Start(12, "Click on ok  ", test, test1);
				waitForElement(driver, okRename);
				safeclick(driver, okRename);
				Step_End(12, "Click on ok  ", test, test1);

				waitForPopup(driver, popup_Message, Future_Renamed_Pop_Exp);
				String Future_Rename_Pop_Act = getText(driver, popup_Message);
				System.out.println(Future_Rename_Pop_Act);
				Step_Start(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
				if (Future_Renamed_Pop_Exp.equals(Future_Rename_Pop_Act)) {
					System.out.println("Matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
							+ " || Actual popup is : " + Future_Rename_Pop_Act);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
							+ " || Actual popup is : " + Future_Rename_Pop_Act, test, test1);
				} else {
					System.out.println("Not matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
							+ " || Actual popup is : " + Future_Rename_Pop_Act);
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + Future_Renamed_Pop_Exp
							+ " || Actual popup is : " + Future_Rename_Pop_Act, test, test1);

				}
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
				Step_End(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
			}
		}
		Step_End(10, "Choose Whether the Renaming of the vessel should affect the future cycles of the renaming vessel",
				test, test1);
		// selecting current status as addind vessels


		Step_Start(13, "Choose Whether the Renaming of the vessel should affect ony the current cycle of the vessel ",
				test, test1);
		Step_Start(14, "Choose Current Voyages  ", test, test1);
		if (Future_Cycle_Perform.equals("NO")) {
			if (Future_Cycle_Perform.equals("NO")) {

				waitForElement(driver, Selec_current_butn);
				safeclick(driver, Selec_current_butn);
				Step_End(14, "Choose Current Voyages  ", test, test1);
				Step_Start(15, "Click on ok ", test, test1);
				waitForElement(driver, okRename);
				safeclick(driver, okRename);
				Step_End(15, "Click on ok ", test, test1);
				Step_Start(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
                 waitForPopup(driver, popup_Message, Current_Renamed_Pop_Exp);
				String Current_Rename_Pop_Act = getText(driver, popup_Message);
				System.out.println(Current_Rename_Pop_Act);

				if (Current_Renamed_Pop_Exp.equals(Current_Rename_Pop_Act)) {
					System.out.println("Matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
							+ " || Actual Popup is : " + Current_Rename_Pop_Act);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
							+ " || Actual Popup is : " + Current_Rename_Pop_Act, test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					safeclick(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
							+ " || Actual Popup is : " + Current_Rename_Pop_Act);
					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + Current_Renamed_Pop_Exp
							+ " || Actual Popup is : " + Current_Rename_Pop_Act, test, test1);

				}

			}
		}
		Step_End(16, "Now system should show a validation “Vessel Renamed” ", test, test1);
		Step_End(13, "Choose Whether the Renaming of the vessel should affect ony the current cycle of the vessel ",
				test, test1);

		List<String> afterrename = new ArrayList<>();

		waitForElement(driver, vessels_code);

		List<WebElement> vessel_Codes1 = listOfElements(driver, vessels_code);
		for (WebElement Vessel_Code : vessel_Codes1) {
			waitForElement(driver, Vessel_Code);

			String voyage_Num1 = String.format(voyage_Num, Voyage_Number);
			waitForElement(driver, voyage_Num1);
			String actualVoyage1 = getText(driver, voyage_Num1);

			if (Add_Vessels.equals(Vessel_Code.getText()) && Future_Cycle_Perform.equalsIgnoreCase("YES")) {

				waitForElement(driver, Vessel_Code);

				String After = getText1(driver, Vessel_Code);
				afterrename.add(After);
				System.out.println(afterrename);

			}
			if (Add_Vessels.equals(Vessel_Code.getText()) && actualVoyage1.equals(Voyage_Number)
					&& Future_Cycle_Perform.equalsIgnoreCase("NO")) {

				waitForElement(driver, Vessel_Code);

				String After = getText1(driver, Vessel_Code);
				afterrename.add(After);
				System.out.println(afterrename);
				break;
			}

		}
		if (!beforename.equals(afterrename)) {
			System.out.println("Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ afterrename);
			Extent_pass_New(driver, "Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name should be changed as "+ afterrename,
					test, test1);

		} else {

			System.out
					.println("Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name is not changed as "+ afterrename);
			Extent_fail(driver,
					"Matched || The expected Result is : Once user before Renaming  the vessel , vessel name is "+ beforename + "|| Acutal result is : Once user after Renaming  the vessel , vessel name is not changed as "+ afterrename, test,
					test1);

		}
		Extent_completed(testcase_Name, test, test1);
	}
}
