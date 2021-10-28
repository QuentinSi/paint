package fr.ensea.project2A.paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Draw extends JPanel implements MouseMotionListener, MouseListener {

    private Color c;
    private ArrayList<Figure> list;
    private String figureName;
    private int x;
    private int y;

    public Draw() {
        super();
        this.setBackground(Color.white);
        this.list = new ArrayList<Figure>();
        x=0;
        y=0;
        figureName=null;
        addMouseListener(this);
        addMouseMotionListener(this);
        c=Color.white;

    }
    public void setColor(Color color) {
        this.c = color;
    }

    public void setFigureName(String figureName){
        this.figureName=figureName;
    }


    Figure figure;
    @Override
    public void mouseDragged(MouseEvent e) {
        x=e.getX()-figure.origine.getX();
        y=e.getY()-figure.origine.getY();
        figure.setBoundingBox(y,x);
        System.out.println("x= "+x +" ,y="+y);
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        switch (figureName){
           case "Rectangle" :
                list.add(figure=new Rectangle(c,x,y));
                figure.origine=(new Point(e.getX(),e.getY()));
                break;

            case "Square" :
                list.add(figure=new Square(c,x,y));
                figure.origine=(new Point(e.getX(),e.getY()));
                break;

            case "Circle" :
                list.add(figure=new Circle(c,x,y));
                figure.origine=(new Point(e.getX(),e.getY()));
                break;
            case "Ellipse" :
                list.add(figure=new Ellipse(c,x,y));
                figure.origine=(new Point(e.getX(),e.getY()));
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        x=e.getX()-figure.origine.getX();
        y=e.getY()-figure.origine.getY();
        figure.setBoundingBox(y,x);
        System.out.println("x= "+x +" ,y="+y);
        System.out.println(list);
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        for(Figure f : list){
            f.draw(g);
            this.repaint();
        }
    }

}