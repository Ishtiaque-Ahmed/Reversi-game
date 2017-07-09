/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class Successor {
    
    public static int [][] create_child(int ara[][],int row ,int col,int player_type)
    {
       int temp[][]= new int [8][8];
      //temp=ara;
      
      for(int ii=0;ii<8;ii++)
      {
          for(int jj=0;jj<8;jj++)
          {
              temp[ii][jj]=ara[ii][jj];
          }
      }
      
      
      
      
      
      
       if(ara[row][col]!=-1)return temp;
       int i=row,j=col;
         for(int k=j+1;k<8;k++)   //row   check right;
                    {
                        if(ara[i][j+1]==player_type)break;
                        if(ara[i][k]==-1)
                        {
                            break;
                        }
                        if(ara[i][k]==player_type)
                        {
                            temp[row][col]=player_type;
                           for(int same=j;same<k;same++)
                           {
                               temp[i][same]=player_type;
                           }
                            break;
                        }
                    }
       for(int k=j-1;k>=0;k--)   //row check left;
                    {
                        if(ara[i][j-1]==player_type)break;
                        if(ara[i][k]==-1)
                        {
                            break;
                        }
                        if(ara[i][k]==player_type)
                        {
                             temp[row][col]=player_type;
                           for(int same=k;same<j;same++)
                           {
                               temp[i][same]=player_type;
                           }
                            break;
                        }
                    }
        for(int k=i-1;k>=0;k--)   //col check up;
                    {
                        if(ara[i-1][j]==player_type)break;
                        if(ara[k][j]==-1)
                        {
                            break;
                        }
                        if(ara[k][j]==player_type)
                        {
                             temp[row][col]=player_type;
                           for(int same=k;same<=i-1;same++)
                           {
                               temp[same][j]=player_type;
                           }
                            break;
                        }
                    }
         for(int k=i+1;k<8;k++)   //col check down;
                    {
                        if(ara[i+1][j]==player_type)break;
                        if(ara[k][j]==-1)
                        {
                            break;
                        }
                        if(ara[k][j]==player_type)
                        {
                             temp[row][col]=player_type;
                           for(int same=k;same>=i+1;same--)
                           {
                               temp[same][j]=player_type;
                           }
                            break;
                        }
                    }
          //upper-left check
        if(col!=0)
        {
        int r1=row-1,c1=col-1;
        while(r1>=0 && c1>=0)
        {
            if(ara[row-1][col-1]==player_type)break;
            if(ara[r1][c1]==-1)break;
            if(ara[r1][c1]==player_type)
            {
                int tempr1=row,tempc1=col;
               while(tempr1>=r1)
                       {
                           temp[tempr1][tempc1]=player_type;
                           tempr1--;tempc1--;
                       }
               break;
            }
            r1--;c1--;
        }
        
        
        }
        //upper right check
         if(col!=7)
        {
        int r1=row-1,c1=col+1;
        while(r1>=0 && c1<=7)
        {
            if(ara[row-1][col+1]==-1)break;
            if(ara[r1][c1]==-1)break;
            if(ara[r1][c1]==player_type)
            {
                int tempr1=row,tempc1=col;
               while(tempr1>=r1)
                       {
                           temp[tempr1][tempc1]=player_type;
                           tempr1--;tempc1++;
                       }
               break;
            }
            r1--;c1++; 
        }
        }
        //lower left check
         if(col!=0)
        {
        int r1=row+1,c1=col-1;
        while(r1<=7 && c1>=0)
        {
            if(ara[row+1][col-1]==player_type)break;
            if(ara[r1][c1]==-1)break;
            if(ara[r1][c1]==player_type)
            {
               int tempr1=row,tempc1=col;
               while(tempc1>=c1)
                       {
                           temp[tempr1][tempc1]=player_type;
                           tempr1++;tempc1--;
                       }
               break;
            }
            r1++;c1--; 
        }
        
        
        }
         //lower right check
         if(col!=7)
        {
        int r1=row+1,c1=col+1;
        while(r1<=7 && c1<=7)
        {
            if(ara[row+1][col+1]==player_type)break;
            if(ara[r1][c1]==-1)break;
            if(ara[r1][c1]==player_type)
            {
               int tempr1=row,tempc1=col;
               while(tempr1<=r1)
                       {
                           temp[tempr1][tempc1]=player_type;
                           tempr1++;tempc1++;
                       }
               break;
            }
            r1++;c1++; 
        }
        }
         
        
        return temp;
        
    }
    public static void print_ara(int ara[][])
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
               
                System.out.print(ara[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    
    
   public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
       int ara[][]=new int [8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                ara[i][j]=in.nextInt();
            }
        }
        int row,pos,pt;
        row=in.nextInt();
        pos=in.nextInt();
        int temp[][]=new int [8][8];
        temp=create_child(ara,row,pos,1);
        print_ara(temp);
        
     
   }
    
    
}
