package com.example.app.utils.factorial;

/**
 * 0-1ナップサック問題 (動的計画法)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class KnapsackProblem {

	/**
	 * 、0-1ナップサック問題を動的計画法で解く実装です。 ナップサック問題とは、重さと価値が決まっている複数のアイテムの中から、
	 * 最大の価値を持ちながら特定の重さを超えないように選択する問題です。 この例では、動的計画法を使って効率的に解を求めています。
	 *
	 * [0-1ナップサック問題の特徴] - 0-1ナップサック問題では、各アイテムは1つしか存在せず、選ぶか選ばないかの2択（0または1）しかありません。 -
	 * 目的は、重さの合計が指定の制約内で最大の価値を持つようにアイテムを選ぶことです。 -
	 * 例えば、重さと価値が異なる複数のアイテムがあり、それらを最適に選んで最大の価値を得たいという場面で使います。
	 *
	 * [コード全体の概要] - W: ナップサックの最大容量です。 - weights と values: 各アイテムの重さと価値を表す配列です。 -
	 * knapsack() メソッド: 動的計画法で問題を解き、最大価値を求めるメソッドです。 - dp
	 * 配列を使用して、部分問題の結果を再利用することで、計算の重複を避けて効率的に解決します。
	 */

	// ナップサックの最大容量
	static int W = 50;

	// 重さと価値の配列
	static int[] weights = { 10, 20, 30 };
	static int[] values = { 60, 100, 120 };

	// アイテムの数
	static int n = values.length;

	/**
	 * 動的計画法によるナップサック問題の解決
	 * 
	 * @param W
	 * @param weights
	 * @param values
	 * @param n
	 * @return
	 */
	public static int knapsack(int W, int[] weights, int[] values, int n) {
		int[][] dp = new int[n + 1][W + 1];

		// dpテーブルの作成
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else if (weights[i - 1] <= w)
					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				else
					dp[i][w] = dp[i - 1][w];
			}
		}

		return dp[n][W];
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("最大価値: " + knapsack(W, weights, values, n));
	}
}
