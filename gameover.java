import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class GameOver extends JFrame
{
    JFrame condol=new JFrame();
    int gg;
    SaveOption o1=new SaveOption();
    void haha(int s)
    {
        Font font = new Font("Lucida Console", Font.BOLD, 25);
                    JLabel textLabel = new JLabel("         The Snake died. ");
                    textLabel.setFont(font);
                    textLabel.setBounds(10,10,600,35);
                    condol.add(textLabel);
                   JLabel sc = new JLabel("        Score:  "+s);
                   sc.setFont(font);
                    sc.setBounds(15,80,600,35);
                    ImageIcon icon = new ImageIcon("C:/pics/abcd.gif");

                    JLabel copyLabel = new JLabel(icon);
                    copyLabel.setBounds(190,240,120,130);
                    condol.add(copyLabel);

                    condol.add(sc);
                    gg=s;
                    condol.setSize(530, 420);
                    
                    
                     condol.setBackground(Color.WHITE);
                     condol.setTitle("  GAME OVER");
                     condol.setLocationRelativeTo(null);
                     condol.setLayout(null);
                     condol.setVisible(true); 
                     JButton retry=new JButton("Try Again");
                     retry.setBounds(110,120,300,25);
                     retry.addActionListener(new ActionListener(){
                         public void actionPerformed(ActionEvent e) {
                               theGame o1=new theGame();
                               o1.play();
                            }
                        });
                        JButton gonsave=new JButton("Save score");
                        gonsave.setBounds(110,150,300,25);
                        gonsave.addActionListener(new ActionListener(){
                         public void actionPerformed(ActionEvent e) {
                             try{
                                o1.OpenSave(0);
                               o1.letsSave(gg);
                            }
                            catch(Exception ex)
                            {}
                            }
                        });
                     condol.add(retry);
                     condol.add(gonsave);
        
        
        
    }
    void result(int s)
    {
       
    }
    public static void main(String[]args)
    {
        GameOver o1=new GameOver();

    }
}