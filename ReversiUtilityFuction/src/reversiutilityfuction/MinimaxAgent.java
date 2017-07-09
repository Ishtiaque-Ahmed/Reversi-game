/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;
import java.util.*;
import static reversiutilityfuction.ReversiUtilityFuction.valid_moves;
/**
 *
 * @author ASUS
 */
public class MinimaxAgent extends Agent{
    public MinimaxAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
                Othello ogame=(Othello)game;
                
		//TickTackToe tttGame = (TickTackToe) game;
		CellValueTuple best = max(ogame,-500,500,5);
              
                System.out.println("row is "+best.row+" column is "+best.col);
		if(best.col!=-1)
		{
                    Successor s = new Successor();
                    ogame.board=s.create_child(ogame.board,best.row,best.col,role);
			//ogame.board[best.row][best.col] = role;
		}
                else 
                {
                   // ArrayList<pair>m=valid_moves(ogame.board,role);
                   // Successor s = new Successor();
                    //ogame.board=s.create_child(ogame.board,m.get(0).row,m.get(0).col,role);
                  //  System.out.println("Utility is "+best.utility);
                    ogame.s.show_noturn_msg(game.agent[role]);
                }
	}
        	
	
	
	private CellValueTuple max(Othello game,int alpha,int beta,int depth)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
                    
                  
                maxCVT.utility=-500;
                if(game.isBoardFull())
                {
                   // System.out.println("board full");
                  //  maxCVT.utility=game.checkForWin();
                    //maxCVT.is_win=true;
                    
                    maxCVT.utility=evaluation(game.board,role);
                    return maxCVT;
                }
                if(depth==0)
                {
               // print_moves(valid);
                    //System.out.println("Depth 0");
                    maxCVT.utility=evaluation(game.board,role);
                    return maxCVT;
                }
                if(!check_turn(game.board,role))
                {
                    Successor s=new Successor();
                    System.out.println("printing.......");
                  //  s.print_ara(game.board);
                    maxCVT.utility=evaluation(game.board,role);
                    return maxCVT;
                }
                
                
                
                
                ReversiUtilityFuction m=new ReversiUtilityFuction();
                ArrayList<pair>valid=m.valid_moves(game.board,role);
                int curr_ara[][]=new int [8][8];
              
                //curr_ara=game.board;
                 for(int i=0;i<8;i++)
                {
                    for(int j=0;j<8;j++)
                    {
                        curr_ara[i][j]=game.board[i][j];
                    }
                }
                
                
                
              //  
              //  Successor s=new Successor();
               // s.print_ara(curr_ara);
              //  print_moves(valid);
              //  System.out.println("depth is "+depth); 
                
                for(int i=0;i<valid.size();i++)
                {
                    pair temp=(pair)valid.get(i);
                    
                    int child[][]=new int[8][8];
                    Successor s1=new Successor();
                    child=s1.create_child(game.board,temp.row,temp.col,role);
                    game.board=child;
                    int v=min(game,alpha,beta,depth-1).utility;
                    if(depth==5)System.out.println("final v is "+v);
                    if(v>maxCVT.utility)
                    {
                       // System.out.println("done");
                        maxCVT.utility=v;
                        maxCVT.row=temp.row;
                        maxCVT.col=temp.col;
                    }
                    if(v>=beta)
                        
                    {
                       // maxCVT.row=temp.row;
                        //maxCVT.col=temp.col;
                        return maxCVT;
                    }
                    if(alpha<v)alpha =v;
                    //game.board=curr_ara;
                     for(int ii=0;ii<8;ii++)
                        {
                             for(int jj=0;jj<8;jj++)
                            {
                                game.board[ii][jj]=curr_ara[ii][jj];
                            }
                        }
                    
                }
                
		return maxCVT;
			
	}
	
	private CellValueTuple min(Othello game,int alpha,int beta,int depth)
	{	
		CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 1000;
		
		 if(game.isBoardFull())
                {
                   // minCVT.utility=game.checkForWin();
                    //minCVT.is_win=true;
                    minCVT.utility=evaluation(game.board,role);
                    return minCVT;
                }
                if(depth==0)
                {
                 //   System.out.println("depth 0 in min");
                     Successor s=new Successor();
                  //  System.out.println("printing.......");
                  //  s.print_ara(game.board);
                    minCVT.utility=evaluation(game.board,role);
                   // System.out.println(minCVT.utility);
                    return minCVT;
                }
		if(!check_turn(game.board,minRole()))
                {
                    Successor s=new Successor();
                  // System.out.println("printing.......in min ");
                  //  s.print_ara(game.board);
                    minCVT.utility=evaluation(game.board,role);
                    return minCVT;
                }
                
                
                ReversiUtilityFuction m=new ReversiUtilityFuction();
                ArrayList<pair>valid=m.valid_moves(game.board,minRole());
                int curr_ara[][]=new int [8][8];
                //curr_ara=game.board;
                for(int i=0;i<8;i++)
                {
                    for(int j=0;j<8;j++)
                    {
                        curr_ara[i][j]=game.board[i][j];
                    }
                }
                
                
                
                
                for(int i=0;i<valid.size();i++)
                {
                    pair temp=(pair)valid.get(i);
                    int child[][]=new int[8][8];
                    Successor s=new Successor();
                    child=s.create_child(game.board,temp.row,temp.col,minRole());
                    game.board=child;
                    int v=max(game,alpha,beta,depth-1).utility;
                  //  System.out.println("in min"+v+" depth = "+depth);
                    if(v<minCVT.utility)
                    {
                        minCVT.utility=v;
                        minCVT.row=temp.row;
                        minCVT.col=temp.col;
                    }
                    if(v<=alpha)
                        
                    {
                        //minCVT.row=temp.row;
                        //minCVT.col=temp.col;
                        return minCVT;
                    }
                    if(beta>v)beta =v;
                   // game.board=curr_ara;
                   
                   
                    for(int ii=0;ii<8;ii++)
                        {
                             for(int jj=0;jj<8;jj++)
                            {
                                game.board[ii][jj]=curr_ara[ii][jj];
                            }
                        }
                }
                
		return minCVT;
			
	}
	
	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}
        public int evaluation(int ara[][],int r)
        {
            int total=0;
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(ara[i][j]==r)total++;
                }
            }
            return total;
            
        }
	class CellValueTuple
	{
		int row,col, utility;
                boolean is_win;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
                        is_win=false;
		}
	}
        public static void print_moves(ArrayList<pair>a)
        {
            Iterator i=a.iterator();
         System.out.println("valid moves are ");
        while(i.hasNext())
        {
            pair at=(pair)i.next();
            System.out.print(at.row+" "+at.col+"    ");
        }
        System.out.println();
        }
        public static boolean check_turn(int ara[][],int role)
        {
            ReversiUtilityFuction f =new ReversiUtilityFuction();
           // ArrayList<pair>p1=f.valid_moves(ara,0);
            ArrayList<pair>p2=f.valid_moves(ara,role);
            if(p2.size()==0)return false;
            else return true;
            
            
        }
	
    
}
