package Ex7;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {

        File sourceFile = new File("/Users/bhuvansai/Desktop/untitled folder 2/file1");
        File destFile = new File("/Users/bhuvansai/Desktop/untitled folder 2/file2");

        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader(sourceFile);
            out = new FileWriter(destFile);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
