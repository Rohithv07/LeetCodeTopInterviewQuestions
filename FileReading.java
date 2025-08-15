import java.util.*;

import java.io.*;

public class FileReading {
    public static void main(String [] args) {
        String fileName = "DeleteNodeinaBST.java";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
