import java.util.*;

public class TicTacToe {

	public static int printTheResult(char [][] grid) {
		int countX = 0;
		int countO = 0;
		int countDash = 0;
		int rowColX = 0;
		int rowColO = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (grid[i][j] == 'X')
					countX += 1;
				else if (grid[i][j] == 'O')
					countO += 1;
				else
					countDash += 1;
			}
		}
		if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') 
			rowColX = 1;
		if (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') 
			rowColX = 1;
		if (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X') 
			rowColX = 1;
		if (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') 
			rowColX = 1;
		if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') 
			rowColX = 1;
		if (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X') 
			rowColX = 1;
		if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X')
			rowColX = 1;
		if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X')
			rowColX = 1;

		if (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') 
			rowColO = 1;
		if (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') 
			rowColO = 1;
		if (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') 
			rowColO = 1;
		if (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') 
			rowColO = 1;
		if (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') 
			rowColO = 1;
		if (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') 
			rowColO = 1;
		if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O')
			rowColO = 1;
		if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O')
			rowColO = 1;

		if ((rowColX == 1 && rowColO == 1) || (countX - countO < 0) || (countX - countO > 1)) 
			return 3;
		if (countX == 0 && countO == 0 && countDash == 9)
			return 2;
		if (rowColX == 1 && rowColO == 0 && countX > countO)
			return 1;
		if (rowColX == 0 && rowColO == 1 && countX == countO)
			return 1;
		if (rowColX == 0 && rowColO == 0 && countDash == 0)
			return 1;
		if (rowColX == 0 && rowColO == 0 && countDash > 0)
			return 2;
		return 3;
	}

	// public static int printTheResult(char [][] grid) {
	// 	boolean isPreviousX = false;
	// 	boolean isPreviousO = false;
	// 	int countX = 0;
	// 	int countO = 0;
	// 	int countDiagonalX = 0;
	// 	int countDiagonalO = 0;
	// 	int countDiagonalXSecondary = 0;
	// 	int countDiagonalOSecondary = 0;

	// 	for (int i=0; i<3; i++) {
	// 		for (int j=0; j<3; j++) {
	// 			if (grid[i][j] == 'X')
	// 				countX += 1;
	// 			else if (grid[i][j] == 'O')
	// 				countO += 1;
	// 		}
	// 	}

	// 	// primary diagonal full X and check if any of the row or col is also full of X

	// 	if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
	// 		countDiagonalX = 3;
	// 		if ((grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[1][0] == 'X' && grid[2][0] == 'X')) {
	// 			return 3;
	// 		}
	// 		if ((grid[1][0] == 'X' && grid[1][2] == 'X') || (grid[0][1] == 'X' && grid[2][1] == 'X')) {
	// 			return 3;
	// 		}
	// 		if ((grid[2][0] == 'X' && grid[2][1] == 'X') || grid[0][2] == 'X' && grid[1][2] == 'X') {
	// 			return 3;
	// 		}
	// 	}

	// 	// if (countDiagonalX == 3 && Math.abs(countX - countO) != 1)
	// 	// 	return 3;
	// 	// if (countDiagonalX == 3)
	// 	// 	return 1;

	// 	// primary diagonal full O and check if any of the row or col is full o
	// 	if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
	// 		countDiagonalO = 3;
	// 		if ((grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[1][0] == 'O' && grid[2][0] == 'O')) {
	// 			return 3;
	// 		}
	// 		if ((grid[1][0] == 'O' && grid[1][2] == 'O') || (grid[0][1] == 'O' && grid[2][1] == 'O')) {
	// 			return 3;
	// 		}
	// 		if ((grid[2][0] == 'O' && grid[2][1] == 'O') || grid[0][2] == 'O' && grid[1][2] == 'O') {
	// 			return 3;
	// 		}
	// 	}

	// 	// if (countDiagonalO == 3 && countX - countO != 0)
	// 	// 	return 3;

	// 	// if (countDiagonalO == 3)
	// 	// 	return 1;

	// 	// secondary diagonal full X and check for the row or col to be full X
	// 	if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') {
	// 		countDiagonalXSecondary = 3;
	// 		if ((grid[0][0] == 'X' && grid[0][1] == 'X') || (grid[0][0] == 'X' && grid[1][0] == 'X')) {
	// 			return 3;
	// 		}
	// 		if ((grid[1][0] == 'X' && grid[1][2] == 'X') || (grid[0][1] == 'X' && grid[2][1] == 'X')) {
	// 			return 3;
	// 		}
	// 		if ((grid[2][1] == 'X' && grid[2][2] == 'X') || (grid[1][2] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 	}
	// 	// if (countDiagonalXSecondary == 3 && Math.abs(countX - countO) != 1 && countDiagonalX == 3)
	// 	// 	return 3;
	// 	// if (countDiagonalXSecondary == 3)
	// 	// 	return 1;

	// 	// secondary diagonal full O and check for the row or col to be full O
	// 	if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O') {
	// 		countDiagonalOSecondary = 3;
	// 		if ((grid[0][0] == 'O' && grid[0][1] == 'O') || (grid[0][0] == 'O' && grid[1][0] == 'O')) {
	// 			return 3;
	// 		}
	// 		if ((grid[1][0] == 'O' && grid[1][2] == 'O') || (grid[0][1] == 'O' && grid[2][1] == 'O')) {
	// 			return 3;
	// 		}
	// 		if ((grid[2][1] == 'O' && grid[2][2] == 'O') || (grid[1][2] == 'O' && grid[2][2] == 'O')) {
	// 			return 3;
	// 		}
	// 	}
	// 	// if (countDiagonalOSecondary == 3 && countX - countO != 0)
	// 	// 	return 3;
	// 	// if (countDiagonalOSecondary == 3)
	// 	// 	return 1;
	// 	if ((countDiagonalX == 3 && countDiagonalXSecondary == 3) || (countDiagonalO == 3 && countDiagonalOSecondary == 3))
	// 		return 3;
	// 	if (countDiagonalX == 3 && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (countDiagonalX == 3)
	// 		return 1;
	// 	if (countDiagonalO == 3 && countX - countO != 0)
	// 		return 3;

	// 	if (countDiagonalO == 3)
	// 		return 1;
	// 	if (countDiagonalOSecondary == 3 && countX - countO != 0)
	// 		return 3;
	// 	if (countDiagonalOSecondary == 3)
	// 		return 1;
	// 	if (countDiagonalXSecondary == 3 && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (countDiagonalXSecondary == 3)
	// 		return 1;



	// 	// more than one row winning 
	// 	if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') || (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X')) || 
	// 			(grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') || (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) || 
	// 			(grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O')) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;
	// 	if (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X')) || 
	// 			((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 		if (((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) || 
	// 			((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;
	// 	if (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') || (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X')) || 
	// 			((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 		if (((grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') || (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O')) || 
	// 			((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'))){
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;

	// 	// more than one row winning 
	// 	if (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') || (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') || (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;
	// 	if (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;
	// 	if (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') || (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') || (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;

	// 	// more than one col winning
	// 	isPreviousX = false;
	// 	isPreviousO = false;
	// 	if (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) || 
	// 			((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[1][0] == 'X' || grid[1][1] == 'X' || grid[1][2] == 'X') || (grid[2][0] == 'X' || grid[2][1] == 'X' || grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 		if ((grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O')) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;
	// 	if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) || 
	// 			((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[1][0] == 'X' || grid[1][1] == 'X' || grid[1][2] == 'X') || (grid[2][0] == 'X' || grid[2][1] == 'X' || grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 		if ((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O')) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;
	// 	if (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X') {
	// 		isPreviousX = true;
	// 		if (((grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X')) || 
	// 			((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[1][0] == 'X' || grid[1][1] == 'X' || grid[1][2] == 'X') || (grid[2][0] == 'X' || grid[2][1] == 'X' || grid[2][2] == 'X'))) {
	// 			return 3;
	// 		}
	// 		if ((grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O')) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousX && Math.abs(countX - countO) != 1)
	// 		return 3;
	// 	if (isPreviousX)
	// 		return 1;

	// 	if (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[1][0] == 'O' || grid[1][1] == 'O' || grid[1][2] == 'O') || (grid[2][0] == 'O' || grid[2][1] == 'O' || grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;
	// 	if (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[1][0] == 'O' || grid[1][1] == 'O' || grid[1][2] == 'O') || (grid[2][0] == 'O' || grid[2][1] == 'O' || grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;
	// 	if (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') {
	// 		isPreviousO = true;
	// 		if ((grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X')) {
	// 			return 3;
	// 		}
	// 		if (((grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O')) || 
	// 			((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[1][0] == 'O' || grid[1][1] == 'O' || grid[1][2] == 'O') || (grid[2][0] == 'O' || grid[2][1] == 'O' || grid[2][2] == 'O'))) {
	// 			return 3;
	// 		}
	// 	}
	// 	if (isPreviousO && countX - countO != 0)
	// 		return 3;
	// 	if (isPreviousO)
	// 		return 1;


	// 	// // one row full X OR O, but other column full X OR O
	// 	// isPreviousX = false;
	// 	// isPreviousO = false;
	// 	// if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') {
	// 	// 	isPreviousX = true;
	// 	// 	if ((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X')) {
	// 	// 		return 3;
	// 	// 	}
	// 	// 	if ((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) {
	// 	// 		return 3;
	// 	// 	}
	// 	// }
	// 	// if (isPreviousX && Math.abs(countX - countO) != 1)
	// 	// 	return 3;
	// 	// if (isPreviousX)
	// 	// 	return 1;

	// 	// for (int i=0; i<3; i++) {
	// 	// 	for (int j=0; j<3; j++) {
	// 	// 		if (grid[i][j] == 'X')
	// 	// 			countX += 1;
	// 	// 		else if (grid[i][j] == 'O')
	// 	// 			countO += 1;
	// 	// 	}
	// 	// }
	// 	if (countX > 5 || countO > 5)
	// 		return 3;
	// 	if (Math.abs(countX - countO) > 1)
	// 		return 3;
	// 	return 2;
	// }

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		long test = sc.nextLong();
		while (test-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			String s3 = sc.next();
			char [][] grid = new char[3][3];
			grid[0][0] = s1.charAt(0);
			grid[0][1] = s1.charAt(1);
			grid[0][2] = s1.charAt(2);

			grid[1][0] = s2.charAt(0);
			grid[1][1] = s2.charAt(1);
			grid[1][2] = s2.charAt(2);

			grid[2][0] = s3.charAt(0);
			grid[2][1] = s3.charAt(1);
			grid[2][2] = s3.charAt(2);

			System.out.println(printTheResult(grid));
		}
	}
}