package L4;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
    Задания приведены в виде TODO
    комментариев к методам.
 */
public class Main {
    public static void main(String[] args)
    {
        //task1();
        //task2();
        //task3();
        //task4();
//        try
//        {
//            task5_2();
//        }
//        catch (NullPointerException | FileNotFoundException ex)
//        {
//            System.out.println(ex.toString());
//        }

//        try
//        {
//            task6();
//        }
//        catch(Exception3 ex)
//        {
//            System.out.println("3: " + ex.toString());
//        }
//        catch(Exception2 ex){
//            System.out.println("2: " + ex.toString());
//        }
//        catch(Exception1 ex){
//            System.out.println("1: " + ex.toString());
//        }

//        try
//        {
//            task7();
//        }
//        catch(FileSystemException ex)
//        {
//            System.out.println(ex.toString());
//        }

        task8();

    }

    // region task1
    private static void task1()
    {
        try
        {
            int a = 42 / 0;
        }
        catch (ArithmeticException ex)
        {
            System.out.println(ex.toString());
        }
    }
    // endregion

    // region task2
    private static void task2(){
        try
        {
            String s = null;
            String m = s.toLowerCase();
        }
        catch(NullPointerException ex)
        {
            System.out.println(ex.toString());
        }

    }
    // endregion

    //region task3-task4
    private static void task3(){
        try
        {
        int[] m = new int[3];
        m[6] = 5;
        }
        catch(ArrayIndexOutOfBoundsException error)
        {
            System.out.println(error.toString());
        }
    }

    private static void task4(){
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        catch(NumberFormatException error){
            System.out.println(error.toString());
        }
    }
    // endregion
    /*
        В методе main вызовите метод task5 и перехватите только NullPointerException и FileNotFoundException,
        без перехвата ArithmeticException и URISyntaxException
     */
    private static void task5() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        if (i == 0) {
            throw new NullPointerException();
        } else if (i == 1) {
            throw new ArithmeticException();
        } else if (i == 2) {
            throw new FileNotFoundException();
        } else if (i == 3) {
            throw new URISyntaxException("", "");
        }
    }

    private static void task5_2() throws NullPointerException, FileNotFoundException
    {
        try
        {
            task5();
        }
        catch (ArithmeticException | URISyntaxException ex)
        {
            System.out.println("n" + ex.toString());
        }
    }

    /*
        В методе main вызовите метод task6 и обработайте по отдельности Exception1, Exception2 и Exception3
     */
    private static void task6() throws Exception1 {
        int i = (int) (Math.random() * 3);
        if (i == 0) {
            throw new Exception1();
        } else if (i == 1) {
            throw new Exception2();
        } else if (i == 2) {
            throw new Exception3();
        }

    }

    /*
        1.	Разберитесь, какие исключения бросает метод methodThrowExceptions класса StatelessBean
        2.	Метод task7 должен вызывать метод methodThrowExceptions и обрабатывать исключения:
                1. Если возникло исключение FileSystemException, то логировать его (вызвать метод log)
                 и пробросить дальше.
                2. Если возникло исключение CharConversionException или любое другое IOException,
                то только логировать его (вызвать метод BEAN.log)
        3.	Добавьте в объявление метода task7 класс исключения, которое вы пробрасываете в п.2.1.
        4.	В методе main обработайте оставшиеся исключения.
     */

    private static void task7() throws FileSystemException {
        StatelessBean sBean = new StatelessBean();
        try
        {
        sBean.methodThrowExceptions();
        }
        catch(FileSystemException ex)
        {
            sBean.log(ex);
            throw ex;
        }
        catch(CharConversionException ex){
            sBean.log(ex);
        }
        catch(IOException exception){
            sBean.log(exception);
        }
    }

    /*
        Напишите программу для ввода чисел с клавиатуры.
        - Код по чтению чисел с клавиатуры должен быть в методе task8.
        - Код внутри task8 обернуть в try..catch.
        - Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение
            и вывести на экран все ранее введенные числа в качестве результата.
        - Числа выводить с новой строки сохраняя порядок ввода.
     */
    private static void task8()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList();
        Integer number = 0;
        try{
            while (scanner.hasNextLine()) //ctr + z
            {
                number = scanner.nextInt();
                array.add(number);
            }
        }
        catch(InputMismatchException exception)
        {
            System.out.println();
            array.forEach(number1 -> System.out.print(number1 + " "));
        }
        finally
        {
            scanner.close();
        }
    }

    static class Exception1 extends Exception{

    }

    static class Exception2 extends Exception1{

    }

    static class Exception3 extends Exception2{

    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0) {
                throw new CharConversionException();
            } else if (i == 1) {
                throw new FileSystemException("");
            } else if (i == 2) {
                throw new IOException();
            }
        }
    }
}