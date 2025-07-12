package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_027 extends Keywords {


	public void DG_Creation_SC_027(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_027";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String File_Name = Excel_data.get("File_Name");
		String File_Uploaded_Popup = Excel_data.get("File_Uploaded_Popup");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);

		Step_Start(4, "click multi apply  button.", test, test1);

		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1); 
		} 
		
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		Step_End(4, "click multi apply  button.", test, test1);
		Step_Start(5, "Click save button", test, test1);

		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);
		waitForPopup(driver, popup_Message,Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Saved_Popup.equals(Details_Saved_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1); 
		}
		Step_End(5, "Click save button", test, test1);

		Step_Start(6, "Click file upload button", test, test1);

		uploadfile_new(driver, File_Chooser, File_Name);
		
		Step_End(6, "Click file upload button", test, test1);
		Step_Start(7, "click DG File", test, test1);


		waitForPopup(driver, popup_Message, File_Uploaded_Popup);
		String Act_File_upload_popup =getText(driver, popup_Message);
		if(Act_File_upload_popup.equals(File_Uploaded_Popup)) {
			System.out.println("Matched || Expected: File uploaded popup message should be displayed: " + File_Uploaded_Popup + " || Actual: File uploaded popup message is displayed: " + Act_File_upload_popup);
			Extent_pass(driver, "Matched || Expected: File uploaded popup message should be displayed: " + File_Uploaded_Popup + " || Actual: File uploaded popup message is displayed: " + Act_File_upload_popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected: File uploaded popup message should be displayed: " + File_Uploaded_Popup + " || Actual: File uploaded popup message is NOt  displayed: " + Act_File_upload_popup);
			Extent_fail(driver, "Not Matched || Expected: File uploaded popup message should be displayed: " + File_Uploaded_Popup + " || Actual: File uploaded popup message is Not displayed: " + Act_File_upload_popup, test, test1);
		}
		
		
		waitForElement(driver, File_Upload_Name_text);
		String Act_File_name =getText(driver, File_Upload_Name_text);
		
		if(File_Name.equals(Act_File_name)) {
			
			System.out.println("Matched || Expected: File uploaded Name should be displayed: " + File_Name + " || Actual: File uploaded Name is displayed: " + Act_File_name);
			Extent_pass(driver, "Matched || Expected: File uploaded Name should be displayed: " + File_Name + " || Actual: File uploaded Name is displayed: " + Act_File_name, test, test1);
		}else {
			System.out.println("Not Matched || Expected: File uploaded Name should be displayed: " + File_Name + " || Actual: File uploaded Name is Not displayed: " + Act_File_name);
			Extent_fail(driver, "Not Matched || Expected: File uploaded Name should be displayed: " + File_Name + " || Actual: File uploaded Name is Not displayed: " + Act_File_name, test, test1);
		}
		Step_End(7, "click DG File", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
