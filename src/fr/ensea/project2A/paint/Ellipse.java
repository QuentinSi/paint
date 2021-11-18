package fr.ensea.project2A.paint;
import java.awt.*;

public class Ellipse extends Figure {
    protected int semiAxysX;
    protected int semiAxysY;

    public Ellipse( Color color,int px, int py){
        super(color, new Point(px,py));
        c=color;
        setBoundingBox(0,0);

    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
    semiAxysX=widthBB;
    semiAxysY=heightBB;
    }

    @Override
    protected void setBoundingBox(Point origin, Point second) {
        if (origin.getX() < second.getX() & origin.getY() < second.getY()) {
            semiAxysX = (second.getX() - origin.getX()) ;
            semiAxysY = (second.getY() - origin.getY()) ;
        } else if (origin.getX() < second.getX() & second.getY() < origin.getX()) {
            Point originBis = new Point(origin.getX(), second.getY());
            Point secondBis = new Point(second.getX(), origin.getY());
            super.origine = originBis;
            semiAxysX = (secondBis.getX() - originBis.getX()) ;
            semiAxysY = (secondBis.getY() - originBis.getY()) ;
        } else if (second.getX() < origin.getX() & origin.getY() < second.getY()) {
            Point originBis = new Point(second.getX(), origin.getY());
            Point secondBis = new Point(origin.getX(), second.getY());
            super.origine = originBis;
            semiAxysX = (secondBis.getX() - originBis.getX()) ;
            semiAxysY = (secondBis.getY() - originBis.getY()) ;
        } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) {
            Point originBis = new Point(second.getX(), second.getY());
            Point secondBis = new Point(origin.getX(), origin.getY());
            super.origine = originBis;
            semiAxysX = (secondBis.getX() - originBis.getX()) ;
            semiAxysY = (secondBis.getY() - originBis.getY()) ;
        }
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origine.getX(), origine.getY(), semiAxysX, semiAxysY);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c + "origine"+ origine+
                '}';
    }

    public int getSemiAxysX() {
        return semiAxysX;
    }

    public int getSemiAxysY() {
        return semiAxysY;
    }

    public void setSemiAxysX(int semiAxysX) {
        this.semiAxysX = semiAxysX;
    }

    public void setSemiAxysY(int semiAxysY) {
        this.semiAxysY = semiAxysY;
    }
}
