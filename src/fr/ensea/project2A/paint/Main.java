package fr.ensea.project2A.paint;

import java.awt.*;

public class Main {
    public static void main (String[] args){
            System.out.println("Hello word");
            Point ex= new Point(2,3);
            //calcul avec 2 points pour savoir la distance entre les 2
            //Point ex2= new Point (10,8);
            //int px= ex2.getX()- ex.getX();
            //int py= ex2.getY()- ex.getY();
            Rectangle rec= new Rectangle(Color.blue,ex,5,4);
            Ellipse ell= new Ellipse(Color.RED,ex,4,6);
            System.out.println(ex);
            System.out.println(rec);
            System.out.println((ell));
    }
}
