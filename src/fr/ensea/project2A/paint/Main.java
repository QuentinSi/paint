package fr.ensea.project2A.paint;

import java.awt.*;

public class Main {
    public static void main (String[] args){
            System.out.println("Hello word");
            Point ex= new Point(2,3);
            //calcul avec 2 points pour savoir la distance entre les 2
            //Point ex2= new Point (10,8);
            //Point ex3 = new Point (5,6);
            //int px= ex2.getX()- ex3.getX();
            //int py= ex2.getY()- ex3.getY();
            Rectangle rec= new Rectangle(Color.blue,5,4);
            Ellipse ell= new Ellipse(Color.RED,4,6);
            Square carre = new Square(Color.GREEN,10,14 );
            Circle cercle= new Circle(Color.WHITE,7,9);
            System.out.println(ex);
            System.out.println(rec);
            System.out.println((ell));
            System.out.println(carre);
            System.out.println(cercle);
            Window win = new Window(" ",800,600);
                }
}
