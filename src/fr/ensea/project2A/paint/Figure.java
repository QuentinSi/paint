package fr.ensea.project2A.paint;
import java.awt.*;
import java.awt.Color;

public abstract class Figure {
    protected abstract void setBoundingBox(int heightBB, int widthBB);
    protected abstract void draw (Graphics g);
    protected Color c;
    protected Point origine;

    public Figure(Color color,Point point ){
        c=color;
        origine=point;

    }
    public Figure(){
        c=Color.black;
        origine=null;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Figure{c=" + c + '}';
    }
}
