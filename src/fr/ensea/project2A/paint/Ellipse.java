package fr.ensea.project2A.paint;
import java.awt.*;

public class Ellipse extends Figure {
    protected int semiAxysX;
    protected int semiAxysY;

    protected Ellipse( Color color, Point origine,int px, int py){
        super();
        c=color;
        this.origine=origine;
        setBoundingBox(px,py);

    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
    semiAxysX=heightBB/2;
    semiAxysY=widthBB/2;
    }

    @Override
    protected void draw(Graphics g) {

    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c +
                '}';
    }
}
