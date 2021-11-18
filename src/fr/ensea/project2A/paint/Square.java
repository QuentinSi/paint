package fr.ensea.project2A.paint;

import java.awt.*;

public class Square extends Rectangle{

    public Square(Color color, int px, int py) {
        super(color, px, py);
        setBoundingBox(0,0);
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origine.getX(), origine.getY(), length, width);
    }

    @Override
    protected void setBoundingBox(int HeightBB,  int WidthBB){
        if (HeightBB<WidthBB){
            length=HeightBB;
            width=HeightBB;
        }
        else {
            length = WidthBB;
            width = WidthBB;
        }
    }
    @Override
    protected void setBoundingBox(Point origin, Point second) {
        super.setBoundingBox(origin, second);
        if (width < length) {
            length = width;

            if (origin.getX() < second.getX() & second.getY() < origin.getY()) { // tire en haut à droite
                super.origine.setY(origin.getY() - length);

            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origine.setY(origin.getY() - length);
            }
        } else {
            width = length;

            if (second.getX() < origin.getX() & origin.getY() < second.getY()) { // Tire en bas a à gauche
                super.origine.setX(origin.getX() - width);
            } else if (second.getX() < origin.getX() & second.getY() < origin.getY()) { // tire en haut à gauche
                super.origine.setX(origin.getX() - width);
            }
        }
    }

    @Override
    public String toString() {
        return "Carre {"+ " origine "+ origine+ " lenght " + length + " width " + width+ " color " + c + '}';
    }
}
