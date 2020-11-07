package Task3;

public class Main {
    public static void main (String[] args)
    {
        Triangle tr1 = new Triangle(new Point (1,1), new Point(1,3), new Point (-5,2));
        System.out.println(tr1.getPerimeter());
        System.out.println(tr1.getLengthAB());
        System.out.println(tr1.getLengthBC());
        System.out.println(tr1.getLengthCA());
        System.out.println(tr1.getSquare());
        Point m = new Point(tr1.getIntersectionOfMedians().getX(), tr1.getIntersectionOfMedians().getY());
        System.out.println(m.getX());
        System.out.println(m.getY());
    }
}
