package com.example.app.utils.array;

import java.util.Arrays;

/**
 * 配列オペレーション
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class ArrayOperations {

	/**
	 * コンストラクタ
	 */
	public ArrayOperations() {

	}

	/**
	 * 配列操作 配列の基本操作（挿入、削除、検索、文字列の操作）を行うメインメソッド
	 */
	private void arrayOperations() {
		// 初期配列
		int[] array = { 1, 2, 3, 5 };
		System.out.println("初期配列: " + Arrays.toString(array));

		// 挿入（位置3に値4を挿入）
		array = insert(array, 3, 4);
		System.out.println("挿入後: " + Arrays.toString(array));

		// 削除（位置2の要素を削除）
		array = delete(array, 2);
		System.out.println("削除後: " + Arrays.toString(array));

		// 検索（値5の位置を検索）
		int index = search(array, 5);
		System.out.println("値5の位置: " + index);

		// 結合
		String str1 = "Hello";
		String str2 = "World";
		String concatenated = str1 + " " + str2;
		System.out.println("結合: " + concatenated);

		// 分割
		String csv = "apple,banana,cherry";
		String[] fruits = csv.split(",");
		System.out.println("分割: " + Arrays.toString(fruits));

		// 置換
		String original = "I love apples";
		String replaced = original.replace("apples", "oranges");
		System.out.println("置換: " + replaced);

		// パターンマッチング
		String text = "abc123xyz";
		boolean matches = text.matches(".*\\d+.*");
		System.out.println("パターンマッチング（数字を含むか）: " + matches);
	}

	/**
	 * 配列への挿入
	 * 
	 * @param array
	 * @param index
	 * @param value
	 * @return 新しい配列
	 */
	private int[] insert(int[] array, int index, int value) {
		int[] newArray = new int[array.length + 1];

		for (int i = 0; i < newArray.length; i++) {
			if (i < index) {
				newArray[i] = array[i];
			} else if (i == index) {
				newArray[i] = value;
			} else {
				newArray[i] = array[i - 1];
			}
		}
		return newArray;
	}

	/**
	 * 配列からの削除
	 * 
	 * @param array
	 * @param index
	 * @return 新しい配列
	 */
	private int[] delete(int[] array, int index) {
		int[] newArray = new int[array.length - 1];

		for (int i = 0; i < newArray.length; i++) {
			if (i < index) {
				newArray[i] = array[i];
			} else {
				newArray[i] = array[i + 1];
			}
		}
		return newArray;
	}

	/**
	 * 配列の要素
	 * 
	 * @param array
	 * @param value
	 * @return 見つかった位置、見つからなければ -1
	 */
	private int search(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i; // 見つかった場合は位置を返す
			}
		}
		return -1; // 見つからない場合は-1を返す
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayOperations array = new ArrayOperations();
		array.arrayOperations();
	}
}
