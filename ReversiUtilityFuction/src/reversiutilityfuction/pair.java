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
public class pair {

    public pair() {
            this.row=-1;
            this.col=-1;
    }

    public pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
    int row,col;
    public static ArrayList<pair> corner_find(int ara[][],int row ,int col,int player_type)
    {
        ArrayList<pair> v=new ArrayList<pair>();
        //upper-left check
        if(col!=0)
        {
        int r1=row-1,c1=col-1;
        while(r1>=0 && c1>=0)
        {
            if(ara[row-1][col-1]==-1)break;
            if(ara[r1][c1]==player_type)break;
            if(ara[r1][c1]==-1)
            {
                pair ob=new pair(r1,c1);
                v.add(ob);
                            
                
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
            if(ara[r1][c1]==player_type)break;
            if(ara[r1][c1]==-1)
            {
                pair ob=new pair(r1,c1);
                v.add(ob);
                            
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
            if(ara[row+1][col-1]==-1)break;
            if(ara[r1][c1]==player_type)break;
            if(ara[r1][c1]==-1)
            {
                pair ob=new pair(r1,c1);
                v.add(ob);
                            
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
            if(ara[row+1][col+1]==-1)break;
            if(ara[r1][c1]==player_type)break;
            if(ara[r1][c1]==-1)
            {
                pair ob=new pair(r1,c1);
                v.add(ob);
                            
                break;
            }
            r1++;c1++; 
        }
        }
         
         
         
        
        return v;
    }
    
}
