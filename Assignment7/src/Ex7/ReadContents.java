package Ex7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadContents {
	public static void main(String[] args) {
		String file="/Users/bhuvansai/Desktop/UX Assignments/A18/index.html";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
		}catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
	}
}