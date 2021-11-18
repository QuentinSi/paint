package fr.ensea.project2A.paint;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements  ActionListener{
        Draw draw = new Draw();

    public Window(String Title, int x, int y)
 {
         super("Paint");
         this.setSize(x,y);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         Container contentPanel = this.getContentPane() ;

         //déclaration du menu bar
         JMenuBar principal= new JMenuBar();
         JMenu menu1= new JMenu("File");
         menu1.addSeparator();

         //déclaration de toutes les options qui se situe dans le menu bar
         JMenuItem saveMenu= new JMenuItem("Save");
         saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
         saveMenu.addActionListener(this);

         JMenuItem news = new JMenuItem("New");
         news.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
         news.addActionListener(this);

         JMenuItem open = new JMenuItem("Open");
         open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
         open.addActionListener(this);

         JMenuItem quit = new JMenuItem("Quit");
         quit.setAccelerator(KeyStroke.getKeyStroke ((char) KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
         quit.addActionListener(this);

         menu1.add(news);
         menu1.add(open);
         menu1.add(saveMenu);
         menu1.add(quit);
         principal.add(menu1);

         JMenu menu2 = new JMenu ("A propos");
         JMenuItem auteurs = new JMenuItem("Auteurs");
         auteurs.addActionListener(this);
         menu2.add(auteurs);
         principal.add(menu2);

         //Déclaration tous les boutons de couleurs en bas de la page
         JButton black= new JButton("black");
         black.setBackground(Color.BLACK);
         black.setForeground(Color.WHITE);
         black.addActionListener(this);

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

         // déclaration des boutons permettant de dessiner la forme
         JButton paintEllipse= new JButton("paintEllipse");
         paintEllipse.addActionListener(this);

         JButton paintCercle= new JButton("paintCercle");
         paintCercle.addActionListener(this);

         JButton paintRectangle= new JButton("paintRectangle");
         paintRectangle.addActionListener(this);

         JButton paintCarre= new JButton("paintCarre");
         paintCarre.addActionListener(this);

         //déclaration des tableaux en bas de page découper en 2 parties gauche et droite pour obtenir la différence de taille des touches
         JPanel p_gauche = new JPanel();
         p_gauche.setLayout(new GridLayout(2,4));
         p_gauche.add(black);
         p_gauche.add(rouge);
         p_gauche.add(vert);
         p_gauche.add(bleu);
         p_gauche.add(jaune);
         p_gauche.add(rose);
         p_gauche.add(magenta);
         p_gauche.add(orange);

         JPanel p_droite = new JPanel();
         p_droite.setLayout(new GridLayout(2,2));
         p_droite.add(paintEllipse);
         p_droite.add(paintCercle);
         p_droite.add(paintRectangle);
         p_droite.add(paintCarre);

         //déclaration tableau qui récupère le tableau la partie gauche et droite
         JPanel southPanel = new JPanel();
         southPanel.setLayout(new GridLayout(1, 2));
         southPanel.add(p_gauche);
         southPanel.add(p_droite);
         contentPanel.add(southPanel,"South");
         contentPanel.add(draw);
         this.setJMenuBar(principal);
         this.setVisible(true);
         }

         //fonction qui permet de dire au programme que faire lors de l'appuie sur les boutons mais également lors de l'appuie sur un des boutons du menu barre
        @Override
        public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                switch(cmd) {
                        case"black" :draw.setColor(Color.black);System.out.println("noir selectionné");break;
                        case"rouge" :draw.setColor(Color.red);System.out.println("rouge selectionné");break;
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
                        case "Save" :JFileChooser test = new JFileChooser();
                                     int save = test.showSaveDialog(this);
                                     if (save == JFileChooser.APPROVE_OPTION) {
                                             String FileName = test.getSelectedFile().getAbsolutePath();
                                             draw.savedrawing(FileName);
                                     }
                                     else System.out.println("sauvegarde annulé");
                                     System.out.println("save selectionné");break;
                        case "Open" : JFileChooser rec = new JFileChooser();
                                      int open = rec.showOpenDialog(this);
                                       if (open == JFileChooser.APPROVE_OPTION) {
                                                String FileName = rec.getSelectedFile().getAbsolutePath();
                                                draw.opendrawing(FileName);
                                        }
                                       else System.out.println("ouverture fichier annulé");
                                      System.out.println("Open selectionné"); break;
                        case "Quit" : System.exit(0);System.out.println("Quit selectionné");break;
                        case "New" : draw.getList().clear();repaint();System.out.println("New selectionné");break;
                        default : break;
                }
        }
}
