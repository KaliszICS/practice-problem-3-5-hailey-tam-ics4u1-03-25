public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {

		//start at the bottom left
		int row = arr.length - 1;
		int col = 0;

		int noOfMoves = 0;

		return searchMazeMovesHelper(arr, row, col, noOfMoves);
		
	}

	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {

		// base case
		// Goes out of bounds
		if ( row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
			return -1;
		}

		// Reach the finish
		if (arr[row][col].equals("F")){
			// return number of moves
			return moves;
		}

		// recursive call - increase moves
		// Go right (increase col)
		int rightMoves = searchMazeMovesHelper(arr, row, col + 1, moves + 1);
		
		// Go up (decrease row)
		int upMoves = searchMazeMovesHelper(arr, row - 1, col, moves + 1);

		// compare return the smallest one (that is valid)
		if (rightMoves != -1 && upMoves != - 1){
			return Math.min(rightMoves, upMoves);
		}
		else if (rightMoves == -1) {
			return upMoves;
		}
		else {
			return rightMoves;
		}
	}

	public static int noOfPaths(String[][] arr) {

		//start at the bottom left
		int row = arr.length - 1;
		int col = 0;

		return noOfPathsHelper(arr, row, col);
		
	}

	public static int noOfPathsHelper(String[][] arr, int row, int col) {

		// base case
		// Goes out of bounds
		if ( row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
			return -1;
		}
		
		// Reach the finish
		if (arr[row][col].equals("F")){
			return 1; //valid path is found
		}
	
		// recursive call - increase moves
		// Go right (increase col)
		int rightPaths = noOfPathsHelper(arr, row, col + 1);
		
		// Go up (decrease row)
		int upPaths = noOfPathsHelper(arr, row - 1, col);

		if (rightPaths == -1){
			rightPaths = 0;
		}
		if (upPaths == -1){
			upPaths = 0;
		}
			return rightPaths + upPaths;
	}
}
