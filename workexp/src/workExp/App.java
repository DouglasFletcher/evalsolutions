package workExp;

import java.io.IOException;
import java.lang.NullPointerException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.FileReader;

class ReadFile {
	
	private String fileName;
	
	ReadFile(String fileName) {
		this.fileName = fileName;
	}

	public String[] OpenFile() throws IOException {

		FileReader fr = new FileReader(this.fileName);
		BufferedReader br = new BufferedReader(fr);
		
		int numberOfLines = this.readLines();
		String[] textData = new String[numberOfLines];
	
		int i;
		
		for (i=0; i < numberOfLines; i++){
			textData[i] = br.readLine();
		}
		br.close();
		return textData;
	}
	
	public int readLines() throws IOException {
		
		FileReader fr = new FileReader(this.fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		int lineCnt = 0;
		
		while (( line = br.readLine()) != null) {
			lineCnt ++;
		}
		br.close();
		return lineCnt;
	}

}
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

public class App {

	public static void main(String[] args) throws IOException, NullPointerException {

		String fileRef = "c:/projects/2015/codeEval/workexp/rawData.txt";
		//String fileRef = "Some File Name";
		
		// __init__ file read
		ReadFile rf = new ReadFile(fileRef);
		
		// open file lines as list
		String[] listVal = rf.OpenFile();
		
		// initial place to store answer for each
		int[] listOut = new int[listVal.length];
		
		for (int i=0; i < listVal.length; i++){
			System.out.println("line is : " + listVal[i]); 				
			
			// years of experience save to []int 
			ParseLine parseLine = new ParseLine(listVal[i]);
			int expYrs = parseLine.parseToDate();
			listOut[i] = expYrs;
			System.out.println("experience : " + expYrs + " years");
			System.out.println("");
		}
			
		int[] varOut = listOut;
	}

}
