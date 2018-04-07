package edu.iedu.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Tictactoe {

	public static List<List<Integer>> newGameBoard() {
		List<List<Integer>> board = new ArrayList<>();
		for(int row = 0; row < 7; row++) {
			List<Integer> column = new ArrayList<>();
			for(int col = 0; col < 6; col++) {
				column.add(0);
			}
			board.add(column);
		}
		
		return board;
	}
	
	public static void main(String[] args) {
		String dot = ".";
		String space = "  ";
//		String board = "";
		
		System.out.println("1  2  3  4  5  6");
		List<List<Integer>> board = newGameBoard();
		for (int row = 0; row < 7; row++) {
			List<Integer> column = board.get(row);
			String displayCol = "";
			for (int col = 0; col < 6; col++) {
				if(column.get(col) == 0) {
					displayCol+=dot+space;
				} else {
					displayCol+=column.get(col)+space;
				}
			}
			System.out.println(displayCol);
		}
	}
}
