package com.example.app.utils.factorial;

import java.util.HashMap;

/**
 * メモ化を使用したフィボナッチ数列
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class FibonacciMemoization {

	/**
	 * フィボナッチ数列の計算に**メモ化（Memoization）**を使用 効率的にフィボナッチ数を計算する方法を示しています。
	 *
	 * メモ化とは、再帰的な関数呼び出しで既に計算した結果を保存しておき、 再度同じ計算が必要なときに保存された結果を再利用することで、
	 * 計算時間を大幅に削減する手法です。
	 *
	 * この技術は、動的計画法の一種と見なされます。
	 *
	 * [メモ化を使ったフィボナッチ数列の概要] - メモ化では、計算した結果を**キャッシュ（メモリに保存）**しておき、
	 * 再度同じ結果を求める必要があるときに、再計算せずにそのキャッシュを利用します。 -
	 * フィボナッチ数列のような再帰的な構造では、同じサブ問題が何度も計算されることがあります。
	 * そのため、メモ化を使用することで再計算を防ぎ、計算量を削減します。
	 */

	/**
	 * memo化
	 */
	private static HashMap<Integer, Integer> memo = new HashMap<>();

	/**
	 * フィボナッチ数列(メモ化)
	 * 
	 * @param n
	 * @return 結果
	 */
	public static int fibonacci(int n) {
		if (memo.containsKey(n)) {
			return memo.get(n); // メモから取得
		}

		if (n <= 1) {
			memo.put(n, n);
			return n;
		} else {
			int value = fibonacci(n - 1) + fibonacci(n - 2);
			memo.put(n, value); // メモに保存
			return value;
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 40;
		System.out.println(n + " 番目のフィボナッチ数: " + fibonacci(n));
	}
}
