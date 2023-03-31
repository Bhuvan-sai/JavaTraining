package Ex7;

import java.io.*;

public class CopyImage {
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "/Users/bhuvansai/Desktop/untitled folder 2/chidambaram.png";
        String destinationFilePath = "/Users/bhuvansai/Desktop/untitled folder 2/thanjavur.png";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        
        inputStream = new FileInputStream(sourceFilePath);
        outputStream = new FileOutputStream(destinationFilePath);

        int readByte;
        while ((readByte = inputStream.read()) != -1) {
            outputStream.write(readByte);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }
}
