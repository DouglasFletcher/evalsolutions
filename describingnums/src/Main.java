import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
       File file = new File(args[0]);
       //File file = new File("C:/projects/2015/codeEval/describingnums/dataRaw.txt");
    	BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	line = line.trim();
        	if (line.equals("")){
        	} else { 
	        	String[] splitString = new String[line.length()];
	            //System.out.println(line);
	            splitString = line.split("");
	           	int flag = 0;
	           	int count = 0;
	            for (int i= 0; i < splitString.length; i++){
	            	int intCount = line.length() - line.replace(String.valueOf(i), "").length();
	                String stringPo = null;
	               	stringPo = String.valueOf(intCount);
		            if (splitString[i].equals(stringPo)){
	                	flag += 1;
	                } 
		            count += 1;
		            //System.out.println(intCount);
	                //System.out.println(stringPo);
	                //System.out.println(splitString[i]);
	                //System.out.println("");
	            }
	            if (flag == count){
	            	System.out.println(1);
	            } else {
	            	System.out.println(0);
	            }
        	}
        }
    buffer.close(); 
    }
}
