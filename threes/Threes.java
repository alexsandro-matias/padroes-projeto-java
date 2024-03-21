
package threes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Threes {
	private int[][] board;
	private final int SIZE = 4;
	private Random r = new Random();

	public Threes() {
		this.board = new int[SIZE][SIZE];
		this.createNewNumber();
		this.createNewNumber();
	}

	private void createNewNumber() {
		int row = r.nextInt(SIZE);
		int col = r.nextInt(SIZE);
		if (this.board[row][col] == 0) {
			int n = r.nextInt(3) + 1;
			this.board[row][col] = n;
		} else {
			this.createNewNumber();
		}
	}

	public EndOfGame move(Direction d) {
		switch (d) {
		case LEFT:
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (board[i][j] != 0) {
						if (j >= 1) {
							if (board[i][j - 1] == 0) {
								board[i][j - 1] = board[i][j];
								board[i][j] = 0;
							} else if ((board[i][j - 1] == board[i][j] && (board[i][j - 1] + board[i][j]) % 3 == 0)
									|| board[i][j - 1] + board[i][j] == 3) {
								board[i][j - 1] += board[i][j];
								board[i][j] = 0;
							}
						}
					}
				}
			}
			break;
		case RIGHT:
			for (int i = 0; i < SIZE; i++) {
				for (int j = SIZE - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						if (j < SIZE - 1) {
							if (board[i][j + 1] == 0) {
								board[i][j + 1] = board[i][j];
								board[i][j] = 0;
							} else if ((board[i][j + 1] == board[i][j] && (board[i][j + 1] + board[i][j]) % 3 == 0)
									|| board[i][j + 1] + board[i][j] == 3) {
								board[i][j + 1] += board[i][j];
								board[i][j] = 0;
							}
						}
					}
				}
			}
			break;
		case UP:
			for (int j = 0; j < SIZE; j++) {
				for (int i = 0; i < SIZE; i++) {
					if (board[i][j] != 0) {
						if (i >= 1) {
							if (board[i - 1][j] == 0) {
								board[i - 1][j] = board[i][j];
								board[i][j] = 0;
							} else if ((board[i - 1][j] == board[i][j] && (board[i - 1][j] + board[i][j]) % 3 == 0)
									|| board[i - 1][j] + board[i][j] == 3) {
								board[i - 1][j] += board[i][j];
								board[i][j] = 0;
							}
						}
					}
				}
			}
			break;
		case DOWN:
			for (int j = 0; j < SIZE; j++) {
				for (int i = SIZE - 1; i >= 0; i--) {
					if (board[i][j] != 0) {
						if (i < SIZE - 1) {
							if (board[i + 1][j] == 0) {
								board[i + 1][j] = board[i][j];
								board[i][j] = 0;
							} else if ((board[i + 1][j] == board[i][j] && (board[i + 1][j] + board[i][j]) % 3 == 0)
									|| board[i + 1][j] + board[i][j] == 3) {
								board[i + 1][j] += board[i][j];
								board[i][j] = 0;
							}
						}
					}
				}
			}
			break;
		}
		this.createNewNumber();
		return this.gameOver();
	}

	private boolean onBoard(int row, int col) {
		return (row >= 0 && row < SIZE - 1 && col >= 0 && col < SIZE - 1);
	}

	private EndOfGame gameOver() {
		IntStream stream = Arrays.stream(board).flatMapToInt(x -> Arrays.stream(x));
		boolean b = stream.anyMatch(n -> n == 0);
		if (b)
			return EndOfGame.NONE;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				List<Cell> positions = List.of(new Cell(i - 1, j), new Cell(i + 1, j), new Cell(i, j - 1),
						new Cell(i, j + 1));
				for (Cell cell : positions) {
					int m = cell.row(), n = cell.col();
					if (onBoard(m, n)) {
						if ((board[m][n] == board[i][j] && (board[m][n] + board[i][j]) % 3 == 0)
								|| board[m][n] + board[i][j] == 3) {
							return EndOfGame.NONE;
						}
					}
				}
			}
		}
		return EndOfGame.LOSE;
	}

	public static void main(String[] args) {
		Threes t = new Threes();
		Scanner sc = new Scanner(System.in);
		Map<Character, Direction> mapa = Map.of('w', Direction.UP, 's', Direction.DOWN, 'a', Direction.LEFT, 'd',
				Direction.RIGHT);
		EndOfGame end;
		do {
			for (var row : t.board) {
				System.out.println(Arrays.toString(row));
			}
			char key = sc.next().charAt(0);
			Direction d = mapa.getOrDefault(key, Direction.UP);
			end = t.move(d);
			System.out.println("");
		} while (end != EndOfGame.LOSE);
		System.out.println("Fim de jogo");
		sc.close();
	}
}
