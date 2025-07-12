package LRP_Cost_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS062 extends Keywords {

	public void Cost_Activity_Report_TS062(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS062";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Agency = Excel_data.get("Agency");
		String filename = Excel_data.get("filename");

		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, Agency);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);

		} else {
			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);
		}

		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_Start(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(6, "Then click on the search button", test, test1);

		Step_Start(7, "System will show the CAR No", test, test1);

		Step_Start(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(6, "Then click on the search button", test, test1);

		Step_End(7, "System will show the CAR No", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}

		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9, "Click on the expense report", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		Step_End(9, "Click on the expense report", test, test1);

		Step_Start(10, "Click on the download pdf option", test, test1);

		Step_Start(11, "Ensure that the pdf file gets downloaded", test, test1);

		List<WebElement> Open_Mainactivities = listOfElements(driver, CAR_OEParentname);

		List<String> Open_Main_Activities_desc = new ArrayList<String>();

		for (WebElement activity : Open_Mainactivities) {

			String Mainactivity = activity.getText();

			Open_Main_Activities_desc.add(Mainactivity);

		}

		String OpenPdfpath = Verify_FileDownloaded1(driver, CAR_No, Download_approvedPdf);

		String Openextracted_path = "";

		try {
			Openextracted_path = unzipwithname(OpenPdfpath, "./UnZip_Folder", filename);
			System.out.println("Unzipping completed!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("extracted_path : " + Openextracted_path);

		String OpenCarNo = readPdf(Openextracted_path, "CAR No", "Arrival Date");
		String OpenVendorCode = readPdf(Openextracted_path, "Vendor Code", "Approved Date");

		if (OpenCarNo.equals(CAR_No)) {
			System.out.println(
					"PDF File was downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + OpenCarNo);
			Extent_pass_New(driver,
					"PDF File was downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + OpenCarNo,
					test, test1);

		} else {
			System.out.println("PDF File was not downloaded for selected CAR No || Expected : " + CAR_No + " Actual : "
					+ OpenCarNo);
			Extent_fail(driver, "PDF File was not downloaded for selected CAR No || Expected : " + CAR_No + " Actual : "
					+ OpenCarNo, test, test1);

		}

		for (String mainactivity : Open_Main_Activities_desc) {

			if (checkpdf(Openextracted_path, mainactivity) == true) {
				System.out.println("Expected : The Parent Activty '"+mainactivity+"' Should present in the pdf || Actual : The parent activity '"+mainactivity+"' details are present in the pdf");
				Extent_pass_New(driver, "Expected : The Parent Activty '"+mainactivity+"' Should present in the pdf || Actual : The parent activity '"+mainactivity+"' details are present in the pdf", test,
						test1);
			} else {
				System.out.println("Expected : The Parent Activty '"+mainactivity+"' Should present in the pdf || Actual : The parent activity '"+mainactivity+"' details are not present in the pdf");
				Extent_fail(driver, "Expected : The Parent Activty '"+mainactivity+"' Should present in the pdf || Actual : The parent activity '"+mainactivity+"' details are not present in the pdf", test,
						test1);
			}

		}

		List<WebElement> Open_vendorId_ele = listOfElements(driver, CAR_OEVendorcode);

		List<String> OpenvendorIds = new ArrayList<String>();

		for (WebElement element : Open_vendorId_ele) {

			String vendor = element.getText();

			OpenvendorIds.add(vendor);

		}

		for (String vendorid : OpenvendorIds) {

			if (vendorid.equals(OpenVendorCode)) {

				System.out.println("The selected vendor code was displayed in the pdf || Expected : " + vendorid
						+ " Actual : " + OpenVendorCode);
				Extent_pass_New(driver, "The selected vendor code was displayed in the pdf || Expected : " + vendorid
						+ " Actual : " + OpenVendorCode, test, test1);
			} else {

				System.out.println("The selected vendor code was not correctly displayed in the pdf || Expected : "
						+ vendorid + " Actual : " + OpenVendorCode);
				Extent_fail(driver, "The selected vendor code was not correctly displayed in the pdf || Expected : "
						+ vendorid + " Actual : " + OpenVendorCode, test, test1);
			}
		}

		Extent_cal(test, test1, "Pdf verification for approved expenses");

		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);

		waitForElement(driver, Download_approvedPdf);

		List<WebElement> Mainactivities = listOfElements(driver, CAR_AEParentname);

		List<String> Main_Activities_desc = new ArrayList<String>();

		for (WebElement activity : Mainactivities) {

			String Mainactivity = activity.getText();

			Main_Activities_desc.add(Mainactivity);

		}

		String Pdfpath = Verify_FileDownloaded1(driver, CAR_No, Download_approvedPdf);

		String extracted_path = "";

		try {
			extracted_path = unzipwithname(Pdfpath, "./UnZip_Folder", filename);
			System.out.println("Unzipping completed!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("extracted_path : " + extracted_path);

		String CarNo = readPdf(extracted_path, "CAR No", "Arrival Date");
		String VendorCode = readPdf(extracted_path, "Vendor Code", "Approved Date");

		if (CarNo.equals(CAR_No)) {
			System.out.println(
					"PDF File was downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + CarNo);
			Extent_pass_New(driver,
					"PDF File was downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + CarNo, test,
					test1);

		} else {
			System.out.println(
					"PDF File was not downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + CarNo);
			Extent_fail(driver,
					"PDF File was not downloaded for selected CAR No || Expected : " + CAR_No + " Actual : " + CarNo,
					test, test1);

		}

		for (String mainactivity : Main_Activities_desc) {

			if (checkpdf(extracted_path, mainactivity) == true) {
				System.out.println("The parent activity " + mainactivity + " details are present in the pdf");
				Extent_pass_New(driver, "The parent activity " + mainactivity + " details are present in the pdf", test,
						test1);
			} else {
				System.out.println("The parent activity " + mainactivity + " details are not present in the pdf");
				Extent_fail(driver, "The parent activity " + mainactivity + " details are not present in the pdf", test,
						test1);
			}

		}

		List<WebElement> vendorId_ele = listOfElements(driver, CAR_AEVendorcode);

		List<String> vendorIds = new ArrayList<String>();

		for (WebElement element : vendorId_ele) {

			String vendor = element.getText();

			vendorIds.add(vendor);

		}

		if (vendorIds.get(0).equals(VendorCode)) {

			System.out.println("The selected vendor code was displayed in the pdf || Expected : " + vendorIds.get(0)
					+ " Actual : " + VendorCode);
			Extent_pass_New(driver, "The selected vendor code was displayed in the pdf || Expected : " + vendorIds.get(0)
					+ " Actual : " + VendorCode, test, test1);
		} else {

			System.out.println("The selected vendor code was not correctly displayed in the pdf || Expected : "
					+ vendorIds.get(0) + " Actual : " + VendorCode);
			Extent_fail(driver, "The selected vendor code was not correctly displayed in the pdf || Expected : "
					+ vendorIds.get(0) + " Actual : " + VendorCode, test, test1);
		}

		Step_End(10, "Click on the download pdf option", test, test1);

		Step_End(11, "Ensure that the pdf file gets downloaded", test, test1);
		Extent_completed(tc_Name, test, test1);

	}

}
