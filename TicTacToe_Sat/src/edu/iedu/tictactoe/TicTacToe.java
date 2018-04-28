package edu.iedu.tictactoe;

import java.util.List;

public class TicTacToe {
	public int rowSize;
	public int columnSize;
	public String player;
	public List<List<String>> board;
	
	public TicTacToe(int row, int column) {
		rowSize = row;
		columnSize = column;
	}
	
	public boolean isValid(int rowPos, int colPos) {
		if((rowPos > 3 || rowPos < 0) || (colPos > 3 || colPos < 0)) {
			// check valid range  
			return false;
		} else {
			// checl valid position
			List<String> subBoard = board.get(rowPos-1);
			// [".","X","."]
			String value = subBoard.get(colPos - 1);
			// "X"
			if(value.equals(".")) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void insertMark(int _row, int _column) {
		for(int row = 0; row < rowSize; row++) {
			for(int column = 0; column < columnSize; column++) {
				List<String> subBoard = board.get(row);
				if(row == _row - 1 && column == _column - 1) {
					subBoard.set(column, player);
				}
				
				board.set(row, subBoard);
			}
			
		}
	}
	
	public boolean isWinner() {
		
		if(checkHorizontalDirection(board, player)){
			// 1) Check Horizontal Direction
			return true;
		} else if(checkDiagonalDirection(board, player)) {
			// 2) Check Diagonal Direction
			return true;
		}
		
		
		return false;
	}
	
	public boolean checkHorizontalDirection(List<List<String>> board, String player) {
		
		for(int row = 0; row < rowSize; row++) {
			int count = 0;
			List<String> subBoard = board.get(row);

			for(int col = 0; col < columnSize; col++) {
				String mark = subBoard.get(col);
				// "X", player = "X"
				if(mark.equals(player)) {
					count++;
				}
			}
			
			if(count == 3) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean checkDiagonalDirection(List<List<String>> board, String player) {
		int count = 0;
		for(int row = 0; row < rowSize; row++) {
			List<String> subBoard = board.get(row);
			String mark = subBoard.get(row);
			
			if(mark.equals(player)) {
				count++;
			}
		}
		
		if(count == 3) {
			return true;
		}
		
		count = 0;
		
		for(int row = 0; row < rowSize; row++) {
			// ["X", ".", "."]
			// [".", "X", "."]
			// [".", ".", "X"]
			List<String> subBoard = board.get(row);
			String mark = subBoard.get(rowSize-row-1);
			
			if(mark.equals(player)) {
				count++;
			}
		}
		
		if(count == 3) {
			return true;
		}
		
		return false;
	}
	
	public void changePlayer() {
		if(player.equals("X")) {
			player = "O";
		} else {
			player = "X";
		}
	}
}
