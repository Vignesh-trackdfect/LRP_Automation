package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_017 extends Keywords {

	public void Detention_Waiver_TS_017(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_017";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String Bl_Input_Field = Excel_data.get("BL_Number");
		String coloum_Header = Excel_data.get("coloum_Header");
		String WaiverOption = Excel_data.get("Weiver_For");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);

		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, WaiverOption);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);

		Step_Start(2, "Click on BL No Search Field", test, test1);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, Bl_Input_Field, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, "Click on show Button", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);
		
		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, "Click on show Button", test, test1);
		
		scrollBottom(driver);
		reArrangeAG_GridColumnsNew(driver, DW_coloum_button, coloum_Header);
		
	
		Step_Start(5,
				"Verify that Gross Local Amount,Net Local Amount,Net Tariff Amount of total and Each container amount Sum AMount has to Match.\r\n"
						+ "",
				test, test1);
		
		scrollElementToView(driver, DW_totalRecords_ContainerTable);
		waitForElement(driver, DW_totalRecords_ContainerTable);
		String totalRecords=getText(driver, DW_totalRecords_ContainerTable);
		int totalRows=Integer.parseInt(totalRecords);
		
		List<Double> amountValues = new ArrayList<>();
		List<Double> amountValues_Local = new ArrayList<>();
		List<Double> amountValues_Tariff = new ArrayList<>();

		for(int i=0;i<=totalRows-2;i++) {
		
			String actualGrossLocalAmtRow=String.format(DW_Gross_Local_Amount_Rows, i);
			String actualLocalAmtRow=String.format(DW_Net_Local_Amount, i);
			String actualTariffAmtRow=String.format(DW_Net_Tariff_Amount_Gridcell, i);

			mouseOverToElement(driver, actualGrossLocalAmtRow);
			waitForElement(driver, actualGrossLocalAmtRow);
			click(driver, actualGrossLocalAmtRow);
			waitForElement(driver, actualGrossLocalAmtRow);
			
			String actualAmt=getText(driver, actualGrossLocalAmtRow);
			String actualAmt_Local=getText(driver, actualLocalAmtRow);
			String actualAmt_Tariff=getText(driver, actualTariffAmtRow);

			try {
				double amount = getNumberValue(actualAmt);
				amountValues.add(amount); // Add the amount to the list
				
				double amountLocal = getNumberValue(actualAmt_Local);
				amountValues_Local.add(amountLocal);
				
				double amount_Tariff = getNumberValue(actualAmt_Tariff);
				amountValues_Tariff.add(amount_Tariff);
				
			} catch (NumberFormatException e) {
				// Handle invalid text (e.g., if it's not a number)
				System.out.println("Invalid amount value: " + actualAmt_Local);
			}
			
		}
		
		   String lastRow=String.format(DW_Gross_Local_Amount_Rows,totalRows-1 );
		   waitForDisplay(driver, lastRow);
		   scrollElementToView(driver, lastRow);
		   waitForElement(driver, lastRow);

			String lastAmountValue =getText(driver, lastRow);
			double lastAmount_ = getNumberValue(lastAmountValue);

			double totalAmount = 0.0;
			for (Double value : amountValues) {
				totalAmount += value; // Sum up the amounts
			}

//	Gross Local
			// Print the total amount
			System.out.println("Total Amount (Sum): " + totalAmount);

			if (lastAmount_ == totalAmount) {
				System.out.println("Gross Local Amount was Matched || Expected value was : " + totalAmount
						+ " || Actual value was : " + lastAmount_);
				Extent_pass_New(driver, "Gross Local Amount was Matched || Expected value was : " + totalAmount
						+ " || Actual value was : " + lastAmount_, test, test1);
			} else {
				System.out.println("Gross Local Amount was Not Matched || Expected value was : " + totalAmount
						+ " || Actual value was : " + lastAmount_);
				Extent_fail(driver, "Gross Local Amount was Not Matched || Expected value was : " + totalAmount
						+ " || Actual value was  : " + lastAmount_, test, test1);
			}

//			Net Local
			
			   String lastRow_Local=String.format(DW_Net_Local_Amount,totalRows-1 );
				String lastAmountValue_Local =getText(driver, lastRow_Local);
				double lastAmount_Local = getNumberValue(lastAmountValue_Local);

				double totalAmount_Local = 0.0;
				for (Double value : amountValues_Local) {
					totalAmount_Local += value; // Sum up the amounts
				}

				// Print the total amount
				System.out.println("Total Amount (Sum): " + totalAmount_Local);

				if (lastAmount_Local == totalAmount_Local) {
					System.out.println("Net Local Amount was Matched || Expected value was : " + totalAmount_Local
							+ " || Actual value was : " + lastAmount_Local);
					Extent_pass_New(driver, "Net Local Amount was Matched || Expected value was : " + totalAmount_Local
							+ " || Actual value was : " + lastAmount_Local, test, test1);
				} else {
					System.out.println("Net Local Amount was Not Matched || Expected value was : " + totalAmount_Local
							+ " || Actual value was : " + lastAmount_Local);
					Extent_fail(driver, "Net Local Amount was Not Matched || Expected value was : " + totalAmount_Local
							+ " || Actual value was  : " + lastAmount_Local, test, test1);
				}
			
			
//	Net tariff	

			
			   String lastRow_TariffAmtRow=String.format(DW_Net_Tariff_Amount_Gridcell,totalRows-1 );
				String lastAmountValue_Tariff =getText(driver, lastRow_TariffAmtRow);
				double lastAmount_Tariff = getNumberValue(lastAmountValue_Tariff);

				double totalAmount_Tariff = 0.0;
				for (Double value : amountValues_Tariff) {
					totalAmount_Tariff += value; // Sum up the amounts
				}

				// Print the total amount
				System.out.println("Total Amount (Sum): " + totalAmount_Tariff);

				if (lastAmount_Tariff == totalAmount_Tariff) {
					System.out.println("Net Tariff Amount was Matched || Expected value was : " + totalAmount_Tariff
							+ " || Actual value was : " + lastAmount_Tariff);
					Extent_pass_New(driver, "Net Tariff Amount was Matched || Expected value was : " + totalAmount_Tariff
							+ " || Actual value was : " + lastAmount_Tariff, test, test1);
				} else {
					System.out.println("Net Tariff Amount was Not Matched || Expected value was : " + totalAmount_Tariff
							+ " || Actual value was : " + lastAmount_Tariff);
					Extent_fail(driver, "Net Tariff Amount was Not Matched || Expected value was : " + totalAmount_Tariff
							+ " || Actual value was  : " + lastAmount_Tariff, test, test1);
				}
		
		Step_End(5,
				"Verify that Gross Local Amount,Net Local Amount,Net Tariff Amount of total and Each container amount Sum AMount has to Match.\r\n"
						+ "",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
