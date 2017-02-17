package slangflavour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		// slang reference
		String[] slangstr = {", yeah!", ", this is crazy, I tell ya.", ", can U believe this?",
		", eh?", ", aw yea.", ", yo.", "? No way!",	". Awesome!"};
		
		File file = new File("C:/projects/2015/codeEval/slangflavour/rawdata.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        
        while ((line = buffer.readLine()) != null) {
        
        	line = line.trim();
        
        	List<String> arrsent = new ArrayList<String>(Arrays.asList(line.split("(?=\\b[\\.\\!\\?])")));
        	StringBuilder sentence = new StringBuilder();
        	
        	for (int i=0; i < arrsent.size(); i++){
        		// get sentence
        		String cleanstr = arrsent.get(i).trim();
        		
        		// add slang if even
         		if (((i + 1) % 2 == 0)){
        			
         			String newstring1 = cleanstr.substring(0, cleanstr.length() -1);
         			String newstring2 = newstring1 + slangstr[i / 2];
               					
         			sentence.append(newstring2);
        			
        		} else {
        			// get rid of last letter
        			sentence.append(cleanstr);
        		}
        	}
    		System.out.println(sentence);
        }
	
        buffer.close();
	}
}
