/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class HumanAgent extends Agent{
    
    static Scanner in = new Scanner(System.in);
	public HumanAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int row,col;
		//TickTackToe tttGame = (TickTackToe) game;
		Othello ogame=(Othello)game;
		boolean first = true;
		row=-1;col=-1;
			
			
		 ogame.s.something.row=-1;
                 ogame.s.something.col=-1;	
                 System.out.println("role is "+role);
                 Successor check =new Successor();
                 check.print_ara(ogame.board);
		while( true)
                {
                   // System.out.println(s.something.row+" "+s.something.col);
                    if(ogame.s.something.row!=-1)
                    {
                       // System.out.println(s.something.row+" "+s.something.col);
                        if(ogame.isValidCell(ogame.s.something.row, ogame.s.something.col, role))
                        {
                         System.out.println("valid");
                         row = ogame.s.something.row;
                         col = ogame.s.something.col;
                         break;
                        }
                    }
                }
//!tttGame.isValidCell(row, col));
		
                Successor p=new Successor();
                int temp[][]=p.create_child(ogame.board,row,col,role);
                ogame.board=temp;
                
		//tttGame.board[row][col] = role;
	}


	
}
