import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
import java.util.Formatter;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.util.*;
public class GameMenu extends JFrame {

    // JPanel
    JPanel pnlButton = new JPanel();
    JPanel playerButton=new JPanel();
    // Buttons
    JButton first = new JButton("PLAY");
    JButton third=new JButton("HIGHSCORES");
    JButton second=new JButton("EXIT");
    
    JFrame frame=new JFrame();
    Graphics g; 
    
    JFrame player=new JFrame();


    int sure=0;

    public GameMenu() throws Exception {
        
        
        
        
        
    }
    void doings() throws Exception
    {
        
        //sound for buttons
         AudioInputStream yolo = AudioSystem.getAudioInputStream(new File("C:/pics/gunshot.wav").getAbsoluteFile());
        Clip butt = AudioSystem.getClip();
        butt.open(yolo);
                            SaveOption obj=new SaveOption();
        //theme song
        

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/pics/ghi.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        
   
        
        first.setBounds(550, 400, 220, 30);
        first.setBackground(Color.GREEN);
        first.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {        
                            //clip.stop();
                            butt.start();
                            //gamez.setSize( 1400, 700);
                            //gamez.setBackground(Color.WHITE);
                            //gamez.setVisible(true);
                           
                          
                             Rules o2=new Rules();
                           // gamez.add(o1);

            }
        });
        second.setBounds(550,550,220,30);
        second.setBackground(Color.RED);
        second.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                     butt.start();
                String ObjButtons[] = {"Yes","No"};
                    int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Project: Bounce", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
                    if(PromptResult==0)
                    {
                            System.exit(0);          
                        }
            }
        });
        third.setBounds(550,475,220,30);
        third.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                  if(sure==1)
                  {
                    //open a frame to display high scores of that save
                    JFrame jf=new JFrame("HIGHSCORES");
                    
                    TextArea text=new TextArea("                                                                  High Scores",80,80);
                    text.append("\n*********************************************************************************************");
                    for(int i=0;i<5;i++)
                    {
                        text.append("\n");
                    }
                    text.setEditable(false);
                    String xc=obj.filedirectory();
                    try
                    {
                        
                        ArrayList<String> rows = new ArrayList<String>();
                        BufferedReader reader = new BufferedReader(new FileReader(xc));

                        String s;
                        while((s = reader.readLine())!=null)
                        {
                        rows.add(s);
                    }

                        Collections.sort(rows,Collections.reverseOrder());

                        FileWriter writer = new FileWriter(xc);
                        for(String cur: rows)
                        {
                        writer.write(cur+"\n");
                    }

                        reader.close();
                        writer.close();
                        
                        
                        
                        FileReader fr=new FileReader(xc);
                        BufferedReader bur=new BufferedReader(fr);
                        String xd;
                        while((xd=bur.readLine())!=null)
                        {
                            text.append("\n \t \t \t      "+xd);    
                            
                        }
                    }
                    catch(Exception ex)
                    {
                    }
                    text.append("");
                    jf.add(text);
                    jf.setSize(700, 400);
                    jf.setBackground(Color.WHITE);
        
                    //jf.setLocationRelativeTo(null);
                    jf.setBounds(470,100,500,600);
                    jf.setResizable(false);
                    jf.setVisible(true);
                    
                    }
                  else if(sure==2)
                  {
                         final JPanel panel = new JPanel();

                      JOptionPane.showMessageDialog(panel, "No Entries Found.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                  else
                  {
                       final JPanel panel = new JPanel();

                      JOptionPane.showMessageDialog(panel, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);

                    }
               
            }
        });
        
        
        
        
        
        //logo
        BufferedImage myPicture = ImageIO.read(new File("C:/pics/w.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(400,100,520,300);
        add(picLabel);
        JLabel title=new JLabel("SNAKE");
        Font font = new Font("Goudy Stout", Font.PLAIN, 25);
        title.setFont(font);
        title.setBounds(580,190,690,300);
        add(title);
        
        
        
        
        
        addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent we)
            { 
                    String ObjButtons[] = {"Yes","No"};
                    int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Project: Snake", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
                    if(PromptResult==0)
                    {
                            System.exit(0);          
                        }
                    }
                });

        // JPanel bounds
        pnlButton.setBounds(800, 800, 1200, 800);

        // Adding to JFrame
                pnlButton.setLayout(null);
        pnlButton.add(first);
        pnlButton.add(second);
        pnlButton.add(third);

        add(pnlButton);

        
        //menubar      
        JMenuBar jmb = new JMenuBar();
        JMenu jmFiles=new JMenu("File");
        JMenu op=new JMenu("Open");
        
        JMenuItem newplay=new JMenuItem("New System");
        newplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {        
                     JFrame j1=new JFrame();
                     j1.setVisible(false);
                     j1.setSize(100,100);
                     
                    
                    try{
                    obj.newSave();
                    sure=2;
                }
                catch(Exception ex)
                {}
                       
                       

            
        }});
        JMenuItem openexist=new JMenuItem("Open Existing save");
         openexist.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {        
                    try{
                     obj.OpenSave(0);
                     sure=1;
                    }
                    catch(Exception ex)
                    {}

            }
        });

        op.add(openexist);
        op.add(newplay);
        jmFiles.add(op);
        jmb.add(jmFiles);
        
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
              jmiAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {        
                    JFrame ab=new JFrame();
                    String word="Test. Project for class 11. By Nitin. test.";
                    TextArea text=new TextArea(word,80,80);
                    String rels= "\n dddd";
                    text.append(rels);
                    rels="\n eeeee";
                    text.append(rels);
                    text.setEditable(false);
                    ab.add(text);
                    ab.setSize(500,500);
                    ab.setVisible(true);
                
            }
        });
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);
        setJMenuBar(jmb);
        pnlButton.setVisible(true);
        // JFrame properties
        setSize(1400, 700);
        setBackground(Color.WHITE);
        setTitle("                                                                                                                                                                                                        Project: Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        setVisible(true); 
    }
    public void paintComponent(Graphics g) 
    {
       
    }
    public static void main(String[] args) throws Exception{
       GameMenu o1= new GameMenu();
       o1.doings();
    }
}





 