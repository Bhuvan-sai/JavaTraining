package Ex7;

import java.io.File;

public class listAllFiles {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Give a directory name as a command line argument.");
            System.exit(1);
        }

        String directoryName = args[0];
        File directory = new File(directoryName);

        if (!directory.exists() && !directory.isDirectory()) {
            System.out.println("Please enter a valid name.");
            System.exit(1);
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            } else {
                System.out.println("File: " + file.getName());
            }
        }
    }
}
