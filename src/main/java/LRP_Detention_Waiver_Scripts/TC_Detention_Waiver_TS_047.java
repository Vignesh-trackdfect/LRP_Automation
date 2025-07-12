package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_047 extends Keywords {

	public void Detention_Waiver_TS_047(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_047";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BL_retreive_Type1 = Excel_data.get("BL_retreive_Type1");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Number = Excel_data.get("BL_Number");
		String Upload_Popup = Excel_data.get("Upload_Popup");
		String Upload_Filename = Excel_data.get("Upload_Filename");

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
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
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

		Step_Start(6, "Verify the File name upload files and available files should be same Name", test, test1);

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

		String AddedDate = getText(driver, Uploadeddate);

		String currentdate = Getdate();

		if (AddedDate.contains(currentdate)) {
			System.out.println("Uploaded file is added with correct Date || Expected : " + currentdate + " || Actual : "
					+ AddedDate);
			Extent_pass_New(driver, "Uploaded file is added with correct Date || Expected : " + currentdate
					+ " || Actual : " + AddedDate, test, test1);
		} else {

			System.out.println("Uploaded file is not added with correct Date || Expected : " + currentdate
					+ " || Actual : " + AddedDate);
			Extent_fail(driver, "Uploaded file is not added with correct Date || Expected : " + currentdate
					+ " || Actual : " + AddedDate, test, test1);
		}

		Step_End(6, "Verify the File name upload files and available files should be same Name", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
