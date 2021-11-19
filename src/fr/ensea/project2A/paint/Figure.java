package fr.ensea.project2A.paint;
import java.awt.*;
import java.awt.Color;
import java.io.Serializable;

public abstract class Figure implements Serializable {

    protected abstract void setBoundingBox(int heightBB, int widthBB);
    protected abstract void setBoundingBox(Point un, Point deux);
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

    @Override
    public String toString() {
        return "Figure{c=" + c + '}';
    }

    public Color getC() {
        return c;
    }
    public void setC(Color c) {
        this.c = c;
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }
}
