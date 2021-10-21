package fr.ensea.project2A.paint;

import java.awt.*;

public class Rectangle extends Figure {
    protected int length;
    protected int width;

    public Rectangle(Color color,Point origine, int px, int py) {
        // pas obliger de mettre super car on a un constructeur dans figure
        super();
        c = color;
        this.origine=origine;
        setBoundingBox(px, py);
    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        length = heightBB;
        width = widthBB;
    }

    @Override
    protected void draw(Graphics g) {

    }

    @Override
    public String toString() {
        return "Rectangle {" +"origine "+origine+ "length : " + length + " ,width : " + width + " ,color : " + c + '}';
    }
}