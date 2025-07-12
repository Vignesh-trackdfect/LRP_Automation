package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_034 extends Keywords {

	public void DG_Creation_SC_034(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_034";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String UN_No = Excel_data.get("UN_No");
		String EXP_SADT = Excel_data.get("EXP_SADT");
		String SADT_Input = Excel_data.get("SADT_Input");
		String Exp_Control_Temperature = Excel_data.get("Exp_Control_Temperature");
		String Control_Temperature_Input = Excel_data.get("Control_Temperature_Input");
		String Exp_Emergency_Temperature = Excel_data.get("Exp_Emergency_Temperature");
		String Emergency_Temperature_Input = Excel_data.get("Emergency_Temperature_Input");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		Step_Start(1, "Retrieve the Book number with non operator refer N ", test, test1);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_End(1, "Retrieve the Book number with non operator refer N ", test, test1);

		Step_Start(4, "click multi apply  button", test, test1);
		
		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		
		waitForPopup(driver, popup_Message, EXP_SADT);
		String act_SADT = getText(driver, popup_Message);
		
		if (act_SADT.equals(EXP_SADT)) {
			System.out.println("Matched || " + " Expected : S.A.D.T popup should be display : " + EXP_SADT+ " || Actual : S.A.D.T popup is Display : " + act_SADT);
			Extent_pass(driver, "Matched || " + " Expected : S.A.D.T popup should be display : " + EXP_SADT+ " || Actual : S.A.D.T popup is Display : " + act_SADT, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected : S.A.D.T popup should be display : " + EXP_SADT+ " || Actual : S.A.D.T popup is Display : " + act_SADT);
			Extent_fail(driver, "Not Matched || " + " Expected : S.A.D.T popup should be display : " + EXP_SADT+ " || Actual : S.A.D.T popup is Display: " + act_SADT, test, test1);
		}
		
		scrollTop(driver);
		
		waitForElement(driver, DG_SADT_Input);
		sendKeys(driver, DG_SADT_Input, SADT_Input);
		
		scrollElementToView(driver, Multi_Apply_Btn);
		
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		waitForPopup(driver, popup_Message, Exp_Control_Temperature);
		String Act_Control_Temperature = getText(driver, popup_Message);
		
		if (Act_Control_Temperature.equals(Exp_Control_Temperature)) {
			System.out.println("Matched || " + " Expected :  Control Temperature popup should be display : " + Exp_Control_Temperature+ " || Actual : Control Temperature popup is Display : " + Act_Control_Temperature);
			Extent_pass(driver, "Matched || " + " Expected : Control Temperature popup should be display : " + Exp_Control_Temperature+ " || Actual : Control Temperature popup is Display : " + Act_Control_Temperature, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected : Control Temperature popup should be display : " + Exp_Control_Temperature+ " || Actual : Control Temperature popup is Display : " + Act_Control_Temperature);
			Extent_fail(driver, "Not Matched || " + " Expected : Control Temperature popup should be display : " + Exp_Control_Temperature+ " || Actual : Control Temperature popup is Display: " + Act_Control_Temperature, test, test1);
		}

		scrollTop(driver);
		
		waitForElement(driver, DG_ControlTemp_input);
		sendKeys(driver, DG_ControlTemp_input, Control_Temperature_Input);
		
		scrollUsingElement(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		waitForPopup(driver, popup_Message, Exp_Emergency_Temperature);
		String Act_Emergency_Temperature = getText(driver, popup_Message);
		
		if (Act_Emergency_Temperature.equals(Exp_Emergency_Temperature)) {
			System.out.println("Matched || " + " Expected : Emergency Temperature popup should be display : " + Exp_Emergency_Temperature+ " || Actual : Emergency Temperature popup is Display : " + Act_Emergency_Temperature);
			Extent_pass(driver, "Matched || " + " Expected : Emergency Temperature popup should be display : " + Exp_Emergency_Temperature+ " || Actual : Emergency Temperature popup is Display : " + Act_Emergency_Temperature, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected : Emergency Temperature popup should be display : " + Exp_Emergency_Temperature+ " || Actual : Emergency Temperature popup is Display : " + Act_Emergency_Temperature);
			Extent_fail(driver, "Not Matched || " + " Expected : Emergency Temperature popup should be display : " + Exp_Emergency_Temperature+ " || Actual : Emergency Temperature popup is Display: " + Act_Emergency_Temperature, test, test1);
		}
		
		waitForElement(driver, DG_Emergency_Temp_Input);
		sendKeys(driver, DG_Emergency_Temp_Input, Emergency_Temperature_Input);
		
		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);

		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_pass(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp	+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
		}
		
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		
		
		waitForElement(driver, DG_UN_number_Values_grid);
		String act_Un_number=getText(driver, DG_UN_number_Values_grid);
		
		if(act_Un_number.equals(UN_No)) {
			System.out.println("Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is display : " + act_Un_number);
			Extent_pass(driver, "Matched || " + " Expected UN NO Should be display : " + UN_No+ " || Actual UN NO is display : " + act_Un_number, test, test1);
		}else{
			System.out.println("Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number);
			Extent_fail(driver, "Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number, test, test1);
		}
		
		Step_End(4, "click multi apply  button", test, test1);	
		
		Extent_completed(testCaseName, test, test1);

}
	
}
