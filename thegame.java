import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;


//actual game
public class theGame extends JFrame {
 le_snak panel = null; //panel where drawing takes place
 JMenuBar menu = null;
 JMenu controls = null;
 JMenuItem play = null;
 JMenuItem restart = null;
 JMenuItem instructions = null;
 boolean firstplay = true;
 theGame(){
  this.setResizable(false);
  panel = new le_snak();
  this.setLayout(new BorderLayout());
  this.setMinimumSize(new Dimension(1200, 700));
  panel.dim = this.getSize();
  this.add(panel, BorderLayout.CENTER);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  this.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent we)
            { 
                    String ObjButtons[] = {"Yes","No"};
                    int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Project: Snake", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
                    if(PromptResult==0)
                    {
                            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     
                        }
                    }
                });
  this.addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent e)
    {
        panel.keyPress(e);
    }
    });   
   
  this.setVisible(true);
  this.pack();
 }
        //function to start thread for starting game
 public void play(){
  if(firstplay){
   panel.t.start();
   firstplay = false;
   //play.setEnabled(false);
  }
 }
        //function for restarting game, it will resize the le_snak to its initial position and initial length
 public void restart(){
  int pos = 0;
  panel.S_len.clear();
  body_circle[] baby = new body_circle[3];
  for(int i =0; i < 3; i++){
   baby[i] = new body_circle();
   baby[i].X_cen = 200;
   baby[i].Y_cen = 150-pos;
   baby[i].pY_cen = 150-pos;
   baby[i].pX_cen = 200;
   panel.S_len.add(baby[i]);
   pos = pos+10;
  }
  panel.gameover = false;
  panel.dir = 'D';
  panel.repaint();
 }
        //function to be called on the click of instructions
 
 public static void main(String[] args){
    theGame o5=new theGame();
    o5.play();
 }
}
