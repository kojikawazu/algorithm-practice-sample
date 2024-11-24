package com.example.app.utils.factorial;

/**
 * 階乗 [再帰の例]
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class FactorialExample {

	/**
	 * 階乗
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		if (n == 0) {
			return 1; // 基本ケース
		} else {
			return n * factorial(n - 1); // 再帰呼び出し
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 5;
		int result = factorial(number);
		System.out.println(number + " の階乗は " + result + " です。");
	}
}
