package locators;

import java.util.Map;

import commonMethods.Testcases;
import commonMethods.Utils;

public interface Recurring_Journal_Locators {

	Map<String, String> ExcelData = Utils.getDataAsMap(Testcases.conection_vale, "Recurring_Journal",
			"Reference_Name", Testcases.environmentName);


	public static String Transaction_No_searchBtn_RJ = ExcelData.get("Transaction_No_searchBtn_RJ");
	public static String Generate_Button_RJ = ExcelData.get("Generate_Button_RJ");
	public static String Recurring_Journal_Grid = ExcelData.get("Recurring_Journal_Grid");
	public static String week_Click_RJ = ExcelData.get("week_Click_RJ");
	public static String Year_Click_RJ = ExcelData.get("Year_Click_RJ");
	public static String Review_Journal_Button_RJ = ExcelData.get("Review_Journal_Button_RJ");
	public static String Trans_Number_TF_JNL = ExcelData.get("Trans_Number_TF_JNL");
	public static String Trans_Number_select = ExcelData.get("Trans_Number_select");
	public static String Search_Button_RJ = ExcelData.get("Search_Button_RJ");
	public static String Recurring_Posting_Details_Button_RJ = ExcelData.get("Recurring_Posting_Details_Button_RJ");
	public static String Posting_details_Page_RJ = ExcelData.get("Posting_details_Page_RJ");
	public static String Posting_Details_From_Date_RJ = ExcelData.get("Posting_Details_From_Date_RJ");
	public static String Posting_Details_to_Date_RJ = ExcelData.get("Posting_Details_to_Date_RJ");
	public static String Status_Type = ExcelData.get("Status_Type");
	public static String Select_Type = ExcelData.get("Select_Type");
	public static String posting_Details_Grid_Header = ExcelData.get("posting_Details_Grid_Header");
	public static String posting_Details_Grid_Rows = ExcelData.get("posting_Details_Grid_Rows");
	public static String show_Btn_RJ = ExcelData.get("show_Btn_RJ");
	public static String Clear_button_RJ = ExcelData.get("Clear_button_RJ");
	public static String Posting_status_RadioBtn_RJ = ExcelData.get("Posting_status_RadioBtn_RJ");
	public static String Activity_Date_RadioBtn_RJ = ExcelData.get("Activity_Date_RadioBtn_RJ");
	public static String scroll_RJ = ExcelData.get("scroll_RJ");
	public static String Date_Radio_Button_RJ = ExcelData.get("Date_Radio_Button_RJ");
	public static String End_Date_RJ = ExcelData.get("End_Date_RJ");
	public static String Recurring_No_RJ = ExcelData.get("Recurring_No_RJ");
	public static String Trans_numner_search = ExcelData.get("Trans_numner_search");
	public static String create_batch = ExcelData.get("create_batch");
	public static String Day_input = ExcelData.get("Day_input");
	public static String week_radio_button = ExcelData.get("week_radio_button");
	public static String month_radio_button = ExcelData.get("month_radio_button");
	public static String year_radio_button = ExcelData.get("year_radio_button");
	public static String week_input = ExcelData.get("week_input");
	public static String month_input = ExcelData.get("month_input");
	public static String year_input = ExcelData.get("year_input");
	public static String start_date = ExcelData.get("start_date");
	public static String end_date = ExcelData.get("end_date");
	public static String end_date_radio_button = ExcelData.get("end_date_radio_button");
	public static String No_end_date_radio_button = ExcelData.get("No_end_date_radio_button");
	public static String recurring_journal_click = ExcelData.get("recurring_journal_click");
	public static String week_days_click = ExcelData.get("week_days_click");
	public static String month_days_click = ExcelData.get("month_days_click");
	public static String year_days_click = ExcelData.get("year_days_click");
	public static String day_drop_click = ExcelData.get("day_drop_click");
	public static String day_drop_click_year = ExcelData.get("day_drop_click_year");
	public static String year_month_click = ExcelData.get("year_month_click");
	public static String year_month_click1 = ExcelData.get("year_month_click1");
	public static String date_select = ExcelData.get("date_select");
	public static String day_drop_select_click = ExcelData.get("day_drop_select_click");
	public static String year_month_click_drop = ExcelData.get("year_month_click_drop");
	public static String day_drop_select_click1 = ExcelData.get("day_drop_select_click1");
	public static String generate_button = ExcelData.get("generate_button");
	public static String select_row = ExcelData.get("select_row");
	public static String recurring_journal_pop = ExcelData.get("recurring_journal_pop");
	public static String recurring_journal_edit_pop = ExcelData.get("recurring_journal_edit_pop");
	public static String recurring_journal_No = ExcelData.get("recurring_journal_No");
	public static String recurring_journal_select_checkbox = ExcelData.get("recurring_journal_select_checkbox");
	public static String recurring_journal_post_button = ExcelData.get("recurring_journal_post_button");
	public static String recurring_journal_account_book_num = ExcelData.get("recurring_journal_account_book_num");
	public static String recurring_journal_clicksecount_tab = ExcelData.get("recurring_journal_clicksecount_tab");
	public static String recurring_journal_trans_tab = ExcelData.get("recurring_journal_trans_tab");
	public static String recurring_journal_posted_date = ExcelData.get("recurring_journal_posted_date");
	public static String recurring_journal_user_tab = ExcelData.get("recurring_journal_user_tab");
	public static String recurring_journal_status = ExcelData.get("recurring_journal_status");
	public static String recurring_journal_remove_button = ExcelData.get("recurring_journal_remove_button");
	public static String recurring_journal_batch_type = ExcelData.get("recurring_journal_batch_type");
	public static String recurring_journal_userr = ExcelData.get("recurring_journal_userr");

}
