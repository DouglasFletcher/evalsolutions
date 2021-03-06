package datarecovery;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main (String[] args) throws IOException {
      
    	File file = new File("C:/projects/2015/codeEval/datarecovery/rawdata.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        while ((line = buffer.readLine()) != null) {
        
        	line = line.trim();
            String[] strList = new String[2];
            
            strList = line.split(";");
            
            if ( strList.length == 2){
            	
            	// get sentence to list
            	List<String> listStr = new ArrayList<String>(Arrays.asList(strList[0].split(" ")));
            	// get num to list
            	List<String> listInt = new ArrayList<String>(Arrays.asList(strList[1].split(" ")));

            	StringBuilder sentence = new StringBuilder() ;
            	for (int i = 1; i <= listInt.size() + 1 ; i++){
            		//System.out.println("number is " + i);
            		int ordered = listInt.indexOf( new Integer(i).toString() );
            		//System.out.println("position is : " + ordered);
            		if (ordered != -1){
            			sentence.append(" "); 
            			sentence.append(listStr.get(ordered));  
                	} else {
                		sentence.append(" ");
                		sentence.append(listStr.get(listInt.size()));
                	}
            	}            	
            	System.out.println(sentence.toString());
            }
        }
        buffer.close();
    }
}

