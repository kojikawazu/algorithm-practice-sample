package com.example.app.utils.tree;

import com.example.app.entity.TreeNode;

/**
 * バイナリツリー(二分探索木)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class BinaryTreeOperations {

	/**
	 * バイナリツリーは、各ノードが最大2つの子ノードを持つ木構造です。 このコードは、挿入・検索・中順走査を行う機能を備えたシンプルな二分探索木 (Binary
	 * Search Tree, BST) です。
	 * 
	 * [二分探索木 (Binary Search Tree, BST) の特徴] - 各ノードには最大2つの子ノードがあります: 左の子と右の子。 -
	 * 左部分木にある全てのノードは、親ノードの値より小さく、右部分木にある全てのノードは親ノードの値より大きいです。 -
	 * この構造により、検索、挿入、削除が効率的に行えるようになっています。
	 *
	 * [コードの全体の概要] このクラス BinaryTreeOperations では、ノードを挿入したり、特定の値を検索したり、
	 * 木の内容を中順走査で表示したりする機能を持っています。
	 *
	 * [計算量] - 平均計算量: バランスが取れている場合、挿入・削除・検索の操作は いずれも O(log n)
	 * で行えます。これは木の高さに依存しており、データが均等に分布していれば効率的です。 - 最悪計算量: バランスが崩れると、木が一方に偏る（すべてのノードが
	 * 一方向に連なる形になる）場合があります。この場合、木の高さはノード数に等しくなり、計算量は O(n) となります。
	 *
	 * [二分探索木を採用する場面] - 動的に追加されるデータセットでの検索、挿入、削除 -
	 * 何度も挿入・削除を繰り返しながら、動的に変化するデータセットに対して効率的に検索を行いたい場合
	 *
	 * - ソートされた順序での要素の列挙（Inorder Traversal） - データをソートされた順序で出力する必要がある場合
	 *
	 * - 範囲内の値を効率的に検索（Range Search） - 二分探索木の中から、特定の範囲 [L, R] にある値を見つけたい。
	 *
	 * - 前後の要素の取得（Predecessor and Successor） -
	 * 二分探索木の中で、特定の値に対する**前の要素（前任者）と後の要素（後任者）**を取得する。
	 *
	 * - K番目に小さいまたは大きい要素の取得（K-th Smallest/Largest Element） -
	 * 二分探索木から、K番目に小さい（または大きい）要素を求める。
	 *
	 * - データのランクを求める（Rank Query） - 二分探索木内の特定の要素がソート順で何番目にあるかを求める。
	 *
	 * - 最小値・最大値の取得 - 二分探索木の中から最小値または最大値を求める。
	 */

	/**
	 * ルートノード
	 */
	TreeNode root;

	/**
	 * ノードの挿入
	 * 
	 * @param data
	 */
	public void insert(int data) {
		root = insertRec(root, data);
	}

	/**
	 * 再帰的な挿入メソッド
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private TreeNode insertRec(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}
		if (data < root.getData())
			root.setLeft(insertRec(root.getLeft(), data));
		else if (data > root.getData())
			root.setRight(insertRec(root.getRight(), data));
		return root;
	}

	/**
	 * 検索
	 * 
	 * @param data
	 * @return
	 */
	public boolean search(int data) {
		return searchRec(root, data);
	}

	/**
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private boolean searchRec(TreeNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		if (data < root.getData())
			return searchRec(root.getLeft(), data);
		else
			return searchRec(root.getRight(), data);
	}

	/**
	 * 中順（Inorder）走査
	 */
	public void inorder() {
		inorderRec(root);
		System.out.println();
	}

	/**
	 * 
	 * @param root
	 */
	private void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderRec(root.getRight());
		}
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeOperations tree = new BinaryTreeOperations();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);

		System.out.print("中順走査: ");
		tree.inorder();

		System.out.println("検索（値40）: " + tree.search(40));
		System.out.println("検索（値25）: " + tree.search(25));
	}
}
