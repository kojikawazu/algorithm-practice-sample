package com.example.app.utils.search;

/**
 * リニアサーチ(線形探索)
 * 
 * @since 2024/11/24
 * @author koji kawazu
 */
public class LinearSearchExample {

	/**
	 * リニアサーチ(線形探索)
	 * 
	 * @param array
	 * @param key
	 * @return 結果
	 */
	public static int linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; // 見つかった場合のインデックスを返す
			}
		}
		return -1; // 見つからない場合
	}

	/**
	 * main関数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = { 5, 3, 8, 4, 2 };
		int key = 4;
		int index = linearSearch(data, key);
		if (index != -1) {
			System.out.println("値 " + key + " はインデックス " + index + " にあります。");
		} else {
			System.out.println("値 " + key + " は見つかりませんでした。");
		}
	}
}
