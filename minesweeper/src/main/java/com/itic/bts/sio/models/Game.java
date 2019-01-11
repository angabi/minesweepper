package com.itic.bts.sio.models;

public class Game {

	private String[][] fields;
	private String[][] displayFields;
	private boolean done;
	private boolean win;
	private int mines;

	public Game() {
	}

	
	public Game(String[][] fields, String[][] displayFields, int mines) {
		super();
		this.fields = fields;
		this.displayFields = displayFields;
		this.mines = mines;
	}


	public Game(String[][] fields, int mines) {
		this.fields = fields;
		this.mines = mines;
	}

	public Game(String[][] fields) {
		this.fields = fields;
	}

	public String[][] getFields() {
		return fields;
	}

	public void setFields(String[][] fields) {
		this.fields = fields;
	}

	public String[][] getDisplayFields() {
		return displayFields;
	}

	public void setDisplayFields(String[][] displayFields) {
		this.displayFields = displayFields;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int getMines() {
		return mines;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}

}
