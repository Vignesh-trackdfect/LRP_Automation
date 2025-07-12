package LRP_Ecommerce_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_006 extends Keywords {

	public void Ecommerce_Gateway_Validator_006(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_006";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String Reference_Number = Excel_data.get("Reference_Number");
		String Booking_Number = Excel_data.get("Booking_Number");
		String BL_Number = Excel_data.get("BL_Number");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");
		String Expected_Status = Excel_data.get("Expected_Status");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		moduleNavigate(driver, Module_Name);

		Step_Start(1,
				"Enter the BL number and click the refresh button. transaction type and non-processed checkbox based on the SI records should show in the grid",
				test, test1);

		waitForElement(driver, EG_BLNo_input);
		sendKeys(driver, EG_BLNo_input, BL_Number);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			waitForElement(driver, EG_FromDate_Input);
			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		if (!Reference_Number.isEmpty()) {

			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);

		}

		if (!Booking_Number.isEmpty()) {

			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);

		}

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Refresh);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		int i = 0;

		boolean grid = true;

		List<String> NonProcessed = new ArrayList<String>();

		while (grid == true) {

			try {
				String Statusfield = String.format(EG_Grid_Status, i);
				String ReceivedDate_field = String.format(EG_Grid_ReceivedDate, i);

				mouseOverToElement(driver, Statusfield);

				String grid_status = getText(driver, Statusfield);

				String BookNofield = String.format(EG_Grid_BookNo, i);
				String RefNo_field = String.format(EG_Grid_RefNo, i);
				String BLNo_field = String.format(EG_Grid_BLNo, i);

				NonProcessed.add(grid_status);

				if (DateCheckbox_Status.equals("Yes")) {

					String grid_ReceivedDate = getText(driver, ReceivedDate_field);

					String[] actualdate = grid_ReceivedDate.split(" ");

					String Grid_Date = actualdate[0];

					if (isDateBetween(Grid_Date, Given_From_Date, Given_To_Date)) {

						System.out.println(
								"The Grid data's are correctly showing between the From and To Dates : The received date is : "
										+ Grid_Date + " || From Date is : " + Given_From_Date + " || To Date is : "
										+ Given_To_Date);
						Extent_pass_New(driver,
								"The Grid data's are correctly showing between the From and To Dates : The received date is : "
										+ Grid_Date + " || From Date is : " + Given_From_Date + " || To Date is : "
										+ Given_To_Date,
								test, test1);

					} else {

						System.out.println(
								"The Grid data's are not correctly showing between the From and To Dates : The received date is : "
										+ Grid_Date + " || From Date is : " + Given_From_Date + " || To Date is : "
										+ Given_To_Date);
						Extent_fail(driver,
								"The Grid data's are not correctly showing between the From and To Dates : The received date is : "
										+ Grid_Date + " || From Date is : " + Given_From_Date + " || To Date is : "
										+ Given_To_Date,
								test, test1);
					}

				}

				if (!Reference_Number.isEmpty()) {

					String grid_RefNo = getText(driver, RefNo_field);

					if (grid_RefNo.equals(Reference_Number)) {

						System.out.println(
								"Only the given reference number details are showing in the grid || Expected : "
										+ Reference_Number + " || Actual : " + grid_RefNo);
						Extent_pass_New(driver,
								"Only the given reference number details are showing in the grid || Expected : "
										+ Reference_Number + " || Actual : " + grid_RefNo,
								test, test1);
					} else {

						System.out.println("All the reference number details are showing in the grid || Expected : "
								+ Reference_Number + " || Actual : " + grid_RefNo);
						Extent_fail(driver, "All the reference number details are showing in the grid || Expected : "
								+ Reference_Number + " || Actual : " + grid_RefNo, test, test1);
					}

				}

				if (!Booking_Number.isEmpty()) {

					String grid_BookNo = getText(driver, BookNofield);

					if (grid_BookNo.equals(Booking_Number)) {

						System.out.println("All the Booking number details are showing in the grid || Expected : "
								+ Booking_Number + " || Actual : " + grid_BookNo);
						Extent_pass_New(driver, "All the Booking number details are showing in the grid || Expected : "
								+ Booking_Number + " || Actual : " + grid_BookNo, test, test1);
					} else {

						System.out.println("All the Booking number details are not showing in the grid || Expected : "
								+ Booking_Number + " || Actual : " + grid_BookNo);
						Extent_fail(driver, "All the Booking number details are not showing in the grid || Expected : "
								+ Booking_Number + " || Actual : " + grid_BookNo, test, test1);
					}
				}

				if (!BL_Number.isEmpty()) {

					String grid_BLNo = getText(driver, BLNo_field);

					if (grid_BLNo.equals(BL_Number)) {

						System.out.println("Only the given BL number details are showing in the grid || Expected : "
								+ BL_Number + " || Actual : " + grid_BLNo);
						Extent_pass_New(driver, "Only the given BL number details are showing in the grid || Expected : "
								+ BL_Number + " || Actual : " + grid_BLNo, test, test1);
					} else {

						System.out.println("Only the given BL number details are not showing in the grid || Expected : "
								+ BL_Number + " || Actual : " + grid_BLNo);
						Extent_fail(driver,
								"Only the given BL number details are not showing in the grid || Expected : "
										+ BL_Number + " || Actual : " + grid_BLNo,
								test, test1);
					}

				}

				grid = true;

				i++;

			} catch (Exception e) {
				grid = false;
			}

		}

		List<String> ExpectedStatuses = splitAndExpand(Expected_Status);

		for (String Expected : ExpectedStatuses) {

			if (NonProcessed.contains(Expected)) {

				System.out.println("Expected :" + Expected + " status data should be displayed in the Grid || Acual : "
						+ Expected + " Status data's are showing in the Grid and the Displayed status was : "
						+ NonProcessed);
				Extent_pass_New(driver,
						"Expected :" + Expected + " status data should be displayed in the Grid || Acual : " + Expected
								+ " Status data's are showing in the Grid and the Displayed status was : "
								+ NonProcessed,
						test, test1);

			} else {

				System.out.println("Expected :" + Expected + " status data should be displayed in the Grid || Acual : "
						+ Expected + " Status data's are not showing in the Grid and the Displayed status was : "
						+ NonProcessed);
				Extent_fail(driver,
						"Expected :" + Expected + " status data should be displayed in the Grid || Acual : " + Expected
								+ " Status data's are not showing in the Grid and the Displayed status was : "
								+ NonProcessed,
						test, test1);
			}

		}

		Step_End(1,
				"Enter the BL number and click the refresh button. transaction type and non-processed checkbox based on the SI records should show in the grid",
				test, test1);
		Extent_completed(testcase_Name, test, test1);

	}

}
