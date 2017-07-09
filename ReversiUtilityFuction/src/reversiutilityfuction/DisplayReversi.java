/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class DisplayReversi extends JFrame{
    ArrayList<label>bita;
    volatile label something;
    int map;
    public DisplayReversi() {
      //  JFrame f=new JFrame();
        something =new label();
        setLayout(new FlowLayout());
        int cnt=0;
        bita =new ArrayList<label>();
       for(int i=0;i<8;i++)
        {
            JPanel p=new JPanel();
            //p.setLayout(new Absol);
            for(int j=0;j<8;j++)
            {
               // String sup="Label"+cnt;
                JLabel temp=new JLabel();
                ImageIcon iconLogo = new ImageIcon("Images/green.png");
                  ImageIcon iLogo1 = new ImageIcon("Images/blackball.jpg");
                  ImageIcon iLogo2 = new ImageIcon("Images/whiteball.jpg");
                // In init() method write this code
                int row_index=i;int col_index=j;
                if(i==3 && j==3)temp.setIcon(iLogo2);
                else if(i==3 && j==4)temp.setIcon(iLogo1);
                else if(i==4 && j==3)temp.setIcon(iLogo1);
                else if(i==4 && j==4)temp.setIcon(iLogo2);
                else temp.setIcon(iconLogo);
                temp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Icon a=new ImageIcon("Images/fahim.png");
                   // temp.setIcon(iconLogo1);
                    something.row=row_index;
                    something.col=col_index;
                }
                //bita.add(temp);

            });
               
               label t=new label(temp,i,j);
               bita.add(t);
             //  bita.add(t);
                p.add(temp);cnt++;
                

            }
               add(p);  
               
            }
           
        }
      
    
    public void show_noturn_msg(Agent a)
    {
        String name = a.name+" has no valid moves";
          JOptionPane.showMessageDialog(
                        null,
                        name,
                        null, JOptionPane.INFORMATION_MESSAGE,
                        null);
     
            
    }
    public void show_win_msg(Agent a)
    {
        
        String winner_name=a.name+" has won ";
          JOptionPane.showMessageDialog(
                        null,
                        winner_name,
                        null, JOptionPane.INFORMATION_MESSAGE,
                        null);
         
        
       
        
    }
    public void show_draw_msg()
    {
        
         JOptionPane.showMessageDialog(
                        null,
                        "Game drawn",
                        null, JOptionPane.INFORMATION_MESSAGE,
                        null);
        
    }
   public void change_board(int ara[][])
   {
       for(int i=0;i<ara.length;i++)
       {
           for(int j=0;j<ara.length;j++)
           {
               if(ara[i][j]==0)
               {
                  // int new_index=i*8+j;
                  // String comp="Label"+new_index;
                   for(int l=0;l<bita.size();l++)
                   {
                      if(bita.get(l).row==i && bita.get(l).col==j)
                      {
                          bita.get(l).b.setIcon(new ImageIcon("Images/whiteball.jpg"));
                      }
                   }
                   
               }
               else if(ara[i][j]==1)
               {
                   //int new_index=i*8+j;
                  // String comp="Label"+new_index;
                   for(int l=0;l<bita.size();l++)
                   {
                      if(bita.get(l).row==i && bita.get(l).col==j)
                      {
                          bita.get(l).b.setIcon(new ImageIcon("Images/blackball.jpg"));
                      }
                   }
                   
               }
               
               
               
               
           }
       }
   }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DisplayReversi s=new DisplayReversi();
      //  JFrame frame=new JFrame();
      //  frame=s.final_f;
       // s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setSize(600,800);
        s.setVisible(true);
        Scanner in=new Scanner(System.in);
        int ara[][]=new int[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                ara[i][j]=in.nextInt();
            }
        }
        s.change_board(ara);
 
        //int index;
        
        // TODO code application logic here
    }
    
}
class label
    {
        String name;
        JLabel b;
        int row;
        int col;

        public label(JLabel b,int row,int col) {
            this.row=row;
            this.col=col;
            this.b=b;
        }

    public label() {
  
    
    }
       
    }