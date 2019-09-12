import javax.swing.*;
import java.io.*;
import java.awt.*;
class SaveOption extends JFrame
{
     FileReader fr=null;
     BufferedReader bur=null;
     FileWriter fw=null;
     BufferedWriter bw=null;
     PrintWriter pw=null;
    void newSave() throws Exception
    {
        JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("Choose where you want to save...");
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    chooser.setAcceptAllFileFilterUsed(false);
                    String ghij="";
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                    {
                        ghij=chooser.getSelectedFile().toString().replace('\\','/');
                       // System.out.println("getSelectedFile() : " + ghij);
                        
                    }
                  String str1 = JOptionPane.showInputDialog("Enter Save Name");
                       fw=new FileWriter(ghij+"/"+str1+".txt",true);
                      /* bw=new BufferedWriter(fw);
                       pw=new PrintWriter(bw);*/
                    
                    
    }
    String direct;
    void OpenSave(int r) throws Exception
    {
        JFrame j1=new JFrame();
                     j1.setVisible(false);
                     j1.setSize(100,100);
                     FileDialog fd=new FileDialog(j1,"Choose the savegame file");
                     fd.setVisible(true);
                     String file=fd.getDirectory();
                     String safe=fd.getFile();
                     //System.out.println(file);
                     direct=file.replace('\\' ,'/')+safe;
                     //System.out.println(direct);
                    
                        /* fr=new FileReader(direct);
                         bur=new BufferedReader(fr);*/
                        
                        fw=new FileWriter(direct,true);
                       bw=new BufferedWriter(fw);
                       pw=new PrintWriter(bw);
                       if(r==1)
                       {
                           fr=new FileReader(direct);
                         bur=new BufferedReader(fr);
                        }
                        
                   
    }
    String filedirectory()
    {
        return direct;
    }
    void letsSave(int s)
    {
         String str1 = JOptionPane.showInputDialog("Enter your Name(first 4 characters will be taken)");
        
         
        pw.println(s+"------------------------------"+str1);
        pw.close();
    }
}