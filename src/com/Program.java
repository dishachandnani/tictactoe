package com;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic tac toe");
		System.out.println("-----------------------");
		Tictactoe t1=new Tictactoe();
		t1.printBoard();
		Scanner input=new Scanner(System.in);
		System.out.println("First turn will be of X...Enter slot number:");
		String winner=null;
		while (winner == null) {
			int numInput;
			try {
				numInput = input.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
		
			t1.changePlayer(numInput);
			winner = t1.checkWinner();
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
		input.close();
	}
}
