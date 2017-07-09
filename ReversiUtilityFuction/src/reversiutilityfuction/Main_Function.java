/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversiutilityfuction;

import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Main_Function {
    public static void main(String[] args) 
	{
	
                DisplayReversi s=new DisplayReversi();
		Agent human = new HumanAgent("Neo");
		//Agent human = new MinimaxTTTAgent("007");
		Agent machine = new MinimaxAgent("Smith");
                Agent machine2= new MinimaxAgent("Terminator");
                    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    s.setSize(600,800);
                    s.setVisible(true);
		//System.out.println(human.name+" vs. "+machine.name);
		
                Othello game = new Othello(human,machine);
                game.setdisplay(s);
		game.play();
		
	}
}
 