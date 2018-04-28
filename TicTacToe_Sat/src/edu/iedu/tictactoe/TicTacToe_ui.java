package edu.iedu.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe_ui {
	public TicTacToe tictactoe;
	
	public TicTacToe_ui(int row, int column) {
		tictactoe = new TicTacToe(row, column);
	}
	
	public void newBoard() {
		// This method is for making a new tic tac toe board.
		// When you call this method, your board will be refreshed.
		tictactoe.board = new ArrayList<>();
		
		for(int row = 0; row < tictactoe.rowSize; row++) {
			List<String> subBoard = new ArrayList<>();
			// []
			for(int column = 0; column < tictactoe.columnSize; column++) {
				subBoard.add(".");
			}
			tictactoe.board.add(subBoard);
		}
	}
	
	public void drawBoard() {
		// This method is for drawing current board
		
		for(int row = 0; row < tictactoe.rowSize; row++) {
			List<String> subBoard = tictactoe.board.get(row);
			String rowString = "";
			String space = " ";
			for(int column = 0; column < tictactoe.columnSize; column++) {
				String value = subBoard.get(column);
				rowString = rowString + value + space;
			}
			System.out.println(rowString);
		}
	}
	
	public void play() {
		
		
	}
	
	public void init() {		
		tictactoe.player = "X";
		
		newBoard();
		drawBoard();
		play();
	}
}
