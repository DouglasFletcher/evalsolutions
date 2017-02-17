
/*
package workExp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

class ParseLine {
	// for each line compare max & min date 
	// and get difference in months between them
	
	private String inLine ;
	
	ParseLine(String lineVal){
		this.inLine = lineVal;
	}
		
	private static int differenceInMonths(Date minDate, Date maxDate) {
		// get difference in two dates in months return as year rounds
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(minDate);
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(maxDate);
	    int diff = 0;
	    while (c2.after(c1)) {
	    	c1.add(Calendar.MONTH, 1);
	        if (c2.after(c1)) {
	        	diff++;
	        }
	    }
	    // add one month for end of month
	    int yearDiff = ((diff + 1) / 12) ; 
	    return yearDiff;
	}
		
	public int parseToDate(){
		// parse max & min dates & return difference
		List<String> workHistUser = Arrays.asList(this.inLine.split("\\s*;\\s*"));
		String dateRange = null;
		String[] dateVal = null;
		Date maxDate = null;
		Date minDate = null;
				
		for (int i= 0; i < workHistUser.size(); i++){
			// get date values as month + year
			dateRange = workHistUser.get(i);
			dateVal = dateRange.split("-");
			for (int j = 0; j < dateVal.length; j++){
				// date as string
				String dateStr = dateVal[j];
				// parse date
				DateFormat format = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
				Date date = null;
				try {
					date = format.parse(dateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					// get max date
					if (date.after(maxDate)) {
						maxDate = date;
					}
					// get min date
					if (date.before(minDate)) {
						minDate = date;
					}
				// first attempt set as first date
				} catch (Exception e) {
					maxDate = date;
					minDate = date;
				}
			}
		}
		// difference in months
		int yearDiff = differenceInMonths(minDate, maxDate);

		System.out.println("earliest job : " + minDate);
		System.out.println("latest job : " + maxDate);
		return yearDiff;
	}
}
*/