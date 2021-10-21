package fr.ensea.project2A.paint;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.io.*;

public class Window extends JFrame {


    public Window(String Title, int x, int y)
 {
         super("Paint");
         this.setSize(x,y);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         Container contentPanel = this.getContentPane() ;

         //déclaration de la barre en haut
         JMenuBar m= new JMenuBar();
         JMenu menu1= new JMenu("File");
         menu1.addSeparator();
         JMenuItem saveMenu= new JMenuItem("Save");
         saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
         menu1.add(new JMenuItem("New"));
         menu1.add(new JMenuItem("Open"));
         menu1.add(saveMenu);

         menu1.add(new JMenuItem("Quit"));
         m.add(menu1);

         JMenu menu2 = new JMenu ("A propos");
         menu2.add(new JMenuItem("Auteurs"));
         m.add(menu2);
         setJMenuBar(m);

         //Déclaration tous les boutons de couleurs en bas de la page
         JButton Black= new JButton("Black");
         Black.setBackground(Color.BLACK);
         Black.setForeground(Color.WHITE);
         Black.setSize(new Dimension(25,35));
         JButton Rouge= new JButton("Rouge");
         Rouge.setBackground(Color.RED);
         JButton Vert= new JButton("Vert");
         Vert.setBackground(Color.GREEN);
         JButton Bleu= new JButton("Bleu");
         Bleu.setBackground(Color.BLUE);
         Bleu.setForeground(Color.WHITE);
         JButton PaintPackageEllipse= new JButton("paintPackage.Ellipse");
         JButton PaintPackageCercle= new JButton("paintPackage.Cercle");
         JButton Jaune= new JButton("Jaune");
         Jaune.setBackground(Color.YELLOW);
         JButton Rose= new JButton("Rose");
         Rose.setBackground(Color.PINK);
         JButton Magenta= new JButton("Magenta");
         Magenta.setBackground(Color.MAGENTA);
         JButton Orange= new JButton("Orange");
         Orange.setBackground(Color.ORANGE);
         JButton paintPackageRectangle= new JButton("paintPackage.Rectangle");
         JButton paintPackageCarre= new JButton("paintPackage.Carre");
         JPanel southPanel = new JPanel();
         southPanel.setLayout(new GridLayout(2, 6));
         southPanel.add(Black);
         southPanel.add(Rouge);
         southPanel.add(Vert);
         southPanel.add(Bleu);
         southPanel.add(PaintPackageEllipse);
         southPanel.add(PaintPackageCercle);
         southPanel.add(Jaune);
         southPanel.add(Rose);
         southPanel.add(Magenta);
         southPanel.add(Orange);
         southPanel.add(paintPackageRectangle);
         southPanel.add(paintPackageCarre);
         //déclaration de ou va se situer tous les boutons créer
         contentPanel.add(southPanel,"South");
         this.setVisible(true);
         }

    public static void main (String args[]){
         Window win = new Window(" ",800,600);
         }


}
