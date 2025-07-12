package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EMS_EDI_Configuration_TS_014 extends Keywords {
	
	public void EMS_EDI_Configuration_TS_014(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_014";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Movement_Code_Header = Excel_data.get("Movement_Code_Header");
		String Movement_Code_input = Excel_data.get("Movement_Code_input");
		String EDI_Movement_Code_Input = Excel_data.get("EDI_Movement_Code_Input");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url); 

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);
		
		Step_Start(1, "Click the status event tab",test, test1);
		
		waitForElement(driver, EDI_Status_Event_Option);
		click(driver, EDI_Status_Event_Option);

		Step_End(1, "Click the status event tab",test, test1);
		
		Step_Start(2, "Search the partner id ",test, test1);
		
		waitForElement(driver, EEC_Status_Event_Partner_Id_Search_Button);
		click(driver, EEC_Status_Event_Partner_Id_Search_Button);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_input);
		
		Step_End(2, "Search the partner id ",test, test1);
		
		Step_Start(3, "Search the EDI ID ",test, test1);
		
		waitForElement(driver, EEC_Status_Event_EDI_Id_Search_Field);
		click(driver, EEC_Status_Event_EDI_Id_Search_Field);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Input);
		
		Step_End(3, "Search the EDI ID ",test, test1);
		
		Step_Start(4, "Enter the EDI movement code ",test, test1);
		
		waitForElement(driver, EEC_Status_Event_Movement_Code_Search_Button);
		click(driver, EEC_Status_Event_Movement_Code_Search_Button);
		
		twoColumnSearchWindow(driver, Movement_Code_Header, Filter_Condition, Movement_Code_input);
		
		waitForElement(driver, EEC_Status_Event_Add_Button);
        sendKeys(driver, EEC_Status_Event_Add_Button, EDI_Movement_Code_Input);
        
        Step_End(4, "Enter the EDI movement code ",test, test1);
		
    	Step_Start(5, "Click the add button ",test, test1);  

		waitForElement(driver, EDI_Status_Add_button);
		click(driver, EDI_Status_Add_button);
		
		waitForElement(driver, EDI_Status_Event_Filter);
		click(driver, EDI_Status_Event_Filter);
		
		waitForElement(driver, EDI_Status_Event_Filter);
		sendKeys(driver, EDI_Status_Partner_Id_Input,Partner_ID_input);
		
		waitForElement(driver, EDI_Status_EDI_Id_Input);
		sendKeys(driver, EDI_Status_EDI_Id_Input,EDI_ID_Input);
		
		waitForElement(driver, EDI_Status_Movement_Code_Input);
		sendKeys(driver, EDI_Status_Movement_Code_Input,EDI_Movement_Code_Input);
		
		waitForElement(driver, EEC_MovementCode_FilterInput);
		sendKeys(driver, EEC_MovementCode_FilterInput,Movement_Code_input);
		
		waitForElement(driver, EDI_Status_Event_Partner_in_Value);
		String Act_Partnerid=getText(driver, EDI_Status_Event_Partner_in_Value);
		
		waitForElement(driver, EDI_Status_Event_Edi_Id_Value);
		String Act_Edi_Id=getText(driver, EDI_Status_Event_Edi_Id_Value);
	
		waitForElement(driver, EDI_Status_Movement_Code_Id_Value);
		String Act_Movement_Code=getText(driver, EDI_Status_Movement_Code_Id_Value);
		System.out.println("Act_Movement_Code :"+Act_Movement_Code);
		
		waitForElement(driver, EDI_Status_Event_Movement_Name_Value);
		String Act_Movement_Name=getText(driver, EDI_Status_Event_Movement_Name_Value);
		System.out.println("Act_Movement_Name :"+Act_Movement_Name);
		
		if(Act_Partnerid.equals(Partner_ID_input)) {
		    System.out.println("Matched ||  Expected result : Given partener Id : "+ Partner_ID_input+ "should be added in the grid || Actual result : Given partener Id "+ Act_Partnerid +"was added in the grid");
			Extent_pass_New(driver, "Matched ||  Expected result : Given partener Id : "+ Partner_ID_input+ "should be added in the grid || Actual result : Given partener Id "+ Act_Partnerid +"was added in the grid", test,test1);
		}else {
			System.out.println("Not Matched ||  Expected result : Given partener Id : "+ Partner_ID_input+ "should be added in the grid || Actual result : Given partener Id "+ Act_Partnerid +"was Not added in the grid");
			Extent_fail(driver, "Not Matched ||  Expected result : Given partener Id : "+ Partner_ID_input+ "should be added in the grid || Actual result : Given partener Id "+ Act_Partnerid +"was Not added in the grid", test,test1);
		}
		
		if(Act_Edi_Id.equals(EDI_ID_Input)) {
			 System.out.println("Matched ||  Expected result : Given EDI Id : "+ EDI_ID_Input+ "should be added in the grid || Actual result : Given EDI Id "+ Act_Edi_Id +"was added in the grid");
			Extent_pass_New(driver, "Matched ||  Expected result : Given EDI Id : "+ EDI_ID_Input+ "should be added in the grid || Actual result : Given EDI Id "+ Act_Edi_Id +"was added in the grid", test,test1);
		}else {
			 System.out.println("Not Matched ||  Expected result : Given EDI Id : "+ EDI_ID_Input+ "should be added in the grid || Actual result : Given EDI Id "+ Act_Edi_Id +"was Not added in the grid");
			Extent_fail(driver, "Not Matched ||  Expected result : Given EDI Id : "+ EDI_ID_Input+ "should be added in the grid || Actual result : Given EDI Id "+ Act_Edi_Id +"was Not added in the grid", test,test1);
		}
		
		if(Act_Movement_Code.equals(Movement_Code_input)) {
			System.out.println("Matched ||  Expected result : Given Movement code : "+ Movement_Code_input+ "should be added in the grid || Actual result : Given Movement code"+ Act_Movement_Code +"was added in the grid");
			Extent_pass_New(driver, "Matched ||  Expected result : Given Movement code : "+ Movement_Code_input+ "should be added in the grid || Actual result : Given Movement code"+ Act_Movement_Code +"was added in the grid", test,test1);
		}else {
			 System.out.println("Not Matched ||  Expected result : Given Movement code : "+ Movement_Code_input+ "should be added in the grid || Actual result : Given Movement code"+ Act_Movement_Code +"was Not added in the grid");
				Extent_fail(driver, "Not Matched ||  Expected result : Given Movement code : "+ Movement_Code_input+ "should be added in the grid || Actual result : Given Movement code"+ Act_Movement_Code +"was Not added in the grid", test,test1);
		}

		if(Act_Movement_Name.equals(EDI_Movement_Code_Input)) {
			System.out.println("Matched ||  Expected result : Given Movement Name: "+ EDI_Movement_Code_Input+ "should be added in the grid || Actual result : Given Movement Name"+ Act_Movement_Name +"was added in the grid");
			Extent_pass_New(driver,"Matched ||  Expected result : Given Movement Name: "+ EDI_Movement_Code_Input+ "should be added in the grid || Actual result : Given Movement Name"+ Act_Movement_Name +"was added in the grid", test,test1);
		}else {
			System.out.println("Not Matched ||  Expected result : Given Movement Name: "+ EDI_Movement_Code_Input+ "should be added in the grid || Actual result : Given Movement Name"+ Act_Movement_Name +"was Not added in the grid");
			Extent_fail(driver,"Not Matched ||  Expected result : Given Movement Name: "+ EDI_Movement_Code_Input+ "should be added in the grid || Actual result : Given Movement Name"+ Act_Movement_Name +"was Not added in the grid", test,test1);
		}
		
		Step_End(5, "Click the add button ",test, test1);  	
		
		Extent_completed(testcase_Name, test, test1);
	}
}