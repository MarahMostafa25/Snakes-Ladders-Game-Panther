package model;

import java.util.ArrayList;

public class Board {
	private int boardId;
	private int size;
	private ArrayList<Square> squares;
	
	public Board(int boardId, int size) {
		super();
		this.boardId = boardId;
		this.size = size;
		this.squares = new ArrayList<Square>(); ;
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

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Square> getSquares() {
		return squares;
	}

	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}

	
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", size=" + size + ", squares=" + squares + "]";
	}
	
	
}
