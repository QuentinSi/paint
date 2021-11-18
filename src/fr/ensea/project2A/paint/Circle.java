package fr.ensea.project2A.paint;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Color color,int px, int py) {
        super(color, px, py);
        setBoundingBox(0, 0);
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origine.getX(), origine.getY(), semiAxysX, semiAxysY);

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
    protected void setBoundingBox(Point origin, Point second) {
        super.setBoundingBox(origin, second);
        if (semiAxysX < semiAxysY) {
            semiAxysY = semiAxysX;

            if (origin.getX() < second.getX() & second.getY() < origin.getY()) { // tire en haut à droite
                super.origine.setY(origin.getY() - semiAxysY);

            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origine.setY(origin.getY() - semiAxysY );
            }
        } else {
            semiAxysX = semiAxysY;

            if (second.getX() < origin.getX() & origin.getY() < second.getY()) { // Tire en bas a à gauche
                super.origine.setX(origin.getX() - semiAxysX );
            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origine.setX(origin.getX() - semiAxysX );
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

