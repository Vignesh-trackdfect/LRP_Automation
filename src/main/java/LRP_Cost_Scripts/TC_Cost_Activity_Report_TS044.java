package LRP_Cost_Scripts;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS044 extends Keywords {

	public void Cost_Activity_Report_TS044(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS044";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Upload_popup = Excel_data.get("Upload_popup");
		String Upload_Filename = Excel_data.get("Upload_Filename");
		String Filename = Excel_data.get("Filename");
		String Agency = Excel_data.get("Agency");

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

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
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

		Step_Start(9, "Click on the document attachment option in the toolbar", test, test1);

		waitForElement(driver, Attachement_Button_toolBar);
		click(driver, Attachement_Button_toolBar);

		Step_End(9, "Click on the document attachment option in the toolbar", test, test1);

		Step_Start(10, "Ensure that Document attachment window gets opened", test, test1);

		waitForElement(driver, Document_AttachmentPage);

		Step_End(10, "Ensure that Document attachment window gets opened", test, test1);

		Step_Start(11, "Click on the select file option", test, test1);

		Step_Start(12, "A window from the system gets opened and select the required file and click on the open option",
				test, test1);

		uploadfile_new(driver, UploadInput, Upload_Filename);

		Step_End(11, "Click on the select file option", test, test1);

		Step_End(12, "A window from the system gets opened and select the required file and click on the open option",
				test, test1);

		Step_Start(13, "Click upload option", test, test1);

		waitForElement(driver, Upload_Btn_CAR);
		click(driver, Upload_Btn_CAR);

		Step_End(13, "Click upload option", test, test1);

		Step_Start(14, "System shows an information message as File Uploaded Successfully", test, test1);

		waitForPopup(driver, popup_Message, Upload_popup);
		String ActualPopupmessage = getText(driver, popup_Message);

		if (ActualPopupmessage.equals(Upload_popup)) {

			System.out.println(
					"Document was uploaded || Expected : " + Upload_popup + " || Actual : " + ActualPopupmessage);
			Extent_pass_New(driver,
					"Document was uploaded || Expected : " + Upload_popup + " || Actual : " + ActualPopupmessage, test,
					test1);
		} else {

			System.out.println(
					"Document was not uploaded || Expected : " + Upload_popup + " || Actual : " + ActualPopupmessage);
			Extent_fail(driver,
					"Document was not uploaded || Expected : " + Upload_popup + " || Actual : " + ActualPopupmessage,
					test, test1);
		}

		Step_End(14, "System shows an information message as File Uploaded Successfully", test, test1);

		Step_Start(15, "Click on the ok option", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(15, "Click on the ok option", test, test1);

		Step_Start(16, "Click close option", test, test1);

		waitForElement(driver, Close_Attachment);
		click(driver, Close_Attachment);

		Step_End(16, "Click close option", test, test1);

		Step_Start(17, "Ensure that clicking the document attachment in the toolbar, shows the uploaded documents",
				test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");
		waitForElement(driver, Attachement_Button_toolBar);
		click(driver, Attachement_Button_toolBar);

		waitForElement(driver, Document_AttachmentPage);

		String uploadfilecheck = String.format(Filename_field, Upload_Filename);

		if (isdisplayed(driver, uploadfilecheck)) {

			System.out.println("Expected : Uploaded file Should show in the Document Attachment page || Actaul : Uploaded file was showing in the Document Attachment page");
			Extent_pass_New(driver, "Expected : Uploaded file Should show in the Document Attachment page || Actaul : Uploaded file was showing in the Document Attachment page", test, test1);
		} else {

			System.out.println("Expected : Uploaded file Should show in the Document Attachment page || Actaul : Uploaded file was not showing in the Document Attachment page");
			Extent_fail(driver, "Expected : Uploaded file Should show in the Document Attachment page || Actaul : Uploaded file was not showing in the Document Attachment page", test, test1);

		}

		click(driver, uploadfilecheck);

		Set<String> old_Files = getDirectoryFiles();

		String gridDownload = String.format(GridDownload, Upload_Filename);

		waitForDisplay(driver, gridDownload);
		click(driver, gridDownload);

		boolean isDownloaded = isNewFileDownloaded(old_Files, Filename);

		if (isDownloaded == true) {

			System.out.println("Expected : New excel file Should downloaded in the downloads folder || Actual : New excel file is downloaded in the downloads folder");
			Extent_pass_New(driver, "Expected : New excel file Should downloaded in the downloads folder || Actual : New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("Expected : New excel file Should downloaded in the downloads folder || Actual : New excel file is not downloaded in the downloads folder");
			Extent_fail(driver, "Expected : New excel file Should downloaded in the downloads folder || Actual : New excel file is not downloaded in the downloads folder", test, test1);
		}

		waitForElement(driver, Removeattchment);
		click(driver, Removeattchment);

		waitForElement(driver, Remove_attachment_yes);
		click(driver, Remove_attachment_yes);
		
		Step_End(17, "Ensure that clicking the document attachment in the toolbar, shows the uploaded documents",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
