package com.example.app.utils.search;

/**
 * バイナリサーチ(二分探索)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class BinarySearchExample {

	/**
	 * [計算量] - 計算量を大幅に削減できます（O(log n)）
	 *
	 * [二分探索を採用する場面] - ソート済み配列内での値の検索（Standard Search in Sorted Array） -
	 * ソートされた配列が与えられたとき、特定の値が存在するかどうかを確認する。
	 *
	 * - 境界値の検索（Find the Boundary Index） - ソートされた配列の中で、特定の値が初めてまたは最後に現れる位置を探す。
	 *
	 * - 山のように増減する配列のピーク要素を見つける（Find Peak Element） -
	 * 配列が一度増加し、その後減少する場合（山のような配列）、ピークとなる位置を見つける。
	 *
	 * - 検索挿入位置を求める（Search Insert Position） - ソートされた配列内で、特定の値が挿入されるべき位置を探す。
	 *
	 * - 部分的にソートされた配列からの値の検索（Search in Rotated Sorted Array） -
	 * ソートされた配列が一部回転されたものから、特定の値を見つける。
	 *
	 * - 平方根の近似値を求める（Square Root using Binary Search） - 正の整数の平方根を整数で近似して求める。
	 *
	 * - K番目の最小/最大要素を見つける（Kth Smallest/Largest Element） - ソートされた構造内で、K
	 * 番目に小さいまたは大きい要素を見つける。
	 *
	 * - 最適化問題の最小または最大値を見つける（Optimization Problems） -
	 * 特定の条件を満たす最小値や最大値を見つける問題（例えば、資源を使う最小のコストを求めるなど）
	 */

	/**
	 * バイナリサーチ(二分探索)
	 * 
	 * @param array
	 * @param key
	 * @return 結果
	 */
	public static int binarySearch(int[] array, int key) {
		int left = 0, right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// キーが中央の要素に一致する場合
			if (array[mid] == key) {
				return mid;
			}

			// キーが中央の要素より小さい場合、左部分を探索
			if (array[mid] > key) {
				right = mid - 1;
			}

			// キーが中央の要素より大きい場合、右部分を探索
			else {
				left = mid + 1;
			}
		}

		return -1; // 見つからない場合
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = { 2, 3, 4, 10, 40 };
		int key = 10;
		int index = binarySearch(data, key);
		if (index != -1) {
			System.out.println("値 " + key + " はインデックス " + index + " にあります。");
		} else {
			System.out.println("値 " + key + " は見つかりませんでした。");
		}
	}
}
