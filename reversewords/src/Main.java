
import java.io.*;
public class Main {
	
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        //File file = new File("C:\\projects\\2015\\codeEval\\reversewords\\rawdata.txt");
    	BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	if (line.equals("")){
        	} else {
	        	String[] lineArray = line.split("\\s");
            	String[] swapString = new String[lineArray.length];
                for (int i = 0; i < lineArray.length; i++){
                	swapString[lineArray.length-1 - i] = lineArray[i];
                }
                String conString = new String();
                for (int i = 0; i < swapString.length; i++){
                	conString = conString + " " + swapString[i];
                }
        		System.out.println(conString.trim());
	        } 
        }
        buffer.close();
    }
}


