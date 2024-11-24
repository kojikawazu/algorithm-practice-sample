package com.example.app.utils.factorial;

import java.util.PriorityQueue;

/**
 * 0-1ナップサック問題 （Branch and Boundによる解法）
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class KnapsackBranchAndBound {

	/**
	 * 0-1ナップサック問題は、限られた容量のナップサックに対して価値の最大化を目的にアイテムを選ぶ問題です。
	 *
	 * Branch and Bound法を使うことで、探索空間を効率的に探索し、不要な計算を避けることで解を求める手法です。
	 * このアルゴリズムでは、木構造を利用して問題を部分問題に分割しながら解を探します。
	 *
	 * [コードの全体概要] - アイテムクラス (Item) と ノードクラス (Node) を定義して、ナップサックの中に入れるアイテムの情報と、
	 * 探索空間のノードを表現します。 - 優先度付きキュー (PriorityQueue) を使って、分枝を管理し、価値の最大化を目指します。
	 */

	/**
	 * アイテムクラス
	 */
	static class Item {
		int weight;
		int value;
		double ratio;

		/**
		 * コンストラクタ
		 * 
		 * @param w
		 * @param v
		 */
		Item(int w, int v) {
			weight = w;
			value = v;
			ratio = (double) v / w;
		}
	}

	/**
	 * ノードクラス
	 */
	static class Node implements Comparable<Node> {
		int level;
		int profit;
		int weight;
		double bound;

		/**
		 * コンストラクタ
		 * 
		 * @param l
		 * @param p
		 * @param w
		 * @param b
		 */
		Node(int l, int p, int w, double b) {
			level = l;
			profit = p;
			weight = w;
			bound = b;
		}

		/**
		 * 比較
		 * 
		 * @param other
		 * @return 結果
		 */
		public int compareTo(Node other) {
			return Double.compare(other.bound, this.bound);
		}
	}

	/**
	 * 与えられたノードの見込み価値の上限を計算する関数
	 * 
	 * @param u
	 * @param n
	 * @param W
	 * @param items
	 * @return
	 */
	public static double bound(Node u, int n, int W, Item[] items) {
		if (u.weight >= W)
			return 0;

		double profit_bound = u.profit;
		int j = u.level + 1;
		int totweight = u.weight;

		while (j < n && totweight + items[j].weight <= W) {
			totweight += items[j].weight;
			profit_bound += items[j].value;
			j++;
		}

		if (j < n)
			profit_bound += (W - totweight) * items[j].ratio;

		return profit_bound;
	}

	/**
	 * 0-1ナップサック問題を分枝限定法で解くメインの関数
	 * 
	 * @param W
	 * @param items
	 * @param n
	 * @return
	 */
	public static int knapsack(int W, Item[] items, int n) {
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Node u, v;
		u = new Node(-1, 0, 0, 0.0);
		u.bound = bound(u, n, W, items);
		Q.add(u);
		int maxProfit = 0;

		while (!Q.isEmpty()) {
			u = Q.poll();

			if (u.bound > maxProfit) {
				v = new Node(u.level + 1, u.profit, u.weight, 0.0);

				// 左の子（アイテムを選ぶ）
				v.weight += items[v.level].weight;
				v.profit += items[v.level].value;

				if (v.weight <= W && v.profit > maxProfit)
					maxProfit = v.profit;

				v.bound = bound(v, n, W, items);

				if (v.bound > maxProfit)
					Q.add(v);

				// 右の子（アイテムを選ばない）
				v = new Node(u.level + 1, u.profit, u.weight, 0.0);
				v.bound = bound(v, n, W, items);

				if (v.bound > maxProfit)
					Q.add(v);
			}
		}
		return maxProfit;
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] profits = { 40, 35, 18, 4, 10, 2 };
		int[] weights = { 10, 9, 5, 2, 3, 1 };
		int W = 16;
		int n = profits.length;

		Item[] items = new Item[n];
		for (int i = 0; i < n; i++)
			items[i] = new Item(weights[i], profits[i]);

		// 価値重量比でソート
		java.util.Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

		int maxProfit = knapsack(W, items, n);
		System.out.println("最大価値: " + maxProfit);
	}
}
