package com.example.app.utils.array;

import java.util.Arrays;

/**
 * ツーポインタ法クラス
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class TwoPointer {

	/**
	 * [ツーポインタ法 (Two Pointer Technique)]
	 *
	 * ツーポインタ法は、2つのポインタ（インデックス）を使って配列の要素を効率的に操作する手法です。
	 * 通常、ポインタは同時に動かされることで、特定の条件に応じた部分配列や要素の組み合わせを探します。
	 *
	 * [ツーポインタ法の特徴] - 主にソートされた配列や文字列での問題を解決するために使用されます。 -
	 * ポインタを両端（先頭と末尾）に配置し、条件に応じてポインタを内側に動かしていきます。 - この方法は、通常 O(n)
	 * の時間計算量で、効率的に問題を解決できます。
	 *
	 * [例] - 特定の合計を持つ2つの要素を探す問題 (Two Sum) -
	 * ソートされた配列が与えられ、その中から合計が指定されたターゲット値になる2つの要素を探す。
	 * 
	 * - 有効な回文の判定 (Palindrome Check) - 文字列が回文かどうかを判定する問題
	 *
	 * - 合計が一定以下の最長部分配列 (Subarray Sum) - 配列内の要素の合計がターゲット値以下になる最長の部分配列を見つける。
	 *
	 * - 2つのソートされた配列のマージ (Merge Two Sorted Arrays) - 2つのソートされた配列を1つのソートされた配列にマージする。
	 *
	 * - 合計がゼロになる三つの数を探す (3Sum Problem) -
	 * ソートされていない整数配列が与えられ、その中で合計が0になるような3つの数の組み合わせを探す。
	 *
	 * - 重複を避けた特定の要素のペアの探索 (Two Pointer for Unique Pairs) -
	 * ソートされた配列内から、重複しないように特定の合計を持つペアを全て見つける。
	 *
	 * - 2つの文字列の最長共通部分 (Longest Common Substring) -
	 * 2つの文字列が与えられ、それらの中から最長の共通部分を見つける問題。
	 */

	/**
	 * 2つのポインタを使用して問題を解くメソッド 例として、ソート済み配列内で指定されたターゲット値を持つペアを見つける
	 * 
	 * @param nums
	 * @param target
	 * @return ペアのインデックス
	 */
	public int[] findPairWithTargetSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				return new int[] { left, right };
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return new int[] { -1, -1 }; // 見つからない場合
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TwoPointer twoPointer = new TwoPointer();
		int[] nums = { 1, 2, 3, 4, 6 };
		int target = 8;
		int[] result = twoPointer.findPairWithTargetSum(nums, target);
		System.out.println("ペアのインデックス: " + Arrays.toString(result));
	}
}
