package com.example.app.utils.hash;

import java.util.PriorityQueue;

/**
 * 最小ヒープクラス
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class MinHeapExample {

	/**
	 * [計算量] - 挿入と削除の計算量はどちらも O(log n)。最小値の取得は O(1)。
	 *
	 * [最小ヒープを採用する場面] - K番目に小さい要素を見つける問題（Kth Smallest Element） - 配列から K
	 * 番目に小さい要素を見つける。
	 *
	 * - K個のソート済みリストをマージする（Merge K Sorted Lists） - K
	 * 個のソート済みリストが与えられたとき、それらを1つのソート済みリストにマージする。
	 *
	 * - スライディングウィンドウの最大値または最小値の問題（Sliding Window Minimum/Maximum） - 配列が与えられ、長さ K
	 * のスライディングウィンドウで各位置の最小値または最大値を求める。
	 *
	 * - ミーティングルームの割り当て（Meeting Rooms II） -
	 * 会議のスケジュール（開始時間と終了時間）が与えられたとき、同時に開催される会議の最小数を求める（会議室の数を最小化する）。
	 *
	 * - 配列のK個の最大/最小要素を求める問題（Top K Elements） - 配列から K 個の最も大きい（または小さい）要素を見つける。
	 *
	 * - ストリームからK番目に大きい要素を見つける（Kth Largest Element in a Stream） -
	 * 数字がストリームで順次与えられていき、その時点で K 番目に大きい要素を常に維持したい。
	 *
	 * - 最短経路問題（Dijkstra アルゴリズム） - グラフが与えられ、始点から各頂点への最短距離を求める。
	 */

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 最小ヒープの作成
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// 要素の追加
		minHeap.add(5);
		minHeap.add(2);
		minHeap.add(8);
		minHeap.add(1);

		// ヒープから要素を取り出す
		while (!minHeap.isEmpty()) {
			int min = minHeap.poll();
			System.out.println("取り出した最小値: " + min);
		}
	}
}
