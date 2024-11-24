package com.example.app.utils.array;

import java.util.EmptyStackException;

import com.example.app.entity.Node;

/**
 * スタック
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class StackOperations {

	/**
	 * [計算量] - 挿入と削除が効率的（O(1)）ですが、特定の要素の検索やアクセスは効率的ではありません（O(n)）。
	 *
	 * [スタックに採用する場面]
	 *
	 * スタックの「後入れ先出し（LIFO）」という特性をうまく活かすことで、 計算を効率化したり、データの順序を正しく管理したりすることが可能です。
	 *
	 * - 括弧のバランス確認（Valid Parentheses） - 与えられた文字列が、開き括弧と閉じ括弧のペアが正しく対応しているかどうかを判定する。
	 *
	 * - 逆ポーランド記法の評価（Evaluate Reverse Polish Notation） -
	 * 逆ポーランド記法（RPN）で与えられた計算式を評価し、その結果を返す。
	 *
	 * - 整数の最大・最小を追跡するスタック（Min Stack / Max Stack） - 通常のスタック操作（プッシュ、ポップ）に加えて、
	 * 現在のスタック内の最小値または最大値を常に O(1) で取得できるスタックを実装する。
	 *
	 * - DFS（深さ優先探索） - グラフやツリーを深さ優先で探索し、特定のノードを探す、または各ノードを処理する。
	 *
	 * - 式の評価（Infix Expression Evaluation） - 通常の中置記法（例えば 3 + 5 * (2 -
	 * 8)）で与えられた式を評価する。
	 *
	 * - 次の大きい要素（Next Greater Element） - 配列内の各要素に対して、その右側にある次に大きい要素を見つける問題。
	 *
	 * - ヒストグラムの最大面積（Largest Rectangle in Histogram） -
	 * ヒストグラムが与えられたとき、その中で形成される最大の長方形の面積を求める。
	 *
	 * - 木のパスの探索（Binary Tree Paths） - 二分木において、ルートから葉に至るすべてのパスを求める。
	 *
	 */

	/**
	 * スタックのトップ
	 */
	Node top;

	/**
	 * プッシュ操作
	 * 
	 * @param data
	 */
	public void push(int data) {
		Node node = new Node(data);
		node.setNext(top);
		top = node;
	}

	/**
	 * ポップ操作
	 * 
	 * @return
	 */
	public int pop() {
		if (top == null)
			throw new EmptyStackException();
		int data = top.getData();
		top = top.getNext();
		return data;
	}

	/**
	 * ピーク操作
	 * 
	 * @return
	 */
	public int peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.getData();
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StackOperations stack = new StackOperations();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("ピーク: " + stack.peek());
		System.out.println("ポップ: " + stack.pop());
		System.out.println("ポップ: " + stack.pop());
	}
}
