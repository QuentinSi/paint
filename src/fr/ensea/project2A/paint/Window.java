package fr.ensea.project2A.paint;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements  ActionListener{
        Draw draw = new Draw();

    public Window(String Title, int x, int y){
         super("Paint");
         this.setSize(x,y);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         Container contentPanel = this.getContentPane() ;

         JMenuBar principal= new JMenuBar();
         JMenu menu1= new JMenu("File");
         menu1.addSeparator();

         JMenuItem saveMenu= new JMenuItem("Save");
         saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
         saveMenu.addActionListener(this);

         JMenuItem news = new JMenuItem("New");
         news.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
         news.addActionListener(this);

         JMenuItem open = new JMenuItem("Open");
         open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
         open.addActionListener(this);

         JMenuItem undo = new JMenuItem("undo");
         undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
         undo.addActionListener(this);

         JMenuItem quit = new JMenuItem("Quit");
         quit.setAccelerator(KeyStroke.getKeyStroke (KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
         quit.addActionListener(this);

         menu1.add(news);
         menu1.add(open);
         menu1.add(saveMenu);
         menu1.add(undo);
         menu1.add(quit);
         principal.add(menu1);

         JMenu menu2 = new JMenu ("About");
         JMenuItem author = new JMenuItem("Author");
         author.addActionListener(this);
         menu2.add(author);
         principal.add(menu2);

         JButton black= new JButton("black");
         black.setBackground(Color.BLACK);
         black.setForeground(Color.WHITE);
         black.addActionListener(this);

         JButton red= new JButton("red");
         red.setBackground(Color.red);
         red.addActionListener(this);

         JButton green= new JButton("green");
         green.setBackground(Color.green);
         green.addActionListener(this);

         JButton blue= new JButton("blue");
         blue.setBackground(Color.BLUE);;
         blue.setForeground(Color.WHITE);
         blue.addActionListener(this);

         JButton yellow= new JButton("yellow");
         yellow.setBackground(Color.YELLOW);
         yellow.addActionListener(this);

         JButton pink= new JButton("pink");
         pink.setBackground(Color.PINK);
         pink.addActionListener(this);

         JButton magenta= new JButton("magenta");
         magenta.setBackground(Color.MAGENTA);
         magenta.addActionListener(this);

         JButton orange= new JButton("orange");
         orange.setBackground(Color.ORANGE);
         orange.addActionListener(this);

         JButton paintEllipse= new JButton("paintEllipse");
         paintEllipse.addActionListener(this);

         JButton paintCircle= new JButton("paintCircle");
         paintCircle.addActionListener(this);

         JButton paintRectangle= new JButton("paintRectangle");
         paintRectangle.addActionListener(this);

         JButton paintSquare= new JButton("paintSquare");
         paintSquare.addActionListener(this);

         JPanel left_part = new JPanel();
         left_part.setLayout(new GridLayout(2,4));
         left_part.add(black);
         left_part.add(red);
         left_part.add(green);
         left_part.add(blue);
         left_part.add(yellow);
         left_part.add(pink);
         left_part.add(magenta);
         left_part.add(orange);

         JPanel right_part = new JPanel();
         right_part.setLayout(new GridLayout(2,2));
         right_part.add(paintEllipse);
         right_part.add(paintCircle);
         right_part.add(paintRectangle);
         right_part.add(paintSquare);

         JPanel southPanel = new JPanel();
         southPanel.setLayout(new GridLayout(1, 2));
         southPanel.add(left_part);
         southPanel.add(right_part);
         contentPanel.add(southPanel,"South");
         contentPanel.add(draw);
         this.setJMenuBar(principal);
         this.setVisible(true);
         }

        @Override
        public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                switch(cmd) {
                        case"black" :draw.setColor(Color.black);System.out.println("black selected");break;
                        case"red" :draw.setColor(Color.red);System.out.println("red selected");break;
                        case"blue" : draw.setColor(Color.blue); System.out.println("blue selected");;break;
                        case"green" : draw.setColor(Color.green); System.out.println("green selected");break;
                        case"yellow" : draw.setColor(Color.yellow); System.out.println("yellow selected");break;
                        case"pink" : draw.setColor(Color.pink);System.out.println("pink selected");break;
                        case"magenta" : draw.setColor(Color.magenta);System.out.println("magenta selected");break;
                        case"orange" : draw.setColor(Color.orange);System.out.println("orange selected");break;

                        case"paintRectangle" : System.out.println("rectangle selected");
                                               draw.setFigureName("Rectangle");
                                               break;
                        case"paintSquare" : System.out.println("square selected");
                                           draw.setFigureName("Square");
                                           break;
                        case"paintEllipse" : System.out.println("ellipse selected");
                                             draw.setFigureName("Ellipse");
                                             break;
                        case"paintCircle" : System.out.println("circle selected");
                                            draw.setFigureName("Circle");
                                            break;
                        case "Author": System.out.println("author selected");
                                        JOptionPane info = new JOptionPane();
                                        info.showInternalMessageDialog(info, "Author : Quentin SIMON","information",JOptionPane.INFORMATION_MESSAGE);
                                        break;
                        case "Save" :JFileChooser test = new JFileChooser();
                                     int save = test.showSaveDialog(this);
                                     if (save == JFileChooser.APPROVE_OPTION) {
                                             String FileName = test.getSelectedFile().getAbsolutePath();
                                             draw.savedrawing(FileName);
                                     }
                                     else System.out.println("backup canceled\n");
                                     System.out.println("save selected");break;
                        case "Open" : JFileChooser rec = new JFileChooser();
                                      int open = rec.showOpenDialog(this);
                                       if (open == JFileChooser.APPROVE_OPTION) {
                                                String FileName = rec.getSelectedFile().getAbsolutePath();
                                                draw.opendrawing(FileName);
                                        }
                                       else System.out.println("open file canceled\n");break;
                        case "Quit" : System.exit(0);System.out.println("Quit selected");break;
                        case "New" : draw.getList().clear();repaint();System.out.println("New selected");break;
                        case "undo" : draw.back_one_step();System.out.println("Undo selected");break;
                        default : break;
                }
        }
}
