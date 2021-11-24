package fr.ensea.project2A.paint;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Draw extends JPanel implements MouseMotionListener, MouseListener, Serializable {

    private Color c;
    private ArrayList<Figure> list;
    private String figureName;
    private Point first;
    private Point second;
    Figure figure;

    public Draw() {
        super();
        this.setBackground(Color.white);
        this.list = new ArrayList<Figure>();
        figureName="Rectangle";
        addMouseListener(this);
        addMouseMotionListener(this);
        c=Color.black;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        first = new Point(e.getX(),e.getY());
        switch (figureName){
            case "Rectangle" :
                list.add(figure=new Rectangle(c, first.getX(), first.getY()));
                break;
            case "Square" :
                list.add(figure=new Square(c, first.getX(), first.getY()));
                break;
            case "Circle" :
                list.add(figure=new Circle(c, first.getX(), first.getY()));
                break;
            case "Ellipse" :
                list.add(figure=new Ellipse(c, first.getX(), first.getY()));
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        second = new Point(e.getX(),e.getY());
        figure.setBoundingBox(first, second);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

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
        list.remove(list.size()-1);
        repaint();
    }

    public void savedrawing(String FileName){
        try {
            FileOutputStream output = new FileOutputStream(FileName);
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);
            objectOutput.writeObject(list);
            objectOutput.close();
            System.out.println("\nSaved\n");
        } catch (Exception e) {
            System.out.println("The file could not be saved");
            e.printStackTrace();
        }
    }

    public void opendrawing (String FileName){
        try {
            FileInputStream input = new FileInputStream(FileName);
            ObjectInputStream objectInput = new ObjectInputStream(input);
            this.list.clear();
            paintComponent((this.getGraphics()));
            list = (ArrayList<Figure>) objectInput.readObject();
            repaint();
            objectInput.close();
            System.out.println("\nopen\n");
        } catch (Exception e) {
            System.out.println("The file could not be opened");
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
