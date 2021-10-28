package fr.ensea.project2A.paint;

import java.awt.*;

public class Rectangle extends Figure {
    protected int length;
    protected int width;

    public Rectangle(Color color, int px, int py) {
        // pas obliger de mettre super car on a un constructeur dans figure
        super(color, new Point(px,py));
        setBoundingBox(0, 0);
    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        length = heightBB;
        width = widthBB;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

}