package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD02 extends Keywords {

	public void Discharge_Reconciliation_MD02(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD02";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options = Excel_data.get("Plan_Type");
		String Page_options = Excel_data.get("DC_Page_options");

		//
	

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, " Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to Agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(3, "Click on new button if new button not available go below,", test, test1);

		Step_Start(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		Step_End(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
		waitForElement(driver, Plan_Option);
		click(driver, Plan_Option);

		formatLocatorClick(driver, Plan_Option_Select, Plan_Options);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment.,", test, test1);

		Step_Start(6, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button.", test, test1);

		Step_Start(7, " Select the Page Size into-10 system has to Spit it accordingly to the Page", test, test1);
		waitForElement(driver, Pagesize_option_DR);
		click(driver, Pagesize_option_DR);
		formatLocatorClick(driver, Pagesize_option_select_DR, Page_options);
		Step_End(7, " Select the Page Size into-10 system has to Spit it accordingly to the Page ", test, test1);

		Step_Start(8, "Verify that each pages has to List 10 Rows by selecting Page1 and Page 2", test, test1);

		waitForElement(driver, VesselTable_List_DR);

		List<WebElement> bookno = listOfElements(driver, VesselTable_List_DR);

		int noofbls = bookno.size();

		int pagesize = Integer.parseInt(Page_options);

		String totalrecords = getText(driver, Total_Records_DR);

		int total_records = Integer.parseInt(totalrecords);

		int pageno = 1;

		int pagerecordcounts = 0;

		if (noofbls == pagesize) {
			System.out.println("Pass || Expected result is : The page " + pageno + " should have " + Page_options
					+ " records || Actual result is : The page " + pageno + " should have " + Page_options
					+ " records");
			Extent_pass(driver, "Pass || Expected result is : The page " + pageno + " should have " + Page_options
					+ " records || Actual result is : The page " + pageno + " should have " + Page_options + " records",
					test, test1);

			pagerecordcounts = pagerecordcounts + noofbls;

		} else if (noofbls < pagesize) {

			if (noofbls == total_records) {

				System.out.println("Pass || The selected page " + pageno
						+ " has less count than selected page option || Expected total records count : " + total_records
						+ " Actual page count : " + noofbls);
				Extent_pass(driver,
						"Pass || The selected page " + pageno
								+ " has less count than selected page option || Expected total records count : "
								+ total_records + " Actual page count : " + noofbls,
						test, test1);
			} else {

				System.out.println("Fail || The selected page " + pageno
						+ " has less count than selected page option || Expected total records count : " + total_records
						+ " Actual page count : " + noofbls);
				Extent_fail(driver,
						"Fail || The selected page " + pageno
								+ " has less count than selected page option || Expected total records count : "
								+ total_records + " Actual page count : " + noofbls,
						test, test1);

			}

		} else {
			System.out.println("Fail || Expected result is : The page " + pageno + " should have " + Page_options
					+ " records || Actual result is : The page " + pageno + " is having " + Page_options + " records");
			Extent_fail(driver, "Fail || Expected result is : The page " + pageno + " should have " + Page_options
					+ " records || Actual result is : The page " + pageno + " is having " + Page_options + " records",
					test, test1);

		}

		String pagecount = getText(driver, Pagecount_DR);

		int remaining_count = total_records - pagerecordcounts;

		if (Integer.parseInt(pagecount) > 1) {

			for (int i = 1; i < Integer.parseInt(pagecount); i++) {

				waitForElement(driver, Click_page2_DR);
				click(driver, Click_page2_DR);

				waitForElement(driver, VesselTable_List_DR);
				List<WebElement> bookno2 = listOfElements(driver, VesselTable_List_DR);

				int nextpagecount = bookno2.size();

				if (nextpagecount == pagesize) {
					System.out.println(
							"Pass || Expected: page should be listed 10 rows by selecting page || Actual: page listed "+nextpagecount+ " rows by selecting page");
					Extent_pass(driver,
							"Pass || Expected: page  should be listed 10 rows by selecting page || Actual: page listed "+nextpagecount+ " rows by selecting page",
							test, test1);


				} else if (remaining_count < pagesize) {
					System.out.println(
							"Pass || Expected: page should be listed lesser than 10 rows by selecting page || Actual: page listed "+remaining_count+ " rows by selecting page");
					Extent_pass(driver,
							"Pass || Expected: page should be listed lesser than 10 rows by selecting page || Actual: page listed "+remaining_count+ " rows by selecting page",
							test, test1);

					int RowCountGets = remaining_count + noofbls;
					
					if (RowCountGets == total_records) {
						System.out.println(
								"Pass || Expected: Total record "+total_records+" count should match Actual record || Actual: Total record "+total_records+" count matches with Actual record "+RowCountGets+ " count");
						Extent_pass(driver,
								"Pass || Expected: Total record "+total_records+" count should match Actual record || Actual: Total record "+total_records+" count matches with Actual record "+RowCountGets+ " count",
								test, test1);

					} else {
						System.out.println(
								"Pass || Expected: Total record "+total_records+" count should match Actual record || Actual: Total record "+total_records+" count does not matches with Actual record "+RowCountGets+ " count");
						Extent_pass(driver,
								"Pass || Expected: Total record "+total_records+" count should match Actual record || Actual: Total record "+total_records+" count does not matches with Actual record "+RowCountGets+ " count",
								test, test1);

					}
				}

				else {
					System.out.println(
							"Fail || Expected: page should be listed 10 rows by selecting page || Actual: page not listed 10 rows by selecting page");
					Extent_fail(driver,
							"Fail || Expected: page  should be listed 10 rows by selecting page || Actual: page not listed 10 rows by selecting page",
							test, test1);

				}

			}

		}
		Step_End(8, "Verify that each pages has to List 10 Rows by selecting Page1 and Page 2", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}
}
