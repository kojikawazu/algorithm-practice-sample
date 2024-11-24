package com.example.app.utils.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * ハッシュマップ
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class HashMapExample {

	/**
	 * [計算量] - 検索、挿入、削除の操作は平均的には非常に高速で、計算量は O(1) になります。 ただし、最悪のケースでは計算量が O(n)
	 * になることもあります。 - ハッシュ関数の衝突（Collision） - 再ハッシュ（Rehashing）
	 *
	 * [ハッシュマップを採用する場面]
	 *
	 * - 要素の出現回数をカウントする問題 - 配列内の各要素が何回出現しているかを求める。
	 *
	 * - 2数の合計が特定の値になるか（Two Sum） - 配列内の2つの要素の合計が特定のターゲット値になるかどうかを判定する問題。
	 *
	 * - アナグラムの判定（Anagram Check） - 2つの文字列がアナグラムであるかを判定する。
	 *
	 * - 最長の部分文字列（Longest Substring Without Repeating Characters） -
	 * 重複しない文字からなる最長の部分文字列の長さを求める。
	 *
	 * - キーがユニークかどうかを確認する（Unique Key Check） - 与えられたリスト内で、キーがユニークであるかどうかを判定する問題。
	 *
	 * - 2つの配列の共通部分を求める（Intersection of Two Arrays） - 2つの配列の共通する要素をすべて求める。
	 *
	 * - サブアレイの合計が0かどうか（Subarray Sum Equals Zero） - 配列の連続する部分配列の合計がゼロであるかどうかを判定する。
	 *
	 * - 最長の連続するシーケンス（Longest Consecutive Sequence） -
	 * 配列内の最長の連続する数のシーケンスを見つけ、その長さを返す。
	 */

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ハッシュマップの作成
		HashMap<String, Integer> map = new HashMap<>();

		// 要素の追加
		map.put("apple", 100);
		map.put("banana", 80);
		map.put("orange", 90);

		// 要素の取得
		int price = map.get("banana");
		System.out.println("bananaの価格: " + price);

		// 要素の削除
		map.remove("orange");

		// キーの存在確認
		boolean hasApple = map.containsKey("apple");
		System.out.println("appleは存在するか: " + hasApple);

		// マップの走査
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " の価格は " + entry.getValue());
		}
	}
}
