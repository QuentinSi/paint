package fr.ensea.project2A.paint;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Color color,int px, int py) {
        super(color, px, py);
        setBoundingBox(0,0);
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origin.getX(), origin.getY(), semiAxysX, semiAxysY);

    }

    @Override
    protected void setBoundingBox(int HeightBB,  int WidthBB){
        if (HeightBB<WidthBB){
            semiAxysX=HeightBB;
            semiAxysY=HeightBB;
        }
        else {
            semiAxysX = WidthBB;
            semiAxysY = WidthBB;
        }
    }
    @Override
    protected void setBoundingBox(Point first, Point second) {
        super.setBoundingBox(first, second);
        if (semiAxysX < semiAxysY) {
            semiAxysY = semiAxysX;

            if (first.getX() < second.getX() & second.getY() < first.getY()) { // tire en haut à droite
                super.origin.setY(first.getY() - semiAxysY);

            } else if (second.getX() < first.getX() & second.getY() < first.getY()) { // tire en haut à gauche
                super.origin.setY(first.getY() - semiAxysY );
            }
        } else {
            semiAxysX = semiAxysY;

            if (second.getX() < first.getX() & first.getY() < second.getY()) { // Tire en bas a à gauche
                super.origin.setX(first.getX() - semiAxysX );
            } else if (second.getX() < first.getX() & second.getY() < first.getY()) { // tire en haut à gauche
                super.origin.setX(first.getX() - semiAxysX );
            }
        }
    }
    @Override
    public String toString() {
        return "Circle{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c +
                '}';

    }
}

