package com.example.app.utils.factorial;

/**
 * フィボナッチ数列 [再帰の例]
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class FibonacciExample {

	/**
	 * フィボナッチ数列を再帰を用いて計算する。
	 *
	 * 再帰は、関数が自分自身を呼び出す手法。 問題を小さな部分問題に分割することで解を得る方法です。
	 *
	 * [フィボナッチ数列の概要] フィボナッチ数列は、0から始まり、次の数が前の2つの数の和である数列です。 数列の最初の数は次のようになります： 0, 1,
	 * 1, 2, 3, 5, 8, 13, 21, 34, ...
	 *
	 * 一般的に、n 番目のフィボナッチ数は次のように定義されます： F(0) = 0 F(1) = 1 F(n) = F(n-1) + F(n-2) （n >=
	 * 2）
	 *
	 */

	/**
	 * フィボナッチ数列
	 * 
	 * @param n
	 * @return 結果
	 */
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n; // 基本ケース
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2); // 再帰呼び出し
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		System.out.print("フィボナッチ数列（" + n + "項目まで）: ");
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}
}
