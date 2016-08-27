package practice.dev.problemsolving.snakesandladdersgame;

public class SnakesLaddersGame {
	public static void main(String[] args) {
		// TODO these parameters have to be read and checked for
		// validity from the console, that is, the command line. String[]
		// playerNames = {"Monica", "Albert","Noemi","Jaume"}; int numSquares =
		// 12;
		// for the user first square is at position 1 but
		// internally is at 0
		int[][] snakesFromTo = { { 11, 5 } };
		int[][] laddersFromTo = { { 2, 6 }, { 7, 9 } };
		String[] playerNames = null;
		int numSquares = 0;
		Game game = new Game(playerNames, numSquares, snakesFromTo,
				laddersFromTo);
		game.play();
	}
}
