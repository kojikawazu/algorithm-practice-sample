package com.example.app.utils.algorithm;

/**
 * KMP法 (Knunth-Morris-Pratt)
 *
 * @since 2024/11/24
 * @author koji kawazu
 */
public class KMPAlgorithm {

	/**
	 * KMP（Knuth-Morris-Pratt）文字列検索アルゴリズム
	 *
	 * KMPアルゴリズムは、効率的に部分文字列を検索するための手法であり、 特にパターンの重複部分を利用して検索を効率化しています。
	 * [KMPアルゴリズムの基本] - KMPアルゴリズムは、部分一致を利用して効率的に文字列中のパターンを見つけるアルゴリズムです。 -
	 * パターンをテキストに一致させながら、一致しない部分が見つかったときに前の情報を活用することで、 一度比較した部分を再度比較せずに済むようにしています。 -
	 * このアルゴリズムは、2つの主要なステップから成り立っています。 - 部分一致テーブル（lps 配列）の構築。 - テキスト中でパターンを検索する。
	 *
	 * [KMPアルゴリズムを採用する場面] - 部分文字列の検索 -
	 * 典型的な「部分文字列検索」問題において、特定のパターンが与えられたテキストに何度現れるかを調べる場合
	 *
	 * - パターンマッチング問題 - 文字列の中で、あるパターンが存在する位置を求める問題
	 *
	 * - 連続するパターンの検出 - 特定の部分文字列がテキスト内に繰り返し登場する場合の位置や頻度を求める問題
	 *
	 * - DNA配列のマッチングやテキスト分析 - DNA配列のような特殊な文字列内でパターンを見つける問題 -
	 * テキストから特定のキーワードの位置を見つける問題
	 *
	 * - 複数の部分一致検索 - 複数の部分一致の検索が必要な問題 - KMPのLPS（Longest Prefix which is also
	 * Suffix）配列
	 */

	/**
	 * パターン文字列（pat）をテキスト文字列（txt）の中から探す
	 * 
	 * @param pat
	 * @param txt
	 */
	public static void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		// 部分一致テーブルを構築
		int[] lps = new int[M];
		computeLPSArray(pat, M, lps);

		int i = 0; // txtのインデックス
		int j = 0; // patのインデックス
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}
			if (j == M) {
				System.out.println("パターンがインデックス " + (i - j) + " で見つかりました。");
				j = lps[j - 1];
			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

	/**
	 * 部分一致テーブルを計算
	 * 
	 * @param pat
	 * @param M
	 * @param lps
	 */
	public static void computeLPSArray(String pat, int M, int[] lps) {
		int len = 0; // 最長の共通接頭辞と接尾辞の長さ
		int i = 1;
		lps[0] = 0; // lps[0]は0

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		KMPSearch(pat, txt);
	}
}
