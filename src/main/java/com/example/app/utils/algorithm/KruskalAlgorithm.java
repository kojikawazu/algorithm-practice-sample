package com.example.app.utils.algorithm;

import java.util.Arrays;

/**
 * クラスカル法 （Kruskal's Algorithm）
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class KruskalAlgorithm {

	/**
	 * グラフの最小全域木（Minimum Spanning Tree, MST）を求めるもの。
	 * 
	 * クラスカル法は、グラフのすべての頂点を含みつつ、合計の辺の重みが最小になるような木構造（MST）を構築するためのアルゴリズムです。
	 * 最小全域木の構築は、ネットワークの配線や交通路の構築など、コストを最小化する問題に応用できます。
	 *
	 * [クラスカル法の基本] - クラスカル法は、すべての辺を重み順にソートし、軽い順に辺を選んでいき、
	 * サイクルを作らないように注意しながら最小全域木を構築するアルゴリズムです。
	 *
	 * - Union-Findを使って、サイクルの検出と異なる集合を結合する処理を行います。
	 *
	 * - このアルゴリズムの計算量は O(E log E) であり、E は辺の数です。 辺のソートに時間がかかりますが、効率的に最小全域木を構築できます。
	 *
	 * [クラスカル法を採用する場面] - 最小全域木の構築問題 - グラフの全てのノードをカバーする最小コストの全域木を構築する問題
	 *
	 * - インフラストラクチャのコスト最小化 - 都市を繋ぐ道路、通信ネットワーク、パイプラインなどの構築において、全ての拠点を最小のコストで繋ぐ問題
	 *
	 * - 分割統治が得意な場面 - **エッジ数が少ない（スパースなグラフ）**場合
	 *
	 * - 無向グラフの最小接続 - 無向グラフにおける最小全域木を構築するのに非常に適している
	 */

	/**
	 * Edge
	 */
	static class Edge implements Comparable<Edge> {
		int src, dest, weight;

		/**
		 * コンストラクタ
		 * 
		 * @param s
		 * @param d
		 * @param w
		 */
		Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}

		/**
		 * 比較
		 */
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}

	/**
	 * サブセット
	 */
	static class Subset {
		int parent, rank;
	}

	int vertices, edges;
	Edge[] edgeList;

	/**
	 * コンストラクタ
	 * 
	 * @param v
	 * @param e
	 */
	KruskalAlgorithm(int v, int e) {
		vertices = v;
		edges = e;
		edgeList = new Edge[e];
		for (int i = 0; i < e; ++i)
			edgeList[i] = new Edge(0, 0, 0);
	}

	/**
	 * 探索
	 * 
	 * @param subsets
	 * @param i
	 * @return
	 */
	int find(Subset[] subsets, int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	/**
	 * 2つの集合を結合
	 * 
	 * @param subsets
	 * @param x
	 * @param y
	 */
	void union(Subset[] subsets, int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	/**
	 * クラスカル法を使って最小全域木を構築
	 */
	void kruskalMST() {
		Edge[] result = new Edge[vertices];
		int e = 0; // 結果のエッジ数
		int i = 0; // ソートされたエッジのインデックス

		Arrays.sort(edgeList);

		Subset[] subsets = new Subset[vertices];
		for (i = 0; i < vertices; ++i) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		i = 0;

		while (e < vertices - 1) {
			Edge nextEdge = edgeList[i++];
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);

			if (x != y) {
				result[e++] = nextEdge;
				union(subsets, x, y);
			}
		}

		// 結果の表示
		System.out.println("構築された最小全域木:");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int V = 4; // 頂点数
		int E = 5; // エッジ数
		KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

		// エッジの追加
		graph.edgeList[0] = new Edge(0, 1, 10);
		graph.edgeList[1] = new Edge(0, 2, 6);
		graph.edgeList[2] = new Edge(0, 3, 5);
		graph.edgeList[3] = new Edge(1, 3, 15);
		graph.edgeList[4] = new Edge(2, 3, 4);

		graph.kruskalMST();
	}
}
