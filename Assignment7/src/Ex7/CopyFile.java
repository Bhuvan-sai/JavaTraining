package Ex7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {
        String sourceFile = "";
        String destinationFile = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            
            System.out.println("File copied successfully.");
            
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
