package LRP_EMS_Individual_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EDI_Request_Submission_SC22 extends Keywords {

	public void RequestSubmission22(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name="TC_EDI_Request_Submission_SC22";
		
		


		
		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String field_name1 = Excel_data.get("field_name1");
		String Partner_Id = Excel_data.get("Partner_Id");
		String Edi_Id = Excel_data.get("Edi_Id");
		String Save_Popup = Excel_data.get("Save_Popup");
		String file_Upload =  Excel_data.get("file_Upload");
		String conditionFilter =  Excel_data.get("conditionFilter");
		String partner_Id_Search =  Excel_data.get("partner_Id_Search");
		String Edi_Id_Search =  Excel_data.get("Edi_Id_Search");
		
		
		
		
		
		
		
		Extent_Start(testcase_Name, test, test1);

		// login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, pass_word);
		// module search
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
         
         
 		moduleNavigate(driver, field_name1);

		
		Step_Start(1, "Click on search icon besides Partner id field", test, test1);
		waitForElement(driver, searchField);
		click(driver, searchField);
		Step_End(1, "Click on search icon besides Partner id field", test, test1);
		
		Step_Start(2, "select appropriate partner code accordingly", test, test1);
		twoColumnSearchWindow(driver, partner_Id_Search, conditionFilter, Partner_Id);

		

		Step_End(2, "select appropriate partner code accordingly", test, test1);
		
		Step_Start(3, "Click on search icon besides EDI Id field", test, test1);
		waitForElement(driver, ediSearch);
		click(driver, ediSearch);
		Step_End(3, "Click on search icon besides EDI Id field", test, test1);
		
		Step_Start(4, "select appropriate id code accordingly", test, test1);
		
		twoColumnSearchWindow(driver, Edi_Id_Search, conditionFilter, Edi_Id);


        Step_End(4, "select appropriate id code accordingly", test, test1);
	
		
		Step_Start(5, "Click choose button & select excel file from local system manually", test, test1);
		waitForElement(driver, chooseOption);
		// upload file
		uploadfile2(driver, file_Upload);
        Step_End(5, "Click choose button & select excel file from local system manually", test, test1);
		
        Step_Start(6, "Click save button & message will be shown as submitted", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
	
		
		
		waitForPopup(driver, Popup_Message, Save_Popup);
		String Actual_Save_Popup = getText(driver, Popup_Message);

		if (Save_Popup.equals(Actual_Save_Popup)) {

			System.out.println(
					"Matched || expected  Popup was:" + Save_Popup + " || Actual Popup was:" + Actual_Save_Popup);
			Extent_pass_New(driver,
					"Matched || expected Popup was:" + Save_Popup + " || Actual Popup was:" + Actual_Save_Popup, test,
					test1);

		} else {
			System.out.println(
					"NotMatched || expected Popup was:" + Save_Popup + " || Actual Popup was:" + Actual_Save_Popup);
			Extent_fail(driver,
					"NotMatched || expected Popup was:" + Save_Popup + " || Actual Popup was:" + Actual_Save_Popup,
					test, test1);
		}
		Step_End(6, "Click save button & message will be shown as submitted", test, test1);

		waitForElement(driver, Excel_Upload);
		String Uploaded = getText(driver, Excel_Upload);
		System.out.println(Uploaded);
		if (file_Upload.contains(Uploaded)) {
			System.out.println("Matched || expected file path was:" + file_Upload + " || Actual file path was:" + Uploaded);
			Extent_pass_New(driver, "Matched || expected file path was:" + file_Upload + " || Actual file path was:" + Uploaded, test,
					test1);

		} else {
			System.out.println("NotMatched || expected file path was:" + file_Upload + " || Actual file path was:" + Uploaded);
			Extent_fail(driver, "NotMatched || expected file path was:" + file_Upload + " || Actual file path was:" + Uploaded,
					test, test1);
		}
		
		Extent_completed(testcase_Name, test, test1);

	}

}
