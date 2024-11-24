package com.example.app.utils.search;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 幅優先探索（Breadth First Search, BFS）
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class BreadthFirstSearch {

	/**
	 * グラフや木のすべてのノードを幅広く探索していく手法
	 *
	 * [計算量] - V はグラフのノード数（頂点数）、E は辺の数です。 -
	 * BFSは各ノードを一度訪問し、各辺も一度だけ訪問するため、計算量はノード数と辺の数に比例します。 - ツリーの探索では、ノードの数 N に対して計算量は
	 * O(N) です。
	 *
	 * [幅優先探索を採用する場面] - 最短経路探索（Shortest Path in Unweighted Graph） -
	 * 無向グラフまたは有向グラフにおいて、始点から終点までの最短経路を求める。
	 *
	 * - 迷路探索（Maze Solver） - 迷路のスタート地点からゴール地点までの最短経路を見つける。
	 *
	 * - 階層ごとの探索（Level Order Traversal in Trees） - 二分木を階層ごとに探索し、各レベルのノードを順に出力する。
	 *
	 * - 最小ステップ数を求める問題（Minimum Steps to Reach Target） -
	 * 棋盤上で、ナイトの駒がスタート位置から目標位置まで移動するのに必要な最小ステップ数を求める。
	 *
	 * - グラフの連結性の確認（Connected Components in a Graph） -
	 * 無向グラフが与えられたとき、そのグラフが連結しているかを確認する。
	 *
	 * - 二部グラフの判定（Bipartite Graph Check） - 無向グラフが二部グラフであるかどうかを確認する。
	 *
	 * - 全ての可能な経路の探索（All Paths in Unweighted Graph） - あるノードから別のノードへのすべてのパスを探索する。
	 */

	private int numVertices;
	private LinkedList<Integer>[] adjLists;

	/**
	 * コンストラクタ
	 * 
	 * @param vertices
	 */
	public BreadthFirstSearch(int vertices) {
		numVertices = vertices;
		adjLists = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++)
			adjLists[i] = new LinkedList<>();
	}

	/**
	 * 辺の追加
	 * 
	 * @param src
	 * @param dest
	 */
	void addEdge(int src, int dest) {
		adjLists[src].add(dest);
		// 無向グラフの場合は以下を追加
		// adjLists[dest].add(src);
	}

	/**
	 * 幅優先探索（BFS）
	 * 
	 * @param startVertex
	 */
	void BFS(int startVertex) {
		boolean[] visited = new boolean[numVertices];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[startVertex] = true;
		queue.add(startVertex);

		while (queue.size() != 0) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");

			Iterator<Integer> ite = adjLists[vertex].listIterator();
			while (ite.hasNext()) {
				int adj = ite.next();
				if (!visited[adj]) {
					visited[adj] = true;
					queue.add(adj);
				}
			}
		}
	}

	/**
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(4);

		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);

		System.out.print("幅優先探索（BFS）: ");
		bfs.BFS(2);
	}
}
