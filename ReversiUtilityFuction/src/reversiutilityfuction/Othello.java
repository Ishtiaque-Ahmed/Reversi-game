 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;
import java.util.*;
import static reversiutilityfuction.MinimaxAgent.print_moves;
/**
 *
 * @author ASUS
 * Example class extending Game class
 * @author Azad
 *
 */
public class Othello extends Game 
{

	/**
	 * The actual game board
	 * -1 empty, 0 -> O, 1 -> X
	 */
	public int[][] board;
          public DisplayReversi s;
	
	/**
	 * First agent starts with O
	 * @param a
	 * @param b
	 */
	public Othello(Agent a, Agent b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		
		a.setRole(0); // The first argument/agent is always assigned O (0)
		b.setRole(1); // The second argument/agent is always assigned X (1)
				  // NOtice that, here first dows not mean that afent a will make the first move of the game.
					  // Here, first means the first argument of the constructor
					  // Which of a and b will actually give the first move is chosen randomly. See Game class
		
		name = "Othello";
		
		board = new int[8][8];
		
	}
       public void  setdisplay(DisplayReversi s)
       {
           this.s=s;
       }
	/**
	 * Called by the play method of Game class. It must update the winner variable. 
	 * In this implementation, it is done inside checkForWin() function.
	 */
	@Override
	boolean isFinished() {
		// TODO Auto-generated method stub
		
		if(isBoardFull())
			return true;
                ReversiUtilityFuction temp=new ReversiUtilityFuction();
                ArrayList<pair>agent1=temp.valid_moves(board,0);
                ArrayList<pair>agent2=temp.valid_moves(board,1);
                if(agent1.size()==0 && agent2.size()==0)return true;
                return false;
                    
                
	}

	@Override
	void initialize(boolean fromFile) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = -1;
			}
		}
                
                board[3][3]=0;
                board[3][4]=1;
                board[4][3]=1;
                board[4][4]=0;
	}

	/**
	 * Prints the current board (may be replaced/appended with by GUI)
	 */
	@Override
	void showGameState() {
		// TODO Auto-generated method stub
		 
         for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j]!=-1)
                System.out.print("  "+board[i][j]);
                else 
                 System.out.print(" "+board[i][j]);
                }
            System.out.println();
        }
    }
	
    /** Loop through all cells of the board and if one is found to be empty (contains -1) then return false.
    	Otherwise the board is full.
    */
    public boolean isBoardFull() {

		
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                if (board[i][j] == -1) 
                {
                   return false;
                }
            }
        }
		
        return true;
    }
	
	
    /** Returns role of the winner, if no winner/ still game is going on -1.
     * @return role of the winner, if no winner/ still game is going on -1.
     */
    public int checkForWin() 
    {
    	winner = null;
        int cnt0=0;
        int cnt1=0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j]==0)cnt0++;
                else if(board[i][j]==1)cnt1++;
            }
        }
     //   System.out.println("0 count "+cnt0);
      //  System.out.println("1 count "+cnt1);
        if(cnt0>cnt1)return 0;
        else if(cnt1>cnt0)return 1;
        else return -1;
    	
    }
	
	
	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(int c1, int c2, int c3) 
    {
        return ((c1 != -1) && (c1 == c2) && (c2 == c3));
    }
	
	public boolean isValidCell(int row, int col,int p_type)
	{
          ReversiUtilityFuction r =new ReversiUtilityFuction(row,col);
          ArrayList a=r.valid_moves(board,p_type);
          
          for(int i=0;i<a.size();i++)
          {
              pair p =(pair)a.get(i);
             // System.out.print(p.row+" "+p.col+" ");
              if(p.row==row && p.col==col)return true;
              
          }
          return false;
	}

	@Override
	void updateMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
        @Override
        public void play()
        {
            
		updateMessage("Starting " + name + " between "+ agent[0].name+ " and "+ agent[1].name+".");
		//int turn = random.nextInt(2);
                int turn=0;
		
		//System.out.println(agent[turn].name+ " makes the first move.");
		initialize(false);
		
		while(!isFinished())
		{
			updateMessage(agent[turn].name+ "'s turn. ");
			ReversiUtilityFuction r= new ReversiUtilityFuction();
                        ArrayList<pair>moves=r.valid_moves(board,turn);
                       if(moves.size()!=0)
                       {
                           
                        // print_moves(moves);
                        agent[turn].makeMove(this);
			//showGameState();
			s.change_board(board);
                       }
                       else 
                       {
                           System.out.println("No move");
                           s.show_noturn_msg(agent[turn]);
                       }
                       
			turn = (turn+1)%2;
		}
		
                int m=checkForWin();
                if(m==-1)
                {
                    s.show_draw_msg();
                }
                else 
                    s.show_win_msg(agent[m]);
                
		//s.show_win_msg(checkForWin());
                   // updateMessage("Game drawn");
		
	
	
        }
	
}
