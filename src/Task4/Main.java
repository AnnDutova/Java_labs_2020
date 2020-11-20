package Task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static final String FILE_NAME ="D:\\IDEA\\IntelliJ IDEA Community Edition 2020.2.2\\unnecessary_proj\\L2\\src\\Task4\\note2.txt";
    public static void main (String[] args) throws Exception
    {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s*(\\s)\\s*");
                for (String el: words)
                {
                System.out.print(el + " ");
                }
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
