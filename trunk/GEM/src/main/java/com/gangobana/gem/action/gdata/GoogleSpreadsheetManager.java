package com.gangobana.gem.action.gdata;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gangobana.gem.domain.Expense;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class GoogleSpreadsheetManager {
	
	private Expense expense;
	private static final String EXPENSE_SPREADSHEET_NAME = "Controle de gastos";
	private static final Map<Integer, String> months;
	
	static {
		months = new HashMap<Integer, String>(12);
		months.put(0, "Janeiro");
		months.put(1, "Fevereiro");
		months.put(2, "Março");
		months.put(3, "Abril");
		months.put(4, "Maio");
		months.put(5, "Junho");
		months.put(6, "Julho");
		months.put(7, "Agosto");
		months.put(8, "Setembro");
		months.put(9, "Outubro");
		months.put(10, "Novembro");
		months.put(11, "Dezembro");
	}
	
	public GoogleSpreadsheetManager(Expense expense) {
		this.expense = expense;
	}
	
	public void doSpreadsheetWork() {
		SpreadsheetService service = new SpreadsheetService("com.gangobana.GEM");
		try {
			
			service.setUserCredentials(expense.getUserlogin(), new String(expense.getUserPassword()));
			URL metafeedUrl = new URL("http://spreadsheets.google.com/feeds/spreadsheets/private/full");
			SpreadsheetFeed feed = service.getFeed(metafeedUrl, SpreadsheetFeed.class);
			
			// Obtains the correct spreadsheet
			List<SpreadsheetEntry> spreadsheets = feed.getEntries();
			SpreadsheetEntry expenseSpreadsheet = null;
			
			for (SpreadsheetEntry entry : spreadsheets) {
				if (entry.getTitle().getPlainText().equals(EXPENSE_SPREADSHEET_NAME)) {
					expenseSpreadsheet = entry;
					break;
				}
			}
			
			// Obtains the correct worksheet
			String expenseMonth = months.get(expense.getExpenseDate().get(Calendar.MONTH));	
			List<WorksheetEntry> worksheets = expenseSpreadsheet.getWorksheets();
			WorksheetEntry currentWorksheet = null;
			
			for (WorksheetEntry entry : worksheets) {
				if (entry.getTitle().getPlainText().contains(expenseMonth)) {
					currentWorksheet = entry;
					break;
				}
			}
			
			// Update the worksheet metadata
			// Obtains the correct column
			URL listFeedUrl = currentWorksheet.getListFeedUrl();
			ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
			for (ListEntry entry : listFeed.getEntries()) {
				System.out.println(entry.getTitle().getPlainText());
				for (String tag : entry.getCustomElements().getTags()) {
				    System.out.println("  " + entry.getCustomElements().getValue(tag) + "");
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			// It wasn't possible to authenticate
			e.printStackTrace();
		}
		finally {
			// Logs out of the service
		}
		
		
		
		
	}

}
