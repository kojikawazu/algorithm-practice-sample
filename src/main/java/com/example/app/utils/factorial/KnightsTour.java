package com.example.app.utils.factorial;

/**
 * ナイトの巡回問題（Knight's Tour） (バックトラッキング（Backtracking）を用いて解く)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class KnightsTour {

	/**
	 * ナイトの巡回問題 (Knight's Tour) をバックトラッキング (Backtracking) を用いて解くプログラムです。
	 * ナイトの巡回問題とは、チェスのナイトがチェス盤上のすべてのマスを一度ずつ訪れる経路を見つける問題です。
	 *
	 * [ナイトの巡回問題の概要] - ナイトの動きは、チェスのルールに従い、"L字型" の 8 通りの動きをすることができます。 -
	 * ナイトがチェス盤上の全てのマスを一度ずつ訪れる経路を見つけるのが目標です。 -
	 * 問題の難しさは、既に訪問したマスには戻れないという制約のもとで、全てのマスを訪れる巡回経路を探すことにあります。
	 *
	 * [コード全体の概要] - バックトラッキングを使って、ナイトの次の動きを試み、解が見つからなければ戻って他の可能性を探ることで経路を見つけます。 -
	 * チェス盤のサイズは 8x8 で、すべてのマスを訪れることが目標です。
	 */

	private static int N = 8;
	private static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	/**
	 * 指定された位置が安全かどうかを判定する
	 * 
	 * @param x
	 * @param y
	 * @param board
	 * @return 安全な位置であれば true、それ以外は false
	 */
	private static boolean isSafe(int x, int y, int[][] board) {
		return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	}

	/**
	 * ナイトの巡回を再帰的に試行する
	 * 
	 * @param x
	 * @param y
	 * @param movei
	 * @param board
	 * @return 解が見つかった場合は true、それ以外は false
	 */
	private static boolean solveKTUtil(int x, int y, int movei, int[][] board) {
		if (movei == N * N) {
			return true;
		}

		for (int k = 0; k < 8; k++) {
			int next_x = x + dx[k];
			int next_y = y + dy[k];

			if (isSafe(next_x, next_y, board)) {
				board[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1, board)) {
					return true;
				} else {
					board[next_x][next_y] = -1; // バックトラック
				}
			}
		}
		return false;
	}

	/**
	 * ナイトの巡回問題を解く チェス盤を初期化し、ナイトの巡回を試行します。
	 */
	public static void solveKT() {
		int[][] board = new int[N][N];

		// ボードを初期化
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				board[x][y] = -1;

		// ナイトの初期位置
		int startX = 0;
		int startY = 0;
		board[startX][startY] = 0;

		if (!solveKTUtil(startX, startY, 1, board)) {
			System.out.println("解は存在しません。");
		} else {
			printSolution(board);
		}
	}

	/**
	 * チェス盤の解を表示する
	 * 
	 * @param board
	 */
	private static void printSolution(int[][] board) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.printf("%2d ", board[x][y]);
			System.out.println();
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		solveKT();
	}
}
