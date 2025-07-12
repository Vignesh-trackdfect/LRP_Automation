package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Delivery_Order_TS_046 extends Keywords{
	public void Delivery_Order_TS_046(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_046";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearchFilterOption_DO=Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String globalSearchFilterOption_DO_Reset=Excel_data.get("GlobalSearchFilterOption_DO_Reset");
		String module_Delivery_Order = Excel_data.get("Module_Delivery_Order");
		String module_Delivery_Order_Reset = Excel_data.get("Module_Delivery_Order_Reset");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String remarks = Excel_data.get("Remarks");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String attribute=Excel_data.get("Attribute");
		String description=Excel_data.get("AttributeDescription");
		String value=Excel_data.get("Value");
		String emptyReturnForm=Excel_data.get("EmptyReturnForm");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String value_back = Excel_data.get("value_back");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Condition = Excel_data.get("Condition");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header,Attribute_Search_Column_Header,Condition, agencyUser, attribute, description, value);
		Step_Start(5, "Open delivery order module ", test, test1);
		//	Delivery Order
		moduleNavigate(driver, module_Delivery_Order);
		Extent_cal(test, test1, module_Delivery_Order);
		Step_End(5, "Open delivery order module ", test, test1);
		Step_Start(6, "Click search button and fetch the record using BL number or Delivery Order number", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,dropdownCondition,globalSearchFilterOption_DO,globalSearch_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO, status_Filer_Data);
		waitForElement(driver, deliveryOrderNumber_Textfield);
		String actualDO_Number=getAttribute(driver, deliveryOrderNumber_Textfield,"value");
		Step_End(6, "Click search button and fetch the record using BL number or Delivery Order number", test, test1);
		Step_Start(7, "Select the print do and empty return form check box", test, test1);
		//	With Delivery Order
		Extent_call(test, test1, "With Delivery Order");
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, "Yes");
		waitForElement(driver, emptyReturnForm_Checkbox);
		checkBox(driver, emptyReturnForm_Checkbox, "Yes");
		scrollBottom(driver);
		waitForElement(driver, select_All_Checkbox_DO);
		checkBox(driver, select_All_Checkbox_DO, "Yes");
		waitForElement(driver, select_All_Checkbox_DO);
		scrollTop(driver);
		Step_End(7, "Select the print do and empty return form check box", test, test1);
		Step_Start(8, "Click print", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(8, "Click print", test, test1);
		Step_Start(9, "Make sure system allows to print both printouts", test, test1);
		waitForDisplay(driver, pdf_Viewer);
		if(isDisplayed(driver, pdf_Viewer)) {
			System.out.println("Matched || Expected Result is : print page Should be open || Actual Result is : print page is opened");
			Extent_pass_New(driver, "Matched || Expected Result is : print page Should be open || Actual Result is : print page is opened", test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : print page Should be open || Actual Result is : print page is Not opened");
			Extent_fail(driver, "Not Matched || Expected Result is : print page Should be open || Actual Result is : print page is Not opened", test, test1);
		}
		switchToFrame(driver, iFrame);
		String doNumber = String.format(DO_Number_PDF, actualDO_Number);
		waitForElement(driver, doNumber);
		String doNumber_PDF=getText(driver, doNumber);
		if(doNumber_PDF.equals(actualDO_Number)) {
			Extent_pass_New(driver, "Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number, test, test1);
			System.out.println("Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number);
		}else {
			System.out.println("Not Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number);
			Extent_fail(driver, "Not Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number, test, test1);
		}
		String stringFormatPageNo=getText(driver, totalPages_PDF);
		String[] splitPageNo=stringFormatPageNo.split(" ");
		int totalPages=Integer.parseInt(splitPageNo[1]);
		System.out.println("totalPages : "+totalPages);
		for(int i=1;i<totalPages;i++) {
			if( i<totalPages) {
				waitForElement(driver, pdf_PageNext_Button);
				click(driver, pdf_PageNext_Button);
			}
		}
		List<WebElement> total = listOfElements(driver, emptyReturnForm_PDF);
		int noOfCopies=total.size();
		System.out.println("noOfCopies:"+noOfCopies);
		String actualText=getText(driver,emptyReturnForm_PDF);
		System.out.println("actualText"+actualText); 
		if(actualText.equals(emptyReturnForm)) {
			Extent_pass_New(driver, "Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText, test, test1);
			System.out.println("Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText);
		}else {
			System.out.println("Not Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText);
			Extent_fail(driver, "Not Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText, test, test1);
		}
		if(noOfCopies==2) {
			Extent_pass_New(driver,"Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Printed", test, test1);
			System.out.println("Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Printed");
		}else {
			System.out.println("Not Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Not Printed");
			Extent_fail(driver,"Not Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Not Printed", test, test1);
		}
		switchToDefaultFrame(driver);
		waitForElement(driver, close_Button_PDF_Viewer);
		click(driver, close_Button_PDF_Viewer);
		Step_End(9, "Make sure system allows to print both printouts", test, test1);
		//		Without Delivery Order
		Extent_call(test, test1, "Without Delivery Order");
		Step_Start(8, "Click print", test, test1);
		waitForElement(driver, Print_DO_Check_Box);
		click(driver, Print_DO_Check_Box);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(8, "Click print", test, test1);
		Step_Start(9, "Make sure system allows to print both printouts", test, test1);
		waitForElement(driver, iFrame);
		switchToFrame(driver, iFrame);
		waitForElement(driver, totalPages_PDF);
		String stringFormatPageNo2=getText(driver, totalPages_PDF);
		String[] splitPageNo2=stringFormatPageNo2.split(" ");
		int totalPages2=Integer.parseInt(splitPageNo2[1]);
		System.out.println("totalPages : "+totalPages2);
		for(int j=1;j<totalPages2;j++) {
			if( j<totalPages2) {
				waitForElement(driver, pdf_PageNext_Button);
				click(driver, pdf_PageNext_Button);
			}
		}
		String actualText1=getText(driver,emptyReturnForm_PDF);
		System.out.println("actualText"+actualText1); 
		List<WebElement> total1 = listOfElements(driver, emptyReturnForm_PDF);
		int noOfCopies1=total1.size();
		System.out.println("noOfCopies:"+noOfCopies1);

		if(actualText1.equals(emptyReturnForm)) {
			Extent_pass_New(driver, "Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText1, test, test1);
			System.out.println("Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText1);
		}else {
			System.out.println("Not Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText1);
			Extent_fail(driver, "Not Matched || Expected Name : "+emptyReturnForm +" || Actual Name : "+actualText1, test, test1);
		}
		if(noOfCopies1==2) {
			Extent_pass_New(driver,"Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Printed", test, test1);
			System.out.println("Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Printed");
		}else {
			System.out.println("Not Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Not Printed");
			Extent_fail(driver,"Not Matched || Expected Result is : Two Copies of Empty Return Form Should be Print || Actual Result is : Two Copies of Empty Return Form Not Printed", test, test1);
		}
		switchToDefaultFrame(driver);
		waitForElement(driver, close_Button_PDF_Viewer);
		click(driver, close_Button_PDF_Viewer);
		Step_End(9, "Make sure system allows to print both printouts", test, test1);
		if(Reset_Option.equalsIgnoreCase("Yes")) {
		//		Delivery Order Reset
		Extent_cal(test, test1, module_Delivery_Order_Reset);
		moduleNavigate(driver, module_Delivery_Order_Reset);
		waitForElement(driver, DO_Number_SearchButton);
		click(driver, DO_Number_SearchButton);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_DO_Reset,actualDO_Number, "", "", "", "");
		waitForElement(driver, DO_Reset_Remarks_Area);
		sendKeys(driver, DO_Reset_Remarks_Area, remarks);
		waitForElement(driver, DO_Reset_Button);
		click(driver, DO_Reset_Button);
		waitForElement(driver,popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		}
		// Agency Configuration
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, agencyUser, description, value_back, newlyadded, set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}