package com.example.app.utils.search;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 深さ優先探索 (DFS)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class DepthFirstSearch {

	/**
	 * グラフや木のすべてのノードを探索するための再帰的またはスタックを用いた探索手法。
	 *
	 * [計算量] - V はグラフのノード数（頂点数）、E は辺の数です。 -
	 * DFSは各ノードを一度訪問し、各辺も一度訪れるため、計算量はノード数と辺の数の和に比例します。 - ツリーの場合は、ノードの数 N に対して計算量は
	 * O(N) です。
	 *
	 * [DFSで採用する場面] - グラフ内の連結成分の探索（Connected Components） -
	 * グラフが与えられたとき、連結成分（繋がった部分）をすべて探索し、それぞれを識別する必要がある。
	 *
	 * - 迷路やパズルの解法（Maze Solving or Path Finding） -
	 * 迷路内でスタート地点からゴール地点までのパスを見つける必要がある場合。
	 *
	 * - 全探索（Combination/Permutation Search） -
	 * 配列や文字列のすべての**順列（Permutation）や組み合わせ（Combination）**を生成する。
	 *
	 * - 木のパス探索（Tree Path Finding） - 二分木や一般の木で、特定の条件を満たすパスを見つけたい場合。
	 *
	 * - サイクル検出（Cycle Detection in Graphs） - グラフが与えられたとき、その中にサイクル（閉路）が存在するかどうかを確認する。
	 *
	 * - 全ての経路を見つける（All Paths from Source to Target） -
	 * 有向グラフで、スタートノードからターゲットノードまでのすべての経路を見つける。
	 *
	 * - バックトラッキングを伴う探索（Sudoku SolverやN-Queenなど） -
	 * N-Queen問題や**数独（Sudoku）**の解を見つけるために、 部分的に解を進め、行き詰まったら戻って別の可能性を試す必要がある場合。
	 */

	private LinkedList<Integer>[] adjLists;
	private boolean[] visited;

	/**
	 * コンストラクタ
	 * 
	 * @param vertices
	 */
	public DepthFirstSearch(int vertices) {
		adjLists = new LinkedList[vertices];
		visited = new boolean[vertices];

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
	 * 深さ優先探索（DFS）
	 * 
	 * @param vertex
	 */
	void DFS(int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");

		Iterator<Integer> ite = adjLists[vertex].listIterator();
		while (ite.hasNext()) {
			int adj = ite.next();
			if (!visited[adj])
				DFS(adj);
		}
	}

	/**
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		DepthFirstSearch g = new DepthFirstSearch(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.print("深さ優先探索（DFS）: ");
		g.DFS(2);
	}
}
