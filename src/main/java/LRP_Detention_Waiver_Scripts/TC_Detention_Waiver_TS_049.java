package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_049 extends Keywords {

	public void Detention_Waiver_TS_049(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_049";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String Upload_Popup = Excel_data.get("Upload_Popup");
		String Upload_Filename = Excel_data.get("Upload_Filename");
		String Duplicate_Popup = Excel_data.get("Duplicate_Popup");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention waiver module", test, test1);

		moduleNavigate(driver, Detention_Module);

		Step_End(1, "Open Detention waiver module", test, test1);

		Step_Start(2, "Search and load the Waiver number", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, BL_Condition, BL_retreive_Type1, BL_Number, "", "", "", "");

		Step_End(2, "Search and load the Waiver number", test, test1);

		Step_Start(3,
				"Click on Upload Button and select the any one of the files, Select .JPG/.JPEG/.DOC/.XLS/.PDF/.PNG/.TXT/.XLSX/ files",
				test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		uploadfile_new(driver, DW_Uploads, Upload_Filename);

		waitForDisplay(driver, popup_Message_Yes_Button);
		if (isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}

		waitForPopup(driver, popup_Message, Upload_Popup);
		String actualpopup = getText(driver, popup_Message);

		if (actualpopup.equals(Upload_Popup)) {

			System.out.println(
					"File uploaded Successfully || Expected : " + Upload_Popup + " || Actual : " + actualpopup);
			Extent_pass_New(driver,
					"File uploaded Successfully || Expected : " + Upload_Popup + " || Actual : " + actualpopup, test,
					test1);

		} else {

			System.out.println("File not uploaded || Expected : " + Upload_Popup + " || Actual : " + actualpopup);
			Extent_fail(driver, "File not uploaded || Expected : " + Upload_Popup + " || Actual : " + actualpopup, test,
					test1);

		}

		Step_End(3,
				"Click on Upload Button and select the any one of the files, Select .JPG/.JPEG/.DOC/.XLS/.PDF/.PNG/.TXT/.XLSX/ files",
				test, test1);

		Step_Start(4, "click on in this msg File Upload Success", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "click on in this msg File Upload Success", test, test1);

		Step_Start(5, "Click on Preview button. system has to open New window", test, test1);

		waitForElement(driver, DW_Preview);
		click(driver, DW_Preview);

		Step_End(5, "Click on Preview button. system has to open New window", test, test1);

		Step_Start(6, "a) Capture the Uploaded Date and time and close the window", test, test1);

		waitForElement(driver, DW_PreviewPage);

		String Filecheck = String.format(DW_uploadedfilename, Upload_Filename);

		if (isdisplayed(driver, Filecheck)) {

			System.out.println(
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is showing in the preview Tab");
			Extent_pass_New(driver,
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is showing in the preview Tab",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is not showing in the preview Tab");
			Extent_fail(driver,
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is not showing in the preview Tab",
					test, test1);

		}

		String User_name = String.format(DW_uploadedUser, Upload_Filename);

		String AddedUsername = getText(driver, User_name);

		if (AddedUsername.equals(Username.toUpperCase())) {
			System.out.println("Uploaded file is added with correct username || Expected : " + Username
					+ " || Actual : " + AddedUsername);
			Extent_pass_New(driver, "Uploaded file is added with correct username || Expected : " + Username
					+ " || Actual : " + AddedUsername, test, test1);
		} else {

			System.out.println("Uploaded file is not added with correct username || Expected : " + Username
					+ " || Actual : " + AddedUsername);
			Extent_fail(driver, "Uploaded file is not added with correct username || Expected : " + Username
					+ " || Actual : " + AddedUsername, test, test1);
		}

		String Uploadeddate = String.format(DW_uploadedDate, Upload_Filename);

		String ytru = getText(driver, Uploadeddate);

		// Define the formatter that matches the format
	//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		// Parse the string into LocalDateTime
	//	LocalDateTime dateTime = LocalDateTime.parse(ytru, formatter);
//		LocalDateTime dateTime = LocalDateTime.parse(ytru, formatter);
//		System.out.println(dateTime);
		
		
		
	
		 DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	                .appendPattern("yyyy-MM-dd HH:mm:ss")
	                .optionalStart()
	                .appendFraction(ChronoField.MILLI_OF_SECOND, 1, 9, true)
	                .optionalEnd()
	                .toFormatter();

	       
	            LocalDateTime dateTime = LocalDateTime.parse(ytru, formatter);

	            String dateOnlyy = dateTime.toLocalDate().toString(); // yyyy-MM-dd
	            int hourOnlyy = dateTime.getHour(); // hour as int

	            System.out.println("Date: " + dateOnlyy);
	            System.out.println("Hour: " + hourOnlyy);
	        
		// Extract just the date and hour
//		String dateOnlyy = dateTime.toLocalDate().toString(); // yyyy-MM-dd
//		int hourOnlyy = dateTime.getHour(); // hour as int
//
//		// Print or use as needed
//		System.out.println("Date: " + dateOnlyy);
//		System.out.println("Hour: " + hourOnlyy);

		LocalDateTime now = LocalDateTime.now();

		// Format with fractional seconds (1 digit)
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		String formattedDateTime = now.format(formatter1);
		System.out.println("Formatted date and time: " + formattedDateTime);

		// Extract and print only the hour
		int hour = now.getHour();
		System.out.println("Hour only: " + hour);

		// Extract and print only the date
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateOnly = now.format(dateFormatter);
		System.out.println("Date only: " + dateOnly);

		if (dateOnlyy.contains(dateOnly)) {
			System.out.println(
					"Uploaded file is added with correct Date || Expected : " + dateOnlyy + " || Actual : " + dateOnly);
			Extent_pass_New(driver,
					"Uploaded file is added with correct Date || Expected : " + dateOnlyy + " || Actual : " + dateOnly,
					test, test1);
		} else {

			System.out.println("Uploaded file is not added with correct Date || Expected : " + dateOnlyy
					+ " || Actual : " + dateOnly);
			Extent_fail(driver, "Uploaded file is not added with correct Date || Expected : " + dateOnlyy
					+ " || Actual : " + dateOnly, test, test1);
		}

		if (hourOnlyy == hour) {
			System.out.println(
					"Uploaded file is added with correct time || Expected : " + hourOnlyy + " || Actual : " + hour);
			Extent_pass_New(driver,
					"Uploaded file is added with correct time || Expected : " + hourOnlyy + " || Actual : " + hour,
					test, test1);
		} else {

			System.out.println(
					"Uploaded file is not added with correct time || Expected : " + hourOnlyy + " || Actual : " + hour);
			Extent_fail(driver,
					"Uploaded file is not added with correct time || Expected : " + hourOnlyy + " || Actual : " + hour,
					test, test1);
		}

		String UploadedDate = String.format(DW_uploadedDate, Upload_Filename);

		String DateTime = getText(driver, UploadedDate);

		waitForElement(driver, DW_ClosePreview);
		click(driver, DW_ClosePreview);

		Step_End(6, "a) Capture the Uploaded Date and time and close the window", test, test1);

		Step_Start(6, "click on choose Button and upload the same Files", test, test1);

		uploadfile_new(driver, DW_Uploads, Upload_Filename);

		Step_End(6, "click on choose Button and upload the same Files", test, test1);

		Step_Start(7,
				"Verify that system shows files already available msg  as 'File already exist. Do you want to replace it ?",
				test, test1);

		waitForPopup(driver, popup_Message, Upload_Popup);
		String actualpopup2 = getText(driver, popup_Message);

		if (actualpopup2.equals(Duplicate_Popup)) {

			System.out.println(
					"File uploaded Successfully || Expected : " + Duplicate_Popup + " || Actual : " + actualpopup2);
			Extent_pass_New(driver,
					"File uploaded Successfully || Expected : " + Duplicate_Popup + " || Actual : " + actualpopup2,
					test, test1);

		} else {

			System.out.println("File not uploaded || Expected : " + Duplicate_Popup + " || Actual : " + actualpopup2);
			Extent_fail(driver, "File not uploaded || Expected : " + Duplicate_Popup + " || Actual : " + actualpopup2,
					test, test1);

		}

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_Start(7,
				"Verify that system shows files already available msg  as 'File already exist. Do you want to replace it ?",
				test, test1);

		waitForPopup(driver, popup_Message, Upload_Popup);
		String actualsave_popup = getText(driver, popup_Message);

		if (actualsave_popup.equals(Upload_Popup)) {

			System.out.println(
					"File uploaded Successfully || Expected : " + Upload_Popup + " || Actual : " + actualsave_popup);
			Extent_pass_New(driver,
					"File uploaded Successfully || Expected : " + Upload_Popup + " || Actual : " + actualsave_popup,
					test, test1);

		} else {

			System.out.println("File not uploaded || Expected : " + Upload_Popup + " || Actual : " + actualsave_popup);
			Extent_fail(driver, "File not uploaded || Expected : " + Upload_Popup + " || Actual : " + actualsave_popup,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(7,
				"Verify that system shows files already available msg  as 'File already exist. Do you want to replace it ?",
				test, test1);

		Step_Start(8,
				"click on Preview Button  and Verify that same Files Available at the same time uploaded Date and time should be same",
				test, test1);

		waitForElement(driver, DW_Preview);
		click(driver, DW_Preview);

		waitForElement(driver, DW_PreviewPage);

		String Filecheck2 = String.format(DW_uploadedfilename, Upload_Filename);

		if (isdisplayed(driver, Filecheck2)) {

			System.out.println(
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is showing in the preview Tab");
			Extent_pass_New(driver,
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is showing in the preview Tab",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is not showing in the preview Tab");
			Extent_fail(driver,
					"Expected result : Uploaded file should showin in the preview Tab || Actual result is : Uploaded file is not showing in the preview Tab",
					test, test1);

		}

		String New_UploadedDate = String.format(DW_uploadedDate, Upload_Filename);

		String New_DateTime = getText(driver, New_UploadedDate);

		if (!New_DateTime.equals(DateTime)) {

			System.out.println(
					"Expected result : Previous file should be replaced with newly uploaded file || Actual result is : Previous file is replaced with newly uploaded file");
			Extent_pass_New(driver,
					"Expected result : Previous file should be replaced with newly uploaded file || Actual result is : Previous file is replaced with newly uploaded file",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Previous file should be replaced with newly uploaded file || Actual result is : Previous file is not replaced with newly uploaded file");
			Extent_fail(driver,
					"Expected result : Previous file should be replaced with newly uploaded file || Actual result is : Previous file is not replaced with newly uploaded file",
					test, test1);

		}

		Step_End(8,
				"click on Preview Button  and Verify that same Files Available at the same time uploaded Date and time should be same",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
