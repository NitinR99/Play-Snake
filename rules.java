import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Rules extends JFrame
{
        JFrame rules=new JFrame();
        Rules()
        {
                    Font font = new Font("Jokerman", Font.PLAIN, 15);
                    JLabel textLabel = new JLabel("          Players must try to get the highest score in order to win ");
                    textLabel.setFont(font);
                    textLabel.setBounds(10,10,600,35);
                    rules.add(textLabel);
                    JButton rel=new JButton("RELEASE THE SNAKE!");
                    rel.setBounds(140, 170, 220, 30);
                     rel.addActionListener(new ActionListener(){
                         public void actionPerformed(ActionEvent e) {
                               theGame o1=new theGame();
                               o1.play();
                            }
                        });
                    rules.add(rel);
                     rules.setSize(530, 370);
                     rules.setBackground(Color.WHITE);
                     rules.setTitle("  Project: Snake");
                     rules.setLocationRelativeTo(null);
                     rules.setLayout(null);
                     rules.setResizable(false);
                     rules.setVisible(true); 
        }
    }