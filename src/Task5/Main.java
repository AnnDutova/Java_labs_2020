package Task5;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static int getRandomNumber(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static char randomChar(char fchar, char schar, char tchar){
        int num = getRandomNumber(97,122);
        boolean found = false;
        while (!found){
            if ( num!= (int)fchar && num!= (int)tchar){
                schar = (char)(num);
                found = true;
            }
            else {
                num = getRandomNumber(97,122);;
            }
        }
        return schar;
    }
     public static String createRandomWord(String word, int length)
     {
         if(length>2)
         {
             StringBuilder myName = new StringBuilder(word);
             myName.setCharAt(1, randomChar(word.charAt(0), word.charAt(1), word.charAt(2)));
             return myName.toString();
         }
         else {
             return word;
         }
     }
     public static void main (String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Vector<String> wordMass = new Vector<>();
        int deliver = str.length() - ((int)str.length()/3)*3;
        for (int i = 3; i <= str.length(); i++) {
            if(i%3==0)
            {
            String pic = str.substring(i-3,i);
            wordMass.addElement(pic); 
            }
            if(i == str.length() - deliver)
            {
                String pic = str.substring(i,str.length());
                wordMass.addElement(pic);
                break;
            }
        }
        Vector<String> wordMass2 = new Vector<>();
        for (String vec: wordMass)
        {
            wordMass2.addElement(createRandomWord(vec, vec.length()));
        }
        Collections.sort(wordMass2);
        for (String vec: wordMass2)
        {
            System.out.println(vec);
        }
    }
}
