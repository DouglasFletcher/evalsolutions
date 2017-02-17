
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

class ColumnComparator implements Comparator<Date[]>{
    
	public int compare(Date[] array, Date[] anotherArray){
        return array[0].compareTo( anotherArray[0] );
    }
};


class ParseLine {

	private String inLine ;
	
	ParseLine(String lineVal){
		this.inLine = lineVal;
	}
		
	public int parseToDate() throws ParseException{
		// get work history as ordered map of dates
		List<String> workHistUser = Arrays.asList(this.inLine.split("\\s*;\\s*"));
		String dateRange = null;
		String[] dateVal = null;
		// define work history lookup		
	    ArrayList<Date[]> workHist = new ArrayList<Date[]>();
	    
		for (int i= 0; i < workHistUser.size(); i++){
		    Date[] histLookup = new Date[2];
			// get date values as month + year
			dateRange = workHistUser.get(i);
			dateVal = dateRange.split("-");
			// string to date format
			DateFormat format = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
			// convert to lookup hash
			histLookup[0] = format.parse(dateVal[0]);
			histLookup[1] = format.parse(dateVal[1]);
			workHist.add(histLookup);
		}
		// sort from first job
		Collections.sort(workHist, new ColumnComparator());
		int expYrs = lengthCalc(workHist);
		return expYrs;
	}
	
	public int lengthCalc(List< Date[] > workHist) {
		
		// initialize start value
		Date[] start0 = workHist.get(0);
		// initialize journey
		List< Date[] > workHistEnum = new ArrayList< Date[] >(workHist.size());
		// update indicator
	    int k = 0;
	    workHistEnum.add(k, start0);
		// initialize new overlapping experience
	    //Date[] newElement = new Date[2];
			    
	    for (int i = 0; i < workHist.size()-1; i ++){
			// comparable
			Date start2 = workHist.get(i+1)[0];
			Date finsh2 = workHist.get(i+1)[1];
			// other comparable
			Date[] startfinsh1 = workHistEnum.get(k);
			// if overlapping time periods
			if (startfinsh1[1].after(start2) || startfinsh1[1].equals(start2)){
				// combined work range
			    Date[] newElement = new Date[2];
				newElement[0] = startfinsh1[0];
				// get largest end date
				if (finsh2.after(startfinsh1[1])){
					newElement[1] = finsh2;
				} else {
					newElement[1] = startfinsh1[1];
				}
				workHistEnum.set(k, newElement);
			} else {
				// time period not overlapping
			    Date[] newElement = new Date[2];
				newElement[0] = start2;
				newElement[1] = finsh2;
				k++;
				workHistEnum.add(k, newElement);
			}
	    }
	    
	    // get experience return in months
	    int monthTot = 0;
	    for (int i = 0; i < workHistEnum.size(); i++){
	    	Date start = workHistEnum.get(i)[0];
	    	Date finsh = workHistEnum.get(i)[1];
	    	int monthDiff = differenceInMonths(start, finsh)+2;
	    	//System.out.println("start " + start);
	    	//System.out.println("finish " + finsh);
	    	//System.out.println("diff " + monthDiff);
	    	monthTot += monthDiff; 
	    }
	    return (int) (monthTot / 12.0)  ;
	}
	
	private static int differenceInMonths(Date minDate, Date maxDate) {
		// get difference in two dates in months
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
	    return diff;
	}
}

public class Main {

	public static void main (String[] args) throws ParseException {
	
	    try {
	        File file = new File(args[0]);
	        //File file = new File("C:/projects/2015/codeEval/workexp/rawData.txt");
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        
	        while ((line = in.readLine()) != null) {
	        	//System.out.println();
	        	//System.out.println(line);
	        	ParseLine parseLine = new ParseLine(line);
				//int expMths = parseLine.parseToDate();
	    	    //int expYrs = (int) (expMths / 12.0) ;
		        System.out.println(parseLine.parseToDate());
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
}

