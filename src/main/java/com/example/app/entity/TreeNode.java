package com.example.app.entity;

import lombok.Data;

/**
 * ツリーノード
 *
 * @since 2024/11/24
 * @author koji kawazu
 */
@Data
public class TreeNode {
	private int data;
	private TreeNode left, right;

	/**
	 * コンストラクタ
	 *
	 * @param data
	 */
	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}
