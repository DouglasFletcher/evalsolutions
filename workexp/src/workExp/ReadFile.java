/*
package workExp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
*/