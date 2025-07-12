package LRP_CRO_Scripts;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC052 extends Keywords {

	public void CRO_SC052(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC052";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Container_rows = Excel_data.get("Container_rows");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String condition = Excel_data.get("condition");
		
		String containerRows = Excel_data.get("containerRows");
		String commodity_Desc_Input=Excel_data.get("commodity_Desc_Input");
		
		String equipment_Id=Excel_data.get("equipment_Id");
		String shipper_seal=Excel_data.get("shipper_seal");
		String carrier_seal=Excel_data.get("carrier_seal");
		String cargo_Weight=Excel_data.get("cargo_Weight");
		String Volume=Excel_data.get("Volume");
		String Package_Input=Excel_data.get("Package_Input");
		String Marks_No=Excel_data.get("Marks_No");
		String HS_Code_Input=Excel_data.get("HS_Code_Input");
		String dd1_condition = Excel_data.get("dd1_condition");
		String select_by_commodity_code = Excel_data.get("select_by_commodity_code");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String Release_Terminal_Input = Excel_data.get("Release_Terminal_Input");
		String Acceptance_Terminal_Header = Excel_data.get("Acceptance_Terminal_Header");
		String Acceptance_Terminal_Input = Excel_data.get("Acceptance_Terminal_Input");
		String Release_Terminal_Header = Excel_data.get("Release_Terminal_Header");
		String Cro_quan = Excel_data.get("Cro_quan");
		String Excepted_CRO_Saved_PopUp = Excel_data.get("Excepted_CRO_Saved_PopUp");
		
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Open the browser", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Open the browser", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, " Click on Login Button", test, test1);

		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_End(4, " Click on Login Button", test, test1);
		Step_Start(5, "Switch the agency", test, test1);

		SwitchProfile(driver, agencyUser);
		
		Step_End(5, "Switch the agency", test, test1);
		
		Step_Start(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);

		moduleNavigate(driver, Booking_Module_Name);

		Step_End(6, "Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);
		
		Step_Start(7, "Enter the agr party", test, test1);

		Extent_cal(test, test1, Booking_Module_Name);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(7, "Enter the agr party", test, test1);
		
		Step_Start(8, "Enter the orgin", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		Step_End(8, "Enter the orgin", test, test1);
		
		Step_Start(9, "Enter the Delivery", test, test1);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		Step_End(9, "Enter the Delivery", test, test1);
		Step_Start(10, "Click the Rates", test, test1);
		Step_Start(11, "Select the rates", test, test1);

		
		waitForDisplay(driver, Draft_Button);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		Step_End(10, "Click the Rates", test, test1);
		Step_End(11, "Select the rates", test, test1);
		Step_Start(12, "Click the draft button and save ", test, test1);

			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);
		
		Step_End(12, "Click the draft button and save ", test, test1);
		Step_Start(13, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);



		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
		}


		Step_End(13, "Validate the pop up  after  saved  [BOOKING SAVED]", test, test1);
		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		}
		Step_End(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
		
		
		Step_Start(15, "Click the edit Button", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(15, "Click the edit Button", test, test1);
		
		
		Step_Start(16, "Click container tab", test, test1);
		
		waitForElement(driver, Container_Tab);
		click(driver, Container_Tab);

		Step_End(16, "Click container tab", test, test1);
		
		
		Step_Start(17, " Click the container in grid.", test, test1);
		
		waitForElement(driver, select_Container);
		click(driver, select_Container);
		waitForElement(driver, select_Container);
		RightClick(driver, select_Container);
		
		Step_End(17, "Click the container in grid.", test, test1);
		
		Step_Start(18, "Right click and click copy option.", test, test1);
		
		waitForElement(driver, Container_copy);
		click(driver, Container_copy);

		waitForElement(driver, select_Container);
		RightClick(driver, select_Container);
		
		Step_End(18, "Right click and click copy option.", test, test1);
		
		Step_Start(19, "Enter the rows (4) and click ok button", test, test1);
		
		waitForElement(driver, Copy_Rows_Value);
		sendKeys(driver, Copy_Rows_Value, Container_rows);
		int CopuNum = Integer.parseInt(Container_rows);

		waitForElement(driver, Copy_OkBtn);
		click(driver, Copy_OkBtn);
		
		System.out.println("the passing value: " + CopuNum);
		
		Step_End(19, "Enter the rows (4) and click ok button", test, test1);
		
		Step_Start(20, "Click smart import button and add the actual eqp.ID, Carrier seal and shipper seal", test, test1);
		
		waitForElement(driver, smart_import_btn);
		click(driver, smart_import_btn);
		
		StringSelection eqpID = new StringSelection(equipment_Id);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(eqpID, null);
        
        
        Actions action = new Actions(driver);
        
        waitForElement(driver, actual_Eqp_ID_gridcell);
		mouseOverToElement(driver, actual_Eqp_ID_gridcell);
		click(driver, actual_Eqp_ID_gridcell);
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		StringSelection carrierSeal = new StringSelection(carrier_seal);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(carrierSeal, null);
        
        waitForElement(driver, carrierSeal_Gridcell);
  		mouseOverToElement(driver, carrierSeal_Gridcell);
  		click(driver, carrierSeal_Gridcell);
  		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
  		
  		StringSelection shipperSeal = new StringSelection(shipper_seal);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(shipperSeal, null);
        
        waitForElement(driver, shipperSeal_Gridcell);
  		mouseOverToElement(driver, shipperSeal_Gridcell);
  		click(driver, shipperSeal_Gridcell);
  		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
  		

		
		Step_End(20, "Click smart import button and add the actual eqp.ID, Carrier seal and shipper seal", test, test1);
		
		
		Step_Start(21, "Click paste button.", test, test1);
		
		waitForElement(driver, paste_Button_BKG);
		safeclick(driver, paste_Button_BKG);
		
		Step_End(21, "Click paste button.", test, test1);
		
		Step_Start(22, " Validate the actual container then change and past again.", test, test1);
		
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
		}
		
		Step_End(22, " Validate the actual container then change and past again.", test, test1);
		
		Step_Start(23, "Click commodity tab", test, test1);
		
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		
		Step_End(23, " Click commodity tab", test, test1);
		
		Step_Start(24, "Click the 1st row commodity.", test, test1);


		waitForElement(driver, Commodity_first_grid);
		safeclick(driver, Commodity_first_grid);
		
		Step_End(24, "Click the 1st row commodity.", test, test1);
		
		
		Step_Start(25, " Enter the package", test, test1);
		
		waitForElement(driver, commodity_Package_B);
		safeclick(driver, commodity_Package_B);
		sendKeys(driver, commodity_Package_B, Package_Input);
		enter(driver);
		
		Step_End(25, " Enter the package", test, test1);
		
		Step_Start(26, " Enter the commodity Group", test, test1);
			
		Step_End(26, " Enter the commodity Group", test, test1);
		
		
        Step_Start(27, "Enter the HS Code and HS code name fetched automatically.", test, test1);
        
        waitForElement(driver, HS_Code_Search_B);
		safeclick(driver, HS_Code_Search_B);
		globalValueSearchWindow(driver, dd1_condition, select_by_commodity_code, HS_Code_Input, "", "", "", "");
		
		Step_End(27, "Enter the HS Code and HS code name fetched automatically.", test, test1);
		
		
        Step_Start(28, "Enter the Cargo weight.", test, test1);
        
        waitForElement(driver, commodity_Cargo_Weight_B);
		safeclick(driver, commodity_Cargo_Weight_B);
		clearAndType(driver, commodity_Cargo_Weight_B, cargo_Weight);
		
		Step_End(28, "Enter the Cargo weight.", test, test1);
		
		
        Step_Start(29, " Enter the Volume.", test, test1);
		
        waitForElement(driver, commodity_Volume_B);
		safeclick(driver, commodity_Volume_B);
		clearAndType(driver, commodity_Volume_B, Volume);

		
		Step_End(29, " Enter the Volume.", test, test1);
		
		
		
        Step_Start(30, "Enter the mark and No.", test, test1);
        
        waitForElement(driver, commodity_MarksNo_B);
		safeclick(driver, commodity_MarksNo_B);
		sendKeys(driver, commodity_MarksNo_B, Marks_No);
		
		Step_End(30, "Enter the mark and No.", test, test1);
		
		
        Step_Start(31, " Enter the commodity Desc.", test, test1);
        
        waitForElement(driver, commodity_Desc_B);
		click(driver, commodity_Desc_B);
		Actionsendkeys(driver, commodity_Desc_B, commodity_Desc_Input);
		
		
		Step_End(31, " Enter the commodity Desc.", test, test1);
		
		
        Step_Start(32, "Click edit button then details added in grid.", test, test1);
               
		
        waitForElement(driver, commodity_Add_B);
		safeclick(driver, commodity_Add_B);
		

		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);
			
		}
		
		Step_End(32, "Click edit button then details added in grid.", test, test1);
		
		
        Step_Start(33, "Remove the remaining commodities", test, test1);
        
        int noOfComm=Integer.parseInt(containerRows);
		for(int i=noOfComm+1; i>1;i--) {

			String commodity_Select=String.format(commodity, i);
			waitForElement(driver, commodity_Select);
			click(driver,commodity_Select);
			
			waitForElement(driver, commidityRemove_Button);
			click(driver, commidityRemove_Button);

		}
		
		Step_End(33, "Remove the remaining commodities", test, test1);
		
		 Step_Start(34, " Right Click the 1st row commodity.", test, test1);
		 
		 scrollBottom(driver);
			waitForElement(driver, Commodity_first_grid);
			safeclick(driver, Commodity_first_grid);
		 
			waitForElement(driver, Commodity_first_grid);
			RightClick(driver, Commodity_first_grid);
			
		 Step_End(34, " Right Click the 1st row commodity.", test, test1);
			
			
		 Step_Start(35, "Click multi copy", test, test1);
		 
		 waitForElement(driver, Multi_copy_click);
			click(driver, Multi_copy_click);
			
			waitForElement(driver, Multi_copy_click_all);
			click(driver, Multi_copy_click_all);
				
		 Step_End(35, "Click multi copy", test, test1);
		 
		 Step_Start(36, "Select all the containers and click OK button all commodity added in grid.", test, test1);
		 
		 waitForElement(driver, Multi_copy_click_all_ok);
			click(driver, Multi_copy_click_all_ok);
			
		 Step_End(36, "Select all the containers and click OK button all commodity added in grid.", test, test1);
		 
		 
		 Step_Start(37, "Click charges tab.", test, test1);
		 
		 waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);
			
			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);
			
		 Step_End(37, "Click charges tab.", test, test1);

		 
		 Step_Start(38, "Click auto rate the charges.", test, test1);
		 
		 
		 waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

			
		 Step_End(38, "Click auto rate the charges.", test, test1);
		 
		 
		 Step_Start(39, "Click on save button", test, test1);
			
		    scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			
		 Step_End(39, "Click on save button", test, test1);
		 
		 
		 Step_Start(40, "Swift to the master tab and click on confirm button", test, test1);
		 
		    waitForElement(driver, master_tab);
			click(driver, master_tab);

			String booknum = getAttribute(driver, booking_no,"value");
			System.out.println(booknum);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
		 
			waitForElement(driver, Confirmed_Button);
			safeclick(driver, Confirmed_Button);
			
		 Step_End(40, "Swift to the master tab and click on confirm button", test, test1);
		 
		 
		 Step_Start(41, "Click on Save Button", test, test1);
		 
		  scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			
		 Step_End(41, "Click on Save Button", test, test1);
		
		 Step_Start(42, "Validate the popup After clicking save button[BOOKING SAVED]", test, test1);
		 
		 waitForPopup(driver, popup_Message,bookingUpdatedPopup);
			String saved_conformed_pop_act = getText(driver, popup_Message);
			System.out.println(saved_conformed_pop_act);
			// validate the saved conform popup
			System.out.println("**********Verifting the saved popup **********");
			Extent_call(test, test1,"**********Verifting the saved popup**********");
			if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
				System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act);            
				Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);        
				Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1); 
			} 
			
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver,popup_Message_Ok_Button);
			
		 Step_End(42, "Validate the popup After clicking save button[BOOKING SAVED]", test, test1);
		 
		 Step_Start(43, "Validate the colour of Booking number field [Green colour]", test, test1);
		 
		// validate the colour of booking number field after conform
			Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
			waitForElement(driver, booking_no);
			String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
			if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
				System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
				Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
				Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
			} 
			
		 Step_End(43, "Validate the colour of Booking number field [Green colour]", test, test1);
		 
		 
		 Step_Start(44, "Navigate CRO from booking.", test, test1);
		 
		 waitForElement(driver, CRO_btn);
			click(driver, CRO_btn);
			
		 Step_End(44, "Navigate CRO from booking.", test, test1);
		 
		 
		 Step_Start(45, "Click edit button.", test, test1);
		
		 waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		 
		 Step_End(45, "Click edit button.", test, test1);
		 
		 Step_Start(46, "Select Release Depot/Terminal.", test, test1);
		 
		 waitForElement(driver, Release_Terminal_SearchButton_CRO);
			click(driver, Release_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, Release_Terminal_Header, Serach_Condition, Release_Terminal_Input);
			
		 Step_End(46, "Select Release Depot/Terminal.", test, test1);
		 
		 Step_Start(47, "Select Acceptance Terminal.", test, test1);
		 
		 waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		 click(driver, acceptance_Terminal_SearchButton_CRO);
		 twoColumnSearchWindow(driver, Acceptance_Terminal_Header, Serach_Condition, Acceptance_Terminal_Input);
			
		 Step_End(47, "Select Acceptance Terminal.", test, test1);
		 
		 Step_Start(48, "Double click the container type grid.", test, test1);
		 
		    waitForElement(driver, Container_Type_CRO);
			doubleClick(driver, Container_Type_CRO);
		 
		 Step_End(48, "Double click the container type grid.", test, test1);
		 
		 
		 Step_Start(49, "Edit quantity (3)", test, test1);
		 
		 waitForElement(driver, CRO_Quantity);
		   click(driver, CRO_Quantity);
		   waitForElement(driver, CRO_Quantity);
		   clear(driver, CRO_Quantity);
		   waitForElement(driver, CRO_Quantity);
			sendKeys(driver, CRO_Quantity, Cro_quan);
			
		 Step_End(49, "Edit quantity (3)", test, test1);
		 
		 
		 Step_Start(50, "Click edit button.", test, test1);
		 
		 waitForElement(driver, CRO_Edit_btn);
			click(driver, CRO_Edit_btn);	
			
		 Step_End(50, "Click edit button.", test, test1);
		 
		 
		 Step_Start(51, "Click save button.", test, test1);
		 
		 scrollTop(driver);
		 waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
		 Step_End(51, "Click save button.", test, test1);
		 
		 Step_Start(52, "CRO is saved message shown.", test, test1);
			
		 String Actual_Saved_Popup = getText(driver, Popup_Message);
			if (Excepted_CRO_Saved_PopUp.equals(Actual_Saved_Popup)) {
				System.out.println( "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup);
				Extent_pass_New(driver, "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
			} else {
				System.out.println( " Not Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup);
				Extent_fail(driver, " Not Matched ||  Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup, test, test);
			
			}
			
			
			 scrollTop(driver);
			  waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				
		 Step_End(52, "CRO is saved message shown.", test, test1);
		 
		 Step_Start(53, "Click create button.", test, test1);
		 
		 
		    waitForElement(driver, Booking);
			click(driver, Booking);
			
		    waitForElement(driver, Booking_no);
			String Book_no = getAttribute(driver, Booking_no, "value");
			System.out.println("Booking_NumberBefore :"+Book_no);
			
			waitForElement(driver,NewButton_ToolBar );
			click(driver, NewButton_ToolBar);
			
			waitForElement(driver,cancel_Common_btn );
			click(driver, cancel_Common_btn);
		 
		 Step_End(53, "Click create button.", test, test1);
		 
		 Step_Start(54, "Click booking number in search", test, test1);
			scrollTop(driver);

		 waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver,condition, select_by_book_number , Book_no, "", "", "", "");
			
		 Step_End(54, "Click booking number in search", test, test1);
		 
		 Step_Start(55, "Click edit button.", test, test1);
		 
		 waitForElement(driver, CRO_btn);
			click(driver, CRO_btn);
		 
		 waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
		 Step_End(55, "Click edit button.", test, test1);
		 
		 Step_Start(56, " Select Release Depot/Terminal.", test, test1);
		 
		 waitForElement(driver, Release_Terminal_SearchButton_CRO);
			click(driver, Release_Terminal_SearchButton_CRO);
			twoColumnSearchWindow(driver, Release_Terminal_Header, Serach_Condition, Release_Terminal_Input);
			
		 Step_End(56, " Select Release Depot/Terminal.", test, test1);
		 
		 Step_Start(57, "Select Acceptance Terminal.", test, test1);
			
		 waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		 click(driver, acceptance_Terminal_SearchButton_CRO);
		 twoColumnSearchWindow(driver, Acceptance_Terminal_Header, Serach_Condition, Acceptance_Terminal_Input);
		 
		 Step_End(57, "Select Acceptance Terminal.", test, test1);
		 
		 Step_Start(58, "Click save button.", test, test1);
			scrollTop(driver);

		 waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
		 Step_End(58, "Click save button.", test, test1);
		 
		 Step_Start(59, "CRO is saved message shown.", test, test1);
		 
		 String Actual_Saved_Popup1 = getText(driver, Popup_Message);
			if (Excepted_CRO_Saved_PopUp.equals(Actual_Saved_Popup1)) {
				System.out.println( "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup1);
				Extent_pass_New(driver, "Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup1, test, test);
			} else {
				System.out.println( " Not Matched || Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup1);
				Extent_fail(driver, " Not Matched ||  Excepted : After Click on Save button The Status should be : "+ Excepted_CRO_Saved_PopUp+" || Actual : After Click on Save Button The Satus is : "+ Actual_Saved_Popup1, test, test);
			
			}
			
		 Step_End(59, "CRO is saved message shown.", test, test1);
		 
		 Extent_completed(testCaseName, test, test1);
	}
}
