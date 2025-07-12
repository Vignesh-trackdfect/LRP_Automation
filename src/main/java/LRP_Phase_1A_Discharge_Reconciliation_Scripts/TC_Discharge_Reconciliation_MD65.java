package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD65 extends Keywords {
	
	public void Discharge_Reconciliation_MD65(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD65";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String Agency_code_header = Excel_data.get("Agency_code_header");
		String Attribute_code_header = Excel_data.get("Attribute_code_header");
		String Condition = Excel_data.get("Condition");
		String Attribute = Excel_data.get("Attribute");
		String Description = Excel_data.get("Description");
		String Value = Excel_data.get("Value");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Plan_Input=Excel_data.get("Plan_Input");
		String bl_Number = Excel_data.get("bl_Number");
		String Saved_pop_expected = Excel_data.get("Saved_pop_expected");
		String DPD_Code_input_Value = Excel_data.get("DPD_Code_input_Value");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String Discharge_Header = Excel_data.get("Discharge_Header");
		
		

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		SwitchProfile(driver, AgencyUser);
	
	
		Step_Start(1, " Switch to agency", test, test1);
		Step_Start(2, " Open Agency configuration module", test, test1);
		Step_Start(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, " Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_Start(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_Start(7, " if marked as N move to next action", test, test1);
		Step_Start(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_Start(9, " if Configuration is not added go to next step,", test, test1);
		setAgencyConfiguration(driver, Agency_Config_Module, Agency_code_header, Attribute_code_header, Condition,
				AgencyUser, Attribute, Description, Value);
		Step_End(1, " Switch to agency", test, test1);
		Step_End(2, " Open Agency configuration module", test, test1);
		Step_End(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, " Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_End(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_End(7, " if marked as N move to next action", test, test1);
		Step_End(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_End(9, " if Configuration is not added go to next step,", test, test1);
        
		Step_Start(10, "Open Discharge Reconciliation Module", test, test1);
moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(10, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		Step_End(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		
		Step_Start(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
	
		Step_Start(14, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(14, "Click on Download BL Button.", test, test1);
		Step_Start(15, "select the BLs listed under Test Data,", test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		
		
		

		List<String> Bl_Number_Input = splitAndExpand(bl_Number);
		String[] values = splitXpath(Bl_Number_input_re_con_row_click);
		
		By rowClickLocator = By.xpath(values[1]);
		
		for (int i = 0; i < Bl_Number_Input.size(); i++) {
		    String value = Bl_Number_Input.get(i);

		    waitForElement(driver, Bl_Number_input_re_con);
		    clear(driver, Bl_Number_input_re_con);
		    waitForElement(driver, Bl_Number_input_re_con);
		    sendKeys(driver, Bl_Number_input_re_con, value);

		    waitForElement(driver, Bl_Number_input_re_con_row_click);
		    WebElement elementToClick = driver.findElement(rowClickLocator);

		    if (i == 0) {
		        // First iteration: normal click
		        elementToClick.click();
		    } else {
		        // From second iteration: Ctrl + Click
		        Actions actions = new Actions(driver);
		        actions.keyDown(Keys.CONTROL)
		               .click(elementToClick)
		               .keyUp(Keys.CONTROL)
		               .build()
		               .perform();
		    }
		}
		
		Step_End(15, "select the BLs listed under Test Data,", test, test1);
		Step_Start(16, "select the Row and right click it", test, test1);
		RightClick(driver, Bl_Number_input_re_con_row_click);
		Step_End(16, "select the Row and right click it", test, test1);
		Step_Start(17, "select as change DPD Code option ", test, test1);
		waitForElement(driver, Change_dpd_code);
		click(driver, Change_dpd_code);
		Step_End(17, "select as change DPD Code option ", test, test1);
		Step_Start(18, "system will be open new window, user can select the Enter the DPD Code ", test, test1);
		waitForElement(driver, DPD_Code_input);
		sendKeys(driver, DPD_Code_input, DPD_Code_input_Value);
		Step_End(18, "system will be open new window, user can select the Enter the DPD Code ", test, test1);
		Step_Start(19, " and click on Update Button,", test, test1);
		waitForElement(driver, DPD_Code_select_update);
		click(driver, DPD_Code_select_update);
		Step_End(19, " and click on Update Button,", test, test1);
		Step_Start(20, "and Click on DPD code Button and system shows \"\"DPD Code Updated\"\" and click ok,", test, test1);
		waitForElement(driver, DPD_CODE_BUTTON);
		click(driver, DPD_CODE_BUTTON);
		waitForPopup(driver, popup_Message,Saved_pop_expected);
		String popact1 = getText(driver, popup_Message);

		if (Saved_pop_expected.equals(popact1)) {
			System.out.println(
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_pass(driver,
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_fail(driver,
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was  : " + popact1,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(20, "and Click on DPD code Button and system shows \"\"DPD Code Updated\"\" and click ok,", test, test1);

		
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		List<String> Bl_Number_Input1 = splitAndExpand(bl_Number);

		for (String value : Bl_Number_Input1) {
		    waitForElement(driver, Bl_Number_input_re_con);
		    clear(driver, Bl_Number_input_re_con);
		    waitForElement(driver, Bl_Number_input_re_con);
		    waitForElement(driver, Bl_Number_input_re_con);
		    sendKeys(driver, Bl_Number_input_re_con, value);
		    waitForElement(driver, Bl_Number_input_re_con);
		    waitForElement(driver, DPD_Code_text_Gird);
		    String DPD_Code_ = getText(driver, DPD_Code_text_Gird);

			if (DPD_Code_input_Value.equals(DPD_Code_)) {
				System.out.println(
						"Matched || Expected DPD Code given in test data : " + DPD_Code_input_Value + " || Actual DPD Code given in Discharge Reconciliation: " + DPD_Code_);
				Extent_pass(driver,
						"Matched || Expected DPD Code given in test data : " + DPD_Code_input_Value + " || Actual DPD Code given in Discharge Reconciliation : " + DPD_Code_, test,
						test1);
			} else {
				System.out.println(
						"Not Matched || Expected DPD Code given in test data : " + DPD_Code_input_Value + " || Actual DPD Code given in Discharge Reconciliation : " + DPD_Code_);
				Extent_fail(driver,
						"Not Matched || Expected DPD Code given in test data : " + DPD_Code_input_Value + " || Actual DPD Code given in Discharge Reconciliation  : " + DPD_Code_,
						test, test1);
			}

		}
		
		Extent_completed(testcase_Name, test, test1);
		
	
}}
