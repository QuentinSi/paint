package fr.ensea.project2A.paint;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Window extends JFrame implements  ActionListener{
        Draw draw = new Draw();

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
         saveMenu.addActionListener(this);
         JMenuItem news = new JMenuItem("New");
         news.addActionListener(this);
         JMenuItem open = new JMenuItem("Open");
         open.addActionListener(this);
         JMenuItem quit = new JMenuItem("Quit");
         quit.addActionListener(this);
         menu1.add(news);
         menu1.add(open);
         menu1.add(saveMenu);
         menu1.add(quit);
         m.add(menu1);

         JMenu menu2 = new JMenu ("A propos");
         JMenuItem auteurs = new JMenuItem("Auteurs");
         auteurs.addActionListener(this);
         menu2.add(auteurs);
         m.add(menu2);

         //Déclaration tous les boutons de couleurs en bas de la page
         JButton black= new JButton("black");
         black.setBackground(Color.BLACK);
         black.setForeground(Color.WHITE);
         black.addActionListener(this);
         black.setSize(new Dimension(25,35));
         JButton rouge= new JButton("rouge");
         rouge.setBackground(Color.red);
         rouge.addActionListener(this);
         JButton vert= new JButton("vert");
         vert.setBackground(Color.green);
         vert.addActionListener(this);
         JButton bleu= new JButton("bleu");
         bleu.setBackground(Color.BLUE);;
         bleu.setForeground(Color.WHITE);
         bleu.addActionListener(this);
         JButton paintEllipse= new JButton("paintEllipse");
         paintEllipse.addActionListener(this);
         JButton paintCercle= new JButton("paintCercle");
         paintCercle.addActionListener(this);
         JButton jaune= new JButton("jaune");
         jaune.setBackground(Color.YELLOW);
         jaune.addActionListener(this);
         JButton rose= new JButton("rose");
         rose.setBackground(Color.PINK);
         rose.addActionListener(this);
         JButton magenta= new JButton("magenta");
         magenta.setBackground(Color.MAGENTA);
         magenta.addActionListener(this);
         JButton orange= new JButton("orange");
         orange.setBackground(Color.ORANGE);
         orange.addActionListener(this);
         JButton paintRectangle= new JButton("paintRectangle");
         paintRectangle.addActionListener(this);
         JButton paintCarre= new JButton("paintCarre");
         paintCarre.addActionListener(this);
         JPanel southPanel = new JPanel();
         southPanel.setLayout(new GridLayout(2, 6));
         southPanel.add(black);
         southPanel.add(rouge);
         southPanel.add(vert);
         southPanel.add(bleu);
         southPanel.add(paintEllipse);
         southPanel.add(paintCercle);
         southPanel.add(jaune);
         southPanel.add(rose);
         southPanel.add(magenta);
         southPanel.add(orange);
         southPanel.add(paintRectangle);
         southPanel.add(paintCarre);
         //déclaration de ou va se situer tous les boutons créer
         contentPanel.add(southPanel,"South");
         contentPanel.add(draw);
         this.setJMenuBar(m);
         this.setVisible(true);
         }

        @Override
        public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                switch(cmd) {
                        case"black" :System.out.println("noir selectionné");draw.setColor(Color.black);break;
                        case"rouge" : System.out.println("rouge selectionné");draw.setColor(Color.red);break;
                        case"bleu" : draw.setColor(Color.blue); System.out.println("bleu selectionné");;break;
                        case"vert" : draw.setColor(Color.green); System.out.println("vert selectionné");break;
                        case"jaune" : draw.setColor(Color.yellow); System.out.println("jaune selectionné");break;
                        case"rose" : draw.setColor(Color.pink);System.out.println("rose selectionné");break;
                        case"magenta" : draw.setColor(Color.magenta);System.out.println("magenta selectionné");break;
                        case"orange" : draw.setColor(Color.orange);System.out.println("orange selectionné");break;

                        case"paintRectangle" : System.out.println("rectangle selectionné");
                                               draw.setFigureName("Rectangle");
                                               break;
                        case"paintCarre" : System.out.println("carre selectionné");
                                           draw.setFigureName("Square");
                                           break;
                        case"paintEllipse" : System.out.println("ellipse selectionné");
                                             draw.setFigureName("Ellipse");
                                             break;
                        case"paintCercle" : System.out.println("cercle selectionné");
                                            draw.setFigureName("Circle");
                                            break;
                        case "Auteurs": System.out.println("auteurs selectionné");
                                        JOptionPane info = new JOptionPane();
                                        info.showInternalMessageDialog(info, "Auteur : Quentin SIMON","information",JOptionPane.INFORMATION_MESSAGE);
                                        break;
                        case "Save" : System.out.println("save selectionné");break;
                        case "Open" : System.out.println("Open selectionné"); break;
                        case "Quit" : System.out.println("Quit selectionné");break;
                        case "New" : System.out.println("New selectionné");break;
                        default : break;
                }
        }
}
