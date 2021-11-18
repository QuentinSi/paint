package fr.ensea.project2A.paint;

import java.awt.*;

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
    protected void setBoundingBox(Point origin, Point second) {
        if(origin.getX() < second.getX() & origin.getY()<second.getY()){ //tire vers en bas à droite
            width=(second.getX()- origin.getX());
            length=(second.getY()-origin.getY());
        }
        else if(origin.getX()< second.getX() & second.getY()< origin.getY()){ // tire en haut à droite
            Point originBis=new Point(origin.getX(), second.getY());
            Point secondBis= new Point (second.getX(),origin.getY());
            super.origine=originBis;
            width=(secondBis.getX()- originBis.getX());
            length=(secondBis.getY()-originBis.getY());
        }
        else if(second.getX()< origin.getX() & origin.getY()< second.getY()){ // Tire en bas a à gauche
            Point originBis= new Point (second.getX(), origin.getY());
            Point secondBis= new Point (origin.getX(), second.getY());
            super.origine=originBis;
            width=(secondBis.getX()-originBis.getX());
            length=(secondBis.getY()- originBis.getY());
        }
        else if (second.getX()< origin.getX() & second.getY()< origin.getY()){ // tire en haut à gauche
            Point originBis= new Point (second.getX(), second.getY());
            Point secondBis= new Point (origin.getX(), origin.getY());
            super.origine=originBis;
            width=(secondBis.getX()-originBis.getX());
            length=(secondBis.getY()- originBis.getY());
        }
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origine.getX(), origine.getY(), width, length);
    }

    @Override
    public String toString() {
        return "Rectangle {" +"origine "+origine+ "length : " + length + " ,width : " + width + " ,color : " + c + '}';
    }
}