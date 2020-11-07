package Task1;

public class Main {
    final static String[] numbers = {"нуль", " один"," два"," три"," четыре"," пять"," шесть", " семь",
            " восемь"," девять"," десять", " одиннадцать", " двенадцать", " тринадцать", " четырнадцать",
            " пятьнадцать", " шестьнадцать", " семьнадцать", " восемьнадцать", " девятнадцать"};
    final static String[] dozen = {"",""," двадцать"," тридцать"," сорок"," пятьдесят"," шестьдесят",
            " семьдесят"," восемьдесят"," девяносто" };
    final static String[] hundreds = {""," сто", " двести"," триста"," четыресто",
            " пятьсот"," шестьсот", " семьсот"," восемьсот"," девятьсот" };
    final static String[] counters = {" тысяч"," миллион"," миллиард", " триллион",
            " квадриллион", " квинтиллион", " сектиллион"};
    final static String[] end = {"а", "ов", "и"};
    final static String[] order = {"одна", "две", "три", "четыре"};
    public static int extent (int number)
    {
        int counter = 1;
        int n= 0;
        while (number/counter > 0)
        {
            ++n;
            counter*=10;
        }
        return n;
    }
    public static void printHundreds(int number)
    {
        int order = 10;
        if(number >= 100)
        {
            System.out.print(hundreds[number/(order*order)]);
            number %= (order*order);
        }
        if(number>19 && number <=99)
        {
            System.out.print(dozen[number/order]);
            System.out.print(numbers[number%order]);
        }
        else{
            System.out.print(numbers[number]);
        }

    }
    public static void printThousand (int number)
    {
        if (number/1000 == 1)
        {
            System.out.print(order[0] + counters[0]+end[0]);
        }
        else if (number/1000 >= 2 && number/1000 <= 4)
        {
            System.out.print(order[number/1000 - 1] + counters[0]+end[2]);
        }
        else {
        printHundreds(number/1000);
        System.out.print(counters[0]);
        }
        if (number%1000!=0)
        {
            printHundreds(number%1000);
        }
    }
    public static void printMillion (int number)
    {
        printHundreds(number/1000000);
        System.out.print(counters[1]);
        if (number%1000000!=0)
        {
        printThousand(number%1000000);
        }
    }
    public static void main (String[] args)
    {
        int number = Integer.parseInt(args[0]);
        int n = extent(number);
        int order = 10;
        if ( n <= 9 && n > 6)
        {
            printMillion(number);
        }
        else if (n <= 6 && n > 3)
        {
            printThousand(number);
        }
        else if (n <= 3)
        {
            printHundreds(number);
        }
    }
}
