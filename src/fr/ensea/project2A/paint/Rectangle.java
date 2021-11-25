package fr.ensea.project2A.paint;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure {
    protected int length;
    protected int width;

    public Rectangle(Color color, int px, int py) {
        super(color, new Point(px,py));
        setBoundingBox(0,0);
    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        length = heightBB;
        width = widthBB;
    }

    @Override
    protected void setBoundingBox(Point first, Point second) {
        if(first.getX() < second.getX() & first.getY()<second.getY()){
            width=(second.getX()- first.getX());
            length=(second.getY()-first.getY());
        }
        else if (second.getX()< first.getX() & second.getY()< first.getY()){
            Point firstBis= new Point (second.getX(), second.getY());
            Point secondBis= new Point (first.getX(), first.getY());
            super.origin =firstBis;
            width=(secondBis.getX()-firstBis.getX());
            length=(secondBis.getY()- firstBis.getY());
        }
        else if(second.getX()< first.getX() & first.getY()< second.getY()){
            Point firstBis= new Point (second.getX(), first.getY());
            Point secondBis= new Point (first.getX(), second.getY());
            super.origin =firstBis;
            width=(secondBis.getX()-firstBis.getX());
            length=(secondBis.getY()- firstBis.getY());
        }
        else if(first.getX()< second.getX() & second.getY()< first.getY()){
            Point firstBis=new Point(first.getX(), second.getY());
            Point secondBis= new Point (second.getX(),first.getY());
            super.origin =firstBis;
            width=(secondBis.getX()- firstBis.getX());
            length=(secondBis.getY()-firstBis.getY());
        }
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origin.getX(), origin.getY(), width, length);
    }

    @Override
    public String toString() {
        return "Rectangle {" +"origine "+ origin + "length : " + length + " ,width : " + width + " ,color : " + c + '}';
    }
}