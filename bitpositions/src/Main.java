



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer ;

public class Main {
    public static void main (String[] args) throws IOException {
        //File file = new File(args[0]);
        File file = new File("C:/projects/2015/codeEval/bitpositions/input.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	// define bit array
        	String[] strList = new String[3];
        	// only if blank	        	
        	line = line.trim();
            strList = line.split(",");
        	if (line.length() != 0){
            	
            	// get p1 & p2 by row
            	int var1 = Integer.parseInt(strList[1]);
            	int var2 = Integer.parseInt(strList[2]);
            	
            	int maxvar;
            	int minvar;
            	
            	if (var1 >= var2){
            		maxvar = var1;
            		minvar = var2;
            	} else {
            		maxvar = var2;
            		minvar = var1;
            	}
            	
            	int k = 1;
            	boolean truth = true;
            	while (truth){
            		// bounds
            		double upbound = (Math.pow(2, k ) - 1);
            		// check bounds
            		if ( maxvar > upbound){
           				truth = true;
           				k ++;
            		} else {
            			truth = false;
            		}
            	}

            	//System.out.println("maxvar: " + maxvar);
            	//System.out.println("minvar: " + minvar);
            	//System.out.println("k: " + k);
            	//System.out.println("2^k - 1 : " + (Math.pow(2, k ) - 1));
            	//System.out.println("2^(k-1) : " + Math.pow(2, (k - 1) ));

            	double lbound = Math.pow(2, (k - 1) );
            	double ubound = (Math.pow(2, k) - 1 );
            	
            	if ( minvar <= ubound ) {
            		if (minvar >= lbound ){
                		System.out.println(true);
            		} else {
                		System.out.println(false);
            		}
            	} else {
            		if (minvar >= lbound ){
                		System.out.println(false);
            		} else {
                		System.out.println(false);
            		}
            		
            	}
            }
        }
        buffer.close();
    }
}
