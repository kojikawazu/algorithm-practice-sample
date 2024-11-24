package com.example.app.utils.array;

import com.example.app.entity.Node;

/**
 * キュー
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class QueueOperations {

	/**
	 * [計算量] - 挿入と削除が効率的（O(1)）ですが、ランダムなアクセスや検索は効率的ではありません（O(n)）
	 *
	 * [キューを採用する場面]
	 *
	 * - 幅優先探索（BFS）を使った問題 - 迷路の最短経路を求める、グラフ内で2つのノード間の最短距離を求めるなど
	 *
	 * - トポロジカルソート - 依存関係を持つタスクを順番に処理する、例えばプロジェクトのタスクを完了するための順序を求めるなど
	 *
	 * - スライディングウィンドウの最大値の問題 - 配列が与えられたとき、サイズ k
	 * のウィンドウを配列上で右にスライドさせながら、各ウィンドウ内の最大値を求める
	 *
	 * - タスクスケジューリングとローテーション問題 -
	 * いくつかのタスクがリソースの制限に従って順番に処理されるような問題、例えばラウンドロビン方式でのタスクの実行
	 *
	 * - 腐ったオレンジ問題（Rotting Oranges） - グリッド（2次元配列）に新鮮なオレンジと腐ったオレンジが配置されています。
	 * 腐ったオレンジは隣接する新鮮なオレンジを1分ごとに腐らせます。すべてのオレンジが腐るのにかかる最短時間を求める。
	 *
	 * - 接続されている島の数を数える問題 - 2次元の地図（0と1で構成）で、1が陸地を示し、0が水を示します。接続されている陸地の数（島の数）を数える。
	 *
	 * - 最短距離を求める問題 - 無向グラフや2次元グリッドが与えられ、スタート地点からゴール地点までの最短距離を求める。
	 */

	/**
	 * キューのフロントとリア
	 */
	Node front, rear;

	/**
	 * エンキュー操作
	 * 
	 * @param data
	 */
	public void enqueue(int data) {
		Node node = new Node(data);

		if (rear != null) {
			rear.setNext(node);
		}

		rear = node;
		if (front == null) {
			front = rear;
		}
	}

	/**
	 * デキュー操作
	 * 
	 * @return
	 */
	public int dequeue() {
		if (front == null)
			throw new RuntimeException("キューが空です");

		int data = front.getData();
		front = front.getNext();
		if (front == null) {
			rear = null;
		}

		return data;
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		QueueOperations queue = new QueueOperations();

		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);

		System.out.println("デキュー: " + queue.dequeue());
		System.out.println("デキュー: " + queue.dequeue());
	}
}
