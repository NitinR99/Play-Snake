import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
//a panel where all the drawings take place and it is embedded into JFrame
class le_snak extends JPanel implements Runnable{
 Vector<body_circle> S_len = null;   //S_len which will hold all the beads of le_snak body
 body_circle[] baby = null;
 int centx = 0, centy = 0;
 int inc = 10, pos = 0;
 char dir = 'D';
 Dimension dim = null;
 Thread t = null;
 boolean b = true, gameover = false;
 le_snak(){
  S_len = new Vector();
  baby = new body_circle[3];
  for(int i =0; i < 3; i++){
   baby[i] = new body_circle();
   baby[i].X_cen = 200;
   baby[i].Y_cen = 150-pos;
   baby[i].pY_cen = 150-pos;
   baby[i].pX_cen = 200;
   S_len.add(baby[i]);
   pos = pos+10;
  }
  t = new Thread(this);
  this.setLayout(null);
  this.setDoubleBuffered(true);
  dim = this.getSize();
  this.addKeyListener(new KeyAdapter(){public void keyTyped(KeyEvent e)
      {
          keyPress(e);
        }});
  this.setVisible(true);
 }
 int time = 30; //speed which  le_snak moves smaller means faster
 boolean gamepause = true;
        //setting keyevents 
 void keyPress(KeyEvent e){
  if(e.getKeyCode() == KeyEvent.VK_DOWN){
   if(dir != 'U')
    dir = 'D';
  }
  else if(e.getKeyCode() == KeyEvent.VK_UP){
   if(dir != 'D')
    dir = 'U';
  }
  else if(e.getKeyCode() == KeyEvent.VK_LEFT){
   if(dir != 'R')
    dir = 'L';
  }
  else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
   if(dir != 'L')
    dir = 'R';
  }
  else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
   System.exit(0);
  else if(e.getKeyCode() == KeyEvent.VK_SPACE){
   if(gamepause){
    t.suspend();
    gamepause = false;
   }
   else{
    t.resume();
    gamepause = true;
   }
  }
  
  
  
 }
 //generating random position of food
    

 int foodx = 20+(int)(Math.random()*85)*10;
 int foody = 20+(int)(Math.random()*59)*10;


 int score = 0;
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D)g;
  score = S_len.size()-3;

   
  g2.setColor(Color.red);
  g2.fillRect(0, 560, 1200,140);
 g2.setColor(Color.WHITE);
    g2.setFont(new Font("TimesRoman", Font.BOLD, 16));
  g2.drawString("Score: "+score,80,610);


  g2.setColor(Color.BLACK);
  g2.fillRect(0, 560, 1200,10);
    
  g2.setColor(Color.RED);
  g2.fillRect(foodx, foody, 10, 10);
    g2.setColor(Color.GREEN);

    
    
                //if game over then it will be display on screen
  if(gameover){
   //opens small frame where you can save high scores if required
   t.stop();
    int score=S_len.size()-3;
   GameOver pw=new GameOver();
   pw.haha(score);
   
  
   

   
  }
  else{   
   g2.fillRect(S_len.get(0).X_cen, S_len.get(0).Y_cen, S_len.get(0).r, S_len.get(0).r);
   for(int i=1; i < S_len.size(); i++){
    g2.fillOval(S_len.get(i).X_cen, S_len.get(i).Y_cen, S_len.get(i).r, S_len.get(i).r);
    S_len.get(i).pX_cen = S_len.get(i).X_cen;
    S_len.get(i).pY_cen = S_len.get(i).Y_cen;
    S_len.get(i).X_cen = S_len.get(i-1).pX_cen;
    S_len.get(i).Y_cen = S_len.get(i-1).pY_cen;
   }
  }  
 }
        //important function which will see collision of le_snak with wall or itself
 void collideWithWall(int x, int y){
  if(x < 10 || x > dim.width-13 || y < 10 || y > dim.height-150){
   gameover = true;
  

   try{Thread.sleep(1000);}catch(Exception e){}
   repaint();

  }
  else if(x==foodx && y==foody){
   body_circle baby = new body_circle(); //use if to check if cheatcode is entered
   baby.X_cen = S_len.get(S_len.size()-1).pX_cen;
   baby.Y_cen = S_len.get(S_len.size()-1).pY_cen;
   S_len.add(baby);
   foodx = 20+(int)(Math.random()*70)*10;
   foody = 20+(int)(Math.random()*52)*10;   
  }
  for(int i=1; i < S_len.size(); i++){
   if(x == S_len.get(i).X_cen && y == S_len.get(i).Y_cen){
    gameover = true;
 
    try{Thread.sleep(1000);}catch(Exception e){}
    repaint();
   }
  }
 }
 
 public void run(){
  
  while (true){
      if(dir=='L')
      {
          S_len.get(0).X_cen = (S_len.get(0).X_cen-inc);
          S_len.get(0).pX_cen = S_len.get(0).X_cen;
          collideWithWall(S_len.get(0).X_cen, S_len.get(0).Y_cen);
          repaint();
          
        }
        else if(dir=='R')
        {
            S_len.get(0).X_cen = (S_len.get(0).X_cen+inc);
            S_len.get(0).pX_cen = S_len.get(0).X_cen;
            collideWithWall(S_len.get(0).X_cen, S_len.get(0).Y_cen);
            repaint();
                
        }
        else if(dir=='U')
        {
             S_len.get(0).Y_cen = (S_len.get(0).Y_cen-inc);
             S_len.get(0).pY_cen = S_len.get(0).Y_cen;
             collideWithWall(S_len.get(0).X_cen, S_len.get(0).Y_cen);
             repaint();
             
        }
        else if(dir=='D')
        {
             S_len.get(0).Y_cen = (S_len.get(0).Y_cen+inc);
             S_len.get(0).pY_cen = S_len.get(0).Y_cen;
             collideWithWall(S_len.get(0).X_cen, S_len.get(0).Y_cen);
             repaint();
             
        }
      
   try{
    Thread.sleep(time);
   }
   catch(Exception e){}
  }
 }
}

 
    
