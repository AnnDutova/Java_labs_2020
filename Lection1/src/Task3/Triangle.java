package Task3;

public class Triangle extends Figure
{
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Triangle(double aX, double aY ,double bX, double bY, double cX, double cY) {
    this.a = new Point (aX, aY);
    this.b = new Point (bX, bY);
    this.c = new Point (cX, cY);
    }

    public double getLengthAB(){
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY()-b.getY(),2));
    }

    public double getLengthBC(){
        return Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY()-b.getY(),2));
    }

    public double getLengthCA(){
        return Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY()-a.getY(),2));
    }

    @Override
    public double getSquare() {
        double p = getPerimeter()/2.0;
        double la =getLengthAB();
        double lb =getLengthBC();
        double lc =getLengthCA();
        return Math.sqrt(p*(p - la)*(p - lb)*(p - lc));
    }

    @Override
    public double getPerimeter() {
        double la =getLengthAB();
        double lb =getLengthBC();
        double lc =getLengthCA();
        return (la+lb+lc);
    }

    @Override
    public Point getIntersectionOfMedians() {
        Point median = new Point(0,0);
        Point p_a = new Point ((b.getX() - c.getX()) / 2.0, (b.getY() - c.getY()) / 2.0); //?????
        median.setX((a.getX() + 2 * p_a.getX())/3.0);
        median.setY((a.getY() + 2 * p_a.getY())/3.0);
        return median;
    }
}
