package Task2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static final String FILE_NAME ="D:\\IDEA\\IntelliJ IDEA Community Edition 2020.2.2\\unnecessary_proj\\L2\\src\\Task2\\note.txt";
    public static final String PAS = "Password: ";
    public static void main (String[] args) throws Exception
    {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))){
            String line;
            int count = 0;
            String password = "";
            AuthData temp = null;
            ArrayList <AuthData> list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(PAS))
                {
                    password = line.substring(PAS.length());
                    temp = new AuthData(password);
                    if (list.contains(temp))
                    {
                        list.get(list.indexOf(temp)).iterateCount();
                    }
                    else {
                    list.add(temp);
                    }
                }
            }
            list.sort(AuthData::compareTo);
            for(int i = 0; i< 3; i++)
            {
                System.out.println( (i+1) + " " + list.get(i));
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
