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
    public String toString() {
        return "Carre {"+ " origine "+ origine+ " lenght " + length + " width " + width+ " color " + c + '}';
    }
}
