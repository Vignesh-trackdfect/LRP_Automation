package LRP_EMS_Equipment_Profile_Scripts;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Equipment_Profile_TS_057 extends Keywords{
	
//	To Update weight details in Equipment Profile
	
	public void updateWeightDetails(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		String testCaseName="TC_Equipment_Profile_TS_057";
	//  Get data from excel sheet	
		
		
		
				
        String username = Excel_data.get("Username");
        String password = Excel_data.get("Password");
        String moduleName = Excel_data.get("ModuleEquipmentProfile");
        String eqpProEqpNo = Excel_data.get("EqpProfileEquipmentNo");
		String tareWeight = Excel_data.get("TareWeight");
		String payLoad = Excel_data.get("PayLoad");
		String updatedPopup = Excel_data.get("UpdatedPopup");

		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition = Excel_data.get("DropdownCondition");

		String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
		String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login
		
		LRP_Login(driver, username, password);
		
//		Module Search
		moduleNavigate(driver, moduleName);
		
		Step_Start(1, "Click global search icon", test, test1);
		
		waitForDisplay(driver,  newButton_EquipmentProfile_Homepage);
		if(isdisplayed(driver,  newButton_EquipmentProfile_Homepage)) {
			click(driver,  newButton_EquipmentProfile_Homepage);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(1, "Click global search icon ", test, test1);
		Step_Start(2, "Enter valid container no in equipment no field", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, eqpProEqpNo, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

		
		Step_End(2, "Enter valid container no in equipment no field", test, test1);
		
		waitForElement(driver, eqpNoTextField_L);
		String actEqNo = getAttribute(driver, eqpNoTextField_L, "value");
		System.out.println("Actual:" + actEqNo);
		System.out.println("Expected:" + eqpProEqpNo);
		
		waitForElement(driver, maxGrossWeightTextField_L);
		String beforeGross = getAttribute(driver, maxGrossWeightTextField_L, "value");
		String tareWeightBefore = getAttribute(driver, tareWeightTextField_L, "value");
		String payLoadBefore = getAttribute(driver, payLoadTextField_L, "value");
		System.out.println("Before max gross Weight:" + beforeGross);
		System.out.println("Tare weight before:" + tareWeightBefore);
		System.out.println("Payload before:" + payLoadBefore);
		
		
		Step_Start(3, "Clik Edit button ", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(3, "Clik Edit button ", test, test1);
			
			Step_Start(4, "Enter updated amount for Tare & Payload field ", test, test1);
			waitForElement(driver, tareWeightTextField_L);
			click(driver, tareWeightTextField_L);
			waitForElement(driver, tareWeightTextField_L);
			clear(driver, tareWeightTextField_L);
			waitForElement(driver, tareWeightTextField_L);
			sendKeys(driver, tareWeightTextField_L, tareWeight);
			waitForElement(driver, tareWeightTextField_L);
			clearAndType(driver, tareWeightTextField_L, tareWeight);

			waitForElement(driver, payLoadTextField_L);
			clear(driver, payLoadTextField_L);
			waitForElement(driver, payLoadTextField_L);
			sendKeys(driver, payLoadTextField_L, payLoad);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(4, "Enter updated amount for Tare & Payload field ", test, test1);
//	Updated popup
		Step_Start(5, "Updated Popup Verification", test, test1);
		waitForPopup(driver, Popup_Message, updatedPopup);

		String actualPopup=getText(driver, Popup_Message);
		System.out.println("actualPopup: "+actualPopup);
		if(actualPopup.equals(updatedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup, test, test1);
			System.out.println("Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup);
		}else {
			System.out.println("Not Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup: "+updatedPopup+" || Actual popup: "+actualPopup +"<br>"+updatedPopup+" popup is not displayed", test, test1);
		}
		
		Step_End(5, "Updated Popup Verification", test, test1);
		
		Step_Start(6, "Gross will calculate automatically", test, test1);
		waitForElement(driver, tareWeightTextField_L);
		String tareWeightAfter = getAttribute(driver, tareWeightTextField_L, "value");
		String actual_TareWeight=tareWeightAfter.replace(",", "");
		String payLoadAfter = getAttribute(driver, payLoadTextField_L, "value");
		String actual_PayLoad=payLoadAfter.replace(",", "");

		System.out.println("Tare weight after:" + tareWeightAfter);
		System.out.println("Payload after:" + payLoadAfter);

		String afterGross = getAttribute(driver, maxGrossWeightTextField_L, "value");
		System.out.println("After max gross Weight:" + afterGross);
		String act_Gross=afterGross.replace(",", "");
		System.out.println("act_Gross:"+act_Gross);
		
		DecimalFormat df=new DecimalFormat("0.00");

		double tareDoub=Double.parseDouble(actual_TareWeight);
		String actualTareWeight=df.format(tareDoub);
		System.out.println("actualTareWeight:"+actualTareWeight);

		double payDoub=Double.parseDouble(actual_PayLoad);
		String actualPayLoad=df.format(payDoub);
		System.out.println("actualPayLoad:"+actualPayLoad);	
		
		double maxGross=tareDoub+payDoub;
		System.out.println("maxGross:"+maxGross);

		double actual_Gross=Double.parseDouble(act_Gross);
		String actGross=df.format(actual_Gross);
		System.out.println("actual_Gross : "+actGross);
		
		String actMaxGross=df.format(maxGross);
		System.out.println("actMaxGross:"+actMaxGross);
		
		// Verification			
		
		if (actGross.equals(actMaxGross)) {
			System.out.println("Matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross);
			Extent_pass_New(driver,"Matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross,test,test1);
			Extent_pass_New(driver, "max Gross weight is calculated and it is verified", test,test1);
			System.out.println("max Gross weight is calculated and it is verified");
		} else {
			System.out.println("Not matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross);
			System.out.println("max Gross weight is not calculated and it is verified");
			Extent_fail(driver,"Not matched || " + " Expected Gross weight  : " + actMaxGross + " || Actual Gross weight  : " + actGross +"<br>"+"max Gross weight is not calculated and it is verified",test,test1);
		}
	
		if (actualTareWeight.equals(tareWeight)) {
			System.out.println("Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
			Extent_pass_New(driver,"Matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight,test,test1);
					
			Extent_pass_New(driver, "Tare weight updated and it is verified", test,test1);
			System.out.println("Tare weight updated and it is verified");
		} else {
			System.out.println("Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight);
			System.out.println("Tare weight not updated and it is verified");
			Extent_fail(driver,"Not matched || " + " Expected Tare weight : " + tareWeight + " || Actual Tare weight : " + actualTareWeight+"<br>"+"Tare weight not updated and it is verified",test,test1);
		}
		if (actualPayLoad.equals(payLoad)) {
			System.out.println("Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
			Extent_pass_New(driver,"Matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad,test,test1);			
			Extent_pass_New(driver, "Pay load updated and it is verified", test,test1);
			System.out.println("Pay load updated and it is verified");
		} else {
			System.out.println("Not matched || " + " Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad);
			System.out.println("Pay load not updated and it is verified");
			Extent_fail(driver,"Not matched || Expected Payload : " + payLoad + " || Actual Payload : " + actualPayLoad+"<br>"+"Pay load not updated and it is verified",test,test1);
		}
		Step_End(6, "Gross will calculate automatically", test, test1);
	
		Extent_completed(testCaseName, test, test1);
	}
}
