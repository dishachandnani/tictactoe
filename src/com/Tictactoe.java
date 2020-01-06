package com;
import java.util.Arrays;

public class Tictactoe {
	private String[] board;
	private String currentPlayerMark;
	public Tictactoe() {
		board=new String[9];
		currentPlayerMark="x";
		initializeBoard();
	}
	public void initializeBoard() {				//initializing the board with slot numbers
		for(int i=0;i<9;i++)
		{
			board[i]=String.valueOf(i+1);
		}
	}
	public void printBoard() {					//printing the board
		//System.out.println("--------------");
		int temp=0;
		for(int i=0;i<3;i++)
		{
			System.out.print("| ");
			for(int j=0;j<3;j++)
			{
				//System.out.println("--------------");
				System.out.print(board[temp]+" | ");
				++temp;
			}
			System.out.println();
			//System.out.println("---------------");
		}
	}
	public void changePlayer(int numInput) {
		if (board[numInput-1].equals(String.valueOf(numInput))) {
			board[numInput-1] = currentPlayerMark;
			if (currentPlayerMark.equals("x")) {
				currentPlayerMark = "0";
			} else {
				currentPlayerMark = "x";
			}
			printBoard();
			
		} else {
			System.out.println("Slot already taken; re-enter slot number:");
			//continue;
		}
	}
	public String checkWinner(){
		for(int i=0;i<8;i++)
		{
			String line=null;
			switch (i) {
			case 0:
				line=board[0]+board[1]+board[2];
				break;
			case 1:
				line=board[3]+board[4]+board[5];
				break;
			case 2:
				line=board[6]+board[7]+board[8];
				break;
			case 3:
				line=board[0]+board[3]+board[6];
				break;
			case 4:
				line=board[1]+board[4]+board[7];
				break;
			case 5:
				line=board[2]+board[5]+board[8];
				break;
			case 6:
				line=board[0]+board[4]+board[8];
				break;
			case 7:
				line=board[2]+board[4]+board[6];
				break;
				
			}
			if(line.equals("xxx"))
				return "x";
			else if(line.equals("000"))
				return "0";	
		}
		for(int i=0;i<9;i++)
		{
			if(Arrays.asList(board).contains(String.valueOf(i+1)))
				break;
			else if(i==8)
				return "draw";
				
		}
		System.out.println(currentPlayerMark+"'s turn..");
		System.out.println("Enter a slot number to place "+currentPlayerMark+" in:");
		return null;
	}
}
