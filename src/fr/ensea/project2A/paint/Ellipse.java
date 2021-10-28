package fr.ensea.project2A.paint;
import java.awt.*;

public class Ellipse extends Figure {
    protected int semiAxysX;
    protected int semiAxysY;

    public Ellipse( Color color,int px, int py){
        super();
        c=color;
        setBoundingBox(0,0);

    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
    semiAxysX=widthBB;
    semiAxysY=heightBB;
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origine.getX(), origine.getY(), semiAxysX, semiAxysY);

    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                ", c=" + c + "origine"+ origine+
                '}';
    }

    public int getSemiAxysX() {
        return semiAxysX;
    }

    public int getSemiAxysY() {
        return semiAxysY;
    }

    public void setSemiAxysX(int semiAxysX) {
        this.semiAxysX = semiAxysX;
    }

    public void setSemiAxysY(int semiAxysY) {
        this.semiAxysY = semiAxysY;
    }
}
