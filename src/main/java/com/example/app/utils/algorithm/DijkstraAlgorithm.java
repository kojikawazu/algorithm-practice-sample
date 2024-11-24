package com.example.app.utils.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ダイクストラ法
 *
 * @since 2024/11/24
 * @author koji kawazu
 */
public class DijkstraAlgorithm {

	/**
	 * 特定の始点からグラフ内の各頂点への最短距離を求めるものです。
	 * ダイクストラ法は、重み付きグラフで始点から各頂点への最短経路を見つけるために使用されるアルゴリズムで、 主に正の重みを持つ辺に対して効率的に動作します。
	 *
	 * [計算量] - ダイクストラ法はノードをすべて訪問する必要があるため、基本的な探索部分の計算量は**O(V)** -
	 * 各ノードに対して、すべてのエッジを探索して距離の更新を行う必要があり、その操作にかかる計算量は**O(E)** -
	 * ヒープ（優先度付きキュー）を使う場合、**ヒープ操作（挿入・削除）の計算量がO(log V)であるため、全体でO((V + E) log V)**
	 *
	 * [ダイクストラ法を採用する例] - 最短経路を求める問題: - 例えば、ある都市から別の都市への最短移動時間を求める問題、
	 * 特定の地点から他のすべての地点への移動コストを最小化する問題など、 ノード間の距離やコストを最小化するタイプの問題で使用されます。
	 *
	 * - 到達可能性とコスト: - 配送ルートや燃料消費の最適化のような問題で、どのルートが最も安価で効率的かを計算する際に、
	 * コストの重みがついたグラフが与えられる場合です。
	 *
	 * - 単一始点最短経路（Single-Source Shortest Path）: -
	 * 「「特定のノードから他のノードへの最短経路を求めよ」という形式で出題されることが多く、 これはダイクストラ法の典型的な適用場面です。
	 */

	/**
	 * Edgeクラス
	 */
	static class Edge {
		int target;
		int weight;

		Edge(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}

	/**
	 * ダイクストラ法のアルゴリズム
	 *
	 * @param graph
	 * @param source
	 */
	public static void dijkstra(List<List<Edge>> graph, int source) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		pq.offer(new Edge(source, 0));

		// 算出
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int u = current.target;

			for (Edge neighbor : graph.get(u)) {
				int v = neighbor.target;
				int weight = neighbor.weight;
				if (dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pq.offer(new Edge(v, dist[v]));
				}
			}
		}

		// 結果の表示
		System.out.println("頂点 " + source + " から各頂点への最短距離:");
		for (int i = 0; i < n; i++) {
			System.out.println("頂点 " + i + " への距離: " + dist[i]);
		}
	}

	/**
	 * main関数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5; // 頂点の数
		List<List<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// グラフの定義
		// 頂点0から頂点1への距離は10
		graph.get(0).add(new Edge(1, 10));
		graph.get(0).add(new Edge(4, 5));
		graph.get(1).add(new Edge(2, 1));
		graph.get(1).add(new Edge(4, 2));
		graph.get(2).add(new Edge(3, 4));
		graph.get(3).add(new Edge(2, 6));
		graph.get(3).add(new Edge(0, 7));
		graph.get(4).add(new Edge(1, 3));
		graph.get(4).add(new Edge(2, 9));
		graph.get(4).add(new Edge(3, 2));

		// 頂点0から全ての最短距離
		dijkstra(graph, 0);
	}
}
