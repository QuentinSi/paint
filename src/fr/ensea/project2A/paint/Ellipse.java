package fr.ensea.project2A.paint;
import java.awt.Color;
import java.awt.Graphics;

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
    protected void setBoundingBox(Point first, Point second) {
        if (first.getX() < second.getX() & first.getY() < second.getY()) {
            semiAxysX = (second.getX() - first.getX());
            semiAxysY = (second.getY() - first.getY());
        }
        else if (second.getX() < first.getX() & first.getY() < second.getY()) {
            Point firstBis = new Point(second.getX(), first.getY());
            Point secondBis = new Point(first.getX(), second.getY());
            super.origin = firstBis;
            semiAxysX = (secondBis.getX() - firstBis.getX());
            semiAxysY = (secondBis.getY() - firstBis.getY());
        }
        else if (second.getX() < first.getX() & second.getY() < first.getY()) {
            Point firstBis = new Point(second.getX(), second.getY());
            Point secondBis = new Point(first.getX(), first.getY());
            super.origin = firstBis;
            semiAxysX = (secondBis.getX() - firstBis.getX());
            semiAxysY = (secondBis.getY() - firstBis.getY());
        }
        else if (first.getX() < second.getX() & second.getY() < first.getY()) {
            Point firstBis = new Point(first.getX(), second.getY());
            Point secondBis = new Point(second.getX(), first.getY());
            super.origin = firstBis;
            semiAxysX = (secondBis.getX() - firstBis.getX());
            semiAxysY = (secondBis.getY() - firstBis.getY());
        }
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origin.getX(), origin.getY(), semiAxysX, semiAxysY);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c + "origine"+ origin +
                '}';
    }
}
