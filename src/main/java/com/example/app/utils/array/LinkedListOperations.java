package com.example.app.utils.array;

import com.example.app.entity.Node;

/**
 * リンクドリスト
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class LinkedListOperations {

	/**
	 * [計算量] - 先頭の操作は非常に効率的（O(1)）ですが、末尾の操作やランダムアクセスには向いていません。
	 *
	 * [リンクドリストを採用する場面]
	 *
	 * リンクドリストは、要素の挿入や削除が頻繁に発生する状況や、順次探索が必要な場合に非常に適しています。
	 *
	 * - 要素の挿入・削除の操作に関連する問題 - 与えられたリンクドリストから特定の値を削除する、または特定の位置に要素を挿入する。
	 *
	 * - リストの逆転（Reverse Linked List） - 与えられたリンクドリストを逆順に並べ替える。
	 *
	 * - 中間ノードを見つける（Find Middle Node） - 与えられたリンクドリストの中間に位置するノードを見つけなさい。
	 *
	 * - リンクドリストのサイクル検出（Cycle Detection） - リンクドリストにループが存在するかどうかを検出する。
	 *
	 * - 2つのリンクドリストのマージ（Merge Two Sorted Lists） -
	 * 2つのソート済みリンクドリストを1つのソート済みリンクドリストにマージする。
	 *
	 * - n番目のノードからの削除（Remove N-th Node From End） - 与えられたリンクドリストの後ろから n 番目のノードを削除する。
	 *
	 * - ペア単位での交換（Swap Nodes in Pairs） - リンクドリスト内のノードを2つずつペアで交換する。
	 */

	/**
	 * リンクドリストのヘッド
	 */
	Node head;

	/**
	 * ノードを末尾に追加
	 * 
	 * @param data
	 */
	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(new Node(data));
	}

	/**
	 * ノードを特定の位置に挿入
	 * 
	 * @param index
	 * @param data
	 */
	public void insert(int index, int data) {
		if (index == 0) {
			Node newNode = new Node(data);
			newNode.setNext(head);
			head = newNode;
			return;
		}

		Node current = head;
		for (int i = 0; i < index - 1 && current != null; i++) {
			current = current.getNext();
		}

		if (current == null)
			return;
		Node newNode = new Node(data);
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}

	/**
	 * ノードを削除
	 * 
	 * @param data
	 */
	public void delete(int data) {
		if (head == null)
			return;
		if (head.getData() == data) {
			head = head.getNext();
			return;
		}

		Node current = head;
		while (current.getNext() != null && current.getNext().getData() != data) {
			current = current.getNext();
		}

		if (current.getNext() == null)
			return;
		current.setNext(current.getNext().getNext());
	}

	/**
	 * リンクドリストの表示
	 */
	public void display() {
		Node current = head;
		System.out.print("リンクドリスト: ");

		while (current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}

		System.out.println("null");
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListOperations list = new LinkedListOperations();
		list.append(1);
		list.append(3);
		list.append(5);
		list.display();

		list.insert(1, 2);
		list.display();

		list.delete(3);
		list.display();
	}
}
