package com.example.app.utils.tree;

/**
 * AVLツリー
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class AVLTree {

	/**
	 * AVL木は、各ノードに高さのバランス情報を持たせることで、 挿入や削除があっても常に高さが制限されたバランスの取れた 二分探索木 (Binary
	 * Search Tree, BST) を維持するデータ構造です。
	 *
	 * これにより、検索、挿入、削除の操作を効率的に行うことが可能になります。
	 * 
	 * [AVL木の特徴] - AVL木は、バランスされた二分探索木の一種です。 - 任意のノードに対して、その左部分木と右部分木の高さの差（バランス係数）が
	 * -1、0、1 のいずれかであることを常に維持します。 - 挿入・削除のたびにバランスを調整し、木の高さが O(log n)
	 * に抑えられるため、検索や挿入の操作が効率的に行われます。
	 *
	 * [計算量] - 挿入、削除、検索の各操作において、AVLツリーは木の高さを平衡に保つため、すべての操作がO(log n) で行われます。 -
	 * 挿入や削除の際に平衡を保つために回転操作（単回転または二重回転）が必要ですが、それでも計算量は O(log n) に保たれます。
	 *
	 * [AVLツリーを採用する場面] - 動的なデータセットでの検索・挿入・削除 -
	 * 何度も挿入・削除を繰り返しながら、動的に変化するデータセットに対して効率的に検索を行いたい場合
	 *
	 * - 要素の順序を保ちながらのデータ管理 - 要素を順序に従って管理しながら、頻繁に挿入や削除を行う必要がある場合
	 *
	 * - レンジクエリの実行 - 特定の範囲内にある要素を効率的に検索する必要がある場合
	 *
	 * - 最小・最大の要素の取得 - 動的に追加・削除されるデータセットから、最小値や最大値を効率的に取得したい場合
	 *
	 * - データの順位を求める問題 - 動的に追加・削除されるデータの中で、特定の要素の順位（ソートされた順番での位置）を求める。
	 *
	 * - オンラインデータ管理（Online Median Finding） - データが順次与えられ、その都度現在の中央値を求める必要がある場合
	 */

	/**
	 * ノードクラス
	 */
	class Node {
		int key, height;
		Node left, right;

		Node(int d) {
			key = d;
			height = 1;
		}
	}

	/**
	 * 最上部
	 */
	private Node root;

	/**
	 * ノードの高さを取得
	 * 
	 * @param N
	 * @return 結果
	 */
	int height(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}

	/**
	 * 最大値を取得
	 * 
	 * @param a
	 * @param b
	 * @return 結果
	 */
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * 右回転
	 * 
	 * @param y
	 * @return 結果
	 */
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// 回転の実行
		x.right = y;
		y.left = T2;

		// 高さの更新
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// 新しいルートを返す
		return x;
	}

	/**
	 * 左回転
	 * 
	 * @param x
	 * @return 結果
	 */
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// 回転の実行
		y.left = x;
		x.right = T2;

		// 高さの更新
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// 新しいルートを返す
		return y;
	}

	/**
	 * バランス係数を取得
	 * 
	 * @param N
	 * @return 結果
	 */
	int getBalance(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	/**
	 * ノードの挿入
	 * 
	 * @param node
	 * @param key
	 * @return 結果
	 */
	Node insert(Node node, int key) {
		// 通常の二分探索木の挿入
		if (node == null)
			return (new Node(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else // 同じキーは許可しない
			return node;

		// 高さの更新
		node.height = 1 + max(height(node.left), height(node.right));

		// バランス係数の計算
		int balance = getBalance(node);

		// 4つのケースに対処

		// 左左ケース
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// 右右ケース
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// 左右ケース
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// 右左ケース
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		// バランスされたノードを返す
		return node;
	}

	/**
	 * 中順走査でツリーを表示
	 * 
	 * @param node
	 */
	void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		// ノードの挿入
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		// 中順走査でツリーを表示
		System.out.print("中順走査結果: ");
		tree.inorder(tree.root);
	}
}
