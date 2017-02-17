
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        //File file = new File(args[0]);
        File file = new File("C:/projects/2015/codeEval/closestpairs/rawData.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	String[] strList = new String[line.split(" ").length];
        	line = line.trim();
        	strList = line.split(" ");
        	if (strList.length == 1){
        		if (strList[0] == "0"){
        			break;
        		} else {
        			CoordBean coordBean = new CoordBean( strList[0], String[ Integer.parseInt(strList[0]) ]);
        		}
        	}
        	
        	System.out.println(line);

        }
    }
}
