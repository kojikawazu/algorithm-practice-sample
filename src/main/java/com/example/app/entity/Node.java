package com.example.app.entity;

import lombok.Data;

/**
 * ノード
 * @since 2024/11/24
 * @author koji kawazu
 */
@Data
public class Node {
	private int data;
	private Node next;

	/**
	 * コンストラクタ
	 *
	 * @param data
	 */
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
