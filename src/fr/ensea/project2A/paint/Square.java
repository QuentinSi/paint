package fr.ensea.project2A.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Rectangle{

    public Square(Color color, int px, int py) {
        super(color, px, py);
        setBoundingBox(0,0);
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origin.getX(), origin.getY(), length, width);
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
    protected void setBoundingBox(Point first, Point second) {
        super.setBoundingBox(first, second);
        if (width < length) {
            length = width;

            if (first.getX() < second.getX() & second.getY() < first.getY()) { // tire en haut à droite
                super.origin.setY(first.getY() - length);

            } else if (second.getX() < first.getX() & second.getY() < first.getY()) { // tire en haut à gauche
                super.origin.setY(first.getY() - length);
            }
        } else {
            width = length;

            if (second.getX() < first.getX() & first.getY() < second.getY()) { // Tire en bas a à gauche
                super.origin.setX(first.getX() - width);
            } else if (second.getX() < first.getX() & second.getY() < first.getY()) { // tire en haut à gauche
                super.origin.setX(first.getX() - width);
            }
        }
    }

    @Override
    public String toString() {
        return "Square {"+ " origine "+ origin + " lenght " + length + " width " + width+ " color " + c + '}';
    }
}
