package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD60 extends Keywords {
	public void Discharge_Reconciliation_MD60(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Discharge_Reconciliation_MD60";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);

		String atribute_value = Excel_data.get("Agency_atribute_value");
		String attributeColumn_Header = Excel_data.get("attributeColumn_Header");
		String Agency_condition = Excel_data.get("Agency_condition");
		String agencyColumn_Header = Excel_data.get("agencyColumn_Header");
		String Discription_Value = Excel_data.get("Agency_Discription_Value");
		String Agency_value = Excel_data.get("Agency_value");
		String Bl_Number = Excel_data.get("Bl_Number");
		String Change_Shipment_value = Excel_data.get("DR_Shipment_Category");

		String first_Shipment_Click = String.format(change_shipment_gategory, Change_Shipment_value);
		String Excepted_update_pop_msg = Excel_data.get("Shipment_Category_pop_Expected");
		String Reset_Agency_value = Excel_data.get("Reset_Agency_value");
		String Reset_option = Excel_data.get("Reset_option");
		String Re_Arange_Header = Excel_data.get("Re_Arange_Header");
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);
		Step_Start(2, "Open Agency configuration module", test, test1);
		Step_Start(3, "Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, "Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button", test, test1);
		Step_Start(6,
				" Verify that given configuration is already available if available and make sure that value is Marked as -Y.",
				test, test1);
		Step_Start(7, " if marked as Y move to next action", test, test1);
		Step_Start(8,
				" if Configuration marked as N then Double click the row and change the Value to Y and click (+)button",
				test, test1);
		Step_Start(9,
				"if Configuration is not added click on (+) button and add the configutation -Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y. and mark as Y",
				test, test1);

		List<Boolean> newlyAdded = setAgencyConfiguration(driver, Agency_Config_Module, agencyColumn_Header,
				attributeColumn_Header, Agency_condition, AgencyUser, atribute_value, Discription_Value, Agency_value);

		Step_End(2, "Open Agency configuration module", test, test1);
		Step_End(3, "Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, "Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button", test, test1);
		Step_End(6,
				" Verify that given configuration is already available if available and make sure that value is Marked as -Y.",
				test, test1);
		Step_End(7, " if marked as Y move to next action", test, test1);
		Step_End(8,
				" if Configuration marked as N then Double click the row and change the Value to Y and click (+)button",
				test, test1);
		Step_End(9,
				"if Configuration is not added click on (+) button and add the configutation -Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y. and mark as Y",
				test, test1);

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
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);

		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		Step_End(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(13, "Select the Plan as ALL/Local/Transhipment.", test, test1);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(13, "Select the Plan as ALL/Local/Transhipment.", test, test1);

		Step_Start(14, " Click on Download BL Button", test, test1);

		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(14, " Click on Download BL Button", test, test1);
		Step_Start(15, "select the multiple BLs listed under Test Data", test, test1);
		Step_Start(16, " select the Row and right click it", test, test1);

		List<String> Bl_numbers = splitAndExpand(Bl_Number, ",");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		int size = Bl_numbers.size();
		for (int i = 0; i < size; i++) {
			String Bl_numbers_locator = String.format(Bl_numbers_Split, Bl_numbers.get(i));
			waitForElement(driver, Bl_numbers_locator);
			click(driver, Bl_numbers_locator);
			if (i == size - 1) {
				action.keyUp(Keys.CONTROL).build().perform();
				waitForElement(driver, Bl_numbers_locator);
				RightClick(driver, Bl_numbers_locator);
			}
		}
		Step_End(15, "select the multiple BLs listed under Test Data", test, test1);

		Step_End(16, " select the Row and right click it", test, test1);

		Step_Start(17, " select as change the shipment category option ", test, test1);
		waitForElement(driver, change_shipment_btn);
		click(driver, change_shipment_btn);

		Step_End(17, " select as change the shipment category option ", test, test1);
		Step_Start(18, "system will be open new window, user can select the Shipment Catagory as DPD+CFS.", test,
				test1);
		waitForElement(driver, first_Shipment_Click);
		click(driver, first_Shipment_Click);
		Step_End(18, "system will be open new window, user can select the Shipment Catagory as DPD+CFS.", test, test1);
		Step_Start(19, " click on Update Button", test, test1);
		waitForElement(driver, change_shipment_update_btn);
		click(driver, change_shipment_update_btn);
		Step_End(19, " click on Update Button", test, test1);
		Step_Start(20, " make sure that DPD+CFS code has listed for the selected grid in shipment category column",
				test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Re_Arange_Header);
		for (int i = 0; i < size; i++) {
			Newclear(driver, Re_arange_Bl_filter);
			sendKeys(driver, Re_arange_Bl_filter, Bl_numbers.get(i));
			waitForElement(driver, DR_Shipment_Category_type);
			String Shipment_catagory_In_DR_Text = getText(driver, DR_Shipment_Category_type);
			if (isDisplayed(driver, DR_Shipment_Category_type)) {
				System.out.println(
						"Pass:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is Displayed");
				Extent_pass(driver,
						"Pass:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is Displayed",
						test, test1);
				if (Change_Shipment_value.equals(Shipment_catagory_In_DR_Text)) {
					System.out.println("pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i)
							+ "  is:" + Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
							+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text + "Both Are Same");
					Extent_pass(driver,
							"pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i) + "  is:"
									+ Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
									+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text + "Both Are Same",
							test, test1);

				} else {
					System.out.println("pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i)
							+ "  is:" + Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
							+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text + "Both Are not Same");
					Extent_fail(driver,
							"pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i) + "  is:"
									+ Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
									+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text + "Both Are not Same",
							test, test1);

				}
			} else {
				System.out.println(
						"Fail:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is not Displayed");
				Extent_fail(driver,
						"Fail:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is not Displayed",
						test, test1);

			}

		}
		Step_End(20, " make sure that DPD+CFS code has listed for the selected grid in shipment category column", test,
				test1);
		Step_Start(21, "click on shipment category Button and system says shipment category is updated.", test, test1);
		waitForElement(driver, shipment_catagory_btn);
		click(driver, shipment_catagory_btn);
		waitForPopup(driver, popup_Message, Excepted_update_pop_msg);
		String Actual_update_pop_msg = getText(driver, popup_Message);
		if (Excepted_update_pop_msg.equals(Actual_update_pop_msg)) {
			System.out.println("pass:The Excepted pop msg is:" + Excepted_update_pop_msg + "The Actual Pop Msg is :"
					+ Actual_update_pop_msg );
			Extent_pass(driver, "pass:The Excepted pop msg is:" + Excepted_update_pop_msg + "The Actual Pop Msg is :"
					+ Actual_update_pop_msg , test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println("Fail:The Excepted pop msg is:" + Excepted_update_pop_msg + "The Actual Pop Msg is :"
					+ Actual_update_pop_msg);
			Extent_fail(driver, "Fail:The Excepted pop msg is:" + Excepted_update_pop_msg + "The Actual Pop Msg is :"
					+ Actual_update_pop_msg , test, test1);

		}
		Step_End(21, "click on shipment category Button and system says shipment category is updated.", test, test1);
		Step_Start(22,
				"Verify that all the selected conainter has updated the shipment Category in Discharge reconciliation module in grid.",
				test, test1);

		for (int i = 0; i < size; i++) {
			Newclear(driver, Re_arange_Bl_filter);
			sendKeys(driver, Re_arange_Bl_filter, Bl_numbers.get(i));
			waitForElement(driver, DR_Shipment_Category_type);
			String Shipment_catagory_In_DR_Text = getText(driver, DR_Shipment_Category_type);
			if (isDisplayed(driver, DR_Shipment_Category_type)) {
				System.out.println(
						"Pass:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is Displayed");
				Extent_pass(driver,
						"Pass:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is Displayed",
						test, test1);
				if (Change_Shipment_value.equals(Shipment_catagory_In_DR_Text)) {
					System.out.println("pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i)
							+ "  is:" + Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
							+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text);
					Extent_pass(driver,
							"pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i) + "  is:"
									+ Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
									+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text ,
							test, test1);

				} else {
					System.out.println("pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i)
							+ "  is:" + Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
							+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text);
					Extent_fail(driver,
							"pass:The excepted shipment catagory for This Bl Number+" + Bl_numbers.get(i) + "  is:"
									+ Change_Shipment_value + "The Actual Shipment catagory for This Bl Number"
									+ Bl_numbers.get(i) + "  is:" + Shipment_catagory_In_DR_Text,
							test, test1);

				}
			} else {
				System.out.println(
						"Fail:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is not Displayed");
				Extent_fail(driver,
						"Fail:The Excepted is The Shipment Gategory Should be Displayed||The Actual is The Shipment Category is not Displayed",
						test, test1);

			}

		}

		Step_End(22,
				"Verify that all the selected conainter has updated the shipment Category in Discharge reconciliation module in grid.",
				test, test1);
		// reset The Agency Configuration
		reSetAgencyConfiguration(driver, Agency_Config_Module, agencyColumn_Header, attributeColumn_Header,
				Agency_condition, AgencyUser, Discription_Value, Reset_Agency_value, newlyAdded, Reset_option);

		Extent_completed(testcase_Name, test, test1);

	}
}
