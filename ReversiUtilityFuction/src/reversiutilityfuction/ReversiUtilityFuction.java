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
public class ReversiUtilityFuction {

    public ReversiUtilityFuction(int row, int col) {
        this.row = row;
        this.col = col;
    }
     public ReversiUtilityFuction() {
        this.row = -1;
        this.col = -1;
    }
    int row,col;
 
    public static ArrayList<pair> valid_moves(int ara[][],int player_type)
    {
        //Vector v=new Vector();
       ArrayList<pair>v=new ArrayList<pair>();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(ara[i][j]==-1)continue;
                if(ara[i][j]==player_type)
                {
                   
                    
                  //  System.out.println("player found at "+i+" "+j);
                    boolean isthere=false;
                    for(int k=j+1;k<8;k++)   //row check right;
                    {
                        if(ara[i][j+1]==-1)break;
                        if(ara[i][k]==player_type)
                        {
                            break;
                        }
                        if(ara[i][k]==-1)
                        {
                            pair ob= new pair(i,k);
                            if(!is_duplicate(v,ob))
                            {    
                            v.add(ob);
                            }
                            break;
                            
                        }
                    }
                    //row check left
                    for(int k=j-1;k>=0;k--)
                    {
                        if(ara[i][j-1]==-1)break;
                        if(ara[i][k]==player_type)
                        {
                            break;
                        }
                        if(ara[i][k]==-1)
                        {
                            pair ob= new pair(i,k);
                            if(!is_duplicate(v,ob))
                            {    
                            v.add(ob);
                            }
                            break;
                            
                        }
                    }
                    //colum check up
                       for(int k=i-1;k>=0;k--)
                    {
                        if(ara[i-1][j]==-1)break;
                        if(ara[k][j]==player_type)
                        {
                            break;
                        }
                        if(ara[k][j]==-1)
                        {
                            pair ob= new pair(k,j);
                             if(!is_duplicate(v,ob))
                            {    
                            v.add(ob);
                            }
                            break;
                            
                        }
                    }
                       //col check down
                          for(int k=i+1;k<8;k++)
                    {
                        if(ara[i+1][j]==-1)break;
                        if(ara[k][j]==player_type)
                        {
                            break;
                        }
                        if(ara[k][j]==-1)
                        {
                            pair ob= new pair(k,j);
                             if(!is_duplicate(v,ob))
                            {    
                            v.add(ob);
                            }
                            break;
                            
                        }
                    }
                          pair p=new pair();
                    ArrayList<pair> corners=p.corner_find(ara,i,j,player_type);
                    for(int ii=0;ii<corners.size();ii++)
                    {
                        pair pi=(pair)corners.get(ii);
                       if(!is_duplicate(v,pi))
                            {    
                            v.add(pi);
                            }
                        //System.out.println(corners.get(ii).toString());
                    }
                  
                  
                }
                
            }
        }
        
        
        
        return v;
    }
   public static boolean is_duplicate(ArrayList<pair> a,pair p)
   {
       for(int i=0;i<a.size();i++)
       {
           pair temp=(pair)a.get(i);
           if(temp.row==p.row && temp.col==p.col)return true;
           
       }
       return false;
   }

    /**
     * @param args the command line arguments
     */
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
       
        ArrayList a=valid_moves(ara,0);
        Iterator i=a.iterator();
        while(i.hasNext())
        {
            pair at=(pair)i.next();
            System.out.println(at.row+" "+at.col);
        }
        // TODO code application logic here
    }
    
}
