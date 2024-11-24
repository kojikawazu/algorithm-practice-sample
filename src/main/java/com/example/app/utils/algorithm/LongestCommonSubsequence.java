package com.example.app.utils.algorithm;

/**
 * 最長共通部分列 （Longest Common Subsequence, LCS）
 *
 * @since 2024/11/24
 * @author koji kawazu
 */
public class LongestCommonSubsequence {

	/**
	 * 「最長共通部分列（Longest Common Subsequence, LCS）」問題を 動的計画法（Dynamic
	 * Programming）を使って解決するプログラムです。
	 *
	 * LCS問題は、2つの文字列のうち、両方に含まれる最も長い共通部分列の長さを求める問題です。
	 * 例えば、DNA配列の比較やテキスト編集の差分を計算する際などに利用される重要なアルゴリズムです。
	 *
	 * [最長共通部分列 (LCS) の概要] - **最長共通部分列（LCS）**は、2つの文字列 X と Y の中で共通する部分列のうち、
	 * 最も長いものの長さを求める問題です。
	 *
	 * - 部分列とは、文字列から一部の文字を順序を保ったまま取り出したものを指し、必ずしも連続している必要はありません。
	 *
	 * - LCS問題の例: - X = "AGGTAB" と Y = "GXTXAYB" の場合、最長共通部分列は "GTAB" で、その長さは 4 です。
	 */

	/**
	 * 2つの文字列 X と Y の最長共通部分列の長さを求める
	 * 
	 * @param X
	 * @param Y
	 * @return 最長共通部分列の長さ
	 */
	public static int lcs(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] L = new int[m + 1][n + 1];

		// DPテーブルの構築
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// LCSの長さを返す
		return L[m][n];
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		System.out.println("最長共通部分列の長さ: " + lcs(X, Y));
	}
}
