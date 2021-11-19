package fr.ensea.project2A.paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

public class Draw extends JPanel implements MouseMotionListener, MouseListener, Serializable {

    private Color c;
    private ArrayList<Figure> list;
    private String figureName;
    private int x;
    private int y;
    private Point premier;
    private Point deuxieme;
    Figure figure;

    public Draw() {
        super();
        this.setBackground(Color.white);
        this.list = new ArrayList<Figure>();
        x=0;
        y=0;
        figureName="Rectangle";
        addMouseListener(this);
        addMouseMotionListener(this);
        c=Color.black;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        premier= new Point(e.getX(),e.getY());
        switch (figureName){
            case "Rectangle" :
                list.add(figure=new Rectangle(c,premier.getX(),premier.getY()));
                break;
            case "Square" :
                list.add(figure=new Square(c,premier.getX(),premier.getY()));
                break;
            case "Circle" :
                list.add(figure=new Circle(c,premier.getX(),premier.getY()));
                break;
            case "Ellipse" :
                list.add(figure=new Ellipse(c,premier.getX(),premier.getY()));
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /*x=e.getX()-figure.origine.getX();
        y=e.getY()-figure.origine.getY();
        figure.setBoundingBox(y,x);*/
        deuxieme= new Point(e.getX(),e.getY());
        /*deuxieme.setX(e.getX());
        deuxieme.setY(e.getY());*/
        figure.setBoundingBox(premier,deuxieme);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*x=e.getX()-figure.origine.getX();
        y=e.getY()-figure.origine.getY();
        figure.setBoundingBox(y,x);*/
        /*figure.setBoundingBox(premier,deuxieme);
        repaint();*/
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

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
        }
    }

    public void back_one_step(){
        list.remove(list.size()-1); repaint();
    }

    public void savedrawing(String FileName){
        try {
            FileOutputStream ops = new FileOutputStream(FileName);
            ObjectOutputStream oos = new ObjectOutputStream(ops);
            oos.writeObject(list);
            oos.close();
            System.out.println("\nSauvegardé\n");
        } catch (Exception e) {
            System.out.println("Le fichier n'a pas pu être sauvegarder");
            e.printStackTrace();
        }
    }

    public void opendrawing (String FileName){
        try {
            FileInputStream ips = new FileInputStream(FileName);
            ObjectInputStream ios = new ObjectInputStream(ips);
            this.list.clear();
            paintComponent((this.getGraphics()));
            list = (ArrayList<Figure>) ios.readObject();
            repaint();
            ios.close();
            System.out.println("\nouvert\n");
        } catch (Exception e) {
            System.out.println("Le fichier n'a pas pu être ouvert");
        }
    }

    public void setColor(Color color) {
        this.c = color;
    }
    public void setFigureName(String figureName){
        this.figureName=figureName;
    }
    public ArrayList<Figure> getList() { return list; }

}
