package Ex7;

import java.io.*;
import java.util.Date;

public class FileDate {
    public static void main(String[] args) {
        Date currentDate = new Date();

        try {
            File file = new File("date.txt");
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeLong(currentDate.getTime());
            dos.close();
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            Date savedDate = new Date(dis.readLong());
            dis.close();
            System.out.println("Saved date: " + savedDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
