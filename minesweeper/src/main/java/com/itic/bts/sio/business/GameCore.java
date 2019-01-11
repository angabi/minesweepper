package com.itic.bts.sio.business;

import java.util.Scanner;

import com.itic.bts.sio.models.Game;

public class GameCore {

	private String Case = " ? ";
	private String CaseMinee = " * ";

	// Faire la bordure
	private String CaseVide = "   ";

	private Game game;

	public GameCore(Game game) {
		this.game = game;
	}

	//LE JEU
	public void runGame() {
		int x, y;
		initGame();
		generateMines();

		printGridGame(game.getDisplayFields());
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		while (true) {
			if (game.isDone() && game.isWin()) {
				System.out.println("\nVous avez gagner !");
				gameOver();
				break;
			} else if (game.isDone()) {
				gameOver();
				System.out.println("\nVous avez perdu..");
				break;
			} else if (!game.isDone()) {
				System.out.print("\nEntrer les coordonnees de x.");
				y = scan.nextInt();
				System.out.print("\nEntrer les coordonnees de y.");
				x = scan.nextInt();
				play(x, y);
				isVictory();
				reperer_CaseMinees();
				rafraichir();
			}
		}
	}

	
	//Initialisation du jeu a completer
	public void initGame() {
		for (int row = 0; row < game.getFields().length; row++) {
			for (int col = 0; col < game.getFields().length; col++) {

				if ((row == 0 || row == game.getFields().length - 1)
						|| (col == 0 || col == game.getFields()[0].length - 1)) {
					game.getFields()[row][col] = CaseVide;
					game.getDisplayFields()[row][col] = CaseVide;
				} else {
					game.getFields()[row][col] = Case;
					game.getDisplayFields()[row][col] = Case;
				}

			}
		}
	}

	public void printGridGame(String[][] fileds) {
		for (int row = 1; row < fileds.length - 1; row++) {
			for (int col = 0; col < fileds.length; col++) {

				if (col > 0 && col < fileds.length) {
					System.out.print("|");
				} else {
					System.out.println("");
				}

				System.out.print(fileds[row][col]);

			}
		}
	}

	private void generateMines() {
		for (int CaseMinee = 0; CaseMinee < game.getMines(); CaseMinee++) {
			while (true) {
				int x = 1 + (int) (Math.random() * ((game.getFields().length - 2) - 1));
				int y = 1 + (int) (Math.random() * ((game.getFields().length - 2) - 1));
				if (!game.getFields()[x][y].equals(this.CaseMinee)) {
					game.getFields()[x][y] = this.CaseMinee;
					break;
				}

			}

		}
	}

	public void rafraichir() {
		printGridGame(game.getDisplayFields());
		System.out.println("");
	}

	public void reperer_CaseMinees() {
		for (int x = 1; x <= game.getDisplayFields().length - 2; x++) {
			for (int y = 1; y <= game.getDisplayFields().length - 2; y++) {
				if (game.getDisplayFields()[x][y].equals(CaseVide)) {
					int nums = 0;
					for (int i = (x - 1); i <= (x + 1); i++) {
						for (int j = (y - 1); j <= (y + 1); j++) {
							if (game.getFields()[i][j].equals(CaseMinee)) {
								nums++;
							}
						}
					}
					game.getDisplayFields()[x][y] = " " + nums + " ";
				}
			}
		}
	}

	public void play(int x, int y) {
		if (game.getFields()[x][y].equals(Case) == true) {
			game.setDone(false);
			game.getDisplayFields()[x][y] = CaseVide;
			// game.getFields()[x][y] = CaseVide;
		} else if (game.getFields()[x][y].equals(CaseMinee) == true) {
			game.setDone(true);
			game.setWin(false);
		} else if (game.getDisplayFields()[x][y].equals(CaseVide) == true) {
			game.setDone(false);
			System.out.println("\nCette case a deja ete ouverte");
		}
	}

	public void isVictory() {
		int tile = 0;
		for (int i = 0; i < game.getFields().length; i++) {
			for (int j = 0; j < game.getFields().length; j++) {
				if (game.getFields()[i][j].equals(Case) == true)
					tile++;
			}
		}
		if (tile != 0) {
			game.setWin(false);
		} else {
			game.setWin(true);
			game.setDone(true);
		}
	}

	public void gameOver() {
		printGridGame(game.getFields());
		System.out.println();
	}
}
