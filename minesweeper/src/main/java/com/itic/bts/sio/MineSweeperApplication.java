package com.itic.bts.sio;

import java.util.Scanner;

import com.itic.bts.sio.business.GameCore;
import com.itic.bts.sio.models.Game;

public class MineSweeperApplication {
	
	
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		System.out.print("Entrer la taille de demineur souhaitée : ");
		int size = scan.nextInt() + 2;
		String[][] gameFields = new String[size][size];
		String[][] filedsToDisplay = new String[size][size];
		
		System.out.print("Entrer le nombre de mines souhaitée : ");
		int mines = scan.nextInt();
		Game game = new Game(gameFields, filedsToDisplay, mines);
		GameCore core = new GameCore(game);
		core.runGame();
		
	}

}
