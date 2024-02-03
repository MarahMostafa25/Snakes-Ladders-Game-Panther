package model;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Level;

public class Board {
	private int boardId;
	private int size;
	private Square[][] boardMatrix;	
	private Level levelgame;
	public Board(int boardId, Level levelgame) {
		super();
		this.boardId = boardId;
		if(levelgame.equals(Level.Easy)) {
			this.size=7;
		}
		if(levelgame.equals(Level.Medium)) {
			this.size=10;
		}
		if(levelgame.equals(Level.Hard)) {
			this.size=13;
		}

        this.boardMatrix = new Square[size][size];
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getSize() {
		return size;
	}

	
	public Square[][] getBoardMatrix() {
		return boardMatrix;
	}

	public void setBoardMatrix(Square[][] boardMatrix) {
		this.boardMatrix = boardMatrix;
	}

	public Level getLevelgame() {
		return levelgame;
	}

	public void setLevelgame(Level levelgame) {
		this.levelgame = levelgame;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", size=" + size + ", boardMatrix=" + Arrays.toString(boardMatrix)
				+ ", levelgame=" + levelgame + "]";
	}

	
}
