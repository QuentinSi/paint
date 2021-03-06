package fr.ensea.project2A.paint;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Color c;
    protected Point origin;
    protected abstract void setBoundingBox(int heightBB, int widthBB);
    protected abstract void setBoundingBox(Point one, Point two);
    protected abstract void draw (Graphics g);

    public Figure(Color color,Point point ){
        c=color;
        origin =point;
    }

    public Figure(){
        c=Color.black;
        origin =new Point (0,0);
    }

    @Override
    public String toString() {
        return "Figure{c=" + c + '}';
    }
}
