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
    public String toString() {
        return "Circle{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c +
                '}';

    }
}

